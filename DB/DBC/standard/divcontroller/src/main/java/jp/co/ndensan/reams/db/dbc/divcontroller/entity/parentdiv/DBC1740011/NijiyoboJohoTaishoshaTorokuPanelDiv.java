package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1740011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.IKaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.KaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.IKaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NijiyoboJohoTaishoshaTorokuPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class NijiyoboJohoTaishoshaTorokuPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-07_19-12-57">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("NijiyoboTaishosha")
    private NijiyoboTaishoshaDiv NijiyoboTaishosha;
    @JsonProperty("NijiyoboJohoTaishoIchiran")
    private NijiyoboJohoTaishoIchiranDiv NijiyoboJohoTaishoIchiran;
    @JsonProperty("NijiyoboJohoShosai")
    private NijiyoboJohoShosaiDiv NijiyoboJohoShosai;
    @JsonProperty("ccdKanryoMessage")
    private KaigoKanryoMessageDiv ccdKanryoMessage;
    @JsonProperty("operateState")
    private RString operateState;
    @JsonProperty("被保険者番号")
    private RString 被保険者番号;
    @JsonProperty("識別コード")
    private RString 識別コード;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getNijiyoboTaishosha
     * @return NijiyoboTaishosha
     */
    @JsonProperty("NijiyoboTaishosha")
    public NijiyoboTaishoshaDiv getNijiyoboTaishosha() {
        return NijiyoboTaishosha;
    }

    /*
     * setNijiyoboTaishosha
     * @param NijiyoboTaishosha NijiyoboTaishosha
     */
    @JsonProperty("NijiyoboTaishosha")
    public void setNijiyoboTaishosha(NijiyoboTaishoshaDiv NijiyoboTaishosha) {
        this.NijiyoboTaishosha = NijiyoboTaishosha;
    }

    /*
     * getNijiyoboJohoTaishoIchiran
     * @return NijiyoboJohoTaishoIchiran
     */
    @JsonProperty("NijiyoboJohoTaishoIchiran")
    public NijiyoboJohoTaishoIchiranDiv getNijiyoboJohoTaishoIchiran() {
        return NijiyoboJohoTaishoIchiran;
    }

    /*
     * setNijiyoboJohoTaishoIchiran
     * @param NijiyoboJohoTaishoIchiran NijiyoboJohoTaishoIchiran
     */
    @JsonProperty("NijiyoboJohoTaishoIchiran")
    public void setNijiyoboJohoTaishoIchiran(NijiyoboJohoTaishoIchiranDiv NijiyoboJohoTaishoIchiran) {
        this.NijiyoboJohoTaishoIchiran = NijiyoboJohoTaishoIchiran;
    }

    /*
     * getNijiyoboJohoShosai
     * @return NijiyoboJohoShosai
     */
    @JsonProperty("NijiyoboJohoShosai")
    public NijiyoboJohoShosaiDiv getNijiyoboJohoShosai() {
        return NijiyoboJohoShosai;
    }

    /*
     * setNijiyoboJohoShosai
     * @param NijiyoboJohoShosai NijiyoboJohoShosai
     */
    @JsonProperty("NijiyoboJohoShosai")
    public void setNijiyoboJohoShosai(NijiyoboJohoShosaiDiv NijiyoboJohoShosai) {
        this.NijiyoboJohoShosai = NijiyoboJohoShosai;
    }

    /*
     * getccdKanryoMessage
     * @return ccdKanryoMessage
     */
    @JsonProperty("ccdKanryoMessage")
    public IKaigoKanryoMessageDiv getCcdKanryoMessage() {
        return ccdKanryoMessage;
    }

    /*
     * getoperateState
     * @return operateState
     */
    @JsonProperty("operateState")
    public RString getOperateState() {
        return operateState;
    }

    /*
     * setoperateState
     * @param operateState operateState
     */
    @JsonProperty("operateState")
    public void setOperateState(RString operateState) {
        this.operateState = operateState;
    }

    /*
     * get被保険者番号
     * @return 被保険者番号
     */
    @JsonProperty("被保険者番号")
    public RString get被保険者番号() {
        return 被保険者番号;
    }

    /*
     * set被保険者番号
     * @param 被保険者番号 被保険者番号
     */
    @JsonProperty("被保険者番号")
    public void set被保険者番号(RString 被保険者番号) {
        this.被保険者番号 = 被保険者番号;
    }

    /*
     * get識別コード
     * @return 識別コード
     */
    @JsonProperty("識別コード")
    public RString get識別コード() {
        return 識別コード;
    }

    /*
     * set識別コード
     * @param 識別コード 識別コード
     */
    @JsonProperty("識別コード")
    public void set識別コード(RString 識別コード) {
        this.識別コード = 識別コード;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public IKaigoShikakuKihonDiv getCcdKaiigoShikakuKihon() {
        return this.getNijiyoboTaishosha().getCcdKaiigoShikakuKihon();
    }

    @JsonIgnore
    public IKaigoAtenaInfoDiv getCcdKaigoAtenaInfo() {
        return this.getNijiyoboTaishosha().getCcdKaigoAtenaInfo();
    }

    // </editor-fold>
}
