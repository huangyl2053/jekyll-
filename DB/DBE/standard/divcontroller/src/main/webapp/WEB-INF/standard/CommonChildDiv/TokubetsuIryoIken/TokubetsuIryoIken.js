var DBE;
(function (DBE) {
    (function (TokubetsuIryoIken) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new TokubetsuIryoIken.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new TokubetsuIryoIken.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        TokubetsuIryoIken.ModeController = ModeController;
    })(DBE.TokubetsuIryoIken || (DBE.TokubetsuIryoIken = {}));
    var TokubetsuIryoIken = DBE.TokubetsuIryoIken;
})(DBE || (DBE = {}));

var DBE;
(function (DBE) {
    (function (TokubetsuIryoIken) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new TokubetsuIryoIken.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        TokubetsuIryoIken.PublicProperties = PublicProperties;
    })(DBE.TokubetsuIryoIken || (DBE.TokubetsuIryoIken = {}));
    var TokubetsuIryoIken = DBE.TokubetsuIryoIken;
})(DBE || (DBE = {}));
