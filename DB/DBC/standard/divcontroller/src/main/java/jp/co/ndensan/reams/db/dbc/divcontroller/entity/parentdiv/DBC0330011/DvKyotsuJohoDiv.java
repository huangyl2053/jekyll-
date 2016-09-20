package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0330011;
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
 * DvKyotsuJoho のクラスファイル
 *
 * @reamsid_L DBC-1980-010 yuqingzhang
 */
public class DvKyotsuJohoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("cddAtenaInfo")
    private KaigoAtenaInfoDiv cddAtenaInfo;
    @JsonProperty("cddShikakuKihon")
    private KaigoShikakuKihonDiv cddShikakuKihon;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getcddAtenaInfo
     * @return cddAtenaInfo
     */
    @JsonProperty("cddAtenaInfo")
    public IKaigoAtenaInfoDiv getCddAtenaInfo() {
        return cddAtenaInfo;
    }

    /*
     * getcddShikakuKihon
     * @return cddShikakuKihon
     */
    @JsonProperty("cddShikakuKihon")
    public IKaigoShikakuKihonDiv getCddShikakuKihon() {
        return cddShikakuKihon;
    }

    // </editor-fold>
}
