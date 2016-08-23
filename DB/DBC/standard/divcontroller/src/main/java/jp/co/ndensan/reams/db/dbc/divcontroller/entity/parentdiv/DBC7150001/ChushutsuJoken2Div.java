package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7150001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;

/**
 * ChushutsuJoken2 のクラスファイル
 *
 * @reamsid_L DBC-3102-010 dingminghao
 */
public class ChushutsuJoken2Div extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtJikoFutangakuKakunin")
    private TextBoxDateRange txtJikoFutangakuKakunin;
    @JsonProperty("txtHoseizumiJikoFutangaku")
    private TextBoxDateRange txtHoseizumiJikoFutangaku;
    @JsonProperty("txtJikoFutanngakuShoumeisho")
    private TextBoxDateRange txtJikoFutanngakuShoumeisho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtJikoFutangakuKakunin
     * @return txtJikoFutangakuKakunin
     */
    @JsonProperty("txtJikoFutangakuKakunin")
    public TextBoxDateRange getTxtJikoFutangakuKakunin() {
        return txtJikoFutangakuKakunin;
    }

    /*
     * settxtJikoFutangakuKakunin
     * @param txtJikoFutangakuKakunin txtJikoFutangakuKakunin
     */
    @JsonProperty("txtJikoFutangakuKakunin")
    public void setTxtJikoFutangakuKakunin(TextBoxDateRange txtJikoFutangakuKakunin) {
        this.txtJikoFutangakuKakunin = txtJikoFutangakuKakunin;
    }

    /*
     * gettxtHoseizumiJikoFutangaku
     * @return txtHoseizumiJikoFutangaku
     */
    @JsonProperty("txtHoseizumiJikoFutangaku")
    public TextBoxDateRange getTxtHoseizumiJikoFutangaku() {
        return txtHoseizumiJikoFutangaku;
    }

    /*
     * settxtHoseizumiJikoFutangaku
     * @param txtHoseizumiJikoFutangaku txtHoseizumiJikoFutangaku
     */
    @JsonProperty("txtHoseizumiJikoFutangaku")
    public void setTxtHoseizumiJikoFutangaku(TextBoxDateRange txtHoseizumiJikoFutangaku) {
        this.txtHoseizumiJikoFutangaku = txtHoseizumiJikoFutangaku;
    }

    /*
     * gettxtJikoFutanngakuShoumeisho
     * @return txtJikoFutanngakuShoumeisho
     */
    @JsonProperty("txtJikoFutanngakuShoumeisho")
    public TextBoxDateRange getTxtJikoFutanngakuShoumeisho() {
        return txtJikoFutanngakuShoumeisho;
    }

    /*
     * settxtJikoFutanngakuShoumeisho
     * @param txtJikoFutanngakuShoumeisho txtJikoFutanngakuShoumeisho
     */
    @JsonProperty("txtJikoFutanngakuShoumeisho")
    public void setTxtJikoFutanngakuShoumeisho(TextBoxDateRange txtJikoFutanngakuShoumeisho) {
        this.txtJikoFutanngakuShoumeisho = txtJikoFutanngakuShoumeisho;
    }

    // </editor-fold>
}
