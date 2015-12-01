var DBZ;
(function (DBZ) {
    (function (KaigoToiawasesaki) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnAddChohyoDokuji = function () {
                return "onClick_btnAddChohyoDokuji";
            };

            Events.onClick_dgToiawasesakiControl = function () {
                return "onClick_dgToiawasesakiControl";
            };

            Events.onClick_dgToiawasesakiControl_modify = function () {
                return "onClick_dgToiawasesakiControl_modify";
            };

            Events.onClick_dgToiawasesakiControl_delete = function () {
                return "onClick_dgToiawasesakiControl_delete";
            };

            Events.onClick_btnDecide = function () {
                return "onClick_btnDecide";
            };

            Events.onClick_btnCancel = function () {
                return "onClick_btnCancel";
            };

            Events.onClick_btnSave = function () {
                return "onClick_btnSave";
            };

            Events.onClick_btnClose = function () {
                return "onClick_btnClose";
            };
            return Events;
        })();
        KaigoToiawasesaki.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KaigoToiawasesaki";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.KaigoToiawasesaki.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.KaigoToiawasesaki.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KaigoToiawasesaki = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.ToiawasesakiControl = function () {
                return new UZA.Panel(this.convFiledName("ToiawasesakiControl"));
            };

            Controls.prototype.btnAddChohyoDokuji = function () {
                return new UZA.Button(this.convFiledName("btnAddChohyoDokuji"));
            };

            Controls.prototype.dgToiawasesakiControl = function () {
                return new UZA.DataGrid(this.convFiledName("dgToiawasesakiControl"));
            };

            Controls.prototype.ToiawasesakiShosai = function () {
                return new UZA.Panel(this.convFiledName("ToiawasesakiShosai"));
            };

            Controls.prototype.lblHensyuTaisho = function () {
                return new UZA.Label(this.convFiledName("lblHensyuTaisho"));
            };

            Controls.prototype.Detail1 = function () {
                return new UZA.Panel(this.convFiledName("Detail1"));
            };

            Controls.prototype.txtYubinNo = function () {
                return new UZA.TextBoxYubinNo(this.convFiledName("txtYubinNo"));
            };

            Controls.prototype.txtShozaichi = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtShozaichi"));
            };

            Controls.prototype.txtChoshaName = function () {
                return new UZA.TextBox(this.convFiledName("txtChoshaName"));
            };

            Controls.prototype.Detail2 = function () {
                return new UZA.Panel(this.convFiledName("Detail2"));
            };

            Controls.prototype.txtTelNo = function () {
                return new UZA.TextBoxTelNo(this.convFiledName("txtTelNo"));
            };

            Controls.prototype.txtNaisenNo = function () {
                return new UZA.TextBox(this.convFiledName("txtNaisenNo"));
            };

            Controls.prototype.txtBushoName = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtBushoName"));
            };

            Controls.prototype.txtTantoshaName = function () {
                return new UZA.TextBox(this.convFiledName("txtTantoshaName"));
            };

            Controls.prototype.line1 = function () {
                return new UZA.HorizontalLine(this.convFiledName("line1"));
            };

            Controls.prototype.btnDecide = function () {
                return new UZA.Button(this.convFiledName("btnDecide"));
            };

            Controls.prototype.btnCancel = function () {
                return new UZA.Button(this.convFiledName("btnCancel"));
            };

            Controls.prototype.btnSave = function () {
                return new UZA.Button(this.convFiledName("btnSave"));
            };

            Controls.prototype.btnClose = function () {
                return new UZA.Button(this.convFiledName("btnClose"));
            };
            return Controls;
        })();
        KaigoToiawasesaki.Controls = Controls;
    })(DBZ.KaigoToiawasesaki || (DBZ.KaigoToiawasesaki = {}));
    var KaigoToiawasesaki = DBZ.KaigoToiawasesaki;
})(DBZ || (DBZ = {}));
