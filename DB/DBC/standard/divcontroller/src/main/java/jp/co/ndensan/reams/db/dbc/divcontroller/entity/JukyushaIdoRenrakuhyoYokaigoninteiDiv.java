package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
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
 * JukyushaIdoRenrakuhyoYokaigonintei のクラスファイル 
 * 
 * @author 自動生成
 */
public class JukyushaIdoRenrakuhyoYokaigoninteiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radShinseiType")
    private RadioButton radShinseiType;
    @JsonProperty("radHenkoShinseichuKubun")
    private RadioButton radHenkoShinseichuKubun;
    @JsonProperty("txtShinseiDate")
    private TextBoxFlexibleDate txtShinseiDate;
    @JsonProperty("radMinashiYokaigoKubun")
    private RadioButton radMinashiYokaigoKubun;
    @JsonProperty("ddlYokaigoJotaiKubun")
    private DropDownList ddlYokaigoJotaiKubun;
    @JsonProperty("txtNinteiDateRange")
    private TextBoxDateRange txtNinteiDateRange;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("radShinseiType")
    public RadioButton getRadShinseiType() {
        return radShinseiType;
    }

    @JsonProperty("radShinseiType")
    public void setRadShinseiType(RadioButton radShinseiType) {
        this.radShinseiType=radShinseiType;
    }

    @JsonProperty("radHenkoShinseichuKubun")
    public RadioButton getRadHenkoShinseichuKubun() {
        return radHenkoShinseichuKubun;
    }

    @JsonProperty("radHenkoShinseichuKubun")
    public void setRadHenkoShinseichuKubun(RadioButton radHenkoShinseichuKubun) {
        this.radHenkoShinseichuKubun=radHenkoShinseichuKubun;
    }

    @JsonProperty("txtShinseiDate")
    public TextBoxFlexibleDate getTxtShinseiDate() {
        return txtShinseiDate;
    }

    @JsonProperty("txtShinseiDate")
    public void setTxtShinseiDate(TextBoxFlexibleDate txtShinseiDate) {
        this.txtShinseiDate=txtShinseiDate;
    }

    @JsonProperty("radMinashiYokaigoKubun")
    public RadioButton getRadMinashiYokaigoKubun() {
        return radMinashiYokaigoKubun;
    }

    @JsonProperty("radMinashiYokaigoKubun")
    public void setRadMinashiYokaigoKubun(RadioButton radMinashiYokaigoKubun) {
        this.radMinashiYokaigoKubun=radMinashiYokaigoKubun;
    }

    @JsonProperty("ddlYokaigoJotaiKubun")
    public DropDownList getDdlYokaigoJotaiKubun() {
        return ddlYokaigoJotaiKubun;
    }

    @JsonProperty("ddlYokaigoJotaiKubun")
    public void setDdlYokaigoJotaiKubun(DropDownList ddlYokaigoJotaiKubun) {
        this.ddlYokaigoJotaiKubun=ddlYokaigoJotaiKubun;
    }

    @JsonProperty("txtNinteiDateRange")
    public TextBoxDateRange getTxtNinteiDateRange() {
        return txtNinteiDateRange;
    }

    @JsonProperty("txtNinteiDateRange")
    public void setTxtNinteiDateRange(TextBoxDateRange txtNinteiDateRange) {
        this.txtNinteiDateRange=txtNinteiDateRange;
    }

}
