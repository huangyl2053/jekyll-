package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5140002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.KanryoMessage.IKanryoMessageDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.KanryoMessage.KanryoMessageDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShinsakaiIinWaritsuke のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinsakaiIinWaritsukeDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-02-15_05-21-09">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("Waritsuke")
    private WaritsukeDiv Waritsuke;
    @JsonProperty("Kanryo")
    private KanryoDiv Kanryo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getWaritsuke
     * @return Waritsuke
     */
    @JsonProperty("Waritsuke")
    public WaritsukeDiv getWaritsuke() {
        return Waritsuke;
    }

    /*
     * setWaritsuke
     * @param Waritsuke Waritsuke
     */
    @JsonProperty("Waritsuke")
    public void setWaritsuke(WaritsukeDiv Waritsuke) {
        this.Waritsuke = Waritsuke;
    }

    /*
     * getKanryo
     * @return Kanryo
     */
    @JsonProperty("Kanryo")
    public KanryoDiv getKanryo() {
        return Kanryo;
    }

    /*
     * setKanryo
     * @param Kanryo Kanryo
     */
    @JsonProperty("Kanryo")
    public void setKanryo(KanryoDiv Kanryo) {
        this.Kanryo = Kanryo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public IKanryoMessageDiv getCcdKanryoMsg() {
        return this.getKanryo().getCcdKanryoMsg();
    }

    // </editor-fold>
}
