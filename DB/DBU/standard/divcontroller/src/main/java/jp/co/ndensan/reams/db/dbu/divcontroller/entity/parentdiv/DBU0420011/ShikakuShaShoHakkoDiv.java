package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0420011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hihokenshashikakuhakko.HihokenshaShikakuHakko.HihokenshaShikakuHakkoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hihokenshashikakuhakko.HihokenshaShikakuHakko.IHihokenshaShikakuHakkoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShikakuShaShoHakko のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShikakuShaShoHakkoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnTainoInfo")
    private ButtonDialog btnTainoInfo;
    @JsonProperty("btnGengakuInfo")
    private ButtonDialog btnGengakuInfo;
    @JsonProperty("ccdHihokenshaShikakuHakko")
    private HihokenshaShikakuHakkoDiv ccdHihokenshaShikakuHakko;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnTainoInfo
     * @return btnTainoInfo
     */
    @JsonProperty("btnTainoInfo")
    public ButtonDialog getBtnTainoInfo() {
        return btnTainoInfo;
    }

    /*
     * setbtnTainoInfo
     * @param btnTainoInfo btnTainoInfo
     */
    @JsonProperty("btnTainoInfo")
    public void setBtnTainoInfo(ButtonDialog btnTainoInfo) {
        this.btnTainoInfo = btnTainoInfo;
    }

    /*
     * getbtnGengakuInfo
     * @return btnGengakuInfo
     */
    @JsonProperty("btnGengakuInfo")
    public ButtonDialog getBtnGengakuInfo() {
        return btnGengakuInfo;
    }

    /*
     * setbtnGengakuInfo
     * @param btnGengakuInfo btnGengakuInfo
     */
    @JsonProperty("btnGengakuInfo")
    public void setBtnGengakuInfo(ButtonDialog btnGengakuInfo) {
        this.btnGengakuInfo = btnGengakuInfo;
    }

    /*
     * getccdHihokenshaShikakuHakko
     * @return ccdHihokenshaShikakuHakko
     */
    @JsonProperty("ccdHihokenshaShikakuHakko")
    public IHihokenshaShikakuHakkoDiv getCcdHihokenshaShikakuHakko() {
        return ccdHihokenshaShikakuHakko;
    }

    // </editor-fold>
}
