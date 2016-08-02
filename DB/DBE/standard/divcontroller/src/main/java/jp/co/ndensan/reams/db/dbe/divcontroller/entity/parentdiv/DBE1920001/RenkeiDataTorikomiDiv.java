package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1920001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.UploadPanel;

/**
 * RenkeiDataTorikomi のクラスファイル
 *
 * @author 自動生成
 */
public class RenkeiDataTorikomiDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("RenkeiDataTorikomiBatchParameter")
    private RenkeiDataTorikomiBatchParameterDiv RenkeiDataTorikomiBatchParameter;
    @JsonProperty("torikomiichiran")
    private torikomiichiranDiv torikomiichiran;
    @JsonProperty("uploadArea")
    private uploadAreaDiv uploadArea;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getRenkeiDataTorikomiBatchParameter
     * @return RenkeiDataTorikomiBatchParameter
     */
    @JsonProperty("RenkeiDataTorikomiBatchParameter")
    public RenkeiDataTorikomiBatchParameterDiv getRenkeiDataTorikomiBatchParameter() {
        return RenkeiDataTorikomiBatchParameter;
    }

    /*
     * setRenkeiDataTorikomiBatchParameter
     * @param RenkeiDataTorikomiBatchParameter RenkeiDataTorikomiBatchParameter
     */
    @JsonProperty("RenkeiDataTorikomiBatchParameter")
    public void setRenkeiDataTorikomiBatchParameter(RenkeiDataTorikomiBatchParameterDiv RenkeiDataTorikomiBatchParameter) {
        this.RenkeiDataTorikomiBatchParameter = RenkeiDataTorikomiBatchParameter;
    }

    /*
     * gettorikomiichiran
     * @return torikomiichiran
     */
    @JsonProperty("torikomiichiran")
    public torikomiichiranDiv getTorikomiichiran() {
        return torikomiichiran;
    }

    /*
     * settorikomiichiran
     * @param torikomiichiran torikomiichiran
     */
    @JsonProperty("torikomiichiran")
    public void setTorikomiichiran(torikomiichiranDiv torikomiichiran) {
        this.torikomiichiran = torikomiichiran;
    }

    /*
     * getuploadArea
     * @return uploadArea
     */
    @JsonProperty("uploadArea")
    public uploadAreaDiv getUploadArea() {
        return uploadArea;
    }

    /*
     * setuploadArea
     * @param uploadArea uploadArea
     */
    @JsonProperty("uploadArea")
    public void setUploadArea(uploadAreaDiv uploadArea) {
        this.uploadArea = uploadArea;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadHoKaisei() {
        return this.getRenkeiDataTorikomiBatchParameter().getRadHoKaisei();
    }

    @JsonIgnore
    public void setRadHoKaisei(RadioButton radHoKaisei) {
        this.getRenkeiDataTorikomiBatchParameter().setRadHoKaisei(radHoKaisei);
    }

    @JsonIgnore
    public DataGrid<dgTorikomiTaisho_Row> getDgTorikomiTaisho() {
        return this.getRenkeiDataTorikomiBatchParameter().getDgTorikomiTaisho();
    }

    @JsonIgnore
    public void setDgTorikomiTaisho(DataGrid<dgTorikomiTaisho_Row> dgTorikomiTaisho) {
        this.getRenkeiDataTorikomiBatchParameter().setDgTorikomiTaisho(dgTorikomiTaisho);
    }

    @JsonIgnore
    public Button getBtnDataTorikomi() {
        return this.getRenkeiDataTorikomiBatchParameter().getBtnDataTorikomi();
    }

    @JsonIgnore
    public void setBtnDataTorikomi(Button btnDataTorikomi) {
        this.getRenkeiDataTorikomiBatchParameter().setBtnDataTorikomi(btnDataTorikomi);
    }

    @JsonIgnore
    public IHokenshaListDiv getListHokennsha() {
        return this.getRenkeiDataTorikomiBatchParameter().getListHokennsha();
    }

    @JsonIgnore
    public DataGrid<dgtorikomidataichiran_Row> getDgtorikomidataichiran() {
        return this.getTorikomiichiran().getDgtorikomidataichiran();
    }

    @JsonIgnore
    public void setDgtorikomidataichiran(DataGrid<dgtorikomidataichiran_Row> dgtorikomidataichiran) {
        this.getTorikomiichiran().setDgtorikomidataichiran(dgtorikomidataichiran);
    }

    @JsonIgnore
    public UploadPanel getUploadTool() {
        return this.getUploadArea().getUploadTool();
    }

    @JsonIgnore
    public void setUploadTool(UploadPanel uploadTool) {
        this.getUploadArea().setUploadTool(uploadTool);
    }

    // </editor-fold>
}
