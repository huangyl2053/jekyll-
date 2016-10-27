package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1050021;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.JushochiTokureiDialogButton.IJushochiTokureiDialogButtonDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.JushochiTokureiDialogButton.JushochiTokureiDialogButtonDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.ShikakuHenkoRirekiDialogButton.IShikakuHenkoRirekiDialogButtonDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.ShikakuHenkoRirekiDialogButton.ShikakuHenkoRirekiDialogButtonDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.ShisetsuNyutaishoDialogButton.IShisetsuNyutaishoDialogButtonDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.ShisetsuNyutaishoDialogButton.ShisetsuNyutaishoDialogButtonDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShikakuShosaiDialogs のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShikakuShosaiDialogsDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdShikakuHenkoDialogButton")
    private ShikakuHenkoRirekiDialogButtonDiv ccdShikakuHenkoDialogButton;
    @JsonProperty("ccdJutokuDialogButton")
    private JushochiTokureiDialogButtonDiv ccdJutokuDialogButton;
    @JsonProperty("ccdShisetsuNyutaishoDialogButton")
    private ShisetsuNyutaishoDialogButtonDiv ccdShisetsuNyutaishoDialogButton;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdShikakuHenkoDialogButton
     * @return ccdShikakuHenkoDialogButton
     */
    @JsonProperty("ccdShikakuHenkoDialogButton")
    public IShikakuHenkoRirekiDialogButtonDiv getCcdShikakuHenkoDialogButton() {
        return ccdShikakuHenkoDialogButton;
    }

    /*
     * getccdJutokuDialogButton
     * @return ccdJutokuDialogButton
     */
    @JsonProperty("ccdJutokuDialogButton")
    public IJushochiTokureiDialogButtonDiv getCcdJutokuDialogButton() {
        return ccdJutokuDialogButton;
    }

    /*
     * getccdShisetsuNyutaishoDialogButton
     * @return ccdShisetsuNyutaishoDialogButton
     */
    @JsonProperty("ccdShisetsuNyutaishoDialogButton")
    public IShisetsuNyutaishoDialogButtonDiv getCcdShisetsuNyutaishoDialogButton() {
        return ccdShisetsuNyutaishoDialogButton;
    }

    // </editor-fold>
}
