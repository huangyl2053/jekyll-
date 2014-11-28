var DBC;
(function (DBC) {
    (function (JutakuKaishuShinseiDetailInput) {
        var Events = (function () {
            function Events() {
            }
            Events.onSelectByModifyButton = function () {
                return "onSelectByModifyButton";
            };

            Events.onSelectByDeleteButton = function () {
                return "onSelectByDeleteButton";
            };

            Events.onClick_btnCopyAddress = function () {
                return "onClick_btnCopyAddress";
            };

            Events.onClick_btnClearDetail = function () {
                return "onClick_btnClearDetail";
            };

            Events.onClick_btnModifyDetail = function () {
                return "onClick_btnModifyDetail";
            };
            return Events;
        })();
        JutakuKaishuShinseiDetailInput.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "JutakuKaishuShinseiDetailInput";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBC.JutakuKaishuShinseiDetailInput.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBC.JutakuKaishuShinseiDetailInput.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.JutakuKaishuShinseiDetailInput = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.dgJutakuKaishuDetail = function () {
                return new UZA.DataGrid(this.convFiledName("dgJutakuKaishuDetail"));
            };

            Controls.prototype.JutakuKaishuDetailInput = function () {
                return new UZA.Panel(this.convFiledName("JutakuKaishuDetailInput"));
            };

            Controls.prototype.txtKaishuContents = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtKaishuContents"));
            };

            Controls.prototype.txtKaishuJigyoshaName = function () {
                return new UZA.TextBox(this.convFiledName("txtKaishuJigyoshaName"));
            };

            Controls.prototype.lblKaishuTaishoAddress = function () {
                return new UZA.Label(this.convFiledName("lblKaishuTaishoAddress"));
            };

            Controls.prototype.btnCopyAddress = function () {
                return new UZA.Button(this.convFiledName("btnCopyAddress"));
            };

            Controls.prototype.txtKaishuTaishoAddress = function () {
                return new UZA.TextBox(this.convFiledName("txtKaishuTaishoAddress"));
            };

            Controls.prototype.txtChakkoDueDate = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtChakkoDueDate"));
            };

            Controls.prototype.txtKanseiDueDate = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKanseiDueDate"));
            };

            Controls.prototype.txtEstimatedAmount = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtEstimatedAmount"));
            };

            Controls.prototype.btnClearDetail = function () {
                return new UZA.Button(this.convFiledName("btnClearDetail"));
            };

            Controls.prototype.btnModifyDetail = function () {
                return new UZA.Button(this.convFiledName("btnModifyDetail"));
            };
            return Controls;
        })();
        JutakuKaishuShinseiDetailInput.Controls = Controls;
    })(DBC.JutakuKaishuShinseiDetailInput || (DBC.JutakuKaishuShinseiDetailInput = {}));
    var JutakuKaishuShinseiDetailInput = DBC.JutakuKaishuShinseiDetailInput;
})(DBC || (DBC = {}));
