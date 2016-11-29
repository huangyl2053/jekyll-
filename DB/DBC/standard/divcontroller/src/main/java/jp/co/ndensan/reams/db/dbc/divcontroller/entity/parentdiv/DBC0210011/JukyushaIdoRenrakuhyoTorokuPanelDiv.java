package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0210011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.IKaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.KaigoKanryoMessageDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JukyushaIdoRenrakuhyoTorokuPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class JukyushaIdoRenrakuhyoTorokuPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("JukyushaIdoRenrakuhyoShinkiTorokuPanel")
    private JukyushaIdoRenrakuhyoShinkiTorokuPanelDiv JukyushaIdoRenrakuhyoShinkiTorokuPanel;
    @JsonProperty("ccdKanryoMessage")
    private KaigoKanryoMessageDiv ccdKanryoMessage;
    @JsonProperty("hdnFlg")
    private RString hdnFlg;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getJukyushaIdoRenrakuhyoShinkiTorokuPanel
     * @return JukyushaIdoRenrakuhyoShinkiTorokuPanel
     */
    @JsonProperty("JukyushaIdoRenrakuhyoShinkiTorokuPanel")
    public JukyushaIdoRenrakuhyoShinkiTorokuPanelDiv getJukyushaIdoRenrakuhyoShinkiTorokuPanel() {
        return JukyushaIdoRenrakuhyoShinkiTorokuPanel;
    }

    /*
     * setJukyushaIdoRenrakuhyoShinkiTorokuPanel
     * @param JukyushaIdoRenrakuhyoShinkiTorokuPanel JukyushaIdoRenrakuhyoShinkiTorokuPanel
     */
    @JsonProperty("JukyushaIdoRenrakuhyoShinkiTorokuPanel")
    public void setJukyushaIdoRenrakuhyoShinkiTorokuPanel(JukyushaIdoRenrakuhyoShinkiTorokuPanelDiv JukyushaIdoRenrakuhyoShinkiTorokuPanel) {
        this.JukyushaIdoRenrakuhyoShinkiTorokuPanel = JukyushaIdoRenrakuhyoShinkiTorokuPanel;
    }

    /*
     * getccdKanryoMessage
     * @return ccdKanryoMessage
     */
    @JsonProperty("ccdKanryoMessage")
    public IKaigoKanryoMessageDiv getCcdKanryoMessage() {
        return ccdKanryoMessage;
    }

    /*
     * gethdnFlg
     * @return hdnFlg
     */
    @JsonProperty("hdnFlg")
    public RString getHdnFlg() {
        return hdnFlg;
    }

    /*
     * sethdnFlg
     * @param hdnFlg hdnFlg
     */
    @JsonProperty("hdnFlg")
    public void setHdnFlg(RString hdnFlg) {
        this.hdnFlg = hdnFlg;
    }

    // </editor-fold>
}
