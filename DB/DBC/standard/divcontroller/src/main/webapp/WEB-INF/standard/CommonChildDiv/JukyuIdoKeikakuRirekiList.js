var DBC;
(function (DBC) {
    (function (JukyuIdoKeikakuRirekiList) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new JukyuIdoKeikakuRirekiList.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new JukyuIdoKeikakuRirekiList.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        JukyuIdoKeikakuRirekiList.ModeController = ModeController;
    })(DBC.JukyuIdoKeikakuRirekiList || (DBC.JukyuIdoKeikakuRirekiList = {}));
    var JukyuIdoKeikakuRirekiList = DBC.JukyuIdoKeikakuRirekiList;
})(DBC || (DBC = {}));

var DBC;
(function (DBC) {
    (function (JukyuIdoKeikakuRirekiList) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new JukyuIdoKeikakuRirekiList.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        JukyuIdoKeikakuRirekiList.PublicProperties = PublicProperties;
    })(DBC.JukyuIdoKeikakuRirekiList || (DBC.JukyuIdoKeikakuRirekiList = {}));
    var JukyuIdoKeikakuRirekiList = DBC.JukyuIdoKeikakuRirekiList;
})(DBC || (DBC = {}));
