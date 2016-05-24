package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.SeikatsuhogoDetail;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SeikatsuhogoDetail のクラスファイル 
 * 
 * @author 自動生成
 */
public class SeikatsuhogoDetailDiv extends Panel implements ISeikatsuhogoDetailDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SeikatsuhogoDetailSub")
    private SeikatsuhogoDetailSubDiv SeikatsuhogoDetailSub;
    @JsonProperty("FujoShurui")
    private FujoShuruiDiv FujoShurui;
    @JsonProperty("TeishiKikan")
    private TeishiKikanDiv TeishiKikan;
    @JsonProperty("SeikatsuHojoInputSeigyo")
    private SeikatsuHojoInputSeigyoDiv SeikatsuHojoInputSeigyo;
    @JsonProperty("hdnDataPass")
    private RString hdnDataPass;
    @JsonProperty("hdnHyoujiMode")
    private RString hdnHyoujiMode;
    @JsonProperty("hdnMainHyoujiMode")
    private RString hdnMainHyoujiMode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getSeikatsuhogoDetailSub
     * @return SeikatsuhogoDetailSub
     */
    @JsonProperty("SeikatsuhogoDetailSub")
    public SeikatsuhogoDetailSubDiv getSeikatsuhogoDetailSub() {
        return SeikatsuhogoDetailSub;
    }

    /*
     * setSeikatsuhogoDetailSub
     * @param SeikatsuhogoDetailSub SeikatsuhogoDetailSub
     */
    @JsonProperty("SeikatsuhogoDetailSub")
    public void setSeikatsuhogoDetailSub(SeikatsuhogoDetailSubDiv SeikatsuhogoDetailSub) {
        this.SeikatsuhogoDetailSub = SeikatsuhogoDetailSub;
    }

    /*
     * getFujoShurui
     * @return FujoShurui
     */
    @JsonProperty("FujoShurui")
    public FujoShuruiDiv getFujoShurui() {
        return FujoShurui;
    }

    /*
     * setFujoShurui
     * @param FujoShurui FujoShurui
     */
    @JsonProperty("FujoShurui")
    public void setFujoShurui(FujoShuruiDiv FujoShurui) {
        this.FujoShurui = FujoShurui;
    }

    /*
     * getTeishiKikan
     * @return TeishiKikan
     */
    @JsonProperty("TeishiKikan")
    public TeishiKikanDiv getTeishiKikan() {
        return TeishiKikan;
    }

    /*
     * setTeishiKikan
     * @param TeishiKikan TeishiKikan
     */
    @JsonProperty("TeishiKikan")
    public void setTeishiKikan(TeishiKikanDiv TeishiKikan) {
        this.TeishiKikan = TeishiKikan;
    }

    /*
     * getSeikatsuHojoInputSeigyo
     * @return SeikatsuHojoInputSeigyo
     */
    @JsonProperty("SeikatsuHojoInputSeigyo")
    public SeikatsuHojoInputSeigyoDiv getSeikatsuHojoInputSeigyo() {
        return SeikatsuHojoInputSeigyo;
    }

    /*
     * setSeikatsuHojoInputSeigyo
     * @param SeikatsuHojoInputSeigyo SeikatsuHojoInputSeigyo
     */
    @JsonProperty("SeikatsuHojoInputSeigyo")
    public void setSeikatsuHojoInputSeigyo(SeikatsuHojoInputSeigyoDiv SeikatsuHojoInputSeigyo) {
        this.SeikatsuHojoInputSeigyo = SeikatsuHojoInputSeigyo;
    }

    /*
     * gethdnDataPass
     * @return hdnDataPass
     */
    @JsonProperty("hdnDataPass")
    public RString getHdnDataPass() {
        return hdnDataPass;
    }

    /*
     * sethdnDataPass
     * @param hdnDataPass hdnDataPass
     */
    @JsonProperty("hdnDataPass")
    public void setHdnDataPass(RString hdnDataPass) {
        this.hdnDataPass = hdnDataPass;
    }

    /*
     * gethdnHyoujiMode
     * @return hdnHyoujiMode
     */
    @JsonProperty("hdnHyoujiMode")
    public RString getHdnHyoujiMode() {
        return hdnHyoujiMode;
    }

    /*
     * sethdnHyoujiMode
     * @param hdnHyoujiMode hdnHyoujiMode
     */
    @JsonProperty("hdnHyoujiMode")
    public void setHdnHyoujiMode(RString hdnHyoujiMode) {
        this.hdnHyoujiMode = hdnHyoujiMode;
    }

    /*
     * gethdnMainHyoujiMode
     * @return hdnMainHyoujiMode
     */
    @JsonProperty("hdnMainHyoujiMode")
    public RString getHdnMainHyoujiMode() {
        return hdnMainHyoujiMode;
    }

    /*
     * sethdnMainHyoujiMode
     * @param hdnMainHyoujiMode hdnMainHyoujiMode
     */
    @JsonProperty("hdnMainHyoujiMode")
    public void setHdnMainHyoujiMode(RString hdnMainHyoujiMode) {
        this.hdnMainHyoujiMode = hdnMainHyoujiMode;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public JukyuKikanDiv getJukyuKikan() {
        return this.getSeikatsuhogoDetailSub().getJukyuKikan();
    }

    @JsonIgnore
    public void  setJukyuKikan(JukyuKikanDiv JukyuKikan) {
        this.getSeikatsuhogoDetailSub().setJukyuKikan(JukyuKikan);
    }

    @JsonIgnore
    public TextBoxCode getTxtJukyushaNo() {
        return this.getSeikatsuhogoDetailSub().getJukyuKikan().getTxtJukyushaNo();
    }

    @JsonIgnore
    public void  setTxtJukyushaNo(TextBoxCode txtJukyushaNo) {
        this.getSeikatsuhogoDetailSub().getJukyuKikan().setTxtJukyushaNo(txtJukyushaNo);
    }

    @JsonIgnore
    public TextBoxDate getTxtJukyuKaishiYMD() {
        return this.getSeikatsuhogoDetailSub().getJukyuKikan().getTxtJukyuKaishiYMD();
    }

    @JsonIgnore
    public void  setTxtJukyuKaishiYMD(TextBoxDate txtJukyuKaishiYMD) {
        this.getSeikatsuhogoDetailSub().getJukyuKikan().setTxtJukyuKaishiYMD(txtJukyuKaishiYMD);
    }

    @JsonIgnore
    public TextBoxDate getTxtJukyuHaishiYMD() {
        return this.getSeikatsuhogoDetailSub().getJukyuKikan().getTxtJukyuHaishiYMD();
    }

    @JsonIgnore
    public void  setTxtJukyuHaishiYMD(TextBoxDate txtJukyuHaishiYMD) {
        this.getSeikatsuhogoDetailSub().getJukyuKikan().setTxtJukyuHaishiYMD(txtJukyuHaishiYMD);
    }

    @JsonIgnore
    public HokenryoDairinofuDiv getHokenryoDairinofu() {
        return this.getSeikatsuhogoDetailSub().getHokenryoDairinofu();
    }

    @JsonIgnore
    public void  setHokenryoDairinofu(HokenryoDairinofuDiv HokenryoDairinofu) {
        this.getSeikatsuhogoDetailSub().setHokenryoDairinofu(HokenryoDairinofu);
    }

    @JsonIgnore
    public RadioButton getRadDairinofuKubun() {
        return this.getSeikatsuhogoDetailSub().getHokenryoDairinofu().getRadDairinofuKubun();
    }

    @JsonIgnore
    public void  setRadDairinofuKubun(RadioButton radDairinofuKubun) {
        this.getSeikatsuhogoDetailSub().getHokenryoDairinofu().setRadDairinofuKubun(radDairinofuKubun);
    }

    @JsonIgnore
    public TextBoxDate getTxtDainoNofuYM() {
        return this.getSeikatsuhogoDetailSub().getHokenryoDairinofu().getTxtDainoNofuYM();
    }

    @JsonIgnore
    public void  setTxtDainoNofuYM(TextBoxDate txtDainoNofuYM) {
        this.getSeikatsuhogoDetailSub().getHokenryoDairinofu().setTxtDainoNofuYM(txtDainoNofuYM);
    }

    @JsonIgnore
    public KyugoShisetsuDiv getKyugoShisetsu() {
        return this.getSeikatsuhogoDetailSub().getKyugoShisetsu();
    }

    @JsonIgnore
    public void  setKyugoShisetsu(KyugoShisetsuDiv KyugoShisetsu) {
        this.getSeikatsuhogoDetailSub().setKyugoShisetsu(KyugoShisetsu);
    }

    @JsonIgnore
    public RadioButton getRadNyutaishoKubun() {
        return this.getSeikatsuhogoDetailSub().getKyugoShisetsu().getRadNyutaishoKubun();
    }

    @JsonIgnore
    public void  setRadNyutaishoKubun(RadioButton radNyutaishoKubun) {
        this.getSeikatsuhogoDetailSub().getKyugoShisetsu().setRadNyutaishoKubun(radNyutaishoKubun);
    }

    @JsonIgnore
    public TextBoxDate getTxtNyutaishoYMD() {
        return this.getSeikatsuhogoDetailSub().getKyugoShisetsu().getTxtNyutaishoYMD();
    }

    @JsonIgnore
    public void  setTxtNyutaishoYMD(TextBoxDate txtNyutaishoYMD) {
        this.getSeikatsuhogoDetailSub().getKyugoShisetsu().setTxtNyutaishoYMD(txtNyutaishoYMD);
    }

    @JsonIgnore
    public CheckBoxList getChkFujoShurui() {
        return this.getFujoShurui().getChkFujoShurui();
    }

    @JsonIgnore
    public void  setChkFujoShurui(CheckBoxList chkFujoShurui) {
        this.getFujoShurui().setChkFujoShurui(chkFujoShurui);
    }

    @JsonIgnore
    public Button getBtnTeishiRirekiAdd() {
        return this.getTeishiKikan().getBtnTeishiRirekiAdd();
    }

    @JsonIgnore
    public void  setBtnTeishiRirekiAdd(Button btnTeishiRirekiAdd) {
        this.getTeishiKikan().setBtnTeishiRirekiAdd(btnTeishiRirekiAdd);
    }

    @JsonIgnore
    public DataGrid<dgTeishiRireki_Row> getDgTeishiRireki() {
        return this.getTeishiKikan().getDgTeishiRireki();
    }

    @JsonIgnore
    public void  setDgTeishiRireki(DataGrid<dgTeishiRireki_Row> dgTeishiRireki) {
        this.getTeishiKikan().setDgTeishiRireki(dgTeishiRireki);
    }

    @JsonIgnore
    public TeishiKikanInputDiv getTeishiKikanInput() {
        return this.getTeishiKikan().getTeishiKikanInput();
    }

    @JsonIgnore
    public void  setTeishiKikanInput(TeishiKikanInputDiv TeishiKikanInput) {
        this.getTeishiKikan().setTeishiKikanInput(TeishiKikanInput);
    }

    @JsonIgnore
    public TextBoxDate getTxtTeishiKaishiYMD() {
        return this.getTeishiKikan().getTeishiKikanInput().getTxtTeishiKaishiYMD();
    }

    @JsonIgnore
    public void  setTxtTeishiKaishiYMD(TextBoxDate txtTeishiKaishiYMD) {
        this.getTeishiKikan().getTeishiKikanInput().setTxtTeishiKaishiYMD(txtTeishiKaishiYMD);
    }

    @JsonIgnore
    public TextBoxDate getTxtTeishiShuryoYMD() {
        return this.getTeishiKikan().getTeishiKikanInput().getTxtTeishiShuryoYMD();
    }

    @JsonIgnore
    public void  setTxtTeishiShuryoYMD(TextBoxDate txtTeishiShuryoYMD) {
        this.getTeishiKikan().getTeishiKikanInput().setTxtTeishiShuryoYMD(txtTeishiShuryoYMD);
    }

    @JsonIgnore
    public TeishiInputSeigyoDiv getTeishiInputSeigyo() {
        return this.getTeishiKikan().getTeishiKikanInput().getTeishiInputSeigyo();
    }

    @JsonIgnore
    public void  setTeishiInputSeigyo(TeishiInputSeigyoDiv TeishiInputSeigyo) {
        this.getTeishiKikan().getTeishiKikanInput().setTeishiInputSeigyo(TeishiInputSeigyo);
    }

    @JsonIgnore
    public Button getBtnTeishiInputKakutei() {
        return this.getTeishiKikan().getTeishiKikanInput().getTeishiInputSeigyo().getBtnTeishiInputKakutei();
    }

    @JsonIgnore
    public void  setBtnTeishiInputKakutei(Button btnTeishiInputKakutei) {
        this.getTeishiKikan().getTeishiKikanInput().getTeishiInputSeigyo().setBtnTeishiInputKakutei(btnTeishiInputKakutei);
    }

    @JsonIgnore
    public Button getBtnTeishiInputTorikeshi() {
        return this.getTeishiKikan().getTeishiKikanInput().getTeishiInputSeigyo().getBtnTeishiInputTorikeshi();
    }

    @JsonIgnore
    public void  setBtnTeishiInputTorikeshi(Button btnTeishiInputTorikeshi) {
        this.getTeishiKikan().getTeishiKikanInput().getTeishiInputSeigyo().setBtnTeishiInputTorikeshi(btnTeishiInputTorikeshi);
    }

    @JsonIgnore
    public Button getBtnMeisaiKakutei() {
        return this.getSeikatsuHojoInputSeigyo().getBtnMeisaiKakutei();
    }

    @JsonIgnore
    public void  setBtnMeisaiKakutei(Button btnMeisaiKakutei) {
        this.getSeikatsuHojoInputSeigyo().setBtnMeisaiKakutei(btnMeisaiKakutei);
    }

    @JsonIgnore
    public Button getBtnMeisaiTorikeshi() {
        return this.getSeikatsuHojoInputSeigyo().getBtnMeisaiTorikeshi();
    }

    @JsonIgnore
    public void  setBtnMeisaiTorikeshi(Button btnMeisaiTorikeshi) {
        this.getSeikatsuHojoInputSeigyo().setBtnMeisaiTorikeshi(btnMeisaiTorikeshi);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
