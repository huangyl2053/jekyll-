/// <reference path='JogaiShinsainJoho_Design.ts' />
module DBZ
{
    export module JogaiShinsainJoho
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
            public ShoriType() {
                return new Modes.ShoriType(this.controls);
            }
        }

        export module Modes {

            export class ShoriType {
                
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public Input(): void {
                    
                    this.controls.btnShinkiTsuika().disabled = false;
                    var gridSetting = this.controls.dgShinsakaiIinIchiran().gridSetting;

                    gridSetting.isShowDeleteButtonColumn = true;
                    this.controls.txtShinsakaiIinCode().readOnly = false;
                    this.controls.btnShinsakaiIinGuide().disabled = false;
                    this.controls.btnToroku().disabled = false;
                    this.controls.btnShinkiTsuika().disabled = false;
                    this.controls.btnKakutei().disabled = false;
                    this.controls.dgShinsakaiIinIchiran().gridSetting = gridSetting;
                    this.controls.dgShinsakaiIinIchiran()._control.afterPropertiesSet();
                }
                
                public Shokai(): void {
                    var gridSetting = this.controls.dgShinsakaiIinIchiran().gridSetting;
                    gridSetting.isShowDeleteButtonColumn = false;
                    this.controls.txtShinsakaiIinCode().readOnly = true;
                    this.controls.btnShinsakaiIinGuide().disabled = true;
                    this.controls.btnToroku().disabled = true;
                    this.controls.btnShinkiTsuika().disabled = true;
                    this.controls.btnKakutei().disabled = true;
                    this.controls.dgShinsakaiIinIchiran().gridSetting = gridSetting;
                    this.controls.dgShinsakaiIinIchiran()._control.afterPropertiesSet();

                }
            }
        }
    }
}

module DBZ
{
    export module JogaiShinsainJoho
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