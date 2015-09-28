package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0120001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * HeijunkaShoriKakunin のクラスファイル 
 * 
 * @author 自動生成
 */
public class HeijunkaShoriKakuninDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-49">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgHeijunkaShoriKakunin1")
    private DataGrid<dgHeijunkaShoriKakunin1_Row> dgHeijunkaShoriKakunin1;
    @JsonProperty("lblShoriKakunin1")
    private Label lblShoriKakunin1;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("dgHeijunkaShoriKakunin1")
    public DataGrid<dgHeijunkaShoriKakunin1_Row> getDgHeijunkaShoriKakunin1() {
        return dgHeijunkaShoriKakunin1;
    }

    @JsonProperty("dgHeijunkaShoriKakunin1")
    public void setDgHeijunkaShoriKakunin1(DataGrid<dgHeijunkaShoriKakunin1_Row> dgHeijunkaShoriKakunin1) {
        this.dgHeijunkaShoriKakunin1=dgHeijunkaShoriKakunin1;
    }

    @JsonProperty("lblShoriKakunin1")
    public Label getLblShoriKakunin1() {
        return lblShoriKakunin1;
    }

    @JsonProperty("lblShoriKakunin1")
    public void setLblShoriKakunin1(Label lblShoriKakunin1) {
        this.lblShoriKakunin1=lblShoriKakunin1;
    }

    // </editor-fold>
}
