package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4050001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShoriTaishoshaIchiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShoriTaishoshaIchiranDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgImageMaskShoriTaishosha")
    private DataGrid<dgImageMaskShoriTaishosha_Row> dgImageMaskShoriTaishosha;
    @JsonProperty("btnSaiKensaku")
    private Button btnSaiKensaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgImageMaskShoriTaishosha
     * @return dgImageMaskShoriTaishosha
     */
    @JsonProperty("dgImageMaskShoriTaishosha")
    public DataGrid<dgImageMaskShoriTaishosha_Row> getDgImageMaskShoriTaishosha() {
        return dgImageMaskShoriTaishosha;
    }

    /*
     * setdgImageMaskShoriTaishosha
     * @param dgImageMaskShoriTaishosha dgImageMaskShoriTaishosha
     */
    @JsonProperty("dgImageMaskShoriTaishosha")
    public void setDgImageMaskShoriTaishosha(DataGrid<dgImageMaskShoriTaishosha_Row> dgImageMaskShoriTaishosha) {
        this.dgImageMaskShoriTaishosha = dgImageMaskShoriTaishosha;
    }

    /*
     * getbtnSaiKensaku
     * @return btnSaiKensaku
     */
    @JsonProperty("btnSaiKensaku")
    public Button getBtnSaiKensaku() {
        return btnSaiKensaku;
    }

    /*
     * setbtnSaiKensaku
     * @param btnSaiKensaku btnSaiKensaku
     */
    @JsonProperty("btnSaiKensaku")
    public void setBtnSaiKensaku(Button btnSaiKensaku) {
        this.btnSaiKensaku = btnSaiKensaku;
    }

    // </editor-fold>
}
