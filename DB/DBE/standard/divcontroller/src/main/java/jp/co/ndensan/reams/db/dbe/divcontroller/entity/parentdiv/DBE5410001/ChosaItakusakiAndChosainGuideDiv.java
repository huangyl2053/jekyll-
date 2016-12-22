package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5410001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ChosaItakusakiAndChosainGuide のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChosaItakusakiAndChosainGuideDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-09-23_20-45-52">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtChosaItakusakiCode")
    private TextBoxCode txtChosaItakusakiCode;
    @JsonProperty("txtChosaItakusakiName")
    private TextBox txtChosaItakusakiName;
    @JsonProperty("txtNinteiChosainCode")
    private TextBoxCode txtNinteiChosainCode;
    @JsonProperty("txtNinteiChosainName")
    private TextBox txtNinteiChosainName;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtChosaItakusakiCode
     * @return txtChosaItakusakiCode
     */
    @JsonProperty("txtChosaItakusakiCode")
    public TextBoxCode getTxtChosaItakusakiCode() {
        return txtChosaItakusakiCode;
    }

    /*
     * settxtChosaItakusakiCode
     * @param txtChosaItakusakiCode txtChosaItakusakiCode
     */
    @JsonProperty("txtChosaItakusakiCode")
    public void setTxtChosaItakusakiCode(TextBoxCode txtChosaItakusakiCode) {
        this.txtChosaItakusakiCode = txtChosaItakusakiCode;
    }

    /*
     * gettxtChosaItakusakiName
     * @return txtChosaItakusakiName
     */
    @JsonProperty("txtChosaItakusakiName")
    public TextBox getTxtChosaItakusakiName() {
        return txtChosaItakusakiName;
    }

    /*
     * settxtChosaItakusakiName
     * @param txtChosaItakusakiName txtChosaItakusakiName
     */
    @JsonProperty("txtChosaItakusakiName")
    public void setTxtChosaItakusakiName(TextBox txtChosaItakusakiName) {
        this.txtChosaItakusakiName = txtChosaItakusakiName;
    }

    /*
     * gettxtNinteiChosainCode
     * @return txtNinteiChosainCode
     */
    @JsonProperty("txtNinteiChosainCode")
    public TextBoxCode getTxtNinteiChosainCode() {
        return txtNinteiChosainCode;
    }

    /*
     * settxtNinteiChosainCode
     * @param txtNinteiChosainCode txtNinteiChosainCode
     */
    @JsonProperty("txtNinteiChosainCode")
    public void setTxtNinteiChosainCode(TextBoxCode txtNinteiChosainCode) {
        this.txtNinteiChosainCode = txtNinteiChosainCode;
    }

    /*
     * gettxtNinteiChosainName
     * @return txtNinteiChosainName
     */
    @JsonProperty("txtNinteiChosainName")
    public TextBox getTxtNinteiChosainName() {
        return txtNinteiChosainName;
    }

    /*
     * settxtNinteiChosainName
     * @param txtNinteiChosainName txtNinteiChosainName
     */
    @JsonProperty("txtNinteiChosainName")
    public void setTxtNinteiChosainName(TextBox txtNinteiChosainName) {
        this.txtNinteiChosainName = txtNinteiChosainName;
    }

    // </editor-fold>
}
