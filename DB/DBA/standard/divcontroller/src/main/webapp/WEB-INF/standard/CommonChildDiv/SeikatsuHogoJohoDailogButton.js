var DBA;
(function (DBA) {
    (function (SeikatsuHogoJohoDailogButton) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new SeikatsuHogoJohoDailogButton.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new SeikatsuHogoJohoDailogButton.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        SeikatsuHogoJohoDailogButton.ModeController = ModeController;
    })(DBA.SeikatsuHogoJohoDailogButton || (DBA.SeikatsuHogoJohoDailogButton = {}));
    var SeikatsuHogoJohoDailogButton = DBA.SeikatsuHogoJohoDailogButton;
})(DBA || (DBA = {}));

var DBA;
(function (DBA) {
    (function (SeikatsuHogoJohoDailogButton) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new SeikatsuHogoJohoDailogButton.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        SeikatsuHogoJohoDailogButton.PublicProperties = PublicProperties;
    })(DBA.SeikatsuHogoJohoDailogButton || (DBA.SeikatsuHogoJohoDailogButton = {}));
    var SeikatsuHogoJohoDailogButton = DBA.SeikatsuHogoJohoDailogButton;
})(DBA || (DBA = {}));
