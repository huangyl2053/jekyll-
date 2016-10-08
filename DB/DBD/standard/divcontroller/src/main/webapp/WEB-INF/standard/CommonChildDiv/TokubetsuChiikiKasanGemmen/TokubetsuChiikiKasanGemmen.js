var DBD;
(function (DBD) {
    (function (TokubetsuChiikiKasanGemmen) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new TokubetsuChiikiKasanGemmen.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new TokubetsuChiikiKasanGemmen.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        TokubetsuChiikiKasanGemmen.ModeController = ModeController;
    })(DBD.TokubetsuChiikiKasanGemmen || (DBD.TokubetsuChiikiKasanGemmen = {}));
    var TokubetsuChiikiKasanGemmen = DBD.TokubetsuChiikiKasanGemmen;
})(DBD || (DBD = {}));

var DBD;
(function (DBD) {
    (function (TokubetsuChiikiKasanGemmen) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new TokubetsuChiikiKasanGemmen.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        TokubetsuChiikiKasanGemmen.PublicProperties = PublicProperties;
    })(DBD.TokubetsuChiikiKasanGemmen || (DBD.TokubetsuChiikiKasanGemmen = {}));
    var TokubetsuChiikiKasanGemmen = DBD.TokubetsuChiikiKasanGemmen;
})(DBD || (DBD = {}));
