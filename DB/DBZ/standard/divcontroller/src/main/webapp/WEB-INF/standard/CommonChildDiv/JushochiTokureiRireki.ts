/// <reference path='JushochiTokureiRireki_Design.ts' />
module DBZ {
    export module JushochiTokureiRireki {
        export class ModeController {
            private controls: Controls;
            private fieldName: string;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public Properties() {
                return new UZA.CommonChildDiv(this.fieldName);
            }

            public PublicProperties() {
                return new PublicProperties(this.fieldName);
            }
 
            public priorities(): Array < string > {
                return [
                	"TashichosonDisplayMode",
                	"TashichosonTeiseiDisplayMode"
                ];
            }

            public TashichosonDisplayMode() {
                return new Modes.TashichosonDisplayMode(this.controls);
            }

            public TashichosonTeiseiDisplayMode() {
                return new Modes.TashichosonTeiseiDisplayMode(this.controls);
            }

        }
        export module Modes {

            export class TashichosonDisplayMode {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public Shokai(): void {
                    this.controls.btnAdd().visible = false;
                    this.controls.btnAdd().displayNone = true;
                    this.controls.dgJushochiTokureiRireki().readOnly = true;

                    this.controls.dgJushochiTokureiRireki().gridSetting.isShowSelectButtonColumn = false;
                    this.controls.dgJushochiTokureiRireki().gridSetting.isShowModifyButtonColumn = false;
                    this.controls.dgJushochiTokureiRireki().gridSetting.isShowDeleteButtonColumn = false;
                    this.controls.dgJushochiTokureiRireki()._control.afterPropertiesSet();
                }

                public IdoToroku(): void {
                    this.controls.btnAdd().visible = true;
                    this.controls.btnAdd().displayNone = false;
                    this.controls.dgJushochiTokureiRireki().readOnly = false;

                    this.controls.dgJushochiTokureiRireki().gridSetting.isShowSelectButtonColumn = false;
                    this.controls.dgJushochiTokureiRireki().gridSetting.isShowModifyButtonColumn = false;
                    this.controls.dgJushochiTokureiRireki().gridSetting.isShowDeleteButtonColumn = false;
                    this.controls.dgJushochiTokureiRireki()._control.afterPropertiesSet();
                }
            }


            
            export class TashichosonTeiseiDisplayMode {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public Shokai(): void {

                    this.controls.btnAdd().displayNone = true;
                    this.controls.dgJushochiTokureiRireki().readOnly = true;

                    var gridSetting = this.controls.dgJushochiTokureiRireki().gridSetting;
                    var columns = gridSetting.columns;

                    gridSetting.isShowSelectButtonColumn = false
                    gridSetting.isShowModifyButtonColumn = false;
                    gridSetting.isShowDeleteButtonColumn = false;
                    //�ی��� sochiHokenshaMeisho
                    columns[6].visible = true;
                    //��۔ԍ� sochiHihokenshaNo
                    columns[7].visible = true;
                    //�{�ݎ�� ShisetsuShurui
                    columns[10].visible = true;
                    //�����{�� �\�� �Đݒ�250 (ShisetsuShurui(120) + NyushoShisetsu(250))
                    columns[11].width = 250;
      
                    this.controls.dgJushochiTokureiRireki().gridSetting = gridSetting;
                    this.controls.dgJushochiTokureiRireki()._control.afterPropertiesSet();

                }


                public IdoToroku(): void {

                    this.controls.btnAdd().displayNone = false;
                    this.controls.dgJushochiTokureiRireki().readOnly = false;
                    
                    var gridSetting = this.controls.dgJushochiTokureiRireki().gridSetting;
                    var columns = gridSetting.columns;

                    gridSetting.isShowSelectButtonColumn = false;
                    gridSetting.isShowModifyButtonColumn = true;
                    gridSetting.isShowDeleteButtonColumn = true;
                    //�ی��� sochiHokenshaMeisho
                    columns[6].visible = true;
                    //��۔ԍ� sochiHihokenshaNo
                    columns[7].visible = true;
                    //�{�ݎ�� ShisetsuShurui
                    columns[10].visible = true;
                    //�����{�� �\�� �Đݒ�250 (ShisetsuShurui(120) + NyushoShisetsu(250))
                    columns[11].width = 250;

                    this.controls.dgJushochiTokureiRireki().gridSetting = gridSetting;
                    this.controls.dgJushochiTokureiRireki()._control.afterPropertiesSet();
                }


                public IdoToroku_SelectButton(): void {

                    this.controls.btnAdd().displayNone = true;
                    this.controls.dgJushochiTokureiRireki().readOnly = false;

                    var gridSetting = this.controls.dgJushochiTokureiRireki().gridSetting;

                    gridSetting.isShowSelectButtonColumn = true;
                    gridSetting.isShowModifyButtonColumn = false;
                    gridSetting.isShowDeleteButtonColumn = false;

                    this.controls.dgJushochiTokureiRireki().gridSetting = gridSetting;
                    this.controls.dgJushochiTokureiRireki()._control.afterPropertiesSet();
                }

            }
        }
    }
}



module DBZ {

    export module JushochiTokureiRireki {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            }

        }
    }
}


