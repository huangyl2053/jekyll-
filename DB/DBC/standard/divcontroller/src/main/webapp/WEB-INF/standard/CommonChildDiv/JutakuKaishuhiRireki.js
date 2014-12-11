var DBC;
(function (DBC) {
    (function (JutakuKaishuhiRireki) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new JutakuKaishuhiRireki.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        JutakuKaishuhiRireki.ModeController = ModeController;
    })(DBC.JutakuKaishuhiRireki || (DBC.JutakuKaishuhiRireki = {}));
    var JutakuKaishuhiRireki = DBC.JutakuKaishuhiRireki;
})(DBC || (DBC = {}));

var DBC;
(function (DBC) {
    (function (JutakuKaishuhiRireki) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new JutakuKaishuhiRireki.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        JutakuKaishuhiRireki.PublicProperties = PublicProperties;
    })(DBC.JutakuKaishuhiRireki || (DBC.JutakuKaishuhiRireki = {}));
    var JutakuKaishuhiRireki = DBC.JutakuKaishuhiRireki;
})(DBC || (DBC = {}));
