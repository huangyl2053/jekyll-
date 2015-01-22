var DBC;
(function (DBC) {
    (function (SearchServiceCodeDialog) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnCloseDialog = function () {
                return "onClick_btnCloseDialog";
            };
            return Events;
        })();
        SearchServiceCodeDialog.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "SearchServiceCodeDialog";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBC.SearchServiceCodeDialog.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBC.SearchServiceCodeDialog.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.SearchServiceCodeDialog = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtServiceShuruiCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtServiceShuruiCode"));
            };

            Controls.prototype.txtServiceItemCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtServiceItemCode"));
            };

            Controls.prototype.txtKijunYM = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKijunYM"));
            };

            Controls.prototype.btnSearchServiceCode = function () {
                return new UZA.Button(this.convFiledName("btnSearchServiceCode"));
            };

            Controls.prototype.dgServiceCode = function () {
                return new UZA.DataGrid(this.convFiledName("dgServiceCode"));
            };

            Controls.prototype.btnCancel = function () {
                return new UZA.Button(this.convFiledName("btnCancel"));
            };
            return Controls;
        })();
        SearchServiceCodeDialog.Controls = Controls;
    })(DBC.SearchServiceCodeDialog || (DBC.SearchServiceCodeDialog = {}));
    var SearchServiceCodeDialog = DBC.SearchServiceCodeDialog;
})(DBC || (DBC = {}));
