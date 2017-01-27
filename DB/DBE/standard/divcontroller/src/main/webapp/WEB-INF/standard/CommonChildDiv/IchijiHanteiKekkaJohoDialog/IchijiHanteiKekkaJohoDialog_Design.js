var DBE;
(function (DBE) {
    (function (IchijiHanteiKekkaJohoDialog) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnBack = function () {
                return "onClick_btnBack";
            };

            Events.onClick_btnKakutei = function () {
                return "onClick_btnKakutei";
            };
            return Events;
        })();
        IchijiHanteiKekkaJohoDialog.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "IchijiHanteiKekkaJohoDialog";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBE.IchijiHanteiKekkaJohoDialog.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBE.IchijiHanteiKekkaJohoDialog.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.IchijiHanteiKekkaJohoDialog = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.btnBack = function () {
                return new UZA.Button(this.convFiledName("btnBack"));
            };

            Controls.prototype.btnKakutei = function () {
                return new UZA.Button(this.convFiledName("btnKakutei"));
            };
            return Controls;
        })();
        IchijiHanteiKekkaJohoDialog.Controls = Controls;
    })(DBE.IchijiHanteiKekkaJohoDialog || (DBE.IchijiHanteiKekkaJohoDialog = {}));
    var IchijiHanteiKekkaJohoDialog = DBE.IchijiHanteiKekkaJohoDialog;
})(DBE || (DBE = {}));
