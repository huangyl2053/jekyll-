package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelPublish;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * YufuriKobetsu のクラスファイル 
 * 
 * @author 自動生成
 */
public class YufuriKobetsuDiv extends PanelPublish {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlYufuriShuturyokuKi")
    private DropDownList ddlYufuriShuturyokuKi;
    @JsonProperty("chkYufuriShuturyokuKi")
    private CheckBoxList chkYufuriShuturyokuKi;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ddlYufuriShuturyokuKi")
    public DropDownList getDdlYufuriShuturyokuKi() {
        return ddlYufuriShuturyokuKi;
    }

    @JsonProperty("ddlYufuriShuturyokuKi")
    public void setDdlYufuriShuturyokuKi(DropDownList ddlYufuriShuturyokuKi) {
        this.ddlYufuriShuturyokuKi=ddlYufuriShuturyokuKi;
    }

    @JsonProperty("chkYufuriShuturyokuKi")
    public CheckBoxList getChkYufuriShuturyokuKi() {
        return chkYufuriShuturyokuKi;
    }

    @JsonProperty("chkYufuriShuturyokuKi")
    public void setChkYufuriShuturyokuKi(CheckBoxList chkYufuriShuturyokuKi) {
        this.chkYufuriShuturyokuKi=chkYufuriShuturyokuKi;
    }

}
