var DBC;
(function (DBC) {
    (function (KyufugakuSummary) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnRireki = function () {
                return "onClick_btnRireki";
            };

            Events.onClick_btnCheckGendogaku = function () {
                return "onClick_btnCheckGendogaku";
            };
            return Events;
        })();
        KyufugakuSummary.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KyufugakuSummary";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBC.KyufugakuSummary.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBC.KyufugakuSummary.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KyufugakuSummary = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.tblSeikyuSummary = function () {
                return new UZA.TablePanel(this.convFiledName("tblSeikyuSummary"));
            };

            Controls.prototype.cel11 = function () {
                return new UZA.TableCell(this.convFiledName("cel11"));
            };

            Controls.prototype.lblSummary = function () {
                return new UZA.Label(this.convFiledName("lblSummary"));
            };

            Controls.prototype.cel12 = function () {
                return new UZA.TableCell(this.convFiledName("cel12"));
            };

            Controls.prototype.lblHiyoTotal = function () {
                return new UZA.Label(this.convFiledName("lblHiyoTotal"));
            };

            Controls.prototype.cel13 = function () {
                return new UZA.TableCell(this.convFiledName("cel13"));
            };

            Controls.prototype.lblHokenTaishoHiyo = function () {
                return new UZA.Label(this.convFiledName("lblHokenTaishoHiyo"));
            };

            Controls.prototype.cel14 = function () {
                return new UZA.TableCell(this.convFiledName("cel14"));
            };

            Controls.prototype.lblHokenKyufuAmount = function () {
                return new UZA.Label(this.convFiledName("lblHokenKyufuAmount"));
            };

            Controls.prototype.cel15 = function () {
                return new UZA.TableCell(this.convFiledName("cel15"));
            };

            Controls.prototype.lblRiyoshaFutanAmount = function () {
                return new UZA.Label(this.convFiledName("lblRiyoshaFutanAmount"));
            };

            Controls.prototype.cel21 = function () {
                return new UZA.TableCell(this.convFiledName("cel21"));
            };

            Controls.prototype.lblSummaryMae = function () {
                return new UZA.Label(this.convFiledName("lblSummaryMae"));
            };

            Controls.prototype.cel22 = function () {
                return new UZA.TableCell(this.convFiledName("cel22"));
            };

            Controls.prototype.txtHiyoTotalMae = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtHiyoTotalMae"));
            };

            Controls.prototype.cel23 = function () {
                return new UZA.TableCell(this.convFiledName("cel23"));
            };

            Controls.prototype.txtHokenTaishoHiyoMae = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtHokenTaishoHiyoMae"));
            };

            Controls.prototype.cel24 = function () {
                return new UZA.TableCell(this.convFiledName("cel24"));
            };

            Controls.prototype.txtHokenKyufuAmountMae = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtHokenKyufuAmountMae"));
            };

            Controls.prototype.cel25 = function () {
                return new UZA.TableCell(this.convFiledName("cel25"));
            };

            Controls.prototype.txtRiyoshaFutanAmountMae = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtRiyoshaFutanAmountMae"));
            };

            Controls.prototype.cell26 = function () {
                return new UZA.TableCell(this.convFiledName("cell26"));
            };

            Controls.prototype.btnRireki = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnRireki"));
            };

            Controls.prototype.cel31 = function () {
                return new UZA.TableCell(this.convFiledName("cel31"));
            };

            Controls.prototype.lblSummaryNow = function () {
                return new UZA.Label(this.convFiledName("lblSummaryNow"));
            };

            Controls.prototype.cel32 = function () {
                return new UZA.TableCell(this.convFiledName("cel32"));
            };

            Controls.prototype.txtHiyoTotalNow = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtHiyoTotalNow"));
            };

            Controls.prototype.cel33 = function () {
                return new UZA.TableCell(this.convFiledName("cel33"));
            };

            Controls.prototype.txtHokenTaishoHiyoNow = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtHokenTaishoHiyoNow"));
            };

            Controls.prototype.cel34 = function () {
                return new UZA.TableCell(this.convFiledName("cel34"));
            };

            Controls.prototype.txtHokenKyufuAmountNow = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtHokenKyufuAmountNow"));
            };

            Controls.prototype.cel35 = function () {
                return new UZA.TableCell(this.convFiledName("cel35"));
            };

            Controls.prototype.txtRiyoshaFutanAmountNow = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtRiyoshaFutanAmountNow"));
            };

            Controls.prototype.cel36 = function () {
                return new UZA.TableCell(this.convFiledName("cel36"));
            };

            Controls.prototype.btnLimitOverCheck = function () {
                return new UZA.Button(this.convFiledName("btnLimitOverCheck"));
            };
            return Controls;
        })();
        KyufugakuSummary.Controls = Controls;
    })(DBC.KyufugakuSummary || (DBC.KyufugakuSummary = {}));
    var KyufugakuSummary = DBC.KyufugakuSummary;
})(DBC || (DBC = {}));
