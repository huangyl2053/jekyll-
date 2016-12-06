/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.ikensho.ninteichosaitakusakimaster;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.basic.SonotaKikanJoho;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosaitakusakimaster.NinteichosaMasterMapperParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosaitakusakimaster.NinteichosaMasterSearchParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.sonotakikanmaster.SonotaKikanJohoEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteichosaimaster.INinteichosaMasterMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5914SonotaKikanJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * その他機関情報クラスです。
 *
 * @reamsid_L DBE-1360-010 suguangjun
 */
public class NinteichosaMasterFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    NinteichosaMasterFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param MapperProvider {@link mapperProvider}
     */
    NinteichosaMasterFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link NinteichosaMasterFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link NinteichosaMasterFinder}のインスタンス
     */
    public static NinteichosaMasterFinder createInstance() {
        return InstanceProvider.create(NinteichosaMasterFinder.class);
    }

    /**
     * 検索条件に従い、その他機関情報を検索します。
     *
     * @param その他機関情報検索条件 その他機関情報検索条件
     * @return ShujiiMaster その他機関情報 nullが返る可能性があります。
     */
    @Transaction
    public SearchResult<SonotaKikanJohoEntity> getSonotaKikanichiranList(NinteichosaMasterMapperParameter その他機関情報検索条件) {
        requireNonNull(その他機関情報検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("その他機関情報検索条件"));
        INinteichosaMasterMapper mapper = mapperProvider.create(INinteichosaMasterMapper.class);
        List<SonotaKikanJohoEntity> kikanJohoEntityList = mapper.selectSonotaKikanichiranList(その他機関情報検索条件);
        if (kikanJohoEntityList.isEmpty()) {
            return SearchResult.of(Collections.<SonotaKikanJohoEntity>emptyList(), 0, false);
        }
        
        return SearchResult.of(kikanJohoEntityList, 0, false);
    }

    /**
     * 検索条件に従い、その他機関情報を検索します。
     *
     * @param その他機関情報検索条件 その他機関情報検索条件
     * @return ShujiiMaster その他機関情報 nullが返る可能性があります。
     */
    @Transaction
    public SearchResult<SonotaKikanJoho> getSonotaKikanJohoList(NinteichosaMasterMapperParameter その他機関情報検索条件) {
        requireNonNull(その他機関情報検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("その他機関情報検索条件"));
        INinteichosaMasterMapper mapper = mapperProvider.create(INinteichosaMasterMapper.class);
        List<DbT5914SonotaKikanJohoEntity> kikanJohoEntityList = mapper.selectSonotaKikanJohoList(その他機関情報検索条件);
        if (kikanJohoEntityList.isEmpty()) {
            return SearchResult.of(Collections.<SonotaKikanJoho>emptyList(), 0, false);
        }
        List<SonotaKikanJoho> その他機関情報List = new ArrayList<>();
        for (DbT5914SonotaKikanJohoEntity entity : kikanJohoEntityList) {
            entity.initializeMd5();
            その他機関情報List.add(new SonotaKikanJoho(entity));
        }
        return SearchResult.of(その他機関情報List, 0, false);
    }

    /**
     * 検索条件に従い、その他機関情報の件数を検索します。
     *
     * @param その他機関情報検索条件 その他機関情報検索条件
     * @return その他機関情報の件数
     */
    @Transaction
    public int getSonotaKikanJohoCount(NinteichosaMasterSearchParameter その他機関情報検索条件) {
        INinteichosaMasterMapper mapper = mapperProvider.create(INinteichosaMasterMapper.class);
        return mapper.selectSonotaKikanJohoCount(その他機関情報検索条件);
    }

    /**
     * 検索条件に従い、介護認定審査会委員所属機関情報件数検索処理。
     *
     * @param その他機関情報検索条件 その他機関情報検索条件
     * @return 介護認定審査会委員所属機関情報件数
     */
    @Transaction
    public int getKaigoNinteiShinsakaiCount(NinteichosaMasterSearchParameter その他機関情報検索条件) {
        INinteichosaMasterMapper mapper = mapperProvider.create(INinteichosaMasterMapper.class);
        return mapper.selectKaigoNinteiShinsakaiCount(その他機関情報検索条件);
    }
}
