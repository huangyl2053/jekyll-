var DBZ;
(function (DBZ) {
    (function (Hihosyosai) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new Hihosyosai.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new Hihosyosai.PublicProperties(this.fieldName);
            };
            ModeController.prototype.priorities = function () {
                return [
                    "DisplayType"
                ];
            };
            ModeController.prototype.DisplayType = function () {
                return new Modes.DisplayType(this.controls);
            };
            return ModeController;
        })();
        Hihosyosai.ModeController = ModeController;

        (function (Modes) {
            var DisplayType = (function () {
                function DisplayType(controls) {
                    this.controls = controls;
                }
                DisplayType.prototype.shokai = function () {
                    this.controls.txtSyutokuYMD().readOnly = true;
                    this.controls.txtSyutokutodokedeYMD().readOnly = true;
                    this.controls.ddlSyutokuJiyu().readOnly = true;
                    this.controls.ddlHihokubun().readOnly = true;
                    this.controls.ddlSyozaiHokensya().readOnly = true;
                    this.controls.ddlSotimotoHokensya().readOnly = true;
                    this.controls.ddlKyuHokensya().readOnly = true;
                    this.controls.txtSosichiYMD().readOnly = true;
                    this.controls.txtSosichiTodokedeYMD().readOnly = true;
                    this.controls.ddlSosichiJiyu().readOnly = true;

                    this.controls.tabPnlJyusyoti().visible = true;
                    this.controls.tabPnlShikaku().visible = true;
                };

                DisplayType.prototype.toroku = function () {
                    this.controls.txtSyutokuYMD().readOnly = false;
                    this.controls.txtSyutokutodokedeYMD().readOnly = false;
                    this.controls.ddlSyutokuJiyu().readOnly = false;
                    this.controls.ddlHihokubun().readOnly = false;
                    this.controls.ddlSyozaiHokensya().readOnly = false;
                    this.controls.ddlSotimotoHokensya().readOnly = false;
                    this.controls.ddlKyuHokensya().readOnly = false;
                    this.controls.txtSosichiYMD().readOnly = false;
                    this.controls.txtSosichiTodokedeYMD().readOnly = false;
                    this.controls.ddlSosichiJiyu().readOnly = false;

                    this.controls.tabPnlJyusyoti().visible = true;
                    this.controls.tabPnlShikaku().visible = true;
                };

                DisplayType.prototype.teiseitoroku_jyusyoti = function () {
                    this.controls.txtSyutokuYMD().readOnly = false;
                    this.controls.txtSyutokutodokedeYMD().readOnly = false;
                    this.controls.ddlSyutokuJiyu().readOnly = false;
                    this.controls.ddlHihokubun().readOnly = false;
                    this.controls.ddlSyozaiHokensya().readOnly = false;
                    this.controls.ddlSotimotoHokensya().readOnly = false;
                    this.controls.ddlKyuHokensya().readOnly = false;
                    this.controls.txtSosichiYMD().readOnly = false;
                    this.controls.txtSosichiTodokedeYMD().readOnly = false;
                    this.controls.ddlSosichiJiyu().readOnly = false;

                    this.controls.tabPnlJyusyoti().visible = true;
                    this.controls.tabPnlShikaku().visible = true;
                };

                DisplayType.prototype.teiseitoroku_shikaku = function () {
                    this.controls.txtSyutokuYMD().readOnly = false;
                    this.controls.txtSyutokutodokedeYMD().readOnly = false;
                    this.controls.ddlSyutokuJiyu().readOnly = false;
                    this.controls.ddlHihokubun().readOnly = false;
                    this.controls.ddlSyozaiHokensya().readOnly = false;
                    this.controls.ddlSotimotoHokensya().readOnly = false;
                    this.controls.ddlKyuHokensya().readOnly = false;
                    this.controls.txtSosichiYMD().readOnly = false;
                    this.controls.txtSosichiTodokedeYMD().readOnly = false;
                    this.controls.ddlSosichiJiyu().readOnly = false;

                    this.controls.tabPnlJyusyoti().visible = false;
                    this.controls.tabPnlShikaku().visible = true;
                };
                return DisplayType;
            })();
            Modes.DisplayType = DisplayType;
        })(Hihosyosai.Modes || (Hihosyosai.Modes = {}));
        var Modes = Hihosyosai.Modes;
    })(DBZ.Hihosyosai || (DBZ.Hihosyosai = {}));
    var Hihosyosai = DBZ.Hihosyosai;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (Hihosyosai) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new Hihosyosai.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        Hihosyosai.PublicProperties = PublicProperties;
    })(DBZ.Hihosyosai || (DBZ.Hihosyosai = {}));
    var Hihosyosai = DBZ.Hihosyosai;
})(DBZ || (DBZ = {}));
