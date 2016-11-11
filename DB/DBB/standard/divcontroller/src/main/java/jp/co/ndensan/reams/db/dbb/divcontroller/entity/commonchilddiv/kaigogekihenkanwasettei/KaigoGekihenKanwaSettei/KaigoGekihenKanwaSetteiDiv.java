package jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.kaigogekihenkanwasettei.KaigoGekihenKanwaSettei;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;

/**
 * KaigoGekihenKanwaSettei のクラスファイル
 *
 * @reamsid_L DBB-1770-020 wangkanglei
 */
public class KaigoGekihenKanwaSetteiDiv extends Panel implements IKaigoGekihenKanwaSetteiDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgGekihenKanwa")
    private DataGrid<dgGekihenKanwa_Row> dgGekihenKanwa;
    @JsonProperty("btnKakutei")
    private Button btnKakutei;
    @JsonProperty("btnClose")
    private Button btnClose;
    @JsonProperty("hdnGekihenIndex04")
    private RString hdnGekihenIndex04;
    @JsonProperty("hdnGekihenIndex05")
    private RString hdnGekihenIndex05;
    @JsonProperty("hdnGekihenIndex06")
    private RString hdnGekihenIndex06;
    @JsonProperty("hdnGekihenIndex08")
    private RString hdnGekihenIndex08;
    @JsonProperty("hdnGekihenIndex09")
    private RString hdnGekihenIndex09;
    @JsonProperty("hdnGekihenIndex10")
    private RString hdnGekihenIndex10;
    @JsonProperty("hdnGekihenIndex11")
    private RString hdnGekihenIndex11;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgGekihenKanwa
     * @return dgGekihenKanwa
     */
    @JsonProperty("dgGekihenKanwa")
    public DataGrid<dgGekihenKanwa_Row> getDgGekihenKanwa() {
        return dgGekihenKanwa;
    }

    /*
     * setdgGekihenKanwa
     * @param dgGekihenKanwa dgGekihenKanwa
     */
    @JsonProperty("dgGekihenKanwa")
    public void setDgGekihenKanwa(DataGrid<dgGekihenKanwa_Row> dgGekihenKanwa) {
        this.dgGekihenKanwa = dgGekihenKanwa;
    }

    /*
     * getbtnKakutei
     * @return btnKakutei
     */
    @JsonProperty("btnKakutei")
    public Button getBtnKakutei() {
        return btnKakutei;
    }

    /*
     * setbtnKakutei
     * @param btnKakutei btnKakutei
     */
    @JsonProperty("btnKakutei")
    public void setBtnKakutei(Button btnKakutei) {
        this.btnKakutei = btnKakutei;
    }

    /*
     * getbtnClose
     * @return btnClose
     */
    @JsonProperty("btnClose")
    public Button getBtnClose() {
        return btnClose;
    }

    /*
     * setbtnClose
     * @param btnClose btnClose
     */
    @JsonProperty("btnClose")
    public void setBtnClose(Button btnClose) {
        this.btnClose = btnClose;
    }

    /*
     * gethdnGekihenIndex04
     * @return hdnGekihenIndex04
     */
    @JsonProperty("hdnGekihenIndex04")
    public RString getHdnGekihenIndex04() {
        return hdnGekihenIndex04;
    }

    /*
     * sethdnGekihenIndex04
     * @param hdnGekihenIndex04 hdnGekihenIndex04
     */
    @JsonProperty("hdnGekihenIndex04")
    public void setHdnGekihenIndex04(RString hdnGekihenIndex04) {
        this.hdnGekihenIndex04 = hdnGekihenIndex04;
    }

    /*
     * gethdnGekihenIndex05
     * @return hdnGekihenIndex05
     */
    @JsonProperty("hdnGekihenIndex05")
    public RString getHdnGekihenIndex05() {
        return hdnGekihenIndex05;
    }

    /*
     * sethdnGekihenIndex05
     * @param hdnGekihenIndex05 hdnGekihenIndex05
     */
    @JsonProperty("hdnGekihenIndex05")
    public void setHdnGekihenIndex05(RString hdnGekihenIndex05) {
        this.hdnGekihenIndex05 = hdnGekihenIndex05;
    }

    /*
     * gethdnGekihenIndex06
     * @return hdnGekihenIndex06
     */
    @JsonProperty("hdnGekihenIndex06")
    public RString getHdnGekihenIndex06() {
        return hdnGekihenIndex06;
    }

    /*
     * sethdnGekihenIndex06
     * @param hdnGekihenIndex06 hdnGekihenIndex06
     */
    @JsonProperty("hdnGekihenIndex06")
    public void setHdnGekihenIndex06(RString hdnGekihenIndex06) {
        this.hdnGekihenIndex06 = hdnGekihenIndex06;
    }

    /*
     * gethdnGekihenIndex08
     * @return hdnGekihenIndex08
     */
    @JsonProperty("hdnGekihenIndex08")
    public RString getHdnGekihenIndex08() {
        return hdnGekihenIndex08;
    }

    /*
     * sethdnGekihenIndex08
     * @param hdnGekihenIndex08 hdnGekihenIndex08
     */
    @JsonProperty("hdnGekihenIndex08")
    public void setHdnGekihenIndex08(RString hdnGekihenIndex08) {
        this.hdnGekihenIndex08 = hdnGekihenIndex08;
    }

    /*
     * gethdnGekihenIndex09
     * @return hdnGekihenIndex09
     */
    @JsonProperty("hdnGekihenIndex09")
    public RString getHdnGekihenIndex09() {
        return hdnGekihenIndex09;
    }

    /*
     * sethdnGekihenIndex09
     * @param hdnGekihenIndex09 hdnGekihenIndex09
     */
    @JsonProperty("hdnGekihenIndex09")
    public void setHdnGekihenIndex09(RString hdnGekihenIndex09) {
        this.hdnGekihenIndex09 = hdnGekihenIndex09;
    }

    /*
     * gethdnGekihenIndex10
     * @return hdnGekihenIndex10
     */
    @JsonProperty("hdnGekihenIndex10")
    public RString getHdnGekihenIndex10() {
        return hdnGekihenIndex10;
    }

    /*
     * sethdnGekihenIndex10
     * @param hdnGekihenIndex10 hdnGekihenIndex10
     */
    @JsonProperty("hdnGekihenIndex10")
    public void setHdnGekihenIndex10(RString hdnGekihenIndex10) {
        this.hdnGekihenIndex10 = hdnGekihenIndex10;
    }

    /*
     * gethdnGekihenIndex11
     * @return hdnGekihenIndex11
     */
    @JsonProperty("hdnGekihenIndex11")
    public RString getHdnGekihenIndex11() {
        return hdnGekihenIndex11;
    }

    /*
     * sethdnGekihenIndex11
     * @param hdnGekihenIndex11 hdnGekihenIndex11
     */
    @JsonProperty("hdnGekihenIndex11")
    public void setHdnGekihenIndex11(RString hdnGekihenIndex11) {
        this.hdnGekihenIndex11 = hdnGekihenIndex11;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @JsonIgnore
    @Override
    public void initialize(Decimal hdnGekihenIndex04,
            Decimal hdnGekihenIndex05,
            Decimal hdnGekihenIndex06,
            Decimal hdnGekihenIndex08,
            Decimal hdnGekihenIndex09,
            Decimal hdnGekihenIndex10,
            Decimal hdnGekihenIndex11) {
        KaigoGekihenKanwaSetteiHandler.of(this).onLoad(hdnGekihenIndex04,
                hdnGekihenIndex05,
                hdnGekihenIndex06,
                hdnGekihenIndex08,
                hdnGekihenIndex09,
                hdnGekihenIndex10,
                hdnGekihenIndex11);
    }

}
