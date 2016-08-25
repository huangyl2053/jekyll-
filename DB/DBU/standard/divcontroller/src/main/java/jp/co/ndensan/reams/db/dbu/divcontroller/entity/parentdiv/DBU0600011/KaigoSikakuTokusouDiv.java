package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0600011;
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
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KaigoSikakuTokusou のクラスファイル 
 * 
 * @author 自動生成
 */
public class KaigoSikakuTokusouDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("HeadPanel")
    private HeadPanelDiv HeadPanel;
    @JsonProperty("KaigoSikaku")
    private KaigoSikakuDiv KaigoSikaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getHeadPanel
     * @return HeadPanel
     */
    @JsonProperty("HeadPanel")
    public HeadPanelDiv getHeadPanel() {
        return HeadPanel;
    }

    /*
     * setHeadPanel
     * @param HeadPanel HeadPanel
     */
    @JsonProperty("HeadPanel")
    public void setHeadPanel(HeadPanelDiv HeadPanel) {
        this.HeadPanel = HeadPanel;
    }

    /*
     * getKaigoSikaku
     * @return KaigoSikaku
     */
    @JsonProperty("KaigoSikaku")
    public KaigoSikakuDiv getKaigoSikaku() {
        return KaigoSikaku;
    }

    /*
     * setKaigoSikaku
     * @param KaigoSikaku KaigoSikaku
     */
    @JsonProperty("KaigoSikaku")
    public void setKaigoSikaku(KaigoSikakuDiv KaigoSikaku) {
        this.KaigoSikaku = KaigoSikaku;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public IKaigoShikakuKihonDiv getKaigoShikakuKihonChildDiv() {
        return this.getHeadPanel().getKaigoShikakuKihonChildDiv();
    }

    @JsonIgnore
    public IKaigoAtenaInfoDiv getKaigoAtenaInfoChildDiv() {
        return this.getHeadPanel().getKaigoAtenaInfoChildDiv();
    }

    @JsonIgnore
    public SikakuJohoDiv getSikakuJoho() {
        return this.getKaigoSikaku().getSikakuJoho();
    }

    @JsonIgnore
    public void  setSikakuJoho(SikakuJohoDiv SikakuJoho) {
        this.getKaigoSikaku().setSikakuJoho(SikakuJoho);
    }

    @JsonIgnore
    public Button getSikakuJohoButton() {
        return this.getKaigoSikaku().getSikakuJoho().getSikakuJohoButton();
    }

    @JsonIgnore
    public void  setSikakuJohoButton(Button SikakuJohoButton) {
        this.getKaigoSikaku().getSikakuJoho().setSikakuJohoButton(SikakuJohoButton);
    }

    @JsonIgnore
    public Button getJyukyusyaJohoButton() {
        return this.getKaigoSikaku().getSikakuJoho().getJyukyusyaJohoButton();
    }

    @JsonIgnore
    public void  setJyukyusyaJohoButton(Button JyukyusyaJohoButton) {
        this.getKaigoSikaku().getSikakuJoho().setJyukyusyaJohoButton(JyukyusyaJohoButton);
    }

    @JsonIgnore
    public Button getKyuhuJohoButton() {
        return this.getKaigoSikaku().getSikakuJoho().getKyuhuJohoButton();
    }

    @JsonIgnore
    public void  setKyuhuJohoButton(Button KyuhuJohoButton) {
        this.getKaigoSikaku().getSikakuJoho().setKyuhuJohoButton(KyuhuJohoButton);
    }

    @JsonIgnore
    public Button getHukaJohoButton() {
        return this.getKaigoSikaku().getSikakuJoho().getHukaJohoButton();
    }

    @JsonIgnore
    public void  setHukaJohoButton(Button HukaJohoButton) {
        this.getKaigoSikaku().getSikakuJoho().setHukaJohoButton(HukaJohoButton);
    }

    @JsonIgnore
    public Button getJyuminJohoButton() {
        return this.getKaigoSikaku().getSikakuJoho().getJyuminJohoButton();
    }

    @JsonIgnore
    public void  setJyuminJohoButton(Button JyuminJohoButton) {
        this.getKaigoSikaku().getSikakuJoho().setJyuminJohoButton(JyuminJohoButton);
    }

    @JsonIgnore
    public Button getHihokensyaJohoButton() {
        return this.getKaigoSikaku().getSikakuJoho().getHihokensyaJohoButton();
    }

    @JsonIgnore
    public void  setHihokensyaJohoButton(Button HihokensyaJohoButton) {
        this.getKaigoSikaku().getSikakuJoho().setHihokensyaJohoButton(HihokensyaJohoButton);
    }

    @JsonIgnore
    public Button getHokaJyusyoTokureisyaButton7() {
        return this.getKaigoSikaku().getSikakuJoho().getHokaJyusyoTokureisyaButton7();
    }

    @JsonIgnore
    public void  setHokaJyusyoTokureisyaButton7(Button HokaJyusyoTokureisyaButton7) {
        this.getKaigoSikaku().getSikakuJoho().setHokaJyusyoTokureisyaButton7(HokaJyusyoTokureisyaButton7);
    }

    @JsonIgnore
    public Button getTekiyoJyogaisyaButton() {
        return this.getKaigoSikaku().getSikakuJoho().getTekiyoJyogaisyaButton();
    }

    @JsonIgnore
    public void  setTekiyoJyogaisyaButton(Button TekiyoJyogaisyaButton) {
        this.getKaigoSikaku().getSikakuJoho().setTekiyoJyogaisyaButton(TekiyoJyogaisyaButton);
    }

    @JsonIgnore
    public HihokensyaJohoDiv getHihokensyaJoho() {
        return this.getKaigoSikaku().getHihokensyaJoho();
    }

    @JsonIgnore
    public void  setHihokensyaJoho(HihokensyaJohoDiv HihokensyaJoho) {
        this.getKaigoSikaku().setHihokensyaJoho(HihokensyaJoho);
    }

    @JsonIgnore
    public TextBoxDate getSyutokuYYMMDD() {
        return this.getKaigoSikaku().getHihokensyaJoho().getSyutokuYYMMDD();
    }

    @JsonIgnore
    public void  setSyutokuYYMMDD(TextBoxDate SyutokuYYMMDD) {
        this.getKaigoSikaku().getHihokensyaJoho().setSyutokuYYMMDD(SyutokuYYMMDD);
    }

    @JsonIgnore
    public TextBox getSyutokuJiyu() {
        return this.getKaigoSikaku().getHihokensyaJoho().getSyutokuJiyu();
    }

    @JsonIgnore
    public void  setSyutokuJiyu(TextBox SyutokuJiyu) {
        this.getKaigoSikaku().getHihokensyaJoho().setSyutokuJiyu(SyutokuJiyu);
    }

    @JsonIgnore
    public TextBox getHihokensyaKubun() {
        return this.getKaigoSikaku().getHihokensyaJoho().getHihokensyaKubun();
    }

    @JsonIgnore
    public void  setHihokensyaKubun(TextBox HihokensyaKubun) {
        this.getKaigoSikaku().getHihokensyaJoho().setHihokensyaKubun(HihokensyaKubun);
    }

    @JsonIgnore
    public TextBox getSyozaiHokensya() {
        return this.getKaigoSikaku().getHihokensyaJoho().getSyozaiHokensya();
    }

    @JsonIgnore
    public void  setSyozaiHokensya(TextBox SyozaiHokensya) {
        this.getKaigoSikaku().getHihokensyaJoho().setSyozaiHokensya(SyozaiHokensya);
    }

    @JsonIgnore
    public TextBoxDate getSosituYYMMDD() {
        return this.getKaigoSikaku().getHihokensyaJoho().getSosituYYMMDD();
    }

    @JsonIgnore
    public void  setSosituYYMMDD(TextBoxDate SosituYYMMDD) {
        this.getKaigoSikaku().getHihokensyaJoho().setSosituYYMMDD(SosituYYMMDD);
    }

    @JsonIgnore
    public TextBox getSosituJiyu() {
        return this.getKaigoSikaku().getHihokensyaJoho().getSosituJiyu();
    }

    @JsonIgnore
    public void  setSosituJiyu(TextBox SosituJiyu) {
        this.getKaigoSikaku().getHihokensyaJoho().setSosituJiyu(SosituJiyu);
    }

    @JsonIgnore
    public TextBoxDate getJyusyoTokureiTekiyouYYMMDD() {
        return this.getKaigoSikaku().getHihokensyaJoho().getJyusyoTokureiTekiyouYYMMDD();
    }

    @JsonIgnore
    public void  setJyusyoTokureiTekiyouYYMMDD(TextBoxDate JyusyoTokureiTekiyouYYMMDD) {
        this.getKaigoSikaku().getHihokensyaJoho().setJyusyoTokureiTekiyouYYMMDD(JyusyoTokureiTekiyouYYMMDD);
    }

    @JsonIgnore
    public TextBox getJyusyoTokureiTekiyouJiyu() {
        return this.getKaigoSikaku().getHihokensyaJoho().getJyusyoTokureiTekiyouJiyu();
    }

    @JsonIgnore
    public void  setJyusyoTokureiTekiyouJiyu(TextBox JyusyoTokureiTekiyouJiyu) {
        this.getKaigoSikaku().getHihokensyaJoho().setJyusyoTokureiTekiyouJiyu(JyusyoTokureiTekiyouJiyu);
    }

    @JsonIgnore
    public TextBox getKyuHokensya() {
        return this.getKaigoSikaku().getHihokensyaJoho().getKyuHokensya();
    }

    @JsonIgnore
    public void  setKyuHokensya(TextBox KyuHokensya) {
        this.getKaigoSikaku().getHihokensyaJoho().setKyuHokensya(KyuHokensya);
    }

    @JsonIgnore
    public TextBoxDate getHenkoYYMMDD() {
        return this.getKaigoSikaku().getHihokensyaJoho().getHenkoYYMMDD();
    }

    @JsonIgnore
    public void  setHenkoYYMMDD(TextBoxDate HenkoYYMMDD) {
        this.getKaigoSikaku().getHihokensyaJoho().setHenkoYYMMDD(HenkoYYMMDD);
    }

    @JsonIgnore
    public TextBox getHenkoJiyu() {
        return this.getKaigoSikaku().getHihokensyaJoho().getHenkoJiyu();
    }

    @JsonIgnore
    public void  setHenkoJiyu(TextBox HenkoJiyu) {
        this.getKaigoSikaku().getHihokensyaJoho().setHenkoJiyu(HenkoJiyu);
    }

    @JsonIgnore
    public TextBoxDate getJyusyoTokureiKaijoYYMMDD() {
        return this.getKaigoSikaku().getHihokensyaJoho().getJyusyoTokureiKaijoYYMMDD();
    }

    @JsonIgnore
    public void  setJyusyoTokureiKaijoYYMMDD(TextBoxDate JyusyoTokureiKaijoYYMMDD) {
        this.getKaigoSikaku().getHihokensyaJoho().setJyusyoTokureiKaijoYYMMDD(JyusyoTokureiKaijoYYMMDD);
    }

    @JsonIgnore
    public TextBox getJyusyoTokureiKaijoJiyu() {
        return this.getKaigoSikaku().getHihokensyaJoho().getJyusyoTokureiKaijoJiyu();
    }

    @JsonIgnore
    public void  setJyusyoTokureiKaijoJiyu(TextBox JyusyoTokureiKaijoJiyu) {
        this.getKaigoSikaku().getHihokensyaJoho().setJyusyoTokureiKaijoJiyu(JyusyoTokureiKaijoJiyu);
    }

    @JsonIgnore
    public TextBox getHiroSotiMotoHokensya() {
        return this.getKaigoSikaku().getHihokensyaJoho().getHiroSotiMotoHokensya();
    }

    @JsonIgnore
    public void  setHiroSotiMotoHokensya(TextBox HiroSotiMotoHokensya) {
        this.getKaigoSikaku().getHihokensyaJoho().setHiroSotiMotoHokensya(HiroSotiMotoHokensya);
    }

    @JsonIgnore
    public SisetuNyutaisyoJohoDiv getSisetuNyutaisyoJoho() {
        return this.getKaigoSikaku().getSisetuNyutaisyoJoho();
    }

    @JsonIgnore
    public void  setSisetuNyutaisyoJoho(SisetuNyutaisyoJohoDiv SisetuNyutaisyoJoho) {
        this.getKaigoSikaku().setSisetuNyutaisyoJoho(SisetuNyutaisyoJoho);
    }

    @JsonIgnore
    public TextBoxDate getNyusyoYYMMDD() {
        return this.getKaigoSikaku().getSisetuNyutaisyoJoho().getNyusyoYYMMDD();
    }

    @JsonIgnore
    public void  setNyusyoYYMMDD(TextBoxDate NyusyoYYMMDD) {
        this.getKaigoSikaku().getSisetuNyutaisyoJoho().setNyusyoYYMMDD(NyusyoYYMMDD);
    }

    @JsonIgnore
    public TextBox getDaityoSyubetu() {
        return this.getKaigoSikaku().getSisetuNyutaisyoJoho().getDaityoSyubetu();
    }

    @JsonIgnore
    public void  setDaityoSyubetu(TextBox DaityoSyubetu) {
        this.getKaigoSikaku().getSisetuNyutaisyoJoho().setDaityoSyubetu(DaityoSyubetu);
    }

    @JsonIgnore
    public TextBox getSisetuSyubetu() {
        return this.getKaigoSikaku().getSisetuNyutaisyoJoho().getSisetuSyubetu();
    }

    @JsonIgnore
    public void  setSisetuSyubetu(TextBox SisetuSyubetu) {
        this.getKaigoSikaku().getSisetuNyutaisyoJoho().setSisetuSyubetu(SisetuSyubetu);
    }

    @JsonIgnore
    public TextBoxDate getTaisyoYYMMDD() {
        return this.getKaigoSikaku().getSisetuNyutaisyoJoho().getTaisyoYYMMDD();
    }

    @JsonIgnore
    public void  setTaisyoYYMMDD(TextBoxDate TaisyoYYMMDD) {
        this.getKaigoSikaku().getSisetuNyutaisyoJoho().setTaisyoYYMMDD(TaisyoYYMMDD);
    }

    @JsonIgnore
    public TextBox getNyusyoSisetuCode() {
        return this.getKaigoSikaku().getSisetuNyutaisyoJoho().getNyusyoSisetuCode();
    }

    @JsonIgnore
    public void  setNyusyoSisetuCode(TextBox NyusyoSisetuCode) {
        this.getKaigoSikaku().getSisetuNyutaisyoJoho().setNyusyoSisetuCode(NyusyoSisetuCode);
    }

    @JsonIgnore
    public TextBox getNyusyoSisetuMesyo() {
        return this.getKaigoSikaku().getSisetuNyutaisyoJoho().getNyusyoSisetuMesyo();
    }

    @JsonIgnore
    public void  setNyusyoSisetuMesyo(TextBox NyusyoSisetuMesyo) {
        this.getKaigoSikaku().getSisetuNyutaisyoJoho().setNyusyoSisetuMesyo(NyusyoSisetuMesyo);
    }

    @JsonIgnore
    public HokaSityosonJohoDiv getHokaSityosonJoho() {
        return this.getKaigoSikaku().getHokaSityosonJoho();
    }

    @JsonIgnore
    public void  setHokaSityosonJoho(HokaSityosonJohoDiv HokaSityosonJoho) {
        this.getKaigoSikaku().setHokaSityosonJoho(HokaSityosonJoho);
    }

    @JsonIgnore
    public TextBoxDate getHokaSityosonTekiyoYYMMDD() {
        return this.getKaigoSikaku().getHokaSityosonJoho().getHokaSityosonTekiyoYYMMDD();
    }

    @JsonIgnore
    public void  setHokaSityosonTekiyoYYMMDD(TextBoxDate HokaSityosonTekiyoYYMMDD) {
        this.getKaigoSikaku().getHokaSityosonJoho().setHokaSityosonTekiyoYYMMDD(HokaSityosonTekiyoYYMMDD);
    }

    @JsonIgnore
    public TextBox getHokaSityosonTekiyouJiyu() {
        return this.getKaigoSikaku().getHokaSityosonJoho().getHokaSityosonTekiyouJiyu();
    }

    @JsonIgnore
    public void  setHokaSityosonTekiyouJiyu(TextBox HokaSityosonTekiyouJiyu) {
        this.getKaigoSikaku().getHokaSityosonJoho().setHokaSityosonTekiyouJiyu(HokaSityosonTekiyouJiyu);
    }

    @JsonIgnore
    public TextBox getSotiMotoHokensya() {
        return this.getKaigoSikaku().getHokaSityosonJoho().getSotiMotoHokensya();
    }

    @JsonIgnore
    public void  setSotiMotoHokensya(TextBox SotiMotoHokensya) {
        this.getKaigoSikaku().getHokaSityosonJoho().setSotiMotoHokensya(SotiMotoHokensya);
    }

    @JsonIgnore
    public TextBox getHokaSityosonSisetuSyubetu() {
        return this.getKaigoSikaku().getHokaSityosonJoho().getHokaSityosonSisetuSyubetu();
    }

    @JsonIgnore
    public void  setHokaSityosonSisetuSyubetu(TextBox HokaSityosonSisetuSyubetu) {
        this.getKaigoSikaku().getHokaSityosonJoho().setHokaSityosonSisetuSyubetu(HokaSityosonSisetuSyubetu);
    }

    @JsonIgnore
    public TextBoxDate getHokaSityosonKaijoYYMMDD() {
        return this.getKaigoSikaku().getHokaSityosonJoho().getHokaSityosonKaijoYYMMDD();
    }

    @JsonIgnore
    public void  setHokaSityosonKaijoYYMMDD(TextBoxDate HokaSityosonKaijoYYMMDD) {
        this.getKaigoSikaku().getHokaSityosonJoho().setHokaSityosonKaijoYYMMDD(HokaSityosonKaijoYYMMDD);
    }

    @JsonIgnore
    public TextBox getHokaSityosonKaijoJiyu() {
        return this.getKaigoSikaku().getHokaSityosonJoho().getHokaSityosonKaijoJiyu();
    }

    @JsonIgnore
    public void  setHokaSityosonKaijoJiyu(TextBox HokaSityosonKaijoJiyu) {
        this.getKaigoSikaku().getHokaSityosonJoho().setHokaSityosonKaijoJiyu(HokaSityosonKaijoJiyu);
    }

    @JsonIgnore
    public TextBox getSotiMotoHihokensya() {
        return this.getKaigoSikaku().getHokaSityosonJoho().getSotiMotoHihokensya();
    }

    @JsonIgnore
    public void  setSotiMotoHihokensya(TextBox SotiMotoHihokensya) {
        this.getKaigoSikaku().getHokaSityosonJoho().setSotiMotoHihokensya(SotiMotoHihokensya);
    }

    @JsonIgnore
    public TextBox getHokaSityosonSisetuCode() {
        return this.getKaigoSikaku().getHokaSityosonJoho().getHokaSityosonSisetuCode();
    }

    @JsonIgnore
    public void  setHokaSityosonSisetuCode(TextBox HokaSityosonSisetuCode) {
        this.getKaigoSikaku().getHokaSityosonJoho().setHokaSityosonSisetuCode(HokaSityosonSisetuCode);
    }

    @JsonIgnore
    public TextBox getHokaSityosonSisetuMesyo() {
        return this.getKaigoSikaku().getHokaSityosonJoho().getHokaSityosonSisetuMesyo();
    }

    @JsonIgnore
    public void  setHokaSityosonSisetuMesyo(TextBox HokaSityosonSisetuMesyo) {
        this.getKaigoSikaku().getHokaSityosonJoho().setHokaSityosonSisetuMesyo(HokaSityosonSisetuMesyo);
    }

    @JsonIgnore
    public TekiyoJyogaisyaJohoDiv getTekiyoJyogaisyaJoho() {
        return this.getKaigoSikaku().getTekiyoJyogaisyaJoho();
    }

    @JsonIgnore
    public void  setTekiyoJyogaisyaJoho(TekiyoJyogaisyaJohoDiv TekiyoJyogaisyaJoho) {
        this.getKaigoSikaku().setTekiyoJyogaisyaJoho(TekiyoJyogaisyaJoho);
    }

    @JsonIgnore
    public TextBoxDate getTekiyoJyogaisyaTekiyoYYMMDD() {
        return this.getKaigoSikaku().getTekiyoJyogaisyaJoho().getTekiyoJyogaisyaTekiyoYYMMDD();
    }

    @JsonIgnore
    public void  setTekiyoJyogaisyaTekiyoYYMMDD(TextBoxDate TekiyoJyogaisyaTekiyoYYMMDD) {
        this.getKaigoSikaku().getTekiyoJyogaisyaJoho().setTekiyoJyogaisyaTekiyoYYMMDD(TekiyoJyogaisyaTekiyoYYMMDD);
    }

    @JsonIgnore
    public TextBox getTekiyoJyogaisyaTekiyouJiyu() {
        return this.getKaigoSikaku().getTekiyoJyogaisyaJoho().getTekiyoJyogaisyaTekiyouJiyu();
    }

    @JsonIgnore
    public void  setTekiyoJyogaisyaTekiyouJiyu(TextBox TekiyoJyogaisyaTekiyouJiyu) {
        this.getKaigoSikaku().getTekiyoJyogaisyaJoho().setTekiyoJyogaisyaTekiyouJiyu(TekiyoJyogaisyaTekiyouJiyu);
    }

    @JsonIgnore
    public TextBox getTekiyoJyogaisyaSisetuSyubetu() {
        return this.getKaigoSikaku().getTekiyoJyogaisyaJoho().getTekiyoJyogaisyaSisetuSyubetu();
    }

    @JsonIgnore
    public void  setTekiyoJyogaisyaSisetuSyubetu(TextBox TekiyoJyogaisyaSisetuSyubetu) {
        this.getKaigoSikaku().getTekiyoJyogaisyaJoho().setTekiyoJyogaisyaSisetuSyubetu(TekiyoJyogaisyaSisetuSyubetu);
    }

    @JsonIgnore
    public TextBoxDate getTekiyoJyogaisyaKaijoYYMMDD() {
        return this.getKaigoSikaku().getTekiyoJyogaisyaJoho().getTekiyoJyogaisyaKaijoYYMMDD();
    }

    @JsonIgnore
    public void  setTekiyoJyogaisyaKaijoYYMMDD(TextBoxDate TekiyoJyogaisyaKaijoYYMMDD) {
        this.getKaigoSikaku().getTekiyoJyogaisyaJoho().setTekiyoJyogaisyaKaijoYYMMDD(TekiyoJyogaisyaKaijoYYMMDD);
    }

    @JsonIgnore
    public TextBox getTekiyoJyogaisyaKaijoJiyu() {
        return this.getKaigoSikaku().getTekiyoJyogaisyaJoho().getTekiyoJyogaisyaKaijoJiyu();
    }

    @JsonIgnore
    public void  setTekiyoJyogaisyaKaijoJiyu(TextBox TekiyoJyogaisyaKaijoJiyu) {
        this.getKaigoSikaku().getTekiyoJyogaisyaJoho().setTekiyoJyogaisyaKaijoJiyu(TekiyoJyogaisyaKaijoJiyu);
    }

    @JsonIgnore
    public TextBox getTekiyoJyogaisyaSisetuCode() {
        return this.getKaigoSikaku().getTekiyoJyogaisyaJoho().getTekiyoJyogaisyaSisetuCode();
    }

    @JsonIgnore
    public void  setTekiyoJyogaisyaSisetuCode(TextBox TekiyoJyogaisyaSisetuCode) {
        this.getKaigoSikaku().getTekiyoJyogaisyaJoho().setTekiyoJyogaisyaSisetuCode(TekiyoJyogaisyaSisetuCode);
    }

    @JsonIgnore
    public TextBox getTekiyoJyogaisyaSisetuMesyo() {
        return this.getKaigoSikaku().getTekiyoJyogaisyaJoho().getTekiyoJyogaisyaSisetuMesyo();
    }

    @JsonIgnore
    public void  setTekiyoJyogaisyaSisetuMesyo(TextBox TekiyoJyogaisyaSisetuMesyo) {
        this.getKaigoSikaku().getTekiyoJyogaisyaJoho().setTekiyoJyogaisyaSisetuMesyo(TekiyoJyogaisyaSisetuMesyo);
    }

    // </editor-fold>
}
