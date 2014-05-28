package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * JukyushaIdoRenrakuhyoRiyoshaFutan のクラスファイル 
 * 
 * @author 自動生成
 */
public class JukyushaIdoRenrakuhyoRiyoshaFutanDiv extends Panel {
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
    @JsonProperty("radRiyoshaFutanKubun")
    public RadioButton getRadRiyoshaFutanKubun() {
        return radRiyoshaFutanKubun;
    }

    @JsonProperty("radRiyoshaFutanKubun")
    public void setRadRiyoshaFutanKubun(RadioButton radRiyoshaFutanKubun) {
        this.radRiyoshaFutanKubun=radRiyoshaFutanKubun;
    }

    @JsonProperty("txtRiyoshaFutanKyufuritsu")
    public TextBoxNum getTxtRiyoshaFutanKyufuritsu() {
        return txtRiyoshaFutanKyufuritsu;
    }

    @JsonProperty("txtRiyoshaFutanKyufuritsu")
    public void setTxtRiyoshaFutanKyufuritsu(TextBoxNum txtRiyoshaFutanKyufuritsu) {
        this.txtRiyoshaFutanKyufuritsu=txtRiyoshaFutanKyufuritsu;
    }

    @JsonProperty("txtRiyoshaFutanTekiyoDateRange")
    public TextBoxDateRange getTxtRiyoshaFutanTekiyoDateRange() {
        return txtRiyoshaFutanTekiyoDateRange;
    }

    @JsonProperty("txtRiyoshaFutanTekiyoDateRange")
    public void setTxtRiyoshaFutanTekiyoDateRange(TextBoxDateRange txtRiyoshaFutanTekiyoDateRange) {
        this.txtRiyoshaFutanTekiyoDateRange=txtRiyoshaFutanTekiyoDateRange;
    }

}
