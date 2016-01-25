package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810026;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * GoukeiInfo のクラスファイル 
 * 
 * @author 自動生成
 */
public class GoukeiInfoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-16_12-38-19">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("panelCcd")
    private panelCcdDiv panelCcd;
    @JsonProperty("panelHead")
    private panelHeadDiv panelHead;
    @JsonProperty("panelGoukeiInfo")
    private panelGoukeiInfoDiv panelGoukeiInfo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getpanelCcd
     * @return panelCcd
     */
    @JsonProperty("panelCcd")
    public panelCcdDiv getPanelCcd() {
        return panelCcd;
    }

    /*
     * setpanelCcd
     * @param panelCcd panelCcd
     */
    @JsonProperty("panelCcd")
    public void setPanelCcd(panelCcdDiv panelCcd) {
        this.panelCcd = panelCcd;
    }

    /*
     * getpanelHead
     * @return panelHead
     */
    @JsonProperty("panelHead")
    public panelHeadDiv getPanelHead() {
        return panelHead;
    }

    /*
     * setpanelHead
     * @param panelHead panelHead
     */
    @JsonProperty("panelHead")
    public void setPanelHead(panelHeadDiv panelHead) {
        this.panelHead = panelHead;
    }

    /*
     * getpanelGoukeiInfo
     * @return panelGoukeiInfo
     */
    @JsonProperty("panelGoukeiInfo")
    public panelGoukeiInfoDiv getPanelGoukeiInfo() {
        return panelGoukeiInfo;
    }

    /*
     * setpanelGoukeiInfo
     * @param panelGoukeiInfo panelGoukeiInfo
     */
    @JsonProperty("panelGoukeiInfo")
    public void setPanelGoukeiInfo(panelGoukeiInfoDiv panelGoukeiInfo) {
        this.panelGoukeiInfo = panelGoukeiInfo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxNum getTxtServiceTanyi() {
        return this.getPanelGoukeiInfo().getTxtServiceTanyi();
    }

    @JsonIgnore
    public void  setTxtServiceTanyi(TextBoxNum txtServiceTanyi) {
        this.getPanelGoukeiInfo().setTxtServiceTanyi(txtServiceTanyi);
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenSeikyugaku() {
        return this.getPanelGoukeiInfo().getTxtHokenSeikyugaku();
    }

    @JsonIgnore
    public void  setTxtHokenSeikyugaku(TextBoxNum txtHokenSeikyugaku) {
        this.getPanelGoukeiInfo().setTxtHokenSeikyugaku(txtHokenSeikyugaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyoshafutangaku() {
        return this.getPanelGoukeiInfo().getTxtRiyoshafutangaku();
    }

    @JsonIgnore
    public void  setTxtRiyoshafutangaku(TextBoxNum txtRiyoshafutangaku) {
        this.getPanelGoukeiInfo().setTxtRiyoshafutangaku(txtRiyoshafutangaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtKinkyujiShisetsuRyoyo() {
        return this.getPanelGoukeiInfo().getTxtKinkyujiShisetsuRyoyo();
    }

    @JsonIgnore
    public void  setTxtKinkyujiShisetsuRyoyo(TextBoxNum txtKinkyujiShisetsuRyoyo) {
        this.getPanelGoukeiInfo().setTxtKinkyujiShisetsuRyoyo(txtKinkyujiShisetsuRyoyo);
    }

    @JsonIgnore
    public TextBoxNum getTxtTokuteiShinryo() {
        return this.getPanelGoukeiInfo().getTxtTokuteiShinryo();
    }

    @JsonIgnore
    public void  setTxtTokuteiShinryo(TextBoxNum txtTokuteiShinryo) {
        this.getPanelGoukeiInfo().setTxtTokuteiShinryo(txtTokuteiShinryo);
    }

    @JsonIgnore
    public TextBoxNum getTxtShokujiTeikyohi() {
        return this.getPanelGoukeiInfo().getTxtShokujiTeikyohi();
    }

    @JsonIgnore
    public void  setTxtShokujiTeikyohi(TextBoxNum txtShokujiTeikyohi) {
        this.getPanelGoukeiInfo().setTxtShokujiTeikyohi(txtShokujiTeikyohi);
    }

    // </editor-fold>
}
