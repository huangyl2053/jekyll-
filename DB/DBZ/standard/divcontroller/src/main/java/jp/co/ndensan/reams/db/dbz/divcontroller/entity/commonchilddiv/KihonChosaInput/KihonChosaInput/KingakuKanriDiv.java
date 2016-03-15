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
 * KingakuKanri のクラスファイル 
 * 
 * @author 自動生成
 */
public class KingakuKanriDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnKingakuKanri")
    private ButtonDialog btnKingakuKanri;
    @JsonProperty("radKingakuKanri")
    private RadioButton radKingakuKanri;
    @JsonProperty("KingakuKanriShinseishoKanriNo")
    private RString KingakuKanriShinseishoKanriNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnKingakuKanri
     * @return btnKingakuKanri
     */
    @JsonProperty("btnKingakuKanri")
    public ButtonDialog getBtnKingakuKanri() {
        return btnKingakuKanri;
    }

    /*
     * setbtnKingakuKanri
     * @param btnKingakuKanri btnKingakuKanri
     */
    @JsonProperty("btnKingakuKanri")
    public void setBtnKingakuKanri(ButtonDialog btnKingakuKanri) {
        this.btnKingakuKanri = btnKingakuKanri;
    }

    /*
     * getradKingakuKanri
     * @return radKingakuKanri
     */
    @JsonProperty("radKingakuKanri")
    public RadioButton getRadKingakuKanri() {
        return radKingakuKanri;
    }

    /*
     * setradKingakuKanri
     * @param radKingakuKanri radKingakuKanri
     */
    @JsonProperty("radKingakuKanri")
    public void setRadKingakuKanri(RadioButton radKingakuKanri) {
        this.radKingakuKanri = radKingakuKanri;
    }

    /*
     * getKingakuKanriShinseishoKanriNo
     * @return KingakuKanriShinseishoKanriNo
     */
    @JsonProperty("KingakuKanriShinseishoKanriNo")
    public RString getKingakuKanriShinseishoKanriNo() {
        return KingakuKanriShinseishoKanriNo;
    }

    /*
     * setKingakuKanriShinseishoKanriNo
     * @param KingakuKanriShinseishoKanriNo KingakuKanriShinseishoKanriNo
     */
    @JsonProperty("KingakuKanriShinseishoKanriNo")
    public void setKingakuKanriShinseishoKanriNo(RString KingakuKanriShinseishoKanriNo) {
        this.KingakuKanriShinseishoKanriNo = KingakuKanriShinseishoKanriNo;
    }

    // </editor-fold>
}
