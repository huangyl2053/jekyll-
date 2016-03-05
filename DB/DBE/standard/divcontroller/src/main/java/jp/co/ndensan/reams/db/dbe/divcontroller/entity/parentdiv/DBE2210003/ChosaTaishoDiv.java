package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210003;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaJisshishaJoho.ChosaJisshishaJoho.ChosaJisshishaJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaJisshishaJoho.ChosaJisshishaJoho.IChosaJisshishaJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoNinteiShinseishaInfo.KaigoNinteiShinseishaInfo.IKaigoNinteiShinseishaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoNinteiShinseishaInfo.KaigoNinteiShinseishaInfo.KaigoNinteiShinseishaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseiRenrakusakiKihon.NinteiShinseiRenrakusakiKihon.INinteiShinseiRenrakusakiKihonDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ChosaTaisho のクラスファイル
 *
 * @author 自動生成
 */
public class ChosaTaishoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("RenrakusakiKihon")
    private RenrakusakiKihonDiv RenrakusakiKihon;
    @JsonProperty("ccdChosaJisshishaJoho")
    private ChosaJisshishaJohoDiv ccdChosaJisshishaJoho;
    @JsonProperty("ccdKaigoNinteiShiseishaInfo")
    private KaigoNinteiShinseishaInfoDiv ccdKaigoNinteiShiseishaInfo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getRenrakusakiKihon
     * @return RenrakusakiKihon
     */
    @JsonProperty("RenrakusakiKihon")
    public RenrakusakiKihonDiv getRenrakusakiKihon() {
        return RenrakusakiKihon;
    }

    /*
     * setRenrakusakiKihon
     * @param RenrakusakiKihon RenrakusakiKihon
     */
    @JsonProperty("RenrakusakiKihon")
    public void setRenrakusakiKihon(RenrakusakiKihonDiv RenrakusakiKihon) {
        this.RenrakusakiKihon = RenrakusakiKihon;
    }

    /*
     * getccdChosaJisshishaJoho
     * @return ccdChosaJisshishaJoho
     */
    @JsonProperty("ccdChosaJisshishaJoho")
    public IChosaJisshishaJohoDiv getCcdChosaJisshishaJoho() {
        return ccdChosaJisshishaJoho;
    }

    /*
     * getccdKaigoNinteiShiseishaInfo
     * @return ccdKaigoNinteiShiseishaInfo
     */
    @JsonProperty("ccdKaigoNinteiShiseishaInfo")
    public IKaigoNinteiShinseishaInfoDiv getCcdKaigoNinteiShiseishaInfo() {
        return ccdKaigoNinteiShiseishaInfo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public INinteiShinseiRenrakusakiKihonDiv getCcdNinteiShinseiRenrakusakiKihon() {
        return this.getRenrakusakiKihon().getCcdNinteiShinseiRenrakusakiKihon();
    }

    // </editor-fold>
}
