var DBC;
(function (DBC) {
    (function (JutakuKaishuJizenShinseiTab) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new JutakuKaishuJizenShinseiTab.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        JutakuKaishuJizenShinseiTab.ModeController = ModeController;
    })(DBC.JutakuKaishuJizenShinseiTab || (DBC.JutakuKaishuJizenShinseiTab = {}));
    var JutakuKaishuJizenShinseiTab = DBC.JutakuKaishuJizenShinseiTab;
})(DBC || (DBC = {}));

var DBC;
(function (DBC) {
    (function (JutakuKaishuJizenShinseiTab) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new JutakuKaishuJizenShinseiTab.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        JutakuKaishuJizenShinseiTab.PublicProperties = PublicProperties;
    })(DBC.JutakuKaishuJizenShinseiTab || (DBC.JutakuKaishuJizenShinseiTab = {}));
    var JutakuKaishuJizenShinseiTab = DBC.JutakuKaishuJizenShinseiTab;
})(DBC || (DBC = {}));
