var DBZ;
(function (DBZ) {
    (function (SogoShokaiFukaInfo) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new SogoShokaiFukaInfo.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        SogoShokaiFukaInfo.ModeController = ModeController;
    })(DBZ.SogoShokaiFukaInfo || (DBZ.SogoShokaiFukaInfo = {}));
    var SogoShokaiFukaInfo = DBZ.SogoShokaiFukaInfo;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (SogoShokaiFukaInfo) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new SogoShokaiFukaInfo.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        SogoShokaiFukaInfo.PublicProperties = PublicProperties;
    })(DBZ.SogoShokaiFukaInfo || (DBZ.SogoShokaiFukaInfo = {}));
    var SogoShokaiFukaInfo = DBZ.SogoShokaiFukaInfo;
})(DBZ || (DBZ = {}));
