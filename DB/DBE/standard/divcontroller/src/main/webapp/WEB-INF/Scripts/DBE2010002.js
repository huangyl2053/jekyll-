/// <reference path="jquery.d.ts" />
/// <reference path="UzViewControls.d.ts" />
var DBE;
(function (DBE) {
    var DBE2010002 = (function () {
        function DBE2010002() {
        }
        DBE2010002.setCode = //        private static btnToEntryChosaIrai: Uz._Button = <Uz._Button>Uz.GyomuJSHelper.getJSControl('btnToEntryChosaIrai');
        //        private static btnToComplete: Uz._Button = <Uz._Button>Uz.GyomuJSHelper.getJSControl('btnToComplete');
        //        private static btnToPublishIraisho: Uz._Button = <Uz._Button>Uz.GyomuJSHelper.getJSControl('btnToPublishIraisho');
        function () {
            DBE2010002.init();
            DBE2010002.deployEvents();
        };

        DBE2010002.init = function () {
            alert("ver.3.1.0");
            DBE2010002.divideWaritsukeOrMiwaritsuke();
        };

        DBE2010002.deployEvents = function () {
            Uz.GyomuJSHelper.registOriginalEvent("onClick_btnToBind", function (control) {
                DBE2010002._onClick_btnToBind();
                DBE2010002.divideWaritsukeOrMiwaritsuke();
            });
            Uz.GyomuJSHelper.registOriginalEvent("onClick_btnToFree", function (control) {
                DBE2010002._onClick_btnToFree();
                DBE2010002.divideWaritsukeOrMiwaritsuke();
            });
        };

        DBE2010002._onClick_btnToBind = /**
        * 割付完了化処理です。
        */
        function () {
            var selectedItem = DBE2010002.extractSelectedItem(DBE2010002.comMiwaritsukeList.dataSource);
            if (selectedItem === null) {
            } else {
                var index = DBE2010002.getIndexOfHihokensha(selectedItem.hihokenshaNo);
                DBE2010002.setChosaIrai(index, DBE2010002.txtChosaIraiDate.value, DBE2010002.txtChosaKigenDate.value, "1：初回");
            }
        };

        DBE2010002._onClick_btnToFree = /**
        * 未割付化処理です。
        */
        function () {
            var selectedItem = DBE2010002.extractSelectedItem(DBE2010002.comWaritukezumiList.dataSource);
            if (selectedItem === null) {
            } else {
                var index = DBE2010002.getIndexOfHihokensha(selectedItem.hihokenshaNo);
                DBE2010002.unsetChosaIrai(index);
            }
        };

        DBE2010002.setChosaIrai = function (index, iraiDateValue, kigenDateValue, chosaIraiKubun) {
            DBE2010002._setChosaIrai(index, iraiDateValue, kigenDateValue, chosaIraiKubun);
        };

        DBE2010002.unsetChosaIrai = function (index) {
            DBE2010002._setChosaIrai(index, "", "", "");
        };

        DBE2010002._setChosaIrai = function (index, iraiDateValue, kigenDateValue, chosaIraiKubun) {
            var items = DBE2010002.comNinteichosaIraiListGod.dataSource;
            var def = items[index];
            def.chosaIraiDate.value = iraiDateValue;
            def.chosaKigenDate.value = kigenDateValue;
            def.chosaIraiKubun = chosaIraiKubun;
            items[index] = def;
            DBE2010002.comNinteichosaIraiListGod.dataSource = items;
        };

        DBE2010002.extractSelectedItem = function (chosaIraiItems) {
            for (var i = 0; i < chosaIraiItems.length; i++) {
                if (chosaIraiItems[i].selected) {
                    return chosaIraiItems[i];
                }
            }
            return null;
        };

        DBE2010002.getIndexOfHihokensha = /**
        * 被保険者番号の値から、comNinteichosaIraiListGodのindexを取得します。
        */
        function (_hihokenshaNo) {
            var chosaIraiItems = DBE2010002.comNinteichosaIraiListGod.dataSource;
            for (var i = 0; i < chosaIraiItems.length; i++) {
                if (chosaIraiItems[i].hihokenshaNo === _hihokenshaNo) {
                    return i;
                }
            }
        };

        DBE2010002.divideWaritsukeOrMiwaritsuke = /**
        * 非表示の全対象者を持ったDataGridのRowそれぞれについて、
        * 割付済みか未割付かを判定して、それぞれ専用のDataGridへ振り分けます。
        */
        function () {
            var chosaIraiItems = DBE2010002.comNinteichosaIraiListGod.dataSource;

            var waritsuke = [];
            var miwaritsuke = [];

            function isMiwariate(item) {
                function isEmpty(str) {
                    return str === "";
                }
                ;
                return isEmpty(item.chosaIraiDate.value) || isEmpty(item.chosaIraiKubun) || isEmpty(item.chosaKigenDate.value);
            }

            for (var i = 0; i < chosaIraiItems.length; i++) {
                if (isMiwariate(chosaIraiItems[i])) {
                    miwaritsuke.push(chosaIraiItems[i]);
                } else {
                    waritsuke.push(chosaIraiItems[i]);
                }
            }

            DBE2010002.comMiwaritsukeList.dataSource = miwaritsuke;
            DBE2010002.comWaritukezumiList.dataSource = waritsuke;
        };
        DBE2010002.comNinteichosaIraiListGod = Uz.GyomuJSHelper.getJSControl('comNinteichosaIraiListGod_dgNinteichosaIraiListForByHand');
        DBE2010002.comWaritukezumiList = Uz.GyomuJSHelper.getJSControl('comWaritukezumiList_dgNinteichosaIraiListForByHand');
        DBE2010002.comMiwaritsukeList = Uz.GyomuJSHelper.getJSControl('comMiwarituskeList_dgNinteichosaIraiListForByHand');
        DBE2010002.txtChosaIraiDate = Uz.GyomuJSHelper.getJSControl('txtChosaIraiDate');
        DBE2010002.txtChosaKigenDate = Uz.GyomuJSHelper.getJSControl('txtChosaKigenDate');
        DBE2010002.ddIraiKubun = Uz.GyomuJSHelper.getJSControl('ddIraiKubun');
        return DBE2010002;
    })();
    DBE.DBE2010002 = DBE2010002;
})(DBE || (DBE = {}));

DBE.DBE2010002.setCode();
//@ sourceMappingURL=DBE2010002.js.map
