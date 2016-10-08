var DBD;
(function (DBD) {
    (function (FutanGendogakuNintei) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new FutanGendogakuNintei.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new FutanGendogakuNintei.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        FutanGendogakuNintei.ModeController = ModeController;
    })(DBD.FutanGendogakuNintei || (DBD.FutanGendogakuNintei = {}));
    var FutanGendogakuNintei = DBD.FutanGendogakuNintei;
})(DBD || (DBD = {}));

var DBD;
(function (DBD) {
    (function (FutanGendogakuNintei) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new FutanGendogakuNintei.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        FutanGendogakuNintei.PublicProperties = PublicProperties;
    })(DBD.FutanGendogakuNintei || (DBD.FutanGendogakuNintei = {}));
    var FutanGendogakuNintei = DBD.FutanGendogakuNintei;
})(DBD || (DBD = {}));
