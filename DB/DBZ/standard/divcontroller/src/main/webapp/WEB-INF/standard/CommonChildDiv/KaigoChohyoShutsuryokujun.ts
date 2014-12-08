/// <reference path="KaigoChohyoShutsuryokujun_Design.ts" />

// 共有子Divモード記述TypeScriptソースです。

module DBZ
{
    export module KaigoChohyoShutsuryokujun {

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

    export module KaigoChohyoShutsuryokujun {

        export class PublicProperties {
            private controls: Controls;
            private fieldName: string;

            constructor(fieldName: string) {
                this.fieldName = fieldName;
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("ChohyoShutsuryokujun_width", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            }
            
            //TODO n8178 城間篤人 PublicPropertyへの参照が見えないため、入れ子になっているUR共有子Divのプロパティを取得できない
            public getChohyoShutsuryokujun_width() {
                //return this.controls.kaigoChohyoShutsuryokujun().ChohyoShutsuryokujun_width;
                return this.controls.convFiledName;
            }

            public setChohyoShutsuryokujun_width(value) {
                //return this.controls.kaigoChohyoShutsuryokujun().ChohyoShutsuryokujun_width=value;
                return this.controls.convFiledName = value;
            }

        }
    }
}




