package jp.co.ndensan.reams.db.dbe.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.tblIkensho5KomokuDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * Ikensho5Komoku のクラスファイル 
 * 
 * @author 自動生成
 */
public class Ikensho5KomokuDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tblIkensho5Komoku")
    private tblIkensho5KomokuDiv tblIkensho5Komoku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("tblIkensho5Komoku")
    public tblIkensho5KomokuDiv getTblIkensho5Komoku() {
        return tblIkensho5Komoku;
    }

    @JsonProperty("tblIkensho5Komoku")
    public void setTblIkensho5Komoku(tblIkensho5KomokuDiv tblIkensho5Komoku) {
        this.tblIkensho5Komoku=tblIkensho5Komoku;
    }

}
