package org.sam.blog.java.java5;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


@State(Scope.Thread) // 每個執行緒都獨立，確保數據隔離，以免出現數據共享問題
@OutputTimeUnit(TimeUnit.NANOSECONDS) // 基準測試結果的時間單位為「奈秒」
@BenchmarkMode(Mode.AverageTime) // 基準測試的模式為「平均時間」
@Warmup(iterations = 3, time = 1) // 預熱階段，這裡進行3次預熱，每次1秒
@Measurement(iterations = 5, time = 3) // 開始真正的測量，重複5次，每次3秒
public class StreamVsLoopBenchmark {

    private List<Integer> numbers;

    @Setup // 測試前的初始化動作
    public void setup() {
        numbers = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
            numbers.add(i);
        }
    }

    @Benchmark // 標註應該執行基準測試的方法
    public int sumUsingStream() {
        return numbers.stream().reduce(0, Integer::sum);
    }

    @Benchmark // 標註應該執行基準測試的方法
    public int sumUsingLoop() {
        int sum = 0;
        for (int n : numbers) {
            sum += n;
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        Options opt = new OptionsBuilder()
                // 將結果匯出成 json 檔(將結果變成圖性化時用得到)
                .resultFormat(ResultFormatType.JSON)
                // 執行緒數量(這邊為單執行緒)
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}