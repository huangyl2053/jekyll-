package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA7010011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TajutokuTekiyoJohoIchiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class TajutokuTekiyoJohoIchiranDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgJushochiTokureiRireki")
    private DataGrid<dgJushochiTokureiRireki_Row> dgJushochiTokureiRireki;
    @JsonProperty("ReportPublish")
    private ReportPublishDiv ReportPublish;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgJushochiTokureiRireki
     * @return dgJushochiTokureiRireki
     */
    @JsonProperty("dgJushochiTokureiRireki")
    public DataGrid<dgJushochiTokureiRireki_Row> getDgJushochiTokureiRireki() {
        return dgJushochiTokureiRireki;
    }

    /*
     * setdgJushochiTokureiRireki
     * @param dgJushochiTokureiRireki dgJushochiTokureiRireki
     */
    @JsonProperty("dgJushochiTokureiRireki")
    public void setDgJushochiTokureiRireki(DataGrid<dgJushochiTokureiRireki_Row> dgJushochiTokureiRireki) {
        this.dgJushochiTokureiRireki = dgJushochiTokureiRireki;
    }

    /*
     * getReportPublish
     * @return ReportPublish
     */
    @JsonProperty("ReportPublish")
    public ReportPublishDiv getReportPublish() {
        return ReportPublish;
    }

    /*
     * setReportPublish
     * @param ReportPublish ReportPublish
     */
    @JsonProperty("ReportPublish")
    public void setReportPublish(ReportPublishDiv ReportPublish) {
        this.ReportPublish = ReportPublish;
    }

    // </editor-fold>
}
