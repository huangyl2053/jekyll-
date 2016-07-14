package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.Hihosyosai.Hihosyosai;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuNyutaishoRirekiKanri.IShisetsuNyutaishoRirekiKanriDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuNyutaishoRirekiKanri.ShisetsuNyutaishoRirekiKanriDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * tabPnlShisetu のクラスファイル
 *
 * @reamsid_L DBA-0170-010 linghuhang
 */
public class tabPnlShisetuDiv extends TabPanel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdShisetuNyutaisyo")
    private ShisetsuNyutaishoRirekiKanriDiv ccdShisetuNyutaisyo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdShisetuNyutaisyo
     * @return ccdShisetuNyutaisyo
     */
    @JsonProperty("ccdShisetuNyutaisyo")
    public IShisetsuNyutaishoRirekiKanriDiv getCcdShisetuNyutaisyo() {
        return ccdShisetuNyutaisyo;
    }

    // </editor-fold>
}
