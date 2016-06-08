var DBC;
(function (DBC) {
    (function (ServiceTeikyoShomeishoShukeiList) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ServiceTeikyoShomeishoShukeiList.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        ServiceTeikyoShomeishoShukeiList.ModeController = ModeController;
    })(DBC.ServiceTeikyoShomeishoShukeiList || (DBC.ServiceTeikyoShomeishoShukeiList = {}));
    var ServiceTeikyoShomeishoShukeiList = DBC.ServiceTeikyoShomeishoShukeiList;
})(DBC || (DBC = {}));

var DBC;
(function (DBC) {
    (function (ServiceTeikyoShomeishoShukeiList) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new ServiceTeikyoShomeishoShukeiList.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("AddButtonVisible", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("AddButtonDisplayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("AddButtonOnClick", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("MeisaiListHeight", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("MeisaiListOnSelect", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("MeisaiListOnSelectByDblClick", UZA.EditTypeEnumForPublicProperty.StringType);
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

            PublicProperties.prototype.getMeisaiListHeight = function () {
                return this.controls.dgServiceTeikyoShomeishoShukeiList().height;
            };

            PublicProperties.prototype.setMeisaiListHeight = function (value) {
                this.controls.dgServiceTeikyoShomeishoShukeiList().height = value;
            };

            PublicProperties.prototype.getMeisaiListOnSelect = function () {
                return this.controls.dgServiceTeikyoShomeishoShukeiList().onSelect;
            };

            PublicProperties.prototype.setMeisaiListOnSelect = function (value) {
                this.controls.dgServiceTeikyoShomeishoShukeiList().onSelect = value;
            };

            PublicProperties.prototype.getMeisaiListOnSelectByDblClick = function () {
                return this.controls.dgServiceTeikyoShomeishoShukeiList().onSelectByDblClick;
            };

            PublicProperties.prototype.setMeisaiListOnSelectByDblClick = function (value) {
                this.controls.dgServiceTeikyoShomeishoShukeiList().onSelectByDblClick = value;
            };
            return PublicProperties;
        })();
        ServiceTeikyoShomeishoShukeiList.PublicProperties = PublicProperties;
    })(DBC.ServiceTeikyoShomeishoShukeiList || (DBC.ServiceTeikyoShomeishoShukeiList = {}));
    var ServiceTeikyoShomeishoShukeiList = DBC.ServiceTeikyoShomeishoShukeiList;
})(DBC || (DBC = {}));
