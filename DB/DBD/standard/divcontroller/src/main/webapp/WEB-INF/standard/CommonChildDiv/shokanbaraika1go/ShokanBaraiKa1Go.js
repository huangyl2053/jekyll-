var DBD;
(function (DBD) {
    (function (ShokanBaraiKa1Go) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShokanBaraiKa1Go.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ShokanBaraiKa1Go.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        ShokanBaraiKa1Go.ModeController = ModeController;
    })(DBD.ShokanBaraiKa1Go || (DBD.ShokanBaraiKa1Go = {}));
    var ShokanBaraiKa1Go = DBD.ShokanBaraiKa1Go;
})(DBD || (DBD = {}));

var DBD;
(function (DBD) {
    (function (ShokanBaraiKa1Go) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShokanBaraiKa1Go.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ShokanBaraiKa1Go.PublicProperties = PublicProperties;
    })(DBD.ShokanBaraiKa1Go || (DBD.ShokanBaraiKa1Go = {}));
    var ShokanBaraiKa1Go = DBD.ShokanBaraiKa1Go;
})(DBD || (DBD = {}));
