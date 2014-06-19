package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe1010001;
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
 * LatestNinteiResult のクラスファイル 
 * 
 * @author 自動生成
 */
public class LatestNinteiResultDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtYokaigodo")
    private TextBox txtYokaigodo;
    @JsonProperty("txtNinteiDate")
    private TextBoxFlexibleDate txtNinteiDate;
    @JsonProperty("txtNinteiYukokikanFrom")
    private TextBoxFlexibleDate txtNinteiYukokikanFrom;
    @JsonProperty("txtNinteiYukokikanTo")
    private TextBoxFlexibleDate txtNinteiYukokikanTo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtYokaigodo")
    public TextBox getTxtYokaigodo() {
        return txtYokaigodo;
    }

    @JsonProperty("txtYokaigodo")
    public void setTxtYokaigodo(TextBox txtYokaigodo) {
        this.txtYokaigodo=txtYokaigodo;
    }

    @JsonProperty("txtNinteiDate")
    public TextBoxFlexibleDate getTxtNinteiDate() {
        return txtNinteiDate;
    }

    @JsonProperty("txtNinteiDate")
    public void setTxtNinteiDate(TextBoxFlexibleDate txtNinteiDate) {
        this.txtNinteiDate=txtNinteiDate;
    }

    @JsonProperty("txtNinteiYukokikanFrom")
    public TextBoxFlexibleDate getTxtNinteiYukokikanFrom() {
        return txtNinteiYukokikanFrom;
    }

    @JsonProperty("txtNinteiYukokikanFrom")
    public void setTxtNinteiYukokikanFrom(TextBoxFlexibleDate txtNinteiYukokikanFrom) {
        this.txtNinteiYukokikanFrom=txtNinteiYukokikanFrom;
    }

    @JsonProperty("txtNinteiYukokikanTo")
    public TextBoxFlexibleDate getTxtNinteiYukokikanTo() {
        return txtNinteiYukokikanTo;
    }

    @JsonProperty("txtNinteiYukokikanTo")
    public void setTxtNinteiYukokikanTo(TextBoxFlexibleDate txtNinteiYukokikanTo) {
        this.txtNinteiYukokikanTo=txtNinteiYukokikanTo;
    }

}
