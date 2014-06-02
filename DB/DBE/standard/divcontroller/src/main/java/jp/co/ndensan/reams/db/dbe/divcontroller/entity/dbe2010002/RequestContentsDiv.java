package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010002;
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
 * RequestContents のクラスファイル 
 * 
 * @author 自動生成
 */
public class RequestContentsDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlIraiKubun")
    private DropDownList ddlIraiKubun;
    @JsonProperty("txtChosaIraiDate")
    private TextBoxFlexibleDate txtChosaIraiDate;
    @JsonProperty("txtChosaKigenDate")
    private TextBoxFlexibleDate txtChosaKigenDate;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ddlIraiKubun")
    public DropDownList getDdlIraiKubun() {
        return ddlIraiKubun;
    }

    @JsonProperty("ddlIraiKubun")
    public void setDdlIraiKubun(DropDownList ddlIraiKubun) {
        this.ddlIraiKubun=ddlIraiKubun;
    }

    @JsonProperty("txtChosaIraiDate")
    public TextBoxFlexibleDate getTxtChosaIraiDate() {
        return txtChosaIraiDate;
    }

    @JsonProperty("txtChosaIraiDate")
    public void setTxtChosaIraiDate(TextBoxFlexibleDate txtChosaIraiDate) {
        this.txtChosaIraiDate=txtChosaIraiDate;
    }

    @JsonProperty("txtChosaKigenDate")
    public TextBoxFlexibleDate getTxtChosaKigenDate() {
        return txtChosaKigenDate;
    }

    @JsonProperty("txtChosaKigenDate")
    public void setTxtChosaKigenDate(TextBoxFlexibleDate txtChosaKigenDate) {
        this.txtChosaKigenDate=txtChosaKigenDate;
    }

}
