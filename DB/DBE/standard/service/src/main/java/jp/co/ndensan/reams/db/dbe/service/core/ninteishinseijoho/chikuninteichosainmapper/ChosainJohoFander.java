/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.ninteishinseijoho.chikuninteichosainmapper;

import java.util.ArrayList;
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
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

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
     * 認定調査スケジュール詳細情報を返します。
     *
     * @param 認定調査スケジュール詳細情報検索条件 認定調査スケジュール詳細情報検索条件
     * @return List<ChikuNinteiChosain>
     */
    public List<ChikuNinteiChosain> get認定調査スケジュール詳細情報1(ChosainJohoParameter 認定調査スケジュール詳細情報検索条件) {
        requireNonNull(認定調査スケジュール詳細情報検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査スケジュール詳細情報検索条件"));
        List<ChikuNinteiChosain> ChikuNinteiChosainList = new ArrayList<>();
        ChosainJohoMapper chosainjohomapper = mapperProvider.create(ChosainJohoMapper.class);
        List<ChosainJohoRelateEntity> entitylist = chosainjohomapper.getChikuNinteiChosainRelateEntity1(認定調査スケジュール詳細情報検索条件);
        if (entitylist == null || entitylist.isEmpty()) {
            return ChikuNinteiChosainList;
        }
        for (ChosainJohoRelateEntity entity : entitylist) {
            ChikuNinteiChosainList.add(new ChikuNinteiChosain(entity));
        }
        return ChikuNinteiChosainList;
    }

    /**
     * 認定調査スケジュール詳細情報を返します。
     *
     * @param 認定調査スケジュール詳細情報検索条件 認定調査スケジュール詳細情報検索条件
     * @return List<ChikuNinteiChosain>
     */
    public List<ChikuNinteiChosain> get認定調査スケジュール詳細情報2(ChosainJohoParameter 認定調査スケジュール詳細情報検索条件) {
        requireNonNull(認定調査スケジュール詳細情報検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査スケジュール詳細情報検索条件"));
        List<ChikuNinteiChosain> ChikuNinteiChosainList = new ArrayList<>();
        ChosainJohoMapper chosainjohomapper = mapperProvider.create(ChosainJohoMapper.class);
        List<ChosainJohoRelateEntity> entitylist = chosainjohomapper.getChikuNinteiChosainRelateEntity2(認定調査スケジュール詳細情報検索条件);
        if (entitylist == null || entitylist.isEmpty()) {
            return ChikuNinteiChosainList;
        }
        for (ChosainJohoRelateEntity entity : entitylist) {
            ChikuNinteiChosainList.add(new ChikuNinteiChosain(entity));
        }
        return ChikuNinteiChosainList;
    }

    /**
     * 保険者名称を返します。
     *
     * @param 保険者名称検索条件 保険者名称検索条件
     * @return List<ChikuNinteiKoseiShichoson>
     */
    public List<ChikuNinteiKoseiShichoson> get対象地区(ChosainJohoParameter 保険者名称検索条件) {
        requireNonNull(保険者名称検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("保険者名称検索条件"));
        List<ChikuNinteiKoseiShichoson> ChikuNinteiKoseiShichosonList = new ArrayList<>();
        ChosainJohoMapper chosainjohomapper = mapperProvider.create(ChosainJohoMapper.class);
        List<ChikuNinteiKoseiShichosonRelateEntity> entitylist = chosainjohomapper.getChikuNinteiKoseiShichosonRelateRelateEntity(保険者名称検索条件);
        if (entitylist == null || entitylist.isEmpty()) {
            return ChikuNinteiKoseiShichosonList;
        }
        for (ChikuNinteiKoseiShichosonRelateEntity entity : entitylist) {
            ChikuNinteiKoseiShichosonList.add(new ChikuNinteiKoseiShichoson(entity));
        }
        return ChikuNinteiKoseiShichosonList;
    }

    /**
     * 認定調査委託先名称を返します。
     *
     * @param 認定調査委託先名称検索条件 認定調査委託先名称検索条件
     * @return List<ChikuNinteiNinteichosa>
     */
    public List<ChikuNinteiNinteichosa> get保険者(ChosainJohoParameter 認定調査委託先名称検索条件) {
        requireNonNull(認定調査委託先名称検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査委託先名称検索条件"));
        List<ChikuNinteiNinteichosa> ChikuNinteiNinteichosaList = new ArrayList<>();
        ChosainJohoMapper chosainjohomapper = mapperProvider.create(ChosainJohoMapper.class);
        List<ChikuNinteiNinteichosaRelateEntity> entitylist = chosainjohomapper.getChikuNinteiNinteichosaRelateEntity(認定調査委託先名称検索条件);
        if (entitylist == null || entitylist.isEmpty()) {
            return ChikuNinteiNinteichosaList;
        }
        for (ChikuNinteiNinteichosaRelateEntity entity : entitylist) {
            ChikuNinteiNinteichosaList.add(new ChikuNinteiNinteichosa(entity));
        }
        return ChikuNinteiNinteichosaList;
    }

    /**
     * 申請書管理番号を返します。
     *
     * @param 申請書管理番号検索条件 申請書管理番号検索条件
     * @return NinteichosaSchedule
     */
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
