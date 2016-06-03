var DBC;
(function (DBC) {
    (function (KyufuseigenRirekiList) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KyufuseigenRirekiList.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KyufuseigenRirekiList.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        KyufuseigenRirekiList.ModeController = ModeController;
    })(DBC.KyufuseigenRirekiList || (DBC.KyufuseigenRirekiList = {}));
    var KyufuseigenRirekiList = DBC.KyufuseigenRirekiList;
})(DBC || (DBC = {}));

var DBC;
(function (DBC) {
    (function (KyufuseigenRirekiList) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KyufuseigenRirekiList.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        KyufuseigenRirekiList.PublicProperties = PublicProperties;
    })(DBC.KyufuseigenRirekiList || (DBC.KyufuseigenRirekiList = {}));
    var KyufuseigenRirekiList = DBC.KyufuseigenRirekiList;
})(DBC || (DBC = {}));
