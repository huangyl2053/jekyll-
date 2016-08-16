package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5130001;
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
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * Ninteishinseihakko のクラスファイル
 *
 * @author 自動生成
 */
public class NinteishinseihakkoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdKaigoNinteiAtenaInfo")
    private KaigoNinteiAtenaInfoDiv ccdKaigoNinteiAtenaInfo;
    @JsonProperty("ccdKaigoninteiShikakuInfo")
    private KaigoninteiShikakuInfoDiv ccdKaigoninteiShikakuInfo;
    @JsonProperty("hdnShinseishoKanrino")
    private RString hdnShinseishoKanrino;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdKaigoNinteiAtenaInfo
     * @return ccdKaigoNinteiAtenaInfo
     */
    @JsonProperty("ccdKaigoNinteiAtenaInfo")
    public IKaigoNinteiAtenaInfoDiv getCcdKaigoNinteiAtenaInfo() {
        return ccdKaigoNinteiAtenaInfo;
    }

    /*
     * getccdKaigoninteiShikakuInfo
     * @return ccdKaigoninteiShikakuInfo
     */
    @JsonProperty("ccdKaigoninteiShikakuInfo")
    public IKaigoninteiShikakuInfoDiv getCcdKaigoninteiShikakuInfo() {
        return ccdKaigoninteiShikakuInfo;
    }

    /*
     * gethdnShinseishoKanrino
     * @return hdnShinseishoKanrino
     */
    @JsonProperty("hdnShinseishoKanrino")
    public RString getHdnShinseishoKanrino() {
        return hdnShinseishoKanrino;
    }

    /*
     * sethdnShinseishoKanrino
     * @param hdnShinseishoKanrino hdnShinseishoKanrino
     */
    @JsonProperty("hdnShinseishoKanrino")
    public void setHdnShinseishoKanrino(RString hdnShinseishoKanrino) {
        this.hdnShinseishoKanrino = hdnShinseishoKanrino;
    }

    // </editor-fold>
}
