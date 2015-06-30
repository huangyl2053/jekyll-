package jp.co.ndensan.reams.db.dbe.divcontroller.entity.DBE2020009;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * PrintConditionPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class PrintConditionPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-47">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlTaishoShichoson")
    private DropDownList ddlTaishoShichoson;
    @JsonProperty("txtNinteiChosaYoteiYMD")
    private TextBoxDateRange txtNinteiChosaYoteiYMD;
    @JsonProperty("ddlTaishoNinteiChosainShozokuKikan")
    private DropDownList ddlTaishoNinteiChosainShozokuKikan;
    @JsonProperty("ddlTaishoNinteiChosain")
    private DropDownList ddlTaishoNinteiChosain;
    @JsonProperty("radJokyo")
    private RadioButton radJokyo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ddlTaishoShichoson")
    public DropDownList getDdlTaishoShichoson() {
        return ddlTaishoShichoson;
    }

    @JsonProperty("ddlTaishoShichoson")
    public void setDdlTaishoShichoson(DropDownList ddlTaishoShichoson) {
        this.ddlTaishoShichoson=ddlTaishoShichoson;
    }

    @JsonProperty("txtNinteiChosaYoteiYMD")
    public TextBoxDateRange getTxtNinteiChosaYoteiYMD() {
        return txtNinteiChosaYoteiYMD;
    }

    @JsonProperty("txtNinteiChosaYoteiYMD")
    public void setTxtNinteiChosaYoteiYMD(TextBoxDateRange txtNinteiChosaYoteiYMD) {
        this.txtNinteiChosaYoteiYMD=txtNinteiChosaYoteiYMD;
    }

    @JsonProperty("ddlTaishoNinteiChosainShozokuKikan")
    public DropDownList getDdlTaishoNinteiChosainShozokuKikan() {
        return ddlTaishoNinteiChosainShozokuKikan;
    }

    @JsonProperty("ddlTaishoNinteiChosainShozokuKikan")
    public void setDdlTaishoNinteiChosainShozokuKikan(DropDownList ddlTaishoNinteiChosainShozokuKikan) {
        this.ddlTaishoNinteiChosainShozokuKikan=ddlTaishoNinteiChosainShozokuKikan;
    }

    @JsonProperty("ddlTaishoNinteiChosain")
    public DropDownList getDdlTaishoNinteiChosain() {
        return ddlTaishoNinteiChosain;
    }

    @JsonProperty("ddlTaishoNinteiChosain")
    public void setDdlTaishoNinteiChosain(DropDownList ddlTaishoNinteiChosain) {
        this.ddlTaishoNinteiChosain=ddlTaishoNinteiChosain;
    }

    @JsonProperty("radJokyo")
    public RadioButton getRadJokyo() {
        return radJokyo;
    }

    @JsonProperty("radJokyo")
    public void setRadJokyo(RadioButton radJokyo) {
        this.radJokyo=radJokyo;
    }

    // </editor-fold>
}
