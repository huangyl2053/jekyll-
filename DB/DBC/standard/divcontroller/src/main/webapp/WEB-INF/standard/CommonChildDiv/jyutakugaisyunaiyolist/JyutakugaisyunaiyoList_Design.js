var DBC;
(function (DBC) {
    (function (JyutakugaisyunaiyoList) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        JyutakugaisyunaiyoList.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "JyutakugaisyunaiyoList";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBC.JyutakugaisyunaiyoList.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBC.JyutakugaisyunaiyoList.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.JyutakugaisyunaiyoList = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.PnlGaisyuListArea = function () {
                return new UZA.Panel(this.convFiledName("PnlGaisyuListArea"));
            };

            Controls.prototype.btnDetailAdd = function () {
                return new UZA.Button(this.convFiledName("btnDetailAdd"));
            };

            Controls.prototype.dgGaisyuList = function () {
                return new UZA.DataGrid(this.convFiledName("dgGaisyuList"));
            };

            Controls.prototype.PnlNyuryokuArea = function () {
                return new UZA.Panel(this.convFiledName("PnlNyuryokuArea"));
            };

            Controls.prototype.txtKaisyunaiyo = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtKaisyunaiyo"));
            };

            Controls.prototype.txtJigyosya = function () {
                return new UZA.TextBox(this.convFiledName("txtJigyosya"));
            };

            Controls.prototype.lblTaisyojyutakujyusyo = function () {
                return new UZA.Label(this.convFiledName("lblTaisyojyutakujyusyo"));
            };

            Controls.prototype.btnHonnijyusyoCopy = function () {
                return new UZA.Button(this.convFiledName("btnHonnijyusyoCopy"));
            };

            Controls.prototype.txtJyusyo = function () {
                return new UZA.TextBoxJusho(this.convFiledName("txtJyusyo"));
            };

            Controls.prototype.txtTyakkoyotebi = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtTyakkoyotebi"));
            };

            Controls.prototype.txtKanseyotebi = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKanseyotebi"));
            };

            Controls.prototype.txtKaisyukingaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtKaisyukingaku"));
            };

            Controls.prototype.btnClear = function () {
                return new UZA.Button(this.convFiledName("btnClear"));
            };

            Controls.prototype.btnDetailConfirm = function () {
                return new UZA.Button(this.convFiledName("btnDetailConfirm"));
            };
            return Controls;
        })();
        JyutakugaisyunaiyoList.Controls = Controls;
    })(DBC.JyutakugaisyunaiyoList || (DBC.JyutakugaisyunaiyoList = {}));
    var JyutakugaisyunaiyoList = DBC.JyutakugaisyunaiyoList;
})(DBC || (DBC = {}));
