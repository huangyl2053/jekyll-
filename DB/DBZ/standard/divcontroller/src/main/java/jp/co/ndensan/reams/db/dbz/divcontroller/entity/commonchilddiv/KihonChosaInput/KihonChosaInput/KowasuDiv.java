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
 * Kowasu のクラスファイル 
 * 
 * @author 自動生成
 */
public class KowasuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnKowasu")
    private ButtonDialog btnKowasu;
    @JsonProperty("radKowasu")
    private RadioButton radKowasu;
    @JsonProperty("KowasuShinseishoKanriNo")
    private RString KowasuShinseishoKanriNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnKowasu
     * @return btnKowasu
     */
    @JsonProperty("btnKowasu")
    public ButtonDialog getBtnKowasu() {
        return btnKowasu;
    }

    /*
     * setbtnKowasu
     * @param btnKowasu btnKowasu
     */
    @JsonProperty("btnKowasu")
    public void setBtnKowasu(ButtonDialog btnKowasu) {
        this.btnKowasu = btnKowasu;
    }

    /*
     * getradKowasu
     * @return radKowasu
     */
    @JsonProperty("radKowasu")
    public RadioButton getRadKowasu() {
        return radKowasu;
    }

    /*
     * setradKowasu
     * @param radKowasu radKowasu
     */
    @JsonProperty("radKowasu")
    public void setRadKowasu(RadioButton radKowasu) {
        this.radKowasu = radKowasu;
    }

    /*
     * getKowasuShinseishoKanriNo
     * @return KowasuShinseishoKanriNo
     */
    @JsonProperty("KowasuShinseishoKanriNo")
    public RString getKowasuShinseishoKanriNo() {
        return KowasuShinseishoKanriNo;
    }

    /*
     * setKowasuShinseishoKanriNo
     * @param KowasuShinseishoKanriNo KowasuShinseishoKanriNo
     */
    @JsonProperty("KowasuShinseishoKanriNo")
    public void setKowasuShinseishoKanriNo(RString KowasuShinseishoKanriNo) {
        this.KowasuShinseishoKanriNo = KowasuShinseishoKanriNo;
    }

    // </editor-fold>
}
