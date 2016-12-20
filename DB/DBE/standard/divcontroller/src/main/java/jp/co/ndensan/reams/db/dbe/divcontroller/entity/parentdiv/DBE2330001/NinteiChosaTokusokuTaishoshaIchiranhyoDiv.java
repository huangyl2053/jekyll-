package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2330001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NinteiChosaTokusokuTaishoshaIchiranhyo のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiChosaTokusokuTaishoshaIchiranhyoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-02_08-19-39">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkInsatsuChohyo")
    private CheckBoxList chkInsatsuChohyo;
    @JsonProperty("chkCSVShutsuryoku")
    private CheckBoxList chkCSVShutsuryoku;
    @JsonProperty("txtInsatsuKikan")
    private TextBoxDateRange txtInsatsuKikan;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkInsatsuChohyo
     * @return chkInsatsuChohyo
     */
    @JsonProperty("chkInsatsuChohyo")
    public CheckBoxList getChkInsatsuChohyo() {
        return chkInsatsuChohyo;
    }

    /*
     * setchkInsatsuChohyo
     * @param chkInsatsuChohyo chkInsatsuChohyo
     */
    @JsonProperty("chkInsatsuChohyo")
    public void setChkInsatsuChohyo(CheckBoxList chkInsatsuChohyo) {
        this.chkInsatsuChohyo = chkInsatsuChohyo;
    }

    /*
     * getchkCSVShutsuryoku
     * @return chkCSVShutsuryoku
     */
    @JsonProperty("chkCSVShutsuryoku")
    public CheckBoxList getChkCSVShutsuryoku() {
        return chkCSVShutsuryoku;
    }

    /*
     * setchkCSVShutsuryoku
     * @param chkCSVShutsuryoku chkCSVShutsuryoku
     */
    @JsonProperty("chkCSVShutsuryoku")
    public void setChkCSVShutsuryoku(CheckBoxList chkCSVShutsuryoku) {
        this.chkCSVShutsuryoku = chkCSVShutsuryoku;
    }

    /*
     * gettxtInsatsuKikan
     * @return txtInsatsuKikan
     */
    @JsonProperty("txtInsatsuKikan")
    public TextBoxDateRange getTxtInsatsuKikan() {
        return txtInsatsuKikan;
    }

    /*
     * settxtInsatsuKikan
     * @param txtInsatsuKikan txtInsatsuKikan
     */
    @JsonProperty("txtInsatsuKikan")
    public void setTxtInsatsuKikan(TextBoxDateRange txtInsatsuKikan) {
        this.txtInsatsuKikan = txtInsatsuKikan;
    }

    // </editor-fold>
}
