var DBC;
(function (DBC) {
    (function (ShotokuJokyo) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShotokuJokyo.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ShotokuJokyo.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        ShotokuJokyo.ModeController = ModeController;
    })(DBC.ShotokuJokyo || (DBC.ShotokuJokyo = {}));
    var ShotokuJokyo = DBC.ShotokuJokyo;
})(DBC || (DBC = {}));

var DBC;
(function (DBC) {
    (function (ShotokuJokyo) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShotokuJokyo.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ShotokuJokyo.PublicProperties = PublicProperties;
    })(DBC.ShotokuJokyo || (DBC.ShotokuJokyo = {}));
    var ShotokuJokyo = DBC.ShotokuJokyo;
})(DBC || (DBC = {}));
