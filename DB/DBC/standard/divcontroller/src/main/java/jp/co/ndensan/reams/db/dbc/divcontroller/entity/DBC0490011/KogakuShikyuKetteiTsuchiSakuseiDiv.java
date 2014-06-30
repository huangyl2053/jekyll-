package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0490011;
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
 * KogakuShikyuKetteiTsuchiSakusei のクラスファイル 
 * 
 * @author 自動生成
 */
public class KogakuShikyuKetteiTsuchiSakuseiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKetteiYM")
    private TextBoxDate txtKetteiYM;
    @JsonProperty("txtTsuchiSotatsuYMD")
    private TextBoxDate txtTsuchiSotatsuYMD;
    @JsonProperty("chkOutputTargetKubun")
    private CheckBoxList chkOutputTargetKubun;
    @JsonProperty("KogakuShikyuKetteiTsuchiSakuseiListPanel")
    private KogakuShikyuKetteiTsuchiSakuseiListPanelDiv KogakuShikyuKetteiTsuchiSakuseiListPanel;
    @JsonProperty("KogakuShikyuKetteiTsuchiSakuseishoPanel")
    private KogakuShikyuKetteiTsuchiSakuseishoPanelDiv KogakuShikyuKetteiTsuchiSakuseishoPanel;
    @JsonProperty("btnCreate")
    private Button btnCreate;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtKetteiYM")
    public TextBoxDate getTxtKetteiYM() {
        return txtKetteiYM;
    }

    @JsonProperty("txtKetteiYM")
    public void setTxtKetteiYM(TextBoxDate txtKetteiYM) {
        this.txtKetteiYM=txtKetteiYM;
    }

    @JsonProperty("txtTsuchiSotatsuYMD")
    public TextBoxDate getTxtTsuchiSotatsuYMD() {
        return txtTsuchiSotatsuYMD;
    }

    @JsonProperty("txtTsuchiSotatsuYMD")
    public void setTxtTsuchiSotatsuYMD(TextBoxDate txtTsuchiSotatsuYMD) {
        this.txtTsuchiSotatsuYMD=txtTsuchiSotatsuYMD;
    }

    @JsonProperty("chkOutputTargetKubun")
    public CheckBoxList getChkOutputTargetKubun() {
        return chkOutputTargetKubun;
    }

    @JsonProperty("chkOutputTargetKubun")
    public void setChkOutputTargetKubun(CheckBoxList chkOutputTargetKubun) {
        this.chkOutputTargetKubun=chkOutputTargetKubun;
    }

    @JsonProperty("KogakuShikyuKetteiTsuchiSakuseiListPanel")
    public KogakuShikyuKetteiTsuchiSakuseiListPanelDiv getKogakuShikyuKetteiTsuchiSakuseiListPanel() {
        return KogakuShikyuKetteiTsuchiSakuseiListPanel;
    }

    @JsonProperty("KogakuShikyuKetteiTsuchiSakuseiListPanel")
    public void setKogakuShikyuKetteiTsuchiSakuseiListPanel(KogakuShikyuKetteiTsuchiSakuseiListPanelDiv KogakuShikyuKetteiTsuchiSakuseiListPanel) {
        this.KogakuShikyuKetteiTsuchiSakuseiListPanel=KogakuShikyuKetteiTsuchiSakuseiListPanel;
    }

    @JsonProperty("KogakuShikyuKetteiTsuchiSakuseishoPanel")
    public KogakuShikyuKetteiTsuchiSakuseishoPanelDiv getKogakuShikyuKetteiTsuchiSakuseishoPanel() {
        return KogakuShikyuKetteiTsuchiSakuseishoPanel;
    }

    @JsonProperty("KogakuShikyuKetteiTsuchiSakuseishoPanel")
    public void setKogakuShikyuKetteiTsuchiSakuseishoPanel(KogakuShikyuKetteiTsuchiSakuseishoPanelDiv KogakuShikyuKetteiTsuchiSakuseishoPanel) {
        this.KogakuShikyuKetteiTsuchiSakuseishoPanel=KogakuShikyuKetteiTsuchiSakuseishoPanel;
    }

    @JsonProperty("btnCreate")
    public Button getBtnCreate() {
        return btnCreate;
    }

    @JsonProperty("btnCreate")
    public void setBtnCreate(Button btnCreate) {
        this.btnCreate=btnCreate;
    }

}
