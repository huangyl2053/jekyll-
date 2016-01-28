/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.konicho;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.konicho.KoNiChoItem;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.konicho.KoNiChoRelateMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.konicho.KoNiChoRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.core.basic.MapperProvider;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.konicho.IKoNiChoRelateMapper;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5913ChosainJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5913ChosainJohoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 調査員内容を管理するクラスです。
 */
public class KoNiChoManager {

    private final MapperProvider mapperProvider;
    private final DbT5913ChosainJohoDac dac;

    /**
     * コンストラクタです。
     */
    KoNiChoManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        dac = InstanceProvider.create(DbT5913ChosainJohoDac.class);

    }

    public static KoNiChoManager createInstance() {
        return InstanceProvider.create(KoNiChoManager.class);

    }

    /**
     * 調査員内容を返します。
     *
     * @param 調査員内容検索条件 調査員内容検索条件
     * @return KoNiChoRelateEntity 。
     */
    @Transaction
    public List<KoNiChoItem> get調査員内容(KoNiChoRelateMapperParameter 調査員内容検索条件) {
        requireNonNull(調査員内容検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("調査員内容検索条件"));
        List<KoNiChoItem> Busslist = new ArrayList();
        IKoNiChoRelateMapper mapper = mapperProvider.create(IKoNiChoRelateMapper.class);
        List<KoNiChoRelateEntity> relatelist = mapper.getKoNiChoRelateEntity(調査員内容検索条件);
        if (relatelist == null || relatelist.isEmpty()) {
            return Busslist;
        }
        for (KoNiChoRelateEntity entity : relatelist) {
            Busslist.add(new KoNiChoItem(entity));
        }
        return null;

    }

    /**
     * update調査員を保存します。
     *
     * @param 調査員 {@link ChosainJoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public int update調査員(DbT5913ChosainJohoEntity 調査員) {
        requireNonNull(調査員, UrSystemErrorMessages.値がnull.getReplacedMessage("調査員"));
        if (!調査員.hasChanged()) {
            return 0;
        }
        int i = dac.save(調査員);
        return i;
    }

    /**
     * insert調査員を保存します。
     *
     * @param 調査員 {@link ChosainJoho}
     * @return 追加件数 追加結果の件数を返します。
     */
    @Transaction
    public int insert調査員(DbT5913ChosainJohoEntity 調査員) {
        requireNonNull(調査員, UrSystemErrorMessages.値がnull.getReplacedMessage("調査員"));
        int i = dac.save(調査員);
        return i;
    }

    /**
     * delete調査員{@link ChosainJoho}を保存します。
     *
     * @param 調査員 {@link ChosainJoho}
     * @return 削除件数 削除結果の件数を返します。
     */
    @Transaction
    public int delete調査員(DbT5913ChosainJohoEntity 調査員) {
        requireNonNull(調査員, UrSystemErrorMessages.値がnull.getReplacedMessage("調査員"));
        int i = dac.save(調査員);
        return i;
    }

}
