/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.shujiiiryokikanmaster;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.ninnteichousairai.ShichosonMeishoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.shujiiiryokikanjohomaster.KoseiShujiiIryoKikanMasterBusiness;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shujiiiryokikanjohomaster.KoseiShujiiIryoKikanMasterMapperParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shujiiiryokikanjohomaster.KoseiShujiiIryoKikanMasterSearchParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiiiryokikanjohomaster.KoseiShujiiIryoKikanMasterRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shujiiiryokikanmaster.IKoseiShujiiIryoKikanMasterMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7051KoseiShichosonMasterDac;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShujiiIryoKikanJoho;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5911ShujiiIryoKikanJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 主治医医療機関情報を管理するクラスです。
 *
 * @reamsid_L DBE-0240-010 dongyabin
 */
public class KoseiShujiiIryoKikanMasterFinder {

    private final MapperProvider mapperProvider;
    private final DbT7051KoseiShichosonMasterDac dac;

    /**
     * コンストラクタです。
     */
    KoseiShujiiIryoKikanMasterFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.dac = InstanceProvider.create(DbT7051KoseiShichosonMasterDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param mapperProvider dac
     */
    KoseiShujiiIryoKikanMasterFinder(MapperProvider mapperProvider,
            DbT7051KoseiShichosonMasterDac dac) {
        this.mapperProvider = mapperProvider;
        this.dac = dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KoseiShujiiIryoKikanMasterFinder}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link KoseiShujiiIryoKikanMasterFinder}のインスタンス
     */
    public static KoseiShujiiIryoKikanMasterFinder createInstance() {
        return InstanceProvider.create(KoseiShujiiIryoKikanMasterFinder.class);
    }

    /**
     * 主キーに合致する主治医医療機関情報を返します。
     *
     * @param 主治医医療機関情報検索条件 主治医医療機関情報検索条件
     * @return SearchResult<KoseiShujiiIryoKikanMasterBusiness> 主治医医療機関情報を管理
     */
    @Transaction
    public SearchResult<KoseiShujiiIryoKikanMasterBusiness> getShujiKikanJohoIchiranList(
            KoseiShujiiIryoKikanMasterMapperParameter 主治医医療機関情報検索条件) {
        requireNonNull(主治医医療機関情報検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医医療機関情報検索条件"));
        IKoseiShujiiIryoKikanMasterMapper mapper = mapperProvider.create(IKoseiShujiiIryoKikanMasterMapper.class);
        List<KoseiShujiiIryoKikanMasterRelateEntity> relateEntityList = mapper.selectShujiKikanJohoIchiranList(主治医医療機関情報検索条件);
        int totalcount = 0;
        if (relateEntityList.isEmpty()) {
            return SearchResult.of(Collections.<KoseiShujiiIryoKikanMasterBusiness>emptyList(), totalcount, false);
        } else {
            totalcount = relateEntityList.get(0).getTotalCount();
        }
        List<KoseiShujiiIryoKikanMasterBusiness> 調査員情報List = new ArrayList<>();
        for (KoseiShujiiIryoKikanMasterRelateEntity relateEntity : relateEntityList) {
            調査員情報List.add(new KoseiShujiiIryoKikanMasterBusiness(relateEntity));
        }
        return SearchResult.of(調査員情報List, totalcount, 主治医医療機関情報検索条件.getSaidaiHyojiKensu().intValue() < totalcount);
    }

    /**
     * 検索条件に従い、主治医医療機関情報を検索します。
     *
     * @param 主治医医療機関情報検索条件 主治医医療機関情報検索条件
     * @return ShujiiIryoKikanJoho 主治医医療機関情報を管理 nullが返る可能性があります。
     */
    @Transaction
    public SearchResult<ShujiiIryoKikanJoho> getShujiiIryoKikanJohoList(KoseiShujiiIryoKikanMasterMapperParameter 主治医医療機関情報検索条件) {
        List<ShujiiIryoKikanJoho> businessList = new ArrayList<>();
        IKoseiShujiiIryoKikanMasterMapper mapper = mapperProvider.create(IKoseiShujiiIryoKikanMasterMapper.class);
        List<DbT5911ShujiiIryoKikanJohoEntity> entityList = mapper.selectShujiiIryoKikanJohoList(主治医医療機関情報検索条件);
        if (entityList.isEmpty()) {
            return SearchResult.of(Collections.<ShujiiIryoKikanJoho>emptyList(), 0, false);
        }
        for (DbT5911ShujiiIryoKikanJohoEntity entity : entityList) {
            entity.initializeMd5();
            businessList.add(new ShujiiIryoKikanJoho(entity));
        }
        return SearchResult.of(businessList, 0, false);
    }

    /**
     * 検索条件に従い、主治医医療機関情報の件数を検索します。
     *
     * @param 主治医医療機関情報検索条件 主治医医療機関情報検索条件
     * @return 主治医医療機関情報情報の件数
     */
    @Transaction
    public int getShujiiIryoKikanJohoCount(KoseiShujiiIryoKikanMasterSearchParameter 主治医医療機関情報検索条件) {
        IKoseiShujiiIryoKikanMasterMapper mapper = mapperProvider.create(IKoseiShujiiIryoKikanMasterMapper.class);
        return mapper.selectShujiiIryoKikanJohoCount(主治医医療機関情報検索条件);
    }

    /**
     * 検索条件に従い、主治医情報の件数を検索します。
     *
     * @param 主治医情報検索条件 主治医情報検索条件
     * @return 主治医情報情報の件数
     */
    @Transaction
    public int getShujiiJohoCount(KoseiShujiiIryoKikanMasterSearchParameter 主治医情報検索条件) {
        IKoseiShujiiIryoKikanMasterMapper mapper = mapperProvider.create(IKoseiShujiiIryoKikanMasterMapper.class);
        return mapper.selectShujiiJohoCount(主治医情報検索条件);
    }

    /**
     * 検索条件に従い、市町村名検索します。
     *
     * @param 市町村コード 市町村コード
     * @return 市町村名
     */
    @Transaction
    public SearchResult<ShichosonMeishoBusiness> getShichosonMeisho(LasdecCode 市町村コード) {
        List<DbT7051KoseiShichosonMasterEntity> entityList = dac.selectByshichosonCode(市町村コード);
        if (entityList == null || entityList.isEmpty()) {
            return SearchResult.of(Collections.<ShichosonMeishoBusiness>emptyList(), 0, false);
        }
        List<ShichosonMeishoBusiness> shichosonMeisho = new ArrayList<>();
        for (DbT7051KoseiShichosonMasterEntity entity : entityList) {
            shichosonMeisho.add(new ShichosonMeishoBusiness(entity));
        }
        return SearchResult.of(shichosonMeisho, 0, false);
    }
}
