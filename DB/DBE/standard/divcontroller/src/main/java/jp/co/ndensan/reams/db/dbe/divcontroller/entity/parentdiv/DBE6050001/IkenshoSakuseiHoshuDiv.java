package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6050001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * IkenshoSakuseiHoshu のクラスファイル 
 * 
 * @author 自動生成
 */
public class IkenshoSakuseiHoshuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-16_10-13-04">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgIkenshoSakuseiHoshu")
    private DataGrid<dgIkenshoSakuseiHoshu_Row> dgIkenshoSakuseiHoshu;
    @JsonProperty("txtTotalCount")
    private TextBoxNum txtTotalCount;
    @JsonProperty("txtZaitakuShinki")
    private TextBoxNum txtZaitakuShinki;
    @JsonProperty("txtZaitakuKeizoku")
    private TextBoxNum txtZaitakuKeizoku;
    @JsonProperty("txtShisetsuShinki")
    private TextBoxNum txtShisetsuShinki;
    @JsonProperty("txtShisetsuKeizoku")
    private TextBoxNum txtShisetsuKeizoku;
    @JsonProperty("txtSakuseiryo")
    private TextBoxNum txtSakuseiryo;
    @JsonProperty("txtShinryohi")
    private TextBoxNum txtShinryohi;
    @JsonProperty("txtHoshuGokei")
    private TextBoxNum txtHoshuGokei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgIkenshoSakuseiHoshu
     * @return dgIkenshoSakuseiHoshu
     */
    @JsonProperty("dgIkenshoSakuseiHoshu")
    public DataGrid<dgIkenshoSakuseiHoshu_Row> getDgIkenshoSakuseiHoshu() {
        return dgIkenshoSakuseiHoshu;
    }

    /*
     * setdgIkenshoSakuseiHoshu
     * @param dgIkenshoSakuseiHoshu dgIkenshoSakuseiHoshu
     */
    @JsonProperty("dgIkenshoSakuseiHoshu")
    public void setDgIkenshoSakuseiHoshu(DataGrid<dgIkenshoSakuseiHoshu_Row> dgIkenshoSakuseiHoshu) {
        this.dgIkenshoSakuseiHoshu = dgIkenshoSakuseiHoshu;
    }

    /*
     * gettxtTotalCount
     * @return txtTotalCount
     */
    @JsonProperty("txtTotalCount")
    public TextBoxNum getTxtTotalCount() {
        return txtTotalCount;
    }

    /*
     * settxtTotalCount
     * @param txtTotalCount txtTotalCount
     */
    @JsonProperty("txtTotalCount")
    public void setTxtTotalCount(TextBoxNum txtTotalCount) {
        this.txtTotalCount = txtTotalCount;
    }

    /*
     * gettxtZaitakuShinki
     * @return txtZaitakuShinki
     */
    @JsonProperty("txtZaitakuShinki")
    public TextBoxNum getTxtZaitakuShinki() {
        return txtZaitakuShinki;
    }

    /*
     * settxtZaitakuShinki
     * @param txtZaitakuShinki txtZaitakuShinki
     */
    @JsonProperty("txtZaitakuShinki")
    public void setTxtZaitakuShinki(TextBoxNum txtZaitakuShinki) {
        this.txtZaitakuShinki = txtZaitakuShinki;
    }

    /*
     * gettxtZaitakuKeizoku
     * @return txtZaitakuKeizoku
     */
    @JsonProperty("txtZaitakuKeizoku")
    public TextBoxNum getTxtZaitakuKeizoku() {
        return txtZaitakuKeizoku;
    }

    /*
     * settxtZaitakuKeizoku
     * @param txtZaitakuKeizoku txtZaitakuKeizoku
     */
    @JsonProperty("txtZaitakuKeizoku")
    public void setTxtZaitakuKeizoku(TextBoxNum txtZaitakuKeizoku) {
        this.txtZaitakuKeizoku = txtZaitakuKeizoku;
    }

    /*
     * gettxtShisetsuShinki
     * @return txtShisetsuShinki
     */
    @JsonProperty("txtShisetsuShinki")
    public TextBoxNum getTxtShisetsuShinki() {
        return txtShisetsuShinki;
    }

    /*
     * settxtShisetsuShinki
     * @param txtShisetsuShinki txtShisetsuShinki
     */
    @JsonProperty("txtShisetsuShinki")
    public void setTxtShisetsuShinki(TextBoxNum txtShisetsuShinki) {
        this.txtShisetsuShinki = txtShisetsuShinki;
    }

    /*
     * gettxtShisetsuKeizoku
     * @return txtShisetsuKeizoku
     */
    @JsonProperty("txtShisetsuKeizoku")
    public TextBoxNum getTxtShisetsuKeizoku() {
        return txtShisetsuKeizoku;
    }

    /*
     * settxtShisetsuKeizoku
     * @param txtShisetsuKeizoku txtShisetsuKeizoku
     */
    @JsonProperty("txtShisetsuKeizoku")
    public void setTxtShisetsuKeizoku(TextBoxNum txtShisetsuKeizoku) {
        this.txtShisetsuKeizoku = txtShisetsuKeizoku;
    }

    /*
     * gettxtSakuseiryo
     * @return txtSakuseiryo
     */
    @JsonProperty("txtSakuseiryo")
    public TextBoxNum getTxtSakuseiryo() {
        return txtSakuseiryo;
    }

    /*
     * settxtSakuseiryo
     * @param txtSakuseiryo txtSakuseiryo
     */
    @JsonProperty("txtSakuseiryo")
    public void setTxtSakuseiryo(TextBoxNum txtSakuseiryo) {
        this.txtSakuseiryo = txtSakuseiryo;
    }

    /*
     * gettxtShinryohi
     * @return txtShinryohi
     */
    @JsonProperty("txtShinryohi")
    public TextBoxNum getTxtShinryohi() {
        return txtShinryohi;
    }

    /*
     * settxtShinryohi
     * @param txtShinryohi txtShinryohi
     */
    @JsonProperty("txtShinryohi")
    public void setTxtShinryohi(TextBoxNum txtShinryohi) {
        this.txtShinryohi = txtShinryohi;
    }

    /*
     * gettxtHoshuGokei
     * @return txtHoshuGokei
     */
    @JsonProperty("txtHoshuGokei")
    public TextBoxNum getTxtHoshuGokei() {
        return txtHoshuGokei;
    }

    /*
     * settxtHoshuGokei
     * @param txtHoshuGokei txtHoshuGokei
     */
    @JsonProperty("txtHoshuGokei")
    public void setTxtHoshuGokei(TextBoxNum txtHoshuGokei) {
        this.txtHoshuGokei = txtHoshuGokei;
    }

    // </editor-fold>
}
