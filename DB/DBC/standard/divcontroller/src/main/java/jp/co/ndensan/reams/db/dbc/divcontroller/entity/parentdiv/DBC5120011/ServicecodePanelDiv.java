package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC5120011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.chikushichosonselect.ChikuShichosonSelect.ChikuShichosonSelectDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.chikushichosonselect.ChikuShichosonSelect.IChikuShichosonSelectDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * ServicecodePanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class ServicecodePanelDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("jokenFukugenHozon")
    private jokenFukugenHozonDiv jokenFukugenHozon;
    @JsonProperty("chusyutsuPanel")
    private chusyutsuPanelDiv chusyutsuPanel;
    @JsonProperty("sekkeiPanel")
    private sekkeiPanelDiv sekkeiPanel;
    @JsonProperty("lblComment1")
    private Label lblComment1;
    @JsonProperty("lblComment2")
    private Label lblComment2;
    @JsonProperty("lblComment3")
    private Label lblComment3;
    @JsonProperty("lblComment4")
    private Label lblComment4;
    @JsonProperty("ccdChikuShichosonSelect")
    private ChikuShichosonSelectDiv ccdChikuShichosonSelect;
    @JsonProperty("hdnSelectedMap")
    private RString hdnSelectedMap;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getjokenFukugenHozon
     * @return jokenFukugenHozon
     */
    @JsonProperty("jokenFukugenHozon")
    public jokenFukugenHozonDiv getJokenFukugenHozon() {
        return jokenFukugenHozon;
    }

    /*
     * setjokenFukugenHozon
     * @param jokenFukugenHozon jokenFukugenHozon
     */
    @JsonProperty("jokenFukugenHozon")
    public void setJokenFukugenHozon(jokenFukugenHozonDiv jokenFukugenHozon) {
        this.jokenFukugenHozon = jokenFukugenHozon;
    }

    /*
     * getchusyutsuPanel
     * @return chusyutsuPanel
     */
    @JsonProperty("chusyutsuPanel")
    public chusyutsuPanelDiv getChusyutsuPanel() {
        return chusyutsuPanel;
    }

    /*
     * setchusyutsuPanel
     * @param chusyutsuPanel chusyutsuPanel
     */
    @JsonProperty("chusyutsuPanel")
    public void setChusyutsuPanel(chusyutsuPanelDiv chusyutsuPanel) {
        this.chusyutsuPanel = chusyutsuPanel;
    }

    /*
     * getsekkeiPanel
     * @return sekkeiPanel
     */
    @JsonProperty("sekkeiPanel")
    public sekkeiPanelDiv getSekkeiPanel() {
        return sekkeiPanel;
    }

    /*
     * setsekkeiPanel
     * @param sekkeiPanel sekkeiPanel
     */
    @JsonProperty("sekkeiPanel")
    public void setSekkeiPanel(sekkeiPanelDiv sekkeiPanel) {
        this.sekkeiPanel = sekkeiPanel;
    }

    /*
     * getlblComment1
     * @return lblComment1
     */
    @JsonProperty("lblComment1")
    public Label getLblComment1() {
        return lblComment1;
    }

    /*
     * setlblComment1
     * @param lblComment1 lblComment1
     */
    @JsonProperty("lblComment1")
    public void setLblComment1(Label lblComment1) {
        this.lblComment1 = lblComment1;
    }

    /*
     * getlblComment2
     * @return lblComment2
     */
    @JsonProperty("lblComment2")
    public Label getLblComment2() {
        return lblComment2;
    }

    /*
     * setlblComment2
     * @param lblComment2 lblComment2
     */
    @JsonProperty("lblComment2")
    public void setLblComment2(Label lblComment2) {
        this.lblComment2 = lblComment2;
    }

    /*
     * getlblComment3
     * @return lblComment3
     */
    @JsonProperty("lblComment3")
    public Label getLblComment3() {
        return lblComment3;
    }

    /*
     * setlblComment3
     * @param lblComment3 lblComment3
     */
    @JsonProperty("lblComment3")
    public void setLblComment3(Label lblComment3) {
        this.lblComment3 = lblComment3;
    }

    /*
     * getlblComment4
     * @return lblComment4
     */
    @JsonProperty("lblComment4")
    public Label getLblComment4() {
        return lblComment4;
    }

    /*
     * setlblComment4
     * @param lblComment4 lblComment4
     */
    @JsonProperty("lblComment4")
    public void setLblComment4(Label lblComment4) {
        this.lblComment4 = lblComment4;
    }

    /*
     * getccdChikuShichosonSelect
     * @return ccdChikuShichosonSelect
     */
    @JsonProperty("ccdChikuShichosonSelect")
    public IChikuShichosonSelectDiv getCcdChikuShichosonSelect() {
        return ccdChikuShichosonSelect;
    }

    /*
     * gethdnSelectedMap
     * @return hdnSelectedMap
     */
    @JsonProperty("hdnSelectedMap")
    public RString getHdnSelectedMap() {
        return hdnSelectedMap;
    }

    /*
     * sethdnSelectedMap
     * @param hdnSelectedMap hdnSelectedMap
     */
    @JsonProperty("hdnSelectedMap")
    public void setHdnSelectedMap(RString hdnSelectedMap) {
        this.hdnSelectedMap = hdnSelectedMap;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public ButtonBatchParameterSave getBtnBatchParameterSave() {
        return this.getJokenFukugenHozon().getBtnBatchParameterSave();
    }

    @JsonIgnore
    public void  setBtnBatchParameterSave(ButtonBatchParameterSave btnBatchParameterSave) {
        this.getJokenFukugenHozon().setBtnBatchParameterSave(btnBatchParameterSave);
    }

    @JsonIgnore
    public ButtonBatchParameterRestore getBtnBatchParameterRestore() {
        return this.getJokenFukugenHozon().getBtnBatchParameterRestore();
    }

    @JsonIgnore
    public void  setBtnBatchParameterRestore(ButtonBatchParameterRestore btnBatchParameterRestore) {
        this.getJokenFukugenHozon().setBtnBatchParameterRestore(btnBatchParameterRestore);
    }

    // </editor-fold>
}
