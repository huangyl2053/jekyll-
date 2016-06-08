var DBD;
(function (DBD) {
    (function (KaigoNinteiShinchokuJokyoKojin) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        KaigoNinteiShinchokuJokyoKojin.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KaigoNinteiShinchokuJokyoKojin";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBD.KaigoNinteiShinchokuJokyoKojin.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBD.KaigoNinteiShinchokuJokyoKojin.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KaigoNinteiShinchokuJokyoKojin = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.ShinchokuJokyo = function () {
                return new UZA.Panel(this.convFiledName("ShinchokuJokyo"));
            };

            Controls.prototype.tplShinchoKujokyo = function () {
                return new UZA.TablePanel(this.convFiledName("tplShinchoKujokyo"));
            };

            Controls.prototype.celTableCell1 = function () {
                return new UZA.TableCell(this.convFiledName("celTableCell1"));
            };

            Controls.prototype.celTableCell2 = function () {
                return new UZA.TableCell(this.convFiledName("celTableCell2"));
            };

            Controls.prototype.lblShinseiToroku = function () {
                return new UZA.Label(this.convFiledName("lblShinseiToroku"));
            };

            Controls.prototype.celTableCell3 = function () {
                return new UZA.TableCell(this.convFiledName("celTableCell3"));
            };

            Controls.prototype.lblNinteiChosaIrai = function () {
                return new UZA.Label(this.convFiledName("lblNinteiChosaIrai"));
            };

            Controls.prototype.celTableCell7 = function () {
                return new UZA.TableCell(this.convFiledName("celTableCell7"));
            };

            Controls.prototype.lblNinteiChosaJisshi = function () {
                return new UZA.Label(this.convFiledName("lblNinteiChosaJisshi"));
            };

            Controls.prototype.celTableCell8 = function () {
                return new UZA.TableCell(this.convFiledName("celTableCell8"));
            };

            Controls.prototype.ShujiIkenshoSakuseiIrai = function () {
                return new UZA.Label(this.convFiledName("ShujiIkenshoSakuseiIrai"));
            };

            Controls.prototype.celTableCell9 = function () {
                return new UZA.TableCell(this.convFiledName("celTableCell9"));
            };

            Controls.prototype.lblShujiiIkenshoToroku = function () {
                return new UZA.Label(this.convFiledName("lblShujiiIkenshoToroku"));
            };

            Controls.prototype.celTableCell10 = function () {
                return new UZA.TableCell(this.convFiledName("celTableCell10"));
            };

            Controls.prototype.IblIchijiHantei = function () {
                return new UZA.Label(this.convFiledName("IblIchijiHantei"));
            };

            Controls.prototype.celTableCell11 = function () {
                return new UZA.TableCell(this.convFiledName("celTableCell11"));
            };

            Controls.prototype.lblMasking = function () {
                return new UZA.Label(this.convFiledName("lblMasking"));
            };

            Controls.prototype.celTableCell12 = function () {
                return new UZA.TableCell(this.convFiledName("celTableCell12"));
            };

            Controls.prototype.lblKaigoNinteiShinsakaiWaritsuke = function () {
                return new UZA.Label(this.convFiledName("lblKaigoNinteiShinsakaiWaritsuke"));
            };

            Controls.prototype.celTableCell13 = function () {
                return new UZA.TableCell(this.convFiledName("celTableCell13"));
            };

            Controls.prototype.lblKaigoNinteiShinsakaiJissi = function () {
                return new UZA.Label(this.convFiledName("lblKaigoNinteiShinsakaiJissi"));
            };

            Controls.prototype.celTableCell4 = function () {
                return new UZA.TableCell(this.convFiledName("celTableCell4"));
            };

            Controls.prototype.lblYoteiDay = function () {
                return new UZA.Label(this.convFiledName("lblYoteiDay"));
            };

            Controls.prototype.celTableCell5 = function () {
                return new UZA.TableCell(this.convFiledName("celTableCell5"));
            };

            Controls.prototype.txtShinseiTorokuYoteiDay = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtShinseiTorokuYoteiDay"));
            };

            Controls.prototype.celTableCell6 = function () {
                return new UZA.TableCell(this.convFiledName("celTableCell6"));
            };

            Controls.prototype.txtNinteiChosaIraiYoteiDay = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtNinteiChosaIraiYoteiDay"));
            };

            Controls.prototype.celTableCell14 = function () {
                return new UZA.TableCell(this.convFiledName("celTableCell14"));
            };

            Controls.prototype.txtNinteiChosaJisshiYoteiDay = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtNinteiChosaJisshiYoteiDay"));
            };

            Controls.prototype.celTableCell15 = function () {
                return new UZA.TableCell(this.convFiledName("celTableCell15"));
            };

            Controls.prototype.txtShujiIkenshoSakuseiIraiYoteiDay = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtShujiIkenshoSakuseiIraiYoteiDay"));
            };

            Controls.prototype.celTableCell16 = function () {
                return new UZA.TableCell(this.convFiledName("celTableCell16"));
            };

            Controls.prototype.txtShujiiIkenshoTorokuYoteiDay = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtShujiiIkenshoTorokuYoteiDay"));
            };

            Controls.prototype.celTableCell17 = function () {
                return new UZA.TableCell(this.convFiledName("celTableCell17"));
            };

            Controls.prototype.txtIchijiHanteiYoteiDay = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtIchijiHanteiYoteiDay"));
            };

            Controls.prototype.celTableCell18 = function () {
                return new UZA.TableCell(this.convFiledName("celTableCell18"));
            };

            Controls.prototype.txtMaskingYoteiDay = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtMaskingYoteiDay"));
            };

            Controls.prototype.celTableCell19 = function () {
                return new UZA.TableCell(this.convFiledName("celTableCell19"));
            };

            Controls.prototype.txtKaigoNinteiShinsakaiWaritsukeYoteiDay = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKaigoNinteiShinsakaiWaritsukeYoteiDay"));
            };

            Controls.prototype.celTableCell20 = function () {
                return new UZA.TableCell(this.convFiledName("celTableCell20"));
            };

            Controls.prototype.txtKaigoNinteiShinsakaiJissiYoteiDay = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKaigoNinteiShinsakaiJissiYoteiDay"));
            };

            Controls.prototype.celTableCell21 = function () {
                return new UZA.TableCell(this.convFiledName("celTableCell21"));
            };

            Controls.prototype.lblKanryoDay = function () {
                return new UZA.Label(this.convFiledName("lblKanryoDay"));
            };

            Controls.prototype.celTableCell22 = function () {
                return new UZA.TableCell(this.convFiledName("celTableCell22"));
            };

            Controls.prototype.txtShinseiTorokuKanryoDay = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtShinseiTorokuKanryoDay"));
            };

            Controls.prototype.celTableCell23 = function () {
                return new UZA.TableCell(this.convFiledName("celTableCell23"));
            };

            Controls.prototype.txtNinteiChosaIraiKanryoDay = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtNinteiChosaIraiKanryoDay"));
            };

            Controls.prototype.celTableCell24 = function () {
                return new UZA.TableCell(this.convFiledName("celTableCell24"));
            };

            Controls.prototype.txtNinteiChosaJisshiKanryoDay = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtNinteiChosaJisshiKanryoDay"));
            };

            Controls.prototype.celTableCell25 = function () {
                return new UZA.TableCell(this.convFiledName("celTableCell25"));
            };

            Controls.prototype.txtShujiIkenshoSakuseiIraiKanryoDay = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtShujiIkenshoSakuseiIraiKanryoDay"));
            };

            Controls.prototype.celTableCell26 = function () {
                return new UZA.TableCell(this.convFiledName("celTableCell26"));
            };

            Controls.prototype.txtShujiiIkenshoTorokuKanryoDay = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtShujiiIkenshoTorokuKanryoDay"));
            };

            Controls.prototype.celTableCell27 = function () {
                return new UZA.TableCell(this.convFiledName("celTableCell27"));
            };

            Controls.prototype.txtIchijiHanteiKanryoDay = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtIchijiHanteiKanryoDay"));
            };

            Controls.prototype.celTableCell28 = function () {
                return new UZA.TableCell(this.convFiledName("celTableCell28"));
            };

            Controls.prototype.txtMaskingKanryo = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtMaskingKanryo"));
            };

            Controls.prototype.celTableCell29 = function () {
                return new UZA.TableCell(this.convFiledName("celTableCell29"));
            };

            Controls.prototype.txtKaigoNinteiShinsakaiWaritsukeKanryoDay = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKaigoNinteiShinsakaiWaritsukeKanryoDay"));
            };

            Controls.prototype.celTableCell30 = function () {
                return new UZA.TableCell(this.convFiledName("celTableCell30"));
            };

            Controls.prototype.txtKaigoNinteiShinsakaiJissiKanryoDay = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKaigoNinteiShinsakaiJissiKanryoDay"));
            };

            Controls.prototype.btnModoru = function () {
                return new UZA.Button(this.convFiledName("btnModoru"));
            };

            Controls.prototype.btnKojinShinchokuPrint = function () {
                return new UZA.ButtonBatchRegister(this.convFiledName("btnKojinShinchokuPrint"));
            };
            return Controls;
        })();
        KaigoNinteiShinchokuJokyoKojin.Controls = Controls;
    })(DBD.KaigoNinteiShinchokuJokyoKojin || (DBD.KaigoNinteiShinchokuJokyoKojin = {}));
    var KaigoNinteiShinchokuJokyoKojin = DBD.KaigoNinteiShinchokuJokyoKojin;
})(DBD || (DBD = {}));
