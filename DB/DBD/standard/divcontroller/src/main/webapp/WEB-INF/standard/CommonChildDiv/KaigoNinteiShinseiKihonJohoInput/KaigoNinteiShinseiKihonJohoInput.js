var DBD;
(function (DBD) {
    (function (KaigoNinteiShinseiKihonJohoInput) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoNinteiShinseiKihonJohoInput.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KaigoNinteiShinseiKihonJohoInput.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        KaigoNinteiShinseiKihonJohoInput.ModeController = ModeController;
    })(DBD.KaigoNinteiShinseiKihonJohoInput || (DBD.KaigoNinteiShinseiKihonJohoInput = {}));
    var KaigoNinteiShinseiKihonJohoInput = DBD.KaigoNinteiShinseiKihonJohoInput;
})(DBD || (DBD = {}));

var DBD;
(function (DBD) {
    (function (KaigoNinteiShinseiKihonJohoInput) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoNinteiShinseiKihonJohoInput.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        KaigoNinteiShinseiKihonJohoInput.PublicProperties = PublicProperties;
    })(DBD.KaigoNinteiShinseiKihonJohoInput || (DBD.KaigoNinteiShinseiKihonJohoInput = {}));
    var KaigoNinteiShinseiKihonJohoInput = DBD.KaigoNinteiShinseiKihonJohoInput;
})(DBD || (DBD = {}));
