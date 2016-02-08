/// <reference path='JigyoshaNyuryokuGudieCommonChildDiv_Design.ts' />
module DBZ
{
    export module JigyoshaNyuryokuGudieCommonChildDiv
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

                public ServiceJigyoshaMode(): void {
                    this.controls.ServiceJigyosha().displayNone = false;
                    this.controls.OtherTokureiShisetsu().displayNone = true;
                    var gridSetting = this.controls.dgJigyoshaItiran().gridSetting;
                    gridSetting.isShowSelectButtonColumn = true;
                    gridSetting.isShowModifyButtonColumn = false;
                    gridSetting.isShowDeleteButtonColumn = false;
                    this.controls.dgJigyoshaItiran().gridSetting = gridSetting;
                    this.controls.dgJigyoshaItiran()._control.afterPropertiesSet();
                }

                public OtherTokureiShisetsuMode(): void {
                    this.controls.ServiceJigyosha().displayNone = true;
                    this.controls.OtherTokureiShisetsu().displayNone = false;
                    var gridSetting = this.controls.dgJigyoshaItiran().gridSetting;
                    gridSetting.isShowSelectButtonColumn = true;
                    gridSetting.isShowModifyButtonColumn = false;
                    gridSetting.isShowDeleteButtonColumn = false;
                    this.controls.dgJigyoshaItiran().gridSetting = gridSetting;
                    this.controls.dgJigyoshaItiran()._control.afterPropertiesSet();
                }

                public ShitekiJogaiShisetsuMode(): void {
                    this.controls.ServiceJigyosha().displayNone= true;
                    this.controls.OtherTokureiShisetsu().displayNone = true;
                    var gridSetting = this.controls.dgJigyoshaItiran().gridSetting;
                    gridSetting.isShowSelectButtonColumn = true;
                    gridSetting.isShowModifyButtonColumn = false;
                    gridSetting.isShowDeleteButtonColumn = false;
                    this.controls.dgJigyoshaItiran().gridSetting = gridSetting;
                    this.controls.dgJigyoshaItiran()._control.afterPropertiesSet();
                }

                public サービス事業者修正削除モード(): void {
                    this.controls.ServiceJigyosha().displayNone = false;
                    this.controls.OtherTokureiShisetsu().displayNone = true;
                    var gridSetting = this.controls.dgJigyoshaItiran().gridSetting;
                    gridSetting.isShowSelectButtonColumn = false;
                    gridSetting.isShowModifyButtonColumn = true;
                    gridSetting.isShowDeleteButtonColumn = true;
                    this.controls.dgJigyoshaItiran().gridSetting = gridSetting;
                    this.controls.dgJigyoshaItiran()._control.afterPropertiesSet();
                }
                
                public その他特例施設修正削除モード(): void {
                    this.controls.ServiceJigyosha().displayNone = true;
                    this.controls.OtherTokureiShisetsu().displayNone = false;
                    var gridSetting = this.controls.dgJigyoshaItiran().gridSetting;
                    gridSetting.isShowSelectButtonColumn = false;
                    gridSetting.isShowModifyButtonColumn = true;
                    gridSetting.isShowDeleteButtonColumn = true;
                    this.controls.dgJigyoshaItiran().gridSetting = gridSetting;
                    this.controls.dgJigyoshaItiran()._control.afterPropertiesSet();
                }
                
                public 適用除外施設修正削除モード(): void {
                    this.controls.ServiceJigyosha().displayNone = true;
                    this.controls.OtherTokureiShisetsu().displayNone = true;
                    var gridSetting = this.controls.dgJigyoshaItiran().gridSetting;
                    gridSetting.isShowSelectButtonColumn = false;
                    gridSetting.isShowModifyButtonColumn = true;
                    gridSetting.isShowDeleteButtonColumn = true;
                    this.controls.dgJigyoshaItiran().gridSetting = gridSetting;
                    this.controls.dgJigyoshaItiran()._control.afterPropertiesSet();
                }
            }
        }
    }
}

module DBZ
{
    export module JigyoshaNyuryokuGudieCommonChildDiv
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

