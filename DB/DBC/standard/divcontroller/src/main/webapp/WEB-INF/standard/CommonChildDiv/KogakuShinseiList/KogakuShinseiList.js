var DBC;
(function (DBC) {
    (function (KogakuShinseiList) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KogakuShinseiList.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KogakuShinseiList.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        KogakuShinseiList.ModeController = ModeController;
    })(DBC.KogakuShinseiList || (DBC.KogakuShinseiList = {}));
    var KogakuShinseiList = DBC.KogakuShinseiList;
})(DBC || (DBC = {}));

var DBC;
(function (DBC) {
    (function (KogakuShinseiList) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KogakuShinseiList.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        KogakuShinseiList.PublicProperties = PublicProperties;
    })(DBC.KogakuShinseiList || (DBC.KogakuShinseiList = {}));
    var KogakuShinseiList = DBC.KogakuShinseiList;
})(DBC || (DBC = {}));
