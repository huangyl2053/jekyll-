package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB8110001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.kaigofukakihon.KaigoFukaKihon.IKaigoFukaKihonDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.kaigofukakihon.KaigoFukaKihon.KaigoFukaKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JuminFukaShokai のクラスファイル 
 * 
 * @author 自動生成
 */
public class JuminFukaShokaiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-07_19-12-57">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdFukaKihon")
    private KaigoFukaKihonDiv ccdFukaKihon;
    @JsonProperty("ccdKaigoatena")
    private KaigoAtenaInfoDiv ccdKaigoatena;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdFukaKihon
     * @return ccdFukaKihon
     */
    @JsonProperty("ccdFukaKihon")
    public IKaigoFukaKihonDiv getCcdFukaKihon() {
        return ccdFukaKihon;
    }

    /*
     * getccdKaigoatena
     * @return ccdKaigoatena
     */
    @JsonProperty("ccdKaigoatena")
    public IKaigoAtenaInfoDiv getCcdKaigoatena() {
        return ccdKaigoatena;
    }

    // </editor-fold>
}
