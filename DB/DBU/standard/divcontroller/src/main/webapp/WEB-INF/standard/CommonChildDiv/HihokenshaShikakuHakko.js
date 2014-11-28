var DBU;
(function (DBU) {
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
    })(DBU.HihokenshaShikakuHakko || (DBU.HihokenshaShikakuHakko = {}));
    var HihokenshaShikakuHakko = DBU.HihokenshaShikakuHakko;
})(DBU || (DBU = {}));

var DBU;
(function (DBU) {
    (function (HihokenshaShikakuHakko) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new HihokenshaShikakuHakko.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("txtYukoKigen_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("radInjiIchi_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
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
            return PublicProperties;
        })();
        HihokenshaShikakuHakko.PublicProperties = PublicProperties;
    })(DBU.HihokenshaShikakuHakko || (DBU.HihokenshaShikakuHakko = {}));
    var HihokenshaShikakuHakko = DBU.HihokenshaShikakuHakko;
})(DBU || (DBU = {}));
