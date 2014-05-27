package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.tabShokanShikyuTorokuShinseishoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ShokanShikyuTorokuShinseisho のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShokanShikyuTorokuShinseishoDiv extends Panel {
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
    @JsonProperty("txtShinseiInputKubun")
    private TextBox txtShinseiInputKubun;
    @JsonProperty("tabShokanShikyuTorokuShinseisho")
    private tabShokanShikyuTorokuShinseishoDiv tabShokanShikyuTorokuShinseisho;

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

    @JsonProperty("txtShinseiInputKubun")
    public TextBox getTxtShinseiInputKubun() {
        return txtShinseiInputKubun;
    }

    @JsonProperty("txtShinseiInputKubun")
    public void setTxtShinseiInputKubun(TextBox txtShinseiInputKubun) {
        this.txtShinseiInputKubun=txtShinseiInputKubun;
    }

    @JsonProperty("tabShokanShikyuTorokuShinseisho")
    public tabShokanShikyuTorokuShinseishoDiv getTabShokanShikyuTorokuShinseisho() {
        return tabShokanShikyuTorokuShinseisho;
    }

    @JsonProperty("tabShokanShikyuTorokuShinseisho")
    public void setTabShokanShikyuTorokuShinseisho(tabShokanShikyuTorokuShinseishoDiv tabShokanShikyuTorokuShinseisho) {
        this.tabShokanShikyuTorokuShinseisho=tabShokanShikyuTorokuShinseisho;
    }

}
