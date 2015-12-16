/// <reference path='ShoKaishuKirokuKanri_Design.ts' />
module DBZ
{
    export module ShoKaishuKirokuKanri
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
        
              // �Ɖ�[�h
              export class ModeA {
                private controls: Controls;
                constructor(controls: Controls) {
                    this.controls = controls;
                }

                 public SyoKai(): void {
                  
                    this.controls.panelInput().displayNone = true;
                }
              
              
              }
              
              // �X�V���[�h
              export class ModeB {
                private controls: Controls;
                constructor(controls: Controls) {
                    this.controls = controls;
                }

                 public Update(): void {
                     this.controls.panelInput().displayNone = false;
                     
                     this.controls.btnCancel().disabled = true;
                     this.controls.btnConfirm().disabled = true;
                     var gridSetting = this.controls.dgKoufuKaishu().gridSetting;
                   	gridSetting.isShowSelectButtonColumn = false;
                  
                }

              }
              
              

        
        //////////////////////////////////
        }
    }
}

module DBZ
{
    export module ShoKaishuKirokuKanri
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

