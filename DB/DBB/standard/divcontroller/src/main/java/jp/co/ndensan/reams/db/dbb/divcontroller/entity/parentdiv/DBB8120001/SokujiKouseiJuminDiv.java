package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB8120001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.IKaigoFukaKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.KaigoFukaKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.kaigoatenainfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.kaigoatenainfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SokujiKouseiJumin のクラスファイル
 *
 * @author 自動生成
 */
public class SokujiKouseiJuminDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-49">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SokujiKouseiKihon")
    private KaigoFukaKihonDiv SokujiKouseiKihon;
    @JsonProperty("SokujiKouseiAtena")
    private KaigoAtenaInfoDiv SokujiKouseiAtena;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("SokujiKouseiKihon")
    public IKaigoFukaKihonDiv getSokujiKouseiKihon() {
        return SokujiKouseiKihon;
    }

    @JsonProperty("SokujiKouseiAtena")
    public IKaigoAtenaInfoDiv getSokujiKouseiAtena() {
        return SokujiKouseiAtena;
    }

    // </editor-fold>
}
