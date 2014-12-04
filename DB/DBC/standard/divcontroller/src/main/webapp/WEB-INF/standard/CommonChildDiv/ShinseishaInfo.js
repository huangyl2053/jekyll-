var DBC;
(function (DBC) {
    (function (ShinseishaInfo) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShinseishaInfo.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        ShinseishaInfo.ModeController = ModeController;
    })(DBC.ShinseishaInfo || (DBC.ShinseishaInfo = {}));
    var ShinseishaInfo = DBC.ShinseishaInfo;
})(DBC || (DBC = {}));

var DBC;
(function (DBC) {
    (function (ShinseishaInfo) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new ShinseishaInfo.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("btnSearch_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            };

            PublicProperties.prototype.getbtnSearch_displayNone = function () {
                return this.controls.btnSearchJigyosha().displayNone;
            };

            PublicProperties.prototype.setbtnSearch_displayNone = function (value) {
                this.controls.btnSearchJigyosha().displayNone = value;
            };
            return PublicProperties;
        })();
        ShinseishaInfo.PublicProperties = PublicProperties;
    })(DBC.ShinseishaInfo || (DBC.ShinseishaInfo = {}));
    var ShinseishaInfo = DBC.ShinseishaInfo;
})(DBC || (DBC = {}));
