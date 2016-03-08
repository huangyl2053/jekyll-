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

    /*
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum SizeType implements ICommonChildDivMode {

        Normal("Normal"),
        Small("Small");

        private final String name;

        private SizeType(final String name) {
            this.name = name;
        }

        public static SizeType getEnum(String str) {
            SizeType[] enumArray = SizeType.values();

            for (SizeType enumStr : enumArray) {
                if (str.equals(enumStr.name.toString())) {
                    return enumStr;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            return this.name;
        }

    }

    public SizeType getMode_SizeType() {
        return (SizeType) _CommonChildDivModeUtil.getMode(this.modes, SizeType.class);
    }

    public void setMode_SizeType(SizeType value) {
        _CommonChildDivModeUtil.setMode(this.modes, SizeType.class, value);
    }

    public static enum MessageType implements ICommonChildDivMode {

        Nomal("Nomal"),
        Empty("Empty");

        private final String name;

        private MessageType(final String name) {
            this.name = name;
        }

        public static MessageType getEnum(String str) {
            MessageType[] enumArray = MessageType.values();

            for (MessageType enumStr : enumArray) {
                if (str.equals(enumStr.name.toString())) {
                    return enumStr;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            return this.name;
        }

    }

    public MessageType getMode_MessageType() {
        return (MessageType) _CommonChildDivModeUtil.getMode(this.modes, MessageType.class);
    }

    public void setMode_MessageType(MessageType value) {
        _CommonChildDivModeUtil.setMode(this.modes, MessageType.class, value);
    }

    public static enum ResultType implements ICommonChildDivMode {

        Success("Success"),
        Error("Error");

        private final String name;

        private ResultType(final String name) {
            this.name = name;
        }

        public static ResultType getEnum(String str) {
            ResultType[] enumArray = ResultType.values();

            for (ResultType enumStr : enumArray) {
                if (str.equals(enumStr.name.toString())) {
                    return enumStr;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            return this.name;
        }

    }

    public ResultType getMode_ResultType() {
        return (ResultType) _CommonChildDivModeUtil.getMode(this.modes, ResultType.class);
    }

    public void setMode_ResultType(ResultType value) {
        _CommonChildDivModeUtil.setMode(this.modes, ResultType.class, value);
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
