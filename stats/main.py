import matplotlib.pyplot as plt
from datetime import datetime, timedelta

colors = ['g', 'r', 'y', 'b', 'c']
date_format = '%Y-%m-%d %H:%M:%S'
main_dir = "../core/"


def get_date(line: str) -> datetime:
    date_str = line.split(",")[0]
    return datetime.strptime(date_str, date_format)


def to_float(time_delta: timedelta) -> float:
    return time_delta.total_seconds()/3600


def bugs_to_time():
    for i, log_dir in enumerate(["logs/"]):
        bug_name_list = list()
        number_list = list()
        time_list = list()
        bug_number = 0

        file = open(main_dir + log_dir + "bugManager.log", "r")
        start_date = get_date(file.readline())
        total_time = 0

        for line in file:
            if line.find("to ") >= 0:
                bug_name = line.split("to ")[1].strip()
                bug_date = get_date(line)
                if len(bug_name_list) == 0 or bug_name_list[-1] != bug_name:
                    time_h = to_float(bug_date - start_date)
                    bug_number += 1
                    number_list.append(bug_number)
                    time_list.append(time_h)
                    bug_name_list.append(bug_name)
                    total_time = time_h

        print(total_time)
        print(bug_number)
        plt.plot(time_list, number_list, color=colors[i])

    plt.grid()
    plt.xlabel("Time, h")
    plt.ylabel("Bugs number")
    plt.savefig('bug_stats.png')


def compilations_to_time():
    for i, log_dir in enumerate(["logs/"]):
        number_list = list()
        time_list = list()

        file = open(main_dir + log_dir + "coordinator.log", "r")
        start_date = get_date(file.readline())
        total_number = 0

        for line in file:
            if line.find("projects to compiler") >= 0:
                projects_number = line.split(" ")[5].strip()
                total_number += int(projects_number)
                cur_date = get_date(line)
                time_h = to_float(cur_date - start_date)
                # if time_h > 60:
                #     break
                number_list.append(total_number)
                time_list.append(time_h)
        plt.plot(time_list, number_list, color=colors[i])

    plt.grid()
    plt.xlabel("Time, h")
    plt.ylabel("Compilation number")
    plt.savefig('compiler_stats.png')


if __name__ == "__main__":
    #bugs_to_time()
    compilations_to_time()
