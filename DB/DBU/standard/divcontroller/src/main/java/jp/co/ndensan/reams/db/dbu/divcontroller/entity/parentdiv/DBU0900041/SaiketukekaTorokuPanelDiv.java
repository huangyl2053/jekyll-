package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0900041;
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
 * SaiketukekaTorokuPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class SaiketukekaTorokuPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("AtenaPanel")
    private AtenaPanelDiv AtenaPanel;
    @JsonProperty("ShikakuKihonPanel")
    private ShikakuKihonPanelDiv ShikakuKihonPanel;
    @JsonProperty("SaiketukekaMeisaiPanel")
    private SaiketukekaMeisaiPanelDiv SaiketukekaMeisaiPanel;
    @JsonProperty("KaryoMessage")
    private KaryoMessageDiv KaryoMessage;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getAtenaPanel
     * @return AtenaPanel
     */
    @JsonProperty("AtenaPanel")
    public AtenaPanelDiv getAtenaPanel() {
        return AtenaPanel;
    }

    /*
     * setAtenaPanel
     * @param AtenaPanel AtenaPanel
     */
    @JsonProperty("AtenaPanel")
    public void setAtenaPanel(AtenaPanelDiv AtenaPanel) {
        this.AtenaPanel = AtenaPanel;
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
     * getSaiketukekaMeisaiPanel
     * @return SaiketukekaMeisaiPanel
     */
    @JsonProperty("SaiketukekaMeisaiPanel")
    public SaiketukekaMeisaiPanelDiv getSaiketukekaMeisaiPanel() {
        return SaiketukekaMeisaiPanel;
    }

    /*
     * setSaiketukekaMeisaiPanel
     * @param SaiketukekaMeisaiPanel SaiketukekaMeisaiPanel
     */
    @JsonProperty("SaiketukekaMeisaiPanel")
    public void setSaiketukekaMeisaiPanel(SaiketukekaMeisaiPanelDiv SaiketukekaMeisaiPanel) {
        this.SaiketukekaMeisaiPanel = SaiketukekaMeisaiPanel;
    }

    /*
     * getKaryoMessage
     * @return KaryoMessage
     */
    @JsonProperty("KaryoMessage")
    public KaryoMessageDiv getKaryoMessage() {
        return KaryoMessage;
    }

    /*
     * setKaryoMessage
     * @param KaryoMessage KaryoMessage
     */
    @JsonProperty("KaryoMessage")
    public void setKaryoMessage(KaryoMessageDiv KaryoMessage) {
        this.KaryoMessage = KaryoMessage;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public IKaigoAtenaInfoDiv getAtenaInfoCommonChildDiv() {
        return this.getAtenaPanel().getAtenaInfoCommonChildDiv();
    }

    @JsonIgnore
    public IKaigoShikakuKihonDiv getKaigoShikakuKihonCommonChildDiv() {
        return this.getShikakuKihonPanel().getKaigoShikakuKihonCommonChildDiv();
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtMultiLineSaiketukeka() {
        return this.getSaiketukekaMeisaiPanel().getTxtMultiLineSaiketukeka();
    }

    @JsonIgnore
    public void  setTxtMultiLineSaiketukeka(TextBoxMultiLine txtMultiLineSaiketukeka) {
        this.getSaiketukekaMeisaiPanel().setTxtMultiLineSaiketukeka(txtMultiLineSaiketukeka);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtMultiLineSaiketuRiyu() {
        return this.getSaiketukekaMeisaiPanel().getTxtMultiLineSaiketuRiyu();
    }

    @JsonIgnore
    public void  setTxtMultiLineSaiketuRiyu(TextBoxMultiLine txtMultiLineSaiketuRiyu) {
        this.getSaiketukekaMeisaiPanel().setTxtMultiLineSaiketuRiyu(txtMultiLineSaiketuRiyu);
    }

    @JsonIgnore
    public TextBoxDate getTxtDateBenmeisyoSakuseibi() {
        return this.getSaiketukekaMeisaiPanel().getTxtDateBenmeisyoSakuseibi();
    }

    @JsonIgnore
    public void  setTxtDateBenmeisyoSakuseibi(TextBoxDate txtDateBenmeisyoSakuseibi) {
        this.getSaiketukekaMeisaiPanel().setTxtDateBenmeisyoSakuseibi(txtDateBenmeisyoSakuseibi);
    }

    // </editor-fold>
}
