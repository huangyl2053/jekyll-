package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0310003;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * HonKakushuTsuchiUchiwakeKakunin のクラスファイル 
 * 
 * @author 自動生成
 */
public class HonKakushuTsuchiUchiwakeKakuninDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("HonKakushuTsuchiUchiwakeSentaku")
    private HonKakushuTsuchiUchiwakeSentakuDiv HonKakushuTsuchiUchiwakeSentaku;
    @JsonProperty("dgTsuchishoSettei")
    private DataGrid<dgTsuchishoSettei_Row> dgTsuchishoSettei;
    @JsonProperty("txtTsuchishoSetteiHozonMeisho")
    private TextBox txtTsuchishoSetteiHozonMeisho;
    @JsonProperty("btnTsuchishoSetteiHozon")
    private Button btnTsuchishoSetteiHozon;
    @JsonProperty("test001")
    private Button test001;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getHonKakushuTsuchiUchiwakeSentaku
     * @return HonKakushuTsuchiUchiwakeSentaku
     */
    @JsonProperty("HonKakushuTsuchiUchiwakeSentaku")
    public HonKakushuTsuchiUchiwakeSentakuDiv getHonKakushuTsuchiUchiwakeSentaku() {
        return HonKakushuTsuchiUchiwakeSentaku;
    }

    /*
     * setHonKakushuTsuchiUchiwakeSentaku
     * @param HonKakushuTsuchiUchiwakeSentaku HonKakushuTsuchiUchiwakeSentaku
     */
    @JsonProperty("HonKakushuTsuchiUchiwakeSentaku")
    public void setHonKakushuTsuchiUchiwakeSentaku(HonKakushuTsuchiUchiwakeSentakuDiv HonKakushuTsuchiUchiwakeSentaku) {
        this.HonKakushuTsuchiUchiwakeSentaku = HonKakushuTsuchiUchiwakeSentaku;
    }

    /*
     * getdgTsuchishoSettei
     * @return dgTsuchishoSettei
     */
    @JsonProperty("dgTsuchishoSettei")
    public DataGrid<dgTsuchishoSettei_Row> getDgTsuchishoSettei() {
        return dgTsuchishoSettei;
    }

    /*
     * setdgTsuchishoSettei
     * @param dgTsuchishoSettei dgTsuchishoSettei
     */
    @JsonProperty("dgTsuchishoSettei")
    public void setDgTsuchishoSettei(DataGrid<dgTsuchishoSettei_Row> dgTsuchishoSettei) {
        this.dgTsuchishoSettei = dgTsuchishoSettei;
    }

    /*
     * gettxtTsuchishoSetteiHozonMeisho
     * @return txtTsuchishoSetteiHozonMeisho
     */
    @JsonProperty("txtTsuchishoSetteiHozonMeisho")
    public TextBox getTxtTsuchishoSetteiHozonMeisho() {
        return txtTsuchishoSetteiHozonMeisho;
    }

    /*
     * settxtTsuchishoSetteiHozonMeisho
     * @param txtTsuchishoSetteiHozonMeisho txtTsuchishoSetteiHozonMeisho
     */
    @JsonProperty("txtTsuchishoSetteiHozonMeisho")
    public void setTxtTsuchishoSetteiHozonMeisho(TextBox txtTsuchishoSetteiHozonMeisho) {
        this.txtTsuchishoSetteiHozonMeisho = txtTsuchishoSetteiHozonMeisho;
    }

    /*
     * getbtnTsuchishoSetteiHozon
     * @return btnTsuchishoSetteiHozon
     */
    @JsonProperty("btnTsuchishoSetteiHozon")
    public Button getBtnTsuchishoSetteiHozon() {
        return btnTsuchishoSetteiHozon;
    }

    /*
     * setbtnTsuchishoSetteiHozon
     * @param btnTsuchishoSetteiHozon btnTsuchishoSetteiHozon
     */
    @JsonProperty("btnTsuchishoSetteiHozon")
    public void setBtnTsuchishoSetteiHozon(Button btnTsuchishoSetteiHozon) {
        this.btnTsuchishoSetteiHozon = btnTsuchishoSetteiHozon;
    }

    /*
     * gettest001
     * @return test001
     */
    @JsonProperty("test001")
    public Button getTest001() {
        return test001;
    }

    /*
     * settest001
     * @param test001 test001
     */
    @JsonProperty("test001")
    public void setTest001(Button test001) {
        this.test001 = test001;
    }

    // </editor-fold>
}
