package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0710022;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.IKaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JutakuKaishuShinseiHihokenshaPanel のクラスファイル
 *
 * @reamsid_L DBC-0992-110 yangchenbing
 */
public class JutakuKaishuShinseiHihokenshaPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-07_19-12-57">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KaigoShikakuKihon")
    private KaigoShikakuKihonDiv KaigoShikakuKihon;
    @JsonProperty("KaigoAtenaInfo")
    private KaigoAtenaInfoDiv KaigoAtenaInfo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKaigoShikakuKihon
     * @return KaigoShikakuKihon
     */
    @JsonProperty("KaigoShikakuKihon")
    public IKaigoShikakuKihonDiv getKaigoShikakuKihon() {
        return KaigoShikakuKihon;
    }

    /*
     * getKaigoAtenaInfo
     * @return KaigoAtenaInfo
     */
    @JsonProperty("KaigoAtenaInfo")
    public IKaigoAtenaInfoDiv getKaigoAtenaInfo() {
        return KaigoAtenaInfo;
    }

    // </editor-fold>
}
