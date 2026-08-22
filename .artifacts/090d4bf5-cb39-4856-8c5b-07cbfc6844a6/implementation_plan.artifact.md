# Implement Blue & White Color Scheme

Update the application's visual theme to a coordinated palette of blues and off-whites, replacing the current purple-toned hardcoded colors.

## Proposed Changes

### [Component] Resources

#### [MODIFY] [colors.xml](file:///C:/Users/Rain/Downloads/Application,%20Development%20and%20Emerging%20Technology/MACToDoList/app/mactodolist/src/main/res/values/colors.xml)
- Define `dark_blue` (#004586), `primary_blue` (#1976D2), `light_blue` (#BBDEFB), and `dirty_white` (#F5F5F5).

#### [MODIFY] [themes.xml](file:///C:/Users/Rain/Downloads/Application,%20Development%20and%20Emerging%20Technology/MACToDoList/app/mactodolist/src/main/res/values/themes.xml)
- Update Material3 theme to use the new color palette for primary and surface colors.

### [Component] UI Layouts

#### [MODIFY] [activity_main.xml](file:///C:/Users/Rain/Downloads/Application,%20Development%20and%20Emerging%20Technology/MACToDoList/app/mactodolist/src/main/res/layout/activity_main.xml)
- Update background to `dirty_white`.
- Set title and button colors to `dark_blue`.

#### [MODIFY] [activity_add_edit_task.xml](file:///C:/Users/Rain/Downloads/Application,%20Development%20and%20Emerging%20Technology/MACToDoList/app/mactodolist/src/main/res/layout/activity_add_edit_task.xml)
- Update background to `dirty_white`.
- Set labels and "Save" button to `dark_blue`.
- Set "Cancel" button to `primary_blue`.

#### [MODIFY] [item_task.xml](file:///C:/Users/Rain/Downloads/Application,%20Development%20and%20Emerging%20Technology/MACToDoList/app/mactodolist/src/main/res/layout/item_task.xml)
- Update card background to `light_blue`.
- Set task title to `dark_blue`.
- Set action buttons to `dark_blue`.

## Verification Plan

### Automated Tests
- Run `./gradlew :app:mactodolist:assembleDebug` to ensure no resource errors were introduced.

### Manual Verification
- Deploy the app and verify the new color scheme visually matches the requested "Blue, Light Blue, Dirty White, Dark Blue" mix.
