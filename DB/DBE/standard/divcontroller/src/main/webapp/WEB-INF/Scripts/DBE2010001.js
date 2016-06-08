/// <reference path="jquery.d.ts" />
/// <reference path="UzViewControls.d.ts" />
var DBE;
(function (DBE) {
    var DBE2010001 = (function () {
        function DBE2010001() {
        }
        DBE2010001.setCoding = function () {
            DBE2010001.init();
            DBE2010001.deployEvents();
        };

        DBE2010001.init = function () {
            // alert("ver.2.1");
            DBE2010001.changeStateOfBtnToComplete();
        };

        DBE2010001.deployEvents = function () {
            Uz.GyomuJSHelper.registOriginalEvent("changeStateOfBtnToComplete", function (control) {
                DBE2010001.changeStateOfBtnToComplete();
            });
        };

        DBE2010001.countOfSelectedItems = function () {
            var count = 0;
            var selectedItems = DBE2010001.dgNinteichosaIraiList.dataSource;
            for (var i = 0; i < selectedItems.length; i++) {
                if (selectedItems[i].selected === true) {
                    count++;
                }
            }
            return count;
        };

        DBE2010001.changeStateOfBtnToComplete = function () {
            DBE2010001.btnToComplete.disabled = DBE2010001.judgeStateOfBtnToComplete();
        };

        DBE2010001.judgeStateOfBtnToComplete = function () {
            var items = DBE2010001.dgNinteichosaIraiList.dataSource;
            if (items.length === 0) {
                return true;
            }
            for (var i = 0; i < items.length; i++) {
                if (items[i].selected === true) {
                    if ((items[i].依頼登録済 === false) || (items[i].依頼書発行済 === false)) {
                        return true;
                    }
                }
            }
            return false;
        };
        DBE2010001.dgNinteichosaIraiList = Uz.GyomuJSHelper.getJSControl('dgNinteichosaIraiList');
        DBE2010001.btnToEntryChosaIrai = Uz.GyomuJSHelper.getJSControl('btnToEntryChosaIrai');
        DBE2010001.btnToComplete = Uz.GyomuJSHelper.getJSControl('btnToComplete');
        DBE2010001.btnToPublishIraisho = Uz.GyomuJSHelper.getJSControl('btnToPublishIraisho');
        return DBE2010001;
    })();
    DBE.DBE2010001 = DBE2010001;
})(DBE || (DBE = {}));

DBE.DBE2010001.setCoding();
//@ sourceMappingURL=DBE2010001.js.map
