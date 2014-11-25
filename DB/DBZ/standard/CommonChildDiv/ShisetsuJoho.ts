/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

/// <reference path='ShisetsuJoho_Design.ts' />
module DBZ {
    export module ShisetsuJoho {
        export class ModeController {
            private controls: Controls;
            private fieldName: string;

            constructor(fieldName: string) {
                this.fieldName = fieldName;
                this.controls = new Controls(fieldName);
            }

            public priorities(): Array {
                return [
                    "台帳種別",
                    "施設種類",
                    "入力補助"
                ];
            }

            public Properties() {
                return new UZA.CommonChildDiv(this.fieldName);
            }

            public 台帳種別() {
                return new Modes.台帳種別(this.controls);
            }

            public 施設種類() {
                return new Modes.施設種類(this.controls);
            } 

            public 入力補助() {
                return new Modes.入力補助(this.controls);
            }

        }

        export module Modes {


            export class 台帳種別 {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public 台帳種別表示する(): void {

                    this.controls.ddlDaichoShubetsu().displayNone = false;

                }

                public 台帳種別非表示する(): void {

                    this.controls.ddlDaichoShubetsu().displayNone = true;
                }
            }

            
            export class 施設種類 {
                private controls: Controls;


                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public 施設種類を表示する(): void {
                    this.controls.radShisetsuShurui().displayNone = false;                    
                }

                public 施設種類を表示しない(): void {
                    this.controls.radShisetsuShurui().displayNone = true;
                }

           }


            export class 入力補助 {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public 事業者を表示する(): void {
                    this.controls.btnJigyoshaInputGuide().displayNone = false;
                    this.controls.btnOtherTokureiShisetsuInputGuide().displayNone = true;
                    this.controls.btnJogaiShisetsuInputGuide().displayNone = true;
                }

                public 他特例施設を表示する(): void {
                    this.controls.btnJigyoshaInputGuide().displayNone = true;
                    this.controls.btnOtherTokureiShisetsuInputGuide().displayNone = false;
                    this.controls.btnJogaiShisetsuInputGuide().displayNone = true;
                }

                public 除外施設を表示する(): void {
                    this.controls.btnJigyoshaInputGuide().displayNone = true;
                    this.controls.btnOtherTokureiShisetsuInputGuide().displayNone = true;
                    this.controls.btnJogaiShisetsuInputGuide().displayNone = false;
                }
            }

        }
    }
}


module DBZ {

    export module ShisetsuJoho {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            }

        }
    }
}




