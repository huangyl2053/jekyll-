package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA4020011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TajutokuShokai のクラスファイル
 *
 * @reamsid_L DBA-0402-010 xuyannan
 */
public class TajutokuShokaiDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShikakuKihonJoho")
    private ShikakuKihonJohoDiv ShikakuKihonJoho;
    @JsonProperty("TajutokuTekiyoJohoIchiran")
    private TajutokuTekiyoJohoIchiranDiv TajutokuTekiyoJohoIchiran;
    @JsonProperty("JutokuJohoTeiseiIchiran")
    private JutokuJohoTeiseiIchiranDiv JutokuJohoTeiseiIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
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
     * getTajutokuTekiyoJohoIchiran
     * @return TajutokuTekiyoJohoIchiran
     */
    @JsonProperty("TajutokuTekiyoJohoIchiran")
    public TajutokuTekiyoJohoIchiranDiv getTajutokuTekiyoJohoIchiran() {
        return TajutokuTekiyoJohoIchiran;
    }

    /*
     * setTajutokuTekiyoJohoIchiran
     * @param TajutokuTekiyoJohoIchiran TajutokuTekiyoJohoIchiran
     */
    @JsonProperty("TajutokuTekiyoJohoIchiran")
    public void setTajutokuTekiyoJohoIchiran(TajutokuTekiyoJohoIchiranDiv TajutokuTekiyoJohoIchiran) {
        this.TajutokuTekiyoJohoIchiran = TajutokuTekiyoJohoIchiran;
    }

    /*
     * getJutokuJohoTeiseiIchiran
     * @return JutokuJohoTeiseiIchiran
     */
    @JsonProperty("JutokuJohoTeiseiIchiran")
    public JutokuJohoTeiseiIchiranDiv getJutokuJohoTeiseiIchiran() {
        return JutokuJohoTeiseiIchiran;
    }

    /*
     * setJutokuJohoTeiseiIchiran
     * @param JutokuJohoTeiseiIchiran JutokuJohoTeiseiIchiran
     */
    @JsonProperty("JutokuJohoTeiseiIchiran")
    public void setJutokuJohoTeiseiIchiran(JutokuJohoTeiseiIchiranDiv JutokuJohoTeiseiIchiran) {
        this.JutokuJohoTeiseiIchiran = JutokuJohoTeiseiIchiran;
    }

    // </editor-fold>
}
