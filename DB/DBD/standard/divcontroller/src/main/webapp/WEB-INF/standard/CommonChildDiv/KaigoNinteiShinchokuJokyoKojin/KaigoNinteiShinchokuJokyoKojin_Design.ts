/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />
// <reference path="../../d.ts/DBZCommonChildDiv.d.ts" />

module DBD {

     export module KaigoNinteiShinchokuJokyoKojin {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "KaigoNinteiShinchokuJokyoKojin";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBD.KaigoNinteiShinchokuJokyoKojin.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBD.KaigoNinteiShinchokuJokyoKojin.Controls.myType() + "_" + fieldName;
            }

            public KaigoNinteiShinchokuJokyoKojin(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            //public ccdKaigoNinteiShinseishaInfo(): DBZ.KaigoNinteiShinseishaInfo.ModeController {
            //    return new DBZ.KaigoNinteiShinseishaInfo.ModeController(this.convFiledName("ccdKaigoNinteiShinseishaInfo"));
            //}

            public ShinchokuJokyo(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ShinchokuJokyo"));
            }

            public tplShinchoKujokyo(): UZA.TablePanel {
                return new UZA.TablePanel(this.convFiledName("tplShinchoKujokyo"));
            }

            public celTableCell1(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTableCell1"));
            }

            public celTableCell2(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTableCell2"));
            }

            public lblShinseiToroku(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblShinseiToroku"));
            }

            public celTableCell3(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTableCell3"));
            }

            public lblNinteiChosaIrai(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblNinteiChosaIrai"));
            }

            public celTableCell7(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTableCell7"));
            }

            public lblNinteiChosaJisshi(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblNinteiChosaJisshi"));
            }

            public celTableCell8(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTableCell8"));
            }

            public ShujiIkenshoSakuseiIrai(): UZA.Label {
                return new UZA.Label(this.convFiledName("ShujiIkenshoSakuseiIrai"));
            }

            public celTableCell9(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTableCell9"));
            }

            public lblShujiiIkenshoToroku(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblShujiiIkenshoToroku"));
            }

            public celTableCell10(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTableCell10"));
            }

            public IblIchijiHantei(): UZA.Label {
                return new UZA.Label(this.convFiledName("IblIchijiHantei"));
            }

            public celTableCell11(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTableCell11"));
            }

            public lblMasking(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblMasking"));
            }

            public celTableCell12(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTableCell12"));
            }

            public lblKaigoNinteiShinsakaiWaritsuke(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblKaigoNinteiShinsakaiWaritsuke"));
            }

            public celTableCell13(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTableCell13"));
            }

            public lblKaigoNinteiShinsakaiJissi(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblKaigoNinteiShinsakaiJissi"));
            }

            public celTableCell4(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTableCell4"));
            }

            public lblYoteiDay(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblYoteiDay"));
            }

            public celTableCell5(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTableCell5"));
            }

            public txtShinseiTorokuYoteiDay(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtShinseiTorokuYoteiDay"));
            }

            public celTableCell6(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTableCell6"));
            }

            public txtNinteiChosaIraiYoteiDay(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtNinteiChosaIraiYoteiDay"));
            }

            public celTableCell14(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTableCell14"));
            }

            public txtNinteiChosaJisshiYoteiDay(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtNinteiChosaJisshiYoteiDay"));
            }

            public celTableCell15(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTableCell15"));
            }

            public txtShujiIkenshoSakuseiIraiYoteiDay(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtShujiIkenshoSakuseiIraiYoteiDay"));
            }

            public celTableCell16(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTableCell16"));
            }

            public txtShujiiIkenshoTorokuYoteiDay(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtShujiiIkenshoTorokuYoteiDay"));
            }

            public celTableCell17(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTableCell17"));
            }

            public txtIchijiHanteiYoteiDay(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtIchijiHanteiYoteiDay"));
            }

            public celTableCell18(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTableCell18"));
            }

            public txtMaskingYoteiDay(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtMaskingYoteiDay"));
            }

            public celTableCell19(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTableCell19"));
            }

            public txtKaigoNinteiShinsakaiWaritsukeYoteiDay(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtKaigoNinteiShinsakaiWaritsukeYoteiDay"));
            }

            public celTableCell20(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTableCell20"));
            }

            public txtKaigoNinteiShinsakaiJissiYoteiDay(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtKaigoNinteiShinsakaiJissiYoteiDay"));
            }

            public celTableCell21(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTableCell21"));
            }

            public lblKanryoDay(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblKanryoDay"));
            }

            public celTableCell22(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTableCell22"));
            }

            public txtShinseiTorokuKanryoDay(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtShinseiTorokuKanryoDay"));
            }

            public celTableCell23(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTableCell23"));
            }

            public txtNinteiChosaIraiKanryoDay(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtNinteiChosaIraiKanryoDay"));
            }

            public celTableCell24(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTableCell24"));
            }

            public txtNinteiChosaJisshiKanryoDay(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtNinteiChosaJisshiKanryoDay"));
            }

            public celTableCell25(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTableCell25"));
            }

            public txtShujiIkenshoSakuseiIraiKanryoDay(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtShujiIkenshoSakuseiIraiKanryoDay"));
            }

            public celTableCell26(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTableCell26"));
            }

            public txtShujiiIkenshoTorokuKanryoDay(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtShujiiIkenshoTorokuKanryoDay"));
            }

            public celTableCell27(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTableCell27"));
            }

            public txtIchijiHanteiKanryoDay(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtIchijiHanteiKanryoDay"));
            }

            public celTableCell28(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTableCell28"));
            }

            public txtMaskingKanryo(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtMaskingKanryo"));
            }

            public celTableCell29(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTableCell29"));
            }

            public txtKaigoNinteiShinsakaiWaritsukeKanryoDay(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtKaigoNinteiShinsakaiWaritsukeKanryoDay"));
            }

            public celTableCell30(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTableCell30"));
            }

            public txtKaigoNinteiShinsakaiJissiKanryoDay(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtKaigoNinteiShinsakaiJissiKanryoDay"));
            }

            //public ccdNinteiChosaJokyoInput(): DBZ.NinteiChosaJokyoInput.ModeController {
            //    return new DBZ.NinteiChosaJokyoInput.ModeController(this.convFiledName("ccdNinteiChosaJokyoInput"));
            //}

            public btnModoru(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnModoru"));
            }

            public btnKojinShinchokuPrint(): UZA.ButtonBatchRegister {
                return new UZA.ButtonBatchRegister(this.convFiledName("btnKojinShinchokuPrint"));
            }

        }

     }

}

