/// <reference path='RirekiShusei_Design.ts' />
module DBZ
{
    export module RirekiShusei
    {
        export class ModeController {
            private controls: Controls;
            private fieldName: string;

            constructor(fieldName: string) {
                this.fieldName = fieldName;
                this.controls = new Controls(fieldName);
            }

            public Properties() {
                return new UZA.CommonChildDiv(this.fieldName);
            }

            public PublicProperties() {
                return new PublicProperties(this.fieldName);
            }
            public DisplayType() {
                return new Modes.DisplayType(this.controls);
            }
        }

        export module Modes {
            export class DisplayType {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }
                public tsuika(): void {
                    //異動事由のみ入力可能
                }
                public sakujo(): void {
                    //削除事由のみ入力可能
                }
                public sakujoShusei(): void {
                    //削除事由・当初認定開始-終了・受給資格証明書1-2・申請区分(申請時)-(法令)　が入力可
                }
                public torikeshiTsuika(): void {
                    //ccd認定入力・削除事由・喪失日　が未入力
                }
                public torikeshiShusei(): void {
                    //ccd認定入力・削除事由・喪失日・特定疾病　が未入力
                }
                public ninteiShusei(): void {
                    //tuikaShusei・異動事由
                }
            }
        }
    }
}

module DBZ
{
    export module RirekiShusei
    {
        export class PublicProperties {
            private controls: Controls;
            private fieldName: string;

            constructor(fieldName: string) {
                this.fieldName = fieldName;
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            }
        }
    }
}

