package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2710002;
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
 * TokuchoDoteiKohoshaShosai のクラスファイル 
 * 
 * @author 自動生成
 */
public class TokuchoDoteiKohoshaShosaiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("AtenaInfo")
    private AtenaInfoDiv AtenaInfo;
    @JsonProperty("KaigoShikakuInfo")
    private KaigoShikakuInfoDiv KaigoShikakuInfo;
    @JsonProperty("TorokuZumiNenkinInfo")
    private TorokuZumiNenkinInfoDiv TorokuZumiNenkinInfo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getAtenaInfo
     * @return AtenaInfo
     */
    @JsonProperty("AtenaInfo")
    public AtenaInfoDiv getAtenaInfo() {
        return AtenaInfo;
    }

    /*
     * setAtenaInfo
     * @param AtenaInfo AtenaInfo
     */
    @JsonProperty("AtenaInfo")
    public void setAtenaInfo(AtenaInfoDiv AtenaInfo) {
        this.AtenaInfo = AtenaInfo;
    }

    /*
     * getKaigoShikakuInfo
     * @return KaigoShikakuInfo
     */
    @JsonProperty("KaigoShikakuInfo")
    public KaigoShikakuInfoDiv getKaigoShikakuInfo() {
        return KaigoShikakuInfo;
    }

    /*
     * setKaigoShikakuInfo
     * @param KaigoShikakuInfo KaigoShikakuInfo
     */
    @JsonProperty("KaigoShikakuInfo")
    public void setKaigoShikakuInfo(KaigoShikakuInfoDiv KaigoShikakuInfo) {
        this.KaigoShikakuInfo = KaigoShikakuInfo;
    }

    /*
     * getTorokuZumiNenkinInfo
     * @return TorokuZumiNenkinInfo
     */
    @JsonProperty("TorokuZumiNenkinInfo")
    public TorokuZumiNenkinInfoDiv getTorokuZumiNenkinInfo() {
        return TorokuZumiNenkinInfo;
    }

    /*
     * setTorokuZumiNenkinInfo
     * @param TorokuZumiNenkinInfo TorokuZumiNenkinInfo
     */
    @JsonProperty("TorokuZumiNenkinInfo")
    public void setTorokuZumiNenkinInfo(TorokuZumiNenkinInfoDiv TorokuZumiNenkinInfo) {
        this.TorokuZumiNenkinInfo = TorokuZumiNenkinInfo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBox getTxtShikibetsuCode() {
        return this.getAtenaInfo().getTxtShikibetsuCode();
    }

    @JsonIgnore
    public void  setTxtShikibetsuCode(TextBox txtShikibetsuCode) {
        this.getAtenaInfo().setTxtShikibetsuCode(txtShikibetsuCode);
    }

    @JsonIgnore
    public TextBox getTxtAtenaShimeiKana() {
        return this.getAtenaInfo().getTxtAtenaShimeiKana();
    }

    @JsonIgnore
    public void  setTxtAtenaShimeiKana(TextBox txtAtenaShimeiKana) {
        this.getAtenaInfo().setTxtAtenaShimeiKana(txtAtenaShimeiKana);
    }

    @JsonIgnore
    public TextBoxDate getTxtAtenaUmareYMD() {
        return this.getAtenaInfo().getTxtAtenaUmareYMD();
    }

    @JsonIgnore
    public void  setTxtAtenaUmareYMD(TextBoxDate txtAtenaUmareYMD) {
        this.getAtenaInfo().setTxtAtenaUmareYMD(txtAtenaUmareYMD);
    }

    @JsonIgnore
    public TextBox getTxtJuminshu() {
        return this.getAtenaInfo().getTxtJuminshu();
    }

    @JsonIgnore
    public void  setTxtJuminshu(TextBox txtJuminshu) {
        this.getAtenaInfo().setTxtJuminshu(txtJuminshu);
    }

    @JsonIgnore
    public TextBox getTxtAtenaShimeiKanji() {
        return this.getAtenaInfo().getTxtAtenaShimeiKanji();
    }

    @JsonIgnore
    public void  setTxtAtenaShimeiKanji(TextBox txtAtenaShimeiKanji) {
        this.getAtenaInfo().setTxtAtenaShimeiKanji(txtAtenaShimeiKanji);
    }

    @JsonIgnore
    public TextBox getTxtAtenaSebetsu() {
        return this.getAtenaInfo().getTxtAtenaSebetsu();
    }

    @JsonIgnore
    public void  setTxtAtenaSebetsu(TextBox txtAtenaSebetsu) {
        this.getAtenaInfo().setTxtAtenaSebetsu(txtAtenaSebetsu);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtJutoYMD() {
        return this.getAtenaInfo().getTxtJutoYMD();
    }

    @JsonIgnore
    public void  setTxtJutoYMD(TextBoxFlexibleDate txtJutoYMD) {
        this.getAtenaInfo().setTxtJutoYMD(txtJutoYMD);
    }

    @JsonIgnore
    public TextBox getTxtAtenaJushoKana() {
        return this.getAtenaInfo().getTxtAtenaJushoKana();
    }

    @JsonIgnore
    public void  setTxtAtenaJushoKana(TextBox txtAtenaJushoKana) {
        this.getAtenaInfo().setTxtAtenaJushoKana(txtAtenaJushoKana);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShojoYMD() {
        return this.getAtenaInfo().getTxtShojoYMD();
    }

    @JsonIgnore
    public void  setTxtShojoYMD(TextBoxFlexibleDate txtShojoYMD) {
        this.getAtenaInfo().setTxtShojoYMD(txtShojoYMD);
    }

    @JsonIgnore
    public TextBox getTxtAtenaJushoKanji() {
        return this.getAtenaInfo().getTxtAtenaJushoKanji();
    }

    @JsonIgnore
    public void  setTxtAtenaJushoKanji(TextBox txtAtenaJushoKanji) {
        this.getAtenaInfo().setTxtAtenaJushoKanji(txtAtenaJushoKanji);
    }

    @JsonIgnore
    public TextBox getTxtHihokenshaNo() {
        return this.getKaigoShikakuInfo().getTxtHihokenshaNo();
    }

    @JsonIgnore
    public void  setTxtHihokenshaNo(TextBox txtHihokenshaNo) {
        this.getKaigoShikakuInfo().setTxtHihokenshaNo(txtHihokenshaNo);
    }

    @JsonIgnore
    public TextBoxDate getTxtShutokuYMD() {
        return this.getKaigoShikakuInfo().getTxtShutokuYMD();
    }

    @JsonIgnore
    public void  setTxtShutokuYMD(TextBoxDate txtShutokuYMD) {
        this.getKaigoShikakuInfo().setTxtShutokuYMD(txtShutokuYMD);
    }

    @JsonIgnore
    public TextBox getTxtShutokuJiyu() {
        return this.getKaigoShikakuInfo().getTxtShutokuJiyu();
    }

    @JsonIgnore
    public void  setTxtShutokuJiyu(TextBox txtShutokuJiyu) {
        this.getKaigoShikakuInfo().setTxtShutokuJiyu(txtShutokuJiyu);
    }

    @JsonIgnore
    public TextBoxDate getTxtSoshitsuYMD() {
        return this.getKaigoShikakuInfo().getTxtSoshitsuYMD();
    }

    @JsonIgnore
    public void  setTxtSoshitsuYMD(TextBoxDate txtSoshitsuYMD) {
        this.getKaigoShikakuInfo().setTxtSoshitsuYMD(txtSoshitsuYMD);
    }

    @JsonIgnore
    public TextBox getTxtSoshitsuJiyu() {
        return this.getKaigoShikakuInfo().getTxtSoshitsuJiyu();
    }

    @JsonIgnore
    public void  setTxtSoshitsuJiyu(TextBox txtSoshitsuJiyu) {
        this.getKaigoShikakuInfo().setTxtSoshitsuJiyu(txtSoshitsuJiyu);
    }

    @JsonIgnore
    public ButtonDialog getBtnHihokenshaFinder() {
        return this.getKaigoShikakuInfo().getBtnHihokenshaFinder();
    }

    @JsonIgnore
    public void  setBtnHihokenshaFinder(ButtonDialog btnHihokenshaFinder) {
        this.getKaigoShikakuInfo().setBtnHihokenshaFinder(btnHihokenshaFinder);
    }

    @JsonIgnore
    public TextBox getTxtTorokuZumiKisoNenkinNo() {
        return this.getTorokuZumiNenkinInfo().getTxtTorokuZumiKisoNenkinNo();
    }

    @JsonIgnore
    public void  setTxtTorokuZumiKisoNenkinNo(TextBox txtTorokuZumiKisoNenkinNo) {
        this.getTorokuZumiNenkinInfo().setTxtTorokuZumiKisoNenkinNo(txtTorokuZumiKisoNenkinNo);
    }

    @JsonIgnore
    public TextBox getTxtTorokuZumiNenkinCode() {
        return this.getTorokuZumiNenkinInfo().getTxtTorokuZumiNenkinCode();
    }

    @JsonIgnore
    public void  setTxtTorokuZumiNenkinCode(TextBox txtTorokuZumiNenkinCode) {
        this.getTorokuZumiNenkinInfo().setTxtTorokuZumiNenkinCode(txtTorokuZumiNenkinCode);
    }

    @JsonIgnore
    public TextBox getTxtTorokuZumiTokuchoGimusha() {
        return this.getTorokuZumiNenkinInfo().getTxtTorokuZumiTokuchoGimusha();
    }

    @JsonIgnore
    public void  setTxtTorokuZumiTokuchoGimusha(TextBox txtTorokuZumiTokuchoGimusha) {
        this.getTorokuZumiNenkinInfo().setTxtTorokuZumiTokuchoGimusha(txtTorokuZumiTokuchoGimusha);
    }

    // </editor-fold>
}
