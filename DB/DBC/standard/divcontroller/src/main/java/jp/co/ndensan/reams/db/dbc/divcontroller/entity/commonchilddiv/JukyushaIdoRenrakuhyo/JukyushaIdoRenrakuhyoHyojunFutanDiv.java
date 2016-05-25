package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.JukyushaIdoRenrakuhyo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JukyushaIdoRenrakuhyoHyojunFutan のクラスファイル 
 * 
 * @author 自動生成
 */
public class JukyushaIdoRenrakuhyoHyojunFutanDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radHyojunFutanKubun")
    private RadioButton radHyojunFutanKubun;
    @JsonProperty("txtHyojunFutangaku")
    private TextBoxNum txtHyojunFutangaku;
    @JsonProperty("txtHyojunFutanTekiyoDateRange")
    private TextBoxDateRange txtHyojunFutanTekiyoDateRange;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradHyojunFutanKubun
     * @return radHyojunFutanKubun
     */
    @JsonProperty("radHyojunFutanKubun")
    public RadioButton getRadHyojunFutanKubun() {
        return radHyojunFutanKubun;
    }

    /*
     * setradHyojunFutanKubun
     * @param radHyojunFutanKubun radHyojunFutanKubun
     */
    @JsonProperty("radHyojunFutanKubun")
    public void setRadHyojunFutanKubun(RadioButton radHyojunFutanKubun) {
        this.radHyojunFutanKubun = radHyojunFutanKubun;
    }

    /*
     * gettxtHyojunFutangaku
     * @return txtHyojunFutangaku
     */
    @JsonProperty("txtHyojunFutangaku")
    public TextBoxNum getTxtHyojunFutangaku() {
        return txtHyojunFutangaku;
    }

    /*
     * settxtHyojunFutangaku
     * @param txtHyojunFutangaku txtHyojunFutangaku
     */
    @JsonProperty("txtHyojunFutangaku")
    public void setTxtHyojunFutangaku(TextBoxNum txtHyojunFutangaku) {
        this.txtHyojunFutangaku = txtHyojunFutangaku;
    }

    /*
     * gettxtHyojunFutanTekiyoDateRange
     * @return txtHyojunFutanTekiyoDateRange
     */
    @JsonProperty("txtHyojunFutanTekiyoDateRange")
    public TextBoxDateRange getTxtHyojunFutanTekiyoDateRange() {
        return txtHyojunFutanTekiyoDateRange;
    }

    /*
     * settxtHyojunFutanTekiyoDateRange
     * @param txtHyojunFutanTekiyoDateRange txtHyojunFutanTekiyoDateRange
     */
    @JsonProperty("txtHyojunFutanTekiyoDateRange")
    public void setTxtHyojunFutanTekiyoDateRange(TextBoxDateRange txtHyojunFutanTekiyoDateRange) {
        this.txtHyojunFutanTekiyoDateRange = txtHyojunFutanTekiyoDateRange;
    }

    // </editor-fold>
}
