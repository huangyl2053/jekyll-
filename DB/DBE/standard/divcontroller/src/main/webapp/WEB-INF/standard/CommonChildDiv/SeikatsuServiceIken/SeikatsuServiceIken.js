var DBE;
(function (DBE) {
    (function (SeikatsuServiceIken) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new SeikatsuServiceIken.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new SeikatsuServiceIken.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        SeikatsuServiceIken.ModeController = ModeController;
    })(DBE.SeikatsuServiceIken || (DBE.SeikatsuServiceIken = {}));
    var SeikatsuServiceIken = DBE.SeikatsuServiceIken;
})(DBE || (DBE = {}));

var DBE;
(function (DBE) {
    (function (SeikatsuServiceIken) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new SeikatsuServiceIken.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        SeikatsuServiceIken.PublicProperties = PublicProperties;
    })(DBE.SeikatsuServiceIken || (DBE.SeikatsuServiceIken = {}));
    var SeikatsuServiceIken = DBE.SeikatsuServiceIken;
})(DBE || (DBE = {}));
