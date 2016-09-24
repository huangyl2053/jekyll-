package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2430011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.BunshoBangoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.IBunshoBangoInputDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * ShikyuKetteitsuchishoParameter のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShikyuKetteitsuchishoParameterDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ChushutsuJokenPanel")
    private ChushutsuJokenPanelDiv ChushutsuJokenPanel;
    @JsonProperty("KetteiTsuchishoHakkoJohoPanel")
    private KetteiTsuchishoHakkoJohoPanelDiv KetteiTsuchishoHakkoJohoPanel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getChushutsuJokenPanel
     * @return ChushutsuJokenPanel
     */
    @JsonProperty("ChushutsuJokenPanel")
    public ChushutsuJokenPanelDiv getChushutsuJokenPanel() {
        return ChushutsuJokenPanel;
    }

    /*
     * setChushutsuJokenPanel
     * @param ChushutsuJokenPanel ChushutsuJokenPanel
     */
    @JsonProperty("ChushutsuJokenPanel")
    public void setChushutsuJokenPanel(ChushutsuJokenPanelDiv ChushutsuJokenPanel) {
        this.ChushutsuJokenPanel = ChushutsuJokenPanel;
    }

    /*
     * getKetteiTsuchishoHakkoJohoPanel
     * @return KetteiTsuchishoHakkoJohoPanel
     */
    @JsonProperty("KetteiTsuchishoHakkoJohoPanel")
    public KetteiTsuchishoHakkoJohoPanelDiv getKetteiTsuchishoHakkoJohoPanel() {
        return KetteiTsuchishoHakkoJohoPanel;
    }

    /*
     * setKetteiTsuchishoHakkoJohoPanel
     * @param KetteiTsuchishoHakkoJohoPanel KetteiTsuchishoHakkoJohoPanel
     */
    @JsonProperty("KetteiTsuchishoHakkoJohoPanel")
    public void setKetteiTsuchishoHakkoJohoPanel(KetteiTsuchishoHakkoJohoPanelDiv KetteiTsuchishoHakkoJohoPanel) {
        this.KetteiTsuchishoHakkoJohoPanel = KetteiTsuchishoHakkoJohoPanel;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxDateRange getTxtZnkaiKetteiYMD() {
        return this.getChushutsuJokenPanel().getTxtZnkaiKetteiYMD();
    }

    @JsonIgnore
    public void  setTxtZnkaiKetteiYMD(TextBoxDateRange txtZnkaiKetteiYMD) {
        this.getChushutsuJokenPanel().setTxtZnkaiKetteiYMD(txtZnkaiKetteiYMD);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKetteiYMD() {
        return this.getChushutsuJokenPanel().getTxtKetteiYMD();
    }

    @JsonIgnore
    public void  setTxtKetteiYMD(TextBoxDateRange txtKetteiYMD) {
        this.getChushutsuJokenPanel().setTxtKetteiYMD(txtKetteiYMD);
    }

    @JsonIgnore
    public Space getSpcInsho() {
        return this.getChushutsuJokenPanel().getSpcInsho();
    }

    @JsonIgnore
    public void  setSpcInsho(Space spcInsho) {
        this.getChushutsuJokenPanel().setSpcInsho(spcInsho);
    }

    @JsonIgnore
    public CheckBoxList getChkShiteiJigyoshaNomi() {
        return this.getChushutsuJokenPanel().getChkShiteiJigyoshaNomi();
    }

    @JsonIgnore
    public void  setChkShiteiJigyoshaNomi(CheckBoxList chkShiteiJigyoshaNomi) {
        this.getChushutsuJokenPanel().setChkShiteiJigyoshaNomi(chkShiteiJigyoshaNomi);
    }

    @JsonIgnore
    public DropDownList getDdlJigyosha() {
        return this.getChushutsuJokenPanel().getDdlJigyosha();
    }

    @JsonIgnore
    public void  setDdlJigyosha(DropDownList ddlJigyosha) {
        this.getChushutsuJokenPanel().setDdlJigyosha(ddlJigyosha);
    }

    @JsonIgnore
    public IBunshoBangoInputDiv getCcdBunshoBangoInput() {
        return this.getKetteiTsuchishoHakkoJohoPanel().getCcdBunshoBangoInput();
    }

    @JsonIgnore
    public IChohyoShutsuryokujunDiv getCcdChohyoShutsuryokujun() {
        return this.getKetteiTsuchishoHakkoJohoPanel().getCcdChohyoShutsuryokujun();
    }

    // </editor-fold>
}
