import os
from collections import Counter
from typing import List, Dict, Tuple

import numpy as np


class Stack:
    def __init__(self):
        self.frames: List[str] = [
            "fun3",
            "fun2",
            "fun1",
            "main"
        ]


class TfIdfComputer:
    def __init__(self):
        self.word2idx = {}
        self.doc_freq = []
        self.N = None

    def fit(self, stacks: List[Stack]) -> 'TfIdfComputer':
        if self.N is not None:
            print("TfIdf model already fitted (skipped)")
            return self
        self.N = len(stacks)
        for stack in stacks:
            for word in set(stack.frames):
                if word not in self.word2idx:
                    self.word2idx[word] = len(self.word2idx)
                    self.doc_freq.append(0)
                self.doc_freq[self.word2idx[word]] += 1
        for i, v in enumerate(self.doc_freq):
            self.doc_freq[i] = 1 + np.log(self.N / v)  # v + 1
        return self

    def idf(self, frame: str, default: float = 0.):
        if frame not in self.word2idx:
            return default
        return self.doc_freq[self.word2idx[frame]]

    def transform(self, stack: Stack) -> Dict[str, Tuple[float, float]]:
        vec = {}
        words_freqs = Counter(stack.frames)
        for word, freq in words_freqs.items():
            if word not in self.word2idx:
                idf = np.log(self.N)
            else:
                idf = self.doc_freq[self.word2idx[word]]
            tf = np.sqrt(words_freqs[word])
            vec[word] = tf, idf
        return vec


class LerchModel:
    def __init__(self):
        self.tfidf = TfIdfComputer()

    def fit(self, unsupervised_data: List[Stack]) -> 'LerchModel':
        self.tfidf.fit(unsupervised_data)
        return self

    def predict(self, anchor: Stack, stacks: List[Stack]) -> List[float]:
        anchor_tfidf = self.tfidf.transform(anchor)

        max_score = 1
        scores = []
        for stack in stacks:
            score = 0
            for word in set(stack.frames):
                if word not in anchor_tfidf:
                    continue
                tf, idf = anchor_tfidf[word]
                tf_idf_pow2 = tf * idf ** 2
                score += tf_idf_pow2

            denom = 1
            scores.append(score / max_score / denom)

        return scores
