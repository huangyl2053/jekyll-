package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ShokanShikyuTorokuShomeishoRyoyoKinkyujiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ShokanShikyuTorokuShomeishoRyoyoOshinTsuinDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ShokanShikyuTorokuShomeishoRyoyoShikkanDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ShokanShikyuTorokuShomeishoRyoyoTensuDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ShokanShikyuTorokuShomeishoRyoyoMeisai のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShokanShikyuTorokuShomeishoRyoyoMeisaiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShokanShikyuTorokuShomeishoRyoyoShikkan")
    private ShokanShikyuTorokuShomeishoRyoyoShikkanDiv ShokanShikyuTorokuShomeishoRyoyoShikkan;
    @JsonProperty("ShokanShikyuTorokuShomeishoRyoyoKinkyuji")
    private ShokanShikyuTorokuShomeishoRyoyoKinkyujiDiv ShokanShikyuTorokuShomeishoRyoyoKinkyuji;
    @JsonProperty("ShokanShikyuTorokuShomeishoRyoyoOshinTsuin")
    private ShokanShikyuTorokuShomeishoRyoyoOshinTsuinDiv ShokanShikyuTorokuShomeishoRyoyoOshinTsuin;
    @JsonProperty("ShokanShikyuTorokuShomeishoRyoyoTensu")
    private ShokanShikyuTorokuShomeishoRyoyoTensuDiv ShokanShikyuTorokuShomeishoRyoyoTensu;
    @JsonProperty("btnRyoyohiKakutei")
    private Button btnRyoyohiKakutei;
    @JsonProperty("txtRyoyoSelectedIndex")
    private TextBox txtRyoyoSelectedIndex;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ShokanShikyuTorokuShomeishoRyoyoShikkan")
    public ShokanShikyuTorokuShomeishoRyoyoShikkanDiv getShokanShikyuTorokuShomeishoRyoyoShikkan() {
        return ShokanShikyuTorokuShomeishoRyoyoShikkan;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoRyoyoShikkan")
    public void setShokanShikyuTorokuShomeishoRyoyoShikkan(ShokanShikyuTorokuShomeishoRyoyoShikkanDiv ShokanShikyuTorokuShomeishoRyoyoShikkan) {
        this.ShokanShikyuTorokuShomeishoRyoyoShikkan=ShokanShikyuTorokuShomeishoRyoyoShikkan;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoRyoyoKinkyuji")
    public ShokanShikyuTorokuShomeishoRyoyoKinkyujiDiv getShokanShikyuTorokuShomeishoRyoyoKinkyuji() {
        return ShokanShikyuTorokuShomeishoRyoyoKinkyuji;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoRyoyoKinkyuji")
    public void setShokanShikyuTorokuShomeishoRyoyoKinkyuji(ShokanShikyuTorokuShomeishoRyoyoKinkyujiDiv ShokanShikyuTorokuShomeishoRyoyoKinkyuji) {
        this.ShokanShikyuTorokuShomeishoRyoyoKinkyuji=ShokanShikyuTorokuShomeishoRyoyoKinkyuji;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoRyoyoOshinTsuin")
    public ShokanShikyuTorokuShomeishoRyoyoOshinTsuinDiv getShokanShikyuTorokuShomeishoRyoyoOshinTsuin() {
        return ShokanShikyuTorokuShomeishoRyoyoOshinTsuin;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoRyoyoOshinTsuin")
    public void setShokanShikyuTorokuShomeishoRyoyoOshinTsuin(ShokanShikyuTorokuShomeishoRyoyoOshinTsuinDiv ShokanShikyuTorokuShomeishoRyoyoOshinTsuin) {
        this.ShokanShikyuTorokuShomeishoRyoyoOshinTsuin=ShokanShikyuTorokuShomeishoRyoyoOshinTsuin;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoRyoyoTensu")
    public ShokanShikyuTorokuShomeishoRyoyoTensuDiv getShokanShikyuTorokuShomeishoRyoyoTensu() {
        return ShokanShikyuTorokuShomeishoRyoyoTensu;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoRyoyoTensu")
    public void setShokanShikyuTorokuShomeishoRyoyoTensu(ShokanShikyuTorokuShomeishoRyoyoTensuDiv ShokanShikyuTorokuShomeishoRyoyoTensu) {
        this.ShokanShikyuTorokuShomeishoRyoyoTensu=ShokanShikyuTorokuShomeishoRyoyoTensu;
    }

    @JsonProperty("btnRyoyohiKakutei")
    public Button getBtnRyoyohiKakutei() {
        return btnRyoyohiKakutei;
    }

    @JsonProperty("btnRyoyohiKakutei")
    public void setBtnRyoyohiKakutei(Button btnRyoyohiKakutei) {
        this.btnRyoyohiKakutei=btnRyoyohiKakutei;
    }

    @JsonProperty("txtRyoyoSelectedIndex")
    public TextBox getTxtRyoyoSelectedIndex() {
        return txtRyoyoSelectedIndex;
    }

    @JsonProperty("txtRyoyoSelectedIndex")
    public void setTxtRyoyoSelectedIndex(TextBox txtRyoyoSelectedIndex) {
        this.txtRyoyoSelectedIndex=txtRyoyoSelectedIndex;
    }

}
