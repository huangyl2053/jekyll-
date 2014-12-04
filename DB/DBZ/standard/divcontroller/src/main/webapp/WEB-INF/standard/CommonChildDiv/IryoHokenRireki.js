var DBZ;
(function (DBZ) {
    (function (IryoHokenRireki) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnAddIryoHoken = function () {
                return "onClick_btnAddIryoHoken";
            };

            Events.onSelect_dgIryoHokenRireki = function () {
                return "onSelect_dgIryoHokenRireki";
            };

            Events.onSelectByDbClick_dgIryoHokenRireki = function () {
                return "onSelectByDbClick_dgIryoHokenRireki";
            };

            Events.onSelectByModifyButton_dgIryoHokenRireki = function () {
                return "onSelectByModifyButton_dgIryoHokenRireki";
            };

            Events.onSelectByDeleteButton_dgIryoHokenRireki = function () {
                return "onSelectByDeleteButton_dgIryoHokenRireki";
            };

            Events.onBlur_txtIryoHokenHokenshaNo = function () {
                return "onBlur_txtIryoHokenHokenshaNo";
            };

            Events.onClick_btnIryoHokenKakutei = function () {
                return "onClick_btnIryoHokenKakutei";
            };

            Events.onClick_btnIryoHokenTorikeshi = function () {
                return "onClick_btnIryoHokenTorikeshi";
            };
            return Events;
        })();
        IryoHokenRireki.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "IryoHokenRireki";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.IryoHokenRireki.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.IryoHokenRireki.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.IryoHokenRireki = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.btnAddIryoHoken = function () {
                return new UZA.Button(this.convFiledName("btnAddIryoHoken"));
            };

            Controls.prototype.dgIryoHokenRireki = function () {
                return new UZA.DataGrid(this.convFiledName("dgIryoHokenRireki"));
            };

            Controls.prototype.IryoHokenInput = function () {
                return new UZA.Panel(this.convFiledName("IryoHokenInput"));
            };

            Controls.prototype.txtIryoHokenKanyuDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIryoHokenKanyuDate"));
            };

            Controls.prototype.txtIryoHokenDattaiDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIryoHokenDattaiDate"));
            };

            Controls.prototype.ddlIryoHokenShubetsu = function () {
                return new UZA.DropDownList(this.convFiledName("ddlIryoHokenShubetsu"));
            };

            Controls.prototype.txtIryoHokenHokenshaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtIryoHokenHokenshaNo"));
            };

            Controls.prototype.txtIryoHokenHokenshaMeisho = function () {
                return new UZA.TextBox(this.convFiledName("txtIryoHokenHokenshaMeisho"));
            };

            Controls.prototype.txtIryoHokenKigoNo = function () {
                return new UZA.TextBox(this.convFiledName("txtIryoHokenKigoNo"));
            };

            Controls.prototype.btnIryoHokenKakutei = function () {
                return new UZA.Button(this.convFiledName("btnIryoHokenKakutei"));
            };

            Controls.prototype.btnIryoHokenTorikeshi = function () {
                return new UZA.Button(this.convFiledName("btnIryoHokenTorikeshi"));
            };
            return Controls;
        })();
        IryoHokenRireki.Controls = Controls;
    })(DBZ.IryoHokenRireki || (DBZ.IryoHokenRireki = {}));
    var IryoHokenRireki = DBZ.IryoHokenRireki;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (IryoHokenRireki) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new IryoHokenRireki.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new IryoHokenRireki.PublicProperties(this.fieldName);
            };

            ModeController.prototype.priorities = function () {
                return [
                    "DisplayMode",
                    "WidthMode",
                    "MeisaiMode"
                ];
            };

            ModeController.prototype.DisplayMode = function () {
                return new Modes.DisplayMode(this.controls);
            };

            ModeController.prototype.WidthMode = function () {
                return new Modes.WidthMode(this.controls);
            };

            ModeController.prototype.MeisaiMode = function () {
                return new Modes.MeisaiMode(this.controls);
            };
            return ModeController;
        })();
        IryoHokenRireki.ModeController = ModeController;

        (function (Modes) {
            var DisplayMode = (function () {
                function DisplayMode(controls) {
                    this.controls = controls;
                }
                DisplayMode.prototype.Toroku = function () {
                    this.controls.dgIryoHokenRireki().readOnly = false;
                    this.controls.btnAddIryoHoken().displayNone = false;

                    var gridSetting = this.controls.dgIryoHokenRireki().gridSetting;
                    gridSetting.isShowDeleteButtonColumn = true;
                    gridSetting.isShowModifyButtonColumn = true;
                    gridSetting.columns[0].visible = false;

                    this.controls.dgIryoHokenRireki().gridSetting = gridSetting;

                    this.controls.dgIryoHokenRireki().width = 980;

                    this.controls.dgIryoHokenRireki()._control.afterPropertiesSet();
                };

                DisplayMode.prototype.Shokai = function () {
                    this.controls.dgIryoHokenRireki().readOnly = true;
                    this.controls.btnAddIryoHoken().displayNone = true;

                    var gridSetting = this.controls.dgIryoHokenRireki().gridSetting;
                    gridSetting.isShowDeleteButtonColumn = false;
                    gridSetting.isShowModifyButtonColumn = false;
                    gridSetting.columns[0].visible = false;

                    this.controls.dgIryoHokenRireki().gridSetting = gridSetting;

                    this.controls.dgIryoHokenRireki().width = 940;

                    this.controls.dgIryoHokenRireki()._control.afterPropertiesSet();
                };

                DisplayMode.prototype.ShikakuIdo = function () {
                    this.controls.dgIryoHokenRireki().readOnly = false;
                    this.controls.btnAddIryoHoken().displayNone = false;

                    var gridSetting = this.controls.dgIryoHokenRireki().gridSetting;
                    gridSetting.isShowDeleteButtonColumn = true;
                    gridSetting.isShowModifyButtonColumn = true;
                    gridSetting.columns[0].visible = true;

                    this.controls.dgIryoHokenRireki().gridSetting = gridSetting;

                    this.controls.dgIryoHokenRireki().width = 980;

                    this.controls.dgIryoHokenRireki()._control.afterPropertiesSet();
                };
                return DisplayMode;
            })();
            Modes.DisplayMode = DisplayMode;

            var WidthMode = (function () {
                function WidthMode(controls) {
                    this.controls = controls;
                }
                WidthMode.prototype.Width1 = function () {
                    this.controls.dgIryoHokenRireki().width = 800;
                    this.controls.dgIryoHokenRireki()._control.afterPropertiesSet();
                };

                WidthMode.prototype.Width2 = function () {
                    this.controls.dgIryoHokenRireki().width = 700;
                    this.controls.dgIryoHokenRireki()._control.afterPropertiesSet();
                };
                return WidthMode;
            })();
            Modes.WidthMode = WidthMode;

            var MeisaiMode = (function () {
                function MeisaiMode(controls) {
                    this.controls = controls;
                }
                MeisaiMode.prototype.toroku = function () {
                    this.controls.IryoHokenInput().readOnly = false;
                    this.controls.IryoHokenInput().displayNone = false;

                    this.controls.txtIryoHokenKanyuDate().readOnly = false;
                    this.controls.txtIryoHokenKanyuDate().displayNone = false;
                    this.controls.txtIryoHokenDattaiDate().readOnly = false;
                    this.controls.txtIryoHokenDattaiDate().displayNone = false;
                    this.controls.ddlIryoHokenShubetsu().readOnly = false;
                    this.controls.ddlIryoHokenShubetsu().displayNone = false;
                    this.controls.txtIryoHokenHokenshaNo().readOnly = false;
                    this.controls.txtIryoHokenHokenshaNo().displayNone = false;
                    this.controls.txtIryoHokenHokenshaMeisho().readOnly = false;
                    this.controls.txtIryoHokenHokenshaMeisho().displayNone = false;
                    this.controls.txtIryoHokenKigoNo().readOnly = false;
                    this.controls.txtIryoHokenKigoNo().displayNone = false;

                    this.controls.btnIryoHokenKakutei().disabled = false;
                    this.controls.btnIryoHokenKakutei().displayNone = false;
                    this.controls.btnIryoHokenTorikeshi().disabled = false;
                    this.controls.btnIryoHokenTorikeshi().displayNone = false;
                };

                MeisaiMode.prototype.sakujo = function () {
                    this.controls.IryoHokenInput().readOnly = false;
                    this.controls.IryoHokenInput().displayNone = false;

                    this.controls.txtIryoHokenKanyuDate().readOnly = true;
                    this.controls.txtIryoHokenKanyuDate().displayNone = false;
                    this.controls.txtIryoHokenDattaiDate().readOnly = true;
                    this.controls.txtIryoHokenDattaiDate().displayNone = false;
                    this.controls.ddlIryoHokenShubetsu().readOnly = true;
                    this.controls.ddlIryoHokenShubetsu().displayNone = false;
                    this.controls.txtIryoHokenHokenshaNo().readOnly = true;
                    this.controls.txtIryoHokenHokenshaNo().displayNone = false;
                    this.controls.txtIryoHokenHokenshaMeisho().readOnly = true;
                    this.controls.txtIryoHokenHokenshaMeisho().displayNone = false;
                    this.controls.txtIryoHokenKigoNo().readOnly = true;
                    this.controls.txtIryoHokenKigoNo().displayNone = false;

                    this.controls.btnIryoHokenKakutei().disabled = false;
                    this.controls.btnIryoHokenKakutei().displayNone = false;
                    this.controls.btnIryoHokenTorikeshi().disabled = false;
                    this.controls.btnIryoHokenTorikeshi().displayNone = false;
                };

                MeisaiMode.prototype.setReadOnly = function () {
                    this.controls.IryoHokenInput().readOnly = true;
                    this.controls.IryoHokenInput().displayNone = false;

                    this.controls.txtIryoHokenKanyuDate().displayNone = false;
                    this.controls.txtIryoHokenDattaiDate().displayNone = false;
                    this.controls.ddlIryoHokenShubetsu().displayNone = false;
                    this.controls.txtIryoHokenHokenshaNo().displayNone = false;
                    this.controls.txtIryoHokenHokenshaMeisho().displayNone = false;
                    this.controls.txtIryoHokenKigoNo().displayNone = false;

                    this.controls.btnIryoHokenKakutei().displayNone = true;
                    this.controls.btnIryoHokenTorikeshi().displayNone = true;
                };

                MeisaiMode.prototype.setDisplayNone = function () {
                    this.controls.IryoHokenInput().readOnly = true;
                    this.controls.IryoHokenInput().displayNone = true;
                };
                return MeisaiMode;
            })();
            Modes.MeisaiMode = MeisaiMode;
        })(IryoHokenRireki.Modes || (IryoHokenRireki.Modes = {}));
        var Modes = IryoHokenRireki.Modes;
    })(DBZ.IryoHokenRireki || (DBZ.IryoHokenRireki = {}));
    var IryoHokenRireki = DBZ.IryoHokenRireki;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (IryoHokenRireki) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new IryoHokenRireki.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        IryoHokenRireki.PublicProperties = PublicProperties;
    })(DBZ.IryoHokenRireki || (DBZ.IryoHokenRireki = {}));
    var IryoHokenRireki = DBZ.IryoHokenRireki;
})(DBZ || (DBZ = {}));
