package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6040001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShinsakaiIinHoshu のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinsakaiIinHoshuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-16_10-13-04">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShinsakaiKaisaiYMView")
    private TextBoxDate txtShinsakaiKaisaiYMView;
    @JsonProperty("dgShinsakaiIinHoshu")
    private DataGrid<dgShinsakaiIinHoshu_Row> dgShinsakaiIinHoshu;
    @JsonProperty("lblLegend")
    private Label lblLegend;
    @JsonProperty("txtTotalCount")
    private TextBoxNum txtTotalCount;
    @JsonProperty("txtShinsaKaisu")
    private TextBoxNum txtShinsaKaisu;
    @JsonProperty("txtHoshuSogaku")
    private TextBoxNum txtHoshuSogaku;
    @JsonProperty("txtSonotaHiyo")
    private TextBoxNum txtSonotaHiyo;
    @JsonProperty("txtZeiKojoGaku")
    private TextBoxNum txtZeiKojoGaku;
    @JsonProperty("txtHoshuGokei")
    private TextBoxNum txtHoshuGokei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShinsakaiKaisaiYMView
     * @return txtShinsakaiKaisaiYMView
     */
    @JsonProperty("txtShinsakaiKaisaiYMView")
    public TextBoxDate getTxtShinsakaiKaisaiYMView() {
        return txtShinsakaiKaisaiYMView;
    }

    /*
     * settxtShinsakaiKaisaiYMView
     * @param txtShinsakaiKaisaiYMView txtShinsakaiKaisaiYMView
     */
    @JsonProperty("txtShinsakaiKaisaiYMView")
    public void setTxtShinsakaiKaisaiYMView(TextBoxDate txtShinsakaiKaisaiYMView) {
        this.txtShinsakaiKaisaiYMView = txtShinsakaiKaisaiYMView;
    }

    /*
     * getdgShinsakaiIinHoshu
     * @return dgShinsakaiIinHoshu
     */
    @JsonProperty("dgShinsakaiIinHoshu")
    public DataGrid<dgShinsakaiIinHoshu_Row> getDgShinsakaiIinHoshu() {
        return dgShinsakaiIinHoshu;
    }

    /*
     * setdgShinsakaiIinHoshu
     * @param dgShinsakaiIinHoshu dgShinsakaiIinHoshu
     */
    @JsonProperty("dgShinsakaiIinHoshu")
    public void setDgShinsakaiIinHoshu(DataGrid<dgShinsakaiIinHoshu_Row> dgShinsakaiIinHoshu) {
        this.dgShinsakaiIinHoshu = dgShinsakaiIinHoshu;
    }

    /*
     * getlblLegend
     * @return lblLegend
     */
    @JsonProperty("lblLegend")
    public Label getLblLegend() {
        return lblLegend;
    }

    /*
     * setlblLegend
     * @param lblLegend lblLegend
     */
    @JsonProperty("lblLegend")
    public void setLblLegend(Label lblLegend) {
        this.lblLegend = lblLegend;
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
     * gettxtShinsaKaisu
     * @return txtShinsaKaisu
     */
    @JsonProperty("txtShinsaKaisu")
    public TextBoxNum getTxtShinsaKaisu() {
        return txtShinsaKaisu;
    }

    /*
     * settxtShinsaKaisu
     * @param txtShinsaKaisu txtShinsaKaisu
     */
    @JsonProperty("txtShinsaKaisu")
    public void setTxtShinsaKaisu(TextBoxNum txtShinsaKaisu) {
        this.txtShinsaKaisu = txtShinsaKaisu;
    }

    /*
     * gettxtHoshuSogaku
     * @return txtHoshuSogaku
     */
    @JsonProperty("txtHoshuSogaku")
    public TextBoxNum getTxtHoshuSogaku() {
        return txtHoshuSogaku;
    }

    /*
     * settxtHoshuSogaku
     * @param txtHoshuSogaku txtHoshuSogaku
     */
    @JsonProperty("txtHoshuSogaku")
    public void setTxtHoshuSogaku(TextBoxNum txtHoshuSogaku) {
        this.txtHoshuSogaku = txtHoshuSogaku;
    }

    /*
     * gettxtSonotaHiyo
     * @return txtSonotaHiyo
     */
    @JsonProperty("txtSonotaHiyo")
    public TextBoxNum getTxtSonotaHiyo() {
        return txtSonotaHiyo;
    }

    /*
     * settxtSonotaHiyo
     * @param txtSonotaHiyo txtSonotaHiyo
     */
    @JsonProperty("txtSonotaHiyo")
    public void setTxtSonotaHiyo(TextBoxNum txtSonotaHiyo) {
        this.txtSonotaHiyo = txtSonotaHiyo;
    }

    /*
     * gettxtZeiKojoGaku
     * @return txtZeiKojoGaku
     */
    @JsonProperty("txtZeiKojoGaku")
    public TextBoxNum getTxtZeiKojoGaku() {
        return txtZeiKojoGaku;
    }

    /*
     * settxtZeiKojoGaku
     * @param txtZeiKojoGaku txtZeiKojoGaku
     */
    @JsonProperty("txtZeiKojoGaku")
    public void setTxtZeiKojoGaku(TextBoxNum txtZeiKojoGaku) {
        this.txtZeiKojoGaku = txtZeiKojoGaku;
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
