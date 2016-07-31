package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4560011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.IKaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.KaigoKanryoMessageDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KoshinKekkaKakunin のクラスファイル
 *
 * @reamsid_L DBC-5820-010 tianshuai
 */
public class KoshinKekkaKakuninDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdKanryouMessage")
    private KaigoKanryoMessageDiv ccdKanryouMessage;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdKanryouMessage
     * @return ccdKanryouMessage
     */
    @JsonProperty("ccdKanryouMessage")
    public IKaigoKanryoMessageDiv getCcdKanryouMessage() {
        return ccdKanryouMessage;
    }

    // </editor-fold>
}
