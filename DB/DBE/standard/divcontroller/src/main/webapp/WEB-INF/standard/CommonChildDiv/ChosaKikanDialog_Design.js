var DBE;
(function (DBE) {
    (function (ChosaKikanDialog) {
        var Events = (function () {
            function Events() {
            }
            Events.onSelect_dgKikanIchiran = function () {
                return "onSelect_dgKikanIchiran";
            };

            Events.onSelect_dgChosainIchiran = function () {
                return "onSelect_dgChosainIchiran";
            };

            Events.CloseOK = function () {
                return "CloseOK";
            };

            Events.CloseCancel = function () {
                return "CloseCancel";
            };
            return Events;
        })();
        ChosaKikanDialog.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ChosaKikanDialog";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBE.ChosaKikanDialog.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBE.ChosaKikanDialog.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ChosaKikanDialog = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.btnToMentenanceChosaKikan = function () {
                return new UZA.Button(this.convFiledName("btnToMentenanceChosaKikan"));
            };

            Controls.prototype.dgKikanIchiran = function () {
                return new UZA.DataGrid(this.convFiledName("dgKikanIchiran"));
            };

            Controls.prototype.dgChosainIchiran = function () {
                return new UZA.DataGrid(this.convFiledName("dgChosainIchiran"));
            };

            Controls.prototype.btnSelectKikan = function () {
                return new UZA.Button(this.convFiledName("btnSelectKikan"));
            };

            Controls.prototype.btnNonSelectReturn = function () {
                return new UZA.Button(this.convFiledName("btnNonSelectReturn"));
            };
            return Controls;
        })();
        ChosaKikanDialog.Controls = Controls;
    })(DBE.ChosaKikanDialog || (DBE.ChosaKikanDialog = {}));
    var ChosaKikanDialog = DBE.ChosaKikanDialog;
})(DBE || (DBE = {}));
