var DBE;
(function (DBE) {
    (function (ImageJohoMaskingDialog) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ImageJohoMaskingDialog.Controls(fieldName);
                Uz.GyomuJSHelper.registOriginalEvent(DBE.ImageJohoMaskingDialog.Events.onClick_btnHozon(), function (control) {
                    (Uz)._MessageUtil.confirm("保存します。よろしいですか？", function (isOk) {
                        if (isOk) {
                            UZI.ImageMasking.EventScripts.beforeClick();
                            $("#" + Uz.JSControlUtil.getJSControl("btnSave").fieldName).click();
                        }
                    });
                });
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ImageJohoMaskingDialog.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        ImageJohoMaskingDialog.ModeController = ModeController;
    })(DBE.ImageJohoMaskingDialog || (DBE.ImageJohoMaskingDialog = {}));
    var ImageJohoMaskingDialog = DBE.ImageJohoMaskingDialog;
})(DBE || (DBE = {}));

var DBE;
(function (DBE) {
    (function (ImageJohoMaskingDialog) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ImageJohoMaskingDialog.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ImageJohoMaskingDialog.PublicProperties = PublicProperties;
    })(DBE.ImageJohoMaskingDialog || (DBE.ImageJohoMaskingDialog = {}));
    var ImageJohoMaskingDialog = DBE.ImageJohoMaskingDialog;
})(DBE || (DBE = {}));
