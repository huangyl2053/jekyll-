package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0310001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * Kyotsupanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyotsupanelDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnHonsanteiFukaYoyaku")
    private Button btnHonsanteiFukaYoyaku;
    @JsonProperty("btnHonsanteiFuka")
    private Button btnHonsanteiFuka;
    @JsonProperty("btnTsuchishoHakko")
    private Button btnTsuchishoHakko;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("btnHonsanteiFukaYoyaku")
    public Button getBtnHonsanteiFukaYoyaku() {
        return btnHonsanteiFukaYoyaku;
    }

    @JsonProperty("btnHonsanteiFukaYoyaku")
    public void setBtnHonsanteiFukaYoyaku(Button btnHonsanteiFukaYoyaku) {
        this.btnHonsanteiFukaYoyaku=btnHonsanteiFukaYoyaku;
    }

    @JsonProperty("btnHonsanteiFuka")
    public Button getBtnHonsanteiFuka() {
        return btnHonsanteiFuka;
    }

    @JsonProperty("btnHonsanteiFuka")
    public void setBtnHonsanteiFuka(Button btnHonsanteiFuka) {
        this.btnHonsanteiFuka=btnHonsanteiFuka;
    }

    @JsonProperty("btnTsuchishoHakko")
    public Button getBtnTsuchishoHakko() {
        return btnTsuchishoHakko;
    }

    @JsonProperty("btnTsuchishoHakko")
    public void setBtnTsuchishoHakko(Button btnTsuchishoHakko) {
        this.btnTsuchishoHakko=btnTsuchishoHakko;
    }

}
