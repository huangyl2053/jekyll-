package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5810001;
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
 * JokenPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class JokenPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tpNenrei")
    private tpNenreiDiv tpNenrei;
    @JsonProperty("lblChiku")
    private Label lblChiku;
    @JsonProperty("ddlChiku")
    private DropDownList ddlChiku;
    @JsonProperty("ccdJyuusyoStart")
    private ChoikiInputDiv ccdJyuusyoStart;
    @JsonProperty("ccdGyouseiEnd")
    private GyoseikuInputDiv ccdGyouseiEnd;
    @JsonProperty("ccdChikuEnd")
    private Chiku2InputDiv ccdChikuEnd;
    @JsonProperty("ccdGyouseiStart")
    private GyoseikuInputDiv ccdGyouseiStart;
    @JsonProperty("ccdJyuusyoEnd")
    private ChoikiInputDiv ccdJyuusyoEnd;
    @JsonProperty("ccdChikuStart")
    private Chiku2InputDiv ccdChikuStart;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettpNenrei
     * @return tpNenrei
     */
    @JsonProperty("tpNenrei")
    public tpNenreiDiv getTpNenrei() {
        return tpNenrei;
    }

    /*
     * settpNenrei
     * @param tpNenrei tpNenrei
     */
    @JsonProperty("tpNenrei")
    public void setTpNenrei(tpNenreiDiv tpNenrei) {
        this.tpNenrei = tpNenrei;
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
     * getccdJyuusyoStart
     * @return ccdJyuusyoStart
     */
    @JsonProperty("ccdJyuusyoStart")
    public IChoikiInputDiv getCcdJyuusyoStart() {
        return ccdJyuusyoStart;
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
     * getccdChikuEnd
     * @return ccdChikuEnd
     */
    @JsonProperty("ccdChikuEnd")
    public IChiku2InputDiv getCcdChikuEnd() {
        return ccdChikuEnd;
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
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRdoNenrei() {
        return this.getTpNenrei().getRdoNenrei();
    }

    @JsonIgnore
    public TextBoxNumRange getTxtNenrei() {
        return this.getTpNenrei().getTxtNenrei();
    }

    @JsonIgnore
    public TextBoxDate getTxtNenreikijyun() {
        return this.getTpNenrei().getTxtNenreikijyun();
    }

    @JsonIgnore
    public TextBoxDateRange getTxtSeinen() {
        return this.getTpNenrei().getTxtSeinen();
    }

    // </editor-fold>
}
