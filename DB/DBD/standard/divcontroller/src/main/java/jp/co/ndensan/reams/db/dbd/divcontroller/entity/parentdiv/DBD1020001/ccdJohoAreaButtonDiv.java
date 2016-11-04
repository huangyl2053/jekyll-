package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1020001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ccdJohoAreaButton のクラスファイル 
 * 
 * @author 自動生成
 */
public class ccdJohoAreaButtonDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnShinseiKakutei")
    private Button btnShinseiKakutei;
    @JsonProperty("btnConfirm")
    private Button btnConfirm;
    @JsonProperty("btnBackShinseiIchirai")
    private Button btnBackShinseiIchirai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnShinseiKakutei
     * @return btnShinseiKakutei
     */
    @JsonProperty("btnShinseiKakutei")
    public Button getBtnShinseiKakutei() {
        return btnShinseiKakutei;
    }

    /*
     * setbtnShinseiKakutei
     * @param btnShinseiKakutei btnShinseiKakutei
     */
    @JsonProperty("btnShinseiKakutei")
    public void setBtnShinseiKakutei(Button btnShinseiKakutei) {
        this.btnShinseiKakutei = btnShinseiKakutei;
    }

    /*
     * getbtnConfirm
     * @return btnConfirm
     */
    @JsonProperty("btnConfirm")
    public Button getBtnConfirm() {
        return btnConfirm;
    }

    /*
     * setbtnConfirm
     * @param btnConfirm btnConfirm
     */
    @JsonProperty("btnConfirm")
    public void setBtnConfirm(Button btnConfirm) {
        this.btnConfirm = btnConfirm;
    }

    /*
     * getbtnBackShinseiIchirai
     * @return btnBackShinseiIchirai
     */
    @JsonProperty("btnBackShinseiIchirai")
    public Button getBtnBackShinseiIchirai() {
        return btnBackShinseiIchirai;
    }

    /*
     * setbtnBackShinseiIchirai
     * @param btnBackShinseiIchirai btnBackShinseiIchirai
     */
    @JsonProperty("btnBackShinseiIchirai")
    public void setBtnBackShinseiIchirai(Button btnBackShinseiIchirai) {
        this.btnBackShinseiIchirai = btnBackShinseiIchirai;
    }

    // </editor-fold>
}
