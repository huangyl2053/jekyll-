var DBE;
(function (DBE) {
    (function (IchijiHanteiKekkaJoho) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new IchijiHanteiKekkaJoho.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new IchijiHanteiKekkaJoho.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        IchijiHanteiKekkaJoho.ModeController = ModeController;
    })(DBE.IchijiHanteiKekkaJoho || (DBE.IchijiHanteiKekkaJoho = {}));
    var IchijiHanteiKekkaJoho = DBE.IchijiHanteiKekkaJoho;
})(DBE || (DBE = {}));

var DBE;
(function (DBE) {
    (function (IchijiHanteiKekkaJoho) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new IchijiHanteiKekkaJoho.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        IchijiHanteiKekkaJoho.PublicProperties = PublicProperties;
    })(DBE.IchijiHanteiKekkaJoho || (DBE.IchijiHanteiKekkaJoho = {}));
    var IchijiHanteiKekkaJoho = DBE.IchijiHanteiKekkaJoho;
})(DBE || (DBE = {}));
