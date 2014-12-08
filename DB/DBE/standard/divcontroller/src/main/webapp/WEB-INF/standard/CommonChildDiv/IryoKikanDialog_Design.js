var DBE;
(function (DBE) {
    (function (IryoKikanDialog) {
        var Events = (function () {
            function Events() {
            }
            Events.onSelect_dgKikanIchiran = function () {
                return "onSelect_dgKikanIchiran";
            };

            Events.onSelect_dgShujiiIchiran = function () {
                return "onSelect_dgShujiiIchiran";
            };

            Events.CloseOK = function () {
                return "CloseOK";
            };

            Events.CloseCancel = function () {
                return "CloseCancel";
            };
            return Events;
        })();
        IryoKikanDialog.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "IryoKikanDialog";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBE.IryoKikanDialog.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBE.IryoKikanDialog.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.IryoKikanDialog = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.btnToMentenanceChosaKikan = function () {
                return new UZA.Button(this.convFiledName("btnToMentenanceChosaKikan"));
            };

            Controls.prototype.dgKikanIchiran = function () {
                return new UZA.DataGrid(this.convFiledName("dgKikanIchiran"));
            };

            Controls.prototype.dgShujiiIchiran = function () {
                return new UZA.DataGrid(this.convFiledName("dgShujiiIchiran"));
            };

            Controls.prototype.btnSelectKikan = function () {
                return new UZA.Button(this.convFiledName("btnSelectKikan"));
            };

            Controls.prototype.btnNonSelectReturn = function () {
                return new UZA.Button(this.convFiledName("btnNonSelectReturn"));
            };
            return Controls;
        })();
        IryoKikanDialog.Controls = Controls;
    })(DBE.IryoKikanDialog || (DBE.IryoKikanDialog = {}));
    var IryoKikanDialog = DBE.IryoKikanDialog;
})(DBE || (DBE = {}));
