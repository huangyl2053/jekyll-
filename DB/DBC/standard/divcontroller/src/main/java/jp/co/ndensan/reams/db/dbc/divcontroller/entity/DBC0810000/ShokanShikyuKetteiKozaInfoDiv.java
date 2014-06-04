package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0810000;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0810000.ShokanShikyuKetteiKozaInfoKozaDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0810000.ShokanShikyuKetteiKozaInfoMadoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ShokanShikyuKetteiKozaInfo のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShokanShikyuKetteiKozaInfoDiv extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShinseiShiharaiKubun")
    private TextBox txtShinseiShiharaiKubun;
    @JsonProperty("ShokanShikyuKetteiKozaInfoMado")
    private ShokanShikyuKetteiKozaInfoMadoDiv ShokanShikyuKetteiKozaInfoMado;
    @JsonProperty("ShokanShikyuKetteiKozaInfoKoza")
    private ShokanShikyuKetteiKozaInfoKozaDiv ShokanShikyuKetteiKozaInfoKoza;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtShinseiShiharaiKubun")
    public TextBox getTxtShinseiShiharaiKubun() {
        return txtShinseiShiharaiKubun;
    }

    @JsonProperty("txtShinseiShiharaiKubun")
    public void setTxtShinseiShiharaiKubun(TextBox txtShinseiShiharaiKubun) {
        this.txtShinseiShiharaiKubun=txtShinseiShiharaiKubun;
    }

    @JsonProperty("ShokanShikyuKetteiKozaInfoMado")
    public ShokanShikyuKetteiKozaInfoMadoDiv getShokanShikyuKetteiKozaInfoMado() {
        return ShokanShikyuKetteiKozaInfoMado;
    }

    @JsonProperty("ShokanShikyuKetteiKozaInfoMado")
    public void setShokanShikyuKetteiKozaInfoMado(ShokanShikyuKetteiKozaInfoMadoDiv ShokanShikyuKetteiKozaInfoMado) {
        this.ShokanShikyuKetteiKozaInfoMado=ShokanShikyuKetteiKozaInfoMado;
    }

    @JsonProperty("ShokanShikyuKetteiKozaInfoKoza")
    public ShokanShikyuKetteiKozaInfoKozaDiv getShokanShikyuKetteiKozaInfoKoza() {
        return ShokanShikyuKetteiKozaInfoKoza;
    }

    @JsonProperty("ShokanShikyuKetteiKozaInfoKoza")
    public void setShokanShikyuKetteiKozaInfoKoza(ShokanShikyuKetteiKozaInfoKozaDiv ShokanShikyuKetteiKozaInfoKoza) {
        this.ShokanShikyuKetteiKozaInfoKoza=ShokanShikyuKetteiKozaInfoKoza;
    }

}
