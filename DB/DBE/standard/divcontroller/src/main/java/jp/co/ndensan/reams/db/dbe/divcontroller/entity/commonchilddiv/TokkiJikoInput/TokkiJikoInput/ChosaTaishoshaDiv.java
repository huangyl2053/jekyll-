package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.TokkiJikoInput.TokkiJikoInput;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseiRenrakusakiKihon.NinteiShinseiRenrakusakiKihon.INinteiShinseiRenrakusakiKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseiRenrakusakiKihon.NinteiShinseiRenrakusakiKihon.NinteiShinseiRenrakusakiKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ninteishinseishakihoninfo.NinteiShinseishaKihonInfo.INinteiShinseishaKihonInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ninteishinseishakihoninfo.NinteiShinseishaKihonInfo.NinteiShinseishaKihonInfoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ChosaTaishosha のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChosaTaishoshaDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-02-23_06-32-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdNinteiShinseishaKihon")
    private NinteiShinseishaKihonInfoDiv ccdNinteiShinseishaKihon;
    @JsonProperty("ccdNinteiShinseiRenrakusakiKihon")
    private NinteiShinseiRenrakusakiKihonDiv ccdNinteiShinseiRenrakusakiKihon;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdNinteiShinseishaKihon
     * @return ccdNinteiShinseishaKihon
     */
    @JsonProperty("ccdNinteiShinseishaKihon")
    public INinteiShinseishaKihonInfoDiv getCcdNinteiShinseishaKihon() {
        return ccdNinteiShinseishaKihon;
    }

    /*
     * getccdNinteiShinseiRenrakusakiKihon
     * @return ccdNinteiShinseiRenrakusakiKihon
     */
    @JsonProperty("ccdNinteiShinseiRenrakusakiKihon")
    public INinteiShinseiRenrakusakiKihonDiv getCcdNinteiShinseiRenrakusakiKihon() {
        return ccdNinteiShinseiRenrakusakiKihon;
    }

    // </editor-fold>
}
