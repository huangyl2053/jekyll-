/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.ninteishinseijoho.chikuninteichosainmapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.chikuninteichosain.ChikuNinteiChosain;
import jp.co.ndensan.reams.db.dbe.business.core.chikuninteichosain.ChikuNinteiKoseiShichoson;
import jp.co.ndensan.reams.db.dbe.business.core.chikuninteichosain.ChikuNinteiNinteichosa;
import jp.co.ndensan.reams.db.dbe.business.core.chikuninteichosain.NinteichosaSchedule;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.chikuninteichosain.ChosainJohoParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.chikuninteichosain.ChikuNinteiKoseiShichosonRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.chikuninteichosain.ChikuNinteiNinteichosaRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.chikuninteichosain.ChosainJohoRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.core.basic.MapperProvider;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.chikuninteichosain.ChosainJohoMapper;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5221NinteichosaScheduleEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定調査スケジュール登録2を管理するクラスです。
 */
public class ChosainJohoFander {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public ChosainJohoFander() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @paramMapperProvider mapperProvider
     */
    ChosainJohoFander(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link HokenshaNyuryokuHojoFinder}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link HokenshaNyuryokuHojoFinder}のインスタンス
     */
    public static ChosainJohoFander createInstance() {
        return InstanceProvider.create(ChosainJohoFander.class);
    }

    /**
     * 通常メモ情報件数を返します。
     *
     * @param parameter 認定調査スケジュール登録2用パラメータ
     * @return int 通常メモ情報件数
     */
    @Transaction
    public int get通常メモ情報件数(ChosainJohoParameter parameter) {
        return 0;
    }

    /**
     * 重要メモ情報件数を返します。
     *
     * @param parameter 認定調査スケジュール登録2用パラメータ
     * @return int 重要メモ情報件数
     */
    @Transaction
    public int get重要メモ情報件数(ChosainJohoParameter parameter) {
        return 0;
    }

    /**
     * 認定調査スケジュール詳細情報を返します。
     *
     * @param 認定調査スケジュール詳細情報検索条件 認定調査スケジュール登録2用パラメータ
     * @return SearchResult<ChikuNinteiChosain> 認定調査スケジュール詳細情報検索結果
     */
    @Transaction
    public SearchResult<ChikuNinteiChosain> get認定調査スケジュール詳細情報1(ChosainJohoParameter 認定調査スケジュール詳細情報検索条件) {
        requireNonNull(認定調査スケジュール詳細情報検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査スケジュール詳細情報検索条件"));
        List<ChikuNinteiChosain> ChikuNinteiChosainList = new ArrayList<>();
        ChosainJohoMapper chosainjohomapper = mapperProvider.create(ChosainJohoMapper.class);
        List<ChosainJohoRelateEntity> entitylist = chosainjohomapper.getChikuNinteiChosainRelateEntity1(認定調査スケジュール詳細情報検索条件);
        if (entitylist == null || entitylist.isEmpty()) {
            return SearchResult.of(Collections.<ChikuNinteiChosain>emptyList(), 0, false);
        }
        for (ChosainJohoRelateEntity entity : entitylist) {
            ChikuNinteiChosainList.add(new ChikuNinteiChosain(entity));
        }
        return SearchResult.of(ChikuNinteiChosainList, 0, false);
    }

    /**
     * 認定調査スケジュール詳細情報を返します。
     *
     * @param 認定調査スケジュール詳細情報検索条件 認定調査スケジュール登録2用パラメータ
     * @return SearchResult<ChikuNinteiChosain> 認定調査スケジュール詳細情報検索結果
     */
    @Transaction
    public SearchResult<ChikuNinteiChosain> get認定調査スケジュール詳細情報2(ChosainJohoParameter 認定調査スケジュール詳細情報検索条件) {
        requireNonNull(認定調査スケジュール詳細情報検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査スケジュール詳細情報検索条件"));
        List<ChikuNinteiChosain> ChikuNinteiChosainList = new ArrayList<>();
        ChosainJohoMapper chosainjohomapper = mapperProvider.create(ChosainJohoMapper.class);
        List<ChosainJohoRelateEntity> entitylist = chosainjohomapper.getChikuNinteiChosainRelateEntity2(認定調査スケジュール詳細情報検索条件);
        if (entitylist == null || entitylist.isEmpty()) {
            return SearchResult.of(Collections.<ChikuNinteiChosain>emptyList(), 0, false);
        }
        for (ChosainJohoRelateEntity entity : entitylist) {
            ChikuNinteiChosainList.add(new ChikuNinteiChosain(entity));
        }
        return SearchResult.of(ChikuNinteiChosainList, 0, false);
    }

    /**
     * 保険者名称を返します。
     *
     * @param 保険者名称検索条件 認定調査スケジュール登録2用パラメータ
     * @return SearchResult<ChikuNinteiKoseiShichoson> 保険者検索結果
     */
    @Transaction
    public SearchResult<ChikuNinteiKoseiShichoson> get保険者(ChosainJohoParameter 保険者名称検索条件) {
        requireNonNull(保険者名称検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("保険者名称検索条件"));
        List<ChikuNinteiKoseiShichoson> ChikuNinteiKoseiShichosonList = new ArrayList<>();
        ChosainJohoMapper chosainjohomapper = mapperProvider.create(ChosainJohoMapper.class);
        List<ChikuNinteiKoseiShichosonRelateEntity> entitylist = chosainjohomapper.getChikuNinteiKoseiShichosonRelateRelateEntity(保険者名称検索条件);
        if (entitylist == null || entitylist.isEmpty()) {
            return SearchResult.of(Collections.<ChikuNinteiKoseiShichoson>emptyList(), 0, false);
        }
        for (ChikuNinteiKoseiShichosonRelateEntity entity : entitylist) {
            ChikuNinteiKoseiShichosonList.add(new ChikuNinteiKoseiShichoson(entity));
        }
        return SearchResult.of(ChikuNinteiKoseiShichosonList, 0, false);
    }

    /**
     * 認定調査委託先名称を返します。
     *
     * @param 認定調査委託先名称検索条件 認定調査スケジュール登録2用パラメータ
     * @return SearchResult<ChikuNinteiNinteichosa> 認定調査委託先名称検索結果
     */
    @Transaction
    public SearchResult<ChikuNinteiNinteichosa> get認定調査委託先名称(ChosainJohoParameter 認定調査委託先名称検索条件) {
        requireNonNull(認定調査委託先名称検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査委託先名称検索条件"));
        List<ChikuNinteiNinteichosa> ChikuNinteiNinteichosaList = new ArrayList<>();
        ChosainJohoMapper chosainjohomapper = mapperProvider.create(ChosainJohoMapper.class);
        List<ChikuNinteiNinteichosaRelateEntity> entitylist = chosainjohomapper.getChikuNinteiNinteichosaRelateEntity(認定調査委託先名称検索条件);
        if (entitylist == null || entitylist.isEmpty()) {
            return SearchResult.of(Collections.<ChikuNinteiNinteichosa>emptyList(), 0, false);
        }
        for (ChikuNinteiNinteichosaRelateEntity entity : entitylist) {
            ChikuNinteiNinteichosaList.add(new ChikuNinteiNinteichosa(entity));
        }
        return SearchResult.of(ChikuNinteiNinteichosaList, 0, false);
    }

    /**
     * 申請書管理番号を返します。
     *
     * @param 申請書管理番号検索条件 認定調査スケジュール登録2用パラメータ
     * @return NinteichosaSchedule 申請書管理番号
     */
    @Transaction
    public NinteichosaSchedule get申請書管理番号(ChosainJohoParameter 申請書管理番号検索条件) {
        requireNonNull(申請書管理番号検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号検索条件"));
        ChosainJohoMapper chosainjohomapper = mapperProvider.create(ChosainJohoMapper.class);
        DbT5221NinteichosaScheduleEntity entity = chosainjohomapper.getNinteichosaScheduleEntity(申請書管理番号検索条件);
        if (entity == null) {
            return null;
        }
        return new NinteichosaSchedule(entity);
    }

}
