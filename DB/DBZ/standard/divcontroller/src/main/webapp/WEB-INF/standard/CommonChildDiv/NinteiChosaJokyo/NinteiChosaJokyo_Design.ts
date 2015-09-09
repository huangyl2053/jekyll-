/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module NinteiChosaJokyo {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "NinteiChosaJokyo";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.NinteiChosaJokyo.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.NinteiChosaJokyo.Controls.myType() + "_" + fieldName;
            }

            public NinteiChosaJokyo(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public NinteiChosa(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("NinteiChosa"));
            }

            public txtNinteiChosainCode(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtNinteiChosainCode"));
            }

            public btnChosainGuide(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnChosainGuide"));
            }

            public txtNinteiChosainName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtNinteiChosainName"));
            }

            public txtNinteiChosaItakusakiCode(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtNinteiChosaItakusakiCode"));
            }

            public btnItakusakiGuide(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnItakusakiGuide"));
            }

            public txtNinteiChosaItakusakiName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtNinteiChosaItakusakiName"));
            }

            public txtNinteiChosaYubinNo(): UZA.TextBoxYubinNo {
                return new UZA.TextBoxYubinNo(this.convFiledName("txtNinteiChosaYubinNo"));
            }

            public txtNinteiChosaJusho(): UZA.TextBoxJusho {
                return new UZA.TextBoxJusho(this.convFiledName("txtNinteiChosaJusho"));
            }

            public txtNinteiChosaTelNo(): UZA.TextBoxTelNo {
                return new UZA.TextBoxTelNo(this.convFiledName("txtNinteiChosaTelNo"));
            }

            public txtNinteiChosaIraiDate(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNinteiChosaIraiDate"));
            }

            public txtNinteiChosaJisshiYoteiDate(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNinteiChosaJisshiYoteiDate"));
            }

            public txtNinteiChosaJisshiDate(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNinteiChosaJisshiDate"));
            }

            public ddlNinteiChosaItakusakiKubun(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlNinteiChosaItakusakiKubun"));
            }

            public HomonChosasaki(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("HomonChosasaki"));
            }

            public txtChosasakiName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtChosasakiName"));
            }

            public txtChosasakiYubinNo(): UZA.TextBoxYubinNo {
                return new UZA.TextBoxYubinNo(this.convFiledName("txtChosasakiYubinNo"));
            }

            public txtChosasakiJusho(): UZA.TextBoxJusho {
                return new UZA.TextBoxJusho(this.convFiledName("txtChosasakiJusho"));
            }

            public txtChosasakiTelNo(): UZA.TextBoxTelNo {
                return new UZA.TextBoxTelNo(this.convFiledName("txtChosasakiTelNo"));
            }

            public ShujiiAndShujiIryoKikan(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ShujiiAndShujiIryoKikan"));
            }

            public txtShujiiCode(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtShujiiCode"));
            }

            public btnShujiiGuide(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnShujiiGuide"));
            }

            public txtShujiiName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShujiiName"));
            }

            public txtShujiiIryoKikanCode(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtShujiiIryoKikanCode"));
            }

            public btnIryoKikanGuide(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnIryoKikanGuide"));
            }

            public txtShujiiIryoKikanName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShujiiIryoKikanName"));
            }

            public txtShujiiIryoKikanYubinNo(): UZA.TextBoxYubinNo {
                return new UZA.TextBoxYubinNo(this.convFiledName("txtShujiiIryoKikanYubinNo"));
            }

            public txtShujiiIryoKikanJusho(): UZA.TextBoxJusho {
                return new UZA.TextBoxJusho(this.convFiledName("txtShujiiIryoKikanJusho"));
            }

            public txtShujiiIryoKikanTelNo(): UZA.TextBoxTelNo {
                return new UZA.TextBoxTelNo(this.convFiledName("txtShujiiIryoKikanTelNo"));
            }

            public txtShujiiIryoKikanIraiDate(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShujiiIryoKikanIraiDate"));
            }

            public txtShujiiIryoKikanNyushuYoteiDate(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShujiiIryoKikanNyushuYoteiDate"));
            }

            public txtShujiiIryoKikanNyushuDate(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShujiiIryoKikanNyushuDate"));
            }

            public chkShujiiKubun(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkShujiiKubun"));
            }

            public IchijiHantei(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("IchijiHantei"));
            }

            public ddlYokaigodo(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlYokaigodo"));
            }

            public txtIchijiHanteiDate(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIchijiHanteiDate"));
            }

            public ddlNinchishoKasangoYokaigodo(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlNinchishoKasangoYokaigodo"));
            }

            public KaigoNinteiShinsakai(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KaigoNinteiShinsakai"));
            }

            public txtShinsakaiShiryoSakuseiDate(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShinsakaiShiryoSakuseiDate"));
            }

            public txtShinsakaiKaisaiYoteiDate(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShinsakaiKaisaiYoteiDate"));
            }

            public txtNijiHanteiDate(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNijiHanteiDate"));
            }

            public ddlNijiHanteiKekka(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlNijiHanteiKekka"));
            }

            public txtNijiHanteiYukoKikan(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtNijiHanteiYukoKikan"));
            }

            public txtNinteiYukoKikanFrom(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNinteiYukoKikanFrom"));
            }

            public txtNinteiYukoKikanTo(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNinteiYukoKikanTo"));
            }

            public EnkiTsuchi(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("EnkiTsuchi"));
            }

            public txtEnkiTsuchiHakkoDay(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtEnkiTsuchiHakkoDay"));
            }

            public txtEnkiTsuchiHakkoCount(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtEnkiTsuchiHakkoCount"));
            }

            public btnKakutei(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnKakutei"));
            }

            public btnTorikeshi(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnTorikeshi"));
            }

        }

     }

}

