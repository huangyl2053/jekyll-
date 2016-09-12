package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD4040011;
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
 * ShogaishaKojoTaishoshaNinteishoHakkoPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShogaishaKojoTaishoshaNinteishoHakkoPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShogaishaKojoNinteishoHakko")
    private ShogaishaKojoNinteishoHakkoDiv ShogaishaKojoNinteishoHakko;
    @JsonProperty("TaishoshaKaigoShikaku")
    private KaigoShikakuKihonDiv TaishoshaKaigoShikaku;
    @JsonProperty("TaishoshaAtena")
    private KaigoAtenaInfoDiv TaishoshaAtena;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShogaishaKojoNinteishoHakko
     * @return ShogaishaKojoNinteishoHakko
     */
    @JsonProperty("ShogaishaKojoNinteishoHakko")
    public ShogaishaKojoNinteishoHakkoDiv getShogaishaKojoNinteishoHakko() {
        return ShogaishaKojoNinteishoHakko;
    }

    /*
     * setShogaishaKojoNinteishoHakko
     * @param ShogaishaKojoNinteishoHakko ShogaishaKojoNinteishoHakko
     */
    @JsonProperty("ShogaishaKojoNinteishoHakko")
    public void setShogaishaKojoNinteishoHakko(ShogaishaKojoNinteishoHakkoDiv ShogaishaKojoNinteishoHakko) {
        this.ShogaishaKojoNinteishoHakko = ShogaishaKojoNinteishoHakko;
    }

    /*
     * getTaishoshaKaigoShikaku
     * @return TaishoshaKaigoShikaku
     */
    @JsonProperty("TaishoshaKaigoShikaku")
    public IKaigoShikakuKihonDiv getTaishoshaKaigoShikaku() {
        return TaishoshaKaigoShikaku;
    }

    /*
     * getTaishoshaAtena
     * @return TaishoshaAtena
     */
    @JsonProperty("TaishoshaAtena")
    public IKaigoAtenaInfoDiv getTaishoshaAtena() {
        return TaishoshaAtena;
    }

    // </editor-fold>
}
