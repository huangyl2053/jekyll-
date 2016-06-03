package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2010013;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JigyoshaServiceList のクラスファイル 
 * 
 * 
 */
public class JigyoshaServiceListDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgJigyoshaServiceList")
    private DataGrid<dgJigyoshaServiceList_Row> dgJigyoshaServiceList;
    @JsonProperty("btnServiceIkkatsu")
    private Button btnServiceIkkatsu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgJigyoshaServiceList
     * @return dgJigyoshaServiceList
     */
    @JsonProperty("dgJigyoshaServiceList")
    public DataGrid<dgJigyoshaServiceList_Row> getDgJigyoshaServiceList() {
        return dgJigyoshaServiceList;
    }

    /*
     * setdgJigyoshaServiceList
     * @param dgJigyoshaServiceList dgJigyoshaServiceList
     */
    @JsonProperty("dgJigyoshaServiceList")
    public void setDgJigyoshaServiceList(DataGrid<dgJigyoshaServiceList_Row> dgJigyoshaServiceList) {
        this.dgJigyoshaServiceList = dgJigyoshaServiceList;
    }

    /*
     * getbtnServiceIkkatsu
     * @return btnServiceIkkatsu
     */
    @JsonProperty("btnServiceIkkatsu")
    public Button getBtnServiceIkkatsu() {
        return btnServiceIkkatsu;
    }

    /*
     * setbtnServiceIkkatsu
     * @param btnServiceIkkatsu btnServiceIkkatsu
     */
    @JsonProperty("btnServiceIkkatsu")
    public void setBtnServiceIkkatsu(Button btnServiceIkkatsu) {
        this.btnServiceIkkatsu = btnServiceIkkatsu;
    }

    // </editor-fold>
}
