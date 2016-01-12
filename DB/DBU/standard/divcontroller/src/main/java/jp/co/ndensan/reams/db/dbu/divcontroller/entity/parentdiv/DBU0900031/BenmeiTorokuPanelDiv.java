package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0900031;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.kaigoatenainfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.kaigoatenainfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.kaigoshikakukihon.IKaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.kaigoshikakukihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * BenmeiTorokuPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class BenmeiTorokuPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
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
    public IKaigoAtenaInfoDiv getAtenaCommonChildDiv() {
        return this.getAtenaPanel().getAtenaCommonChildDiv();
    }

    @JsonIgnore
    public IKaigoShikakuKihonDiv getShikakuKihonCommonChildDiv() {
        return this.getShikakukihonPanel().getShikakuKihonCommonChildDiv();
    }

    @JsonIgnore
    public TextBoxDate getTxtdateBenmeiSyoSakuseibi() {
        return this.getBenmeiTorokuMeisaiPanel().getTxtdateBenmeiSyoSakuseibi();
    }

    @JsonIgnore
    public void  setTxtdateBenmeiSyoSakuseibi(TextBoxDate txtdateBenmeiSyoSakuseibi) {
        this.getBenmeiTorokuMeisaiPanel().setTxtdateBenmeiSyoSakuseibi(txtdateBenmeiSyoSakuseibi);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtMultiLineBenmeisya() {
        return this.getBenmeiTorokuMeisaiPanel().getTxtMultiLineBenmeisya();
    }

    @JsonIgnore
    public void  setTxtMultiLineBenmeisya(TextBoxMultiLine txtMultiLineBenmeisya) {
        this.getBenmeiTorokuMeisaiPanel().setTxtMultiLineBenmeisya(txtMultiLineBenmeisya);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtMultiLineShobunNaiyo() {
        return this.getBenmeiTorokuMeisaiPanel().getTxtMultiLineShobunNaiyo();
    }

    @JsonIgnore
    public void  setTxtMultiLineShobunNaiyo(TextBoxMultiLine txtMultiLineShobunNaiyo) {
        this.getBenmeiTorokuMeisaiPanel().setTxtMultiLineShobunNaiyo(txtMultiLineShobunNaiyo);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtMultiLineBenmeiNaiyo() {
        return this.getBenmeiTorokuMeisaiPanel().getTxtMultiLineBenmeiNaiyo();
    }

    @JsonIgnore
    public void  setTxtMultiLineBenmeiNaiyo(TextBoxMultiLine txtMultiLineBenmeiNaiyo) {
        this.getBenmeiTorokuMeisaiPanel().setTxtMultiLineBenmeiNaiyo(txtMultiLineBenmeiNaiyo);
    }

    @JsonIgnore
    public TextBoxDate getTxtDateBenmeisyoTeishutubi() {
        return this.getBenmeiTorokuMeisaiPanel().getTxtDateBenmeisyoTeishutubi();
    }

    @JsonIgnore
    public void  setTxtDateBenmeisyoTeishutubi(TextBoxDate txtDateBenmeisyoTeishutubi) {
        this.getBenmeiTorokuMeisaiPanel().setTxtDateBenmeisyoTeishutubi(txtDateBenmeisyoTeishutubi);
    }

    // </editor-fold>
}
