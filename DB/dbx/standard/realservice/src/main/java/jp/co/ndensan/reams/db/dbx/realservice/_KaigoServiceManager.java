package jp.co.ndensan.reams.db.dbx.realservice;

import java.util.List;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbx.business.IKaigoService;
import jp.co.ndensan.reams.db.dbx.business.IKaigoServiceCode;
import jp.co.ndensan.reams.db.dbx.business.IKaigoServiceNaiyo;
import jp.co.ndensan.reams.db.dbx.business.IKaigoServiceShurui;
import jp.co.ndensan.reams.db.dbx.business._KaigoServiceCode;
import jp.co.ndensan.reams.db.dbx.business._KaigoServiceNaiyo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.db.dbx.entity.basic.DbT7130KaigoServiceShuruiEntity;
import jp.co.ndensan.reams.db.dbx.entity.basic.DbT7131KaigoServiceNaiyouEntity;
import jp.co.ndensan.reams.db.dbx.business.mapper.KaigoServiceMapper;
import jp.co.ndensan.reams.db.dbx.business.mapper.KaigoServiceNaiyoMapper;
import jp.co.ndensan.reams.db.dbx.business.mapper.KaigoServiceShuruiMapper;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7131KaigoServiceNaiyouDac;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7130KaigoServiceShuruiDac;
import jp.co.ndensan.reams.uz.uza.util.db.searchcondition.FlexibleYearMonthOperator;
import jp.co.ndensan.reams.uz.uza.util.db.searchcondition.INewSearchCondition;
import jp.co.ndensan.reams.uz.uza.util.db.searchcondition.ISearchCondition;
import jp.co.ndensan.reams.db.dbx.realservice.search.KaigoServiceNaiyoSearchItem;
import jp.co.ndensan.reams.db.dbx.realservice.search.KaigoServiceShuruiSearchItem;
import jp.co.ndensan.reams.uz.uza.util.db.searchcondition.SearchConditionFactory;
import jp.co.ndensan.reams.uz.uza.util.db.searchcondition.StringOperator;
import jp.co.ndensan.reams.uz.uza.biz.KaigoServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.ITrueFalseCriteria;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 介護サービスに関する情報を取得するためのマネージャークラスです。
 *
 * @author N9935 知念 広宰
 * @jpName 介護サービス取得
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護サービス
 * @mainClass
 * @reference
 */
public class _KaigoServiceManager implements IKaigoServiceManager {

    private final DbT7130KaigoServiceShuruiDac shuruiDac;
    private final DbT7131KaigoServiceNaiyouDac naiyoDac;
    private final RString base_date = new RString("基準日");

    /**
     * 介護サービスマネージャークラスのコンストラクタです。
     */
    public _KaigoServiceManager() {
        shuruiDac = InstanceProvider.createWithCustomize(DbT7130KaigoServiceShuruiDac.class);
        naiyoDac = InstanceProvider.createWithCustomize(DbT7131KaigoServiceNaiyouDac.class);
    }

    /**
     * テスト用のコンストラクタです。
     *
     * @param shuruiDac 介護サービス種類Dacクラス
     * @param naiyoDac 介護サービス内容Dacクラス
     */
    public _KaigoServiceManager(DbT7130KaigoServiceShuruiDac shuruiDac, DbT7131KaigoServiceNaiyouDac naiyoDac) {
        this.shuruiDac = shuruiDac;
        this.naiyoDac = naiyoDac;
    }

    @Override
    public List<IKaigoServiceShurui> get介護サービス種類All(FlexibleYearMonth 基準年月) {
        Objects.requireNonNull(基準年月, UrSystemErrorMessages.値がnull.getReplacedMessage(base_date.toString()));

        List<DbT7130KaigoServiceShuruiEntity> entities = shuruiDac.selectList(makeShuruiConditions(基準年月, KaigoServiceShuruiCode.EMPTY, RString.EMPTY));

        return KaigoServiceShuruiMapper.to介護サービス種類リスト(entities);
    }

    @Override
    public IKaigoService get介護サービス(FlexibleYearMonth 基準年月, KaigoServiceShuruiCode サービス種類) {
        Objects.requireNonNull(基準年月, UrSystemErrorMessages.値がnull.getReplacedMessage(base_date.toString()));
        Objects.requireNonNull(サービス種類, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類"));

        List<DbT7130KaigoServiceShuruiEntity> shuruiEntities = shuruiDac.selectList(makeShuruiConditions(基準年月, サービス種類, RString.EMPTY));
        List<DbT7131KaigoServiceNaiyouEntity> naiyoEntities = naiyoDac.selectList(makeNaiyoConditions(基準年月, サービス種類, RString.EMPTY));

        return KaigoServiceMapper.to介護サービス(shuruiEntities, naiyoEntities);
    }

    @Override
    public List<IKaigoServiceShurui> get介護サービス種類(FlexibleYearMonth 基準年月, RString サービス分類) {
        Objects.requireNonNull(基準年月, UrSystemErrorMessages.値がnull.getReplacedMessage(base_date.toString()));
        Objects.requireNonNull(サービス分類, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス分類"));

        List<DbT7130KaigoServiceShuruiEntity> entities = shuruiDac.selectList(makeShuruiConditions(基準年月, KaigoServiceShuruiCode.EMPTY, サービス分類));

        return KaigoServiceShuruiMapper.to介護サービス種類リスト(entities);
    }

    @Override
    public IKaigoService get介護サービス内容(FlexibleYearMonth 基準年月, IKaigoServiceCode サービスコード) {
        Objects.requireNonNull(基準年月, UrSystemErrorMessages.値がnull.getReplacedMessage(base_date.toString()));
        Objects.requireNonNull(サービスコード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービスコード"));

        List<DbT7130KaigoServiceShuruiEntity> shuruiEntities
                = shuruiDac.selectList(makeShuruiConditions(基準年月, サービスコード.getサービス種類コード(), RString.EMPTY));

        List<DbT7131KaigoServiceNaiyouEntity> naiyoEntities
                = naiyoDac.selectList(makeNaiyoConditions(基準年月, サービスコード.getサービス種類コード(), サービスコード.getサービス項目コード()));

        return KaigoServiceMapper.to介護サービス(shuruiEntities, naiyoEntities);
    }

    @Override
    public int save介護サービス種類(IKaigoServiceShurui 介護サービス種類) {
        return shuruiDac.save(KaigoServiceShuruiMapper.to介護サービス種類Entity(介護サービス種類));
    }

    @Override
    public int save介護サービス内容(IKaigoServiceNaiyo 介護サービス内容) {
        return naiyoDac.save(KaigoServiceNaiyoMapper.to介護サービス内容Entity(介護サービス内容));
    }

    @Override
    public int remove介護サービス種類(IKaigoServiceShurui 介護サービス種類) {
        int removeShurui = shuruiDac.save(KaigoServiceShuruiMapper.to介護サービス種類Entity(介護サービス種類));
        IKaigoServiceCode kaigoServiceCode = new _KaigoServiceCode(介護サービス種類.getサービス種類コード(), RString.EMPTY);
        IKaigoServiceNaiyo 介護サービス内容 = new _KaigoServiceNaiyo(kaigoServiceCode);
        int removeNaiyo = naiyoDac.save(KaigoServiceNaiyoMapper.to介護サービス内容Entity(介護サービス内容));
        return removeShurui + removeNaiyo;
    }

    @Override
    public int remove介護サービス内容(IKaigoServiceNaiyo 介護サービス内容) {
        return naiyoDac.save(KaigoServiceNaiyoMapper.to介護サービス内容Entity(介護サービス内容));
    }

    private ITrueFalseCriteria makeShuruiConditions(FlexibleYearMonth 基準年月, KaigoServiceShuruiCode サービス種類, RString サービス分類) {
        INewSearchCondition 提供開始年月 = SearchConditionFactory.condition(
                KaigoServiceShuruiSearchItem.提供開始年月, FlexibleYearMonthOperator.以降, 基準年月);
        INewSearchCondition 提供終了年月 = SearchConditionFactory.condition(
                KaigoServiceShuruiSearchItem.提供終了年月, FlexibleYearMonthOperator.以前, 基準年月);
        INewSearchCondition 介護サービス種類 = SearchConditionFactory.condition(
                KaigoServiceShuruiSearchItem.介護サービス種類, StringOperator.完全一致, サービス種類.value());
        INewSearchCondition 介護サービス分類 = SearchConditionFactory.condition(
                KaigoServiceShuruiSearchItem.介護サービス分類, StringOperator.完全一致, サービス分類);
        ISearchCondition result = 提供開始年月.and(提供終了年月).and(介護サービス種類).and(介護サービス分類);

        return result.makeSearchCondition();
    }

    private ITrueFalseCriteria makeNaiyoConditions(FlexibleYearMonth 基準年月, KaigoServiceShuruiCode サービス種類, RString サービス項目) {
        INewSearchCondition 適用開始年月 = SearchConditionFactory.condition(
                KaigoServiceNaiyoSearchItem.適用開始年月, FlexibleYearMonthOperator.以降, 基準年月);
        INewSearchCondition 適用終了年月 = SearchConditionFactory.condition(
                KaigoServiceNaiyoSearchItem.適用終了年月, FlexibleYearMonthOperator.以前, 基準年月);
        INewSearchCondition 介護サービス種類コード = SearchConditionFactory.condition(
                KaigoServiceNaiyoSearchItem.介護サービス種類コード, StringOperator.完全一致, サービス種類.value());
        INewSearchCondition 介護サービス項目コード = SearchConditionFactory.condition(
                KaigoServiceNaiyoSearchItem.介護サービス項目コード, StringOperator.完全一致, サービス項目);
        ISearchCondition result = 介護サービス種類コード.and(介護サービス項目コード).and(適用開始年月).and(適用終了年月);

        return result.makeSearchCondition();
    }
}
