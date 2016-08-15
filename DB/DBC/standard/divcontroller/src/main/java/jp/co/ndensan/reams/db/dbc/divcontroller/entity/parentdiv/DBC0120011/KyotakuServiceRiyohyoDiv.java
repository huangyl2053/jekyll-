package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0120011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ServiceRiyohyoInfo.IServiceRiyohyoInfoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KyotakuServiceRiyohyo のクラスファイル
 *
 * @reamsid_L DBC-1930-030 huzongcheng
 */
public class KyotakuServiceRiyohyoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdServiceRiyohyoInfo")
    private IServiceRiyohyoInfoDiv ccdServiceRiyohyoInfo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdServiceRiyohyoInfo
     * @return ccdServiceRiyohyoInfo
     */
    @JsonProperty("ccdServiceRiyohyoInfo")
    public IServiceRiyohyoInfoDiv getCcdServiceRiyohyoInfo() {
        return ccdServiceRiyohyoInfo;
    }

    // </editor-fold>
}
