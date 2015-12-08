
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

            public Properties() {
                return new UZA.CommonChildDiv(this.fieldName);
            }

            public PublicProperties() {
                return new DBZ.JushochiTokureiRirekiList.PublicProperties(this.fieldName);
            }

            public priorities(): Array {
                return [
                    "DisplayType",
                    "ShoriNichijiDisplayMode",
                    "MeisaiDisplayMode",
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

                public tekiyo(): void {
                    this.controls.dgJutoku().readOnly = false;

                    var gridSetting = this.controls.dgJutoku().gridSetting;
                    
                    gridSetting.columns[0].visible = true;
                    gridSetting.isShowModifyButtonColumn = true;
                    gridSetting.isShowDeleteButtonColumn = true;

                    this.controls.dgJutoku().gridSetting = gridSetting;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                }

                public kaijo(): void {
                    this.controls.dgJutoku().readOnly = false;

                    var gridSetting = this.controls.dgJutoku().gridSetting;
                    
                    gridSetting.columns[0].visible = true;
                    gridSetting.isShowModifyButtonColumn = true;
                    gridSetting.isShowDeleteButtonColumn = true;

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

                    //this.controls.TekiyojiHokenshaJoho().readOnly = true;
                    //this.controls.TekiyojiHokenshaJoho().displayNone = false;
                    this.controls.ddlTekiyoJiyu().readOnly = true;
                    //this.controls.ddlTekiyojiKyuHokensha().readOnly = true;
                    //this.controls.ddlTekiyojiJuminJoho().readOnly = true;
                    
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

                    //this.controls.KaijojiHokenshaJoho().readOnly = true;
                    //this.controls.KaijojiHokenshaJoho().displayNone = false;
                    this.controls.ddlKaijoJiyu().readOnly = true;
                    //this.controls.ddlKaijojiKyuHokensha().readOnly = true;
                    //this.controls.ddlKaijojiJuminJono().readOnly = true;
                    
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

                    //this.controls.TekiyojiHokenshaJoho().readOnly = false;
                    //this.controls.TekiyojiHokenshaJoho().displayNone = false;
                    this.controls.ddlTekiyoJiyu().readOnly = false;
                    //this.controls.ddlTekiyojiKyuHokensha().readOnly = false;
                    //this.controls.ddlTekiyojiJuminJoho().readOnly = false;

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

                    //this.controls.KaijojiHokenshaJoho().readOnly = false;
                    //this.controls.KaijojiHokenshaJoho().displayNone = false;
                    this.controls.ddlKaijoJiyu().readOnly = false;
                    //this.controls.ddlKaijojiKyuHokensha().readOnly = false;
                    //this.controls.ddlKaijojiJuminJono().readOnly = false;

                    this.controls.btnJutokuKakutei().displayNone = false;
                    this.controls.btnJutokuTorikeshi().displayNone = false;
                }

                public teiseiInput(): void {
                    this.controls.JutokuInput().readOnly = false;
                    this.controls.JutokuInput().displayNone = false;

                    this.controls.JutokuTekiyoInput().readOnly = false;
                    this.controls.JutokuTekiyoInput().displayNone = false;
                    this.controls.txtTekiyoDate().readOnly = false;
                    this.controls.txtTekiyoTodokedeDate().readOnly = false;

                    //this.controls.TekiyojiHokenshaJoho().readOnly = false;
                    //this.controls.TekiyojiHokenshaJoho().displayNone = false;
                    this.controls.ddlTekiyoJiyu().readOnly = false;
                    //this.controls.ddlTekiyojiKyuHokensha().readOnly = false;
                    //this.controls.ddlTekiyojiJuminJoho().readOnly = false;

                    this.controls.JutokuKaijoInput().readOnly = false;
                    this.controls.JutokuKaijoInput().displayNone = false;
                    this.controls.txtKaijoDate().readOnly = false;
                    this.controls.txtKaijoTodokedeDate().readOnly = false;

                    //this.controls.KaijojiHokenshaJoho().readOnly = false;
                    //this.controls.KaijojiHokenshaJoho().displayNone = false;
                    this.controls.ddlKaijoJiyu().readOnly = false;
                    //this.controls.ddlKaijojiKyuHokensha().readOnly = false;
                    //this.controls.ddlKaijojiJuminJono().readOnly = false;

                    this.controls.btnJutokuKakutei().displayNone = false;
                    this.controls.btnJutokuTorikeshi().displayNone = false;
                }
                
                public teiseiShokai(): void {
                    this.controls.JutokuInput().readOnly = true;
                    this.controls.JutokuInput().displayNone = false;

                    this.controls.JutokuTekiyoInput().readOnly = true;
                    this.controls.JutokuTekiyoInput().displayNone = false;
                    this.controls.txtTekiyoDate().readOnly = true;
                    this.controls.txtTekiyoTodokedeDate().readOnly = true;

                    //this.controls.TekiyojiHokenshaJoho().readOnly = true;
                    //this.controls.TekiyojiHokenshaJoho().displayNone = false;
                    this.controls.ddlTekiyoJiyu().readOnly = true;
                    //this.controls.ddlTekiyojiKyuHokensha().readOnly = true;
                    //this.controls.ddlTekiyojiJuminJoho().readOnly = true;

                    this.controls.JutokuKaijoInput().readOnly = true;
                    this.controls.JutokuKaijoInput().displayNone = false;
                    this.controls.txtKaijoDate().readOnly = true;
                    this.controls.txtKaijoTodokedeDate().readOnly = true;

                    //this.controls.KaijojiHokenshaJoho().readOnly = true;
                    //this.controls.KaijojiHokenshaJoho().displayNone = false;
                    this.controls.ddlKaijoJiyu().readOnly = true;
                    //this.controls.ddlKaijojiKyuHokensha().readOnly = true;
                    //this.controls.ddlKaijojiJuminJono().readOnly = true;

                    this.controls.btnJutokuKakutei().displayNone = true;
                    this.controls.btnJutokuTorikeshi().displayNone = true;
                }

                public displayNone(): void {
                    this.controls.JutokuInput().displayNone = true;
                }

            }

            export class ShoriNichijiDisplayMode {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public VisibleTrue(): void {
                    var gridSetting = this.controls.dgJutoku().gridSetting;

                    for (var i = 0; i < gridSetting.columns.length; i++) {
                        if (gridSetting.columns[i].dataName == 'shoriDate') {
                            gridSetting.columns[i].visible = true;
                        }
                    }

                    this.controls.dgJutoku().gridSetting = gridSetting;

                    this.controls.dgJutoku()._control.afterPropertiesSet();

                }

                public VisibleFalse(): void {
                    var gridSetting = this.controls.dgJutoku().gridSetting;

                    for (var i = 0; i < gridSetting.columns.length; i++) {
                        if (gridSetting.columns[i].dataName == 'shoriDate') {
                            gridSetting.columns[i].visible = false;
                        }
                    }

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
                    this.controls.btnAdd().disabled = false;
                }

                public SetDisplayNone(): void {
                    this.controls.btnAdd().displayNone = true;
                    this.controls.btnAdd().disabled = true;
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



module DBZ {

    export module JushochiTokureiRirekiList {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }
            

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();
                
                editTypes.addEditType("dgJutoku_height", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("btnAdd_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("btnAdd_disabled", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            }

            public getDgJutoku_height() {
                return this.controls.dgJutoku().height;
            }

            public setDgJutoku_height(value) {
                this.controls.dgJutoku().height = value;
            }

            public getBtnAdd_displayNone() {
                return this.controls.btnAdd().displayNone;
            }

            public setBtnAdd_displayNone(value) {
                this.controls.btnAdd().displayNone = value;
            }

            public getBtnAdd_disabled() {
                return this.controls.btnAdd().disabled;
            }

            public setBtnAdd_disabled(value) {
                this.controls.btnAdd().disabled = value;
            }

        }
    }
}


