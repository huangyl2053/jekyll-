package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.menjokaijosaitennyu.MenjoKaijoSaiTennyu;
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
 * MenjoKaijoSaiTennyu のクラスファイル 
 * 
 * @author 自動生成
 */
public class MenjoKaijoSaiTennyuDiv extends Panel implements IMenjoKaijoSaiTennyuDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgMenjoKaijoOrSaitennyu")
    private DataGrid<dgMenjoKaijoOrSaitennyu_Row> dgMenjoKaijoOrSaitennyu;
    @JsonProperty("linIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuGrid")
    private HorizontalLine linIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuGrid;
    @JsonProperty("lblIchigoKyufugakuGengakuMenjoKaijoOrSaitennyu1")
    private Label lblIchigoKyufugakuGengakuMenjoKaijoOrSaitennyu1;
    @JsonProperty("lblExplanation2")
    private Label lblExplanation2;
    @JsonProperty("lblExplanation3")
    private Label lblExplanation3;
    @JsonProperty("lblExplanation4")
    private Label lblExplanation4;
    @JsonProperty("lblExplanation5")
    private Label lblExplanation5;
    @JsonProperty("KyufugakuGengakuToroku")
    private KyufugakuGengakuTorokuDiv KyufugakuGengakuToroku;
    @JsonProperty("btnIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuClose")
    private Button btnIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuClose;
    @JsonProperty("key_ShiharaiHohoHenkoKanri")
    private RString key_ShiharaiHohoHenkoKanri;
    @JsonProperty("key_HihokenshaNo")
    private RString key_HihokenshaNo;
    @JsonProperty("key_MaxRirekiNo")
    private RString key_MaxRirekiNo;
    @JsonProperty("key_Button")
    private RString key_Button;
    @JsonProperty("hihokenshaNo")
    private RString hihokenshaNo;
    @JsonProperty("kanriKubun")
    private RString kanriKubun;
    @JsonProperty("tainoHanteiKubun")
    private RString tainoHanteiKubun;
    @JsonProperty("rirekiNo")
    private RString rirekiNo;
    @JsonProperty("tainoHanteiKekka")
    private RString tainoHanteiKekka;
    @JsonProperty("key_hannteiIndex")
    private RString key_hannteiIndex;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgMenjoKaijoOrSaitennyu
     * @return dgMenjoKaijoOrSaitennyu
     */
    @JsonProperty("dgMenjoKaijoOrSaitennyu")
    public DataGrid<dgMenjoKaijoOrSaitennyu_Row> getDgMenjoKaijoOrSaitennyu() {
        return dgMenjoKaijoOrSaitennyu;
    }

    /*
     * setdgMenjoKaijoOrSaitennyu
     * @param dgMenjoKaijoOrSaitennyu dgMenjoKaijoOrSaitennyu
     */
    @JsonProperty("dgMenjoKaijoOrSaitennyu")
    public void setDgMenjoKaijoOrSaitennyu(DataGrid<dgMenjoKaijoOrSaitennyu_Row> dgMenjoKaijoOrSaitennyu) {
        this.dgMenjoKaijoOrSaitennyu = dgMenjoKaijoOrSaitennyu;
    }

    /*
     * getlinIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuGrid
     * @return linIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuGrid
     */
    @JsonProperty("linIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuGrid")
    public HorizontalLine getLinIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuGrid() {
        return linIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuGrid;
    }

    /*
     * setlinIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuGrid
     * @param linIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuGrid linIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuGrid
     */
    @JsonProperty("linIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuGrid")
    public void setLinIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuGrid(HorizontalLine linIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuGrid) {
        this.linIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuGrid = linIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuGrid;
    }

    /*
     * getlblIchigoKyufugakuGengakuMenjoKaijoOrSaitennyu1
     * @return lblIchigoKyufugakuGengakuMenjoKaijoOrSaitennyu1
     */
    @JsonProperty("lblIchigoKyufugakuGengakuMenjoKaijoOrSaitennyu1")
    public Label getLblIchigoKyufugakuGengakuMenjoKaijoOrSaitennyu1() {
        return lblIchigoKyufugakuGengakuMenjoKaijoOrSaitennyu1;
    }

    /*
     * setlblIchigoKyufugakuGengakuMenjoKaijoOrSaitennyu1
     * @param lblIchigoKyufugakuGengakuMenjoKaijoOrSaitennyu1 lblIchigoKyufugakuGengakuMenjoKaijoOrSaitennyu1
     */
    @JsonProperty("lblIchigoKyufugakuGengakuMenjoKaijoOrSaitennyu1")
    public void setLblIchigoKyufugakuGengakuMenjoKaijoOrSaitennyu1(Label lblIchigoKyufugakuGengakuMenjoKaijoOrSaitennyu1) {
        this.lblIchigoKyufugakuGengakuMenjoKaijoOrSaitennyu1 = lblIchigoKyufugakuGengakuMenjoKaijoOrSaitennyu1;
    }

    /*
     * getlblExplanation2
     * @return lblExplanation2
     */
    @JsonProperty("lblExplanation2")
    public Label getLblExplanation2() {
        return lblExplanation2;
    }

    /*
     * setlblExplanation2
     * @param lblExplanation2 lblExplanation2
     */
    @JsonProperty("lblExplanation2")
    public void setLblExplanation2(Label lblExplanation2) {
        this.lblExplanation2 = lblExplanation2;
    }

    /*
     * getlblExplanation3
     * @return lblExplanation3
     */
    @JsonProperty("lblExplanation3")
    public Label getLblExplanation3() {
        return lblExplanation3;
    }

    /*
     * setlblExplanation3
     * @param lblExplanation3 lblExplanation3
     */
    @JsonProperty("lblExplanation3")
    public void setLblExplanation3(Label lblExplanation3) {
        this.lblExplanation3 = lblExplanation3;
    }

    /*
     * getlblExplanation4
     * @return lblExplanation4
     */
    @JsonProperty("lblExplanation4")
    public Label getLblExplanation4() {
        return lblExplanation4;
    }

    /*
     * setlblExplanation4
     * @param lblExplanation4 lblExplanation4
     */
    @JsonProperty("lblExplanation4")
    public void setLblExplanation4(Label lblExplanation4) {
        this.lblExplanation4 = lblExplanation4;
    }

    /*
     * getlblExplanation5
     * @return lblExplanation5
     */
    @JsonProperty("lblExplanation5")
    public Label getLblExplanation5() {
        return lblExplanation5;
    }

    /*
     * setlblExplanation5
     * @param lblExplanation5 lblExplanation5
     */
    @JsonProperty("lblExplanation5")
    public void setLblExplanation5(Label lblExplanation5) {
        this.lblExplanation5 = lblExplanation5;
    }

    /*
     * getKyufugakuGengakuToroku
     * @return KyufugakuGengakuToroku
     */
    @JsonProperty("KyufugakuGengakuToroku")
    public KyufugakuGengakuTorokuDiv getKyufugakuGengakuToroku() {
        return KyufugakuGengakuToroku;
    }

    /*
     * setKyufugakuGengakuToroku
     * @param KyufugakuGengakuToroku KyufugakuGengakuToroku
     */
    @JsonProperty("KyufugakuGengakuToroku")
    public void setKyufugakuGengakuToroku(KyufugakuGengakuTorokuDiv KyufugakuGengakuToroku) {
        this.KyufugakuGengakuToroku = KyufugakuGengakuToroku;
    }

    /*
     * getbtnIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuClose
     * @return btnIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuClose
     */
    @JsonProperty("btnIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuClose")
    public Button getBtnIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuClose() {
        return btnIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuClose;
    }

    /*
     * setbtnIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuClose
     * @param btnIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuClose btnIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuClose
     */
    @JsonProperty("btnIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuClose")
    public void setBtnIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuClose(Button btnIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuClose) {
        this.btnIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuClose = btnIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuClose;
    }

    /*
     * getkey_ShiharaiHohoHenkoKanri
     * @return key_ShiharaiHohoHenkoKanri
     */
    @JsonProperty("key_ShiharaiHohoHenkoKanri")
    public RString getKey_ShiharaiHohoHenkoKanri() {
        return key_ShiharaiHohoHenkoKanri;
    }

    /*
     * setkey_ShiharaiHohoHenkoKanri
     * @param key_ShiharaiHohoHenkoKanri key_ShiharaiHohoHenkoKanri
     */
    @JsonProperty("key_ShiharaiHohoHenkoKanri")
    public void setKey_ShiharaiHohoHenkoKanri(RString key_ShiharaiHohoHenkoKanri) {
        this.key_ShiharaiHohoHenkoKanri = key_ShiharaiHohoHenkoKanri;
    }

    /*
     * getkey_HihokenshaNo
     * @return key_HihokenshaNo
     */
    @JsonProperty("key_HihokenshaNo")
    public RString getKey_HihokenshaNo() {
        return key_HihokenshaNo;
    }

    /*
     * setkey_HihokenshaNo
     * @param key_HihokenshaNo key_HihokenshaNo
     */
    @JsonProperty("key_HihokenshaNo")
    public void setKey_HihokenshaNo(RString key_HihokenshaNo) {
        this.key_HihokenshaNo = key_HihokenshaNo;
    }

    /*
     * getkey_MaxRirekiNo
     * @return key_MaxRirekiNo
     */
    @JsonProperty("key_MaxRirekiNo")
    public RString getKey_MaxRirekiNo() {
        return key_MaxRirekiNo;
    }

    /*
     * setkey_MaxRirekiNo
     * @param key_MaxRirekiNo key_MaxRirekiNo
     */
    @JsonProperty("key_MaxRirekiNo")
    public void setKey_MaxRirekiNo(RString key_MaxRirekiNo) {
        this.key_MaxRirekiNo = key_MaxRirekiNo;
    }

    /*
     * getkey_Button
     * @return key_Button
     */
    @JsonProperty("key_Button")
    public RString getKey_Button() {
        return key_Button;
    }

    /*
     * setkey_Button
     * @param key_Button key_Button
     */
    @JsonProperty("key_Button")
    public void setKey_Button(RString key_Button) {
        this.key_Button = key_Button;
    }

    /*
     * gethihokenshaNo
     * @return hihokenshaNo
     */
    @JsonProperty("hihokenshaNo")
    public RString getHihokenshaNo() {
        return hihokenshaNo;
    }

    /*
     * sethihokenshaNo
     * @param hihokenshaNo hihokenshaNo
     */
    @JsonProperty("hihokenshaNo")
    public void setHihokenshaNo(RString hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /*
     * getkanriKubun
     * @return kanriKubun
     */
    @JsonProperty("kanriKubun")
    public RString getKanriKubun() {
        return kanriKubun;
    }

    /*
     * setkanriKubun
     * @param kanriKubun kanriKubun
     */
    @JsonProperty("kanriKubun")
    public void setKanriKubun(RString kanriKubun) {
        this.kanriKubun = kanriKubun;
    }

    /*
     * gettainoHanteiKubun
     * @return tainoHanteiKubun
     */
    @JsonProperty("tainoHanteiKubun")
    public RString getTainoHanteiKubun() {
        return tainoHanteiKubun;
    }

    /*
     * settainoHanteiKubun
     * @param tainoHanteiKubun tainoHanteiKubun
     */
    @JsonProperty("tainoHanteiKubun")
    public void setTainoHanteiKubun(RString tainoHanteiKubun) {
        this.tainoHanteiKubun = tainoHanteiKubun;
    }

    /*
     * getrirekiNo
     * @return rirekiNo
     */
    @JsonProperty("rirekiNo")
    public RString getRirekiNo() {
        return rirekiNo;
    }

    /*
     * setrirekiNo
     * @param rirekiNo rirekiNo
     */
    @JsonProperty("rirekiNo")
    public void setRirekiNo(RString rirekiNo) {
        this.rirekiNo = rirekiNo;
    }

    /*
     * gettainoHanteiKekka
     * @return tainoHanteiKekka
     */
    @JsonProperty("tainoHanteiKekka")
    public RString getTainoHanteiKekka() {
        return tainoHanteiKekka;
    }

    /*
     * settainoHanteiKekka
     * @param tainoHanteiKekka tainoHanteiKekka
     */
    @JsonProperty("tainoHanteiKekka")
    public void setTainoHanteiKekka(RString tainoHanteiKekka) {
        this.tainoHanteiKekka = tainoHanteiKekka;
    }

    /*
     * getkey_hannteiIndex
     * @return key_hannteiIndex
     */
    @JsonProperty("key_hannteiIndex")
    public RString getKey_hannteiIndex() {
        return key_hannteiIndex;
    }

    /*
     * setkey_hannteiIndex
     * @param key_hannteiIndex key_hannteiIndex
     */
    @JsonProperty("key_hannteiIndex")
    public void setKey_hannteiIndex(RString key_hannteiIndex) {
        this.key_hannteiIndex = key_hannteiIndex;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBox getTxtTorokuJokyo() {
        return this.getKyufugakuGengakuToroku().getTxtTorokuJokyo();
    }

    @JsonIgnore
    public void  setTxtTorokuJokyo(TextBox txtTorokuJokyo) {
        this.getKyufugakuGengakuToroku().setTxtTorokuJokyo(txtTorokuJokyo);
    }

    @JsonIgnore
    public TextBoxNum getTxtKyufugakuGengakuKikan() {
        return this.getKyufugakuGengakuToroku().getTxtKyufugakuGengakuKikan();
    }

    @JsonIgnore
    public void  setTxtKyufugakuGengakuKikan(TextBoxNum txtKyufugakuGengakuKikan) {
        this.getKyufugakuGengakuToroku().setTxtKyufugakuGengakuKikan(txtKyufugakuGengakuKikan);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtGengakuTekiyoKikanKaishiYMD() {
        return this.getKyufugakuGengakuToroku().getTxtGengakuTekiyoKikanKaishiYMD();
    }

    @JsonIgnore
    public void  setTxtGengakuTekiyoKikanKaishiYMD(TextBoxFlexibleDate txtGengakuTekiyoKikanKaishiYMD) {
        this.getKyufugakuGengakuToroku().setTxtGengakuTekiyoKikanKaishiYMD(txtGengakuTekiyoKikanKaishiYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtGengakuTekiyoKikanShuryoYMD() {
        return this.getKyufugakuGengakuToroku().getTxtGengakuTekiyoKikanShuryoYMD();
    }

    @JsonIgnore
    public void  setTxtGengakuTekiyoKikanShuryoYMD(TextBoxFlexibleDate txtGengakuTekiyoKikanShuryoYMD) {
        this.getKyufugakuGengakuToroku().setTxtGengakuTekiyoKikanShuryoYMD(txtGengakuTekiyoKikanShuryoYMD);
    }

    @JsonIgnore
    public TextBoxNum getTxtChoshukenShometsuKikan() {
        return this.getKyufugakuGengakuToroku().getTxtChoshukenShometsuKikan();
    }

    @JsonIgnore
    public void  setTxtChoshukenShometsuKikan(TextBoxNum txtChoshukenShometsuKikan) {
        this.getKyufugakuGengakuToroku().setTxtChoshukenShometsuKikan(txtChoshukenShometsuKikan);
    }

    @JsonIgnore
    public TextBoxNum getTxtNofuzumiKikan() {
        return this.getKyufugakuGengakuToroku().getTxtNofuzumiKikan();
    }

    @JsonIgnore
    public void  setTxtNofuzumiKikan(TextBoxNum txtNofuzumiKikan) {
        this.getKyufugakuGengakuToroku().setTxtNofuzumiKikan(txtNofuzumiKikan);
    }

    @JsonIgnore
    public HorizontalLine getLinIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuTorokuJokyo() {
        return this.getKyufugakuGengakuToroku().getLinIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuTorokuJokyo();
    }

    @JsonIgnore
    public void  setLinIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuTorokuJokyo(HorizontalLine linIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuTorokuJokyo) {
        this.getKyufugakuGengakuToroku().setLinIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuTorokuJokyo(linIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuTorokuJokyo);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtGengakuKetteiYMD() {
        return this.getKyufugakuGengakuToroku().getTxtGengakuKetteiYMD();
    }

    @JsonIgnore
    public void  setTxtGengakuKetteiYMD(TextBoxFlexibleDate txtGengakuKetteiYMD) {
        this.getKyufugakuGengakuToroku().setTxtGengakuKetteiYMD(txtGengakuKetteiYMD);
    }

    @JsonIgnore
    public ButtonDialog getTxtTainoJokyo() {
        return this.getKyufugakuGengakuToroku().getTxtTainoJokyo();
    }

    @JsonIgnore
    public void  setTxtTainoJokyo(ButtonDialog txtTainoJokyo) {
        this.getKyufugakuGengakuToroku().setTxtTainoJokyo(txtTainoJokyo);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtZenkaiKikanKaishiYMD() {
        return this.getKyufugakuGengakuToroku().getTxtZenkaiKikanKaishiYMD();
    }

    @JsonIgnore
    public void  setTxtZenkaiKikanKaishiYMD(TextBoxFlexibleDate txtZenkaiKikanKaishiYMD) {
        this.getKyufugakuGengakuToroku().setTxtZenkaiKikanKaishiYMD(txtZenkaiKikanKaishiYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtZenkaiKikanShuryoYMD() {
        return this.getKyufugakuGengakuToroku().getTxtZenkaiKikanShuryoYMD();
    }

    @JsonIgnore
    public void  setTxtZenkaiKikanShuryoYMD(TextBoxFlexibleDate txtZenkaiKikanShuryoYMD) {
        this.getKyufugakuGengakuToroku().setTxtZenkaiKikanShuryoYMD(txtZenkaiKikanShuryoYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtGengakuTsuchiHakkoYMD() {
        return this.getKyufugakuGengakuToroku().getTxtGengakuTsuchiHakkoYMD();
    }

    @JsonIgnore
    public void  setTxtGengakuTsuchiHakkoYMD(TextBoxFlexibleDate txtGengakuTsuchiHakkoYMD) {
        this.getKyufugakuGengakuToroku().setTxtGengakuTsuchiHakkoYMD(txtGengakuTsuchiHakkoYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKonkaiKikanKaishiYMD() {
        return this.getKyufugakuGengakuToroku().getTxtKonkaiKikanKaishiYMD();
    }

    @JsonIgnore
    public void  setTxtKonkaiKikanKaishiYMD(TextBoxFlexibleDate txtKonkaiKikanKaishiYMD) {
        this.getKyufugakuGengakuToroku().setTxtKonkaiKikanKaishiYMD(txtKonkaiKikanKaishiYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKonkaiKikanShuryoYMD() {
        return this.getKyufugakuGengakuToroku().getTxtKonkaiKikanShuryoYMD();
    }

    @JsonIgnore
    public void  setTxtKonkaiKikanShuryoYMD(TextBoxFlexibleDate txtKonkaiKikanShuryoYMD) {
        this.getKyufugakuGengakuToroku().setTxtKonkaiKikanShuryoYMD(txtKonkaiKikanShuryoYMD);
    }

    @JsonIgnore
    public Button getBtnKakutei() {
        return this.getKyufugakuGengakuToroku().getBtnKakutei();
    }

    @JsonIgnore
    public void  setBtnKakutei(Button btnKakutei) {
        this.getKyufugakuGengakuToroku().setBtnKakutei(btnKakutei);
    }

    @JsonIgnore
    public Button getBtnTorikeshi() {
        return this.getKyufugakuGengakuToroku().getBtnTorikeshi();
    }

    @JsonIgnore
    public void  setBtnTorikeshi(Button btnTorikeshi) {
        this.getKyufugakuGengakuToroku().setBtnTorikeshi(btnTorikeshi);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
