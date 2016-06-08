var DBC;
(function (DBC) {
    (function (KyufuhiKashitsukekinList) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KyufuhiKashitsukekinList.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        KyufuhiKashitsukekinList.ModeController = ModeController;
    })(DBC.KyufuhiKashitsukekinList || (DBC.KyufuhiKashitsukekinList = {}));
    var KyufuhiKashitsukekinList = DBC.KyufuhiKashitsukekinList;
})(DBC || (DBC = {}));

var DBC;
(function (DBC) {
    (function (KyufuhiKashitsukekinList) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new KyufuhiKashitsukekinList.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("AddButtonVisible", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("AddButtonDisplayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("ListHeight", UZA.EditTypeEnumForPublicProperty.StringType);

                return editTypes;
            };

            PublicProperties.prototype.getAddButtonVisible = function () {
                return this.controls.btnAdd().visible;
            };

            PublicProperties.prototype.setAddButtonVisible = function (value) {
                this.controls.btnAdd().visible = value;
            };

            PublicProperties.prototype.getAddButtonDisplayNone = function () {
                return this.controls.btnAdd().displayNone;
            };

            PublicProperties.prototype.setAddButtonDisplayNone = function (value) {
                this.controls.btnAdd().displayNone = value;
            };

            PublicProperties.prototype.getListHeight = function () {
                return this.controls.dgKyufuhiKashitsukekinList().height;
            };

            PublicProperties.prototype.setListHeight = function (value) {
                this.controls.dgKyufuhiKashitsukekinList().height = value;
            };
            return PublicProperties;
        })();
        KyufuhiKashitsukekinList.PublicProperties = PublicProperties;
    })(DBC.KyufuhiKashitsukekinList || (DBC.KyufuhiKashitsukekinList = {}));
    var KyufuhiKashitsukekinList = DBC.KyufuhiKashitsukekinList;
})(DBC || (DBC = {}));
