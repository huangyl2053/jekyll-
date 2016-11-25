package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0020011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ServiceRiyohyoInfo.IServiceRiyohyoInfoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ServiceRiyohyoInfo.ServiceRiyohyoInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.IKaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KyotakuServiceKeikakuShokaiMain のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyotakuServiceKeikakuShokaiMainDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KyotakuServiceRirekiIchiran")
    private KyotakuServiceRirekiIchiranDiv KyotakuServiceRirekiIchiran;
    @JsonProperty("KyotakuServiceiTodokedeInfo")
    private KyotakuServiceiTodokedeInfoDiv KyotakuServiceiTodokedeInfo;
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
     * getKyotakuServiceiTodokedeInfo
     * @return KyotakuServiceiTodokedeInfo
     */
    @JsonProperty("KyotakuServiceiTodokedeInfo")
    public KyotakuServiceiTodokedeInfoDiv getKyotakuServiceiTodokedeInfo() {
        return KyotakuServiceiTodokedeInfo;
    }

    /*
     * setKyotakuServiceiTodokedeInfo
     * @param KyotakuServiceiTodokedeInfo KyotakuServiceiTodokedeInfo
     */
    @JsonProperty("KyotakuServiceiTodokedeInfo")
    public void setKyotakuServiceiTodokedeInfo(KyotakuServiceiTodokedeInfoDiv KyotakuServiceiTodokedeInfo) {
        this.KyotakuServiceiTodokedeInfo = KyotakuServiceiTodokedeInfo;
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
    public void  setDgKyotakuServiceRirekiIchiran(DataGrid<dgKyotakuServiceRirekiIchiran_Row> dgKyotakuServiceRirekiIchiran) {
        this.getKyotakuServiceRirekiIchiran().setDgKyotakuServiceRirekiIchiran(dgKyotakuServiceRirekiIchiran);
    }

    @JsonIgnore
    public TextBoxDate getTxtTodokedeYmd() {
        return this.getKyotakuServiceiTodokedeInfo().getTxtTodokedeYmd();
    }

    @JsonIgnore
    public void  setTxtTodokedeYmd(TextBoxDate txtTodokedeYmd) {
        this.getKyotakuServiceiTodokedeInfo().setTxtTodokedeYmd(txtTodokedeYmd);
    }

    @JsonIgnore
    public TextBox getTxtTodokedeKubun() {
        return this.getKyotakuServiceiTodokedeInfo().getTxtTodokedeKubun();
    }

    @JsonIgnore
    public void  setTxtTodokedeKubun(TextBox txtTodokedeKubun) {
        this.getKyotakuServiceiTodokedeInfo().setTxtTodokedeKubun(txtTodokedeKubun);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtTekiyoKikan() {
        return this.getKyotakuServiceiTodokedeInfo().getTxtTekiyoKikan();
    }

    @JsonIgnore
    public void  setTxtTekiyoKikan(TextBoxDateRange txtTekiyoKikan) {
        this.getKyotakuServiceiTodokedeInfo().setTxtTekiyoKikan(txtTekiyoKikan);
    }

    @JsonIgnore
    public TextBox getTxtKyotakuSogoJigyoKubun() {
        return this.getKyotakuServiceiTodokedeInfo().getTxtKyotakuSogoJigyoKubun();
    }

    @JsonIgnore
    public void  setTxtKyotakuSogoJigyoKubun(TextBox txtKyotakuSogoJigyoKubun) {
        this.getKyotakuServiceiTodokedeInfo().setTxtKyotakuSogoJigyoKubun(txtKyotakuSogoJigyoKubun);
    }

    @JsonIgnore
    public TodokedeshaDiv getTodokedesha() {
        return this.getKyotakuServiceiTodokedeInfo().getTodokedesha();
    }

    @JsonIgnore
    public void  setTodokedesha(TodokedeshaDiv Todokedesha) {
        this.getKyotakuServiceiTodokedeInfo().setTodokedesha(Todokedesha);
    }

    @JsonIgnore
    public TextBox getTxtKeikakuSakuseiKubun() {
        return this.getKyotakuServiceiTodokedeInfo().getTxtKeikakuSakuseiKubun();
    }

    @JsonIgnore
    public void  setTxtKeikakuSakuseiKubun(TextBox txtKeikakuSakuseiKubun) {
        this.getKyotakuServiceiTodokedeInfo().setTxtKeikakuSakuseiKubun(txtKeikakuSakuseiKubun);
    }

    @JsonIgnore
    public KeikakuJigyoshaDiv getKeikakuJigyosha() {
        return this.getKyotakuServiceiTodokedeInfo().getKeikakuJigyosha();
    }

    @JsonIgnore
    public void  setKeikakuJigyosha(KeikakuJigyoshaDiv KeikakuJigyosha) {
        this.getKyotakuServiceiTodokedeInfo().setKeikakuJigyosha(KeikakuJigyosha);
    }

    @JsonIgnore
    public TextBox getTxtJigyoshaNo() {
        return this.getKyotakuServiceiTodokedeInfo().getKeikakuJigyosha().getTxtJigyoshaNo();
    }

    @JsonIgnore
    public void  setTxtJigyoshaNo(TextBox txtJigyoshaNo) {
        this.getKyotakuServiceiTodokedeInfo().getKeikakuJigyosha().setTxtJigyoshaNo(txtJigyoshaNo);
    }

    @JsonIgnore
    public TextBox getTxtJigyoshaName() {
        return this.getKyotakuServiceiTodokedeInfo().getKeikakuJigyosha().getTxtJigyoshaName();
    }

    @JsonIgnore
    public void  setTxtJigyoshaName(TextBox txtJigyoshaName) {
        this.getKyotakuServiceiTodokedeInfo().getKeikakuJigyosha().setTxtJigyoshaName(txtJigyoshaName);
    }

    @JsonIgnore
    public TextBox getTxtServiceShuruiMeisho() {
        return this.getKyotakuServiceiTodokedeInfo().getKeikakuJigyosha().getTxtServiceShuruiMeisho();
    }

    @JsonIgnore
    public void  setTxtServiceShuruiMeisho(TextBox txtServiceShuruiMeisho) {
        this.getKyotakuServiceiTodokedeInfo().getKeikakuJigyosha().setTxtServiceShuruiMeisho(txtServiceShuruiMeisho);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtJigyoshaYubinNo() {
        return this.getKyotakuServiceiTodokedeInfo().getKeikakuJigyosha().getTxtJigyoshaYubinNo();
    }

    @JsonIgnore
    public void  setTxtJigyoshaYubinNo(TextBoxYubinNo txtJigyoshaYubinNo) {
        this.getKyotakuServiceiTodokedeInfo().getKeikakuJigyosha().setTxtJigyoshaYubinNo(txtJigyoshaYubinNo);
    }

    @JsonIgnore
    public TextBox getTxtJigyoshaJusho() {
        return this.getKyotakuServiceiTodokedeInfo().getKeikakuJigyosha().getTxtJigyoshaJusho();
    }

    @JsonIgnore
    public void  setTxtJigyoshaJusho(TextBox txtJigyoshaJusho) {
        this.getKyotakuServiceiTodokedeInfo().getKeikakuJigyosha().setTxtJigyoshaJusho(txtJigyoshaJusho);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtJigyoshaTelNo() {
        return this.getKyotakuServiceiTodokedeInfo().getKeikakuJigyosha().getTxtJigyoshaTelNo();
    }

    @JsonIgnore
    public void  setTxtJigyoshaTelNo(TextBoxTelNo txtJigyoshaTelNo) {
        this.getKyotakuServiceiTodokedeInfo().getKeikakuJigyosha().setTxtJigyoshaTelNo(txtJigyoshaTelNo);
    }

    @JsonIgnore
    public TextBoxAtenaMeisho getTxtKanrishaName() {
        return this.getKyotakuServiceiTodokedeInfo().getKeikakuJigyosha().getTxtKanrishaName();
    }

    @JsonIgnore
    public void  setTxtKanrishaName(TextBoxAtenaMeisho txtKanrishaName) {
        this.getKyotakuServiceiTodokedeInfo().getKeikakuJigyosha().setTxtKanrishaName(txtKanrishaName);
    }

    @JsonIgnore
    public TextBox getTxtItakusakiJigyoshaNo() {
        return this.getKyotakuServiceiTodokedeInfo().getKeikakuJigyosha().getTxtItakusakiJigyoshaNo();
    }

    @JsonIgnore
    public void  setTxtItakusakiJigyoshaNo(TextBox txtItakusakiJigyoshaNo) {
        this.getKyotakuServiceiTodokedeInfo().getKeikakuJigyosha().setTxtItakusakiJigyoshaNo(txtItakusakiJigyoshaNo);
    }

    @JsonIgnore
    public TextBox getTxtItakusakiJigyoshaName() {
        return this.getKyotakuServiceiTodokedeInfo().getKeikakuJigyosha().getTxtItakusakiJigyoshaName();
    }

    @JsonIgnore
    public void  setTxtItakusakiJigyoshaName(TextBox txtItakusakiJigyoshaName) {
        this.getKyotakuServiceiTodokedeInfo().getKeikakuJigyosha().setTxtItakusakiJigyoshaName(txtItakusakiJigyoshaName);
    }

    @JsonIgnore
    public TextBoxDate getTxtHenkoYMD() {
        return this.getKyotakuServiceiTodokedeInfo().getKeikakuJigyosha().getTxtHenkoYMD();
    }

    @JsonIgnore
    public void  setTxtHenkoYMD(TextBoxDate txtHenkoYMD) {
        this.getKyotakuServiceiTodokedeInfo().getKeikakuJigyosha().setTxtHenkoYMD(txtHenkoYMD);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtHenkoJiyu() {
        return this.getKyotakuServiceiTodokedeInfo().getKeikakuJigyosha().getTxtHenkoJiyu();
    }

    @JsonIgnore
    public void  setTxtHenkoJiyu(TextBoxMultiLine txtHenkoJiyu) {
        this.getKyotakuServiceiTodokedeInfo().getKeikakuJigyosha().setTxtHenkoJiyu(txtHenkoJiyu);
    }

    @JsonIgnore
    public DataGrid<dgRiyoNentstsuIchiran_Row> getDgRiyoNentstsuIchiran() {
        return this.getRiyoNengetsuIchiran().getDgRiyoNentstsuIchiran();
    }

    @JsonIgnore
    public void  setDgRiyoNentstsuIchiran(DataGrid<dgRiyoNentstsuIchiran_Row> dgRiyoNentstsuIchiran) {
        this.getRiyoNengetsuIchiran().setDgRiyoNentstsuIchiran(dgRiyoNentstsuIchiran);
    }

    @JsonIgnore
    public Button getBtnBackRirekiIchiran() {
        return this.getRiyoNengetsuIchiranFooter().getBtnBackRirekiIchiran();
    }

    @JsonIgnore
    public void  setBtnBackRirekiIchiran(Button btnBackRirekiIchiran) {
        this.getRiyoNengetsuIchiranFooter().setBtnBackRirekiIchiran(btnBackRirekiIchiran);
    }

    @JsonIgnore
    public IServiceRiyohyoInfoDiv getCcdServiceRiyohyoInfo() {
        return this.getKyotakuServiceRiyohyo().getCcdServiceRiyohyoInfo();
    }

    // </editor-fold>
}
