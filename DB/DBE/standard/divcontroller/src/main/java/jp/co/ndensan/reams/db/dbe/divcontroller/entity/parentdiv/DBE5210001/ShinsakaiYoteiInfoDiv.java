package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5210001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShinsakaiYoteiInfo のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinsakaiYoteiInfoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-31_12-59-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShinsakaiMeisho")
    private TextBox txtShinsakaiMeisho;
    @JsonProperty("txtGogitai")
    private TextBox txtGogitai;
    @JsonProperty("txtKaisaiYoteibi")
    private TextBoxFlexibleDate txtKaisaiYoteibi;
    @JsonProperty("txtYoteiStartTime")
    private TextBoxTime txtYoteiStartTime;
    @JsonProperty("txtYoteiEndTime")
    private TextBoxTime txtYoteiEndTime;
    @JsonProperty("txtYoteiTeiin")
    private TextBoxNum txtYoteiTeiin;
    @JsonProperty("txtYoteiKaijo")
    private TextBox txtYoteiKaijo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShinsakaiMeisho
     * @return txtShinsakaiMeisho
     */
    @JsonProperty("txtShinsakaiMeisho")
    public TextBox getTxtShinsakaiMeisho() {
        return txtShinsakaiMeisho;
    }

    /*
     * settxtShinsakaiMeisho
     * @param txtShinsakaiMeisho txtShinsakaiMeisho
     */
    @JsonProperty("txtShinsakaiMeisho")
    public void setTxtShinsakaiMeisho(TextBox txtShinsakaiMeisho) {
        this.txtShinsakaiMeisho = txtShinsakaiMeisho;
    }

    /*
     * gettxtGogitai
     * @return txtGogitai
     */
    @JsonProperty("txtGogitai")
    public TextBox getTxtGogitai() {
        return txtGogitai;
    }

    /*
     * settxtGogitai
     * @param txtGogitai txtGogitai
     */
    @JsonProperty("txtGogitai")
    public void setTxtGogitai(TextBox txtGogitai) {
        this.txtGogitai = txtGogitai;
    }

    /*
     * gettxtKaisaiYoteibi
     * @return txtKaisaiYoteibi
     */
    @JsonProperty("txtKaisaiYoteibi")
    public TextBoxFlexibleDate getTxtKaisaiYoteibi() {
        return txtKaisaiYoteibi;
    }

    /*
     * settxtKaisaiYoteibi
     * @param txtKaisaiYoteibi txtKaisaiYoteibi
     */
    @JsonProperty("txtKaisaiYoteibi")
    public void setTxtKaisaiYoteibi(TextBoxFlexibleDate txtKaisaiYoteibi) {
        this.txtKaisaiYoteibi = txtKaisaiYoteibi;
    }

    /*
     * gettxtYoteiStartTime
     * @return txtYoteiStartTime
     */
    @JsonProperty("txtYoteiStartTime")
    public TextBoxTime getTxtYoteiStartTime() {
        return txtYoteiStartTime;
    }

    /*
     * settxtYoteiStartTime
     * @param txtYoteiStartTime txtYoteiStartTime
     */
    @JsonProperty("txtYoteiStartTime")
    public void setTxtYoteiStartTime(TextBoxTime txtYoteiStartTime) {
        this.txtYoteiStartTime = txtYoteiStartTime;
    }

    /*
     * gettxtYoteiEndTime
     * @return txtYoteiEndTime
     */
    @JsonProperty("txtYoteiEndTime")
    public TextBoxTime getTxtYoteiEndTime() {
        return txtYoteiEndTime;
    }

    /*
     * settxtYoteiEndTime
     * @param txtYoteiEndTime txtYoteiEndTime
     */
    @JsonProperty("txtYoteiEndTime")
    public void setTxtYoteiEndTime(TextBoxTime txtYoteiEndTime) {
        this.txtYoteiEndTime = txtYoteiEndTime;
    }

    /*
     * gettxtYoteiTeiin
     * @return txtYoteiTeiin
     */
    @JsonProperty("txtYoteiTeiin")
    public TextBoxNum getTxtYoteiTeiin() {
        return txtYoteiTeiin;
    }

    /*
     * settxtYoteiTeiin
     * @param txtYoteiTeiin txtYoteiTeiin
     */
    @JsonProperty("txtYoteiTeiin")
    public void setTxtYoteiTeiin(TextBoxNum txtYoteiTeiin) {
        this.txtYoteiTeiin = txtYoteiTeiin;
    }

    /*
     * gettxtYoteiKaijo
     * @return txtYoteiKaijo
     */
    @JsonProperty("txtYoteiKaijo")
    public TextBox getTxtYoteiKaijo() {
        return txtYoteiKaijo;
    }

    /*
     * settxtYoteiKaijo
     * @param txtYoteiKaijo txtYoteiKaijo
     */
    @JsonProperty("txtYoteiKaijo")
    public void setTxtYoteiKaijo(TextBox txtYoteiKaijo) {
        this.txtYoteiKaijo = txtYoteiKaijo;
    }

    // </editor-fold>
}
