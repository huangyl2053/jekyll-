var DBZ;
(function (DBZ) {
    (function (KaigoRenrakusakiInfo) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnAdd = function () {
                return "onClick_btnAdd";
            };

            Events.onClick_btnDelete = function () {
                return "onClick_btnDelete";
            };

            Events.onSelectByDC_Renrakusaki = function () {
                return "onSelectByDC_Renrakusaki";
            };

            Events.onSelectBySB_Renrakusaki = function () {
                return "onSelectBySB_Renrakusaki";
            };

            Events.onClick_btnClose = function () {
                return "onClick_btnClose";
            };

            Events.onClick_btnKoshin = function () {
                return "onClick_btnKoshin";
            };

            Events.onClick_btnCancel = function () {
                return "onClick_btnCancel";
            };
            return Events;
        })();
        KaigoRenrakusakiInfo.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KaigoRenrakusakiInfo";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.KaigoRenrakusakiInfo.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.KaigoRenrakusakiInfo.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KaigoRenrakusakiInfo = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.btnAdd = function () {
                return new UZA.Button(this.convFiledName("btnAdd"));
            };

            Controls.prototype.btnDelete = function () {
                return new UZA.Button(this.convFiledName("btnDelete"));
            };

            Controls.prototype.dgRenrakusaki = function () {
                return new UZA.DataGrid(this.convFiledName("dgRenrakusaki"));
            };

            Controls.prototype.btnClose = function () {
                return new UZA.Button(this.convFiledName("btnClose"));
            };

            Controls.prototype.SelectedContents = function () {
                return new UZA.Panel(this.convFiledName("SelectedContents"));
            };

            Controls.prototype.txtRenrakusakiKbnNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtRenrakusakiKbnNo"));
            };

            Controls.prototype.txtShimei = function () {
                return new UZA.TextBox(this.convFiledName("txtShimei"));
            };

            Controls.prototype.txtShimeiKana = function () {
                return new UZA.TextBox(this.convFiledName("txtShimeiKana"));
            };

            Controls.prototype.txtTsuzukigara = function () {
                return new UZA.TextBox(this.convFiledName("txtTsuzukigara"));
            };

            Controls.prototype.txtTel = function () {
                return new UZA.TextBox(this.convFiledName("txtTel"));
            };

            Controls.prototype.txtKeitaiNo = function () {
                return new UZA.TextBox(this.convFiledName("txtKeitaiNo"));
            };

            Controls.prototype.txtYubinNo = function () {
                return new UZA.TextBoxYubinNo(this.convFiledName("txtYubinNo"));
            };

            Controls.prototype.txtJusho = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtJusho"));
            };

            Controls.prototype.btnUpdate = function () {
                return new UZA.Button(this.convFiledName("btnUpdate"));
            };

            Controls.prototype.btnReturn = function () {
                return new UZA.Button(this.convFiledName("btnReturn"));
            };
            return Controls;
        })();
        KaigoRenrakusakiInfo.Controls = Controls;
    })(DBZ.KaigoRenrakusakiInfo || (DBZ.KaigoRenrakusakiInfo = {}));
    var KaigoRenrakusakiInfo = DBZ.KaigoRenrakusakiInfo;
})(DBZ || (DBZ = {}));
