package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1080011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JogaishaTorokuIchiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class JogaishaTorokuIchiranDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-06_01-12-04">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("NenreiTotatsh")
    private NenreiTotatshDiv NenreiTotatsh;
    @JsonProperty("JogaiTaishoIchiran")
    private JogaiTaishoIchiranDiv JogaiTaishoIchiran;
    @JsonProperty("Start")
    private RString Start;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getNenreiTotatsh
     * @return NenreiTotatsh
     */
    @JsonProperty("NenreiTotatsh")
    public NenreiTotatshDiv getNenreiTotatsh() {
        return NenreiTotatsh;
    }

    /*
     * setNenreiTotatsh
     * @param NenreiTotatsh NenreiTotatsh
     */
    @JsonProperty("NenreiTotatsh")
    public void setNenreiTotatsh(NenreiTotatshDiv NenreiTotatsh) {
        this.NenreiTotatsh = NenreiTotatsh;
    }

    /*
     * getJogaiTaishoIchiran
     * @return JogaiTaishoIchiran
     */
    @JsonProperty("JogaiTaishoIchiran")
    public JogaiTaishoIchiranDiv getJogaiTaishoIchiran() {
        return JogaiTaishoIchiran;
    }

    /*
     * setJogaiTaishoIchiran
     * @param JogaiTaishoIchiran JogaiTaishoIchiran
     */
    @JsonProperty("JogaiTaishoIchiran")
    public void setJogaiTaishoIchiran(JogaiTaishoIchiranDiv JogaiTaishoIchiran) {
        this.JogaiTaishoIchiran = JogaiTaishoIchiran;
    }

    /*
     * getStart
     * @return Start
     */
    @JsonProperty("Start")
    public RString getStart() {
        return Start;
    }

    /*
     * setStart
     * @param Start Start
     */
    @JsonProperty("Start")
    public void setStart(RString Start) {
        this.Start = Start;
    }

    // </editor-fold>
}
