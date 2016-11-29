package jp.co.ndensan.reams.db.dbu.service.core.sogosyokaifukajyoho;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.core.sogosyokaifukajyoho.SoGoSyoKaiFuKaJyoHoBusiness;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.sogosyokaifukajyoho.SoGoSyoKaiFuKaJyoHoParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.sogosyokaifukajyoho.SoGoSyoKaiFuKaJyoHoEntity;
import jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.sogosyokaifukajyoho.ISoGoSyoKaiFuKaJyoHoMapper;
import jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbx.business.core.fuka.Fuka;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT2001ChoshuHohoDac;
import jp.co.ndensan.reams.db.dbx.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbV2002FukaAliveDac;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 画面設計_DBU0600041_総合照会_賦課情報のFinderクラスです。
 *
 * @reamsid_L DBU-4100-050 houtianpeng
 */
public class SoGoSyoKaiFuKaJyoHoFinder {

    private final MapperProvider mapperProvider;
    private final DbV2002FukaAliveDac dbv2002FuKaDac;
    private final DbT7022ShoriDateKanriDac dbT7022Dac;
    private final DbT2001ChoshuHohoDac dbT2001Dac;

    /**
     * コンストラクタです。
     */
    SoGoSyoKaiFuKaJyoHoFinder() {
        this.dbv2002FuKaDac = InstanceProvider.create(DbV2002FukaAliveDac.class);
        this.dbT7022Dac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
        this.dbT2001Dac = InstanceProvider.create(DbT2001ChoshuHohoDac.class);
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider {@link MapperProvider}}
     */
    SoGoSyoKaiFuKaJyoHoFinder(MapperProvider mapperProvider,
            DbV2002FukaAliveDac dbv2002FuKaDac,
            DbT7022ShoriDateKanriDac dbT7022Dac,
            DbT2001ChoshuHohoDac dbT2001Dac) {
        this.mapperProvider = mapperProvider;
        this.dbv2002FuKaDac = dbv2002FuKaDac;
        this.dbT7022Dac = dbT7022Dac;
        this.dbT2001Dac = dbT2001Dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link SoGoSyoKaiFuKaJyoHoFinder}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link SoGoSyoKaiFuKaJyoHoFinder}のインスタンス
     */
    public static SoGoSyoKaiFuKaJyoHoFinder createInstance() {
        return InstanceProvider.create(SoGoSyoKaiFuKaJyoHoFinder.class);
    }

    /**
     * 賦課情報の取得。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return 最新の賦課年度と調定年度
     */
    @Transaction
    public SearchResult<Fuka> get最新の賦課年度と調定年度(HihokenshaNo 被保険者番号) {
        DbT2002FukaEntity entity = dbv2002FuKaDac.select賦課年度と調定年度(被保険者番号);
        if (entity == null) {
            return SearchResult.of(Collections.<Fuka>emptyList(), 0, false);
        }
        List<Fuka> fukaList = new ArrayList();
        fukaList.add(new Fuka(entity));
        return SearchResult.of(fukaList, 0, false);
    }

    /**
     * 本算定賦課の処理日時を取得。
     *
     * @param 賦課年度 FlexibleYear
     * @return 本算定賦課の処理日時
     */
    @Transaction
    public YMDHMS get本算定賦課の処理日時(FlexibleYear 賦課年度) {

        DbT7022ShoriDateKanriEntity entity = dbT7022Dac.getMax基準日(賦課年度, ShoriName.本算定賦課.get名称());
        if (entity != null) {
            return entity.getKijunTimestamp();
        }
        return null;
    }

    /**
     * 賦課情報の取得。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 賦課年度 FlexibleYear
     * @param 調定年度 FlexibleYear
     * @return 賦課情報
     */
    @Transaction
    public SearchResult<Fuka> get賦課情報(FlexibleYear 調定年度, FlexibleYear 賦課年度, HihokenshaNo 被保険者番号) {
        List<DbT2002FukaEntity> fukaList = dbv2002FuKaDac.select賦課情報(調定年度, 賦課年度, 被保険者番号);
        if (fukaList == null) {
            return SearchResult.of(Collections.<Fuka>emptyList(), 0, false);
        }
        List<Fuka> fuka = new ArrayList();
        for (DbT2002FukaEntity entity : fukaList) {
            fuka.add(new Fuka(entity));
        }
        return SearchResult.of(fuka, 0, false);
    }

    /**
     * 賦課情報の取得。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 調定年度 FlexibleYear
     * @return 前年の賦課年度と調定年度
     */
    @Transaction
    public SearchResult<Fuka> get前年の賦課年度と調定年度(HihokenshaNo 被保険者番号, FlexibleYear 調定年度) {
        DbT2002FukaEntity entity = dbv2002FuKaDac.select前年の賦課年度と調定年度(被保険者番号, 調定年度);
        if (entity == null) {
            return SearchResult.of(Collections.<Fuka>emptyList(), 0, false);
        }
        List<Fuka> fukaList = new ArrayList();
        fukaList.add(new Fuka(entity));
        return SearchResult.of(fukaList, 0, false);
    }

    /**
     * 前年の賦課情報の取得。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 賦課年度 FlexibleYear
     * @param 調定年度 FlexibleYear
     * @return 賦課情報
     */
    @Transaction
    public SearchResult<Fuka> get前年の賦課情報(FlexibleYear 調定年度, FlexibleYear 賦課年度, HihokenshaNo 被保険者番号) {
        DbT2002FukaEntity entity = dbv2002FuKaDac.select前年賦課情報(調定年度, 賦課年度, 被保険者番号);
        if (entity == null) {
            return SearchResult.of(Collections.<Fuka>emptyList(), 0, false);
        }
        List<Fuka> fukaList = new ArrayList();
        fukaList.add(new Fuka(entity));
        return SearchResult.of(fukaList, 0, false);
    }

    /**
     * 介護徴収方法の取得。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 賦課年度 FlexibleYear
     * @return 介護徴収方法
     */
    @Transaction
    public SearchResult<ChoshuHoho> get介護徴収方法(FlexibleYear 賦課年度, HihokenshaNo 被保険者番号) {
        DbT2001ChoshuHohoEntity entity = dbT2001Dac.select(賦課年度, 被保険者番号);
        if (entity == null) {
            return SearchResult.of(Collections.<ChoshuHoho>emptyList(), 0, false);
        }
        List<ChoshuHoho> choshuHohoList = new ArrayList();
        choshuHohoList.add(new ChoshuHoho(entity));
        return SearchResult.of(choshuHohoList, 0, false);
    }

    /**
     * 調定情報の取得。
     *
     * @param parameter SoGoSyoKaiFuKaJyoHoParameter
     * @return 調定情報
     */
    @Transaction
    public SearchResult<SoGoSyoKaiFuKaJyoHoBusiness> get調定情報(SoGoSyoKaiFuKaJyoHoParameter parameter) {

        ISoGoSyoKaiFuKaJyoHoMapper mapper = mapperProvider.create(ISoGoSyoKaiFuKaJyoHoMapper.class);
        List<SoGoSyoKaiFuKaJyoHoEntity> soGoSyoKaiFuKaJyoHoList = mapper.get調定情報(parameter);
        if (soGoSyoKaiFuKaJyoHoList == null || soGoSyoKaiFuKaJyoHoList.isEmpty()) {

            return SearchResult.of(Collections.<SoGoSyoKaiFuKaJyoHoBusiness>emptyList(), 0, false);
        }
        List<SoGoSyoKaiFuKaJyoHoBusiness> soGoSyoKaiFuKaJyoList = new ArrayList();
        for (SoGoSyoKaiFuKaJyoHoEntity entity : soGoSyoKaiFuKaJyoHoList) {
            soGoSyoKaiFuKaJyoList.add(new SoGoSyoKaiFuKaJyoHoBusiness(entity));
        }
        return SearchResult.of(soGoSyoKaiFuKaJyoList, 0, false);
    }
}
