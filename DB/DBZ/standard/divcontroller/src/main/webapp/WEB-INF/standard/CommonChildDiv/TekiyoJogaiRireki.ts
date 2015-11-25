/// <reference path='TekiyoJogaiRireki_Design.ts' />
module DBZ
{
    export module TekiyoJogaiRireki
    {
        export class ModeController {
            private controls: Controls;
            private fieldName: string;

            constructor(fieldName: string) {
                this.fieldName = fieldName;
                this.controls = new Controls(fieldName);
            }
            
            /////////////////////////////
            public ModeA() {
                return new Modes.ModeA(this.controls);
            }
            
            public ModeB() {
                return new Modes.ModeB(this.controls);
            }
            
            public ModeC() {
                return new Modes.ModeC(this.controls);
            }
            
            public ModeD() {
                return new Modes.ModeD(this.controls);
            }
            ////////////////////////////

            public Properties() {
                return new UZA.CommonChildDiv(this.fieldName);
            }

            public PublicProperties() {
                return new PublicProperties(this.fieldName);
            }
            
            ////////////////////////////////////////////////////
            
            public priorities(): Array<string> {
                return [
                    "ModeA","ModeB","ModeC","ModeD"
                ];
            }
            ////////////////////////////////////////////////////
        }

        export module Modes {
        //////////////////////////////////
              //新規（適用）モード
              export class ModeA {
                private controls: Controls;
                constructor(controls: Controls) {
                    this.controls = controls;
                }

                 public Shinki(): void {
                  
                    this.controls.panelTekiyoJokaiTekiInput().displayNone = false;
                   
                    this.controls.panelTekiyoInput().displayNone = true;
                    this.controls.panelTekiyoJokaiKaiJyoInput().displayNone = true;
                    this.controls.btnKakutei().displayNone = false;
                }
              
              
              }
              
              //削除（解除）モード
              export class ModeB {
                private controls: Controls;
                constructor(controls: Controls) {
                    this.controls = controls;
                }


                 public Kaijo(): void {
                    this.controls.panelTekiyoJokaiTekiInput().displayNone = true;
                   
                    this.controls.panelTekiyoInput().displayNone = true;
                    this.controls.panelTekiyoJokaiKaiJyoInput().displayNone = false;
                    
                    this.controls.btnKakutei().displayNone = false;
                    this.controls.btnKakutei().disabled = false;
                }
              }
                
              //変更モード
              export class ModeC {
                private controls: Controls;
                constructor(controls: Controls) {
                    this.controls = controls;
                }


                 public HenKo(): void {
                    this.controls.panelTekiyoJokaiTekiInput().displayNone = true;
                   
                    this.controls.panelTekiyoInput().displayNone = false;
                    this.controls.panelTekiyoJokaiKaiJyoInput().displayNone = true;
                    this.controls.btnKakutei().disabled = true;
                    
                    this.controls.btnKakutei().displayNone = false;
                    this.controls.btnKakutei().disabled = true;
                }
                
              }
              //表示モード
              export class ModeD {
                private controls: Controls;
                constructor(controls: Controls) {
                    this.controls = controls;
                }


                 public Hyoji(): void {
                    this.controls.panelTekiyoJokaiTekiInput().displayNone = true;
                    this.controls.panelTekiyoInput().displayNone = true;
                    this.controls.panelTekiyoJokaiKaiJyoInput().displayNone = true;
                    
                    this.controls.btnKakutei().displayNone = true;
                }

              
              
              }

        
        //////////////////////////////////
        }
    }
}

module DBZ
{
    export module TekiyoJogaiRireki
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

