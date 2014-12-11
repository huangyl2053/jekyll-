package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KashitsukekinHenkoKariukeDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KashitsukekinHenkoKetteiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * tplKashitsukekinHenko のクラスファイル 
 * 
 * @author 自動生成
 */
public class tplKashitsukekinHenkoDiv extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtEnchoShinseiYMD")
    private TextBoxDate txtEnchoShinseiYMD;
    @JsonProperty("txtEnchoKikan")
    private TextBoxDateRange txtEnchoKikan;
    @JsonProperty("txtMishokanKingaku")
    private TextBoxNum txtMishokanKingaku;
    @JsonProperty("txtEnchoRiyu")
    private TextBox txtEnchoRiyu;
    @JsonProperty("KashitsukekinHenkoKariuke")
    private KashitsukekinHenkoKariukeDiv KashitsukekinHenkoKariuke;
    @JsonProperty("KashitsukekinHenkoKettei")
    private KashitsukekinHenkoKetteiDiv KashitsukekinHenkoKettei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtEnchoShinseiYMD")
    public TextBoxDate getTxtEnchoShinseiYMD() {
        return txtEnchoShinseiYMD;
    }

    @JsonProperty("txtEnchoShinseiYMD")
    public void setTxtEnchoShinseiYMD(TextBoxDate txtEnchoShinseiYMD) {
        this.txtEnchoShinseiYMD=txtEnchoShinseiYMD;
    }

    @JsonProperty("txtEnchoKikan")
    public TextBoxDateRange getTxtEnchoKikan() {
        return txtEnchoKikan;
    }

    @JsonProperty("txtEnchoKikan")
    public void setTxtEnchoKikan(TextBoxDateRange txtEnchoKikan) {
        this.txtEnchoKikan=txtEnchoKikan;
    }

    @JsonProperty("txtMishokanKingaku")
    public TextBoxNum getTxtMishokanKingaku() {
        return txtMishokanKingaku;
    }

    @JsonProperty("txtMishokanKingaku")
    public void setTxtMishokanKingaku(TextBoxNum txtMishokanKingaku) {
        this.txtMishokanKingaku=txtMishokanKingaku;
    }

    @JsonProperty("txtEnchoRiyu")
    public TextBox getTxtEnchoRiyu() {
        return txtEnchoRiyu;
    }

    @JsonProperty("txtEnchoRiyu")
    public void setTxtEnchoRiyu(TextBox txtEnchoRiyu) {
        this.txtEnchoRiyu=txtEnchoRiyu;
    }

    @JsonProperty("KashitsukekinHenkoKariuke")
    public KashitsukekinHenkoKariukeDiv getKashitsukekinHenkoKariuke() {
        return KashitsukekinHenkoKariuke;
    }

    @JsonProperty("KashitsukekinHenkoKariuke")
    public void setKashitsukekinHenkoKariuke(KashitsukekinHenkoKariukeDiv KashitsukekinHenkoKariuke) {
        this.KashitsukekinHenkoKariuke=KashitsukekinHenkoKariuke;
    }

    @JsonProperty("KashitsukekinHenkoKettei")
    public KashitsukekinHenkoKetteiDiv getKashitsukekinHenkoKettei() {
        return KashitsukekinHenkoKettei;
    }

    @JsonProperty("KashitsukekinHenkoKettei")
    public void setKashitsukekinHenkoKettei(KashitsukekinHenkoKetteiDiv KashitsukekinHenkoKettei) {
        this.KashitsukekinHenkoKettei=KashitsukekinHenkoKettei;
    }

}
