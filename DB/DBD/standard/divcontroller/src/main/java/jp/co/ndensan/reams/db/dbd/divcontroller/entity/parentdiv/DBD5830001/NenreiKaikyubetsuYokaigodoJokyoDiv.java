package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5830001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.Chiku2Input.Chiku2InputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.Chiku2Input.IChiku2InputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.ChoikiInput.ChoikiInputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.ChoikiInput.IChoikiInputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.GyoseikuInput.GyoseikuInputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.GyoseikuInput.IGyoseikuInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NenreiKaikyubetsuYokaigodoJokyo のクラスファイル 
 * 
 * @author 自動生成
 */
public class NenreiKaikyubetsuYokaigodoJokyoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tp1")
    private tp1Div tp1;
    @JsonProperty("hLine1")
    private HorizontalLine hLine1;
    @JsonProperty("lblChiku")
    private Label lblChiku;
    @JsonProperty("ddlChiku")
    private DropDownList ddlChiku;
    @JsonProperty("ddlShichoson")
    private DropDownList ddlShichoson;
    @JsonProperty("lblGyoseikuStart")
    private Label lblGyoseikuStart;
    @JsonProperty("lblGyoseikuEnd")
    private Label lblGyoseikuEnd;
    @JsonProperty("lblChiku2Start")
    private Label lblChiku2Start;
    @JsonProperty("lblChiku2End")
    private Label lblChiku2End;
    @JsonProperty("lblJyushoStart")
    private Label lblJyushoStart;
    @JsonProperty("lblJyushoEnd")
    private Label lblJyushoEnd;
    @JsonProperty("hLine2")
    private HorizontalLine hLine2;
    @JsonProperty("lblComment")
    private Label lblComment;
    @JsonProperty("ccdChoikiStart")
    private ChoikiInputDiv ccdChoikiStart;
    @JsonProperty("ccsGyoseikuEnd")
    private GyoseikuInputDiv ccsGyoseikuEnd;
    @JsonProperty("ccdGyoseikuStart")
    private GyoseikuInputDiv ccdGyoseikuStart;
    @JsonProperty("ccdChiku2Start")
    private Chiku2InputDiv ccdChiku2Start;
    @JsonProperty("ccdChiku2End")
    private Chiku2InputDiv ccdChiku2End;
    @JsonProperty("ccdChoikiEnd")
    private ChoikiInputDiv ccdChoikiEnd;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettp1
     * @return tp1
     */
    @JsonProperty("tp1")
    public tp1Div getTp1() {
        return tp1;
    }

    /*
     * settp1
     * @param tp1 tp1
     */
    @JsonProperty("tp1")
    public void setTp1(tp1Div tp1) {
        this.tp1 = tp1;
    }

    /*
     * gethLine1
     * @return hLine1
     */
    @JsonProperty("hLine1")
    public HorizontalLine getHLine1() {
        return hLine1;
    }

    /*
     * sethLine1
     * @param hLine1 hLine1
     */
    @JsonProperty("hLine1")
    public void setHLine1(HorizontalLine hLine1) {
        this.hLine1 = hLine1;
    }

    /*
     * getlblChiku
     * @return lblChiku
     */
    @JsonProperty("lblChiku")
    public Label getLblChiku() {
        return lblChiku;
    }

    /*
     * setlblChiku
     * @param lblChiku lblChiku
     */
    @JsonProperty("lblChiku")
    public void setLblChiku(Label lblChiku) {
        this.lblChiku = lblChiku;
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
     * getddlShichoson
     * @return ddlShichoson
     */
    @JsonProperty("ddlShichoson")
    public DropDownList getDdlShichoson() {
        return ddlShichoson;
    }

    /*
     * setddlShichoson
     * @param ddlShichoson ddlShichoson
     */
    @JsonProperty("ddlShichoson")
    public void setDdlShichoson(DropDownList ddlShichoson) {
        this.ddlShichoson = ddlShichoson;
    }

    /*
     * getlblGyoseikuStart
     * @return lblGyoseikuStart
     */
    @JsonProperty("lblGyoseikuStart")
    public Label getLblGyoseikuStart() {
        return lblGyoseikuStart;
    }

    /*
     * setlblGyoseikuStart
     * @param lblGyoseikuStart lblGyoseikuStart
     */
    @JsonProperty("lblGyoseikuStart")
    public void setLblGyoseikuStart(Label lblGyoseikuStart) {
        this.lblGyoseikuStart = lblGyoseikuStart;
    }

    /*
     * getlblGyoseikuEnd
     * @return lblGyoseikuEnd
     */
    @JsonProperty("lblGyoseikuEnd")
    public Label getLblGyoseikuEnd() {
        return lblGyoseikuEnd;
    }

    /*
     * setlblGyoseikuEnd
     * @param lblGyoseikuEnd lblGyoseikuEnd
     */
    @JsonProperty("lblGyoseikuEnd")
    public void setLblGyoseikuEnd(Label lblGyoseikuEnd) {
        this.lblGyoseikuEnd = lblGyoseikuEnd;
    }

    /*
     * getlblChiku2Start
     * @return lblChiku2Start
     */
    @JsonProperty("lblChiku2Start")
    public Label getLblChiku2Start() {
        return lblChiku2Start;
    }

    /*
     * setlblChiku2Start
     * @param lblChiku2Start lblChiku2Start
     */
    @JsonProperty("lblChiku2Start")
    public void setLblChiku2Start(Label lblChiku2Start) {
        this.lblChiku2Start = lblChiku2Start;
    }

    /*
     * getlblChiku2End
     * @return lblChiku2End
     */
    @JsonProperty("lblChiku2End")
    public Label getLblChiku2End() {
        return lblChiku2End;
    }

    /*
     * setlblChiku2End
     * @param lblChiku2End lblChiku2End
     */
    @JsonProperty("lblChiku2End")
    public void setLblChiku2End(Label lblChiku2End) {
        this.lblChiku2End = lblChiku2End;
    }

    /*
     * getlblJyushoStart
     * @return lblJyushoStart
     */
    @JsonProperty("lblJyushoStart")
    public Label getLblJyushoStart() {
        return lblJyushoStart;
    }

    /*
     * setlblJyushoStart
     * @param lblJyushoStart lblJyushoStart
     */
    @JsonProperty("lblJyushoStart")
    public void setLblJyushoStart(Label lblJyushoStart) {
        this.lblJyushoStart = lblJyushoStart;
    }

    /*
     * getlblJyushoEnd
     * @return lblJyushoEnd
     */
    @JsonProperty("lblJyushoEnd")
    public Label getLblJyushoEnd() {
        return lblJyushoEnd;
    }

    /*
     * setlblJyushoEnd
     * @param lblJyushoEnd lblJyushoEnd
     */
    @JsonProperty("lblJyushoEnd")
    public void setLblJyushoEnd(Label lblJyushoEnd) {
        this.lblJyushoEnd = lblJyushoEnd;
    }

    /*
     * gethLine2
     * @return hLine2
     */
    @JsonProperty("hLine2")
    public HorizontalLine getHLine2() {
        return hLine2;
    }

    /*
     * sethLine2
     * @param hLine2 hLine2
     */
    @JsonProperty("hLine2")
    public void setHLine2(HorizontalLine hLine2) {
        this.hLine2 = hLine2;
    }

    /*
     * getlblComment
     * @return lblComment
     */
    @JsonProperty("lblComment")
    public Label getLblComment() {
        return lblComment;
    }

    /*
     * setlblComment
     * @param lblComment lblComment
     */
    @JsonProperty("lblComment")
    public void setLblComment(Label lblComment) {
        this.lblComment = lblComment;
    }

    /*
     * getccdChoikiStart
     * @return ccdChoikiStart
     */
    @JsonProperty("ccdChoikiStart")
    public IChoikiInputDiv getCcdChoikiStart() {
        return ccdChoikiStart;
    }

    /*
     * getccsGyoseikuEnd
     * @return ccsGyoseikuEnd
     */
    @JsonProperty("ccsGyoseikuEnd")
    public IGyoseikuInputDiv getCcsGyoseikuEnd() {
        return ccsGyoseikuEnd;
    }

    /*
     * getccdGyoseikuStart
     * @return ccdGyoseikuStart
     */
    @JsonProperty("ccdGyoseikuStart")
    public IGyoseikuInputDiv getCcdGyoseikuStart() {
        return ccdGyoseikuStart;
    }

    /*
     * getccdChiku2Start
     * @return ccdChiku2Start
     */
    @JsonProperty("ccdChiku2Start")
    public IChiku2InputDiv getCcdChiku2Start() {
        return ccdChiku2Start;
    }

    /*
     * getccdChiku2End
     * @return ccdChiku2End
     */
    @JsonProperty("ccdChiku2End")
    public IChiku2InputDiv getCcdChiku2End() {
        return ccdChiku2End;
    }

    /*
     * getccdChoikiEnd
     * @return ccdChoikiEnd
     */
    @JsonProperty("ccdChoikiEnd")
    public IChoikiInputDiv getCcdChoikiEnd() {
        return ccdChoikiEnd;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRdoKijyun() {
        return this.getTp1().getRdoKijyun();
    }

    @JsonIgnore
    public TextBoxDate getTxtKijyunD() {
        return this.getTp1().getTxtKijyunD();
    }

    @JsonIgnore
    public TextBoxDate getTxtKijyunYM() {
        return this.getTp1().getTxtKijyunYM();
    }

    // </editor-fold>
}
