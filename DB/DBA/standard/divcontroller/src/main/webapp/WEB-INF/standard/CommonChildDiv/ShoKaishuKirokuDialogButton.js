var DBA;
(function (DBA) {
    (function (ShoKaishuKirokuDialogButton) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShoKaishuKirokuDialogButton.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ShoKaishuKirokuDialogButton.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        ShoKaishuKirokuDialogButton.ModeController = ModeController;
    })(DBA.ShoKaishuKirokuDialogButton || (DBA.ShoKaishuKirokuDialogButton = {}));
    var ShoKaishuKirokuDialogButton = DBA.ShoKaishuKirokuDialogButton;
})(DBA || (DBA = {}));

var DBA;
(function (DBA) {
    (function (ShoKaishuKirokuDialogButton) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShoKaishuKirokuDialogButton.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ShoKaishuKirokuDialogButton.PublicProperties = PublicProperties;
    })(DBA.ShoKaishuKirokuDialogButton || (DBA.ShoKaishuKirokuDialogButton = {}));
    var ShoKaishuKirokuDialogButton = DBA.ShoKaishuKirokuDialogButton;
})(DBA || (DBA = {}));
