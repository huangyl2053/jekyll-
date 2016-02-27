package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0710011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * BatchParamterInfo のクラスファイル 
 * 
 * @author 自動生成
 */
public class BatchParamterInfoDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlShichosonShitei")
    private DropDownList ddlShichosonShitei;
    @JsonProperty("linChushutsu")
    private HorizontalLine linChushutsu;
    @JsonProperty("lblChushutsuJyoken")
    private Label lblChushutsuJyoken;
    @JsonProperty("tblChushutsuJyoken")
    private tblChushutsuJyokenDiv tblChushutsuJyoken;
    @JsonProperty("ccdChohyoShutsuryokujun")
    private ChohyoShutsuryokujunDiv ccdChohyoShutsuryokujun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlShichosonShitei
     * @return ddlShichosonShitei
     */
    @JsonProperty("ddlShichosonShitei")
    public DropDownList getDdlShichosonShitei() {
        return ddlShichosonShitei;
    }

    /*
     * setddlShichosonShitei
     * @param ddlShichosonShitei ddlShichosonShitei
     */
    @JsonProperty("ddlShichosonShitei")
    public void setDdlShichosonShitei(DropDownList ddlShichosonShitei) {
        this.ddlShichosonShitei = ddlShichosonShitei;
    }

    /*
     * getlinChushutsu
     * @return linChushutsu
     */
    @JsonProperty("linChushutsu")
    public HorizontalLine getLinChushutsu() {
        return linChushutsu;
    }

    /*
     * setlinChushutsu
     * @param linChushutsu linChushutsu
     */
    @JsonProperty("linChushutsu")
    public void setLinChushutsu(HorizontalLine linChushutsu) {
        this.linChushutsu = linChushutsu;
    }

    /*
     * getlblChushutsuJyoken
     * @return lblChushutsuJyoken
     */
    @JsonProperty("lblChushutsuJyoken")
    public Label getLblChushutsuJyoken() {
        return lblChushutsuJyoken;
    }

    /*
     * setlblChushutsuJyoken
     * @param lblChushutsuJyoken lblChushutsuJyoken
     */
    @JsonProperty("lblChushutsuJyoken")
    public void setLblChushutsuJyoken(Label lblChushutsuJyoken) {
        this.lblChushutsuJyoken = lblChushutsuJyoken;
    }

    /*
     * gettblChushutsuJyoken
     * @return tblChushutsuJyoken
     */
    @JsonProperty("tblChushutsuJyoken")
    public tblChushutsuJyokenDiv getTblChushutsuJyoken() {
        return tblChushutsuJyoken;
    }

    /*
     * settblChushutsuJyoken
     * @param tblChushutsuJyoken tblChushutsuJyoken
     */
    @JsonProperty("tblChushutsuJyoken")
    public void setTblChushutsuJyoken(tblChushutsuJyokenDiv tblChushutsuJyoken) {
        this.tblChushutsuJyoken = tblChushutsuJyoken;
    }

    /*
     * getccdChohyoShutsuryokujun
     * @return ccdChohyoShutsuryokujun
     */
    @JsonProperty("ccdChohyoShutsuryokujun")
    public IChohyoShutsuryokujunDiv getCcdChohyoShutsuryokujun() {
        return ccdChohyoShutsuryokujun;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadChokin() {
        return this.getTblChushutsuJyoken().getRadChokin();
    }

    @JsonIgnore
    public Space getSpcChokin() {
        return this.getTblChushutsuJyoken().getSpcChokin();
    }

    @JsonIgnore
    public RadioButton getRadKijyunbi() {
        return this.getTblChushutsuJyoken().getRadKijyunbi();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKijunYMD() {
        return this.getTblChushutsuJyoken().getTxtKijunYMD();
    }

    @JsonIgnore
    public Space getSpcHani() {
        return this.getTblChushutsuJyoken().getSpcHani();
    }

    @JsonIgnore
    public RadioButton getRadHani() {
        return this.getTblChushutsuJyoken().getRadHani();
    }

    @JsonIgnore
    public Label getLblKaishibi() {
        return this.getTblChushutsuJyoken().getLblKaishibi();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKonkaiKaishibi() {
        return this.getTblChushutsuJyoken().getTxtKonkaiKaishibi();
    }

    @JsonIgnore
    public Label getLblShuryobi() {
        return this.getTblChushutsuJyoken().getLblShuryobi();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKonkaiShuryobi() {
        return this.getTblChushutsuJyoken().getTxtKonkaiShuryobi();
    }

    // </editor-fold>
}
