package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD0530011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoNinteiAtenaInfo.IKaigoNinteiAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoNinteiAtenaInfo.KaigoNinteiAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoninteiShikakuInfo.IKaigoninteiShikakuInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoninteiShikakuInfo.KaigoninteiShikakuInfoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * HeaderPanel のクラスファイル
 *
 * @author 自動生成
 */
public class HeaderPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-03-02_13-24-25">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdShikakuInfo")
    private KaigoninteiShikakuInfoDiv ccdShikakuInfo;
    @JsonProperty("ccdAtenaInfo")
    private KaigoNinteiAtenaInfoDiv ccdAtenaInfo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdShikakuInfo
     * @return ccdShikakuInfo
     */
    @JsonProperty("ccdShikakuInfo")
    public IKaigoninteiShikakuInfoDiv getCcdShikakuInfo() {
        return ccdShikakuInfo;
    }

    /*
     * getccdAtenaInfo
     * @return ccdAtenaInfo
     */
    @JsonProperty("ccdAtenaInfo")
    public IKaigoNinteiAtenaInfoDiv getCcdAtenaInfo() {
        return ccdAtenaInfo;
    }

    // </editor-fold>
}
