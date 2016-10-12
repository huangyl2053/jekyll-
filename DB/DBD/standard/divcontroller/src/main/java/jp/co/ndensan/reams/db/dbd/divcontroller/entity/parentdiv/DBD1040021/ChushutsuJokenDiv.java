package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1040021;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.Chiku2Input.Chiku2InputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.Chiku2Input.IChiku2InputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.ChoikiInput.ChoikiInputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.ChoikiInput.IChoikiInputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.GyoseikuInput.GyoseikuInputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.GyoseikuInput.IGyoseikuInputDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ChushutsuJoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChushutsuJokenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ChikuSpace1")
    private Space ChikuSpace1;
    @JsonProperty("ddlChiku")
    private DropDownList ddlChiku;
    @JsonProperty("lblJushoKara")
    private Label lblJushoKara;
    @JsonProperty("lblChiku2Kara")
    private Label lblChiku2Kara;
    @JsonProperty("lblGyoseikuKara")
    private Label lblGyoseikuKara;
    @JsonProperty("ShichosonSpace1")
    private Space ShichosonSpace1;
    @JsonProperty("ccdJyuusyoStart")
    private ChoikiInputDiv ccdJyuusyoStart;
    @JsonProperty("ccdChikuEnd")
    private Chiku2InputDiv ccdChikuEnd;
    @JsonProperty("ccdJyuusyoEnd")
    private ChoikiInputDiv ccdJyuusyoEnd;
    @JsonProperty("ccdChikuStart")
    private Chiku2InputDiv ccdChikuStart;
    @JsonProperty("ccdGyouseiEnd")
    private GyoseikuInputDiv ccdGyouseiEnd;
    @JsonProperty("ccdGyouseiStart")
    private GyoseikuInputDiv ccdGyouseiStart;
    @JsonProperty("InputMode")
    private RString InputMode;
    @JsonProperty("SearchLevel")
    private RString SearchLevel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getChikuSpace1
     * @return ChikuSpace1
     */
    @JsonProperty("ChikuSpace1")
    public Space getChikuSpace1() {
        return ChikuSpace1;
    }

    /*
     * setChikuSpace1
     * @param ChikuSpace1 ChikuSpace1
     */
    @JsonProperty("ChikuSpace1")
    public void setChikuSpace1(Space ChikuSpace1) {
        this.ChikuSpace1 = ChikuSpace1;
    }

    /*
     * getddlChiku
     * @return ddlChiku
     */
    @JsonProperty("ddlChiku")
    public DropDownList getDdlChiku() {
        return ddlChiku;
    }

    /*
     * setddlChiku
     * @param ddlChiku ddlChiku
     */
    @JsonProperty("ddlChiku")
    public void setDdlChiku(DropDownList ddlChiku) {
        this.ddlChiku = ddlChiku;
    }

    /*
     * getlblJushoKara
     * @return lblJushoKara
     */
    @JsonProperty("lblJushoKara")
    public Label getLblJushoKara() {
        return lblJushoKara;
    }

    /*
     * setlblJushoKara
     * @param lblJushoKara lblJushoKara
     */
    @JsonProperty("lblJushoKara")
    public void setLblJushoKara(Label lblJushoKara) {
        this.lblJushoKara = lblJushoKara;
    }

    /*
     * getlblChiku2Kara
     * @return lblChiku2Kara
     */
    @JsonProperty("lblChiku2Kara")
    public Label getLblChiku2Kara() {
        return lblChiku2Kara;
    }

    /*
     * setlblChiku2Kara
     * @param lblChiku2Kara lblChiku2Kara
     */
    @JsonProperty("lblChiku2Kara")
    public void setLblChiku2Kara(Label lblChiku2Kara) {
        this.lblChiku2Kara = lblChiku2Kara;
    }

    /*
     * getlblGyoseikuKara
     * @return lblGyoseikuKara
     */
    @JsonProperty("lblGyoseikuKara")
    public Label getLblGyoseikuKara() {
        return lblGyoseikuKara;
    }

    /*
     * setlblGyoseikuKara
     * @param lblGyoseikuKara lblGyoseikuKara
     */
    @JsonProperty("lblGyoseikuKara")
    public void setLblGyoseikuKara(Label lblGyoseikuKara) {
        this.lblGyoseikuKara = lblGyoseikuKara;
    }

    /*
     * getShichosonSpace1
     * @return ShichosonSpace1
     */
    @JsonProperty("ShichosonSpace1")
    public Space getShichosonSpace1() {
        return ShichosonSpace1;
    }

    /*
     * setShichosonSpace1
     * @param ShichosonSpace1 ShichosonSpace1
     */
    @JsonProperty("ShichosonSpace1")
    public void setShichosonSpace1(Space ShichosonSpace1) {
        this.ShichosonSpace1 = ShichosonSpace1;
    }

    /*
     * getccdJyuusyoStart
     * @return ccdJyuusyoStart
     */
    @JsonProperty("ccdJyuusyoStart")
    public IChoikiInputDiv getCcdJyuusyoStart() {
        return ccdJyuusyoStart;
    }

    /*
     * getccdChikuEnd
     * @return ccdChikuEnd
     */
    @JsonProperty("ccdChikuEnd")
    public IChiku2InputDiv getCcdChikuEnd() {
        return ccdChikuEnd;
    }

    /*
     * getccdJyuusyoEnd
     * @return ccdJyuusyoEnd
     */
    @JsonProperty("ccdJyuusyoEnd")
    public IChoikiInputDiv getCcdJyuusyoEnd() {
        return ccdJyuusyoEnd;
    }

    /*
     * getccdChikuStart
     * @return ccdChikuStart
     */
    @JsonProperty("ccdChikuStart")
    public IChiku2InputDiv getCcdChikuStart() {
        return ccdChikuStart;
    }

    /*
     * getccdGyouseiEnd
     * @return ccdGyouseiEnd
     */
    @JsonProperty("ccdGyouseiEnd")
    public IGyoseikuInputDiv getCcdGyouseiEnd() {
        return ccdGyouseiEnd;
    }

    /*
     * getccdGyouseiStart
     * @return ccdGyouseiStart
     */
    @JsonProperty("ccdGyouseiStart")
    public IGyoseikuInputDiv getCcdGyouseiStart() {
        return ccdGyouseiStart;
    }

    /*
     * getInputMode
     * @return InputMode
     */
    @JsonProperty("InputMode")
    public RString getInputMode() {
        return InputMode;
    }

    /*
     * setInputMode
     * @param InputMode InputMode
     */
    @JsonProperty("InputMode")
    public void setInputMode(RString InputMode) {
        this.InputMode = InputMode;
    }

    /*
     * getSearchLevel
     * @return SearchLevel
     */
    @JsonProperty("SearchLevel")
    public RString getSearchLevel() {
        return SearchLevel;
    }

    /*
     * setSearchLevel
     * @param SearchLevel SearchLevel
     */
    @JsonProperty("SearchLevel")
    public void setSearchLevel(RString SearchLevel) {
        this.SearchLevel = SearchLevel;
    }

    // </editor-fold>
}
