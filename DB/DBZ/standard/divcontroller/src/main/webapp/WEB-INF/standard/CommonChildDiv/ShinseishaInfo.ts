/// <reference path="ShinseishaInfo_Design.ts" />

// 共有子Divモード記述TypeScriptソースです。

module DBZ
{
    export module ShinseishaInfo {

        export class ModeController{
            private controls: Controls;
            private fieldName: string;

            constructor(fieldName: string) {
                this.fieldName = fieldName;
                this.controls = new Controls(fieldName);
            }
 
            public priorities(): Array<string> {
                return [];
            }

            public Properties() {
                return new UZA.CommonChildDiv(this.fieldName);
            }

            public PublicProperties() {
                return new PublicProperties(this.fieldName);
            }
        }

    }
}



module DBZ {

    export module ShinseishaInfo {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("btnJigyoshaInputGuide_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtUkestukeDate_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("title", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("panelDisplay", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("txtJigyoshaNo_disabled", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtShinseishaName_labelLText", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("txtYubinNo_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtAddress_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("btnJigyoshaInputGuide_disabled", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("shinseishaInfo_eraseBorder", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            }

            public getbtnJigyoshaInputGuide_displayNone() {
                return this.controls.btnJigyoshaInputGuide().displayNone;
            }

            public setbtnJigyoshaInputGuide_displayNone(value) {
                this.controls.btnJigyoshaInputGuide().displayNone = value;
            }

            public gettxtUkestukeDate_displayNone() {
                return this.controls.txtUketsukeDate().displayNone;
            }

            public settxtUkestukeDate_displayNone(value) {
                this.controls.txtUketsukeDate().displayNone = value;
            }

            public gettitle() {
                return this.controls.ShinseishaInfo().title;
            }

            public settitle(value) {
                this.controls.ShinseishaInfo().title = value;
            }

            public getpanelDisplay() {
                return this.controls.ShinseishaInfo().panelDisplay;
            }

            public setpanelDisplay(value) {
                this.controls.ShinseishaInfo().panelDisplay = value;
            }

            public gettxtJigyoshaNo_disabled() {
                return this.controls.txtJigyoshaNo().disabled;
            }

            public settxtJigyoshaNo_disabled(value) {
                this.controls.txtJigyoshaNo().disabled = value;
            }

            public gettxtShinseishaName_labelLText() {
                return this.controls.txtShinseishaNameKana().labelLText;
            }

            public settxtShinseishaName_labelLText(value) {
                this.controls.txtShinseishaNameKana().labelLText = value;
            }

            public gettxtYubinNo_displayNone() {
                return this.controls.txtYubinNo().displayNone;
            }

            public settxtYubinNo_displayNone(value) {
                this.controls.txtYubinNo().displayNone = value;
            }

            public gettxtAddress_displayNone() {
                return this.controls.txtAddress().displayNone;
            }

            public settxtAddress_displayNone(value) {
                this.controls.txtAddress().displayNone = value;
            }

            public getbtnJigyoshaInputGuide_disabled() {
                return this.controls.btnJigyoshaInputGuide().disabled;
            }

            public setbtnJigyoshaInputGuide_disabled(value) {
                this.controls.btnJigyoshaInputGuide().disabled = value;
            }

            public getshinseishaInfo_eraseBorder() {
                return this.controls.ShinseishaInfo().eraseBorder;
            }

            public setshinseishaInfo_eraseBorder(value) {
                this.controls.ShinseishaInfo().eraseBorder = value;
            }

        }
    }
}




