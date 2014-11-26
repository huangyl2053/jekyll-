var DBC;
(function (DBC) {
    (function (JutakuKaishuJizenShinsei) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new JutakuKaishuJizenShinsei.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        JutakuKaishuJizenShinsei.ModeController = ModeController;
    })(DBC.JutakuKaishuJizenShinsei || (DBC.JutakuKaishuJizenShinsei = {}));
    var JutakuKaishuJizenShinsei = DBC.JutakuKaishuJizenShinsei;
})(DBC || (DBC = {}));

var DBC;
(function (DBC) {
    (function (JutakuKaishuJizenShinsei) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new JutakuKaishuJizenShinsei.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        JutakuKaishuJizenShinsei.PublicProperties = PublicProperties;
    })(DBC.JutakuKaishuJizenShinsei || (DBC.JutakuKaishuJizenShinsei = {}));
    var JutakuKaishuJizenShinsei = DBC.JutakuKaishuJizenShinsei;
})(DBC || (DBC = {}));
