package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0420011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.JukyuSikakuShomeishoHakko.IJukyuSikakuShomeishoHakkoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.JukyuSikakuShomeishoHakko.JukyuSikakuShomeishoHakkoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hihokenshashikakuhakko.HihokenshaShikakuHakko.HihokenshaShikakuHakkoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hihokenshashikakuhakko.HihokenshaShikakuHakko.IHihokenshaShikakuHakkoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.kaigoatenainfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.kaigoatenainfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.kaigoshikakukihon.IKaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.kaigoshikakukihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * PnlTotal のクラスファイル 
 * 
 * @author 自動生成
 */
public class PnlTotalDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
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
    @JsonProperty("ccdJukyuSikakuShomeishoHakko1")
    private JukyuSikakuShomeishoHakkoDiv ccdJukyuSikakuShomeishoHakko1;

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
     * getccdJukyuSikakuShomeishoHakko1
     * @return ccdJukyuSikakuShomeishoHakko1
     */
    @JsonProperty("ccdJukyuSikakuShomeishoHakko1")
    public IJukyuSikakuShomeishoHakkoDiv getCcdJukyuSikakuShomeishoHakko1() {
        return ccdJukyuSikakuShomeishoHakko1;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public IKaigoAtenaInfoDiv getCcdKaigoAtenaInfo() {
        return this.getAtenaShikakuInfo().getCcdKaigoAtenaInfo();
    }

    @JsonIgnore
    public IKaigoShikakuKihonDiv getCcdKaigoShikakuKihon() {
        return this.getAtenaShikakuInfo().getCcdKaigoShikakuKihon();
    }

    @JsonIgnore
    public ButtonDialog getBtnTainoInfo() {
        return this.getShikakuShaShoHakko().getBtnTainoInfo();
    }

    @JsonIgnore
    public void  setBtnTainoInfo(ButtonDialog btnTainoInfo) {
        this.getShikakuShaShoHakko().setBtnTainoInfo(btnTainoInfo);
    }

    @JsonIgnore
    public ButtonDialog getBtnGengakuInfo() {
        return this.getShikakuShaShoHakko().getBtnGengakuInfo();
    }

    @JsonIgnore
    public void  setBtnGengakuInfo(ButtonDialog btnGengakuInfo) {
        this.getShikakuShaShoHakko().setBtnGengakuInfo(btnGengakuInfo);
    }

    @JsonIgnore
    public IHihokenshaShikakuHakkoDiv getCcdHihokenshaShikakuHakko() {
        return this.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko();
    }

    // </editor-fold>
}
