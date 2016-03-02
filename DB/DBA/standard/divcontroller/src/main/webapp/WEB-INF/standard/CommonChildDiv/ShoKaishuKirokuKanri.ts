/// <reference path='ShoKaishuKirokuKanri_Design.ts' />
module DBA
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
            
            public priorities(): Array {
                return [
                    "DisplayMode"
                ];
            }
            
            public DisplayMode() {
                return new Modes.DisplayMode(this.controls);
            }

            public Properties() {
                return new UZA.CommonChildDiv(this.fieldName);
            }

            public PublicProperties() {
                return new PublicProperties(this.fieldName);
            }
        }

        export module Modes {
        	export class DisplayMode {
        		private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }
                
                public shokai(): void {
                    this.controls.panelKoufuList().displayNone = false;
                    this.controls.dgKoufuKaishu().gridSetting.isShowSelectButtonColumn = true;
                    this.controls.dgKoufuKaishu().gridSetting.isShowModifyButtonColumn = false;
                    this.controls.dgKoufuKaishu().gridSetting.isShowDeleteButtonColumn = false;
                    this.controls.dgKoufuKaishu().gridSetting.isShowRowState = false;
                    this.controls.dgKoufuKaishu()._control.afterPropertiesSet();
                    this.controls.panelInput().displayNone = true;
                }
                
                public shokai_selected(): void {
                    this.controls.panelKoufuList().displayNone = false;
                    this.controls.dgKoufuKaishu().gridSetting.isShowSelectButtonColumn = true;
                    this.controls.dgKoufuKaishu().gridSetting.isShowModifyButtonColumn = false;
                    this.controls.dgKoufuKaishu().gridSetting.isShowDeleteButtonColumn = false;
                    this.controls.dgKoufuKaishu().gridSetting.isShowRowState = false;
                    this.controls.dgKoufuKaishu()._control.afterPropertiesSet();
                    this.controls.panelInput().displayNone = false;
                }
                
                public koshin(): void {
                    this.controls.panelKoufuList().displayNone = false;
                    this.controls.dgKoufuKaishu().gridSetting.isShowSelectButtonColumn = false;
                    this.controls.dgKoufuKaishu().gridSetting.isShowModifyButtonColumn = true;
                    this.controls.dgKoufuKaishu().gridSetting.isShowDeleteButtonColumn = true;
                    this.controls.dgKoufuKaishu().gridSetting.isShowRowState = true;
                    this.controls.dgKoufuKaishu()._control.afterPropertiesSet();
                    this.controls.panelInput().displayNone = false;
                }
			}

        	
        }
    }
}

module DBA
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

