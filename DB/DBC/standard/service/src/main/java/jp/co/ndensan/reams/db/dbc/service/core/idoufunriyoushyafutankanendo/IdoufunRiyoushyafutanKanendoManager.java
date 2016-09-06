/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.idoufunriyoushyafutankanendo;

import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.idoufunriyoushyafutankanendo.IIdoufunRiyoushyafutanKanendoMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 異動分利用者負担割合判定（過年度）のManagerクラスです。
 *
 * @reamsid_L DBC-4940-010 wangrenze
 */
public class IdoufunRiyoushyafutanKanendoManager {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public IdoufunRiyoushyafutanKanendoManager() {
        mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link IdoufunRiyoushyafutanKanendoManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link IdoufunRiyoushyafutanKanendoManager}のインスタンス
     */
    public static IdoufunRiyoushyafutanKanendoManager createInstance() {
        return InstanceProvider.create(IdoufunRiyoushyafutanKanendoManager.class);
    }

    /**
     * 直近の年次負担割合判定処理のデータを取得です.
     *
     * @param 処理名
     * @return 直近の年次負担割合判定処理のデータ ShoriDateKanri
     */
    public ShoriDateKanri get直近の年次負担割合判定処理(RString 処理名) {
        IIdoufunRiyoushyafutanKanendoMapper mapper = mapperProvider.create(IIdoufunRiyoushyafutanKanendoMapper.class);
        return new ShoriDateKanri(mapper.get直近の年次負担割合判定処理(処理名));
    }

    /**
     * 処理年度の異動分利用者負担割合判定_過年度のデータを取得です.
     *
     * @param 処理名 RString
     * @return 処理年度の異動分利用者負担割合判定_過年度のデータ ShoriDateKanri
     */
    public ShoriDateKanri get異動分利用者負担割合判定_過年度のデータ(RString 処理名) {
        IIdoufunRiyoushyafutanKanendoMapper mapper = mapperProvider.create(IIdoufunRiyoushyafutanKanendoMapper.class);
        return new ShoriDateKanri(mapper.get処理年度の異動分利用者負担割合判定_過年度のデータ(処理名));
    }

    /**
     * 異動分利用者負担割合判定のデータを取得です.
     *
     * @param 処理名 RString
     * @param 年次判定年度 RString
     * @return 異動分利用者負担割合判定のデータ ShoriDateKanri
     */
    public ShoriDateKanri get異動分利用者負担割合判定のデータ(RString 処理名, RString 年次判定年度) {
        IIdoufunRiyoushyafutanKanendoMapper mapper = mapperProvider.create(IIdoufunRiyoushyafutanKanendoMapper.class);

        return new ShoriDateKanri(mapper.get異動分利用者負担割合判定のデータ(処理名, 年次判定年度));
    }
}
