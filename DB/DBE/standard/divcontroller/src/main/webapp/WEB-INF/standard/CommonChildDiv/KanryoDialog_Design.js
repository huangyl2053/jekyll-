var DBE;
(function (DBE) {
    (function (KanryoDialog) {
        var Events = (function () {
            function Events() {
            }
            Events.CloseOK = function () {
                return "CloseOK";
            };
            return Events;
        })();
        KanryoDialog.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KanryoDialog";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBE.KanryoDialog.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBE.KanryoDialog.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KanryoDialog = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.SuccessInfo = function () {
                return new UZA.Panel(this.convFiledName("SuccessInfo"));
            };

            Controls.prototype.imgSuccess = function () {
                return new UZA.StaticImage(this.convFiledName("imgSuccess"));
            };

            Controls.prototype.WrapMessageMain = function () {
                return new UZA.Panel(this.convFiledName("SuccessInfo_WrapMessageMain"));
            };

            Controls.prototype.lblMessageMain = function () {
                return new UZA.Label(this.convFiledName("lblMessageMain"));
            };

            Controls.prototype.btnClose = function () {
                return new UZA.Button(this.convFiledName("btnClose"));
            };
            return Controls;
        })();
        KanryoDialog.Controls = Controls;
    })(DBE.KanryoDialog || (DBE.KanryoDialog = {}));
    var KanryoDialog = DBE.KanryoDialog;
})(DBE || (DBE = {}));
