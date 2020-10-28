学习笔记
1.使用 GCLogAnalysis 测试结果：

GC	            512M	1024M	2048M	4096M
SerialGC	    14443	18456	17333	15572
ParallelGC	    13023	20263	23220	21463
ConcMarkSweepGC	14397	20392	16485	16333
G1GC	        16865	25792	25189	24394

结论分析
SerialGC 在小内存的场景下表现不错，ParallelGC 在多核表现优秀，G1GC 在大内存的场景下表现优异。CMS，已经被标记为过时了，有点类似于并发GC和G1GC的过渡。

2.G1 响应延时更低，Parallel 整体吞吐量更大，CMS 更像是 Parallel 这种注重吞吐量的垃圾收集器向 G1 这种注重低延迟的垃圾收集器的过渡，整体来讲 CMS 并没有太大的优势。