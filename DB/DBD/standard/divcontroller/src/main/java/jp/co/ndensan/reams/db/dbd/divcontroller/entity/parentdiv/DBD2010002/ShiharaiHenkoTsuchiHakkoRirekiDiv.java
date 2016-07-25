package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD2010002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShiharaiHenkoTsuchiHakkoRireki のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShiharaiHenkoTsuchiHakkoRirekiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgShiharaiHohoHenkoRireki")
    private DataGrid<dgShiharaiHohoHenkoRireki_Row> dgShiharaiHohoHenkoRireki;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgShiharaiHohoHenkoRireki
     * @return dgShiharaiHohoHenkoRireki
     */
    @JsonProperty("dgShiharaiHohoHenkoRireki")
    public DataGrid<dgShiharaiHohoHenkoRireki_Row> getDgShiharaiHohoHenkoRireki() {
        return dgShiharaiHohoHenkoRireki;
    }

    /*
     * setdgShiharaiHohoHenkoRireki
     * @param dgShiharaiHohoHenkoRireki dgShiharaiHohoHenkoRireki
     */
    @JsonProperty("dgShiharaiHohoHenkoRireki")
    public void setDgShiharaiHohoHenkoRireki(DataGrid<dgShiharaiHohoHenkoRireki_Row> dgShiharaiHohoHenkoRireki) {
        this.dgShiharaiHohoHenkoRireki = dgShiharaiHohoHenkoRireki;
    }

    // </editor-fold>
}
