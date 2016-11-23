var DBD;
(function (DBD) {
    (function (TainoInfo) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new TainoInfo.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new TainoInfo.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        TainoInfo.ModeController = ModeController;
    })(DBD.TainoInfo || (DBD.TainoInfo = {}));
    var TainoInfo = DBD.TainoInfo;
})(DBD || (DBD = {}));

var DBD;
(function (DBD) {
    (function (TainoInfo) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new TainoInfo.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        TainoInfo.PublicProperties = PublicProperties;
    })(DBD.TainoInfo || (DBD.TainoInfo = {}));
    var TainoInfo = DBD.TainoInfo;
})(DBD || (DBD = {}));
