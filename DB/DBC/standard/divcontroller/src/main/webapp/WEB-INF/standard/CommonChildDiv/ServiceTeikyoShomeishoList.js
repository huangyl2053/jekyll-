var DBC;
(function (DBC) {
    (function (ServiceTeikyoShomeishoList) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ServiceTeikyoShomeishoList.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        ServiceTeikyoShomeishoList.ModeController = ModeController;
    })(DBC.ServiceTeikyoShomeishoList || (DBC.ServiceTeikyoShomeishoList = {}));
    var ServiceTeikyoShomeishoList = DBC.ServiceTeikyoShomeishoList;
})(DBC || (DBC = {}));

var DBC;
(function (DBC) {
    (function (ServiceTeikyoShomeishoList) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new ServiceTeikyoShomeishoList.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("AddButtonVisible", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("AddButtonDisplayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("AddButtonOnClick", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("ShomeishoHeight", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("ShomeishoOnSelect", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("ShomeishoOnSelectDblClick", UZA.EditTypeEnumForPublicProperty.StringType);
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

            PublicProperties.prototype.getShomeishoHeight = function () {
                return this.controls.dgServiceTeikyoShomeishoList().height;
            };

            PublicProperties.prototype.setShomeishoHeight = function (value) {
                this.controls.dgServiceTeikyoShomeishoList().height = value;
            };

            PublicProperties.prototype.getShomeishoOnSelect = function () {
                return this.controls.dgServiceTeikyoShomeishoList().onSelect;
            };

            PublicProperties.prototype.setShomeishoOnSelect = function (value) {
                this.controls.dgServiceTeikyoShomeishoList().onSelect = value;
            };

            PublicProperties.prototype.getShomeishoOnSelectDblClick = function () {
                return this.controls.dgServiceTeikyoShomeishoList().onSelectByDblClick;
            };

            PublicProperties.prototype.setShomeishoOnSelectDblClick = function (value) {
                this.controls.dgServiceTeikyoShomeishoList().onSelectByDblClick = value;
            };
            return PublicProperties;
        })();
        ServiceTeikyoShomeishoList.PublicProperties = PublicProperties;
    })(DBC.ServiceTeikyoShomeishoList || (DBC.ServiceTeikyoShomeishoList = {}));
    var ServiceTeikyoShomeishoList = DBC.ServiceTeikyoShomeishoList;
})(DBC || (DBC = {}));
