var DBE;
(function (DBE) {
    (function (KaigoHihokenshaJoho) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoHihokenshaJoho.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        KaigoHihokenshaJoho.ModeController = ModeController;
    })(DBE.KaigoHihokenshaJoho || (DBE.KaigoHihokenshaJoho = {}));
    var KaigoHihokenshaJoho = DBE.KaigoHihokenshaJoho;
})(DBE || (DBE = {}));

var DBE;
(function (DBE) {
    (function (KaigoHihokenshaJoho) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new KaigoHihokenshaJoho.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        KaigoHihokenshaJoho.PublicProperties = PublicProperties;
    })(DBE.KaigoHihokenshaJoho || (DBE.KaigoHihokenshaJoho = {}));
    var KaigoHihokenshaJoho = DBE.KaigoHihokenshaJoho;
})(DBE || (DBE = {}));
