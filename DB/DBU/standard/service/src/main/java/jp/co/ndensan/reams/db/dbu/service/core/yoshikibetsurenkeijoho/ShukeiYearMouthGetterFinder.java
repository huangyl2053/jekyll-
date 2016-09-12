/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.service.core.yoshikibetsurenkeijoho;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbu.business.core.yoshikibetsurenkeijoho.JigyoHokokuTokei;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.yoshikibetsurenkeijoho.ShukeiYearMouthGetterParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7021JigyoHokokuTokeiDataEntity;
import jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.yoshikibetsurenkeijoho.IShukeiYearMouthGetterMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 集計年月取得するクラスです。
 *
 * @reamsid_L DBU-4050-030 suguangjun
 */
public class ShukeiYearMouthGetterFinder {

    private static final int COUNT_4 = 4;
    private static final int COUNT_6 = 6;
    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    ShukeiYearMouthGetterFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider mapperProvider
     */
    ShukeiYearMouthGetterFinder(
            MapperProvider mapperProvider
    ) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShukeiYearMouthGetterFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ShukeiYearMouthGetterFinder}のインスタンス
     */
    public static ShukeiYearMouthGetterFinder createInstance() {
        return InstanceProvider.create(ShukeiYearMouthGetterFinder.class);
    }

    /**
     * 一般状況１～１０の集計年月の取得処理します。
     *
     * @param parameter 集計年月を特定するためのMyBatis用パラメータ
     * @return SearchResult<JigyoHokokuTokeiData> 集計年月
     */
    @Transaction
    public SearchResult<JigyoHokokuTokei> get集計年月_一般状況1から10(ShukeiYearMouthGetterParameter parameter) {
        requireNonNull(parameter, UrSystemErrorMessages.値がnull.getReplacedMessage(parameter.toString()));
        List<JigyoHokokuTokei> 集計年月リスト = new ArrayList<>();
        ShukeiYearMouthGetterParameter getterParameter = ShukeiYearMouthGetterParameter.createParam_common(parameter.get報告年月(),
                parameter.get報告年月().getYear(), parameter.get報告年月().toDateString().substring(COUNT_4, COUNT_6));
        IShukeiYearMouthGetterMapper getterMapper = mapperProvider.create(IShukeiYearMouthGetterMapper.class);
        DbT7021JigyoHokokuTokeiDataEntity tokeiDataEntity = getterMapper.selectCollectionDate1_10(getterParameter);
        if (tokeiDataEntity != null) {
            集計年月リスト.add(new JigyoHokokuTokei(tokeiDataEntity));
        }
        return SearchResult.of(集計年月リスト, 0, false);
    }

    /**
     * 一般状況１１・１２～１４【現物分】の集計年月の取得処理します。
     *
     * @param parameter 集計年月を特定するためのMyBatis用パラメータ
     * @return SearchResult<JigyoHokokuTokeiData> 集計年月
     */
    @Transaction
    public SearchResult<JigyoHokokuTokei> get集計年月_一般状況11から14現物分(ShukeiYearMouthGetterParameter parameter) {
        requireNonNull(parameter, UrSystemErrorMessages.値がnull.getReplacedMessage(parameter.toString()));
        List<JigyoHokokuTokei> 集計年月リスト = new ArrayList<>();
        ShukeiYearMouthGetterParameter getterParameter = ShukeiYearMouthGetterParameter.createParam_common(parameter.get報告年月(),
                parameter.get報告年月().getYear(), parameter.get報告年月().toDateString().substring(COUNT_4, COUNT_6));
        IShukeiYearMouthGetterMapper getterMapper = mapperProvider.create(IShukeiYearMouthGetterMapper.class);
        DbT7021JigyoHokokuTokeiDataEntity tokeiDataEntity = getterMapper.selectCollectionDate12_14(getterParameter);
        if (tokeiDataEntity != null) {
            集計年月リスト.add(new JigyoHokokuTokei(tokeiDataEntity));
        }
        return SearchResult.of(集計年月リスト, 0, false);
    }

    /**
     * 一般状況１１・１２～１４【償還分】の審査年月の取得処理します。
     *
     * @param parameter 集計年月を特定するためのMyBatis用パラメータ
     * @return SearchResult<JigyoHokokuTokeiData> 集計年月
     */
    @Transaction
    public SearchResult<JigyoHokokuTokei> get審査年月_一般状況11から14償還分(ShukeiYearMouthGetterParameter parameter) {
        requireNonNull(parameter, UrSystemErrorMessages.値がnull.getReplacedMessage(parameter.toString()));
        List<JigyoHokokuTokei> 集計年月リスト = new ArrayList<>();
        ShukeiYearMouthGetterParameter getterParameter = ShukeiYearMouthGetterParameter.createParam_common(parameter.get報告年月(),
                parameter.get報告年月().getYear(), parameter.get報告年月().toDateString().substring(COUNT_4, COUNT_6));
        IShukeiYearMouthGetterMapper getterMapper = mapperProvider.create(IShukeiYearMouthGetterMapper.class);
        DbT7021JigyoHokokuTokeiDataEntity tokeiDataEntity = getterMapper.selectReviewDate12_14(getterParameter);
        if (tokeiDataEntity != null) {
            集計年月リスト.add(new JigyoHokokuTokei(tokeiDataEntity));
        }
        return SearchResult.of(集計年月リスト, 0, false);
    }

    /**
     * 一般状況１１・１２～１４【償還分】の決定年月の取得処理します。
     *
     * @param parameter 集計年月を特定するためのMyBatis用パラメータ
     * @return SearchResult<JigyoHokokuTokeiData> 集計年月
     */
    @Transaction
    public SearchResult<JigyoHokokuTokei> get決定年月_一般状況11から14償還分(ShukeiYearMouthGetterParameter parameter) {
        requireNonNull(parameter, UrSystemErrorMessages.値がnull.getReplacedMessage(parameter.toString()));
        List<JigyoHokokuTokei> 集計年月リスト = new ArrayList<>();
        ShukeiYearMouthGetterParameter getterParameter = ShukeiYearMouthGetterParameter.createParam_common(parameter.get報告年月(),
                parameter.get報告年月().getYear(), parameter.get報告年月().toDateString().substring(COUNT_4, COUNT_6));
        IShukeiYearMouthGetterMapper getterMapper = mapperProvider.create(IShukeiYearMouthGetterMapper.class);
        DbT7021JigyoHokokuTokeiDataEntity tokeiDataEntity = getterMapper.selectDecisionDate12_14(getterParameter);
        if (tokeiDataEntity != null) {
            集計年月リスト.add(new JigyoHokokuTokei(tokeiDataEntity));
        }
        return SearchResult.of(集計年月リスト, 0, false);
    }

    /**
     * 保険給付決定状況【現物分】の集計年月の取得処理します。
     *
     * @param parameter 集計年月を特定するためのMyBatis用パラメータ
     * @return SearchResult<JigyoHokokuTokeiData> 集計年月
     */
    @Transaction
    public SearchResult<JigyoHokokuTokei> get集計年月_決定状況現物分(ShukeiYearMouthGetterParameter parameter) {
        requireNonNull(parameter, UrSystemErrorMessages.値がnull.getReplacedMessage(parameter.toString()));
        List<JigyoHokokuTokei> 集計年月リスト = new ArrayList<>();
        ShukeiYearMouthGetterParameter getterParameter = ShukeiYearMouthGetterParameter.createParam_common(parameter.get報告年月(),
                parameter.get報告年月().getYear(), parameter.get報告年月().toDateString().substring(COUNT_4, COUNT_6));
        IShukeiYearMouthGetterMapper getterMapper = mapperProvider.create(IShukeiYearMouthGetterMapper.class);
        DbT7021JigyoHokokuTokeiDataEntity tokeiDataEntity = getterMapper.selectCollectionDate(getterParameter);
        if (tokeiDataEntity != null) {
            集計年月リスト.add(new JigyoHokokuTokei(tokeiDataEntity));
        }
        return SearchResult.of(集計年月リスト, 0, false);
    }

    /**
     * 保険給付決定状況【償還分】の審査年月の取得処理します。
     *
     * @param parameter 集計年月を特定するためのMyBatis用パラメータ
     * @return SearchResult<JigyoHokokuTokeiData> 集計年月
     */
    @Transaction
    public SearchResult<JigyoHokokuTokei> get審査年月_決定状況償還分(ShukeiYearMouthGetterParameter parameter) {
        requireNonNull(parameter, UrSystemErrorMessages.値がnull.getReplacedMessage(parameter.toString()));
        List<JigyoHokokuTokei> 集計年月リスト = new ArrayList<>();
        ShukeiYearMouthGetterParameter getterParameter = ShukeiYearMouthGetterParameter.createParam_common(parameter.get報告年月(),
                parameter.get報告年月().getYear(), parameter.get報告年月().toDateString().substring(COUNT_4, COUNT_6));
        IShukeiYearMouthGetterMapper getterMapper = mapperProvider.create(IShukeiYearMouthGetterMapper.class);
        DbT7021JigyoHokokuTokeiDataEntity tokeiDataEntity = getterMapper.selectReviewDate(getterParameter);
        if (tokeiDataEntity != null) {
            集計年月リスト.add(new JigyoHokokuTokei(tokeiDataEntity));
        }
        return SearchResult.of(集計年月リスト, 0, false);
    }

    /**
     * 保険給付決定状況【償還分】の決定年月の取得処理します。
     *
     * @param parameter 集計年月を特定するためのMyBatis用パラメータ
     * @return SearchResult<JigyoHokokuTokeiData> 集計年月
     */
    @Transaction
    public SearchResult<JigyoHokokuTokei> get決定年月_決定状況償還分(ShukeiYearMouthGetterParameter parameter) {
        requireNonNull(parameter, UrSystemErrorMessages.値がnull.getReplacedMessage(parameter.toString()));
        List<JigyoHokokuTokei> 集計年月リスト = new ArrayList<>();
        ShukeiYearMouthGetterParameter getterParameter = ShukeiYearMouthGetterParameter.createParam_common(parameter.get報告年月(),
                parameter.get報告年月().getYear(), parameter.get報告年月().toDateString().substring(COUNT_4, COUNT_6));
        IShukeiYearMouthGetterMapper getterMapper = mapperProvider.create(IShukeiYearMouthGetterMapper.class);
        DbT7021JigyoHokokuTokeiDataEntity tokeiDataEntity = getterMapper.selectDecisionDate(getterParameter);
        if (tokeiDataEntity != null) {
            集計年月リスト.add(new JigyoHokokuTokei(tokeiDataEntity));
        }
        return SearchResult.of(集計年月リスト, 0, false);
    }

    /**
     * 過去報告年月の取得処理します。
     *
     * @return SearchResult<JigyoHokokuTokeiData> 集計年月
     */
    @Transaction
    public SearchResult<JigyoHokokuTokei> get過去報告年月() {
        List<JigyoHokokuTokei> 集計年月リスト = new ArrayList<>();
        IShukeiYearMouthGetterMapper getterMapper = mapperProvider.create(IShukeiYearMouthGetterMapper.class);
        List<DbT7021JigyoHokokuTokeiDataEntity> tokeiDataEntityList = getterMapper.selectKakoHokokuYM();
        for (DbT7021JigyoHokokuTokeiDataEntity tokeiDataEntity : tokeiDataEntityList) {
            集計年月リスト.add(new JigyoHokokuTokei(tokeiDataEntity));
        }
        return SearchResult.of(集計年月リスト, 0, false);
    }
}
