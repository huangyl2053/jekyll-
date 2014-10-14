package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe1010002;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * SinseiRiyu のクラスファイル 
 * 
 * @author 自動生成
 */
public class SinseiRiyuDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnTeikeibun")
    private ButtonDialog btnTeikeibun;
    @JsonProperty("txtShinseiRiyu")
    private TextBoxMultiLine txtShinseiRiyu;
    @JsonProperty("teikeiKbn")
    private RString teikeiKbn;
    @JsonProperty("teikeiShubetsu")
    private RString teikeiShubetsu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("btnTeikeibun")
    public ButtonDialog getBtnTeikeibun() {
        return btnTeikeibun;
    }

    @JsonProperty("btnTeikeibun")
    public void setBtnTeikeibun(ButtonDialog btnTeikeibun) {
        this.btnTeikeibun=btnTeikeibun;
    }

    @JsonProperty("txtShinseiRiyu")
    public TextBoxMultiLine getTxtShinseiRiyu() {
        return txtShinseiRiyu;
    }

    @JsonProperty("txtShinseiRiyu")
    public void setTxtShinseiRiyu(TextBoxMultiLine txtShinseiRiyu) {
        this.txtShinseiRiyu=txtShinseiRiyu;
    }

    @JsonProperty("teikeiKbn")
    public RString getTeikeiKbn() {
        return teikeiKbn;
    }

    @JsonProperty("teikeiKbn")
    public void setTeikeiKbn(RString teikeiKbn) {
        this.teikeiKbn=teikeiKbn;
    }

    @JsonProperty("teikeiShubetsu")
    public RString getTeikeiShubetsu() {
        return teikeiShubetsu;
    }

    @JsonProperty("teikeiShubetsu")
    public void setTeikeiShubetsu(RString teikeiShubetsu) {
        this.teikeiShubetsu=teikeiShubetsu;
    }

}
