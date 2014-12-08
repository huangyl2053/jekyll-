var DBC;
(function (DBC) {
    (function (ShokanShikyuShinseishoList) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShokanShikyuShinseishoList.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        ShokanShikyuShinseishoList.ModeController = ModeController;
    })(DBC.ShokanShikyuShinseishoList || (DBC.ShokanShikyuShinseishoList = {}));
    var ShokanShikyuShinseishoList = DBC.ShokanShikyuShinseishoList;
})(DBC || (DBC = {}));

var DBC;
(function (DBC) {
    (function (ShokanShikyuShinseishoList) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new ShokanShikyuShinseishoList.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("AddButtonVisible", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("AddButtonDisplayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("AddButtonOnClick", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("ShinseishoListHeight", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("ShinseishoListOnSelect", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("ShinseishoListOnSelectByDblClick", UZA.EditTypeEnumForPublicProperty.StringType);
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

            PublicProperties.prototype.getAddButtonOnClick = function () {
                return this.controls.btnAdd().onClick;
            };

            PublicProperties.prototype.setAddButtonOnClick = function (value) {
                this.controls.btnAdd().onClick = value;
            };

            PublicProperties.prototype.getShinseishoListHeight = function () {
                return this.controls.dgShokanShikyuShinseishoList().height;
            };

            PublicProperties.prototype.setShinseishoListHeight = function (value) {
                this.controls.dgShokanShikyuShinseishoList().height = value;
            };

            PublicProperties.prototype.getShinseishoListOnSelect = function () {
                return this.controls.dgShokanShikyuShinseishoList().onSelect;
            };

            PublicProperties.prototype.setShinseishoListOnSelect = function (value) {
                this.controls.dgShokanShikyuShinseishoList().onSelect = value;
            };

            PublicProperties.prototype.getShinseishoListOnSelectByDblClick = function () {
                return this.controls.dgShokanShikyuShinseishoList().onSelectByDblClick;
            };

            PublicProperties.prototype.setShinseishoListOnSelectByDblClick = function (value) {
                this.controls.dgShokanShikyuShinseishoList().onSelectByDblClick = value;
            };
            return PublicProperties;
        })();
        ShokanShikyuShinseishoList.PublicProperties = PublicProperties;
    })(DBC.ShokanShikyuShinseishoList || (DBC.ShokanShikyuShinseishoList = {}));
    var ShokanShikyuShinseishoList = DBC.ShokanShikyuShinseishoList;
})(DBC || (DBC = {}));
