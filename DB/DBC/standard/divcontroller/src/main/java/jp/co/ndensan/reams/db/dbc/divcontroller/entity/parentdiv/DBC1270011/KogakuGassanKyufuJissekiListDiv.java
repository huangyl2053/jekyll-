package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1270011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KogakuGassanKyufuJissekiList のクラスファイル 
 * 
 * @author 自動生成
 */
public class KogakuGassanKyufuJissekiListDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkRirekiHyoji")
    private CheckBoxList chkRirekiHyoji;
    @JsonProperty("dgRireki")
    private DataGrid<dgRireki_Row> dgRireki;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkRirekiHyoji
     * @return chkRirekiHyoji
     */
    @JsonProperty("chkRirekiHyoji")
    public CheckBoxList getChkRirekiHyoji() {
        return chkRirekiHyoji;
    }

    /*
     * setchkRirekiHyoji
     * @param chkRirekiHyoji chkRirekiHyoji
     */
    @JsonProperty("chkRirekiHyoji")
    public void setChkRirekiHyoji(CheckBoxList chkRirekiHyoji) {
        this.chkRirekiHyoji = chkRirekiHyoji;
    }

    /*
     * getdgRireki
     * @return dgRireki
     */
    @JsonProperty("dgRireki")
    public DataGrid<dgRireki_Row> getDgRireki() {
        return dgRireki;
    }

    /*
     * setdgRireki
     * @param dgRireki dgRireki
     */
    @JsonProperty("dgRireki")
    public void setDgRireki(DataGrid<dgRireki_Row> dgRireki) {
        this.dgRireki = dgRireki;
    }

    // </editor-fold>
}
