## Fix
- Update to the latest version of the JVM you're using.
- Cause:
  - [It's a bug related to ⁨msvcp140.dll⁩ and ABI changes related to mutexes](https://stackoverflow.com/questions/78598141/first-stdmutexlock-crashes-in-application-built-with-latest-visual-studio)
  
## Steps to reproduce
- Have the problematic environment (JVM with problematic versions of msvcp140.dll)
- Use Vulkan Configuration application to configure "Vulkan Layers Configuration Scope" turn on a layer (for example, Validation) for "Any Running Vulkan Executable"
- Run ```gradlew run```

Or, alternatively:
- Have the problematic environment (JVM with problematic versions of msvcp140.dll)
- Run ```gradlew runDump```

### Resulting hs_err
```
Current thread (0x000002938807c6d0):  JavaThread "main"             [_thread_in_native, id=35020, stack(0x000000f300700000,0x000000f300800000) (1024K)]

Stack: [0x000000f300700000,0x000000f300800000],  sp=0x000000f3007fbe40,  free space=1007k
Native frames: (J=compiled Java code, j=interpreted, Vv=VM code, C=native code)
C  [msvcp140.dll+0x132a8]
C  [VkLayer_khronos_validation.dll+0x810a0c]

Java frames: (J=compiled Java code, j=interpreted, Vv=VM code)
j  org.lwjgl.system.JNI.callPPPI(JJJJ)I+0
j  org.lwjgl.vulkan.VK10.nvkCreateInstance(JJJ)I+24
j  org.lwjgl.vulkan.VK10.vkCreateInstance(Lorg/lwjgl/vulkan/VkInstanceCreateInfo;Lorg/lwjgl/vulkan/VkAllocationCallbacks;Lorg/lwjgl/PointerBuffer;)I+23
j  org.test.MainKt.main()V+51
j  org.test.MainKt.main([Ljava/lang/String;)V+0
v  ~StubRoutines::call_stub 0x0000029399b5100d

siginfo: EXCEPTION_ACCESS_VIOLATION (0xc0000005), reading address 0x0000000000000000
```
