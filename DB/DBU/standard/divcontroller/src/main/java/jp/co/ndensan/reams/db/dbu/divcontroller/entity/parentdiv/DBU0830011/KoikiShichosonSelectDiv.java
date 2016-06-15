package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0830011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KoikiShichosonSelect のクラスファイル 
 * 
 * @author 自動生成
 */
public class KoikiShichosonSelectDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgKoikiShichosonSelect")
    private DataGrid<dgKoikiShichosonSelect_Row> dgKoikiShichosonSelect;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgKoikiShichosonSelect
     * @return dgKoikiShichosonSelect
     */
    @JsonProperty("dgKoikiShichosonSelect")
    public DataGrid<dgKoikiShichosonSelect_Row> getDgKoikiShichosonSelect() {
        return dgKoikiShichosonSelect;
    }

    /*
     * setdgKoikiShichosonSelect
     * @param dgKoikiShichosonSelect dgKoikiShichosonSelect
     */
    @JsonProperty("dgKoikiShichosonSelect")
    public void setDgKoikiShichosonSelect(DataGrid<dgKoikiShichosonSelect_Row> dgKoikiShichosonSelect) {
        this.dgKoikiShichosonSelect = dgKoikiShichosonSelect;
    }

    // </editor-fold>
}
