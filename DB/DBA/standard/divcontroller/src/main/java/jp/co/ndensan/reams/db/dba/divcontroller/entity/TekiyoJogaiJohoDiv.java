package jp.co.ndensan.reams.db.dba.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.TekiyoJogaiTorokuDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dgTekiyoJogaiRireki_Row;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * TekiyoJogaiJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class TekiyoJogaiJohoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgTekiyoJogaiRireki")
    private DataGrid<dgTekiyoJogaiRireki_Row> dgTekiyoJogaiRireki;
    @JsonProperty("TekiyoJogaiToroku")
    private TekiyoJogaiTorokuDiv TekiyoJogaiToroku;
    @JsonProperty("selectedRows")
    private RString selectedRows;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("dgTekiyoJogaiRireki")
    public DataGrid<dgTekiyoJogaiRireki_Row> getDgTekiyoJogaiRireki() {
        return dgTekiyoJogaiRireki;
    }

    @JsonProperty("dgTekiyoJogaiRireki")
    public void setDgTekiyoJogaiRireki(DataGrid<dgTekiyoJogaiRireki_Row> dgTekiyoJogaiRireki) {
        this.dgTekiyoJogaiRireki=dgTekiyoJogaiRireki;
    }

    @JsonProperty("TekiyoJogaiToroku")
    public TekiyoJogaiTorokuDiv getTekiyoJogaiToroku() {
        return TekiyoJogaiToroku;
    }

    @JsonProperty("TekiyoJogaiToroku")
    public void setTekiyoJogaiToroku(TekiyoJogaiTorokuDiv TekiyoJogaiToroku) {
        this.TekiyoJogaiToroku=TekiyoJogaiToroku;
    }

    @JsonProperty("selectedRows")
    public RString getSelectedRows() {
        return selectedRows;
    }

    @JsonProperty("selectedRows")
    public void setSelectedRows(RString selectedRows) {
        this.selectedRows=selectedRows;
    }

}
