package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.menjokaijosaitennyu.MenjoKaijoSaiTennyu;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KyufugakuGengakuToroku のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyufugakuGengakuTorokuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtTorokuJokyo")
    private TextBox txtTorokuJokyo;
    @JsonProperty("txtKyufugakuGengakuKikan")
    private TextBoxNum txtKyufugakuGengakuKikan;
    @JsonProperty("txtGengakuTekiyoKikanKaishiYMD")
    private TextBoxFlexibleDate txtGengakuTekiyoKikanKaishiYMD;
    @JsonProperty("txtGengakuTekiyoKikanShuryoYMD")
    private TextBoxFlexibleDate txtGengakuTekiyoKikanShuryoYMD;
    @JsonProperty("txtChoshukenShometsuKikan")
    private TextBoxNum txtChoshukenShometsuKikan;
    @JsonProperty("txtNofuzumiKikan")
    private TextBoxNum txtNofuzumiKikan;
    @JsonProperty("linIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuTorokuJokyo")
    private HorizontalLine linIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuTorokuJokyo;
    @JsonProperty("txtGengakuKetteiYMD")
    private TextBoxFlexibleDate txtGengakuKetteiYMD;
    @JsonProperty("txtTainoJokyo")
    private ButtonDialog txtTainoJokyo;
    @JsonProperty("txtZenkaiKikanKaishiYMD")
    private TextBoxFlexibleDate txtZenkaiKikanKaishiYMD;
    @JsonProperty("txtZenkaiKikanShuryoYMD")
    private TextBoxFlexibleDate txtZenkaiKikanShuryoYMD;
    @JsonProperty("txtGengakuTsuchiHakkoYMD")
    private TextBoxFlexibleDate txtGengakuTsuchiHakkoYMD;
    @JsonProperty("txtKonkaiKikanKaishiYMD")
    private TextBoxFlexibleDate txtKonkaiKikanKaishiYMD;
    @JsonProperty("txtKonkaiKikanShuryoYMD")
    private TextBoxFlexibleDate txtKonkaiKikanShuryoYMD;
    @JsonProperty("btnKakutei")
    private Button btnKakutei;
    @JsonProperty("btnTorikeshi")
    private Button btnTorikeshi;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtTorokuJokyo
     * @return txtTorokuJokyo
     */
    @JsonProperty("txtTorokuJokyo")
    public TextBox getTxtTorokuJokyo() {
        return txtTorokuJokyo;
    }

    /*
     * settxtTorokuJokyo
     * @param txtTorokuJokyo txtTorokuJokyo
     */
    @JsonProperty("txtTorokuJokyo")
    public void setTxtTorokuJokyo(TextBox txtTorokuJokyo) {
        this.txtTorokuJokyo = txtTorokuJokyo;
    }

    /*
     * gettxtKyufugakuGengakuKikan
     * @return txtKyufugakuGengakuKikan
     */
    @JsonProperty("txtKyufugakuGengakuKikan")
    public TextBoxNum getTxtKyufugakuGengakuKikan() {
        return txtKyufugakuGengakuKikan;
    }

    /*
     * settxtKyufugakuGengakuKikan
     * @param txtKyufugakuGengakuKikan txtKyufugakuGengakuKikan
     */
    @JsonProperty("txtKyufugakuGengakuKikan")
    public void setTxtKyufugakuGengakuKikan(TextBoxNum txtKyufugakuGengakuKikan) {
        this.txtKyufugakuGengakuKikan = txtKyufugakuGengakuKikan;
    }

    /*
     * gettxtGengakuTekiyoKikanKaishiYMD
     * @return txtGengakuTekiyoKikanKaishiYMD
     */
    @JsonProperty("txtGengakuTekiyoKikanKaishiYMD")
    public TextBoxFlexibleDate getTxtGengakuTekiyoKikanKaishiYMD() {
        return txtGengakuTekiyoKikanKaishiYMD;
    }

    /*
     * settxtGengakuTekiyoKikanKaishiYMD
     * @param txtGengakuTekiyoKikanKaishiYMD txtGengakuTekiyoKikanKaishiYMD
     */
    @JsonProperty("txtGengakuTekiyoKikanKaishiYMD")
    public void setTxtGengakuTekiyoKikanKaishiYMD(TextBoxFlexibleDate txtGengakuTekiyoKikanKaishiYMD) {
        this.txtGengakuTekiyoKikanKaishiYMD = txtGengakuTekiyoKikanKaishiYMD;
    }

    /*
     * gettxtGengakuTekiyoKikanShuryoYMD
     * @return txtGengakuTekiyoKikanShuryoYMD
     */
    @JsonProperty("txtGengakuTekiyoKikanShuryoYMD")
    public TextBoxFlexibleDate getTxtGengakuTekiyoKikanShuryoYMD() {
        return txtGengakuTekiyoKikanShuryoYMD;
    }

    /*
     * settxtGengakuTekiyoKikanShuryoYMD
     * @param txtGengakuTekiyoKikanShuryoYMD txtGengakuTekiyoKikanShuryoYMD
     */
    @JsonProperty("txtGengakuTekiyoKikanShuryoYMD")
    public void setTxtGengakuTekiyoKikanShuryoYMD(TextBoxFlexibleDate txtGengakuTekiyoKikanShuryoYMD) {
        this.txtGengakuTekiyoKikanShuryoYMD = txtGengakuTekiyoKikanShuryoYMD;
    }

    /*
     * gettxtChoshukenShometsuKikan
     * @return txtChoshukenShometsuKikan
     */
    @JsonProperty("txtChoshukenShometsuKikan")
    public TextBoxNum getTxtChoshukenShometsuKikan() {
        return txtChoshukenShometsuKikan;
    }

    /*
     * settxtChoshukenShometsuKikan
     * @param txtChoshukenShometsuKikan txtChoshukenShometsuKikan
     */
    @JsonProperty("txtChoshukenShometsuKikan")
    public void setTxtChoshukenShometsuKikan(TextBoxNum txtChoshukenShometsuKikan) {
        this.txtChoshukenShometsuKikan = txtChoshukenShometsuKikan;
    }

    /*
     * gettxtNofuzumiKikan
     * @return txtNofuzumiKikan
     */
    @JsonProperty("txtNofuzumiKikan")
    public TextBoxNum getTxtNofuzumiKikan() {
        return txtNofuzumiKikan;
    }

    /*
     * settxtNofuzumiKikan
     * @param txtNofuzumiKikan txtNofuzumiKikan
     */
    @JsonProperty("txtNofuzumiKikan")
    public void setTxtNofuzumiKikan(TextBoxNum txtNofuzumiKikan) {
        this.txtNofuzumiKikan = txtNofuzumiKikan;
    }

    /*
     * getlinIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuTorokuJokyo
     * @return linIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuTorokuJokyo
     */
    @JsonProperty("linIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuTorokuJokyo")
    public HorizontalLine getLinIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuTorokuJokyo() {
        return linIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuTorokuJokyo;
    }

    /*
     * setlinIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuTorokuJokyo
     * @param linIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuTorokuJokyo linIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuTorokuJokyo
     */
    @JsonProperty("linIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuTorokuJokyo")
    public void setLinIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuTorokuJokyo(HorizontalLine linIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuTorokuJokyo) {
        this.linIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuTorokuJokyo = linIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuTorokuJokyo;
    }

    /*
     * gettxtGengakuKetteiYMD
     * @return txtGengakuKetteiYMD
     */
    @JsonProperty("txtGengakuKetteiYMD")
    public TextBoxFlexibleDate getTxtGengakuKetteiYMD() {
        return txtGengakuKetteiYMD;
    }

    /*
     * settxtGengakuKetteiYMD
     * @param txtGengakuKetteiYMD txtGengakuKetteiYMD
     */
    @JsonProperty("txtGengakuKetteiYMD")
    public void setTxtGengakuKetteiYMD(TextBoxFlexibleDate txtGengakuKetteiYMD) {
        this.txtGengakuKetteiYMD = txtGengakuKetteiYMD;
    }

    /*
     * gettxtTainoJokyo
     * @return txtTainoJokyo
     */
    @JsonProperty("txtTainoJokyo")
    public ButtonDialog getTxtTainoJokyo() {
        return txtTainoJokyo;
    }

    /*
     * settxtTainoJokyo
     * @param txtTainoJokyo txtTainoJokyo
     */
    @JsonProperty("txtTainoJokyo")
    public void setTxtTainoJokyo(ButtonDialog txtTainoJokyo) {
        this.txtTainoJokyo = txtTainoJokyo;
    }

    /*
     * gettxtZenkaiKikanKaishiYMD
     * @return txtZenkaiKikanKaishiYMD
     */
    @JsonProperty("txtZenkaiKikanKaishiYMD")
    public TextBoxFlexibleDate getTxtZenkaiKikanKaishiYMD() {
        return txtZenkaiKikanKaishiYMD;
    }

    /*
     * settxtZenkaiKikanKaishiYMD
     * @param txtZenkaiKikanKaishiYMD txtZenkaiKikanKaishiYMD
     */
    @JsonProperty("txtZenkaiKikanKaishiYMD")
    public void setTxtZenkaiKikanKaishiYMD(TextBoxFlexibleDate txtZenkaiKikanKaishiYMD) {
        this.txtZenkaiKikanKaishiYMD = txtZenkaiKikanKaishiYMD;
    }

    /*
     * gettxtZenkaiKikanShuryoYMD
     * @return txtZenkaiKikanShuryoYMD
     */
    @JsonProperty("txtZenkaiKikanShuryoYMD")
    public TextBoxFlexibleDate getTxtZenkaiKikanShuryoYMD() {
        return txtZenkaiKikanShuryoYMD;
    }

    /*
     * settxtZenkaiKikanShuryoYMD
     * @param txtZenkaiKikanShuryoYMD txtZenkaiKikanShuryoYMD
     */
    @JsonProperty("txtZenkaiKikanShuryoYMD")
    public void setTxtZenkaiKikanShuryoYMD(TextBoxFlexibleDate txtZenkaiKikanShuryoYMD) {
        this.txtZenkaiKikanShuryoYMD = txtZenkaiKikanShuryoYMD;
    }

    /*
     * gettxtGengakuTsuchiHakkoYMD
     * @return txtGengakuTsuchiHakkoYMD
     */
    @JsonProperty("txtGengakuTsuchiHakkoYMD")
    public TextBoxFlexibleDate getTxtGengakuTsuchiHakkoYMD() {
        return txtGengakuTsuchiHakkoYMD;
    }

    /*
     * settxtGengakuTsuchiHakkoYMD
     * @param txtGengakuTsuchiHakkoYMD txtGengakuTsuchiHakkoYMD
     */
    @JsonProperty("txtGengakuTsuchiHakkoYMD")
    public void setTxtGengakuTsuchiHakkoYMD(TextBoxFlexibleDate txtGengakuTsuchiHakkoYMD) {
        this.txtGengakuTsuchiHakkoYMD = txtGengakuTsuchiHakkoYMD;
    }

    /*
     * gettxtKonkaiKikanKaishiYMD
     * @return txtKonkaiKikanKaishiYMD
     */
    @JsonProperty("txtKonkaiKikanKaishiYMD")
    public TextBoxFlexibleDate getTxtKonkaiKikanKaishiYMD() {
        return txtKonkaiKikanKaishiYMD;
    }

    /*
     * settxtKonkaiKikanKaishiYMD
     * @param txtKonkaiKikanKaishiYMD txtKonkaiKikanKaishiYMD
     */
    @JsonProperty("txtKonkaiKikanKaishiYMD")
    public void setTxtKonkaiKikanKaishiYMD(TextBoxFlexibleDate txtKonkaiKikanKaishiYMD) {
        this.txtKonkaiKikanKaishiYMD = txtKonkaiKikanKaishiYMD;
    }

    /*
     * gettxtKonkaiKikanShuryoYMD
     * @return txtKonkaiKikanShuryoYMD
     */
    @JsonProperty("txtKonkaiKikanShuryoYMD")
    public TextBoxFlexibleDate getTxtKonkaiKikanShuryoYMD() {
        return txtKonkaiKikanShuryoYMD;
    }

    /*
     * settxtKonkaiKikanShuryoYMD
     * @param txtKonkaiKikanShuryoYMD txtKonkaiKikanShuryoYMD
     */
    @JsonProperty("txtKonkaiKikanShuryoYMD")
    public void setTxtKonkaiKikanShuryoYMD(TextBoxFlexibleDate txtKonkaiKikanShuryoYMD) {
        this.txtKonkaiKikanShuryoYMD = txtKonkaiKikanShuryoYMD;
    }

    /*
     * getbtnKakutei
     * @return btnKakutei
     */
    @JsonProperty("btnKakutei")
    public Button getBtnKakutei() {
        return btnKakutei;
    }

    /*
     * setbtnKakutei
     * @param btnKakutei btnKakutei
     */
    @JsonProperty("btnKakutei")
    public void setBtnKakutei(Button btnKakutei) {
        this.btnKakutei = btnKakutei;
    }

    /*
     * getbtnTorikeshi
     * @return btnTorikeshi
     */
    @JsonProperty("btnTorikeshi")
    public Button getBtnTorikeshi() {
        return btnTorikeshi;
    }

    /*
     * setbtnTorikeshi
     * @param btnTorikeshi btnTorikeshi
     */
    @JsonProperty("btnTorikeshi")
    public void setBtnTorikeshi(Button btnTorikeshi) {
        this.btnTorikeshi = btnTorikeshi;
    }

    // </editor-fold>
}
