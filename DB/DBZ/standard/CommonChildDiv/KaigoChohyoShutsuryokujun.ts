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
        }

    }
}



module DBZ {

    export module KaigoChohyoShutsuryokujun {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("ChohyoShutsuryokujun_width", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            }

            /*
            //PublicPropertyへの参照が見えないため設定不可
            public getChohyoShutsuryokujun_width() {
                return this.controls.kaigoChohyoShutsuryokujun().ChohyoShutsuryokujun_width;
            }

            public setChohyoShutsuryokujun_width(value) {
                this.controls.kaigoChohyoShutsuryokujun().ChohyoShutsuryokujun_width = value;
            }
            */

        }
    }
}




