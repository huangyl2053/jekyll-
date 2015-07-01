var DBZ;
(function (DBZ) {
    (function (KaigohokenShikakuKihonJoho) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigohokenShikakuKihonJoho.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KaigohokenShikakuKihonJoho.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        KaigohokenShikakuKihonJoho.ModeController = ModeController;
    })(DBZ.KaigohokenShikakuKihonJoho || (DBZ.KaigohokenShikakuKihonJoho = {}));
    var KaigohokenShikakuKihonJoho = DBZ.KaigohokenShikakuKihonJoho;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (KaigohokenShikakuKihonJoho) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigohokenShikakuKihonJoho.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        KaigohokenShikakuKihonJoho.PublicProperties = PublicProperties;
    })(DBZ.KaigohokenShikakuKihonJoho || (DBZ.KaigohokenShikakuKihonJoho = {}));
    var KaigohokenShikakuKihonJoho = DBZ.KaigohokenShikakuKihonJoho;
})(DBZ || (DBZ = {}));
