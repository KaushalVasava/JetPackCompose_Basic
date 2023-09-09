# JetPackCompose_Basic

In this project, we implement Drag-n-Drop functionality in Jetpack compose.

# Video
https://github.com/KaushalVasava/JetPackCompose_Basic/assets/49050597/10df632c-ebc6-44cf-9bca-b31df623ca6d

# Important topics are:
👉 GraphicsLayer :

Create a Modifier.Node called 'graphicsLayer' that allows content to be drawn into a separate draw layer. This layer can be invalidated independently from its parent, reducing unnecessary updates. Use a 'graphicsLayer' when content updates independently to minimize invalidations.
You can apply various effects like scaling, rotation, opacity, shadow, and clipping to the content within this layer. It's best suited for situations where layer properties are driven by 'androidx.compose.runtime.State' or animated values. Avoid reading state inside the block, as it only updates the layer properties without triggering recomposition and re-layout.

Parameters:
'block': A block within the `GraphicsLayerScope` where you can define layer properties.


👉 PointerInput:

Create a modifier for processing pointer input within the modified element's region. This modifier allows you to handle pointer input events using the 'pointerInputs' function. You can use the 'PointerInputScope.awaitPointerEventScope' function to set up a pointer input handler that can await and consume pointer events via 'AwaitPointerEventScope.awaitPointerEvent'.

Here's a simplified version of your description:
"When creating a pointerInput modifier through composition, if the 'block' function captures any local variables for processing, you can specify these variables as key parameters. This allows the 'block' to cancel and restart from the beginning if any of these key variables change. This behavior is useful for handling changes to variables while working with pointer input."

This simplification retains the essential information while removing some of the detailed technical terminology.

👉 onGloballyPositioned:

Call `onGloballyPositioned` with the `LayoutCoordinates` of the element when the global position of the content might have changed. This callback will be triggered at least once when the coordinates are finalized and whenever the element's position changes within the window. However, it's not guaranteed to trigger every time the element's position relative to the screen changes. For instance, if the system moves content within a window without triggering a callback, you might not receive updates when calculating the position on the entire screen, as opposed to just within the window.

Basic of drag are here:
[https://lnkd.in/dqjSypsM](https://developer.android.com/jetpack/compose/touch-input/pointer-input/drag-swipe-fling)

Follow me for more if you find it helpful and share it.
