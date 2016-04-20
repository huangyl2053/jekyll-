package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2010012;
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
 * ShisetsutourukuPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShisetsutourukuPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KaigoKanryo")
    private KaigoKanryoDiv KaigoKanryo;
    @JsonProperty("JigyoshaShurui")
    private JigyoshaShuruiDiv JigyoshaShurui;
    @JsonProperty("ShisetsuJoho")
    private ShisetsuJohoDiv ShisetsuJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKaigoKanryo
     * @return KaigoKanryo
     */
    @JsonProperty("KaigoKanryo")
    public KaigoKanryoDiv getKaigoKanryo() {
        return KaigoKanryo;
    }

    /*
     * setKaigoKanryo
     * @param KaigoKanryo KaigoKanryo
     */
    @JsonProperty("KaigoKanryo")
    public void setKaigoKanryo(KaigoKanryoDiv KaigoKanryo) {
        this.KaigoKanryo = KaigoKanryo;
    }

    /*
     * getJigyoshaShurui
     * @return JigyoshaShurui
     */
    @JsonProperty("JigyoshaShurui")
    public JigyoshaShuruiDiv getJigyoshaShurui() {
        return JigyoshaShurui;
    }

    /*
     * setJigyoshaShurui
     * @param JigyoshaShurui JigyoshaShurui
     */
    @JsonProperty("JigyoshaShurui")
    public void setJigyoshaShurui(JigyoshaShuruiDiv JigyoshaShurui) {
        this.JigyoshaShurui = JigyoshaShurui;
    }

    /*
     * getShisetsuJoho
     * @return ShisetsuJoho
     */
    @JsonProperty("ShisetsuJoho")
    public ShisetsuJohoDiv getShisetsuJoho() {
        return ShisetsuJoho;
    }

    /*
     * setShisetsuJoho
     * @param ShisetsuJoho ShisetsuJoho
     */
    @JsonProperty("ShisetsuJoho")
    public void setShisetsuJoho(ShisetsuJohoDiv ShisetsuJoho) {
        this.ShisetsuJoho = ShisetsuJoho;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxFlexibleDate getTxtShisetsuYukoKaishiYMD() {
        return this.getShisetsuJoho().getTxtShisetsuYukoKaishiYMD();
    }

    @JsonIgnore
    public void  setTxtShisetsuYukoKaishiYMD(TextBoxFlexibleDate txtShisetsuYukoKaishiYMD) {
        this.getShisetsuJoho().setTxtShisetsuYukoKaishiYMD(txtShisetsuYukoKaishiYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShisetsuYukoShuryoYMD() {
        return this.getShisetsuJoho().getTxtShisetsuYukoShuryoYMD();
    }

    @JsonIgnore
    public void  setTxtShisetsuYukoShuryoYMD(TextBoxFlexibleDate txtShisetsuYukoShuryoYMD) {
        this.getShisetsuJoho().setTxtShisetsuYukoShuryoYMD(txtShisetsuYukoShuryoYMD);
    }

    @JsonIgnore
    public RadioButton getRadShisetsuKannaiKangaiKubun() {
        return this.getShisetsuJoho().getRadShisetsuKannaiKangaiKubun();
    }

    @JsonIgnore
    public void  setRadShisetsuKannaiKangaiKubun(RadioButton radShisetsuKannaiKangaiKubun) {
        this.getShisetsuJoho().setRadShisetsuKannaiKangaiKubun(radShisetsuKannaiKangaiKubun);
    }

    @JsonIgnore
    public TextBoxCode getTxtShisetsuJigyoshaNo() {
        return this.getShisetsuJoho().getTxtShisetsuJigyoshaNo();
    }

    @JsonIgnore
    public void  setTxtShisetsuJigyoshaNo(TextBoxCode txtShisetsuJigyoshaNo) {
        this.getShisetsuJoho().setTxtShisetsuJigyoshaNo(txtShisetsuJigyoshaNo);
    }

    @JsonIgnore
    public TextBox getTxtShisetsuJigyoshaName() {
        return this.getShisetsuJoho().getTxtShisetsuJigyoshaName();
    }

    @JsonIgnore
    public void  setTxtShisetsuJigyoshaName(TextBox txtShisetsuJigyoshaName) {
        this.getShisetsuJoho().setTxtShisetsuJigyoshaName(txtShisetsuJigyoshaName);
    }

    @JsonIgnore
    public TextBox getTxtShisetsuJigyoshaNameKana() {
        return this.getShisetsuJoho().getTxtShisetsuJigyoshaNameKana();
    }

    @JsonIgnore
    public void  setTxtShisetsuJigyoshaNameKana(TextBox txtShisetsuJigyoshaNameKana) {
        this.getShisetsuJoho().setTxtShisetsuJigyoshaNameKana(txtShisetsuJigyoshaNameKana);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShisetsuJigyoKaishiYMD() {
        return this.getShisetsuJoho().getTxtShisetsuJigyoKaishiYMD();
    }

    @JsonIgnore
    public void  setTxtShisetsuJigyoKaishiYMD(TextBoxFlexibleDate txtShisetsuJigyoKaishiYMD) {
        this.getShisetsuJoho().setTxtShisetsuJigyoKaishiYMD(txtShisetsuJigyoKaishiYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShisetsuJigyoKyushuYMD() {
        return this.getShisetsuJoho().getTxtShisetsuJigyoKyushuYMD();
    }

    @JsonIgnore
    public void  setTxtShisetsuJigyoKyushuYMD(TextBoxFlexibleDate txtShisetsuJigyoKyushuYMD) {
        this.getShisetsuJoho().setTxtShisetsuJigyoKyushuYMD(txtShisetsuJigyoKyushuYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShisetsuJigyoSaikaiYMD() {
        return this.getShisetsuJoho().getTxtShisetsuJigyoSaikaiYMD();
    }

    @JsonIgnore
    public void  setTxtShisetsuJigyoSaikaiYMD(TextBoxFlexibleDate txtShisetsuJigyoSaikaiYMD) {
        this.getShisetsuJoho().setTxtShisetsuJigyoSaikaiYMD(txtShisetsuJigyoSaikaiYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShisetsuJigyoHaishiYMD() {
        return this.getShisetsuJoho().getTxtShisetsuJigyoHaishiYMD();
    }

    @JsonIgnore
    public void  setTxtShisetsuJigyoHaishiYMD(TextBoxFlexibleDate txtShisetsuJigyoHaishiYMD) {
        this.getShisetsuJoho().setTxtShisetsuJigyoHaishiYMD(txtShisetsuJigyoHaishiYMD);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtShisetsuYubinNo() {
        return this.getShisetsuJoho().getTxtShisetsuYubinNo();
    }

    @JsonIgnore
    public void  setTxtShisetsuYubinNo(TextBoxYubinNo txtShisetsuYubinNo) {
        this.getShisetsuJoho().setTxtShisetsuYubinNo(txtShisetsuYubinNo);
    }

    @JsonIgnore
    public TextBox getTxtShisetsuTelNo() {
        return this.getShisetsuJoho().getTxtShisetsuTelNo();
    }

    @JsonIgnore
    public void  setTxtShisetsuTelNo(TextBox txtShisetsuTelNo) {
        this.getShisetsuJoho().setTxtShisetsuTelNo(txtShisetsuTelNo);
    }

    @JsonIgnore
    public TextBox getTxtShisetsuFaxNo() {
        return this.getShisetsuJoho().getTxtShisetsuFaxNo();
    }

    @JsonIgnore
    public void  setTxtShisetsuFaxNo(TextBox txtShisetsuFaxNo) {
        this.getShisetsuJoho().setTxtShisetsuFaxNo(txtShisetsuFaxNo);
    }

    @JsonIgnore
    public TextBox getTxtShisetsuJusho() {
        return this.getShisetsuJoho().getTxtShisetsuJusho();
    }

    @JsonIgnore
    public void  setTxtShisetsuJusho(TextBox txtShisetsuJusho) {
        this.getShisetsuJoho().setTxtShisetsuJusho(txtShisetsuJusho);
    }

    @JsonIgnore
    public TextBox getTxtShisetsuJushoKana() {
        return this.getShisetsuJoho().getTxtShisetsuJushoKana();
    }

    @JsonIgnore
    public void  setTxtShisetsuJushoKana(TextBox txtShisetsuJushoKana) {
        this.getShisetsuJoho().setTxtShisetsuJushoKana(txtShisetsuJushoKana);
    }

    @JsonIgnore
    public TextBox getTxtShisetsuDaihyoshaName() {
        return this.getShisetsuJoho().getTxtShisetsuDaihyoshaName();
    }

    @JsonIgnore
    public void  setTxtShisetsuDaihyoshaName(TextBox txtShisetsuDaihyoshaName) {
        this.getShisetsuJoho().setTxtShisetsuDaihyoshaName(txtShisetsuDaihyoshaName);
    }

    @JsonIgnore
    public TextBox getTxtShisetsuDaihyoshaNameKana() {
        return this.getShisetsuJoho().getTxtShisetsuDaihyoshaNameKana();
    }

    @JsonIgnore
    public void  setTxtShisetsuDaihyoshaNameKana(TextBox txtShisetsuDaihyoshaNameKana) {
        this.getShisetsuJoho().setTxtShisetsuDaihyoshaNameKana(txtShisetsuDaihyoshaNameKana);
    }

    @JsonIgnore
    public TextBox getTxtShisetsuYakushoku() {
        return this.getShisetsuJoho().getTxtShisetsuYakushoku();
    }

    @JsonIgnore
    public void  setTxtShisetsuYakushoku(TextBox txtShisetsuYakushoku) {
        this.getShisetsuJoho().setTxtShisetsuYakushoku(txtShisetsuYakushoku);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtShisetsuBiko() {
        return this.getShisetsuJoho().getTxtShisetsuBiko();
    }

    @JsonIgnore
    public void  setTxtShisetsuBiko(TextBoxMultiLine txtShisetsuBiko) {
        this.getShisetsuJoho().setTxtShisetsuBiko(txtShisetsuBiko);
    }

    // </editor-fold>
}
