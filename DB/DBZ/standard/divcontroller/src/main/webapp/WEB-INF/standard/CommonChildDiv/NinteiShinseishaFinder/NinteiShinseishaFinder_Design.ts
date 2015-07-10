/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module NinteiShinseishaFinder {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "NinteiShinseishaFinder";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.NinteiShinseishaFinder.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.NinteiShinseishaFinder.Controls.myType() + "_" + fieldName;
            }

            public NinteiShinseishaFinder(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtHihokenshaNumber(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtHihokenshaNumber"));
            }

            public ddlHokenshaNumber(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlHokenshaNumber"));
            }

            public ddlShichosonCode(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlShichosonCode"));
            }

            public linHorizon(): UZA.HorizontalLine {
                return new UZA.HorizontalLine(this.convFiledName("linHorizon"));
            }

            public txtHihokenshaName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtHihokenshaName"));
            }

            public btnHihokenshaGuide(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnHihokenshaGuide"));
            }

            public ddlHihokenshaNameKensakuJoken(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlHihokenshaNameKensakuJoken"));
            }

            public txtShinseiDay(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtShinseiDay"));
            }

            public txtBirthYMD(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtBirthYMD"));
            }

            public ddlShinseijiShinseiKubun(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlShinseijiShinseiKubun"));
            }

            public radSeibetsu(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radSeibetsu"));
            }

            public ShosaiJoken(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ShosaiJoken"));
            }

            public KihonJoho(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KihonJoho"));
            }

            public ddlHihokenshaKubun(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlHihokenshaKubun"));
            }

            public ddlHoreiShinseiji(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlHoreiShinseiji"));
            }

            public ddlShoriKubun(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlShoriKubun"));
            }

            public lblYubinNo(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblYubinNo"));
            }

            public btnYubinNoGuide(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnYubinNoGuide"));
            }

            public txtYubinNo(): UZA.TextBoxYubinNo {
                return new UZA.TextBoxYubinNo(this.convFiledName("txtYubinNo"));
            }

            public ddlChiku(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlChiku"));
            }

            public radShisetsuNyusho(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radShisetsuNyusho"));
            }

            public ddlNyushoShisetsuShubetsu(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlNyushoShisetsuShubetsu"));
            }

            public txtNyushoShisetsuName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtNyushoShisetsuName"));
            }

            public btnNyushoShisetsuGuige(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnNyushoShisetsuGuige"));
            }

            public ddlNyushoshisetsuKensakuJoken(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlNyushoshisetsuKensakuJoken"));
            }

            public NinteiChosa(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("NinteiChosa"));
            }

            public lblNinteiChosaIinItakuSaki(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblNinteiChosaIinItakuSaki"));
            }

            public btnNinteiChosaItakusakiGuide(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnNinteiChosaItakusakiGuide"));
            }

            public txtNinteiChosaItakusakiName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtNinteiChosaItakusakiName"));
            }

            public lblNinteiChosaInShimei(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblNinteiChosaInShimei"));
            }

            public btnNinteiChosainGuide(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnNinteiChosainGuide"));
            }

            public txtNinteiChosainName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtNinteiChosainName"));
            }

            public ddlChosaJisshiBasho(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlChosaJisshiBasho"));
            }

            public ddlChosaKubun(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlChosaKubun"));
            }

            public txtChosaJisshiDay(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtChosaJisshiDay"));
            }

            public ddlNinteiChosaNetakirido(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlNinteiChosaNetakirido"));
            }

            public ddlNinteiChosaNinchido(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlNinteiChosaNinchido"));
            }

            public ShujiiJoho(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ShujiiJoho"));
            }

            public lblShujiiIryoKikan(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblShujiiIryoKikan"));
            }

            public btnShujiiIryokikanGuide(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnShujiiIryokikanGuide"));
            }

            public txtShujiiIryokikanName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShujiiIryokikanName"));
            }

            public lblShujiiName(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblShujiiName"));
            }

            public btnShujiiGuide(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnShujiiGuide"));
            }

            public txtShujiiName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShujiiName"));
            }

            public ddlShujiIkubun(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlShujiIkubun"));
            }

            public txtIkenshoKinyuDay(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtIkenshoKinyuDay"));
            }

            public ddlShujiJohoNetakirido(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlShujiJohoNetakirido"));
            }

            public ddlShujiJohoNinchido(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlShujiJohoNinchido"));
            }

            public IchijiHantei(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("IchijiHantei"));
            }

            public txtIchijiHanteiYMD(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtIchijiHanteiYMD"));
            }

            public ddlIchijiHanteiKekka(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlIchijiHanteiKekka"));
            }

            public IchiGoHantei(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("IchiGoHantei"));
            }

            public txtIchiGoHantei(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtIchiGoHantei"));
            }

            public ddlIchiGohanteiKekka(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlIchiGohanteiKekka"));
            }

            public KaigoNinteiShinsakaiJoho(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KaigoNinteiShinsakaiJoho"));
            }

            public ddlNijiHanteiKekka(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlNijiHanteiKekka"));
            }

            public txtNinteiYukoKikan(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtNinteiYukoKikan"));
            }

            public txtCheckDay(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtCheckDay"));
            }

            public txtNinteiYukoKaishiYMD(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtNinteiYukoKaishiYMD"));
            }

            public txtYukoShuryoYMD(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtYukoShuryoYMD"));
            }

            public txtNijihanteiYMD(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtNijihanteiYMD"));
            }

            public txtKaisaiYMD(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtKaisaiYMD"));
            }

            public lblKaisaiNumber(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblKaisaiNumber"));
            }

            public btnKaisaiNumberStart(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnKaisaiNumberStart"));
            }

            public txtKaisaiNumberStart(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKaisaiNumberStart"));
            }

            public lblFor(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFor"));
            }

            public btnKaisaiNumberEnd(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnKaisaiNumberEnd"));
            }

            public txtKaisaiNumberEnd(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKaisaiNumberEnd"));
            }

            public ZenkaiJoho(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ZenkaiJoho"));
            }

            public lblNinteiChosaItakusakiName(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblNinteiChosaItakusakiName"));
            }

            public btnZenkaiNinteiChosaItakusakiGuide(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnZenkaiNinteiChosaItakusakiGuide"));
            }

            public txtZenkaiNinteiChosaItakusakiName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtZenkaiNinteiChosaItakusakiName"));
            }

            public lblShujiiIryokikanName(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblShujiiIryokikanName"));
            }

            public btnZenkaiShujiiIryokikanGuide(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnZenkaiShujiiIryokikanGuide"));
            }

            public txtZenkaiShujiiIryokikanName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtZenkaiShujiiIryokikanName"));
            }

            public ddlZenkaiNijiHanteiKekka(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlZenkaiNijiHanteiKekka"));
            }

            public txtZenkaiNinteiYukoKikan(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtZenkaiNinteiYukoKikan"));
            }

            public txtZenkaiNinteiYMD(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtZenkaiNinteiYMD"));
            }

            public SonotaJoho(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("SonotaJoho"));
            }

            public lblGeninShikkan(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblGeninShikkan"));
            }

            public btnGeninShikkanGuide(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnGeninShikkanGuide"));
            }

            public txtGeninShikkan(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtGeninShikkan"));
            }

            public txtShinseiKeikaNissu(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtShinseiKeikaNissu"));
            }

            public KanryoJoho(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KanryoJoho"));
            }

            public ddlNowPhase(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlNowPhase"));
            }

            public chkShoriJotai(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkShoriJotai"));
            }

            public lblKoshinTaishoJotai(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblKoshinTaishoJotai"));
            }

            public chkKoshinTaishoChushutsu(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkKoshinTaishoChushutsu"));
            }

            public lblIchijiHantei(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblIchijiHantei"));
            }

            public chkIchijiHanteiJotai(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkIchijiHanteiJotai"));
            }

            public lblShinseiUketsukeJotai(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblShinseiUketsukeJotai"));
            }

            public chkShinseiUketsukeJotai(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkShinseiUketsukeJotai"));
            }

            public lblMaskingJotai(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblMaskingJotai"));
            }

            public chkMaskingJotai(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkMaskingJotai"));
            }

            public lblChosaIrai(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblChosaIrai"));
            }

            public chkChosaIrai(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkChosaIrai"));
            }

            public lblShinsakaiToroku(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblShinsakaiToroku"));
            }

            public chkShinsakaiToroku(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkShinsakaiToroku"));
            }

            public lblIkenshoIraiJotai(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblIkenshoIraiJotai"));
            }

            public chkIkenshoIraiJotai(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkIkenshoIraiJotai"));
            }

            public lblNijiHanteiJotai(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblNijiHanteiJotai"));
            }

            public chkNijiHanteiJotai(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkNijiHanteiJotai"));
            }

            public lblChosaNyushuJotai(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblChosaNyushuJotai"));
            }

            public chkChosaNyushuJotai(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkChosaNyushuJotai"));
            }

            public lblTsuchiShoriJotai(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTsuchiShoriJotai"));
            }

            public chkTsuchiShoriJotai(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkTsuchiShoriJotai"));
            }

            public lblIkenshoNyushuJotai(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblIkenshoNyushuJotai"));
            }

            public chkIkenshoNyushuJotai(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkIkenshoNyushuJotai"));
            }

            public lblGetsureiShoriJotai(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblGetsureiShoriJotai"));
            }

            public chkGetsureiS(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkGetsureiS"));
            }

        }

     }

}

