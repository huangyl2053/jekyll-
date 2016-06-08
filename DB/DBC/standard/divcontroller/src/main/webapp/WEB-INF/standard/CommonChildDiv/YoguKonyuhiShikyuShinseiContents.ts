/// <reference path="YoguKonyuhiShikyuShinseiContents_Design.ts" />

// 共有子Divモード記述TypeScriptソースです。

module DBC
{
    export module YoguKonyuhiShikyuShinseiContents {

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

    export module YoguKonyuhiShikyuShinseiContents {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("AddSeikyuDetailOnclick", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            }

            public getAddSeikyuDetailOnclick() {
                return this.controls.btnAddSeikyuDetail().onClick;
            }

            public setAddSeikyuDetailOnclick(value) {
                this.controls.btnAddSeikyuDetail().onClick = value;
            }

        }
    }
}




