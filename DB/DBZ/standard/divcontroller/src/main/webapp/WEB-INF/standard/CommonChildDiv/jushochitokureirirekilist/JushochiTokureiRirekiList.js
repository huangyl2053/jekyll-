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
                return new DBZ.JushochiTokureiRirekiList.PublicProperties(this.fieldName);
            };

            ModeController.prototype.priorities = function () {
                return [
                    "DisplayType",
                    "ShoriNichijiDisplayMode",
                    "MeisaiDisplayMode",
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

                DisplayType.prototype.tekiyo = function () {
                    this.controls.dgJutoku().readOnly = false;

                    var gridSetting = this.controls.dgJutoku().gridSetting;

                    gridSetting.columns[0].visible = true;
                    gridSetting.isShowModifyButtonColumn = true;
                    gridSetting.isShowDeleteButtonColumn = true;

                    this.controls.dgJutoku().gridSetting = gridSetting;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                DisplayType.prototype.kaijo = function () {
                    this.controls.dgJutoku().readOnly = false;

                    var gridSetting = this.controls.dgJutoku().gridSetting;

                    gridSetting.columns[0].visible = true;
                    gridSetting.isShowModifyButtonColumn = true;
                    gridSetting.isShowDeleteButtonColumn = true;

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

                    this.controls.ddlTekiyoJiyu().readOnly = true;

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

                    this.controls.ddlKaijoJiyu().readOnly = true;

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

                    this.controls.ddlTekiyoJiyu().readOnly = false;

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

                    this.controls.ddlKaijoJiyu().readOnly = false;

                    this.controls.btnJutokuKakutei().displayNone = false;
                    this.controls.btnJutokuTorikeshi().displayNone = false;
                };

                MeisaiDisplayMode.prototype.teiseiInput = function () {
                    this.controls.JutokuInput().readOnly = false;
                    this.controls.JutokuInput().displayNone = false;

                    this.controls.JutokuTekiyoInput().readOnly = false;
                    this.controls.JutokuTekiyoInput().displayNone = false;
                    this.controls.txtTekiyoDate().readOnly = false;
                    this.controls.txtTekiyoTodokedeDate().readOnly = false;

                    this.controls.ddlTekiyoJiyu().readOnly = false;

                    this.controls.JutokuKaijoInput().readOnly = false;
                    this.controls.JutokuKaijoInput().displayNone = false;
                    this.controls.txtKaijoDate().readOnly = false;
                    this.controls.txtKaijoTodokedeDate().readOnly = false;

                    this.controls.ddlKaijoJiyu().readOnly = false;

                    this.controls.btnJutokuKakutei().displayNone = false;
                    this.controls.btnJutokuTorikeshi().displayNone = false;
                };

                MeisaiDisplayMode.prototype.teiseiShokai = function () {
                    this.controls.JutokuInput().readOnly = true;
                    this.controls.JutokuInput().displayNone = false;

                    this.controls.JutokuTekiyoInput().readOnly = true;
                    this.controls.JutokuTekiyoInput().displayNone = false;
                    this.controls.txtTekiyoDate().readOnly = true;
                    this.controls.txtTekiyoTodokedeDate().readOnly = true;

                    this.controls.ddlTekiyoJiyu().readOnly = true;

                    this.controls.JutokuKaijoInput().readOnly = true;
                    this.controls.JutokuKaijoInput().displayNone = false;
                    this.controls.txtKaijoDate().readOnly = true;
                    this.controls.txtKaijoTodokedeDate().readOnly = true;

                    this.controls.ddlKaijoJiyu().readOnly = true;

                    this.controls.btnJutokuKakutei().displayNone = true;
                    this.controls.btnJutokuTorikeshi().displayNone = true;
                };

                MeisaiDisplayMode.prototype.displayNone = function () {
                    this.controls.JutokuInput().displayNone = true;
                };
                return MeisaiDisplayMode;
            })();
            Modes.MeisaiDisplayMode = MeisaiDisplayMode;

            var ShoriNichijiDisplayMode = (function () {
                function ShoriNichijiDisplayMode(controls) {
                    this.controls = controls;
                }
                ShoriNichijiDisplayMode.prototype.VisibleTrue = function () {
                    var gridSetting = this.controls.dgJutoku().gridSetting;

                    for (var i = 0; i < gridSetting.columns.length; i++) {
                        if (gridSetting.columns[i].dataName == 'shoriDate') {
                            gridSetting.columns[i].visible = true;
                        }
                    }

                    this.controls.dgJutoku().gridSetting = gridSetting;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                ShoriNichijiDisplayMode.prototype.VisibleFalse = function () {
                    var gridSetting = this.controls.dgJutoku().gridSetting;

                    for (var i = 0; i < gridSetting.columns.length; i++) {
                        if (gridSetting.columns[i].dataName == 'shoriDate') {
                            gridSetting.columns[i].visible = false;
                        }
                    }

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

                editTypes.addEditType("dgJutoku_height", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("btnAdd_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("btnAdd_disabled", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            };

            PublicProperties.prototype.getDgJutoku_height = function () {
                return this.controls.dgJutoku().height;
            };

            PublicProperties.prototype.setDgJutoku_height = function (value) {
                this.controls.dgJutoku().height = value;
            };

            PublicProperties.prototype.getBtnAdd_displayNone = function () {
                return this.controls.btnAdd().displayNone;
            };

            PublicProperties.prototype.setBtnAdd_displayNone = function (value) {
                this.controls.btnAdd().displayNone = value;
            };

            PublicProperties.prototype.getBtnAdd_disabled = function () {
                return this.controls.btnAdd().disabled;
            };

            PublicProperties.prototype.setBtnAdd_disabled = function (value) {
                this.controls.btnAdd().disabled = value;
            };
            return PublicProperties;
        })();
        JushochiTokureiRirekiList.PublicProperties = PublicProperties;
    })(DBZ.JushochiTokureiRirekiList || (DBZ.JushochiTokureiRirekiList = {}));
    var JushochiTokureiRirekiList = DBZ.JushochiTokureiRirekiList;
})(DBZ || (DBZ = {}));
