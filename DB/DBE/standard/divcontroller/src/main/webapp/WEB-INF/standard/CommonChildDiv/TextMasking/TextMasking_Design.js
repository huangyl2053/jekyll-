var DBE;
(function (DBE) {
    (function (TextMasking) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        TextMasking.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "TextMasking";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBE.TextMasking.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBE.TextMasking.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.TextMasking = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.tblTextMasking = function () {
                return new UZA.TablePanel(this.convFiledName("tblTextMasking"));
            };

            Controls.prototype.celTableCell1 = function () {
                return new UZA.TableCell(this.convFiledName("celTableCell1"));
            };

            Controls.prototype.txtChosaKomokuNo = function () {
                return new UZA.TextBox(this.convFiledName("txtChosaKomokuNo"));
            };

            Controls.prototype.celTableCell2 = function () {
                return new UZA.TableCell(this.convFiledName("celTableCell2"));
            };

            Controls.prototype.lblHyphen = function () {
                return new UZA.Label(this.convFiledName("lblHyphen"));
            };

            Controls.prototype.celTableCell3 = function () {
                return new UZA.TableCell(this.convFiledName("celTableCell3"));
            };

            Controls.prototype.txtChosaKomokuRenban = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtChosaKomokuRenban"));
            };

            Controls.prototype.celTableCell6 = function () {
                return new UZA.TableCell(this.convFiledName("celTableCell6"));
            };

            Controls.prototype.txtChosaKomokuMeisho = function () {
                return new UZA.TextBox(this.convFiledName("txtChosaKomokuMeisho"));
            };

            Controls.prototype.celTableCell4 = function () {
                return new UZA.TableCell(this.convFiledName("celTableCell4"));
            };

            Controls.prototype.lblBeforeMasking = function () {
                return new UZA.Label(this.convFiledName("lblBeforeMasking"));
            };

            Controls.prototype.celTableCell5 = function () {
                return new UZA.TableCell(this.convFiledName("celTableCell5"));
            };

            Controls.prototype.txtBeforeMasking = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtBeforeMasking"));
            };

            Controls.prototype.celTableCell7 = function () {
                return new UZA.TableCell(this.convFiledName("celTableCell7"));
            };

            Controls.prototype.lblAfterMasking = function () {
                return new UZA.Label(this.convFiledName("lblAfterMasking"));
            };

            Controls.prototype.celTableCell8 = function () {
                return new UZA.TableCell(this.convFiledName("celTableCell8"));
            };

            Controls.prototype.txtAfterMasking = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtAfterMasking"));
            };

            Controls.prototype.btnModoru = function () {
                return new UZA.Button(this.convFiledName("btnModoru"));
            };

            Controls.prototype.btnHozon = function () {
                return new UZA.Button(this.convFiledName("btnHozon"));
            };
            return Controls;
        })();
        TextMasking.Controls = Controls;
    })(DBE.TextMasking || (DBE.TextMasking = {}));
    var TextMasking = DBE.TextMasking;
})(DBE || (DBE = {}));
