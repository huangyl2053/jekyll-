/// <reference path="KaigoKanryoMessage_Design.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />

// 共有子Divモード記述TypeScriptソースです。

module DBZ
{
    export module KaigoKanryoMessage {

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

    export module KaigoKanryoMessage {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("KanryoMessage_width", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            }
            /*
            //TODO n8178 城間篤人 PublicPropertyへの参照が見えない。確認が必要。
            public getKanryoMessage_width() {
                return this.controls.KanryoMessage().PublicProperties().KanryoMessage_width;
            }

            public setKanryoMessage_width(value) {
                this.controls.KanryoMessage().PublicProperties().KanryoMessage_width = value;
            }
            */

        }
    }
}




