package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1040011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.Hihosyosai.Hihosyosai.IHihosyosaiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.IKaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.IKaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShikakuHenkouIdou のクラスファイル
 *
 * @author 自動生成
 */
public class ShikakuHenkouIdouDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
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
    @JsonProperty("ShosaiJoho")
    private ShosaiJohoDiv ShosaiJoho;

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
     * getShosaiJoho
     * @return ShosaiJoho
     */
    @JsonProperty("ShosaiJoho")
    public ShosaiJohoDiv getShosaiJoho() {
        return ShosaiJoho;
    }

    /*
     * setShosaiJoho
     * @param ShosaiJoho ShosaiJoho
     */
    @JsonProperty("ShosaiJoho")
    public void setShosaiJoho(ShosaiJohoDiv ShosaiJoho) {
        this.ShosaiJoho = ShosaiJoho;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public IKaigoKanryoMessageDiv getCcdKaigoKanryoMessage() {
        return this.getComplete().getCcdKaigoKanryoMessage();
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
    public IHihosyosaiDiv getCcdHihosyosai() {
        return this.getShosaiJoho().getCcdHihosyosai();
    }

    // </editor-fold>
}
