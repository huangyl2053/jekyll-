package jp.co.ndensan.reams.db.dba.divcontroller.entity.dba203001t;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba203001t.tabInputsDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TaskJutokuTekiyoJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class TaskJutokuTekiyoJohoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tabInputs")
    private tabInputsDiv tabInputs;
    @JsonProperty("shikakuInputMode")
    private RString shikakuInputMode;
    @JsonProperty("iryoHokenInputMode")
    private RString iryoHokenInputMode;
    @JsonProperty("shikakuSelectRow")
    private RString shikakuSelectRow;
    @JsonProperty("iryoHokenSelectRow")
    private RString iryoHokenSelectRow;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("tabInputs")
    public tabInputsDiv getTabInputs() {
        return tabInputs;
    }

    @JsonProperty("tabInputs")
    public void setTabInputs(tabInputsDiv tabInputs) {
        this.tabInputs=tabInputs;
    }

    @JsonProperty("shikakuInputMode")
    public RString getShikakuInputMode() {
        return shikakuInputMode;
    }

    @JsonProperty("shikakuInputMode")
    public void setShikakuInputMode(RString shikakuInputMode) {
        this.shikakuInputMode=shikakuInputMode;
    }

    @JsonProperty("iryoHokenInputMode")
    public RString getIryoHokenInputMode() {
        return iryoHokenInputMode;
    }

    @JsonProperty("iryoHokenInputMode")
    public void setIryoHokenInputMode(RString iryoHokenInputMode) {
        this.iryoHokenInputMode=iryoHokenInputMode;
    }

    @JsonProperty("shikakuSelectRow")
    public RString getShikakuSelectRow() {
        return shikakuSelectRow;
    }

    @JsonProperty("shikakuSelectRow")
    public void setShikakuSelectRow(RString shikakuSelectRow) {
        this.shikakuSelectRow=shikakuSelectRow;
    }

    @JsonProperty("iryoHokenSelectRow")
    public RString getIryoHokenSelectRow() {
        return iryoHokenSelectRow;
    }

    @JsonProperty("iryoHokenSelectRow")
    public void setIryoHokenSelectRow(RString iryoHokenSelectRow) {
        this.iryoHokenSelectRow=iryoHokenSelectRow;
    }

}
