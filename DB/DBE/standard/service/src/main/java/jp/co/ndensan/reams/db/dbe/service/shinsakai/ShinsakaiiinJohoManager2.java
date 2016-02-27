/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.shinsakai;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.shinsakaiwariateiinjoho.ShinsakaiWariateIinJoho;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaiiinwaritsuke.ShinsakaiiinJoho;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.shinsakaiiinwaritsuke.ShinsakaiIinWaritsukeParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5503ShinsakaiWariateIinJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakai.shinsakaiwariateiinjoho.ShinsakaiWariateIinJohoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaiiinwaritsuke.ShinsakaiiinJohoRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.core.basic.MapperProvider;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5503ShinsakaiWariateIinJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinsakaiiinwaritsuke.IShinsakaiIinWaritsukeMapper;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護認定審査会委員の取得処理です。
 */
public class ShinsakaiiinJohoManager2 {

    private final MapperProvider mapperProvider;
    private final DbT5503ShinsakaiWariateIinJohoDac dac;

    /**
     * コンストラクタです。
     */
    ShinsakaiiinJohoManager2() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.dac = InstanceProvider.create(DbT5503ShinsakaiWariateIinJohoDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param dac 介護認定審査会割当委員情報のDac
     * @param mapperProvider {@link MapperProvider}
     */
    ShinsakaiiinJohoManager2(
            MapperProvider mapperProvider,
            DbT5503ShinsakaiWariateIinJohoDac dac) {
        this.mapperProvider = mapperProvider;
        this.dac = dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShinsakaiiinJohoManager2}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ShinsakaiiinJohoManager2}のインスタンス
     */
    public static ShinsakaiiinJohoManager2 createInstance() {
        return InstanceProvider.create(ShinsakaiiinJohoManager2.class);
    }

    /**
     * 開催番号によって、介護認定審査会委員情報を取得します。
     *
     * @param kaisaiNo 開催番号
     * @param kaisaiYMD 開催年月日
     * @return SearchResult<ShinsakaiiinJoho>
     */
    @Transaction
    public SearchResult<ShinsakaiiinJoho> search審査会委員情報Of開催番号(RString kaisaiNo, RString kaisaiYMD) {
        requireNonNull(kaisaiNo, UrSystemErrorMessages.値がnull.getReplacedMessage("開催番号"));
        IShinsakaiIinWaritsukeMapper mapper = mapperProvider.create(IShinsakaiIinWaritsukeMapper.class);
        List<ShinsakaiiinJohoRelateEntity> shinsakaiiinJohoList
                = mapper.get審査会委員情報By開催番号(
                        ShinsakaiIinWaritsukeParameter.createShinsakaiIinWaritsukeParameter(
                                kaisaiNo,
                                AssociationFinderFactory.createInstance().getAssociation().get地方公共団体コード(),
                                kaisaiYMD));
        List<ShinsakaiiinJoho> businessList = new ArrayList();
        for (ShinsakaiiinJohoRelateEntity entity : shinsakaiiinJohoList) {
            businessList.add(new ShinsakaiiinJoho(entity));
        }
        return SearchResult.of(businessList, 0, false);
    }

    /**
     * 介護認定審査会委員全件情報を取得します。
     *
     * @param kaisaiYMD 開催年月日
     * @return SearchResult<ShinsakaiiinJoho>
     */
    @Transaction
    public SearchResult<ShinsakaiiinJoho> searchAll審査会委員情報(RString kaisaiYMD) {
        requireNonNull(kaisaiYMD, UrSystemErrorMessages.値がnull.getReplacedMessage("開催年月日"));
        IShinsakaiIinWaritsukeMapper mapper = mapperProvider.create(IShinsakaiIinWaritsukeMapper.class);
        List<ShinsakaiiinJohoRelateEntity> shinsakaiiinJohoList
                = mapper.get審査会委員情報By開催年月日(
                        ShinsakaiIinWaritsukeParameter.createShinsakaiIinWaritsukeParameter(
                                RString.EMPTY,
                                AssociationFinderFactory.createInstance().getAssociation().get地方公共団体コード(),
                                kaisaiYMD));
        List<ShinsakaiiinJoho> businessList = new ArrayList();
        for (ShinsakaiiinJohoRelateEntity entity : shinsakaiiinJohoList) {
            businessList.add(new ShinsakaiiinJoho(entity));
        }
        return SearchResult.of(businessList, 0, false);
    }

    /**
     * 介護認定審査会割当委員情報を物理削除します。
     *
     * @param entity 介護認定審査会割当委員情報
     * @return 削除あり:true、削除なし:false <br>
     */
    @Transaction
    public boolean deletePhysicalByKaisaiNo(DbT5503ShinsakaiWariateIinJohoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会割当委員情報"));
        return 0 < dac.deletePhysical(entity);
    }

    /**
     * 開催番号で介護認定審査会割当委員情報を取得します。
     *
     * @param kaisaiNo 開催番号
     * @return SearchResult<ShinsakaiWariateIinJoho>
     */
    @Transaction
    public SearchResult<ShinsakaiWariateIinJoho> searchByKaisaiNo(RString kaisaiNo) {
        requireNonNull(kaisaiNo, UrSystemErrorMessages.値がnull.getReplacedMessage("開催番号"));
        List<DbT5503ShinsakaiWariateIinJohoEntity> entityList = dac.selectBy開催番号(kaisaiNo);
        List<ShinsakaiWariateIinJoho> businessList = new ArrayList();
        for (DbT5503ShinsakaiWariateIinJohoEntity entity : entityList) {
            ShinsakaiWariateIinJohoRelateEntity relateEntity = new ShinsakaiWariateIinJohoRelateEntity();
            relateEntity.set介護認定審査会割当委員情報Entity(entity);
            businessList.add(new ShinsakaiWariateIinJoho(relateEntity));
        }
        return SearchResult.of(businessList, 0, false);
    }

    /**
     * 介護認定審査会割当委員情報を新規処理します。
     *
     * @param entity 介護認定審査会割当委員情報エンティティ
     * @return 新規あり:true、新規なし:false <br>
     * いずれかのテーブルに新規があればtrueを返す
     */
    @Transaction
    public boolean save(DbT5503ShinsakaiWariateIinJohoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会割当委員情報エンティティ"));
        return 0 < dac.save(entity);
    }
}
