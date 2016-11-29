/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kougakugassanshikyuketteitsuchisho;

import jp.co.ndensan.reams.db.dbc.business.report.gassanjigyobunketteitsuchisho.KogakuGassanShikyuKetteiTsuchisho;
import jp.co.ndensan.reams.db.dbc.business.report.gassanjigyobunketteitsuchisho.KougakugassanShikyuketteiTsuuchishoOutputEntity;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kougakugassanshikyuketteitsuchisho.KougakuGassanShikyuKetteiTsuchishoParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kougakugassanshikyuketteitsuchisho.HihokenshaTaishoPSMFuka;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kougakugassanshikyuketteitsuchisho.JigyoKogakuGassanEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kougakugassanshikyuketteitsuchisho.IKougakuGassanShikyuKetteiTsuchishoMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.core.kanri.JushoHenshu;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedAtesaki;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoHanyoManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoKyotsuManager;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.koza.IKoza;
import jp.co.ndensan.reams.ua.uax.business.core.koza.KozaSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.GyomuKoyuKeyRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.atesaki.IAtesakiGyomuHanteiKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.service.core.koza.IKozaManager;
import jp.co.ndensan.reams.ua.uax.service.core.koza.KozaService;
import jp.co.ndensan.reams.ua.uax.service.core.shikibetsutaisho.ShikibetsuTaishoService;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ux.uxx.business.core.tsuchishoteikeibun.TsuchishoTeikeibun;
import jp.co.ndensan.reams.ux.uxx.service.core.tsuchishoteikeibun.TsuchishoTeikeibunFinder;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.util.barcode.CustomerBarCode;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * ビジネス設計_DBCMNN2003_事業分高額合算支給決定通知書（単）のビジネス。
 *
 * @reamsid_L DBC-4850-040 pengxingyi
 */
public class KougakuGassanShikyuKetteiTsuchisho {

    private final MapperProvider mapperProvider;
    private static final ReportId 通知文情報帳票ID = new ReportId("DBC200201_GassanJigyobunKetteiTsuchisho");
    private static final int NUM_1 = 1;
    private static final int NUM_2 = 2;
    private static final int NUM_3 = 3;
    private static final int NUM_4 = 4;
    private static final RString 定数_2 = new RString("2");
    private static final RString 定数_1 = new RString("1");
    private static final RString 定数_0 = new RString("0");
    private static final RString 項目名_取り消し線 = new RString("取り消し線");
    private static final RString 項目名_帳票タイトル = new RString("帳票タイトル");
    private static final RString 項目名_帳票タイトル_抹消線あり１ = new RString("帳票タイトル_抹消線あり１");
    private static final RString 項目名_帳票タイトル_抹消線あり２ = new RString("帳票タイトル_抹消線あり２");
    private static final RString 項目名_帳票タイトル_抹消線あり３ = new RString("帳票タイトル_抹消線あり３");
    private static final RString 項目名_帳票タイトル_抹消線あり４ = new RString("帳票タイトル_抹消線あり４");

    /**
     * コンストラクタです。
     */
    public KougakuGassanShikyuKetteiTsuchisho() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * にて生成した{@link KougakuGassanShikyuKetteiTsuchisho}のインスタンスを返します。
     *
     * @return KougakuGassanShikyuKetteiTsuchisho
     */
    public static KougakuGassanShikyuKetteiTsuchisho createInstance() {
        return InstanceProvider.create(KougakuGassanShikyuKetteiTsuchisho.class);
    }

    /**
     * 事業高額合算情報取得です。
     *
     * @param 識別コード 識別コード
     * @param 被保険者番号 被保険者番号
     * @param 帳票ID 帳票ID
     * @param 対象年度 対象年度
     * @param 連絡票整理番号 連絡票整理番号
     * @param 履歴番号 履歴番号
     * @param 文書番号 文書番号
     * @param 発行日 発行日
     * @param 支払予定日 支払予定日
     * @param 口座ID 口座ID
     * @return {@link KogakuGassanShikyuKetteiTsuchisho}
     */
    public KougakugassanShikyuketteiTsuuchishoOutputEntity editKougakugassanShikyuketteiTsuuchisho(ShikibetsuCode 識別コード,
            HihokenshaNo 被保険者番号, ReportId 帳票ID, FlexibleYear 対象年度, RString 連絡票整理番号, int 履歴番号, RString 文書番号,
            FlexibleDate 発行日, FlexibleDate 支払予定日, long 口座ID) {
        KougakugassanShikyuketteiTsuuchishoOutputEntity target = new KougakugassanShikyuketteiTsuuchishoOutputEntity();
        RString データ有無 = 定数_0;
        IShikibetsuTaishoPSMSearchKey searchKey = new ShikibetsuTaishoPSMSearchKeyBuilder(
                GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先).
                setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード).
                set基準日(発行日).
                build();
        KougakuGassanShikyuKetteiTsuchishoParameter param = new KougakuGassanShikyuKetteiTsuchishoParameter(searchKey);
        param.set対象年度(対象年度);
        param.set履歴番号(履歴番号);
        param.set被保険者番号(被保険者番号);
        param.set連絡票整理番号(連絡票整理番号);
        IKougakuGassanShikyuKetteiTsuchishoMapper mapper = mapperProvider.create(IKougakuGassanShikyuKetteiTsuchishoMapper.class);
        JigyoKogakuGassanEntity jigyoKogakuGassanEntity = mapper.select事業高額合算(param);
        HihokenshaTaishoPSMFuka hihokenshaTaishoPSMFuka = mapper.select被保険者宛名情報(param);
        KogakuGassanShikyuKetteiTsuchisho entity = new KogakuGassanShikyuKetteiTsuchisho();
        if (jigyoKogakuGassanEntity == null) {
            target.setデータ有無(定数_1);
            return target;
        } else {
            entity.set事業高額合算支給不支給決定(jigyoKogakuGassanEntity.get事業高額合算支給不支給決定());
        }
        if (hihokenshaTaishoPSMFuka != null && hihokenshaTaishoPSMFuka.getKanjiShimei() != null) {
            entity.set被保険者氏名(hihokenshaTaishoPSMFuka.getKanjiShimei().getColumnValue());
        }
        ChohyoSeigyoHanyoManager manager = new ChohyoSeigyoHanyoManager();
        ChohyoSeigyoHanyo 帳票制御汎用_取り消し線
                = manager.get帳票制御汎用(SubGyomuCode.DBC介護給付, 通知文情報帳票ID, FlexibleYear.MIN, 項目名_取り消し線);
        ChohyoSeigyoHanyo 帳票制御汎用_帳票タイトル
                = manager.get帳票制御汎用(SubGyomuCode.DBC介護給付, 通知文情報帳票ID, FlexibleYear.MIN, 項目名_帳票タイトル);
        ChohyoSeigyoHanyo 帳票制御汎用_帳票タイトル_抹消線あり１
                = manager.get帳票制御汎用(SubGyomuCode.DBC介護給付, 通知文情報帳票ID, FlexibleYear.MIN, 項目名_帳票タイトル_抹消線あり１);
        ChohyoSeigyoHanyo 帳票制御汎用_帳票タイトル_抹消線あり２
                = manager.get帳票制御汎用(SubGyomuCode.DBC介護給付, 通知文情報帳票ID, FlexibleYear.MIN, 項目名_帳票タイトル_抹消線あり２);
        ChohyoSeigyoHanyo 帳票制御汎用_帳票タイトル_抹消線あり３
                = manager.get帳票制御汎用(SubGyomuCode.DBC介護給付, 通知文情報帳票ID, FlexibleYear.MIN, 項目名_帳票タイトル_抹消線あり３);
        ChohyoSeigyoHanyo 帳票制御汎用_帳票タイトル_抹消線あり４
                = manager.get帳票制御汎用(SubGyomuCode.DBC介護給付, 通知文情報帳票ID, FlexibleYear.MIN, 項目名_帳票タイトル_抹消線あり４);
        if (定数_0.equals(帳票制御汎用_取り消し線.get設定値())) {
            entity.setTitle(帳票制御汎用_帳票タイトル.get設定値());
        } else if (定数_1.equals(帳票制御汎用_取り消し線.get設定値())) {
            entity.setTitle21(帳票制御汎用_帳票タイトル_抹消線あり１.get設定値());
            entity.setTitle24(帳票制御汎用_帳票タイトル_抹消線あり４.get設定値());
            if (定数_1.equals(jigyoKogakuGassanEntity.get事業高額合算支給不支給決定().getShikyuKubunCode())) {
                entity.setTitle221(帳票制御汎用_帳票タイトル_抹消線あり２.get設定値());
                entity.setTitle222(RString.EMPTY);
                entity.setTitle231(RString.EMPTY);
                entity.setTitle232(帳票制御汎用_帳票タイトル_抹消線あり３.get設定値());
            } else if (定数_2.equals(jigyoKogakuGassanEntity.get事業高額合算支給不支給決定().getShikyuKubunCode())) {
                entity.setTitle221(RString.EMPTY);
                entity.setTitle222(帳票制御汎用_帳票タイトル_抹消線あり２.get設定値());
                entity.setTitle231(帳票制御汎用_帳票タイトル_抹消線あり３.get設定値());
                entity.setTitle232(RString.EMPTY);
            }
        }
        ShikibetsuCode shikibetsuCode = hihokenshaTaishoPSMFuka == null ? null : hihokenshaTaishoPSMFuka.getShikibetsuCode();
        entity.set文書番号(文書番号);
        entity.set発行日(発行日);
        entity.set被保険者番号(被保険者番号);
        setKoza(entity, 口座ID, shikibetsuCode);
        set通知文(entity);
        set送付物宛先(entity, shikibetsuCode, 発行日);
        target.set事業分高額合算支給決定通知書(entity);
        target.setデータ有無(データ有無);
        return target;
    }

    private void set送付物宛先(KogakuGassanShikyuKetteiTsuchisho entity, ShikibetsuCode 識別コード, FlexibleDate 発行日) {
        IAtesakiGyomuHanteiKey 宛先業務判定キー = AtesakiGyomuHanteiKeyFactory.createInstace(GyomuCode.DB介護保険, SubGyomuCode.DBC介護給付);
        AtesakiPSMSearchKeyBuilder builder = new AtesakiPSMSearchKeyBuilder(宛先業務判定キー);
        builder.set識別コード(識別コード);
        builder.set基準日(FlexibleDate.getNowDate());
        builder.set業務固有キー利用区分(GyomuKoyuKeyRiyoKubun.利用しない);
        IAtesaki 宛先 = ShikibetsuTaishoService.getAtesakiFinder().get宛先(builder.build());
        Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
        ChohyoSeigyoKyotsuManager manager = new ChohyoSeigyoKyotsuManager();
        ChohyoSeigyoKyotsu 帳票制御共通 = manager.get帳票制御共通(SubGyomuCode.DBC介護給付, 通知文情報帳票ID);
        EditedAtesaki 編集後宛先 = JushoHenshu.create編集後宛先(宛先, 地方公共団体, 帳票制御共通);
        SofubutsuAtesakiSource 送付物宛先ソースデータ = 編集後宛先.getSofubutsuAtesakiSource().get送付物宛先ソース();
        送付物宛先ソースデータ.customerBarCode = new CustomerBarCode().convertCustomerBarCode(
                編集後宛先.get郵便番号(), 編集後宛先.get住所コード().value()).getCustomerBarCode();
        entity.set送付物宛先(送付物宛先ソースデータ);
    }

    private void set通知文(KogakuGassanShikyuKetteiTsuchisho entity) {
        entity.set文書1(get通知文文章(NUM_1, NUM_2));
        entity.set文書2(get通知文文章(NUM_1, NUM_3));
        entity.set文書3(get通知文文章(NUM_2, NUM_3));
        entity.set文書4(get通知文文章(NUM_3, NUM_3));
        entity.set文書5(get通知文文章(NUM_3, NUM_4));
        entity.set文書6(get通知文文章(NUM_4, NUM_3));
        entity.set文書7(get通知文文章(NUM_4, NUM_4));
    }

    private void setKoza(KogakuGassanShikyuKetteiTsuchisho entity, long 口座ID, ShikibetsuCode 識別コード) {
        if (口座ID == 0L) {
            return;
        }
        IKoza 口座;
        ChohyoSeigyoKyotsuManager chohyoSeigyoKyotsuManager = new ChohyoSeigyoKyotsuManager();
        KozaSearchKeyBuilder builder = new KozaSearchKeyBuilder();
        builder.setサブ業務コード(SubGyomuCode.DBC介護給付);
        builder.set業務コード(GyomuCode.DB介護保険);
        builder.set識別コード(識別コード);
        builder.set口座ID(口座ID);
        IKozaManager iKozaManager = KozaService.createKozaManager();
        if (chohyoSeigyoKyotsuManager.get帳票制御共通(SubGyomuCode.DBC介護給付, 通知文情報帳票ID).is口座マスク有無()) {
            口座 = iKozaManager.getマスク済口座(builder.build()).isEmpty() ? null : iKozaManager.getマスク済口座(builder.build()).get(0);
        } else {
            口座 = iKozaManager.get口座(builder.build()).isEmpty() ? null : iKozaManager.get口座(builder.build()).get(0);
        }
        entity.set口座情報(口座);
    }

    private RString get通知文文章(int パターン番号, int 項目番号) {
        TsuchishoTeikeibunFinder finder = new TsuchishoTeikeibunFinder();
        TsuchishoTeikeibun tsuchishoTeikeibun = finder.get通知書定型文_最新適用開始日(SubGyomuCode.DBC介護給付, 通知文情報帳票ID,
                KamokuCode.EMPTY, パターン番号, 項目番号);
        if (tsuchishoTeikeibun != null) {
            return tsuchishoTeikeibun.get文章();
        }
        return RString.EMPTY;
    }
}
