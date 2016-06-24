/// <reference path='KogakuShinseiList_Design.ts' />
module DBC
{
    export module KogakuShinseiList
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

                //照会モード
                public shokai(): void {
                    this.controls.txtServiceYM().disabled = true;
                    this.controls.txtShokisai().disabled = true;
                    this.controls.btnShinseiJohoTsuika().disabled = true;
                    this.controls.btnTaishosyaJoho().disabled = true;
                    this.controls.lin1().disabled = true;
                    
                    this.controls.txtServiceYMFrom().disabled = true;
                    this.controls.txtServiceYMTo().disabled = true;
                    this.controls.btnKensaku().disabled = true;
                    
                    //DataGrid(修正・削除ボタン)
                    var gridSetting = this.controls.dgShinseiJoho().gridSetting;
                    gridSetting.isShowModifyButtonColumn = false;
                    gridSetting.isShowDeleteButtonColumn = false;
                    
                    this.controls.dgShinseiJoho().gridSetting = gridSetting;
                    this.controls.dgShinseiJoho()._control.afterPropertiesSet();
                }
                
                //登録モード
                public toroku(): void {
                    this.controls.txtServiceYM().disabled = false;
                    this.controls.txtShokisai().disabled = true;
                    this.controls.btnShinseiJohoTsuika().disabled = false;
                    this.controls.btnTaishosyaJoho().disabled = false;
                    this.controls.lin1().disabled = false;
                    
                    this.controls.txtServiceYMFrom().disabled = false;
                    this.controls.txtServiceYMTo().disabled = false;
                    this.controls.btnKensaku().disabled = false;
                    
                    //DataGrid(修正・削除ボタン)
                    var gridSetting = this.controls.dgShinseiJoho().gridSetting;
                    gridSetting.isShowModifyButtonColumn = true;
                    gridSetting.isShowDeleteButtonColumn = true;
                    
                    this.controls.dgShinseiJoho().gridSetting = gridSetting;
                    this.controls.dgShinseiJoho()._control.afterPropertiesSet();
                }
            }
        }
    }
}

module DBC
{
    export module KogakuShinseiList
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

