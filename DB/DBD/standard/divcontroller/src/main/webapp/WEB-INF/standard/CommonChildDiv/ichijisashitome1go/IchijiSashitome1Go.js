var DBD;
(function (DBD) {
    (function (IchijiSashitome1Go) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new IchijiSashitome1Go.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new IchijiSashitome1Go.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        IchijiSashitome1Go.ModeController = ModeController;
    })(DBD.IchijiSashitome1Go || (DBD.IchijiSashitome1Go = {}));
    var IchijiSashitome1Go = DBD.IchijiSashitome1Go;
})(DBD || (DBD = {}));

var DBD;
(function (DBD) {
    (function (IchijiSashitome1Go) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new IchijiSashitome1Go.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        IchijiSashitome1Go.PublicProperties = PublicProperties;
    })(DBD.IchijiSashitome1Go || (DBD.IchijiSashitome1Go = {}));
    var IchijiSashitome1Go = DBD.IchijiSashitome1Go;
})(DBD || (DBD = {}));
