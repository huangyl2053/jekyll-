package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1090001;
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
 * FutanGendogakuNinteiHedda のクラスファイル 
 * 
 * @author 自動生成
 */
public class FutanGendogakuNinteiHeddaDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("FutanGendogakuNinteiNkami")
    private FutanGendogakuNinteiNkamiDiv FutanGendogakuNinteiNkami;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getFutanGendogakuNinteiNkami
     * @return FutanGendogakuNinteiNkami
     */
    @JsonProperty("FutanGendogakuNinteiNkami")
    public FutanGendogakuNinteiNkamiDiv getFutanGendogakuNinteiNkami() {
        return FutanGendogakuNinteiNkami;
    }

    /*
     * setFutanGendogakuNinteiNkami
     * @param FutanGendogakuNinteiNkami FutanGendogakuNinteiNkami
     */
    @JsonProperty("FutanGendogakuNinteiNkami")
    public void setFutanGendogakuNinteiNkami(FutanGendogakuNinteiNkamiDiv FutanGendogakuNinteiNkami) {
        this.FutanGendogakuNinteiNkami = FutanGendogakuNinteiNkami;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblNaiyou() {
        return this.getFutanGendogakuNinteiNkami().getLblNaiyou();
    }

    @JsonIgnore
    public void  setLblNaiyou(Label lblNaiyou) {
        this.getFutanGendogakuNinteiNkami().setLblNaiyou(lblNaiyou);
    }

    @JsonIgnore
    public HorizontalLine getLineHorizontal2() {
        return this.getFutanGendogakuNinteiNkami().getLineHorizontal2();
    }

    @JsonIgnore
    public void  setLineHorizontal2(HorizontalLine LineHorizontal2) {
        this.getFutanGendogakuNinteiNkami().setLineHorizontal2(LineHorizontal2);
    }

    @JsonIgnore
    public TextBox getTxtKeqteiKubunn() {
        return this.getFutanGendogakuNinteiNkami().getTxtKeqteiKubunn();
    }

    @JsonIgnore
    public void  setTxtKeqteiKubunn(TextBox txtKeqteiKubunn) {
        this.getFutanGendogakuNinteiNkami().setTxtKeqteiKubunn(txtKeqteiKubunn);
    }

    @JsonIgnore
    public TextBox getTxtSinnseiRiyuu() {
        return this.getFutanGendogakuNinteiNkami().getTxtSinnseiRiyuu();
    }

    @JsonIgnore
    public void  setTxtSinnseiRiyuu(TextBox txtSinnseiRiyuu) {
        this.getFutanGendogakuNinteiNkami().setTxtSinnseiRiyuu(txtSinnseiRiyuu);
    }

    @JsonIgnore
    public TextBoxDate getTxtSinnseiDate() {
        return this.getFutanGendogakuNinteiNkami().getTxtSinnseiDate();
    }

    @JsonIgnore
    public void  setTxtSinnseiDate(TextBoxDate txtSinnseiDate) {
        this.getFutanGendogakuNinteiNkami().setTxtSinnseiDate(txtSinnseiDate);
    }

    @JsonIgnore
    public TextBox getTxtFutanDankai() {
        return this.getFutanGendogakuNinteiNkami().getTxtFutanDankai();
    }

    @JsonIgnore
    public void  setTxtFutanDankai(TextBox txtFutanDankai) {
        this.getFutanGendogakuNinteiNkami().setTxtFutanDankai(txtFutanDankai);
    }

    @JsonIgnore
    public TextBox getTxtKyusoti() {
        return this.getFutanGendogakuNinteiNkami().getTxtKyusoti();
    }

    @JsonIgnore
    public void  setTxtKyusoti(TextBox txtKyusoti) {
        this.getFutanGendogakuNinteiNkami().setTxtKyusoti(txtKyusoti);
    }

    @JsonIgnore
    public TextBox getTxtKyoukaiso() {
        return this.getFutanGendogakuNinteiNkami().getTxtKyoukaiso();
    }

    @JsonIgnore
    public void  setTxtKyoukaiso(TextBox txtKyoukaiso) {
        this.getFutanGendogakuNinteiNkami().setTxtKyoukaiso(txtKyoukaiso);
    }

    @JsonIgnore
    public TextBox getTxtGekihenKanwa() {
        return this.getFutanGendogakuNinteiNkami().getTxtGekihenKanwa();
    }

    @JsonIgnore
    public void  setTxtGekihenKanwa(TextBox txtGekihenKanwa) {
        this.getFutanGendogakuNinteiNkami().setTxtGekihenKanwa(txtGekihenKanwa);
    }

    @JsonIgnore
    public TextBoxDate getTxtKeqteiDate() {
        return this.getFutanGendogakuNinteiNkami().getTxtKeqteiDate();
    }

    @JsonIgnore
    public void  setTxtKeqteiDate(TextBoxDate txtKeqteiDate) {
        this.getFutanGendogakuNinteiNkami().setTxtKeqteiDate(txtKeqteiDate);
    }

    @JsonIgnore
    public Label getLblFutanGendogaku() {
        return this.getFutanGendogakuNinteiNkami().getLblFutanGendogaku();
    }

    @JsonIgnore
    public void  setLblFutanGendogaku(Label lblFutanGendogaku) {
        this.getFutanGendogakuNinteiNkami().setLblFutanGendogaku(lblFutanGendogaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtShokuhiNum() {
        return this.getFutanGendogakuNinteiNkami().getTxtShokuhiNum();
    }

    @JsonIgnore
    public void  setTxtShokuhiNum(TextBoxNum txtShokuhiNum) {
        this.getFutanGendogakuNinteiNkami().setTxtShokuhiNum(txtShokuhiNum);
    }

    @JsonIgnore
    public TextBoxDate getTxtTekiyouDate() {
        return this.getFutanGendogakuNinteiNkami().getTxtTekiyouDate();
    }

    @JsonIgnore
    public void  setTxtTekiyouDate(TextBoxDate txtTekiyouDate) {
        this.getFutanGendogakuNinteiNkami().setTxtTekiyouDate(txtTekiyouDate);
    }

    @JsonIgnore
    public TextBoxNum getTxtYunittoketaKoshitsuNum() {
        return this.getFutanGendogakuNinteiNkami().getTxtYunittoketaKoshitsuNum();
    }

    @JsonIgnore
    public void  setTxtYunittoketaKoshitsuNum(TextBoxNum txtYunittoketaKoshitsuNum) {
        this.getFutanGendogakuNinteiNkami().setTxtYunittoketaKoshitsuNum(txtYunittoketaKoshitsuNum);
    }

    @JsonIgnore
    public TextBoxNum getTxtYunittoketaJyunKoshitsuNum() {
        return this.getFutanGendogakuNinteiNkami().getTxtYunittoketaJyunKoshitsuNum();
    }

    @JsonIgnore
    public void  setTxtYunittoketaJyunKoshitsuNum(TextBoxNum txtYunittoketaJyunKoshitsuNum) {
        this.getFutanGendogakuNinteiNkami().setTxtYunittoketaJyunKoshitsuNum(txtYunittoketaJyunKoshitsuNum);
    }

    @JsonIgnore
    public TextBoxDate getTxtYuukouKigenDate() {
        return this.getFutanGendogakuNinteiNkami().getTxtYuukouKigenDate();
    }

    @JsonIgnore
    public void  setTxtYuukouKigenDate(TextBoxDate txtYuukouKigenDate) {
        this.getFutanGendogakuNinteiNkami().setTxtYuukouKigenDate(txtYuukouKigenDate);
    }

    @JsonIgnore
    public TextBoxNum getTxtJuuraiKoshitsuTNum() {
        return this.getFutanGendogakuNinteiNkami().getTxtJuuraiKoshitsuTNum();
    }

    @JsonIgnore
    public void  setTxtJuuraiKoshitsuTNum(TextBoxNum txtJuuraiKoshitsuTNum) {
        this.getFutanGendogakuNinteiNkami().setTxtJuuraiKoshitsuTNum(txtJuuraiKoshitsuTNum);
    }

    @JsonIgnore
    public TextBoxNum getTxtJuuraiKoshitsuLNum() {
        return this.getFutanGendogakuNinteiNkami().getTxtJuuraiKoshitsuLNum();
    }

    @JsonIgnore
    public void  setTxtJuuraiKoshitsuLNum(TextBoxNum txtJuuraiKoshitsuLNum) {
        this.getFutanGendogakuNinteiNkami().setTxtJuuraiKoshitsuLNum(txtJuuraiKoshitsuLNum);
    }

    @JsonIgnore
    public TextBoxNum getTxtTkutokosituNum() {
        return this.getFutanGendogakuNinteiNkami().getTxtTkutokosituNum();
    }

    @JsonIgnore
    public void  setTxtTkutokosituNum(TextBoxNum txtTkutokosituNum) {
        this.getFutanGendogakuNinteiNkami().setTxtTkutokosituNum(txtTkutokosituNum);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtFushouninRiyuLine() {
        return this.getFutanGendogakuNinteiNkami().getTxtFushouninRiyuLine();
    }

    @JsonIgnore
    public void  setTxtFushouninRiyuLine(TextBoxMultiLine txtFushouninRiyuLine) {
        this.getFutanGendogakuNinteiNkami().setTxtFushouninRiyuLine(txtFushouninRiyuLine);
    }

    // </editor-fold>
}
