/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBE {

     export module IchijiHanteiKekkaInfo {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "IchijiHanteiKekkaInfo";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBE.IchijiHanteiKekkaInfo.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBE.IchijiHanteiKekkaInfo.Controls.myType() + "_" + fieldName;
            }

            public IchijiHanteiKekkaInfo(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtIchijiHanteibi(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIchijiHanteibi"));
            }

            public txtIchijiHanteiKekka(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtIchijiHanteiKekka"));
            }

            public txtKijunJikan(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKijunJikan"));
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

            public txtShokuji(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShokuji"));
            }

            public celHaisetsu(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celHaisetsu"));
            }

            public txtHaisetsu(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtHaisetsu"));
            }

            public celIdo(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celIdo"));
            }

            public txtIdo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtIdo"));
            }

            public celSeiketsuHoji(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celSeiketsuHoji"));
            }

            public txtSeiketsuHoji(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtSeiketsuHoji"));
            }

            public celKansetsuCare(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKansetsuCare"));
            }

            public txtKansetsuCare(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKansetsuCare"));
            }

            public celBpsdKanren(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celBpsdKanren"));
            }

            public txtBpsdKanren(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtBpsdKanren"));
            }

            public celKinoKunren(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKinoKunren"));
            }

            public txtKinoKunren(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKinoKunren"));
            }

            public celIryoKanren(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celIryoKanren"));
            }

            public txtIryoKanren(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtIryoKanren"));
            }

            public celNinchishoKasan(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celNinchishoKasan"));
            }

            public txtNinchishoKasan(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtNinchishoKasan"));
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

            public txtDai1gun(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtDai1gun"));
            }

            public celDai2gun(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celDai2gun"));
            }

            public txtDai2gun(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtDai2gun"));
            }

            public celDai3gun(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celDai3gun"));
            }

            public txtDai3gun(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtDai3gun"));
            }

            public celDai4gun(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celDai4gun"));
            }

            public txtDai4gun(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtDai4gun"));
            }

            public celDai5gun(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celDai5gun"));
            }

            public txtDai5gun(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtDai5gun"));
            }

            public celDai6gun(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celDai6gun"));
            }

            public txtDai6gun(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtDai6gun"));
            }

            public celDai7gun(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celDai7gun"));
            }

            public txtDai7gun(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtDai7gun"));
            }

            public lblNichiJyotaiHyokaKekka(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblNichiJyotaiHyokaKekka"));
            }

            public lblNinchiNichijyoSeikatsuJiritsudo(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblNinchiNichijyoSeikatsuJiritsudo"));
            }

            public txtGaizensei(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtGaizensei"));
            }

            public txtJiritsudoChosa(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtJiritsudoChosa"));
            }

            public txtJyotaiAnteisei(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtJyotaiAnteisei"));
            }

            public txtJiritsudoIkensho(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtJiritsudoIkensho"));
            }

            public txtKyufuKbn(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKyufuKbn"));
            }

            public lblIchijiHanteiKeikokuCode(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblIchijiHanteiKeikokuCode"));
            }

            public dgIchijiHanteiKeikokuCode(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgIchijiHanteiKeikokuCode"));
            }

        }

     }

}

