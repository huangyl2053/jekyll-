package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1100011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;

/**
 * tabShinseiTorokuPanel4 のクラスファイル
 *
 * @reamsid_L DBC-2040-030 huzongcheng
 */
public class tabShinseiTorokuPanel4Div extends TabPanel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("TorokuKanyRirekiuListPanel")
    private TorokuKanyRirekiuListPanelDiv TorokuKanyRirekiuListPanel;
    @JsonProperty("KanyuInfoPanel")
    private KanyuInfoPanelDiv KanyuInfoPanel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getTorokuKanyRirekiuListPanel
     * @return TorokuKanyRirekiuListPanel
     */
    @JsonProperty("TorokuKanyRirekiuListPanel")
    public TorokuKanyRirekiuListPanelDiv getTorokuKanyRirekiuListPanel() {
        return TorokuKanyRirekiuListPanel;
    }

    /*
     * setTorokuKanyRirekiuListPanel
     * @param TorokuKanyRirekiuListPanel TorokuKanyRirekiuListPanel
     */
    @JsonProperty("TorokuKanyRirekiuListPanel")
    public void setTorokuKanyRirekiuListPanel(TorokuKanyRirekiuListPanelDiv TorokuKanyRirekiuListPanel) {
        this.TorokuKanyRirekiuListPanel = TorokuKanyRirekiuListPanel;
    }

    /*
     * getKanyuInfoPanel
     * @return KanyuInfoPanel
     */
    @JsonProperty("KanyuInfoPanel")
    public KanyuInfoPanelDiv getKanyuInfoPanel() {
        return KanyuInfoPanel;
    }

    /*
     * setKanyuInfoPanel
     * @param KanyuInfoPanel KanyuInfoPanel
     */
    @JsonProperty("KanyuInfoPanel")
    public void setKanyuInfoPanel(KanyuInfoPanelDiv KanyuInfoPanel) {
        this.KanyuInfoPanel = KanyuInfoPanel;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Button getBtnKanyuJohoTsuika() {
        return this.getTorokuKanyRirekiuListPanel().getBtnKanyuJohoTsuika();
    }

    @JsonIgnore
    public void setBtnKanyuJohoTsuika(Button btnKanyuJohoTsuika) {
        this.getTorokuKanyRirekiuListPanel().setBtnKanyuJohoTsuika(btnKanyuJohoTsuika);
    }

    @JsonIgnore
    public DataGrid<dgTorokuKanyRirekiuList_Row> getDgTorokuKanyRirekiuList() {
        return this.getTorokuKanyRirekiuListPanel().getDgTorokuKanyRirekiuList();
    }

    @JsonIgnore
    public void setDgTorokuKanyRirekiuList(DataGrid<dgTorokuKanyRirekiuList_Row> dgTorokuKanyRirekiuList) {
        this.getTorokuKanyRirekiuListPanel().setDgTorokuKanyRirekiuList(dgTorokuKanyRirekiuList);
    }

    @JsonIgnore
    public TextBox getTxtKanyuInfoHokensyaMei() {
        return this.getKanyuInfoPanel().getTxtKanyuInfoHokensyaMei();
    }

    @JsonIgnore
    public void setTxtKanyuInfoHokensyaMei(TextBox txtKanyuInfoHokensyaMei) {
        this.getKanyuInfoPanel().setTxtKanyuInfoHokensyaMei(txtKanyuInfoHokensyaMei);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKanyuInfoKanyuKikanYMD() {
        return this.getKanyuInfoPanel().getTxtKanyuInfoKanyuKikanYMD();
    }

    @JsonIgnore
    public void setTxtKanyuInfoKanyuKikanYMD(TextBoxDateRange txtKanyuInfoKanyuKikanYMD) {
        this.getKanyuInfoPanel().setTxtKanyuInfoKanyuKikanYMD(txtKanyuInfoKanyuKikanYMD);
    }

    @JsonIgnore
    public TextBox getTxtJikoFutangakuShomeishoSeiriBango() {
        return this.getKanyuInfoPanel().getTxtJikoFutangakuShomeishoSeiriBango();
    }

    @JsonIgnore
    public void setTxtJikoFutangakuShomeishoSeiriBango(TextBox txtJikoFutangakuShomeishoSeiriBango) {
        this.getKanyuInfoPanel().setTxtJikoFutangakuShomeishoSeiriBango(txtJikoFutangakuShomeishoSeiriBango);
    }

    @JsonIgnore
    public Button getBtnKanyuRirekKakutei() {
        return this.getKanyuInfoPanel().getBtnKanyuRirekKakutei();
    }

    @JsonIgnore
    public void setBtnKanyuRirekKakutei(Button btnKanyuRirekKakutei) {
        this.getKanyuInfoPanel().setBtnKanyuRirekKakutei(btnKanyuRirekKakutei);
    }

    @JsonIgnore
    public Button getBtnKanyuRirekiModoru() {
        return this.getKanyuInfoPanel().getBtnKanyuRirekiModoru();
    }

    @JsonIgnore
    public void setBtnKanyuRirekiModoru(Button btnKanyuRirekiModoru) {
        this.getKanyuInfoPanel().setBtnKanyuRirekiModoru(btnKanyuRirekiModoru);
    }

    // </editor-fold>
}
