package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * 共有子Div介護完了メッセージのインタフェースクラスです。
 */
public interface IKaigoKanryoMessageDiv extends ICommonChildDivBaseProperties {
    
    /**
     * 親画面から介護完了メッセージを引き渡す時の処理（メッセージ：文字列の場合）を行います。
     * 
     * @param message 完了メッセージ文字列
     * @param messageTaisho1 完了メッセージ対象情報1
     * @param messageTaisho2 完了メッセージ対象情報2
     * @param isSuccess 完了ステータス 成功ならばtrue
     */
    public void setMessage(RString message, RString messageTaisho1, RString messageTaisho2, boolean isSuccess);

    /**
     * 親画面から介護完了メッセージを引き渡す時の処理（メッセージ：オブジェクト「IMessageGettable」の場合）を行います。
     * 
     * @param message 完了メッセージオブジェクト
     * @param messageTaisho1 完了メッセージ対象情報1
     * @param messageTaisho2 完了メッセージ対象情報2
     * @param isSuccess 完了ステータス 成功ならばtrue
     */
    public void setMessage(IMessageGettable message, RString messageTaisho1, RString messageTaisho2, boolean isSuccess);

    /**
     * 親画面から介護完了メッセージを引き渡す時の処理（メッセージ：オブジェクト「IMessageGettable」、且つ置換文字列があるの場合）を行います。
     * 
     * @param message 完了メッセージオブジェクト
     * @param messageTaisho1 完了メッセージ対象情報1
     * @param messageTaisho2 完了メッセージ対象情報2
     * @param isSuccess 完了ステータス 成功ならばtrue
     * @param replaces メッセージ置換文字列
     */
    public void setMessage(IMessageGettable message, RString messageTaisho1, RString messageTaisho2,
            boolean isSuccess, String... replaces);

}
