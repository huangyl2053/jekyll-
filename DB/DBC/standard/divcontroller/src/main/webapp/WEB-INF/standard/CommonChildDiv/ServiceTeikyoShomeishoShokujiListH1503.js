var DBC;
(function (DBC) {
    (function (ServiceTeikyoShomeishoShokujiListH1503) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ServiceTeikyoShomeishoShokujiListH1503.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        ServiceTeikyoShomeishoShokujiListH1503.ModeController = ModeController;
    })(DBC.ServiceTeikyoShomeishoShokujiListH1503 || (DBC.ServiceTeikyoShomeishoShokujiListH1503 = {}));
    var ServiceTeikyoShomeishoShokujiListH1503 = DBC.ServiceTeikyoShomeishoShokujiListH1503;
})(DBC || (DBC = {}));

var DBC;
(function (DBC) {
    (function (ServiceTeikyoShomeishoShokujiListH1503) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new ServiceTeikyoShomeishoShokujiListH1503.Controls(fieldName);
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
                return this.controls.dgServiceTeikyoShomeishoShokujiListH1503().height;
            };

            PublicProperties.prototype.setMeisaiListHeight = function (value) {
                this.controls.dgServiceTeikyoShomeishoShokujiListH1503().height = value;
            };

            PublicProperties.prototype.getMeisaiListOnSelect = function () {
                return this.controls.dgServiceTeikyoShomeishoShokujiListH1503().onSelect;
            };

            PublicProperties.prototype.setMeisaiListOnSelect = function (value) {
                this.controls.dgServiceTeikyoShomeishoShokujiListH1503().onSelect = value;
            };

            PublicProperties.prototype.getMeisaiListOnSelectByDblClick = function () {
                return this.controls.dgServiceTeikyoShomeishoShokujiListH1503().onSelectByDblClick;
            };

            PublicProperties.prototype.setMeisaiListOnSelectByDblClick = function (value) {
                this.controls.dgServiceTeikyoShomeishoShokujiListH1503().onSelectByDblClick = value;
            };
            return PublicProperties;
        })();
        ServiceTeikyoShomeishoShokujiListH1503.PublicProperties = PublicProperties;
    })(DBC.ServiceTeikyoShomeishoShokujiListH1503 || (DBC.ServiceTeikyoShomeishoShokujiListH1503 = {}));
    var ServiceTeikyoShomeishoShokujiListH1503 = DBC.ServiceTeikyoShomeishoShokujiListH1503;
})(DBC || (DBC = {}));
