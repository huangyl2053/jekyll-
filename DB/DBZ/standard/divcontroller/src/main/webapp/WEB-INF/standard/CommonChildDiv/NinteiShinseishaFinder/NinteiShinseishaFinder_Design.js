var DBZ;
(function (DBZ) {
    (function (NinteiShinseishaFinder) {
        var Events = (function () {
            function Events() {
            }
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
                return new UZA.TextBox(this.convFiledName("txtHihokenshaNumber"));
            };

            Controls.prototype.ddlHokenshaNumber = function () {
                return new UZA.DropDownList(this.convFiledName("ddlHokenshaNumber"));
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

            Controls.prototype.btnHihokenshaGuide = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnHihokenshaGuide"));
            };

            Controls.prototype.ddlHihokenshaNameKensakuJoken = function () {
                return new UZA.DropDownList(this.convFiledName("ddlHihokenshaNameKensakuJoken"));
            };

            Controls.prototype.txtShinseiDay = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtShinseiDay"));
            };

            Controls.prototype.txtBirthYMD = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtBirthYMD"));
            };

            Controls.prototype.ddlShinseijiShinseiKubun = function () {
                return new UZA.DropDownList(this.convFiledName("ddlShinseijiShinseiKubun"));
            };

            Controls.prototype.radSeibetsu = function () {
                return new UZA.RadioButton(this.convFiledName("radSeibetsu"));
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

            Controls.prototype.lblYubinNo = function () {
                return new UZA.Label(this.convFiledName("lblYubinNo"));
            };

            Controls.prototype.btnYubinNoGuide = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnYubinNoGuide"));
            };

            Controls.prototype.txtYubinNo = function () {
                return new UZA.TextBoxYubinNo(this.convFiledName("txtYubinNo"));
            };

            Controls.prototype.ddlChiku = function () {
                return new UZA.DropDownList(this.convFiledName("ddlChiku"));
            };

            Controls.prototype.radShisetsuNyusho = function () {
                return new UZA.RadioButton(this.convFiledName("radShisetsuNyusho"));
            };

            Controls.prototype.ddlNyushoShisetsuShubetsu = function () {
                return new UZA.DropDownList(this.convFiledName("ddlNyushoShisetsuShubetsu"));
            };

            Controls.prototype.txtNyushoShisetsuName = function () {
                return new UZA.TextBox(this.convFiledName("txtNyushoShisetsuName"));
            };

            Controls.prototype.btnNyushoShisetsuGuige = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnNyushoShisetsuGuige"));
            };

            Controls.prototype.ddlNyushoshisetsuKensakuJoken = function () {
                return new UZA.DropDownList(this.convFiledName("ddlNyushoshisetsuKensakuJoken"));
            };

            Controls.prototype.NinteiChosa = function () {
                return new UZA.Panel(this.convFiledName("NinteiChosa"));
            };

            Controls.prototype.lblNinteiChosaIinItakuSaki = function () {
                return new UZA.Label(this.convFiledName("lblNinteiChosaIinItakuSaki"));
            };

            Controls.prototype.btnNinteiChosaItakusakiGuide = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnNinteiChosaItakusakiGuide"));
            };

            Controls.prototype.txtNinteiChosaItakusakiName = function () {
                return new UZA.TextBox(this.convFiledName("txtNinteiChosaItakusakiName"));
            };

            Controls.prototype.lblNinteiChosaInShimei = function () {
                return new UZA.Label(this.convFiledName("lblNinteiChosaInShimei"));
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

            Controls.prototype.txtChosaJisshiDay = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtChosaJisshiDay"));
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

            Controls.prototype.lblShujiiIryoKikan = function () {
                return new UZA.Label(this.convFiledName("lblShujiiIryoKikan"));
            };

            Controls.prototype.btnShujiiIryokikanGuide = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnShujiiIryokikanGuide"));
            };

            Controls.prototype.txtShujiiIryokikanName = function () {
                return new UZA.TextBox(this.convFiledName("txtShujiiIryokikanName"));
            };

            Controls.prototype.lblShujiiName = function () {
                return new UZA.Label(this.convFiledName("lblShujiiName"));
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

            Controls.prototype.txtIkenshoKinyuDay = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtIkenshoKinyuDay"));
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

            Controls.prototype.txtIchijiHanteiYMD = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtIchijiHanteiYMD"));
            };

            Controls.prototype.ddlIchijiHanteiKekka = function () {
                return new UZA.DropDownList(this.convFiledName("ddlIchijiHanteiKekka"));
            };

            Controls.prototype.IchiGoHantei = function () {
                return new UZA.Panel(this.convFiledName("IchiGoHantei"));
            };

            Controls.prototype.txtIchiGoHantei = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtIchiGoHantei"));
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
                return new UZA.TextBox(this.convFiledName("txtCheckDay"));
            };

            Controls.prototype.txtNinteiYukoKaishiYMD = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtNinteiYukoKaishiYMD"));
            };

            Controls.prototype.txtYukoShuryoYMD = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtYukoShuryoYMD"));
            };

            Controls.prototype.txtNijihanteiYMD = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtNijihanteiYMD"));
            };

            Controls.prototype.txtKaisaiYMD = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtKaisaiYMD"));
            };

            Controls.prototype.lblKaisaiNumber = function () {
                return new UZA.Label(this.convFiledName("lblKaisaiNumber"));
            };

            Controls.prototype.btnKaisaiNumberStart = function () {
                return new UZA.Button(this.convFiledName("btnKaisaiNumberStart"));
            };

            Controls.prototype.txtKaisaiNumberStart = function () {
                return new UZA.TextBox(this.convFiledName("txtKaisaiNumberStart"));
            };

            Controls.prototype.lblFor = function () {
                return new UZA.Label(this.convFiledName("lblFor"));
            };

            Controls.prototype.btnKaisaiNumberEnd = function () {
                return new UZA.Button(this.convFiledName("btnKaisaiNumberEnd"));
            };

            Controls.prototype.txtKaisaiNumberEnd = function () {
                return new UZA.TextBox(this.convFiledName("txtKaisaiNumberEnd"));
            };

            Controls.prototype.ZenkaiJoho = function () {
                return new UZA.Panel(this.convFiledName("ZenkaiJoho"));
            };

            Controls.prototype.lblNinteiChosaItakusakiName = function () {
                return new UZA.Label(this.convFiledName("lblNinteiChosaItakusakiName"));
            };

            Controls.prototype.btnZenkaiNinteiChosaItakusakiGuide = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnZenkaiNinteiChosaItakusakiGuide"));
            };

            Controls.prototype.txtZenkaiNinteiChosaItakusakiName = function () {
                return new UZA.TextBox(this.convFiledName("txtZenkaiNinteiChosaItakusakiName"));
            };

            Controls.prototype.lblShujiiIryokikanName = function () {
                return new UZA.Label(this.convFiledName("lblShujiiIryokikanName"));
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

            Controls.prototype.txtZenkaiNinteiYMD = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtZenkaiNinteiYMD"));
            };

            Controls.prototype.SonotaJoho = function () {
                return new UZA.Panel(this.convFiledName("SonotaJoho"));
            };

            Controls.prototype.lblGeninShikkan = function () {
                return new UZA.Label(this.convFiledName("lblGeninShikkan"));
            };

            Controls.prototype.btnGeninShikkanGuide = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnGeninShikkanGuide"));
            };

            Controls.prototype.txtGeninShikkan = function () {
                return new UZA.TextBox(this.convFiledName("txtGeninShikkan"));
            };

            Controls.prototype.txtShinseiKeikaNissu = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtShinseiKeikaNissu"));
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

            Controls.prototype.lblKoshinTaishoJotai = function () {
                return new UZA.Label(this.convFiledName("lblKoshinTaishoJotai"));
            };

            Controls.prototype.chkKoshinTaishoChushutsu = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkKoshinTaishoChushutsu"));
            };

            Controls.prototype.lblIchijiHantei = function () {
                return new UZA.Label(this.convFiledName("lblIchijiHantei"));
            };

            Controls.prototype.chkIchijiHanteiJotai = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkIchijiHanteiJotai"));
            };

            Controls.prototype.lblShinseiUketsukeJotai = function () {
                return new UZA.Label(this.convFiledName("lblShinseiUketsukeJotai"));
            };

            Controls.prototype.chkShinseiUketsukeJotai = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkShinseiUketsukeJotai"));
            };

            Controls.prototype.lblMaskingJotai = function () {
                return new UZA.Label(this.convFiledName("lblMaskingJotai"));
            };

            Controls.prototype.chkMaskingJotai = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkMaskingJotai"));
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

            Controls.prototype.lblIkenshoIraiJotai = function () {
                return new UZA.Label(this.convFiledName("lblIkenshoIraiJotai"));
            };

            Controls.prototype.chkIkenshoIraiJotai = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkIkenshoIraiJotai"));
            };

            Controls.prototype.lblNijiHanteiJotai = function () {
                return new UZA.Label(this.convFiledName("lblNijiHanteiJotai"));
            };

            Controls.prototype.chkNijiHanteiJotai = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkNijiHanteiJotai"));
            };

            Controls.prototype.lblChosaNyushuJotai = function () {
                return new UZA.Label(this.convFiledName("lblChosaNyushuJotai"));
            };

            Controls.prototype.chkChosaNyushuJotai = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkChosaNyushuJotai"));
            };

            Controls.prototype.lblTsuchiShoriJotai = function () {
                return new UZA.Label(this.convFiledName("lblTsuchiShoriJotai"));
            };

            Controls.prototype.chkTsuchiShoriJotai = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkTsuchiShoriJotai"));
            };

            Controls.prototype.lblIkenshoNyushuJotai = function () {
                return new UZA.Label(this.convFiledName("lblIkenshoNyushuJotai"));
            };

            Controls.prototype.chkIkenshoNyushuJotai = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkIkenshoNyushuJotai"));
            };

            Controls.prototype.lblGetsureiShoriJotai = function () {
                return new UZA.Label(this.convFiledName("lblGetsureiShoriJotai"));
            };

            Controls.prototype.chkGetsureiS = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkGetsureiS"));
            };
            return Controls;
        })();
        NinteiShinseishaFinder.Controls = Controls;
    })(DBZ.NinteiShinseishaFinder || (DBZ.NinteiShinseishaFinder = {}));
    var NinteiShinseishaFinder = DBZ.NinteiShinseishaFinder;
})(DBZ || (DBZ = {}));
