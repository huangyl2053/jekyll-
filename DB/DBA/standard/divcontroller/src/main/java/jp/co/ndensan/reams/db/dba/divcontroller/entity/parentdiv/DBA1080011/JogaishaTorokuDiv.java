package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1080011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.IKaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.KaigoKanryoMessageDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JogaishaToroku のクラスファイル 
 * 
 * @author 自動生成
 */
public class JogaishaTorokuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-06_01-12-04">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KaigoKanryo")
    private KaigoKanryoDiv KaigoKanryo;
    @JsonProperty("JogaishaTorokuIchiran")
    private JogaishaTorokuIchiranDiv JogaishaTorokuIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKaigoKanryo
     * @return KaigoKanryo
     */
    @JsonProperty("KaigoKanryo")
    public KaigoKanryoDiv getKaigoKanryo() {
        return KaigoKanryo;
    }

    /*
     * setKaigoKanryo
     * @param KaigoKanryo KaigoKanryo
     */
    @JsonProperty("KaigoKanryo")
    public void setKaigoKanryo(KaigoKanryoDiv KaigoKanryo) {
        this.KaigoKanryo = KaigoKanryo;
    }

    /*
     * getJogaishaTorokuIchiran
     * @return JogaishaTorokuIchiran
     */
    @JsonProperty("JogaishaTorokuIchiran")
    public JogaishaTorokuIchiranDiv getJogaishaTorokuIchiran() {
        return JogaishaTorokuIchiran;
    }

    /*
     * setJogaishaTorokuIchiran
     * @param JogaishaTorokuIchiran JogaishaTorokuIchiran
     */
    @JsonProperty("JogaishaTorokuIchiran")
    public void setJogaishaTorokuIchiran(JogaishaTorokuIchiranDiv JogaishaTorokuIchiran) {
        this.JogaishaTorokuIchiran = JogaishaTorokuIchiran;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public IKaigoKanryoMessageDiv getCcdKaigoKanryoMessage() {
        return this.getKaigoKanryo().getCcdKaigoKanryoMessage();
    }

    // </editor-fold>
}
