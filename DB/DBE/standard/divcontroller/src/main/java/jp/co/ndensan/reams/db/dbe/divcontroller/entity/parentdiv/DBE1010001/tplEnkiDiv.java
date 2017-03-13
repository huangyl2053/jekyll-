package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1010001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * tplEnki のクラスファイル 
 * 
 * @author 自動生成
 */
public class tplEnkiDiv extends TabPanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-02-23_06-32-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("pnlEnki")
    private pnlEnkiDiv pnlEnki;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getpnlEnki
     * @return pnlEnki
     */
    @JsonProperty("pnlEnki")
    public pnlEnkiDiv getPnlEnki() {
        return pnlEnki;
    }

    /*
     * setpnlEnki
     * @param pnlEnki pnlEnki
     */
    @JsonProperty("pnlEnki")
    public void setPnlEnki(pnlEnkiDiv pnlEnki) {
        this.pnlEnki = pnlEnki;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxDate getTxtEnkiKetteiYMD() {
        return this.getPnlEnki().getTxtEnkiKetteiYMD();
    }

    @JsonIgnore
    public void  setTxtEnkiKetteiYMD(TextBoxDate txtEnkiKetteiYMD) {
        this.getPnlEnki().setTxtEnkiKetteiYMD(txtEnkiKetteiYMD);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtEnkiMikomiKikan() {
        return this.getPnlEnki().getTxtEnkiMikomiKikan();
    }

    @JsonIgnore
    public void  setTxtEnkiMikomiKikan(TextBoxDateRange txtEnkiMikomiKikan) {
        this.getPnlEnki().setTxtEnkiMikomiKikan(txtEnkiMikomiKikan);
    }

    @JsonIgnore
    public Label getLblEnkiRiyu() {
        return this.getPnlEnki().getLblEnkiRiyu();
    }

    @JsonIgnore
    public void  setLblEnkiRiyu(Label lblEnkiRiyu) {
        this.getPnlEnki().setLblEnkiRiyu(lblEnkiRiyu);
    }

    @JsonIgnore
    public ButtonDialog getBtnEnkiRiyuTeikeibun() {
        return this.getPnlEnki().getBtnEnkiRiyuTeikeibun();
    }

    @JsonIgnore
    public void  setBtnEnkiRiyuTeikeibun(ButtonDialog btnEnkiRiyuTeikeibun) {
        this.getPnlEnki().setBtnEnkiRiyuTeikeibun(btnEnkiRiyuTeikeibun);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtEnkiRiyu() {
        return this.getPnlEnki().getTxtEnkiRiyu();
    }

    @JsonIgnore
    public void  setTxtEnkiRiyu(TextBoxMultiLine txtEnkiRiyu) {
        this.getPnlEnki().setTxtEnkiRiyu(txtEnkiRiyu);
    }

    @JsonIgnore
    public TextBoxDate getTxtEnkiTsuchiHakkoYMD() {
        return this.getPnlEnki().getTxtEnkiTsuchiHakkoYMD();
    }

    @JsonIgnore
    public void  setTxtEnkiTsuchiHakkoYMD(TextBoxDate txtEnkiTsuchiHakkoYMD) {
        this.getPnlEnki().setTxtEnkiTsuchiHakkoYMD(txtEnkiTsuchiHakkoYMD);
    }

    @JsonIgnore
    public TextBoxNum getTxtEnkiTsuchishoHakkoCount() {
        return this.getPnlEnki().getTxtEnkiTsuchishoHakkoCount();
    }

    @JsonIgnore
    public void  setTxtEnkiTsuchishoHakkoCount(TextBoxNum txtEnkiTsuchishoHakkoCount) {
        this.getPnlEnki().setTxtEnkiTsuchishoHakkoCount(txtEnkiTsuchishoHakkoCount);
    }

    // </editor-fold>
}
