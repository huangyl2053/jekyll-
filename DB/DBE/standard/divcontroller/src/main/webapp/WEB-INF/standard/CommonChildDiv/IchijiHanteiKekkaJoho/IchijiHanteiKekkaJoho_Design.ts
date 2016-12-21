/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBE {

     export module IchijiHanteiKekkaJoho {

        export class Events {

            public static onClick_btnIchijiHantei(): string {
                return "onClick_btnIchijiHantei";
            }

            public static onClick_btnAfterIchijiHantei(): string {
                return "onClick_btnAfterIchijiHantei";
            }

            public static onClick_btnBack(): string {
                return "onClick_btnBack";
            }

            public static onClick_btnKakutei(): string {
                return "onClick_btnKakutei";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "IchijiHanteiKekkaJoho";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBE.IchijiHanteiKekkaJoho.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBE.IchijiHanteiKekkaJoho.Controls.myType() + "_" + fieldName;
            }

            public IchijiHanteiKekkaJoho(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public btnIchijiHantei(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnIchijiHantei"));
            }

            public btnAfterIchijiHantei(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnAfterIchijiHantei"));
            }

            public txtIchijiHanteibi(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIchijiHanteibi"));
            }

            public ddlIchijiHanteiKekka(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlIchijiHanteiKekka"));
            }

            public ddlIchijiHanteiKekkaNinchishoKasan(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlIchijiHanteiKekkaNinchishoKasan"));
            }

            public txtKijunJikan(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtKijunJikan"));
            }

            public lblChukanHyokaKomokuTokuten(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblChukanHyokaKomokuTokuten"));
            }

            public tblKijunJikan(): UZA.TablePanel {
                return new UZA.TablePanel(this.convFiledName("tblKijunJikan"));
            }

            public celShokujiHeader(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celShokujiHeader"));
            }

            public lblShokuji(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblShokuji"));
            }

            public celHaisetsuHeader(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celHaisetsuHeader"));
            }

            public lblHaisetsu(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblHaisetsu"));
            }

            public celIdoHeader(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celIdoHeader"));
            }

            public lblIdo(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblIdo"));
            }

            public celSeiketsuHojiHeader(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celSeiketsuHojiHeader"));
            }

            public lblSeiketsuhoji(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblSeiketsuhoji"));
            }

            public celKansetsuCareHeader(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKansetsuCareHeader"));
            }

            public lblKansetsuCare(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblKansetsuCare"));
            }

            public celBpsdKanrenHeader(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celBpsdKanrenHeader"));
            }

            public lblBpsdKanren(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblBpsdKanren"));
            }

            public celKinoKunrenHeader(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKinoKunrenHeader"));
            }

            public lblKinoKunren(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblKinoKunren"));
            }

            public celIryoKanrenHeader(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celIryoKanrenHeader"));
            }

            public lblIryoKanren(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblIryoKanren"));
            }

            public celNinchishoKasanHeader(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celNinchishoKasanHeader"));
            }

            public lblNinchishoKasan(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblNinchishoKasan"));
            }

            public celShokuji(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celShokuji"));
            }

            public txtShokuji(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtShokuji"));
            }

            public celHaisetsu(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celHaisetsu"));
            }

            public txtHaisetsu(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtHaisetsu"));
            }

            public celIdo(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celIdo"));
            }

            public txtIdo(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtIdo"));
            }

            public celSeiketsuHoji(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celSeiketsuHoji"));
            }

            public txtSeiketsuHoji(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtSeiketsuHoji"));
            }

            public celKansetsuCare(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKansetsuCare"));
            }

            public txtKansetsuCare(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtKansetsuCare"));
            }

            public celBpsdKanren(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celBpsdKanren"));
            }

            public txtBpsdKanren(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtBpsdKanren"));
            }

            public celKinoKunren(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKinoKunren"));
            }

            public txtKinoKunren(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtKinoKunren"));
            }

            public celIryoKanren(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celIryoKanren"));
            }

            public txtIryoKanren(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtIryoKanren"));
            }

            public celNinchishoKasan(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celNinchishoKasan"));
            }

            public txtNinchishoKasan(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtNinchishoKasan"));
            }

            public tblTyukanHyokaKomokuTokuten(): UZA.TablePanel {
                return new UZA.TablePanel(this.convFiledName("tblTyukanHyokaKomokuTokuten"));
            }

            public celDai1gunHeader(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celDai1gunHeader"));
            }

            public lblDai1gun(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblDai1gun"));
            }

            public celDai2gunHeader(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celDai2gunHeader"));
            }

            public lblDai2gun(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblDai2gun"));
            }

            public celDai3gunHeader(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celDai3gunHeader"));
            }

            public lblDai3gun(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblDai3gun"));
            }

            public celDai4gunHeader(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celDai4gunHeader"));
            }

            public lblDai4gun(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblDai4gun"));
            }

            public celDai5gunHeader(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celDai5gunHeader"));
            }

            public lblDai5gun(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblDai5gun"));
            }

            public celDai6gunHeader(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celDai6gunHeader"));
            }

            public lblDai6gun(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblDai6gun"));
            }

            public celDai7gunHeader(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celDai7gunHeader"));
            }

            public lblDai7gun(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblDai7gun"));
            }

            public celDai1gun(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celDai1gun"));
            }

            public txtDai1gun(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtDai1gun"));
            }

            public celDai2gun(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celDai2gun"));
            }

            public txtDai2gun(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtDai2gun"));
            }

            public celDai3gun(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celDai3gun"));
            }

            public txtDai3gun(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtDai3gun"));
            }

            public celDai4gun(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celDai4gun"));
            }

            public txtDai4gun(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtDai4gun"));
            }

            public celDai5gun(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celDai5gun"));
            }

            public txtDai5gun(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtDai5gun"));
            }

            public celDai6gun(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celDai6gun"));
            }

            public txtDai6gun(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtDai6gun"));
            }

            public celDai7gun(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celDai7gun"));
            }

            public txtDai7gun(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtDai7gun"));
            }

            public lblNichiJyotaiHyokaKekka(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblNichiJyotaiHyokaKekka"));
            }

            public lblNinchiNichijyoSeikatsuJiritsudo(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblNinchiNichijyoSeikatsuJiritsudo"));
            }

            public txtGaizensei(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtGaizensei"));
            }

            public ddlJiritsudoChosa(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlJiritsudoChosa"));
            }

            public ddlJyotaiAnteisei(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlJyotaiAnteisei"));
            }

            public ddlJiritsudoIkensho(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlJiritsudoIkensho"));
            }

            public ddlKyufuKbn(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlKyufuKbn"));
            }

            public lblIchijiHanteiKeikokuCode(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblIchijiHanteiKeikokuCode"));
            }

            public dgIchijiHanteiKeikokuCode(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgIchijiHanteiKeikokuCode"));
            }

            public btnModoru(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnModoru"));
            }

            public btnKakutei(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnKakutei"));
            }

        }

     }

}

