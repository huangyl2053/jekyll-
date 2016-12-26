package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1010001;
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
 * headPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class headPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdAtenaInfo")
    private KaigoNinteiAtenaInfoDiv ccdAtenaInfo;
    @JsonProperty("AtenaInfoToroku")
    private AtenaInfoTorokuDiv AtenaInfoToroku;
    @JsonProperty("ccdShikakuInfo")
    private KaigoninteiShikakuInfoDiv ccdShikakuInfo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdAtenaInfo
     * @return ccdAtenaInfo
     */
    @JsonProperty("ccdAtenaInfo")
    public IKaigoNinteiAtenaInfoDiv getCcdAtenaInfo() {
        return ccdAtenaInfo;
    }

    /*
     * getAtenaInfoToroku
     * @return AtenaInfoToroku
     */
    @JsonProperty("AtenaInfoToroku")
    public AtenaInfoTorokuDiv getAtenaInfoToroku() {
        return AtenaInfoToroku;
    }

    /*
     * setAtenaInfoToroku
     * @param AtenaInfoToroku AtenaInfoToroku
     */
    @JsonProperty("AtenaInfoToroku")
    public void setAtenaInfoToroku(AtenaInfoTorokuDiv AtenaInfoToroku) {
        this.AtenaInfoToroku = AtenaInfoToroku;
    }

    /*
     * getccdShikakuInfo
     * @return ccdShikakuInfo
     */
    @JsonProperty("ccdShikakuInfo")
    public IKaigoninteiShikakuInfoDiv getCcdShikakuInfo() {
        return ccdShikakuInfo;
    }

    // </editor-fold>
}
