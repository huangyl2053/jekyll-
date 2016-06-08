var DBE;
(function (DBE) {
    (function (ImageMasking) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        ImageMasking.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ImageMasking";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBE.ImageMasking.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBE.ImageMasking.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ImageMasking = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.tblImageMasking = function () {
                return new UZA.TablePanel(this.convFiledName("tblImageMasking"));
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

            Controls.prototype.celTableCell4 = function () {
                return new UZA.TableCell(this.convFiledName("celTableCell4"));
            };

            Controls.prototype.lblOkikaeru = function () {
                return new UZA.Label(this.convFiledName("lblOkikaeru"));
            };

            Controls.prototype.celTableCell5 = function () {
                return new UZA.TableCell(this.convFiledName("celTableCell5"));
            };

            Controls.prototype.txtChosaKomokuMeisho = function () {
                return new UZA.TextBox(this.convFiledName("txtChosaKomokuMeisho"));
            };

            Controls.prototype.btnModoru = function () {
                return new UZA.Button(this.convFiledName("btnModoru"));
            };

            Controls.prototype.btnIchijiHozon = function () {
                return new UZA.Button(this.convFiledName("btnIchijiHozon"));
            };
            return Controls;
        })();
        ImageMasking.Controls = Controls;
    })(DBE.ImageMasking || (DBE.ImageMasking = {}));
    var ImageMasking = DBE.ImageMasking;
})(DBE || (DBE = {}));
