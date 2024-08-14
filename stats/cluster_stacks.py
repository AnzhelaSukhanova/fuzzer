from lerch import *


def cluster_reports(stacks: List[Stack], threshold: float = 0.5):
    accepted_stacks = []
    stack_to_cluster = {}
    cluster_to_frame = {}
    model = LerchModel()
    model.fit(stacks)
    i = 0
    for stack in stacks:
        # first stack
        if not accepted_stacks:
            i = len(stack_to_cluster)
            stack_to_cluster[stack] = i
            accepted_stacks.append(stack)
            continue
        # compute similarity scores with every stack in clusters
        scores = model.predict(stack, accepted_stacks)
        # find the closest stack
        top_score, top_stack = sorted(zip(scores, accepted_stacks), key=lambda x: x[0])[-1]
        if top_score > threshold:
            i = stack_to_cluster[top_stack]
            stack_to_cluster[stack] = i
        else:
            i = len(stack_to_cluster)
            stack_to_cluster[stack] = i

        cluster_to_frame[i] = stack.frames[1] #.split('(')[0]
        accepted_stacks.append(stack)

    return stack_to_cluster, cluster_to_frame


def find_threshold() -> int:
    def process_options(range: range) -> int:
        threshold = range.start
        unique_lines_number = 0
        for i in range:
            _, stack_lines = cluster_reports(stacks, i)
            cur_unique_lines_number = len(set(stack_lines.values()))
            repeating_lines_number = len(stack_lines.values()) - cur_unique_lines_number
            print(i, cur_unique_lines_number, unique_lines_number, repeating_lines_number)
            if cur_unique_lines_number >= unique_lines_number or repeating_lines_number >= max(unique_lines_number, 5):
                unique_lines_number = cur_unique_lines_number
                threshold = i
                # for j in set(stack_lines.values()):
                #     print(j)
            else:
                break
        return threshold

    threshold = 500
    for step in [-100, -10, -1]:
        threshold = process_options(range(threshold, 0, step))
    return threshold


if __name__ == "__main__":
    directory = "../core/tmp/results/curBugs/"
    stacks = []
    stack_to_filename = {}
    for filename in sorted(os.listdir(directory)):
        if filename.endswith(".kt"):
            with open(directory + filename, 'r') as file:
                stack = Stack()
                stack.frames = file.read().split("Combined output:", 1)[1].splitlines()
                # print(stack.frames[1])
                stack_to_filename[stack] = filename
                stacks.append(stack)
    threshold = find_threshold()
    print(threshold)
    clusters, _ = cluster_reports(stacks, threshold)
    processed = set()
    for key in clusters:
        value = clusters[key]
        if value in processed:
            continue
        files = sorted([stack_to_filename[k] for k, v in clusters.items() if v == value])
        number = len(files)
        #print(", ".join(files))
        print(value, ":", (files[0] if number == 1 else number), ":", key.frames[1])
        # with open(directory.split('/')[-2] + ".txt", "a+") as file:
        #     file.write(", ".join(files) + "\n")
        processed.add(value)
