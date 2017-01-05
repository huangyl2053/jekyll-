var DBZ;
(function (DBZ) {
    (function (NinteiShinseishaFinder) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_ShosaiJoken = function () {
                return "onClick_ShosaiJoken";
            };

            Events.onChange_ddlKoroshoShikibetsuCode = function () {
                return "onChange_ddlKoroshoShikibetsuCode";
            };

            Events.onClick_NinteiChosa = function () {
                return "onClick_NinteiChosa";
            };

            Events.onBlur_txtNinteiChosaIinItakuSaki = function () {
                return "onBlur_txtNinteiChosaIinItakuSaki";
            };

            Events.onOkClose_btnNinteiChosaItakusakiGuide = function () {
                return "onOkClose_btnNinteiChosaItakusakiGuide";
            };

            Events.onClick_btnNinteiChosaItakusakiGuide = function () {
                return "onClick_btnNinteiChosaItakusakiGuide";
            };

            Events.onBlur_txtNinteiChosaInShimei = function () {
                return "onBlur_txtNinteiChosaInShimei";
            };

            Events.onOkClose_btnNinteiChosainGuide = function () {
                return "onOkClose_btnNinteiChosainGuide";
            };

            Events.onClick_btnNinteiChosainGuide = function () {
                return "onClick_btnNinteiChosainGuide";
            };

            Events.onClick_ShujiiJoho = function () {
                return "onClick_ShujiiJoho";
            };

            Events.onBlur_txtShujiiIryokikan = function () {
                return "onBlur_txtShujiiIryokikan";
            };

            Events.onOkClose_btnShujiiIryokikanGuide = function () {
                return "onOkClose_btnShujiiIryokikanGuide";
            };

            Events.onClick_btnShujiiIryokikanGuide = function () {
                return "onClick_btnShujiiIryokikanGuide";
            };

            Events.onBlur_txtShujiiShimei = function () {
                return "onBlur_txtShujiiShimei";
            };

            Events.onOkClose_btnShujiiGuide = function () {
                return "onOkClose_btnShujiiGuide";
            };

            Events.onClick_btnShujiiGuide = function () {
                return "onClick_btnShujiiGuide";
            };

            Events.onClick_IchijiHantei = function () {
                return "onClick_IchijiHantei";
            };

            Events.onClick_IchiGoHantei = function () {
                return "onClick_IchiGoHantei";
            };

            Events.onClick_KaigoNinteiShinsakaiJoho = function () {
                return "onClick_KaigoNinteiShinsakaiJoho";
            };

            Events.onClick_ZenkaiJoho = function () {
                return "onClick_ZenkaiJoho";
            };

            Events.onBlur_txtZenkaiChosaItakusaki = function () {
                return "onBlur_txtZenkaiChosaItakusaki";
            };

            Events.onOkClose_btnZenkaiChosaItakusakiGuide = function () {
                return "onOkClose_btnZenkaiChosaItakusakiGuide";
            };

            Events.onClick_btnZenkaiChosaItakusakiGuide = function () {
                return "onClick_btnZenkaiChosaItakusakiGuide";
            };

            Events.onBlur_txtZenkaiShujiiIryokikan = function () {
                return "onBlur_txtZenkaiShujiiIryokikan";
            };

            Events.onOkClose_btnZenkaiShujiiIryokikanGuide = function () {
                return "onOkClose_btnZenkaiShujiiIryokikanGuide";
            };

            Events.onClick_btnZenkaiShujiiIryokikanGuide = function () {
                return "onClick_btnZenkaiShujiiIryokikanGuide";
            };

            Events.onClick_SonotaJoho = function () {
                return "onClick_SonotaJoho";
            };

            Events.onClick_KanryoJoho = function () {
                return "onClick_KanryoJoho";
            };

            Events.onChange_ddlNowPhase = function () {
                return "onChange_ddlNowPhase";
            };

            Events.onChange_chkShoriJotai = function () {
                return "onChange_chkShoriJotai";
            };

            Events.onChange_chkIchijiHantei = function () {
                return "onChange_chkIchijiHantei";
            };

            Events.onChange_chkShinseiUketsuke = function () {
                return "onChange_chkShinseiUketsuke";
            };

            Events.onChange_chkMasking = function () {
                return "onChange_chkMasking";
            };

            Events.onChange_chkChosaIrai = function () {
                return "onChange_chkChosaIrai";
            };

            Events.onChange_chkShinsakaiToroku = function () {
                return "onChange_chkShinsakaiToroku";
            };

            Events.onChange_chkIkenshoIrai = function () {
                return "onChange_chkIkenshoIrai";
            };

            Events.onChange_chkNijiHantei = function () {
                return "onChange_chkNijiHantei";
            };

            Events.onChange_chkChosaNyushu = function () {
                return "onChange_chkChosaNyushu";
            };

            Events.onChange_chkIkenshoNyushu = function () {
                return "onChange_chkIkenshoNyushu";
            };

            Events.onChange_chkGetsureiShori = function () {
                return "onChange_chkGetsureiShori";
            };
            return Events;
        })();
        NinteiShinseishaFinder.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "NinteiShinseishaFinder";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.NinteiShinseishaFinder.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.NinteiShinseishaFinder.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.NinteiShinseishaFinder = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtHihokenshaNumber = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtHihokenshaNumber"));
            };

            Controls.prototype.ddlHokenshaNumber = function () {
                return new DBZ.HokenshaList.ModeController(this.convFiledName("ddlHokenshaNumber"));
            };

            Controls.prototype.ddlShichosonCode = function () {
                return new UZA.DropDownList(this.convFiledName("ddlShichosonCode"));
            };

            Controls.prototype.linHorizon = function () {
                return new UZA.HorizontalLine(this.convFiledName("linHorizon"));
            };

            Controls.prototype.txtHihokenshaName = function () {
                return new UZA.TextBox(this.convFiledName("txtHihokenshaName"));
            };

            Controls.prototype.ddlHihokenshaNameMatchType = function () {
                return new UZA.DropDownList(this.convFiledName("ddlHihokenshaNameMatchType"));
            };

            Controls.prototype.chkMinashiFlag = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkMinashiFlag"));
            };

            Controls.prototype.txtNinteiShinseiDateRange = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtNinteiShinseiDateRange"));
            };

            Controls.prototype.txtBirthDateRange = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtBirthDateRange"));
            };

            Controls.prototype.pnlForDesign = function () {
                return new UZA.Panel(this.convFiledName("pnlForDesign"));
            };

            Controls.prototype.ddlShinseijiShinseiKubun = function () {
                return new UZA.DropDownList(this.convFiledName("ddlShinseijiShinseiKubun"));
            };

            Controls.prototype.chkSeibetsu = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkSeibetsu"));
            };

            Controls.prototype.ccdSaikinShorisha = function () {
                return new DBZ.SaikinShorisha.ModeController(this.convFiledName("ccdSaikinShorisha"));
            };

            Controls.prototype.ShosaiJoken = function () {
                return new UZA.Panel(this.convFiledName("ShosaiJoken"));
            };

            Controls.prototype.KihonJoho = function () {
                return new UZA.Panel(this.convFiledName("KihonJoho"));
            };

            Controls.prototype.ddlHihokenshaKubun = function () {
                return new UZA.DropDownList(this.convFiledName("ddlHihokenshaKubun"));
            };

            Controls.prototype.ddlHoreiShinseiji = function () {
                return new UZA.DropDownList(this.convFiledName("ddlHoreiShinseiji"));
            };

            Controls.prototype.ddlShoriKubun = function () {
                return new UZA.DropDownList(this.convFiledName("ddlShoriKubun"));
            };

            Controls.prototype.ddlKoroshoShikibetsuCode = function () {
                return new UZA.DropDownList(this.convFiledName("ddlKoroshoShikibetsuCode"));
            };

            Controls.prototype.lblYubinNo = function () {
                return new UZA.Label(this.convFiledName("lblYubinNo"));
            };

            Controls.prototype.txtYubinNo = function () {
                return new UZA.TextBoxYubinNo(this.convFiledName("txtYubinNo"));
            };

            Controls.prototype.ddlChiku = function () {
                return new UZA.DropDownList(this.convFiledName("ddlChiku"));
            };

            Controls.prototype.chkShisetsuNyusho = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkShisetsuNyusho"));
            };

            Controls.prototype.NinteiChosa = function () {
                return new UZA.Panel(this.convFiledName("NinteiChosa"));
            };

            Controls.prototype.txtNinteiChosaIinItakuSaki = function () {
                return new UZA.TextBoxDomainCode(this.convFiledName("txtNinteiChosaIinItakuSaki"));
            };

            Controls.prototype.btnNinteiChosaItakusakiGuide = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnNinteiChosaItakusakiGuide"));
            };

            Controls.prototype.txtNinteiChosaItakusakiName = function () {
                return new UZA.TextBox(this.convFiledName("txtNinteiChosaItakusakiName"));
            };

            Controls.prototype.txtNinteiChosaInShimei = function () {
                return new UZA.TextBoxDomainCode(this.convFiledName("txtNinteiChosaInShimei"));
            };

            Controls.prototype.btnNinteiChosainGuide = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnNinteiChosainGuide"));
            };

            Controls.prototype.txtNinteiChosainName = function () {
                return new UZA.TextBox(this.convFiledName("txtNinteiChosainName"));
            };

            Controls.prototype.ddlChosaJisshiBasho = function () {
                return new UZA.DropDownList(this.convFiledName("ddlChosaJisshiBasho"));
            };

            Controls.prototype.ddlChosaKubun = function () {
                return new UZA.DropDownList(this.convFiledName("ddlChosaKubun"));
            };

            Controls.prototype.txtChosaJisshiDateRange = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtChosaJisshiDateRange"));
            };

            Controls.prototype.ddlNinteiChosaNetakirido = function () {
                return new UZA.DropDownList(this.convFiledName("ddlNinteiChosaNetakirido"));
            };

            Controls.prototype.ddlNinteiChosaNinchido = function () {
                return new UZA.DropDownList(this.convFiledName("ddlNinteiChosaNinchido"));
            };

            Controls.prototype.ShujiiJoho = function () {
                return new UZA.Panel(this.convFiledName("ShujiiJoho"));
            };

            Controls.prototype.txtShujiiIryokikan = function () {
                return new UZA.TextBoxDomainCode(this.convFiledName("txtShujiiIryokikan"));
            };

            Controls.prototype.btnShujiiIryokikanGuide = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnShujiiIryokikanGuide"));
            };

            Controls.prototype.txtShujiiIryokikanName = function () {
                return new UZA.TextBox(this.convFiledName("txtShujiiIryokikanName"));
            };

            Controls.prototype.txtShujiiShimei = function () {
                return new UZA.TextBoxDomainCode(this.convFiledName("txtShujiiShimei"));
            };

            Controls.prototype.btnShujiiGuide = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnShujiiGuide"));
            };

            Controls.prototype.txtShujiiName = function () {
                return new UZA.TextBox(this.convFiledName("txtShujiiName"));
            };

            Controls.prototype.ddlShujiIkubun = function () {
                return new UZA.DropDownList(this.convFiledName("ddlShujiIkubun"));
            };

            Controls.prototype.txtIkenshoKinyuDateRange = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtIkenshoKinyuDateRange"));
            };

            Controls.prototype.ddlShujiJohoNetakirido = function () {
                return new UZA.DropDownList(this.convFiledName("ddlShujiJohoNetakirido"));
            };

            Controls.prototype.ddlShujiJohoNinchido = function () {
                return new UZA.DropDownList(this.convFiledName("ddlShujiJohoNinchido"));
            };

            Controls.prototype.IchijiHantei = function () {
                return new UZA.Panel(this.convFiledName("IchijiHantei"));
            };

            Controls.prototype.txtIchijiHanteiDateRange = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtIchijiHanteiDateRange"));
            };

            Controls.prototype.ddlIchijiHanteiKekka = function () {
                return new UZA.DropDownList(this.convFiledName("ddlIchijiHanteiKekka"));
            };

            Controls.prototype.IchiGoHantei = function () {
                return new UZA.Panel(this.convFiledName("IchiGoHantei"));
            };

            Controls.prototype.txtIchiGoHanteiDateRange = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtIchiGoHanteiDateRange"));
            };

            Controls.prototype.ddlIchiGohanteiKekka = function () {
                return new UZA.DropDownList(this.convFiledName("ddlIchiGohanteiKekka"));
            };

            Controls.prototype.KaigoNinteiShinsakaiJoho = function () {
                return new UZA.Panel(this.convFiledName("KaigoNinteiShinsakaiJoho"));
            };

            Controls.prototype.ddlNijiHanteiKekka = function () {
                return new UZA.DropDownList(this.convFiledName("ddlNijiHanteiKekka"));
            };

            Controls.prototype.txtNinteiYukoKikan = function () {
                return new UZA.TextBox(this.convFiledName("txtNinteiYukoKikan"));
            };

            Controls.prototype.txtCheckDay = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtCheckDay"));
            };

            Controls.prototype.txtNinteiYukoKaishiDateRange = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtNinteiYukoKaishiDateRange"));
            };

            Controls.prototype.txtNinteiYukoShuryoDateRange = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtNinteiYukoShuryoDateRange"));
            };

            Controls.prototype.txtNijiHanteiDateRange = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtNijiHanteiDateRange"));
            };

            Controls.prototype.txtKaisaiDateRange = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtKaisaiDateRange"));
            };

            Controls.prototype.lblKaisaiNumber = function () {
                return new UZA.Label(this.convFiledName("lblKaisaiNumber"));
            };

            Controls.prototype.txtKaisaiNumberStart = function () {
                return new UZA.TextBox(this.convFiledName("txtKaisaiNumberStart"));
            };

            Controls.prototype.lblKaisaiNoFor = function () {
                return new UZA.Label(this.convFiledName("lblKaisaiNoFor"));
            };

            Controls.prototype.txtKaisaiNumberEnd = function () {
                return new UZA.TextBox(this.convFiledName("txtKaisaiNumberEnd"));
            };

            Controls.prototype.ZenkaiJoho = function () {
                return new UZA.Panel(this.convFiledName("ZenkaiJoho"));
            };

            Controls.prototype.txtZenkaiChosaItakusaki = function () {
                return new UZA.TextBoxDomainCode(this.convFiledName("txtZenkaiChosaItakusaki"));
            };

            Controls.prototype.btnZenkaiChosaItakusakiGuide = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnZenkaiChosaItakusakiGuide"));
            };

            Controls.prototype.txtZenkaiNinteiChosaItakusakiName = function () {
                return new UZA.TextBox(this.convFiledName("txtZenkaiNinteiChosaItakusakiName"));
            };

            Controls.prototype.txtZenkaiShujiiIryokikan = function () {
                return new UZA.TextBoxDomainCode(this.convFiledName("txtZenkaiShujiiIryokikan"));
            };

            Controls.prototype.btnZenkaiShujiiIryokikanGuide = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnZenkaiShujiiIryokikanGuide"));
            };

            Controls.prototype.txtZenkaiShujiiIryokikanName = function () {
                return new UZA.TextBox(this.convFiledName("txtZenkaiShujiiIryokikanName"));
            };

            Controls.prototype.ddlZenkaiNijiHanteiKekka = function () {
                return new UZA.DropDownList(this.convFiledName("ddlZenkaiNijiHanteiKekka"));
            };

            Controls.prototype.txtZenkaiNinteiYukoKikan = function () {
                return new UZA.TextBox(this.convFiledName("txtZenkaiNinteiYukoKikan"));
            };

            Controls.prototype.txtZenkaiYukoKaishiDateRange = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtZenkaiYukoKaishiDateRange"));
            };

            Controls.prototype.SonotaJoho = function () {
                return new UZA.Panel(this.convFiledName("SonotaJoho"));
            };

            Controls.prototype.ccdGeninShikkan = function () {
                return new URZ.CodeInput.ModeController(this.convFiledName("ccdGeninShikkan"));
            };

            Controls.prototype.txtShinseiKeikaNissu = function () {
                return new UZA.TextBoxNumRange(this.convFiledName("txtShinseiKeikaNissu"));
            };

            Controls.prototype.KanryoJoho = function () {
                return new UZA.Panel(this.convFiledName("KanryoJoho"));
            };

            Controls.prototype.ddlNowPhase = function () {
                return new UZA.DropDownList(this.convFiledName("ddlNowPhase"));
            };

            Controls.prototype.chkShoriJotai = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkShoriJotai"));
            };

            Controls.prototype.lblKoshinTaishoChushutsu = function () {
                return new UZA.Label(this.convFiledName("lblKoshinTaishoChushutsu"));
            };

            Controls.prototype.chkKoshinTaishoChushutsu = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkKoshinTaishoChushutsu"));
            };

            Controls.prototype.lblIchijiHantei = function () {
                return new UZA.Label(this.convFiledName("lblIchijiHantei"));
            };

            Controls.prototype.chkIchijiHantei = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkIchijiHantei"));
            };

            Controls.prototype.lblShinseiUketsuke = function () {
                return new UZA.Label(this.convFiledName("lblShinseiUketsuke"));
            };

            Controls.prototype.chkShinseiUketsuke = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkShinseiUketsuke"));
            };

            Controls.prototype.lblMasking = function () {
                return new UZA.Label(this.convFiledName("lblMasking"));
            };

            Controls.prototype.chkMasking = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkMasking"));
            };

            Controls.prototype.lblChosaIrai = function () {
                return new UZA.Label(this.convFiledName("lblChosaIrai"));
            };

            Controls.prototype.chkChosaIrai = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkChosaIrai"));
            };

            Controls.prototype.lblShinsakaiToroku = function () {
                return new UZA.Label(this.convFiledName("lblShinsakaiToroku"));
            };

            Controls.prototype.chkShinsakaiToroku = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkShinsakaiToroku"));
            };

            Controls.prototype.lblIkenshoIrai = function () {
                return new UZA.Label(this.convFiledName("lblIkenshoIrai"));
            };

            Controls.prototype.chkIkenshoIrai = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkIkenshoIrai"));
            };

            Controls.prototype.lblNijiHantei = function () {
                return new UZA.Label(this.convFiledName("lblNijiHantei"));
            };

            Controls.prototype.chkNijiHantei = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkNijiHantei"));
            };

            Controls.prototype.lblChosaNyushu = function () {
                return new UZA.Label(this.convFiledName("lblChosaNyushu"));
            };

            Controls.prototype.chkChosaNyushu = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkChosaNyushu"));
            };

            Controls.prototype.lblTsuchiShori = function () {
                return new UZA.Label(this.convFiledName("lblTsuchiShori"));
            };

            Controls.prototype.chkTsuchiShori = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkTsuchiShori"));
            };

            Controls.prototype.lblIkenshoNyushu = function () {
                return new UZA.Label(this.convFiledName("lblIkenshoNyushu"));
            };

            Controls.prototype.chkIkenshoNyushu = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkIkenshoNyushu"));
            };

            Controls.prototype.lblGetsureiShori = function () {
                return new UZA.Label(this.convFiledName("lblGetsureiShori"));
            };

            Controls.prototype.chkGetsureiShori = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkGetsureiShori"));
            };
            return Controls;
        })();
        NinteiShinseishaFinder.Controls = Controls;
    })(DBZ.NinteiShinseishaFinder || (DBZ.NinteiShinseishaFinder = {}));
    var NinteiShinseishaFinder = DBZ.NinteiShinseishaFinder;
})(DBZ || (DBZ = {}));
