package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0110001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TokutyoKariSanteiKanriInfo のクラスファイル 
 * 
 * @author 自動生成
 */
public class TokutyoKariSanteiKanriInfoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-49">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgKanrijoho1")
    private DataGrid<dgKanrijoho1_Row> dgKanrijoho1;
    @JsonProperty("dgKanrijoho2")
    private DataGrid<dgKanrijoho2_Row> dgKanrijoho2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("dgKanrijoho1")
    public DataGrid<dgKanrijoho1_Row> getDgKanrijoho1() {
        return dgKanrijoho1;
    }

    @JsonProperty("dgKanrijoho1")
    public void setDgKanrijoho1(DataGrid<dgKanrijoho1_Row> dgKanrijoho1) {
        this.dgKanrijoho1=dgKanrijoho1;
    }

    @JsonProperty("dgKanrijoho2")
    public DataGrid<dgKanrijoho2_Row> getDgKanrijoho2() {
        return dgKanrijoho2;
    }

    @JsonProperty("dgKanrijoho2")
    public void setDgKanrijoho2(DataGrid<dgKanrijoho2_Row> dgKanrijoho2) {
        this.dgKanrijoho2=dgKanrijoho2;
    }

    // </editor-fold>
}
