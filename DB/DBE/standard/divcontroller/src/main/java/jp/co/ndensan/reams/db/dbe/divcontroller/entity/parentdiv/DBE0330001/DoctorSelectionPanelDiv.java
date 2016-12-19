package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0330001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * DoctorSelectionPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class DoctorSelectionPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgDoctorSelection")
    private DataGrid<dgDoctorSelection_Row> dgDoctorSelection;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgDoctorSelection
     * @return dgDoctorSelection
     */
    @JsonProperty("dgDoctorSelection")
    public DataGrid<dgDoctorSelection_Row> getDgDoctorSelection() {
        return dgDoctorSelection;
    }

    /*
     * setdgDoctorSelection
     * @param dgDoctorSelection dgDoctorSelection
     */
    @JsonProperty("dgDoctorSelection")
    public void setDgDoctorSelection(DataGrid<dgDoctorSelection_Row> dgDoctorSelection) {
        this.dgDoctorSelection = dgDoctorSelection;
    }

    // </editor-fold>
}
