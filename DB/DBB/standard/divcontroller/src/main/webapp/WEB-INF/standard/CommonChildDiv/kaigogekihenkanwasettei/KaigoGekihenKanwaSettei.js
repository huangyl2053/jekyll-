var DBB;
(function (DBB) {
    (function (KaigoGekihenKanwaSettei) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoGekihenKanwaSettei.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KaigoGekihenKanwaSettei.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        KaigoGekihenKanwaSettei.ModeController = ModeController;
    })(DBB.KaigoGekihenKanwaSettei || (DBB.KaigoGekihenKanwaSettei = {}));
    var KaigoGekihenKanwaSettei = DBB.KaigoGekihenKanwaSettei;
})(DBB || (DBB = {}));

var DBB;
(function (DBB) {
    (function (KaigoGekihenKanwaSettei) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoGekihenKanwaSettei.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        KaigoGekihenKanwaSettei.PublicProperties = PublicProperties;
    })(DBB.KaigoGekihenKanwaSettei || (DBB.KaigoGekihenKanwaSettei = {}));
    var KaigoGekihenKanwaSettei = DBB.KaigoGekihenKanwaSettei;
})(DBB || (DBB = {}));
