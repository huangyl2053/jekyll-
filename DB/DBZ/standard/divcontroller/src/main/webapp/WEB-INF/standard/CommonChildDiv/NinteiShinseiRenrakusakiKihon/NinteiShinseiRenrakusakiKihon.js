var DBZ;
(function (DBZ) {
    (function (NinteiShinseiRenrakusakiKihon) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new NinteiShinseiRenrakusakiKihon.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new NinteiShinseiRenrakusakiKihon.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        NinteiShinseiRenrakusakiKihon.ModeController = ModeController;
    })(DBZ.NinteiShinseiRenrakusakiKihon || (DBZ.NinteiShinseiRenrakusakiKihon = {}));
    var NinteiShinseiRenrakusakiKihon = DBZ.NinteiShinseiRenrakusakiKihon;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (NinteiShinseiRenrakusakiKihon) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new NinteiShinseiRenrakusakiKihon.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        NinteiShinseiRenrakusakiKihon.PublicProperties = PublicProperties;
    })(DBZ.NinteiShinseiRenrakusakiKihon || (DBZ.NinteiShinseiRenrakusakiKihon = {}));
    var NinteiShinseiRenrakusakiKihon = DBZ.NinteiShinseiRenrakusakiKihon;
})(DBZ || (DBZ = {}));
