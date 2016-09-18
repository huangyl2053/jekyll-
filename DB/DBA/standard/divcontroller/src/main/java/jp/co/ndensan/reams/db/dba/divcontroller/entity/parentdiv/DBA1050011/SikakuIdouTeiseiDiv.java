package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1050011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.IryohokenRirekiCommonChildDiv.IIryohokenRirekiCommonChildDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.IryohokenRirekiCommonChildDiv.IryohokenRirekiCommonChildDivDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.IKaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.KaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.RoreiFukushiNenkinShokai.IRoreiFukushiNenkinShokaiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.RoreiFukushiNenkinShokai.RoreiFukushiNenkinShokaiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShikakuTokusoRireki.IShikakuTokusoRirekiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShikakuTokusoRireki.ShikakuTokusoRirekiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.IKaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SikakuIdouTeisei のクラスファイル 
 * 
 * @author 自動生成
 */
public class SikakuIdouTeiseiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("Complete")
    private CompleteDiv Complete;
    @JsonProperty("KihonJoho")
    private KihonJohoDiv KihonJoho;
    @JsonProperty("ShikakuShutokuJoho")
    private ShikakuShutokuJohoDiv ShikakuShutokuJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getComplete
     * @return Complete
     */
    @JsonProperty("Complete")
    public CompleteDiv getComplete() {
        return Complete;
    }

    /*
     * setComplete
     * @param Complete Complete
     */
    @JsonProperty("Complete")
    public void setComplete(CompleteDiv Complete) {
        this.Complete = Complete;
    }

    /*
     * getKihonJoho
     * @return KihonJoho
     */
    @JsonProperty("KihonJoho")
    public KihonJohoDiv getKihonJoho() {
        return KihonJoho;
    }

    /*
     * setKihonJoho
     * @param KihonJoho KihonJoho
     */
    @JsonProperty("KihonJoho")
    public void setKihonJoho(KihonJohoDiv KihonJoho) {
        this.KihonJoho = KihonJoho;
    }

    /*
     * getShikakuShutokuJoho
     * @return ShikakuShutokuJoho
     */
    @JsonProperty("ShikakuShutokuJoho")
    public ShikakuShutokuJohoDiv getShikakuShutokuJoho() {
        return ShikakuShutokuJoho;
    }

    /*
     * setShikakuShutokuJoho
     * @param ShikakuShutokuJoho ShikakuShutokuJoho
     */
    @JsonProperty("ShikakuShutokuJoho")
    public void setShikakuShutokuJoho(ShikakuShutokuJohoDiv ShikakuShutokuJoho) {
        this.ShikakuShutokuJoho = ShikakuShutokuJoho;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public IKaigoKanryoMessageDiv getCcdComplete() {
        return this.getComplete().getCcdComplete();
    }

    @JsonIgnore
    public IKaigoShikakuKihonDiv getCcdKaigoShikakuKihon() {
        return this.getKihonJoho().getCcdKaigoShikakuKihon();
    }

    @JsonIgnore
    public IKaigoAtenaInfoDiv getCcdKaigoAtenaInfo() {
        return this.getKihonJoho().getCcdKaigoAtenaInfo();
    }

    @JsonIgnore
    public tabInputsDiv getTabInputs() {
        return this.getShikakuShutokuJoho().getTabInputs();
    }

    @JsonIgnore
    public void  setTabInputs(tabInputsDiv tabInputs) {
        this.getShikakuShutokuJoho().setTabInputs(tabInputs);
    }

    @JsonIgnore
    public tplShikakuJohoDiv getTplShikakuJoho() {
        return this.getShikakuShutokuJoho().getTabInputs().getTplShikakuJoho();
    }

    @JsonIgnore
    public void  setTplShikakuJoho(tplShikakuJohoDiv tplShikakuJoho) {
        this.getShikakuShutokuJoho().getTabInputs().setTplShikakuJoho(tplShikakuJoho);
    }

    @JsonIgnore
    public ShikakuTokusoRirekiiDiv getShikakuTokusoRirekii() {
        return this.getShikakuShutokuJoho().getTabInputs().getTplShikakuJoho().getShikakuTokusoRirekii();
    }

    @JsonIgnore
    public void  setShikakuTokusoRirekii(ShikakuTokusoRirekiiDiv ShikakuTokusoRirekii) {
        this.getShikakuShutokuJoho().getTabInputs().getTplShikakuJoho().setShikakuTokusoRirekii(ShikakuTokusoRirekii);
    }

    @JsonIgnore
    public IShikakuTokusoRirekiDiv getCcdShikakuTokusoRireki() {
        return this.getShikakuShutokuJoho().getTabInputs().getTplShikakuJoho().getShikakuTokusoRirekii().getCcdShikakuTokusoRireki();
    }

    @JsonIgnore
    public tplIryoHokenDiv getTplIryoHoken() {
        return this.getShikakuShutokuJoho().getTabInputs().getTplIryoHoken();
    }

    @JsonIgnore
    public void  setTplIryoHoken(tplIryoHokenDiv tplIryoHoken) {
        this.getShikakuShutokuJoho().getTabInputs().setTplIryoHoken(tplIryoHoken);
    }

    @JsonIgnore
    public IryoHokenRirekiiDiv getIryoHokenRirekii() {
        return this.getShikakuShutokuJoho().getTabInputs().getTplIryoHoken().getIryoHokenRirekii();
    }

    @JsonIgnore
    public void  setIryoHokenRirekii(IryoHokenRirekiiDiv IryoHokenRirekii) {
        this.getShikakuShutokuJoho().getTabInputs().getTplIryoHoken().setIryoHokenRirekii(IryoHokenRirekii);
    }

    @JsonIgnore
    public IIryohokenRirekiCommonChildDiv getCcdIryoHokenRireki() {
        return this.getShikakuShutokuJoho().getTabInputs().getTplIryoHoken().getIryoHokenRirekii().getCcdIryoHokenRireki();
    }

    @JsonIgnore
    public tplRofukuNenkinDiv getTplRofukuNenkin() {
        return this.getShikakuShutokuJoho().getTabInputs().getTplRofukuNenkin();
    }

    @JsonIgnore
    public void  setTplRofukuNenkin(tplRofukuNenkinDiv tplRofukuNenkin) {
        this.getShikakuShutokuJoho().getTabInputs().setTplRofukuNenkin(tplRofukuNenkin);
    }

    @JsonIgnore
    public RohukuNenkinDiv getRohukuNenkin() {
        return this.getShikakuShutokuJoho().getTabInputs().getTplRofukuNenkin().getRohukuNenkin();
    }

    @JsonIgnore
    public void  setRohukuNenkin(RohukuNenkinDiv RohukuNenkin) {
        this.getShikakuShutokuJoho().getTabInputs().getTplRofukuNenkin().setRohukuNenkin(RohukuNenkin);
    }

    @JsonIgnore
    public IRoreiFukushiNenkinShokaiDiv getCcdRohukuNenkin() {
        return this.getShikakuShutokuJoho().getTabInputs().getTplRofukuNenkin().getRohukuNenkin().getCcdRohukuNenkin();
    }

    // </editor-fold>
}
