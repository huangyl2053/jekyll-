package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0020011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JikoSakuseiTodokedeInfo のクラスファイル 
 * 
 * @author 自動生成
 */
public class JikoSakuseiTodokedeInfoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtTodokedeYmd")
    private TextBoxDate txtTodokedeYmd;
    @JsonProperty("txtTodokedeKubun")
    private TextBox txtTodokedeKubun;
    @JsonProperty("txtTekiyoKikan")
    private TextBoxDateRange txtTekiyoKikan;
    @JsonProperty("Todokedesha")
    private TodokedeshaDiv Todokedesha;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtTodokedeYmd
     * @return txtTodokedeYmd
     */
    @JsonProperty("txtTodokedeYmd")
    public TextBoxDate getTxtTodokedeYmd() {
        return txtTodokedeYmd;
    }

    /*
     * settxtTodokedeYmd
     * @param txtTodokedeYmd txtTodokedeYmd
     */
    @JsonProperty("txtTodokedeYmd")
    public void setTxtTodokedeYmd(TextBoxDate txtTodokedeYmd) {
        this.txtTodokedeYmd = txtTodokedeYmd;
    }

    /*
     * gettxtTodokedeKubun
     * @return txtTodokedeKubun
     */
    @JsonProperty("txtTodokedeKubun")
    public TextBox getTxtTodokedeKubun() {
        return txtTodokedeKubun;
    }

    /*
     * settxtTodokedeKubun
     * @param txtTodokedeKubun txtTodokedeKubun
     */
    @JsonProperty("txtTodokedeKubun")
    public void setTxtTodokedeKubun(TextBox txtTodokedeKubun) {
        this.txtTodokedeKubun = txtTodokedeKubun;
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

    /*
     * getTodokedesha
     * @return Todokedesha
     */
    @JsonProperty("Todokedesha")
    public TodokedeshaDiv getTodokedesha() {
        return Todokedesha;
    }

    /*
     * setTodokedesha
     * @param Todokedesha Todokedesha
     */
    @JsonProperty("Todokedesha")
    public void setTodokedesha(TodokedeshaDiv Todokedesha) {
        this.Todokedesha = Todokedesha;
    }

    // </editor-fold>
}
