/// <reference path="KaigoAtenaInfo_Design.ts" />

// 共有子Divモード記述TypeScriptソースです。

module DBZ
{
    export module KaigoAtenaInfo {

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

            public priorities(): Array<string> {
                return [
                    "DisplayType",
                    "BtnDainoninDisplay",
                    "BtnSofusakiDisplay",
                    "BtnKozaDisplay",
                    "BtnSetaiDisplay",
                    "BtnEltaxDisplay",
                    "BtnAtesakiDisplay"
                ];
            }

            public DisplayType() {
                return new Modes.DisplayType(this.controls);
            }

            public BtnDainoninDisplay() {
                return new Modes.BtnDainoninDisplay(this.controls);
            }

            public BtnSofusakiDisplay() {
                return new Modes.BtnSofusakiDisplay(this.controls);
            }

            public BtnKozaDisplay() {
                return new Modes.BtnKozaDisplay(this.controls);
            }

            public BtnSetaiDisplay() {
                return new Modes.BtnSetaiDisplay(this.controls);
            }

            public BtnEltaxDisplay() {
                return new Modes.BtnEltaxDisplay(this.controls);
            }

            public BtnAtesakiDisplay() {
                return new Modes.BtnAtesakiDisplay(this.controls);
            }
        }

        export module Modes {


            export class DisplayType {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                
                public 一行タイプ() {
                    this.controls.atenaInfo().DisplayType().一行タイプ();
                }

                public 三行タイプ() {
                    this.controls.atenaInfo().DisplayType().三行タイプ();
                }

                public 指定無し() {
                    this.controls.atenaInfo().DisplayType().指定無し();
                }
            }
            
            export class BtnDainoninDisplay {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }
                
                public 指定無し() {
                    this.controls.atenaInfo().BtnDainoninDisplay().指定無し();
                }
                public 表示しない() {
                    this.controls.atenaInfo().BtnDainoninDisplay().表示しない();
                }
            
            }

            export class BtnSofusakiDisplay {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }
                
                
                public 指定無し() {
                    this.controls.atenaInfo().BtnSofusakiDisplay().指定無し();
                }
                public 表示しない() {
                    this.controls.atenaInfo().BtnSofusakiDisplay().表示しない();
                }

            }

            export class BtnKozaDisplay {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }
                
                
                public 指定無し() {
                    this.controls.atenaInfo().BtnKozaDisplay().指定無し();
                }
                public 表示しない() {
                    this.controls.atenaInfo().BtnKozaDisplay().表示しない();
                }

            }

            export class BtnSetaiDisplay {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }
                
                
                public 指定無し() {
                    this.controls.atenaInfo().BtnSetaiDisplay().指定無し();
                }
                public 表示しない() {
                    this.controls.atenaInfo().BtnSetaiDisplay().表示しない();
                }

            }

            export class BtnEltaxDisplay {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                
                public 指定無し() {
                    this.controls.atenaInfo().BtnEltaxDisplay().指定無し();
                }
                public 表示しない() {
                    this.controls.atenaInfo().BtnEltaxDisplay().表示しない();
                }
            }

            export class BtnAtesakiDisplay {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }
                
                
                public 指定無し() {
                    this.controls.atenaInfo().BtnAtesakiDisplay().指定無し();
                }
                public 表示しない() {
                    this.controls.atenaInfo().BtnAtesakiDisplay().表示しない();
                }

            }
        }
    }
}

module DBZ {

    export module KaigoAtenaInfo {

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




