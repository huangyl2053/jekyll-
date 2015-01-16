/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.model.KyotakuKeikakuJigyoshaSakuseiModel;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.persistence.relate.KyotakuKeikakuJigyoshaSakuseiDac;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 居宅給付計画事業者作成を管理するクラスです。
 *
 * @author n8187 久保田 英男
 */
public class KyotakuKeikakuJigyoshaSakuseiManager {

    private final KyotakuKeikakuJigyoshaSakuseiDac dac;

    /**
     * コンストラクタです。
     */
    public KyotakuKeikakuJigyoshaSakuseiManager() {
        dac = InstanceProvider.create(KyotakuKeikakuJigyoshaSakuseiDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     */
    KyotakuKeikakuJigyoshaSakuseiManager(KyotakuKeikakuJigyoshaSakuseiDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する居宅給付計画事業者作成を返します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 証記載保険者番号 証記載保険者番号
     * @param 識別コード 識別コード
     * @param 対象年月 対象年月
     * @param 処理日時 処理日時
     * @return KyotakuKeikakuJigyoshaSakuseiModel
     */
    @Transaction
    public Optional<KyotakuKeikakuJigyoshaSakuseiModel> get居宅給付計画事業者作成(HihokenshaNo 被保険者番号,
            ShoKisaiHokenshaNo 証記載保険者番号,
            ShikibetsuCode 識別コード,
            FlexibleYearMonth 対象年月,
            YMDHMS 処理日時) {

        return dac.selectByKey(被保険者番号.value(), 証記載保険者番号.value(), 識別コード, 対象年月, 処理日時);
    }

    /**
     * 居宅給付計画事業者作成の一覧を返します。
     *
     * @return IItemList<KyotakuKeikakuJigyoshaSakuseiModel>
     */
    @Transaction
    public IItemList<KyotakuKeikakuJigyoshaSakuseiModel> get居宅計画事業者作成一覧() {
        return dac.selectAll();
    }

    /**
     * 被保険者番号に合致する直近の居宅給付計画事業者作成を返します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 証記載保険者番号 証記載保険者番号
     * @param 識別コード 識別コード
     * @param 対象年月 対象年月
     * @return KyotakuKeikakuJigyoshaSakuseiModel
     */
    @Transaction
    public Optional<KyotakuKeikakuJigyoshaSakuseiModel> get直近居宅計画事業者作成(HihokenshaNo 被保険者番号,
            ShoKisaiHokenshaNo 証記載保険者番号,
            ShikibetsuCode 識別コード,
            FlexibleYearMonth 対象年月) {
        return dac.select直近居宅給付計画事業者作成(被保険者番号.value(), 証記載保険者番号.value(), 識別コード, 対象年月);
    }

    /**
     * 居宅給付計画事業者作成を登録します。
     *
     * @param 居宅給付計画事業者作成モデル KyotakuKeikakuJigyoshaSakuseiModel
     * @return 登録件数
     */
    @Transaction
    public int save居宅給付計画事業者作成(KyotakuKeikakuJigyoshaSakuseiModel 居宅給付計画事業者作成モデル) {

        if (居宅給付計画事業者作成モデル.getState() == EntityDataState.Added) {
            return dac.insert(居宅給付計画事業者作成モデル);
        } else if (居宅給付計画事業者作成モデル.getState() == EntityDataState.Modified) {
            return dac.update(居宅給付計画事業者作成モデル);
        } else if (居宅給付計画事業者作成モデル.getState() == EntityDataState.Deleted) {
            return dac.delete(居宅給付計画事業者作成モデル);
        }

        throw new ApplicationException(UrErrorMessages.更新対象のデータがない.getMessage());
    }
}
