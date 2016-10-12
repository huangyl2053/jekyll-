package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1040021;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.HokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.Chiku2Input.Chiku2InputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.Chiku2Input.IChiku2InputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.ChoikiInput.ChoikiInputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.ChoikiInput.IChoikiInputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.GyoseikuInput.GyoseikuInputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.GyoseikuInput.IGyoseikuInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ChushutsuJoken4 のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChushutsuJoken4Div extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ChushutsuJoken")
    private ChushutsuJokenDiv ChushutsuJoken;
    @JsonProperty("ShichosonPanel")
    private ShichosonPanelDiv ShichosonPanel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getChushutsuJoken
     * @return ChushutsuJoken
     */
    @JsonProperty("ChushutsuJoken")
    public ChushutsuJokenDiv getChushutsuJoken() {
        return ChushutsuJoken;
    }

    /*
     * setChushutsuJoken
     * @param ChushutsuJoken ChushutsuJoken
     */
    @JsonProperty("ChushutsuJoken")
    public void setChushutsuJoken(ChushutsuJokenDiv ChushutsuJoken) {
        this.ChushutsuJoken = ChushutsuJoken;
    }

    /*
     * getShichosonPanel
     * @return ShichosonPanel
     */
    @JsonProperty("ShichosonPanel")
    public ShichosonPanelDiv getShichosonPanel() {
        return ShichosonPanel;
    }

    /*
     * setShichosonPanel
     * @param ShichosonPanel ShichosonPanel
     */
    @JsonProperty("ShichosonPanel")
    public void setShichosonPanel(ShichosonPanelDiv ShichosonPanel) {
        this.ShichosonPanel = ShichosonPanel;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Space getChikuSpace1() {
        return this.getChushutsuJoken().getChikuSpace1();
    }

    @JsonIgnore
    public void  setChikuSpace1(Space ChikuSpace1) {
        this.getChushutsuJoken().setChikuSpace1(ChikuSpace1);
    }

    @JsonIgnore
    public DropDownList getDdlChiku() {
        return this.getChushutsuJoken().getDdlChiku();
    }

    @JsonIgnore
    public void  setDdlChiku(DropDownList ddlChiku) {
        this.getChushutsuJoken().setDdlChiku(ddlChiku);
    }

    @JsonIgnore
    public Label getLblJushoKara() {
        return this.getChushutsuJoken().getLblJushoKara();
    }

    @JsonIgnore
    public void  setLblJushoKara(Label lblJushoKara) {
        this.getChushutsuJoken().setLblJushoKara(lblJushoKara);
    }

    @JsonIgnore
    public Label getLblChiku2Kara() {
        return this.getChushutsuJoken().getLblChiku2Kara();
    }

    @JsonIgnore
    public void  setLblChiku2Kara(Label lblChiku2Kara) {
        this.getChushutsuJoken().setLblChiku2Kara(lblChiku2Kara);
    }

    @JsonIgnore
    public Label getLblGyoseikuKara() {
        return this.getChushutsuJoken().getLblGyoseikuKara();
    }

    @JsonIgnore
    public void  setLblGyoseikuKara(Label lblGyoseikuKara) {
        this.getChushutsuJoken().setLblGyoseikuKara(lblGyoseikuKara);
    }

    @JsonIgnore
    public Space getShichosonSpace1() {
        return this.getChushutsuJoken().getShichosonSpace1();
    }

    @JsonIgnore
    public void  setShichosonSpace1(Space ShichosonSpace1) {
        this.getChushutsuJoken().setShichosonSpace1(ShichosonSpace1);
    }

    @JsonIgnore
    public IChoikiInputDiv getCcdJyuusyoStart() {
        return this.getChushutsuJoken().getCcdJyuusyoStart();
    }

    @JsonIgnore
    public IChiku2InputDiv getCcdChikuEnd() {
        return this.getChushutsuJoken().getCcdChikuEnd();
    }

    @JsonIgnore
    public IChoikiInputDiv getCcdJyuusyoEnd() {
        return this.getChushutsuJoken().getCcdJyuusyoEnd();
    }

    @JsonIgnore
    public IChiku2InputDiv getCcdChikuStart() {
        return this.getChushutsuJoken().getCcdChikuStart();
    }

    @JsonIgnore
    public IGyoseikuInputDiv getCcdGyouseiEnd() {
        return this.getChushutsuJoken().getCcdGyouseiEnd();
    }

    @JsonIgnore
    public IGyoseikuInputDiv getCcdGyouseiStart() {
        return this.getChushutsuJoken().getCcdGyouseiStart();
    }

    @JsonIgnore
    public Space getChikuSpace2() {
        return this.getShichosonPanel().getChikuSpace2();
    }

    @JsonIgnore
    public void  setChikuSpace2(Space ChikuSpace2) {
        this.getShichosonPanel().setChikuSpace2(ChikuSpace2);
    }

    @JsonIgnore
    public Space getShichosonSpace2() {
        return this.getShichosonPanel().getShichosonSpace2();
    }

    @JsonIgnore
    public void  setShichosonSpace2(Space ShichosonSpace2) {
        this.getShichosonPanel().setShichosonSpace2(ShichosonSpace2);
    }

    @JsonIgnore
    public IHokenshaListDiv getCcdHokenshaList() {
        return this.getShichosonPanel().getCcdHokenshaList();
    }

    // </editor-fold>
}
