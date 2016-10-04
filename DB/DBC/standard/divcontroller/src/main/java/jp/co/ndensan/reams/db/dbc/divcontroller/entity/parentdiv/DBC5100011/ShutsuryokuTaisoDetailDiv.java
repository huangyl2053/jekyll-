package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC5100011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShutsuryokuTaisoDetail のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShutsuryokuTaisoDetailDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("spc01")
    private Space spc01;
    @JsonProperty("radMeisaiGokeiOut")
    private RadioButton radMeisaiGokeiOut;
    @JsonProperty("chkMeisaiCsvEdit")
    private CheckBoxList chkMeisaiCsvEdit;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getspc01
     * @return spc01
     */
    @JsonProperty("spc01")
    public Space getSpc01() {
        return spc01;
    }

    /*
     * setspc01
     * @param spc01 spc01
     */
    @JsonProperty("spc01")
    public void setSpc01(Space spc01) {
        this.spc01 = spc01;
    }

    /*
     * getradMeisaiGokeiOut
     * @return radMeisaiGokeiOut
     */
    @JsonProperty("radMeisaiGokeiOut")
    public RadioButton getRadMeisaiGokeiOut() {
        return radMeisaiGokeiOut;
    }

    /*
     * setradMeisaiGokeiOut
     * @param radMeisaiGokeiOut radMeisaiGokeiOut
     */
    @JsonProperty("radMeisaiGokeiOut")
    public void setRadMeisaiGokeiOut(RadioButton radMeisaiGokeiOut) {
        this.radMeisaiGokeiOut = radMeisaiGokeiOut;
    }

    /*
     * getchkMeisaiCsvEdit
     * @return chkMeisaiCsvEdit
     */
    @JsonProperty("chkMeisaiCsvEdit")
    public CheckBoxList getChkMeisaiCsvEdit() {
        return chkMeisaiCsvEdit;
    }

    /*
     * setchkMeisaiCsvEdit
     * @param chkMeisaiCsvEdit chkMeisaiCsvEdit
     */
    @JsonProperty("chkMeisaiCsvEdit")
    public void setChkMeisaiCsvEdit(CheckBoxList chkMeisaiCsvEdit) {
        this.chkMeisaiCsvEdit = chkMeisaiCsvEdit;
    }

    // </editor-fold>
}
