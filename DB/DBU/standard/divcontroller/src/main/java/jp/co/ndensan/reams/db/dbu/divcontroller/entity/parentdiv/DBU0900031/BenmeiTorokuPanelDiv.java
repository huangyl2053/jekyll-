package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0900031;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.IKaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * BenmeiTorokuPanel のクラスファイル
 *
 * @reamsid_L DBU-1080-020 lijia
 *
 */
public class BenmeiTorokuPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("AtenaPanel")
    private AtenaPanelDiv AtenaPanel;
    @JsonProperty("ShikakukihonPanel")
    private ShikakukihonPanelDiv ShikakukihonPanel;
    @JsonProperty("BenmeiTorokuMeisaiPanel")
    private BenmeiTorokuMeisaiPanelDiv BenmeiTorokuMeisaiPanel;
    @JsonProperty("KanryoMessagePanel")
    private KanryoMessagePanelDiv KanryoMessagePanel;
    @JsonProperty("ProcessState")
    private RString ProcessState;

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
     * getShikakukihonPanel
     * @return ShikakukihonPanel
     */
    @JsonProperty("ShikakukihonPanel")
    public ShikakukihonPanelDiv getShikakukihonPanel() {
        return ShikakukihonPanel;
    }

    /*
     * setShikakukihonPanel
     * @param ShikakukihonPanel ShikakukihonPanel
     */
    @JsonProperty("ShikakukihonPanel")
    public void setShikakukihonPanel(ShikakukihonPanelDiv ShikakukihonPanel) {
        this.ShikakukihonPanel = ShikakukihonPanel;
    }

    /*
     * getBenmeiTorokuMeisaiPanel
     * @return BenmeiTorokuMeisaiPanel
     */
    @JsonProperty("BenmeiTorokuMeisaiPanel")
    public BenmeiTorokuMeisaiPanelDiv getBenmeiTorokuMeisaiPanel() {
        return BenmeiTorokuMeisaiPanel;
    }

    /*
     * setBenmeiTorokuMeisaiPanel
     * @param BenmeiTorokuMeisaiPanel BenmeiTorokuMeisaiPanel
     */
    @JsonProperty("BenmeiTorokuMeisaiPanel")
    public void setBenmeiTorokuMeisaiPanel(BenmeiTorokuMeisaiPanelDiv BenmeiTorokuMeisaiPanel) {
        this.BenmeiTorokuMeisaiPanel = BenmeiTorokuMeisaiPanel;
    }

    /*
     * getKanryoMessagePanel
     * @return KanryoMessagePanel
     */
    @JsonProperty("KanryoMessagePanel")
    public KanryoMessagePanelDiv getKanryoMessagePanel() {
        return KanryoMessagePanel;
    }

    /*
     * setKanryoMessagePanel
     * @param KanryoMessagePanel KanryoMessagePanel
     */
    @JsonProperty("KanryoMessagePanel")
    public void setKanryoMessagePanel(KanryoMessagePanelDiv KanryoMessagePanel) {
        this.KanryoMessagePanel = KanryoMessagePanel;
    }

    /*
     * getProcessState
     * @return ProcessState
     */
    @JsonProperty("ProcessState")
    public RString getProcessState() {
        return ProcessState;
    }

    /*
     * setProcessState
     * @param ProcessState ProcessState
     */
    @JsonProperty("ProcessState")
    public void setProcessState(RString ProcessState) {
        this.ProcessState = ProcessState;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public IKaigoShikakuKihonDiv getCcdKaigoShikakuKihon() {
        return this.getShikakukihonPanel().getCcdKaigoShikakuKihon();
    }

    @JsonIgnore
    public TextBoxDate getTxtBenmeiSyoSakuseibi() {
        return this.getBenmeiTorokuMeisaiPanel().getTxtBenmeiSyoSakuseibi();
    }

    @JsonIgnore
    public void setTxtBenmeiSyoSakuseibi(TextBoxDate txtBenmeiSyoSakuseibi) {
        this.getBenmeiTorokuMeisaiPanel().setTxtBenmeiSyoSakuseibi(txtBenmeiSyoSakuseibi);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtMultiLineBenmeisya() {
        return this.getBenmeiTorokuMeisaiPanel().getTxtMultiLineBenmeisya();
    }

    @JsonIgnore
    public void setTxtMultiLineBenmeisya(TextBoxMultiLine txtMultiLineBenmeisya) {
        this.getBenmeiTorokuMeisaiPanel().setTxtMultiLineBenmeisya(txtMultiLineBenmeisya);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtMultiLineShobunNaiyo() {
        return this.getBenmeiTorokuMeisaiPanel().getTxtMultiLineShobunNaiyo();
    }

    @JsonIgnore
    public void setTxtMultiLineShobunNaiyo(TextBoxMultiLine txtMultiLineShobunNaiyo) {
        this.getBenmeiTorokuMeisaiPanel().setTxtMultiLineShobunNaiyo(txtMultiLineShobunNaiyo);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtMultiLineBenmeiNaiyo() {
        return this.getBenmeiTorokuMeisaiPanel().getTxtMultiLineBenmeiNaiyo();
    }

    @JsonIgnore
    public void setTxtMultiLineBenmeiNaiyo(TextBoxMultiLine txtMultiLineBenmeiNaiyo) {
        this.getBenmeiTorokuMeisaiPanel().setTxtMultiLineBenmeiNaiyo(txtMultiLineBenmeiNaiyo);
    }

    @JsonIgnore
    public TextBoxDate getTxtBenmeisyoTeishutubi() {
        return this.getBenmeiTorokuMeisaiPanel().getTxtBenmeisyoTeishutubi();
    }

    @JsonIgnore
    public void setTxtBenmeisyoTeishutubi(TextBoxDate txtBenmeisyoTeishutubi) {
        this.getBenmeiTorokuMeisaiPanel().setTxtBenmeisyoTeishutubi(txtBenmeisyoTeishutubi);
    }

    // </editor-fold>
}
