/// <reference path="jquery.d.ts" />
/// <reference path="UzViewControls.d.ts" />
var DBE;
(function (DBE) {
    var DBE2060001 = (function () {
        function DBE2060001() {
        }
        DBE2060001.setSampleCoding = function () {
            DBE2060001.init();
            DBE2060001.deployEvents();
        };

        DBE2060001.init = function () {
            DBE2060001.editingIndex = 0;
            DBE2060001.init_chosaItems();
            DBE2060001.select(0);
        };

        DBE2060001.init_chosaItems = function () {
            DBE2060001._concatJSControlsToChosaItems((Uz.GyomuJSHelper.getJSControl('Kihonchosa0911')).items);
            DBE2060001._concatJSControlsToChosaItems((Uz.GyomuJSHelper.getJSControl('Kihonchosa0912')).items);
            DBE2060001._concatJSControlsToChosaItems((Uz.GyomuJSHelper.getJSControl('Kihonchosa0921')).items);
            DBE2060001._concatJSControlsToChosaItems((Uz.GyomuJSHelper.getJSControl('Kihonchosa0931')).items);
            DBE2060001._concatJSControlsToChosaItems((Uz.GyomuJSHelper.getJSControl('Kihonchosa0941')).items);
            DBE2060001._concatJSControlsToChosaItems((Uz.GyomuJSHelper.getJSControl('Kihonchosa0942')).items);
            DBE2060001._concatJSControlsToChosaItems((Uz.GyomuJSHelper.getJSControl('Kihonchosa0951')).items);
            DBE2060001._concatJSControlsToChosaItems((Uz.GyomuJSHelper.getJSControl('Kihonchosa0961')).items);
            DBE2060001._concatJSControlsToChosaItems((Uz.GyomuJSHelper.getJSControl('Kihonchosa0971')).items);
            for (var i = 0; i < DBE2060001.chosaItems.length; i++) {
                DBE2060001.textBoxForAnswerOf(DBE2060001.chosaItems[i]).onFocus = "onFocus_txtAnswer";
                DBE2060001.textBoxForAnswerOf(DBE2060001.chosaItems[i]).onChange = "onChange_txtAnswer";
            }
        };

        DBE2060001._concatJSControlsToChosaItems = function (viewControls) {
            DBE2060001.chosaItems = DBE2060001.chosaItems.concat(viewControls);
        };

        DBE2060001.alertHellowWorld = function () {
            if (!Uz.GyomuJSHelper.isDesignMode()) {
                alert("HelloWorld");
            }
        };
        DBE2060001.deployEvents = function () {
            Uz.GyomuJSHelper.registOriginalEvent("onClick_btnToEditTokkijiko", function (control) {
                var panel = Uz.GyomuJSHelper.getJSControl('KihonchosaResultGuidance');
                panel.title = "test";
                alert("" + DBE2060001.chosaItems.length);
            });

            Uz.GyomuJSHelper.registOriginalEvent("onClick_btnSelectNext", function (control) {
                DBE2060001.next();
            });

            Uz.GyomuJSHelper.registOriginalEvent("onClick_btnSelectPrevious", function (control) {
                DBE2060001.previous();
            });

            Uz.GyomuJSHelper.registOriginalEvent("onChange_radChoices", function (control) {
                var selectedKeyValue = DBE2060001.choices.selectedItem;
                DBE2060001.textBoxForAnswerOf(DBE2060001.currentItem).value = selectedKeyValue;
                DBE2060001.textBoxForAnswerOf(DBE2060001.currentItem).text = selectedKeyValue;
            });

            Uz.GyomuJSHelper.registOriginalEvent("onChange_radChoices", function (control) {
                var selectedKeyValue = DBE2060001.choices.selectedItem;
                DBE2060001.textBoxForAnswerOf(DBE2060001.currentItem).value = selectedKeyValue;
                DBE2060001.textBoxForAnswerOf(DBE2060001.currentItem).text = selectedKeyValue;
            });

            Uz.GyomuJSHelper.registOriginalEvent("onFocus_txtAnswer", function (control) {
                var parentFieldName = control.fieldName.replace("_txtAnswer", "");
                var currentItem = Uz.GyomuJSHelper.getJSControl(parentFieldName);
                DBE2060001.setUpGuaidance(currentItem);
                DBE2060001.select(DBE2060001._getArrayIndexOf(currentItem));
            });

            Uz.GyomuJSHelper.registOriginalEvent("onChange_txtAnswer", function (control) {
                DBE2060001.choices.selectedItem = (control).text;
            });
        };

        DBE2060001._getArrayIndexOf = function (chosaItem) {
            for (var index = 0; index < DBE2060001.chosaItems.length; index++) {
                if (DBE2060001.chosaItems[index] === chosaItem) {
                    return index;
                }
            }
            return 0;
        };

        DBE2060001.next = function () {
            var index = DBE2060001.editingIndex;
            if (index < DBE2060001.chosaItems.length) {
                DBE2060001.select(index + 1);
            }
        };

        DBE2060001.previous = function () {
            var index = DBE2060001.editingIndex;
            if (0 < index) {
                DBE2060001.select(index - 1);
            }
        };

        DBE2060001.select = function (index) {
            DBE2060001.editingIndex = index;
            var targetItem = DBE2060001.chosaItems[index];
            DBE2060001.setUpGuaidance(targetItem);

            DBE2060001._showOrHideButtons(index);
            DBE2060001._moveCursorTo(targetItem);

            DBE2060001.currentItem = targetItem;
        };

        DBE2060001._moveCursorTo = function (target) {
            $(DBE2060001.textBoxForAnswerOf(target).fieldName).focus();
        };

        DBE2060001._showOrHideButtons = function (index) {
            if (index == 0) {
                DBE2060001.makeControlDisabled(DBE2060001.previousButton);
            } else if (index == DBE2060001.chosaItems.length - 1) {
                DBE2060001.makeControlDisabled(DBE2060001.nextButton);
            } else {
                DBE2060001.makeControlAbled(DBE2060001.nextButton);
                DBE2060001.makeControlAbled(DBE2060001.previousButton);
            }
        };

        DBE2060001.nameOf = function (chosaItem) {
            return (DBE2060001.extractFieldFromChosaItem("lblItemName", chosaItem)).text;
        };

        DBE2060001.numberOf = function (chosaItem) {
            return (DBE2060001.extractFieldFromChosaItem("lblItemNo", chosaItem)).text;
        };

        DBE2060001.textBoxForAnswerOf = function (chosaItem) {
            return (DBE2060001.extractFieldFromChosaItem("txtAnswer", chosaItem));
        };

        DBE2060001.choicesOf = function (chosaItem) {
            return (DBE2060001.extractFieldFromChosaItem("radChoices", chosaItem));
        };

        DBE2060001.extractFieldFromChosaItem = function (fieldName, chosaItem) {
            //return Uz.GyomuJSHelper.getCompositeChildControl(chosaItem.fieldName, "KihonchosaResultInputCom", fieldName);
            return Uz.GyomuJSHelper.getJSControl(chosaItem.fieldName + '_' + fieldName);
        };

        DBE2060001.setUpGuaidance = function (target) {
            (Uz.GyomuJSHelper.getJSControl('lblItemNo')).text = DBE2060001.numberOf(target);
            (Uz.GyomuJSHelper.getJSControl('lblItemName')).text = DBE2060001.nameOf(target);
            DBE2060001.choices.dataSource = DBE2060001.choicesOf(target).dataSource;
            DBE2060001.choices.selectedItem = DBE2060001.textBoxForAnswerOf(target).value;
        };

        DBE2060001.makeControlDisabled = function (control) {
            control.disabled = true;
        };

        DBE2060001.makeControlAbled = function (control) {
            control.disabled = false;
        };
        DBE2060001.isHogeButtonClicked = false;
        DBE2060001.editingIndex = 0;
        DBE2060001.guaidance = Uz.GyomuJSHelper.getJSControl('KihonchosaResultGuidance');
        DBE2060001.chosaItems = [];
        DBE2060001.nextButton = Uz.GyomuJSHelper.getJSControl('btnSelectNext');
        DBE2060001.previousButton = Uz.GyomuJSHelper.getJSControl('btnSelectPrevious');
        DBE2060001.choices = Uz.GyomuJSHelper.getJSControl('radChoices');
        return DBE2060001;
    })();
    DBE.DBE2060001 = DBE2060001;
})(DBE || (DBE = {}));

DBE.DBE2060001.setSampleCoding();
//@ sourceMappingURL=DBE2060001.js.map
