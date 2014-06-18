/// <reference path="jquery.d.ts" />
/// <reference path="UzViewControls.d.ts" />

module DBE {

    interface IChosaItem extends Uz._JSControl {
    }

    class ChosaItem {
        private theItem: IChosaItem;

        constructor(item: IChosaItem) {
            this.theItem = item;
        }

        lblItemNo(): Uz._Label {
            return <Uz._Label>this.extractControlFromFieldName("lblItemNo");
        }

        lblItemName(): Uz._Label {
            return <Uz._Label>this.extractControlFromFieldName("lblItemName");
        }

        txtAnswer(): Uz._TextBox {
            return <Uz._TextBox>this.extractControlFromFieldName("txtAnswer");
        }

        radChoices(): Uz._RadioButton {
            return <Uz._RadioButton>this.extractControlFromFieldName("radChoices");
        }

        private extractControlFromFieldName(control_fieldName: string): Uz._JSControl {
            return Uz.GyomuJSHelper.getJSControl(this.theItem.fieldName + '_' + control_fieldName);
        }
    }

    export class DBE2060001 {
        private static isHogeButtonClicked = false;
        private static editingIndex: number = 0;
        private static guaidance: Uz._Panel = <Uz._Panel>Uz.GyomuJSHelper.getJSControl('KihonchosaResultGuidance');
        private static chosaItems: IChosaItem[] = [];
        private static nextButton: Uz._Button = <Uz._Button>Uz.GyomuJSHelper.getJSControl('btnSelectNext');
        private static previousButton: Uz._Button = <Uz._Button>Uz.GyomuJSHelper.getJSControl('btnSelectPrevious');
        private static choices: Uz._RadioButton = <Uz._RadioButton>Uz.GyomuJSHelper.getJSControl('radChoices');
        private static currentItem: Uz._JSControl;

        public static setSampleCoding() {
            DBE2060001.deployEvents();
        }

        

        private static deployEvents() {

            Uz.GyomuJSHelper.registOriginalEvent("onLoad_NinteichosaResultEntryMain", (control: Uz._ViewControl) => {
                DBE2060001.init();
            });

            Uz.GyomuJSHelper.registOriginalEvent("onClick_btnToEditTokkijiko", (control: Uz._ViewControl) => {
            });

            Uz.GyomuJSHelper.registOriginalEvent("onClick_btnSelectNext", (control: Uz._ViewControl) => {
                DBE2060001.onClick_btnSelectNext();
            });

            Uz.GyomuJSHelper.registOriginalEvent("onClick_btnSelectPrevious", (control: Uz._ViewControl) => {
                DBE2060001.onClick_btnSelectPrevious();
            });

            Uz.GyomuJSHelper.registOriginalEvent("onChange_radChoices", (control: Uz._ViewControl) => {
                var selectedKeyValue: string = DBE2060001.choices.selectedItem;
                var txtAnswer: Uz._TextBox = DBE2060001.txtAnswerOf(DBE2060001.currentItem);
                DBE2060001.setValueToTextBox(selectedKeyValue, txtAnswer);
            });

            Uz.GyomuJSHelper.registOriginalEvent("onChange_radChoices", (control: Uz._ViewControl) => {
                var selectedKeyValue: string = DBE2060001.choices.selectedItem;
                var txtAnswer: Uz._TextBox = DBE2060001.txtAnswerOf(DBE2060001.currentItem);
                DBE2060001.setValueToTextBox(selectedKeyValue, txtAnswer);
            });

            Uz.GyomuJSHelper.registOriginalEvent("onFocus_txtAnswer", (control: Uz._ViewControl) => {
                var parentFieldName = control.fieldName.replace("_txtAnswer", "");
                var currentItem: Uz._JSControl = Uz.GyomuJSHelper.getJSControl(parentFieldName);
                DBE2060001._setUpGuaidance(<IChosaItem>currentItem);
                DBE2060001.select(DBE2060001._getArrayIndexOf(currentItem));
            });

            Uz.GyomuJSHelper.registOriginalEvent("onChange_txtAnswer", (control: Uz._ViewControl) => {
                DBE2060001.choices.selectedItem = (<Uz._TextBox>control).text;
            });
        }

        private static init() {
            DBE2060001.editingIndex = 0;
            DBE2060001.init_chosaItems();
            DBE2060001.select(0);
        }

        private static init_chosaItems() {

            function _concatJSControlsToChosaItems(viewControls: Uz._JSControl[]) {
                DBE2060001.chosaItems = DBE2060001.chosaItems.concat(viewControls);
            }

            _concatJSControlsToChosaItems((<Uz._Panel>Uz.GyomuJSHelper.getJSControl('Kihonchosa0911')).items);
            _concatJSControlsToChosaItems((<Uz._Panel>Uz.GyomuJSHelper.getJSControl('Kihonchosa0912')).items);
            _concatJSControlsToChosaItems((<Uz._Panel>Uz.GyomuJSHelper.getJSControl('Kihonchosa0921')).items);
            _concatJSControlsToChosaItems((<Uz._Panel>Uz.GyomuJSHelper.getJSControl('Kihonchosa0931')).items);
            _concatJSControlsToChosaItems((<Uz._Panel>Uz.GyomuJSHelper.getJSControl('Kihonchosa0941')).items);
            _concatJSControlsToChosaItems((<Uz._Panel>Uz.GyomuJSHelper.getJSControl('Kihonchosa0942')).items);
            _concatJSControlsToChosaItems((<Uz._Panel>Uz.GyomuJSHelper.getJSControl('Kihonchosa0951')).items);
            _concatJSControlsToChosaItems((<Uz._Panel>Uz.GyomuJSHelper.getJSControl('Kihonchosa0961')).items);
            _concatJSControlsToChosaItems((<Uz._Panel>Uz.GyomuJSHelper.getJSControl('Kihonchosa0971')).items);

            for (var i = 0; i < DBE2060001.chosaItems.length; i++) {
                var txtAnswer: Uz._TextBox = DBE2060001.txtAnswerOf(DBE2060001.chosaItems[i]);
                txtAnswer.onFocus = "onFocus_txtAnswer";
                txtAnswer.onChange = "onChange_txtAnswer";
            }
        }

        private static _getArrayIndexOf(chosaItem: Uz._JSControl): number {
            for (var i = 0; i < DBE2060001.chosaItems.length; i++) {
                if (DBE2060001.chosaItems[i] === chosaItem) {
                    return i;
                }
            }
            return 0;
        }

        private static onClick_btnSelectNext() {
            var index: number = DBE2060001.editingIndex;
            if (index < DBE2060001.chosaItems.length) {
                DBE2060001.select(index + 1);
            }
        }

        private static onClick_btnSelectPrevious() {
            var index: number = DBE2060001.editingIndex;
            if (0 < index) {
                DBE2060001.select(index - 1);
            }
        }

        private static select(index: number) {
            DBE2060001.editingIndex = index;
            var targetItem: Uz._JSControl = DBE2060001.chosaItems[index];
            DBE2060001._setUpGuaidance(<IChosaItem> targetItem);

            DBE2060001._showOrHideButtons(index);
            DBE2060001._moveCursorTo(targetItem);

            DBE2060001.currentItem = targetItem;
        }

        private static _setUpGuaidance(target: IChosaItem) {
            var chosaItem: ChosaItem = new ChosaItem(target);
            (<Uz._TextBox>Uz.GyomuJSHelper.getJSControl('lblItemNo')).text = chosaItem.lblItemNo().text;
            (<Uz._TextBox>Uz.GyomuJSHelper.getJSControl('lblItemName')).text = chosaItem.lblItemName().text;
            DBE2060001.choices.dataSource = chosaItem.radChoices().dataSource;
            DBE2060001.choices.selectedItem = chosaItem.txtAnswer().value;
        }
        
        private static _moveCursorTo(target: IChosaItem) {
            $(DBE2060001.txtAnswerOf(target).fieldName).focus();
        }
        
        private static _showOrHideButtons(index: number) {
            function isFirst(index: number): boolean {return index === 0 };
            function isLast(index: number): boolean { return index === DBE2060001.chosaItems.length - 1 };
            if (isFirst(index)) {
                DBE2060001.makeControlDisabled(DBE2060001.previousButton);
            } else if (isLast(index)) {
                DBE2060001.makeControlDisabled(DBE2060001.nextButton);
            } else {
                DBE2060001.makeControlAbled(DBE2060001.nextButton);
                DBE2060001.makeControlAbled(DBE2060001.previousButton);
            }
        }

        private static makeControlDisabled(control: Uz._ViewControl) {
            control.disabled = true;
        }

        private static makeControlAbled(control: Uz._ViewControl) {
            control.disabled = false;
        }

        private static txtAnswerOf(chosaItem: IChosaItem): Uz._TextBox {
            return <Uz._TextBox>Uz.GyomuJSHelper.getJSControl(chosaItem.fieldName + '_' + "txtAnswer");
        }

        private static setValueToTextBox(value: string, textBox: Uz._TextBox) {
            textBox.text = value;
            textBox.value = value;
        }
    }
}

DBE.DBE2060001.setSampleCoding();