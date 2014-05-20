package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.tblSeikyuSummaryDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SeikyuSummary のクラスファイル 
 * 
 * @author 自動生成
 */
public class SeikyuSummaryDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tblSeikyuSummary")
    private tblSeikyuSummaryDiv tblSeikyuSummary;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("tblSeikyuSummary")
    public tblSeikyuSummaryDiv getTblSeikyuSummary() {
        return tblSeikyuSummary;
    }

    @JsonProperty("tblSeikyuSummary")
    public void setTblSeikyuSummary(tblSeikyuSummaryDiv tblSeikyuSummary) {
        this.tblSeikyuSummary=tblSeikyuSummary;
    }

}
