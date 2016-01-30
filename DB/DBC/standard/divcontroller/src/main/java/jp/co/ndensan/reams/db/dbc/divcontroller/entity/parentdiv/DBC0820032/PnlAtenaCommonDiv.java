package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820032;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.kaigoatenainfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.kaigoatenainfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.kaigoshikakukihon.IKaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.kaigoshikakukihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * PnlAtenaCommon のクラスファイル 
 * 
 * @author 自動生成
 */
public class PnlAtenaCommonDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdKaigoKihon")
    private KaigoShikakuKihonDiv ccdKaigoKihon;
    @JsonProperty("ccdAtena")
    private KaigoAtenaInfoDiv ccdAtena;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdKaigoKihon
     * @return ccdKaigoKihon
     */
    @JsonProperty("ccdKaigoKihon")
    public IKaigoShikakuKihonDiv getCcdKaigoKihon() {
        return ccdKaigoKihon;
    }

    /*
     * getccdAtena
     * @return ccdAtena
     */
    @JsonProperty("ccdAtena")
    public IKaigoAtenaInfoDiv getCcdAtena() {
        return ccdAtena;
    }

    // </editor-fold>
}
