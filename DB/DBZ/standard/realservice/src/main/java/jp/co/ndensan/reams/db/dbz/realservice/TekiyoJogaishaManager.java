/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1002TekiyoJogaishaEntity;
import jp.co.ndensan.reams.db.dbz.persistence.relate.TekiyoJogaishaDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 適用除外者Modelを管理するクラスです。
 *
 * @author n8178 城間篤人
 */
public class TekiyoJogaishaManager {

    private final TekiyoJogaishaDac dac;

    /**
     * コンストラクタです。
     */
    public TekiyoJogaishaManager() {
        dac = InstanceProvider.create(TekiyoJogaishaDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     */
    TekiyoJogaishaManager(TekiyoJogaishaDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する適用除外者Modelを返します。
     *
     * @param 識別コード ShikibetsuCode
     * @param 異動日 FlexibleDate
     * @param 枝番 RString
     * @return TekiyoJogaishaModelModel
     */
    @Transaction
    public Optional<DbT1002TekiyoJogaishaEntity> get適用除外者Model(ShikibetsuCode 識別コード,
            FlexibleDate 異動日,
            RString 枝番) {

        return Optional.of(dac.select適用除外者ModelByKey(識別コード, 異動日, 枝番));
    }

    /**
     * 一人分の適用除外者情報Listを、適用日の降順で取得します。
     *
     * @param 市町村コード LasdecCode
     * @param 識別コード ShikibetsuCode
     * @return List<TekiyoJogaishaModelModel>
     */
    @Transaction
    public IItemList<DbT1002TekiyoJogaishaEntity> get適用除外者情報List(LasdecCode 市町村コード, ShikibetsuCode 識別コード) {
        return ItemList.of(dac.select適用除外者List(市町村コード, 識別コード));
    }

    /**
     * 適用除外者Modelを登録します。
     *
     * @param 適用除外者Modelモデル TekiyoJogaishaModelModel
     * @return 登録件数
     */
    @Transaction
    public int save適用除外者Model(DbT1002TekiyoJogaishaEntity 適用除外者Modelモデル) {

        if (適用除外者Modelモデル.getState() == EntityDataState.Added) {
            return dac.insert(適用除外者Modelモデル);
        } else if (適用除外者Modelモデル.getState() == EntityDataState.Modified) {
            return dac.update(適用除外者Modelモデル);
        } else if (適用除外者Modelモデル.getState() == EntityDataState.Deleted) {
            return dac.delete(適用除外者Modelモデル);
        }

        throw new ApplicationException(UrErrorMessages.更新対象のデータがない.getMessage());
    }
}
