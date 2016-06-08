package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0420011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * Total のクラスファイル 
 * 
 * @author 自動生成
 */
public class TotalDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("AtenaShikakuInfo")
    private AtenaShikakuInfoDiv AtenaShikakuInfo;
    @JsonProperty("ShikakuShaShoHakko")
    private ShikakuShaShoHakkoDiv ShikakuShaShoHakko;
    @JsonProperty("JukyuSikakuShomeiHakko")
    private JukyuSikakuShomeiHakkoDiv JukyuSikakuShomeiHakko;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getAtenaShikakuInfo
     * @return AtenaShikakuInfo
     */
    @JsonProperty("AtenaShikakuInfo")
    public AtenaShikakuInfoDiv getAtenaShikakuInfo() {
        return AtenaShikakuInfo;
    }

    /*
     * setAtenaShikakuInfo
     * @param AtenaShikakuInfo AtenaShikakuInfo
     */
    @JsonProperty("AtenaShikakuInfo")
    public void setAtenaShikakuInfo(AtenaShikakuInfoDiv AtenaShikakuInfo) {
        this.AtenaShikakuInfo = AtenaShikakuInfo;
    }

    /*
     * getShikakuShaShoHakko
     * @return ShikakuShaShoHakko
     */
    @JsonProperty("ShikakuShaShoHakko")
    public ShikakuShaShoHakkoDiv getShikakuShaShoHakko() {
        return ShikakuShaShoHakko;
    }

    /*
     * setShikakuShaShoHakko
     * @param ShikakuShaShoHakko ShikakuShaShoHakko
     */
    @JsonProperty("ShikakuShaShoHakko")
    public void setShikakuShaShoHakko(ShikakuShaShoHakkoDiv ShikakuShaShoHakko) {
        this.ShikakuShaShoHakko = ShikakuShaShoHakko;
    }

    /*
     * getJukyuSikakuShomeiHakko
     * @return JukyuSikakuShomeiHakko
     */
    @JsonProperty("JukyuSikakuShomeiHakko")
    public JukyuSikakuShomeiHakkoDiv getJukyuSikakuShomeiHakko() {
        return JukyuSikakuShomeiHakko;
    }

    /*
     * setJukyuSikakuShomeiHakko
     * @param JukyuSikakuShomeiHakko JukyuSikakuShomeiHakko
     */
    @JsonProperty("JukyuSikakuShomeiHakko")
    public void setJukyuSikakuShomeiHakko(JukyuSikakuShomeiHakkoDiv JukyuSikakuShomeiHakko) {
        this.JukyuSikakuShomeiHakko = JukyuSikakuShomeiHakko;
    }

    // </editor-fold>
}
