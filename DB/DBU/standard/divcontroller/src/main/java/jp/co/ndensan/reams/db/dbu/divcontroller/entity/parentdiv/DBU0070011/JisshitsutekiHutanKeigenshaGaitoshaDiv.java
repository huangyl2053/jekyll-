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
 * JisshitsutekiHutanKeigenshaGaitosha のクラスファイル 
 * 
 * @author 自動生成
 */
public class JisshitsutekiHutanKeigenshaGaitoshaDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtRenrakuhyoSakuseiDateGaitosha")
    private TextBoxFlexibleDate txtRenrakuhyoSakuseiDateGaitosha;
    @JsonProperty("tblKyufugakugengakuGaito")
    private tblKyufugakugengakuGaitoDiv tblKyufugakugengakuGaito;
    @JsonProperty("RenrakuhyoBikoGaitosha")
    private RenrakuhyoBikoGaitoshaDiv RenrakuhyoBikoGaitosha;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtRenrakuhyoSakuseiDateGaitosha
     * @return txtRenrakuhyoSakuseiDateGaitosha
     */
    @JsonProperty("txtRenrakuhyoSakuseiDateGaitosha")
    public TextBoxFlexibleDate getTxtRenrakuhyoSakuseiDateGaitosha() {
        return txtRenrakuhyoSakuseiDateGaitosha;
    }

    /*
     * settxtRenrakuhyoSakuseiDateGaitosha
     * @param txtRenrakuhyoSakuseiDateGaitosha txtRenrakuhyoSakuseiDateGaitosha
     */
    @JsonProperty("txtRenrakuhyoSakuseiDateGaitosha")
    public void setTxtRenrakuhyoSakuseiDateGaitosha(TextBoxFlexibleDate txtRenrakuhyoSakuseiDateGaitosha) {
        this.txtRenrakuhyoSakuseiDateGaitosha = txtRenrakuhyoSakuseiDateGaitosha;
    }

    /*
     * gettblKyufugakugengakuGaito
     * @return tblKyufugakugengakuGaito
     */
    @JsonProperty("tblKyufugakugengakuGaito")
    public tblKyufugakugengakuGaitoDiv getTblKyufugakugengakuGaito() {
        return tblKyufugakugengakuGaito;
    }

    /*
     * settblKyufugakugengakuGaito
     * @param tblKyufugakugengakuGaito tblKyufugakugengakuGaito
     */
    @JsonProperty("tblKyufugakugengakuGaito")
    public void setTblKyufugakugengakuGaito(tblKyufugakugengakuGaitoDiv tblKyufugakugengakuGaito) {
        this.tblKyufugakugengakuGaito = tblKyufugakugengakuGaito;
    }

    /*
     * getRenrakuhyoBikoGaitosha
     * @return RenrakuhyoBikoGaitosha
     */
    @JsonProperty("RenrakuhyoBikoGaitosha")
    public RenrakuhyoBikoGaitoshaDiv getRenrakuhyoBikoGaitosha() {
        return RenrakuhyoBikoGaitosha;
    }

    /*
     * setRenrakuhyoBikoGaitosha
     * @param RenrakuhyoBikoGaitosha RenrakuhyoBikoGaitosha
     */
    @JsonProperty("RenrakuhyoBikoGaitosha")
    public void setRenrakuhyoBikoGaitosha(RenrakuhyoBikoGaitoshaDiv RenrakuhyoBikoGaitosha) {
        this.RenrakuhyoBikoGaitosha = RenrakuhyoBikoGaitosha;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public KyufugakugengakuGaitoshaDiv getKyufugakugengakuGaitosha() {
        return this.getTblKyufugakugengakuGaito().getKyufugakugengakuGaitosha();
    }

    @JsonIgnore
    public RadioButton getRadKyuhugakuGengakuUmuGaitosha() {
        return this.getTblKyufugakugengakuGaito().getKyufugakugengakuGaitosha().getRadKyuhugakuGengakuUmuGaitosha();
    }

    @JsonIgnore
    public void  setRadKyuhugakuGengakuUmuGaitosha(RadioButton radKyuhugakuGengakuUmuGaitosha) {
        this.getTblKyufugakugengakuGaito().getKyufugakugengakuGaitosha().setRadKyuhugakuGengakuUmuGaitosha(radKyuhugakuGengakuUmuGaitosha);
    }

    @JsonIgnore
    public TextBox getTxtKyufugakuGengakuGaitosha() {
        return this.getTblKyufugakugengakuGaito().getKyufugakugengakuGaitosha().getTxtKyufugakuGengakuGaitosha();
    }

    @JsonIgnore
    public void  setTxtKyufugakuGengakuGaitosha(TextBox txtKyufugakuGengakuGaitosha) {
        this.getTblKyufugakugengakuGaito().getKyufugakugengakuGaitosha().setTxtKyufugakuGengakuGaitosha(txtKyufugakuGengakuGaitosha);
    }

    @JsonIgnore
    public KyojuhiGaitoshaDiv getKyojuhiGaitosha() {
        return this.getTblKyufugakugengakuGaito().getKyojuhiGaitosha();
    }

    @JsonIgnore
    public tblKyojuhiGaitoshaDiv getTblKyojuhiGaitosha() {
        return this.getTblKyufugakugengakuGaito().getKyojuhiGaitosha().getTblKyojuhiGaitosha();
    }

    @JsonIgnore
    public void  setTblKyojuhiGaitosha(tblKyojuhiGaitoshaDiv tblKyojuhiGaitosha) {
        this.getTblKyufugakugengakuGaito().getKyojuhiGaitosha().setTblKyojuhiGaitosha(tblKyojuhiGaitosha);
    }

    @JsonIgnore
    public Label getLblYunittokoshitsuGaitosha() {
        return this.getTblKyufugakugengakuGaito().getKyojuhiGaitosha().getTblKyojuhiGaitosha().getLblYunittokoshitsuGaitosha();
    }

    @JsonIgnore
    public Label getLblYunitjunkoshitsuGaitosha() {
        return this.getTblKyufugakugengakuGaito().getKyojuhiGaitosha().getTblKyojuhiGaitosha().getLblYunitjunkoshitsuGaitosha();
    }

    @JsonIgnore
    public Label getLblTokuyoGaitosha() {
        return this.getTblKyufugakugengakuGaito().getKyojuhiGaitosha().getTblKyojuhiGaitosha().getLblTokuyoGaitosha();
    }

    @JsonIgnore
    public Label getLblTashoGaitosha() {
        return this.getTblKyufugakugengakuGaito().getKyojuhiGaitosha().getTblKyojuhiGaitosha().getLblTashoGaitosha();
    }

    @JsonIgnore
    public TextBox getTxtDaiichiKoshitsuGaitosha() {
        return this.getTblKyufugakugengakuGaito().getKyojuhiGaitosha().getTblKyojuhiGaitosha().getTxtDaiichiKoshitsuGaitosha();
    }

    @JsonIgnore
    public TextBox getTxtDaiichiJunKoshitsuGaitosha() {
        return this.getTblKyufugakugengakuGaito().getKyojuhiGaitosha().getTblKyojuhiGaitosha().getTxtDaiichiJunKoshitsuGaitosha();
    }

    @JsonIgnore
    public TextBox getTxtDaiichiTokuyoGaitosha() {
        return this.getTblKyufugakugengakuGaito().getKyojuhiGaitosha().getTblKyojuhiGaitosha().getTxtDaiichiTokuyoGaitosha();
    }

    @JsonIgnore
    public TextBox getTxtDaiichiTashoshitsuGaitosha() {
        return this.getTblKyufugakugengakuGaito().getKyojuhiGaitosha().getTblKyojuhiGaitosha().getTxtDaiichiTashoshitsuGaitosha();
    }

    @JsonIgnore
    public TextBox getTxtDainiKoshitsuGaitosha() {
        return this.getTblKyufugakugengakuGaito().getKyojuhiGaitosha().getTblKyojuhiGaitosha().getTxtDainiKoshitsuGaitosha();
    }

    @JsonIgnore
    public TextBox getTxtDaininoIchiJunKoshitsuGaitosha() {
        return this.getTblKyufugakugengakuGaito().getKyojuhiGaitosha().getTblKyojuhiGaitosha().getTxtDaininoIchiJunKoshitsuGaitosha();
    }

    @JsonIgnore
    public TextBox getTxtDaininoIchiTokuyoGaitosha() {
        return this.getTblKyufugakugengakuGaito().getKyojuhiGaitosha().getTblKyojuhiGaitosha().getTxtDaininoIchiTokuyoGaitosha();
    }

    @JsonIgnore
    public TextBox getTxtDaininoIchiTashoshitsuGaitosha() {
        return this.getTblKyufugakugengakuGaito().getKyojuhiGaitosha().getTblKyojuhiGaitosha().getTxtDaininoIchiTashoshitsuGaitosha();
    }

    @JsonIgnore
    public TextBox getTxtDaisanKoshitsuGaitosha() {
        return this.getTblKyufugakugengakuGaito().getKyojuhiGaitosha().getTblKyojuhiGaitosha().getTxtDaisanKoshitsuGaitosha();
    }

    @JsonIgnore
    public TextBox getTxtDaininoNiJunKoshitsuGaitosha() {
        return this.getTblKyufugakugengakuGaito().getKyojuhiGaitosha().getTblKyojuhiGaitosha().getTxtDaininoNiJunKoshitsuGaitosha();
    }

    @JsonIgnore
    public TextBox getTxtDaininoNiTokuyoGaitosha() {
        return this.getTblKyufugakugengakuGaito().getKyojuhiGaitosha().getTblKyojuhiGaitosha().getTxtDaininoNiTokuyoGaitosha();
    }

    @JsonIgnore
    public TextBox getTxtDaininoNiTashoshitsuGaitosha() {
        return this.getTblKyufugakugengakuGaito().getKyojuhiGaitosha().getTblKyojuhiGaitosha().getTxtDaininoNiTashoshitsuGaitosha();
    }

    @JsonIgnore
    public TextBox getTxtKijunHiyogakuKoshitsuGaitosha() {
        return this.getTblKyufugakugengakuGaito().getKyojuhiGaitosha().getTblKyojuhiGaitosha().getTxtKijunHiyogakuKoshitsuGaitosha();
    }

    @JsonIgnore
    public TextBox getTxtDaisanJunKoshitsuGaitosha() {
        return this.getTblKyufugakugengakuGaito().getKyojuhiGaitosha().getTblKyojuhiGaitosha().getTxtDaisanJunKoshitsuGaitosha();
    }

    @JsonIgnore
    public TextBox getTxtDaininoSanTokuyoGaitosha() {
        return this.getTblKyufugakugengakuGaito().getKyojuhiGaitosha().getTblKyojuhiGaitosha().getTxtDaininoSanTokuyoGaitosha();
    }

    @JsonIgnore
    public TextBox getTxtDaisanTashoshitsuGaitosha() {
        return this.getTblKyufugakugengakuGaito().getKyojuhiGaitosha().getTblKyojuhiGaitosha().getTxtDaisanTashoshitsuGaitosha();
    }

    @JsonIgnore
    public TextBox getTxtKijunHiyogakuJunKoshitsuGaitosha() {
        return this.getTblKyufugakugengakuGaito().getKyojuhiGaitosha().getTblKyojuhiGaitosha().getTxtKijunHiyogakuJunKoshitsuGaitosha();
    }

    @JsonIgnore
    public TextBox getTxtDaisanTokuyoGaitosha() {
        return this.getTblKyufugakugengakuGaito().getKyojuhiGaitosha().getTblKyojuhiGaitosha().getTxtDaisanTokuyoGaitosha();
    }

    @JsonIgnore
    public TextBox getTxtKijunHiyogakuTashoshitsuGaitosha() {
        return this.getTblKyufugakugengakuGaito().getKyojuhiGaitosha().getTblKyojuhiGaitosha().getTxtKijunHiyogakuTashoshitsuGaitosha();
    }

    @JsonIgnore
    public TextBox getTxtKijunHiyogakuTokuyoGaitosha() {
        return this.getTblKyufugakugengakuGaito().getKyojuhiGaitosha().getTblKyojuhiGaitosha().getTxtKijunHiyogakuTokuyoGaitosha();
    }

    @JsonIgnore
    public KaigoHokenryoIchiranGaitoshaDiv getKaigoHokenryoIchiranGaitosha() {
        return this.getTblKyufugakugengakuGaito().getKaigoHokenryoIchiranGaitosha();
    }

    @JsonIgnore
    public DataGrid<dgKaigoHokenryoGaitosha_Row> getDgKaigoHokenryoGaitosha() {
        return this.getTblKyufugakugengakuGaito().getKaigoHokenryoIchiranGaitosha().getDgKaigoHokenryoGaitosha();
    }

    @JsonIgnore
    public void  setDgKaigoHokenryoGaitosha(DataGrid<dgKaigoHokenryoGaitosha_Row> dgKaigoHokenryoGaitosha) {
        this.getTblKyufugakugengakuGaito().getKaigoHokenryoIchiranGaitosha().setDgKaigoHokenryoGaitosha(dgKaigoHokenryoGaitosha);
    }

    @JsonIgnore
    public ShokuhiFutanGaitoshaDiv getShokuhiFutanGaitosha() {
        return this.getTblKyufugakugengakuGaito().getShokuhiFutanGaitosha();
    }

    @JsonIgnore
    public RadioButton getRadShokuhiGakuGaitosha() {
        return this.getTblKyufugakugengakuGaito().getShokuhiFutanGaitosha().getRadShokuhiGakuGaitosha();
    }

    @JsonIgnore
    public void  setRadShokuhiGakuGaitosha(RadioButton radShokuhiGakuGaitosha) {
        this.getTblKyufugakugengakuGaito().getShokuhiFutanGaitosha().setRadShokuhiGakuGaitosha(radShokuhiGakuGaitosha);
    }

    @JsonIgnore
    public TextBox getTxtShokuhiGakuOtherGaitosha() {
        return this.getTblKyufugakugengakuGaito().getShokuhiFutanGaitosha().getTxtShokuhiGakuOtherGaitosha();
    }

    @JsonIgnore
    public void  setTxtShokuhiGakuOtherGaitosha(TextBox txtShokuhiGakuOtherGaitosha) {
        this.getTblKyufugakugengakuGaito().getShokuhiFutanGaitosha().setTxtShokuhiGakuOtherGaitosha(txtShokuhiGakuOtherGaitosha);
    }

    @JsonIgnore
    public KogakuKaigoServiceHiGaitoshaDiv getKogakuKaigoServiceHiGaitosha() {
        return this.getTblKyufugakugengakuGaito().getKogakuKaigoServiceHiGaitosha();
    }

    @JsonIgnore
    public RadioButton getRadKogakuKaigoServiceHiGaitosha() {
        return this.getTblKyufugakugengakuGaito().getKogakuKaigoServiceHiGaitosha().getRadKogakuKaigoServiceHiGaitosha();
    }

    @JsonIgnore
    public void  setRadKogakuKaigoServiceHiGaitosha(RadioButton radKogakuKaigoServiceHiGaitosha) {
        this.getTblKyufugakugengakuGaito().getKogakuKaigoServiceHiGaitosha().setRadKogakuKaigoServiceHiGaitosha(radKogakuKaigoServiceHiGaitosha);
    }

    @JsonIgnore
    public TextBox getTxtKogakuKaigoServiceHiOtherGaitosha() {
        return this.getTblKyufugakugengakuGaito().getKogakuKaigoServiceHiGaitosha().getTxtKogakuKaigoServiceHiOtherGaitosha();
    }

    @JsonIgnore
    public void  setTxtKogakuKaigoServiceHiOtherGaitosha(TextBox txtKogakuKaigoServiceHiOtherGaitosha) {
        this.getTblKyufugakugengakuGaito().getKogakuKaigoServiceHiGaitosha().setTxtKogakuKaigoServiceHiOtherGaitosha(txtKogakuKaigoServiceHiOtherGaitosha);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtRenrakuhyoBikoGaitosha() {
        return this.getRenrakuhyoBikoGaitosha().getTxtRenrakuhyoBikoGaitosha();
    }

    @JsonIgnore
    public void  setTxtRenrakuhyoBikoGaitosha(TextBoxMultiLine txtRenrakuhyoBikoGaitosha) {
        this.getRenrakuhyoBikoGaitosha().setTxtRenrakuhyoBikoGaitosha(txtRenrakuhyoBikoGaitosha);
    }

    // </editor-fold>
}
