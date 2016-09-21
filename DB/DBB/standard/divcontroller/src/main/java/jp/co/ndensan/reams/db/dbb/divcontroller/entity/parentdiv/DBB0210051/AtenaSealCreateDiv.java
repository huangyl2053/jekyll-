package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0210051;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatesakijushosettei.KaigoAtesakiJushoSettei.IKaigoAtesakiJushoSetteiDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.AtenaSealPositionInput.AtenaSealPositionInputDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.AtenaSealPositionInput.IAtenaSealPositionInputDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * AtenaSealCreate のクラスファイル
 *
 * reamsid_L DBB-5660-010 wangxingpeng
 */
public class AtenaSealCreateDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("CyushutsuJoken")
    private CyushutsuJokenDiv CyushutsuJoken;
    @JsonProperty("HensyuHoho")
    private HensyuHohoDiv HensyuHoho;
    @JsonProperty("ccdAtenaSealPosition")
    private AtenaSealPositionInputDiv ccdAtenaSealPosition;
    @JsonProperty("ccdShutsuryokuJun")
    private ChohyoShutsuryokujunDiv ccdShutsuryokuJun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getCyushutsuJoken
     * @return CyushutsuJoken
     */
    @JsonProperty("CyushutsuJoken")
    public CyushutsuJokenDiv getCyushutsuJoken() {
        return CyushutsuJoken;
    }

    /*
     * setCyushutsuJoken
     * @param CyushutsuJoken CyushutsuJoken
     */
    @JsonProperty("CyushutsuJoken")
    public void setCyushutsuJoken(CyushutsuJokenDiv CyushutsuJoken) {
        this.CyushutsuJoken = CyushutsuJoken;
    }

    /*
     * getHensyuHoho
     * @return HensyuHoho
     */
    @JsonProperty("HensyuHoho")
    public HensyuHohoDiv getHensyuHoho() {
        return HensyuHoho;
    }

    /*
     * setHensyuHoho
     * @param HensyuHoho HensyuHoho
     */
    @JsonProperty("HensyuHoho")
    public void setHensyuHoho(HensyuHohoDiv HensyuHoho) {
        this.HensyuHoho = HensyuHoho;
    }

    /*
     * getccdAtenaSealPosition
     * @return ccdAtenaSealPosition
     */
    @JsonProperty("ccdAtenaSealPosition")
    public IAtenaSealPositionInputDiv getCcdAtenaSealPosition() {
        return ccdAtenaSealPosition;
    }

    /*
     * getccdShutsuryokuJun
     * @return ccdShutsuryokuJun
     */
    @JsonProperty("ccdShutsuryokuJun")
    public IChohyoShutsuryokujunDiv getCcdShutsuryokuJun() {
        return ccdShutsuryokuJun;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public CheckBoxList getChkTaishosha() {
        return this.getCyushutsuJoken().getChkTaishosha();
    }

    @JsonIgnore
    public void setChkTaishosha(CheckBoxList chkTaishosha) {
        this.getCyushutsuJoken().setChkTaishosha(chkTaishosha);
    }

    @JsonIgnore
    public Label getLblCyushutuKikan() {
        return this.getCyushutsuJoken().getLblCyushutuKikan();
    }

    @JsonIgnore
    public void setLblCyushutuKikan(Label lblCyushutuKikan) {
        this.getCyushutsuJoken().setLblCyushutuKikan(lblCyushutuKikan);
    }

    @JsonIgnore
    public Label getLblKijyunnengatu() {
        return this.getCyushutsuJoken().getLblKijyunnengatu();
    }

    @JsonIgnore
    public void setLblKijyunnengatu(Label lblKijyunnengatu) {
        this.getCyushutsuJoken().setLblKijyunnengatu(lblKijyunnengatu);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKijyunnengatu() {
        return this.getCyushutsuJoken().getTxtKijyunnengatu();
    }

    @JsonIgnore
    public void setTxtKijyunnengatu(TextBoxFlexibleDate txtKijyunnengatu) {
        this.getCyushutsuJoken().setTxtKijyunnengatu(txtKijyunnengatu);
    }

    @JsonIgnore
    public DropDownList getDdlShikakuKubun() {
        return this.getCyushutsuJoken().getDdlShikakuKubun();
    }

    @JsonIgnore
    public void setDdlShikakuKubun(DropDownList ddlShikakuKubun) {
        this.getCyushutsuJoken().setDdlShikakuKubun(ddlShikakuKubun);
    }

    @JsonIgnore
    public DropDownList getDdlShicyouson() {
        return this.getCyushutsuJoken().getDdlShicyouson();
    }

    @JsonIgnore
    public void setDdlShicyouson(DropDownList ddlShicyouson) {
        this.getCyushutsuJoken().setDdlShicyouson(ddlShicyouson);
    }

    @JsonIgnore
    public DropDownList getDdlSaiyusenJusho() {
        return this.getHensyuHoho().getDdlSaiyusenJusho();
    }

    @JsonIgnore
    public void setDdlSaiyusenJusho(DropDownList ddlSaiyusenJusho) {
        this.getHensyuHoho().setDdlSaiyusenJusho(ddlSaiyusenJusho);
    }

    @JsonIgnore
    public DropDownList getDdlKeisho() {
        return this.getHensyuHoho().getDdlKeisho();
    }

    @JsonIgnore
    public void setDdlKeisho(DropDownList ddlKeisho) {
        this.getHensyuHoho().setDdlKeisho(ddlKeisho);
    }

    @JsonIgnore
    public RadioButton getRadIsPrintHihokenshaNo() {
        return this.getHensyuHoho().getRadIsPrintHihokenshaNo();
    }

    @JsonIgnore
    public void setRadIsPrintHihokenshaNo(RadioButton radIsPrintHihokenshaNo) {
        this.getHensyuHoho().setRadIsPrintHihokenshaNo(radIsPrintHihokenshaNo);
    }

    @JsonIgnore
    public IKaigoAtesakiJushoSetteiDiv getCcdJushoSettei() {
        return this.getHensyuHoho().getCcdJushoSettei();
    }

    // </editor-fold>
}
