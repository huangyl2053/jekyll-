var DBZ;
(function (DBZ) {
    (function (NinteiShinsakaiIinGuide) {
        var Events = (function () {
            function Events() {
            }
            Events.onOKClose_chosaItakusakiGuide = function () {
                return "onOKClose_chosaItakusakiGuide";
            };

            Events.onBefore_chosaItakusakiGuide = function () {
                return "onBefore_chosaItakusakiGuide";
            };

            Events.onOKClose_iryoKikanGuide = function () {
                return "onOKClose_iryoKikanGuide";
            };

            Events.onBefore_iryoKikanGuide = function () {
                return "onBefore_iryoKikanGuide";
            };

            Events.onOKClose_sonotaKikanGuide = function () {
                return "onOKClose_sonotaKikanGuide";
            };

            Events.onBefore_sonotaKikanGuide = function () {
                return "onBefore_sonotaKikanGuide";
            };

            Events.onClick_btnKensakku = function () {
                return "onClick_btnKensakku";
            };

            Events.onClick_btnClear = function () {
                return "onClick_btnClear";
            };

            Events.onClick_ShinsakaiIinIchiranDate = function () {
                return "onClick_ShinsakaiIinIchiranDate";
            };

            Events.onClick_btnModoru = function () {
                return "onClick_btnModoru";
            };

            Events.onClick_btnSaikensaku = function () {
                return "onClick_btnSaikensaku";
            };
            return Events;
        })();
        NinteiShinsakaiIinGuide.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "NinteiShinsakaiIinGuide";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.NinteiShinsakaiIinGuide.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.NinteiShinsakaiIinGuide.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.NinteiShinsakaiIinGuide = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.KensakuJoken = function () {
                return new UZA.Panel(this.convFiledName("KensakuJoken"));
            };

            Controls.prototype.KensakuJokenInput = function () {
                return new UZA.Panel(this.convFiledName("KensakuJokenInput"));
            };

            Controls.prototype.txtShinsakaiIinCodeFrom = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtShinsakaiIinCodeFrom"));
            };

            Controls.prototype.txtShinsakaiIinCodeTo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtShinsakaiIinCodeTo"));
            };

            Controls.prototype.txtShinsakaiIinName = function () {
                return new UZA.TextBox(this.convFiledName("txtShinsakaiIinName"));
            };

            Controls.prototype.ddlSeibetsu = function () {
                return new UZA.DropDownList(this.convFiledName("ddlSeibetsu"));
            };

            Controls.prototype.ddlShinsainShikakuCode = function () {
                return new UZA.DropDownList(this.convFiledName("ddlShinsainShikakuCode"));
            };

            Controls.prototype.txtKijunbi = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKijunbi"));
            };

            Controls.prototype.radKikan = function () {
                return new UZA.RadioButton(this.convFiledName("radKikan"));
            };

            Controls.prototype.chkHaishi = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkHaishi"));
            };

            Controls.prototype.pnlShosaiJoken = function () {
                return new UZA.Panel(this.convFiledName("pnlShosaiJoken"));
            };

            Controls.prototype.ccdHokensha = function () {
                return new DBZ.HokenshaList.ModeController(this.convFiledName("ccdHokensha"));
            };

            Controls.prototype.txtChosaItakusakiCode = function () {
                return new UZA.TextBox(this.convFiledName("txtChosaItakusakiCode"));
            };

            Controls.prototype.btnChosaItakusaki = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnChosaItakusaki"));
            };

            Controls.prototype.txtChosaItakusakiName = function () {
                return new UZA.TextBox(this.convFiledName("txtChosaItakusakiName"));
            };

            Controls.prototype.txtIryoKikanCode = function () {
                return new UZA.TextBox(this.convFiledName("txtIryoKikanCode"));
            };

            Controls.prototype.btnIryoKikan = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnIryoKikan"));
            };

            Controls.prototype.txtIryoKikanName = function () {
                return new UZA.TextBox(this.convFiledName("txtIryoKikanName"));
            };

            Controls.prototype.txtSonotaJigyoshaCode = function () {
                return new UZA.TextBox(this.convFiledName("txtSonotaJigyoshaCode"));
            };

            Controls.prototype.btnSonotaJigyosha = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnSonotaJigyosha"));
            };

            Controls.prototype.txtSonotaJigyoshaName = function () {
                return new UZA.TextBox(this.convFiledName("txtSonotaJigyoshaName"));
            };

            Controls.prototype.txtMaxKensu = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtMaxKensu"));
            };

            Controls.prototype.btnKensakku = function () {
                return new UZA.Button(this.convFiledName("btnKensakku"));
            };

            Controls.prototype.btnClear = function () {
                return new UZA.Button(this.convFiledName("btnClear"));
            };

            Controls.prototype.ShinsakaiIinIchiran = function () {
                return new UZA.Panel(this.convFiledName("ShinsakaiIinIchiran"));
            };

            Controls.prototype.dgShinsakaiIinIchiran = function () {
                return new UZA.DataGrid(this.convFiledName("dgShinsakaiIinIchiran"));
            };

            Controls.prototype.btnModoru = function () {
                return new UZA.Button(this.convFiledName("btnModoru"));
            };

            Controls.prototype.btnSaikensaku = function () {
                return new UZA.Button(this.convFiledName("btnSaikensaku"));
            };
            return Controls;
        })();
        NinteiShinsakaiIinGuide.Controls = Controls;
    })(DBZ.NinteiShinsakaiIinGuide || (DBZ.NinteiShinsakaiIinGuide = {}));
    var NinteiShinsakaiIinGuide = DBZ.NinteiShinsakaiIinGuide;
})(DBZ || (DBZ = {}));
