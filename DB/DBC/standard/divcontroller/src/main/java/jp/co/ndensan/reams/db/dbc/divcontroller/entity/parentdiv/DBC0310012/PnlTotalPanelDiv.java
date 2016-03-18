package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0310012;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * PnlTotalPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class PnlTotalPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("PnlCommon")
    private PnlCommonDiv PnlCommon;
    @JsonProperty("PnlMsgPrint")
    private PnlMsgPrintDiv PnlMsgPrint;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getPnlCommon
     * @return PnlCommon
     */
    @JsonProperty("PnlCommon")
    public PnlCommonDiv getPnlCommon() {
        return PnlCommon;
    }

    /*
     * setPnlCommon
     * @param PnlCommon PnlCommon
     */
    @JsonProperty("PnlCommon")
    public void setPnlCommon(PnlCommonDiv PnlCommon) {
        this.PnlCommon = PnlCommon;
    }

    /*
     * getPnlMsgPrint
     * @return PnlMsgPrint
     */
    @JsonProperty("PnlMsgPrint")
    public PnlMsgPrintDiv getPnlMsgPrint() {
        return PnlMsgPrint;
    }

    /*
     * setPnlMsgPrint
     * @param PnlMsgPrint PnlMsgPrint
     */
    @JsonProperty("PnlMsgPrint")
    public void setPnlMsgPrint(PnlMsgPrintDiv PnlMsgPrint) {
        this.PnlMsgPrint = PnlMsgPrint;
    }

    // </editor-fold>
}
