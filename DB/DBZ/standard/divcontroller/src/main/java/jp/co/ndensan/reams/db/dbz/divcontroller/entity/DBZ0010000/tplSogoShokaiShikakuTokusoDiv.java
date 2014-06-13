package jp.co.ndensan.reams.db.dbz.divcontroller.entity.DBZ0010000;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * tplSogoShokaiShikakuTokuso のクラスファイル 
 * 
 * @author 自動生成
 */
public class tplSogoShokaiShikakuTokusoDiv extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnHokenKanyuInfo")
    private ButtonDialog btnHokenKanyuInfo;
    @JsonProperty("dgSogoShokaiShikakuTokusoList")
    private DataGrid<dgSogoShokaiShikakuTokusoList_Row> dgSogoShokaiShikakuTokusoList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("btnHokenKanyuInfo")
    public ButtonDialog getBtnHokenKanyuInfo() {
        return btnHokenKanyuInfo;
    }

    @JsonProperty("btnHokenKanyuInfo")
    public void setBtnHokenKanyuInfo(ButtonDialog btnHokenKanyuInfo) {
        this.btnHokenKanyuInfo=btnHokenKanyuInfo;
    }

    @JsonProperty("dgSogoShokaiShikakuTokusoList")
    public DataGrid<dgSogoShokaiShikakuTokusoList_Row> getDgSogoShokaiShikakuTokusoList() {
        return dgSogoShokaiShikakuTokusoList;
    }

    @JsonProperty("dgSogoShokaiShikakuTokusoList")
    public void setDgSogoShokaiShikakuTokusoList(DataGrid<dgSogoShokaiShikakuTokusoList_Row> dgSogoShokaiShikakuTokusoList) {
        this.dgSogoShokaiShikakuTokusoList=dgSogoShokaiShikakuTokusoList;
    }

}
