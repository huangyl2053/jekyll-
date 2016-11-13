package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD3010002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * DvRiyoshafutanGakuWariai のクラスファイル 
 * 
 * @author 自動生成
 */
public class DvRiyoshafutanGakuWariaiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-17_21-01-54">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtRiyoshafutanNendo")
    private TextBoxDate txtRiyoshafutanNendo;
    @JsonProperty("txtRiyoshafutanWariai")
    private TextBox txtRiyoshafutanWariai;
    @JsonProperty("txtTekiyoKikan")
    private TextBoxDateRange txtTekiyoKikan;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtRiyoshafutanNendo
     * @return txtRiyoshafutanNendo
     */
    @JsonProperty("txtRiyoshafutanNendo")
    public TextBoxDate getTxtRiyoshafutanNendo() {
        return txtRiyoshafutanNendo;
    }

    /*
     * settxtRiyoshafutanNendo
     * @param txtRiyoshafutanNendo txtRiyoshafutanNendo
     */
    @JsonProperty("txtRiyoshafutanNendo")
    public void setTxtRiyoshafutanNendo(TextBoxDate txtRiyoshafutanNendo) {
        this.txtRiyoshafutanNendo = txtRiyoshafutanNendo;
    }

    /*
     * gettxtRiyoshafutanWariai
     * @return txtRiyoshafutanWariai
     */
    @JsonProperty("txtRiyoshafutanWariai")
    public TextBox getTxtRiyoshafutanWariai() {
        return txtRiyoshafutanWariai;
    }

    /*
     * settxtRiyoshafutanWariai
     * @param txtRiyoshafutanWariai txtRiyoshafutanWariai
     */
    @JsonProperty("txtRiyoshafutanWariai")
    public void setTxtRiyoshafutanWariai(TextBox txtRiyoshafutanWariai) {
        this.txtRiyoshafutanWariai = txtRiyoshafutanWariai;
    }

    /*
     * gettxtTekiyoKikan
     * @return txtTekiyoKikan
     */
    @JsonProperty("txtTekiyoKikan")
    public TextBoxDateRange getTxtTekiyoKikan() {
        return txtTekiyoKikan;
    }

    /*
     * settxtTekiyoKikan
     * @param txtTekiyoKikan txtTekiyoKikan
     */
    @JsonProperty("txtTekiyoKikan")
    public void setTxtTekiyoKikan(TextBoxDateRange txtTekiyoKikan) {
        this.txtTekiyoKikan = txtTekiyoKikan;
    }

    // </editor-fold>
}
