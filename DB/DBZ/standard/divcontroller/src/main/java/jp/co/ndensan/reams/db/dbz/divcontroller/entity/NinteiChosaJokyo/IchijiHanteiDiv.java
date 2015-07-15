package jp.co.ndensan.reams.db.dbz.divcontroller.entity.NinteiChosaJokyo;
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
 * IchijiHantei のクラスファイル 
 * 
 * @author 自動生成
 */
public class IchijiHanteiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlYokaigodo")
    private DropDownList ddlYokaigodo;
    @JsonProperty("txtIchijiHanteiDay")
    private TextBoxDate txtIchijiHanteiDay;
    @JsonProperty("ddlNinchishoKasangoYokaigodo")
    private DropDownList ddlNinchishoKasangoYokaigodo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ddlYokaigodo")
    public DropDownList getDdlYokaigodo() {
        return ddlYokaigodo;
    }

    @JsonProperty("ddlYokaigodo")
    public void setDdlYokaigodo(DropDownList ddlYokaigodo) {
        this.ddlYokaigodo=ddlYokaigodo;
    }

    @JsonProperty("txtIchijiHanteiDay")
    public TextBoxDate getTxtIchijiHanteiDay() {
        return txtIchijiHanteiDay;
    }

    @JsonProperty("txtIchijiHanteiDay")
    public void setTxtIchijiHanteiDay(TextBoxDate txtIchijiHanteiDay) {
        this.txtIchijiHanteiDay=txtIchijiHanteiDay;
    }

    @JsonProperty("ddlNinchishoKasangoYokaigodo")
    public DropDownList getDdlNinchishoKasangoYokaigodo() {
        return ddlNinchishoKasangoYokaigodo;
    }

    @JsonProperty("ddlNinchishoKasangoYokaigodo")
    public void setDdlNinchishoKasangoYokaigodo(DropDownList ddlNinchishoKasangoYokaigodo) {
        this.ddlNinchishoKasangoYokaigodo=ddlNinchishoKasangoYokaigodo;
    }

}
