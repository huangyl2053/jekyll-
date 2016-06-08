var DBC;
(function (DBC) {
    (function (ServiceRiyohyoRirekiList) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ServiceRiyohyoRirekiList.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        ServiceRiyohyoRirekiList.ModeController = ModeController;
    })(DBC.ServiceRiyohyoRirekiList || (DBC.ServiceRiyohyoRirekiList = {}));
    var ServiceRiyohyoRirekiList = DBC.ServiceRiyohyoRirekiList;
})(DBC || (DBC = {}));

var DBC;
(function (DBC) {
    (function (ServiceRiyohyoRirekiList) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new ServiceRiyohyoRirekiList.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("RirekiListHeight", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("RirekiListWidth", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            };

            PublicProperties.prototype.getRirekiListHeight = function () {
                return this.controls.dgServiceRiyohyoRirekiList().height;
            };

            PublicProperties.prototype.setRirekiListHeight = function (value) {
                this.controls.dgServiceRiyohyoRirekiList().height = value;
            };

            PublicProperties.prototype.getRirekiListWidth = function () {
                return this.controls.dgServiceRiyohyoRirekiList().width;
            };

            PublicProperties.prototype.setRirekiListWidth = function (value) {
                this.controls.dgServiceRiyohyoRirekiList().width = value;
            };
            return PublicProperties;
        })();
        ServiceRiyohyoRirekiList.PublicProperties = PublicProperties;
    })(DBC.ServiceRiyohyoRirekiList || (DBC.ServiceRiyohyoRirekiList = {}));
    var ServiceRiyohyoRirekiList = DBC.ServiceRiyohyoRirekiList;
})(DBC || (DBC = {}));
