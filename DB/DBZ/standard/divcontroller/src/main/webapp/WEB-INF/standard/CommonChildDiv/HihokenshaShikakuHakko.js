var DBZ;
(function (DBZ) {
    (function (HihokenshaShikakuHakko) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new HihokenshaShikakuHakko.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new HihokenshaShikakuHakko.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        HihokenshaShikakuHakko.ModeController = ModeController;
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
                editTypes.addEditType("radInjiIchi_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
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

            PublicProperties.prototype.getradInjiIchi_displayNone = function () {
                return this.controls.radInjiIchi().displayNone;
            };

            PublicProperties.prototype.setradInjiIchi_displayNone = function (value) {
                this.controls.radInjiIchi().displayNone = value;
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
