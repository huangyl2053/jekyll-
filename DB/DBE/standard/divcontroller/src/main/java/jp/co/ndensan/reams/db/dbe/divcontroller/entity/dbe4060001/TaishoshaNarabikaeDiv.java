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
    @JsonProperty("ddlSortKomoku1")
    private DropDownList ddlSortKomoku1;
    @JsonProperty("ddlSortKomoku2")
    private DropDownList ddlSortKomoku2;
    @JsonProperty("ddlSortKomoku3")
    private DropDownList ddlSortKomoku3;
    @JsonProperty("btnJikko")
    private Button btnJikko;
    @JsonProperty("btnCancel")
    private Button btnCancel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ddlSortKomoku1")
    public DropDownList getDdlSortKomoku1() {
        return ddlSortKomoku1;
    }

    @JsonProperty("ddlSortKomoku1")
    public void setDdlSortKomoku1(DropDownList ddlSortKomoku1) {
        this.ddlSortKomoku1=ddlSortKomoku1;
    }

    @JsonProperty("ddlSortKomoku2")
    public DropDownList getDdlSortKomoku2() {
        return ddlSortKomoku2;
    }

    @JsonProperty("ddlSortKomoku2")
    public void setDdlSortKomoku2(DropDownList ddlSortKomoku2) {
        this.ddlSortKomoku2=ddlSortKomoku2;
    }

    @JsonProperty("ddlSortKomoku3")
    public DropDownList getDdlSortKomoku3() {
        return ddlSortKomoku3;
    }

    @JsonProperty("ddlSortKomoku3")
    public void setDdlSortKomoku3(DropDownList ddlSortKomoku3) {
        this.ddlSortKomoku3=ddlSortKomoku3;
    }

    @JsonProperty("btnJikko")
    public Button getBtnJikko() {
        return btnJikko;
    }

    @JsonProperty("btnJikko")
    public void setBtnJikko(Button btnJikko) {
        this.btnJikko=btnJikko;
    }

    @JsonProperty("btnCancel")
    public Button getBtnCancel() {
        return btnCancel;
    }

    @JsonProperty("btnCancel")
    public void setBtnCancel(Button btnCancel) {
        this.btnCancel=btnCancel;
    }

}
