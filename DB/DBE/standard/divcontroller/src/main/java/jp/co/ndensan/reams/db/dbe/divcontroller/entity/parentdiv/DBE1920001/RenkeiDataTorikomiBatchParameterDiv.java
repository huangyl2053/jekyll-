package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1920001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.HokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * RenkeiDataTorikomiBatchParameter のクラスファイル 
 * 
 * @author 自動生成
 */
public class RenkeiDataTorikomiBatchParameterDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radHoKaisei")
    private RadioButton radHoKaisei;
    @JsonProperty("dgTorikomiTaisho")
    private DataGrid<dgTorikomiTaisho_Row> dgTorikomiTaisho;
    @JsonProperty("listHokennsha")
    private HokenshaListDiv listHokennsha;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradHoKaisei
     * @return radHoKaisei
     */
    @JsonProperty("radHoKaisei")
    public RadioButton getRadHoKaisei() {
        return radHoKaisei;
    }

    /*
     * setradHoKaisei
     * @param radHoKaisei radHoKaisei
     */
    @JsonProperty("radHoKaisei")
    public void setRadHoKaisei(RadioButton radHoKaisei) {
        this.radHoKaisei = radHoKaisei;
    }

    /*
     * getdgTorikomiTaisho
     * @return dgTorikomiTaisho
     */
    @JsonProperty("dgTorikomiTaisho")
    public DataGrid<dgTorikomiTaisho_Row> getDgTorikomiTaisho() {
        return dgTorikomiTaisho;
    }

    /*
     * setdgTorikomiTaisho
     * @param dgTorikomiTaisho dgTorikomiTaisho
     */
    @JsonProperty("dgTorikomiTaisho")
    public void setDgTorikomiTaisho(DataGrid<dgTorikomiTaisho_Row> dgTorikomiTaisho) {
        this.dgTorikomiTaisho = dgTorikomiTaisho;
    }

    /*
     * getlistHokennsha
     * @return listHokennsha
     */
    @JsonProperty("listHokennsha")
    public IHokenshaListDiv getListHokennsha() {
        return listHokennsha;
    }

    // </editor-fold>
}
