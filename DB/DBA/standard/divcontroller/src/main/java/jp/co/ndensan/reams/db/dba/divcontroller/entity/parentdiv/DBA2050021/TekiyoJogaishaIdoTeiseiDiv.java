package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2050021;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TekiyoJogaishaIdoTeisei のクラスファイル
 *
 * @reamsid_L DBA-0411-050 lizhuoxuan
 */
public class TekiyoJogaishaIdoTeiseiDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KaigoKanryoMessageJo")
    private KaigoKanryoMessageJoDiv KaigoKanryoMessageJo;
    @JsonProperty("ShikakuKihonJoho")
    private ShikakuKihonJohoDiv ShikakuKihonJoho;
    @JsonProperty("TekiyoJogaiJohoIchiran")
    private TekiyoJogaiJohoIchiranDiv TekiyoJogaiJohoIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKaigoKanryoMessageJo
     * @return KaigoKanryoMessageJo
     */
    @JsonProperty("KaigoKanryoMessageJo")
    public KaigoKanryoMessageJoDiv getKaigoKanryoMessageJo() {
        return KaigoKanryoMessageJo;
    }

    /*
     * setKaigoKanryoMessageJo
     * @param KaigoKanryoMessageJo KaigoKanryoMessageJo
     */
    @JsonProperty("KaigoKanryoMessageJo")
    public void setKaigoKanryoMessageJo(KaigoKanryoMessageJoDiv KaigoKanryoMessageJo) {
        this.KaigoKanryoMessageJo = KaigoKanryoMessageJo;
    }

    /*
     * getShikakuKihonJoho
     * @return ShikakuKihonJoho
     */
    @JsonProperty("ShikakuKihonJoho")
    public ShikakuKihonJohoDiv getShikakuKihonJoho() {
        return ShikakuKihonJoho;
    }

    /*
     * setShikakuKihonJoho
     * @param ShikakuKihonJoho ShikakuKihonJoho
     */
    @JsonProperty("ShikakuKihonJoho")
    public void setShikakuKihonJoho(ShikakuKihonJohoDiv ShikakuKihonJoho) {
        this.ShikakuKihonJoho = ShikakuKihonJoho;
    }

    /*
     * getTekiyoJogaiJohoIchiran
     * @return TekiyoJogaiJohoIchiran
     */
    @JsonProperty("TekiyoJogaiJohoIchiran")
    public TekiyoJogaiJohoIchiranDiv getTekiyoJogaiJohoIchiran() {
        return TekiyoJogaiJohoIchiran;
    }

    /*
     * setTekiyoJogaiJohoIchiran
     * @param TekiyoJogaiJohoIchiran TekiyoJogaiJohoIchiran
     */
    @JsonProperty("TekiyoJogaiJohoIchiran")
    public void setTekiyoJogaiJohoIchiran(TekiyoJogaiJohoIchiranDiv TekiyoJogaiJohoIchiran) {
        this.TekiyoJogaiJohoIchiran = TekiyoJogaiJohoIchiran;
    }

    // </editor-fold>
}
