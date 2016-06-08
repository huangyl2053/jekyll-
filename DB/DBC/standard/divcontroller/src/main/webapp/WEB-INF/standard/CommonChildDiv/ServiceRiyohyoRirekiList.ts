/// <reference path="ServiceRiyohyoRirekiList_Design.ts" />

// 共有子Divモード記述TypeScriptソースです。

module DBC
{
    export module ServiceRiyohyoRirekiList {

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

    export module ServiceRiyohyoRirekiList {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("RirekiListHeight", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("RirekiListWidth", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            }
            
            /*
            //TODO n8178 城間篤人 モード化するか削除するか作成者の判断が必要。
            public getRirekiListGridSetting() {
                return this.controls.dgServiceRiyohyoRirekiList().gridSetting;
            }

            public setRirekiListGridSetting(value) {
                this.controls.dgServiceRiyohyoRirekiList().gridSetting = value;
            }
            */

            public getRirekiListHeight() {
                return this.controls.dgServiceRiyohyoRirekiList().height;
            }

            public setRirekiListHeight(value) {
                this.controls.dgServiceRiyohyoRirekiList().height = value;
            }

            public getRirekiListWidth() {
                return this.controls.dgServiceRiyohyoRirekiList().width;
            }

            public setRirekiListWidth(value) {
                this.controls.dgServiceRiyohyoRirekiList().width = value;
            }

        }
    }
}




