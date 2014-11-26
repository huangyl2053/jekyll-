var DBC;
(function (DBC) {
    (function (OutputOrderAndNewpage) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new OutputOrderAndNewpage.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        OutputOrderAndNewpage.ModeController = ModeController;
    })(DBC.OutputOrderAndNewpage || (DBC.OutputOrderAndNewpage = {}));
    var OutputOrderAndNewpage = DBC.OutputOrderAndNewpage;
})(DBC || (DBC = {}));

var DBC;
(function (DBC) {
    (function (OutputOrderAndNewpage) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new OutputOrderAndNewpage.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("isGroupBox", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("title", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("txtNewPageItem_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            };

            PublicProperties.prototype.getisGroupBox = function () {
                return this.controls.OutputOrderAndNewpage().isGroupBox;
            };

            PublicProperties.prototype.setisGroupBox = function (value) {
                this.controls.OutputOrderAndNewpage().isGroupBox = value;
            };

            PublicProperties.prototype.gettitle = function () {
                return this.controls.OutputOrderAndNewpage().title;
            };

            PublicProperties.prototype.settitle = function (value) {
                this.controls.OutputOrderAndNewpage().title = value;
            };

            PublicProperties.prototype.gettxtNewPageItem_displayNone = function () {
                return this.controls.txtNewPageItem().displayNone;
            };

            PublicProperties.prototype.settxtNewPageItem_displayNone = function (value) {
                this.controls.txtNewPageItem().displayNone = value;
            };
            return PublicProperties;
        })();
        OutputOrderAndNewpage.PublicProperties = PublicProperties;
    })(DBC.OutputOrderAndNewpage || (DBC.OutputOrderAndNewpage = {}));
    var OutputOrderAndNewpage = DBC.OutputOrderAndNewpage;
})(DBC || (DBC = {}));
