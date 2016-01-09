/// <reference path='ShokanShinseiList_Design.ts' />
module DBC
{
    export module ShokanShinseiList
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
            
            
            public priorities(): Array {
                return [
                    "DisplayType"
                ];
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

                public shokai(): void {
                    this.controls.txtServiceYM().displayNone = true;
                    this.controls.btnAdd().displayNone = true;
                    this.controls.line().displayNone = true;
                    this.controls.dgShinseiList().marginRight=40;
                    this.controls.ShokanShinseiList().width = "G12";
                    
                    this.controls.dgShinseiList().readOnly = true;
                    this.controls.dgShinseiList().width = 510;
                    
                    var gridSetting = this.controls.dgShinseiList().gridSetting;
                    
                    gridSetting.isShowSelectButtonColumn = true;
                    gridSetting.isShowModifyButtonColumn = false;
                    gridSetting.isShowDeleteButtonColumn = false;

                    this.controls.dgShinseiList().gridSetting = gridSetting;

                    this.controls.dgShinseiList()._control.afterPropertiesSet();
                }

                public toroku(): void {
                    this.controls.txtServiceYM().displayNone = false;
                    this.controls.btnAdd().displayNone = false;
                    this.controls.line().displayNone = false;
                    
                    this.controls.ShokanShinseiList().width = "G12";
                    
                    this.controls.dgShinseiList().readOnly = true;
                    this.controls.dgShinseiList().width = 580;
                    
                    var gridSetting = this.controls.dgShinseiList().gridSetting;
                    
                    gridSetting.isShowSelectButtonColumn = false;
                    gridSetting.isShowModifyButtonColumn = true;
                    gridSetting.isShowDeleteButtonColumn = true;

                    this.controls.dgShinseiList().gridSetting = gridSetting;

                    this.controls.dgShinseiList()._control.afterPropertiesSet();
                }

            }
        }
    }
}

module DBC
{
    export module ShokanShinseiList
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

