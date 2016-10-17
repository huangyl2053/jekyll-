package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1010032;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.IKaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.KaigoKanryoMessageDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * FutanyikkatsuShoninkekkaList のクラスファイル 
 * 
 * @author 自動生成
 */
public class FutanyikkatsuShoninkekkaListDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("HyojiTaisho")
    private HyojiTaishoDiv HyojiTaisho;
    @JsonProperty("Datagridhojipanel")
    private DatagridhojipanelDiv Datagridhojipanel;
    @JsonProperty("ccdKaigoKanryoMessage")
    private KaigoKanryoMessageDiv ccdKaigoKanryoMessage;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getHyojiTaisho
     * @return HyojiTaisho
     */
    @JsonProperty("HyojiTaisho")
    public HyojiTaishoDiv getHyojiTaisho() {
        return HyojiTaisho;
    }

    /*
     * setHyojiTaisho
     * @param HyojiTaisho HyojiTaisho
     */
    @JsonProperty("HyojiTaisho")
    public void setHyojiTaisho(HyojiTaishoDiv HyojiTaisho) {
        this.HyojiTaisho = HyojiTaisho;
    }

    /*
     * getDatagridhojipanel
     * @return Datagridhojipanel
     */
    @JsonProperty("Datagridhojipanel")
    public DatagridhojipanelDiv getDatagridhojipanel() {
        return Datagridhojipanel;
    }

    /*
     * setDatagridhojipanel
     * @param Datagridhojipanel Datagridhojipanel
     */
    @JsonProperty("Datagridhojipanel")
    public void setDatagridhojipanel(DatagridhojipanelDiv Datagridhojipanel) {
        this.Datagridhojipanel = Datagridhojipanel;
    }

    /*
     * getccdKaigoKanryoMessage
     * @return ccdKaigoKanryoMessage
     */
    @JsonProperty("ccdKaigoKanryoMessage")
    public IKaigoKanryoMessageDiv getCcdKaigoKanryoMessage() {
        return ccdKaigoKanryoMessage;
    }

    // </editor-fold>
}
