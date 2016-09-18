var DBA;
(function (DBA) {
    (function (ShoKaishuKirokuDialog) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShoKaishuKirokuDialog.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ShoKaishuKirokuDialog.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        ShoKaishuKirokuDialog.ModeController = ModeController;
    })(DBA.ShoKaishuKirokuDialog || (DBA.ShoKaishuKirokuDialog = {}));
    var ShoKaishuKirokuDialog = DBA.ShoKaishuKirokuDialog;
})(DBA || (DBA = {}));

var DBA;
(function (DBA) {
    (function (ShoKaishuKirokuDialog) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShoKaishuKirokuDialog.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ShoKaishuKirokuDialog.PublicProperties = PublicProperties;
    })(DBA.ShoKaishuKirokuDialog || (DBA.ShoKaishuKirokuDialog = {}));
    var ShoKaishuKirokuDialog = DBA.ShoKaishuKirokuDialog;
})(DBA || (DBA = {}));
