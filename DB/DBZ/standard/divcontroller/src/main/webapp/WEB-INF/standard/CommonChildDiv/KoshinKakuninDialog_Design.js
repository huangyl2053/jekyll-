var DBZ;
(function (DBZ) {
    (function (KoshinKakuninDialog) {
        var Events = (function () {
            function Events() {
            }
            Events.CloseOK = function () {
                return "CloseOK";
            };

            Events.CloseCancel = function () {
                return "CloseCancel";
            };
            return Events;
        })();
        KoshinKakuninDialog.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KoshinKakuninDialog";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.KoshinKakuninDialog.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.KoshinKakuninDialog.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KoshinKakuninDialog = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.lblKoshinMassage = function () {
                return new UZA.Label(this.convFiledName("lblKoshinMassage"));
            };

            Controls.prototype.btnYes = function () {
                return new UZA.Button(this.convFiledName("btnYes"));
            };

            Controls.prototype.btnNo = function () {
                return new UZA.Button(this.convFiledName("btnNo"));
            };
            return Controls;
        })();
        KoshinKakuninDialog.Controls = Controls;
    })(DBZ.KoshinKakuninDialog || (DBZ.KoshinKakuninDialog = {}));
    var KoshinKakuninDialog = DBZ.KoshinKakuninDialog;
})(DBZ || (DBZ = {}));
