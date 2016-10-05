package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1100011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KogakuGassanShikyuShinseiTorokuFooter のクラスファイル
 *
 * @reamsid_L DBC-2040-030 huzongcheng
 */
public class KogakuGassanShikyuShinseiTorokuFooterDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnKakuteiShintei")
    private Button btnKakuteiShintei;
    @JsonProperty("btnBackShinseiIchiran")
    private Button btnBackShinseiIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnKakuteiShintei
     * @return btnKakuteiShintei
     */
    @JsonProperty("btnKakuteiShintei")
    public Button getBtnKakuteiShintei() {
        return btnKakuteiShintei;
    }

    /*
     * setbtnKakuteiShintei
     * @param btnKakuteiShintei btnKakuteiShintei
     */
    @JsonProperty("btnKakuteiShintei")
    public void setBtnKakuteiShintei(Button btnKakuteiShintei) {
        this.btnKakuteiShintei = btnKakuteiShintei;
    }

    /*
     * getbtnBackShinseiIchiran
     * @return btnBackShinseiIchiran
     */
    @JsonProperty("btnBackShinseiIchiran")
    public Button getBtnBackShinseiIchiran() {
        return btnBackShinseiIchiran;
    }

    /*
     * setbtnBackShinseiIchiran
     * @param btnBackShinseiIchiran btnBackShinseiIchiran
     */
    @JsonProperty("btnBackShinseiIchiran")
    public void setBtnBackShinseiIchiran(Button btnBackShinseiIchiran) {
        this.btnBackShinseiIchiran = btnBackShinseiIchiran;
    }

    // </editor-fold>
}
