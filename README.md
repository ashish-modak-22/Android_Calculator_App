# 🧮 Calculator App — Android (Kotlin)
 
A modern, fully functional calculator Android app built with Kotlin featuring a clean dark UI, rounded buttons, and full arithmetic support with BODMAS/PEMDAS precedence.
 
---

## 📸 App Preview
 
> Dark themed calculator with color-coded buttons — number buttons in dark gray, operators in orange, delete in red, and a large display area showing both the expression and result.
 
---

## ✨ Features
 
- ➕ Basic arithmetic — Addition, Subtraction, Multiplication, Division
- 📐 BODMAS/PEMDAS operator precedence
- 💯 Percentage calculation
- ➖ Toggle positive/negative sign
- ⌫ Backspace — delete last character
- 🔄 AC — clear everything instantly
- 🔢 Decimal number support
- ⚠️ Division by zero error handling
- 🌙 Always-on dark theme
- 🎨 Attractive UI with rounded, color-coded buttons
---
 
## 🛠️ Technologies Used
 
| Technology | Purpose |
|---|---|
| **Kotlin** | Primary programming language |
| **Android SDK** | Android app development framework |
| **AndroidX AppCompat** | Backward compatible UI components |
| **Material Design 3** | App theming (Dark theme base) |
| **XML Layouts** | UI design and structure |
| **Gradle (Kotlin DSL)** | Build system |
 
---
## 📚 Android Concepts Covered
 
| Concept | Description |
|---|---|
| **Activity & Lifecycle** | `AppCompatActivity`, `onCreate()` |
| **findViewById** | Connecting Kotlin code to XML views |
| **setOnClickListener** | Handling button tap events |
| **LinearLayoutCompat** | Arranging views vertically and horizontally |
| **layout_weight** | Distributing equal space among buttons |
| **AppCompatButton** | Flexible, theme-safe buttons |
| **Custom Drawables** | Rounded button backgrounds via XML shapes |
| **Styles & Themes** | Reusable button styles, dark app theme |
| **State Management** | Tracking input and result state with variables |
| **Exception Handling** | try-catch for division by zero and parse errors |
| **String Manipulation** | Building and parsing math expressions |
| **BODMAS Logic** | Manual implementation of operator precedence |
 
---

## 📁 Project Structure
 
```
CalculatorApp/
│
├── app/
│   ├── manifests/
│   │   └── AndroidManifest.xml          # App config, entry point
│   │
│   ├── kotlin+java/
│   │   └── com.example.calculator/
│   │       └── MainActivity.kt          # All calculator logic
│   │
│   └── res/
│       ├── drawable/
│       │   ├── btn_rounded_number.xml   # Dark gray rounded button background
│       │   ├── btn_rounded_operator.xml # Orange rounded button background
│       │   ├── btn_rounded_action.xml   # Medium gray rounded button background
│       │   ├── btn_rounded_equal.xml    # Orange equal button background
│       │   └── btn_rounded_delete.xml  # Red delete button background
│       │
│       ├── layout/
│       │   └── activity_main.xml        # Calculator UI layout
│       │
│       └── values/
│           ├── colors.xml               # All color definitions
│           ├── styles.xml               # Reusable button styles
│           └── themes.xml               # Dark app theme
│
├── build.gradle.kts                     # App level build config
└── gradle.properties                    # Gradle settings
```
 
---

 ## 🎨 UI Design
 
 ### Color Palette
 
| Element | Color | Hex |
|---|---|---|
| Background | Deep Dark | `#1C1C1E` |
| Number Buttons | Dark Gray | `#2C2C2E` |
| Operator Buttons | Orange | `#FF9F0A` |
| Action Buttons | Medium Gray | `#3A3A3C` |
| Delete Button | Red | `#FF453A` |
| Display Text | White | `#FFFFFF` |
| Expression Text | Gray | `#8E8E93` |

---
 ### Button Layout
```
┌─────────────────────────────┐
│  Expression (small, gray)   │
│  Result    (large, white)   │
├──────┬──────┬──────┬────────┤
│  AC  │  ⌫  │  %   │   ÷   │
├──────┼──────┼──────┼────────┤
│  7   │  8   │  9   │   ×   │
├──────┼──────┼──────┼────────┤
│  4   │  5   │  6   │   −   │
├──────┼──────┼──────┼────────┤
│  1   │  2   │  3   │   +   │
├──────┼──────┼──────┼────────┤
│ +/-  │  0   │  .   │   =   │
└──────┴──────┴──────┴────────┘
```
 
---

 
## ⚙️ Requirements
 
| Requirement | Version |
|---|---|
| **Android Studio** | Hedgehog or later |
| **Minimum SDK** | API 24 (Android 7.0 Nougat) |
| **Target SDK** | API 36 |
| **Kotlin** | 1.9+ |
| **Gradle** | 8.0+ |
| **Java** | JDK 17 |
 
---
 
## 🚀 Getting Started
 
### 1. Clone the Repository
 
```bash
git clone https://github.com/ashish-modak-22/Android_Calculator_App.git
```

---

### 2. Open in Android Studio
- Open **Android Studio**
- Click **File → Open**
- Navigate to the cloned folder and select it
- Wait for Gradle sync to complete
### 3. Run the App
- Connect an Android device or start an emulator
- Click the ▶️ **Run** button
- Select your device and click **OK**
---
