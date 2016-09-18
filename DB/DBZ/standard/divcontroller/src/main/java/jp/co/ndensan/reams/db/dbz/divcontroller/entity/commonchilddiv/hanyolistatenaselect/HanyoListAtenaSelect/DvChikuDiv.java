package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hanyolistatenaselect.HanyoListAtenaSelect;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.Chiku1Input.Chiku1InputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.Chiku1Input.IChiku1InputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.Chiku2Input.Chiku2InputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.Chiku2Input.IChiku2InputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.Chiku3Input.Chiku3InputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.Chiku3Input.IChiku3InputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.ChoikiInput.ChoikiInputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.ChoikiInput.IChoikiInputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.GyoseikuInput.GyoseikuInputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.GyoseikuInput.IGyoseikuInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * DvChiku のクラスファイル 
 * 
 * @author 自動生成
 */
public class DvChikuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlChikuSelect")
    private DropDownList ddlChikuSelect;
    @JsonProperty("lblStart")
    private Label lblStart;
    @JsonProperty("ccdJushoFrom")
    private ChoikiInputDiv ccdJushoFrom;
    @JsonProperty("ccdGyoseikuFrom")
    private GyoseikuInputDiv ccdGyoseikuFrom;
    @JsonProperty("ccdChiku1From")
    private Chiku1InputDiv ccdChiku1From;
    @JsonProperty("ccdChiku2From")
    private Chiku2InputDiv ccdChiku2From;
    @JsonProperty("ccdChiku3From")
    private Chiku3InputDiv ccdChiku3From;
    @JsonProperty("lblEnd")
    private Label lblEnd;
    @JsonProperty("ccdJushoTo")
    private ChoikiInputDiv ccdJushoTo;
    @JsonProperty("ccdGyoseikuTo")
    private GyoseikuInputDiv ccdGyoseikuTo;
    @JsonProperty("ccdChiku1To")
    private Chiku1InputDiv ccdChiku1To;
    @JsonProperty("ccdChiku2To")
    private Chiku2InputDiv ccdChiku2To;
    @JsonProperty("ccdChiku3To")
    private Chiku3InputDiv ccdChiku3To;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlChikuSelect
     * @return ddlChikuSelect
     */
    @JsonProperty("ddlChikuSelect")
    public DropDownList getDdlChikuSelect() {
        return ddlChikuSelect;
    }

    /*
     * setddlChikuSelect
     * @param ddlChikuSelect ddlChikuSelect
     */
    @JsonProperty("ddlChikuSelect")
    public void setDdlChikuSelect(DropDownList ddlChikuSelect) {
        this.ddlChikuSelect = ddlChikuSelect;
    }

    /*
     * getlblStart
     * @return lblStart
     */
    @JsonProperty("lblStart")
    public Label getLblStart() {
        return lblStart;
    }

    /*
     * setlblStart
     * @param lblStart lblStart
     */
    @JsonProperty("lblStart")
    public void setLblStart(Label lblStart) {
        this.lblStart = lblStart;
    }

    /*
     * getccdJushoFrom
     * @return ccdJushoFrom
     */
    @JsonProperty("ccdJushoFrom")
    public IChoikiInputDiv getCcdJushoFrom() {
        return ccdJushoFrom;
    }

    /*
     * getccdGyoseikuFrom
     * @return ccdGyoseikuFrom
     */
    @JsonProperty("ccdGyoseikuFrom")
    public IGyoseikuInputDiv getCcdGyoseikuFrom() {
        return ccdGyoseikuFrom;
    }

    /*
     * getccdChiku1From
     * @return ccdChiku1From
     */
    @JsonProperty("ccdChiku1From")
    public IChiku1InputDiv getCcdChiku1From() {
        return ccdChiku1From;
    }

    /*
     * getccdChiku2From
     * @return ccdChiku2From
     */
    @JsonProperty("ccdChiku2From")
    public IChiku2InputDiv getCcdChiku2From() {
        return ccdChiku2From;
    }

    /*
     * getccdChiku3From
     * @return ccdChiku3From
     */
    @JsonProperty("ccdChiku3From")
    public IChiku3InputDiv getCcdChiku3From() {
        return ccdChiku3From;
    }

    /*
     * getlblEnd
     * @return lblEnd
     */
    @JsonProperty("lblEnd")
    public Label getLblEnd() {
        return lblEnd;
    }

    /*
     * setlblEnd
     * @param lblEnd lblEnd
     */
    @JsonProperty("lblEnd")
    public void setLblEnd(Label lblEnd) {
        this.lblEnd = lblEnd;
    }

    /*
     * getccdJushoTo
     * @return ccdJushoTo
     */
    @JsonProperty("ccdJushoTo")
    public IChoikiInputDiv getCcdJushoTo() {
        return ccdJushoTo;
    }

    /*
     * getccdGyoseikuTo
     * @return ccdGyoseikuTo
     */
    @JsonProperty("ccdGyoseikuTo")
    public IGyoseikuInputDiv getCcdGyoseikuTo() {
        return ccdGyoseikuTo;
    }

    /*
     * getccdChiku1To
     * @return ccdChiku1To
     */
    @JsonProperty("ccdChiku1To")
    public IChiku1InputDiv getCcdChiku1To() {
        return ccdChiku1To;
    }

    /*
     * getccdChiku2To
     * @return ccdChiku2To
     */
    @JsonProperty("ccdChiku2To")
    public IChiku2InputDiv getCcdChiku2To() {
        return ccdChiku2To;
    }

    /*
     * getccdChiku3To
     * @return ccdChiku3To
     */
    @JsonProperty("ccdChiku3To")
    public IChiku3InputDiv getCcdChiku3To() {
        return ccdChiku3To;
    }

    // </editor-fold>
}
