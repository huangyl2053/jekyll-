var DBC;
(function (DBC) {
    (function (JukyushaIdoRenrakuhyo) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new JukyushaIdoRenrakuhyo.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        JukyushaIdoRenrakuhyo.ModeController = ModeController;
    })(DBC.JukyushaIdoRenrakuhyo || (DBC.JukyushaIdoRenrakuhyo = {}));
    var JukyushaIdoRenrakuhyo = DBC.JukyushaIdoRenrakuhyo;
})(DBC || (DBC = {}));

var DBC;
(function (DBC) {
    (function (JukyushaIdoRenrakuhyo) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new JukyushaIdoRenrakuhyo.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("TeiseiInfoVisible", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TeiseiInfoDisplayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            };

            PublicProperties.prototype.getTeiseiInfoVisible = function () {
                return this.controls.JukyushaIdoRenrakuhyoTeisei().visible;
            };

            PublicProperties.prototype.setTeiseiInfoVisible = function (value) {
                this.controls.JukyushaIdoRenrakuhyoTeisei().visible = value;
            };

            PublicProperties.prototype.getTeiseiInfoDisplayNone = function () {
                return this.controls.JukyushaIdoRenrakuhyoTeisei().displayNone;
            };

            PublicProperties.prototype.setTeiseiInfoDisplayNone = function (value) {
                this.controls.JukyushaIdoRenrakuhyoTeisei().displayNone = value;
            };
            return PublicProperties;
        })();
        JukyushaIdoRenrakuhyo.PublicProperties = PublicProperties;
    })(DBC.JukyushaIdoRenrakuhyo || (DBC.JukyushaIdoRenrakuhyo = {}));
    var JukyushaIdoRenrakuhyo = DBC.JukyushaIdoRenrakuhyo;
})(DBC || (DBC = {}));
