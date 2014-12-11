var DBZ;
(function (DBZ) {
    (function (JushochiTokureiRirekiList) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnAdd = function () {
                return "onClick_btnAdd";
            };

            Events.onSelect_dgJutoku = function () {
                return "onSelect_dgJutoku";
            };

            Events.onSelectByDblClick_dgJutoku = function () {
                return "onSelectByDblClick_dgJutoku";
            };

            Events.onSelectByModifyButton_dgJutoku = function () {
                return "onSelectByModifyButton_dgJutoku";
            };

            Events.onSelectByDeleteButton_dgJutoku = function () {
                return "onSelectByDeleteButton_dgJutoku";
            };

            Events.onClick_btnJutokuKakutei = function () {
                return "onClick_btnJutokuKakutei";
            };

            Events.onClick_btnJutokuTorikeshi = function () {
                return "onClick_btnJutokuTorikeshi";
            };
            return Events;
        })();
        JushochiTokureiRirekiList.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "JushochiTokureiRirekiList";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.JushochiTokureiRirekiList.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.JushochiTokureiRirekiList.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.JushochiTokureiRirekiList = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.btnAdd = function () {
                return new UZA.Button(this.convFiledName("btnAdd"));
            };

            Controls.prototype.dgJutoku = function () {
                return new UZA.DataGrid(this.convFiledName("dgJutoku"));
            };

            Controls.prototype.JutokuInput = function () {
                return new UZA.Panel(this.convFiledName("JutokuInput"));
            };

            Controls.prototype.JutokuTekiyoInput = function () {
                return new UZA.Panel(this.convFiledName("JutokuInput_JutokuTekiyoInput"));
            };

            Controls.prototype.txtTekiyoDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtTekiyoDate"));
            };

            Controls.prototype.txtTekiyoTodokedeDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtTekiyoTodokedeDate"));
            };

            Controls.prototype.ddlTekiyoJiyu = function () {
                return new UZA.DropDownList(this.convFiledName("ddlTekiyoJiyu"));
            };

            Controls.prototype.tekiyojiHokenshaJoho = function () {
                return new UZA.Panel(this.convFiledName("JutokuInput_JutokuTekiyoInput_tekiyojiHokenshaJoho"));
            };

            Controls.prototype.ddlTekiyojiShozaiHokensha = function () {
                return new UZA.DropDownList(this.convFiledName("ddlTekiyojiShozaiHokensha"));
            };

            Controls.prototype.ddlTekiyojiSochimotoHokensha = function () {
                return new UZA.DropDownList(this.convFiledName("ddlTekiyojiSochimotoHokensha"));
            };

            Controls.prototype.ddlTekiyojiKyuHokensha = function () {
                return new UZA.DropDownList(this.convFiledName("ddlTekiyojiKyuHokensha"));
            };

            Controls.prototype.ddlTekiyojiJuminJoho = function () {
                return new UZA.DropDownList(this.convFiledName("ddlTekiyojiJuminJoho"));
            };

            Controls.prototype.JutokuKaijoInput = function () {
                return new UZA.Panel(this.convFiledName("JutokuInput_JutokuKaijoInput"));
            };

            Controls.prototype.txtKaijoDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtKaijoDate"));
            };

            Controls.prototype.txtKaijoTodokedeDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtKaijoTodokedeDate"));
            };

            Controls.prototype.ddlKaijoJiyu = function () {
                return new UZA.DropDownList(this.convFiledName("ddlKaijoJiyu"));
            };

            Controls.prototype.kaijojiHokenshaJoho = function () {
                return new UZA.Panel(this.convFiledName("JutokuInput_JutokuKaijoInput_kaijojiHokenshaJoho"));
            };

            Controls.prototype.ddlKaijojiShozaiHokensha = function () {
                return new UZA.DropDownList(this.convFiledName("ddlKaijojiShozaiHokensha"));
            };

            Controls.prototype.ddlKaijojiSochimotoHokensha = function () {
                return new UZA.DropDownList(this.convFiledName("ddlKaijojiSochimotoHokensha"));
            };

            Controls.prototype.ddlKaijojiKyuHokensha = function () {
                return new UZA.DropDownList(this.convFiledName("ddlKaijojiKyuHokensha"));
            };

            Controls.prototype.ddlKaijojiJuminJono = function () {
                return new UZA.DropDownList(this.convFiledName("ddlKaijojiJuminJono"));
            };

            Controls.prototype.btnJutokuKakutei = function () {
                return new UZA.Button(this.convFiledName("btnJutokuKakutei"));
            };

            Controls.prototype.btnJutokuTorikeshi = function () {
                return new UZA.Button(this.convFiledName("btnJutokuTorikeshi"));
            };
            return Controls;
        })();
        JushochiTokureiRirekiList.Controls = Controls;
    })(DBZ.JushochiTokureiRirekiList || (DBZ.JushochiTokureiRirekiList = {}));
    var JushochiTokureiRirekiList = DBZ.JushochiTokureiRirekiList;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (JushochiTokureiRirekiList) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new JushochiTokureiRirekiList.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new JushochiTokureiRirekiList.PublicProperties(this.fieldName);
            };

            ModeController.prototype.priorities = function () {
                return [
                    "DisplayType",
                    "ShoriNichijiDisplayMode",
                    "MeisaiDisplayMode",
                    "HokenshaJohoDisplayMode",
                    "BtnDisplayMode",
                    "DataGridWidth",
                    "DataGridHeight"
                ];
            };

            ModeController.prototype.DisplayType = function () {
                return new Modes.DisplayType(this.controls);
            };

            ModeController.prototype.BtnDisplayMode = function () {
                return new Modes.BtnDisplayMode(this.controls);
            };

            ModeController.prototype.HokenshaJohoDisplayMode = function () {
                return new Modes.HokenshaJohoDisplayMode(this.controls);
            };

            ModeController.prototype.ShoriNichijiDisplayMode = function () {
                return new Modes.ShoriNichijiDisplayMode(this.controls);
            };

            ModeController.prototype.MeisaiDisplayMode = function () {
                return new Modes.MeisaiDisplayMode(this.controls);
            };

            ModeController.prototype.DataGridWidth = function () {
                return new Modes.DataGridWidth(this.controls);
            };

            ModeController.prototype.DataGridHeight = function () {
                return new Modes.DataGridHeight(this.controls);
            };
            return ModeController;
        })();
        JushochiTokureiRirekiList.ModeController = ModeController;

        (function (Modes) {
            var DisplayType = (function () {
                function DisplayType(controls) {
                    this.controls = controls;
                }
                DisplayType.prototype.shokai = function () {
                    this.controls.dgJutoku().readOnly = false;

                    var gridSetting = this.controls.dgJutoku().gridSetting;

                    gridSetting.columns[0].visible = false;
                    gridSetting.isShowModifyButtonColumn = false;
                    gridSetting.isShowDeleteButtonColumn = false;

                    this.controls.dgJutoku().gridSetting = gridSetting;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                DisplayType.prototype.toroku = function () {
                    this.controls.dgJutoku().readOnly = false;

                    var gridSetting = this.controls.dgJutoku().gridSetting;

                    gridSetting.columns[0].visible = true;
                    gridSetting.isShowModifyButtonColumn = false;
                    gridSetting.isShowDeleteButtonColumn = false;

                    this.controls.dgJutoku().gridSetting = gridSetting;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                DisplayType.prototype.teiseitoroku = function () {
                    this.controls.dgJutoku().readOnly = false;

                    var gridSetting = this.controls.dgJutoku().gridSetting;

                    gridSetting.columns[0].visible = true;
                    gridSetting.isShowModifyButtonColumn = true;
                    gridSetting.isShowDeleteButtonColumn = true;

                    this.controls.dgJutoku().gridSetting = gridSetting;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };
                return DisplayType;
            })();
            Modes.DisplayType = DisplayType;

            var MeisaiDisplayMode = (function () {
                function MeisaiDisplayMode(controls) {
                    this.controls = controls;
                }
                MeisaiDisplayMode.prototype.tekiyoShokai = function () {
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
                };

                MeisaiDisplayMode.prototype.kaijoShokai = function () {
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
                };

                MeisaiDisplayMode.prototype.tekiyoInput = function () {
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
                };

                MeisaiDisplayMode.prototype.kaijoInput = function () {
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
                };

                MeisaiDisplayMode.prototype.TeiseiInput = function () {
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
                };

                MeisaiDisplayMode.prototype.displayNone = function () {
                    this.controls.JutokuInput().displayNone = true;
                };
                return MeisaiDisplayMode;
            })();
            Modes.MeisaiDisplayMode = MeisaiDisplayMode;

            var HokenshaJohoDisplayMode = (function () {
                function HokenshaJohoDisplayMode(controls) {
                    this.controls = controls;
                }
                HokenshaJohoDisplayMode.prototype.TanitsuGappeiNashi = function () {
                    var gridSetting = this.controls.dgJutoku().gridSetting;

                    gridSetting.columns[9].visible = false;
                    gridSetting.columns[10].visible = false;
                    gridSetting.columns[11].visible = false;

                    this.controls.dgJutoku().gridSetting = gridSetting;

                    this.controls.tekiyojiHokenshaJoho().displayNone = true;
                    this.controls.kaijojiHokenshaJoho().displayNone = true;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                HokenshaJohoDisplayMode.prototype.TanitsuGappeiAri = function () {
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
                };

                HokenshaJohoDisplayMode.prototype.KoikiGappeiNashi = function () {
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
                };

                HokenshaJohoDisplayMode.prototype.KoikiGappeiAri = function () {
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
                };
                return HokenshaJohoDisplayMode;
            })();
            Modes.HokenshaJohoDisplayMode = HokenshaJohoDisplayMode;

            var ShoriNichijiDisplayMode = (function () {
                function ShoriNichijiDisplayMode(controls) {
                    this.controls = controls;
                }
                ShoriNichijiDisplayMode.prototype.VisibleTrue = function () {
                    var gridSetting = this.controls.dgJutoku().gridSetting;

                    gridSetting.columns[12].visible = true;

                    this.controls.dgJutoku().gridSetting = gridSetting;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                ShoriNichijiDisplayMode.prototype.VisibleFalse = function () {
                    var gridSetting = this.controls.dgJutoku().gridSetting;

                    gridSetting.columns[12].visible = false;

                    this.controls.dgJutoku().gridSetting = gridSetting;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };
                return ShoriNichijiDisplayMode;
            })();
            Modes.ShoriNichijiDisplayMode = ShoriNichijiDisplayMode;

            var BtnDisplayMode = (function () {
                function BtnDisplayMode(controls) {
                    this.controls = controls;
                }
                BtnDisplayMode.prototype.SetDisplay = function () {
                    this.controls.btnAdd().displayNone = false;
                    this.controls.btnAdd().disabled = false;
                };

                BtnDisplayMode.prototype.SetDisplayNone = function () {
                    this.controls.btnAdd().displayNone = true;
                    this.controls.btnAdd().disabled = true;
                };
                return BtnDisplayMode;
            })();
            Modes.BtnDisplayMode = BtnDisplayMode;

            var DataGridWidth = (function () {
                function DataGridWidth(controls) {
                    this.controls = controls;
                }
                DataGridWidth.prototype.Size1 = function () {
                    this.controls.dgJutoku().width = 1070;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                DataGridWidth.prototype.Size2 = function () {
                    this.controls.dgJutoku().width = 1030;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                DataGridWidth.prototype.Size3 = function () {
                    this.controls.dgJutoku().width = 1020;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                DataGridWidth.prototype.Size4 = function () {
                    this.controls.dgJutoku().width = 950;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                DataGridWidth.prototype.Size5 = function () {
                    this.controls.dgJutoku().width = 910;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                DataGridWidth.prototype.Size6 = function () {
                    this.controls.dgJutoku().width = 900;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                DataGridWidth.prototype.Size7 = function () {
                    this.controls.dgJutoku().width = 830;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                DataGridWidth.prototype.Size8 = function () {
                    this.controls.dgJutoku().width = 790;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                DataGridWidth.prototype.Size9 = function () {
                    this.controls.dgJutoku().width = 780;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                DataGridWidth.prototype.Size10 = function () {
                    this.controls.dgJutoku().width = 710;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                DataGridWidth.prototype.Size11 = function () {
                    this.controls.dgJutoku().width = 660;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };
                return DataGridWidth;
            })();
            Modes.DataGridWidth = DataGridWidth;

            var DataGridHeight = (function () {
                function DataGridHeight(controls) {
                    this.controls = controls;
                }
                DataGridHeight.prototype.Size1 = function () {
                    this.controls.dgJutoku().height = 450;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                DataGridHeight.prototype.Size2 = function () {
                    this.controls.dgJutoku().height = 400;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                DataGridHeight.prototype.Size3 = function () {
                    this.controls.dgJutoku().height = 350;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                DataGridHeight.prototype.Size4 = function () {
                    this.controls.dgJutoku().height = 300;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                DataGridHeight.prototype.Size5 = function () {
                    this.controls.dgJutoku().height = 250;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                DataGridHeight.prototype.Size6 = function () {
                    this.controls.dgJutoku().height = 200;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };
                return DataGridHeight;
            })();
            Modes.DataGridHeight = DataGridHeight;
        })(JushochiTokureiRirekiList.Modes || (JushochiTokureiRirekiList.Modes = {}));
        var Modes = JushochiTokureiRirekiList.Modes;
    })(DBZ.JushochiTokureiRirekiList || (DBZ.JushochiTokureiRirekiList = {}));
    var JushochiTokureiRirekiList = DBZ.JushochiTokureiRirekiList;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (JushochiTokureiRirekiList) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new JushochiTokureiRirekiList.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        JushochiTokureiRirekiList.PublicProperties = PublicProperties;
    })(DBZ.JushochiTokureiRirekiList || (DBZ.JushochiTokureiRirekiList = {}));
    var JushochiTokureiRirekiList = DBZ.JushochiTokureiRirekiList;
})(DBZ || (DBZ = {}));
