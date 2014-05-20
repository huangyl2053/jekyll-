/// <reference path="jquery.d.ts" />
/// <reference path="UzViewControls.d.ts" />

module DBE {
    export class DBE2060001 {
        private static isHogeButtonClicked = false;
        private static editingIndex: number = 0;
        private static guaidance: Uz._Panel = <Uz._Panel>Uz.GyomuJSHelper.getJSControl('KihonchosaResultGuidance');
        private static chosaItems: Uz._JSControl[] = [];
        private static nextButton: Uz._Button = <Uz._Button>Uz.GyomuJSHelper.getJSControl('btnSelectNext');
        private static previousButton: Uz._Button = <Uz._Button>Uz.GyomuJSHelper.getJSControl('btnSelectPrevious');
        private static choices: Uz._RadioButton = <Uz._RadioButton>Uz.GyomuJSHelper.getJSControl('radChoices');
        private static currentItem: Uz._JSControl;

        public static setSampleCoding() {
            DBE2060001.init();
            //DBE2060001.alertHellowWorld();
            DBE2060001.deployBtnToEditTokkijikoEvent();
            DBE2060001.deployKihonchosaItemEvents();
        }

        private static init() {
            DBE2060001.editingIndex = 0;
            DBE2060001.init_chosaItems();
            DBE2060001.select(0);
        }

        private static init_chosaItems() {
            DBE2060001._concatJSControlsToChosaItems((<Uz._Panel>Uz.GyomuJSHelper.getJSControl('Kihonchosa0911')).items);
            DBE2060001._concatJSControlsToChosaItems((<Uz._Panel>Uz.GyomuJSHelper.getJSControl('Kihonchosa0912')).items);
            DBE2060001._concatJSControlsToChosaItems((<Uz._Panel>Uz.GyomuJSHelper.getJSControl('Kihonchosa0921')).items);
            DBE2060001._concatJSControlsToChosaItems((<Uz._Panel>Uz.GyomuJSHelper.getJSControl('Kihonchosa0931')).items);
            DBE2060001._concatJSControlsToChosaItems((<Uz._Panel>Uz.GyomuJSHelper.getJSControl('Kihonchosa0941')).items);
            DBE2060001._concatJSControlsToChosaItems((<Uz._Panel>Uz.GyomuJSHelper.getJSControl('Kihonchosa0942')).items);
            DBE2060001._concatJSControlsToChosaItems((<Uz._Panel>Uz.GyomuJSHelper.getJSControl('Kihonchosa0951')).items);
            DBE2060001._concatJSControlsToChosaItems((<Uz._Panel>Uz.GyomuJSHelper.getJSControl('Kihonchosa0961')).items);
            DBE2060001._concatJSControlsToChosaItems((<Uz._Panel>Uz.GyomuJSHelper.getJSControl('Kihonchosa0971')).items);
        }

        private static _concatJSControlsToChosaItems(viewControls: Uz._JSControl[]) {
            DBE2060001.chosaItems = DBE2060001.chosaItems.concat(viewControls);
        }

        private static alertHellowWorld() {
            if (!Uz.GyomuJSHelper.isDesignMode()) {
                alert("HelloWorld");
            }
        }

        private static deployBtnToEditTokkijikoEvent() {
            Uz.GyomuJSHelper.registOriginalEvent("onClick_btnToEditTokkijiko", (control: Uz._ViewControl) => {
                var panel: Uz._Panel = <Uz._Panel>Uz.GyomuJSHelper.getJSControl('KihonchosaResultGuidance');
                panel.title = "test";
                alert("" + DBE2060001.chosaItems.length);
            });

        }

        private static deployKihonchosaItemEvents() {
            Uz.GyomuJSHelper.registOriginalEvent("onClick_btnSelectNext", (control: Uz._ViewControl) => {
                DBE2060001.next();
            });
            Uz.GyomuJSHelper.registOriginalEvent("onClick_btnSelectPrevious", (control: Uz._ViewControl) => {
                DBE2060001.previous();
            });
        }

        private static next() {
            var index: number = DBE2060001.editingIndex;
            if (index < DBE2060001.chosaItems.length) {
                DBE2060001.select(index + 1);
            }
        }

        private static previous() {
            var index: number = DBE2060001.editingIndex;
            if (0 < index) {
                DBE2060001.select(index - 1);
            }
        }


        private static select(index: number) {
            DBE2060001.editingIndex = index;
            var targetItem: Uz._JSControl = DBE2060001.chosaItems[index];
            DBE2060001.setUpGuaidance(targetItem);

            DBE2060001._showOrHideButtons(index);
            DBE2060001._moveCursorTo(targetItem);

            DBE2060001.currentItem = targetItem;
        }

        private static _moveCursorTo(target: Uz._JSControl) {
            $(DBE2060001.textBoxToAnswerOf(target).fieldName).focus();
        }

        private static _showOrHideButtons(index: number) {
            if (index == 0) {
                DBE2060001.makeControlDisabled(DBE2060001.previousButton);
            } else if (index == DBE2060001.chosaItems.length - 1) {
                DBE2060001.makeControlDisabled(DBE2060001.nextButton);
            }
            else {
                DBE2060001.makeControlAbled(DBE2060001.nextButton);
                DBE2060001.makeControlAbled(DBE2060001.previousButton);
            }
        }

        private static nameOf(chosaItem: Uz._JSControl): string {
            return (<Uz._Label>DBE2060001.extractFieldFromChosaItem("lblItemName", chosaItem)).text;
        }

        private static numberOf(chosaItem: Uz._JSControl): string {
            return (<Uz._Label>DBE2060001.extractFieldFromChosaItem("lblItemNo", chosaItem)).text;
        }

        private static textBoxToAnswerOf(chosaItem: Uz._JSControl): Uz._TextBox {
            return (<Uz._TextBox>DBE2060001.extractFieldFromChosaItem("txtAnswer", chosaItem));
        }

        private static choicesOf(chosaItem: Uz._JSControl): Uz._RadioButton {
            return (<Uz._RadioButton>DBE2060001.extractFieldFromChosaItem("radChoices", chosaItem));
        }

        private static extractFieldFromChosaItem(fieldName: string, chosaItem: Uz._JSControl): Uz._JSControl {
            //return Uz.GyomuJSHelper.getCompositeChildControl(chosaItem.fieldName, "KihonchosaResultInputCom", fieldName);
            return Uz.GyomuJSHelper.getJSControl(chosaItem.fieldName + '_' + fieldName);
        }

        private static setUpGuaidance(target: Uz._JSControl) {
            (<Uz._TextBox>Uz.GyomuJSHelper.getJSControl('lblItemNo')).text = DBE2060001.numberOf(target);
            (<Uz._TextBox>Uz.GyomuJSHelper.getJSControl('lblItemName')).text = DBE2060001.nameOf(target);
            DBE2060001.choices.dataSource = DBE2060001.choicesOf(target).dataSource;
            DBE2060001.choices.selectedItem = DBE2060001.textBoxToAnswerOf(target).value;

        }

        private static makeControlDisabled(control: Uz._ViewControl) {
            control.disabled = true;
        }

        private static makeControlAbled(control: Uz._ViewControl) {
            control.disabled = false;
        }
    }
}

DBE.DBE2060001.setSampleCoding();