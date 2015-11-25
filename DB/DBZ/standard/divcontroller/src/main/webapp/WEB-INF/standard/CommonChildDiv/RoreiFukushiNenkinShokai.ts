/// <reference path='RoreiFukushiNenkinShokai_Design.ts' />
module DBZ
{
    export module RoreiFukushiNenkinShokai
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
                    "ModeA","ModeB"
                ];
            }
            ////////////////////////////////////////////////////
        }

        export module Modes {
        
        //////////////////////////////////
              //初期状態
              export class ModeA {
                private controls: Controls;
                constructor(controls: Controls) {
                    this.controls = controls;
                }

                 public init(): void {
                  
                    this.controls.panelInput().displayNone = true;
                }
              
              
              }
              
              //更新モード
              export class ModeB {
                private controls: Controls;
                constructor(controls: Controls) {
                    this.controls = controls;
                }


                 public update(): void {
                     this.controls.panelRireki().displayNone = true;
                     this.controls.panelInput().displayNone = false;
                     
                     this.controls.txtStartDate().readOnly = false;
                     this.controls.txtEndDate().readOnly = false;
                }

              
              
              }

        
        //////////////////////////////////
        
        }
    }
}

module DBZ
{
    export module RoreiFukushiNenkinShokai
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

