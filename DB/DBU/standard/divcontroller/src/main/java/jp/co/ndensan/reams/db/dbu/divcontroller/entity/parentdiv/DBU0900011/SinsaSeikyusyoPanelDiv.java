package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0900011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.kaigoatenainfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.kaigoshikakukihon.IKaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SinsaSeikyusyoPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class SinsaSeikyusyoPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("AtennaInfoPanel")
    private AtennaInfoPanelDiv AtennaInfoPanel;
    @JsonProperty("ShikakuKihonPanel")
    private ShikakuKihonPanelDiv ShikakuKihonPanel;
    @JsonProperty("SinsaSeikyusyoJohoPane1")
    private SinsaSeikyusyoJohoPane1Div SinsaSeikyusyoJohoPane1;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getAtennaInfoPanel
     * @return AtennaInfoPanel
     */
    @JsonProperty("AtennaInfoPanel")
    public AtennaInfoPanelDiv getAtennaInfoPanel() {
        return AtennaInfoPanel;
    }

    /*
     * setAtennaInfoPanel
     * @param AtennaInfoPanel AtennaInfoPanel
     */
    @JsonProperty("AtennaInfoPanel")
    public void setAtennaInfoPanel(AtennaInfoPanelDiv AtennaInfoPanel) {
        this.AtennaInfoPanel = AtennaInfoPanel;
    }

    /*
     * getShikakuKihonPanel
     * @return ShikakuKihonPanel
     */
    @JsonProperty("ShikakuKihonPanel")
    public ShikakuKihonPanelDiv getShikakuKihonPanel() {
        return ShikakuKihonPanel;
    }

    /*
     * setShikakuKihonPanel
     * @param ShikakuKihonPanel ShikakuKihonPanel
     */
    @JsonProperty("ShikakuKihonPanel")
    public void setShikakuKihonPanel(ShikakuKihonPanelDiv ShikakuKihonPanel) {
        this.ShikakuKihonPanel = ShikakuKihonPanel;
    }

    /*
     * getSinsaSeikyusyoJohoPane1
     * @return SinsaSeikyusyoJohoPane1
     */
    @JsonProperty("SinsaSeikyusyoJohoPane1")
    public SinsaSeikyusyoJohoPane1Div getSinsaSeikyusyoJohoPane1() {
        return SinsaSeikyusyoJohoPane1;
    }

    /*
     * setSinsaSeikyusyoJohoPane1
     * @param SinsaSeikyusyoJohoPane1 SinsaSeikyusyoJohoPane1
     */
    @JsonProperty("SinsaSeikyusyoJohoPane1")
    public void setSinsaSeikyusyoJohoPane1(SinsaSeikyusyoJohoPane1Div SinsaSeikyusyoJohoPane1) {
        this.SinsaSeikyusyoJohoPane1 = SinsaSeikyusyoJohoPane1;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public IKaigoAtenaInfoDiv getAtenainfoCommonChildDiv1() {
        return this.getAtennaInfoPanel().getAtenainfoCommonChildDiv1();
    }

    @JsonIgnore
    public IKaigoShikakuKihonDiv getShikakuKihonCommonChildDiv1() {
        return this.getShikakuKihonPanel().getShikakuKihonCommonChildDiv1();
    }

    @JsonIgnore
    public Button getBtnTuika() {
        return this.getSinsaSeikyusyoJohoPane1().getBtnTuika();
    }

    @JsonIgnore
    public void  setBtnTuika(Button btnTuika) {
        this.getSinsaSeikyusyoJohoPane1().setBtnTuika(btnTuika);
    }

    @JsonIgnore
    public DataGrid<grdSinsaSeikyusyoJoho_Row> getGrdSinsaSeikyusyoJoho() {
        return this.getSinsaSeikyusyoJohoPane1().getGrdSinsaSeikyusyoJoho();
    }

    @JsonIgnore
    public void  setGrdSinsaSeikyusyoJoho(DataGrid<grdSinsaSeikyusyoJoho_Row> grdSinsaSeikyusyoJoho) {
        this.getSinsaSeikyusyoJohoPane1().setGrdSinsaSeikyusyoJoho(grdSinsaSeikyusyoJoho);
    }

    // </editor-fold>
}
