var DBE;
(function (DBE) {
    (function (IchiGojiHanteiKekkaJoho) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnBack = function () {
                return "onClick_btnBack";
            };

            Events.onClick_btnKakutei = function () {
                return "onClick_btnKakutei";
            };
            return Events;
        })();
        IchiGojiHanteiKekkaJoho.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "IchiGojiHanteiKekkaJoho";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBE.IchiGojiHanteiKekkaJoho.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBE.IchiGojiHanteiKekkaJoho.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.IchiGojiHanteiKekkaJoho = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtIchijiHanteibi = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIchijiHanteibi"));
            };

            Controls.prototype.txtIchijiHanteiKekka = function () {
                return new UZA.TextBox(this.convFiledName("txtIchijiHanteiKekka"));
            };

            Controls.prototype.txtKijunJikan = function () {
                return new UZA.TextBox(this.convFiledName("txtKijunJikan"));
            };

            Controls.prototype.lblChukanHyokaKomokuTokuten = function () {
                return new UZA.Label(this.convFiledName("lblChukanHyokaKomokuTokuten"));
            };

            Controls.prototype.tblKijunJikan = function () {
                return new UZA.TablePanel(this.convFiledName("tblKijunJikan"));
            };

            Controls.prototype.celShokujiHeader = function () {
                return new UZA.TableCell(this.convFiledName("celShokujiHeader"));
            };

            Controls.prototype.lblShokuji = function () {
                return new UZA.Label(this.convFiledName("lblShokuji"));
            };

            Controls.prototype.celHaisetsuHeader = function () {
                return new UZA.TableCell(this.convFiledName("celHaisetsuHeader"));
            };

            Controls.prototype.lblHaisetsu = function () {
                return new UZA.Label(this.convFiledName("lblHaisetsu"));
            };

            Controls.prototype.celIdoHeader = function () {
                return new UZA.TableCell(this.convFiledName("celIdoHeader"));
            };

            Controls.prototype.lblIdo = function () {
                return new UZA.Label(this.convFiledName("lblIdo"));
            };

            Controls.prototype.celSeiketsuHojiHeader = function () {
                return new UZA.TableCell(this.convFiledName("celSeiketsuHojiHeader"));
            };

            Controls.prototype.lblSeiketsuhoji = function () {
                return new UZA.Label(this.convFiledName("lblSeiketsuhoji"));
            };

            Controls.prototype.celKansetsuCareHeader = function () {
                return new UZA.TableCell(this.convFiledName("celKansetsuCareHeader"));
            };

            Controls.prototype.lblKansetsuCare = function () {
                return new UZA.Label(this.convFiledName("lblKansetsuCare"));
            };

            Controls.prototype.celBpsdKanrenHeader = function () {
                return new UZA.TableCell(this.convFiledName("celBpsdKanrenHeader"));
            };

            Controls.prototype.lblBpsdKanren = function () {
                return new UZA.Label(this.convFiledName("lblBpsdKanren"));
            };

            Controls.prototype.celKinoKunrenHeader = function () {
                return new UZA.TableCell(this.convFiledName("celKinoKunrenHeader"));
            };

            Controls.prototype.lblKinoKunren = function () {
                return new UZA.Label(this.convFiledName("lblKinoKunren"));
            };

            Controls.prototype.celIryoKanrenHeader = function () {
                return new UZA.TableCell(this.convFiledName("celIryoKanrenHeader"));
            };

            Controls.prototype.lblIryoKanren = function () {
                return new UZA.Label(this.convFiledName("lblIryoKanren"));
            };

            Controls.prototype.celNinchishoKasanHeader = function () {
                return new UZA.TableCell(this.convFiledName("celNinchishoKasanHeader"));
            };

            Controls.prototype.lblNinchishoKasan = function () {
                return new UZA.Label(this.convFiledName("lblNinchishoKasan"));
            };

            Controls.prototype.celShokuji = function () {
                return new UZA.TableCell(this.convFiledName("celShokuji"));
            };

            Controls.prototype.txtShokuji = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtShokuji"));
            };

            Controls.prototype.celHaisetsu = function () {
                return new UZA.TableCell(this.convFiledName("celHaisetsu"));
            };

            Controls.prototype.txtHaisetsu = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtHaisetsu"));
            };

            Controls.prototype.celIdo = function () {
                return new UZA.TableCell(this.convFiledName("celIdo"));
            };

            Controls.prototype.txtIdo = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtIdo"));
            };

            Controls.prototype.celSeiketsuHoji = function () {
                return new UZA.TableCell(this.convFiledName("celSeiketsuHoji"));
            };

            Controls.prototype.txtSeiketsuHoji = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtSeiketsuHoji"));
            };

            Controls.prototype.celKansetsuCare = function () {
                return new UZA.TableCell(this.convFiledName("celKansetsuCare"));
            };

            Controls.prototype.txtKansetsuCare = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtKansetsuCare"));
            };

            Controls.prototype.celBpsdKanren = function () {
                return new UZA.TableCell(this.convFiledName("celBpsdKanren"));
            };

            Controls.prototype.txtBpsdKanren = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtBpsdKanren"));
            };

            Controls.prototype.celKinoKunren = function () {
                return new UZA.TableCell(this.convFiledName("celKinoKunren"));
            };

            Controls.prototype.txtKinoKunren = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtKinoKunren"));
            };

            Controls.prototype.celIryoKanren = function () {
                return new UZA.TableCell(this.convFiledName("celIryoKanren"));
            };

            Controls.prototype.txtIryoKanren = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtIryoKanren"));
            };

            Controls.prototype.celNinchishoKasan = function () {
                return new UZA.TableCell(this.convFiledName("celNinchishoKasan"));
            };

            Controls.prototype.txtNinchishoKasan = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtNinchishoKasan"));
            };

            Controls.prototype.tblTyukanHyokaKomokuTokuten = function () {
                return new UZA.TablePanel(this.convFiledName("tblTyukanHyokaKomokuTokuten"));
            };

            Controls.prototype.celDai1gunHeader = function () {
                return new UZA.TableCell(this.convFiledName("celDai1gunHeader"));
            };

            Controls.prototype.lblDai1gun = function () {
                return new UZA.Label(this.convFiledName("lblDai1gun"));
            };

            Controls.prototype.celDai2gunHeader = function () {
                return new UZA.TableCell(this.convFiledName("celDai2gunHeader"));
            };

            Controls.prototype.lblDai2gun = function () {
                return new UZA.Label(this.convFiledName("lblDai2gun"));
            };

            Controls.prototype.celDai3gunHeader = function () {
                return new UZA.TableCell(this.convFiledName("celDai3gunHeader"));
            };

            Controls.prototype.lblDai3gun = function () {
                return new UZA.Label(this.convFiledName("lblDai3gun"));
            };

            Controls.prototype.celDai4gunHeader = function () {
                return new UZA.TableCell(this.convFiledName("celDai4gunHeader"));
            };

            Controls.prototype.lblDai4gun = function () {
                return new UZA.Label(this.convFiledName("lblDai4gun"));
            };

            Controls.prototype.celDai5gunHeader = function () {
                return new UZA.TableCell(this.convFiledName("celDai5gunHeader"));
            };

            Controls.prototype.lblDai5gun = function () {
                return new UZA.Label(this.convFiledName("lblDai5gun"));
            };

            Controls.prototype.celDai1gun = function () {
                return new UZA.TableCell(this.convFiledName("celDai1gun"));
            };

            Controls.prototype.txtDai1gun = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtDai1gun"));
            };

            Controls.prototype.celDai2gun = function () {
                return new UZA.TableCell(this.convFiledName("celDai2gun"));
            };

            Controls.prototype.txtDai2gun = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtDai2gun"));
            };

            Controls.prototype.celDai3gun = function () {
                return new UZA.TableCell(this.convFiledName("celDai3gun"));
            };

            Controls.prototype.txtDai3gun = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtDai3gun"));
            };

            Controls.prototype.celDai4gun = function () {
                return new UZA.TableCell(this.convFiledName("celDai4gun"));
            };

            Controls.prototype.txtDai4gun = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtDai4gun"));
            };

            Controls.prototype.celDai5gun = function () {
                return new UZA.TableCell(this.convFiledName("celDai5gun"));
            };

            Controls.prototype.txtDai5gun = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtDai5gun"));
            };

            Controls.prototype.lblNichiJyotaiHyokaKekka = function () {
                return new UZA.Label(this.convFiledName("lblNichiJyotaiHyokaKekka"));
            };

            Controls.prototype.lblNinchiNichijyoSeikatsuJiritsudo = function () {
                return new UZA.Label(this.convFiledName("lblNinchiNichijyoSeikatsuJiritsudo"));
            };

            Controls.prototype.txtGaizensei = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtGaizensei"));
            };

            Controls.prototype.txtJiritsudoChosa = function () {
                return new UZA.TextBox(this.convFiledName("txtJiritsudoChosa"));
            };

            Controls.prototype.txtJyotaiAnteisei = function () {
                return new UZA.TextBox(this.convFiledName("txtJyotaiAnteisei"));
            };

            Controls.prototype.txtJiritsudoIkensho = function () {
                return new UZA.TextBox(this.convFiledName("txtJiritsudoIkensho"));
            };

            Controls.prototype.txtKyufuKbn = function () {
                return new UZA.TextBox(this.convFiledName("txtKyufuKbn"));
            };

            Controls.prototype.lblIchijiHanteiKeikokuCode = function () {
                return new UZA.Label(this.convFiledName("lblIchijiHanteiKeikokuCode"));
            };

            Controls.prototype.dgIchijiHanteiKeikokuCode = function () {
                return new UZA.DataGrid(this.convFiledName("dgIchijiHanteiKeikokuCode"));
            };

            Controls.prototype.btnModoru = function () {
                return new UZA.Button(this.convFiledName("btnModoru"));
            };

            Controls.prototype.btnKakutei = function () {
                return new UZA.Button(this.convFiledName("btnKakutei"));
            };
            return Controls;
        })();
        IchiGojiHanteiKekkaJoho.Controls = Controls;
    })(DBE.IchiGojiHanteiKekkaJoho || (DBE.IchiGojiHanteiKekkaJoho = {}));
    var IchiGojiHanteiKekkaJoho = DBE.IchiGojiHanteiKekkaJoho;
})(DBE || (DBE = {}));
