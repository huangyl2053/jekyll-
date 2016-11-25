package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.GemmenGengakuRirekiList;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * pnlFutangendogakuRireki のクラスファイル
 *
 * @reamsid_L DBC-4350-030 liuxiaoyu
 */
public class pnlFutangendogakuRirekiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgFutanGendogakuList")
    private DataGrid<dgFutanGendogakuList_Row> dgFutanGendogakuList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgFutanGendogakuList
     * @return dgFutanGendogakuList
     */
    @JsonProperty("dgFutanGendogakuList")
    public DataGrid<dgFutanGendogakuList_Row> getDgFutanGendogakuList() {
        return dgFutanGendogakuList;
    }

    /*
     * setdgFutanGendogakuList
     * @param dgFutanGendogakuList dgFutanGendogakuList
     */
    @JsonProperty("dgFutanGendogakuList")
    public void setDgFutanGendogakuList(DataGrid<dgFutanGendogakuList_Row> dgFutanGendogakuList) {
        this.dgFutanGendogakuList = dgFutanGendogakuList;
    }

    // </editor-fold>
}
