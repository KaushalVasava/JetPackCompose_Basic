# JetPackCompose Basic

In this project, you will know how to open keyboard at screen start-up and get focus on TextField.

First know this,

➡ FocusRequester:
The FocusRequester is used in conjunction with Modifier.focusRequester to send requests to change focus.

➡ SoftwareKeyboardController:
SoftwareKeyboardController that can control the current software keyboard.

Steps:
1. Initialize FocusRequester and SoftwareKeyboardController
val keyboard = LocalSoftwareKeyboardController.current
val focusRequester = remember { FocusRequester() }

2. Call requestFocus() method to get focus and show the keyboard and put all this code inside LanchedEffect to run at once
LaunchedEffect(Unit) {
   focusRequester.requestFocus()
   keyboard?.show()
}
3. Add focusRequester modifier and pass focusRequester of the TextField
TextField(Modifier.focusRequester(focusRequester),..)

4. Add a keyboard Options as Done and Action to hide keyboard when    submit input.

keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
keyboardActions = KeyboardActions(
   onDone = {
   keyboard?.hide()
})

# Video
https://github.com/KaushalVasava/JetPackCompose_Basic/assets/49050597/97046668-2033-4c53-b374-da35b5ead465

# Author
Kaushal Vasava

