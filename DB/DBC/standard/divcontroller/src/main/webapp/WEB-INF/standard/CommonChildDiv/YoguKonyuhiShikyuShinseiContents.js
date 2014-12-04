var DBC;
(function (DBC) {
    (function (YoguKonyuhiShikyuShinseiContents) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new YoguKonyuhiShikyuShinseiContents.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        YoguKonyuhiShikyuShinseiContents.ModeController = ModeController;
    })(DBC.YoguKonyuhiShikyuShinseiContents || (DBC.YoguKonyuhiShikyuShinseiContents = {}));
    var YoguKonyuhiShikyuShinseiContents = DBC.YoguKonyuhiShikyuShinseiContents;
})(DBC || (DBC = {}));

var DBC;
(function (DBC) {
    (function (YoguKonyuhiShikyuShinseiContents) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new YoguKonyuhiShikyuShinseiContents.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("AddSeikyuDetailOnclick", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            };

            PublicProperties.prototype.getAddSeikyuDetailOnclick = function () {
                return this.controls.btnAddSeikyuDetail().onClick;
            };

            PublicProperties.prototype.setAddSeikyuDetailOnclick = function (value) {
                this.controls.btnAddSeikyuDetail().onClick = value;
            };
            return PublicProperties;
        })();
        YoguKonyuhiShikyuShinseiContents.PublicProperties = PublicProperties;
    })(DBC.YoguKonyuhiShikyuShinseiContents || (DBC.YoguKonyuhiShikyuShinseiContents = {}));
    var YoguKonyuhiShikyuShinseiContents = DBC.YoguKonyuhiShikyuShinseiContents;
})(DBC || (DBC = {}));
