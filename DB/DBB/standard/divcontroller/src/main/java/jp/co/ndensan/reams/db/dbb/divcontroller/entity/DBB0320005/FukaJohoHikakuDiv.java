package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320005;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320005.HonSantei1Div;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320005.HonSantei2Div;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320005.KariSantei1Div;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320005.KariSantei2Div;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320005.zanteihokenryoHeightKari1Div;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320005.zanteihokenryoHeightKari2Div;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.kiwarigaku.IKiwarigakuDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.kiwarigaku.KiwarigakuDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * FukaJohoHikaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class FukaJohoHikakuDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("HonSantei1")
    private HonSantei1Div HonSantei1;
    @JsonProperty("KariSantei1")
    private KariSantei1Div KariSantei1;
    @JsonProperty("KariSantei2")
    private KariSantei2Div KariSantei2;
    @JsonProperty("HonSantei2")
    private HonSantei2Div HonSantei2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("HonSantei1")
    public HonSantei1Div getHonSantei1() {
        return HonSantei1;
    }

    @JsonProperty("HonSantei1")
    public void setHonSantei1(HonSantei1Div HonSantei1) {
        this.HonSantei1=HonSantei1;
    }

    @JsonProperty("KariSantei1")
    public KariSantei1Div getKariSantei1() {
        return KariSantei1;
    }

    @JsonProperty("KariSantei1")
    public void setKariSantei1(KariSantei1Div KariSantei1) {
        this.KariSantei1=KariSantei1;
    }

    @JsonProperty("KariSantei2")
    public KariSantei2Div getKariSantei2() {
        return KariSantei2;
    }

    @JsonProperty("KariSantei2")
    public void setKariSantei2(KariSantei2Div KariSantei2) {
        this.KariSantei2=KariSantei2;
    }

    @JsonProperty("HonSantei2")
    public HonSantei2Div getHonSantei2() {
        return HonSantei2;
    }

    @JsonProperty("HonSantei2")
    public void setHonSantei2(HonSantei2Div HonSantei2) {
        this.HonSantei2=HonSantei2;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblShikakushutokuYMDHon1() {
        return this.getHonSantei1().getFukakijunHon1().getLblShikakushutokuYMDHon1();
    }

    @JsonIgnore
    public void  setLblShikakushutokuYMDHon1(Label lblShikakushutokuYMDHon1) {
        this.getHonSantei1().getFukakijunHon1().setLblShikakushutokuYMDHon1(lblShikakushutokuYMDHon1);
    }

    @JsonIgnore
    public TextBoxDate getTxtShikakuShutokuYMDHon1() {
        return this.getHonSantei1().getFukakijunHon1().getTxtShikakuShutokuYMDHon1();
    }

    @JsonIgnore
    public void  setTxtShikakuShutokuYMDHon1(TextBoxDate txtShikakuShutokuYMDHon1) {
        this.getHonSantei1().getFukakijunHon1().setTxtShikakuShutokuYMDHon1(txtShikakuShutokuYMDHon1);
    }

    @JsonIgnore
    public Label getLblShikakusoshitsuYMDHon1() {
        return this.getHonSantei1().getFukakijunHon1().getLblShikakusoshitsuYMDHon1();
    }

    @JsonIgnore
    public void  setLblShikakusoshitsuYMDHon1(Label lblShikakusoshitsuYMDHon1) {
        this.getHonSantei1().getFukakijunHon1().setLblShikakusoshitsuYMDHon1(lblShikakusoshitsuYMDHon1);
    }

    @JsonIgnore
    public TextBoxDate getTxtShikakusoshitsuYMDHon1() {
        return this.getHonSantei1().getFukakijunHon1().getTxtShikakusoshitsuYMDHon1();
    }

    @JsonIgnore
    public void  setTxtShikakusoshitsuYMDHon1(TextBoxDate txtShikakusoshitsuYMDHon1) {
        this.getHonSantei1().getFukakijunHon1().setTxtShikakusoshitsuYMDHon1(txtShikakusoshitsuYMDHon1);
    }

    @JsonIgnore
    public Label getLblGoukeiShotokuHon1() {
        return this.getHonSantei1().getFukakijunHon1().getLblGoukeiShotokuHon1();
    }

    @JsonIgnore
    public void  setLblGoukeiShotokuHon1(Label lblGoukeiShotokuHon1) {
        this.getHonSantei1().getFukakijunHon1().setLblGoukeiShotokuHon1(lblGoukeiShotokuHon1);
    }

    @JsonIgnore
    public TextBoxNum getTxtGoukeiShotokuHon1() {
        return this.getHonSantei1().getFukakijunHon1().getTxtGoukeiShotokuHon1();
    }

    @JsonIgnore
    public void  setTxtGoukeiShotokuHon1(TextBoxNum txtGoukeiShotokuHon1) {
        this.getHonSantei1().getFukakijunHon1().setTxtGoukeiShotokuHon1(txtGoukeiShotokuHon1);
    }

    @JsonIgnore
    public Label getLblNenkinShunyuHon1() {
        return this.getHonSantei1().getFukakijunHon1().getLblNenkinShunyuHon1();
    }

    @JsonIgnore
    public void  setLblNenkinShunyuHon1(Label lblNenkinShunyuHon1) {
        this.getHonSantei1().getFukakijunHon1().setLblNenkinShunyuHon1(lblNenkinShunyuHon1);
    }

    @JsonIgnore
    public TextBoxNum getTxtNenkinShunyuHon1() {
        return this.getHonSantei1().getFukakijunHon1().getTxtNenkinShunyuHon1();
    }

    @JsonIgnore
    public void  setTxtNenkinShunyuHon1(TextBoxNum txtNenkinShunyuHon1) {
        this.getHonSantei1().getFukakijunHon1().setTxtNenkinShunyuHon1(txtNenkinShunyuHon1);
    }

    @JsonIgnore
    public Label getLblHonninKazeiHon1() {
        return this.getHonSantei1().getFukakijunHon1().getLblHonninKazeiHon1();
    }

    @JsonIgnore
    public void  setLblHonninKazeiHon1(Label lblHonninKazeiHon1) {
        this.getHonSantei1().getFukakijunHon1().setLblHonninKazeiHon1(lblHonninKazeiHon1);
    }

    @JsonIgnore
    public TextBox getTxtHonninKazeiHon1() {
        return this.getHonSantei1().getFukakijunHon1().getTxtHonninKazeiHon1();
    }

    @JsonIgnore
    public void  setTxtHonninKazeiHon1(TextBox txtHonninKazeiHon1) {
        this.getHonSantei1().getFukakijunHon1().setTxtHonninKazeiHon1(txtHonninKazeiHon1);
    }

    @JsonIgnore
    public Label getLblSetaiKazeiHon1() {
        return this.getHonSantei1().getFukakijunHon1().getLblSetaiKazeiHon1();
    }

    @JsonIgnore
    public void  setLblSetaiKazeiHon1(Label lblSetaiKazeiHon1) {
        this.getHonSantei1().getFukakijunHon1().setLblSetaiKazeiHon1(lblSetaiKazeiHon1);
    }

    @JsonIgnore
    public TextBox getTxtSetaiKazeiHon1() {
        return this.getHonSantei1().getFukakijunHon1().getTxtSetaiKazeiHon1();
    }

    @JsonIgnore
    public void  setTxtSetaiKazeiHon1(TextBox txtSetaiKazeiHon1) {
        this.getHonSantei1().getFukakijunHon1().setTxtSetaiKazeiHon1(txtSetaiKazeiHon1);
    }

    @JsonIgnore
    public Label getLblSetaiinSuHon1() {
        return this.getHonSantei1().getFukakijunHon1().getLblSetaiinSuHon1();
    }

    @JsonIgnore
    public void  setLblSetaiinSuHon1(Label lblSetaiinSuHon1) {
        this.getHonSantei1().getFukakijunHon1().setLblSetaiinSuHon1(lblSetaiinSuHon1);
    }

    @JsonIgnore
    public TextBox getTxtSetaiinSuHon1() {
        return this.getHonSantei1().getFukakijunHon1().getTxtSetaiinSuHon1();
    }

    @JsonIgnore
    public void  setTxtSetaiinSuHon1(TextBox txtSetaiinSuHon1) {
        this.getHonSantei1().getFukakijunHon1().setTxtSetaiinSuHon1(txtSetaiinSuHon1);
    }

    @JsonIgnore
    public Label getLblHokenryoDankaiHon1() {
        return this.getHonSantei1().getHokenryoHon1().getLblHokenryoDankaiHon1();
    }

    @JsonIgnore
    public void  setLblHokenryoDankaiHon1(Label lblHokenryoDankaiHon1) {
        this.getHonSantei1().getHokenryoHon1().setLblHokenryoDankaiHon1(lblHokenryoDankaiHon1);
    }

    @JsonIgnore
    public TextBox getTxtHokenryoDankaiHon1() {
        return this.getHonSantei1().getHokenryoHon1().getTxtHokenryoDankaiHon1();
    }

    @JsonIgnore
    public void  setTxtHokenryoDankaiHon1(TextBox txtHokenryoDankaiHon1) {
        this.getHonSantei1().getHokenryoHon1().setTxtHokenryoDankaiHon1(txtHokenryoDankaiHon1);
    }

    @JsonIgnore
    public Label getLblKyokaisoHon1() {
        return this.getHonSantei1().getHokenryoHon1().getLblKyokaisoHon1();
    }

    @JsonIgnore
    public void  setLblKyokaisoHon1(Label lblKyokaisoHon1) {
        this.getHonSantei1().getHokenryoHon1().setLblKyokaisoHon1(lblKyokaisoHon1);
    }

    @JsonIgnore
    public TextBox getTxtKyokaisoHon1() {
        return this.getHonSantei1().getHokenryoHon1().getTxtKyokaisoHon1();
    }

    @JsonIgnore
    public void  setTxtKyokaisoHon1(TextBox txtKyokaisoHon1) {
        this.getHonSantei1().getHokenryoHon1().setTxtKyokaisoHon1(txtKyokaisoHon1);
    }

    @JsonIgnore
    public Label getLblKeisanHokenryogakuHon1() {
        return this.getHonSantei1().getHokenryoHon1().getLblKeisanHokenryogakuHon1();
    }

    @JsonIgnore
    public void  setLblKeisanHokenryogakuHon1(Label lblKeisanHokenryogakuHon1) {
        this.getHonSantei1().getHokenryoHon1().setLblKeisanHokenryogakuHon1(lblKeisanHokenryogakuHon1);
    }

    @JsonIgnore
    public TextBoxNum getTxtKeisanHokenryogakuHon1() {
        return this.getHonSantei1().getHokenryoHon1().getTxtKeisanHokenryogakuHon1();
    }

    @JsonIgnore
    public void  setTxtKeisanHokenryogakuHon1(TextBoxNum txtKeisanHokenryogakuHon1) {
        this.getHonSantei1().getHokenryoHon1().setTxtKeisanHokenryogakuHon1(txtKeisanHokenryogakuHon1);
    }

    @JsonIgnore
    public Label getLblGemmenGakuHon1() {
        return this.getHonSantei1().getHokenryoHon1().getLblGemmenGakuHon1();
    }

    @JsonIgnore
    public void  setLblGemmenGakuHon1(Label lblGemmenGakuHon1) {
        this.getHonSantei1().getHokenryoHon1().setLblGemmenGakuHon1(lblGemmenGakuHon1);
    }

    @JsonIgnore
    public TextBoxNum getTxtGemmenGakuHon1() {
        return this.getHonSantei1().getHokenryoHon1().getTxtGemmenGakuHon1();
    }

    @JsonIgnore
    public void  setTxtGemmenGakuHon1(TextBoxNum txtGemmenGakuHon1) {
        this.getHonSantei1().getHokenryoHon1().setTxtGemmenGakuHon1(txtGemmenGakuHon1);
    }

    @JsonIgnore
    public Label getLblKakuteiHokenryoHon1() {
        return this.getHonSantei1().getHokenryoHon1().getLblKakuteiHokenryoHon1();
    }

    @JsonIgnore
    public void  setLblKakuteiHokenryoHon1(Label lblKakuteiHokenryoHon1) {
        this.getHonSantei1().getHokenryoHon1().setLblKakuteiHokenryoHon1(lblKakuteiHokenryoHon1);
    }

    @JsonIgnore
    public TextBoxNum getTxtKakuteiHokenryoHon1() {
        return this.getHonSantei1().getHokenryoHon1().getTxtKakuteiHokenryoHon1();
    }

    @JsonIgnore
    public void  setTxtKakuteiHokenryoHon1(TextBoxNum txtKakuteiHokenryoHon1) {
        this.getHonSantei1().getHokenryoHon1().setTxtKakuteiHokenryoHon1(txtKakuteiHokenryoHon1);
    }

    @JsonIgnore
    public IKiwarigakuDiv getCcdKiwarigakuHon1() {
        return this.getHonSantei1().getKibetsugakuHon1().getCcdKiwarigakuHon1();
    }

    @JsonIgnore
    public TextBoxDate getTxtShikakuShutokuYMDKari1() {
        return this.getKariSantei1().getFukakijunKari1().getTxtShikakuShutokuYMDKari1();
    }

    @JsonIgnore
    public void  setTxtShikakuShutokuYMDKari1(TextBoxDate txtShikakuShutokuYMDKari1) {
        this.getKariSantei1().getFukakijunKari1().setTxtShikakuShutokuYMDKari1(txtShikakuShutokuYMDKari1);
    }

    @JsonIgnore
    public TextBoxDate getTxtShikakuSoshitsuYMDKari1() {
        return this.getKariSantei1().getFukakijunKari1().getTxtShikakuSoshitsuYMDKari1();
    }

    @JsonIgnore
    public void  setTxtShikakuSoshitsuYMDKari1(TextBoxDate txtShikakuSoshitsuYMDKari1) {
        this.getKariSantei1().getFukakijunKari1().setTxtShikakuSoshitsuYMDKari1(txtShikakuSoshitsuYMDKari1);
    }

    @JsonIgnore
    public TextBox getTxtHokenryoDankaiKari1() {
        return this.getKariSantei1().getZennendoKari1().getTxtHokenryoDankaiKari1();
    }

    @JsonIgnore
    public void  setTxtHokenryoDankaiKari1(TextBox txtHokenryoDankaiKari1) {
        this.getKariSantei1().getZennendoKari1().setTxtHokenryoDankaiKari1(txtHokenryoDankaiKari1);
    }

    @JsonIgnore
    public TextBox getTxtHokenryoRitsuKari1() {
        return this.getKariSantei1().getZennendoKari1().getTxtHokenryoRitsuKari1();
    }

    @JsonIgnore
    public void  setTxtHokenryoRitsuKari1(TextBox txtHokenryoRitsuKari1) {
        this.getKariSantei1().getZennendoKari1().setTxtHokenryoRitsuKari1(txtHokenryoRitsuKari1);
    }

    @JsonIgnore
    public TextBoxNum getTxtNengakuHokenryoKari1() {
        return this.getKariSantei1().getZennendoKari1().getTxtNengakuHokenryoKari1();
    }

    @JsonIgnore
    public void  setTxtNengakuHokenryoKari1(TextBoxNum txtNengakuHokenryoKari1) {
        this.getKariSantei1().getZennendoKari1().setTxtNengakuHokenryoKari1(txtNengakuHokenryoKari1);
    }

    @JsonIgnore
    public TextBoxNum getTxtZanteiKeisanjoHokenryoKari1() {
        return this.getKariSantei1().getHokenryoKari1().getTxtZanteiKeisanjoHokenryoKari1();
    }

    @JsonIgnore
    public void  setTxtZanteiKeisanjoHokenryoKari1(TextBoxNum txtZanteiKeisanjoHokenryoKari1) {
        this.getKariSantei1().getHokenryoKari1().setTxtZanteiKeisanjoHokenryoKari1(txtZanteiKeisanjoHokenryoKari1);
    }

    @JsonIgnore
    public TextBoxNum getTxtGemmenGakuKari1() {
        return this.getKariSantei1().getHokenryoKari1().getTxtGemmenGakuKari1();
    }

    @JsonIgnore
    public void  setTxtGemmenGakuKari1(TextBoxNum txtGemmenGakuKari1) {
        this.getKariSantei1().getHokenryoKari1().setTxtGemmenGakuKari1(txtGemmenGakuKari1);
    }

    @JsonIgnore
    public TextBoxNum getTxtZanteiGoukeiGakuKari1() {
        return this.getKariSantei1().getHokenryoKari1().getTxtZanteiGoukeiGakuKari1();
    }

    @JsonIgnore
    public void  setTxtZanteiGoukeiGakuKari1(TextBoxNum txtZanteiGoukeiGakuKari1) {
        this.getKariSantei1().getHokenryoKari1().setTxtZanteiGoukeiGakuKari1(txtZanteiGoukeiGakuKari1);
    }

    @JsonIgnore
    public zanteihokenryoHeightKari1Div getZanteihokenryoHeightKari1() {
        return this.getKariSantei1().getHokenryoKari1().getZanteihokenryoHeightKari1();
    }

    @JsonIgnore
    public void  setZanteihokenryoHeightKari1(zanteihokenryoHeightKari1Div zanteihokenryoHeightKari1) {
        this.getKariSantei1().getHokenryoKari1().setZanteihokenryoHeightKari1(zanteihokenryoHeightKari1);
    }

    @JsonIgnore
    public IKiwarigakuDiv getCcdKiwarigakuKari1() {
        return this.getKariSantei1().getKibetsugakuKari1().getCcdKiwarigakuKari1();
    }

    @JsonIgnore
    public TextBoxDate getTxtShikakuShutokuYMDKari2() {
        return this.getKariSantei2().getFukakijunKari2().getTxtShikakuShutokuYMDKari2();
    }

    @JsonIgnore
    public void  setTxtShikakuShutokuYMDKari2(TextBoxDate txtShikakuShutokuYMDKari2) {
        this.getKariSantei2().getFukakijunKari2().setTxtShikakuShutokuYMDKari2(txtShikakuShutokuYMDKari2);
    }

    @JsonIgnore
    public TextBoxDate getTxtShikakuSoshitsuYMDKari2() {
        return this.getKariSantei2().getFukakijunKari2().getTxtShikakuSoshitsuYMDKari2();
    }

    @JsonIgnore
    public void  setTxtShikakuSoshitsuYMDKari2(TextBoxDate txtShikakuSoshitsuYMDKari2) {
        this.getKariSantei2().getFukakijunKari2().setTxtShikakuSoshitsuYMDKari2(txtShikakuSoshitsuYMDKari2);
    }

    @JsonIgnore
    public TextBox getTxtHokenryoDankaiKari2() {
        return this.getKariSantei2().getZennendoKari2().getTxtHokenryoDankaiKari2();
    }

    @JsonIgnore
    public void  setTxtHokenryoDankaiKari2(TextBox txtHokenryoDankaiKari2) {
        this.getKariSantei2().getZennendoKari2().setTxtHokenryoDankaiKari2(txtHokenryoDankaiKari2);
    }

    @JsonIgnore
    public TextBox getTxtHokenryoRitsuKari2() {
        return this.getKariSantei2().getZennendoKari2().getTxtHokenryoRitsuKari2();
    }

    @JsonIgnore
    public void  setTxtHokenryoRitsuKari2(TextBox txtHokenryoRitsuKari2) {
        this.getKariSantei2().getZennendoKari2().setTxtHokenryoRitsuKari2(txtHokenryoRitsuKari2);
    }

    @JsonIgnore
    public TextBoxNum getTxtNengakuHokenryoKari2() {
        return this.getKariSantei2().getZennendoKari2().getTxtNengakuHokenryoKari2();
    }

    @JsonIgnore
    public void  setTxtNengakuHokenryoKari2(TextBoxNum txtNengakuHokenryoKari2) {
        this.getKariSantei2().getZennendoKari2().setTxtNengakuHokenryoKari2(txtNengakuHokenryoKari2);
    }

    @JsonIgnore
    public TextBoxNum getTxtZanteiKeisanjoHokenryoKari2() {
        return this.getKariSantei2().getHokenryoKari2().getTxtZanteiKeisanjoHokenryoKari2();
    }

    @JsonIgnore
    public void  setTxtZanteiKeisanjoHokenryoKari2(TextBoxNum txtZanteiKeisanjoHokenryoKari2) {
        this.getKariSantei2().getHokenryoKari2().setTxtZanteiKeisanjoHokenryoKari2(txtZanteiKeisanjoHokenryoKari2);
    }

    @JsonIgnore
    public TextBoxNum getTxtGemmenGakuKari2() {
        return this.getKariSantei2().getHokenryoKari2().getTxtGemmenGakuKari2();
    }

    @JsonIgnore
    public void  setTxtGemmenGakuKari2(TextBoxNum txtGemmenGakuKari2) {
        this.getKariSantei2().getHokenryoKari2().setTxtGemmenGakuKari2(txtGemmenGakuKari2);
    }

    @JsonIgnore
    public TextBoxNum getTxtZanteiGoukeiGakuKari2() {
        return this.getKariSantei2().getHokenryoKari2().getTxtZanteiGoukeiGakuKari2();
    }

    @JsonIgnore
    public void  setTxtZanteiGoukeiGakuKari2(TextBoxNum txtZanteiGoukeiGakuKari2) {
        this.getKariSantei2().getHokenryoKari2().setTxtZanteiGoukeiGakuKari2(txtZanteiGoukeiGakuKari2);
    }

    @JsonIgnore
    public zanteihokenryoHeightKari2Div getZanteihokenryoHeightKari2() {
        return this.getKariSantei2().getHokenryoKari2().getZanteihokenryoHeightKari2();
    }

    @JsonIgnore
    public void  setZanteihokenryoHeightKari2(zanteihokenryoHeightKari2Div zanteihokenryoHeightKari2) {
        this.getKariSantei2().getHokenryoKari2().setZanteihokenryoHeightKari2(zanteihokenryoHeightKari2);
    }

    @JsonIgnore
    public IKiwarigakuDiv getCcdKiwarigakuKari2() {
        return this.getKariSantei2().getKibetsugakuKari2().getCcdKiwarigakuKari2();
    }

    @JsonIgnore
    public Label getLblShikakushutokuYMDHon2() {
        return this.getHonSantei2().getFukakijunHon2().getLblShikakushutokuYMDHon2();
    }

    @JsonIgnore
    public void  setLblShikakushutokuYMDHon2(Label lblShikakushutokuYMDHon2) {
        this.getHonSantei2().getFukakijunHon2().setLblShikakushutokuYMDHon2(lblShikakushutokuYMDHon2);
    }

    @JsonIgnore
    public TextBoxDate getTxtShikakuShutokuYMDHon2() {
        return this.getHonSantei2().getFukakijunHon2().getTxtShikakuShutokuYMDHon2();
    }

    @JsonIgnore
    public void  setTxtShikakuShutokuYMDHon2(TextBoxDate txtShikakuShutokuYMDHon2) {
        this.getHonSantei2().getFukakijunHon2().setTxtShikakuShutokuYMDHon2(txtShikakuShutokuYMDHon2);
    }

    @JsonIgnore
    public Label getLblShikakusoshitsuYMDHon2() {
        return this.getHonSantei2().getFukakijunHon2().getLblShikakusoshitsuYMDHon2();
    }

    @JsonIgnore
    public void  setLblShikakusoshitsuYMDHon2(Label lblShikakusoshitsuYMDHon2) {
        this.getHonSantei2().getFukakijunHon2().setLblShikakusoshitsuYMDHon2(lblShikakusoshitsuYMDHon2);
    }

    @JsonIgnore
    public TextBoxDate getTxtShikakuSoshitsuYMDHon2() {
        return this.getHonSantei2().getFukakijunHon2().getTxtShikakuSoshitsuYMDHon2();
    }

    @JsonIgnore
    public void  setTxtShikakuSoshitsuYMDHon2(TextBoxDate txtShikakuSoshitsuYMDHon2) {
        this.getHonSantei2().getFukakijunHon2().setTxtShikakuSoshitsuYMDHon2(txtShikakuSoshitsuYMDHon2);
    }

    @JsonIgnore
    public Label getLblGoukeiShotokuHon2() {
        return this.getHonSantei2().getFukakijunHon2().getLblGoukeiShotokuHon2();
    }

    @JsonIgnore
    public void  setLblGoukeiShotokuHon2(Label lblGoukeiShotokuHon2) {
        this.getHonSantei2().getFukakijunHon2().setLblGoukeiShotokuHon2(lblGoukeiShotokuHon2);
    }

    @JsonIgnore
    public TextBoxNum getTxtGoukeiShotokuHon2() {
        return this.getHonSantei2().getFukakijunHon2().getTxtGoukeiShotokuHon2();
    }

    @JsonIgnore
    public void  setTxtGoukeiShotokuHon2(TextBoxNum txtGoukeiShotokuHon2) {
        this.getHonSantei2().getFukakijunHon2().setTxtGoukeiShotokuHon2(txtGoukeiShotokuHon2);
    }

    @JsonIgnore
    public Label getLblNenkinShunyuHon2() {
        return this.getHonSantei2().getFukakijunHon2().getLblNenkinShunyuHon2();
    }

    @JsonIgnore
    public void  setLblNenkinShunyuHon2(Label lblNenkinShunyuHon2) {
        this.getHonSantei2().getFukakijunHon2().setLblNenkinShunyuHon2(lblNenkinShunyuHon2);
    }

    @JsonIgnore
    public TextBoxNum getTxtNenkinShunyuHon2() {
        return this.getHonSantei2().getFukakijunHon2().getTxtNenkinShunyuHon2();
    }

    @JsonIgnore
    public void  setTxtNenkinShunyuHon2(TextBoxNum txtNenkinShunyuHon2) {
        this.getHonSantei2().getFukakijunHon2().setTxtNenkinShunyuHon2(txtNenkinShunyuHon2);
    }

    @JsonIgnore
    public Label getLblHonninKazeiHon2() {
        return this.getHonSantei2().getFukakijunHon2().getLblHonninKazeiHon2();
    }

    @JsonIgnore
    public void  setLblHonninKazeiHon2(Label lblHonninKazeiHon2) {
        this.getHonSantei2().getFukakijunHon2().setLblHonninKazeiHon2(lblHonninKazeiHon2);
    }

    @JsonIgnore
    public TextBox getTxtHonninKazeiHon2() {
        return this.getHonSantei2().getFukakijunHon2().getTxtHonninKazeiHon2();
    }

    @JsonIgnore
    public void  setTxtHonninKazeiHon2(TextBox txtHonninKazeiHon2) {
        this.getHonSantei2().getFukakijunHon2().setTxtHonninKazeiHon2(txtHonninKazeiHon2);
    }

    @JsonIgnore
    public Label getLblSetaiKazeiHon2() {
        return this.getHonSantei2().getFukakijunHon2().getLblSetaiKazeiHon2();
    }

    @JsonIgnore
    public void  setLblSetaiKazeiHon2(Label lblSetaiKazeiHon2) {
        this.getHonSantei2().getFukakijunHon2().setLblSetaiKazeiHon2(lblSetaiKazeiHon2);
    }

    @JsonIgnore
    public TextBox getTxtSetaiKazeiHon2() {
        return this.getHonSantei2().getFukakijunHon2().getTxtSetaiKazeiHon2();
    }

    @JsonIgnore
    public void  setTxtSetaiKazeiHon2(TextBox txtSetaiKazeiHon2) {
        this.getHonSantei2().getFukakijunHon2().setTxtSetaiKazeiHon2(txtSetaiKazeiHon2);
    }

    @JsonIgnore
    public Label getLblSetaiinSuHon2() {
        return this.getHonSantei2().getFukakijunHon2().getLblSetaiinSuHon2();
    }

    @JsonIgnore
    public void  setLblSetaiinSuHon2(Label lblSetaiinSuHon2) {
        this.getHonSantei2().getFukakijunHon2().setLblSetaiinSuHon2(lblSetaiinSuHon2);
    }

    @JsonIgnore
    public TextBox getTxtSetaiinSuHon2() {
        return this.getHonSantei2().getFukakijunHon2().getTxtSetaiinSuHon2();
    }

    @JsonIgnore
    public void  setTxtSetaiinSuHon2(TextBox txtSetaiinSuHon2) {
        this.getHonSantei2().getFukakijunHon2().setTxtSetaiinSuHon2(txtSetaiinSuHon2);
    }

    @JsonIgnore
    public Label getLblHokenryoDankaiHon2() {
        return this.getHonSantei2().getHokenryoHon2().getLblHokenryoDankaiHon2();
    }

    @JsonIgnore
    public void  setLblHokenryoDankaiHon2(Label lblHokenryoDankaiHon2) {
        this.getHonSantei2().getHokenryoHon2().setLblHokenryoDankaiHon2(lblHokenryoDankaiHon2);
    }

    @JsonIgnore
    public TextBox getTxtHokenryoDankaiHon2() {
        return this.getHonSantei2().getHokenryoHon2().getTxtHokenryoDankaiHon2();
    }

    @JsonIgnore
    public void  setTxtHokenryoDankaiHon2(TextBox txtHokenryoDankaiHon2) {
        this.getHonSantei2().getHokenryoHon2().setTxtHokenryoDankaiHon2(txtHokenryoDankaiHon2);
    }

    @JsonIgnore
    public Label getLblKyokaisoHon2() {
        return this.getHonSantei2().getHokenryoHon2().getLblKyokaisoHon2();
    }

    @JsonIgnore
    public void  setLblKyokaisoHon2(Label lblKyokaisoHon2) {
        this.getHonSantei2().getHokenryoHon2().setLblKyokaisoHon2(lblKyokaisoHon2);
    }

    @JsonIgnore
    public TextBox getTxtKyokaisoHon2() {
        return this.getHonSantei2().getHokenryoHon2().getTxtKyokaisoHon2();
    }

    @JsonIgnore
    public void  setTxtKyokaisoHon2(TextBox txtKyokaisoHon2) {
        this.getHonSantei2().getHokenryoHon2().setTxtKyokaisoHon2(txtKyokaisoHon2);
    }

    @JsonIgnore
    public Label getLblKeisanHokenryogakuHon2() {
        return this.getHonSantei2().getHokenryoHon2().getLblKeisanHokenryogakuHon2();
    }

    @JsonIgnore
    public void  setLblKeisanHokenryogakuHon2(Label lblKeisanHokenryogakuHon2) {
        this.getHonSantei2().getHokenryoHon2().setLblKeisanHokenryogakuHon2(lblKeisanHokenryogakuHon2);
    }

    @JsonIgnore
    public TextBoxNum getTxtKeisanHokenryogakuHon2() {
        return this.getHonSantei2().getHokenryoHon2().getTxtKeisanHokenryogakuHon2();
    }

    @JsonIgnore
    public void  setTxtKeisanHokenryogakuHon2(TextBoxNum txtKeisanHokenryogakuHon2) {
        this.getHonSantei2().getHokenryoHon2().setTxtKeisanHokenryogakuHon2(txtKeisanHokenryogakuHon2);
    }

    @JsonIgnore
    public Label getLblGemmenGakuHon2() {
        return this.getHonSantei2().getHokenryoHon2().getLblGemmenGakuHon2();
    }

    @JsonIgnore
    public void  setLblGemmenGakuHon2(Label lblGemmenGakuHon2) {
        this.getHonSantei2().getHokenryoHon2().setLblGemmenGakuHon2(lblGemmenGakuHon2);
    }

    @JsonIgnore
    public TextBoxNum getTxtGemmenGakuHon2() {
        return this.getHonSantei2().getHokenryoHon2().getTxtGemmenGakuHon2();
    }

    @JsonIgnore
    public void  setTxtGemmenGakuHon2(TextBoxNum txtGemmenGakuHon2) {
        this.getHonSantei2().getHokenryoHon2().setTxtGemmenGakuHon2(txtGemmenGakuHon2);
    }

    @JsonIgnore
    public Label getLblKakuteiHokenryoHon2() {
        return this.getHonSantei2().getHokenryoHon2().getLblKakuteiHokenryoHon2();
    }

    @JsonIgnore
    public void  setLblKakuteiHokenryoHon2(Label lblKakuteiHokenryoHon2) {
        this.getHonSantei2().getHokenryoHon2().setLblKakuteiHokenryoHon2(lblKakuteiHokenryoHon2);
    }

    @JsonIgnore
    public TextBoxNum getTxtKakuteiHokenryoHon2() {
        return this.getHonSantei2().getHokenryoHon2().getTxtKakuteiHokenryoHon2();
    }

    @JsonIgnore
    public void  setTxtKakuteiHokenryoHon2(TextBoxNum txtKakuteiHokenryoHon2) {
        this.getHonSantei2().getHokenryoHon2().setTxtKakuteiHokenryoHon2(txtKakuteiHokenryoHon2);
    }

    @JsonIgnore
    public IKiwarigakuDiv getCcdKiwarigakuHon2() {
        return this.getHonSantei2().getKibetsugakuHon2().getCcdKiwarigakuHon2();
    }

}
