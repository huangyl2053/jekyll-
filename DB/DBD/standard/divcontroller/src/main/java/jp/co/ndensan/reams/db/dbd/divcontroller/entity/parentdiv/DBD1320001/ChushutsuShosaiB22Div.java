package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1320001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ChushutsuShosaiB22 のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChushutsuShosaiB22Div extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radHaniJoken2")
    private RadioButton radHaniJoken2;
    @JsonProperty("chkShinseishaNomi")
    private CheckBoxList chkShinseishaNomi;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradHaniJoken2
     * @return radHaniJoken2
     */
    @JsonProperty("radHaniJoken2")
    public RadioButton getRadHaniJoken2() {
        return radHaniJoken2;
    }

    /*
     * setradHaniJoken2
     * @param radHaniJoken2 radHaniJoken2
     */
    @JsonProperty("radHaniJoken2")
    public void setRadHaniJoken2(RadioButton radHaniJoken2) {
        this.radHaniJoken2 = radHaniJoken2;
    }

    /*
     * getchkShinseishaNomi
     * @return chkShinseishaNomi
     */
    @JsonProperty("chkShinseishaNomi")
    public CheckBoxList getChkShinseishaNomi() {
        return chkShinseishaNomi;
    }

    /*
     * setchkShinseishaNomi
     * @param chkShinseishaNomi chkShinseishaNomi
     */
    @JsonProperty("chkShinseishaNomi")
    public void setChkShinseishaNomi(CheckBoxList chkShinseishaNomi) {
        this.chkShinseishaNomi = chkShinseishaNomi;
    }

    // </editor-fold>
}
