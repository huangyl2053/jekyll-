package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4060001;
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
 * TaishoshaNarabikae のクラスファイル 
 * 
 * @author 自動生成
 */
public class TaishoshaNarabikaeDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlSortKey1")
    private DropDownList ddlSortKey1;
    @JsonProperty("ddlSortKey2")
    private DropDownList ddlSortKey2;
    @JsonProperty("ddlSortKey3")
    private DropDownList ddlSortKey3;
    @JsonProperty("btnCancel")
    private Button btnCancel;
    @JsonProperty("btnJikko")
    private Button btnJikko;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ddlSortKey1")
    public DropDownList getDdlSortKey1() {
        return ddlSortKey1;
    }

    @JsonProperty("ddlSortKey1")
    public void setDdlSortKey1(DropDownList ddlSortKey1) {
        this.ddlSortKey1=ddlSortKey1;
    }

    @JsonProperty("ddlSortKey2")
    public DropDownList getDdlSortKey2() {
        return ddlSortKey2;
    }

    @JsonProperty("ddlSortKey2")
    public void setDdlSortKey2(DropDownList ddlSortKey2) {
        this.ddlSortKey2=ddlSortKey2;
    }

    @JsonProperty("ddlSortKey3")
    public DropDownList getDdlSortKey3() {
        return ddlSortKey3;
    }

    @JsonProperty("ddlSortKey3")
    public void setDdlSortKey3(DropDownList ddlSortKey3) {
        this.ddlSortKey3=ddlSortKey3;
    }

    @JsonProperty("btnCancel")
    public Button getBtnCancel() {
        return btnCancel;
    }

    @JsonProperty("btnCancel")
    public void setBtnCancel(Button btnCancel) {
        this.btnCancel=btnCancel;
    }

    @JsonProperty("btnJikko")
    public Button getBtnJikko() {
        return btnJikko;
    }

    @JsonProperty("btnJikko")
    public void setBtnJikko(Button btnJikko) {
        this.btnJikko=btnJikko;
    }

}
