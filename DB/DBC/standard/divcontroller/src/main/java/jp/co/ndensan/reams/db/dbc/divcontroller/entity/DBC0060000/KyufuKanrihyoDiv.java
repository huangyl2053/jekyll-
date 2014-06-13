package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0060000;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyufuKanrihyoInfo.KyufuKanrihyoInfoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KyufuKanrihyo のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyufuKanrihyoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtTaishoYM")
    private TextBoxDate txtTaishoYM;
    @JsonProperty("txtKaigoJotai")
    private TextBox txtKaigoJotai;
    @JsonProperty("txtHokenshaNo")
    private TextBoxCode txtHokenshaNo;
    @JsonProperty("txtShinsaYM")
    private TextBoxDate txtShinsaYM;
    @JsonProperty("tabKyufuKanrihyo")
    private tabKyufuKanrihyoDiv tabKyufuKanrihyo;
    @JsonProperty("KyufuKanrihyoInfoKyotaku")
    private KyufuKanrihyoInfoDiv KyufuKanrihyoInfoKyotaku;
    @JsonProperty("btnReturn")
    private Button btnReturn;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtTaishoYM")
    public TextBoxDate getTxtTaishoYM() {
        return txtTaishoYM;
    }

    @JsonProperty("txtTaishoYM")
    public void setTxtTaishoYM(TextBoxDate txtTaishoYM) {
        this.txtTaishoYM=txtTaishoYM;
    }

    @JsonProperty("txtKaigoJotai")
    public TextBox getTxtKaigoJotai() {
        return txtKaigoJotai;
    }

    @JsonProperty("txtKaigoJotai")
    public void setTxtKaigoJotai(TextBox txtKaigoJotai) {
        this.txtKaigoJotai=txtKaigoJotai;
    }

    @JsonProperty("txtHokenshaNo")
    public TextBoxCode getTxtHokenshaNo() {
        return txtHokenshaNo;
    }

    @JsonProperty("txtHokenshaNo")
    public void setTxtHokenshaNo(TextBoxCode txtHokenshaNo) {
        this.txtHokenshaNo=txtHokenshaNo;
    }

    @JsonProperty("txtShinsaYM")
    public TextBoxDate getTxtShinsaYM() {
        return txtShinsaYM;
    }

    @JsonProperty("txtShinsaYM")
    public void setTxtShinsaYM(TextBoxDate txtShinsaYM) {
        this.txtShinsaYM=txtShinsaYM;
    }

    @JsonProperty("tabKyufuKanrihyo")
    public tabKyufuKanrihyoDiv getTabKyufuKanrihyo() {
        return tabKyufuKanrihyo;
    }

    @JsonProperty("tabKyufuKanrihyo")
    public void setTabKyufuKanrihyo(tabKyufuKanrihyoDiv tabKyufuKanrihyo) {
        this.tabKyufuKanrihyo=tabKyufuKanrihyo;
    }

    @JsonProperty("KyufuKanrihyoInfoKyotaku")
    public KyufuKanrihyoInfoDiv getKyufuKanrihyoInfoKyotaku() {
        return KyufuKanrihyoInfoKyotaku;
    }

    @JsonProperty("KyufuKanrihyoInfoKyotaku")
    public void setKyufuKanrihyoInfoKyotaku(KyufuKanrihyoInfoDiv KyufuKanrihyoInfoKyotaku) {
        this.KyufuKanrihyoInfoKyotaku=KyufuKanrihyoInfoKyotaku;
    }

    @JsonProperty("btnReturn")
    public Button getBtnReturn() {
        return btnReturn;
    }

    @JsonProperty("btnReturn")
    public void setBtnReturn(Button btnReturn) {
        this.btnReturn=btnReturn;
    }

}
