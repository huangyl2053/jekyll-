package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0510011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * tabShomeishoJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class tabShomeishoJohoDiv extends TabPanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShomeishoNaiyo")
    private ShomeishoNaiyoDiv ShomeishoNaiyo;
    @JsonProperty("KyokaisoGaitouSochiNaiyo")
    private KyokaisoGaitouSochiNaiyoDiv KyokaisoGaitouSochiNaiyo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShomeishoNaiyo
     * @return ShomeishoNaiyo
     */
    @JsonProperty("ShomeishoNaiyo")
    public ShomeishoNaiyoDiv getShomeishoNaiyo() {
        return ShomeishoNaiyo;
    }

    /*
     * setShomeishoNaiyo
     * @param ShomeishoNaiyo ShomeishoNaiyo
     */
    @JsonProperty("ShomeishoNaiyo")
    public void setShomeishoNaiyo(ShomeishoNaiyoDiv ShomeishoNaiyo) {
        this.ShomeishoNaiyo = ShomeishoNaiyo;
    }

    /*
     * getKyokaisoGaitouSochiNaiyo
     * @return KyokaisoGaitouSochiNaiyo
     */
    @JsonProperty("KyokaisoGaitouSochiNaiyo")
    public KyokaisoGaitouSochiNaiyoDiv getKyokaisoGaitouSochiNaiyo() {
        return KyokaisoGaitouSochiNaiyo;
    }

    /*
     * setKyokaisoGaitouSochiNaiyo
     * @param KyokaisoGaitouSochiNaiyo KyokaisoGaitouSochiNaiyo
     */
    @JsonProperty("KyokaisoGaitouSochiNaiyo")
    public void setKyokaisoGaitouSochiNaiyo(KyokaisoGaitouSochiNaiyoDiv KyokaisoGaitouSochiNaiyo) {
        this.KyokaisoGaitouSochiNaiyo = KyokaisoGaitouSochiNaiyo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxDate getTxtShiseiHaishibi() {
        return this.getShomeishoNaiyo().getTxtShiseiHaishibi();
    }

    @JsonIgnore
    public void  setTxtShiseiHaishibi(TextBoxDate txtShiseiHaishibi) {
        this.getShomeishoNaiyo().setTxtShiseiHaishibi(txtShiseiHaishibi);
    }

    @JsonIgnore
    public TextBoxNum getTxtHogoFuyoKonshoGengakuKingaku() {
        return this.getShomeishoNaiyo().getTxtHogoFuyoKonshoGengakuKingaku();
    }

    @JsonIgnore
    public void  setTxtHogoFuyoKonshoGengakuKingaku(TextBoxNum txtHogoFuyoKonshoGengakuKingaku) {
        this.getShomeishoNaiyo().setTxtHogoFuyoKonshoGengakuKingaku(txtHogoFuyoKonshoGengakuKingaku);
    }

    @JsonIgnore
    public TextBoxDate getTxtShomeishoKoufuDate() {
        return this.getShomeishoNaiyo().getTxtShomeishoKoufuDate();
    }

    @JsonIgnore
    public void  setTxtShomeishoKoufuDate(TextBoxDate txtShomeishoKoufuDate) {
        this.getShomeishoNaiyo().setTxtShomeishoKoufuDate(txtShomeishoKoufuDate);
    }

    @JsonIgnore
    public TextBoxNum getTxtKyufugakuJikoFutanGetsugaku() {
        return this.getKyokaisoGaitouSochiNaiyo().getTxtKyufugakuJikoFutanGetsugaku();
    }

    @JsonIgnore
    public void  setTxtKyufugakuJikoFutanGetsugaku(TextBoxNum txtKyufugakuJikoFutanGetsugaku) {
        this.getKyokaisoGaitouSochiNaiyo().setTxtKyufugakuJikoFutanGetsugaku(txtKyufugakuJikoFutanGetsugaku);
    }

    @JsonIgnore
    public DropDownList getDdlKyojuhiGendogakuDankai() {
        return this.getKyokaisoGaitouSochiNaiyo().getDdlKyojuhiGendogakuDankai();
    }

    @JsonIgnore
    public void  setDdlKyojuhiGendogakuDankai(DropDownList ddlKyojuhiGendogakuDankai) {
        this.getKyokaisoGaitouSochiNaiyo().setDdlKyojuhiGendogakuDankai(ddlKyojuhiGendogakuDankai);
    }

    @JsonIgnore
    public TextBoxNum getTxtKyojuhiJikoFutanGetsugaku() {
        return this.getKyokaisoGaitouSochiNaiyo().getTxtKyojuhiJikoFutanGetsugaku();
    }

    @JsonIgnore
    public void  setTxtKyojuhiJikoFutanGetsugaku(TextBoxNum txtKyojuhiJikoFutanGetsugaku) {
        this.getKyokaisoGaitouSochiNaiyo().setTxtKyojuhiJikoFutanGetsugaku(txtKyojuhiJikoFutanGetsugaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtShokuhiJikoFutanGetsugaku() {
        return this.getKyokaisoGaitouSochiNaiyo().getTxtShokuhiJikoFutanGetsugaku();
    }

    @JsonIgnore
    public void  setTxtShokuhiJikoFutanGetsugaku(TextBoxNum txtShokuhiJikoFutanGetsugaku) {
        this.getKyokaisoGaitouSochiNaiyo().setTxtShokuhiJikoFutanGetsugaku(txtShokuhiJikoFutanGetsugaku);
    }

    @JsonIgnore
    public DropDownList getDdlShokuhiGakenFutanGendogakuDankai() {
        return this.getKyokaisoGaitouSochiNaiyo().getDdlShokuhiGakenFutanGendogakuDankai();
    }

    @JsonIgnore
    public void  setDdlShokuhiGakenFutanGendogakuDankai(DropDownList ddlShokuhiGakenFutanGendogakuDankai) {
        this.getKyokaisoGaitouSochiNaiyo().setDdlShokuhiGakenFutanGendogakuDankai(ddlShokuhiGakenFutanGendogakuDankai);
    }

    @JsonIgnore
    public TextBoxNum getTxtKaigoHokenryoJikoFutanGetsugaku() {
        return this.getKyokaisoGaitouSochiNaiyo().getTxtKaigoHokenryoJikoFutanGetsugaku();
    }

    @JsonIgnore
    public void  setTxtKaigoHokenryoJikoFutanGetsugaku(TextBoxNum txtKaigoHokenryoJikoFutanGetsugaku) {
        this.getKyokaisoGaitouSochiNaiyo().setTxtKaigoHokenryoJikoFutanGetsugaku(txtKaigoHokenryoJikoFutanGetsugaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyoshaFutanSeidaiGokeigaku() {
        return this.getKyokaisoGaitouSochiNaiyo().getTxtRiyoshaFutanSeidaiGokeigaku();
    }

    @JsonIgnore
    public void  setTxtRiyoshaFutanSeidaiGokeigaku(TextBoxNum txtRiyoshaFutanSeidaiGokeigaku) {
        this.getKyokaisoGaitouSochiNaiyo().setTxtRiyoshaFutanSeidaiGokeigaku(txtRiyoshaFutanSeidaiGokeigaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtJikoFutanGetsugakuGokeigaku() {
        return this.getKyokaisoGaitouSochiNaiyo().getTxtJikoFutanGetsugakuGokeigaku();
    }

    @JsonIgnore
    public void  setTxtJikoFutanGetsugakuGokeigaku(TextBoxNum txtJikoFutanGetsugakuGokeigaku) {
        this.getKyokaisoGaitouSochiNaiyo().setTxtJikoFutanGetsugakuGokeigaku(txtJikoFutanGetsugakuGokeigaku);
    }

    // </editor-fold>
}
