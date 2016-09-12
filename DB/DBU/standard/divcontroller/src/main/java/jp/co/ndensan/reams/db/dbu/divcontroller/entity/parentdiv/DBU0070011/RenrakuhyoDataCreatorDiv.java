package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0070011;
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
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * RenrakuhyoDataCreator のクラスファイル 
 * 
 * @author 自動生成
 */
public class RenrakuhyoDataCreatorDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShikakuKihonJoho")
    private ShikakuKihonJohoDiv ShikakuKihonJoho;
    @JsonProperty("JisshitsutekiHutanKeigenshaHigaito")
    private JisshitsutekiHutanKeigenshaHigaitoDiv JisshitsutekiHutanKeigenshaHigaito;
    @JsonProperty("JisshitsutekiHutanKeigenshaGaitosha")
    private JisshitsutekiHutanKeigenshaGaitoshaDiv JisshitsutekiHutanKeigenshaGaitosha;
    @JsonProperty("kaigoHokenryoSelected")
    private RString kaigoHokenryoSelected;
    @JsonProperty("dankaiKubunSelected")
    private RString dankaiKubunSelected;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShikakuKihonJoho
     * @return ShikakuKihonJoho
     */
    @JsonProperty("ShikakuKihonJoho")
    public ShikakuKihonJohoDiv getShikakuKihonJoho() {
        return ShikakuKihonJoho;
    }

    /*
     * setShikakuKihonJoho
     * @param ShikakuKihonJoho ShikakuKihonJoho
     */
    @JsonProperty("ShikakuKihonJoho")
    public void setShikakuKihonJoho(ShikakuKihonJohoDiv ShikakuKihonJoho) {
        this.ShikakuKihonJoho = ShikakuKihonJoho;
    }

    /*
     * getJisshitsutekiHutanKeigenshaHigaito
     * @return JisshitsutekiHutanKeigenshaHigaito
     */
    @JsonProperty("JisshitsutekiHutanKeigenshaHigaito")
    public JisshitsutekiHutanKeigenshaHigaitoDiv getJisshitsutekiHutanKeigenshaHigaito() {
        return JisshitsutekiHutanKeigenshaHigaito;
    }

    /*
     * setJisshitsutekiHutanKeigenshaHigaito
     * @param JisshitsutekiHutanKeigenshaHigaito JisshitsutekiHutanKeigenshaHigaito
     */
    @JsonProperty("JisshitsutekiHutanKeigenshaHigaito")
    public void setJisshitsutekiHutanKeigenshaHigaito(JisshitsutekiHutanKeigenshaHigaitoDiv JisshitsutekiHutanKeigenshaHigaito) {
        this.JisshitsutekiHutanKeigenshaHigaito = JisshitsutekiHutanKeigenshaHigaito;
    }

    /*
     * getJisshitsutekiHutanKeigenshaGaitosha
     * @return JisshitsutekiHutanKeigenshaGaitosha
     */
    @JsonProperty("JisshitsutekiHutanKeigenshaGaitosha")
    public JisshitsutekiHutanKeigenshaGaitoshaDiv getJisshitsutekiHutanKeigenshaGaitosha() {
        return JisshitsutekiHutanKeigenshaGaitosha;
    }

    /*
     * setJisshitsutekiHutanKeigenshaGaitosha
     * @param JisshitsutekiHutanKeigenshaGaitosha JisshitsutekiHutanKeigenshaGaitosha
     */
    @JsonProperty("JisshitsutekiHutanKeigenshaGaitosha")
    public void setJisshitsutekiHutanKeigenshaGaitosha(JisshitsutekiHutanKeigenshaGaitoshaDiv JisshitsutekiHutanKeigenshaGaitosha) {
        this.JisshitsutekiHutanKeigenshaGaitosha = JisshitsutekiHutanKeigenshaGaitosha;
    }

    /*
     * getkaigoHokenryoSelected
     * @return kaigoHokenryoSelected
     */
    @JsonProperty("kaigoHokenryoSelected")
    public RString getKaigoHokenryoSelected() {
        return kaigoHokenryoSelected;
    }

    /*
     * setkaigoHokenryoSelected
     * @param kaigoHokenryoSelected kaigoHokenryoSelected
     */
    @JsonProperty("kaigoHokenryoSelected")
    public void setKaigoHokenryoSelected(RString kaigoHokenryoSelected) {
        this.kaigoHokenryoSelected = kaigoHokenryoSelected;
    }

    /*
     * getdankaiKubunSelected
     * @return dankaiKubunSelected
     */
    @JsonProperty("dankaiKubunSelected")
    public RString getDankaiKubunSelected() {
        return dankaiKubunSelected;
    }

    /*
     * setdankaiKubunSelected
     * @param dankaiKubunSelected dankaiKubunSelected
     */
    @JsonProperty("dankaiKubunSelected")
    public void setDankaiKubunSelected(RString dankaiKubunSelected) {
        this.dankaiKubunSelected = dankaiKubunSelected;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public IKaigoShikakuKihonDiv getCcdKaigoShikakuKihon() {
        return this.getShikakuKihonJoho().getCcdKaigoShikakuKihon();
    }

    @JsonIgnore
    public IKaigoAtenaInfoDiv getCcdKaigoAtenaInfo() {
        return this.getShikakuKihonJoho().getCcdKaigoAtenaInfo();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtRenrakuhyoSakuseiDate() {
        return this.getJisshitsutekiHutanKeigenshaHigaito().getTxtRenrakuhyoSakuseiDate();
    }

    @JsonIgnore
    public void  setTxtRenrakuhyoSakuseiDate(TextBoxFlexibleDate txtRenrakuhyoSakuseiDate) {
        this.getJisshitsutekiHutanKeigenshaHigaito().setTxtRenrakuhyoSakuseiDate(txtRenrakuhyoSakuseiDate);
    }

    @JsonIgnore
    public tblKyufugakugengakuDiv getTblKyufugakugengaku() {
        return this.getJisshitsutekiHutanKeigenshaHigaito().getTblKyufugakugengaku();
    }

    @JsonIgnore
    public void  setTblKyufugakugengaku(tblKyufugakugengakuDiv tblKyufugakugengaku) {
        this.getJisshitsutekiHutanKeigenshaHigaito().setTblKyufugakugengaku(tblKyufugakugengaku);
    }

    @JsonIgnore
    public KyufugakugengakuDiv getKyufugakugengaku() {
        return this.getJisshitsutekiHutanKeigenshaHigaito().getTblKyufugakugengaku().getKyufugakugengaku();
    }

    @JsonIgnore
    public RadioButton getRadKyuhugakuGengakuUmu() {
        return this.getJisshitsutekiHutanKeigenshaHigaito().getTblKyufugakugengaku().getKyufugakugengaku().getRadKyuhugakuGengakuUmu();
    }

    @JsonIgnore
    public void  setRadKyuhugakuGengakuUmu(RadioButton radKyuhugakuGengakuUmu) {
        this.getJisshitsutekiHutanKeigenshaHigaito().getTblKyufugakugengaku().getKyufugakugengaku().setRadKyuhugakuGengakuUmu(radKyuhugakuGengakuUmu);
    }

    @JsonIgnore
    public TextBox getTxtKyufugakuGengaku() {
        return this.getJisshitsutekiHutanKeigenshaHigaito().getTblKyufugakugengaku().getKyufugakugengaku().getTxtKyufugakuGengaku();
    }

    @JsonIgnore
    public void  setTxtKyufugakuGengaku(TextBox txtKyufugakuGengaku) {
        this.getJisshitsutekiHutanKeigenshaHigaito().getTblKyufugakugengaku().getKyufugakugengaku().setTxtKyufugakuGengaku(txtKyufugakuGengaku);
    }

    @JsonIgnore
    public KyojuhiDiv getKyojuhi() {
        return this.getJisshitsutekiHutanKeigenshaHigaito().getTblKyufugakugengaku().getKyojuhi();
    }

    @JsonIgnore
    public tblKyojuhiDiv getTblKyojuhi() {
        return this.getJisshitsutekiHutanKeigenshaHigaito().getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi();
    }

    @JsonIgnore
    public void  setTblKyojuhi(tblKyojuhiDiv tblKyojuhi) {
        this.getJisshitsutekiHutanKeigenshaHigaito().getTblKyufugakugengaku().getKyojuhi().setTblKyojuhi(tblKyojuhi);
    }

    @JsonIgnore
    public Label getLblRiyoshafutan() {
        return this.getJisshitsutekiHutanKeigenshaHigaito().getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getLblRiyoshafutan();
    }

    @JsonIgnore
    public Label getLblYunittokoshitsu() {
        return this.getJisshitsutekiHutanKeigenshaHigaito().getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getLblYunittokoshitsu();
    }

    @JsonIgnore
    public Label getLblYunitjunkoshitsu() {
        return this.getJisshitsutekiHutanKeigenshaHigaito().getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getLblYunitjunkoshitsu();
    }

    @JsonIgnore
    public Label getLblJuraikoshitsu() {
        return this.getJisshitsutekiHutanKeigenshaHigaito().getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getLblJuraikoshitsu();
    }

    @JsonIgnore
    public Label getLblTasho() {
        return this.getJisshitsutekiHutanKeigenshaHigaito().getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getLblTasho();
    }

    @JsonIgnore
    public Label getLblTokuyo() {
        return this.getJisshitsutekiHutanKeigenshaHigaito().getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getLblTokuyo();
    }

    @JsonIgnore
    public Label getLblRokenryoyo() {
        return this.getJisshitsutekiHutanKeigenshaHigaito().getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getLblRokenryoyo();
    }

    @JsonIgnore
    public Label getLblDaiichidankai() {
        return this.getJisshitsutekiHutanKeigenshaHigaito().getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getLblDaiichidankai();
    }

    @JsonIgnore
    public TextBox getTxtDaiichiKoshitsu() {
        return this.getJisshitsutekiHutanKeigenshaHigaito().getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getTxtDaiichiKoshitsu();
    }

    @JsonIgnore
    public TextBox getTxtDaiichiJunKoshitsu() {
        return this.getJisshitsutekiHutanKeigenshaHigaito().getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getTxtDaiichiJunKoshitsu();
    }

    @JsonIgnore
    public TextBox getTxtDaiichiTokuyo() {
        return this.getJisshitsutekiHutanKeigenshaHigaito().getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getTxtDaiichiTokuyo();
    }

    @JsonIgnore
    public TextBox getTxtDaiichiRokenRyoyogata() {
        return this.getJisshitsutekiHutanKeigenshaHigaito().getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getTxtDaiichiRokenRyoyogata();
    }

    @JsonIgnore
    public TextBox getTxtDaiichiTashoshitsu() {
        return this.getJisshitsutekiHutanKeigenshaHigaito().getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getTxtDaiichiTashoshitsu();
    }

    @JsonIgnore
    public Label getLblDainidankai() {
        return this.getJisshitsutekiHutanKeigenshaHigaito().getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getLblDainidankai();
    }

    @JsonIgnore
    public TextBox getTxtDainiKoshitsu() {
        return this.getJisshitsutekiHutanKeigenshaHigaito().getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getTxtDainiKoshitsu();
    }

    @JsonIgnore
    public TextBox getTxtDainiJunKoshitsu() {
        return this.getJisshitsutekiHutanKeigenshaHigaito().getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getTxtDainiJunKoshitsu();
    }

    @JsonIgnore
    public TextBox getTxtDainiTokuyo() {
        return this.getJisshitsutekiHutanKeigenshaHigaito().getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getTxtDainiTokuyo();
    }

    @JsonIgnore
    public TextBox getTxtDainiRokenRyoyogata() {
        return this.getJisshitsutekiHutanKeigenshaHigaito().getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getTxtDainiRokenRyoyogata();
    }

    @JsonIgnore
    public TextBox getTxtDainiTashoshitsu() {
        return this.getJisshitsutekiHutanKeigenshaHigaito().getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getTxtDainiTashoshitsu();
    }

    @JsonIgnore
    public Label getLblDaisandankai() {
        return this.getJisshitsutekiHutanKeigenshaHigaito().getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getLblDaisandankai();
    }

    @JsonIgnore
    public TextBox getTxtDaisanKoshitsu() {
        return this.getJisshitsutekiHutanKeigenshaHigaito().getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getTxtDaisanKoshitsu();
    }

    @JsonIgnore
    public TextBox getTxtDaisanJunKoshitsu() {
        return this.getJisshitsutekiHutanKeigenshaHigaito().getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getTxtDaisanJunKoshitsu();
    }

    @JsonIgnore
    public TextBox getTxtDaisanTokuyo() {
        return this.getJisshitsutekiHutanKeigenshaHigaito().getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getTxtDaisanTokuyo();
    }

    @JsonIgnore
    public TextBox getTxtDaisanRokenRyoyogata() {
        return this.getJisshitsutekiHutanKeigenshaHigaito().getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getTxtDaisanRokenRyoyogata();
    }

    @JsonIgnore
    public TextBox getTxtDaisanTashoshitsu() {
        return this.getJisshitsutekiHutanKeigenshaHigaito().getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getTxtDaisanTashoshitsu();
    }

    @JsonIgnore
    public Label getLblKijunhiyoGaku() {
        return this.getJisshitsutekiHutanKeigenshaHigaito().getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getLblKijunhiyoGaku();
    }

    @JsonIgnore
    public TextBox getTxtKijunHiyogakuKoshitsu() {
        return this.getJisshitsutekiHutanKeigenshaHigaito().getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getTxtKijunHiyogakuKoshitsu();
    }

    @JsonIgnore
    public TextBox getTxtKijunHiyogakuJunKoshitsu() {
        return this.getJisshitsutekiHutanKeigenshaHigaito().getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getTxtKijunHiyogakuJunKoshitsu();
    }

    @JsonIgnore
    public TextBox getTxtKijunHiyogakuTokuyo() {
        return this.getJisshitsutekiHutanKeigenshaHigaito().getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getTxtKijunHiyogakuTokuyo();
    }

    @JsonIgnore
    public TextBox getTxtKijunHiyogakuRokenRyoyogata() {
        return this.getJisshitsutekiHutanKeigenshaHigaito().getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getTxtKijunHiyogakuRokenRyoyogata();
    }

    @JsonIgnore
    public TextBox getTxtKijunHiyogakuTashoshitsu() {
        return this.getJisshitsutekiHutanKeigenshaHigaito().getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getTxtKijunHiyogakuTashoshitsu();
    }

    @JsonIgnore
    public Label getLblDaiyondankai() {
        return this.getJisshitsutekiHutanKeigenshaHigaito().getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getLblDaiyondankai();
    }

    @JsonIgnore
    public Label getLblFutanGengakuNashi() {
        return this.getJisshitsutekiHutanKeigenshaHigaito().getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getLblFutanGengakuNashi();
    }

    @JsonIgnore
    public KaigoHokenryoIchiranDiv getKaigoHokenryoIchiran() {
        return this.getJisshitsutekiHutanKeigenshaHigaito().getTblKyufugakugengaku().getKaigoHokenryoIchiran();
    }

    @JsonIgnore
    public DataGrid<dgKaigoHokenryo_Row> getDgKaigoHokenryo() {
        return this.getJisshitsutekiHutanKeigenshaHigaito().getTblKyufugakugengaku().getKaigoHokenryoIchiran().getDgKaigoHokenryo();
    }

    @JsonIgnore
    public void  setDgKaigoHokenryo(DataGrid<dgKaigoHokenryo_Row> dgKaigoHokenryo) {
        this.getJisshitsutekiHutanKeigenshaHigaito().getTblKyufugakugengaku().getKaigoHokenryoIchiran().setDgKaigoHokenryo(dgKaigoHokenryo);
    }

    @JsonIgnore
    public ShokuhiFutanDiv getShokuhiFutan() {
        return this.getJisshitsutekiHutanKeigenshaHigaito().getTblKyufugakugengaku().getShokuhiFutan();
    }

    @JsonIgnore
    public RadioButton getRadShokuhiGaku() {
        return this.getJisshitsutekiHutanKeigenshaHigaito().getTblKyufugakugengaku().getShokuhiFutan().getRadShokuhiGaku();
    }

    @JsonIgnore
    public void  setRadShokuhiGaku(RadioButton radShokuhiGaku) {
        this.getJisshitsutekiHutanKeigenshaHigaito().getTblKyufugakugengaku().getShokuhiFutan().setRadShokuhiGaku(radShokuhiGaku);
    }

    @JsonIgnore
    public TextBox getTxtShokuhiGakuOther() {
        return this.getJisshitsutekiHutanKeigenshaHigaito().getTblKyufugakugengaku().getShokuhiFutan().getTxtShokuhiGakuOther();
    }

    @JsonIgnore
    public void  setTxtShokuhiGakuOther(TextBox txtShokuhiGakuOther) {
        this.getJisshitsutekiHutanKeigenshaHigaito().getTblKyufugakugengaku().getShokuhiFutan().setTxtShokuhiGakuOther(txtShokuhiGakuOther);
    }

    @JsonIgnore
    public KogakuKaigoServiceHiDiv getKogakuKaigoServiceHi() {
        return this.getJisshitsutekiHutanKeigenshaHigaito().getTblKyufugakugengaku().getKogakuKaigoServiceHi();
    }

    @JsonIgnore
    public RadioButton getRadKogakuKaigoServiceHi() {
        return this.getJisshitsutekiHutanKeigenshaHigaito().getTblKyufugakugengaku().getKogakuKaigoServiceHi().getRadKogakuKaigoServiceHi();
    }

    @JsonIgnore
    public void  setRadKogakuKaigoServiceHi(RadioButton radKogakuKaigoServiceHi) {
        this.getJisshitsutekiHutanKeigenshaHigaito().getTblKyufugakugengaku().getKogakuKaigoServiceHi().setRadKogakuKaigoServiceHi(radKogakuKaigoServiceHi);
    }

    @JsonIgnore
    public TextBox getTxtKogakuKaigoServiceHiOther() {
        return this.getJisshitsutekiHutanKeigenshaHigaito().getTblKyufugakugengaku().getKogakuKaigoServiceHi().getTxtKogakuKaigoServiceHiOther();
    }

    @JsonIgnore
    public void  setTxtKogakuKaigoServiceHiOther(TextBox txtKogakuKaigoServiceHiOther) {
        this.getJisshitsutekiHutanKeigenshaHigaito().getTblKyufugakugengaku().getKogakuKaigoServiceHi().setTxtKogakuKaigoServiceHiOther(txtKogakuKaigoServiceHiOther);
    }

    @JsonIgnore
    public RenrakuhyoBikoDiv getRenrakuhyoBiko() {
        return this.getJisshitsutekiHutanKeigenshaHigaito().getRenrakuhyoBiko();
    }

    @JsonIgnore
    public void  setRenrakuhyoBiko(RenrakuhyoBikoDiv RenrakuhyoBiko) {
        this.getJisshitsutekiHutanKeigenshaHigaito().setRenrakuhyoBiko(RenrakuhyoBiko);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtRenrakuhyoBiko() {
        return this.getJisshitsutekiHutanKeigenshaHigaito().getRenrakuhyoBiko().getTxtRenrakuhyoBiko();
    }

    @JsonIgnore
    public void  setTxtRenrakuhyoBiko(TextBoxMultiLine txtRenrakuhyoBiko) {
        this.getJisshitsutekiHutanKeigenshaHigaito().getRenrakuhyoBiko().setTxtRenrakuhyoBiko(txtRenrakuhyoBiko);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtRenrakuhyoSakuseiDateGaitosha() {
        return this.getJisshitsutekiHutanKeigenshaGaitosha().getTxtRenrakuhyoSakuseiDateGaitosha();
    }

    @JsonIgnore
    public void  setTxtRenrakuhyoSakuseiDateGaitosha(TextBoxFlexibleDate txtRenrakuhyoSakuseiDateGaitosha) {
        this.getJisshitsutekiHutanKeigenshaGaitosha().setTxtRenrakuhyoSakuseiDateGaitosha(txtRenrakuhyoSakuseiDateGaitosha);
    }

    @JsonIgnore
    public tblKyufugakugengakuGaitoDiv getTblKyufugakugengakuGaito() {
        return this.getJisshitsutekiHutanKeigenshaGaitosha().getTblKyufugakugengakuGaito();
    }

    @JsonIgnore
    public void  setTblKyufugakugengakuGaito(tblKyufugakugengakuGaitoDiv tblKyufugakugengakuGaito) {
        this.getJisshitsutekiHutanKeigenshaGaitosha().setTblKyufugakugengakuGaito(tblKyufugakugengakuGaito);
    }

    @JsonIgnore
    public KyufugakugengakuGaitoshaDiv getKyufugakugengakuGaitosha() {
        return this.getJisshitsutekiHutanKeigenshaGaitosha().getTblKyufugakugengakuGaito().getKyufugakugengakuGaitosha();
    }

    @JsonIgnore
    public RadioButton getRadKyuhugakuGengakuUmuGaitosha() {
        return this.getJisshitsutekiHutanKeigenshaGaitosha().getTblKyufugakugengakuGaito().getKyufugakugengakuGaitosha().getRadKyuhugakuGengakuUmuGaitosha();
    }

    @JsonIgnore
    public void  setRadKyuhugakuGengakuUmuGaitosha(RadioButton radKyuhugakuGengakuUmuGaitosha) {
        this.getJisshitsutekiHutanKeigenshaGaitosha().getTblKyufugakugengakuGaito().getKyufugakugengakuGaitosha().setRadKyuhugakuGengakuUmuGaitosha(radKyuhugakuGengakuUmuGaitosha);
    }

    @JsonIgnore
    public TextBox getTxtKyufugakuGengakuGaitosha() {
        return this.getJisshitsutekiHutanKeigenshaGaitosha().getTblKyufugakugengakuGaito().getKyufugakugengakuGaitosha().getTxtKyufugakuGengakuGaitosha();
    }

    @JsonIgnore
    public void  setTxtKyufugakuGengakuGaitosha(TextBox txtKyufugakuGengakuGaitosha) {
        this.getJisshitsutekiHutanKeigenshaGaitosha().getTblKyufugakugengakuGaito().getKyufugakugengakuGaitosha().setTxtKyufugakuGengakuGaitosha(txtKyufugakuGengakuGaitosha);
    }

    @JsonIgnore
    public KyojuhiGaitoshaDiv getKyojuhiGaitosha() {
        return this.getJisshitsutekiHutanKeigenshaGaitosha().getTblKyufugakugengakuGaito().getKyojuhiGaitosha();
    }

    @JsonIgnore
    public tblKyojuhiGaitoshaDiv getTblKyojuhiGaitosha() {
        return this.getJisshitsutekiHutanKeigenshaGaitosha().getTblKyufugakugengakuGaito().getKyojuhiGaitosha().getTblKyojuhiGaitosha();
    }

    @JsonIgnore
    public void  setTblKyojuhiGaitosha(tblKyojuhiGaitoshaDiv tblKyojuhiGaitosha) {
        this.getJisshitsutekiHutanKeigenshaGaitosha().getTblKyufugakugengakuGaito().getKyojuhiGaitosha().setTblKyojuhiGaitosha(tblKyojuhiGaitosha);
    }

    @JsonIgnore
    public Label getLblYunittokoshitsuGaitosha() {
        return this.getJisshitsutekiHutanKeigenshaGaitosha().getTblKyufugakugengakuGaito().getKyojuhiGaitosha().getTblKyojuhiGaitosha().getLblYunittokoshitsuGaitosha();
    }

    @JsonIgnore
    public Label getLblYunitjunkoshitsuGaitosha() {
        return this.getJisshitsutekiHutanKeigenshaGaitosha().getTblKyufugakugengakuGaito().getKyojuhiGaitosha().getTblKyojuhiGaitosha().getLblYunitjunkoshitsuGaitosha();
    }

    @JsonIgnore
    public Label getLblTokuyoGaitosha() {
        return this.getJisshitsutekiHutanKeigenshaGaitosha().getTblKyufugakugengakuGaito().getKyojuhiGaitosha().getTblKyojuhiGaitosha().getLblTokuyoGaitosha();
    }

    @JsonIgnore
    public Label getLblTashoGaitosha() {
        return this.getJisshitsutekiHutanKeigenshaGaitosha().getTblKyufugakugengakuGaito().getKyojuhiGaitosha().getTblKyojuhiGaitosha().getLblTashoGaitosha();
    }

    @JsonIgnore
    public TextBox getTxtDaiichiKoshitsuGaitosha() {
        return this.getJisshitsutekiHutanKeigenshaGaitosha().getTblKyufugakugengakuGaito().getKyojuhiGaitosha().getTblKyojuhiGaitosha().getTxtDaiichiKoshitsuGaitosha();
    }

    @JsonIgnore
    public TextBox getTxtDaiichiJunKoshitsuGaitosha() {
        return this.getJisshitsutekiHutanKeigenshaGaitosha().getTblKyufugakugengakuGaito().getKyojuhiGaitosha().getTblKyojuhiGaitosha().getTxtDaiichiJunKoshitsuGaitosha();
    }

    @JsonIgnore
    public TextBox getTxtDaiichiTokuyoGaitosha() {
        return this.getJisshitsutekiHutanKeigenshaGaitosha().getTblKyufugakugengakuGaito().getKyojuhiGaitosha().getTblKyojuhiGaitosha().getTxtDaiichiTokuyoGaitosha();
    }

    @JsonIgnore
    public TextBox getTxtDaiichiTashoshitsuGaitosha() {
        return this.getJisshitsutekiHutanKeigenshaGaitosha().getTblKyufugakugengakuGaito().getKyojuhiGaitosha().getTblKyojuhiGaitosha().getTxtDaiichiTashoshitsuGaitosha();
    }

    @JsonIgnore
    public TextBox getTxtDainiKoshitsuGaitosha() {
        return this.getJisshitsutekiHutanKeigenshaGaitosha().getTblKyufugakugengakuGaito().getKyojuhiGaitosha().getTblKyojuhiGaitosha().getTxtDainiKoshitsuGaitosha();
    }

    @JsonIgnore
    public TextBox getTxtDaininoIchiJunKoshitsuGaitosha() {
        return this.getJisshitsutekiHutanKeigenshaGaitosha().getTblKyufugakugengakuGaito().getKyojuhiGaitosha().getTblKyojuhiGaitosha().getTxtDaininoIchiJunKoshitsuGaitosha();
    }

    @JsonIgnore
    public TextBox getTxtDaininoIchiTokuyoGaitosha() {
        return this.getJisshitsutekiHutanKeigenshaGaitosha().getTblKyufugakugengakuGaito().getKyojuhiGaitosha().getTblKyojuhiGaitosha().getTxtDaininoIchiTokuyoGaitosha();
    }

    @JsonIgnore
    public TextBox getTxtDaininoIchiTashoshitsuGaitosha() {
        return this.getJisshitsutekiHutanKeigenshaGaitosha().getTblKyufugakugengakuGaito().getKyojuhiGaitosha().getTblKyojuhiGaitosha().getTxtDaininoIchiTashoshitsuGaitosha();
    }

    @JsonIgnore
    public TextBox getTxtDaisanKoshitsuGaitosha() {
        return this.getJisshitsutekiHutanKeigenshaGaitosha().getTblKyufugakugengakuGaito().getKyojuhiGaitosha().getTblKyojuhiGaitosha().getTxtDaisanKoshitsuGaitosha();
    }

    @JsonIgnore
    public TextBox getTxtDaininoNiJunKoshitsuGaitosha() {
        return this.getJisshitsutekiHutanKeigenshaGaitosha().getTblKyufugakugengakuGaito().getKyojuhiGaitosha().getTblKyojuhiGaitosha().getTxtDaininoNiJunKoshitsuGaitosha();
    }

    @JsonIgnore
    public TextBox getTxtDaininoNiTokuyoGaitosha() {
        return this.getJisshitsutekiHutanKeigenshaGaitosha().getTblKyufugakugengakuGaito().getKyojuhiGaitosha().getTblKyojuhiGaitosha().getTxtDaininoNiTokuyoGaitosha();
    }

    @JsonIgnore
    public TextBox getTxtDaininoNiTashoshitsuGaitosha() {
        return this.getJisshitsutekiHutanKeigenshaGaitosha().getTblKyufugakugengakuGaito().getKyojuhiGaitosha().getTblKyojuhiGaitosha().getTxtDaininoNiTashoshitsuGaitosha();
    }

    @JsonIgnore
    public TextBox getTxtKijunHiyogakuKoshitsuGaitosha() {
        return this.getJisshitsutekiHutanKeigenshaGaitosha().getTblKyufugakugengakuGaito().getKyojuhiGaitosha().getTblKyojuhiGaitosha().getTxtKijunHiyogakuKoshitsuGaitosha();
    }

    @JsonIgnore
    public TextBox getTxtDaisanJunKoshitsuGaitosha() {
        return this.getJisshitsutekiHutanKeigenshaGaitosha().getTblKyufugakugengakuGaito().getKyojuhiGaitosha().getTblKyojuhiGaitosha().getTxtDaisanJunKoshitsuGaitosha();
    }

    @JsonIgnore
    public TextBox getTxtDaininoSanTokuyoGaitosha() {
        return this.getJisshitsutekiHutanKeigenshaGaitosha().getTblKyufugakugengakuGaito().getKyojuhiGaitosha().getTblKyojuhiGaitosha().getTxtDaininoSanTokuyoGaitosha();
    }

    @JsonIgnore
    public TextBox getTxtDaisanTashoshitsuGaitosha() {
        return this.getJisshitsutekiHutanKeigenshaGaitosha().getTblKyufugakugengakuGaito().getKyojuhiGaitosha().getTblKyojuhiGaitosha().getTxtDaisanTashoshitsuGaitosha();
    }

    @JsonIgnore
    public TextBox getTxtKijunHiyogakuJunKoshitsuGaitosha() {
        return this.getJisshitsutekiHutanKeigenshaGaitosha().getTblKyufugakugengakuGaito().getKyojuhiGaitosha().getTblKyojuhiGaitosha().getTxtKijunHiyogakuJunKoshitsuGaitosha();
    }

    @JsonIgnore
    public TextBox getTxtDaisanTokuyoGaitosha() {
        return this.getJisshitsutekiHutanKeigenshaGaitosha().getTblKyufugakugengakuGaito().getKyojuhiGaitosha().getTblKyojuhiGaitosha().getTxtDaisanTokuyoGaitosha();
    }

    @JsonIgnore
    public TextBox getTxtKijunHiyogakuTashoshitsuGaitosha() {
        return this.getJisshitsutekiHutanKeigenshaGaitosha().getTblKyufugakugengakuGaito().getKyojuhiGaitosha().getTblKyojuhiGaitosha().getTxtKijunHiyogakuTashoshitsuGaitosha();
    }

    @JsonIgnore
    public TextBox getTxtKijunHiyogakuTokuyoGaitosha() {
        return this.getJisshitsutekiHutanKeigenshaGaitosha().getTblKyufugakugengakuGaito().getKyojuhiGaitosha().getTblKyojuhiGaitosha().getTxtKijunHiyogakuTokuyoGaitosha();
    }

    @JsonIgnore
    public KaigoHokenryoIchiranGaitoshaDiv getKaigoHokenryoIchiranGaitosha() {
        return this.getJisshitsutekiHutanKeigenshaGaitosha().getTblKyufugakugengakuGaito().getKaigoHokenryoIchiranGaitosha();
    }

    @JsonIgnore
    public DataGrid<dgKaigoHokenryoGaitosha_Row> getDgKaigoHokenryoGaitosha() {
        return this.getJisshitsutekiHutanKeigenshaGaitosha().getTblKyufugakugengakuGaito().getKaigoHokenryoIchiranGaitosha().getDgKaigoHokenryoGaitosha();
    }

    @JsonIgnore
    public void  setDgKaigoHokenryoGaitosha(DataGrid<dgKaigoHokenryoGaitosha_Row> dgKaigoHokenryoGaitosha) {
        this.getJisshitsutekiHutanKeigenshaGaitosha().getTblKyufugakugengakuGaito().getKaigoHokenryoIchiranGaitosha().setDgKaigoHokenryoGaitosha(dgKaigoHokenryoGaitosha);
    }

    @JsonIgnore
    public ShokuhiFutanGaitoshaDiv getShokuhiFutanGaitosha() {
        return this.getJisshitsutekiHutanKeigenshaGaitosha().getTblKyufugakugengakuGaito().getShokuhiFutanGaitosha();
    }

    @JsonIgnore
    public RadioButton getRadShokuhiGakuGaitosha() {
        return this.getJisshitsutekiHutanKeigenshaGaitosha().getTblKyufugakugengakuGaito().getShokuhiFutanGaitosha().getRadShokuhiGakuGaitosha();
    }

    @JsonIgnore
    public void  setRadShokuhiGakuGaitosha(RadioButton radShokuhiGakuGaitosha) {
        this.getJisshitsutekiHutanKeigenshaGaitosha().getTblKyufugakugengakuGaito().getShokuhiFutanGaitosha().setRadShokuhiGakuGaitosha(radShokuhiGakuGaitosha);
    }

    @JsonIgnore
    public TextBox getTxtShokuhiGakuOtherGaitosha() {
        return this.getJisshitsutekiHutanKeigenshaGaitosha().getTblKyufugakugengakuGaito().getShokuhiFutanGaitosha().getTxtShokuhiGakuOtherGaitosha();
    }

    @JsonIgnore
    public void  setTxtShokuhiGakuOtherGaitosha(TextBox txtShokuhiGakuOtherGaitosha) {
        this.getJisshitsutekiHutanKeigenshaGaitosha().getTblKyufugakugengakuGaito().getShokuhiFutanGaitosha().setTxtShokuhiGakuOtherGaitosha(txtShokuhiGakuOtherGaitosha);
    }

    @JsonIgnore
    public KogakuKaigoServiceHiGaitoshaDiv getKogakuKaigoServiceHiGaitosha() {
        return this.getJisshitsutekiHutanKeigenshaGaitosha().getTblKyufugakugengakuGaito().getKogakuKaigoServiceHiGaitosha();
    }

    @JsonIgnore
    public RadioButton getRadKogakuKaigoServiceHiGaitosha() {
        return this.getJisshitsutekiHutanKeigenshaGaitosha().getTblKyufugakugengakuGaito().getKogakuKaigoServiceHiGaitosha().getRadKogakuKaigoServiceHiGaitosha();
    }

    @JsonIgnore
    public void  setRadKogakuKaigoServiceHiGaitosha(RadioButton radKogakuKaigoServiceHiGaitosha) {
        this.getJisshitsutekiHutanKeigenshaGaitosha().getTblKyufugakugengakuGaito().getKogakuKaigoServiceHiGaitosha().setRadKogakuKaigoServiceHiGaitosha(radKogakuKaigoServiceHiGaitosha);
    }

    @JsonIgnore
    public TextBox getTxtKogakuKaigoServiceHiOtherGaitosha() {
        return this.getJisshitsutekiHutanKeigenshaGaitosha().getTblKyufugakugengakuGaito().getKogakuKaigoServiceHiGaitosha().getTxtKogakuKaigoServiceHiOtherGaitosha();
    }

    @JsonIgnore
    public void  setTxtKogakuKaigoServiceHiOtherGaitosha(TextBox txtKogakuKaigoServiceHiOtherGaitosha) {
        this.getJisshitsutekiHutanKeigenshaGaitosha().getTblKyufugakugengakuGaito().getKogakuKaigoServiceHiGaitosha().setTxtKogakuKaigoServiceHiOtherGaitosha(txtKogakuKaigoServiceHiOtherGaitosha);
    }

    @JsonIgnore
    public RenrakuhyoBikoGaitoshaDiv getRenrakuhyoBikoGaitosha() {
        return this.getJisshitsutekiHutanKeigenshaGaitosha().getRenrakuhyoBikoGaitosha();
    }

    @JsonIgnore
    public void  setRenrakuhyoBikoGaitosha(RenrakuhyoBikoGaitoshaDiv RenrakuhyoBikoGaitosha) {
        this.getJisshitsutekiHutanKeigenshaGaitosha().setRenrakuhyoBikoGaitosha(RenrakuhyoBikoGaitosha);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtRenrakuhyoBikoGaitosha() {
        return this.getJisshitsutekiHutanKeigenshaGaitosha().getRenrakuhyoBikoGaitosha().getTxtRenrakuhyoBikoGaitosha();
    }

    @JsonIgnore
    public void  setTxtRenrakuhyoBikoGaitosha(TextBoxMultiLine txtRenrakuhyoBikoGaitosha) {
        this.getJisshitsutekiHutanKeigenshaGaitosha().getRenrakuhyoBikoGaitosha().setTxtRenrakuhyoBikoGaitosha(txtRenrakuhyoBikoGaitosha);
    }

    // </editor-fold>
}
