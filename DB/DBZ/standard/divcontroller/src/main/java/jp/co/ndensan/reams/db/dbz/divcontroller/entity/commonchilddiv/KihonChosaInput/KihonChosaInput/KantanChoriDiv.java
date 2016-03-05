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
 * KantanChori のクラスファイル 
 * 
 * @author 自動生成
 */
public class KantanChoriDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnKantanChori")
    private ButtonDialog btnKantanChori;
    @JsonProperty("radKantanChori")
    private RadioButton radKantanChori;
    @JsonProperty("KantanChoriShinseishoKanriNo")
    private RString KantanChoriShinseishoKanriNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnKantanChori
     * @return btnKantanChori
     */
    @JsonProperty("btnKantanChori")
    public ButtonDialog getBtnKantanChori() {
        return btnKantanChori;
    }

    /*
     * setbtnKantanChori
     * @param btnKantanChori btnKantanChori
     */
    @JsonProperty("btnKantanChori")
    public void setBtnKantanChori(ButtonDialog btnKantanChori) {
        this.btnKantanChori = btnKantanChori;
    }

    /*
     * getradKantanChori
     * @return radKantanChori
     */
    @JsonProperty("radKantanChori")
    public RadioButton getRadKantanChori() {
        return radKantanChori;
    }

    /*
     * setradKantanChori
     * @param radKantanChori radKantanChori
     */
    @JsonProperty("radKantanChori")
    public void setRadKantanChori(RadioButton radKantanChori) {
        this.radKantanChori = radKantanChori;
    }

    /*
     * getKantanChoriShinseishoKanriNo
     * @return KantanChoriShinseishoKanriNo
     */
    @JsonProperty("KantanChoriShinseishoKanriNo")
    public RString getKantanChoriShinseishoKanriNo() {
        return KantanChoriShinseishoKanriNo;
    }

    /*
     * setKantanChoriShinseishoKanriNo
     * @param KantanChoriShinseishoKanriNo KantanChoriShinseishoKanriNo
     */
    @JsonProperty("KantanChoriShinseishoKanriNo")
    public void setKantanChoriShinseishoKanriNo(RString KantanChoriShinseishoKanriNo) {
        this.KantanChoriShinseishoKanriNo = KantanChoriShinseishoKanriNo;
    }

    // </editor-fold>
}
