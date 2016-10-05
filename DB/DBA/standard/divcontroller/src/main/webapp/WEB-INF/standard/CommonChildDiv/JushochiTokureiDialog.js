var DBA;
(function (DBA) {
    (function (JushochiTokureiDialog) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new JushochiTokureiDialog.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new JushochiTokureiDialog.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        JushochiTokureiDialog.ModeController = ModeController;
    })(DBA.JushochiTokureiDialog || (DBA.JushochiTokureiDialog = {}));
    var JushochiTokureiDialog = DBA.JushochiTokureiDialog;
})(DBA || (DBA = {}));

var DBA;
(function (DBA) {
    (function (JushochiTokureiDialog) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new JushochiTokureiDialog.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        JushochiTokureiDialog.PublicProperties = PublicProperties;
    })(DBA.JushochiTokureiDialog || (DBA.JushochiTokureiDialog = {}));
    var JushochiTokureiDialog = DBA.JushochiTokureiDialog;
})(DBA || (DBA = {}));
