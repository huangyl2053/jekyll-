package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0500011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShoKaishuKirokuKanriJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShoKaishuKirokuKanriJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KanryoMessage")
    private KanryoMessageDiv KanryoMessage;
    @JsonProperty("KihonJoho")
    private KihonJohoDiv KihonJoho;
    @JsonProperty("ShoKaishuList")
    private ShoKaishuListDiv ShoKaishuList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKanryoMessage
     * @return KanryoMessage
     */
    @JsonProperty("KanryoMessage")
    public KanryoMessageDiv getKanryoMessage() {
        return KanryoMessage;
    }

    /*
     * setKanryoMessage
     * @param KanryoMessage KanryoMessage
     */
    @JsonProperty("KanryoMessage")
    public void setKanryoMessage(KanryoMessageDiv KanryoMessage) {
        this.KanryoMessage = KanryoMessage;
    }

    /*
     * getKihonJoho
     * @return KihonJoho
     */
    @JsonProperty("KihonJoho")
    public KihonJohoDiv getKihonJoho() {
        return KihonJoho;
    }

    /*
     * setKihonJoho
     * @param KihonJoho KihonJoho
     */
    @JsonProperty("KihonJoho")
    public void setKihonJoho(KihonJohoDiv KihonJoho) {
        this.KihonJoho = KihonJoho;
    }

    /*
     * getShoKaishuList
     * @return ShoKaishuList
     */
    @JsonProperty("ShoKaishuList")
    public ShoKaishuListDiv getShoKaishuList() {
        return ShoKaishuList;
    }

    /*
     * setShoKaishuList
     * @param ShoKaishuList ShoKaishuList
     */
    @JsonProperty("ShoKaishuList")
    public void setShoKaishuList(ShoKaishuListDiv ShoKaishuList) {
        this.ShoKaishuList = ShoKaishuList;
    }

    // </editor-fold>
}
