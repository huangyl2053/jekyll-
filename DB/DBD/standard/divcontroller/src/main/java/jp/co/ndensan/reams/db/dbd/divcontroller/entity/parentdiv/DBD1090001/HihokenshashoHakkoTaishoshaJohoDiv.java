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
 * HihokenshashoHakkoTaishoshaJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class HihokenshashoHakkoTaishoshaJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("TsuchishoSakuseiKobetsu")
    private TsuchishoSakuseiKobetsuDiv TsuchishoSakuseiKobetsu;
    @JsonProperty("FutanGendogakuNinteiHedda")
    private FutanGendogakuNinteiHeddaDiv FutanGendogakuNinteiHedda;
    @JsonProperty("ZengoRireki")
    private ZengoRirekiDiv ZengoRireki;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getTsuchishoSakuseiKobetsu
     * @return TsuchishoSakuseiKobetsu
     */
    @JsonProperty("TsuchishoSakuseiKobetsu")
    public TsuchishoSakuseiKobetsuDiv getTsuchishoSakuseiKobetsu() {
        return TsuchishoSakuseiKobetsu;
    }

    /*
     * setTsuchishoSakuseiKobetsu
     * @param TsuchishoSakuseiKobetsu TsuchishoSakuseiKobetsu
     */
    @JsonProperty("TsuchishoSakuseiKobetsu")
    public void setTsuchishoSakuseiKobetsu(TsuchishoSakuseiKobetsuDiv TsuchishoSakuseiKobetsu) {
        this.TsuchishoSakuseiKobetsu = TsuchishoSakuseiKobetsu;
    }

    /*
     * getFutanGendogakuNinteiHedda
     * @return FutanGendogakuNinteiHedda
     */
    @JsonProperty("FutanGendogakuNinteiHedda")
    public FutanGendogakuNinteiHeddaDiv getFutanGendogakuNinteiHedda() {
        return FutanGendogakuNinteiHedda;
    }

    /*
     * setFutanGendogakuNinteiHedda
     * @param FutanGendogakuNinteiHedda FutanGendogakuNinteiHedda
     */
    @JsonProperty("FutanGendogakuNinteiHedda")
    public void setFutanGendogakuNinteiHedda(FutanGendogakuNinteiHeddaDiv FutanGendogakuNinteiHedda) {
        this.FutanGendogakuNinteiHedda = FutanGendogakuNinteiHedda;
    }

    /*
     * getZengoRireki
     * @return ZengoRireki
     */
    @JsonProperty("ZengoRireki")
    public ZengoRirekiDiv getZengoRireki() {
        return ZengoRireki;
    }

    /*
     * setZengoRireki
     * @param ZengoRireki ZengoRireki
     */
    @JsonProperty("ZengoRireki")
    public void setZengoRireki(ZengoRirekiDiv ZengoRireki) {
        this.ZengoRireki = ZengoRireki;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblNaiyou() {
        return this.getFutanGendogakuNinteiHedda().getFutanGendogakuNinteiNkami().getLblNaiyou();
    }

    @JsonIgnore
    public void  setLblNaiyou(Label lblNaiyou) {
        this.getFutanGendogakuNinteiHedda().getFutanGendogakuNinteiNkami().setLblNaiyou(lblNaiyou);
    }

    @JsonIgnore
    public HorizontalLine getLineHorizontal2() {
        return this.getFutanGendogakuNinteiHedda().getFutanGendogakuNinteiNkami().getLineHorizontal2();
    }

    @JsonIgnore
    public void  setLineHorizontal2(HorizontalLine LineHorizontal2) {
        this.getFutanGendogakuNinteiHedda().getFutanGendogakuNinteiNkami().setLineHorizontal2(LineHorizontal2);
    }

    @JsonIgnore
    public TextBox getTxtKeqteiKubunn() {
        return this.getFutanGendogakuNinteiHedda().getFutanGendogakuNinteiNkami().getTxtKeqteiKubunn();
    }

    @JsonIgnore
    public void  setTxtKeqteiKubunn(TextBox txtKeqteiKubunn) {
        this.getFutanGendogakuNinteiHedda().getFutanGendogakuNinteiNkami().setTxtKeqteiKubunn(txtKeqteiKubunn);
    }

    @JsonIgnore
    public TextBox getTxtSinnseiRiyuu() {
        return this.getFutanGendogakuNinteiHedda().getFutanGendogakuNinteiNkami().getTxtSinnseiRiyuu();
    }

    @JsonIgnore
    public void  setTxtSinnseiRiyuu(TextBox txtSinnseiRiyuu) {
        this.getFutanGendogakuNinteiHedda().getFutanGendogakuNinteiNkami().setTxtSinnseiRiyuu(txtSinnseiRiyuu);
    }

    @JsonIgnore
    public TextBoxDate getTxtSinnseiDate() {
        return this.getFutanGendogakuNinteiHedda().getFutanGendogakuNinteiNkami().getTxtSinnseiDate();
    }

    @JsonIgnore
    public void  setTxtSinnseiDate(TextBoxDate txtSinnseiDate) {
        this.getFutanGendogakuNinteiHedda().getFutanGendogakuNinteiNkami().setTxtSinnseiDate(txtSinnseiDate);
    }

    @JsonIgnore
    public TextBox getTxtFutanDankai() {
        return this.getFutanGendogakuNinteiHedda().getFutanGendogakuNinteiNkami().getTxtFutanDankai();
    }

    @JsonIgnore
    public void  setTxtFutanDankai(TextBox txtFutanDankai) {
        this.getFutanGendogakuNinteiHedda().getFutanGendogakuNinteiNkami().setTxtFutanDankai(txtFutanDankai);
    }

    @JsonIgnore
    public TextBox getTxtKyusoti() {
        return this.getFutanGendogakuNinteiHedda().getFutanGendogakuNinteiNkami().getTxtKyusoti();
    }

    @JsonIgnore
    public void  setTxtKyusoti(TextBox txtKyusoti) {
        this.getFutanGendogakuNinteiHedda().getFutanGendogakuNinteiNkami().setTxtKyusoti(txtKyusoti);
    }

    @JsonIgnore
    public TextBox getTxtKyoukaiso() {
        return this.getFutanGendogakuNinteiHedda().getFutanGendogakuNinteiNkami().getTxtKyoukaiso();
    }

    @JsonIgnore
    public void  setTxtKyoukaiso(TextBox txtKyoukaiso) {
        this.getFutanGendogakuNinteiHedda().getFutanGendogakuNinteiNkami().setTxtKyoukaiso(txtKyoukaiso);
    }

    @JsonIgnore
    public TextBox getTxtGekihenKanwa() {
        return this.getFutanGendogakuNinteiHedda().getFutanGendogakuNinteiNkami().getTxtGekihenKanwa();
    }

    @JsonIgnore
    public void  setTxtGekihenKanwa(TextBox txtGekihenKanwa) {
        this.getFutanGendogakuNinteiHedda().getFutanGendogakuNinteiNkami().setTxtGekihenKanwa(txtGekihenKanwa);
    }

    @JsonIgnore
    public TextBoxDate getTxtKeqteiDate() {
        return this.getFutanGendogakuNinteiHedda().getFutanGendogakuNinteiNkami().getTxtKeqteiDate();
    }

    @JsonIgnore
    public void  setTxtKeqteiDate(TextBoxDate txtKeqteiDate) {
        this.getFutanGendogakuNinteiHedda().getFutanGendogakuNinteiNkami().setTxtKeqteiDate(txtKeqteiDate);
    }

    @JsonIgnore
    public Label getLblFutanGendogaku() {
        return this.getFutanGendogakuNinteiHedda().getFutanGendogakuNinteiNkami().getLblFutanGendogaku();
    }

    @JsonIgnore
    public void  setLblFutanGendogaku(Label lblFutanGendogaku) {
        this.getFutanGendogakuNinteiHedda().getFutanGendogakuNinteiNkami().setLblFutanGendogaku(lblFutanGendogaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtShokuhiNum() {
        return this.getFutanGendogakuNinteiHedda().getFutanGendogakuNinteiNkami().getTxtShokuhiNum();
    }

    @JsonIgnore
    public void  setTxtShokuhiNum(TextBoxNum txtShokuhiNum) {
        this.getFutanGendogakuNinteiHedda().getFutanGendogakuNinteiNkami().setTxtShokuhiNum(txtShokuhiNum);
    }

    @JsonIgnore
    public TextBoxDate getTxtTekiyouDate() {
        return this.getFutanGendogakuNinteiHedda().getFutanGendogakuNinteiNkami().getTxtTekiyouDate();
    }

    @JsonIgnore
    public void  setTxtTekiyouDate(TextBoxDate txtTekiyouDate) {
        this.getFutanGendogakuNinteiHedda().getFutanGendogakuNinteiNkami().setTxtTekiyouDate(txtTekiyouDate);
    }

    @JsonIgnore
    public TextBoxNum getTxtYunittoketaKoshitsuNum() {
        return this.getFutanGendogakuNinteiHedda().getFutanGendogakuNinteiNkami().getTxtYunittoketaKoshitsuNum();
    }

    @JsonIgnore
    public void  setTxtYunittoketaKoshitsuNum(TextBoxNum txtYunittoketaKoshitsuNum) {
        this.getFutanGendogakuNinteiHedda().getFutanGendogakuNinteiNkami().setTxtYunittoketaKoshitsuNum(txtYunittoketaKoshitsuNum);
    }

    @JsonIgnore
    public TextBoxNum getTxtYunittoketaJyunKoshitsuNum() {
        return this.getFutanGendogakuNinteiHedda().getFutanGendogakuNinteiNkami().getTxtYunittoketaJyunKoshitsuNum();
    }

    @JsonIgnore
    public void  setTxtYunittoketaJyunKoshitsuNum(TextBoxNum txtYunittoketaJyunKoshitsuNum) {
        this.getFutanGendogakuNinteiHedda().getFutanGendogakuNinteiNkami().setTxtYunittoketaJyunKoshitsuNum(txtYunittoketaJyunKoshitsuNum);
    }

    @JsonIgnore
    public TextBoxDate getTxtYuukouKigenDate() {
        return this.getFutanGendogakuNinteiHedda().getFutanGendogakuNinteiNkami().getTxtYuukouKigenDate();
    }

    @JsonIgnore
    public void  setTxtYuukouKigenDate(TextBoxDate txtYuukouKigenDate) {
        this.getFutanGendogakuNinteiHedda().getFutanGendogakuNinteiNkami().setTxtYuukouKigenDate(txtYuukouKigenDate);
    }

    @JsonIgnore
    public TextBoxNum getTxtJuuraiKoshitsuTNum() {
        return this.getFutanGendogakuNinteiHedda().getFutanGendogakuNinteiNkami().getTxtJuuraiKoshitsuTNum();
    }

    @JsonIgnore
    public void  setTxtJuuraiKoshitsuTNum(TextBoxNum txtJuuraiKoshitsuTNum) {
        this.getFutanGendogakuNinteiHedda().getFutanGendogakuNinteiNkami().setTxtJuuraiKoshitsuTNum(txtJuuraiKoshitsuTNum);
    }

    @JsonIgnore
    public TextBoxNum getTxtJuuraiKoshitsuLNum() {
        return this.getFutanGendogakuNinteiHedda().getFutanGendogakuNinteiNkami().getTxtJuuraiKoshitsuLNum();
    }

    @JsonIgnore
    public void  setTxtJuuraiKoshitsuLNum(TextBoxNum txtJuuraiKoshitsuLNum) {
        this.getFutanGendogakuNinteiHedda().getFutanGendogakuNinteiNkami().setTxtJuuraiKoshitsuLNum(txtJuuraiKoshitsuLNum);
    }

    @JsonIgnore
    public TextBoxNum getTxtTkutokosituNum() {
        return this.getFutanGendogakuNinteiHedda().getFutanGendogakuNinteiNkami().getTxtTkutokosituNum();
    }

    @JsonIgnore
    public void  setTxtTkutokosituNum(TextBoxNum txtTkutokosituNum) {
        this.getFutanGendogakuNinteiHedda().getFutanGendogakuNinteiNkami().setTxtTkutokosituNum(txtTkutokosituNum);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtFushouninRiyuLine() {
        return this.getFutanGendogakuNinteiHedda().getFutanGendogakuNinteiNkami().getTxtFushouninRiyuLine();
    }

    @JsonIgnore
    public void  setTxtFushouninRiyuLine(TextBoxMultiLine txtFushouninRiyuLine) {
        this.getFutanGendogakuNinteiHedda().getFutanGendogakuNinteiNkami().setTxtFushouninRiyuLine(txtFushouninRiyuLine);
    }

    @JsonIgnore
    public Button getBtnZenRireki() {
        return this.getZengoRireki().getBtnZenRireki();
    }

    @JsonIgnore
    public void  setBtnZenRireki(Button btnZenRireki) {
        this.getZengoRireki().setBtnZenRireki(btnZenRireki);
    }

    @JsonIgnore
    public Button getBtnGoRireki() {
        return this.getZengoRireki().getBtnGoRireki();
    }

    @JsonIgnore
    public void  setBtnGoRireki(Button btnGoRireki) {
        this.getZengoRireki().setBtnGoRireki(btnGoRireki);
    }

    // </editor-fold>
}
