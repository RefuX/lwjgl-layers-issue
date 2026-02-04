Environment:
Currently has been created on a laptop with an integrated and discrete gpu.
```
Devices:
========
GPU0:
        apiVersion         = 1.4.325
        driverVersion      = 591.86.0.0
        vendorID           = 0x10de
        deviceID           = 0x28e1
        deviceType         = PHYSICAL_DEVICE_TYPE_DISCRETE_GPU
        deviceName         = NVIDIA GeForce RTX 4050 Laptop GPU
        driverID           = DRIVER_ID_NVIDIA_PROPRIETARY
        driverName         = NVIDIA
        driverInfo         = 591.86
        conformanceVersion = 1.4.3.0
        deviceUUID         = 1a67171d-33ed-21c8-fab3-ae508de6ed20
        driverUUID         = ab24b0bb-7bd9-59fc-a310-4c2bdaba9b72
GPU1:
        apiVersion         = 1.4.315
        driverVersion      = 2.0.353
        vendorID           = 0x1002
        deviceID           = 0x1681
        deviceType         = PHYSICAL_DEVICE_TYPE_INTEGRATED_GPU
        deviceName         = AMD Radeon(TM) Graphics
        driverID           = DRIVER_ID_AMD_PROPRIETARY
        driverName         = AMD proprietary driver
        driverInfo         = 26.1.1 (AMD proprietary shader compiler)
        conformanceVersion = 1.4.0.0
        deviceUUID         = 00000000-3500-0000-0000-000000000000
        driverUUID         = 414d442d-5749-4e2d-4452-560000000000
[Vulkan Loader] DEBUG | LAYER:  Unloading layer library C:\VulkanSDK\1.4.341.0\Bin\VkLayer_khronos_validation.dll
```

Steps to repoduce:
- Have the problematic environment ^^
- Use Vulkan Configuration to turn on a layer (for example Validation) for "Any Running Vulkan Executable"
- Run ```gradlew run```

Resulting hs_err:
```
Current thread (0x000002938807c6d0):  JavaThread "main"             [_thread_in_native, id=35020, stack(0x000000f300700000,0x000000f300800000) (1024K)]

Stack: [0x000000f300700000,0x000000f300800000],  sp=0x000000f3007fbe40,  free space=1007k
Native frames: (J=compiled Java code, j=interpreted, Vv=VM code, C=native code)
C  [msvcp140.dll+0x132a8]
C  [VkLayer_api_dump.dll+0x5ad424]

Java frames: (J=compiled Java code, j=interpreted, Vv=VM code)
j  org.lwjgl.system.JNI.callPPPI(JJJJ)I+0
j  org.lwjgl.vulkan.VK10.nvkCreateInstance(JJJ)I+24
j  org.lwjgl.vulkan.VK10.vkCreateInstance(Lorg/lwjgl/vulkan/VkInstanceCreateInfo;Lorg/lwjgl/vulkan/VkAllocationCallbacks;Lorg/lwjgl/PointerBuffer;)I+23
j  org.test.MainKt.main()V+51
j  org.test.MainKt.main([Ljava/lang/String;)V+0
v  ~StubRoutines::call_stub 0x0000029399b5100d

siginfo: EXCEPTION_ACCESS_VIOLATION (0xc0000005), reading address 0x0000000000000000
```
