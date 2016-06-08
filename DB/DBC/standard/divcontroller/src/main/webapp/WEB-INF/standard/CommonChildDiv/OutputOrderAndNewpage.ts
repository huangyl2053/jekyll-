/// <reference path="OutputOrderAndNewpage_Design.ts" />

// 共有子Divモード記述TypeScriptソースです。

module DBC
{
    export module OutputOrderAndNewpage {

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

    export module OutputOrderAndNewpage {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("isGroupBox", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("title", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("txtNewPageItem_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            }

            public getisGroupBox() {
                return this.controls.OutputOrderAndNewpage().isGroupBox;
            }

            public setisGroupBox(value) {
                this.controls.OutputOrderAndNewpage().isGroupBox = value;
            }

            public gettitle() {
                return this.controls.OutputOrderAndNewpage().title;
            }

            public settitle(value) {
                this.controls.OutputOrderAndNewpage().title = value;
            }

            public gettxtNewPageItem_displayNone() {
                return this.controls.txtNewPageItem().displayNone;
            }

            public settxtNewPageItem_displayNone(value) {
                this.controls.txtNewPageItem().displayNone = value;
            }

        }
    }
}




