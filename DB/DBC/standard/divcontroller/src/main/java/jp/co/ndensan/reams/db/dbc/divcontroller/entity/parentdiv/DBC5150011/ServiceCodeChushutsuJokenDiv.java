package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC5150011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ServiceTypeInputCommonChildDiv.ServiceTypeInputCommonChildDiv.IServiceTypeInputCommonChildDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ServiceTypeInputCommonChildDiv.ServiceTypeInputCommonChildDiv.ServiceTypeInputCommonChildDivDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;

/**
 * ServiceCodeChushutsuJoken のクラスファイル
 *
 * @reamsid_L DBC-3310-010 chenyadong
 */
public class ServiceCodeChushutsuJokenDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("項目")
    private TextBox 項目;
    @JsonProperty("ccdServiceShurui")
    private ServiceTypeInputCommonChildDivDiv ccdServiceShurui;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * get項目
     * @return 項目
     */
    @JsonProperty("項目")
    public TextBox get項目() {
        return 項目;
    }

    /*
     * set項目
     * @param 項目 項目
     */
    @JsonProperty("項目")
    public void set項目(TextBox 項目) {
        this.項目 = 項目;
    }

    /*
     * getccdServiceShurui
     * @return ccdServiceShurui
     */
    @JsonProperty("ccdServiceShurui")
    public IServiceTypeInputCommonChildDiv getCcdServiceShurui() {
        return ccdServiceShurui;
    }

    // </editor-fold>
}
