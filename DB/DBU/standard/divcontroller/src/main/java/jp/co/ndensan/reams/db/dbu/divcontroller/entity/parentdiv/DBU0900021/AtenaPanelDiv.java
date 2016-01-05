package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0900021;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.IKaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.KaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.kaigoatenainfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.kaigoshikakukihon.IKaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.kaigoshikakukihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * AtenaPanel のクラスファイル
 *
 * @author 自動生成
 */
public class AtenaPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdKanryoMessage")
    private KaigoKanryoMessageDiv ccdKanryoMessage;
    @JsonProperty("AtenaInfoCommonChildDiv")
    private KaigoAtenaInfoDiv AtenaInfoCommonChildDiv;
    @JsonProperty("KaigoShikakuKihonCommonChildDiv")
    private KaigoShikakuKihonDiv KaigoShikakuKihonCommonChildDiv;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdKanryoMessage
     * @return ccdKanryoMessage
     */
    @JsonProperty("ccdKanryoMessage")
    public IKaigoKanryoMessageDiv getCcdKanryoMessage() {
        return ccdKanryoMessage;
    }

    /*
     * getAtenaInfoCommonChildDiv
     * @return AtenaInfoCommonChildDiv
     */
    @JsonProperty("AtenaInfoCommonChildDiv")
    public IKaigoAtenaInfoDiv getAtenaInfoCommonChildDiv() {
        return AtenaInfoCommonChildDiv;
    }

    /*
     * getKaigoShikakuKihonCommonChildDiv
     * @return KaigoShikakuKihonCommonChildDiv
     */
    @JsonProperty("KaigoShikakuKihonCommonChildDiv")
    public IKaigoShikakuKihonDiv getKaigoShikakuKihonCommonChildDiv() {
        return KaigoShikakuKihonCommonChildDiv;
    }

    // </editor-fold>
}
