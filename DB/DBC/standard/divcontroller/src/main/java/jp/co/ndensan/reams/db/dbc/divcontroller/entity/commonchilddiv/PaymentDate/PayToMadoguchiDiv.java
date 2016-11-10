package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.PaymentDate;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * PayToMadoguchi のクラスファイル
 *
 * @reamsid_L DBC-4470-010 wangkanglei
 */
public class PayToMadoguchiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShiharaiBasho")
    private TextBox txtShiharaiBasho;
    @JsonProperty("txtShiharaiDateRange")
    private TextBoxDateRange txtShiharaiDateRange;
    @JsonProperty("txtShiharaiKaishiTime")
    private TextBoxTime txtShiharaiKaishiTime;
    @JsonProperty("txtShiharaiShuryoTime")
    private TextBoxTime txtShiharaiShuryoTime;
    @JsonProperty("radIkkatsuKoshinKubun")
    private RadioButton radIkkatsuKoshinKubun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShiharaiBasho
     * @return txtShiharaiBasho
     */
    @JsonProperty("txtShiharaiBasho")
    public TextBox getTxtShiharaiBasho() {
        return txtShiharaiBasho;
    }

    /*
     * settxtShiharaiBasho
     * @param txtShiharaiBasho txtShiharaiBasho
     */
    @JsonProperty("txtShiharaiBasho")
    public void setTxtShiharaiBasho(TextBox txtShiharaiBasho) {
        this.txtShiharaiBasho = txtShiharaiBasho;
    }

    /*
     * gettxtShiharaiDateRange
     * @return txtShiharaiDateRange
     */
    @JsonProperty("txtShiharaiDateRange")
    public TextBoxDateRange getTxtShiharaiDateRange() {
        return txtShiharaiDateRange;
    }

    /*
     * settxtShiharaiDateRange
     * @param txtShiharaiDateRange txtShiharaiDateRange
     */
    @JsonProperty("txtShiharaiDateRange")
    public void setTxtShiharaiDateRange(TextBoxDateRange txtShiharaiDateRange) {
        this.txtShiharaiDateRange = txtShiharaiDateRange;
    }

    /*
     * gettxtShiharaiKaishiTime
     * @return txtShiharaiKaishiTime
     */
    @JsonProperty("txtShiharaiKaishiTime")
    public TextBoxTime getTxtShiharaiKaishiTime() {
        return txtShiharaiKaishiTime;
    }

    /*
     * settxtShiharaiKaishiTime
     * @param txtShiharaiKaishiTime txtShiharaiKaishiTime
     */
    @JsonProperty("txtShiharaiKaishiTime")
    public void setTxtShiharaiKaishiTime(TextBoxTime txtShiharaiKaishiTime) {
        this.txtShiharaiKaishiTime = txtShiharaiKaishiTime;
    }

    /*
     * gettxtShiharaiShuryoTime
     * @return txtShiharaiShuryoTime
     */
    @JsonProperty("txtShiharaiShuryoTime")
    public TextBoxTime getTxtShiharaiShuryoTime() {
        return txtShiharaiShuryoTime;
    }

    /*
     * settxtShiharaiShuryoTime
     * @param txtShiharaiShuryoTime txtShiharaiShuryoTime
     */
    @JsonProperty("txtShiharaiShuryoTime")
    public void setTxtShiharaiShuryoTime(TextBoxTime txtShiharaiShuryoTime) {
        this.txtShiharaiShuryoTime = txtShiharaiShuryoTime;
    }

    /*
     * getradIkkatsuKoshinKubun
     * @return radIkkatsuKoshinKubun
     */
    @JsonProperty("radIkkatsuKoshinKubun")
    public RadioButton getRadIkkatsuKoshinKubun() {
        return radIkkatsuKoshinKubun;
    }

    /*
     * setradIkkatsuKoshinKubun
     * @param radIkkatsuKoshinKubun radIkkatsuKoshinKubun
     */
    @JsonProperty("radIkkatsuKoshinKubun")
    public void setRadIkkatsuKoshinKubun(RadioButton radIkkatsuKoshinKubun) {
        this.radIkkatsuKoshinKubun = radIkkatsuKoshinKubun;
    }

    // </editor-fold>
}
