var DBZ;
(function (DBZ) {
    (function (HihokenshaShikakuHakko) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new HihokenshaShikakuHakko.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [
                    "発行証タイプ"
                ];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.発行証タイプ = function () {
                return new Modes.発行証タイプ(this.controls);
            };

            ModeController.prototype.PublicProperties = function () {
                return new DBZ.HihokenshaShikakuHakko.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        HihokenshaShikakuHakko.ModeController = ModeController;

        (function (Modes) {
            var 発行証タイプ = (function () {
                function 発行証タイプ(controls) {
                    this.controls = controls;
                }
                発行証タイプ.prototype.被保険者証 = function () {
                    this.controls.txtYukoKigen().displayNone = true;
                    this.controls.txtShinsakaiIken().maxLength = 198;
                    this.controls.txtShinsakaiIken().limitLength = 198;
                };

                発行証タイプ.prototype.資格者証 = function () {
                    this.controls.txtYukoKigen().displayNone = false;
                    this.controls.txtShinsakaiIken().maxLength = 175;
                    this.controls.txtShinsakaiIken().limitLength = 175;
                };
                return 発行証タイプ;
            })();
            Modes.発行証タイプ = 発行証タイプ;
        })(HihokenshaShikakuHakko.Modes || (HihokenshaShikakuHakko.Modes = {}));
        var Modes = HihokenshaShikakuHakko.Modes;
    })(DBZ.HihokenshaShikakuHakko || (DBZ.HihokenshaShikakuHakko = {}));
    var HihokenshaShikakuHakko = DBZ.HihokenshaShikakuHakko;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (HihokenshaShikakuHakko) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new HihokenshaShikakuHakko.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("txtYukoKigen_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("onBlur_txtKofuDate", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("onChange_ddlKofuJiyu", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            };

            PublicProperties.prototype.gettxtYukoKigen_displayNone = function () {
                return this.controls.txtYukoKigen().displayNone;
            };

            PublicProperties.prototype.settxtYukoKigen_displayNone = function (value) {
                this.controls.txtYukoKigen().displayNone = value;
            };

            PublicProperties.prototype.getonBlur_txtKofuDate = function () {
                return this.controls.txtKofuDate().onBlur;
            };

            PublicProperties.prototype.setonBlur_txtKofuDate = function (value) {
                this.controls.txtKofuDate().onBlur = value;
            };

            PublicProperties.prototype.getonChange_ddlKofuJiyu = function () {
                return this.controls.ddlKofuJiyu().onChange;
            };

            PublicProperties.prototype.setonChange_ddlKofuJiyu = function (value) {
                this.controls.ddlKofuJiyu().onChange = value;
            };
            return PublicProperties;
        })();
        HihokenshaShikakuHakko.PublicProperties = PublicProperties;
    })(DBZ.HihokenshaShikakuHakko || (DBZ.HihokenshaShikakuHakko = {}));
    var HihokenshaShikakuHakko = DBZ.HihokenshaShikakuHakko;
})(DBZ || (DBZ = {}));
