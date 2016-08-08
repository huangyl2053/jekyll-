package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0020011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ServiceRiyohyoInfo.IServiceRiyohyoInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.IKaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;

/**
 * KyotakuServiceKeikakuShokaiMain のクラスファイル
 *
 * @author 自動生成
 */
public class KyotakuServiceKeikakuShokaiMainDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
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
    @JsonProperty("RiyoNengetsuIchiran")
    private RiyoNengetsuIchiranDiv RiyoNengetsuIchiran;
    @JsonProperty("RiyoNengetsuIchiranFooter")
    private RiyoNengetsuIchiranFooterDiv RiyoNengetsuIchiranFooter;
    @JsonProperty("KyotakuServiceRiyohyo")
    private KyotakuServiceRiyohyoDiv KyotakuServiceRiyohyo;
    @JsonProperty("ccdKaigoShikakuKihon")
    private KaigoShikakuKihonDiv ccdKaigoShikakuKihon;
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
     * getRiyoNengetsuIchiran
     * @return RiyoNengetsuIchiran
     */
    @JsonProperty("RiyoNengetsuIchiran")
    public RiyoNengetsuIchiranDiv getRiyoNengetsuIchiran() {
        return RiyoNengetsuIchiran;
    }

    /*
     * setRiyoNengetsuIchiran
     * @param RiyoNengetsuIchiran RiyoNengetsuIchiran
     */
    @JsonProperty("RiyoNengetsuIchiran")
    public void setRiyoNengetsuIchiran(RiyoNengetsuIchiranDiv RiyoNengetsuIchiran) {
        this.RiyoNengetsuIchiran = RiyoNengetsuIchiran;
    }

    /*
     * getRiyoNengetsuIchiranFooter
     * @return RiyoNengetsuIchiranFooter
     */
    @JsonProperty("RiyoNengetsuIchiranFooter")
    public RiyoNengetsuIchiranFooterDiv getRiyoNengetsuIchiranFooter() {
        return RiyoNengetsuIchiranFooter;
    }

    /*
     * setRiyoNengetsuIchiranFooter
     * @param RiyoNengetsuIchiranFooter RiyoNengetsuIchiranFooter
     */
    @JsonProperty("RiyoNengetsuIchiranFooter")
    public void setRiyoNengetsuIchiranFooter(RiyoNengetsuIchiranFooterDiv RiyoNengetsuIchiranFooter) {
        this.RiyoNengetsuIchiranFooter = RiyoNengetsuIchiranFooter;
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
    public DataGrid<dgRiyoNentstsuIchiran_Row> getDgRiyoNentstsuIchiran() {
        return this.getRiyoNengetsuIchiran().getDgRiyoNentstsuIchiran();
    }

    @JsonIgnore
    public void setDgRiyoNentstsuIchiran(DataGrid<dgRiyoNentstsuIchiran_Row> dgRiyoNentstsuIchiran) {
        this.getRiyoNengetsuIchiran().setDgRiyoNentstsuIchiran(dgRiyoNentstsuIchiran);
    }

    @JsonIgnore
    public Button getBtnBackRirekiIchiran() {
        return this.getRiyoNengetsuIchiranFooter().getBtnBackRirekiIchiran();
    }

    @JsonIgnore
    public void setBtnBackRirekiIchiran(Button btnBackRirekiIchiran) {
        this.getRiyoNengetsuIchiranFooter().setBtnBackRirekiIchiran(btnBackRirekiIchiran);
    }

    @JsonIgnore
    public IServiceRiyohyoInfoDiv getCcdServiceRiyohyoInfo() {
        return this.getKyotakuServiceRiyohyo().getCcdServiceRiyohyoInfo();
    }

    // </editor-fold>
}
