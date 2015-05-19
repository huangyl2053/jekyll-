var DBZ;
(function (DBZ) {
    (function (NinteiShinseiShichosonRenrakuJoho) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new NinteiShinseiShichosonRenrakuJoho.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new NinteiShinseiShichosonRenrakuJoho.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        NinteiShinseiShichosonRenrakuJoho.ModeController = ModeController;
    })(DBZ.NinteiShinseiShichosonRenrakuJoho || (DBZ.NinteiShinseiShichosonRenrakuJoho = {}));
    var NinteiShinseiShichosonRenrakuJoho = DBZ.NinteiShinseiShichosonRenrakuJoho;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (NinteiShinseiShichosonRenrakuJoho) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new NinteiShinseiShichosonRenrakuJoho.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        NinteiShinseiShichosonRenrakuJoho.PublicProperties = PublicProperties;
    })(DBZ.NinteiShinseiShichosonRenrakuJoho || (DBZ.NinteiShinseiShichosonRenrakuJoho = {}));
    var NinteiShinseiShichosonRenrakuJoho = DBZ.NinteiShinseiShichosonRenrakuJoho;
})(DBZ || (DBZ = {}));
