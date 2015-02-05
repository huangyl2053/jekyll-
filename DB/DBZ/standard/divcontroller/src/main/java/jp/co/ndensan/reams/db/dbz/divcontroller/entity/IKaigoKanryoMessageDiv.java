package jp.co.ndensan.reams.db.dbz.divcontroller.entity;

import jp.co.ndensan.reams.ur.urz.divcontroller.entity.IKanryoMessageDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。
 */
public interface IKaigoKanryoMessageDiv {

    /**
     * 保存に成功した場合の、完了メッセージの設定を行います。
     *
     * @param messageMein メインメッセージ
     * @param messageTaisho1 対象者を示すメッセージ1
     * @param messageTaisho2 対象者を示すメッセージ2
     */
    void setSuccessMessage(RString messageMein, RString messageTaisho1, RString messageTaisho2);
}
