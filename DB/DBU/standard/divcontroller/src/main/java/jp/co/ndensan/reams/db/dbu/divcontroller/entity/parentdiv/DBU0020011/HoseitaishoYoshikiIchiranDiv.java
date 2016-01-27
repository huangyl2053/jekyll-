package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * HoseitaishoYoshikiIchiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class HoseitaishoYoshikiIchiranDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-16_12-38-19">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgHoseitaishoYoshiki")
    private DataGrid<dgHoseitaishoYoshiki_Row> dgHoseitaishoYoshiki;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgHoseitaishoYoshiki
     * @return dgHoseitaishoYoshiki
     */
    @JsonProperty("dgHoseitaishoYoshiki")
    public DataGrid<dgHoseitaishoYoshiki_Row> getDgHoseitaishoYoshiki() {
        return dgHoseitaishoYoshiki;
    }

    /*
     * setdgHoseitaishoYoshiki
     * @param dgHoseitaishoYoshiki dgHoseitaishoYoshiki
     */
    @JsonProperty("dgHoseitaishoYoshiki")
    public void setDgHoseitaishoYoshiki(DataGrid<dgHoseitaishoYoshiki_Row> dgHoseitaishoYoshiki) {
        this.dgHoseitaishoYoshiki = dgHoseitaishoYoshiki;
    }

    // </editor-fold>
}
