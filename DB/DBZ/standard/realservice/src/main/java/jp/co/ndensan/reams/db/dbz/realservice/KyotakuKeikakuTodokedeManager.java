/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.model.KyotakuKeikakuTodokedeModel;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.persistence.relate.KyotakuKeikakuTodokedeDac;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
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
     * @param 被保険者番号
     * @param 証記載保険者番号
     * @param 識別コード
     * @param 対象年月
     * @param 処理日時
     *
     * @return KyotakuKeikakuTodokedeModel
     */
    @Transaction
    public KyotakuKeikakuTodokedeModel get居宅給付計画届出(HihokenshaNo 被保険者番号,
            HokenshaNo 証記載保険者番号, ShikibetsuCode 識別コード, FlexibleYearMonth 対象年月, YMDHMS 処理日時) {

        return dac.selectByKey(被保険者番号, 証記載保険者番号, 識別コード, 対象年月, 処理日時);
    }

    /**
     * 居宅給付計画届出の一覧を返します。
     *
     * @return IItemList<KyotakuKeikakuTodokedeModel>
     */
    @Transaction
    public IItemList<KyotakuKeikakuTodokedeModel> get居宅給付計画届出一覧() {
        return dac.selectAll();
    }

    /**
     * 被保険者番号に合致する居宅給付計画届出の一覧を返します。
     *
     * @param 被保険者番号 被保険者番号
     *
     * @return IItemList<KyotakuKeikakuTodokedeModel>
     */
    @Transaction
    public IItemList<KyotakuKeikakuTodokedeModel> get居宅給付計画届出一覧(HihokenshaNo 被保険者番号) {
        return dac.select居宅給付計画届出一覧By被保険者番号(被保険者番号);
    }

    /**
     * 居宅給付計画届出を登録します。
     *
     * @param 居宅給付計画届出モデル KyotakuKeikakuTodokedeModel
     * @return 登録件数
     */
    @Transaction
    public int save居宅給付計画届出(KyotakuKeikakuTodokedeModel 居宅給付計画届出モデル) {

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
