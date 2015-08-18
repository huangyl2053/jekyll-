/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1003TashichosonJushochiTokureiEntity;
import jp.co.ndensan.reams.db.dbz.persistence.relate.TashichosonJushochiTokureiDac;
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
 * 他市町村住所地特例Modelを管理するクラスです。
 *
 * @author n8178 城間篤人
 */
public class TashichosonJushochiTokureiManager {

    private final TashichosonJushochiTokureiDac dac;

    /**
     * コンストラクタです。
     */
    public TashichosonJushochiTokureiManager() {
        dac = InstanceProvider.create(TashichosonJushochiTokureiDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     */
    TashichosonJushochiTokureiManager(TashichosonJushochiTokureiDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する他市町村住所地特例Modelを返します。
     *
     * @param 識別コード ShikibetsuCode
     * @param 異動日 FlexibleDate
     * @param 枝番 RString
     * @return TashichosonJushochiTokureiModelModel
     */
    @Transaction
    public Optional<DbT1003TashichosonJushochiTokureiEntity> get他市町村住所地特例Model(ShikibetsuCode 識別コード,
            FlexibleDate 異動日,
            RString 枝番) {

        return Optional.of(dac.select他市町村住所地特例ModelByKey(識別コード, 異動日, 枝番));
    }

    /**
     * 一人分の他市町村住所地特例Listを、適用日の降順で取得します。
     *
     * @param 市町村コード LasdecCode
     * @param 識別コード ShikibetsuCode
     * @return List<DbT1003TashichosonJushochiTokureiEntity>
     */
    @Transaction
    public IItemList<DbT1003TashichosonJushochiTokureiEntity> get他市町村住所地特例List(LasdecCode 市町村コード, ShikibetsuCode 識別コード) {
        return ItemList.of(dac.select他市町村住所地特例List(市町村コード, 識別コード));
    }

    /**
     * 他市町村住所地特例Modelを登録します。
     *
     * @param 他市町村住所地特例Modelモデル TashichosonJushochiTokureiModelModel
     * @return 登録件数
     */
    @Transaction
    public int save他市町村住所地特例Model(DbT1003TashichosonJushochiTokureiEntity 他市町村住所地特例Modelモデル) {

        if (他市町村住所地特例Modelモデル.getState() == EntityDataState.Added) {
            return dac.insert(他市町村住所地特例Modelモデル);
        } else if (他市町村住所地特例Modelモデル.getState() == EntityDataState.Modified) {
            return dac.update(他市町村住所地特例Modelモデル);
        } else if (他市町村住所地特例Modelモデル.getState() == EntityDataState.Deleted) {
            return dac.delete(他市町村住所地特例Modelモデル);
        }

        throw new ApplicationException(UrErrorMessages.更新対象のデータがない.getMessage());
    }
}
