var DBD;
(function (DBD) {
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
    })(DBD.ShotokuJokyo || (DBD.ShotokuJokyo = {}));
    var ShotokuJokyo = DBD.ShotokuJokyo;
})(DBD || (DBD = {}));

var DBD;
(function (DBD) {
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
    })(DBD.ShotokuJokyo || (DBD.ShotokuJokyo = {}));
    var ShotokuJokyo = DBD.ShotokuJokyo;
})(DBD || (DBD = {}));
