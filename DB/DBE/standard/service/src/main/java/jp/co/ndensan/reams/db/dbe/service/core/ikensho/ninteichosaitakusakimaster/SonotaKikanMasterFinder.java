/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.ikensho.ninteichosaitakusakimaster;

import java.util.Collections;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosaitakusakimaster.SonotaKikanMasterMapperParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosaitakusakimaster.SonotaKikanMasterSearchParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.sonotakikanmaster.SonotaKikanJohoEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteichosaimaster.ISonotaKikanMasterMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * その他機関情報クラスです。
 *
 * @reamsid_L DBE-1360-010 suguangjun
 */
public class SonotaKikanMasterFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    SonotaKikanMasterFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param MapperProvider {@link mapperProvider}
     */
    SonotaKikanMasterFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link SonotaKikanMasterFinder}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link SonotaKikanMasterFinder}のインスタンス
     */
    public static SonotaKikanMasterFinder createInstance() {
        return InstanceProvider.create(SonotaKikanMasterFinder.class);
    }

    /**
     * 検索条件に従い、その他機関情報を検索します。
     *
     * @param その他機関情報検索条件 その他機関情報検索条件
     * @return ShujiiMaster その他機関情報 nullが返る可能性があります。
     */
    @Transaction
    public SearchResult<SonotaKikanJohoEntity> getSonotaKikanichiranList(SonotaKikanMasterMapperParameter その他機関情報検索条件) {
        requireNonNull(その他機関情報検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("その他機関情報検索条件"));
        ISonotaKikanMasterMapper mapper = mapperProvider.create(ISonotaKikanMasterMapper.class);
        List<SonotaKikanJohoEntity> kikanJohoEntityList = mapper.selectSonotaKikanichiranList(その他機関情報検索条件);
        if (kikanJohoEntityList.isEmpty()) {
            return SearchResult.of(Collections.<SonotaKikanJohoEntity>emptyList(), 0, false);
        }
        for (SonotaKikanJohoEntity entity : kikanJohoEntityList) {
            entity.initializeMd5();
        }
        return SearchResult.of(kikanJohoEntityList, 0, false);
    }

    /**
     * 検索条件に従い、その他機関情報の件数を検索します。
     *
     * @param その他機関情報検索条件 その他機関情報検索条件
     * @return その他機関情報の件数
     */
    @Transaction
    public int getSonotaKikanJohoCount(SonotaKikanMasterSearchParameter その他機関情報検索条件) {
        ISonotaKikanMasterMapper mapper = mapperProvider.create(ISonotaKikanMasterMapper.class);
        return mapper.selectSonotaKikanJohoCount(その他機関情報検索条件);
    }

    /**
     * 検索条件に従い、介護認定審査会委員所属機関情報件数検索処理。
     *
     * @param その他機関情報検索条件 その他機関情報検索条件
     * @return 介護認定審査会委員所属機関情報件数
     */
    @Transaction
    public int getKaigoNinteiShinsakaiCount(SonotaKikanMasterSearchParameter その他機関情報検索条件) {
        ISonotaKikanMasterMapper mapper = mapperProvider.create(ISonotaKikanMasterMapper.class);
        return mapper.selectKaigoNinteiShinsakaiCount(その他機関情報検索条件);
    }
}
