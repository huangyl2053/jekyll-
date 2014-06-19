package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320003;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320003.FukaHikakuFukakijun2Div;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320003.FukaHikakuKibetsuGaku2Div;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320003.FukaHikakuZanteiGaku2Div;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320003.FukaHikakuZennendo2Div;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320003.tblChoteiJiyu2Div;
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
    @JsonProperty("txtChoteiNendo2")
    private TextBox txtChoteiNendo2;
    @JsonProperty("txtFukaNendo2")
    private TextBox txtFukaNendo2;
    @JsonProperty("txtTsuchiNo2")
    private TextBox txtTsuchiNo2;
    @JsonProperty("txtKoseiYMD2")
    private TextBox txtKoseiYMD2;
    @JsonProperty("txtKoseiYM2")
    private TextBox txtKoseiYM2;
    @JsonProperty("txtShimei2")
    private TextBox txtShimei2;
    @JsonProperty("tblChoteiJiyu2")
    private tblChoteiJiyu2Div tblChoteiJiyu2;
    @JsonProperty("FukaHikakuFukakijun2")
    private FukaHikakuFukakijun2Div FukaHikakuFukakijun2;
    @JsonProperty("FukaHikakuZennendo2")
    private FukaHikakuZennendo2Div FukaHikakuZennendo2;
    @JsonProperty("FukaHikakuZanteiGaku2")
    private FukaHikakuZanteiGaku2Div FukaHikakuZanteiGaku2;
    @JsonProperty("FukaHikakuKibetsuGaku2")
    private FukaHikakuKibetsuGaku2Div FukaHikakuKibetsuGaku2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtChoteiNendo2")
    public TextBox getTxtChoteiNendo2() {
        return txtChoteiNendo2;
    }

    @JsonProperty("txtChoteiNendo2")
    public void setTxtChoteiNendo2(TextBox txtChoteiNendo2) {
        this.txtChoteiNendo2=txtChoteiNendo2;
    }

    @JsonProperty("txtFukaNendo2")
    public TextBox getTxtFukaNendo2() {
        return txtFukaNendo2;
    }

    @JsonProperty("txtFukaNendo2")
    public void setTxtFukaNendo2(TextBox txtFukaNendo2) {
        this.txtFukaNendo2=txtFukaNendo2;
    }

    @JsonProperty("txtTsuchiNo2")
    public TextBox getTxtTsuchiNo2() {
        return txtTsuchiNo2;
    }

    @JsonProperty("txtTsuchiNo2")
    public void setTxtTsuchiNo2(TextBox txtTsuchiNo2) {
        this.txtTsuchiNo2=txtTsuchiNo2;
    }

    @JsonProperty("txtKoseiYMD2")
    public TextBox getTxtKoseiYMD2() {
        return txtKoseiYMD2;
    }

    @JsonProperty("txtKoseiYMD2")
    public void setTxtKoseiYMD2(TextBox txtKoseiYMD2) {
        this.txtKoseiYMD2=txtKoseiYMD2;
    }

    @JsonProperty("txtKoseiYM2")
    public TextBox getTxtKoseiYM2() {
        return txtKoseiYM2;
    }

    @JsonProperty("txtKoseiYM2")
    public void setTxtKoseiYM2(TextBox txtKoseiYM2) {
        this.txtKoseiYM2=txtKoseiYM2;
    }

    @JsonProperty("txtShimei2")
    public TextBox getTxtShimei2() {
        return txtShimei2;
    }

    @JsonProperty("txtShimei2")
    public void setTxtShimei2(TextBox txtShimei2) {
        this.txtShimei2=txtShimei2;
    }

    @JsonProperty("tblChoteiJiyu2")
    public tblChoteiJiyu2Div getTblChoteiJiyu2() {
        return tblChoteiJiyu2;
    }

    @JsonProperty("tblChoteiJiyu2")
    public void setTblChoteiJiyu2(tblChoteiJiyu2Div tblChoteiJiyu2) {
        this.tblChoteiJiyu2=tblChoteiJiyu2;
    }

    @JsonProperty("FukaHikakuFukakijun2")
    public FukaHikakuFukakijun2Div getFukaHikakuFukakijun2() {
        return FukaHikakuFukakijun2;
    }

    @JsonProperty("FukaHikakuFukakijun2")
    public void setFukaHikakuFukakijun2(FukaHikakuFukakijun2Div FukaHikakuFukakijun2) {
        this.FukaHikakuFukakijun2=FukaHikakuFukakijun2;
    }

    @JsonProperty("FukaHikakuZennendo2")
    public FukaHikakuZennendo2Div getFukaHikakuZennendo2() {
        return FukaHikakuZennendo2;
    }

    @JsonProperty("FukaHikakuZennendo2")
    public void setFukaHikakuZennendo2(FukaHikakuZennendo2Div FukaHikakuZennendo2) {
        this.FukaHikakuZennendo2=FukaHikakuZennendo2;
    }

    @JsonProperty("FukaHikakuZanteiGaku2")
    public FukaHikakuZanteiGaku2Div getFukaHikakuZanteiGaku2() {
        return FukaHikakuZanteiGaku2;
    }

    @JsonProperty("FukaHikakuZanteiGaku2")
    public void setFukaHikakuZanteiGaku2(FukaHikakuZanteiGaku2Div FukaHikakuZanteiGaku2) {
        this.FukaHikakuZanteiGaku2=FukaHikakuZanteiGaku2;
    }

    @JsonProperty("FukaHikakuKibetsuGaku2")
    public FukaHikakuKibetsuGaku2Div getFukaHikakuKibetsuGaku2() {
        return FukaHikakuKibetsuGaku2;
    }

    @JsonProperty("FukaHikakuKibetsuGaku2")
    public void setFukaHikakuKibetsuGaku2(FukaHikakuKibetsuGaku2Div FukaHikakuKibetsuGaku2) {
        this.FukaHikakuKibetsuGaku2=FukaHikakuKibetsuGaku2;
    }

}
