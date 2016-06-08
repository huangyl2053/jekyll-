package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.IchijiHanteiKekkaInfo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * IchijiHanteiKekkaInfo のクラスファイル 
 * 
 * @author 自動生成
 */
public class IchijiHanteiKekkaInfoDiv extends Panel implements IIchijiHanteiKekkaInfoDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtIchijiHanteibi")
    private TextBoxFlexibleDate txtIchijiHanteibi;
    @JsonProperty("txtIchijiHanteiKekka")
    private TextBox txtIchijiHanteiKekka;
    @JsonProperty("txtKijunJikan")
    private TextBox txtKijunJikan;
    @JsonProperty("lblChukanHyokaKomokuTokuten")
    private Label lblChukanHyokaKomokuTokuten;
    @JsonProperty("tblKijunJikan")
    private tblKijunJikanDiv tblKijunJikan;
    @JsonProperty("tblTyukanHyokaKomokuTokuten")
    private tblTyukanHyokaKomokuTokutenDiv tblTyukanHyokaKomokuTokuten;
    @JsonProperty("lblNichiJyotaiHyokaKekka")
    private Label lblNichiJyotaiHyokaKekka;
    @JsonProperty("lblNinchiNichijyoSeikatsuJiritsudo")
    private Label lblNinchiNichijyoSeikatsuJiritsudo;
    @JsonProperty("txtGaizensei")
    private TextBox txtGaizensei;
    @JsonProperty("txtJiritsudoChosa")
    private TextBox txtJiritsudoChosa;
    @JsonProperty("txtJyotaiAnteisei")
    private TextBox txtJyotaiAnteisei;
    @JsonProperty("txtJiritsudoIkensho")
    private TextBox txtJiritsudoIkensho;
    @JsonProperty("txtKyufuKbn")
    private TextBox txtKyufuKbn;
    @JsonProperty("lblIchijiHanteiKeikokuCode")
    private Label lblIchijiHanteiKeikokuCode;
    @JsonProperty("dgIchijiHanteiKeikokuCode")
    private DataGrid<dgIchijiHanteiKeikokuCode_Row> dgIchijiHanteiKeikokuCode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtIchijiHanteibi
     * @return txtIchijiHanteibi
     */
    @JsonProperty("txtIchijiHanteibi")
    public TextBoxFlexibleDate getTxtIchijiHanteibi() {
        return txtIchijiHanteibi;
    }

    /*
     * settxtIchijiHanteibi
     * @param txtIchijiHanteibi txtIchijiHanteibi
     */
    @JsonProperty("txtIchijiHanteibi")
    public void setTxtIchijiHanteibi(TextBoxFlexibleDate txtIchijiHanteibi) {
        this.txtIchijiHanteibi = txtIchijiHanteibi;
    }

    /*
     * gettxtIchijiHanteiKekka
     * @return txtIchijiHanteiKekka
     */
    @JsonProperty("txtIchijiHanteiKekka")
    public TextBox getTxtIchijiHanteiKekka() {
        return txtIchijiHanteiKekka;
    }

    /*
     * settxtIchijiHanteiKekka
     * @param txtIchijiHanteiKekka txtIchijiHanteiKekka
     */
    @JsonProperty("txtIchijiHanteiKekka")
    public void setTxtIchijiHanteiKekka(TextBox txtIchijiHanteiKekka) {
        this.txtIchijiHanteiKekka = txtIchijiHanteiKekka;
    }

    /*
     * gettxtKijunJikan
     * @return txtKijunJikan
     */
    @JsonProperty("txtKijunJikan")
    public TextBox getTxtKijunJikan() {
        return txtKijunJikan;
    }

    /*
     * settxtKijunJikan
     * @param txtKijunJikan txtKijunJikan
     */
    @JsonProperty("txtKijunJikan")
    public void setTxtKijunJikan(TextBox txtKijunJikan) {
        this.txtKijunJikan = txtKijunJikan;
    }

    /*
     * getlblChukanHyokaKomokuTokuten
     * @return lblChukanHyokaKomokuTokuten
     */
    @JsonProperty("lblChukanHyokaKomokuTokuten")
    public Label getLblChukanHyokaKomokuTokuten() {
        return lblChukanHyokaKomokuTokuten;
    }

    /*
     * setlblChukanHyokaKomokuTokuten
     * @param lblChukanHyokaKomokuTokuten lblChukanHyokaKomokuTokuten
     */
    @JsonProperty("lblChukanHyokaKomokuTokuten")
    public void setLblChukanHyokaKomokuTokuten(Label lblChukanHyokaKomokuTokuten) {
        this.lblChukanHyokaKomokuTokuten = lblChukanHyokaKomokuTokuten;
    }

    /*
     * gettblKijunJikan
     * @return tblKijunJikan
     */
    @JsonProperty("tblKijunJikan")
    public tblKijunJikanDiv getTblKijunJikan() {
        return tblKijunJikan;
    }

    /*
     * settblKijunJikan
     * @param tblKijunJikan tblKijunJikan
     */
    @JsonProperty("tblKijunJikan")
    public void setTblKijunJikan(tblKijunJikanDiv tblKijunJikan) {
        this.tblKijunJikan = tblKijunJikan;
    }

    /*
     * gettblTyukanHyokaKomokuTokuten
     * @return tblTyukanHyokaKomokuTokuten
     */
    @JsonProperty("tblTyukanHyokaKomokuTokuten")
    public tblTyukanHyokaKomokuTokutenDiv getTblTyukanHyokaKomokuTokuten() {
        return tblTyukanHyokaKomokuTokuten;
    }

    /*
     * settblTyukanHyokaKomokuTokuten
     * @param tblTyukanHyokaKomokuTokuten tblTyukanHyokaKomokuTokuten
     */
    @JsonProperty("tblTyukanHyokaKomokuTokuten")
    public void setTblTyukanHyokaKomokuTokuten(tblTyukanHyokaKomokuTokutenDiv tblTyukanHyokaKomokuTokuten) {
        this.tblTyukanHyokaKomokuTokuten = tblTyukanHyokaKomokuTokuten;
    }

    /*
     * getlblNichiJyotaiHyokaKekka
     * @return lblNichiJyotaiHyokaKekka
     */
    @JsonProperty("lblNichiJyotaiHyokaKekka")
    public Label getLblNichiJyotaiHyokaKekka() {
        return lblNichiJyotaiHyokaKekka;
    }

    /*
     * setlblNichiJyotaiHyokaKekka
     * @param lblNichiJyotaiHyokaKekka lblNichiJyotaiHyokaKekka
     */
    @JsonProperty("lblNichiJyotaiHyokaKekka")
    public void setLblNichiJyotaiHyokaKekka(Label lblNichiJyotaiHyokaKekka) {
        this.lblNichiJyotaiHyokaKekka = lblNichiJyotaiHyokaKekka;
    }

    /*
     * getlblNinchiNichijyoSeikatsuJiritsudo
     * @return lblNinchiNichijyoSeikatsuJiritsudo
     */
    @JsonProperty("lblNinchiNichijyoSeikatsuJiritsudo")
    public Label getLblNinchiNichijyoSeikatsuJiritsudo() {
        return lblNinchiNichijyoSeikatsuJiritsudo;
    }

    /*
     * setlblNinchiNichijyoSeikatsuJiritsudo
     * @param lblNinchiNichijyoSeikatsuJiritsudo lblNinchiNichijyoSeikatsuJiritsudo
     */
    @JsonProperty("lblNinchiNichijyoSeikatsuJiritsudo")
    public void setLblNinchiNichijyoSeikatsuJiritsudo(Label lblNinchiNichijyoSeikatsuJiritsudo) {
        this.lblNinchiNichijyoSeikatsuJiritsudo = lblNinchiNichijyoSeikatsuJiritsudo;
    }

    /*
     * gettxtGaizensei
     * @return txtGaizensei
     */
    @JsonProperty("txtGaizensei")
    public TextBox getTxtGaizensei() {
        return txtGaizensei;
    }

    /*
     * settxtGaizensei
     * @param txtGaizensei txtGaizensei
     */
    @JsonProperty("txtGaizensei")
    public void setTxtGaizensei(TextBox txtGaizensei) {
        this.txtGaizensei = txtGaizensei;
    }

    /*
     * gettxtJiritsudoChosa
     * @return txtJiritsudoChosa
     */
    @JsonProperty("txtJiritsudoChosa")
    public TextBox getTxtJiritsudoChosa() {
        return txtJiritsudoChosa;
    }

    /*
     * settxtJiritsudoChosa
     * @param txtJiritsudoChosa txtJiritsudoChosa
     */
    @JsonProperty("txtJiritsudoChosa")
    public void setTxtJiritsudoChosa(TextBox txtJiritsudoChosa) {
        this.txtJiritsudoChosa = txtJiritsudoChosa;
    }

    /*
     * gettxtJyotaiAnteisei
     * @return txtJyotaiAnteisei
     */
    @JsonProperty("txtJyotaiAnteisei")
    public TextBox getTxtJyotaiAnteisei() {
        return txtJyotaiAnteisei;
    }

    /*
     * settxtJyotaiAnteisei
     * @param txtJyotaiAnteisei txtJyotaiAnteisei
     */
    @JsonProperty("txtJyotaiAnteisei")
    public void setTxtJyotaiAnteisei(TextBox txtJyotaiAnteisei) {
        this.txtJyotaiAnteisei = txtJyotaiAnteisei;
    }

    /*
     * gettxtJiritsudoIkensho
     * @return txtJiritsudoIkensho
     */
    @JsonProperty("txtJiritsudoIkensho")
    public TextBox getTxtJiritsudoIkensho() {
        return txtJiritsudoIkensho;
    }

    /*
     * settxtJiritsudoIkensho
     * @param txtJiritsudoIkensho txtJiritsudoIkensho
     */
    @JsonProperty("txtJiritsudoIkensho")
    public void setTxtJiritsudoIkensho(TextBox txtJiritsudoIkensho) {
        this.txtJiritsudoIkensho = txtJiritsudoIkensho;
    }

    /*
     * gettxtKyufuKbn
     * @return txtKyufuKbn
     */
    @JsonProperty("txtKyufuKbn")
    public TextBox getTxtKyufuKbn() {
        return txtKyufuKbn;
    }

    /*
     * settxtKyufuKbn
     * @param txtKyufuKbn txtKyufuKbn
     */
    @JsonProperty("txtKyufuKbn")
    public void setTxtKyufuKbn(TextBox txtKyufuKbn) {
        this.txtKyufuKbn = txtKyufuKbn;
    }

    /*
     * getlblIchijiHanteiKeikokuCode
     * @return lblIchijiHanteiKeikokuCode
     */
    @JsonProperty("lblIchijiHanteiKeikokuCode")
    public Label getLblIchijiHanteiKeikokuCode() {
        return lblIchijiHanteiKeikokuCode;
    }

    /*
     * setlblIchijiHanteiKeikokuCode
     * @param lblIchijiHanteiKeikokuCode lblIchijiHanteiKeikokuCode
     */
    @JsonProperty("lblIchijiHanteiKeikokuCode")
    public void setLblIchijiHanteiKeikokuCode(Label lblIchijiHanteiKeikokuCode) {
        this.lblIchijiHanteiKeikokuCode = lblIchijiHanteiKeikokuCode;
    }

    /*
     * getdgIchijiHanteiKeikokuCode
     * @return dgIchijiHanteiKeikokuCode
     */
    @JsonProperty("dgIchijiHanteiKeikokuCode")
    public DataGrid<dgIchijiHanteiKeikokuCode_Row> getDgIchijiHanteiKeikokuCode() {
        return dgIchijiHanteiKeikokuCode;
    }

    /*
     * setdgIchijiHanteiKeikokuCode
     * @param dgIchijiHanteiKeikokuCode dgIchijiHanteiKeikokuCode
     */
    @JsonProperty("dgIchijiHanteiKeikokuCode")
    public void setDgIchijiHanteiKeikokuCode(DataGrid<dgIchijiHanteiKeikokuCode_Row> dgIchijiHanteiKeikokuCode) {
        this.dgIchijiHanteiKeikokuCode = dgIchijiHanteiKeikokuCode;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblShokuji() {
        return this.getTblKijunJikan().getLblShokuji();
    }

    @JsonIgnore
    public Label getLblHaisetsu() {
        return this.getTblKijunJikan().getLblHaisetsu();
    }

    @JsonIgnore
    public Label getLblIdo() {
        return this.getTblKijunJikan().getLblIdo();
    }

    @JsonIgnore
    public Label getLblSeiketsuhoji() {
        return this.getTblKijunJikan().getLblSeiketsuhoji();
    }

    @JsonIgnore
    public Label getLblKansetsuCare() {
        return this.getTblKijunJikan().getLblKansetsuCare();
    }

    @JsonIgnore
    public Label getLblBpsdKanren() {
        return this.getTblKijunJikan().getLblBpsdKanren();
    }

    @JsonIgnore
    public Label getLblKinoKunren() {
        return this.getTblKijunJikan().getLblKinoKunren();
    }

    @JsonIgnore
    public Label getLblIryoKanren() {
        return this.getTblKijunJikan().getLblIryoKanren();
    }

    @JsonIgnore
    public Label getLblNinchishoKasan() {
        return this.getTblKijunJikan().getLblNinchishoKasan();
    }

    @JsonIgnore
    public TextBox getTxtShokuji() {
        return this.getTblKijunJikan().getTxtShokuji();
    }

    @JsonIgnore
    public TextBox getTxtHaisetsu() {
        return this.getTblKijunJikan().getTxtHaisetsu();
    }

    @JsonIgnore
    public TextBox getTxtIdo() {
        return this.getTblKijunJikan().getTxtIdo();
    }

    @JsonIgnore
    public TextBox getTxtSeiketsuHoji() {
        return this.getTblKijunJikan().getTxtSeiketsuHoji();
    }

    @JsonIgnore
    public TextBox getTxtKansetsuCare() {
        return this.getTblKijunJikan().getTxtKansetsuCare();
    }

    @JsonIgnore
    public TextBox getTxtBpsdKanren() {
        return this.getTblKijunJikan().getTxtBpsdKanren();
    }

    @JsonIgnore
    public TextBox getTxtKinoKunren() {
        return this.getTblKijunJikan().getTxtKinoKunren();
    }

    @JsonIgnore
    public TextBox getTxtIryoKanren() {
        return this.getTblKijunJikan().getTxtIryoKanren();
    }

    @JsonIgnore
    public TextBox getTxtNinchishoKasan() {
        return this.getTblKijunJikan().getTxtNinchishoKasan();
    }

    @JsonIgnore
    public Label getLblDai1gun() {
        return this.getTblTyukanHyokaKomokuTokuten().getLblDai1gun();
    }

    @JsonIgnore
    public Label getLblDai2gun() {
        return this.getTblTyukanHyokaKomokuTokuten().getLblDai2gun();
    }

    @JsonIgnore
    public Label getLblDai3gun() {
        return this.getTblTyukanHyokaKomokuTokuten().getLblDai3gun();
    }

    @JsonIgnore
    public Label getLblDai4gun() {
        return this.getTblTyukanHyokaKomokuTokuten().getLblDai4gun();
    }

    @JsonIgnore
    public Label getLblDai5gun() {
        return this.getTblTyukanHyokaKomokuTokuten().getLblDai5gun();
    }

    @JsonIgnore
    public Label getLblDai6gun() {
        return this.getTblTyukanHyokaKomokuTokuten().getLblDai6gun();
    }

    @JsonIgnore
    public Label getLblDai7gun() {
        return this.getTblTyukanHyokaKomokuTokuten().getLblDai7gun();
    }

    @JsonIgnore
    public TextBox getTxtDai1gun() {
        return this.getTblTyukanHyokaKomokuTokuten().getTxtDai1gun();
    }

    @JsonIgnore
    public TextBox getTxtDai2gun() {
        return this.getTblTyukanHyokaKomokuTokuten().getTxtDai2gun();
    }

    @JsonIgnore
    public TextBox getTxtDai3gun() {
        return this.getTblTyukanHyokaKomokuTokuten().getTxtDai3gun();
    }

    @JsonIgnore
    public TextBox getTxtDai4gun() {
        return this.getTblTyukanHyokaKomokuTokuten().getTxtDai4gun();
    }

    @JsonIgnore
    public TextBox getTxtDai5gun() {
        return this.getTblTyukanHyokaKomokuTokuten().getTxtDai5gun();
    }

    @JsonIgnore
    public TextBox getTxtDai6gun() {
        return this.getTblTyukanHyokaKomokuTokuten().getTxtDai6gun();
    }

    @JsonIgnore
    public TextBox getTxtDai7gun() {
        return this.getTblTyukanHyokaKomokuTokuten().getTxtDai7gun();
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
