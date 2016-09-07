package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1070011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * tplTennyu のクラスファイル 
 * 
 * @author 自動生成
 */
public class tplTennyuDiv extends TabPanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgTennyu")
    private DataGrid<dgTennyu_Row> dgTennyu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgTennyu
     * @return dgTennyu
     */
    @JsonProperty("dgTennyu")
    public DataGrid<dgTennyu_Row> getDgTennyu() {
        return dgTennyu;
    }

    /*
     * setdgTennyu
     * @param dgTennyu dgTennyu
     */
    @JsonProperty("dgTennyu")
    public void setDgTennyu(DataGrid<dgTennyu_Row> dgTennyu) {
        this.dgTennyu = dgTennyu;
    }

    // </editor-fold>
}
