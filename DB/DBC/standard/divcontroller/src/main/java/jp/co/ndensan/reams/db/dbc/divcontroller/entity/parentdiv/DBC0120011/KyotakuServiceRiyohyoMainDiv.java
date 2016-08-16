package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0120011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ServiceRiyohyoInfo.IServiceRiyohyoInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.IKaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.KaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.IKaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KyotakuServiceRiyohyoMain のクラスファイル
 *
 * @reamsid_L DBC-1930-030 huzongcheng
 */
public class KyotakuServiceRiyohyoMainDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KyotakuServiceRirekiIchiran")
    private KyotakuServiceRirekiIchiranDiv KyotakuServiceRirekiIchiran;
    @JsonProperty("JikoSakuseiTodokedeInfo")
    private JikoSakuseiTodokedeInfoDiv JikoSakuseiTodokedeInfo;
    @JsonProperty("RiyotsukiIchiran")
    private RiyotsukiIchiranDiv RiyotsukiIchiran;
    @JsonProperty("RiyotsukiIchiranFooter")
    private RiyotsukiIchiranFooterDiv RiyotsukiIchiranFooter;
    @JsonProperty("KyotakuServiceRiyohyo")
    private KyotakuServiceRiyohyoDiv KyotakuServiceRiyohyo;
    @JsonProperty("ccdKaigoShikakuKihon")
    private KaigoShikakuKihonDiv ccdKaigoShikakuKihon;
    @JsonProperty("ccdKanryoMessage")
    private KaigoKanryoMessageDiv ccdKanryoMessage;
    @JsonProperty("ccdKaigoAtenaInfo")
    private KaigoAtenaInfoDiv ccdKaigoAtenaInfo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKyotakuServiceRirekiIchiran
     * @return KyotakuServiceRirekiIchiran
     */
    @JsonProperty("KyotakuServiceRirekiIchiran")
    public KyotakuServiceRirekiIchiranDiv getKyotakuServiceRirekiIchiran() {
        return KyotakuServiceRirekiIchiran;
    }

    /*
     * setKyotakuServiceRirekiIchiran
     * @param KyotakuServiceRirekiIchiran KyotakuServiceRirekiIchiran
     */
    @JsonProperty("KyotakuServiceRirekiIchiran")
    public void setKyotakuServiceRirekiIchiran(KyotakuServiceRirekiIchiranDiv KyotakuServiceRirekiIchiran) {
        this.KyotakuServiceRirekiIchiran = KyotakuServiceRirekiIchiran;
    }

    /*
     * getJikoSakuseiTodokedeInfo
     * @return JikoSakuseiTodokedeInfo
     */
    @JsonProperty("JikoSakuseiTodokedeInfo")
    public JikoSakuseiTodokedeInfoDiv getJikoSakuseiTodokedeInfo() {
        return JikoSakuseiTodokedeInfo;
    }

    /*
     * setJikoSakuseiTodokedeInfo
     * @param JikoSakuseiTodokedeInfo JikoSakuseiTodokedeInfo
     */
    @JsonProperty("JikoSakuseiTodokedeInfo")
    public void setJikoSakuseiTodokedeInfo(JikoSakuseiTodokedeInfoDiv JikoSakuseiTodokedeInfo) {
        this.JikoSakuseiTodokedeInfo = JikoSakuseiTodokedeInfo;
    }

    /*
     * getRiyotsukiIchiran
     * @return RiyotsukiIchiran
     */
    @JsonProperty("RiyotsukiIchiran")
    public RiyotsukiIchiranDiv getRiyotsukiIchiran() {
        return RiyotsukiIchiran;
    }

    /*
     * setRiyotsukiIchiran
     * @param RiyotsukiIchiran RiyotsukiIchiran
     */
    @JsonProperty("RiyotsukiIchiran")
    public void setRiyotsukiIchiran(RiyotsukiIchiranDiv RiyotsukiIchiran) {
        this.RiyotsukiIchiran = RiyotsukiIchiran;
    }

    /*
     * getRiyotsukiIchiranFooter
     * @return RiyotsukiIchiranFooter
     */
    @JsonProperty("RiyotsukiIchiranFooter")
    public RiyotsukiIchiranFooterDiv getRiyotsukiIchiranFooter() {
        return RiyotsukiIchiranFooter;
    }

    /*
     * setRiyotsukiIchiranFooter
     * @param RiyotsukiIchiranFooter RiyotsukiIchiranFooter
     */
    @JsonProperty("RiyotsukiIchiranFooter")
    public void setRiyotsukiIchiranFooter(RiyotsukiIchiranFooterDiv RiyotsukiIchiranFooter) {
        this.RiyotsukiIchiranFooter = RiyotsukiIchiranFooter;
    }

    /*
     * getKyotakuServiceRiyohyo
     * @return KyotakuServiceRiyohyo
     */
    @JsonProperty("KyotakuServiceRiyohyo")
    public KyotakuServiceRiyohyoDiv getKyotakuServiceRiyohyo() {
        return KyotakuServiceRiyohyo;
    }

    /*
     * setKyotakuServiceRiyohyo
     * @param KyotakuServiceRiyohyo KyotakuServiceRiyohyo
     */
    @JsonProperty("KyotakuServiceRiyohyo")
    public void setKyotakuServiceRiyohyo(KyotakuServiceRiyohyoDiv KyotakuServiceRiyohyo) {
        this.KyotakuServiceRiyohyo = KyotakuServiceRiyohyo;
    }

    /*
     * getccdKaigoShikakuKihon
     * @return ccdKaigoShikakuKihon
     */
    @JsonProperty("ccdKaigoShikakuKihon")
    public IKaigoShikakuKihonDiv getCcdKaigoShikakuKihon() {
        return ccdKaigoShikakuKihon;
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
     * getccdKaigoAtenaInfo
     * @return ccdKaigoAtenaInfo
     */
    @JsonProperty("ccdKaigoAtenaInfo")
    public IKaigoAtenaInfoDiv getCcdKaigoAtenaInfo() {
        return ccdKaigoAtenaInfo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DataGrid<dgKyotakuServiceRirekiIchiran_Row> getDgKyotakuServiceRirekiIchiran() {
        return this.getKyotakuServiceRirekiIchiran().getDgKyotakuServiceRirekiIchiran();
    }

    @JsonIgnore
    public void setDgKyotakuServiceRirekiIchiran(DataGrid<dgKyotakuServiceRirekiIchiran_Row> dgKyotakuServiceRirekiIchiran) {
        this.getKyotakuServiceRirekiIchiran().setDgKyotakuServiceRirekiIchiran(dgKyotakuServiceRirekiIchiran);
    }

    @JsonIgnore
    public TextBoxDate getTxtTodokedeYmd() {
        return this.getJikoSakuseiTodokedeInfo().getTxtTodokedeYmd();
    }

    @JsonIgnore
    public void setTxtTodokedeYmd(TextBoxDate txtTodokedeYmd) {
        this.getJikoSakuseiTodokedeInfo().setTxtTodokedeYmd(txtTodokedeYmd);
    }

    @JsonIgnore
    public TextBox getTxtTodokedeKubun() {
        return this.getJikoSakuseiTodokedeInfo().getTxtTodokedeKubun();
    }

    @JsonIgnore
    public void setTxtTodokedeKubun(TextBox txtTodokedeKubun) {
        this.getJikoSakuseiTodokedeInfo().setTxtTodokedeKubun(txtTodokedeKubun);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtTekiyoKikan() {
        return this.getJikoSakuseiTodokedeInfo().getTxtTekiyoKikan();
    }

    @JsonIgnore
    public void setTxtTekiyoKikan(TextBoxDateRange txtTekiyoKikan) {
        this.getJikoSakuseiTodokedeInfo().setTxtTekiyoKikan(txtTekiyoKikan);
    }

    @JsonIgnore
    public TodokedeshaDiv getTodokedesha() {
        return this.getJikoSakuseiTodokedeInfo().getTodokedesha();
    }

    @JsonIgnore
    public void setTodokedesha(TodokedeshaDiv Todokedesha) {
        this.getJikoSakuseiTodokedeInfo().setTodokedesha(Todokedesha);
    }

    @JsonIgnore
    public Button getBtnAddRiyoNengetsu() {
        return this.getRiyotsukiIchiran().getBtnAddRiyoNengetsu();
    }

    @JsonIgnore
    public void setBtnAddRiyoNengetsu(Button btnAddRiyoNengetsu) {
        this.getRiyotsukiIchiran().setBtnAddRiyoNengetsu(btnAddRiyoNengetsu);
    }

    @JsonIgnore
    public DataGrid<dgRiyoNentstsuIchiran_Row> getDgRiyoNentstsuIchiran() {
        return this.getRiyotsukiIchiran().getDgRiyoNentstsuIchiran();
    }

    @JsonIgnore
    public void setDgRiyoNentstsuIchiran(DataGrid<dgRiyoNentstsuIchiran_Row> dgRiyoNentstsuIchiran) {
        this.getRiyotsukiIchiran().setDgRiyoNentstsuIchiran(dgRiyoNentstsuIchiran);
    }

    @JsonIgnore
    public Button getBtnBackRirekiIchiran() {
        return this.getRiyotsukiIchiranFooter().getBtnBackRirekiIchiran();
    }

    @JsonIgnore
    public void setBtnBackRirekiIchiran(Button btnBackRirekiIchiran) {
        this.getRiyotsukiIchiranFooter().setBtnBackRirekiIchiran(btnBackRirekiIchiran);
    }

    @JsonIgnore
    public IServiceRiyohyoInfoDiv getCcdServiceRiyohyoInfo() {
        return this.getKyotakuServiceRiyohyo().getCcdServiceRiyohyoInfo();
    }

    // </editor-fold>
}
