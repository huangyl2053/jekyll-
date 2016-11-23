var DBD;
(function (DBD) {
    (function (MenjoKaijoSaiTennyu) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new MenjoKaijoSaiTennyu.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new MenjoKaijoSaiTennyu.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        MenjoKaijoSaiTennyu.ModeController = ModeController;
    })(DBD.MenjoKaijoSaiTennyu || (DBD.MenjoKaijoSaiTennyu = {}));
    var MenjoKaijoSaiTennyu = DBD.MenjoKaijoSaiTennyu;
})(DBD || (DBD = {}));

var DBD;
(function (DBD) {
    (function (MenjoKaijoSaiTennyu) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new MenjoKaijoSaiTennyu.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        MenjoKaijoSaiTennyu.PublicProperties = PublicProperties;
    })(DBD.MenjoKaijoSaiTennyu || (DBD.MenjoKaijoSaiTennyu = {}));
    var MenjoKaijoSaiTennyu = DBD.MenjoKaijoSaiTennyu;
})(DBD || (DBD = {}));
