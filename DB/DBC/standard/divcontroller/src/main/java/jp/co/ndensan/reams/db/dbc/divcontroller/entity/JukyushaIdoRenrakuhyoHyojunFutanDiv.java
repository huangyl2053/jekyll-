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
 * JukyushaIdoRenrakuhyoHyojunFutan のクラスファイル 
 * 
 * @author 自動生成
 */
public class JukyushaIdoRenrakuhyoHyojunFutanDiv extends Panel {
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
    @JsonProperty("radHyojunFutanKubun")
    public RadioButton getRadHyojunFutanKubun() {
        return radHyojunFutanKubun;
    }

    @JsonProperty("radHyojunFutanKubun")
    public void setRadHyojunFutanKubun(RadioButton radHyojunFutanKubun) {
        this.radHyojunFutanKubun=radHyojunFutanKubun;
    }

    @JsonProperty("txtHyojunFutangaku")
    public TextBoxNum getTxtHyojunFutangaku() {
        return txtHyojunFutangaku;
    }

    @JsonProperty("txtHyojunFutangaku")
    public void setTxtHyojunFutangaku(TextBoxNum txtHyojunFutangaku) {
        this.txtHyojunFutangaku=txtHyojunFutangaku;
    }

    @JsonProperty("txtHyojunFutanTekiyoDateRange")
    public TextBoxDateRange getTxtHyojunFutanTekiyoDateRange() {
        return txtHyojunFutanTekiyoDateRange;
    }

    @JsonProperty("txtHyojunFutanTekiyoDateRange")
    public void setTxtHyojunFutanTekiyoDateRange(TextBoxDateRange txtHyojunFutanTekiyoDateRange) {
        this.txtHyojunFutanTekiyoDateRange=txtHyojunFutanTekiyoDateRange;
    }

}
