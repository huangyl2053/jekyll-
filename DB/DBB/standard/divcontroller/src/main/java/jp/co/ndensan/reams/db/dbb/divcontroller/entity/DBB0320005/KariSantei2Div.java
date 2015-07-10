package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320005;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320005.FukakijunKari2Div;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320005.HokenryoKari2Div;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320005.KibetsugakuKari2Div;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320005.ZennendoKari2Div;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320005.tblChoteiJiyuKari2Div;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320005.zanteihokenryoHeightKari2Div;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.kiwarigaku.IKiwarigakuDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.kiwarigaku.KiwarigakuDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KariSantei2 のクラスファイル 
 * 
 * @author 自動生成
 */
public class KariSantei2Div extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtChoteiNendoKari2")
    private TextBoxFlexibleDate txtChoteiNendoKari2;
    @JsonProperty("txtFukaNendoKari2")
    private TextBoxFlexibleDate txtFukaNendoKari2;
    @JsonProperty("txtTsuchiNoKari2")
    private TextBox txtTsuchiNoKari2;
    @JsonProperty("txtKoseiYMDKari2")
    private TextBox txtKoseiYMDKari2;
    @JsonProperty("txtKoseiTimeKari2")
    private TextBoxTime txtKoseiTimeKari2;
    @JsonProperty("txtKoseiYMKari2")
    private TextBox txtKoseiYMKari2;
    @JsonProperty("txtShimeiKari2")
    private TextBox txtShimeiKari2;
    @JsonProperty("tblChoteiJiyuKari2")
    private tblChoteiJiyuKari2Div tblChoteiJiyuKari2;
    @JsonProperty("FukakijunKari2")
    private FukakijunKari2Div FukakijunKari2;
    @JsonProperty("ZennendoKari2")
    private ZennendoKari2Div ZennendoKari2;
    @JsonProperty("HokenryoKari2")
    private HokenryoKari2Div HokenryoKari2;
    @JsonProperty("KibetsugakuKari2")
    private KibetsugakuKari2Div KibetsugakuKari2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtChoteiNendoKari2")
    public TextBoxFlexibleDate getTxtChoteiNendoKari2() {
        return txtChoteiNendoKari2;
    }

    @JsonProperty("txtChoteiNendoKari2")
    public void setTxtChoteiNendoKari2(TextBoxFlexibleDate txtChoteiNendoKari2) {
        this.txtChoteiNendoKari2=txtChoteiNendoKari2;
    }

    @JsonProperty("txtFukaNendoKari2")
    public TextBoxFlexibleDate getTxtFukaNendoKari2() {
        return txtFukaNendoKari2;
    }

    @JsonProperty("txtFukaNendoKari2")
    public void setTxtFukaNendoKari2(TextBoxFlexibleDate txtFukaNendoKari2) {
        this.txtFukaNendoKari2=txtFukaNendoKari2;
    }

    @JsonProperty("txtTsuchiNoKari2")
    public TextBox getTxtTsuchiNoKari2() {
        return txtTsuchiNoKari2;
    }

    @JsonProperty("txtTsuchiNoKari2")
    public void setTxtTsuchiNoKari2(TextBox txtTsuchiNoKari2) {
        this.txtTsuchiNoKari2=txtTsuchiNoKari2;
    }

    @JsonProperty("txtKoseiYMDKari2")
    public TextBox getTxtKoseiYMDKari2() {
        return txtKoseiYMDKari2;
    }

    @JsonProperty("txtKoseiYMDKari2")
    public void setTxtKoseiYMDKari2(TextBox txtKoseiYMDKari2) {
        this.txtKoseiYMDKari2=txtKoseiYMDKari2;
    }

    @JsonProperty("txtKoseiTimeKari2")
    public TextBoxTime getTxtKoseiTimeKari2() {
        return txtKoseiTimeKari2;
    }

    @JsonProperty("txtKoseiTimeKari2")
    public void setTxtKoseiTimeKari2(TextBoxTime txtKoseiTimeKari2) {
        this.txtKoseiTimeKari2=txtKoseiTimeKari2;
    }

    @JsonProperty("txtKoseiYMKari2")
    public TextBox getTxtKoseiYMKari2() {
        return txtKoseiYMKari2;
    }

    @JsonProperty("txtKoseiYMKari2")
    public void setTxtKoseiYMKari2(TextBox txtKoseiYMKari2) {
        this.txtKoseiYMKari2=txtKoseiYMKari2;
    }

    @JsonProperty("txtShimeiKari2")
    public TextBox getTxtShimeiKari2() {
        return txtShimeiKari2;
    }

    @JsonProperty("txtShimeiKari2")
    public void setTxtShimeiKari2(TextBox txtShimeiKari2) {
        this.txtShimeiKari2=txtShimeiKari2;
    }

    @JsonProperty("tblChoteiJiyuKari2")
    public tblChoteiJiyuKari2Div getTblChoteiJiyuKari2() {
        return tblChoteiJiyuKari2;
    }

    @JsonProperty("tblChoteiJiyuKari2")
    public void setTblChoteiJiyuKari2(tblChoteiJiyuKari2Div tblChoteiJiyuKari2) {
        this.tblChoteiJiyuKari2=tblChoteiJiyuKari2;
    }

    @JsonProperty("FukakijunKari2")
    public FukakijunKari2Div getFukakijunKari2() {
        return FukakijunKari2;
    }

    @JsonProperty("FukakijunKari2")
    public void setFukakijunKari2(FukakijunKari2Div FukakijunKari2) {
        this.FukakijunKari2=FukakijunKari2;
    }

    @JsonProperty("ZennendoKari2")
    public ZennendoKari2Div getZennendoKari2() {
        return ZennendoKari2;
    }

    @JsonProperty("ZennendoKari2")
    public void setZennendoKari2(ZennendoKari2Div ZennendoKari2) {
        this.ZennendoKari2=ZennendoKari2;
    }

    @JsonProperty("HokenryoKari2")
    public HokenryoKari2Div getHokenryoKari2() {
        return HokenryoKari2;
    }

    @JsonProperty("HokenryoKari2")
    public void setHokenryoKari2(HokenryoKari2Div HokenryoKari2) {
        this.HokenryoKari2=HokenryoKari2;
    }

    @JsonProperty("KibetsugakuKari2")
    public KibetsugakuKari2Div getKibetsugakuKari2() {
        return KibetsugakuKari2;
    }

    @JsonProperty("KibetsugakuKari2")
    public void setKibetsugakuKari2(KibetsugakuKari2Div KibetsugakuKari2) {
        this.KibetsugakuKari2=KibetsugakuKari2;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblChoteiJiyuKari2() {
        return this.getTblChoteiJiyuKari2().getLblChoteiJiyuKari2();
    }

    @JsonIgnore
    public TextBox getTxtChoteiJiyuKari21() {
        return this.getTblChoteiJiyuKari2().getTxtChoteiJiyuKari21();
    }

    @JsonIgnore
    public TextBox getTxtChoteiJiyuKari22() {
        return this.getTblChoteiJiyuKari2().getTxtChoteiJiyuKari22();
    }

    @JsonIgnore
    public TextBox getTxtChoteiJiyuKari23() {
        return this.getTblChoteiJiyuKari2().getTxtChoteiJiyuKari23();
    }

    @JsonIgnore
    public TextBox getTxtChoteiJiyuKari24() {
        return this.getTblChoteiJiyuKari2().getTxtChoteiJiyuKari24();
    }

    @JsonIgnore
    public TextBoxDate getTxtShikakuShutokuYMDKari2() {
        return this.getFukakijunKari2().getTxtShikakuShutokuYMDKari2();
    }

    @JsonIgnore
    public void  setTxtShikakuShutokuYMDKari2(TextBoxDate txtShikakuShutokuYMDKari2) {
        this.getFukakijunKari2().setTxtShikakuShutokuYMDKari2(txtShikakuShutokuYMDKari2);
    }

    @JsonIgnore
    public TextBoxDate getTxtShikakuSoshitsuYMDKari2() {
        return this.getFukakijunKari2().getTxtShikakuSoshitsuYMDKari2();
    }

    @JsonIgnore
    public void  setTxtShikakuSoshitsuYMDKari2(TextBoxDate txtShikakuSoshitsuYMDKari2) {
        this.getFukakijunKari2().setTxtShikakuSoshitsuYMDKari2(txtShikakuSoshitsuYMDKari2);
    }

    @JsonIgnore
    public TextBox getTxtHokenryoDankaiKari2() {
        return this.getZennendoKari2().getTxtHokenryoDankaiKari2();
    }

    @JsonIgnore
    public void  setTxtHokenryoDankaiKari2(TextBox txtHokenryoDankaiKari2) {
        this.getZennendoKari2().setTxtHokenryoDankaiKari2(txtHokenryoDankaiKari2);
    }

    @JsonIgnore
    public TextBox getTxtHokenryoRitsuKari2() {
        return this.getZennendoKari2().getTxtHokenryoRitsuKari2();
    }

    @JsonIgnore
    public void  setTxtHokenryoRitsuKari2(TextBox txtHokenryoRitsuKari2) {
        this.getZennendoKari2().setTxtHokenryoRitsuKari2(txtHokenryoRitsuKari2);
    }

    @JsonIgnore
    public TextBoxNum getTxtNengakuHokenryoKari2() {
        return this.getZennendoKari2().getTxtNengakuHokenryoKari2();
    }

    @JsonIgnore
    public void  setTxtNengakuHokenryoKari2(TextBoxNum txtNengakuHokenryoKari2) {
        this.getZennendoKari2().setTxtNengakuHokenryoKari2(txtNengakuHokenryoKari2);
    }

    @JsonIgnore
    public TextBoxNum getTxtZanteiKeisanjoHokenryoKari2() {
        return this.getHokenryoKari2().getTxtZanteiKeisanjoHokenryoKari2();
    }

    @JsonIgnore
    public void  setTxtZanteiKeisanjoHokenryoKari2(TextBoxNum txtZanteiKeisanjoHokenryoKari2) {
        this.getHokenryoKari2().setTxtZanteiKeisanjoHokenryoKari2(txtZanteiKeisanjoHokenryoKari2);
    }

    @JsonIgnore
    public TextBoxNum getTxtGemmenGakuKari2() {
        return this.getHokenryoKari2().getTxtGemmenGakuKari2();
    }

    @JsonIgnore
    public void  setTxtGemmenGakuKari2(TextBoxNum txtGemmenGakuKari2) {
        this.getHokenryoKari2().setTxtGemmenGakuKari2(txtGemmenGakuKari2);
    }

    @JsonIgnore
    public TextBoxNum getTxtZanteiGoukeiGakuKari2() {
        return this.getHokenryoKari2().getTxtZanteiGoukeiGakuKari2();
    }

    @JsonIgnore
    public void  setTxtZanteiGoukeiGakuKari2(TextBoxNum txtZanteiGoukeiGakuKari2) {
        this.getHokenryoKari2().setTxtZanteiGoukeiGakuKari2(txtZanteiGoukeiGakuKari2);
    }

    @JsonIgnore
    public zanteihokenryoHeightKari2Div getZanteihokenryoHeightKari2() {
        return this.getHokenryoKari2().getZanteihokenryoHeightKari2();
    }

    @JsonIgnore
    public void  setZanteihokenryoHeightKari2(zanteihokenryoHeightKari2Div zanteihokenryoHeightKari2) {
        this.getHokenryoKari2().setZanteihokenryoHeightKari2(zanteihokenryoHeightKari2);
    }

    @JsonIgnore
    public IKiwarigakuDiv getCcdKiwarigakuKari2() {
        return this.getKibetsugakuKari2().getCcdKiwarigakuKari2();
    }

}
