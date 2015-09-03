/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3005KyotakuKeikakuTodokedeEntity;
import jp.co.ndensan.reams.db.dbz.persistence.relate.KyotakuKeikakuTodokedeDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 居宅給付計画届出を管理するクラスです。
 *
 * @author n8187 久保田 英男
 */
public class KyotakuKeikakuTodokedeManager {

    private final KyotakuKeikakuTodokedeDac dac;

    /**
     * コンストラクタです。
     */
    public KyotakuKeikakuTodokedeManager() {
        dac = InstanceProvider.create(KyotakuKeikakuTodokedeDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     */
    KyotakuKeikakuTodokedeManager(KyotakuKeikakuTodokedeDac dac) {
        this.dac = dac;
    }

    /**
     * 検索条件に合致する居宅給付計画届出を返します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 対象年月 対象年月
     * @param 履歴番号 履歴番号
     *
     * @return DbT3005KyotakuKeikakuTodokedeEntity
     */
    @Transaction
    public Optional<DbT3005KyotakuKeikakuTodokedeEntity> get居宅給付計画届出(HihokenshaNo 被保険者番号,
            FlexibleYearMonth 対象年月,
            Decimal 履歴番号) {

        return dac.selectByKey(被保険者番号, 対象年月, 履歴番号);
    }

    /**
     * 居宅給付計画届出の一覧を返します。
     *
     * @return IItemList<DbT3005KyotakuKeikakuTodokedeEntity>
     */
    @Transaction
    public IItemList<DbT3005KyotakuKeikakuTodokedeEntity> get居宅給付計画届出一覧() {
        return dac.selectAll();
    }

    /**
     * 被保険者番号に合致する居宅給付計画届出の一覧を返します。
     *
     * @param 被保険者番号 被保険者番号
     *
     * @return IItemList<DbT3005KyotakuKeikakuTodokedeEntity>
     */
    @Transaction
    public IItemList<DbT3005KyotakuKeikakuTodokedeEntity> get居宅給付計画届出一覧(HihokenshaNo 被保険者番号) {
        return dac.select居宅給付計画届出一覧By被保険者番号(被保険者番号);
    }

    /**
     * 居宅給付計画届出を登録します。
     *
     * @param 居宅給付計画届出モデル DbT3005KyotakuKeikakuTodokedeEntity
     * @return 登録件数
     */
    @Transaction
    public int save居宅給付計画届出(DbT3005KyotakuKeikakuTodokedeEntity 居宅給付計画届出モデル) {

        if (居宅給付計画届出モデル.getState() == EntityDataState.Added) {
            return dac.insert(居宅給付計画届出モデル);
        } else if (居宅給付計画届出モデル.getState() == EntityDataState.Modified) {
            return dac.update(居宅給付計画届出モデル);
        } else if (居宅給付計画届出モデル.getState() == EntityDataState.Deleted) {
            return dac.delete(居宅給付計画届出モデル);
        }

        throw new ApplicationException(UrErrorMessages.更新対象のデータがない.getMessage());
    }
}
