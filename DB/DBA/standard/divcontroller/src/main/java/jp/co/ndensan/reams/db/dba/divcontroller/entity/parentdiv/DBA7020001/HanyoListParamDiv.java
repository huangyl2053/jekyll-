package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA7020001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hanyolistatenaselect.HanyoListAtenaSelect.HanyoListAtenaSelectDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hanyolistatenaselect.HanyoListAtenaSelect.IHanyoListAtenaSelectDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokukomoku.ChohyoShutsuryokuKomoku.ChohyoShutsuryokuKomokuDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokukomoku.ChohyoShutsuryokuKomoku.IChohyoShutsuryokuKomokuDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * HanyoListParam のクラスファイル 
 * 
 * @author 自動生成
 */
public class HanyoListParamDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("JokenFukugenHozon")
    private JokenFukugenHozonDiv JokenFukugenHozon;
    @JsonProperty("TekiyoJogaishaJoken")
    private TekiyoJogaishaJokenDiv TekiyoJogaishaJoken;
    @JsonProperty("TaShichosonJushotiTokureishaJoken")
    private TaShichosonJushotiTokureishaJokenDiv TaShichosonJushotiTokureishaJoken;
    @JsonProperty("RoreiFukushiNenkinJukyushaJoken")
    private RoreiFukushiNenkinJukyushaJokenDiv RoreiFukushiNenkinJukyushaJoken;
    @JsonProperty("SeikatuhogoJukyushaJoken")
    private SeikatuhogoJukyushaJokenDiv SeikatuhogoJukyushaJoken;
    @JsonProperty("ChushutsuPanel2")
    private ChushutsuPanel2Div ChushutsuPanel2;
    @JsonProperty("CsvHenshuHoho")
    private CsvHenshuHohoDiv CsvHenshuHoho;
    @JsonProperty("ccdShutsuryokuKomoku")
    private ChohyoShutsuryokuKomokuDiv ccdShutsuryokuKomoku;
    @JsonProperty("ccdShutsuryokujun")
    private ChohyoShutsuryokujunDiv ccdShutsuryokujun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getJokenFukugenHozon
     * @return JokenFukugenHozon
     */
    @JsonProperty("JokenFukugenHozon")
    public JokenFukugenHozonDiv getJokenFukugenHozon() {
        return JokenFukugenHozon;
    }

    /*
     * setJokenFukugenHozon
     * @param JokenFukugenHozon JokenFukugenHozon
     */
    @JsonProperty("JokenFukugenHozon")
    public void setJokenFukugenHozon(JokenFukugenHozonDiv JokenFukugenHozon) {
        this.JokenFukugenHozon = JokenFukugenHozon;
    }

    /*
     * getTekiyoJogaishaJoken
     * @return TekiyoJogaishaJoken
     */
    @JsonProperty("TekiyoJogaishaJoken")
    public TekiyoJogaishaJokenDiv getTekiyoJogaishaJoken() {
        return TekiyoJogaishaJoken;
    }

    /*
     * setTekiyoJogaishaJoken
     * @param TekiyoJogaishaJoken TekiyoJogaishaJoken
     */
    @JsonProperty("TekiyoJogaishaJoken")
    public void setTekiyoJogaishaJoken(TekiyoJogaishaJokenDiv TekiyoJogaishaJoken) {
        this.TekiyoJogaishaJoken = TekiyoJogaishaJoken;
    }

    /*
     * getTaShichosonJushotiTokureishaJoken
     * @return TaShichosonJushotiTokureishaJoken
     */
    @JsonProperty("TaShichosonJushotiTokureishaJoken")
    public TaShichosonJushotiTokureishaJokenDiv getTaShichosonJushotiTokureishaJoken() {
        return TaShichosonJushotiTokureishaJoken;
    }

    /*
     * setTaShichosonJushotiTokureishaJoken
     * @param TaShichosonJushotiTokureishaJoken TaShichosonJushotiTokureishaJoken
     */
    @JsonProperty("TaShichosonJushotiTokureishaJoken")
    public void setTaShichosonJushotiTokureishaJoken(TaShichosonJushotiTokureishaJokenDiv TaShichosonJushotiTokureishaJoken) {
        this.TaShichosonJushotiTokureishaJoken = TaShichosonJushotiTokureishaJoken;
    }

    /*
     * getRoreiFukushiNenkinJukyushaJoken
     * @return RoreiFukushiNenkinJukyushaJoken
     */
    @JsonProperty("RoreiFukushiNenkinJukyushaJoken")
    public RoreiFukushiNenkinJukyushaJokenDiv getRoreiFukushiNenkinJukyushaJoken() {
        return RoreiFukushiNenkinJukyushaJoken;
    }

    /*
     * setRoreiFukushiNenkinJukyushaJoken
     * @param RoreiFukushiNenkinJukyushaJoken RoreiFukushiNenkinJukyushaJoken
     */
    @JsonProperty("RoreiFukushiNenkinJukyushaJoken")
    public void setRoreiFukushiNenkinJukyushaJoken(RoreiFukushiNenkinJukyushaJokenDiv RoreiFukushiNenkinJukyushaJoken) {
        this.RoreiFukushiNenkinJukyushaJoken = RoreiFukushiNenkinJukyushaJoken;
    }

    /*
     * getSeikatuhogoJukyushaJoken
     * @return SeikatuhogoJukyushaJoken
     */
    @JsonProperty("SeikatuhogoJukyushaJoken")
    public SeikatuhogoJukyushaJokenDiv getSeikatuhogoJukyushaJoken() {
        return SeikatuhogoJukyushaJoken;
    }

    /*
     * setSeikatuhogoJukyushaJoken
     * @param SeikatuhogoJukyushaJoken SeikatuhogoJukyushaJoken
     */
    @JsonProperty("SeikatuhogoJukyushaJoken")
    public void setSeikatuhogoJukyushaJoken(SeikatuhogoJukyushaJokenDiv SeikatuhogoJukyushaJoken) {
        this.SeikatuhogoJukyushaJoken = SeikatuhogoJukyushaJoken;
    }

    /*
     * getChushutsuPanel2
     * @return ChushutsuPanel2
     */
    @JsonProperty("ChushutsuPanel2")
    public ChushutsuPanel2Div getChushutsuPanel2() {
        return ChushutsuPanel2;
    }

    /*
     * setChushutsuPanel2
     * @param ChushutsuPanel2 ChushutsuPanel2
     */
    @JsonProperty("ChushutsuPanel2")
    public void setChushutsuPanel2(ChushutsuPanel2Div ChushutsuPanel2) {
        this.ChushutsuPanel2 = ChushutsuPanel2;
    }

    /*
     * getCsvHenshuHoho
     * @return CsvHenshuHoho
     */
    @JsonProperty("CsvHenshuHoho")
    public CsvHenshuHohoDiv getCsvHenshuHoho() {
        return CsvHenshuHoho;
    }

    /*
     * setCsvHenshuHoho
     * @param CsvHenshuHoho CsvHenshuHoho
     */
    @JsonProperty("CsvHenshuHoho")
    public void setCsvHenshuHoho(CsvHenshuHohoDiv CsvHenshuHoho) {
        this.CsvHenshuHoho = CsvHenshuHoho;
    }

    /*
     * getccdShutsuryokuKomoku
     * @return ccdShutsuryokuKomoku
     */
    @JsonProperty("ccdShutsuryokuKomoku")
    public IChohyoShutsuryokuKomokuDiv getCcdShutsuryokuKomoku() {
        return ccdShutsuryokuKomoku;
    }

    /*
     * getccdShutsuryokujun
     * @return ccdShutsuryokujun
     */
    @JsonProperty("ccdShutsuryokujun")
    public IChohyoShutsuryokujunDiv getCcdShutsuryokujun() {
        return ccdShutsuryokujun;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public ButtonBatchParameterSave getBtnParamSave() {
        return this.getJokenFukugenHozon().getBtnParamSave();
    }

    @JsonIgnore
    public void  setBtnParamSave(ButtonBatchParameterSave btnParamSave) {
        this.getJokenFukugenHozon().setBtnParamSave(btnParamSave);
    }

    @JsonIgnore
    public ButtonBatchParameterRestore getBtnParamRestore() {
        return this.getJokenFukugenHozon().getBtnParamRestore();
    }

    @JsonIgnore
    public void  setBtnParamRestore(ButtonBatchParameterRestore btnParamRestore) {
        this.getJokenFukugenHozon().setBtnParamRestore(btnParamRestore);
    }

    @JsonIgnore
    public RadioButton getRadTekiyoJogaishaChushutsu() {
        return this.getTekiyoJogaishaJoken().getRadTekiyoJogaishaChushutsu();
    }

    @JsonIgnore
    public void  setRadTekiyoJogaishaChushutsu(RadioButton radTekiyoJogaishaChushutsu) {
        this.getTekiyoJogaishaJoken().setRadTekiyoJogaishaChushutsu(radTekiyoJogaishaChushutsu);
    }

    @JsonIgnore
    public TekiyoJogaishaHizukeChushutsuDiv getTekiyoJogaishaHizukeChushutsu() {
        return this.getTekiyoJogaishaJoken().getTekiyoJogaishaHizukeChushutsu();
    }

    @JsonIgnore
    public void  setTekiyoJogaishaHizukeChushutsu(TekiyoJogaishaHizukeChushutsuDiv TekiyoJogaishaHizukeChushutsu) {
        this.getTekiyoJogaishaJoken().setTekiyoJogaishaHizukeChushutsu(TekiyoJogaishaHizukeChushutsu);
    }

    @JsonIgnore
    public Space getTekiyoJogaishaYohaku() {
        return this.getTekiyoJogaishaJoken().getTekiyoJogaishaHizukeChushutsu().getTekiyoJogaishaYohaku();
    }

    @JsonIgnore
    public void  setTekiyoJogaishaYohaku(Space TekiyoJogaishaYohaku) {
        this.getTekiyoJogaishaJoken().getTekiyoJogaishaHizukeChushutsu().setTekiyoJogaishaYohaku(TekiyoJogaishaYohaku);
    }

    @JsonIgnore
    public RadioButton getRadTekiyoJogaishaTekiyoKijyun() {
        return this.getTekiyoJogaishaJoken().getTekiyoJogaishaHizukeChushutsu().getRadTekiyoJogaishaTekiyoKijyun();
    }

    @JsonIgnore
    public void  setRadTekiyoJogaishaTekiyoKijyun(RadioButton radTekiyoJogaishaTekiyoKijyun) {
        this.getTekiyoJogaishaJoken().getTekiyoJogaishaHizukeChushutsu().setRadTekiyoJogaishaTekiyoKijyun(radTekiyoJogaishaTekiyoKijyun);
    }

    @JsonIgnore
    public TextBoxDate getTexTekiyoJogaishaKijyunDate() {
        return this.getTekiyoJogaishaJoken().getTekiyoJogaishaHizukeChushutsu().getTexTekiyoJogaishaKijyunDate();
    }

    @JsonIgnore
    public void  setTexTekiyoJogaishaKijyunDate(TextBoxDate texTekiyoJogaishaKijyunDate) {
        this.getTekiyoJogaishaJoken().getTekiyoJogaishaHizukeChushutsu().setTexTekiyoJogaishaKijyunDate(texTekiyoJogaishaKijyunDate);
    }

    @JsonIgnore
    public RadioButton getRadTekiyoJogaishaTekiyoHani() {
        return this.getTekiyoJogaishaJoken().getTekiyoJogaishaHizukeChushutsu().getRadTekiyoJogaishaTekiyoHani();
    }

    @JsonIgnore
    public void  setRadTekiyoJogaishaTekiyoHani(RadioButton radTekiyoJogaishaTekiyoHani) {
        this.getTekiyoJogaishaJoken().getTekiyoJogaishaHizukeChushutsu().setRadTekiyoJogaishaTekiyoHani(radTekiyoJogaishaTekiyoHani);
    }

    @JsonIgnore
    public TextBoxDateRange getTexTekiyoJogaishaTekiyoDateHani() {
        return this.getTekiyoJogaishaJoken().getTekiyoJogaishaHizukeChushutsu().getTexTekiyoJogaishaTekiyoDateHani();
    }

    @JsonIgnore
    public void  setTexTekiyoJogaishaTekiyoDateHani(TextBoxDateRange texTekiyoJogaishaTekiyoDateHani) {
        this.getTekiyoJogaishaJoken().getTekiyoJogaishaHizukeChushutsu().setTexTekiyoJogaishaTekiyoDateHani(texTekiyoJogaishaTekiyoDateHani);
    }

    @JsonIgnore
    public HorizontalLine getLinLine01() {
        return this.getTekiyoJogaishaJoken().getLinLine01();
    }

    @JsonIgnore
    public void  setLinLine01(HorizontalLine linLine01) {
        this.getTekiyoJogaishaJoken().setLinLine01(linLine01);
    }

    @JsonIgnore
    public CheckBoxList getChkTekiyoJogaishaJoho() {
        return this.getTekiyoJogaishaJoken().getChkTekiyoJogaishaJoho();
    }

    @JsonIgnore
    public void  setChkTekiyoJogaishaJoho(CheckBoxList chkTekiyoJogaishaJoho) {
        this.getTekiyoJogaishaJoken().setChkTekiyoJogaishaJoho(chkTekiyoJogaishaJoho);
    }

    @JsonIgnore
    public HorizontalLine getLinLine02() {
        return this.getTekiyoJogaishaJoken().getLinLine02();
    }

    @JsonIgnore
    public void  setLinLine02(HorizontalLine linLine02) {
        this.getTekiyoJogaishaJoken().setLinLine02(linLine02);
    }

    @JsonIgnore
    public RadioButton getRadTekiyoJogaisha() {
        return this.getTekiyoJogaishaJoken().getRadTekiyoJogaisha();
    }

    @JsonIgnore
    public void  setRadTekiyoJogaisha(RadioButton radTekiyoJogaisha) {
        this.getTekiyoJogaishaJoken().setRadTekiyoJogaisha(radTekiyoJogaisha);
    }

    @JsonIgnore
    public CheckBoxList getChkTekiyoJogaishaTekiyoJiyu() {
        return this.getTekiyoJogaishaJoken().getChkTekiyoJogaishaTekiyoJiyu();
    }

    @JsonIgnore
    public void  setChkTekiyoJogaishaTekiyoJiyu(CheckBoxList chkTekiyoJogaishaTekiyoJiyu) {
        this.getTekiyoJogaishaJoken().setChkTekiyoJogaishaTekiyoJiyu(chkTekiyoJogaishaTekiyoJiyu);
    }

    @JsonIgnore
    public CheckBoxList getChkTekiyoJogaishaKaijoJiyu() {
        return this.getTekiyoJogaishaJoken().getChkTekiyoJogaishaKaijoJiyu();
    }

    @JsonIgnore
    public void  setChkTekiyoJogaishaKaijoJiyu(CheckBoxList chkTekiyoJogaishaKaijoJiyu) {
        this.getTekiyoJogaishaJoken().setChkTekiyoJogaishaKaijoJiyu(chkTekiyoJogaishaKaijoJiyu);
    }

    @JsonIgnore
    public CheckBoxList getChkTekiyoJogaishaShisetsuHenko() {
        return this.getTekiyoJogaishaJoken().getChkTekiyoJogaishaShisetsuHenko();
    }

    @JsonIgnore
    public void  setChkTekiyoJogaishaShisetsuHenko(CheckBoxList chkTekiyoJogaishaShisetsuHenko) {
        this.getTekiyoJogaishaJoken().setChkTekiyoJogaishaShisetsuHenko(chkTekiyoJogaishaShisetsuHenko);
    }

    @JsonIgnore
    public RadioButton getRadTaShichosonJushotiTokureishaChushutsu() {
        return this.getTaShichosonJushotiTokureishaJoken().getRadTaShichosonJushotiTokureishaChushutsu();
    }

    @JsonIgnore
    public void  setRadTaShichosonJushotiTokureishaChushutsu(RadioButton radTaShichosonJushotiTokureishaChushutsu) {
        this.getTaShichosonJushotiTokureishaJoken().setRadTaShichosonJushotiTokureishaChushutsu(radTaShichosonJushotiTokureishaChushutsu);
    }

    @JsonIgnore
    public TaShichosonJushotiTokureishaHizukeChushutsuDiv getTaShichosonJushotiTokureishaHizukeChushutsu() {
        return this.getTaShichosonJushotiTokureishaJoken().getTaShichosonJushotiTokureishaHizukeChushutsu();
    }

    @JsonIgnore
    public void  setTaShichosonJushotiTokureishaHizukeChushutsu(TaShichosonJushotiTokureishaHizukeChushutsuDiv TaShichosonJushotiTokureishaHizukeChushutsu) {
        this.getTaShichosonJushotiTokureishaJoken().setTaShichosonJushotiTokureishaHizukeChushutsu(TaShichosonJushotiTokureishaHizukeChushutsu);
    }

    @JsonIgnore
    public Space getTaShichosonJushotiTokureishaYohaku() {
        return this.getTaShichosonJushotiTokureishaJoken().getTaShichosonJushotiTokureishaHizukeChushutsu().getTaShichosonJushotiTokureishaYohaku();
    }

    @JsonIgnore
    public void  setTaShichosonJushotiTokureishaYohaku(Space TaShichosonJushotiTokureishaYohaku) {
        this.getTaShichosonJushotiTokureishaJoken().getTaShichosonJushotiTokureishaHizukeChushutsu().setTaShichosonJushotiTokureishaYohaku(TaShichosonJushotiTokureishaYohaku);
    }

    @JsonIgnore
    public RadioButton getRadTaShichosonJushotiTokureishaTekiyoKijyun() {
        return this.getTaShichosonJushotiTokureishaJoken().getTaShichosonJushotiTokureishaHizukeChushutsu().getRadTaShichosonJushotiTokureishaTekiyoKijyun();
    }

    @JsonIgnore
    public void  setRadTaShichosonJushotiTokureishaTekiyoKijyun(RadioButton radTaShichosonJushotiTokureishaTekiyoKijyun) {
        this.getTaShichosonJushotiTokureishaJoken().getTaShichosonJushotiTokureishaHizukeChushutsu().setRadTaShichosonJushotiTokureishaTekiyoKijyun(radTaShichosonJushotiTokureishaTekiyoKijyun);
    }

    @JsonIgnore
    public TextBoxDate getTexTaShichosonJushotiTokureishaKijyunDate() {
        return this.getTaShichosonJushotiTokureishaJoken().getTaShichosonJushotiTokureishaHizukeChushutsu().getTexTaShichosonJushotiTokureishaKijyunDate();
    }

    @JsonIgnore
    public void  setTexTaShichosonJushotiTokureishaKijyunDate(TextBoxDate texTaShichosonJushotiTokureishaKijyunDate) {
        this.getTaShichosonJushotiTokureishaJoken().getTaShichosonJushotiTokureishaHizukeChushutsu().setTexTaShichosonJushotiTokureishaKijyunDate(texTaShichosonJushotiTokureishaKijyunDate);
    }

    @JsonIgnore
    public RadioButton getRadTaShichosonJushotiTokureishaTekiyoHani() {
        return this.getTaShichosonJushotiTokureishaJoken().getTaShichosonJushotiTokureishaHizukeChushutsu().getRadTaShichosonJushotiTokureishaTekiyoHani();
    }

    @JsonIgnore
    public void  setRadTaShichosonJushotiTokureishaTekiyoHani(RadioButton radTaShichosonJushotiTokureishaTekiyoHani) {
        this.getTaShichosonJushotiTokureishaJoken().getTaShichosonJushotiTokureishaHizukeChushutsu().setRadTaShichosonJushotiTokureishaTekiyoHani(radTaShichosonJushotiTokureishaTekiyoHani);
    }

    @JsonIgnore
    public TextBoxDateRange getTexTaShichosonJushotiTokureishaTekiyoDateHani() {
        return this.getTaShichosonJushotiTokureishaJoken().getTaShichosonJushotiTokureishaHizukeChushutsu().getTexTaShichosonJushotiTokureishaTekiyoDateHani();
    }

    @JsonIgnore
    public void  setTexTaShichosonJushotiTokureishaTekiyoDateHani(TextBoxDateRange texTaShichosonJushotiTokureishaTekiyoDateHani) {
        this.getTaShichosonJushotiTokureishaJoken().getTaShichosonJushotiTokureishaHizukeChushutsu().setTexTaShichosonJushotiTokureishaTekiyoDateHani(texTaShichosonJushotiTokureishaTekiyoDateHani);
    }

    @JsonIgnore
    public HorizontalLine getLinLine03() {
        return this.getTaShichosonJushotiTokureishaJoken().getLinLine03();
    }

    @JsonIgnore
    public void  setLinLine03(HorizontalLine linLine03) {
        this.getTaShichosonJushotiTokureishaJoken().setLinLine03(linLine03);
    }

    @JsonIgnore
    public CheckBoxList getChkTaShichosonJushotiTokureishaJoho() {
        return this.getTaShichosonJushotiTokureishaJoken().getChkTaShichosonJushotiTokureishaJoho();
    }

    @JsonIgnore
    public void  setChkTaShichosonJushotiTokureishaJoho(CheckBoxList chkTaShichosonJushotiTokureishaJoho) {
        this.getTaShichosonJushotiTokureishaJoken().setChkTaShichosonJushotiTokureishaJoho(chkTaShichosonJushotiTokureishaJoho);
    }

    @JsonIgnore
    public HorizontalLine getLinLine04() {
        return this.getTaShichosonJushotiTokureishaJoken().getLinLine04();
    }

    @JsonIgnore
    public void  setLinLine04(HorizontalLine linLine04) {
        this.getTaShichosonJushotiTokureishaJoken().setLinLine04(linLine04);
    }

    @JsonIgnore
    public RadioButton getRadTaShichosonJushotiTokureisha() {
        return this.getTaShichosonJushotiTokureishaJoken().getRadTaShichosonJushotiTokureisha();
    }

    @JsonIgnore
    public void  setRadTaShichosonJushotiTokureisha(RadioButton radTaShichosonJushotiTokureisha) {
        this.getTaShichosonJushotiTokureishaJoken().setRadTaShichosonJushotiTokureisha(radTaShichosonJushotiTokureisha);
    }

    @JsonIgnore
    public CheckBoxList getChkTaShichosonJushotiTokureishaTekiyoJiyu() {
        return this.getTaShichosonJushotiTokureishaJoken().getChkTaShichosonJushotiTokureishaTekiyoJiyu();
    }

    @JsonIgnore
    public void  setChkTaShichosonJushotiTokureishaTekiyoJiyu(CheckBoxList chkTaShichosonJushotiTokureishaTekiyoJiyu) {
        this.getTaShichosonJushotiTokureishaJoken().setChkTaShichosonJushotiTokureishaTekiyoJiyu(chkTaShichosonJushotiTokureishaTekiyoJiyu);
    }

    @JsonIgnore
    public CheckBoxList getChkTaShichosonJushotiTokureishaKaijoJiyu() {
        return this.getTaShichosonJushotiTokureishaJoken().getChkTaShichosonJushotiTokureishaKaijoJiyu();
    }

    @JsonIgnore
    public void  setChkTaShichosonJushotiTokureishaKaijoJiyu(CheckBoxList chkTaShichosonJushotiTokureishaKaijoJiyu) {
        this.getTaShichosonJushotiTokureishaJoken().setChkTaShichosonJushotiTokureishaKaijoJiyu(chkTaShichosonJushotiTokureishaKaijoJiyu);
    }

    @JsonIgnore
    public CheckBoxList getChkTaShichosonJushotiTokureishaShisetsuHenko() {
        return this.getTaShichosonJushotiTokureishaJoken().getChkTaShichosonJushotiTokureishaShisetsuHenko();
    }

    @JsonIgnore
    public void  setChkTaShichosonJushotiTokureishaShisetsuHenko(CheckBoxList chkTaShichosonJushotiTokureishaShisetsuHenko) {
        this.getTaShichosonJushotiTokureishaJoken().setChkTaShichosonJushotiTokureishaShisetsuHenko(chkTaShichosonJushotiTokureishaShisetsuHenko);
    }

    @JsonIgnore
    public RadioButton getRadRoreiFukushiNenkinJukyushaChushutsu() {
        return this.getRoreiFukushiNenkinJukyushaJoken().getRadRoreiFukushiNenkinJukyushaChushutsu();
    }

    @JsonIgnore
    public void  setRadRoreiFukushiNenkinJukyushaChushutsu(RadioButton radRoreiFukushiNenkinJukyushaChushutsu) {
        this.getRoreiFukushiNenkinJukyushaJoken().setRadRoreiFukushiNenkinJukyushaChushutsu(radRoreiFukushiNenkinJukyushaChushutsu);
    }

    @JsonIgnore
    public RoreiFukushiNenkinHizukeChushutsuDiv getRoreiFukushiNenkinHizukeChushutsu() {
        return this.getRoreiFukushiNenkinJukyushaJoken().getRoreiFukushiNenkinHizukeChushutsu();
    }

    @JsonIgnore
    public void  setRoreiFukushiNenkinHizukeChushutsu(RoreiFukushiNenkinHizukeChushutsuDiv RoreiFukushiNenkinHizukeChushutsu) {
        this.getRoreiFukushiNenkinJukyushaJoken().setRoreiFukushiNenkinHizukeChushutsu(RoreiFukushiNenkinHizukeChushutsu);
    }

    @JsonIgnore
    public Space getRoreiFukushiNenkinJukyushaYohaku() {
        return this.getRoreiFukushiNenkinJukyushaJoken().getRoreiFukushiNenkinHizukeChushutsu().getRoreiFukushiNenkinJukyushaYohaku();
    }

    @JsonIgnore
    public void  setRoreiFukushiNenkinJukyushaYohaku(Space RoreiFukushiNenkinJukyushaYohaku) {
        this.getRoreiFukushiNenkinJukyushaJoken().getRoreiFukushiNenkinHizukeChushutsu().setRoreiFukushiNenkinJukyushaYohaku(RoreiFukushiNenkinJukyushaYohaku);
    }

    @JsonIgnore
    public TextBoxDate getTexRoreiFukushiNenkinJukyushaKijyunDate() {
        return this.getRoreiFukushiNenkinJukyushaJoken().getRoreiFukushiNenkinHizukeChushutsu().getTexRoreiFukushiNenkinJukyushaKijyunDate();
    }

    @JsonIgnore
    public void  setTexRoreiFukushiNenkinJukyushaKijyunDate(TextBoxDate texRoreiFukushiNenkinJukyushaKijyunDate) {
        this.getRoreiFukushiNenkinJukyushaJoken().getRoreiFukushiNenkinHizukeChushutsu().setTexRoreiFukushiNenkinJukyushaKijyunDate(texRoreiFukushiNenkinJukyushaKijyunDate);
    }

    @JsonIgnore
    public RadioButton getRadRoreiFukushiNenkinJukyushaHani() {
        return this.getRoreiFukushiNenkinJukyushaJoken().getRoreiFukushiNenkinHizukeChushutsu().getRadRoreiFukushiNenkinJukyushaHani();
    }

    @JsonIgnore
    public void  setRadRoreiFukushiNenkinJukyushaHani(RadioButton radRoreiFukushiNenkinJukyushaHani) {
        this.getRoreiFukushiNenkinJukyushaJoken().getRoreiFukushiNenkinHizukeChushutsu().setRadRoreiFukushiNenkinJukyushaHani(radRoreiFukushiNenkinJukyushaHani);
    }

    @JsonIgnore
    public TextBoxDateRange getTexRoreiFukushiNenkinJukyushaDateHani() {
        return this.getRoreiFukushiNenkinJukyushaJoken().getRoreiFukushiNenkinHizukeChushutsu().getTexRoreiFukushiNenkinJukyushaDateHani();
    }

    @JsonIgnore
    public void  setTexRoreiFukushiNenkinJukyushaDateHani(TextBoxDateRange texRoreiFukushiNenkinJukyushaDateHani) {
        this.getRoreiFukushiNenkinJukyushaJoken().getRoreiFukushiNenkinHizukeChushutsu().setTexRoreiFukushiNenkinJukyushaDateHani(texRoreiFukushiNenkinJukyushaDateHani);
    }

    @JsonIgnore
    public RadioButton getRadSeikatuhogoJukyushaChushutsu() {
        return this.getSeikatuhogoJukyushaJoken().getRadSeikatuhogoJukyushaChushutsu();
    }

    @JsonIgnore
    public void  setRadSeikatuhogoJukyushaChushutsu(RadioButton radSeikatuhogoJukyushaChushutsu) {
        this.getSeikatuhogoJukyushaJoken().setRadSeikatuhogoJukyushaChushutsu(radSeikatuhogoJukyushaChushutsu);
    }

    @JsonIgnore
    public SeikatuhogoJukyushaHizukeChushutsuDiv getSeikatuhogoJukyushaHizukeChushutsu() {
        return this.getSeikatuhogoJukyushaJoken().getSeikatuhogoJukyushaHizukeChushutsu();
    }

    @JsonIgnore
    public void  setSeikatuhogoJukyushaHizukeChushutsu(SeikatuhogoJukyushaHizukeChushutsuDiv SeikatuhogoJukyushaHizukeChushutsu) {
        this.getSeikatuhogoJukyushaJoken().setSeikatuhogoJukyushaHizukeChushutsu(SeikatuhogoJukyushaHizukeChushutsu);
    }

    @JsonIgnore
    public Space getSeikatuhogoJukyushaYohaku() {
        return this.getSeikatuhogoJukyushaJoken().getSeikatuhogoJukyushaHizukeChushutsu().getSeikatuhogoJukyushaYohaku();
    }

    @JsonIgnore
    public void  setSeikatuhogoJukyushaYohaku(Space SeikatuhogoJukyushaYohaku) {
        this.getSeikatuhogoJukyushaJoken().getSeikatuhogoJukyushaHizukeChushutsu().setSeikatuhogoJukyushaYohaku(SeikatuhogoJukyushaYohaku);
    }

    @JsonIgnore
    public TextBoxDate getTexSeikatuhogoKijunDate() {
        return this.getSeikatuhogoJukyushaJoken().getSeikatuhogoJukyushaHizukeChushutsu().getTexSeikatuhogoKijunDate();
    }

    @JsonIgnore
    public void  setTexSeikatuhogoKijunDate(TextBoxDate texSeikatuhogoKijunDate) {
        this.getSeikatuhogoJukyushaJoken().getSeikatuhogoJukyushaHizukeChushutsu().setTexSeikatuhogoKijunDate(texSeikatuhogoKijunDate);
    }

    @JsonIgnore
    public RadioButton getRadSeikatuhogoHani() {
        return this.getSeikatuhogoJukyushaJoken().getSeikatuhogoJukyushaHizukeChushutsu().getRadSeikatuhogoHani();
    }

    @JsonIgnore
    public void  setRadSeikatuhogoHani(RadioButton radSeikatuhogoHani) {
        this.getSeikatuhogoJukyushaJoken().getSeikatuhogoJukyushaHizukeChushutsu().setRadSeikatuhogoHani(radSeikatuhogoHani);
    }

    @JsonIgnore
    public TextBoxDateRange getTexSeikatuhogoDateHani() {
        return this.getSeikatuhogoJukyushaJoken().getSeikatuhogoJukyushaHizukeChushutsu().getTexSeikatuhogoDateHani();
    }

    @JsonIgnore
    public void  setTexSeikatuhogoDateHani(TextBoxDateRange texSeikatuhogoDateHani) {
        this.getSeikatuhogoJukyushaJoken().getSeikatuhogoJukyushaHizukeChushutsu().setTexSeikatuhogoDateHani(texSeikatuhogoDateHani);
    }

    @JsonIgnore
    public HorizontalLine getLinLine05() {
        return this.getSeikatuhogoJukyushaJoken().getLinLine05();
    }

    @JsonIgnore
    public void  setLinLine05(HorizontalLine linLine05) {
        this.getSeikatuhogoJukyushaJoken().setLinLine05(linLine05);
    }

    @JsonIgnore
    public CheckBoxList getChkSeikatsuHogoJukyushaJoho() {
        return this.getSeikatuhogoJukyushaJoken().getChkSeikatsuHogoJukyushaJoho();
    }

    @JsonIgnore
    public void  setChkSeikatsuHogoJukyushaJoho(CheckBoxList chkSeikatsuHogoJukyushaJoho) {
        this.getSeikatuhogoJukyushaJoken().setChkSeikatsuHogoJukyushaJoho(chkSeikatsuHogoJukyushaJoho);
    }

    @JsonIgnore
    public CheckBoxList getChkSeikatsuHogo() {
        return this.getSeikatuhogoJukyushaJoken().getChkSeikatsuHogo();
    }

    @JsonIgnore
    public void  setChkSeikatsuHogo(CheckBoxList chkSeikatsuHogo) {
        this.getSeikatuhogoJukyushaJoken().setChkSeikatsuHogo(chkSeikatsuHogo);
    }

    @JsonIgnore
    public IHanyoListAtenaSelectDiv getCcdHanyoListAtenaSelect() {
        return this.getChushutsuPanel2().getCcdHanyoListAtenaSelect();
    }

    @JsonIgnore
    public CheckBoxList getChkCsvHenshuHoho() {
        return this.getCsvHenshuHoho().getChkCsvHenshuHoho();
    }

    @JsonIgnore
    public void  setChkCsvHenshuHoho(CheckBoxList chkCsvHenshuHoho) {
        this.getCsvHenshuHoho().setChkCsvHenshuHoho(chkCsvHenshuHoho);
    }

    // </editor-fold>
}
