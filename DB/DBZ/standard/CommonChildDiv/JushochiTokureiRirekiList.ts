
/// <reference path='JushochiTokureiRirekiList_Design.ts' />
module DBZ
{
    export module JushochiTokureiRirekiList
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
                    "DisplayType",
                    "ShoriNichijiDisplayMode",
                    "MeisaiDisplayMode",
                    "HokenshaJohoDisplayMode",
                    "BtnDisplayMode",
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

            public MeisaiDisplayMode() {
                return new Modes.MeisaiDisplayMode(this.controls);
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
                    this.controls.dgJutoku().readOnly = false;
                    
                    var gridSetting = this.controls.dgJutoku().gridSetting;
                    
                    gridSetting.columns[0].visible = false;
                    gridSetting.isShowModifyButtonColumn = false;
                    gridSetting.isShowDeleteButtonColumn = false;

                    this.controls.dgJutoku().gridSetting = gridSetting;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                }

                public toroku(): void {
                    this.controls.dgJutoku().readOnly = false;

                    var gridSetting = this.controls.dgJutoku().gridSetting;
                    
                    gridSetting.columns[0].visible = true;
                    gridSetting.isShowModifyButtonColumn = false;
                    gridSetting.isShowDeleteButtonColumn = false;

                    this.controls.dgJutoku().gridSetting = gridSetting;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                }

                public teiseitoroku(): void {
                    this.controls.dgJutoku().readOnly = false;

                    var gridSetting = this.controls.dgJutoku().gridSetting;

                    gridSetting.columns[0].visible = true;
                    gridSetting.isShowModifyButtonColumn = true;
                    gridSetting.isShowDeleteButtonColumn = true;

                    this.controls.dgJutoku().gridSetting = gridSetting;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                }

            }

            export class MeisaiDisplayMode {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }


                public tekiyoShokai(): void {
                    this.controls.JutokuInput().readOnly = true;
                    this.controls.JutokuInput().displayNone = false;
                    
                    this.controls.JutokuTekiyoInput().readOnly = true;
                    this.controls.JutokuTekiyoInput().displayNone = false;
                    this.controls.txtTekiyoDate().readOnly = true;
                    this.controls.txtTekiyoTodokedeDate().readOnly = true;

                    this.controls.tekiyojiHokenshaJoho().readOnly = true;
                    this.controls.tekiyojiHokenshaJoho().displayNone = false;
                    this.controls.ddlTekiyoJiyu().readOnly = true;
                    this.controls.ddlTekiyojiShozaiHokensha().readOnly = true;
                    this.controls.ddlTekiyojiSochimotoHokensha().readOnly = true;
                    this.controls.ddlTekiyojiKyuHokensha().readOnly = true;
                    this.controls.ddlTekiyojiJuminJoho().readOnly = true;
                    
                    this.controls.JutokuKaijoInput().displayNone = true;


                    this.controls.btnJutokuKakutei().displayNone = true;
                    this.controls.btnJutokuTorikeshi().displayNone = true;
                }

                public kaijoShokai(): void {
                    this.controls.JutokuInput().readOnly = true;
                    this.controls.JutokuInput().displayNone = false;
                    
                    this.controls.JutokuTekiyoInput().displayNone = true;

                    this.controls.JutokuKaijoInput().readOnly = true;
                    this.controls.JutokuKaijoInput().displayNone = false;
                    this.controls.txtKaijoDate().readOnly = true;
                    this.controls.txtKaijoTodokedeDate().readOnly = true;

                    this.controls.kaijojiHokenshaJoho().readOnly = true;
                    this.controls.kaijojiHokenshaJoho().displayNone = false;
                    this.controls.ddlKaijoJiyu().readOnly = true;
                    this.controls.ddlKaijojiShozaiHokensha().readOnly = true;
                    this.controls.ddlKaijojiSochimotoHokensha().readOnly = true;
                    this.controls.ddlKaijojiKyuHokensha().readOnly = true;
                    this.controls.ddlKaijojiJuminJono().readOnly = true;
                    
                    this.controls.btnJutokuKakutei().displayNone = true;
                    this.controls.btnJutokuTorikeshi().displayNone = true;
                }


                public tekiyoInput(): void {
                    this.controls.JutokuInput().readOnly = false;
                    this.controls.JutokuInput().displayNone = false;

                    this.controls.JutokuTekiyoInput().readOnly = false;
                    this.controls.JutokuTekiyoInput().displayNone = false;
                    this.controls.txtTekiyoDate().readOnly = false;
                    this.controls.txtTekiyoTodokedeDate().readOnly = false;

                    this.controls.tekiyojiHokenshaJoho().readOnly = false;
                    this.controls.tekiyojiHokenshaJoho().displayNone = false;
                    this.controls.ddlTekiyoJiyu().readOnly = false;
                    this.controls.ddlTekiyojiShozaiHokensha().readOnly = false;
                    this.controls.ddlTekiyojiSochimotoHokensha().readOnly = false;
                    this.controls.ddlTekiyojiKyuHokensha().readOnly = false;
                    this.controls.ddlTekiyojiJuminJoho().readOnly = false;

                    this.controls.JutokuKaijoInput().displayNone = true;
                    
                    this.controls.btnJutokuKakutei().displayNone = false;
                    this.controls.btnJutokuTorikeshi().displayNone = false;
                }

                public kaijoInput(): void {
                    this.controls.JutokuInput().readOnly = false;
                    this.controls.JutokuInput().displayNone = false;

                    this.controls.JutokuTekiyoInput().displayNone = true;

                    this.controls.JutokuKaijoInput().readOnly = false;
                    this.controls.JutokuKaijoInput().displayNone = false;
                    this.controls.txtKaijoDate().readOnly = false;
                    this.controls.txtKaijoTodokedeDate().readOnly = false;

                    this.controls.kaijojiHokenshaJoho().readOnly = false;
                    this.controls.kaijojiHokenshaJoho().displayNone = false;
                    this.controls.ddlKaijoJiyu().readOnly = false;
                    this.controls.ddlKaijojiShozaiHokensha().readOnly = false;
                    this.controls.ddlKaijojiSochimotoHokensha().readOnly = false;
                    this.controls.ddlKaijojiKyuHokensha().readOnly = false;
                    this.controls.ddlKaijojiJuminJono().readOnly = false;

                    this.controls.btnJutokuKakutei().displayNone = false;
                    this.controls.btnJutokuTorikeshi().displayNone = false;
                }

                public TeiseiInput(): void {
                    this.controls.JutokuInput().readOnly = false;
                    this.controls.JutokuInput().displayNone = false;
                    
                    this.controls.JutokuTekiyoInput().readOnly = false;
                    this.controls.JutokuTekiyoInput().displayNone = false;
                    this.controls.txtTekiyoDate().readOnly = false;
                    this.controls.txtTekiyoTodokedeDate().readOnly = false;

                    this.controls.tekiyojiHokenshaJoho().readOnly = false;
                    this.controls.tekiyojiHokenshaJoho().displayNone = false;
                    this.controls.ddlTekiyoJiyu().readOnly = false;
                    this.controls.ddlTekiyojiShozaiHokensha().readOnly = false;
                    this.controls.ddlTekiyojiSochimotoHokensha().readOnly = false;
                    this.controls.ddlTekiyojiKyuHokensha().readOnly = false;
                    this.controls.ddlTekiyojiJuminJoho().readOnly = false;

                    this.controls.JutokuKaijoInput().readOnly = false;
                    this.controls.JutokuKaijoInput().displayNone = false;
                    this.controls.txtKaijoDate().readOnly = false;
                    this.controls.txtKaijoTodokedeDate().readOnly = false;

                    this.controls.kaijojiHokenshaJoho().readOnly = false;
                    this.controls.kaijojiHokenshaJoho().displayNone = false;
                    this.controls.ddlKaijoJiyu().readOnly = false;
                    this.controls.ddlKaijojiShozaiHokensha().readOnly = false;
                    this.controls.ddlKaijojiSochimotoHokensha().readOnly = false;
                    this.controls.ddlKaijojiKyuHokensha().readOnly = false;
                    this.controls.ddlKaijojiJuminJono().readOnly = false;

                    this.controls.btnJutokuKakutei().displayNone = false;
                    this.controls.btnJutokuTorikeshi().displayNone = false;
                }

                public displayNone(): void {
                    this.controls.JutokuInput().displayNone = true;
                }

            }
                        
            export class HokenshaJohoDisplayMode {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public TanitsuGappeiNashi(): void {
                    var gridSetting = this.controls.dgJutoku().gridSetting;

                    gridSetting.columns[9].visible = false;
                    gridSetting.columns[10].visible = false;
                    gridSetting.columns[11].visible = false;

                    this.controls.dgJutoku().gridSetting = gridSetting;
                    
                    this.controls.tekiyojiHokenshaJoho().displayNone = true;
                    this.controls.kaijojiHokenshaJoho().displayNone = true;

                    this.controls.dgJutoku()._control.afterPropertiesSet();

                }

                public TanitsuGappeiAri(): void {
                    var gridSetting = this.controls.dgJutoku().gridSetting;

                    gridSetting.columns[9].visible = false;
                    gridSetting.columns[10].visible = false;
                    gridSetting.columns[11].visible = true;

                    this.controls.dgJutoku().gridSetting = gridSetting;

                    this.controls.tekiyojiHokenshaJoho().displayNone = false;
                    this.controls.ddlTekiyojiShozaiHokensha().displayNone = true;
                    this.controls.ddlTekiyojiSochimotoHokensha().displayNone = true;
                    this.controls.ddlTekiyojiKyuHokensha().displayNone = false;
                    this.controls.ddlTekiyojiKyuHokensha().readOnly = false;
                    this.controls.ddlTekiyojiJuminJoho().displayNone = true;

                    this.controls.kaijojiHokenshaJoho().displayNone = false;
                    this.controls.ddlKaijojiShozaiHokensha().displayNone = true;
                    this.controls.ddlKaijojiSochimotoHokensha().displayNone = true;
                    this.controls.ddlKaijojiKyuHokensha().displayNone = false;
                    this.controls.ddlKaijojiKyuHokensha().readOnly = false;
                    this.controls.ddlKaijojiJuminJono().displayNone = true;

                    this.controls.dgJutoku()._control.afterPropertiesSet();

                }

                public KoikiGappeiNashi(): void {
                    var gridSetting = this.controls.dgJutoku().gridSetting;

                    gridSetting.columns[9].visible = true;
                    gridSetting.columns[10].visible = true;
                    gridSetting.columns[11].visible = false;

                    this.controls.dgJutoku().gridSetting = gridSetting;

                    this.controls.tekiyojiHokenshaJoho().displayNone = false;
                    this.controls.ddlTekiyojiShozaiHokensha().readOnly = false;
                    this.controls.ddlTekiyojiShozaiHokensha().displayNone = false;
                    this.controls.ddlTekiyojiSochimotoHokensha().readOnly = false;
                    this.controls.ddlTekiyojiSochimotoHokensha().displayNone = false;
                    this.controls.ddlTekiyojiKyuHokensha().displayNone = true;
                    this.controls.ddlTekiyojiJuminJoho().readOnly = false;
                    this.controls.ddlTekiyojiJuminJoho().displayNone = false;

                    this.controls.kaijojiHokenshaJoho().displayNone = false;
                    this.controls.ddlKaijojiShozaiHokensha().readOnly = false;
                    this.controls.ddlKaijojiShozaiHokensha().displayNone = false;
                    this.controls.ddlKaijojiSochimotoHokensha().readOnly = false;
                    this.controls.ddlKaijojiSochimotoHokensha().displayNone = false;
                    this.controls.ddlKaijojiKyuHokensha().displayNone = true;
                    this.controls.ddlKaijojiJuminJono().readOnly = false;
                    this.controls.ddlKaijojiJuminJono().displayNone = false;

                    this.controls.dgJutoku()._control.afterPropertiesSet();

                }

                public KoikiGappeiAri(): void {
                    var gridSetting = this.controls.dgJutoku().gridSetting;

                    gridSetting.columns[9].visible = true;
                    gridSetting.columns[10].visible = true;
                    gridSetting.columns[11].visible = true;

                    this.controls.dgJutoku().gridSetting = gridSetting;

                    this.controls.tekiyojiHokenshaJoho().displayNone = false;
                    this.controls.ddlTekiyojiShozaiHokensha().readOnly = false;
                    this.controls.ddlTekiyojiShozaiHokensha().displayNone = false;
                    this.controls.ddlTekiyojiSochimotoHokensha().readOnly = false;
                    this.controls.ddlTekiyojiSochimotoHokensha().displayNone = false;
                    this.controls.ddlTekiyojiKyuHokensha().readOnly = false;
                    this.controls.ddlTekiyojiKyuHokensha().displayNone = false;
                    this.controls.ddlTekiyojiJuminJoho().readOnly = false;
                    this.controls.ddlTekiyojiJuminJoho().displayNone = false;

                    this.controls.kaijojiHokenshaJoho().displayNone = false;
                    this.controls.ddlKaijojiShozaiHokensha().readOnly = false;
                    this.controls.ddlKaijojiShozaiHokensha().displayNone = false;
                    this.controls.ddlKaijojiSochimotoHokensha().readOnly = false;
                    this.controls.ddlKaijojiSochimotoHokensha().displayNone = false;
                    this.controls.ddlKaijojiKyuHokensha().readOnly = false;
                    this.controls.ddlKaijojiKyuHokensha().displayNone = false;
                    this.controls.ddlKaijojiJuminJono().readOnly = false;
                    this.controls.ddlKaijojiJuminJono().displayNone = false;

                    this.controls.dgJutoku()._control.afterPropertiesSet();

                }

            }   

            export class ShoriNichijiDisplayMode {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public VisibleTrue(): void {
                    var gridSetting = this.controls.dgJutoku().gridSetting;

                    gridSetting.columns[12].visible = true;

                    this.controls.dgJutoku().gridSetting = gridSetting;

                    this.controls.dgJutoku()._control.afterPropertiesSet();

                }

                public VisibleFalse(): void {
                    var gridSetting = this.controls.dgJutoku().gridSetting;

                    gridSetting.columns[12].visible = false;

                    this.controls.dgJutoku().gridSetting = gridSetting;

                    this.controls.dgJutoku()._control.afterPropertiesSet();

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

            export class DataGridWidth {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public Size1(): void {
                    this.controls.dgJutoku().width = 1070;

                    this.controls.dgJutoku()._control.afterPropertiesSet();

                }

                public Size2(): void {
                    this.controls.dgJutoku().width = 1030;

                    this.controls.dgJutoku()._control.afterPropertiesSet();

                }

                public Size3(): void {
                    this.controls.dgJutoku().width = 1020;

                    this.controls.dgJutoku()._control.afterPropertiesSet();

                }

                public Size4(): void {
                    this.controls.dgJutoku().width = 950;

                    this.controls.dgJutoku()._control.afterPropertiesSet();

                }

                public Size5(): void {
                    this.controls.dgJutoku().width = 910;

                    this.controls.dgJutoku()._control.afterPropertiesSet();

                }

                public Size6(): void {
                    this.controls.dgJutoku().width = 900;

                    this.controls.dgJutoku()._control.afterPropertiesSet();

                }

                public Size7(): void {
                    this.controls.dgJutoku().width = 830;

                    this.controls.dgJutoku()._control.afterPropertiesSet();

                }

                public Size8(): void {
                    this.controls.dgJutoku().width = 790;

                    this.controls.dgJutoku()._control.afterPropertiesSet();

                }

                public Size9(): void {
                    this.controls.dgJutoku().width = 780;

                    this.controls.dgJutoku()._control.afterPropertiesSet();

                }

                public Size10(): void {
                    this.controls.dgJutoku().width = 710;

                    this.controls.dgJutoku()._control.afterPropertiesSet();

                }

                public Size11(): void {
                    this.controls.dgJutoku().width = 660;

                    this.controls.dgJutoku()._control.afterPropertiesSet();

                }
            }

            export class DataGridHeight {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public Size1(): void {
                    this.controls.dgJutoku().height = 450;

                    this.controls.dgJutoku()._control.afterPropertiesSet();

                }

                public Size2(): void {
                    this.controls.dgJutoku().height = 400;

                    this.controls.dgJutoku()._control.afterPropertiesSet();

                }

                public Size3(): void {
                    this.controls.dgJutoku().height = 350;

                    this.controls.dgJutoku()._control.afterPropertiesSet();

                }

                public Size4(): void {
                    this.controls.dgJutoku().height = 300;

                    this.controls.dgJutoku()._control.afterPropertiesSet();

                }

                public Size5(): void {
                    this.controls.dgJutoku().height = 250;

                    this.controls.dgJutoku()._control.afterPropertiesSet();

                }

                public Size6(): void {
                    this.controls.dgJutoku().height = 200;

                    this.controls.dgJutoku()._control.afterPropertiesSet();

                }
            }
        }
    }
}
