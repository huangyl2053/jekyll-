var DBD;
(function (DBD) {
    (function (ShisetsuIdoJoho) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShisetsuIdoJoho.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ShisetsuIdoJoho.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        ShisetsuIdoJoho.ModeController = ModeController;
    })(DBD.ShisetsuIdoJoho || (DBD.ShisetsuIdoJoho = {}));
    var ShisetsuIdoJoho = DBD.ShisetsuIdoJoho;
})(DBD || (DBD = {}));

var DBD;
(function (DBD) {
    (function (ShisetsuIdoJoho) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShisetsuIdoJoho.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ShisetsuIdoJoho.PublicProperties = PublicProperties;
    })(DBD.ShisetsuIdoJoho || (DBD.ShisetsuIdoJoho = {}));
    var ShisetsuIdoJoho = DBD.ShisetsuIdoJoho;
})(DBD || (DBD = {}));
