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
import jp.co.ndensan.reams.db.dbz.definition.mybatis.param.shichosonjoh.KijuntsukiShichosonjohMapperParameter;
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
public class KijuntsukiShichosonjohoFinder {

    private final MapperProvider mapperProvider;
    private static final RString 合併なし = new RString("0");
    private static final RString 合併あり = new RString("1");
    private static final RString 事務構成市町村 = new RString("112");
    private static final RString 事務単一 = new RString("120");
    private static final RString 認定単一 = new RString("220");
    private static final RString 事務広域 = new RString("111");
    private static final RString 認定広域 = new RString("211");
    private static RString 内部開始日フラグ = RString.EMPTY;

    /**
     * コンストラクタです。
     */
    KijuntsukiShichosonjohoFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * コンストラクタです。
     */
    public KijuntsukiShichosonjohoFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link JushotiTokureiFinder}のインスタンスを返します。
     *
     * @return JushotiTokureiFinder
     */
    public static KijuntsukiShichosonjohoFinder createInstance() {
        return InstanceProvider.create(KijuntsukiShichosonjohoFinder.class);
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
            }
        } else if (合併あり.equals(gappeijohokubun)) {
            if (事務構成市町村.equals(導入形態コード) || 事務単一.equals(導入形態コード)
                    || 認定単一.equals(導入形態コード)) {
                KijuntsukiShichosonjohMapperParameter parameter = KijuntsukiShichosonjohMapperParameter.yearMonthcreateKaokuParam(基準年月);
                List<IKoseiShichosonMaster> 新合併市町村 = get新合併市町村の取得(parameter);
                koseiShiList.addAll(新合併市町村);
            } else if (事務広域.equals(導入形態コード) || 認定広域.equals(導入形態コード)) {
                KijuntsukiShichosonjohMapperParameter parameter = KijuntsukiShichosonjohMapperParameter.yearMonthcreateKaokuParam(基準年月);
                List<IKoseiShichosonMaster> 広域の旧合併市町村情報 = get広域の旧合併市町村情報(parameter);
                List<IKoseiShichosonMaster> 最新の広域構成市町村 = get最新の広域構成市町村(parameter);
                koseiShiList.addAll(広域の旧合併市町村情報);
                koseiShiList.addAll(最新の広域構成市町村);
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
    private List<IKoseiShichosonMaster> get新合併市町村の取得(KijuntsukiShichosonjohMapperParameter 基準年月) {
        requireNonNull(基準年月, UrSystemErrorMessages.値がnull.getReplacedMessage("基準年月"));
        List<IKoseiShichosonMaster> koseiShiList = new ArrayList<>();
        IKijuntsukiShichosonjohoMapper mapper = mapperProvider.create(IKijuntsukiShichosonjohoMapper.class);
        List<DbT7055GappeiJohoEntity> dbt7055Entity = mapper.get新合併市町村の取得(基準年月);
        if (dbt7055Entity != null) {
            List<IKoseiShichosonMaster> 単一全合併市町村情報 = get単一全合併市町村情報(基準年月);
            koseiShiList.addAll(単一全合併市町村情報);
        }
        //TODO 取得した結果NULL以外場合
        //TODO 市町村情報取得_単一
        return koseiShiList;
    }

    /**
     * 旧市町村情報の取得します
     *
     * @param 基準年月 KijuntsukiShichosonjohMapperParameter
     * @return koseiShiList
     */
    private List<IKoseiShichosonMaster> get単一全合併市町村情報(KijuntsukiShichosonjohMapperParameter 基準年月) {
        requireNonNull(基準年月, UrSystemErrorMessages.値がnull.getReplacedMessage("基準年月"));
        List<IKoseiShichosonMaster> koseiShiList = new ArrayList<>();
        IKijuntsukiShichosonjohoMapper mapper = mapperProvider.create(IKijuntsukiShichosonjohoMapper.class);
        List<GappeiShichosonEntity> entityList = mapper.get旧市町村情報を取得(基準年月);
        if (!entityList.isEmpty()) {
            for (GappeiShichosonEntity entity : entityList) {
                if (1 != entity.getGappeiYMD().getDayValue()) {
                    if (entity.getKokuhorenDataFromYMD().getYearMonth().equals(entity.getGappeiYMD().getYearMonth())
                            && entity.getUnyoShuryoYMD().getYearMonth().equals(基準年月.get基準年月().getYearMonth())) {
                        continue;
                    } else if (entity.getGappeiYMD().getYearMonth().isBefore(entity.getKokuhorenDataFromYMD().getYearMonth())
                            && entity.getUnyoShuryoYMD().getYearMonth().equals(基準年月.get基準年月().getYearMonth())) {
                        koseiShiList.add(new GappeiShichoson(entity));
                        内部開始日フラグ = new RString("2");
                        continue;
                    }
                }
                if (new RString("2") == 内部開始日フラグ && 1 != entity.getUnyoKaishiYMD().getDayValue()) {
                    内部開始日フラグ = RString.EMPTY;
                    if (entity.getUnyoKaishiYMD().getYearMonth().equals(基準年月.get基準年月().getYearMonth())) {
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
    private List<IKoseiShichosonMaster> get広域の旧合併市町村情報(KijuntsukiShichosonjohMapperParameter 基準年月) {
        requireNonNull(基準年月, UrSystemErrorMessages.値がnull.getReplacedMessage("基準年月"));
        List<IKoseiShichosonMaster> koseiShiList = new ArrayList<>();
        IKijuntsukiShichosonjohoMapper mapper = mapperProvider.create(IKijuntsukiShichosonjohoMapper.class);
        List<KoseiShichosonMasterEntity> koseiList = mapper.get広域の旧合併市町村情報を取得(基準年月);
        if (!koseiList.isEmpty()) {
            for (KoseiShichosonMasterEntity entity : koseiList) {
                if (1 != entity.getGappeiYMD().getDayValue()) {
                    if (entity.getKokuhorenDataFromYMD().getYearMonth().equals(entity.getGappeiYMD().getYearMonth())
                            && entity.getRidatsuYMD().getYearMonth().equals(基準年月.get基準年月().getYearMonth())) {
                        continue;
                    } else if (entity.getGappeiYMD().getYearMonth().isBefore(entity.getKokuhorenDataFromYMD().getYearMonth())
                            && entity.getKanyuYMD().getYearMonth().equals(基準年月.get基準年月().getYearMonth())) {
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
    private List<IKoseiShichosonMaster> get最新の広域構成市町村(KijuntsukiShichosonjohMapperParameter 基準年月) {
        requireNonNull(基準年月, UrSystemErrorMessages.値がnull.getReplacedMessage("基準年月"));
        List<IKoseiShichosonMaster> koseiShiList = new ArrayList<>();
        IKijuntsukiShichosonjohoMapper mapper = mapperProvider.create(IKijuntsukiShichosonjohoMapper.class);
        List<KoseiShichosonMasterEntity> koseishiList = mapper.get最新の広域構成市町村の取得(基準年月);
        if (!koseishiList.isEmpty()) {
            for (KoseiShichosonMasterEntity entity : koseishiList) {
                if (1 != entity.getGappeiYMD().getDayValue()) {
                    if (entity.getGappeiYMD().getYearMonth().isBefore(entity.getKokuhorenDataFromYMD().getYearMonth())
                            && entity.getKanyuYMD().getYearMonth().equals(基準年月.get基準年月().getYearMonth())) {
                        continue;
                    }
                }
                koseiShiList.add(new KoseiShichosonMaster(entity));
            }
        }
        return koseiShiList;
    }
}
