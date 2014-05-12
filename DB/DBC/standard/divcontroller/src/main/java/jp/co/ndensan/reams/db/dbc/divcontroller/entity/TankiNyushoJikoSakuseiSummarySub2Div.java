package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.tblTankiNyushoJikoSakuseiSummarySub3Div;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TankiNyushoJikoSakuseiSummarySub2 のクラスファイル 
 * 
 * @author 自動生成
 */
public class TankiNyushoJikoSakuseiSummarySub2Div extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tblTankiNyushoJikoSakuseiSummarySub3")
    private tblTankiNyushoJikoSakuseiSummarySub3Div tblTankiNyushoJikoSakuseiSummarySub3;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("tblTankiNyushoJikoSakuseiSummarySub3")
    public tblTankiNyushoJikoSakuseiSummarySub3Div getTblTankiNyushoJikoSakuseiSummarySub3() {
        return tblTankiNyushoJikoSakuseiSummarySub3;
    }

    @JsonProperty("tblTankiNyushoJikoSakuseiSummarySub3")
    public void setTblTankiNyushoJikoSakuseiSummarySub3(tblTankiNyushoJikoSakuseiSummarySub3Div tblTankiNyushoJikoSakuseiSummarySub3) {
        this.tblTankiNyushoJikoSakuseiSummarySub3=tblTankiNyushoJikoSakuseiSummarySub3;
    }

}
