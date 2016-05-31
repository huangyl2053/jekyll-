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
    @JsonProperty("txtFutangaku")
    private TextBoxNum txtFutangaku;
    @JsonProperty("txtFutangakuTekiyoYMD")
    private TextBoxDateRange txtFutangakuTekiyoYMD;

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
     * gettxtFutangaku
     * @return txtFutangaku
     */
    @JsonProperty("txtFutangaku")
    public TextBoxNum getTxtFutangaku() {
        return txtFutangaku;
    }

    /*
     * settxtFutangaku
     * @param txtFutangaku txtFutangaku
     */
    @JsonProperty("txtFutangaku")
    public void setTxtFutangaku(TextBoxNum txtFutangaku) {
        this.txtFutangaku = txtFutangaku;
    }

    /*
     * gettxtFutangakuTekiyoYMD
     * @return txtFutangakuTekiyoYMD
     */
    @JsonProperty("txtFutangakuTekiyoYMD")
    public TextBoxDateRange getTxtFutangakuTekiyoYMD() {
        return txtFutangakuTekiyoYMD;
    }

    /*
     * settxtFutangakuTekiyoYMD
     * @param txtFutangakuTekiyoYMD txtFutangakuTekiyoYMD
     */
    @JsonProperty("txtFutangakuTekiyoYMD")
    public void setTxtFutangakuTekiyoYMD(TextBoxDateRange txtFutangakuTekiyoYMD) {
        this.txtFutangakuTekiyoYMD = txtFutangakuTekiyoYMD;
    }

    // </editor-fold>
}
