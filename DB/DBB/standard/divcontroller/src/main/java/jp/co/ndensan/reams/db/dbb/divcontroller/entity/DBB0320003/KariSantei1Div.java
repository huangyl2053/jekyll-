package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320003;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320003.FukaHikakuFukakijun1Div;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320003.FukaHikakuKibetsuGaku1Div;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320003.FukaHikakuZanteiGaku1Div;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320003.FukaHikakuZennendo1Div;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320003.tblChoteiJiyu1Div;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KariSantei1 のクラスファイル 
 * 
 * @author 自動生成
 */
public class KariSantei1Div extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtChoteiNendo1")
    private TextBox txtChoteiNendo1;
    @JsonProperty("txtFukaNendo1")
    private TextBox txtFukaNendo1;
    @JsonProperty("txtTsuchiNo1")
    private TextBox txtTsuchiNo1;
    @JsonProperty("txtKoseiYMD1")
    private TextBox txtKoseiYMD1;
    @JsonProperty("txtKoseiYM1")
    private TextBox txtKoseiYM1;
    @JsonProperty("txtShimei1")
    private TextBox txtShimei1;
    @JsonProperty("tblChoteiJiyu1")
    private tblChoteiJiyu1Div tblChoteiJiyu1;
    @JsonProperty("FukaHikakuFukakijun1")
    private FukaHikakuFukakijun1Div FukaHikakuFukakijun1;
    @JsonProperty("FukaHikakuZennendo1")
    private FukaHikakuZennendo1Div FukaHikakuZennendo1;
    @JsonProperty("FukaHikakuZanteiGaku1")
    private FukaHikakuZanteiGaku1Div FukaHikakuZanteiGaku1;
    @JsonProperty("FukaHikakuKibetsuGaku1")
    private FukaHikakuKibetsuGaku1Div FukaHikakuKibetsuGaku1;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtChoteiNendo1")
    public TextBox getTxtChoteiNendo1() {
        return txtChoteiNendo1;
    }

    @JsonProperty("txtChoteiNendo1")
    public void setTxtChoteiNendo1(TextBox txtChoteiNendo1) {
        this.txtChoteiNendo1=txtChoteiNendo1;
    }

    @JsonProperty("txtFukaNendo1")
    public TextBox getTxtFukaNendo1() {
        return txtFukaNendo1;
    }

    @JsonProperty("txtFukaNendo1")
    public void setTxtFukaNendo1(TextBox txtFukaNendo1) {
        this.txtFukaNendo1=txtFukaNendo1;
    }

    @JsonProperty("txtTsuchiNo1")
    public TextBox getTxtTsuchiNo1() {
        return txtTsuchiNo1;
    }

    @JsonProperty("txtTsuchiNo1")
    public void setTxtTsuchiNo1(TextBox txtTsuchiNo1) {
        this.txtTsuchiNo1=txtTsuchiNo1;
    }

    @JsonProperty("txtKoseiYMD1")
    public TextBox getTxtKoseiYMD1() {
        return txtKoseiYMD1;
    }

    @JsonProperty("txtKoseiYMD1")
    public void setTxtKoseiYMD1(TextBox txtKoseiYMD1) {
        this.txtKoseiYMD1=txtKoseiYMD1;
    }

    @JsonProperty("txtKoseiYM1")
    public TextBox getTxtKoseiYM1() {
        return txtKoseiYM1;
    }

    @JsonProperty("txtKoseiYM1")
    public void setTxtKoseiYM1(TextBox txtKoseiYM1) {
        this.txtKoseiYM1=txtKoseiYM1;
    }

    @JsonProperty("txtShimei1")
    public TextBox getTxtShimei1() {
        return txtShimei1;
    }

    @JsonProperty("txtShimei1")
    public void setTxtShimei1(TextBox txtShimei1) {
        this.txtShimei1=txtShimei1;
    }

    @JsonProperty("tblChoteiJiyu1")
    public tblChoteiJiyu1Div getTblChoteiJiyu1() {
        return tblChoteiJiyu1;
    }

    @JsonProperty("tblChoteiJiyu1")
    public void setTblChoteiJiyu1(tblChoteiJiyu1Div tblChoteiJiyu1) {
        this.tblChoteiJiyu1=tblChoteiJiyu1;
    }

    @JsonProperty("FukaHikakuFukakijun1")
    public FukaHikakuFukakijun1Div getFukaHikakuFukakijun1() {
        return FukaHikakuFukakijun1;
    }

    @JsonProperty("FukaHikakuFukakijun1")
    public void setFukaHikakuFukakijun1(FukaHikakuFukakijun1Div FukaHikakuFukakijun1) {
        this.FukaHikakuFukakijun1=FukaHikakuFukakijun1;
    }

    @JsonProperty("FukaHikakuZennendo1")
    public FukaHikakuZennendo1Div getFukaHikakuZennendo1() {
        return FukaHikakuZennendo1;
    }

    @JsonProperty("FukaHikakuZennendo1")
    public void setFukaHikakuZennendo1(FukaHikakuZennendo1Div FukaHikakuZennendo1) {
        this.FukaHikakuZennendo1=FukaHikakuZennendo1;
    }

    @JsonProperty("FukaHikakuZanteiGaku1")
    public FukaHikakuZanteiGaku1Div getFukaHikakuZanteiGaku1() {
        return FukaHikakuZanteiGaku1;
    }

    @JsonProperty("FukaHikakuZanteiGaku1")
    public void setFukaHikakuZanteiGaku1(FukaHikakuZanteiGaku1Div FukaHikakuZanteiGaku1) {
        this.FukaHikakuZanteiGaku1=FukaHikakuZanteiGaku1;
    }

    @JsonProperty("FukaHikakuKibetsuGaku1")
    public FukaHikakuKibetsuGaku1Div getFukaHikakuKibetsuGaku1() {
        return FukaHikakuKibetsuGaku1;
    }

    @JsonProperty("FukaHikakuKibetsuGaku1")
    public void setFukaHikakuKibetsuGaku1(FukaHikakuKibetsuGaku1Div FukaHikakuKibetsuGaku1) {
        this.FukaHikakuKibetsuGaku1=FukaHikakuKibetsuGaku1;
    }

}
