package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyotakuServiceJikoSakuseiSummarySub1Div;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyotakuServiceJikoSakuseiSummarySub2Div;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgKyotakuServiceJikoSakusei_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.tblKyotakuServiceJikoSakuseiGoukeiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.tblKyotakuServiceJikoSakuseiMeisaiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KyotakuServiceJikoSakusei のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyotakuServiceJikoSakuseiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KyotakuServiceJikoSakuseiSummarySub1")
    private KyotakuServiceJikoSakuseiSummarySub1Div KyotakuServiceJikoSakuseiSummarySub1;
    @JsonProperty("KyotakuServiceJikoSakuseiSummarySub2")
    private KyotakuServiceJikoSakuseiSummarySub2Div KyotakuServiceJikoSakuseiSummarySub2;
    @JsonProperty("dgKyotakuServiceJikoSakusei")
    private DataGrid<dgKyotakuServiceJikoSakusei_Row> dgKyotakuServiceJikoSakusei;
    @JsonProperty("tblKyotakuServiceJikoSakuseiMeisai")
    private tblKyotakuServiceJikoSakuseiMeisaiDiv tblKyotakuServiceJikoSakuseiMeisai;
    @JsonProperty("tblKyotakuServiceJikoSakuseiGoukei")
    private tblKyotakuServiceJikoSakuseiGoukeiDiv tblKyotakuServiceJikoSakuseiGoukei;
    @JsonProperty("btnCloseJikoSakusei")
    private Button btnCloseJikoSakusei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("KyotakuServiceJikoSakuseiSummarySub1")
    public KyotakuServiceJikoSakuseiSummarySub1Div getKyotakuServiceJikoSakuseiSummarySub1() {
        return KyotakuServiceJikoSakuseiSummarySub1;
    }

    @JsonProperty("KyotakuServiceJikoSakuseiSummarySub1")
    public void setKyotakuServiceJikoSakuseiSummarySub1(KyotakuServiceJikoSakuseiSummarySub1Div KyotakuServiceJikoSakuseiSummarySub1) {
        this.KyotakuServiceJikoSakuseiSummarySub1=KyotakuServiceJikoSakuseiSummarySub1;
    }

    @JsonProperty("KyotakuServiceJikoSakuseiSummarySub2")
    public KyotakuServiceJikoSakuseiSummarySub2Div getKyotakuServiceJikoSakuseiSummarySub2() {
        return KyotakuServiceJikoSakuseiSummarySub2;
    }

    @JsonProperty("KyotakuServiceJikoSakuseiSummarySub2")
    public void setKyotakuServiceJikoSakuseiSummarySub2(KyotakuServiceJikoSakuseiSummarySub2Div KyotakuServiceJikoSakuseiSummarySub2) {
        this.KyotakuServiceJikoSakuseiSummarySub2=KyotakuServiceJikoSakuseiSummarySub2;
    }

    @JsonProperty("dgKyotakuServiceJikoSakusei")
    public DataGrid<dgKyotakuServiceJikoSakusei_Row> getDgKyotakuServiceJikoSakusei() {
        return dgKyotakuServiceJikoSakusei;
    }

    @JsonProperty("dgKyotakuServiceJikoSakusei")
    public void setDgKyotakuServiceJikoSakusei(DataGrid<dgKyotakuServiceJikoSakusei_Row> dgKyotakuServiceJikoSakusei) {
        this.dgKyotakuServiceJikoSakusei=dgKyotakuServiceJikoSakusei;
    }

    @JsonProperty("tblKyotakuServiceJikoSakuseiMeisai")
    public tblKyotakuServiceJikoSakuseiMeisaiDiv getTblKyotakuServiceJikoSakuseiMeisai() {
        return tblKyotakuServiceJikoSakuseiMeisai;
    }

    @JsonProperty("tblKyotakuServiceJikoSakuseiMeisai")
    public void setTblKyotakuServiceJikoSakuseiMeisai(tblKyotakuServiceJikoSakuseiMeisaiDiv tblKyotakuServiceJikoSakuseiMeisai) {
        this.tblKyotakuServiceJikoSakuseiMeisai=tblKyotakuServiceJikoSakuseiMeisai;
    }

    @JsonProperty("tblKyotakuServiceJikoSakuseiGoukei")
    public tblKyotakuServiceJikoSakuseiGoukeiDiv getTblKyotakuServiceJikoSakuseiGoukei() {
        return tblKyotakuServiceJikoSakuseiGoukei;
    }

    @JsonProperty("tblKyotakuServiceJikoSakuseiGoukei")
    public void setTblKyotakuServiceJikoSakuseiGoukei(tblKyotakuServiceJikoSakuseiGoukeiDiv tblKyotakuServiceJikoSakuseiGoukei) {
        this.tblKyotakuServiceJikoSakuseiGoukei=tblKyotakuServiceJikoSakuseiGoukei;
    }

    @JsonProperty("btnCloseJikoSakusei")
    public Button getBtnCloseJikoSakusei() {
        return btnCloseJikoSakusei;
    }

    @JsonProperty("btnCloseJikoSakusei")
    public void setBtnCloseJikoSakusei(Button btnCloseJikoSakusei) {
        this.btnCloseJikoSakusei=btnCloseJikoSakusei;
    }

}
