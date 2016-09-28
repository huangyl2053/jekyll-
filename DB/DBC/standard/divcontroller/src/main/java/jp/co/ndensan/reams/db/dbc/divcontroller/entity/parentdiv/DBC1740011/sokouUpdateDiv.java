package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1740011;
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
 * sokouUpdate のクラスファイル
 *
 * @reamsid_L DBC-2400-010 yuqingzhang
 */
public class sokouUpdateDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KaiigoShikakCommonChildDiv2")
    private KaigoShikakuKihonDiv KaiigoShikakCommonChildDiv2;
    @JsonProperty("KaigoAtenaInfoChildDiv1")
    private KaigoAtenaInfoDiv KaigoAtenaInfoChildDiv1;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKaiigoShikakCommonChildDiv2
     * @return KaiigoShikakCommonChildDiv2
     */
    @JsonProperty("KaiigoShikakCommonChildDiv2")
    public IKaigoShikakuKihonDiv getKaiigoShikakCommonChildDiv2() {
        return KaiigoShikakCommonChildDiv2;
    }

    /*
     * getKaigoAtenaInfoChildDiv1
     * @return KaigoAtenaInfoChildDiv1
     */
    @JsonProperty("KaigoAtenaInfoChildDiv1")
    public IKaigoAtenaInfoDiv getKaigoAtenaInfoChildDiv1() {
        return KaigoAtenaInfoChildDiv1;
    }

    // </editor-fold>
}
