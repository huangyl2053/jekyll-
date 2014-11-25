/// <reference path="ShisetsuNyutaishoRirekiKanri_Design.ts" />

// 共有子Divモード記述TypeScriptソースです。

module DBZ
{
    export module ShisetsuNyutaishoRirekiKanri {

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
        }

    }
}



module DBZ {

    export module ShisetsuNyutaishoRirekiKanri {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();
                /*
                editTypes.addEditType("InputPanelDisplayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("AddButtonDisplayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("UpdateButtonDisplayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("gridSetting", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("radShisetsuShuruiDisplayNone", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("jigyoshaInputGuideDisplayNone", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("otherShisetsuInputGuideDisplayNone", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("jogaiShisetsuInputGuideDisplayNone", UZA.EditTypeEnumForPublicProperty.StringType);
                */
                return editTypes;
            }

            /*
            //TODO n8178 城間篤人 他ブランチでモード対応済み（もしくは再対応中）そちらとマージ後に修正。
            public getInputPanelDisplayNone() {
                return this.controls.ShisetsuNyutaishoInput().displayNone;
            }

            public setInputPanelDisplayNone(value) {
                this.controls.ShisetsuNyutaishoInput().displayNone = value;
            }

            public getAddButtonDisplayNone() {
                return this.controls.btnAddShisetsuNyutaisho().displayNone;
            }

            public setAddButtonDisplayNone(value) {
                this.controls.btnAddShisetsuNyutaisho().displayNone = value;
            }

            public getUpdateButtonDisplayNone() {
                return this.controls.btnUpdateShisetsuNyutaisho().displayNone;
            }

            public setUpdateButtonDisplayNone(value) {
                this.controls.btnUpdateShisetsuNyutaisho().displayNone = value;
            }
            public getgridSetting() {
                return this.controls.dgShisetsuNyutaishoRireki().gridSetting;
            }

            public setgridSetting(value) {
                this.controls.dgShisetsuNyutaishoRireki().gridSetting = value;
            }
            public getradShisetsuShuruiDisplayNone() {
                return this.controls.ShisetsuJoho().radShisetsuShurui_displayNone;
            }

            public setradShisetsuShuruiDisplayNone(value) {
                this.controls.ShisetsuJoho().radShisetsuShurui_displayNone = value;
            }

            public getjigyoshaInputGuideDisplayNone() {
                return this.controls.ShisetsuJoho().btnJigyoshaInputGuide_displayNone;
            }

            public setjigyoshaInputGuideDisplayNone(value) {
                this.controls.ShisetsuJoho().btnJigyoshaInputGuide_displayNone = value;
            }

            public getotherShisetsuInputGuideDisplayNone() {
                return this.controls.ShisetsuJoho().btnOtherTokureiShisetsuInputGuide_displayNone;
            }

            public setotherShisetsuInputGuideDisplayNone(value) {
                this.controls.ShisetsuJoho().btnOtherTokureiShisetsuInputGuide_displayNone = value;
            }

            public getjogaiShisetsuInputGuideDisplayNone() {
                return this.controls.ShisetsuJoho().btnJogaiShisetsuInputGuide_displayNone;
            }

            public setjogaiShisetsuInputGuideDisplayNone(value) {
                this.controls.ShisetsuJoho().btnJogaiShisetsuInputGuide_displayNone = value;
            }
            */

        }
    }
}




