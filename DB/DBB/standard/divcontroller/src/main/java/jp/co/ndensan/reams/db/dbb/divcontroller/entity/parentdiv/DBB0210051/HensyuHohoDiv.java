package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0210051;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatesakijushosettei.KaigoAtesakiJushoSettei.IKaigoAtesakiJushoSetteiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatesakijushosettei.KaigoAtesakiJushoSettei.KaigoAtesakiJushoSetteiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;

/**
 * HensyuHoho のクラスファイル
 *
 * reamsid_L DBB-5660-010 wangxingpeng
 */
public class HensyuHohoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlSaiyusenJusho")
    private DropDownList ddlSaiyusenJusho;
    @JsonProperty("ddlKeisho")
    private DropDownList ddlKeisho;
    @JsonProperty("radIsPrintHihokenshaNo")
    private RadioButton radIsPrintHihokenshaNo;
    @JsonProperty("ccdJushoSettei")
    private KaigoAtesakiJushoSetteiDiv ccdJushoSettei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlSaiyusenJusho
     * @return ddlSaiyusenJusho
     */
    @JsonProperty("ddlSaiyusenJusho")
    public DropDownList getDdlSaiyusenJusho() {
        return ddlSaiyusenJusho;
    }

    /*
     * setddlSaiyusenJusho
     * @param ddlSaiyusenJusho ddlSaiyusenJusho
     */
    @JsonProperty("ddlSaiyusenJusho")
    public void setDdlSaiyusenJusho(DropDownList ddlSaiyusenJusho) {
        this.ddlSaiyusenJusho = ddlSaiyusenJusho;
    }

    /*
     * getddlKeisho
     * @return ddlKeisho
     */
    @JsonProperty("ddlKeisho")
    public DropDownList getDdlKeisho() {
        return ddlKeisho;
    }

    /*
     * setddlKeisho
     * @param ddlKeisho ddlKeisho
     */
    @JsonProperty("ddlKeisho")
    public void setDdlKeisho(DropDownList ddlKeisho) {
        this.ddlKeisho = ddlKeisho;
    }

    /*
     * getradIsPrintHihokenshaNo
     * @return radIsPrintHihokenshaNo
     */
    @JsonProperty("radIsPrintHihokenshaNo")
    public RadioButton getRadIsPrintHihokenshaNo() {
        return radIsPrintHihokenshaNo;
    }

    /*
     * setradIsPrintHihokenshaNo
     * @param radIsPrintHihokenshaNo radIsPrintHihokenshaNo
     */
    @JsonProperty("radIsPrintHihokenshaNo")
    public void setRadIsPrintHihokenshaNo(RadioButton radIsPrintHihokenshaNo) {
        this.radIsPrintHihokenshaNo = radIsPrintHihokenshaNo;
    }

    /*
     * getccdJushoSettei
     * @return ccdJushoSettei
     */
    @JsonProperty("ccdJushoSettei")
    public IKaigoAtesakiJushoSetteiDiv getCcdJushoSettei() {
        return ccdJushoSettei;
    }

    // </editor-fold>
}
