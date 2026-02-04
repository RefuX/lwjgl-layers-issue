package org.test

import org.lwjgl.system.MemoryStack
import org.lwjgl.vulkan.VK10.VK_STRUCTURE_TYPE_INSTANCE_CREATE_INFO
import org.lwjgl.vulkan.VK10.vkCreateInstance
import org.lwjgl.vulkan.VkInstanceCreateInfo
import kotlin.use

fun main() {
	MemoryStack.stackPush().use { stack ->
		val layers = stack.callocPointer(1)
		layers.put(0, stack.ASCII("VK_LAYER_LUNARG_api_dump"))

		val createInfo =
			VkInstanceCreateInfo
				.calloc(stack)
				.sType(VK_STRUCTURE_TYPE_INSTANCE_CREATE_INFO)
				.ppEnabledLayerNames(layers)

		val pInstance = stack.callocPointer(1)
		vkCreateInstance(createInfo, null, pInstance)
			.vkCheck("Failed to create Vulkan instance")

	}
}
