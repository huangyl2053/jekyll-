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
    @JsonProperty("radRiyoshaFutanKubunCode")
    private RadioButton radRiyoshaFutanKubunCode;
    @JsonProperty("txtKyufuritsu")
    private TextBoxNum txtKyufuritsu;
    @JsonProperty("txtTekiyoYMD")
    private TextBoxDateRange txtTekiyoYMD;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradRiyoshaFutanKubunCode
     * @return radRiyoshaFutanKubunCode
     */
    @JsonProperty("radRiyoshaFutanKubunCode")
    public RadioButton getRadRiyoshaFutanKubunCode() {
        return radRiyoshaFutanKubunCode;
    }

    /*
     * setradRiyoshaFutanKubunCode
     * @param radRiyoshaFutanKubunCode radRiyoshaFutanKubunCode
     */
    @JsonProperty("radRiyoshaFutanKubunCode")
    public void setRadRiyoshaFutanKubunCode(RadioButton radRiyoshaFutanKubunCode) {
        this.radRiyoshaFutanKubunCode = radRiyoshaFutanKubunCode;
    }

    /*
     * gettxtKyufuritsu
     * @return txtKyufuritsu
     */
    @JsonProperty("txtKyufuritsu")
    public TextBoxNum getTxtKyufuritsu() {
        return txtKyufuritsu;
    }

    /*
     * settxtKyufuritsu
     * @param txtKyufuritsu txtKyufuritsu
     */
    @JsonProperty("txtKyufuritsu")
    public void setTxtKyufuritsu(TextBoxNum txtKyufuritsu) {
        this.txtKyufuritsu = txtKyufuritsu;
    }

    /*
     * gettxtTekiyoYMD
     * @return txtTekiyoYMD
     */
    @JsonProperty("txtTekiyoYMD")
    public TextBoxDateRange getTxtTekiyoYMD() {
        return txtTekiyoYMD;
    }

    /*
     * settxtTekiyoYMD
     * @param txtTekiyoYMD txtTekiyoYMD
     */
    @JsonProperty("txtTekiyoYMD")
    public void setTxtTekiyoYMD(TextBoxDateRange txtTekiyoYMD) {
        this.txtTekiyoYMD = txtTekiyoYMD;
    }

    // </editor-fold>
}
