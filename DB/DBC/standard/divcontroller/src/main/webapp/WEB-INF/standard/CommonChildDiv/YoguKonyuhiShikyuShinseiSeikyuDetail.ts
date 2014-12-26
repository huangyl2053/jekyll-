/// <reference path="YoguKonyuhiShikyuShinseiSeikyuDetail_Design.ts" />

// 共有子Divモード記述TypeScriptソースです。

module DBC
{
    export module YoguKonyuhiShikyuShinseiSeikyuDetail {

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



module DBC {

    export module YoguKonyuhiShikyuShinseiSeikyuDetail {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("btnModifyDetail_onClick", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("btnModifyDetail_text", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            }

            public getbtnModifyDetail_onClick() {
                return this.controls.btnModifyDetail().onClick;
            }

            public setbtnModifyDetail_onClick(value) {
                this.controls.btnModifyDetail().onClick = value;
            }

            public getbtnModifyDetail_text() {
                return this.controls.btnModifyDetail().text;
            }

            public setbtnModifyDetail_text(value) {
                this.controls.btnModifyDetail().text = value;
            }

        }
    }
}




