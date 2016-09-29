package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD9010001;
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
 * IryohiKojyoToroku のクラスファイル 
 * 
 * @author 自動生成
 */
public class IryohiKojyoTorokuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KaigoShikakuKihonChildDiv")
    private KaigoShikakuKihonDiv KaigoShikakuKihonChildDiv;
    @JsonProperty("KaigoAtenaInfoChildDiv")
    private KaigoAtenaInfoDiv KaigoAtenaInfoChildDiv;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKaigoShikakuKihonChildDiv
     * @return KaigoShikakuKihonChildDiv
     */
    @JsonProperty("KaigoShikakuKihonChildDiv")
    public IKaigoShikakuKihonDiv getKaigoShikakuKihonChildDiv() {
        return KaigoShikakuKihonChildDiv;
    }

    /*
     * getKaigoAtenaInfoChildDiv
     * @return KaigoAtenaInfoChildDiv
     */
    @JsonProperty("KaigoAtenaInfoChildDiv")
    public IKaigoAtenaInfoDiv getKaigoAtenaInfoChildDiv() {
        return KaigoAtenaInfoChildDiv;
    }

    // </editor-fold>
}
