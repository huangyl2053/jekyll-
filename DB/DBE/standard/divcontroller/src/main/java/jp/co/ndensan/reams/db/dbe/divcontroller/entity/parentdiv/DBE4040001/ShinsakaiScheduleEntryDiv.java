package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4040001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4040001.ScheduleDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4040001.ShinakaiScheduleListDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4040001.ShinsakaiListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShinsakaiScheduleEntry のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinsakaiScheduleEntryDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("Schedule")
    private ScheduleDiv Schedule;
    @JsonProperty("ShinsakaiList")
    private ShinsakaiListDiv ShinsakaiList;
    @JsonProperty("ShinakaiScheduleList")
    private ShinakaiScheduleListDiv ShinakaiScheduleList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("Schedule")
    public ScheduleDiv getSchedule() {
        return Schedule;
    }

    @JsonProperty("Schedule")
    public void setSchedule(ScheduleDiv Schedule) {
        this.Schedule=Schedule;
    }

    @JsonProperty("ShinsakaiList")
    public ShinsakaiListDiv getShinsakaiList() {
        return ShinsakaiList;
    }

    @JsonProperty("ShinsakaiList")
    public void setShinsakaiList(ShinsakaiListDiv ShinsakaiList) {
        this.ShinsakaiList=ShinsakaiList;
    }

    @JsonProperty("ShinakaiScheduleList")
    public ShinakaiScheduleListDiv getShinakaiScheduleList() {
        return ShinakaiScheduleList;
    }

    @JsonProperty("ShinakaiScheduleList")
    public void setShinakaiScheduleList(ShinakaiScheduleListDiv ShinakaiScheduleList) {
        this.ShinakaiScheduleList=ShinakaiScheduleList;
    }

}
