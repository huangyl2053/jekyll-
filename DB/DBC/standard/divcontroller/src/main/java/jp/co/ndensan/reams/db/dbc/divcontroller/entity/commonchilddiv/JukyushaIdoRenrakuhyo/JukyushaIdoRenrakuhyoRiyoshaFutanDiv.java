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
 * JukyushaIdoRenrakuhyoRiyoshaFutan のクラスファイル 
 * 
 * @author 自動生成
 */
public class JukyushaIdoRenrakuhyoRiyoshaFutanDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radRiyoshaFutanKubun")
    private RadioButton radRiyoshaFutanKubun;
    @JsonProperty("txtRiyoshaFutanKyufuritsu")
    private TextBoxNum txtRiyoshaFutanKyufuritsu;
    @JsonProperty("txtRiyoshaFutanTekiyoDateRange")
    private TextBoxDateRange txtRiyoshaFutanTekiyoDateRange;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradRiyoshaFutanKubun
     * @return radRiyoshaFutanKubun
     */
    @JsonProperty("radRiyoshaFutanKubun")
    public RadioButton getRadRiyoshaFutanKubun() {
        return radRiyoshaFutanKubun;
    }

    /*
     * setradRiyoshaFutanKubun
     * @param radRiyoshaFutanKubun radRiyoshaFutanKubun
     */
    @JsonProperty("radRiyoshaFutanKubun")
    public void setRadRiyoshaFutanKubun(RadioButton radRiyoshaFutanKubun) {
        this.radRiyoshaFutanKubun = radRiyoshaFutanKubun;
    }

    /*
     * gettxtRiyoshaFutanKyufuritsu
     * @return txtRiyoshaFutanKyufuritsu
     */
    @JsonProperty("txtRiyoshaFutanKyufuritsu")
    public TextBoxNum getTxtRiyoshaFutanKyufuritsu() {
        return txtRiyoshaFutanKyufuritsu;
    }

    /*
     * settxtRiyoshaFutanKyufuritsu
     * @param txtRiyoshaFutanKyufuritsu txtRiyoshaFutanKyufuritsu
     */
    @JsonProperty("txtRiyoshaFutanKyufuritsu")
    public void setTxtRiyoshaFutanKyufuritsu(TextBoxNum txtRiyoshaFutanKyufuritsu) {
        this.txtRiyoshaFutanKyufuritsu = txtRiyoshaFutanKyufuritsu;
    }

    /*
     * gettxtRiyoshaFutanTekiyoDateRange
     * @return txtRiyoshaFutanTekiyoDateRange
     */
    @JsonProperty("txtRiyoshaFutanTekiyoDateRange")
    public TextBoxDateRange getTxtRiyoshaFutanTekiyoDateRange() {
        return txtRiyoshaFutanTekiyoDateRange;
    }

    /*
     * settxtRiyoshaFutanTekiyoDateRange
     * @param txtRiyoshaFutanTekiyoDateRange txtRiyoshaFutanTekiyoDateRange
     */
    @JsonProperty("txtRiyoshaFutanTekiyoDateRange")
    public void setTxtRiyoshaFutanTekiyoDateRange(TextBoxDateRange txtRiyoshaFutanTekiyoDateRange) {
        this.txtRiyoshaFutanTekiyoDateRange = txtRiyoshaFutanTekiyoDateRange;
    }

    // </editor-fold>
}
