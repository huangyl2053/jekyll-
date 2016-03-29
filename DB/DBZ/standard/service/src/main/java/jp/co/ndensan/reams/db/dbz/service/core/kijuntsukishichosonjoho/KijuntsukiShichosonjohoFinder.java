package jp.co.ndensan.reams.db.dbz.service.core.kijuntsukishichosonjoho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7055GappeiJohoEntity;
import jp.co.ndensan.reams.db.dbz.business.core.kijunt.GappeiShichoson;
import jp.co.ndensan.reams.db.dbz.business.core.kijunt.IKoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbz.business.core.kijunt.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.GappeiShichosonEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.kijuntsukishichosonjoho.IKijuntsukiShichosonjohoMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.service.core.basic.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.db.dbz.service.core.gappeijoho.gappeijoho.GappeiCityJohoBFinder;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 基準月市町村情報の取得します
 */
public class KijuntsukiShichosonjohoFinder {

    private static final RString 合併なし = new RString("0");
    private static final RString 合併あり = new RString("1");
    private static final RString 事務構成市町村 = new RString("112");
    private static final RString 事務単一 = new RString("120");
    private static final RString 認定単一 = new RString("220");
    private static final RString 事務広域 = new RString("111");
    private static final RString 認定広域 = new RString("211");
    private final MapperProvider mapperProvider;
    private final KoikiShichosonJohoFinder shichosonJohoFinder;

    /**
     * コンストラクタです。
     */
    KijuntsukiShichosonjohoFinder(MapperProvider mapperProvider, KoikiShichosonJohoFinder shichosonJohoFinder) {
        this.mapperProvider = mapperProvider;
        this.shichosonJohoFinder = shichosonJohoFinder;
    }

    /**
     * コンストラクタです。
     */
    public KijuntsukiShichosonjohoFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.shichosonJohoFinder = InstanceProvider.create(KoikiShichosonJohoFinder.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KijuntsukiShichosonjohoFinder}のインスタンスを返します。
     *
     * @return KijuntsukiShichosonjohoFinder
     */
    public static KijuntsukiShichosonjohoFinder createInstance() {
        return InstanceProvider.create(KijuntsukiShichosonjohoFinder.class);
    }

    /**
     * 基準月市町村情報の取得します
     *
     * @param 基準年月 FlexibleDate
     * @param 導入形態コード RString
     * @return List<IKoseiShichosonMaster>
     */
    @Transaction
    public List<IKoseiShichosonMaster> getKijuntsukiShichosonjohos(FlexibleDate 基準年月, RString 導入形態コード) {
        List<IKoseiShichosonMaster> koseiShiList = new ArrayList<>();
        RString gappeijohokubun = GappeiCityJohoBFinder.createInstance().getGappeijohokubun();
        if (合併なし.equals(gappeijohokubun)) {
            if (事務構成市町村.equals(導入形態コード) || 事務単一.equals(導入形態コード)
                    || 認定単一.equals(導入形態コード)) {
                return get市町村情報取得(shichosonJohoFinder.koseiShichosonJoho().records());
            }
            if (事務広域.equals(導入形態コード) || 認定広域.equals(導入形態コード)) {
                return get市町村情報取得(shichosonJohoFinder.getGenShichosonJoho().records());
            }
        }
        if (合併あり.equals(gappeijohokubun)) {
            if (事務構成市町村.equals(導入形態コード) || 事務単一.equals(導入形態コード)
                    || 認定単一.equals(導入形態コード)) {
                return get新合併市町村の取得(基準年月);
            }
            if (事務広域.equals(導入形態コード) || 認定広域.equals(導入形態コード)) {
                koseiShiList.addAll(get広域の旧合併市町村情報(基準年月));
                koseiShiList.addAll(get最新の広域構成市町村(基準年月));
            }
        }
        return koseiShiList;
    }

    /**
     * 単一全合併市町村情報の取得します
     *
     * @param 基準年月 FlexibleDate
     * @return List<IKoseiShichosonMaster>
     */
    private List<IKoseiShichosonMaster> get新合併市町村の取得(FlexibleDate 基準年月) {
        IKijuntsukiShichosonjohoMapper mapper = mapperProvider.create(IKijuntsukiShichosonjohoMapper.class);
        List<DbT7055GappeiJohoEntity> dbt7055Entity = mapper.get新合併市町村の取得(基準年月);
        if (dbt7055Entity == null || dbt7055Entity.isEmpty()) {
            return get単一全合併市町村情報(基準年月);
        } else {
            return get市町村情報取得(shichosonJohoFinder.koseiShichosonJoho().records());
        }
    }

    private List<IKoseiShichosonMaster> get単一全合併市町村情報(FlexibleDate 基準年月) {
        RString 内部開始日フラグ = RString.EMPTY;
        List<IKoseiShichosonMaster> koseiShiList = new ArrayList<>();
        IKijuntsukiShichosonjohoMapper mapper = mapperProvider.create(IKijuntsukiShichosonjohoMapper.class);
        List<GappeiShichosonEntity> entityList = mapper.get旧市町村情報を取得(基準年月);
        for (GappeiShichosonEntity entity : entityList) {
            if (1 != entity.getGappeiYMD().getDayValue()) {
                FlexibleDate 運用終了年月日 = entity.getUnyoShuryoYMD();
                FlexibleYearMonth 運用終了年月 = null;
                if (運用終了年月日 != null) {
                    運用終了年月 = 運用終了年月日.getYearMonth();
                }
                if (entity.getKokuhorenDataFromYMD().getYearMonth().equals(entity.getGappeiYMD().getYearMonth())
                        && 基準年月.getYearMonth().equals(運用終了年月)) {
                    continue;
                }
                if (entity.getGappeiYMD().getYearMonth().isBefore(entity.getKokuhorenDataFromYMD().getYearMonth())
                        && 基準年月.getYearMonth().equals(運用終了年月)) {
                    koseiShiList.add(new GappeiShichoson(entity));
                    内部開始日フラグ = new RString("2");
                    continue;
                }
                if (entity.getKokuhorenDataFromYMD().getYearMonth().isBefore(entity.getGappeiYMD().getYearMonth())) {
                    continue;
                }
            }
            FlexibleDate 運用開始年月日 = entity.getUnyoKaishiYMD();
            int 運用開始日 = 1;
            if (運用開始年月日 != null) {
                運用開始日 = 運用開始年月日.getDayValue();
            }
            if ((new RString("2")).equals(内部開始日フラグ) && 1 != 運用開始日) {
                内部開始日フラグ = RString.EMPTY;
                if (運用開始年月日 != null && 基準年月.getYearMonth().equals(運用開始年月日.getYearMonth())) {
                    continue;
                }
            }
            koseiShiList.add(new GappeiShichoson(entity));
        }
        return koseiShiList;
    }

    private List<IKoseiShichosonMaster> get広域の旧合併市町村情報(FlexibleDate 基準年月) {
        List<IKoseiShichosonMaster> koseiShiList = new ArrayList<>();
        IKijuntsukiShichosonjohoMapper mapper = mapperProvider.create(IKijuntsukiShichosonjohoMapper.class);
        List<KoseiShichosonMasterEntity> koseiList = mapper.get広域の旧合併市町村情報を取得(基準年月);
        for (KoseiShichosonMasterEntity entity : koseiList) {
            if (1 != entity.getGappeiYMD().getDayValue()) {
                FlexibleDate 離脱日 = entity.getRidatsuYMD();
                FlexibleYearMonth 離脱年月 = null;
                if (離脱日 != null) {
                    離脱年月 = 離脱日.getYearMonth();
                }
                if (entity.getKokuhorenDataFromYMD().getYearMonth().equals(entity.getGappeiYMD().getYearMonth())
                        && 基準年月.getYearMonth().equals(離脱年月)) {
                    continue;
                }
                if (entity.getGappeiYMD().getYearMonth().isBefore(entity.getKokuhorenDataFromYMD().getYearMonth())
                        && 基準年月.getYearMonth().equals(entity.getKanyuYMD().getYearMonth())) {
                    continue;
                }
            }
            koseiShiList.add(new KoseiShichosonMaster(entity));
        }
        return koseiShiList;
    }

    private List<IKoseiShichosonMaster> get最新の広域構成市町村(FlexibleDate 基準年月) {
        List<IKoseiShichosonMaster> koseiShiList = new ArrayList<>();
        IKijuntsukiShichosonjohoMapper mapper = mapperProvider.create(IKijuntsukiShichosonjohoMapper.class);
        List<KoseiShichosonMasterEntity> koseishiList = mapper.get最新の広域構成市町村の取得(基準年月);
        for (KoseiShichosonMasterEntity entity : koseishiList) {
            if (1 != entity.getGappeiYMD().getDayValue()
                    && (entity.getGappeiYMD().getYearMonth().isBefore(entity.getKokuhorenDataFromYMD().getYearMonth())
                    && 基準年月.getYearMonth().equals(entity.getKanyuYMD().getYearMonth()))) {
                continue;
            }
            koseiShiList.add(new KoseiShichosonMaster(entity));
        }
        return koseiShiList;
    }

    private List<IKoseiShichosonMaster> get市町村情報取得(List<KoikiZenShichosonJoho> 市町村情報) {
        List<IKoseiShichosonMaster> list = new ArrayList<>();
        for (KoikiZenShichosonJoho koikiZenShichosonJoho : 市町村情報) {
            KoseiShichosonMasterEntity entity = new KoseiShichosonMasterEntity();
            entity.setShichosonShokibetsuID(koikiZenShichosonJoho.get市町村識別ID());
            entity.setShichosonCode(koikiZenShichosonJoho.get市町村コード());
            entity.setShoKisaiHokenshaNo(koikiZenShichosonJoho.get証記載保険者番号());
            entity.setKokuhorenKoikiShichosonNo(koikiZenShichosonJoho.get国保連広域内市町村番号());
            entity.setShichosonMeisho(koikiZenShichosonJoho.get市町村名称());
            entity.setTodofukenMeisho(koikiZenShichosonJoho.get都道府県名称());
            entity.setGunMeisho(koikiZenShichosonJoho.get郡名称());
            entity.setYubinNo(koikiZenShichosonJoho.get郵便番号());
            entity.setJusho(koikiZenShichosonJoho.get住所());
            entity.setTelNo(koikiZenShichosonJoho.get電話番号());
            entity.setYusenChikuCode(koikiZenShichosonJoho.get最優先地区コード());
            entity.setTyohyoTodoufukenHyojiUmu(koikiZenShichosonJoho.get帳票用都道府県名称表示有無());
            entity.setTyohyoGunHyojiUmu(koikiZenShichosonJoho.get帳票用郡名称表示有無());
            entity.setTyohyoShichosonHyojiUmu(koikiZenShichosonJoho.get帳票用市町村名称表示有無());
            entity.setTyohyoJushoHenshuHouhou(koikiZenShichosonJoho.get帳票用住所編集方法());
            entity.setTyohyoKatagakiHyojiUmu(koikiZenShichosonJoho.get帳票用方書表示有無());
            entity.setRojinhokenShichosonNo(koikiZenShichosonJoho.get老人保健市町村番号());
            entity.setRokenJukyushaNoTaikei(koikiZenShichosonJoho.get老人保健受給者番号体系());
            entity.setTokuchoBunpaishuyaku(koikiZenShichosonJoho.get特徴分配集約());
            entity.setIkoYMD(koikiZenShichosonJoho.get移行日());
            entity.setKanyuYMD(koikiZenShichosonJoho.get加入日());
            entity.setRidatsuYMD(koikiZenShichosonJoho.get離脱日());
            entity.setGappeiKyuShichosonKubun(koikiZenShichosonJoho.get合併旧市町村区分());
            entity.setGappeiKyuShichosonHyojiUmu(koikiZenShichosonJoho.get合併旧市町村表示有無());
            entity.setGappeiChiikiNo(koikiZenShichosonJoho.get合併情報地域番号());
            entity.setUnyoHokenshaNo(koikiZenShichosonJoho.get運用保険者番号());
            entity.setUnyoKaishiYMD(koikiZenShichosonJoho.get運用終了日());
            entity.setUnyoShuryoYMD(koikiZenShichosonJoho.get運用終了日());
            entity.setUnyoKeitaiKubun(koikiZenShichosonJoho.get運用形態区分());
            list.add(new KoseiShichosonMaster(entity));
        }
        return list;
    }
}
