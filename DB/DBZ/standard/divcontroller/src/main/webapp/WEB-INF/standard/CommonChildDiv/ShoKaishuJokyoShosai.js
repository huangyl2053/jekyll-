﻿var DBZ;
(function (DBZ) {
    (function (ShoKaishuJokyoShosai) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShoKaishuJokyoShosai.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [
                    "HyojiHoho"
                ];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new DBZ.ShoKaishuJokyoShosai.PublicProperties(this.fieldName);
            };

            ModeController.prototype.HyojiHoho = function () {
                return new Modes.HyojiHoho(this.controls);
            };
            return ModeController;
        })();
        ShoKaishuJokyoShosai.ModeController = ModeController;

        (function (Modes) {
            var HyojiHoho = (function () {
                function HyojiHoho(controls) {
                    this.controls = controls;
                }
                HyojiHoho.prototype.照会 = function () {
                    this.controls.ShoKaishuJokyoShosai().readOnly = true;
                    this.controls.ShoKaishuJokyoShosai().displayNone = false;
                };

                HyojiHoho.prototype.入力 = function () {
                    this.controls.ShoKaishuJokyoShosai().readOnly = false;
                    this.controls.ShoKaishuJokyoShosai().displayNone = false;
                };

                HyojiHoho.prototype.非表示 = function () {
                    this.controls.ShoKaishuJokyoShosai().readOnly = true;
                    this.controls.ShoKaishuJokyoShosai().displayNone = true;
                };
                return HyojiHoho;
            })();
            Modes.HyojiHoho = HyojiHoho;
        })(ShoKaishuJokyoShosai.Modes || (ShoKaishuJokyoShosai.Modes = {}));
        var Modes = ShoKaishuJokyoShosai.Modes;
    })(DBZ.ShoKaishuJokyoShosai || (DBZ.ShoKaishuJokyoShosai = {}));
    var ShoKaishuJokyoShosai = DBZ.ShoKaishuJokyoShosai;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (ShoKaishuJokyoShosai) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShoKaishuJokyoShosai.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("ShoKaishuJokyoShosai_panelDisplay", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("ShoKaishuJokyoShosai_canOpenAndClose", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            };

            PublicProperties.prototype.getShoKaishuJokyoShosai_panelDisplay = function () {
                return this.controls.ShoKaishuJokyoShosai().panelDisplay;
            };

            PublicProperties.prototype.setShoKaishuJokyoShosai_panelDisplay = function (value) {
                this.controls.ShoKaishuJokyoShosai().panelDisplay = value;
            };

            PublicProperties.prototype.getShoKaishuJokyoShosai_canOpenAndClose = function () {
                return this.controls.ShoKaishuJokyoShosai().canOpenAndClose;
            };

            PublicProperties.prototype.setShoKaishuJokyoShosai_canOpenAndClose = function (value) {
                this.controls.ShoKaishuJokyoShosai().canOpenAndClose = value;
            };
            return PublicProperties;
        })();
        ShoKaishuJokyoShosai.PublicProperties = PublicProperties;
    })(DBZ.ShoKaishuJokyoShosai || (DBZ.ShoKaishuJokyoShosai = {}));
    var ShoKaishuJokyoShosai = DBZ.ShoKaishuJokyoShosai;
})(DBZ || (DBZ = {}));
