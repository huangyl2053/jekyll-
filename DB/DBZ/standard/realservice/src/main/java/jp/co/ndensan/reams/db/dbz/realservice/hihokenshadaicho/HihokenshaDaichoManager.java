/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice.hihokenshadaicho;

import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoriTimestamp;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho.HihokenshaDaichoModel;
import jp.co.ndensan.reams.db.dbz.persistence.relate.HihokenshaDaichoDac;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 被保険者台帳を管理するクラスです。
 *
 * @author N8156 宮本 康
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
     * 主キーに合致する{@link HihokenshaDaichoModel}を返します。
     *
     * @param 市町村コード 市町村コード
     * @param 被保険者番号 被保険者番号
     * @param 処理日時 処理日時
     * @return {@link HihokenshaDaichoModel}
     */
    @Transaction
    public Optional<HihokenshaDaichoModel> find被保険者台帳(LasdecCode 市町村コード, HihokenshaNo 被保険者番号, ShoriTimestamp 処理日時) {
        return dac.select被保険者台帳ByKey(市町村コード, 被保険者番号, 処理日時);
    }

    /**
     * 被保険者台帳の一覧を返します。
     *
     * @return 被保険者台帳の一覧
     */
    @Transaction
    public IItemList<HihokenshaDaichoModel> get被保険者台帳一覧() {
        return dac.selectAll();
    }

    /**
     * 条件に合致する被保険者台帳の一覧を返します。
     *
     * @param 市町村コード 市町村コード
     * @param 被保険者番号 被保険者番号
     * @return IItemList<HihokenshaDaichoModel>
     */
    @Transaction
    public IItemList<HihokenshaDaichoModel> get被保険者台帳一覧(LasdecCode 市町村コード, HihokenshaNo 被保険者番号) {
        return dac.select被保険者台帳一覧(市町村コード, 被保険者番号);
    }

    /**
     * 条件に合致する被保険者台帳の一覧を返します。返却される被保険者台帳のListは処理日時の降順で返ります。
     *
     * @param 市町村コード 市町村コード
     * @param 被保険者番号 被保険者番号
     * @return IItemList<HihokenshaDaichoModel>
     */
    @Transaction
    public IItemList<HihokenshaDaichoModel> get被保険者台帳一覧DescOrderByShoriTimestamp(LasdecCode 市町村コード, HihokenshaNo 被保険者番号) {
        return dac.select被保険者台帳一覧DescOrderByShoriTimestamp(市町村コード, 被保険者番号);
    }

    /**
     * 条件に合致する最新被保険者台帳を返します。
     *
     * @param 市町村コード 市町村コード
     * @param 識別コード 識別コード
     * @return Optional<HihokenshaDaichoModel>
     */
    @Transaction
    public Optional<HihokenshaDaichoModel> get最新被保険者台帳(LasdecCode 市町村コード, ShikibetsuCode 識別コード) {
        return dac.select最新被保険者台帳(市町村コード, 識別コード);
    }

    /**
     * 条件に合致する最新被保険者台帳を返します。
     *
     * @param 被保険者番号 被保険者番号
     * @return Optional<HihokenshaDaichoModel>
     */
    @Transaction
    public Optional<HihokenshaDaichoModel> get最新被保険者台帳(HihokenshaNo 被保険者番号) {
        return dac.select最新被保険者台帳(被保険者番号);
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
