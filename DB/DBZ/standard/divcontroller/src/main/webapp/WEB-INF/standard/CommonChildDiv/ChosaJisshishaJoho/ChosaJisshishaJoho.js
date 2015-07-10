var DBZ;
(function (DBZ) {
    (function (ChosaJisshishaJoho) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ChosaJisshishaJoho.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ChosaJisshishaJoho.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        ChosaJisshishaJoho.ModeController = ModeController;
    })(DBZ.ChosaJisshishaJoho || (DBZ.ChosaJisshishaJoho = {}));
    var ChosaJisshishaJoho = DBZ.ChosaJisshishaJoho;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (ChosaJisshishaJoho) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ChosaJisshishaJoho.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ChosaJisshishaJoho.PublicProperties = PublicProperties;
    })(DBZ.ChosaJisshishaJoho || (DBZ.ChosaJisshishaJoho = {}));
    var ChosaJisshishaJoho = DBZ.ChosaJisshishaJoho;
})(DBZ || (DBZ = {}));
