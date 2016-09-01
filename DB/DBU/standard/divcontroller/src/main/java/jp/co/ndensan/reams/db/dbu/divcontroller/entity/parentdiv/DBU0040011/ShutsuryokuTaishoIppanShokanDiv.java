package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0040011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShutsuryokuTaishoIppanShokan のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShutsuryokuTaishoIppanShokanDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("cblShutsuryokuTaishoIppanShokan")
    private CheckBoxList cblShutsuryokuTaishoIppanShokan;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getcblShutsuryokuTaishoIppanShokan
     * @return cblShutsuryokuTaishoIppanShokan
     */
    @JsonProperty("cblShutsuryokuTaishoIppanShokan")
    public CheckBoxList getCblShutsuryokuTaishoIppanShokan() {
        return cblShutsuryokuTaishoIppanShokan;
    }

    /*
     * setcblShutsuryokuTaishoIppanShokan
     * @param cblShutsuryokuTaishoIppanShokan cblShutsuryokuTaishoIppanShokan
     */
    @JsonProperty("cblShutsuryokuTaishoIppanShokan")
    public void setCblShutsuryokuTaishoIppanShokan(CheckBoxList cblShutsuryokuTaishoIppanShokan) {
        this.cblShutsuryokuTaishoIppanShokan = cblShutsuryokuTaishoIppanShokan;
    }

    // </editor-fold>
}
