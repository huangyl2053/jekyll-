package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0100000;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0100000.KyotakuKeikakuTodokedeHenkoNaiyoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0100000.KyotakuKeikakuTodokedeJigyoshaDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0100000.KyotakuKeikakuTodokedeshaDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KyotakuKeikakuTodokedeMeisai のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyotakuKeikakuTodokedeMeisaiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtTodokedeYMD")
    private TextBoxDate txtTodokedeYMD;
    @JsonProperty("txtTodokedeKubun")
    private TextBox txtTodokedeKubun;
    @JsonProperty("txtTekiyoKikan")
    private TextBoxDateRange txtTekiyoKikan;
    @JsonProperty("txtRirekiListSelectIndex")
    private TextBox txtRirekiListSelectIndex;
    @JsonProperty("KyotakuKeikakuTodokedesha")
    private KyotakuKeikakuTodokedeshaDiv KyotakuKeikakuTodokedesha;
    @JsonProperty("KyotakuKeikakuTodokedeJigyosha")
    private KyotakuKeikakuTodokedeJigyoshaDiv KyotakuKeikakuTodokedeJigyosha;
    @JsonProperty("KyotakuKeikakuTodokedeHenkoNaiyo")
    private KyotakuKeikakuTodokedeHenkoNaiyoDiv KyotakuKeikakuTodokedeHenkoNaiyo;
    @JsonProperty("btnTodokedeDelete")
    private Button btnTodokedeDelete;
    @JsonProperty("btnTodokedeTeisei")
    private Button btnTodokedeTeisei;
    @JsonProperty("btnTodokedeKakutei")
    private Button btnTodokedeKakutei;
    @JsonProperty("btnTodokedeClear")
    private Button btnTodokedeClear;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtTodokedeYMD")
    public TextBoxDate getTxtTodokedeYMD() {
        return txtTodokedeYMD;
    }

    @JsonProperty("txtTodokedeYMD")
    public void setTxtTodokedeYMD(TextBoxDate txtTodokedeYMD) {
        this.txtTodokedeYMD=txtTodokedeYMD;
    }

    @JsonProperty("txtTodokedeKubun")
    public TextBox getTxtTodokedeKubun() {
        return txtTodokedeKubun;
    }

    @JsonProperty("txtTodokedeKubun")
    public void setTxtTodokedeKubun(TextBox txtTodokedeKubun) {
        this.txtTodokedeKubun=txtTodokedeKubun;
    }

    @JsonProperty("txtTekiyoKikan")
    public TextBoxDateRange getTxtTekiyoKikan() {
        return txtTekiyoKikan;
    }

    @JsonProperty("txtTekiyoKikan")
    public void setTxtTekiyoKikan(TextBoxDateRange txtTekiyoKikan) {
        this.txtTekiyoKikan=txtTekiyoKikan;
    }

    @JsonProperty("txtRirekiListSelectIndex")
    public TextBox getTxtRirekiListSelectIndex() {
        return txtRirekiListSelectIndex;
    }

    @JsonProperty("txtRirekiListSelectIndex")
    public void setTxtRirekiListSelectIndex(TextBox txtRirekiListSelectIndex) {
        this.txtRirekiListSelectIndex=txtRirekiListSelectIndex;
    }

    @JsonProperty("KyotakuKeikakuTodokedesha")
    public KyotakuKeikakuTodokedeshaDiv getKyotakuKeikakuTodokedesha() {
        return KyotakuKeikakuTodokedesha;
    }

    @JsonProperty("KyotakuKeikakuTodokedesha")
    public void setKyotakuKeikakuTodokedesha(KyotakuKeikakuTodokedeshaDiv KyotakuKeikakuTodokedesha) {
        this.KyotakuKeikakuTodokedesha=KyotakuKeikakuTodokedesha;
    }

    @JsonProperty("KyotakuKeikakuTodokedeJigyosha")
    public KyotakuKeikakuTodokedeJigyoshaDiv getKyotakuKeikakuTodokedeJigyosha() {
        return KyotakuKeikakuTodokedeJigyosha;
    }

    @JsonProperty("KyotakuKeikakuTodokedeJigyosha")
    public void setKyotakuKeikakuTodokedeJigyosha(KyotakuKeikakuTodokedeJigyoshaDiv KyotakuKeikakuTodokedeJigyosha) {
        this.KyotakuKeikakuTodokedeJigyosha=KyotakuKeikakuTodokedeJigyosha;
    }

    @JsonProperty("KyotakuKeikakuTodokedeHenkoNaiyo")
    public KyotakuKeikakuTodokedeHenkoNaiyoDiv getKyotakuKeikakuTodokedeHenkoNaiyo() {
        return KyotakuKeikakuTodokedeHenkoNaiyo;
    }

    @JsonProperty("KyotakuKeikakuTodokedeHenkoNaiyo")
    public void setKyotakuKeikakuTodokedeHenkoNaiyo(KyotakuKeikakuTodokedeHenkoNaiyoDiv KyotakuKeikakuTodokedeHenkoNaiyo) {
        this.KyotakuKeikakuTodokedeHenkoNaiyo=KyotakuKeikakuTodokedeHenkoNaiyo;
    }

    @JsonProperty("btnTodokedeDelete")
    public Button getBtnTodokedeDelete() {
        return btnTodokedeDelete;
    }

    @JsonProperty("btnTodokedeDelete")
    public void setBtnTodokedeDelete(Button btnTodokedeDelete) {
        this.btnTodokedeDelete=btnTodokedeDelete;
    }

    @JsonProperty("btnTodokedeTeisei")
    public Button getBtnTodokedeTeisei() {
        return btnTodokedeTeisei;
    }

    @JsonProperty("btnTodokedeTeisei")
    public void setBtnTodokedeTeisei(Button btnTodokedeTeisei) {
        this.btnTodokedeTeisei=btnTodokedeTeisei;
    }

    @JsonProperty("btnTodokedeKakutei")
    public Button getBtnTodokedeKakutei() {
        return btnTodokedeKakutei;
    }

    @JsonProperty("btnTodokedeKakutei")
    public void setBtnTodokedeKakutei(Button btnTodokedeKakutei) {
        this.btnTodokedeKakutei=btnTodokedeKakutei;
    }

    @JsonProperty("btnTodokedeClear")
    public Button getBtnTodokedeClear() {
        return btnTodokedeClear;
    }

    @JsonProperty("btnTodokedeClear")
    public void setBtnTodokedeClear(Button btnTodokedeClear) {
        this.btnTodokedeClear=btnTodokedeClear;
    }

}
