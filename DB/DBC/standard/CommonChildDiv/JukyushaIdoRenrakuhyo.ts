/// <reference path="JukyushaIdoRenrakuhyo_Design.ts" />

// 共有子Divモード記述TypeScriptソースです。

module DBC
{
    export module JukyushaIdoRenrakuhyo {

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

    export module JukyushaIdoRenrakuhyo {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("TeiseiInfoVisible", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TeiseiInfoDisplayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            }

            public getTeiseiInfoVisible() {
                return this.controls.JukyushaIdoRenrakuhyoTeisei().visible;
            }

            public setTeiseiInfoVisible(value) {
                this.controls.JukyushaIdoRenrakuhyoTeisei().visible = value;
            }

            public getTeiseiInfoDisplayNone() {
                return this.controls.JukyushaIdoRenrakuhyoTeisei().displayNone;
            }

            public setTeiseiInfoDisplayNone(value) {
                this.controls.JukyushaIdoRenrakuhyoTeisei().displayNone = value;
            }

        }
    }
}




