package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0810000;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0810000.tabShokanShikyuKetteiShinseishoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ShokanShikyuKetteiShinseisho のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShokanShikyuKetteiShinseishoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShinseiTeikyoYM")
    private TextBoxDate txtShinseiTeikyoYM;
    @JsonProperty("txtShinseiSeiriNo")
    private TextBoxCode txtShinseiSeiriNo;
    @JsonProperty("tabShokanShikyuKetteiShinseisho")
    private tabShokanShikyuKetteiShinseishoDiv tabShokanShikyuKetteiShinseisho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtShinseiTeikyoYM")
    public TextBoxDate getTxtShinseiTeikyoYM() {
        return txtShinseiTeikyoYM;
    }

    @JsonProperty("txtShinseiTeikyoYM")
    public void setTxtShinseiTeikyoYM(TextBoxDate txtShinseiTeikyoYM) {
        this.txtShinseiTeikyoYM=txtShinseiTeikyoYM;
    }

    @JsonProperty("txtShinseiSeiriNo")
    public TextBoxCode getTxtShinseiSeiriNo() {
        return txtShinseiSeiriNo;
    }

    @JsonProperty("txtShinseiSeiriNo")
    public void setTxtShinseiSeiriNo(TextBoxCode txtShinseiSeiriNo) {
        this.txtShinseiSeiriNo=txtShinseiSeiriNo;
    }

    @JsonProperty("tabShokanShikyuKetteiShinseisho")
    public tabShokanShikyuKetteiShinseishoDiv getTabShokanShikyuKetteiShinseisho() {
        return tabShokanShikyuKetteiShinseisho;
    }

    @JsonProperty("tabShokanShikyuKetteiShinseisho")
    public void setTabShokanShikyuKetteiShinseisho(tabShokanShikyuKetteiShinseishoDiv tabShokanShikyuKetteiShinseisho) {
        this.tabShokanShikyuKetteiShinseisho=tabShokanShikyuKetteiShinseisho;
    }

}
