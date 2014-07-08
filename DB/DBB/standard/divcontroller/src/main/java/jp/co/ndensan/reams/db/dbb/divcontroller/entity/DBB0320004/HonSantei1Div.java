package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320004;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320004.FukaHikakuFukakijun3Div;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320004.FukaHikakuHokenryo3Div;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320004.FukaHikakuKibetsuGaku3Div;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320004.tblChoteiJiyu3Div;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * HonSantei1 のクラスファイル 
 * 
 * @author 自動生成
 */
public class HonSantei1Div extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtChoteiNendo3")
    private TextBox txtChoteiNendo3;
    @JsonProperty("txtFukaNendo3")
    private TextBox txtFukaNendo3;
    @JsonProperty("txtTsuchiNo3")
    private TextBox txtTsuchiNo3;
    @JsonProperty("txtKoseiYMD3")
    private TextBox txtKoseiYMD3;
    @JsonProperty("txtKoseiYM3")
    private TextBox txtKoseiYM3;
    @JsonProperty("txtShimei3")
    private TextBox txtShimei3;
    @JsonProperty("tblChoteiJiyu3")
    private tblChoteiJiyu3Div tblChoteiJiyu3;
    @JsonProperty("FukaHikakuFukakijun3")
    private FukaHikakuFukakijun3Div FukaHikakuFukakijun3;
    @JsonProperty("FukaHikakuHokenryo3")
    private FukaHikakuHokenryo3Div FukaHikakuHokenryo3;
    @JsonProperty("FukaHikakuKibetsuGaku3")
    private FukaHikakuKibetsuGaku3Div FukaHikakuKibetsuGaku3;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtChoteiNendo3")
    public TextBox getTxtChoteiNendo3() {
        return txtChoteiNendo3;
    }

    @JsonProperty("txtChoteiNendo3")
    public void setTxtChoteiNendo3(TextBox txtChoteiNendo3) {
        this.txtChoteiNendo3=txtChoteiNendo3;
    }

    @JsonProperty("txtFukaNendo3")
    public TextBox getTxtFukaNendo3() {
        return txtFukaNendo3;
    }

    @JsonProperty("txtFukaNendo3")
    public void setTxtFukaNendo3(TextBox txtFukaNendo3) {
        this.txtFukaNendo3=txtFukaNendo3;
    }

    @JsonProperty("txtTsuchiNo3")
    public TextBox getTxtTsuchiNo3() {
        return txtTsuchiNo3;
    }

    @JsonProperty("txtTsuchiNo3")
    public void setTxtTsuchiNo3(TextBox txtTsuchiNo3) {
        this.txtTsuchiNo3=txtTsuchiNo3;
    }

    @JsonProperty("txtKoseiYMD3")
    public TextBox getTxtKoseiYMD3() {
        return txtKoseiYMD3;
    }

    @JsonProperty("txtKoseiYMD3")
    public void setTxtKoseiYMD3(TextBox txtKoseiYMD3) {
        this.txtKoseiYMD3=txtKoseiYMD3;
    }

    @JsonProperty("txtKoseiYM3")
    public TextBox getTxtKoseiYM3() {
        return txtKoseiYM3;
    }

    @JsonProperty("txtKoseiYM3")
    public void setTxtKoseiYM3(TextBox txtKoseiYM3) {
        this.txtKoseiYM3=txtKoseiYM3;
    }

    @JsonProperty("txtShimei3")
    public TextBox getTxtShimei3() {
        return txtShimei3;
    }

    @JsonProperty("txtShimei3")
    public void setTxtShimei3(TextBox txtShimei3) {
        this.txtShimei3=txtShimei3;
    }

    @JsonProperty("tblChoteiJiyu3")
    public tblChoteiJiyu3Div getTblChoteiJiyu3() {
        return tblChoteiJiyu3;
    }

    @JsonProperty("tblChoteiJiyu3")
    public void setTblChoteiJiyu3(tblChoteiJiyu3Div tblChoteiJiyu3) {
        this.tblChoteiJiyu3=tblChoteiJiyu3;
    }

    @JsonProperty("FukaHikakuFukakijun3")
    public FukaHikakuFukakijun3Div getFukaHikakuFukakijun3() {
        return FukaHikakuFukakijun3;
    }

    @JsonProperty("FukaHikakuFukakijun3")
    public void setFukaHikakuFukakijun3(FukaHikakuFukakijun3Div FukaHikakuFukakijun3) {
        this.FukaHikakuFukakijun3=FukaHikakuFukakijun3;
    }

    @JsonProperty("FukaHikakuHokenryo3")
    public FukaHikakuHokenryo3Div getFukaHikakuHokenryo3() {
        return FukaHikakuHokenryo3;
    }

    @JsonProperty("FukaHikakuHokenryo3")
    public void setFukaHikakuHokenryo3(FukaHikakuHokenryo3Div FukaHikakuHokenryo3) {
        this.FukaHikakuHokenryo3=FukaHikakuHokenryo3;
    }

    @JsonProperty("FukaHikakuKibetsuGaku3")
    public FukaHikakuKibetsuGaku3Div getFukaHikakuKibetsuGaku3() {
        return FukaHikakuKibetsuGaku3;
    }

    @JsonProperty("FukaHikakuKibetsuGaku3")
    public void setFukaHikakuKibetsuGaku3(FukaHikakuKibetsuGaku3Div FukaHikakuKibetsuGaku3) {
        this.FukaHikakuKibetsuGaku3=FukaHikakuKibetsuGaku3;
    }

}
