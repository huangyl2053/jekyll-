package jp.co.ndensan.reams.db.dbz.divcontroller.entity.NinteiInput;
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
 * IchigoHantei のクラスファイル 
 * 
 * @author 自動生成
 */
public class IchigoHanteiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlIchigoHanteiYokaigodo")
    private DropDownList ddlIchigoHanteiYokaigodo;
    @JsonProperty("txtIchigoHanteiDay")
    private TextBoxDate txtIchigoHanteiDay;
    @JsonProperty("ddlNinchishoKasangoIchigoHanteiYokaigodo")
    private DropDownList ddlNinchishoKasangoIchigoHanteiYokaigodo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ddlIchigoHanteiYokaigodo")
    public DropDownList getDdlIchigoHanteiYokaigodo() {
        return ddlIchigoHanteiYokaigodo;
    }

    @JsonProperty("ddlIchigoHanteiYokaigodo")
    public void setDdlIchigoHanteiYokaigodo(DropDownList ddlIchigoHanteiYokaigodo) {
        this.ddlIchigoHanteiYokaigodo=ddlIchigoHanteiYokaigodo;
    }

    @JsonProperty("txtIchigoHanteiDay")
    public TextBoxDate getTxtIchigoHanteiDay() {
        return txtIchigoHanteiDay;
    }

    @JsonProperty("txtIchigoHanteiDay")
    public void setTxtIchigoHanteiDay(TextBoxDate txtIchigoHanteiDay) {
        this.txtIchigoHanteiDay=txtIchigoHanteiDay;
    }

    @JsonProperty("ddlNinchishoKasangoIchigoHanteiYokaigodo")
    public DropDownList getDdlNinchishoKasangoIchigoHanteiYokaigodo() {
        return ddlNinchishoKasangoIchigoHanteiYokaigodo;
    }

    @JsonProperty("ddlNinchishoKasangoIchigoHanteiYokaigodo")
    public void setDdlNinchishoKasangoIchigoHanteiYokaigodo(DropDownList ddlNinchishoKasangoIchigoHanteiYokaigodo) {
        this.ddlNinchishoKasangoIchigoHanteiYokaigodo=ddlNinchishoKasangoIchigoHanteiYokaigodo;
    }

}
