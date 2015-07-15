var DBD;
(function (DBD) {
    (function (KaigoNinteiShinchokuJokyoKojin) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoNinteiShinchokuJokyoKojin.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KaigoNinteiShinchokuJokyoKojin.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        KaigoNinteiShinchokuJokyoKojin.ModeController = ModeController;
    })(DBD.KaigoNinteiShinchokuJokyoKojin || (DBD.KaigoNinteiShinchokuJokyoKojin = {}));
    var KaigoNinteiShinchokuJokyoKojin = DBD.KaigoNinteiShinchokuJokyoKojin;
})(DBD || (DBD = {}));

var DBD;
(function (DBD) {
    (function (KaigoNinteiShinchokuJokyoKojin) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoNinteiShinchokuJokyoKojin.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        KaigoNinteiShinchokuJokyoKojin.PublicProperties = PublicProperties;
    })(DBD.KaigoNinteiShinchokuJokyoKojin || (DBD.KaigoNinteiShinchokuJokyoKojin = {}));
    var KaigoNinteiShinchokuJokyoKojin = DBD.KaigoNinteiShinchokuJokyoKojin;
})(DBD || (DBD = {}));
