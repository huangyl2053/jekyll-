var DBZ;
(function (DBZ) {
    (function (ShoKaishuKirokuKanri) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        ShoKaishuKirokuKanri.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ShoKaishuKirokuKanri";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.ShoKaishuKirokuKanri.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.ShoKaishuKirokuKanri.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ShoKaishuKirokuKanri = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.panelKoufuList = function () {
                return new UZA.Panel(this.convFiledName("panelKoufuList"));
            };

            Controls.prototype.dgKoufuKaishu = function () {
                return new UZA.DataGrid(this.convFiledName("dgKoufuKaishu"));
            };

            Controls.prototype.panelInput = function () {
                return new UZA.Panel(this.convFiledName("panelInput"));
            };

            Controls.prototype.txtKoufuType = function () {
                return new UZA.TextBox(this.convFiledName("txtKoufuType"));
            };

            Controls.prototype.txtKoufuDate = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKoufuDate"));
            };

            Controls.prototype.txtYukouKigen = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtYukouKigen"));
            };

            Controls.prototype.ddlKoufuJiyu = function () {
                return new UZA.DropDownList(this.convFiledName("ddlKoufuJiyu"));
            };

            Controls.prototype.txaKoufuRiyu = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txaKoufuRiyu"));
            };

            Controls.prototype.txtKaisyuDate = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKaisyuDate"));
            };

            Controls.prototype.ddlKaisyuJiyu = function () {
                return new UZA.DropDownList(this.convFiledName("ddlKaisyuJiyu"));
            };

            Controls.prototype.txaKaishuRiyu = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txaKaishuRiyu"));
            };

            Controls.prototype.btnConfirm = function () {
                return new UZA.Button(this.convFiledName("btnConfirm"));
            };

            Controls.prototype.btnCancel = function () {
                return new UZA.Button(this.convFiledName("btnCancel"));
            };
            return Controls;
        })();
        ShoKaishuKirokuKanri.Controls = Controls;
    })(DBZ.ShoKaishuKirokuKanri || (DBZ.ShoKaishuKirokuKanri = {}));
    var ShoKaishuKirokuKanri = DBZ.ShoKaishuKirokuKanri;
})(DBZ || (DBZ = {}));
