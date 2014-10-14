package jp.co.ndensan.reams.db.dbz.divcontroller.entity.kaigoTeikeibun;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.kaigoTeikeibun.dgTeikeibun_Row;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KaigoTeikeibun のクラスファイル 
 * 
 * @author 自動生成
 */
public class KaigoTeikeibunDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlTeikenbunShubetsu")
    private DropDownList ddlTeikenbunShubetsu;
    @JsonProperty("dgTeikeibun")
    private DataGrid<dgTeikeibun_Row> dgTeikeibun;
    @JsonProperty("btnClose")
    private Button btnClose;
    @JsonProperty("teikeiKbn")
    private RString teikeiKbn;
    @JsonProperty("teikeiShubetsu")
    private RString teikeiShubetsu;
    @JsonProperty("teikeibunNaiyo")
    private RString teikeibunNaiyo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ddlTeikenbunShubetsu")
    public DropDownList getDdlTeikenbunShubetsu() {
        return ddlTeikenbunShubetsu;
    }

    @JsonProperty("ddlTeikenbunShubetsu")
    public void setDdlTeikenbunShubetsu(DropDownList ddlTeikenbunShubetsu) {
        this.ddlTeikenbunShubetsu=ddlTeikenbunShubetsu;
    }

    @JsonProperty("dgTeikeibun")
    public DataGrid<dgTeikeibun_Row> getDgTeikeibun() {
        return dgTeikeibun;
    }

    @JsonProperty("dgTeikeibun")
    public void setDgTeikeibun(DataGrid<dgTeikeibun_Row> dgTeikeibun) {
        this.dgTeikeibun=dgTeikeibun;
    }

    @JsonProperty("btnClose")
    public Button getBtnClose() {
        return btnClose;
    }

    @JsonProperty("btnClose")
    public void setBtnClose(Button btnClose) {
        this.btnClose=btnClose;
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

    @JsonProperty("teikeibunNaiyo")
    public RString getTeikeibunNaiyo() {
        return teikeibunNaiyo;
    }

    @JsonProperty("teikeibunNaiyo")
    public void setTeikeibunNaiyo(RString teikeibunNaiyo) {
        this.teikeibunNaiyo=teikeibunNaiyo;
    }

}
