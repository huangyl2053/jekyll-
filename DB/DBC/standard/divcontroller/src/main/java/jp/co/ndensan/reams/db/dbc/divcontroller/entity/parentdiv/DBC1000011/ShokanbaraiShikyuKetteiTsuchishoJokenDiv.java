package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1000011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ShokanbaraiShikyuKetteiTsuchishoJoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShokanbaraiShikyuKetteiTsuchishoJokenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtZenkaiTaishobi")
    private TextBoxDateRange txtZenkaiTaishobi;
    @JsonProperty("radUketsukebi")
    private RadioButton radUketsukebi;
    @JsonProperty("txtUketsukebi")
    private TextBoxDateRange txtUketsukebi;
    @JsonProperty("radKetteibi")
    private RadioButton radKetteibi;
    @JsonProperty("txtKeteibiJoken")
    private TextBoxDateRange txtKeteibiJoken;
    @JsonProperty("radKetteishaUketsukeYM")
    private RadioButton radKetteishaUketsukeYM;
    @JsonProperty("txtKeteishaUketsukeYM")
    private TextBoxYearMonth txtKeteishaUketsukeYM;
    @JsonProperty("PnlInnsho")
    private PnlInnshoDiv PnlInnsho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtZenkaiTaishobi
     * @return txtZenkaiTaishobi
     */
    @JsonProperty("txtZenkaiTaishobi")
    public TextBoxDateRange getTxtZenkaiTaishobi() {
        return txtZenkaiTaishobi;
    }

    /*
     * settxtZenkaiTaishobi
     * @param txtZenkaiTaishobi txtZenkaiTaishobi
     */
    @JsonProperty("txtZenkaiTaishobi")
    public void setTxtZenkaiTaishobi(TextBoxDateRange txtZenkaiTaishobi) {
        this.txtZenkaiTaishobi = txtZenkaiTaishobi;
    }

    /*
     * getradUketsukebi
     * @return radUketsukebi
     */
    @JsonProperty("radUketsukebi")
    public RadioButton getRadUketsukebi() {
        return radUketsukebi;
    }

    /*
     * setradUketsukebi
     * @param radUketsukebi radUketsukebi
     */
    @JsonProperty("radUketsukebi")
    public void setRadUketsukebi(RadioButton radUketsukebi) {
        this.radUketsukebi = radUketsukebi;
    }

    /*
     * gettxtUketsukebi
     * @return txtUketsukebi
     */
    @JsonProperty("txtUketsukebi")
    public TextBoxDateRange getTxtUketsukebi() {
        return txtUketsukebi;
    }

    /*
     * settxtUketsukebi
     * @param txtUketsukebi txtUketsukebi
     */
    @JsonProperty("txtUketsukebi")
    public void setTxtUketsukebi(TextBoxDateRange txtUketsukebi) {
        this.txtUketsukebi = txtUketsukebi;
    }

    /*
     * getradKetteibi
     * @return radKetteibi
     */
    @JsonProperty("radKetteibi")
    public RadioButton getRadKetteibi() {
        return radKetteibi;
    }

    /*
     * setradKetteibi
     * @param radKetteibi radKetteibi
     */
    @JsonProperty("radKetteibi")
    public void setRadKetteibi(RadioButton radKetteibi) {
        this.radKetteibi = radKetteibi;
    }

    /*
     * gettxtKeteibiJoken
     * @return txtKeteibiJoken
     */
    @JsonProperty("txtKeteibiJoken")
    public TextBoxDateRange getTxtKeteibiJoken() {
        return txtKeteibiJoken;
    }

    /*
     * settxtKeteibiJoken
     * @param txtKeteibiJoken txtKeteibiJoken
     */
    @JsonProperty("txtKeteibiJoken")
    public void setTxtKeteibiJoken(TextBoxDateRange txtKeteibiJoken) {
        this.txtKeteibiJoken = txtKeteibiJoken;
    }

    /*
     * getradKetteishaUketsukeYM
     * @return radKetteishaUketsukeYM
     */
    @JsonProperty("radKetteishaUketsukeYM")
    public RadioButton getRadKetteishaUketsukeYM() {
        return radKetteishaUketsukeYM;
    }

    /*
     * setradKetteishaUketsukeYM
     * @param radKetteishaUketsukeYM radKetteishaUketsukeYM
     */
    @JsonProperty("radKetteishaUketsukeYM")
    public void setRadKetteishaUketsukeYM(RadioButton radKetteishaUketsukeYM) {
        this.radKetteishaUketsukeYM = radKetteishaUketsukeYM;
    }

    /*
     * gettxtKeteishaUketsukeYM
     * @return txtKeteishaUketsukeYM
     */
    @JsonProperty("txtKeteishaUketsukeYM")
    public TextBoxYearMonth getTxtKeteishaUketsukeYM() {
        return txtKeteishaUketsukeYM;
    }

    /*
     * settxtKeteishaUketsukeYM
     * @param txtKeteishaUketsukeYM txtKeteishaUketsukeYM
     */
    @JsonProperty("txtKeteishaUketsukeYM")
    public void setTxtKeteishaUketsukeYM(TextBoxYearMonth txtKeteishaUketsukeYM) {
        this.txtKeteishaUketsukeYM = txtKeteishaUketsukeYM;
    }

    /*
     * getPnlInnsho
     * @return PnlInnsho
     */
    @JsonProperty("PnlInnsho")
    public PnlInnshoDiv getPnlInnsho() {
        return PnlInnsho;
    }

    /*
     * setPnlInnsho
     * @param PnlInnsho PnlInnsho
     */
    @JsonProperty("PnlInnsho")
    public void setPnlInnsho(PnlInnshoDiv PnlInnsho) {
        this.PnlInnsho = PnlInnsho;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadInnsho() {
        return this.getPnlInnsho().getRadInnsho();
    }

    @JsonIgnore
    public void  setRadInnsho(RadioButton radInnsho) {
        this.getPnlInnsho().setRadInnsho(radInnsho);
    }

    // </editor-fold>
}
