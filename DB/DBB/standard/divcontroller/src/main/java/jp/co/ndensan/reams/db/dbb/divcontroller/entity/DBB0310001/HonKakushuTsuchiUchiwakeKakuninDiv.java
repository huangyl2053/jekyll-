package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0310001;
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
 * HonKakushuTsuchiUchiwakeKakunin のクラスファイル 
 * 
 * @author 自動生成
 */
public class HonKakushuTsuchiUchiwakeKakuninDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("HonKakushuTsuchiUchiwakeSentaku")
    private HonKakushuTsuchiUchiwakeSentakuDiv HonKakushuTsuchiUchiwakeSentaku;
    @JsonProperty("btnTsuchishoSort")
    private Button btnTsuchishoSort;
    @JsonProperty("dgTsuchishoSettei")
    private DataGrid<dgTsuchishoSettei_Row> dgTsuchishoSettei;
    @JsonProperty("txtTsuchishoSetteiHozonMeisho")
    private TextBox txtTsuchishoSetteiHozonMeisho;
    @JsonProperty("btnTsuchishoSetteiHozon")
    private Button btnTsuchishoSetteiHozon;
    @JsonProperty("HonKakushuTsuchiButton")
    private HonKakushuTsuchiButtonDiv HonKakushuTsuchiButton;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("HonKakushuTsuchiUchiwakeSentaku")
    public HonKakushuTsuchiUchiwakeSentakuDiv getHonKakushuTsuchiUchiwakeSentaku() {
        return HonKakushuTsuchiUchiwakeSentaku;
    }

    @JsonProperty("HonKakushuTsuchiUchiwakeSentaku")
    public void setHonKakushuTsuchiUchiwakeSentaku(HonKakushuTsuchiUchiwakeSentakuDiv HonKakushuTsuchiUchiwakeSentaku) {
        this.HonKakushuTsuchiUchiwakeSentaku=HonKakushuTsuchiUchiwakeSentaku;
    }

    @JsonProperty("btnTsuchishoSort")
    public Button getBtnTsuchishoSort() {
        return btnTsuchishoSort;
    }

    @JsonProperty("btnTsuchishoSort")
    public void setBtnTsuchishoSort(Button btnTsuchishoSort) {
        this.btnTsuchishoSort=btnTsuchishoSort;
    }

    @JsonProperty("dgTsuchishoSettei")
    public DataGrid<dgTsuchishoSettei_Row> getDgTsuchishoSettei() {
        return dgTsuchishoSettei;
    }

    @JsonProperty("dgTsuchishoSettei")
    public void setDgTsuchishoSettei(DataGrid<dgTsuchishoSettei_Row> dgTsuchishoSettei) {
        this.dgTsuchishoSettei=dgTsuchishoSettei;
    }

    @JsonProperty("txtTsuchishoSetteiHozonMeisho")
    public TextBox getTxtTsuchishoSetteiHozonMeisho() {
        return txtTsuchishoSetteiHozonMeisho;
    }

    @JsonProperty("txtTsuchishoSetteiHozonMeisho")
    public void setTxtTsuchishoSetteiHozonMeisho(TextBox txtTsuchishoSetteiHozonMeisho) {
        this.txtTsuchishoSetteiHozonMeisho=txtTsuchishoSetteiHozonMeisho;
    }

    @JsonProperty("btnTsuchishoSetteiHozon")
    public Button getBtnTsuchishoSetteiHozon() {
        return btnTsuchishoSetteiHozon;
    }

    @JsonProperty("btnTsuchishoSetteiHozon")
    public void setBtnTsuchishoSetteiHozon(Button btnTsuchishoSetteiHozon) {
        this.btnTsuchishoSetteiHozon=btnTsuchishoSetteiHozon;
    }

    @JsonProperty("HonKakushuTsuchiButton")
    public HonKakushuTsuchiButtonDiv getHonKakushuTsuchiButton() {
        return HonKakushuTsuchiButton;
    }

    @JsonProperty("HonKakushuTsuchiButton")
    public void setHonKakushuTsuchiButton(HonKakushuTsuchiButtonDiv HonKakushuTsuchiButton) {
        this.HonKakushuTsuchiButton=HonKakushuTsuchiButton;
    }

}
