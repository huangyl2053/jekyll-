package jp.co.ndensan.reams.db.dbb.service.core.fuka;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ca.cax.business.core.shuno.ShunoKanri;
import jp.co.ndensan.reams.ca.cax.business.core.shuno.ShunoKey;
import jp.co.ndensan.reams.ca.cax.business.core.shuno.chotei.Chotei;
import jp.co.ndensan.reams.ca.cax.definition.core.shuno.chotei.ChoteiJiyu;
import jp.co.ndensan.reams.ca.cax.definition.core.shuno.chotei.FukaShoriJokyo;
import jp.co.ndensan.reams.ca.cax.service.core.shuno.ShunoManager;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.Fuka;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.Kibetsu;
import jp.co.ndensan.reams.db.dbb.definition.core.choshuhoho.ChoshuHohoKibetsu;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.fuka.FukaMapperParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fuka.FukaEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2002FukaDac;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.fuka.IFukaMapper;
import jp.co.ndensan.reams.db.dbb.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.FukaNokiResearcher;
import jp.co.ndensan.reams.ur.urc.business.core.noki.nokitsuki.Nokitsuki;
import jp.co.ndensan.reams.ur.urc.business.core.shunokamoku.shunokamoku.IShunoKamoku;
import jp.co.ndensan.reams.ur.urc.definition.core.shuno.tsuchishono.TsuchishoNo;
import jp.co.ndensan.reams.ur.urc.definition.core.shunokamoku.shunokamoku.ShunoKamokuShubetsu;
import jp.co.ndensan.reams.ur.urc.service.core.shunokamoku.shunokamoku.ShunoKamokuManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護賦課を管理するクラスです。
 */
public class FukaManager {

    private static final Decimal 初期金額 = new Decimal(0);
    private static final Decimal 特徴期別金額01 = new Decimal(1);
    private final MapperProvider mapperProvider;
    private final DbT2002FukaDac 介護賦課Dac;
    private final KibetsuManager 介護期別Manager;

    /**
     * コンストラクタです。
     */
    FukaManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.介護賦課Dac = InstanceProvider.create(DbT2002FukaDac.class);
        this.介護期別Manager = new KibetsuManager();
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 介護賦課Dac 介護賦課Dac
     * @param 介護期別Manager 介護期別Manager
     */
    FukaManager(
            MapperProvider mapperProvider,
            DbT2002FukaDac 介護賦課Dac,
            KibetsuManager 介護期別Manager
    ) {
        this.mapperProvider = mapperProvider;
        this.介護賦課Dac = 介護賦課Dac;
        this.介護期別Manager = 介護期別Manager;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link FukaManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link FukaManager}のインスタンス
     */
    public static FukaManager createInstance() {
        return InstanceProvider.create(FukaManager.class);
    }

    /**
     * 主キーに合致する介護賦課を返します。
     *
     * @param 介護賦課検索条件 介護賦課検索条件
     * @return Fuka nullが返る可能性があります。
     */
    @Transaction
    public Fuka get介護賦課(FukaMapperParameter 介護賦課検索条件) {
        requireNonNull(介護賦課検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("介護賦課検索条件"));
        IFukaMapper mapper = mapperProvider.create(IFukaMapper.class);

        FukaEntity relateEntity = mapper.getFukaEntity(介護賦課検索条件);
        if (relateEntity == null) {
            return null;
        }
        relateEntity.initializeMd5ToEntities();
        return new Fuka(relateEntity);
    }

    /**
     * 介護賦課{@link Fuka}を保存します。
     *
     * @param 介護賦課 介護賦課
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean save(Fuka 介護賦課) {
        requireNonNull(介護賦課, UrSystemErrorMessages.値がnull.getReplacedMessage("介護賦課"));

        if (!介護賦課.hasChanged()) {
            return false;
        }
        介護賦課 = 介護賦課.modifiedModel();
        save介護期別リスト(介護賦課.getKibetsuList());
        return 1 == 介護賦課Dac.save(介護賦課.toEntity());
    }

    private void save介護期別リスト(List<Kibetsu> 介護期別List) {
        for (Kibetsu 介護期別 : 介護期別List) {
            介護期別Manager.save介護期別(介護期別);
        }
    }

    /**
     * 介護賦課を保存します。
     *
     * @param 介護賦課 介護賦課
     */
    @Transaction
    public void save賦課(Fuka 介護賦課) {
        requireNonNull(介護賦課, UrSystemErrorMessages.値がnull.getReplacedMessage("介護賦課"));
        if (初期金額.compareTo(特徴期別金額01) < 0) {
            save介護期別(介護賦課, ChoshuHohoKibetsu.特別徴収, 1);
        }

//        if (初期金額.compareTo(普徴期別金額01) < 0) {
//            徴収方法 = ChoshuHohoKibetsu.普通徴収;
//        }
//        Noki 普徴納期 = FukaNokiResearcher.createInstance().get普徴納期(new FuchoKiUtil().get期月リスト().get月の期(Tsuki._4月).get期AsInt());
        save介護期別リスト(介護賦課.getKibetsuList());
        介護賦課Dac.save(介護賦課.toEntity());
    }

    private void save介護期別(Fuka 介護賦課, ChoshuHohoKibetsu 徴収方法, int 期) {
        new ShunoManager().save調定(get収納キークラス(介護賦課, get科目(徴収方法), 期), get調定クラス(介護賦課, 期));
        new KibetsuManager().save介護期別(new Kibetsu(介護賦課.get調定年度(), 介護賦課.get賦課年度(),
                介護賦課.get通知書番号(), 介護賦課.get履歴番号(), ChoshuHohoKibetsu.特別徴収.get名称(), 期));
    }

    private ShunoKey get収納キークラス(Fuka 介護賦課, IShunoKamoku 科目, int 期) {
        return new ShunoKey(get収納管理(介護賦課, 科目, 期), 科目, get納期月(科目, 期));
    }

    private Chotei get調定クラス(Fuka 介護賦課, int 期) {
        Chotei.Builder builder = Chotei.newBuilder();
//      TODO QA927 ChoteiManager.numbering調定ID()
        builder.set調定ID(0L);
        builder.set収納ID(0L);
        builder.set会計年度(new RYear(介護賦課.get調定年度().toString()));
        builder.set調定事由コード(ChoteiJiyu.更正の請求に基づく更正);
//      TODO QA927 特徴期別金額01～06または普徴期別金額01～１４ない
        builder.set調定額(初期金額);
        builder.set消費税額(初期金額);
        builder.set納期限(FukaNokiResearcher.createInstance().get特徴納期(期).get納期限());
        builder.set賦課処理状況(FukaShoriJokyo.保留中);
        return builder.build();
    }

    private IShunoKamoku get科目(ChoshuHohoKibetsu 徴収方法) {
        ShunoKamokuManager 科目Manager = new ShunoKamokuManager();
        if (ChoshuHohoKibetsu.特別徴収 == 徴収方法) {
            return 科目Manager.get科目(ShunoKamokuShubetsu.介護保険料_特別徴収);
        } else {
            return 科目Manager.get科目(ShunoKamokuShubetsu.介護保険料_普通徴収);
        }
    }

    private ShunoKanri get収納管理(Fuka 介護賦課, IShunoKamoku 科目, int 期) {

        ShunoKanri.Builder builder = ShunoKanri.newBuilder();
        builder.setChoteiNendo(new RYear(介護賦課.get調定年度().toString()));
        builder.setKamokuCode(科目.getコード());
        builder.setKamokuEdabanCode(科目.get枝番コード());
        builder.setKazeiNendo(new RYear(介護賦課.get賦課年度().toString()));
        builder.setKibetsu(期);
        builder.setShikibetsuCode(介護賦課.get識別コード());
        builder.setShunoId(0L);
        builder.setTsuchishoNo(new TsuchishoNo(new Decimal(介護賦課.get通知書番号().toString())));
        return builder.build();
    }

    private Nokitsuki get納期月(IShunoKamoku 科目, int 期) {
        Nokitsuki.Builder builder = Nokitsuki.newBuilder();
        builder.set科目コード(科目.getコード());
        builder.set科目枝番コード(科目.get枝番コード());
        builder.set期別(期);
        return builder.build();
    }
}
