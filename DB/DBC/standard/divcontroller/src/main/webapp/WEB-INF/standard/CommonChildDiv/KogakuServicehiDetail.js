var DBC;
(function (DBC) {
    (function (KogakuServicehiDetail) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KogakuServicehiDetail.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KogakuServicehiDetail.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        KogakuServicehiDetail.ModeController = ModeController;
    })(DBC.KogakuServicehiDetail || (DBC.KogakuServicehiDetail = {}));
    var KogakuServicehiDetail = DBC.KogakuServicehiDetail;
})(DBC || (DBC = {}));

var DBC;
(function (DBC) {
    (function (KogakuServicehiDetail) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KogakuServicehiDetail.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        KogakuServicehiDetail.PublicProperties = PublicProperties;
    })(DBC.KogakuServicehiDetail || (DBC.KogakuServicehiDetail = {}));
    var KogakuServicehiDetail = DBC.KogakuServicehiDetail;
})(DBC || (DBC = {}));
