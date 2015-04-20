var DBB;
(function (DBB) {
    (function (KaigoGenkihenKanwaSettei) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoGenkihenKanwaSettei.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KaigoGenkihenKanwaSettei.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        KaigoGenkihenKanwaSettei.ModeController = ModeController;
    })(DBB.KaigoGenkihenKanwaSettei || (DBB.KaigoGenkihenKanwaSettei = {}));
    var KaigoGenkihenKanwaSettei = DBB.KaigoGenkihenKanwaSettei;
})(DBB || (DBB = {}));

var DBB;
(function (DBB) {
    (function (KaigoGenkihenKanwaSettei) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoGenkihenKanwaSettei.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        KaigoGenkihenKanwaSettei.PublicProperties = PublicProperties;
    })(DBB.KaigoGenkihenKanwaSettei || (DBB.KaigoGenkihenKanwaSettei = {}));
    var KaigoGenkihenKanwaSettei = DBB.KaigoGenkihenKanwaSettei;
})(DBB || (DBB = {}));
