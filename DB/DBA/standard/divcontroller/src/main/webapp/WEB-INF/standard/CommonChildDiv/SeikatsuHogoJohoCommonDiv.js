var DBA;
(function (DBA) {
    (function (SeikatsuHogoJohoCommonDiv) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new SeikatsuHogoJohoCommonDiv.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new SeikatsuHogoJohoCommonDiv.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        SeikatsuHogoJohoCommonDiv.ModeController = ModeController;
    })(DBA.SeikatsuHogoJohoCommonDiv || (DBA.SeikatsuHogoJohoCommonDiv = {}));
    var SeikatsuHogoJohoCommonDiv = DBA.SeikatsuHogoJohoCommonDiv;
})(DBA || (DBA = {}));

var DBA;
(function (DBA) {
    (function (SeikatsuHogoJohoCommonDiv) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new SeikatsuHogoJohoCommonDiv.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        SeikatsuHogoJohoCommonDiv.PublicProperties = PublicProperties;
    })(DBA.SeikatsuHogoJohoCommonDiv || (DBA.SeikatsuHogoJohoCommonDiv = {}));
    var SeikatsuHogoJohoCommonDiv = DBA.SeikatsuHogoJohoCommonDiv;
})(DBA || (DBA = {}));
