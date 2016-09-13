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
    @JsonProperty("KanyuRirekiIchiran")
    private KanyuRirekiIchiranDiv KanyuRirekiIchiran;
    @JsonProperty("KanyuRirekiInput")
    private KanyuRirekiInputDiv KanyuRirekiInput;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKanyuRirekiIchiran
     * @return KanyuRirekiIchiran
     */
    @JsonProperty("KanyuRirekiIchiran")
    public KanyuRirekiIchiranDiv getKanyuRirekiIchiran() {
        return KanyuRirekiIchiran;
    }

    /*
     * setKanyuRirekiIchiran
     * @param KanyuRirekiIchiran KanyuRirekiIchiran
     */
    @JsonProperty("KanyuRirekiIchiran")
    public void setKanyuRirekiIchiran(KanyuRirekiIchiranDiv KanyuRirekiIchiran) {
        this.KanyuRirekiIchiran = KanyuRirekiIchiran;
    }

    /*
     * getKanyuRirekiInput
     * @return KanyuRirekiInput
     */
    @JsonProperty("KanyuRirekiInput")
    public KanyuRirekiInputDiv getKanyuRirekiInput() {
        return KanyuRirekiInput;
    }

    /*
     * setKanyuRirekiInput
     * @param KanyuRirekiInput KanyuRirekiInput
     */
    @JsonProperty("KanyuRirekiInput")
    public void setKanyuRirekiInput(KanyuRirekiInputDiv KanyuRirekiInput) {
        this.KanyuRirekiInput = KanyuRirekiInput;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Button getBtnAddKanyuRireki() {
        return this.getKanyuRirekiIchiran().getBtnAddKanyuRireki();
    }

    @JsonIgnore
    public void setBtnAddKanyuRireki(Button btnAddKanyuRireki) {
        this.getKanyuRirekiIchiran().setBtnAddKanyuRireki(btnAddKanyuRireki);
    }

    @JsonIgnore
    public DataGrid<dgKanyuRirekiIchiran_Row> getDgKanyuRirekiIchiran() {
        return this.getKanyuRirekiIchiran().getDgKanyuRirekiIchiran();
    }

    @JsonIgnore
    public void setDgKanyuRirekiIchiran(DataGrid<dgKanyuRirekiIchiran_Row> dgKanyuRirekiIchiran) {
        this.getKanyuRirekiIchiran().setDgKanyuRirekiIchiran(dgKanyuRirekiIchiran);
    }

    @JsonIgnore
    public TextBox getTxtKanyuRirekiHokenshaMei() {
        return this.getKanyuRirekiInput().getTxtKanyuRirekiHokenshaMei();
    }

    @JsonIgnore
    public void setTxtKanyuRirekiHokenshaMei(TextBox txtKanyuRirekiHokenshaMei) {
        this.getKanyuRirekiInput().setTxtKanyuRirekiHokenshaMei(txtKanyuRirekiHokenshaMei);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKanyuRirekiKanyuKikanYMD() {
        return this.getKanyuRirekiInput().getTxtKanyuRirekiKanyuKikanYMD();
    }

    @JsonIgnore
    public void setTxtKanyuRirekiKanyuKikanYMD(TextBoxDateRange txtKanyuRirekiKanyuKikanYMD) {
        this.getKanyuRirekiInput().setTxtKanyuRirekiKanyuKikanYMD(txtKanyuRirekiKanyuKikanYMD);
    }

    @JsonIgnore
    public TextBox getTxtJikoFutangakuShomeishoSeiriBango() {
        return this.getKanyuRirekiInput().getTxtJikoFutangakuShomeishoSeiriBango();
    }

    @JsonIgnore
    public void setTxtJikoFutangakuShomeishoSeiriBango(TextBox txtJikoFutangakuShomeishoSeiriBango) {
        this.getKanyuRirekiInput().setTxtJikoFutangakuShomeishoSeiriBango(txtJikoFutangakuShomeishoSeiriBango);
    }

    @JsonIgnore
    public Button getBtnKakuteiKanyuRireki() {
        return this.getKanyuRirekiInput().getBtnKakuteiKanyuRireki();
    }

    @JsonIgnore
    public void setBtnKakuteiKanyuRireki(Button btnKakuteiKanyuRireki) {
        this.getKanyuRirekiInput().setBtnKakuteiKanyuRireki(btnKakuteiKanyuRireki);
    }

    @JsonIgnore
    public Button getBtnBackKanyuRirekiIchiran() {
        return this.getKanyuRirekiInput().getBtnBackKanyuRirekiIchiran();
    }

    @JsonIgnore
    public void setBtnBackKanyuRirekiIchiran(Button btnBackKanyuRirekiIchiran) {
        this.getKanyuRirekiInput().setBtnBackKanyuRirekiIchiran(btnBackKanyuRirekiIchiran);
    }

    // </editor-fold>
}
