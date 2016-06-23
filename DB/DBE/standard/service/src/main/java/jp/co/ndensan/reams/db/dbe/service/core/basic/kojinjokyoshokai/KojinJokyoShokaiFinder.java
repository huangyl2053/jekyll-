/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.basic.kojinjokyoshokai;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.kojinjokyoshokai.KojinJokyoShokai;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.kojinjokyoshokai.KojinJokyoShokaiParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.kojinjokyoshokai.KojinJokyoShokaiRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.kojinjokyoshokai.IKojinJokyoShokaiMapper;
import jp.co.ndensan.reams.db.dbz.business.core.ninteishinseirenrakusakijoho.RenrakusakiJoho;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5150RenrakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 要介護認定個人状況照会クラスです。
 *
 * @reamsid_L DBE-0200-010 suguangjun
 */
public class KojinJokyoShokaiFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    KojinJokyoShokaiFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider {@link MapperProvider}}
     */
    KojinJokyoShokaiFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShujiiJohoManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ShujiiJohoManager}のインスタンス
     */
    public static KojinJokyoShokaiFinder createInstance() {
        return InstanceProvider.create(KojinJokyoShokaiFinder.class);
    }

    /**
     * 要介護認定個人状況照会情報を返します。
     *
     * @param parameter 要介護認定個人状況照会用パラメータ
     * @return KojinJokyoShokai 要介護認定個人状況照会情報 nullが返る可能性があります。
     */
    @Transaction
    public SearchResult<KojinJokyoShokai> getKojinJokyoShokai(KojinJokyoShokaiParameter parameter) {
        requireNonNull(parameter, UrSystemErrorMessages.値がnull.getReplacedMessage("parameter"));
        IKojinJokyoShokaiMapper mapper = mapperProvider.create(IKojinJokyoShokaiMapper.class);
        KojinJokyoShokaiRelateEntity kojinJokyoShokaiRelateEntity = mapper.selectKojinJokyoShokai(parameter);
        List<KojinJokyoShokai> kojinJokyoShokaiList = new ArrayList();
        if (kojinJokyoShokaiRelateEntity != null) {
            kojinJokyoShokaiList.add(new KojinJokyoShokai(kojinJokyoShokaiRelateEntity));
        }

        return SearchResult.of(kojinJokyoShokaiList, kojinJokyoShokaiList.size(), true);
    }

    /**
     * 要介護認定個人状況照会情報を返します。
     *
     * @param parameter 要介護認定個人状況照会用パラメータ
     * @return KojinJokyoShokai 要介護認定個人状況照会情報 nullが返る可能性があります。
     */
    @Transaction
    public SearchResult<KojinJokyoShokai> getKojinShinchokuJokyohyo(KojinJokyoShokaiParameter parameter) {
        requireNonNull(parameter, UrSystemErrorMessages.値がnull.getReplacedMessage("parameter"));
        IKojinJokyoShokaiMapper mapper = mapperProvider.create(IKojinJokyoShokaiMapper.class);
        KojinJokyoShokaiRelateEntity shokaiRelateEntity = mapper.selectKojinShinchokuJokyohyo(parameter);
        List<KojinJokyoShokai> businessList = new ArrayList();
        if (shokaiRelateEntity != null) {
            businessList.add(new KojinJokyoShokai(shokaiRelateEntity));
        }
        return SearchResult.of(businessList, 0, false);
    }

    /**
     * 連絡先情報を返します。
     *
     * @param parameter 要介護認定個人状況照会用パラメータ
     * @return RenrakusakiJoho 連絡先情報 nullが返る可能性があります。
     */
    @Transaction
    public SearchResult<RenrakusakiJoho> getRenrakusakiJoho(KojinJokyoShokaiParameter parameter) {
        requireNonNull(parameter, UrSystemErrorMessages.値がnull.getReplacedMessage("parameter"));
        IKojinJokyoShokaiMapper mapper = mapperProvider.create(IKojinJokyoShokaiMapper.class);
        List<DbT5150RenrakusakiJohoEntity> renrakusakiJohoEntityList = mapper.selectRenrakusakiJoho(parameter);
        List<RenrakusakiJoho> businessList = new ArrayList();
        if (!renrakusakiJohoEntityList.isEmpty()) {
            for (DbT5150RenrakusakiJohoEntity sakiJohoEntity : renrakusakiJohoEntityList) {
                businessList.add(new RenrakusakiJoho(sakiJohoEntity));
            }
        }
        return SearchResult.of(businessList, 0, false);
    }
}
