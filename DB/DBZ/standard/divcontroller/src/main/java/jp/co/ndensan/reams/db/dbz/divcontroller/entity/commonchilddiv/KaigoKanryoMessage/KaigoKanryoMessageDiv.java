package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashSet;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.KanryoMessage.IKanryoMessageDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.KanryoMessage.KanryoMessageDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.ui.binding.Mode;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;

/**
 * KaigoKanryoMessage のクラスファイル
 *
 * @author 自動生成
 */
public class KaigoKanryoMessageDiv extends Panel implements IKaigoKanryoMessageDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-57">
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
    /**
     * 親画面から介護完了メッセージを引き渡す時の処理（メッセージ：文字列の場合）を行います。
     *
     * @param message 完了メッセージ文字列
     * @param messageTaisho1 完了メッセージ対象情報1
     * @param messageTaisho2 完了メッセージ対象情報2
     * @param isSuccess 完了ステータス 成功ならばtrue
     */
    @Override
    public void setMessage(RString message, RString messageTaisho1, RString messageTaisho2, boolean isSuccess) {
        getHandler().setMessage(message, messageTaisho1, messageTaisho2, isSuccess);
    }

    /**
     * 親画面から介護完了メッセージを引き渡す時の処理（メッセージ：オブジェクト「IMessageGettable」の場合）を行います。
     *
     * @param message 完了メッセージオブジェクト
     * @param messageTaisho1 完了メッセージ対象情報1
     * @param messageTaisho2 完了メッセージ対象情報2
     * @param isSuccess 完了ステータス 成功ならばtrue
     */
    @Override
    public void setMessage(IMessageGettable message, RString messageTaisho1, RString messageTaisho2, boolean isSuccess) {
        getHandler().setMessage(message, messageTaisho1, messageTaisho2, isSuccess);
    }

    /**
     * 親画面から介護完了メッセージを引き渡す時の処理（メッセージ：オブジェクト「IMessageGettable」、且つ置換文字列があるの場合）を行います。
     *
     * @param message 完了メッセージオブジェクト
     * @param messageTaisho1 完了メッセージ対象情報1
     * @param messageTaisho2 完了メッセージ対象情報2
     * @param isSuccess 完了ステータス 成功ならばtrue
     * @param replaces メッセージ置換文字列
     */
    @Override
    public void setMessage(IMessageGettable message, RString messageTaisho1, RString messageTaisho2,
            boolean isSuccess, String... replaces) {
        getHandler().setMessage(message, messageTaisho1, messageTaisho2, isSuccess, replaces);
    }

    private KaigoKanryoMessageHandler getHandler() {
        return new KaigoKanryoMessageHandler(this);
    }

}
