package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput.KihonChosaInput;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * BigVoice のクラスファイル 
 * 
 * @author 自動生成
 */
public class BigVoiceDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnBigVoice")
    private ButtonDialog btnBigVoice;
    @JsonProperty("radBigVoice")
    private RadioButton radBigVoice;
    @JsonProperty("BigVoiceShinseishoKanriNo")
    private RString BigVoiceShinseishoKanriNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnBigVoice
     * @return btnBigVoice
     */
    @JsonProperty("btnBigVoice")
    public ButtonDialog getBtnBigVoice() {
        return btnBigVoice;
    }

    /*
     * setbtnBigVoice
     * @param btnBigVoice btnBigVoice
     */
    @JsonProperty("btnBigVoice")
    public void setBtnBigVoice(ButtonDialog btnBigVoice) {
        this.btnBigVoice = btnBigVoice;
    }

    /*
     * getradBigVoice
     * @return radBigVoice
     */
    @JsonProperty("radBigVoice")
    public RadioButton getRadBigVoice() {
        return radBigVoice;
    }

    /*
     * setradBigVoice
     * @param radBigVoice radBigVoice
     */
    @JsonProperty("radBigVoice")
    public void setRadBigVoice(RadioButton radBigVoice) {
        this.radBigVoice = radBigVoice;
    }

    /*
     * getBigVoiceShinseishoKanriNo
     * @return BigVoiceShinseishoKanriNo
     */
    @JsonProperty("BigVoiceShinseishoKanriNo")
    public RString getBigVoiceShinseishoKanriNo() {
        return BigVoiceShinseishoKanriNo;
    }

    /*
     * setBigVoiceShinseishoKanriNo
     * @param BigVoiceShinseishoKanriNo BigVoiceShinseishoKanriNo
     */
    @JsonProperty("BigVoiceShinseishoKanriNo")
    public void setBigVoiceShinseishoKanriNo(RString BigVoiceShinseishoKanriNo) {
        this.BigVoiceShinseishoKanriNo = BigVoiceShinseishoKanriNo;
    }

    // </editor-fold>
}
