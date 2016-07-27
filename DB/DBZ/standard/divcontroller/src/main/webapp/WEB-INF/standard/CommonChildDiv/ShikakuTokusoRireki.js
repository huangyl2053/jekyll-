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
                    "DialogCloseBtnDisplayMode",
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

            ModeController.prototype.DialogCloseBtnDisplayMode = function () {
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
                    this.controls.btnAddShikakuShutoku().displayNone = true;

                    var gridSetting = this.controls.dgShikakuShutokuRireki().gridSetting;
                    gridSetting.columns[0].visible = false;
                    gridSetting.columns[17].visible = true;
                    gridSetting.isShowModifyButtonColumn = false;
                    gridSetting.isShowDeleteButtonColumn = false;

                    this.controls.dgShikakuShutokuRireki().width;

                    this.controls.dgShikakuShutokuRireki().gridSetting = gridSetting;
                };

                DisplayType.prototype.shutoku = function () {
                    this.controls.dgShikakuShutokuRireki().readOnly = false;
                    this.controls.btnAddShikakuShutoku().displayNone = false;

                    var gridSetting = this.controls.dgShikakuShutokuRireki().gridSetting;

                    gridSetting.columns[0].visible = true;
                    gridSetting.columns[17].visible = false;
                    gridSetting.isShowModifyButtonColumn = true;
                    gridSetting.isShowDeleteButtonColumn = true;

                    this.controls.dgShikakuShutokuRireki().width;

                    this.controls.dgShikakuShutokuRireki().gridSetting = gridSetting;
                };

                DisplayType.prototype.soshitsu = function () {
                    this.controls.dgShikakuShutokuRireki().readOnly = false;
                    this.controls.btnAddShikakuShutoku().displayNone = true;

                    var gridSetting = this.controls.dgShikakuShutokuRireki().gridSetting;

                    gridSetting.columns[0].visible = true;
                    gridSetting.columns[17].visible = false;
                    gridSetting.isShowModifyButtonColumn = true;
                    gridSetting.isShowDeleteButtonColumn = true;

                    this.controls.dgShikakuShutokuRireki().width;

                    this.controls.dgShikakuShutokuRireki().gridSetting = gridSetting;
                };
                DisplayType.prototype.teiseitoroku = function () {
                    this.controls.dgShikakuShutokuRireki().readOnly = false;
                    this.controls.btnAddShikakuShutoku().displayNone = false;

                    var gridSetting = this.controls.dgShikakuShutokuRireki().gridSetting;

                    gridSetting.columns[0].visible = true;
                    gridSetting.columns[17].visible = false;
                    gridSetting.isShowModifyButtonColumn = true;
                    gridSetting.isShowDeleteButtonColumn = true;

                    this.controls.dgShikakuShutokuRireki().width;

                    this.controls.dgShikakuShutokuRireki().gridSetting = gridSetting;
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

            var DialogCloseBtnDisplayMode = (function () {
                function DialogCloseBtnDisplayMode(controls) {
                    this.controls = controls;
                }
                DialogCloseBtnDisplayMode.prototype.SetDisplay = function () {
                    this.controls.btnClose().displayNone = false;
                };

                DialogCloseBtnDisplayMode.prototype.SetDisplayNone = function () {
                    this.controls.btnClose().displayNone = true;
                };
                return DialogCloseBtnDisplayMode;
            })();
            Modes.DialogCloseBtnDisplayMode = DialogCloseBtnDisplayMode;

            var HokenshaJohoDisplayMode = (function () {
                function HokenshaJohoDisplayMode(controls) {
                    this.controls = controls;
                }
                HokenshaJohoDisplayMode.prototype.TanitsuGappeiNashi = function () {
                    var gridSetting = this.controls.dgShikakuShutokuRireki().gridSetting;

                    gridSetting.columns[13].visible = false;
                    gridSetting.columns[14].visible = false;
                    gridSetting.columns[15].visible = false;
                    gridSetting.columns[16].visible = false;

                    this.controls.dgShikakuShutokuRireki().gridSetting = gridSetting;
                };

                HokenshaJohoDisplayMode.prototype.TanitsuGappeiAri = function () {
                    var gridSetting = this.controls.dgShikakuShutokuRireki().gridSetting;

                    gridSetting.columns[13].visible = false;
                    gridSetting.columns[14].visible = false;
                    gridSetting.columns[15].visible = true;
                    gridSetting.columns[16].visible = false;

                    this.controls.dgShikakuShutokuRireki().gridSetting = gridSetting;
                };

                HokenshaJohoDisplayMode.prototype.KoikiGappeiNashi = function () {
                    var gridSetting = this.controls.dgShikakuShutokuRireki().gridSetting;

                    gridSetting.columns[13].visible = true;
                    gridSetting.columns[14].visible = true;
                    gridSetting.columns[15].visible = false;
                    gridSetting.columns[16].visible = true;

                    this.controls.dgShikakuShutokuRireki().gridSetting = gridSetting;
                };

                HokenshaJohoDisplayMode.prototype.KoikiGappeiAri = function () {
                    var gridSetting = this.controls.dgShikakuShutokuRireki().gridSetting;

                    gridSetting.columns[13].visible = true;
                    gridSetting.columns[14].visible = true;
                    gridSetting.columns[15].visible = true;
                    gridSetting.columns[16].visible = true;

                    this.controls.dgShikakuShutokuRireki().gridSetting = gridSetting;
                };
                return HokenshaJohoDisplayMode;
            })();
            Modes.HokenshaJohoDisplayMode = HokenshaJohoDisplayMode;

            var DataGridWidth = (function () {
                function DataGridWidth(controls) {
                    this.controls = controls;
                }
                DataGridWidth.prototype.Size1 = function () {
                    this.controls.dgShikakuShutokuRireki().width = 1220;
                };

                DataGridWidth.prototype.Size2 = function () {
                    this.controls.dgShikakuShutokuRireki().width = 1080;
                };

                DataGridWidth.prototype.Size3 = function () {
                    this.controls.dgShikakuShutokuRireki().width = 1060;
                };

                DataGridWidth.prototype.Size4 = function () {
                    this.controls.dgShikakuShutokuRireki().width = 960;
                };

                DataGridWidth.prototype.Size5 = function () {
                    this.controls.dgShikakuShutokuRireki().width = 940;
                };

                DataGridWidth.prototype.Size6 = function () {
                    this.controls.dgShikakuShutokuRireki().width = 940;
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
                };

                DataGridHeight.prototype.Size300 = function () {
                    this.controls.dgShikakuShutokuRireki().height = 300;
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
