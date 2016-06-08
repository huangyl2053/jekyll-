var DBB;
(function (DBB) {
    var DBB0320001_Script = (function () {
        function DBB0320001_Script() {
        }
        DBB0320001_Script.bindEvents = function () {
            Uz.GyomuJSHelper.registOriginalEvent("onAfterRequestByDblClick_dgFukaRirekiAll", function (control) {
                if (DBB.DBB0320001_Control.lblMode().text === "first") {
                    Uz.GyomuJSHelper.transitionEventFire("gotoKonkyoKiwari");
                }
            });

            Uz.GyomuJSHelper.registOriginalEvent("onAfterRequestBySelectButton_dgFukaRirekiAll", function (control) {
                if (DBB.DBB0320001_Control.lblMode().text === "first") {
                    Uz.GyomuJSHelper.transitionEventFire("gotoKonkyoKiwari");
                }
            });
        };
        return DBB0320001_Script;
    })();
    DBB.DBB0320001_Script = DBB0320001_Script;
})(DBB || (DBB = {}));

DBB.DBB0320001_Script.bindEvents();
