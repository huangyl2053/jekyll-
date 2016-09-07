package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6090001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * Chosain のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChosainDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgChosain")
    private DataGrid<dgChosain_Row> dgChosain;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgChosain
     * @return dgChosain
     */
    @JsonProperty("dgChosain")
    public DataGrid<dgChosain_Row> getDgChosain() {
        return dgChosain;
    }

    /*
     * setdgChosain
     * @param dgChosain dgChosain
     */
    @JsonProperty("dgChosain")
    public void setDgChosain(DataGrid<dgChosain_Row> dgChosain) {
        this.dgChosain = dgChosain;
    }

    // </editor-fold>
}
