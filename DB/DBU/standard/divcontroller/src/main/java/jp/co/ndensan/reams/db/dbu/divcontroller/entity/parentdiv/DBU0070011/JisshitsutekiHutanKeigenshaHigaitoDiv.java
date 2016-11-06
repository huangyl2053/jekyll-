package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0070011;
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
 * JisshitsutekiHutanKeigenshaHigaito のクラスファイル 
 * 
 * @author 自動生成
 */
public class JisshitsutekiHutanKeigenshaHigaitoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-07_19-12-57">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtRenrakuhyoSakuseiDate")
    private TextBoxFlexibleDate txtRenrakuhyoSakuseiDate;
    @JsonProperty("tblKyufugakugengaku")
    private tblKyufugakugengakuDiv tblKyufugakugengaku;
    @JsonProperty("RenrakuhyoBiko")
    private RenrakuhyoBikoDiv RenrakuhyoBiko;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtRenrakuhyoSakuseiDate
     * @return txtRenrakuhyoSakuseiDate
     */
    @JsonProperty("txtRenrakuhyoSakuseiDate")
    public TextBoxFlexibleDate getTxtRenrakuhyoSakuseiDate() {
        return txtRenrakuhyoSakuseiDate;
    }

    /*
     * settxtRenrakuhyoSakuseiDate
     * @param txtRenrakuhyoSakuseiDate txtRenrakuhyoSakuseiDate
     */
    @JsonProperty("txtRenrakuhyoSakuseiDate")
    public void setTxtRenrakuhyoSakuseiDate(TextBoxFlexibleDate txtRenrakuhyoSakuseiDate) {
        this.txtRenrakuhyoSakuseiDate = txtRenrakuhyoSakuseiDate;
    }

    /*
     * gettblKyufugakugengaku
     * @return tblKyufugakugengaku
     */
    @JsonProperty("tblKyufugakugengaku")
    public tblKyufugakugengakuDiv getTblKyufugakugengaku() {
        return tblKyufugakugengaku;
    }

    /*
     * settblKyufugakugengaku
     * @param tblKyufugakugengaku tblKyufugakugengaku
     */
    @JsonProperty("tblKyufugakugengaku")
    public void setTblKyufugakugengaku(tblKyufugakugengakuDiv tblKyufugakugengaku) {
        this.tblKyufugakugengaku = tblKyufugakugengaku;
    }

    /*
     * getRenrakuhyoBiko
     * @return RenrakuhyoBiko
     */
    @JsonProperty("RenrakuhyoBiko")
    public RenrakuhyoBikoDiv getRenrakuhyoBiko() {
        return RenrakuhyoBiko;
    }

    /*
     * setRenrakuhyoBiko
     * @param RenrakuhyoBiko RenrakuhyoBiko
     */
    @JsonProperty("RenrakuhyoBiko")
    public void setRenrakuhyoBiko(RenrakuhyoBikoDiv RenrakuhyoBiko) {
        this.RenrakuhyoBiko = RenrakuhyoBiko;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public KyufugakugengakuDiv getKyufugakugengaku() {
        return this.getTblKyufugakugengaku().getKyufugakugengaku();
    }

    @JsonIgnore
    public RadioButton getRadKyuhugakuGengakuUmu() {
        return this.getTblKyufugakugengaku().getKyufugakugengaku().getRadKyuhugakuGengakuUmu();
    }

    @JsonIgnore
    public void  setRadKyuhugakuGengakuUmu(RadioButton radKyuhugakuGengakuUmu) {
        this.getTblKyufugakugengaku().getKyufugakugengaku().setRadKyuhugakuGengakuUmu(radKyuhugakuGengakuUmu);
    }

    @JsonIgnore
    public TextBox getTxtKyufugakuGengaku() {
        return this.getTblKyufugakugengaku().getKyufugakugengaku().getTxtKyufugakuGengaku();
    }

    @JsonIgnore
    public void  setTxtKyufugakuGengaku(TextBox txtKyufugakuGengaku) {
        this.getTblKyufugakugengaku().getKyufugakugengaku().setTxtKyufugakuGengaku(txtKyufugakuGengaku);
    }

    @JsonIgnore
    public KyojuhiDiv getKyojuhi() {
        return this.getTblKyufugakugengaku().getKyojuhi();
    }

    @JsonIgnore
    public tblKyojuhiDiv getTblKyojuhi() {
        return this.getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi();
    }

    @JsonIgnore
    public void  setTblKyojuhi(tblKyojuhiDiv tblKyojuhi) {
        this.getTblKyufugakugengaku().getKyojuhi().setTblKyojuhi(tblKyojuhi);
    }

    @JsonIgnore
    public Label getLblRiyoshafutan() {
        return this.getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getLblRiyoshafutan();
    }

    @JsonIgnore
    public Label getLblYunittokoshitsu() {
        return this.getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getLblYunittokoshitsu();
    }

    @JsonIgnore
    public Label getLblYunitjunkoshitsu() {
        return this.getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getLblYunitjunkoshitsu();
    }

    @JsonIgnore
    public Label getLblJuraikoshitsu() {
        return this.getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getLblJuraikoshitsu();
    }

    @JsonIgnore
    public Label getLblTasho() {
        return this.getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getLblTasho();
    }

    @JsonIgnore
    public Label getLblTokuyo() {
        return this.getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getLblTokuyo();
    }

    @JsonIgnore
    public Label getLblRokenryoyo() {
        return this.getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getLblRokenryoyo();
    }

    @JsonIgnore
    public Label getLblDaiichidankai() {
        return this.getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getLblDaiichidankai();
    }

    @JsonIgnore
    public Icon getIcoDaiichiKoshitsu() {
        return this.getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getIcoDaiichiKoshitsu();
    }

    @JsonIgnore
    public TextBox getTxtDaiichiKoshitsu() {
        return this.getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getTxtDaiichiKoshitsu();
    }

    @JsonIgnore
    public Icon getIcoDaiichiJunKoshitsu() {
        return this.getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getIcoDaiichiJunKoshitsu();
    }

    @JsonIgnore
    public TextBox getTxtDaiichiJunKoshitsu() {
        return this.getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getTxtDaiichiJunKoshitsu();
    }

    @JsonIgnore
    public Icon getIcoDaiichiTokuyo() {
        return this.getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getIcoDaiichiTokuyo();
    }

    @JsonIgnore
    public TextBox getTxtDaiichiTokuyo() {
        return this.getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getTxtDaiichiTokuyo();
    }

    @JsonIgnore
    public Icon getIcoDaiichiRokenRyoyogata() {
        return this.getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getIcoDaiichiRokenRyoyogata();
    }

    @JsonIgnore
    public TextBox getTxtDaiichiRokenRyoyogata() {
        return this.getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getTxtDaiichiRokenRyoyogata();
    }

    @JsonIgnore
    public Icon getIcoDaiichiTashoshitsu() {
        return this.getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getIcoDaiichiTashoshitsu();
    }

    @JsonIgnore
    public TextBox getTxtDaiichiTashoshitsu() {
        return this.getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getTxtDaiichiTashoshitsu();
    }

    @JsonIgnore
    public Label getLblDainidankai() {
        return this.getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getLblDainidankai();
    }

    @JsonIgnore
    public Icon getIcoDainiKoshitsu() {
        return this.getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getIcoDainiKoshitsu();
    }

    @JsonIgnore
    public TextBox getTxtDainiKoshitsu() {
        return this.getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getTxtDainiKoshitsu();
    }

    @JsonIgnore
    public Icon getIcoDainiJunKoshitsu() {
        return this.getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getIcoDainiJunKoshitsu();
    }

    @JsonIgnore
    public TextBox getTxtDainiJunKoshitsu() {
        return this.getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getTxtDainiJunKoshitsu();
    }

    @JsonIgnore
    public Icon getIcoDainiTokuyo() {
        return this.getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getIcoDainiTokuyo();
    }

    @JsonIgnore
    public TextBox getTxtDainiTokuyo() {
        return this.getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getTxtDainiTokuyo();
    }

    @JsonIgnore
    public Icon getIcoDainiRokenRyoyogata() {
        return this.getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getIcoDainiRokenRyoyogata();
    }

    @JsonIgnore
    public TextBox getTxtDainiRokenRyoyogata() {
        return this.getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getTxtDainiRokenRyoyogata();
    }

    @JsonIgnore
    public Icon getIcoDainiTashoshitsu() {
        return this.getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getIcoDainiTashoshitsu();
    }

    @JsonIgnore
    public TextBox getTxtDainiTashoshitsu() {
        return this.getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getTxtDainiTashoshitsu();
    }

    @JsonIgnore
    public Label getLblDaisandankai() {
        return this.getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getLblDaisandankai();
    }

    @JsonIgnore
    public Icon getIcoDaisanKoshitsu() {
        return this.getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getIcoDaisanKoshitsu();
    }

    @JsonIgnore
    public TextBox getTxtDaisanKoshitsu() {
        return this.getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getTxtDaisanKoshitsu();
    }

    @JsonIgnore
    public Icon getIcoDaisanJunKoshitsu() {
        return this.getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getIcoDaisanJunKoshitsu();
    }

    @JsonIgnore
    public TextBox getTxtDaisanJunKoshitsu() {
        return this.getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getTxtDaisanJunKoshitsu();
    }

    @JsonIgnore
    public Icon getIcoDaisanTokuyo() {
        return this.getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getIcoDaisanTokuyo();
    }

    @JsonIgnore
    public TextBox getTxtDaisanTokuyo() {
        return this.getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getTxtDaisanTokuyo();
    }

    @JsonIgnore
    public Icon getIcoDaisanRokenRyoyogata() {
        return this.getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getIcoDaisanRokenRyoyogata();
    }

    @JsonIgnore
    public TextBox getTxtDaisanRokenRyoyogata() {
        return this.getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getTxtDaisanRokenRyoyogata();
    }

    @JsonIgnore
    public Icon getIcoDaisanTashoshitsu() {
        return this.getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getIcoDaisanTashoshitsu();
    }

    @JsonIgnore
    public TextBox getTxtDaisanTashoshitsu() {
        return this.getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getTxtDaisanTashoshitsu();
    }

    @JsonIgnore
    public Label getLblKijunhiyoGaku() {
        return this.getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getLblKijunhiyoGaku();
    }

    @JsonIgnore
    public Icon getIcoKijunHiyogakuKoshitsu() {
        return this.getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getIcoKijunHiyogakuKoshitsu();
    }

    @JsonIgnore
    public TextBox getTxtKijunHiyogakuKoshitsu() {
        return this.getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getTxtKijunHiyogakuKoshitsu();
    }

    @JsonIgnore
    public Icon getIcoKijunHiyogakuJunKoshitsu() {
        return this.getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getIcoKijunHiyogakuJunKoshitsu();
    }

    @JsonIgnore
    public TextBox getTxtKijunHiyogakuJunKoshitsu() {
        return this.getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getTxtKijunHiyogakuJunKoshitsu();
    }

    @JsonIgnore
    public Icon getIcoKijunHiyogakuTokuyo() {
        return this.getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getIcoKijunHiyogakuTokuyo();
    }

    @JsonIgnore
    public TextBox getTxtKijunHiyogakuTokuyo() {
        return this.getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getTxtKijunHiyogakuTokuyo();
    }

    @JsonIgnore
    public Icon getIcoKijunHiyogakuRokenRyoyogata() {
        return this.getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getIcoKijunHiyogakuRokenRyoyogata();
    }

    @JsonIgnore
    public TextBox getTxtKijunHiyogakuRokenRyoyogata() {
        return this.getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getTxtKijunHiyogakuRokenRyoyogata();
    }

    @JsonIgnore
    public Icon getIcoKijunHiyogakuTashoshitsu() {
        return this.getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getIcoKijunHiyogakuTashoshitsu();
    }

    @JsonIgnore
    public TextBox getTxtKijunHiyogakuTashoshitsu() {
        return this.getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getTxtKijunHiyogakuTashoshitsu();
    }

    @JsonIgnore
    public Label getLblDaiyondankai() {
        return this.getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getLblDaiyondankai();
    }

    @JsonIgnore
    public Label getLblFutanGengakuNashi() {
        return this.getTblKyufugakugengaku().getKyojuhi().getTblKyojuhi().getLblFutanGengakuNashi();
    }

    @JsonIgnore
    public KaigoHokenryoIchiranDiv getKaigoHokenryoIchiran() {
        return this.getTblKyufugakugengaku().getKaigoHokenryoIchiran();
    }

    @JsonIgnore
    public DataGrid<dgKaigoHokenryo_Row> getDgKaigoHokenryo() {
        return this.getTblKyufugakugengaku().getKaigoHokenryoIchiran().getDgKaigoHokenryo();
    }

    @JsonIgnore
    public void  setDgKaigoHokenryo(DataGrid<dgKaigoHokenryo_Row> dgKaigoHokenryo) {
        this.getTblKyufugakugengaku().getKaigoHokenryoIchiran().setDgKaigoHokenryo(dgKaigoHokenryo);
    }

    @JsonIgnore
    public ShokuhiFutanDiv getShokuhiFutan() {
        return this.getTblKyufugakugengaku().getShokuhiFutan();
    }

    @JsonIgnore
    public RadioButton getRadShokuhiGaku() {
        return this.getTblKyufugakugengaku().getShokuhiFutan().getRadShokuhiGaku();
    }

    @JsonIgnore
    public void  setRadShokuhiGaku(RadioButton radShokuhiGaku) {
        this.getTblKyufugakugengaku().getShokuhiFutan().setRadShokuhiGaku(radShokuhiGaku);
    }

    @JsonIgnore
    public TextBox getTxtShokuhiGakuOther() {
        return this.getTblKyufugakugengaku().getShokuhiFutan().getTxtShokuhiGakuOther();
    }

    @JsonIgnore
    public void  setTxtShokuhiGakuOther(TextBox txtShokuhiGakuOther) {
        this.getTblKyufugakugengaku().getShokuhiFutan().setTxtShokuhiGakuOther(txtShokuhiGakuOther);
    }

    @JsonIgnore
    public KogakuKaigoServiceHiDiv getKogakuKaigoServiceHi() {
        return this.getTblKyufugakugengaku().getKogakuKaigoServiceHi();
    }

    @JsonIgnore
    public RadioButton getRadKogakuKaigoServiceHi() {
        return this.getTblKyufugakugengaku().getKogakuKaigoServiceHi().getRadKogakuKaigoServiceHi();
    }

    @JsonIgnore
    public void  setRadKogakuKaigoServiceHi(RadioButton radKogakuKaigoServiceHi) {
        this.getTblKyufugakugengaku().getKogakuKaigoServiceHi().setRadKogakuKaigoServiceHi(radKogakuKaigoServiceHi);
    }

    @JsonIgnore
    public TextBox getTxtKogakuKaigoServiceHiOther() {
        return this.getTblKyufugakugengaku().getKogakuKaigoServiceHi().getTxtKogakuKaigoServiceHiOther();
    }

    @JsonIgnore
    public void  setTxtKogakuKaigoServiceHiOther(TextBox txtKogakuKaigoServiceHiOther) {
        this.getTblKyufugakugengaku().getKogakuKaigoServiceHi().setTxtKogakuKaigoServiceHiOther(txtKogakuKaigoServiceHiOther);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtRenrakuhyoBiko() {
        return this.getRenrakuhyoBiko().getTxtRenrakuhyoBiko();
    }

    @JsonIgnore
    public void  setTxtRenrakuhyoBiko(TextBoxMultiLine txtRenrakuhyoBiko) {
        this.getRenrakuhyoBiko().setTxtRenrakuhyoBiko(txtRenrakuhyoBiko);
    }

    // </editor-fold>
}
