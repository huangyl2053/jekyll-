var DBE;
(function (DBE) {
    (function (ZenkaiNinteiKekkaJoho) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ZenkaiNinteiKekkaJoho.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ZenkaiNinteiKekkaJoho.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        ZenkaiNinteiKekkaJoho.ModeController = ModeController;
    })(DBE.ZenkaiNinteiKekkaJoho || (DBE.ZenkaiNinteiKekkaJoho = {}));
    var ZenkaiNinteiKekkaJoho = DBE.ZenkaiNinteiKekkaJoho;
})(DBE || (DBE = {}));

var DBE;
(function (DBE) {
    (function (ZenkaiNinteiKekkaJoho) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ZenkaiNinteiKekkaJoho.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ZenkaiNinteiKekkaJoho.PublicProperties = PublicProperties;
    })(DBE.ZenkaiNinteiKekkaJoho || (DBE.ZenkaiNinteiKekkaJoho = {}));
    var ZenkaiNinteiKekkaJoho = DBE.ZenkaiNinteiKekkaJoho;
})(DBE || (DBE = {}));
