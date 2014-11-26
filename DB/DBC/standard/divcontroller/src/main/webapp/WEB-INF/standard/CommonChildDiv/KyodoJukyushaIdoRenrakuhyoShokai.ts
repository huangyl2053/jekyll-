/// <reference path="KyodoJukyushaIdoRenrakuhyoShokai_Design.ts" />

// 共有子Divモード記述TypeScriptソースです。

module DBC
{
    export module KyodoJukyushaIdoRenrakuhyoShokai {

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

    export module KyodoJukyushaIdoRenrakuhyoShokai {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            /*
            //TODO n8178 城間篤人 プロパティとして指定されていたTeiseiInfoが見つからない。作成者の判断が必要。
            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("TeiseiInfoVisible", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TeiseiInfoDisplayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            }

            public getTeiseiInfoVisible() {
                return this.controls.KyodoJukyushaIdoRenrakuhyoTeisei().visible;
            }

            public setTeiseiInfoVisible(value) {
                this.controls.KyodoJukyushaIdoRenrakuhyoTeisei().visible = value;
            }

            public getTeiseiInfoDisplayNone() {
                return this.controls.KyodoJukyushaIdoRenrakuhyoTeisei().displayNone;
            }

            public setTeiseiInfoDisplayNone(value) {
                this.controls.KyodoJukyushaIdoRenrakuhyoTeisei().displayNone = value;
            }
            */

        }
    }
}




