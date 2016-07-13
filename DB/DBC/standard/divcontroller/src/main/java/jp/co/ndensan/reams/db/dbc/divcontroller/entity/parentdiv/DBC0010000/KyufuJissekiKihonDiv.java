package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000.KyufuJissekiKihonHihokenshaDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000.KyufuJissekiKihonKohiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000.KyufuJissekiKihonKyotakuServiceKeikakuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000.KyufuJissekiKihonKyufuritsuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000.KyufuJissekiKihonServiceKikanDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000.KyufuJissekiKihonShisetsuNyutaishoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KyufuJissekiKihon のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyufuJissekiKihonDiv extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnKyufuJissekiKihonGokei")
    private Button btnKyufuJissekiKihonGokei;
    @JsonProperty("txtKyufuJissekiKihonSakuseiKubun")
    private TextBox txtKyufuJissekiKihonSakuseiKubun;
    @JsonProperty("txtKyufuJissekiKihonYokaigodo")
    private TextBox txtKyufuJissekiKihonYokaigodo;
    @JsonProperty("txtKyufuJissekiKihonNinteiYukoKikan")
    private TextBoxDateRange txtKyufuJissekiKihonNinteiYukoKikan;
    @JsonProperty("txtKyufuJissekiKihonShinsaYM")
    private TextBoxDate txtKyufuJissekiKihonShinsaYM;
    @JsonProperty("txtKyufuJissekiKihonKeikokuKubun")
    private TextBox txtKyufuJissekiKihonKeikokuKubun;
    @JsonProperty("KyufuJissekiKihonHihokensha")
    private KyufuJissekiKihonHihokenshaDiv KyufuJissekiKihonHihokensha;
    @JsonProperty("KyufuJissekiKihonKyotakuServiceKeikaku")
    private KyufuJissekiKihonKyotakuServiceKeikakuDiv KyufuJissekiKihonKyotakuServiceKeikaku;
    @JsonProperty("KyufuJissekiKihonServiceKikan")
    private KyufuJissekiKihonServiceKikanDiv KyufuJissekiKihonServiceKikan;
    @JsonProperty("KyufuJissekiKihonShisetsuNyutaisho")
    private KyufuJissekiKihonShisetsuNyutaishoDiv KyufuJissekiKihonShisetsuNyutaisho;
    @JsonProperty("KyufuJissekiKihonKyufuritsu")
    private KyufuJissekiKihonKyufuritsuDiv KyufuJissekiKihonKyufuritsu;
    @JsonProperty("KyufuJissekiKihonKohi")
    private KyufuJissekiKihonKohiDiv KyufuJissekiKihonKohi;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("btnKyufuJissekiKihonGokei")
    public Button getBtnKyufuJissekiKihonGokei() {
        return btnKyufuJissekiKihonGokei;
    }

    @JsonProperty("btnKyufuJissekiKihonGokei")
    public void setBtnKyufuJissekiKihonGokei(Button btnKyufuJissekiKihonGokei) {
        this.btnKyufuJissekiKihonGokei=btnKyufuJissekiKihonGokei;
    }

    @JsonProperty("txtKyufuJissekiKihonSakuseiKubun")
    public TextBox getTxtKyufuJissekiKihonSakuseiKubun() {
        return txtKyufuJissekiKihonSakuseiKubun;
    }

    @JsonProperty("txtKyufuJissekiKihonSakuseiKubun")
    public void setTxtKyufuJissekiKihonSakuseiKubun(TextBox txtKyufuJissekiKihonSakuseiKubun) {
        this.txtKyufuJissekiKihonSakuseiKubun=txtKyufuJissekiKihonSakuseiKubun;
    }

    @JsonProperty("txtKyufuJissekiKihonYokaigodo")
    public TextBox getTxtKyufuJissekiKihonYokaigodo() {
        return txtKyufuJissekiKihonYokaigodo;
    }

    @JsonProperty("txtKyufuJissekiKihonYokaigodo")
    public void setTxtKyufuJissekiKihonYokaigodo(TextBox txtKyufuJissekiKihonYokaigodo) {
        this.txtKyufuJissekiKihonYokaigodo=txtKyufuJissekiKihonYokaigodo;
    }

    @JsonProperty("txtKyufuJissekiKihonNinteiYukoKikan")
    public TextBoxDateRange getTxtKyufuJissekiKihonNinteiYukoKikan() {
        return txtKyufuJissekiKihonNinteiYukoKikan;
    }

    @JsonProperty("txtKyufuJissekiKihonNinteiYukoKikan")
    public void setTxtKyufuJissekiKihonNinteiYukoKikan(TextBoxDateRange txtKyufuJissekiKihonNinteiYukoKikan) {
        this.txtKyufuJissekiKihonNinteiYukoKikan=txtKyufuJissekiKihonNinteiYukoKikan;
    }

    @JsonProperty("txtKyufuJissekiKihonShinsaYM")
    public TextBoxDate getTxtKyufuJissekiKihonShinsaYM() {
        return txtKyufuJissekiKihonShinsaYM;
    }

    @JsonProperty("txtKyufuJissekiKihonShinsaYM")
    public void setTxtKyufuJissekiKihonShinsaYM(TextBoxDate txtKyufuJissekiKihonShinsaYM) {
        this.txtKyufuJissekiKihonShinsaYM=txtKyufuJissekiKihonShinsaYM;
    }

    @JsonProperty("txtKyufuJissekiKihonKeikokuKubun")
    public TextBox getTxtKyufuJissekiKihonKeikokuKubun() {
        return txtKyufuJissekiKihonKeikokuKubun;
    }

    @JsonProperty("txtKyufuJissekiKihonKeikokuKubun")
    public void setTxtKyufuJissekiKihonKeikokuKubun(TextBox txtKyufuJissekiKihonKeikokuKubun) {
        this.txtKyufuJissekiKihonKeikokuKubun=txtKyufuJissekiKihonKeikokuKubun;
    }

    @JsonProperty("KyufuJissekiKihonHihokensha")
    public KyufuJissekiKihonHihokenshaDiv getKyufuJissekiKihonHihokensha() {
        return KyufuJissekiKihonHihokensha;
    }

    @JsonProperty("KyufuJissekiKihonHihokensha")
    public void setKyufuJissekiKihonHihokensha(KyufuJissekiKihonHihokenshaDiv KyufuJissekiKihonHihokensha) {
        this.KyufuJissekiKihonHihokensha=KyufuJissekiKihonHihokensha;
    }

    @JsonProperty("KyufuJissekiKihonKyotakuServiceKeikaku")
    public KyufuJissekiKihonKyotakuServiceKeikakuDiv getKyufuJissekiKihonKyotakuServiceKeikaku() {
        return KyufuJissekiKihonKyotakuServiceKeikaku;
    }

    @JsonProperty("KyufuJissekiKihonKyotakuServiceKeikaku")
    public void setKyufuJissekiKihonKyotakuServiceKeikaku(KyufuJissekiKihonKyotakuServiceKeikakuDiv KyufuJissekiKihonKyotakuServiceKeikaku) {
        this.KyufuJissekiKihonKyotakuServiceKeikaku=KyufuJissekiKihonKyotakuServiceKeikaku;
    }

    @JsonProperty("KyufuJissekiKihonServiceKikan")
    public KyufuJissekiKihonServiceKikanDiv getKyufuJissekiKihonServiceKikan() {
        return KyufuJissekiKihonServiceKikan;
    }

    @JsonProperty("KyufuJissekiKihonServiceKikan")
    public void setKyufuJissekiKihonServiceKikan(KyufuJissekiKihonServiceKikanDiv KyufuJissekiKihonServiceKikan) {
        this.KyufuJissekiKihonServiceKikan=KyufuJissekiKihonServiceKikan;
    }

    @JsonProperty("KyufuJissekiKihonShisetsuNyutaisho")
    public KyufuJissekiKihonShisetsuNyutaishoDiv getKyufuJissekiKihonShisetsuNyutaisho() {
        return KyufuJissekiKihonShisetsuNyutaisho;
    }

    @JsonProperty("KyufuJissekiKihonShisetsuNyutaisho")
    public void setKyufuJissekiKihonShisetsuNyutaisho(KyufuJissekiKihonShisetsuNyutaishoDiv KyufuJissekiKihonShisetsuNyutaisho) {
        this.KyufuJissekiKihonShisetsuNyutaisho=KyufuJissekiKihonShisetsuNyutaisho;
    }

    @JsonProperty("KyufuJissekiKihonKyufuritsu")
    public KyufuJissekiKihonKyufuritsuDiv getKyufuJissekiKihonKyufuritsu() {
        return KyufuJissekiKihonKyufuritsu;
    }

    @JsonProperty("KyufuJissekiKihonKyufuritsu")
    public void setKyufuJissekiKihonKyufuritsu(KyufuJissekiKihonKyufuritsuDiv KyufuJissekiKihonKyufuritsu) {
        this.KyufuJissekiKihonKyufuritsu=KyufuJissekiKihonKyufuritsu;
    }

    @JsonProperty("KyufuJissekiKihonKohi")
    public KyufuJissekiKihonKohiDiv getKyufuJissekiKihonKohi() {
        return KyufuJissekiKihonKohi;
    }

    @JsonProperty("KyufuJissekiKihonKohi")
    public void setKyufuJissekiKihonKohi(KyufuJissekiKihonKohiDiv KyufuJissekiKihonKohi) {
        this.KyufuJissekiKihonKohi=KyufuJissekiKihonKohi;
    }

}
