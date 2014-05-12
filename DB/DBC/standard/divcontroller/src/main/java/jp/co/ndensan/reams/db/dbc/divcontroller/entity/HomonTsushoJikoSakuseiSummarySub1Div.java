package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.tblHomonTsushoJikoSakuseiSummarySub1Div;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * HomonTsushoJikoSakuseiSummarySub1 のクラスファイル 
 * 
 * @author 自動生成
 */
public class HomonTsushoJikoSakuseiSummarySub1Div extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tblHomonTsushoJikoSakuseiSummarySub1")
    private tblHomonTsushoJikoSakuseiSummarySub1Div tblHomonTsushoJikoSakuseiSummarySub1;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("tblHomonTsushoJikoSakuseiSummarySub1")
    public tblHomonTsushoJikoSakuseiSummarySub1Div getTblHomonTsushoJikoSakuseiSummarySub1() {
        return tblHomonTsushoJikoSakuseiSummarySub1;
    }

    @JsonProperty("tblHomonTsushoJikoSakuseiSummarySub1")
    public void setTblHomonTsushoJikoSakuseiSummarySub1(tblHomonTsushoJikoSakuseiSummarySub1Div tblHomonTsushoJikoSakuseiSummarySub1) {
        this.tblHomonTsushoJikoSakuseiSummarySub1=tblHomonTsushoJikoSakuseiSummarySub1;
    }

}
