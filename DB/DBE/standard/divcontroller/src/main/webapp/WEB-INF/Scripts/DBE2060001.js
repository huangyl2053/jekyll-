/// <reference path="jquery.d.ts" />
/// <reference path="UzViewControls.d.ts" />
var DBE;
(function (DBE) {
    var ChosaItem = (function () {
        function ChosaItem(item) {
            this.theItem = item;
        }
        ChosaItem.prototype.lblItemNo = function () {
            return this.extractControlFromFieldName("lblItemNo");
        };

        ChosaItem.prototype.lblItemName = function () {
            return this.extractControlFromFieldName("lblItemName");
        };

        ChosaItem.prototype.txtAnswer = function () {
            return this.extractControlFromFieldName("txtAnswer");
        };

        ChosaItem.prototype.radChoices = function () {
            return this.extractControlFromFieldName("radChoices");
        };

        ChosaItem.prototype.extractControlFromFieldName = function (control_fieldName) {
            return Uz.GyomuJSHelper.getJSControl(this.theItem.fieldName + '_' + control_fieldName);
        };
        return ChosaItem;
    })();

    var DBE2060001 = (function () {
        function DBE2060001() {
        }
        DBE2060001.setSampleCoding = function () {
            DBE2060001.deployEvents();
        };

        DBE2060001.deployEvents = function () {
            Uz.GyomuJSHelper.registOriginalEvent("onLoad_NinteichosaResultEntryMain", function (control) {
                DBE2060001.init();
            });

            Uz.GyomuJSHelper.registOriginalEvent("onClick_btnToEditTokkijiko", function (control) {
            });

            Uz.GyomuJSHelper.registOriginalEvent("onClick_btnSelectNext", function (control) {
                DBE2060001.onClick_btnSelectNext();
            });

            Uz.GyomuJSHelper.registOriginalEvent("onClick_btnSelectPrevious", function (control) {
                DBE2060001.onClick_btnSelectPrevious();
            });

            Uz.GyomuJSHelper.registOriginalEvent("onChange_radChoices", function (control) {
                var selectedKeyValue = DBE2060001.choices.selectedItem;
                var txtAnswer = DBE2060001.txtAnswerOf(DBE2060001.currentItem);
                DBE2060001.setValueToTextBox(selectedKeyValue, txtAnswer);
            });

            Uz.GyomuJSHelper.registOriginalEvent("onChange_radChoices", function (control) {
                var selectedKeyValue = DBE2060001.choices.selectedItem;
                var txtAnswer = DBE2060001.txtAnswerOf(DBE2060001.currentItem);
                DBE2060001.setValueToTextBox(selectedKeyValue, txtAnswer);
            });

            Uz.GyomuJSHelper.registOriginalEvent("onFocus_txtAnswer", function (control) {
                var parentFieldName = control.fieldName.replace("_txtAnswer", "");
                var currentItem = Uz.GyomuJSHelper.getJSControl(parentFieldName);
                DBE2060001._setUpGuaidance(currentItem);
                DBE2060001.select(DBE2060001._getArrayIndexOf(currentItem));
            });

            Uz.GyomuJSHelper.registOriginalEvent("onChange_txtAnswer", function (control) {
                DBE2060001.choices.selectedItem = (control).text;
            });
        };

        DBE2060001.init = function () {
            DBE2060001.editingIndex = 0;
            DBE2060001.init_chosaItems();
            DBE2060001.select(0);
        };

        DBE2060001.init_chosaItems = function () {
            function _concatJSControlsToChosaItems(viewControls) {
                DBE2060001.chosaItems = DBE2060001.chosaItems.concat(viewControls);
            }

            _concatJSControlsToChosaItems((Uz.GyomuJSHelper.getJSControl('Kihonchosa0911')).items);
            _concatJSControlsToChosaItems((Uz.GyomuJSHelper.getJSControl('Kihonchosa0912')).items);
            _concatJSControlsToChosaItems((Uz.GyomuJSHelper.getJSControl('Kihonchosa0921')).items);
            _concatJSControlsToChosaItems((Uz.GyomuJSHelper.getJSControl('Kihonchosa0931')).items);
            _concatJSControlsToChosaItems((Uz.GyomuJSHelper.getJSControl('Kihonchosa0941')).items);
            _concatJSControlsToChosaItems((Uz.GyomuJSHelper.getJSControl('Kihonchosa0942')).items);
            _concatJSControlsToChosaItems((Uz.GyomuJSHelper.getJSControl('Kihonchosa0951')).items);
            _concatJSControlsToChosaItems((Uz.GyomuJSHelper.getJSControl('Kihonchosa0961')).items);
            _concatJSControlsToChosaItems((Uz.GyomuJSHelper.getJSControl('Kihonchosa0971')).items);

            for (var i = 0; i < DBE2060001.chosaItems.length; i++) {
                var txtAnswer = DBE2060001.txtAnswerOf(DBE2060001.chosaItems[i]);
                txtAnswer.onFocus = "onFocus_txtAnswer";
                txtAnswer.onChange = "onChange_txtAnswer";
            }
        };

        DBE2060001._getArrayIndexOf = function (chosaItem) {
            for (var i = 0; i < DBE2060001.chosaItems.length; i++) {
                if (DBE2060001.chosaItems[i] === chosaItem) {
                    return i;
                }
            }
            return 0;
        };

        DBE2060001.onClick_btnSelectNext = function () {
            var index = DBE2060001.editingIndex;
            if (index < DBE2060001.chosaItems.length) {
                DBE2060001.select(index + 1);
            }
        };

        DBE2060001.onClick_btnSelectPrevious = function () {
            var index = DBE2060001.editingIndex;
            if (0 < index) {
                DBE2060001.select(index - 1);
            }
        };

        DBE2060001.select = function (index) {
            DBE2060001.editingIndex = index;
            var targetItem = DBE2060001.chosaItems[index];
            DBE2060001._setUpGuaidance(targetItem);

            DBE2060001._showOrHideButtons(index);
            DBE2060001._moveCursorTo(targetItem);

            DBE2060001.currentItem = targetItem;
        };

        DBE2060001._setUpGuaidance = function (target) {
            var chosaItem = new ChosaItem(target);
            (Uz.GyomuJSHelper.getJSControl('lblItemNo')).text = chosaItem.lblItemNo().text;
            (Uz.GyomuJSHelper.getJSControl('lblItemName')).text = chosaItem.lblItemName().text;
            DBE2060001.choices.dataSource = chosaItem.radChoices().dataSource;
            DBE2060001.choices.selectedItem = chosaItem.txtAnswer().value;
        };

        DBE2060001._moveCursorTo = function (target) {
            $(DBE2060001.txtAnswerOf(target).fieldName).focus();
        };

        DBE2060001._showOrHideButtons = function (index) {
            function isFirst(index) {
                return index === 0;
            }
            ;
            function isLast(index) {
                return index === DBE2060001.chosaItems.length - 1;
            }
            ;
            if (isFirst(index)) {
                DBE2060001.makeControlDisabled(DBE2060001.previousButton);
            } else if (isLast(index)) {
                DBE2060001.makeControlDisabled(DBE2060001.nextButton);
            } else {
                DBE2060001.makeControlAbled(DBE2060001.nextButton);
                DBE2060001.makeControlAbled(DBE2060001.previousButton);
            }
        };

        DBE2060001.makeControlDisabled = function (control) {
            control.disabled = true;
        };

        DBE2060001.makeControlAbled = function (control) {
            control.disabled = false;
        };

        DBE2060001.txtAnswerOf = function (chosaItem) {
            return Uz.GyomuJSHelper.getJSControl(chosaItem.fieldName + '_' + "txtAnswer");
        };

        DBE2060001.setValueToTextBox = function (value, textBox) {
            textBox.text = value;
            textBox.value = value;
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
