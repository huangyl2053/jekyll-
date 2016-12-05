/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module NinteiChosaJokyo {

        export class Events {

            public static onOkClose_btnChosainGuide(): string {
                return "onOkClose_btnChosainGuide";
            }

            public static onBeforeOpenDialog_btnChosainGuide(): string {
                return "onBeforeOpenDialog_btnChosainGuide";
            }

            public static onOKClose_btnItakusakiGuide(): string {
                return "onOKClose_btnItakusakiGuide";
            }

            public static onBeforeOpenDialog_btnItakusakiGuide(): string {
                return "onBeforeOpenDialog_btnItakusakiGuide";
            }

            public static onClick_btnChosainJohoClear(): string {
                return "onClick_btnChosainJohoClear";
            }

            public static onClick_btnZenKaiFukusha(): string {
                return "onClick_btnZenKaiFukusha";
            }

            public static onClick_btnHonninJushoFukusha(): string {
                return "onClick_btnHonninJushoFukusha";
            }

            public static onClick_btnNyushoShisetsuFukusha(): string {
                return "onClick_btnNyushoShisetsuFukusha";
            }

            public static onClick_btnHomonChosaClear(): string {
                return "onClick_btnHomonChosaClear";
            }

            public static onOKClose_btnShujiiGuide(): string {
                return "onOKClose_btnShujiiGuide";
            }

            public static onBeforeOpenDialog_btnShujiiGuide(): string {
                return "onBeforeOpenDialog_btnShujiiGuide";
            }

            public static onOKClose_btnIryoKikanGuide(): string {
                return "onOKClose_btnIryoKikanGuide";
            }

            public static onBeforeOpenDialog_btnIryoKikanGuide(): string {
                return "onBeforeOpenDialog_btnIryoKikanGuide";
            }

            public static onClick_btnShujiiJohoClear(): string {
                return "onClick_btnShujiiJohoClear";
            }

            public static onClick_btnKakutei(): string {
                return "onClick_btnKakutei";
            }

            public static onClick_btnTorikeshi(): string {
                return "onClick_btnTorikeshi";
            }

            public static onClick_btnAllClear(): string {
                return "onClick_btnAllClear";
            }

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

            public btnChosainJohoClear(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnChosainJohoClear"));
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

            public txtNinteiChosaIraiDate(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtNinteiChosaIraiDate"));
            }

            public txtNinteiChosaJisshiYoteiDate(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtNinteiChosaJisshiYoteiDate"));
            }

            public txtNinteiChosaJisshiDate(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtNinteiChosaJisshiDate"));
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

            public btnZenKaiFukusha(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnZenKaiFukusha"));
            }

            public btnHonninJushoFukusha(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnHonninJushoFukusha"));
            }

            public btnNyushoShisetsuFukusha(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnNyushoShisetsuFukusha"));
            }

            public btnHomonChosaClear(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnHomonChosaClear"));
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

            public btnShujiiJohoClear(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnShujiiJohoClear"));
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

            public txtShujiiIryoKikanIraiDate(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtShujiiIryoKikanIraiDate"));
            }

            public txtShujiiIryoKikanNyushuYoteiDate(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtShujiiIryoKikanNyushuYoteiDate"));
            }

            public txtShujiiIryoKikanNyushuDate(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtShujiiIryoKikanNyushuDate"));
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

            public txtIchijiHanteiDate(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtIchijiHanteiDate"));
            }

            public ddlNinchishoKasangoYokaigodo(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlNinchishoKasangoYokaigodo"));
            }

            public KaigoNinteiShinsakai(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KaigoNinteiShinsakai"));
            }

            public txtShinsakaiShiryoSakuseiDate(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtShinsakaiShiryoSakuseiDate"));
            }

            public txtShinsakaiKaisaiYoteiDate(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtShinsakaiKaisaiYoteiDate"));
            }

            public txtNijiHanteiDate(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtNijiHanteiDate"));
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

            public txtEnkiTsuchiHakkoDay(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtEnkiTsuchiHakkoDay"));
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

            public btnAllClear(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnAllClear"));
            }

        }

     }

}

