var DBE;
(function (DBE) {
    (function (ImageJohoMaskingDialog) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnTorikeshi = function () {
                return "onClick_btnTorikeshi";
            };

            Events.onClick_btnHozon = function () {
                return "onClick_btnHozon";
            };

            Events.onClick_btnSave = function () {
                return "onClick_btnSave";
            };
            return Events;
        })();
        ImageJohoMaskingDialog.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ImageJohoMaskingDialog";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBE.ImageJohoMaskingDialog.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBE.ImageJohoMaskingDialog.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ImageJohoMaskingDialog = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.ccdImageMasking = function () {
                return new UZI.ImageMasking.ModeController(this.convFiledName("ccdImageMasking"));
            };

            Controls.prototype.btnTorikeshi = function () {
                return new UZA.Button(this.convFiledName("btnTorikeshi"));
            };

            Controls.prototype.btnHozon = function () {
                return new UZA.Button(this.convFiledName("btnHozon"));
            };

            Controls.prototype.btnSave = function () {
                return new UZA.Button(this.convFiledName("btnSave"));
            };
            return Controls;
        })();
        ImageJohoMaskingDialog.Controls = Controls;
    })(DBE.ImageJohoMaskingDialog || (DBE.ImageJohoMaskingDialog = {}));
    var ImageJohoMaskingDialog = DBE.ImageJohoMaskingDialog;
})(DBE || (DBE = {}));
