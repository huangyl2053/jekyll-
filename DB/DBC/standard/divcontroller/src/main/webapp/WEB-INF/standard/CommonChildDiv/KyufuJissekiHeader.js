var DBC;
(function (DBC) {
    (function (KyufuJissekiHeader) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KyufuJissekiHeader.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
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
                this.controls = new KyufuJissekiHeader.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("txtJigyoshaVisible", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtJigyoshaDisplayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            };

            PublicProperties.prototype.gettxtJigyoshaVisible = function () {
                return this.controls.txtJigyosha().visible;
            };

            PublicProperties.prototype.settxtJigyoshaVisible = function (value) {
                this.controls.txtJigyosha().visible = value;
            };

            PublicProperties.prototype.gettxtJigyoshaDisplayNone = function () {
                return this.controls.txtJigyosha().displayNone;
            };

            PublicProperties.prototype.settxtJigyoshaDisplayNone = function (value) {
                this.controls.txtJigyosha().displayNone = value;
            };
            return PublicProperties;
        })();
        KyufuJissekiHeader.PublicProperties = PublicProperties;
    })(DBC.KyufuJissekiHeader || (DBC.KyufuJissekiHeader = {}));
    var KyufuJissekiHeader = DBC.KyufuJissekiHeader;
})(DBC || (DBC = {}));
