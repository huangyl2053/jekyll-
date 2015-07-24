package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1810000;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.kaigoatenainfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.kaigoatenainfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.kaigoshikakukihon.IKaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.kaigoshikakukihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KashitsukeHenkanKihon のクラスファイル 
 * 
 * @author 自動生成
 */
public class KashitsukeHenkanKihonDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-49">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KashitsukeHenkanKaigoKihonInfo")
    private KaigoShikakuKihonDiv KashitsukeHenkanKaigoKihonInfo;
    @JsonProperty("KashitsukeHenkanKihonInfo")
    private KaigoAtenaInfoDiv KashitsukeHenkanKihonInfo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("KashitsukeHenkanKaigoKihonInfo")
    public IKaigoShikakuKihonDiv getKashitsukeHenkanKaigoKihonInfo() {
        return KashitsukeHenkanKaigoKihonInfo;
    }

    @JsonProperty("KashitsukeHenkanKihonInfo")
    public IKaigoAtenaInfoDiv getKashitsukeHenkanKihonInfo() {
        return KashitsukeHenkanKihonInfo;
    }

    // </editor-fold>
}
