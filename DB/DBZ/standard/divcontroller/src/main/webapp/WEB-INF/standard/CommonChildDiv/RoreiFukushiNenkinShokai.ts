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
            
            public ModeA() {
                return new Modes.ModeA(this.controls);
            }
			 public ModeB() {
                return new Modes.ModeB(this.controls);
            }
			 public ModeC() {
                return new Modes.ModeC(this.controls);
            }

            public Properties() {
                return new UZA.CommonChildDiv(this.fieldName);
            }

            public PublicProperties() {
                return new PublicProperties(this.fieldName);
            }
            
            public priorities(): Array<string> {
                return [
                    "ModeA","ModeB","ModeC"
                ];
            }
        }

        export module Modes {
        
              //èâä˙èÛë‘
              export class ModeA {
                private controls: Controls;
                constructor(controls: Controls) {
                    this.controls = controls;
                }

                 public init(): void {
                  
                    this.controls.panelInput().displayNone = true;
                }
              
              
              }
              
              
              export class ModeB {
                private controls: Controls;
                constructor(controls: Controls) {
                    this.controls = controls;
                }

                 public update(): void {
                     this.controls.panelRireki().displayNone = false;
                     this.controls.panelInput().displayNone = false;
                     
                     this.controls.txtStartDate().readOnly = false;
                     this.controls.txtEndDate().readOnly = false;
                     
					 this.controls.btnAdd().displayNone = false;
					 this.controls.datagridRireki().gridSetting.isShowSelectButtonColumn = true;
                     this.controls.datagridRireki().gridSetting.isShowModifyButtonColumn = true;
                     this.controls.datagridRireki().gridSetting.isShowDeleteButtonColumn = true;
                     this.controls.datagridRireki()._control.afterPropertiesSet();
                }
              
              
              }
              
			   export class ModeC {
                private controls: Controls;
                constructor(controls: Controls) {
                    this.controls = controls;
                }

                 public init(): void {
                     this.controls.panelRireki().displayNone = false;
                     this.controls.panelInput().displayNone = true;
					 this.controls.btnAdd().displayNone = true;					
					 this.controls.datagridRireki().gridSetting.isShowSelectButtonColumn = false;
                     this.controls.datagridRireki().gridSetting.isShowModifyButtonColumn = false;
                     this.controls.datagridRireki().gridSetting.isShowDeleteButtonColumn = false;
                     this.controls.datagridRireki()._control.afterPropertiesSet();
                }
                
                


                 public update(): void {
                     this.controls.panelRireki().displayNone = false;
                     this.controls.panelInput().displayNone = false;
                     
                     this.controls.txtStartDate().readOnly = false;
                     this.controls.txtEndDate().readOnly = false;
                     
					 this.controls.btnAdd().displayNone = false;
					 this.controls.datagridRireki().gridSetting.isShowSelectButtonColumn = true;
                     this.controls.datagridRireki().gridSetting.isShowModifyButtonColumn = true;
                     this.controls.datagridRireki().gridSetting.isShowDeleteButtonColumn = true;
                     this.controls.datagridRireki()._control.afterPropertiesSet();
                }
              
              
              }

        
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

