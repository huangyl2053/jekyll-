var DBC;
(function (DBC) {
    (function (JukyushaIdoRenrakuhyoSakuseiErrorList) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new JukyushaIdoRenrakuhyoSakuseiErrorList.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        JukyushaIdoRenrakuhyoSakuseiErrorList.ModeController = ModeController;
    })(DBC.JukyushaIdoRenrakuhyoSakuseiErrorList || (DBC.JukyushaIdoRenrakuhyoSakuseiErrorList = {}));
    var JukyushaIdoRenrakuhyoSakuseiErrorList = DBC.JukyushaIdoRenrakuhyoSakuseiErrorList;
})(DBC || (DBC = {}));

var DBC;
(function (DBC) {
    (function (JukyushaIdoRenrakuhyoSakuseiErrorList) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new JukyushaIdoRenrakuhyoSakuseiErrorList.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        JukyushaIdoRenrakuhyoSakuseiErrorList.PublicProperties = PublicProperties;
    })(DBC.JukyushaIdoRenrakuhyoSakuseiErrorList || (DBC.JukyushaIdoRenrakuhyoSakuseiErrorList = {}));
    var JukyushaIdoRenrakuhyoSakuseiErrorList = DBC.JukyushaIdoRenrakuhyoSakuseiErrorList;
})(DBC || (DBC = {}));
