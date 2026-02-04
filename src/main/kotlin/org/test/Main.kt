package org.test

import org.lwjgl.vulkan.VK10.VK_STRUCTURE_TYPE_INSTANCE_CREATE_INFO
import org.lwjgl.vulkan.VkInstanceCreateInfo
import org.lwjgl.system.MemoryStack
import org.lwjgl.vulkan.VK10.vkCreateInstance

fun main() {
    MemoryStack.stackPush().use { stack ->
        val createInfo =
            VkInstanceCreateInfo
                .calloc(stack)
                .sType(VK_STRUCTURE_TYPE_INSTANCE_CREATE_INFO)

        val pInstance = stack.callocPointer(1)
        vkCreateInstance(createInfo, null, pInstance)
            .vkCheck("Failed to create Vulkan instance")

    }
}
