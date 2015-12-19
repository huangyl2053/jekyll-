/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.kijuntsukishichosonjoho;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.kijunt.GappeiShichoson;
import jp.co.ndensan.reams.db.dbz.business.core.kijunt.IKoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbz.business.core.kijunt.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.db.dbz.definition.mybatis.param.KijuntsukiShichosonjoh.KijuntsukiShichosonjohMapperParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.gappei.DbT7055GappeiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.kijuntsu.GappeiShichosonEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.kijuntsu.KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.kijuntsukishichosonjoho.IKijuntsukiShichosonjohoMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.service.core.basic.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.db.dbz.service.core.gappeijoho.gappeijoho.GappeiCityJohoBFinder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 基準月市町村情報の取得します
 */
public class KijuntsukiShichosonjoho {

    private final MapperProvider mapperProvider;
    private static final RString 合併なし = new RString("0");
    private static final RString 合併あり = new RString("1");
    private static final RString 事務構成市町村 = new RString("112");
    private static final RString 事務単一 = new RString("120");
    private static final RString 認定単一 = new RString("220");
    private static final RString 事務広域 = new RString("111");
    private static final RString 認定広域 = new RString("211");
    private static RString 内部開始日フラグ = new RString("1");

    /**
     * コンストラクタです。
     */
    KijuntsukiShichosonjoho(MapperProvider mapperProvider) {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * コンストラクタです。
     */
    KijuntsukiShichosonjoho() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link JushotiTokureiFinder}のインスタンスを返します。
     *
     * @return JushotiTokureiFinder
     */
    public static KijuntsukiShichosonjoho createInstance() {
        return InstanceProvider.create(KijuntsukiShichosonjoho.class);
    }

    /**
     * 基準月市町村情報の取得します
     *
     * @param 基準年月 FlexibleDate
     * @param 導入形態コード RString
     * @return koseiShiList
     */
    @Transaction
    public List<IKoseiShichosonMaster> getKijuntsukiShichosonjohos(FlexibleDate 基準年月, RString 導入形態コード) {
        List<IKoseiShichosonMaster> koseiShiList = new ArrayList<>();
        RString gappeijohokubun = GappeiCityJohoBFinder.createInstance().getGappeijohokubun();
        if (合併なし.equals(gappeijohokubun)) {
            if (事務構成市町村.equals(導入形態コード) || 事務単一.equals(導入形態コード)
                    || 認定単一.equals(導入形態コード)) {
                //TODO 市町村情報取得_単一
            } else if (事務広域.equals(導入形態コード) || 認定広域.equals(導入形態コード)) {
                SearchResult<KoikiZenShichosonJoho> searchResult = KoikiShichosonJohoFinder.createInstance().koseiShichosonJoho();
                // TODO 市町村情報取得_広域
                return null;
            }
        } else if (合併あり.equals(gappeijohokubun)) {
            if (事務構成市町村.equals(導入形態コード) || 事務単一.equals(導入形態コード)
                    || 認定単一.equals(導入形態コード)) {
                KijuntsukiShichosonjohMapperParameter parameter = KijuntsukiShichosonjohMapperParameter.yearMonthcreateKaokuParam(基準年月);
                get新合併市町村の取得(parameter);
                return koseiShiList;
            } else if (事務広域.equals(導入形態コード) || 認定広域.equals(導入形態コード)) {
                KijuntsukiShichosonjohMapperParameter parameter = KijuntsukiShichosonjohMapperParameter.yearMonthcreateKaokuParam(基準年月);
                get広域の旧合併市町村情報(parameter);
                get最新の広域構成市町村(parameter);
            }
        }
        return koseiShiList;
    }

    /**
     * 単一全合併市町村情報の取得します
     *
     * @param 基準年月 KijuntsukiShichosonjohMapperParameter
     * @return koseiShiList
     */
    public List<IKoseiShichosonMaster> get新合併市町村の取得(KijuntsukiShichosonjohMapperParameter 基準年月) {
        requireNonNull(基準年月, UrSystemErrorMessages.値がnull.getReplacedMessage("基準年月"));
        IKijuntsukiShichosonjohoMapper mapper = mapperProvider.create(IKijuntsukiShichosonjohoMapper.class);
        DbT7055GappeiJohoEntity dbt7055Entity = mapper.get新合併市町村の取得(基準年月);
        if (dbt7055Entity != null) {
            List<IKoseiShichosonMaster> koseiShiList = get単一全合併市町村情報(基準年月);
            return koseiShiList;
        }
        //TODO 取得した結果NULL以外場合
        //TODO 市町村情報取得_単一
        return null;
    }

    /**
     * 旧市町村情報の取得します
     *
     * @param 基準年月 KijuntsukiShichosonjohMapperParameter
     * @return koseiShiList
     */
    public List<IKoseiShichosonMaster> get単一全合併市町村情報(KijuntsukiShichosonjohMapperParameter 基準年月) {
        requireNonNull(基準年月, UrSystemErrorMessages.値がnull.getReplacedMessage("基準年月"));
        List<IKoseiShichosonMaster> koseiShiList = new ArrayList<>();
        IKijuntsukiShichosonjohoMapper mapper = mapperProvider.create(IKijuntsukiShichosonjohoMapper.class);
        List<GappeiShichosonEntity> entityList = mapper.get旧市町村情報を取得(基準年月);
        if (entityList != null) {
            for (GappeiShichosonEntity entity : entityList) {
                if (entity.getGappeiYMD().getDayValue() != 1) {
                    if (entity.getKokuhorenDataFromYMD().getYearMonth() == entity.getGappeiYMD().getYearMonth()
                            && entity.getUnyoKaishiYMD().getYearMonth() == 基準年月.get基準年月().getYearMonth()) {
                        continue;
                    } else if (entity.getKokuhorenDataFromYMD().getYearMonth().isBefore(entity.getGappeiYMD().getYearMonth())
                            && entity.getUnyoKaishiYMD().getYearMonth() == 基準年月.get基準年月().getYearMonth()) {
                        koseiShiList.add(new GappeiShichoson(entity));
                        内部開始日フラグ = new RString("2");
                        continue;
                    }
                }
                if (new RString("2") == 内部開始日フラグ && entity.getUnyoShuryoYMD().getDayValue() != 1) {
                    内部開始日フラグ = null;
                    if (entity.getUnyoKaishiYMD().getYearMonth() == 基準年月.get基準年月().getYearMonth()) {
                        continue;
                        // TODO QA-234
                    }
                }
            }
        }
        return koseiShiList;
    }

    /**
     * 広域の旧合併市町村情報の取得します
     *
     * @param 基準年月 KijuntsukiShichosonjohMapperParameter
     * @return koseiShiList
     */
    public List<IKoseiShichosonMaster> get広域の旧合併市町村情報(KijuntsukiShichosonjohMapperParameter 基準年月) {
        requireNonNull(基準年月, UrSystemErrorMessages.値がnull.getReplacedMessage("基準年月"));
        List<IKoseiShichosonMaster> koseiShiList = new ArrayList<>();
        IKijuntsukiShichosonjohoMapper mapper = mapperProvider.create(IKijuntsukiShichosonjohoMapper.class);
        List<KoseiShichosonMasterEntity> koseiList = mapper.get広域の旧合併市町村情報を取得(基準年月);
        if (koseiList == null) {
            for (KoseiShichosonMasterEntity entity : koseiList) {
                if (entity.getGappeiYMD().getDayValue() != 1) {
                    if (entity.getKokuhorenDataFromYMD().getYearMonth() == entity.getGappeiYMD().getYearMonth()
                            && entity.getRidatsuYMD().getYearMonth() == 基準年月.get基準年月().getYearMonth()) {
                        continue;
                    } else if (entity.getKokuhorenDataFromYMD().getYearMonth().isBefore(entity.getGappeiYMD().getYearMonth())
                            && entity.getKanyuYMD().getYearMonth() == 基準年月.get基準年月().getYearMonth()) {
                        continue;
                    }
                }
                koseiShiList.add(new KoseiShichosonMaster(entity));
            }
        }
        return koseiShiList;
    }

    /**
     * 最新の広域構成市町村の取得します
     *
     * @param 基準年月 KijuntsukiShichosonjohMapperParameter
     * @return koseiShiList
     */
    public List<IKoseiShichosonMaster> get最新の広域構成市町村(KijuntsukiShichosonjohMapperParameter 基準年月) {
        requireNonNull(基準年月, UrSystemErrorMessages.値がnull.getReplacedMessage("基準年月"));
        List<IKoseiShichosonMaster> koseiShiList = new ArrayList<>();
        IKijuntsukiShichosonjohoMapper mapper = mapperProvider.create(IKijuntsukiShichosonjohoMapper.class);
        List<KoseiShichosonMasterEntity> koseishiList = mapper.get最新の広域構成市町村の取得(基準年月);
        if (koseishiList == null) {
            for (KoseiShichosonMasterEntity entity : koseishiList) {
                if (entity.getGappeiYMD().getDayValue() != 1) {
                    if (entity.getKokuhorenDataFromYMD().getYearMonth().isBefore(entity.getGappeiYMD().getYearMonth())
                            && entity.getKanyuYMD().getYearMonth() == 基準年月.get基準年月().getYearMonth()) {
                        continue;
                    }
                }
                koseiShiList.add(new KoseiShichosonMaster(entity));
            }
        }
        return koseiShiList;
    }
}
