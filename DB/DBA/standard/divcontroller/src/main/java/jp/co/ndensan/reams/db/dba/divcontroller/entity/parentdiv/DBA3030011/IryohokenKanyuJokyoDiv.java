package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA3030011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.IKaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * IryohokenKanyuJokyo のクラスファイル 
 * 
 * @author 自動生成
 */
public class IryohokenKanyuJokyoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KihonJoho")
    private KihonJohoDiv KihonJoho;
    @JsonProperty("IryoHokenIchiran")
    private IryoHokenIchiranDiv IryoHokenIchiran;
    @JsonProperty("KaigoKanryoyoMessage")
    private KaigoKanryoyoMessageDiv KaigoKanryoyoMessage;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
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
     * getIryoHokenIchiran
     * @return IryoHokenIchiran
     */
    @JsonProperty("IryoHokenIchiran")
    public IryoHokenIchiranDiv getIryoHokenIchiran() {
        return IryoHokenIchiran;
    }

    /*
     * setIryoHokenIchiran
     * @param IryoHokenIchiran IryoHokenIchiran
     */
    @JsonProperty("IryoHokenIchiran")
    public void setIryoHokenIchiran(IryoHokenIchiranDiv IryoHokenIchiran) {
        this.IryoHokenIchiran = IryoHokenIchiran;
    }

    /*
     * getKaigoKanryoyoMessage
     * @return KaigoKanryoyoMessage
     */
    @JsonProperty("KaigoKanryoyoMessage")
    public KaigoKanryoyoMessageDiv getKaigoKanryoyoMessage() {
        return KaigoKanryoyoMessage;
    }

    /*
     * setKaigoKanryoyoMessage
     * @param KaigoKanryoyoMessage KaigoKanryoyoMessage
     */
    @JsonProperty("KaigoKanryoyoMessage")
    public void setKaigoKanryoyoMessage(KaigoKanryoyoMessageDiv KaigoKanryoyoMessage) {
        this.KaigoKanryoyoMessage = KaigoKanryoyoMessage;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public IKaigoShikakuKihonDiv getCcdKaigoShikakuKihon() {
        return this.getKihonJoho().getCcdKaigoShikakuKihon();
    }

    @JsonIgnore
    public IKaigoAtenaInfoDiv getCcdKaigoAtenaInfo() {
        return this.getKihonJoho().getCcdKaigoAtenaInfo();
    }

    // </editor-fold>
}
