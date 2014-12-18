var DBZ;
(function (DBZ) {
    (function (ShikakuTokusoRireki) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnAddShikakuShutoku = function () {
                return "onClick_btnAddShikakuShutoku";
            };

            Events.onSelect_dgShikakuShutokuRireki = function () {
                return "onSelect_dgShikakuShutokuRireki";
            };

            Events.onSelectByDblClick_dgShikakuShutokuRireki = function () {
                return "onSelectByDblClick_dgShikakuShutokuRireki";
            };

            Events.onSelectByModifyButton_dgShikakuShutokuRireki = function () {
                return "onSelectByModifyButton_dgShikakuShutokuRireki";
            };

            Events.onSelectByDeleteButton_dgShikakuShutokuRireki = function () {
                return "onSelectByDeleteButton_dgShikakuShutokuRireki";
            };
            return Events;
        })();
        ShikakuTokusoRireki.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ShikakuTokusoRireki";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.ShikakuTokusoRireki.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.ShikakuTokusoRireki.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ShikakuTokusoRireki = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.btnAddShikakuShutoku = function () {
                return new UZA.Button(this.convFiledName("btnAddShikakuShutoku"));
            };

            Controls.prototype.dgShikakuShutokuRireki = function () {
                return new UZA.DataGrid(this.convFiledName("dgShikakuShutokuRireki"));
            };
            return Controls;
        })();
        ShikakuTokusoRireki.Controls = Controls;
    })(DBZ.ShikakuTokusoRireki || (DBZ.ShikakuTokusoRireki = {}));
    var ShikakuTokusoRireki = DBZ.ShikakuTokusoRireki;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (ShikakuTokusoRireki) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShikakuTokusoRireki.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ShikakuTokusoRireki.PublicProperties(this.fieldName);
            };

            ModeController.prototype.priorities = function () {
                return [
                    "DisplayType",
                    "BtnDisplayMode",
                    "HokenshaJohoDisplayMode",
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

            ModeController.prototype.DataGridWidth = function () {
                return new Modes.DataGridWidth(this.controls);
            };

            ModeController.prototype.DataGridHeight = function () {
                return new Modes.DataGridHeight(this.controls);
            };
            return ModeController;
        })();
        ShikakuTokusoRireki.ModeController = ModeController;

        (function (Modes) {
            var DisplayType = (function () {
                function DisplayType(controls) {
                    this.controls = controls;
                }
                DisplayType.prototype.shokai = function () {
                    this.controls.dgShikakuShutokuRireki().readOnly = false;

                    var gridSetting = this.controls.dgShikakuShutokuRireki().gridSetting;
                    gridSetting.columns[0].visible = false;
                    gridSetting.isShowModifyButtonColumn = false;
                    gridSetting.isShowDeleteButtonColumn = false;

                    this.controls.dgShikakuShutokuRireki().width;

                    this.controls.dgShikakuShutokuRireki().gridSetting = gridSetting;

                    this.controls.dgShikakuShutokuRireki()._control.afterPropertiesSet();
                };

                DisplayType.prototype.toroku = function () {
                    this.controls.dgShikakuShutokuRireki().readOnly = false;

                    var gridSetting = this.controls.dgShikakuShutokuRireki().gridSetting;

                    gridSetting.columns[0].visible = true;
                    gridSetting.isShowModifyButtonColumn = false;
                    gridSetting.isShowDeleteButtonColumn = false;

                    this.controls.dgShikakuShutokuRireki().width;

                    this.controls.dgShikakuShutokuRireki().gridSetting = gridSetting;

                    this.controls.dgShikakuShutokuRireki()._control.afterPropertiesSet();
                };

                DisplayType.prototype.teiseitoroku = function () {
                    this.controls.dgShikakuShutokuRireki().readOnly = false;

                    var gridSetting = this.controls.dgShikakuShutokuRireki().gridSetting;

                    gridSetting.columns[0].visible = true;
                    gridSetting.isShowModifyButtonColumn = true;
                    gridSetting.isShowDeleteButtonColumn = true;

                    this.controls.dgShikakuShutokuRireki().width;

                    this.controls.dgShikakuShutokuRireki().gridSetting = gridSetting;

                    this.controls.dgShikakuShutokuRireki()._control.afterPropertiesSet();
                };
                return DisplayType;
            })();
            Modes.DisplayType = DisplayType;

            var BtnDisplayMode = (function () {
                function BtnDisplayMode(controls) {
                    this.controls = controls;
                }
                BtnDisplayMode.prototype.SetDisplay = function () {
                    this.controls.btnAddShikakuShutoku().displayNone = false;
                };

                BtnDisplayMode.prototype.SetDisplayNone = function () {
                    this.controls.btnAddShikakuShutoku().displayNone = true;
                };
                return BtnDisplayMode;
            })();
            Modes.BtnDisplayMode = BtnDisplayMode;

            var HokenshaJohoDisplayMode = (function () {
                function HokenshaJohoDisplayMode(controls) {
                    this.controls = controls;
                }
                HokenshaJohoDisplayMode.prototype.TanitsuGappeiNashi = function () {
                    var gridSetting = this.controls.dgShikakuShutokuRireki().gridSetting;

                    gridSetting.columns[14].visible = false;
                    gridSetting.columns[15].visible = false;
                    gridSetting.columns[16].visible = false;

                    this.controls.dgShikakuShutokuRireki().gridSetting = gridSetting;

                    this.controls.dgShikakuShutokuRireki()._control.afterPropertiesSet();
                };

                HokenshaJohoDisplayMode.prototype.TanitsuGappeiAri = function () {
                    var gridSetting = this.controls.dgShikakuShutokuRireki().gridSetting;

                    gridSetting.columns[14].visible = false;
                    gridSetting.columns[15].visible = false;
                    gridSetting.columns[16].visible = true;

                    this.controls.dgShikakuShutokuRireki().gridSetting = gridSetting;

                    this.controls.dgShikakuShutokuRireki()._control.afterPropertiesSet();
                };

                HokenshaJohoDisplayMode.prototype.KoikiGappeiNashi = function () {
                    var gridSetting = this.controls.dgShikakuShutokuRireki().gridSetting;

                    gridSetting.columns[14].visible = true;
                    gridSetting.columns[15].visible = true;
                    gridSetting.columns[16].visible = false;

                    this.controls.dgShikakuShutokuRireki().gridSetting = gridSetting;

                    this.controls.dgShikakuShutokuRireki()._control.afterPropertiesSet();
                };

                HokenshaJohoDisplayMode.prototype.KoikiGappeiAri = function () {
                    var gridSetting = this.controls.dgShikakuShutokuRireki().gridSetting;

                    gridSetting.columns[14].visible = true;
                    gridSetting.columns[15].visible = true;
                    gridSetting.columns[16].visible = true;

                    this.controls.dgShikakuShutokuRireki().gridSetting = gridSetting;

                    this.controls.dgShikakuShutokuRireki()._control.afterPropertiesSet();
                };
                return HokenshaJohoDisplayMode;
            })();
            Modes.HokenshaJohoDisplayMode = HokenshaJohoDisplayMode;

            var DataGridWidth = (function () {
                function DataGridWidth(controls) {
                    this.controls = controls;
                }
                DataGridWidth.prototype.Size1 = function () {
                    this.controls.dgShikakuShutokuRireki().width = 1090;

                    this.controls.dgShikakuShutokuRireki()._control.afterPropertiesSet();
                };

                DataGridWidth.prototype.Size2 = function () {
                    this.controls.dgShikakuShutokuRireki().width = 1050;

                    this.controls.dgShikakuShutokuRireki()._control.afterPropertiesSet();
                };

                DataGridWidth.prototype.Size3 = function () {
                    this.controls.dgShikakuShutokuRireki().width = 1020;

                    this.controls.dgShikakuShutokuRireki()._control.afterPropertiesSet();
                };

                DataGridWidth.prototype.Size4 = function () {
                    this.controls.dgShikakuShutokuRireki().width = 970;

                    this.controls.dgShikakuShutokuRireki()._control.afterPropertiesSet();
                };

                DataGridWidth.prototype.Size5 = function () {
                    this.controls.dgShikakuShutokuRireki().width = 920;

                    this.controls.dgShikakuShutokuRireki()._control.afterPropertiesSet();
                };

                DataGridWidth.prototype.Size6 = function () {
                    this.controls.dgShikakuShutokuRireki().width = 870;

                    this.controls.dgShikakuShutokuRireki()._control.afterPropertiesSet();
                };
                return DataGridWidth;
            })();
            Modes.DataGridWidth = DataGridWidth;

            var DataGridHeight = (function () {
                function DataGridHeight(controls) {
                    this.controls = controls;
                }
                DataGridHeight.prototype.SizeDefault = function () {
                    this.controls.dgShikakuShutokuRireki().height = 217;

                    this.controls.dgShikakuShutokuRireki()._control.afterPropertiesSet();
                };

                DataGridHeight.prototype.Size300 = function () {
                    this.controls.dgShikakuShutokuRireki().height = 300;

                    this.controls.dgShikakuShutokuRireki()._control.afterPropertiesSet();
                };
                return DataGridHeight;
            })();
            Modes.DataGridHeight = DataGridHeight;
        })(ShikakuTokusoRireki.Modes || (ShikakuTokusoRireki.Modes = {}));
        var Modes = ShikakuTokusoRireki.Modes;
    })(DBZ.ShikakuTokusoRireki || (DBZ.ShikakuTokusoRireki = {}));
    var ShikakuTokusoRireki = DBZ.ShikakuTokusoRireki;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (ShikakuTokusoRireki) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new ShikakuTokusoRireki.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ShikakuTokusoRireki.PublicProperties = PublicProperties;
    })(DBZ.ShikakuTokusoRireki || (DBZ.ShikakuTokusoRireki = {}));
    var ShikakuTokusoRireki = DBZ.ShikakuTokusoRireki;
})(DBZ || (DBZ = {}));
