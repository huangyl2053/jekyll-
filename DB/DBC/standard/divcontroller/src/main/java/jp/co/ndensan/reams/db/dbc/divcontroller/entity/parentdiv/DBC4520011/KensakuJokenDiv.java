package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4520011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxKana;

/**
 * KensakuJoken のクラスファイル
 *
 * @reamsid_L DBC-3370-010 yuqingzhang
 */
public class KensakuJokenDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radKaigoSienSenmoninBangoKensaku")
    private RadioButton radKaigoSienSenmoninBangoKensaku;
    @JsonProperty("radShozokuJigyoshaBangoKensaku")
    private RadioButton radShozokuJigyoshaBangoKensaku;
    @JsonProperty("txtKaigoShienSenmoninBango")
    private TextBoxCode txtKaigoShienSenmoninBango;
    @JsonProperty("txtShozokuJigyoshaBango")
    private TextBoxCode txtShozokuJigyoshaBango;
    @JsonProperty("radKaigoShienSenmoninShimeiKensaku")
    private RadioButton radKaigoShienSenmoninShimeiKensaku;
    @JsonProperty("radYukoKikanKensaku")
    private RadioButton radYukoKikanKensaku;
    @JsonProperty("txtkanaShimei")
    private TextBoxKana txtkanaShimei;
    @JsonProperty("chkKanaShimeiZenpoItchi")
    private CheckBoxList chkKanaShimeiZenpoItchi;
    @JsonProperty("txtYukoKikanKensaku")
    private TextBoxDateRange txtYukoKikanKensaku;
    @JsonProperty("txtKanjiShimei")
    private TextBox txtKanjiShimei;
    @JsonProperty("chkKanjiShimeiZenpoItchi")
    private CheckBoxList chkKanjiShimeiZenpoItchi;
    @JsonProperty("txtSaidaiHyojiKensu")
    private TextBox txtSaidaiHyojiKensu;
    @JsonProperty("btnKensakuKuria")
    private Button btnKensakuKuria;
    @JsonProperty("btnKensaku")
    private Button btnKensaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradKaigoSienSenmoninBangoKensaku
     * @return radKaigoSienSenmoninBangoKensaku
     */
    @JsonProperty("radKaigoSienSenmoninBangoKensaku")
    public RadioButton getRadKaigoSienSenmoninBangoKensaku() {
        return radKaigoSienSenmoninBangoKensaku;
    }

    /*
     * setradKaigoSienSenmoninBangoKensaku
     * @param radKaigoSienSenmoninBangoKensaku radKaigoSienSenmoninBangoKensaku
     */
    @JsonProperty("radKaigoSienSenmoninBangoKensaku")
    public void setRadKaigoSienSenmoninBangoKensaku(RadioButton radKaigoSienSenmoninBangoKensaku) {
        this.radKaigoSienSenmoninBangoKensaku = radKaigoSienSenmoninBangoKensaku;
    }

    /*
     * getradShozokuJigyoshaBangoKensaku
     * @return radShozokuJigyoshaBangoKensaku
     */
    @JsonProperty("radShozokuJigyoshaBangoKensaku")
    public RadioButton getRadShozokuJigyoshaBangoKensaku() {
        return radShozokuJigyoshaBangoKensaku;
    }

    /*
     * setradShozokuJigyoshaBangoKensaku
     * @param radShozokuJigyoshaBangoKensaku radShozokuJigyoshaBangoKensaku
     */
    @JsonProperty("radShozokuJigyoshaBangoKensaku")
    public void setRadShozokuJigyoshaBangoKensaku(RadioButton radShozokuJigyoshaBangoKensaku) {
        this.radShozokuJigyoshaBangoKensaku = radShozokuJigyoshaBangoKensaku;
    }

    /*
     * gettxtKaigoShienSenmoninBango
     * @return txtKaigoShienSenmoninBango
     */
    @JsonProperty("txtKaigoShienSenmoninBango")
    public TextBoxCode getTxtKaigoShienSenmoninBango() {
        return txtKaigoShienSenmoninBango;
    }

    /*
     * settxtKaigoShienSenmoninBango
     * @param txtKaigoShienSenmoninBango txtKaigoShienSenmoninBango
     */
    @JsonProperty("txtKaigoShienSenmoninBango")
    public void setTxtKaigoShienSenmoninBango(TextBoxCode txtKaigoShienSenmoninBango) {
        this.txtKaigoShienSenmoninBango = txtKaigoShienSenmoninBango;
    }

    /*
     * gettxtShozokuJigyoshaBango
     * @return txtShozokuJigyoshaBango
     */
    @JsonProperty("txtShozokuJigyoshaBango")
    public TextBoxCode getTxtShozokuJigyoshaBango() {
        return txtShozokuJigyoshaBango;
    }

    /*
     * settxtShozokuJigyoshaBango
     * @param txtShozokuJigyoshaBango txtShozokuJigyoshaBango
     */
    @JsonProperty("txtShozokuJigyoshaBango")
    public void setTxtShozokuJigyoshaBango(TextBoxCode txtShozokuJigyoshaBango) {
        this.txtShozokuJigyoshaBango = txtShozokuJigyoshaBango;
    }

    /*
     * getradKaigoShienSenmoninShimeiKensaku
     * @return radKaigoShienSenmoninShimeiKensaku
     */
    @JsonProperty("radKaigoShienSenmoninShimeiKensaku")
    public RadioButton getRadKaigoShienSenmoninShimeiKensaku() {
        return radKaigoShienSenmoninShimeiKensaku;
    }

    /*
     * setradKaigoShienSenmoninShimeiKensaku
     * @param radKaigoShienSenmoninShimeiKensaku radKaigoShienSenmoninShimeiKensaku
     */
    @JsonProperty("radKaigoShienSenmoninShimeiKensaku")
    public void setRadKaigoShienSenmoninShimeiKensaku(RadioButton radKaigoShienSenmoninShimeiKensaku) {
        this.radKaigoShienSenmoninShimeiKensaku = radKaigoShienSenmoninShimeiKensaku;
    }

    /*
     * getradYukoKikanKensaku
     * @return radYukoKikanKensaku
     */
    @JsonProperty("radYukoKikanKensaku")
    public RadioButton getRadYukoKikanKensaku() {
        return radYukoKikanKensaku;
    }

    /*
     * setradYukoKikanKensaku
     * @param radYukoKikanKensaku radYukoKikanKensaku
     */
    @JsonProperty("radYukoKikanKensaku")
    public void setRadYukoKikanKensaku(RadioButton radYukoKikanKensaku) {
        this.radYukoKikanKensaku = radYukoKikanKensaku;
    }

    /*
     * gettxtkanaShimei
     * @return txtkanaShimei
     */
    @JsonProperty("txtkanaShimei")
    public TextBoxKana getTxtkanaShimei() {
        return txtkanaShimei;
    }

    /*
     * settxtkanaShimei
     * @param txtkanaShimei txtkanaShimei
     */
    @JsonProperty("txtkanaShimei")
    public void setTxtkanaShimei(TextBoxKana txtkanaShimei) {
        this.txtkanaShimei = txtkanaShimei;
    }

    /*
     * getchkKanaShimeiZenpoItchi
     * @return chkKanaShimeiZenpoItchi
     */
    @JsonProperty("chkKanaShimeiZenpoItchi")
    public CheckBoxList getChkKanaShimeiZenpoItchi() {
        return chkKanaShimeiZenpoItchi;
    }

    /*
     * setchkKanaShimeiZenpoItchi
     * @param chkKanaShimeiZenpoItchi chkKanaShimeiZenpoItchi
     */
    @JsonProperty("chkKanaShimeiZenpoItchi")
    public void setChkKanaShimeiZenpoItchi(CheckBoxList chkKanaShimeiZenpoItchi) {
        this.chkKanaShimeiZenpoItchi = chkKanaShimeiZenpoItchi;
    }

    /*
     * gettxtYukoKikanKensaku
     * @return txtYukoKikanKensaku
     */
    @JsonProperty("txtYukoKikanKensaku")
    public TextBoxDateRange getTxtYukoKikanKensaku() {
        return txtYukoKikanKensaku;
    }

    /*
     * settxtYukoKikanKensaku
     * @param txtYukoKikanKensaku txtYukoKikanKensaku
     */
    @JsonProperty("txtYukoKikanKensaku")
    public void setTxtYukoKikanKensaku(TextBoxDateRange txtYukoKikanKensaku) {
        this.txtYukoKikanKensaku = txtYukoKikanKensaku;
    }

    /*
     * gettxtKanjiShimei
     * @return txtKanjiShimei
     */
    @JsonProperty("txtKanjiShimei")
    public TextBox getTxtKanjiShimei() {
        return txtKanjiShimei;
    }

    /*
     * settxtKanjiShimei
     * @param txtKanjiShimei txtKanjiShimei
     */
    @JsonProperty("txtKanjiShimei")
    public void setTxtKanjiShimei(TextBox txtKanjiShimei) {
        this.txtKanjiShimei = txtKanjiShimei;
    }

    /*
     * getchkKanjiShimeiZenpoItchi
     * @return chkKanjiShimeiZenpoItchi
     */
    @JsonProperty("chkKanjiShimeiZenpoItchi")
    public CheckBoxList getChkKanjiShimeiZenpoItchi() {
        return chkKanjiShimeiZenpoItchi;
    }

    /*
     * setchkKanjiShimeiZenpoItchi
     * @param chkKanjiShimeiZenpoItchi chkKanjiShimeiZenpoItchi
     */
    @JsonProperty("chkKanjiShimeiZenpoItchi")
    public void setChkKanjiShimeiZenpoItchi(CheckBoxList chkKanjiShimeiZenpoItchi) {
        this.chkKanjiShimeiZenpoItchi = chkKanjiShimeiZenpoItchi;
    }

    /*
     * gettxtSaidaiHyojiKensu
     * @return txtSaidaiHyojiKensu
     */
    @JsonProperty("txtSaidaiHyojiKensu")
    public TextBox getTxtSaidaiHyojiKensu() {
        return txtSaidaiHyojiKensu;
    }

    /*
     * settxtSaidaiHyojiKensu
     * @param txtSaidaiHyojiKensu txtSaidaiHyojiKensu
     */
    @JsonProperty("txtSaidaiHyojiKensu")
    public void setTxtSaidaiHyojiKensu(TextBox txtSaidaiHyojiKensu) {
        this.txtSaidaiHyojiKensu = txtSaidaiHyojiKensu;
    }

    /*
     * getbtnKensakuKuria
     * @return btnKensakuKuria
     */
    @JsonProperty("btnKensakuKuria")
    public Button getBtnKensakuKuria() {
        return btnKensakuKuria;
    }

    /*
     * setbtnKensakuKuria
     * @param btnKensakuKuria btnKensakuKuria
     */
    @JsonProperty("btnKensakuKuria")
    public void setBtnKensakuKuria(Button btnKensakuKuria) {
        this.btnKensakuKuria = btnKensakuKuria;
    }

    /*
     * getbtnKensaku
     * @return btnKensaku
     */
    @JsonProperty("btnKensaku")
    public Button getBtnKensaku() {
        return btnKensaku;
    }

    /*
     * setbtnKensaku
     * @param btnKensaku btnKensaku
     */
    @JsonProperty("btnKensaku")
    public void setBtnKensaku(Button btnKensaku) {
        this.btnKensaku = btnKensaku;
    }

    // </editor-fold>
}
