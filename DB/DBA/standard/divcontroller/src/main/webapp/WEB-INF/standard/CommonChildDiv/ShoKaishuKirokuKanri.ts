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
                    this.controls.dgKoufuKaishu()._control.afterPropertiesSet();
                    this.controls.panelInput().displayNone = true;
                }

                public shokai_selected(): void {
                    this.controls.panelKoufuList().displayNone = false;
                    this.controls.dgKoufuKaishu().gridSetting.isShowSelectButtonColumn = true;
                    this.controls.dgKoufuKaishu().gridSetting.isShowModifyButtonColumn = false;
                    this.controls.dgKoufuKaishu().gridSetting.isShowDeleteButtonColumn = false;
                    this.controls.dgKoufuKaishu()._control.afterPropertiesSet();
                    this.controls.panelInput().displayNone = false;
                    this.controls.txtKoufuType().disabled = true;
                    this.controls.txtKoufuDate().disabled = true;
                    this.controls.txtYukouKigen().disabled = true;
                    this.controls.ddlKoufuJiyu().disabled = true;
                    this.controls.txaKoufuRiyu().disabled = true;
                    this.controls.txtKaisyuDate().disabled = true;
                    this.controls.ddlKaisyuJiyu().disabled = true;
                    this.controls.txaKaishuRiyu().disabled = true;
                    this.controls.btnCancel().displayNone = true;
                    this.controls.btnConfirm().displayNone = true;
                }

                public koshin(): void {
                    this.controls.panelKoufuList().displayNone = false;
                    this.controls.dgKoufuKaishu().gridSetting.isShowSelectButtonColumn = false;
                    this.controls.dgKoufuKaishu().gridSetting.isShowModifyButtonColumn = true;
                    this.controls.dgKoufuKaishu().gridSetting.isShowDeleteButtonColumn = true;
                    this.controls.dgKoufuKaishu()._control.afterPropertiesSet();
                    this.controls.panelInput().displayNone = false;
                    this.controls.txtKoufuType().disabled = true;
                    this.controls.txtKoufuDate().disabled = false;
                    this.controls.txtYukouKigen().disabled = false;
                    this.controls.ddlKoufuJiyu().disabled = false;
                    this.controls.txaKoufuRiyu().disabled = false;
                    this.controls.txtKaisyuDate().disabled = false;
                    this.controls.ddlKaisyuJiyu().disabled = false;
                    this.controls.txaKaishuRiyu().disabled = false;
                    this.controls.btnCancel().disabled = false;
                    this.controls.btnConfirm().disabled = false;
                }

                public sakujyo(): void {
                    this.controls.panelKoufuList().displayNone = false;
                    this.controls.dgKoufuKaishu().gridSetting.isShowSelectButtonColumn = false;
                    this.controls.dgKoufuKaishu().gridSetting.isShowModifyButtonColumn = true;
                    this.controls.dgKoufuKaishu().gridSetting.isShowDeleteButtonColumn = true;
                    this.controls.dgKoufuKaishu()._control.afterPropertiesSet();
                    this.controls.panelInput().displayNone = false;
                    this.controls.txtKoufuType().disabled = true;
                    this.controls.txtKoufuDate().disabled = true;
                    this.controls.txtYukouKigen().disabled = true;
                    this.controls.ddlKoufuJiyu().disabled = true;
                    this.controls.txaKoufuRiyu().disabled = true;
                    this.controls.txtKaisyuDate().disabled = true;
                    this.controls.ddlKaisyuJiyu().disabled = true;
                    this.controls.txaKaishuRiyu().disabled = true;
                    this.controls.btnCancel().disabled = false;
                    this.controls.btnConfirm().disabled = false;
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

