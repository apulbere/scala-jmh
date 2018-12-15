

### How to run
* 10 iterations
* 10 warmup iterations
* 1 fork
* 1 thread

`./sbtx clean`

`./sbtx jmh:run -i 10 -wi 10 -f1 -t1`

### Result
| | GraalVM EE | GraalVM CE | OpenJDK 8 |
| --- | --- | --- | --- |
| Mode | `thrpt` | `thrpt` | `thrpt` |
| Cnt | `25` | `25` | `25` |
| Score | `91.411` | `26.741` | `45.216` |
| Error | `4.355` | `0.408` | `1.956` |
| Units | `ops/ms` | `ops/ms` | `ops/ms` |

### Detailed result
#### GraalVM Enterprise Edition
`export PATH=~/apps/graalvm-ee-1.0.0-rc10/Contents/Home/bin/:$PATH`

```
[info] # JMH version: 1.21
[info] # VM version: JDK 1.8.0_192, GraalVM 1.0.0-rc10, 25.192-b12-jvmci-0.53
[info] # *** WARNING: JMH support for this VM is experimental. Be extra careful with the produced data.
[info] # VM invoker: ~/apps/graalvm-ee-1.0.0-rc10/Contents/Home/jre/bin/java
[info] # VM options: <none>
[info] # Warmup: 5 iterations, 10 s each
[info] # Measurement: 5 iterations, 10 s each
[info] # Timeout: 10 min per iteration
[info] # Threads: 1 thread, will synchronize iterations
[info] # Benchmark mode: Throughput, ops/time
[info] # Benchmark: jmh.main.LongestCommonSubsequence.longestCommonSubsequenceDP
[info] # Run progress: 0.00% complete, ETA 00:08:20
...
[info] Result "jmh.main.LongestCommonSubsequence.longestCommonSubsequenceDP":
[info]   91.411 ±(99.9%) 4.355 ops/ms [Average]
[info]   (min, avg, max) = (80.435, 91.411, 100.221), stdev = 5.814
[info]   CI (99.9%): [87.056, 95.767] (assumes normal distribution)
[info] # Run complete. Total time: 00:08:22
[info] Benchmark                                             Mode  Cnt   Score   Error   Units
[info] LongestCommonSubsequence.longestCommonSubsequenceDP  thrpt   25  91.411 ± 4.355  ops/ms
```

#### GraalVM Community Edition
`export PATH=~/apps/graalvm-ce-1.0.0-rc10/Contents/Home/bin/:$PATH`

```
[info] # JMH version: 1.21
[info] # VM version: JDK 1.8.0_192, GraalVM 1.0.0-rc10, 25.192-b12-jvmci-0.53
[info] # *** WARNING: JMH support for this VM is experimental. Be extra careful with the produced data.
[info] # VM invoker: ~/apps/graalvm-ce-1.0.0-rc10/Contents/Home/jre/bin/java
[info] # VM options: <none>
[info] # Warmup: 5 iterations, 10 s each
[info] # Measurement: 5 iterations, 10 s each
[info] # Timeout: 10 min per iteration
[info] # Threads: 1 thread, will synchronize iterations
[info] # Benchmark mode: Throughput, ops/time
[info] # Benchmark: jmh.main.LongestCommonSubsequence.longestCommonSubsequenceDP
[info] # Run progress: 0.00% complete, ETA 00:08:20
...
[info] Result "jmh.main.LongestCommonSubsequence.longestCommonSubsequenceDP":
[info]   26.741 ±(99.9%) 0.408 ops/ms [Average]
[info]   (min, avg, max) = (25.307, 26.741, 27.516), stdev = 0.544
[info]   CI (99.9%): [26.334, 27.149] (assumes normal distribution)
[info] # Run complete. Total time: 00:08:21
[info] Benchmark                                             Mode  Cnt   Score   Error   Units
[info] LongestCommonSubsequence.longestCommonSubsequenceDP  thrpt   25  26.741 ± 0.408  ops/ms


```

#### OpenJDK 8
``export JAVA_HOME=`/usr/libexec/java_home -v 1.8``

```
[info] # JMH version: 1.21
[info] # VM version: JDK 1.8.0_192, OpenJDK 64-Bit Server VM, 25.192-b12
[info] # VM invoker: /Library/Java/JavaVirtualMachines/jdk8u192-b12/Contents/Home/jre/bin/java
[info] # VM options: <none>
[info] # Warmup: 5 iterations, 10 s each
[info] # Measurement: 5 iterations, 10 s each
[info] # Timeout: 10 min per iteration
[info] # Threads: 1 thread, will synchronize iterations
[info] # Benchmark mode: Throughput, ops/time
[info] # Benchmark: jmh.main.LongestCommonSubsequence.longestCommonSubsequenceDP
[info] # Run progress: 0.00% complete, ETA 00:08:20
...
[info] Result "jmh.main.LongestCommonSubsequence.longestCommonSubsequenceDP":
[info]   45.216 ±(99.9%) 1.956 ops/ms [Average]
[info]   (min, avg, max) = (40.054, 45.216, 49.033), stdev = 2.611
[info]   CI (99.9%): [43.260, 47.171] (assumes normal distribution)
[info] # Run complete. Total time: 00:08:21
[info] Benchmark                                             Mode  Cnt   Score   Error   Units
[info] LongestCommonSubsequence.longestCommonSubsequenceDP  thrpt   25  45.216 ± 1.956  ops/ms
```


#### Acknowledgments
LCS implementation was taken from [algorithms-in-scala](https://github.com/jianwu-github/algorithms-in-scala)