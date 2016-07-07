var DBD;
(function (DBD) {
    (function (GengakuInfo) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new GengakuInfo.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new GengakuInfo.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        GengakuInfo.ModeController = ModeController;
    })(DBD.GengakuInfo || (DBD.GengakuInfo = {}));
    var GengakuInfo = DBD.GengakuInfo;
})(DBD || (DBD = {}));

var DBD;
(function (DBD) {
    (function (GengakuInfo) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new GengakuInfo.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        GengakuInfo.PublicProperties = PublicProperties;
    })(DBD.GengakuInfo || (DBD.GengakuInfo = {}));
    var GengakuInfo = DBD.GengakuInfo;
})(DBD || (DBD = {}));
