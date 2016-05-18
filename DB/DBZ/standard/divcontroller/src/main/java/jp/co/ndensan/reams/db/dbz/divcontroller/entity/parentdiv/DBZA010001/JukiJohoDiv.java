package jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.DBZA010001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JukiJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class JukiJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtJukiShojoJiyu")
    private TextBox txtJukiShojoJiyu;
    @JsonProperty("txtShojoIdoYmd")
    private TextBoxFlexibleDate txtShojoIdoYmd;
    @JsonProperty("txtShojoTodokedeYmd")
    private TextBoxFlexibleDate txtShojoTodokedeYmd;
    @JsonProperty("txtTenshutsuYoteiYmd")
    private TextBoxFlexibleDate txtTenshutsuYoteiYmd;
    @JsonProperty("txtTenshutsuKakuteiYmd")
    private TextBoxFlexibleDate txtTenshutsuKakuteiYmd;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtJukiShojoJiyu
     * @return txtJukiShojoJiyu
     */
    @JsonProperty("txtJukiShojoJiyu")
    public TextBox getTxtJukiShojoJiyu() {
        return txtJukiShojoJiyu;
    }

    /*
     * settxtJukiShojoJiyu
     * @param txtJukiShojoJiyu txtJukiShojoJiyu
     */
    @JsonProperty("txtJukiShojoJiyu")
    public void setTxtJukiShojoJiyu(TextBox txtJukiShojoJiyu) {
        this.txtJukiShojoJiyu = txtJukiShojoJiyu;
    }

    /*
     * gettxtShojoIdoYmd
     * @return txtShojoIdoYmd
     */
    @JsonProperty("txtShojoIdoYmd")
    public TextBoxFlexibleDate getTxtShojoIdoYmd() {
        return txtShojoIdoYmd;
    }

    /*
     * settxtShojoIdoYmd
     * @param txtShojoIdoYmd txtShojoIdoYmd
     */
    @JsonProperty("txtShojoIdoYmd")
    public void setTxtShojoIdoYmd(TextBoxFlexibleDate txtShojoIdoYmd) {
        this.txtShojoIdoYmd = txtShojoIdoYmd;
    }

    /*
     * gettxtShojoTodokedeYmd
     * @return txtShojoTodokedeYmd
     */
    @JsonProperty("txtShojoTodokedeYmd")
    public TextBoxFlexibleDate getTxtShojoTodokedeYmd() {
        return txtShojoTodokedeYmd;
    }

    /*
     * settxtShojoTodokedeYmd
     * @param txtShojoTodokedeYmd txtShojoTodokedeYmd
     */
    @JsonProperty("txtShojoTodokedeYmd")
    public void setTxtShojoTodokedeYmd(TextBoxFlexibleDate txtShojoTodokedeYmd) {
        this.txtShojoTodokedeYmd = txtShojoTodokedeYmd;
    }

    /*
     * gettxtTenshutsuYoteiYmd
     * @return txtTenshutsuYoteiYmd
     */
    @JsonProperty("txtTenshutsuYoteiYmd")
    public TextBoxFlexibleDate getTxtTenshutsuYoteiYmd() {
        return txtTenshutsuYoteiYmd;
    }

    /*
     * settxtTenshutsuYoteiYmd
     * @param txtTenshutsuYoteiYmd txtTenshutsuYoteiYmd
     */
    @JsonProperty("txtTenshutsuYoteiYmd")
    public void setTxtTenshutsuYoteiYmd(TextBoxFlexibleDate txtTenshutsuYoteiYmd) {
        this.txtTenshutsuYoteiYmd = txtTenshutsuYoteiYmd;
    }

    /*
     * gettxtTenshutsuKakuteiYmd
     * @return txtTenshutsuKakuteiYmd
     */
    @JsonProperty("txtTenshutsuKakuteiYmd")
    public TextBoxFlexibleDate getTxtTenshutsuKakuteiYmd() {
        return txtTenshutsuKakuteiYmd;
    }

    /*
     * settxtTenshutsuKakuteiYmd
     * @param txtTenshutsuKakuteiYmd txtTenshutsuKakuteiYmd
     */
    @JsonProperty("txtTenshutsuKakuteiYmd")
    public void setTxtTenshutsuKakuteiYmd(TextBoxFlexibleDate txtTenshutsuKakuteiYmd) {
        this.txtTenshutsuKakuteiYmd = txtTenshutsuKakuteiYmd;
    }

    // </editor-fold>
}
