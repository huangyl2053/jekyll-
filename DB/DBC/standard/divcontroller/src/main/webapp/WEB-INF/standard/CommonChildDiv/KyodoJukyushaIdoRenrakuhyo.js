var DBC;
(function (DBC) {
    (function (KyodoJukyushaIdoRenrakuhyo) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KyodoJukyushaIdoRenrakuhyo.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        KyodoJukyushaIdoRenrakuhyo.ModeController = ModeController;
    })(DBC.KyodoJukyushaIdoRenrakuhyo || (DBC.KyodoJukyushaIdoRenrakuhyo = {}));
    var KyodoJukyushaIdoRenrakuhyo = DBC.KyodoJukyushaIdoRenrakuhyo;
})(DBC || (DBC = {}));

var DBC;
(function (DBC) {
    (function (KyodoJukyushaIdoRenrakuhyo) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new KyodoJukyushaIdoRenrakuhyo.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("TeiseiInfoVisible", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TeiseiInfoDisplayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            };

            PublicProperties.prototype.getTeiseiInfoVisible = function () {
                return this.controls.KyodoJukyushaIdoRenrakuhyoTeisei().visible;
            };

            PublicProperties.prototype.setTeiseiInfoVisible = function (value) {
                this.controls.KyodoJukyushaIdoRenrakuhyoTeisei().visible = value;
            };

            PublicProperties.prototype.getTeiseiInfoDisplayNone = function () {
                return this.controls.KyodoJukyushaIdoRenrakuhyoTeisei().displayNone;
            };

            PublicProperties.prototype.setTeiseiInfoDisplayNone = function (value) {
                this.controls.KyodoJukyushaIdoRenrakuhyoTeisei().displayNone = value;
            };
            return PublicProperties;
        })();
        KyodoJukyushaIdoRenrakuhyo.PublicProperties = PublicProperties;
    })(DBC.KyodoJukyushaIdoRenrakuhyo || (DBC.KyodoJukyushaIdoRenrakuhyo = {}));
    var KyodoJukyushaIdoRenrakuhyo = DBC.KyodoJukyushaIdoRenrakuhyo;
})(DBC || (DBC = {}));
