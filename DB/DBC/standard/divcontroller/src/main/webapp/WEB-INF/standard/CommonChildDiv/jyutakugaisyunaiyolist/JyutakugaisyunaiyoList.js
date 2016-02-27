var DBC;
(function (DBC) {
    (function (JyutakugaisyunaiyoList) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new JyutakugaisyunaiyoList.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new JyutakugaisyunaiyoList.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        JyutakugaisyunaiyoList.ModeController = ModeController;
    })(DBC.JyutakugaisyunaiyoList || (DBC.JyutakugaisyunaiyoList = {}));
    var JyutakugaisyunaiyoList = DBC.JyutakugaisyunaiyoList;
})(DBC || (DBC = {}));

var DBC;
(function (DBC) {
    (function (JyutakugaisyunaiyoList) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new JyutakugaisyunaiyoList.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        JyutakugaisyunaiyoList.PublicProperties = PublicProperties;
    })(DBC.JyutakugaisyunaiyoList || (DBC.JyutakugaisyunaiyoList = {}));
    var JyutakugaisyunaiyoList = DBC.JyutakugaisyunaiyoList;
})(DBC || (DBC = {}));
