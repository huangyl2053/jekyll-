/// <reference path='KaigoShikakuKihon_Design.ts' />
module DBZ {
    export module KaigoShikakuKihon {
        export class ModeController {
            private controls: Controls;
            private fieldName: string;

            constructor(fieldName: string) {
                this.fieldName = fieldName;
                this.controls = new Controls(fieldName);
            }

            public 連絡先ボタンを() {
                return new Modes.連絡先ボタンを(this.controls);
            }
            
            public 被保履歴ボタンを() {
                return new Modes.被保履歴ボタンを(this.controls);
            }

            public 認定履歴ボタンを() {
                return new Modes.認定履歴ボタンを(this.controls);
            }
        }

        export module Modes {

            export class 連絡先ボタンを {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public 表示する(): void {
                    this.controls.btnRenrakusaki().displayNone = false;
                }

                public 表示しない(): void {
                    this.controls.btnRenrakusaki().displayNone = true;
                }
            }

            export class 被保履歴ボタンを {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public 表示する(): void {
                    this.controls.btnHihoRireki().displayNone = false;
                }
                
                public 表示しない(): void {
                    this.controls.btnHihoRireki().displayNone = true;
                }
            }

            export class 認定履歴ボタンを {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public 表示する(): void {
                    this.controls.btnNinteiRireki().displayNone = false;
                }
                
                public 表示しない(): void {
                    this.controls.btnNinteiRireki().displayNone = true;
                }
            }
        }
    }

}




