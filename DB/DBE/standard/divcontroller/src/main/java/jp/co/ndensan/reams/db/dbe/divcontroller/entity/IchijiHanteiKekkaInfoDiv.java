package jp.co.ndensan.reams.db.dbe.divcontroller.entity;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dgIchijiHanteiKeikokuCode_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.tblKijunJikanDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.tblTyukanHyokaKomokuTokutenDiv;

import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * IchijiHanteiKekkaInfo のクラスファイル
 *
 * @author 自動生成
 */
public class IchijiHanteiKekkaInfoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("txtIchijiHanteibi")
    private TextBoxDate txtIchijiHanteibi;
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
    @JsonProperty("txtIchijiHanteibi")
    public TextBoxDate getTxtIchijiHanteibi() {
        return txtIchijiHanteibi;
    }

    @JsonProperty("txtIchijiHanteibi")
    public void setTxtIchijiHanteibi(TextBoxDate txtIchijiHanteibi) {
        this.txtIchijiHanteibi = txtIchijiHanteibi;
    }

    @JsonProperty("txtIchijiHanteiKekka")
    public TextBox getTxtIchijiHanteiKekka() {
        return txtIchijiHanteiKekka;
    }

    @JsonProperty("txtIchijiHanteiKekka")
    public void setTxtIchijiHanteiKekka(TextBox txtIchijiHanteiKekka) {
        this.txtIchijiHanteiKekka = txtIchijiHanteiKekka;
    }

    @JsonProperty("txtKijunJikan")
    public TextBox getTxtKijunJikan() {
        return txtKijunJikan;
    }

    @JsonProperty("txtKijunJikan")
    public void setTxtKijunJikan(TextBox txtKijunJikan) {
        this.txtKijunJikan = txtKijunJikan;
    }

    @JsonProperty("lblChukanHyokaKomokuTokuten")
    public Label getLblChukanHyokaKomokuTokuten() {
        return lblChukanHyokaKomokuTokuten;
    }

    @JsonProperty("lblChukanHyokaKomokuTokuten")
    public void setLblChukanHyokaKomokuTokuten(Label lblChukanHyokaKomokuTokuten) {
        this.lblChukanHyokaKomokuTokuten = lblChukanHyokaKomokuTokuten;
    }

    @JsonProperty("tblKijunJikan")
    public tblKijunJikanDiv getTblKijunJikan() {
        return tblKijunJikan;
    }

    @JsonProperty("tblKijunJikan")
    public void setTblKijunJikan(tblKijunJikanDiv tblKijunJikan) {
        this.tblKijunJikan = tblKijunJikan;
    }

    @JsonProperty("tblTyukanHyokaKomokuTokuten")
    public tblTyukanHyokaKomokuTokutenDiv getTblTyukanHyokaKomokuTokuten() {
        return tblTyukanHyokaKomokuTokuten;
    }

    @JsonProperty("tblTyukanHyokaKomokuTokuten")
    public void setTblTyukanHyokaKomokuTokuten(tblTyukanHyokaKomokuTokutenDiv tblTyukanHyokaKomokuTokuten) {
        this.tblTyukanHyokaKomokuTokuten = tblTyukanHyokaKomokuTokuten;
    }

    @JsonProperty("lblNichiJyotaiHyokaKekka")
    public Label getLblNichiJyotaiHyokaKekka() {
        return lblNichiJyotaiHyokaKekka;
    }

    @JsonProperty("lblNichiJyotaiHyokaKekka")
    public void setLblNichiJyotaiHyokaKekka(Label lblNichiJyotaiHyokaKekka) {
        this.lblNichiJyotaiHyokaKekka = lblNichiJyotaiHyokaKekka;
    }

    @JsonProperty("lblNinchiNichijyoSeikatsuJiritsudo")
    public Label getLblNinchiNichijyoSeikatsuJiritsudo() {
        return lblNinchiNichijyoSeikatsuJiritsudo;
    }

    @JsonProperty("lblNinchiNichijyoSeikatsuJiritsudo")
    public void setLblNinchiNichijyoSeikatsuJiritsudo(Label lblNinchiNichijyoSeikatsuJiritsudo) {
        this.lblNinchiNichijyoSeikatsuJiritsudo = lblNinchiNichijyoSeikatsuJiritsudo;
    }

    @JsonProperty("txtGaizensei")
    public TextBox getTxtGaizensei() {
        return txtGaizensei;
    }

    @JsonProperty("txtGaizensei")
    public void setTxtGaizensei(TextBox txtGaizensei) {
        this.txtGaizensei = txtGaizensei;
    }

    @JsonProperty("txtJiritsudoChosa")
    public TextBox getTxtJiritsudoChosa() {
        return txtJiritsudoChosa;
    }

    @JsonProperty("txtJiritsudoChosa")
    public void setTxtJiritsudoChosa(TextBox txtJiritsudoChosa) {
        this.txtJiritsudoChosa = txtJiritsudoChosa;
    }

    @JsonProperty("txtJyotaiAnteisei")
    public TextBox getTxtJyotaiAnteisei() {
        return txtJyotaiAnteisei;
    }

    @JsonProperty("txtJyotaiAnteisei")
    public void setTxtJyotaiAnteisei(TextBox txtJyotaiAnteisei) {
        this.txtJyotaiAnteisei = txtJyotaiAnteisei;
    }

    @JsonProperty("txtJiritsudoIkensho")
    public TextBox getTxtJiritsudoIkensho() {
        return txtJiritsudoIkensho;
    }

    @JsonProperty("txtJiritsudoIkensho")
    public void setTxtJiritsudoIkensho(TextBox txtJiritsudoIkensho) {
        this.txtJiritsudoIkensho = txtJiritsudoIkensho;
    }

    @JsonProperty("txtKyufuKbn")
    public TextBox getTxtKyufuKbn() {
        return txtKyufuKbn;
    }

    @JsonProperty("txtKyufuKbn")
    public void setTxtKyufuKbn(TextBox txtKyufuKbn) {
        this.txtKyufuKbn = txtKyufuKbn;
    }

    @JsonProperty("lblIchijiHanteiKeikokuCode")
    public Label getLblIchijiHanteiKeikokuCode() {
        return lblIchijiHanteiKeikokuCode;
    }

    @JsonProperty("lblIchijiHanteiKeikokuCode")
    public void setLblIchijiHanteiKeikokuCode(Label lblIchijiHanteiKeikokuCode) {
        this.lblIchijiHanteiKeikokuCode = lblIchijiHanteiKeikokuCode;
    }

    @JsonProperty("dgIchijiHanteiKeikokuCode")
    public DataGrid<dgIchijiHanteiKeikokuCode_Row> getDgIchijiHanteiKeikokuCode() {
        return dgIchijiHanteiKeikokuCode;
    }

    @JsonProperty("dgIchijiHanteiKeikokuCode")
    public void setDgIchijiHanteiKeikokuCode(DataGrid<dgIchijiHanteiKeikokuCode_Row> dgIchijiHanteiKeikokuCode) {
        this.dgIchijiHanteiKeikokuCode = dgIchijiHanteiKeikokuCode;
    }

}
