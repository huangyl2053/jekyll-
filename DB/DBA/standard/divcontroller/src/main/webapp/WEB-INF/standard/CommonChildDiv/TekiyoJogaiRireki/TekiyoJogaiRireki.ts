/// <reference path='TekiyoJogaiRireki_Design.ts' />
module DBA
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

            public Properties() {
                return new UZA.CommonChildDiv(this.fieldName);
            }

            public PublicProperties() {
                return new PublicProperties(this.fieldName);
            }

            public priorities(): Array<string> {
                return [
                    "DisplayMode"
                ];
            }
            
            public DisplayMode() {
                return new Modes.DisplayMode(this.controls);
            }

        }

        export module Modes {
              
              export class DisplayMode {
                private controls: Controls;
                
                constructor(controls: Controls) {
                    this.controls = controls;
                }

                 public 適用登録モード(): void {
                    this.controls.btnAdd().displayNone = false;
                    this.controls.panelTekiyoRireki().displayNone = false;
                    this.controls.panelTekiyoInput().displayNone = true;
                    this.controls.panelTekiyoJokaiTekiInput().displayNone = false;
                    this.controls.panelTekiyoJokaiKaiJyoInput().displayNone = true;
                    this.controls.btnInputClear().displayNone = false;
                    this.controls.btnKakutei().displayNone = false;
                    
                    var gridSetting = this.controls.datagridTekiyoJogai().gridSetting;
                    gridSetting.isShowSelectButtonColumn = false;
                    gridSetting.isShowModifyButtonColumn = false;
                    gridSetting.isShowDeleteButtonColumn = false;
                    gridSetting.isShowRowState = false;
                    
                    this.controls.datagridTekiyoJogai().gridSetting = gridSetting;
                    
                    //this.controls.datagridTekiyoJogai()._control.afterPropertiesSet();
                    this.controls.panelTekiyoInput().disabled = false;
                }

                 public 解除モード(): void {
                    this.controls.btnAdd().displayNone = true;
                    this.controls.panelTekiyoRireki().displayNone = false;
                    this.controls.panelTekiyoInput().displayNone = true;
                    this.controls.panelTekiyoJokaiTekiInput().displayNone = true;
                    this.controls.panelTekiyoJokaiKaiJyoInput().displayNone = false;
                    this.controls.btnInputClear().displayNone = false;
                    this.controls.btnKakutei().displayNone = false;
                    
                    var gridSetting = this.controls.datagridTekiyoJogai().gridSetting;
                    gridSetting.isShowSelectButtonColumn = false;
                    gridSetting.isShowModifyButtonColumn = false;
                    gridSetting.isShowDeleteButtonColumn = false;
                    gridSetting.isShowRowState = false;
                    
                    this.controls.datagridTekiyoJogai().gridSetting = gridSetting;
                    
                    //this.controls.datagridTekiyoJogai()._control.afterPropertiesSet();
                    this.controls.panelTekiyoInput().disabled = false;
                }

                 public 施設変更モード(): void {
                    this.controls.btnAdd().displayNone = true;
                    this.controls.panelTekiyoRireki().displayNone = true;
                    this.controls.panelTekiyoInput().displayNone = false;
                    this.controls.panelTekiyoJokaiTekiInput().displayNone = true;
                    this.controls.panelTekiyoJokaiKaiJyoInput().displayNone = true;
                    this.controls.btnInputClear().displayNone = false;
                    this.controls.btnKakutei().displayNone = false;
                    
                    var gridSetting = this.controls.datagridTekiyoJogai().gridSetting;
                    gridSetting.isShowSelectButtonColumn = false;
                    gridSetting.isShowModifyButtonColumn = false;
                    gridSetting.isShowDeleteButtonColumn = false;
                    gridSetting.isShowRowState = false;
                    
                    this.controls.datagridTekiyoJogai().gridSetting = gridSetting;
                    
                    //this.controls.datagridTekiyoJogai()._control.afterPropertiesSet();
                    this.controls.panelTekiyoInput().disabled = true;
                }

                 public 訂正履歴モード(): void {
                    this.controls.btnAdd().displayNone = false;
                    this.controls.panelTekiyoRireki().displayNone = false;
                    this.controls.panelTekiyoInput().displayNone = false;
                    this.controls.panelTekiyoJokaiTekiInput().displayNone = true;
                    this.controls.panelTekiyoJokaiKaiJyoInput().displayNone = true;
                    this.controls.btnInputClear().displayNone = false;
                    this.controls.btnKakutei().displayNone = false;
                    
                    var gridSetting = this.controls.datagridTekiyoJogai().gridSetting;
                    gridSetting.isShowSelectButtonColumn = false;
                    gridSetting.isShowModifyButtonColumn = true;
                    gridSetting.isShowDeleteButtonColumn = true;
                    gridSetting.isShowRowState = true;
                    
                    this.controls.datagridTekiyoJogai().gridSetting = gridSetting;
                    
                    //this.controls.datagridTekiyoJogai()._control.afterPropertiesSet();
                    this.controls.panelTekiyoInput().disabled = false;
                }

                 public 照会モード(): void {
                    this.controls.btnAdd().displayNone = true;
                    this.controls.panelTekiyoRireki().displayNone = false;
                    this.controls.panelTekiyoInput().displayNone = false;
                    this.controls.panelTekiyoJokaiTekiInput().displayNone = true;
                    this.controls.panelTekiyoJokaiKaiJyoInput().displayNone = true;
                    this.controls.btnInputClear().displayNone = true;
                    this.controls.btnKakutei().displayNone = true;
                    
                    var gridSetting = this.controls.datagridTekiyoJogai().gridSetting;
                    gridSetting.isShowSelectButtonColumn = true;
                    gridSetting.isShowModifyButtonColumn = false;
                    gridSetting.isShowDeleteButtonColumn = false;
                    gridSetting.isShowRowState = false;
                    
                    this.controls.datagridTekiyoJogai().gridSetting = gridSetting;
                    
                    //this.controls.datagridTekiyoJogai()._control.afterPropertiesSet();
                    this.controls.panelTekiyoInput().disabled = true;
                }
            }
        }
    }
}

module DBA
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

