var DBZ;
(function (DBZ) {
    (function (ShoKaishuJokyoList) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShoKaishuJokyoList.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [
                    "GridHyojiMode",
                    "IchiranPanelTakasa",
                    "MeisaiHyojiMode"
                ];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ShoKaishuJokyoList.PublicProperties(this.fieldName);
            };

            ModeController.prototype.GridHyojiMode = function () {
                return new Modes.GridHyojiMode(this.controls);
            };

            ModeController.prototype.IchiranPanelTakasa = function () {
                return new Modes.IchiranPanelTakasa(this.controls);
            };
            ModeController.prototype.MeisaiHyojiMode = function () {
                return new Modes.MeisaiHyojiMode(this.controls);
            };
            return ModeController;
        })();
        ShoKaishuJokyoList.ModeController = ModeController;

        (function (Modes) {
            var GridHyojiMode = (function () {
                function GridHyojiMode(controls) {
                    this.controls = controls;
                }
                GridHyojiMode.prototype.shokai = function () {
                    var gridSetting = this.controls.dgShoKaishuJokyo().gridSetting;

                    gridSetting.isShowSelectButtonColumn = false;
                    gridSetting.columns[0].visible = false;

                    this.controls.dgShoKaishuJokyo().gridSetting = gridSetting;

                    this.controls.dgShoKaishuJokyo()._control.afterPropertiesSet();
                    this.controls.ShoKaishuJokyoShosai().readOnly = true;
                    this.controls.ShoKaishuJokyoShosai().displayNone = false;
                };

                GridHyojiMode.prototype.toroku = function () {
                    var gridSetting = this.controls.dgShoKaishuJokyo().gridSetting;

                    gridSetting.isShowSelectButtonColumn = true;
                    gridSetting.columns[0].visible = true;

                    this.controls.dgShoKaishuJokyo().gridSetting = gridSetting;

                    this.controls.dgShoKaishuJokyo()._control.afterPropertiesSet();
                };

                GridHyojiMode.prototype.select = function () {
                    var gridSetting = this.controls.dgShoKaishuJokyo().gridSetting;

                    gridSetting.isShowSelectButtonColumn = true;
                    gridSetting.columns[0].visible = false;

                    this.controls.dgShoKaishuJokyo().gridSetting = gridSetting;

                    this.controls.dgShoKaishuJokyo()._control.afterPropertiesSet();
                };
                return GridHyojiMode;
            })();
            Modes.GridHyojiMode = GridHyojiMode;

            var IchiranPanelTakasa = (function () {
                function IchiranPanelTakasa(controls) {
                    this.controls = controls;
                }
                IchiranPanelTakasa.prototype.Size200 = function () {
                    this.controls.dgShoKaishuJokyo().height = "200";
                };

                IchiranPanelTakasa.prototype.Size250 = function () {
                    this.controls.dgShoKaishuJokyo().height = "250";
                };

                IchiranPanelTakasa.prototype.Size300 = function () {
                    this.controls.dgShoKaishuJokyo().height = "300";
                };

                IchiranPanelTakasa.prototype.Size350 = function () {
                    this.controls.dgShoKaishuJokyo().height = "350";
                };

                IchiranPanelTakasa.prototype.Size400 = function () {
                    this.controls.dgShoKaishuJokyo().height = "400";
                };

                IchiranPanelTakasa.prototype.Size450 = function () {
                    this.controls.dgShoKaishuJokyo().height = "450";
                };

                IchiranPanelTakasa.prototype.Size500 = function () {
                    this.controls.dgShoKaishuJokyo().height = "500";
                };
                return IchiranPanelTakasa;
            })();
            Modes.IchiranPanelTakasa = IchiranPanelTakasa;
            var MeisaiHyojiMode = (function () {
                function MeisaiHyojiMode(controls) {
                    this.controls = controls;
                }
                MeisaiHyojiMode.prototype.Shokai = function () {
                    this.controls.ShoKaishuJokyoShosai().readOnly = true;
                    this.controls.ShoKaishuJokyoShosai().displayNone = false;
                };

                MeisaiHyojiMode.prototype.Nyuryoku = function () {
                    this.controls.ShoKaishuJokyoShosai().readOnly = false;
                    this.controls.ShoKaishuJokyoShosai().displayNone = false;
                };

                MeisaiHyojiMode.prototype.Hihyoji = function () {
                    this.controls.ShoKaishuJokyoShosai().readOnly = true;
                    this.controls.ShoKaishuJokyoShosai().displayNone = true;
                };
                return MeisaiHyojiMode;
            })();
            Modes.MeisaiHyojiMode = MeisaiHyojiMode;
        })(ShoKaishuJokyoList.Modes || (ShoKaishuJokyoList.Modes = {}));
        var Modes = ShoKaishuJokyoList.Modes;
    })(DBZ.ShoKaishuJokyoList || (DBZ.ShoKaishuJokyoList = {}));
    var ShoKaishuJokyoList = DBZ.ShoKaishuJokyoList;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (ShoKaishuJokyoList) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new ShoKaishuJokyoList.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ShoKaishuJokyoList.PublicProperties = PublicProperties;
    })(DBZ.ShoKaishuJokyoList || (DBZ.ShoKaishuJokyoList = {}));
    var ShoKaishuJokyoList = DBZ.ShoKaishuJokyoList;
})(DBZ || (DBZ = {}));
