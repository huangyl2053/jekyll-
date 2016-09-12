/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.ninteishinseitodokedesha;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7060KaigoJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7060KaigoJigyoshaDac;
import jp.co.ndensan.reams.db.dbz.business.core.dbt4101ninteishinseijoho.DbT4101NinteiShinseiJohoBusiness;
import jp.co.ndensan.reams.db.dbz.business.core.dbt4120shinseitodokedejoho.DbT4120ShinseitodokedeJohoBusiness;
import jp.co.ndensan.reams.db.dbz.business.core.dbt4121shinseirirekijoho.DbT4121ShinseiRirekiJohoBusiness;
import jp.co.ndensan.reams.db.dbz.business.core.ninteishinseitodokedesha.NinteiShinseiTodokedeshaBusiness;
import jp.co.ndensan.reams.db.dbz.business.core.shisetujyoho.KaigoJigyoshaInputGuide;
import jp.co.ndensan.reams.db.dbz.definition.core.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.ninteishinseitodokedesha.NinteiShinseiTodokedeshaMybatisParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4120ShinseitodokedeJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4121ShinseiRirekiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.ninteishinseitodokedesha.NinteiShinseiTodokedeshaEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4101NinteiShinseiJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4120HokenshaShinseitodokedeJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4121ShinseiRirekiJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.ninteishinseitodokedesha.INinteiShinseiTodokedeshaMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護認定申請届出者のfinderクラスです。
 *
 * @reamsid_L DBZ-1300-110 yaodongsheng
 */
public class NinteiShinseiTodokedeshaFinder {

    private final DbT4121ShinseiRirekiJohoDac dbT4121dac;
    private final DbT4101NinteiShinseiJohoDac dbT4101dac;
    private final DbT4120HokenshaShinseitodokedeJohoDac dbT4120dac;
    private final DbT7060KaigoJigyoshaDac dbT7060dac;
    private final MapperProvider mapperProvider;

    /**
     * コンストラクタ
     */
    NinteiShinseiTodokedeshaFinder() {
        this.dbT4121dac = InstanceProvider.create(DbT4121ShinseiRirekiJohoDac.class);
        this.dbT4101dac = InstanceProvider.create(DbT4101NinteiShinseiJohoDac.class);
        this.dbT4120dac = InstanceProvider.create(DbT4120HokenshaShinseitodokedeJohoDac.class);
        this.dbT7060dac = InstanceProvider.create(DbT7060KaigoJigyoshaDac.class);
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param dbT4121dac dbT4121dac
     * @param dbT4101dac dbT4101dac
     * @param dbT4120dac dbT4120dac
     * @param mapperProvider mapperProvider
     */
    NinteiShinseiTodokedeshaFinder(
            DbT4121ShinseiRirekiJohoDac dbT4121dac,
            DbT4101NinteiShinseiJohoDac dbT4101dac,
            DbT4120HokenshaShinseitodokedeJohoDac dbT4120dac,
            MapperProvider mapperProvider,
            DbT7060KaigoJigyoshaDac dbT7060dac) {
        this.dbT4121dac = dbT4121dac;
        this.dbT4101dac = dbT4101dac;
        this.dbT4120dac = dbT4120dac;
        this.mapperProvider = mapperProvider;
        this.dbT7060dac = dbT7060dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link NinteiShinseiTodokedeshaFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link NinteiShinseiTodokedeshaFinder}のインスタンス
     */
    public static NinteiShinseiTodokedeshaFinder createInstance() {
        return InstanceProvider.create(NinteiShinseiTodokedeshaFinder.class);
    }

    /**
     * 要介護認定申請情報(受給)データを返します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return DbT4101NinteiShinseiJohoBusiness
     */
    @Transaction
    public DbT4121ShinseiRirekiJohoBusiness get申請履歴情報(ShinseishoKanriNo 申請書管理番号) {
        Optional<DbT4121ShinseiRirekiJohoEntity> entity = dbT4121dac.selectByKey(申請書管理番号);
        if (entity.isPresent()) {
            return new DbT4121ShinseiRirekiJohoBusiness(entity.get());
        }
        return null;
    }

    /**
     * 要介護認定申請情報(受給)データを返します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return DbT4101NinteiShinseiJohoBusiness
     */
    @Transaction
    public DbT4101NinteiShinseiJohoBusiness get要介護認定申請情報受給(ShinseishoKanriNo 申請書管理番号) {
        Optional<DbT4101NinteiShinseiJohoEntity> ninteiShinseiJoho = dbT4101dac.selectByKey(申請書管理番号);
        if (ninteiShinseiJoho.isPresent()) {
            return new DbT4101NinteiShinseiJohoBusiness(ninteiShinseiJoho.get());
        }
        return null;
    }

    /**
     * 申請届出情報データを返します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return DbT4101NinteiShinseiJohoBusiness
     */
    @Transaction
    public DbT4120ShinseitodokedeJohoBusiness get申請届出情報(ShinseishoKanriNo 申請書管理番号) {
        Optional<DbT4120ShinseitodokedeJohoEntity> shinseitodokedeJoho = dbT4120dac.selectByKey(申請書管理番号);
        if (shinseitodokedeJoho.isPresent()) {
            return new DbT4120ShinseitodokedeJohoBusiness(shinseitodokedeJoho.get());
        }
        return null;
    }

    /**
     * 宛名データを返します。
     *
     * @param parameter NinteiShinseiTodokedeshaMybatisParameter
     * @return NinteiShinseiTodokedeshaBusiness
     */
    @Transaction
    public NinteiShinseiTodokedeshaBusiness select宛名データOnly_宛名条件And業務条件(NinteiShinseiTodokedeshaMybatisParameter parameter) {
        List<NinteiShinseiTodokedeshaEntity> entityList
                = mapperProvider.create(INinteiShinseiTodokedeshaMapper.class).select宛名データOnly_宛名条件And業務条件(parameter);
        if (!entityList.isEmpty() && entityList.get(0) != null) {
            return new NinteiShinseiTodokedeshaBusiness(entityList.get(0));
        }
        return null;
    }

    /**
     * 介護事業者情報を取得します。
     *
     * @param 事業者番号 KaigoJigyoshaNo
     * @param システム日付 FlexibleDate
     * @return List<KaigoJigyoshaInputGuide> 介護事業者取得リスト
     */
    @Transaction
    public SearchResult<KaigoJigyoshaInputGuide> getKaigoJigyoshaInputGuide(JigyoshaNo 事業者番号, FlexibleDate システム日付) {
        List<KaigoJigyoshaInputGuide> kaigoJigyoshaList = new ArrayList<>();
        List<DbT7060KaigoJigyoshaEntity> dbT7060List = dbT7060dac.select介護事業者(事業者番号, システム日付);
        if (dbT7060List == null || dbT7060List.isEmpty()) {
            return SearchResult.of(Collections.<KaigoJigyoshaInputGuide>emptyList(), 0, false);
        }
        for (DbT7060KaigoJigyoshaEntity entity : dbT7060List) {
            kaigoJigyoshaList.add(new KaigoJigyoshaInputGuide(entity));
        }
        return SearchResult.of(kaigoJigyoshaList, 0, false);
    }
}
