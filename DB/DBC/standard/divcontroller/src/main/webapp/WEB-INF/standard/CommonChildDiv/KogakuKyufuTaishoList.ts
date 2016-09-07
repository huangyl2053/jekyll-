/// <reference path='KogakuKyufuTaishoList_Design.ts' />
module DBC
{
    export module KogakuKyufuTaishoList
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
                    "DisplayMode",
                    "MeisaiGokeiKubunMode"
                ];
            }

            public DisplayMode() {
                return new Modes.DisplayMode(this.controls);
            }
            public MeisaiGokeiKubunMode() {
                return new Modes.MeisaiGokeiKubunMode(this.controls);
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
                    this.controls.btnTsuika().visible = false;
                    this.controls.MeisaiGokeiHenshuPanel().visible = false;
                    //this.controls.rdbMisaiGkeiKbun().disabled = true;
                    //this.controls.txtJgyoshaCode().disabled = true;
                    //this.controls.btnJgyosha().disabled = true;
                    //this.controls.txtJgyoshaName().disabled = true;
                    //this.controls.txtServiceSyurui().disabled = true;
                    //this.controls.btnServiceSyurui().disabled = true;
                    //this.controls.btnServiceSyurui().disabled = true;
                    //this.controls.txtServiceSyuruiName().disabled = true;
                    //this.controls.txtHyoGkei().disabled = true;
                    //this.controls.txtRiyoshafutanGokei().disabled = true;
                    //this.controls.txtSanteiKijunGaku().disabled = true;
                    //this.controls.txtSiharaiZumiGaku().disabled = true;
                    //this.controls.lin1().disabled = true;
                    //this.controls.rdbTsukiOkure().disabled = true;
                    //this.controls.rabSetaiShotokuKubun().disabled = true;
                    //this.controls.rdbShotokuKubun().disabled = true;
                    //this.controls.rdbGassan().disabled = true;
                    //this.controls.rdbRoreiFukushiNenkin().disabled = true;
                    //this.controls.rdbRiyoshafutanDai2dankai().disabled = true;
                    //this.controls.rdbGekihenkanwaKubun().disabled = true;
                    //this.controls.btnkakutei().disabled = true;
                    //this.controls.btnTorikeshi().disabled = true;
                    
                    //DataGrid(修正・削除ボタン)
                    var gridSetting = this.controls.dgTaishoshaIchiran().gridSetting;
                    gridSetting.isShowModifyButtonColumn = false;
                    gridSetting.isShowDeleteButtonColumn = false;
                    gridSetting.columns[0].visible = false;
                    
                    this.controls.dgTaishoshaIchiran().gridSetting = gridSetting;
                    this.controls.dgTaishoshaIchiran()._control.afterPropertiesSet();
                }
                
                //登録モード
                public toroku(): void {
                    this.controls.btnTsuika().visible = true;
                    this.controls.MeisaiGokeiHenshuPanel().visible = true;
                    //this.controls.rdbMisaiGkeiKbun().disabled = true;
                    //this.controls.txtJgyoshaCode().disabled = true;
                    //this.controls.btnJgyosha().disabled = true;
                    //this.controls.txtJgyoshaName().disabled = true;
                    //this.controls.txtServiceSyurui().disabled = true;
                    //this.controls.btnServiceSyurui().disabled = true;
                    //this.controls.btnServiceSyurui().disabled = true;
                    //this.controls.txtServiceSyuruiName().disabled = true;
                    //this.controls.txtHyoGkei().disabled = true;
                    //this.controls.txtRiyoshafutanGokei().disabled = true;
                    //this.controls.txtSanteiKijunGaku().disabled = true;
                    //this.controls.txtSiharaiZumiGaku().disabled = true;
                    //this.controls.lin1().disabled = true;
                    //this.controls.rdbTsukiOkure().disabled = true;
                    //this.controls.rabSetaiShotokuKubun().disabled = true;
                    //this.controls.rdbShotokuKubun().disabled = true;
                    //this.controls.rdbGassan().disabled = true;
                    //this.controls.rdbRoreiFukushiNenkin().disabled = true;
                    //this.controls.rdbRiyoshafutanDai2dankai().disabled = true;
                    //this.controls.rdbGekihenkanwaKubun().disabled = true;
                    //this.controls.btnkakutei().disabled = true;
                    //this.controls.btnTorikeshi().disabled = true;
                    
                    //DataGrid(修正・削除ボタン)
                    var gridSetting = this.controls.dgTaishoshaIchiran().gridSetting;
                    gridSetting.isShowModifyButtonColumn = true;
                    gridSetting.isShowDeleteButtonColumn = true;
                    gridSetting.columns[0].visible = true;
                    
                    this.controls.dgTaishoshaIchiran().gridSetting = gridSetting;
                    this.controls.dgTaishoshaIchiran()._control.afterPropertiesSet();
                }
            }
            
            export class MeisaiGokeiKubunMode {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public Meisai(): void {
                    this.controls.GokeiPanel().displayNone = true;
                    this.controls.KogakuKyufuKonkyoPanel().displayNone = false;
                }
                
                public Gokei(): void {
                    this.controls.GokeiPanel().displayNone = false;
                    this.controls.KogakuKyufuKonkyoPanel().displayNone = true;
                }
                
            }
        }
    }
}

module DBC
{
    export module KogakuKyufuTaishoList
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

