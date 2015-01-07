/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice.hihokenshadaicho;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho.HihokenshaDaichoModel;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.IOptional;
import jp.co.ndensan.reams.db.dbz.persistence.relate.HihokenshaDaichoDac;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 被保険者台帳を管理するクラスです。
 *
 * @author n8187 久保田 英男
 */
public class HihokenshaDaichoManager {

    private final HihokenshaDaichoDac dac;

    /**
     * コンストラクタです。
     */
    public HihokenshaDaichoManager() {
        dac = InstanceProvider.create(HihokenshaDaichoDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     */
    HihokenshaDaichoManager(HihokenshaDaichoDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する被保険者台帳を返します。
     *
     * @param 市町村コード 市町村コード
     * @param 被保険者番号 被保険者番号
     * @param 処理日時 処理日時
     * @return HihokenshaDaichoModel
     */
    @Transaction
    public IOptional<HihokenshaDaichoModel> get被保険者台帳(LasdecCode 市町村コード,
            HihokenshaNo 被保険者番号,
            YMDHMS 処理日時) {

        return dac.selectByKey(市町村コード, 被保険者番号, 処理日時);
    }

    /**
     * 被保険者台帳の一覧を返します。
     *
     * @return IItemList<HihokenshaDaichoModel>
     */
    @Transaction
    public IItemList<HihokenshaDaichoModel> get被保険者台帳一覧() {
        return dac.selectAll();
    }

    /**
     * 被保険者番号に合致する直近の被保険者台帳を返します。
     *
     * @param 被保険者番号 被保険者番号
     * @return HihokenshaDaichoModel
     */
    @Transaction
    public IOptional<HihokenshaDaichoModel> get直近被保険者台帳(
            HihokenshaNo 被保険者番号) {

        return dac.select直近被保険者台帳(被保険者番号);
    }

    /**
     * 被保険者台帳を登録します。
     *
     * @param 被保険者台帳モデル HihokenshaDaichoModel
     * @return 登録件数
     */
    @Transaction
    public int save被保険者台帳(HihokenshaDaichoModel 被保険者台帳モデル) {

        if (被保険者台帳モデル.getState() == EntityDataState.Added) {
            return dac.insert(被保険者台帳モデル);
        } else if (被保険者台帳モデル.getState() == EntityDataState.Modified) {
            return dac.update(被保険者台帳モデル);
        } else if (被保険者台帳モデル.getState() == EntityDataState.Deleted) {
            return dac.delete(被保険者台帳モデル);
        }

        throw new ApplicationException(UrErrorMessages.更新対象のデータがない.getMessage());
    }
}
