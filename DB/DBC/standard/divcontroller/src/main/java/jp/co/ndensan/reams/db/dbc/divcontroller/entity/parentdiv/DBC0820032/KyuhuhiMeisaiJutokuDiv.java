package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820032;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KyuhuhiMeisaiJutoku のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyuhuhiMeisaiJutokuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("PnlAtenaCommon")
    private PnlAtenaCommonDiv PnlAtenaCommon;
    @JsonProperty("PnlBtnDetail")
    private PnlBtnDetailDiv PnlBtnDetail;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getPnlAtenaCommon
     * @return PnlAtenaCommon
     */
    @JsonProperty("PnlAtenaCommon")
    public PnlAtenaCommonDiv getPnlAtenaCommon() {
        return PnlAtenaCommon;
    }

    /*
     * setPnlAtenaCommon
     * @param PnlAtenaCommon PnlAtenaCommon
     */
    @JsonProperty("PnlAtenaCommon")
    public void setPnlAtenaCommon(PnlAtenaCommonDiv PnlAtenaCommon) {
        this.PnlAtenaCommon = PnlAtenaCommon;
    }

    /*
     * getPnlBtnDetail
     * @return PnlBtnDetail
     */
    @JsonProperty("PnlBtnDetail")
    public PnlBtnDetailDiv getPnlBtnDetail() {
        return PnlBtnDetail;
    }

    /*
     * setPnlBtnDetail
     * @param PnlBtnDetail PnlBtnDetail
     */
    @JsonProperty("PnlBtnDetail")
    public void setPnlBtnDetail(PnlBtnDetailDiv PnlBtnDetail) {
        this.PnlBtnDetail = PnlBtnDetail;
    }

    // </editor-fold>
}
