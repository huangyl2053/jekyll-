package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0600011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KaigoSikaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class KaigoSikakuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SikakuJoho")
    private SikakuJohoDiv SikakuJoho;
    @JsonProperty("HihokensyaJoho")
    private HihokensyaJohoDiv HihokensyaJoho;
    @JsonProperty("SisetuNyutaisyoJoho")
    private SisetuNyutaisyoJohoDiv SisetuNyutaisyoJoho;
    @JsonProperty("HokaSityosonJoho")
    private HokaSityosonJohoDiv HokaSityosonJoho;
    @JsonProperty("TekiyoJyogaisyaJoho")
    private TekiyoJyogaisyaJohoDiv TekiyoJyogaisyaJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getSikakuJoho
     * @return SikakuJoho
     */
    @JsonProperty("SikakuJoho")
    public SikakuJohoDiv getSikakuJoho() {
        return SikakuJoho;
    }

    /*
     * setSikakuJoho
     * @param SikakuJoho SikakuJoho
     */
    @JsonProperty("SikakuJoho")
    public void setSikakuJoho(SikakuJohoDiv SikakuJoho) {
        this.SikakuJoho = SikakuJoho;
    }

    /*
     * getHihokensyaJoho
     * @return HihokensyaJoho
     */
    @JsonProperty("HihokensyaJoho")
    public HihokensyaJohoDiv getHihokensyaJoho() {
        return HihokensyaJoho;
    }

    /*
     * setHihokensyaJoho
     * @param HihokensyaJoho HihokensyaJoho
     */
    @JsonProperty("HihokensyaJoho")
    public void setHihokensyaJoho(HihokensyaJohoDiv HihokensyaJoho) {
        this.HihokensyaJoho = HihokensyaJoho;
    }

    /*
     * getSisetuNyutaisyoJoho
     * @return SisetuNyutaisyoJoho
     */
    @JsonProperty("SisetuNyutaisyoJoho")
    public SisetuNyutaisyoJohoDiv getSisetuNyutaisyoJoho() {
        return SisetuNyutaisyoJoho;
    }

    /*
     * setSisetuNyutaisyoJoho
     * @param SisetuNyutaisyoJoho SisetuNyutaisyoJoho
     */
    @JsonProperty("SisetuNyutaisyoJoho")
    public void setSisetuNyutaisyoJoho(SisetuNyutaisyoJohoDiv SisetuNyutaisyoJoho) {
        this.SisetuNyutaisyoJoho = SisetuNyutaisyoJoho;
    }

    /*
     * getHokaSityosonJoho
     * @return HokaSityosonJoho
     */
    @JsonProperty("HokaSityosonJoho")
    public HokaSityosonJohoDiv getHokaSityosonJoho() {
        return HokaSityosonJoho;
    }

    /*
     * setHokaSityosonJoho
     * @param HokaSityosonJoho HokaSityosonJoho
     */
    @JsonProperty("HokaSityosonJoho")
    public void setHokaSityosonJoho(HokaSityosonJohoDiv HokaSityosonJoho) {
        this.HokaSityosonJoho = HokaSityosonJoho;
    }

    /*
     * getTekiyoJyogaisyaJoho
     * @return TekiyoJyogaisyaJoho
     */
    @JsonProperty("TekiyoJyogaisyaJoho")
    public TekiyoJyogaisyaJohoDiv getTekiyoJyogaisyaJoho() {
        return TekiyoJyogaisyaJoho;
    }

    /*
     * setTekiyoJyogaisyaJoho
     * @param TekiyoJyogaisyaJoho TekiyoJyogaisyaJoho
     */
    @JsonProperty("TekiyoJyogaisyaJoho")
    public void setTekiyoJyogaisyaJoho(TekiyoJyogaisyaJohoDiv TekiyoJyogaisyaJoho) {
        this.TekiyoJyogaisyaJoho = TekiyoJyogaisyaJoho;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Button getSikakuJohoButton() {
        return this.getSikakuJoho().getSikakuJohoButton();
    }

    @JsonIgnore
    public void  setSikakuJohoButton(Button SikakuJohoButton) {
        this.getSikakuJoho().setSikakuJohoButton(SikakuJohoButton);
    }

    @JsonIgnore
    public Button getJyukyusyaJohoButton() {
        return this.getSikakuJoho().getJyukyusyaJohoButton();
    }

    @JsonIgnore
    public void  setJyukyusyaJohoButton(Button JyukyusyaJohoButton) {
        this.getSikakuJoho().setJyukyusyaJohoButton(JyukyusyaJohoButton);
    }

    @JsonIgnore
    public Button getKyuhuJohoButton() {
        return this.getSikakuJoho().getKyuhuJohoButton();
    }

    @JsonIgnore
    public void  setKyuhuJohoButton(Button KyuhuJohoButton) {
        this.getSikakuJoho().setKyuhuJohoButton(KyuhuJohoButton);
    }

    @JsonIgnore
    public Button getHukaJohoButton() {
        return this.getSikakuJoho().getHukaJohoButton();
    }

    @JsonIgnore
    public void  setHukaJohoButton(Button HukaJohoButton) {
        this.getSikakuJoho().setHukaJohoButton(HukaJohoButton);
    }

    @JsonIgnore
    public Button getJyuminJohoButton() {
        return this.getSikakuJoho().getJyuminJohoButton();
    }

    @JsonIgnore
    public void  setJyuminJohoButton(Button JyuminJohoButton) {
        this.getSikakuJoho().setJyuminJohoButton(JyuminJohoButton);
    }

    @JsonIgnore
    public Button getHihokensyaJohoButton() {
        return this.getSikakuJoho().getHihokensyaJohoButton();
    }

    @JsonIgnore
    public void  setHihokensyaJohoButton(Button HihokensyaJohoButton) {
        this.getSikakuJoho().setHihokensyaJohoButton(HihokensyaJohoButton);
    }

    @JsonIgnore
    public Button getHokaJyusyoTokureisyaButton7() {
        return this.getSikakuJoho().getHokaJyusyoTokureisyaButton7();
    }

    @JsonIgnore
    public void  setHokaJyusyoTokureisyaButton7(Button HokaJyusyoTokureisyaButton7) {
        this.getSikakuJoho().setHokaJyusyoTokureisyaButton7(HokaJyusyoTokureisyaButton7);
    }

    @JsonIgnore
    public Button getTekiyoJyogaisyaButton() {
        return this.getSikakuJoho().getTekiyoJyogaisyaButton();
    }

    @JsonIgnore
    public void  setTekiyoJyogaisyaButton(Button TekiyoJyogaisyaButton) {
        this.getSikakuJoho().setTekiyoJyogaisyaButton(TekiyoJyogaisyaButton);
    }

    @JsonIgnore
    public TextBoxDate getSyutokuYYMMDD() {
        return this.getHihokensyaJoho().getSyutokuYYMMDD();
    }

    @JsonIgnore
    public void  setSyutokuYYMMDD(TextBoxDate SyutokuYYMMDD) {
        this.getHihokensyaJoho().setSyutokuYYMMDD(SyutokuYYMMDD);
    }

    @JsonIgnore
    public TextBox getSyutokuJiyu() {
        return this.getHihokensyaJoho().getSyutokuJiyu();
    }

    @JsonIgnore
    public void  setSyutokuJiyu(TextBox SyutokuJiyu) {
        this.getHihokensyaJoho().setSyutokuJiyu(SyutokuJiyu);
    }

    @JsonIgnore
    public TextBox getHihokensyaKubun() {
        return this.getHihokensyaJoho().getHihokensyaKubun();
    }

    @JsonIgnore
    public void  setHihokensyaKubun(TextBox HihokensyaKubun) {
        this.getHihokensyaJoho().setHihokensyaKubun(HihokensyaKubun);
    }

    @JsonIgnore
    public TextBox getSyozaiHokensya() {
        return this.getHihokensyaJoho().getSyozaiHokensya();
    }

    @JsonIgnore
    public void  setSyozaiHokensya(TextBox SyozaiHokensya) {
        this.getHihokensyaJoho().setSyozaiHokensya(SyozaiHokensya);
    }

    @JsonIgnore
    public TextBoxDate getSosituYYMMDD() {
        return this.getHihokensyaJoho().getSosituYYMMDD();
    }

    @JsonIgnore
    public void  setSosituYYMMDD(TextBoxDate SosituYYMMDD) {
        this.getHihokensyaJoho().setSosituYYMMDD(SosituYYMMDD);
    }

    @JsonIgnore
    public TextBox getSosituJiyu() {
        return this.getHihokensyaJoho().getSosituJiyu();
    }

    @JsonIgnore
    public void  setSosituJiyu(TextBox SosituJiyu) {
        this.getHihokensyaJoho().setSosituJiyu(SosituJiyu);
    }

    @JsonIgnore
    public TextBoxDate getJyusyoTokureiTekiyouYYMMDD() {
        return this.getHihokensyaJoho().getJyusyoTokureiTekiyouYYMMDD();
    }

    @JsonIgnore
    public void  setJyusyoTokureiTekiyouYYMMDD(TextBoxDate JyusyoTokureiTekiyouYYMMDD) {
        this.getHihokensyaJoho().setJyusyoTokureiTekiyouYYMMDD(JyusyoTokureiTekiyouYYMMDD);
    }

    @JsonIgnore
    public TextBox getJyusyoTokureiTekiyouJiyu() {
        return this.getHihokensyaJoho().getJyusyoTokureiTekiyouJiyu();
    }

    @JsonIgnore
    public void  setJyusyoTokureiTekiyouJiyu(TextBox JyusyoTokureiTekiyouJiyu) {
        this.getHihokensyaJoho().setJyusyoTokureiTekiyouJiyu(JyusyoTokureiTekiyouJiyu);
    }

    @JsonIgnore
    public TextBox getKyuHokensya() {
        return this.getHihokensyaJoho().getKyuHokensya();
    }

    @JsonIgnore
    public void  setKyuHokensya(TextBox KyuHokensya) {
        this.getHihokensyaJoho().setKyuHokensya(KyuHokensya);
    }

    @JsonIgnore
    public TextBoxDate getHenkoYYMMDD() {
        return this.getHihokensyaJoho().getHenkoYYMMDD();
    }

    @JsonIgnore
    public void  setHenkoYYMMDD(TextBoxDate HenkoYYMMDD) {
        this.getHihokensyaJoho().setHenkoYYMMDD(HenkoYYMMDD);
    }

    @JsonIgnore
    public TextBox getHenkoJiyu() {
        return this.getHihokensyaJoho().getHenkoJiyu();
    }

    @JsonIgnore
    public void  setHenkoJiyu(TextBox HenkoJiyu) {
        this.getHihokensyaJoho().setHenkoJiyu(HenkoJiyu);
    }

    @JsonIgnore
    public TextBoxDate getJyusyoTokureiKaijoYYMMDD() {
        return this.getHihokensyaJoho().getJyusyoTokureiKaijoYYMMDD();
    }

    @JsonIgnore
    public void  setJyusyoTokureiKaijoYYMMDD(TextBoxDate JyusyoTokureiKaijoYYMMDD) {
        this.getHihokensyaJoho().setJyusyoTokureiKaijoYYMMDD(JyusyoTokureiKaijoYYMMDD);
    }

    @JsonIgnore
    public TextBox getJyusyoTokureiKaijoJiyu() {
        return this.getHihokensyaJoho().getJyusyoTokureiKaijoJiyu();
    }

    @JsonIgnore
    public void  setJyusyoTokureiKaijoJiyu(TextBox JyusyoTokureiKaijoJiyu) {
        this.getHihokensyaJoho().setJyusyoTokureiKaijoJiyu(JyusyoTokureiKaijoJiyu);
    }

    @JsonIgnore
    public TextBox getHiroSotiMotoHokensya() {
        return this.getHihokensyaJoho().getHiroSotiMotoHokensya();
    }

    @JsonIgnore
    public void  setHiroSotiMotoHokensya(TextBox HiroSotiMotoHokensya) {
        this.getHihokensyaJoho().setHiroSotiMotoHokensya(HiroSotiMotoHokensya);
    }

    @JsonIgnore
    public TextBoxDate getNyusyoYYMMDD() {
        return this.getSisetuNyutaisyoJoho().getNyusyoYYMMDD();
    }

    @JsonIgnore
    public void  setNyusyoYYMMDD(TextBoxDate NyusyoYYMMDD) {
        this.getSisetuNyutaisyoJoho().setNyusyoYYMMDD(NyusyoYYMMDD);
    }

    @JsonIgnore
    public TextBox getDaityoSyubetu() {
        return this.getSisetuNyutaisyoJoho().getDaityoSyubetu();
    }

    @JsonIgnore
    public void  setDaityoSyubetu(TextBox DaityoSyubetu) {
        this.getSisetuNyutaisyoJoho().setDaityoSyubetu(DaityoSyubetu);
    }

    @JsonIgnore
    public TextBox getSisetuSyubetu() {
        return this.getSisetuNyutaisyoJoho().getSisetuSyubetu();
    }

    @JsonIgnore
    public void  setSisetuSyubetu(TextBox SisetuSyubetu) {
        this.getSisetuNyutaisyoJoho().setSisetuSyubetu(SisetuSyubetu);
    }

    @JsonIgnore
    public TextBoxDate getTaisyoYYMMDD() {
        return this.getSisetuNyutaisyoJoho().getTaisyoYYMMDD();
    }

    @JsonIgnore
    public void  setTaisyoYYMMDD(TextBoxDate TaisyoYYMMDD) {
        this.getSisetuNyutaisyoJoho().setTaisyoYYMMDD(TaisyoYYMMDD);
    }

    @JsonIgnore
    public TextBox getNyusyoSisetuCode() {
        return this.getSisetuNyutaisyoJoho().getNyusyoSisetuCode();
    }

    @JsonIgnore
    public void  setNyusyoSisetuCode(TextBox NyusyoSisetuCode) {
        this.getSisetuNyutaisyoJoho().setNyusyoSisetuCode(NyusyoSisetuCode);
    }

    @JsonIgnore
    public TextBox getNyusyoSisetuMesyo() {
        return this.getSisetuNyutaisyoJoho().getNyusyoSisetuMesyo();
    }

    @JsonIgnore
    public void  setNyusyoSisetuMesyo(TextBox NyusyoSisetuMesyo) {
        this.getSisetuNyutaisyoJoho().setNyusyoSisetuMesyo(NyusyoSisetuMesyo);
    }

    @JsonIgnore
    public TextBoxDate getHokaSityosonTekiyoYYMMDD() {
        return this.getHokaSityosonJoho().getHokaSityosonTekiyoYYMMDD();
    }

    @JsonIgnore
    public void  setHokaSityosonTekiyoYYMMDD(TextBoxDate HokaSityosonTekiyoYYMMDD) {
        this.getHokaSityosonJoho().setHokaSityosonTekiyoYYMMDD(HokaSityosonTekiyoYYMMDD);
    }

    @JsonIgnore
    public TextBox getHokaSityosonTekiyouJiyu() {
        return this.getHokaSityosonJoho().getHokaSityosonTekiyouJiyu();
    }

    @JsonIgnore
    public void  setHokaSityosonTekiyouJiyu(TextBox HokaSityosonTekiyouJiyu) {
        this.getHokaSityosonJoho().setHokaSityosonTekiyouJiyu(HokaSityosonTekiyouJiyu);
    }

    @JsonIgnore
    public TextBox getSotiMotoHokensya() {
        return this.getHokaSityosonJoho().getSotiMotoHokensya();
    }

    @JsonIgnore
    public void  setSotiMotoHokensya(TextBox SotiMotoHokensya) {
        this.getHokaSityosonJoho().setSotiMotoHokensya(SotiMotoHokensya);
    }

    @JsonIgnore
    public TextBox getHokaSityosonSisetuSyubetu() {
        return this.getHokaSityosonJoho().getHokaSityosonSisetuSyubetu();
    }

    @JsonIgnore
    public void  setHokaSityosonSisetuSyubetu(TextBox HokaSityosonSisetuSyubetu) {
        this.getHokaSityosonJoho().setHokaSityosonSisetuSyubetu(HokaSityosonSisetuSyubetu);
    }

    @JsonIgnore
    public TextBoxDate getHokaSityosonKaijoYYMMDD() {
        return this.getHokaSityosonJoho().getHokaSityosonKaijoYYMMDD();
    }

    @JsonIgnore
    public void  setHokaSityosonKaijoYYMMDD(TextBoxDate HokaSityosonKaijoYYMMDD) {
        this.getHokaSityosonJoho().setHokaSityosonKaijoYYMMDD(HokaSityosonKaijoYYMMDD);
    }

    @JsonIgnore
    public TextBox getHokaSityosonKaijoJiyu() {
        return this.getHokaSityosonJoho().getHokaSityosonKaijoJiyu();
    }

    @JsonIgnore
    public void  setHokaSityosonKaijoJiyu(TextBox HokaSityosonKaijoJiyu) {
        this.getHokaSityosonJoho().setHokaSityosonKaijoJiyu(HokaSityosonKaijoJiyu);
    }

    @JsonIgnore
    public TextBox getSotiMotoHihokensya() {
        return this.getHokaSityosonJoho().getSotiMotoHihokensya();
    }

    @JsonIgnore
    public void  setSotiMotoHihokensya(TextBox SotiMotoHihokensya) {
        this.getHokaSityosonJoho().setSotiMotoHihokensya(SotiMotoHihokensya);
    }

    @JsonIgnore
    public TextBox getHokaSityosonSisetuCode() {
        return this.getHokaSityosonJoho().getHokaSityosonSisetuCode();
    }

    @JsonIgnore
    public void  setHokaSityosonSisetuCode(TextBox HokaSityosonSisetuCode) {
        this.getHokaSityosonJoho().setHokaSityosonSisetuCode(HokaSityosonSisetuCode);
    }

    @JsonIgnore
    public TextBox getHokaSityosonSisetuMesyo() {
        return this.getHokaSityosonJoho().getHokaSityosonSisetuMesyo();
    }

    @JsonIgnore
    public void  setHokaSityosonSisetuMesyo(TextBox HokaSityosonSisetuMesyo) {
        this.getHokaSityosonJoho().setHokaSityosonSisetuMesyo(HokaSityosonSisetuMesyo);
    }

    @JsonIgnore
    public TextBoxDate getTekiyoJyogaisyaTekiyoYYMMDD() {
        return this.getTekiyoJyogaisyaJoho().getTekiyoJyogaisyaTekiyoYYMMDD();
    }

    @JsonIgnore
    public void  setTekiyoJyogaisyaTekiyoYYMMDD(TextBoxDate TekiyoJyogaisyaTekiyoYYMMDD) {
        this.getTekiyoJyogaisyaJoho().setTekiyoJyogaisyaTekiyoYYMMDD(TekiyoJyogaisyaTekiyoYYMMDD);
    }

    @JsonIgnore
    public TextBox getTekiyoJyogaisyaTekiyouJiyu() {
        return this.getTekiyoJyogaisyaJoho().getTekiyoJyogaisyaTekiyouJiyu();
    }

    @JsonIgnore
    public void  setTekiyoJyogaisyaTekiyouJiyu(TextBox TekiyoJyogaisyaTekiyouJiyu) {
        this.getTekiyoJyogaisyaJoho().setTekiyoJyogaisyaTekiyouJiyu(TekiyoJyogaisyaTekiyouJiyu);
    }

    @JsonIgnore
    public TextBox getTekiyoJyogaisyaSisetuSyubetu() {
        return this.getTekiyoJyogaisyaJoho().getTekiyoJyogaisyaSisetuSyubetu();
    }

    @JsonIgnore
    public void  setTekiyoJyogaisyaSisetuSyubetu(TextBox TekiyoJyogaisyaSisetuSyubetu) {
        this.getTekiyoJyogaisyaJoho().setTekiyoJyogaisyaSisetuSyubetu(TekiyoJyogaisyaSisetuSyubetu);
    }

    @JsonIgnore
    public TextBoxDate getTekiyoJyogaisyaKaijoYYMMDD() {
        return this.getTekiyoJyogaisyaJoho().getTekiyoJyogaisyaKaijoYYMMDD();
    }

    @JsonIgnore
    public void  setTekiyoJyogaisyaKaijoYYMMDD(TextBoxDate TekiyoJyogaisyaKaijoYYMMDD) {
        this.getTekiyoJyogaisyaJoho().setTekiyoJyogaisyaKaijoYYMMDD(TekiyoJyogaisyaKaijoYYMMDD);
    }

    @JsonIgnore
    public TextBox getTekiyoJyogaisyaKaijoJiyu() {
        return this.getTekiyoJyogaisyaJoho().getTekiyoJyogaisyaKaijoJiyu();
    }

    @JsonIgnore
    public void  setTekiyoJyogaisyaKaijoJiyu(TextBox TekiyoJyogaisyaKaijoJiyu) {
        this.getTekiyoJyogaisyaJoho().setTekiyoJyogaisyaKaijoJiyu(TekiyoJyogaisyaKaijoJiyu);
    }

    @JsonIgnore
    public TextBox getTekiyoJyogaisyaSisetuCode() {
        return this.getTekiyoJyogaisyaJoho().getTekiyoJyogaisyaSisetuCode();
    }

    @JsonIgnore
    public void  setTekiyoJyogaisyaSisetuCode(TextBox TekiyoJyogaisyaSisetuCode) {
        this.getTekiyoJyogaisyaJoho().setTekiyoJyogaisyaSisetuCode(TekiyoJyogaisyaSisetuCode);
    }

    @JsonIgnore
    public TextBox getTekiyoJyogaisyaSisetuMesyo() {
        return this.getTekiyoJyogaisyaJoho().getTekiyoJyogaisyaSisetuMesyo();
    }

    @JsonIgnore
    public void  setTekiyoJyogaisyaSisetuMesyo(TextBox TekiyoJyogaisyaSisetuMesyo) {
        this.getTekiyoJyogaisyaJoho().setTekiyoJyogaisyaSisetuMesyo(TekiyoJyogaisyaSisetuMesyo);
    }

    // </editor-fold>
}
