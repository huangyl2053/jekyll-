/// <reference path='ShikakuHenkoRireki_Design.ts' />
module DBZ {
    export module ShikakuHenkoRireki {
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
                    "DisplayType",
                    "BtnDisplayMode",
                    "HokenshaJohoDisplayMode",
                    "ShoriNichijiDisplayMode",
                    "MeisaiMode",
                    "DataGridWidth",
                    "DataGridHeight"
                ];
            }

            public DisplayType() {
                return new Modes.DisplayType(this.controls);
            }

            public BtnDisplayMode() {
                return new Modes.BtnDisplayMode(this.controls);
            }

            public HokenshaJohoDisplayMode() {
                return new Modes.HokenshaJohoDisplayMode(this.controls);
            }

            public ShoriNichijiDisplayMode() {
                return new Modes.ShoriNichijiDisplayMode(this.controls);
            }

            public MeisaiMode() {
                return new Modes.MeisaiMode(this.controls);
            }

            public DataGridWidth() {
                return new Modes.DataGridWidth(this.controls);
            }

            public DataGridHeight() {
                return new Modes.DataGridHeight(this.controls);
            }
        }

        export module Modes {

            export class DisplayType {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public shokai(): void {
                    this.controls.dgHenko().readOnly = false;

                    var gridSetting = this.controls.dgHenko().gridSetting;

                    gridSetting.columns[0].visible = false;
                    gridSetting.columns[8].visible = true;
                    gridSetting.isShowModifyButtonColumn = true;
                    gridSetting.isShowDeleteButtonColumn = true;

                    this.controls.dgHenko().gridSetting = gridSetting;

                    this.controls.dgHenko()._control.afterPropertiesSet();
                }

                public toroku(): void {
                    this.controls.dgHenko().readOnly = false;

                    var gridSetting = this.controls.dgHenko().gridSetting;

                    gridSetting.columns[0].visible = true;
                    gridSetting.columns[8].visible = false;
                    gridSetting.isShowModifyButtonColumn = true;
                    gridSetting.isShowDeleteButtonColumn = true;

                    this.controls.dgHenko().gridSetting = gridSetting;

                    this.controls.dgHenko()._control.afterPropertiesSet();
                }

                public teiseitoroku(): void {
                    this.controls.dgHenko().readOnly = false;

                    var gridSetting = this.controls.dgHenko().gridSetting;

                    gridSetting.columns[0].visible = true;
                    gridSetting.columns[8].visible = false;
                    gridSetting.isShowModifyButtonColumn = true;
                    gridSetting.isShowDeleteButtonColumn = true;

                    this.controls.dgHenko().gridSetting = gridSetting;

                    this.controls.dgHenko()._control.afterPropertiesSet();
                }

            }

            export class BtnDisplayMode {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public SetDisplay(): void {
                    this.controls.btnAdd().displayNone = false;

                }

                public SetDisplayNone(): void {
                    this.controls.btnAdd().displayNone = true;
                }
            }

            export class HokenshaJohoDisplayMode {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public TanitsuGappeiNashi(): void {
                    var gridSetting = this.controls.dgHenko().gridSetting;

                    gridSetting.columns[5].visible = false;
                    gridSetting.columns[6].visible = false;
                    gridSetting.columns[7].visible = false;

                    this.controls.dgHenko().gridSetting = gridSetting;

                    this.controls.HenkoHokenshaJoho().displayNone = true;
                    this.controls.ddlHenkoSochimotoHokensha().displayNone = true;
                    this.controls.ddlHenkoKyuHokensha().displayNone = true;
                    this.controls.ddlJuminJoho().displayNone = true;

                    this.controls.dgHenko()._control.afterPropertiesSet();

                }

                public TanitsuGappeiAri(): void {
                    var gridSetting = this.controls.dgHenko().gridSetting;

                    gridSetting.columns[5].visible = false;
                    gridSetting.columns[6].visible = false;
                    gridSetting.columns[7].visible = true;


                    this.controls.dgHenko().gridSetting = gridSetting;

                    this.controls.HenkoHokenshaJoho().displayNone = false;
                    this.controls.ddlHenkoSochimotoHokensha().displayNone = true;
                    this.controls.ddlHenkoKyuHokensha().displayNone = false;
                    this.controls.ddlJuminJoho().displayNone = true;

                    this.controls.dgHenko()._control.afterPropertiesSet();

                }

                public KoikiGappeiNashi(): void {
                    var gridSetting = this.controls.dgHenko().gridSetting;

                    gridSetting.columns[5].visible = true;
                    gridSetting.columns[6].visible = true;
                    gridSetting.columns[7].visible = false;

                    this.controls.dgHenko().gridSetting = gridSetting;

                    this.controls.HenkoHokenshaJoho().displayNone = false;
                    this.controls.ddlHenkoSochimotoHokensha().displayNone = false;
                    this.controls.ddlHenkoKyuHokensha().displayNone = true;
                    this.controls.ddlJuminJoho().displayNone = false;

                    this.controls.dgHenko()._control.afterPropertiesSet();

                }

                public KoikiGappeiAri(): void {
                    var gridSetting = this.controls.dgHenko().gridSetting;

                    gridSetting.columns[5].visible = true;
                    gridSetting.columns[6].visible = true;
                    gridSetting.columns[7].visible = true;

                    this.controls.dgHenko().gridSetting = gridSetting;

                    this.controls.HenkoHokenshaJoho().displayNone = false;
                    this.controls.ddlHenkoSochimotoHokensha().displayNone = false;
                    this.controls.ddlHenkoKyuHokensha().displayNone = false;
                    this.controls.ddlJuminJoho().displayNone = false;

                    this.controls.dgHenko()._control.afterPropertiesSet();

                }

            }

            export class ShoriNichijiDisplayMode {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public VisibleTrue(): void {
                    var gridSetting = this.controls.dgHenko().gridSetting;

                    gridSetting.columns[8].visible = true;

                    this.controls.dgHenko().gridSetting = gridSetting;

                    this.controls.dgHenko()._control.afterPropertiesSet();

                }

                public VisibleFalse(): void {
                    var gridSetting = this.controls.dgHenko().gridSetting;

                    gridSetting.columns[8].visible = false;

                    this.controls.dgHenko().gridSetting = gridSetting;

                    this.controls.dgHenko()._control.afterPropertiesSet();

                }
            }

            export class MeisaiMode {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public shokai(): void {
                    this.controls.HenkoInput().readOnly = true;
                    this.controls.HenkoInput().displayNone = false;

                    this.controls.txtHenkoDate().readOnly = true;
                    this.controls.txtHenkoTodokedeDate().readOnly = true;
                    this.controls.ddlHenkoJiyu().readOnly = true;
                    this.controls.ddlHenkoSochimotoHokensha().readOnly = true;
                    this.controls.ddlHenkoKyuHokensha().readOnly = true;
                    this.controls.ddlJuminJoho().readOnly = true;

                    this.controls.btnHenkoKakutei().displayNone = true;
                    this.controls.btnHenkoTorikeshi().displayNone = true;
                }

                public toroku(): void {
                    this.controls.HenkoInput().readOnly = false;
                    this.controls.HenkoInput().displayNone = false;

                    this.controls.txtHenkoDate().readOnly = false;
                    this.controls.txtHenkoTodokedeDate().readOnly = false;
                    this.controls.ddlHenkoJiyu().readOnly = false;
                    this.controls.ddlHenkoSochimotoHokensha().readOnly = false;
                    this.controls.ddlHenkoKyuHokensha().readOnly = false;
                    this.controls.ddlJuminJoho().readOnly = false;

                    this.controls.btnHenkoKakutei().displayNone = false;
                    this.controls.btnHenkoTorikeshi().displayNone = false;
                }

                public sakujo(): void {
                    this.controls.HenkoInput().readOnly = false;
                    this.controls.HenkoInput().displayNone = false;

                    this.controls.txtHenkoDate().readOnly = true;
                    this.controls.txtHenkoTodokedeDate().readOnly = true;
                    this.controls.ddlHenkoJiyu().readOnly = true;
                    this.controls.ddlHenkoSochimotoHokensha().readOnly = true;
                    this.controls.ddlHenkoKyuHokensha().readOnly = true;
                    this.controls.ddlJuminJoho().readOnly = true;

                    this.controls.btnHenkoKakutei().displayNone = false;
                    this.controls.btnHenkoTorikeshi().displayNone = false;
                }

                public setDisplayNone(): void {
                    this.controls.HenkoInput().readOnly = true;
                    this.controls.HenkoInput().displayNone = true;
                }
            }

            export class DataGridWidth {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public Size1(): void {
                    this.controls.dgHenko().width = 870;

                    this.controls.dgHenko()._control.afterPropertiesSet();

                }

                public Size2(): void {
                    this.controls.dgHenko().width = 790;

                    this.controls.dgHenko()._control.afterPropertiesSet();

                }

                public Size3(): void {
                    this.controls.dgHenko().width = 750;

                    this.controls.dgHenko()._control.afterPropertiesSet();

                }

                public Size4(): void {
                    this.controls.dgHenko().width = 740;

                    this.controls.dgHenko()._control.afterPropertiesSet();

                }

                public Size5(): void {
                    this.controls.dgHenko().width = 670;

                    this.controls.dgHenko()._control.afterPropertiesSet();

                }

                public Size6(): void {
                    this.controls.dgHenko().width = 630;

                    this.controls.dgHenko()._control.afterPropertiesSet();

                }

                public Size7(): void {
                    this.controls.dgHenko().width = 620;

                    this.controls.dgHenko()._control.afterPropertiesSet();

                }

                public Size8(): void {
                    this.controls.dgHenko().width = 550;

                    this.controls.dgHenko()._control.afterPropertiesSet();

                }

                public Size9(): void {
                    this.controls.dgHenko().width = 510;

                    this.controls.dgHenko()._control.afterPropertiesSet();

                }

                public Size10(): void {
                    this.controls.dgHenko().width = 500;

                    this.controls.dgHenko()._control.afterPropertiesSet();

                }

                public Size11(): void {
                    this.controls.dgHenko().width = 430;

                    this.controls.dgHenko()._control.afterPropertiesSet();

                }

                public Size12(): void {
                    this.controls.dgHenko().width = 380;

                    this.controls.dgHenko()._control.afterPropertiesSet();

                }
            }

            export class DataGridHeight {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public Size1(): void {
                    this.controls.dgHenko().height = 450;

                    this.controls.dgHenko()._control.afterPropertiesSet();

                }

                public Size2(): void {
                    this.controls.dgHenko().height = 400;

                    this.controls.dgHenko()._control.afterPropertiesSet();

                }

                public Size3(): void {
                    this.controls.dgHenko().height = 350;

                    this.controls.dgHenko()._control.afterPropertiesSet();

                }

                public Size4(): void {
                    this.controls.dgHenko().height = 300;

                    this.controls.dgHenko()._control.afterPropertiesSet();

                }

                public Size5(): void {
                    this.controls.dgHenko().height = 250;

                    this.controls.dgHenko()._control.afterPropertiesSet();

                }

                public Size6(): void {
                    this.controls.dgHenko().height = 200;

                    this.controls.dgHenko()._control.afterPropertiesSet();

                }
            }
        }
    }
}



module DBZ {

    export module ShikakuHenkoRireki {

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