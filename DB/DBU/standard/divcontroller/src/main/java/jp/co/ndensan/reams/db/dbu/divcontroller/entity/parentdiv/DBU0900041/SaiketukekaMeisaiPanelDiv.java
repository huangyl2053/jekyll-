package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0900041;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SaiketukekaMeisaiPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class SaiketukekaMeisaiPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtMultiLineSaiketukeka")
    private TextBoxMultiLine txtMultiLineSaiketukeka;
    @JsonProperty("txtMultiLineSaiketuRiyu")
    private TextBoxMultiLine txtMultiLineSaiketuRiyu;
    @JsonProperty("txtDateBenmeisyoSakuseibi")
    private TextBoxDate txtDateBenmeisyoSakuseibi;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtMultiLineSaiketukeka
     * @return txtMultiLineSaiketukeka
     */
    @JsonProperty("txtMultiLineSaiketukeka")
    public TextBoxMultiLine getTxtMultiLineSaiketukeka() {
        return txtMultiLineSaiketukeka;
    }

    /*
     * settxtMultiLineSaiketukeka
     * @param txtMultiLineSaiketukeka txtMultiLineSaiketukeka
     */
    @JsonProperty("txtMultiLineSaiketukeka")
    public void setTxtMultiLineSaiketukeka(TextBoxMultiLine txtMultiLineSaiketukeka) {
        this.txtMultiLineSaiketukeka = txtMultiLineSaiketukeka;
    }

    /*
     * gettxtMultiLineSaiketuRiyu
     * @return txtMultiLineSaiketuRiyu
     */
    @JsonProperty("txtMultiLineSaiketuRiyu")
    public TextBoxMultiLine getTxtMultiLineSaiketuRiyu() {
        return txtMultiLineSaiketuRiyu;
    }

    /*
     * settxtMultiLineSaiketuRiyu
     * @param txtMultiLineSaiketuRiyu txtMultiLineSaiketuRiyu
     */
    @JsonProperty("txtMultiLineSaiketuRiyu")
    public void setTxtMultiLineSaiketuRiyu(TextBoxMultiLine txtMultiLineSaiketuRiyu) {
        this.txtMultiLineSaiketuRiyu = txtMultiLineSaiketuRiyu;
    }

    /*
     * gettxtDateBenmeisyoSakuseibi
     * @return txtDateBenmeisyoSakuseibi
     */
    @JsonProperty("txtDateBenmeisyoSakuseibi")
    public TextBoxDate getTxtDateBenmeisyoSakuseibi() {
        return txtDateBenmeisyoSakuseibi;
    }

    /*
     * settxtDateBenmeisyoSakuseibi
     * @param txtDateBenmeisyoSakuseibi txtDateBenmeisyoSakuseibi
     */
    @JsonProperty("txtDateBenmeisyoSakuseibi")
    public void setTxtDateBenmeisyoSakuseibi(TextBoxDate txtDateBenmeisyoSakuseibi) {
        this.txtDateBenmeisyoSakuseibi = txtDateBenmeisyoSakuseibi;
    }

    // </editor-fold>
}
