package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0700011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * tabShinsaKakka のクラスファイル 
 * 
 * @author 自動生成
 */
public class tabShinsaKakkaDiv extends TabPanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtJudgeYMD")
    private TextBoxDate txtJudgeYMD;
    @JsonProperty("radJudgeKubun")
    private RadioButton radJudgeKubun;
    @JsonProperty("txtShoninCondition")
    private TextBoxMultiLine txtShoninCondition;
    @JsonProperty("txtFushoninReason")
    private TextBoxMultiLine txtFushoninReason;
    @JsonProperty("JutakuKaishuJizenShoninKetteiTsuchisho")
    private JutakuKaishuJizenShoninKetteiTsuchishoDiv JutakuKaishuJizenShoninKetteiTsuchisho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtJudgeYMD
     * @return txtJudgeYMD
     */
    @JsonProperty("txtJudgeYMD")
    public TextBoxDate getTxtJudgeYMD() {
        return txtJudgeYMD;
    }

    /*
     * settxtJudgeYMD
     * @param txtJudgeYMD txtJudgeYMD
     */
    @JsonProperty("txtJudgeYMD")
    public void setTxtJudgeYMD(TextBoxDate txtJudgeYMD) {
        this.txtJudgeYMD = txtJudgeYMD;
    }

    /*
     * getradJudgeKubun
     * @return radJudgeKubun
     */
    @JsonProperty("radJudgeKubun")
    public RadioButton getRadJudgeKubun() {
        return radJudgeKubun;
    }

    /*
     * setradJudgeKubun
     * @param radJudgeKubun radJudgeKubun
     */
    @JsonProperty("radJudgeKubun")
    public void setRadJudgeKubun(RadioButton radJudgeKubun) {
        this.radJudgeKubun = radJudgeKubun;
    }

    /*
     * gettxtShoninCondition
     * @return txtShoninCondition
     */
    @JsonProperty("txtShoninCondition")
    public TextBoxMultiLine getTxtShoninCondition() {
        return txtShoninCondition;
    }

    /*
     * settxtShoninCondition
     * @param txtShoninCondition txtShoninCondition
     */
    @JsonProperty("txtShoninCondition")
    public void setTxtShoninCondition(TextBoxMultiLine txtShoninCondition) {
        this.txtShoninCondition = txtShoninCondition;
    }

    /*
     * gettxtFushoninReason
     * @return txtFushoninReason
     */
    @JsonProperty("txtFushoninReason")
    public TextBoxMultiLine getTxtFushoninReason() {
        return txtFushoninReason;
    }

    /*
     * settxtFushoninReason
     * @param txtFushoninReason txtFushoninReason
     */
    @JsonProperty("txtFushoninReason")
    public void setTxtFushoninReason(TextBoxMultiLine txtFushoninReason) {
        this.txtFushoninReason = txtFushoninReason;
    }

    /*
     * getJutakuKaishuJizenShoninKetteiTsuchisho
     * @return JutakuKaishuJizenShoninKetteiTsuchisho
     */
    @JsonProperty("JutakuKaishuJizenShoninKetteiTsuchisho")
    public JutakuKaishuJizenShoninKetteiTsuchishoDiv getJutakuKaishuJizenShoninKetteiTsuchisho() {
        return JutakuKaishuJizenShoninKetteiTsuchisho;
    }

    /*
     * setJutakuKaishuJizenShoninKetteiTsuchisho
     * @param JutakuKaishuJizenShoninKetteiTsuchisho JutakuKaishuJizenShoninKetteiTsuchisho
     */
    @JsonProperty("JutakuKaishuJizenShoninKetteiTsuchisho")
    public void setJutakuKaishuJizenShoninKetteiTsuchisho(JutakuKaishuJizenShoninKetteiTsuchishoDiv JutakuKaishuJizenShoninKetteiTsuchisho) {
        this.JutakuKaishuJizenShoninKetteiTsuchisho = JutakuKaishuJizenShoninKetteiTsuchisho;
    }

    // </editor-fold>
}
