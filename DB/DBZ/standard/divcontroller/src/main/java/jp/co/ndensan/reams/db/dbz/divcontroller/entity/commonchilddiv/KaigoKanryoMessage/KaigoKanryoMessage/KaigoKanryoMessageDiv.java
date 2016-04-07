package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.KanryoMessage.IKanryoMessageDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.KanryoMessage.KanryoMessageDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import java.util.HashSet;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.ui.binding.Mode;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;

/**
 * KaigoKanryoMessage のクラスファイル
 *
 * @author 自動生成
 */
public class KaigoKanryoMessageDiv extends Panel implements IKaigoKanryoMessageDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdKanryoMessage")
    private KanryoMessageDiv ccdKanryoMessage;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdKanryoMessage
     * @return ccdKanryoMessage
     */
    @JsonProperty("ccdKanryoMessage")
    public IKanryoMessageDiv getCcdKanryoMessage() {
        return ccdKanryoMessage;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void setMessage(RString message, RString messageTaisho1, RString messageTaisho2, boolean isSuccess) {
        getHandler().setMessage(message, messageTaisho1, messageTaisho2, isSuccess);
    }

    @Override
    public void setMessage(RString message, RString messageTaishoLabel, RString messageTaisho1, RString messageTaisho2, boolean isSuccess) {
        getHandler().setMessage(message, messageTaishoLabel, messageTaisho1, messageTaisho2, isSuccess);
    }

    @Override
    public void setMessage(IMessageGettable message, RString messageTaisho1, RString messageTaisho2, boolean isSuccess) {
        getHandler().setMessage(message, messageTaisho1, messageTaisho2, isSuccess);
    }

    @Override
    public void setMessage(IMessageGettable message, RString messageTaisho1, RString messageTaisho2,
            boolean isSuccess, String... replaces) {
        getHandler().setMessage(message, messageTaisho1, messageTaisho2, isSuccess, replaces);
    }

    @Override
    public void setSuccessMessage(RString messageMain, RString messageTaisho1, RString messageTaisho2) {
        getHandler().setSuccessMessage(messageMain, messageTaisho1, messageTaisho2);
    }

    @Override
    public void setFailMessage(RString messageMain, RString messageTaisho1, RString messageTaisho2) {
        getHandler().setFailMessage(messageMain, messageTaisho1, messageTaisho2);
    }

    @Override
    public void setSuccessMessage(RString messageMain) {
        getHandler().setSuccessMessage(messageMain);
    }

    @Override
    public void setFailMessage(RString messageMain) {
        getHandler().setFailMessage(messageMain);
    }

    private KaigoKanryoMessageHandler getHandler() {
        return new KaigoKanryoMessageHandler(this);
    }

}
