package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.JutakuKaishuShinseiDetailInput;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.JutakuKaishuShinseiDetailInput.IJutakuKaishuShinseiDetailInputDiv;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JutakuKaishuShinseiDetailInput のクラスファイル 
 * 
 * @author 自動生成
 */
public class JutakuKaishuShinseiDetailInputDiv extends Panel implements IJutakuKaishuShinseiDetailInputDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-49">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgJutakuKaishuDetail")
    private DataGrid<dgJutakuKaishuDetail_Row> dgJutakuKaishuDetail;
    @JsonProperty("JutakuKaishuDetailInput")
    private JutakuKaishuDetailInputDiv JutakuKaishuDetailInput;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("dgJutakuKaishuDetail")
    public DataGrid<dgJutakuKaishuDetail_Row> getDgJutakuKaishuDetail() {
        return dgJutakuKaishuDetail;
    }

    @JsonProperty("dgJutakuKaishuDetail")
    public void setDgJutakuKaishuDetail(DataGrid<dgJutakuKaishuDetail_Row> dgJutakuKaishuDetail) {
        this.dgJutakuKaishuDetail=dgJutakuKaishuDetail;
    }

    @JsonProperty("JutakuKaishuDetailInput")
    public JutakuKaishuDetailInputDiv getJutakuKaishuDetailInput() {
        return JutakuKaishuDetailInput;
    }

    @JsonProperty("JutakuKaishuDetailInput")
    public void setJutakuKaishuDetailInput(JutakuKaishuDetailInputDiv JutakuKaishuDetailInput) {
        this.JutakuKaishuDetailInput=JutakuKaishuDetailInput;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
