package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.IKaigoBunshoBangoHenshuSetteiDiv;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.BunshoBangoKigoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.BunshoFooterDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.BunshoHeaderDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.BunshoNoHenshuDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.BunshoShuruiDiv;

/**
 * KaigoBunshoBangoHenshuSettei のクラスファイル 
 * 
 * @author 自動生成
 */
public class KaigoBunshoBangoHenshuSetteiDiv extends Panel implements IKaigoBunshoBangoHenshuSetteiDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKaishiYMD")
    private TextBoxDate txtKaishiYMD;
    @JsonProperty("txtShuryoYMD")
    private TextBoxDate txtShuryoYMD;
    @JsonProperty("lin1")
    private HorizontalLine lin1;
    @JsonProperty("radBunshuBangoShuchuryokuUmu")
    private RadioButton radBunshuBangoShuchuryokuUmu;
    @JsonProperty("txtYukoKetasu")
    private TextBoxNum txtYukoKetasu;
    @JsonProperty("lin2")
    private HorizontalLine lin2;
    @JsonProperty("BunshoBangoKigo")
    private BunshoBangoKigoDiv BunshoBangoKigo;
    @JsonProperty("BunshoHeader")
    private BunshoHeaderDiv BunshoHeader;
    @JsonProperty("BunshoNoHenshu")
    private BunshoNoHenshuDiv BunshoNoHenshu;
    @JsonProperty("BunshoFooter")
    private BunshoFooterDiv BunshoFooter;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtKaishiYMD")
    public TextBoxDate getTxtKaishiYMD() {
        return txtKaishiYMD;
    }

    @JsonProperty("txtKaishiYMD")
    public void setTxtKaishiYMD(TextBoxDate txtKaishiYMD) {
        this.txtKaishiYMD=txtKaishiYMD;
    }

    @JsonProperty("txtShuryoYMD")
    public TextBoxDate getTxtShuryoYMD() {
        return txtShuryoYMD;
    }

    @JsonProperty("txtShuryoYMD")
    public void setTxtShuryoYMD(TextBoxDate txtShuryoYMD) {
        this.txtShuryoYMD=txtShuryoYMD;
    }

    @JsonProperty("lin1")
    public HorizontalLine getLin1() {
        return lin1;
    }

    @JsonProperty("lin1")
    public void setLin1(HorizontalLine lin1) {
        this.lin1=lin1;
    }

    @JsonProperty("radBunshuBangoShuchuryokuUmu")
    public RadioButton getRadBunshuBangoShuchuryokuUmu() {
        return radBunshuBangoShuchuryokuUmu;
    }

    @JsonProperty("radBunshuBangoShuchuryokuUmu")
    public void setRadBunshuBangoShuchuryokuUmu(RadioButton radBunshuBangoShuchuryokuUmu) {
        this.radBunshuBangoShuchuryokuUmu=radBunshuBangoShuchuryokuUmu;
    }

    @JsonProperty("txtYukoKetasu")
    public TextBoxNum getTxtYukoKetasu() {
        return txtYukoKetasu;
    }

    @JsonProperty("txtYukoKetasu")
    public void setTxtYukoKetasu(TextBoxNum txtYukoKetasu) {
        this.txtYukoKetasu=txtYukoKetasu;
    }

    @JsonProperty("lin2")
    public HorizontalLine getLin2() {
        return lin2;
    }

    @JsonProperty("lin2")
    public void setLin2(HorizontalLine lin2) {
        this.lin2=lin2;
    }

    @JsonProperty("BunshoBangoKigo")
    public BunshoBangoKigoDiv getBunshoBangoKigo() {
        return BunshoBangoKigo;
    }

    @JsonProperty("BunshoBangoKigo")
    public void setBunshoBangoKigo(BunshoBangoKigoDiv BunshoBangoKigo) {
        this.BunshoBangoKigo=BunshoBangoKigo;
    }

    @JsonProperty("BunshoHeader")
    public BunshoHeaderDiv getBunshoHeader() {
        return BunshoHeader;
    }

    @JsonProperty("BunshoHeader")
    public void setBunshoHeader(BunshoHeaderDiv BunshoHeader) {
        this.BunshoHeader=BunshoHeader;
    }

    @JsonProperty("BunshoNoHenshu")
    public BunshoNoHenshuDiv getBunshoNoHenshu() {
        return BunshoNoHenshu;
    }

    @JsonProperty("BunshoNoHenshu")
    public void setBunshoNoHenshu(BunshoNoHenshuDiv BunshoNoHenshu) {
        this.BunshoNoHenshu=BunshoNoHenshu;
    }

    @JsonProperty("BunshoFooter")
    public BunshoFooterDiv getBunshoFooter() {
        return BunshoFooter;
    }

    @JsonProperty("BunshoFooter")
    public void setBunshoFooter(BunshoFooterDiv BunshoFooter) {
        this.BunshoFooter=BunshoFooter;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadBunshoBangoKigoFuyoUmu() {
        return this.getBunshoBangoKigo().getRadBunshoBangoKigoFuyoUmu();
    }

    @JsonIgnore
    public void  setRadBunshoBangoKigoFuyoUmu(RadioButton radBunshoBangoKigoFuyoUmu) {
        this.getBunshoBangoKigo().setRadBunshoBangoKigoFuyoUmu(radBunshoBangoKigoFuyoUmu);
    }

    @JsonIgnore
    public TextBox getTxtBunshoBangoKigo() {
        return this.getBunshoBangoKigo().getTxtBunshoBangoKigo();
    }

    @JsonIgnore
    public void  setTxtBunshoBangoKigo(TextBox txtBunshoBangoKigo) {
        this.getBunshoBangoKigo().setTxtBunshoBangoKigo(txtBunshoBangoKigo);
    }

    @JsonIgnore
    public RadioButton getRadBunshoHeaderFuyoUmu() {
        return this.getBunshoHeader().getRadBunshoHeaderFuyoUmu();
    }

    @JsonIgnore
    public void  setRadBunshoHeaderFuyoUmu(RadioButton radBunshoHeaderFuyoUmu) {
        this.getBunshoHeader().setRadBunshoHeaderFuyoUmu(radBunshoHeaderFuyoUmu);
    }

    @JsonIgnore
    public TextBox getTxtBunshoNoHeader() {
        return this.getBunshoHeader().getTxtBunshoNoHeader();
    }

    @JsonIgnore
    public void  setTxtBunshoNoHeader(TextBox txtBunshoNoHeader) {
        this.getBunshoHeader().setTxtBunshoNoHeader(txtBunshoNoHeader);
    }

    @JsonIgnore
    public DropDownList getDdlBunshoNoHenshu() {
        return this.getBunshoNoHenshu().getDdlBunshoNoHenshu();
    }

    @JsonIgnore
    public void  setDdlBunshoNoHenshu(DropDownList ddlBunshoNoHenshu) {
        this.getBunshoNoHenshu().setDdlBunshoNoHenshu(ddlBunshoNoHenshu);
    }

    @JsonIgnore
    public DropDownList getDdlBunshoNoHatsuban() {
        return this.getBunshoNoHenshu().getDdlBunshoNoHatsuban();
    }

    @JsonIgnore
    public void  setDdlBunshoNoHatsuban(DropDownList ddlBunshoNoHatsuban) {
        this.getBunshoNoHenshu().setDdlBunshoNoHatsuban(ddlBunshoNoHatsuban);
    }

    @JsonIgnore
    public TextBox getTxtBunshoKoseiNo() {
        return this.getBunshoNoHenshu().getTxtBunshoKoseiNo();
    }

    @JsonIgnore
    public void  setTxtBunshoKoseiNo(TextBox txtBunshoKoseiNo) {
        this.getBunshoNoHenshu().setTxtBunshoKoseiNo(txtBunshoKoseiNo);
    }

    @JsonIgnore
    public RadioButton getRadBunshoNoFooterFuyoUmu() {
        return this.getBunshoFooter().getRadBunshoNoFooterFuyoUmu();
    }

    @JsonIgnore
    public void  setRadBunshoNoFooterFuyoUmu(RadioButton radBunshoNoFooterFuyoUmu) {
        this.getBunshoFooter().setRadBunshoNoFooterFuyoUmu(radBunshoNoFooterFuyoUmu);
    }

    @JsonIgnore
    public TextBox getTxtBunshoNoFooter() {
        return this.getBunshoFooter().getTxtBunshoNoFooter();
    }

    @JsonIgnore
    public void  setTxtBunshoNoFooter(TextBox txtBunshoNoFooter) {
        this.getBunshoFooter().setTxtBunshoNoFooter(txtBunshoNoFooter);
    }

    //--------------- この行より下にコードを追加してください -------------------

}
