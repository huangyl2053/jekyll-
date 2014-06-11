package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320003;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320003.FukaHikakuFukakijun4Div;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320003.FukaHikakuHokenryo4Div;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320003.FukaHikakuKibetsuGaku4Div;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320003.tblChoteiJiyu3Div;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * HonSantei2 のクラスファイル 
 * 
 * @author 自動生成
 */
public class HonSantei2Div extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtChoteiNendo4")
    private TextBox txtChoteiNendo4;
    @JsonProperty("txtFukaNendo4")
    private TextBox txtFukaNendo4;
    @JsonProperty("txtTsuchiNo4")
    private TextBox txtTsuchiNo4;
    @JsonProperty("txtKoseiYMD4")
    private TextBox txtKoseiYMD4;
    @JsonProperty("txtKoseiYM4")
    private TextBox txtKoseiYM4;
    @JsonProperty("txtShimei4")
    private TextBox txtShimei4;
    @JsonProperty("tblChoteiJiyu3")
    private tblChoteiJiyu3Div tblChoteiJiyu3;
    @JsonProperty("FukaHikakuFukakijun4")
    private FukaHikakuFukakijun4Div FukaHikakuFukakijun4;
    @JsonProperty("FukaHikakuHokenryo4")
    private FukaHikakuHokenryo4Div FukaHikakuHokenryo4;
    @JsonProperty("FukaHikakuKibetsuGaku4")
    private FukaHikakuKibetsuGaku4Div FukaHikakuKibetsuGaku4;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtChoteiNendo4")
    public TextBox getTxtChoteiNendo4() {
        return txtChoteiNendo4;
    }

    @JsonProperty("txtChoteiNendo4")
    public void setTxtChoteiNendo4(TextBox txtChoteiNendo4) {
        this.txtChoteiNendo4=txtChoteiNendo4;
    }

    @JsonProperty("txtFukaNendo4")
    public TextBox getTxtFukaNendo4() {
        return txtFukaNendo4;
    }

    @JsonProperty("txtFukaNendo4")
    public void setTxtFukaNendo4(TextBox txtFukaNendo4) {
        this.txtFukaNendo4=txtFukaNendo4;
    }

    @JsonProperty("txtTsuchiNo4")
    public TextBox getTxtTsuchiNo4() {
        return txtTsuchiNo4;
    }

    @JsonProperty("txtTsuchiNo4")
    public void setTxtTsuchiNo4(TextBox txtTsuchiNo4) {
        this.txtTsuchiNo4=txtTsuchiNo4;
    }

    @JsonProperty("txtKoseiYMD4")
    public TextBox getTxtKoseiYMD4() {
        return txtKoseiYMD4;
    }

    @JsonProperty("txtKoseiYMD4")
    public void setTxtKoseiYMD4(TextBox txtKoseiYMD4) {
        this.txtKoseiYMD4=txtKoseiYMD4;
    }

    @JsonProperty("txtKoseiYM4")
    public TextBox getTxtKoseiYM4() {
        return txtKoseiYM4;
    }

    @JsonProperty("txtKoseiYM4")
    public void setTxtKoseiYM4(TextBox txtKoseiYM4) {
        this.txtKoseiYM4=txtKoseiYM4;
    }

    @JsonProperty("txtShimei4")
    public TextBox getTxtShimei4() {
        return txtShimei4;
    }

    @JsonProperty("txtShimei4")
    public void setTxtShimei4(TextBox txtShimei4) {
        this.txtShimei4=txtShimei4;
    }

    @JsonProperty("tblChoteiJiyu3")
    public tblChoteiJiyu3Div getTblChoteiJiyu3() {
        return tblChoteiJiyu3;
    }

    @JsonProperty("tblChoteiJiyu3")
    public void setTblChoteiJiyu3(tblChoteiJiyu3Div tblChoteiJiyu3) {
        this.tblChoteiJiyu3=tblChoteiJiyu3;
    }

    @JsonProperty("FukaHikakuFukakijun4")
    public FukaHikakuFukakijun4Div getFukaHikakuFukakijun4() {
        return FukaHikakuFukakijun4;
    }

    @JsonProperty("FukaHikakuFukakijun4")
    public void setFukaHikakuFukakijun4(FukaHikakuFukakijun4Div FukaHikakuFukakijun4) {
        this.FukaHikakuFukakijun4=FukaHikakuFukakijun4;
    }

    @JsonProperty("FukaHikakuHokenryo4")
    public FukaHikakuHokenryo4Div getFukaHikakuHokenryo4() {
        return FukaHikakuHokenryo4;
    }

    @JsonProperty("FukaHikakuHokenryo4")
    public void setFukaHikakuHokenryo4(FukaHikakuHokenryo4Div FukaHikakuHokenryo4) {
        this.FukaHikakuHokenryo4=FukaHikakuHokenryo4;
    }

    @JsonProperty("FukaHikakuKibetsuGaku4")
    public FukaHikakuKibetsuGaku4Div getFukaHikakuKibetsuGaku4() {
        return FukaHikakuKibetsuGaku4;
    }

    @JsonProperty("FukaHikakuKibetsuGaku4")
    public void setFukaHikakuKibetsuGaku4(FukaHikakuKibetsuGaku4Div FukaHikakuKibetsuGaku4) {
        this.FukaHikakuKibetsuGaku4=FukaHikakuKibetsuGaku4;
    }

}
