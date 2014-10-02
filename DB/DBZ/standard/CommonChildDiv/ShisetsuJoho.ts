/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

/// <reference path='ShisetsuJoho_Design.ts' />
module DBZ
{
    export module ShisetsuJoho
    {
        export class ModeController {
            private controls: Controls;
            private fieldName: string;

            constructor(fieldName: string) {
                this.fieldName = fieldName;
                this.controls = new Controls(fieldName);
            }

            public priorities(): Array {
                return [
                    "施設選択表示",
                    "事業者選択",
                    "他特例施設選択",
                    "除外施設選択"
                ];
            }

            public Properties() {
                return new UZA.CommonChildDiv(this.fieldName);
            }

            public 施設選択表示() {
                return new Modes.施設選択表示(this.controls);
            }

            public 事業者選択() {
                return new Modes.事業者選択(this.controls);
            }

            public 他特例施設選択() {
                return new Modes.他特例施設選択(this.controls);
            }

            public 除外施設選択() {
                return new Modes.除外施設選択(this.controls);
            }
        }

        export module Modes {

            export class 施設選択表示 {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public 表示する(): void {
                    this.controls.radShisetsuShurui().displayNone = false;
                }

                public 表示しない(): void {
                    this.controls.radShisetsuShurui().displayNone = true;
                }
            }

            export class 事業者選択 {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public 表示する(): void {
                    this.controls.btnJigyoshaInputGuide().displayNone = false;
                }

                public 表示しない(): void {
                    this.controls.btnJigyoshaInputGuide().displayNone = true;
                }
            }

            export class 他特例施設選択 {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public 表示する(): void {
                    this.controls.btnOtherTokureiShisetsuInputGuide().displayNone = false;
                }

                public 表示しない(): void {
                    this.controls.btnOtherTokureiShisetsuInputGuide().displayNone = true;
                }
            }

            export class 除外施設選択 {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public 表示する(): void {
                    this.controls.btnJogaiShisetsuInputGuide().displayNone = false;
                }

                public 表示しない(): void {
                    this.controls.btnJogaiShisetsuInputGuide().displayNone = true;
                }
            }

        }
    }
}
