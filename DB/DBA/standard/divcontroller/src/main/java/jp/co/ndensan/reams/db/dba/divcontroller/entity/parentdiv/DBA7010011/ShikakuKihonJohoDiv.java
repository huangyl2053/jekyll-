package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA7010011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.IKaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShikakuKihonJoho のクラスファイル
 *
 * @reamsid_L DBA-0380-020 houtp
 */
public class ShikakuKihonJohoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("TajutokuTekiyoJohoIchiran")
    private TajutokuTekiyoJohoIchiranDiv TajutokuTekiyoJohoIchiran;
    @JsonProperty("ccdKaigoShikakuJoho")
    private KaigoShikakuKihonDiv ccdKaigoShikakuJoho;
    @JsonProperty("ccdKaigoAtenaInfo")
    private KaigoAtenaInfoDiv ccdKaigoAtenaInfo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getTajutokuTekiyoJohoIchiran
     * @return TajutokuTekiyoJohoIchiran
     */
    @JsonProperty("TajutokuTekiyoJohoIchiran")
    public TajutokuTekiyoJohoIchiranDiv getTajutokuTekiyoJohoIchiran() {
        return TajutokuTekiyoJohoIchiran;
    }

    /*
     * setTajutokuTekiyoJohoIchiran
     * @param TajutokuTekiyoJohoIchiran TajutokuTekiyoJohoIchiran
     */
    @JsonProperty("TajutokuTekiyoJohoIchiran")
    public void setTajutokuTekiyoJohoIchiran(TajutokuTekiyoJohoIchiranDiv TajutokuTekiyoJohoIchiran) {
        this.TajutokuTekiyoJohoIchiran = TajutokuTekiyoJohoIchiran;
    }

    /*
     * getccdKaigoShikakuJoho
     * @return ccdKaigoShikakuJoho
     */
    @JsonProperty("ccdKaigoShikakuJoho")
    public IKaigoShikakuKihonDiv getCcdKaigoShikakuJoho() {
        return ccdKaigoShikakuJoho;
    }

    /*
     * getccdKaigoAtenaInfo
     * @return ccdKaigoAtenaInfo
     */
    @JsonProperty("ccdKaigoAtenaInfo")
    public IKaigoAtenaInfoDiv getCcdKaigoAtenaInfo() {
        return ccdKaigoAtenaInfo;
    }

    // </editor-fold>
}
