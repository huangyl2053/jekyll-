package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1050011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.IryoHokenRirekiDialogButton.IIryoHokenRirekiDialogButtonDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.IryoHokenRirekiDialogButton.IryoHokenRirekiDialogButtonDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.RofukuNenkinDialogButton.IRofukuNenkinDialogButtonDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.RofukuNenkinDialogButton.RofukuNenkinDialogButtonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.IKaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.KaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShikakuTokusoRireki.IShikakuTokusoRirekiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShikakuTokusoRireki.ShikakuTokusoRirekiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.IKaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SikakuIdouTeisei のクラスファイル 
 * 
 * @author 自動生成
 */
public class SikakuIdouTeiseiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-06_01-12-04">
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
    public IIryoHokenRirekiDialogButtonDiv getCcdIryoHokenDialogButton() {
        return this.getShikakuShutokuJoho().getCcdIryoHokenDialogButton();
    }

    @JsonIgnore
    public IRofukuNenkinDialogButtonDiv getCcdRofukuNenkinDialogButton() {
        return this.getShikakuShutokuJoho().getCcdRofukuNenkinDialogButton();
    }

    @JsonIgnore
    public HorizontalLine getLinShikakuTokuso() {
        return this.getShikakuShutokuJoho().getLinShikakuTokuso();
    }

    @JsonIgnore
    public void  setLinShikakuTokuso(HorizontalLine linShikakuTokuso) {
        this.getShikakuShutokuJoho().setLinShikakuTokuso(linShikakuTokuso);
    }

    @JsonIgnore
    public IShikakuTokusoRirekiDiv getCcdShikakuTokusoRireki() {
        return this.getShikakuShutokuJoho().getCcdShikakuTokusoRireki();
    }

    // </editor-fold>
}
