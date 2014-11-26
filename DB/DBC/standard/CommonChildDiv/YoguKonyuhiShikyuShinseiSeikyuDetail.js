var DBC;
(function (DBC) {
    (function (YoguKonyuhiShikyuShinseiSeikyuDetail) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new YoguKonyuhiShikyuShinseiSeikyuDetail.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        YoguKonyuhiShikyuShinseiSeikyuDetail.ModeController = ModeController;
    })(DBC.YoguKonyuhiShikyuShinseiSeikyuDetail || (DBC.YoguKonyuhiShikyuShinseiSeikyuDetail = {}));
    var YoguKonyuhiShikyuShinseiSeikyuDetail = DBC.YoguKonyuhiShikyuShinseiSeikyuDetail;
})(DBC || (DBC = {}));

var DBC;
(function (DBC) {
    (function (YoguKonyuhiShikyuShinseiSeikyuDetail) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new YoguKonyuhiShikyuShinseiSeikyuDetail.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("btnModifyDetail_onClick", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("btnModifyDetail_text", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            };

            PublicProperties.prototype.getbtnModifyDetail_onClick = function () {
                return this.controls.btnModifyDetail().onClick;
            };

            PublicProperties.prototype.setbtnModifyDetail_onClick = function (value) {
                this.controls.btnModifyDetail().onClick = value;
            };

            PublicProperties.prototype.getbtnModifyDetail_text = function () {
                return this.controls.btnModifyDetail().text;
            };

            PublicProperties.prototype.setbtnModifyDetail_text = function (value) {
                this.controls.btnModifyDetail().text = value;
            };
            return PublicProperties;
        })();
        YoguKonyuhiShikyuShinseiSeikyuDetail.PublicProperties = PublicProperties;
    })(DBC.YoguKonyuhiShikyuShinseiSeikyuDetail || (DBC.YoguKonyuhiShikyuShinseiSeikyuDetail = {}));
    var YoguKonyuhiShikyuShinseiSeikyuDetail = DBC.YoguKonyuhiShikyuShinseiSeikyuDetail;
})(DBC || (DBC = {}));
