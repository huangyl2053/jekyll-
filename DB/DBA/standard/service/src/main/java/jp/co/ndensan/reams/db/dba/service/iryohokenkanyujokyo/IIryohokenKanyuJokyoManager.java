/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.iryohokenkanyujokyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.hihokensha.iryohokenkanyujokyo.IryohokenKanyuJokyo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1008IryohokenKanyuJokyoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1008IryohokenKanyuJokyoDac;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 医療保険履歴のクラスです。
 *
 */
public class IIryohokenKanyuJokyoManager {

    private final MapperProvider mapperProvider;
    private final DbT1008IryohokenKanyuJokyoDac dac;

    public IIryohokenKanyuJokyoManager() {

        mapperProvider = InstanceProvider.create(MapperProvider.class);
        dac = InstanceProvider.create(DbT1008IryohokenKanyuJokyoDac.class);
    }

    IIryohokenKanyuJokyoManager(DbT1008IryohokenKanyuJokyoDac dac, MapperProvider mapperProvider) {

        this.mapperProvider = mapperProvider;
        this.dac = dac;
    }

    public static IIryohokenKanyuJokyoManager createInstance() {
        return InstanceProvider.create(IIryohokenKanyuJokyoManager.class);
    }

    /**
     * 医療保険情報リストを取得します。
     *
     * @param 識別コード 識別コード
     * @return List<IryohokenKanyuJokyo>
     */
    @Transaction
    public List<IryohokenKanyuJokyo> getIryoHokenJohoList(ShikibetsuCode 識別コード) {
        List<IryohokenKanyuJokyo> iryoHokenJohoList = new ArrayList<>();
        List<DbT1008IryohokenKanyuJokyoEntity> entity = dac.selectByCode(識別コード);
        if (entity.isEmpty()) {
            return new ArrayList<>();
        }
        for (DbT1008IryohokenKanyuJokyoEntity list : entity) {
            iryoHokenJohoList.add(new IryohokenKanyuJokyo(list));
        }

        return iryoHokenJohoList;
    }

    /**
     * 医療保険情報の保存処理を保存します。
     *
     * @param 医療保険情報List 医療保険情報
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public int saveAllIryoHokenJoho(List<IryohokenKanyuJokyo> 医療保険情報List) {
        int count = 0;
        for (IryohokenKanyuJokyo 医療保険情報 : 医療保険情報List) {
            count += dac.save(医療保険情報.toEntity());
        }
        return count;
    }
}
