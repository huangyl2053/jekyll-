/// <reference path='IryohokenRirekiCommonChildDiv_Design.ts' />
module DBA
{
    export module IryohokenRirekiCommonChildDiv
    {
        export class ModeController {
            private controls: Controls;
            private fieldName: string;

            constructor(fieldName: string) {
                this.fieldName = fieldName;
                this.controls = new Controls(fieldName);
            }

            public priorities(): Array<string> {
                return [
                    "State"
                ];
            }
            
            public State() {
                return new Modes.State(this.controls);
            }
            
            public Properties() {
                return new UZA.CommonChildDiv(this.fieldName);
            }

            public PublicProperties() {
                return new PublicProperties(this.fieldName);
            }
        }

        export module Modes {
        	export class State {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public 照会(): void {
                    this.controls.tbdKanyubi().readOnly = true;
                    this.controls.tbdDattabi().readOnly = true;
                    this.controls.ddlSyubetsu().disabled = true;
                    this.controls.txtHokensyaKodo().readOnly = true;
                    this.controls.txtHokensyaMeisho().readOnly = true;
                    this.controls.txtKigoBango().readOnly = true;
                    this.controls.btnIryohokenTsuika().visible = false;
                    this.controls.btnCancel().visible = false;
                    this.controls.btnIryohokenKakute().visible = false;
                    this.controls.dgIryohokenIchiran().gridSetting.isShowSelectButtonColumn = true;
                    this.controls.dgIryohokenIchiran().gridSetting.isShowModifyButtonColumn = false;
                    this.controls.dgIryohokenIchiran().gridSetting.isShowDeleteButtonColumn = false;
                    
                }

                public 追加(): void {
                    this.controls.tbdKanyubi().readOnly = false;
                    this.controls.tbdDattabi().readOnly = false;
                    this.controls.ddlSyubetsu().disabled = false;
                    this.controls.txtHokensyaKodo().readOnly = false;
                    this.controls.txtHokensyaMeisho().readOnly = false;
                    this.controls.txtKigoBango().readOnly = false;
                    this.controls.btnIryohokenTsuika().visible = true;
                    this.controls.btnCancel().visible = true;
                    this.controls.btnIryohokenKakute().visible = true;
                    this.controls.btnIryohokenTsuika().disabled = false;
                    this.controls.btnCancel().disabled = false;
                    this.controls.btnIryohokenKakute().disabled = false;
                    this.controls.dgIryohokenIchiran().gridSetting.isShowSelectButtonColumn = false;
                    this.controls.dgIryohokenIchiran().gridSetting.isShowModifyButtonColumn = true;
                    this.controls.dgIryohokenIchiran().gridSetting.isShowDeleteButtonColumn = true;
                }

                public 修正(): void {
                    this.controls.tbdKanyubi().readOnly = false;
                    this.controls.tbdDattabi().readOnly = false;
                    this.controls.ddlSyubetsu().disabled = false;
                    this.controls.txtHokensyaKodo().readOnly = false;
                    this.controls.txtHokensyaMeisho().readOnly = false;
                    this.controls.txtKigoBango().readOnly = false;
                    this.controls.btnIryohokenTsuika().visible = true;
                    this.controls.btnCancel().visible = true;
                    this.controls.btnIryohokenKakute().visible = true;
                    this.controls.btnIryohokenTsuika().disabled = false;
                    this.controls.btnCancel().disabled = false;
                    this.controls.btnIryohokenKakute().disabled = false;
                    this.controls.dgIryohokenIchiran().gridSetting.isShowSelectButtonColumn = false;
                    this.controls.dgIryohokenIchiran().gridSetting.isShowModifyButtonColumn = true;
                    this.controls.dgIryohokenIchiran().gridSetting.isShowDeleteButtonColumn = true;
                }

                public 削除(): void {
                    this.controls.tbdKanyubi().readOnly = true;
                    this.controls.tbdDattabi().readOnly = true;
                    this.controls.ddlSyubetsu().disabled = true;
                    this.controls.txtHokensyaKodo().readOnly = true;
                    this.controls.txtHokensyaMeisho().readOnly = true;
                    this.controls.txtKigoBango().readOnly = true;
                    this.controls.btnIryohokenKakute().disabled = true;
                    this.controls.btnIryohokenTsuika().visible = true;
                    this.controls.btnCancel().visible = true;
                    this.controls.btnIryohokenKakute().visible = true;
                    this.controls.btnIryohokenTsuika().disabled = false;
                    this.controls.btnCancel().disabled = false;
                    this.controls.btnIryohokenKakute().disabled = false;
                    this.controls.dgIryohokenIchiran().gridSetting.isShowSelectButtonColumn = false;
                    this.controls.dgIryohokenIchiran().gridSetting.isShowModifyButtonColumn = true;
                    this.controls.dgIryohokenIchiran().gridSetting.isShowDeleteButtonColumn = true;
                }
            }
        }
    }
}

module DBA
{
    export module IryohokenRirekiCommonChildDiv
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

