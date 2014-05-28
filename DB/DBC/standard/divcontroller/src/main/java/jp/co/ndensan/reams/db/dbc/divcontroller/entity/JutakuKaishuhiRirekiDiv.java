package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgJutakuKaishuRireki_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * JutakuKaishuhiRireki のクラスファイル 
 * 
 * @author 自動生成
 */
public class JutakuKaishuhiRirekiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShinseiDate")
    private TextBoxDate txtShinseiDate;
    @JsonProperty("txtSeiriNo")
    private TextBoxCode txtSeiriNo;
    @JsonProperty("ddlJotaiKubun")
    private DropDownList ddlJotaiKubun;
    @JsonProperty("dgJutakuKaishuRireki")
    private DataGrid<dgJutakuKaishuRireki_Row> dgJutakuKaishuRireki;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtShinseiDate")
    public TextBoxDate getTxtShinseiDate() {
        return txtShinseiDate;
    }

    @JsonProperty("txtShinseiDate")
    public void setTxtShinseiDate(TextBoxDate txtShinseiDate) {
        this.txtShinseiDate=txtShinseiDate;
    }

    @JsonProperty("txtSeiriNo")
    public TextBoxCode getTxtSeiriNo() {
        return txtSeiriNo;
    }

    @JsonProperty("txtSeiriNo")
    public void setTxtSeiriNo(TextBoxCode txtSeiriNo) {
        this.txtSeiriNo=txtSeiriNo;
    }

    @JsonProperty("ddlJotaiKubun")
    public DropDownList getDdlJotaiKubun() {
        return ddlJotaiKubun;
    }

    @JsonProperty("ddlJotaiKubun")
    public void setDdlJotaiKubun(DropDownList ddlJotaiKubun) {
        this.ddlJotaiKubun=ddlJotaiKubun;
    }

    @JsonProperty("dgJutakuKaishuRireki")
    public DataGrid<dgJutakuKaishuRireki_Row> getDgJutakuKaishuRireki() {
        return dgJutakuKaishuRireki;
    }

    @JsonProperty("dgJutakuKaishuRireki")
    public void setDgJutakuKaishuRireki(DataGrid<dgJutakuKaishuRireki_Row> dgJutakuKaishuRireki) {
        this.dgJutakuKaishuRireki=dgJutakuKaishuRireki;
    }

}
