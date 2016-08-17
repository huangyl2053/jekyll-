/// <reference path="KyufuJissekiHeader_Design.ts" />

// 共有子Divモード記述TypeScriptソースです。

module DBC
{
    export module KyufuJissekiHeader {

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

    export module KyufuJissekiHeader {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("txtJigyoshaVisible", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtJigyoshaDisplayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            }

            public gettxtJigyoshaVisible() {
                return this.controls.txtJigyosha().visible;
            }

            public settxtJigyoshaVisible(value) {
                this.controls.txtJigyosha().visible = value;
            }

            public gettxtJigyoshaDisplayNone() {
                return this.controls.txtJigyosha().displayNone;
            }

            public settxtJigyoshaDisplayNone(value) {
                this.controls.txtJigyosha().displayNone = value;
            }

        }
    }
}




