var DBE;
(function (DBE) {
    (function (IchiGojiHanteiKekkaJoho) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new IchiGojiHanteiKekkaJoho.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new IchiGojiHanteiKekkaJoho.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        IchiGojiHanteiKekkaJoho.ModeController = ModeController;
    })(DBE.IchiGojiHanteiKekkaJoho || (DBE.IchiGojiHanteiKekkaJoho = {}));
    var IchiGojiHanteiKekkaJoho = DBE.IchiGojiHanteiKekkaJoho;
})(DBE || (DBE = {}));

var DBE;
(function (DBE) {
    (function (IchiGojiHanteiKekkaJoho) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new IchiGojiHanteiKekkaJoho.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        IchiGojiHanteiKekkaJoho.PublicProperties = PublicProperties;
    })(DBE.IchiGojiHanteiKekkaJoho || (DBE.IchiGojiHanteiKekkaJoho = {}));
    var IchiGojiHanteiKekkaJoho = DBE.IchiGojiHanteiKekkaJoho;
})(DBE || (DBE = {}));
