var DBB;
(function (DBB) {
    (function (ShunoJoho) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShunoJoho.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        ShunoJoho.ModeController = ModeController;
    })(DBB.ShunoJoho || (DBB.ShunoJoho = {}));
    var ShunoJoho = DBB.ShunoJoho;
})(DBB || (DBB = {}));

var DBB;
(function (DBB) {
    (function (ShunoJoho) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new ShunoJoho.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ShunoJoho.PublicProperties = PublicProperties;
    })(DBB.ShunoJoho || (DBB.ShunoJoho = {}));
    var ShunoJoho = DBB.ShunoJoho;
})(DBB || (DBB = {}));
