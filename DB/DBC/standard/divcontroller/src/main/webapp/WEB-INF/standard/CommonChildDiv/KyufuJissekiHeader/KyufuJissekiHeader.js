var DBC;
(function (DBC) {
    (function (KyufuJissekiHeader) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KyufuJissekiHeader.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KyufuJissekiHeader.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        KyufuJissekiHeader.ModeController = ModeController;
    })(DBC.KyufuJissekiHeader || (DBC.KyufuJissekiHeader = {}));
    var KyufuJissekiHeader = DBC.KyufuJissekiHeader;
})(DBC || (DBC = {}));

var DBC;
(function (DBC) {
    (function (KyufuJissekiHeader) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KyufuJissekiHeader.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        KyufuJissekiHeader.PublicProperties = PublicProperties;
    })(DBC.KyufuJissekiHeader || (DBC.KyufuJissekiHeader = {}));
    var KyufuJissekiHeader = DBC.KyufuJissekiHeader;
})(DBC || (DBC = {}));
