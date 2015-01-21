/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

/// <reference path="DBB0320001.ts" />

module DBB {

    export class DBB0320001_Script {

        public static bindEvents() {
            
            
            Uz.GyomuJSHelper.registOriginalEvent("onAfterRequestByDblClick_dgFukaRirekiAll", (control: Uz._ViewControl) => {
                if (DBB0320001_Control.lblMode().text === "first") {
                    Uz.GyomuJSHelper.transitionEventFire("gotoKonkyoKiwari");
                }
            });

            Uz.GyomuJSHelper.registOriginalEvent("onAfterRequestBySelectButton_dgFukaRirekiAll", (control: Uz._ViewControl) => {
                if (DBB0320001_Control.lblMode().text === "first") {
                    Uz.GyomuJSHelper.transitionEventFire("gotoKonkyoKiwari");
                }
            });
     
        }

    }
}
// 実行時に呼び出すメソッドを記述
DBB.DBB0320001_Script.bindEvents();
