/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />
// <reference path="./../hokenshalist/HokenshaList.ts" />

module DBZ {

     export module NinteiShinseishaFinder {

        export class Events {

            public static onClick_ShosaiJoken(): string {
                return "onClick_ShosaiJoken";
            }

            public static onChange_ddlKoroshoShikibetsuCode(): string {
                return "onChange_ddlKoroshoShikibetsuCode";
            }

            public static onClick_NinteiChosa(): string {
                return "onClick_NinteiChosa";
            }

            public static onOkClose_btnNinteiChosaItakusakiGuide(): string {
                return "onOkClose_btnNinteiChosaItakusakiGuide";
            }

            public static onClick_btnNinteiChosaItakusakiGuide(): string {
                return "onClick_btnNinteiChosaItakusakiGuide";
            }

            public static onOkClose_btnNinteiChosainGuide(): string {
                return "onOkClose_btnNinteiChosainGuide";
            }

            public static onClick_btnNinteiChosainGuide(): string {
                return "onClick_btnNinteiChosainGuide";
            }

            public static onClick_ShujiiJoho(): string {
                return "onClick_ShujiiJoho";
            }

            public static onOkClose_btnShujiiIryokikanGuide(): string {
                return "onOkClose_btnShujiiIryokikanGuide";
            }

            public static onClick_btnShujiiIryokikanGuide(): string {
                return "onClick_btnShujiiIryokikanGuide";
            }

            public static onOkClose_btnShujiiGuide(): string {
                return "onOkClose_btnShujiiGuide";
            }

            public static onClick_btnShujiiGuide(): string {
                return "onClick_btnShujiiGuide";
            }

            public static onClick_IchijiHantei(): string {
                return "onClick_IchijiHantei";
            }

            public static onClick_IchiGoHantei(): string {
                return "onClick_IchiGoHantei";
            }

            public static onClick_KaigoNinteiShinsakaiJoho(): string {
                return "onClick_KaigoNinteiShinsakaiJoho";
            }

            public static onClick_ZenkaiJoho(): string {
                return "onClick_ZenkaiJoho";
            }

            public static onOkClose_btnZenkaiChosaItakusakiGuide(): string {
                return "onOkClose_btnZenkaiChosaItakusakiGuide";
            }

            public static onClick_btnZenkaiChosaItakusakiGuide(): string {
                return "onClick_btnZenkaiChosaItakusakiGuide";
            }

            public static onOkClose_btnZenkaiShujiiIryokikanGuide(): string {
                return "onOkClose_btnZenkaiShujiiIryokikanGuide";
            }

            public static onClick_btnZenkaiShujiiIryokikanGuide(): string {
                return "onClick_btnZenkaiShujiiIryokikanGuide";
            }

            public static onClick_SonotaJoho(): string {
                return "onClick_SonotaJoho";
            }

            public static onClick_KanryoJoho(): string {
                return "onClick_KanryoJoho";
            }

            public static onChange_ddlNowPhase(): string {
                return "onChange_ddlNowPhase";
            }

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

            public txtHihokenshaNumber(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtHihokenshaNumber"));
            }

            //public ddlHokenshaNumber(): DBZ.HokenshaList.ModeController {
            //    return new DBZ.HokenshaList.ModeController(this.convFiledName("ddlHokenshaNumber"));
            //}

            public ddlShichosonCode(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlShichosonCode"));
            }

            public linHorizon(): UZA.HorizontalLine {
                return new UZA.HorizontalLine(this.convFiledName("linHorizon"));
            }

            public txtHihokenshaName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtHihokenshaName"));
            }

            public ddlHihokenshaNameMatchType(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlHihokenshaNameMatchType"));
            }

            public chkMinashiFlag(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkMinashiFlag"));
            }

            public txtNinteiShinseiDateFrom(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNinteiShinseiDateFrom"));
            }

            public lblNinteiShinseiDate(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblNinteiShinseiDate"));
            }

            public txtNinteiShinseiDateTo(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNinteiShinseiDateTo"));
            }

            public txtBirthDateFrom(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtBirthDateFrom"));
            }

            public lblBirthDate(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblBirthDate"));
            }

            public txtBirthDateTO(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtBirthDateTO"));
            }

            public ddlShinseijiShinseiKubun(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlShinseijiShinseiKubun"));
            }

            public chkSeibetsu(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkSeibetsu"));
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

            public ddlKoroshoShikibetsuCode(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlKoroshoShikibetsuCode"));
            }

            public lblYubinNo(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblYubinNo"));
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

            public txtChosaJisshiDateFrom(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtChosaJisshiDateFrom"));
            }

            public lblChosaJisshiDate(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblChosaJisshiDate"));
            }

            public txtChosaJisshiDateTo(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtChosaJisshiDateTo"));
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

            public lblShujiiIryokikan(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblShujiiIryokikan"));
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

            public txtIkenshoKinyuDateFrom(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIkenshoKinyuDateFrom"));
            }

            public lblIkenshoKinyuDateFrom(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblIkenshoKinyuDateFrom"));
            }

            public txtIkenshoKinyuDateTo(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIkenshoKinyuDateTo"));
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

            public txtIchijiHanteiDateFrom(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIchijiHanteiDateFrom"));
            }

            public lblIchijiHanteiDate(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblIchijiHanteiDate"));
            }

            public txtIchijiHanteiDateTo(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIchijiHanteiDateTo"));
            }

            public ddlIchijiHanteiKekka(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlIchijiHanteiKekka"));
            }

            public IchiGoHantei(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("IchiGoHantei"));
            }

            public txtIchiGoHanteiDateFrom(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIchiGoHanteiDateFrom"));
            }

            public lblIchiGoHanteiDate(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblIchiGoHanteiDate"));
            }

            public txtIchiGoHanteiDateTo(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIchiGoHanteiDateTo"));
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

            public txtNinteiYukoKaishiDateFrom(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNinteiYukoKaishiDateFrom"));
            }

            public lblNinteiYukoKaishiDate(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblNinteiYukoKaishiDate"));
            }

            public txtNinteiYukoKaishiDateTo(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNinteiYukoKaishiDateTo"));
            }

            public txtNinteiYukoShuryoDateFrom(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNinteiYukoShuryoDateFrom"));
            }

            public lblNinteiYukoShuryoDate(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblNinteiYukoShuryoDate"));
            }

            public txtNinteiYukoShuryoDate(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNinteiYukoShuryoDate"));
            }

            public txtNijiHanteiDateFrom(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNijiHanteiDateFrom"));
            }

            public lblNijiHanteiDate(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblNijiHanteiDate"));
            }

            public txtNijiHnateiDateTo(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNijiHnateiDateTo"));
            }

            public txtKaisaiDateFrom(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtKaisaiDateFrom"));
            }

            public lblKaisaiDate(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblKaisaiDate"));
            }

            public txtKaisaiDateTo(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtKaisaiDateTo"));
            }

            public lblKaisaiNumber(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblKaisaiNumber"));
            }

            public txtKaisaiNumberStart(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKaisaiNumberStart"));
            }

            public lblKaisaiNoFor(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblKaisaiNoFor"));
            }

            public txtKaisaiNumberEnd(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKaisaiNumberEnd"));
            }

            public ZenkaiJoho(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ZenkaiJoho"));
            }

            public lblZenkaiChosaItakusaki(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblZenkaiChosaItakusaki"));
            }

            public btnZenkaiChosaItakusakiGuide(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnZenkaiChosaItakusakiGuide"));
            }

            public txtZenkaiNinteiChosaItakusakiName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtZenkaiNinteiChosaItakusakiName"));
            }

            public lblZenkaiShujiiIryokikan(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblZenkaiShujiiIryokikan"));
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

            public txtZenkaiYukoKaishiDateFrom(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtZenkaiYukoKaishiDateFrom"));
            }

            public lblZenkaiYukoKaishiDate(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblZenkaiYukoKaishiDate"));
            }

            public txtZenkaiYukoKaishiDateTo(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtZenkaiYukoKaishiDateTo"));
            }

            public SonotaJoho(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("SonotaJoho"));
            }

            public txtGeninShikkanCode(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtGeninShikkanCode"));
            }

            public btnGeninShikkanGuide(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnGeninShikkanGuide"));
            }

            public txtGeninShikkanName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtGeninShikkanName"));
            }

            public txtShinseiKeikaNissu(): UZA.TextBoxNumRange {
                return new UZA.TextBoxNumRange(this.convFiledName("txtShinseiKeikaNissu"));
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

            public lblKoshinTaishoChushutsu(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblKoshinTaishoChushutsu"));
            }

            public chkKoshinTaishoChushutsu(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkKoshinTaishoChushutsu"));
            }

            public lblIchijiHantei(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblIchijiHantei"));
            }

            public chkIchijiHantei(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkIchijiHantei"));
            }

            public lblShinseiUketsuke(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblShinseiUketsuke"));
            }

            public chkShinseiUketsuke(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkShinseiUketsuke"));
            }

            public lblMasking(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblMasking"));
            }

            public chkMasking(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkMasking"));
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

            public lblIkenshoIrai(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblIkenshoIrai"));
            }

            public chkIkenshoIrai(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkIkenshoIrai"));
            }

            public lblNijiHantei(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblNijiHantei"));
            }

            public chkNijiHantei(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkNijiHantei"));
            }

            public lblChosaNyushu(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblChosaNyushu"));
            }

            public chkChosaNyushu(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkChosaNyushu"));
            }

            public lblTsuchiShori(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTsuchiShori"));
            }

            public chkTsuchiShori(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkTsuchiShori"));
            }

            public lblIkenshoNyushu(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblIkenshoNyushu"));
            }

            public chkIkenshoNyushu(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkIkenshoNyushu"));
            }

            public lblGetsureiShori(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblGetsureiShori"));
            }

            public chkGetsureiShori(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkGetsureiShori"));
            }

        }

     }

}

