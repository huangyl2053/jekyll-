package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5140003;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShinsakaiScheduleHakko のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinsakaiScheduleHakkoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShinsakaiScheduleSrch")
    private ShinsakaiScheduleSrchDiv ShinsakaiScheduleSrch;
    @JsonProperty("dgShinsakaiScheduleKagami")
    private DataGrid<dgShinsakaiScheduleKagami_Row> dgShinsakaiScheduleKagami;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShinsakaiScheduleSrch
     * @return ShinsakaiScheduleSrch
     */
    @JsonProperty("ShinsakaiScheduleSrch")
    public ShinsakaiScheduleSrchDiv getShinsakaiScheduleSrch() {
        return ShinsakaiScheduleSrch;
    }

    /*
     * setShinsakaiScheduleSrch
     * @param ShinsakaiScheduleSrch ShinsakaiScheduleSrch
     */
    @JsonProperty("ShinsakaiScheduleSrch")
    public void setShinsakaiScheduleSrch(ShinsakaiScheduleSrchDiv ShinsakaiScheduleSrch) {
        this.ShinsakaiScheduleSrch = ShinsakaiScheduleSrch;
    }

    /*
     * getdgShinsakaiScheduleKagami
     * @return dgShinsakaiScheduleKagami
     */
    @JsonProperty("dgShinsakaiScheduleKagami")
    public DataGrid<dgShinsakaiScheduleKagami_Row> getDgShinsakaiScheduleKagami() {
        return dgShinsakaiScheduleKagami;
    }

    /*
     * setdgShinsakaiScheduleKagami
     * @param dgShinsakaiScheduleKagami dgShinsakaiScheduleKagami
     */
    @JsonProperty("dgShinsakaiScheduleKagami")
    public void setDgShinsakaiScheduleKagami(DataGrid<dgShinsakaiScheduleKagami_Row> dgShinsakaiScheduleKagami) {
        this.dgShinsakaiScheduleKagami = dgShinsakaiScheduleKagami;
    }

    // </editor-fold>
}
