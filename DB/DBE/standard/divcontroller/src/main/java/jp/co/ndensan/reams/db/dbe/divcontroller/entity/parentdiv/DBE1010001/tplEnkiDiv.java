package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1010001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * tplEnki のクラスファイル 
 * 
 * @author 自動生成
 */
public class tplEnkiDiv extends TabPanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-31_08-44-29">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtEnkiKetteiYMD")
    private TextBoxDate txtEnkiKetteiYMD;
    @JsonProperty("txtEnkiMikomiKikan")
    private TextBoxDateRange txtEnkiMikomiKikan;
    @JsonProperty("lblEnkiRiyu")
    private Label lblEnkiRiyu;
    @JsonProperty("btnEnkiRiyuTeikeibun")
    private ButtonDialog btnEnkiRiyuTeikeibun;
    @JsonProperty("txtEnkiRiyu")
    private TextBoxMultiLine txtEnkiRiyu;
    @JsonProperty("txtEnkiTsuchiHakkoYMD")
    private TextBoxDate txtEnkiTsuchiHakkoYMD;
    @JsonProperty("txtEnkiTsuchishoHakkoCount")
    private TextBoxNum txtEnkiTsuchishoHakkoCount;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtEnkiKetteiYMD
     * @return txtEnkiKetteiYMD
     */
    @JsonProperty("txtEnkiKetteiYMD")
    public TextBoxDate getTxtEnkiKetteiYMD() {
        return txtEnkiKetteiYMD;
    }

    /*
     * settxtEnkiKetteiYMD
     * @param txtEnkiKetteiYMD txtEnkiKetteiYMD
     */
    @JsonProperty("txtEnkiKetteiYMD")
    public void setTxtEnkiKetteiYMD(TextBoxDate txtEnkiKetteiYMD) {
        this.txtEnkiKetteiYMD = txtEnkiKetteiYMD;
    }

    /*
     * gettxtEnkiMikomiKikan
     * @return txtEnkiMikomiKikan
     */
    @JsonProperty("txtEnkiMikomiKikan")
    public TextBoxDateRange getTxtEnkiMikomiKikan() {
        return txtEnkiMikomiKikan;
    }

    /*
     * settxtEnkiMikomiKikan
     * @param txtEnkiMikomiKikan txtEnkiMikomiKikan
     */
    @JsonProperty("txtEnkiMikomiKikan")
    public void setTxtEnkiMikomiKikan(TextBoxDateRange txtEnkiMikomiKikan) {
        this.txtEnkiMikomiKikan = txtEnkiMikomiKikan;
    }

    /*
     * getlblEnkiRiyu
     * @return lblEnkiRiyu
     */
    @JsonProperty("lblEnkiRiyu")
    public Label getLblEnkiRiyu() {
        return lblEnkiRiyu;
    }

    /*
     * setlblEnkiRiyu
     * @param lblEnkiRiyu lblEnkiRiyu
     */
    @JsonProperty("lblEnkiRiyu")
    public void setLblEnkiRiyu(Label lblEnkiRiyu) {
        this.lblEnkiRiyu = lblEnkiRiyu;
    }

    /*
     * getbtnEnkiRiyuTeikeibun
     * @return btnEnkiRiyuTeikeibun
     */
    @JsonProperty("btnEnkiRiyuTeikeibun")
    public ButtonDialog getBtnEnkiRiyuTeikeibun() {
        return btnEnkiRiyuTeikeibun;
    }

    /*
     * setbtnEnkiRiyuTeikeibun
     * @param btnEnkiRiyuTeikeibun btnEnkiRiyuTeikeibun
     */
    @JsonProperty("btnEnkiRiyuTeikeibun")
    public void setBtnEnkiRiyuTeikeibun(ButtonDialog btnEnkiRiyuTeikeibun) {
        this.btnEnkiRiyuTeikeibun = btnEnkiRiyuTeikeibun;
    }

    /*
     * gettxtEnkiRiyu
     * @return txtEnkiRiyu
     */
    @JsonProperty("txtEnkiRiyu")
    public TextBoxMultiLine getTxtEnkiRiyu() {
        return txtEnkiRiyu;
    }

    /*
     * settxtEnkiRiyu
     * @param txtEnkiRiyu txtEnkiRiyu
     */
    @JsonProperty("txtEnkiRiyu")
    public void setTxtEnkiRiyu(TextBoxMultiLine txtEnkiRiyu) {
        this.txtEnkiRiyu = txtEnkiRiyu;
    }

    /*
     * gettxtEnkiTsuchiHakkoYMD
     * @return txtEnkiTsuchiHakkoYMD
     */
    @JsonProperty("txtEnkiTsuchiHakkoYMD")
    public TextBoxDate getTxtEnkiTsuchiHakkoYMD() {
        return txtEnkiTsuchiHakkoYMD;
    }

    /*
     * settxtEnkiTsuchiHakkoYMD
     * @param txtEnkiTsuchiHakkoYMD txtEnkiTsuchiHakkoYMD
     */
    @JsonProperty("txtEnkiTsuchiHakkoYMD")
    public void setTxtEnkiTsuchiHakkoYMD(TextBoxDate txtEnkiTsuchiHakkoYMD) {
        this.txtEnkiTsuchiHakkoYMD = txtEnkiTsuchiHakkoYMD;
    }

    /*
     * gettxtEnkiTsuchishoHakkoCount
     * @return txtEnkiTsuchishoHakkoCount
     */
    @JsonProperty("txtEnkiTsuchishoHakkoCount")
    public TextBoxNum getTxtEnkiTsuchishoHakkoCount() {
        return txtEnkiTsuchishoHakkoCount;
    }

    /*
     * settxtEnkiTsuchishoHakkoCount
     * @param txtEnkiTsuchishoHakkoCount txtEnkiTsuchishoHakkoCount
     */
    @JsonProperty("txtEnkiTsuchishoHakkoCount")
    public void setTxtEnkiTsuchishoHakkoCount(TextBoxNum txtEnkiTsuchishoHakkoCount) {
        this.txtEnkiTsuchishoHakkoCount = txtEnkiTsuchishoHakkoCount;
    }

    // </editor-fold>
}
