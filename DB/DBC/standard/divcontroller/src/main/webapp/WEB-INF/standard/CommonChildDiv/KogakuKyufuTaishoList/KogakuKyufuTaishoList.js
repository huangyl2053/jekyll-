var DBC;
(function (DBC) {
    (function (KogakuKyufuTaishoList) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KogakuKyufuTaishoList.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KogakuKyufuTaishoList.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        KogakuKyufuTaishoList.ModeController = ModeController;
    })(DBC.KogakuKyufuTaishoList || (DBC.KogakuKyufuTaishoList = {}));
    var KogakuKyufuTaishoList = DBC.KogakuKyufuTaishoList;
})(DBC || (DBC = {}));

var DBC;
(function (DBC) {
    (function (KogakuKyufuTaishoList) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KogakuKyufuTaishoList.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        KogakuKyufuTaishoList.PublicProperties = PublicProperties;
    })(DBC.KogakuKyufuTaishoList || (DBC.KogakuKyufuTaishoList = {}));
    var KogakuKyufuTaishoList = DBC.KogakuKyufuTaishoList;
})(DBC || (DBC = {}));
