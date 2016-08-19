package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410050;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KaigoKyufuKokuhorenJohoTorikomi.IKaigoKyufuKokuhorenJohoTorikomiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KaigoKyufuKokuhorenJohoTorikomi.KaigoKyufuKokuhorenJohoTorikomiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TsuchishoJoho のクラスファイル
 *
 * @reamsid_L DBC-2500-040 dingminghao
 */
public class TsuchishoJohoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdKokurenJohoTorikomi")
    private KaigoKyufuKokuhorenJohoTorikomiDiv ccdKokurenJohoTorikomi;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdKokurenJohoTorikomi
     * @return ccdKokurenJohoTorikomi
     */
    @JsonProperty("ccdKokurenJohoTorikomi")
    public IKaigoKyufuKokuhorenJohoTorikomiDiv getCcdKokurenJohoTorikomi() {
        return ccdKokurenJohoTorikomi;
    }

    // </editor-fold>
}
