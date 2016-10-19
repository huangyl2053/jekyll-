package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0260012;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KyodoJukyushaIdoRenrakuhyo.KyodoJukyushaIdoRenrakuhyo.IKyodoJukyushaIdoRenrakuhyoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KyodoJukyushaIdoRenrakuhyo.KyodoJukyushaIdoRenrakuhyo.KyodoJukyushaIdoRenrakuhyoDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.KanryoMessage.IKanryoMessageDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.KanryoMessage.KanryoMessageDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KyodoIdoRenrakuhyoHenkoMain のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyodoIdoRenrakuhyoHenkoMainDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-07_19-12-57">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KyodoIdoRenrakuhyoHenkoPrint")
    private KyodoIdoRenrakuhyoHenkoPrintDiv KyodoIdoRenrakuhyoHenkoPrint;
    @JsonProperty("hdnFlag")
    private TextBox hdnFlag;
    @JsonProperty("KanryoMessage")
    private KanryoMessageDiv KanryoMessage;
    @JsonProperty("KyodoIdoRenrakuhyoHenkoDetailInfo")
    private KyodoJukyushaIdoRenrakuhyoDiv KyodoIdoRenrakuhyoHenkoDetailInfo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKyodoIdoRenrakuhyoHenkoPrint
     * @return KyodoIdoRenrakuhyoHenkoPrint
     */
    @JsonProperty("KyodoIdoRenrakuhyoHenkoPrint")
    public KyodoIdoRenrakuhyoHenkoPrintDiv getKyodoIdoRenrakuhyoHenkoPrint() {
        return KyodoIdoRenrakuhyoHenkoPrint;
    }

    /*
     * setKyodoIdoRenrakuhyoHenkoPrint
     * @param KyodoIdoRenrakuhyoHenkoPrint KyodoIdoRenrakuhyoHenkoPrint
     */
    @JsonProperty("KyodoIdoRenrakuhyoHenkoPrint")
    public void setKyodoIdoRenrakuhyoHenkoPrint(KyodoIdoRenrakuhyoHenkoPrintDiv KyodoIdoRenrakuhyoHenkoPrint) {
        this.KyodoIdoRenrakuhyoHenkoPrint = KyodoIdoRenrakuhyoHenkoPrint;
    }

    /*
     * gethdnFlag
     * @return hdnFlag
     */
    @JsonProperty("hdnFlag")
    public TextBox getHdnFlag() {
        return hdnFlag;
    }

    /*
     * sethdnFlag
     * @param hdnFlag hdnFlag
     */
    @JsonProperty("hdnFlag")
    public void setHdnFlag(TextBox hdnFlag) {
        this.hdnFlag = hdnFlag;
    }

    /*
     * getKanryoMessage
     * @return KanryoMessage
     */
    @JsonProperty("KanryoMessage")
    public IKanryoMessageDiv getKanryoMessage() {
        return KanryoMessage;
    }

    /*
     * getKyodoIdoRenrakuhyoHenkoDetailInfo
     * @return KyodoIdoRenrakuhyoHenkoDetailInfo
     */
    @JsonProperty("KyodoIdoRenrakuhyoHenkoDetailInfo")
    public IKyodoJukyushaIdoRenrakuhyoDiv getKyodoIdoRenrakuhyoHenkoDetailInfo() {
        return KyodoIdoRenrakuhyoHenkoDetailInfo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public CheckBoxList getChkRensakuhyoHakko() {
        return this.getKyodoIdoRenrakuhyoHenkoPrint().getChkRensakuhyoHakko();
    }

    @JsonIgnore
    public void  setChkRensakuhyoHakko(CheckBoxList chkRensakuhyoHakko) {
        this.getKyodoIdoRenrakuhyoHenkoPrint().setChkRensakuhyoHakko(chkRensakuhyoHakko);
    }

    @JsonIgnore
    public ButtonReportPublish getBtnReportPublish() {
        return this.getKyodoIdoRenrakuhyoHenkoPrint().getBtnReportPublish();
    }

    @JsonIgnore
    public void  setBtnReportPublish(ButtonReportPublish btnReportPublish) {
        this.getKyodoIdoRenrakuhyoHenkoPrint().setBtnReportPublish(btnReportPublish);
    }

    @JsonIgnore
    public HorizontalLine getLin01() {
        return this.getKyodoIdoRenrakuhyoHenkoPrint().getLin01();
    }

    @JsonIgnore
    public void  setLin01(HorizontalLine lin01) {
        this.getKyodoIdoRenrakuhyoHenkoPrint().setLin01(lin01);
    }

    @JsonIgnore
    public RadioButton getRadTeiseiKomokuHantei() {
        return this.getKyodoIdoRenrakuhyoHenkoPrint().getRadTeiseiKomokuHantei();
    }

    @JsonIgnore
    public void  setRadTeiseiKomokuHantei(RadioButton radTeiseiKomokuHantei) {
        this.getKyodoIdoRenrakuhyoHenkoPrint().setRadTeiseiKomokuHantei(radTeiseiKomokuHantei);
    }

    // </editor-fold>
}
