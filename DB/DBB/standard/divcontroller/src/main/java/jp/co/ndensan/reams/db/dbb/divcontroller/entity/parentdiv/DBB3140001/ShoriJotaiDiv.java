package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB3140001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShoriJotai のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShoriJotaiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgShoriJotai")
    private DataGrid<dgShoriJotai_Row> dgShoriJotai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgShoriJotai
     * @return dgShoriJotai
     */
    @JsonProperty("dgShoriJotai")
    public DataGrid<dgShoriJotai_Row> getDgShoriJotai() {
        return dgShoriJotai;
    }

    /*
     * setdgShoriJotai
     * @param dgShoriJotai dgShoriJotai
     */
    @JsonProperty("dgShoriJotai")
    public void setDgShoriJotai(DataGrid<dgShoriJotai_Row> dgShoriJotai) {
        this.dgShoriJotai = dgShoriJotai;
    }

    // </editor-fold>
}
