var DBZ;
(function (DBZ) {
    (function (SeikatsuhogoDetail) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new SeikatsuhogoDetail.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        SeikatsuhogoDetail.ModeController = ModeController;
    })(DBZ.SeikatsuhogoDetail || (DBZ.SeikatsuhogoDetail = {}));
    var SeikatsuhogoDetail = DBZ.SeikatsuhogoDetail;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (SeikatsuhogoDetail) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new SeikatsuhogoDetail.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("btnHokenshaGuide_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            };

            PublicProperties.prototype.getbtnHokenshaGuide_displayNone = function () {
                return this.controls.btnHokenshaGuide().displayNone;
            };

            PublicProperties.prototype.setbtnHokenshaGuide_displayNone = function (value) {
                this.controls.btnHokenshaGuide().displayNone = value;
            };
            return PublicProperties;
        })();
        SeikatsuhogoDetail.PublicProperties = PublicProperties;
    })(DBZ.SeikatsuhogoDetail || (DBZ.SeikatsuhogoDetail = {}));
    var SeikatsuhogoDetail = DBZ.SeikatsuhogoDetail;
})(DBZ || (DBZ = {}));
