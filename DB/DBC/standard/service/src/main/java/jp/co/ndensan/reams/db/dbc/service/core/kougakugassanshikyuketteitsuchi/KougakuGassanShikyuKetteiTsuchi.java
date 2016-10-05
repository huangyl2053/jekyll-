/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kougakugassanshikyuketteitsuchi;

import jp.co.ndensan.reams.db.dbc.business.report.gassanketteitsuchisho.KogakuGassanShikyuKetteiTsuchishoEntity;
import jp.co.ndensan.reams.db.dbc.business.report.gassanketteitsuchisho.KogakuGassanShikyuKetteiTsuchishoOutputEntity;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigokogakugassan.Kaigogassan_ShikyuFushikyuKubun;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kougakugassanshikyuketteitsuchi.KogakuGassanShikyuKetteiTsuchiParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kougakugassanshikyuketteitsuchi.KougakuGassanShikyuKetteiTsuchiParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kougakugassanshikyuketteitsuchi.KogakuGassanEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kougakugassanshikyuketteitsuchi.IKougakuGassanShikyuKetteiTsuchiMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.core.kanri.JushoHenshu;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedAtesaki;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoHanyoManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoKyotsuManager;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.koza.IKoza;
import jp.co.ndensan.reams.ua.uax.business.core.koza.KozaSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.GyomuKoyuKeyRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.atesaki.IAtesakiGyomuHanteiKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.IKozaSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.service.core.koza.IKozaManager;
import jp.co.ndensan.reams.ua.uax.service.core.koza.KozaManager;
import jp.co.ndensan.reams.ua.uax.service.core.koza.KozaService;
import jp.co.ndensan.reams.ua.uax.service.core.shikibetsutaisho.IShikibetsuTaishoFinder;
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
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * ビジネス設計_DBCMN63003_高額合算支給決定通知書（単）のビジネス。
 *
 * @reamsid_L DBC-2310-030 chenyadong
 */
public class KougakuGassanShikyuKetteiTsuchi {

    private final MapperProvider mapperProvider;
    private static final ReportId 帳票分類ID = new ReportId("DBC100053_GassanKetteiTsuchisho");
    private static final int NUM_1 = 1;
    private static final int NUM_2 = 2;
    private static final int NUM_3 = 3;
    private static final int NUM_4 = 4;
    private static final RString データ有無ある = new RString("0");
    private static final RString データ有無なし = new RString("1");
    private static final RString 取り消し線 = new RString("取り消し線");
    private static final RString 帳票タイトル = new RString("帳票タイトル");
    private static final RString 帳票タイトル_抹消線あり１ = new RString("帳票タイトル_抹消線あり１");
    private static final RString 帳票タイトル_抹消線あり２ = new RString("帳票タイトル_抹消線あり２");
    private static final RString 帳票タイトル_抹消線あり３ = new RString("帳票タイトル_抹消線あり３");
    private static final RString 帳票タイトル_抹消線あり４ = new RString("帳票タイトル_抹消線あり４");
    private static final RString 取り消し線を編集しない = new RString("0");
    private static final RString 取り消し線を編集する = new RString("1");

    /**
     * コンストラクタです。
     */
    public KougakuGassanShikyuKetteiTsuchi() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * にて生成した{@link KougakuGassanShikyuKetteiTsuchi}のインスタンスを返します。
     *
     * @return KougakuGassanShikyuKetteiTsuchi
     */
    public static KougakuGassanShikyuKetteiTsuchi createInstance() {
        return InstanceProvider.create(KougakuGassanShikyuKetteiTsuchi.class);
    }

    /**
     * 事業高額合算情報取得です。
     *
     * @param kogakuParam KogakuGassanShikyuKetteiTsuchiParameter
     * @return {@link KogakuGassanShikyuKetteiTsuchisho}
     */
    public KogakuGassanShikyuKetteiTsuchishoOutputEntity editKougakugassanShikyuketteiTsuuchisho(
            KogakuGassanShikyuKetteiTsuchiParameter kogakuParam) {
        KogakuGassanShikyuKetteiTsuchishoOutputEntity target = new KogakuGassanShikyuKetteiTsuchishoOutputEntity();
        RString データ有無 = データ有無ある;
        IShikibetsuTaishoPSMSearchKey searchKey = new ShikibetsuTaishoPSMSearchKeyBuilder(
                GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先).
                setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード).
                set基準日(kogakuParam.get発行日()).
                build();
        KougakuGassanShikyuKetteiTsuchiParameter param = new KougakuGassanShikyuKetteiTsuchiParameter(searchKey);
        param.set対象年度(kogakuParam.get対象年度());
        param.set履歴番号(kogakuParam.get履歴番号());
        param.set被保険者番号(kogakuParam.get被保険者番号());
        param.set連絡票整理番号(kogakuParam.get連絡票整理番号());
        IKougakuGassanShikyuKetteiTsuchiMapper mapper = mapperProvider.create(IKougakuGassanShikyuKetteiTsuchiMapper.class);
        KogakuGassanEntity kogakuGassanEntity = mapper.select高額合算(param);
        KogakuGassanShikyuKetteiTsuchishoEntity entity = new KogakuGassanShikyuKetteiTsuchishoEntity();
        if (kogakuGassanEntity == null) {
            target.setデータ有無(データ有無なし);
            return target;
        } else {
            entity.set高額合算支給不支給決定(kogakuGassanEntity.get高額合算支給不支給決定());
        }
        RString 被保険者氏名 = RString.EMPTY;
        IShikibetsuTaishoFinder 識別対象Finder = ShikibetsuTaishoService.getShikibetsuTaishoFinder();
        IShikibetsuTaisho 識別対象 = 識別対象Finder.get識別対象(GyomuCode.DB介護保険,
                kogakuParam.get識別コード(), KensakuYusenKubun.住登外優先);
        if (null != 識別対象 && null != 識別対象.get名称()) {
            被保険者氏名 = 識別対象.get名称().getName().getColumnValue();
        }
        entity.set被保険者氏名(被保険者氏名);
        ChohyoSeigyoHanyoManager manager = new ChohyoSeigyoHanyoManager();
        ChohyoSeigyoHanyo 帳票制御汎用_取り消し線
                = manager.get帳票制御汎用(SubGyomuCode.DBC介護給付, 帳票分類ID, FlexibleYear.MIN, 取り消し線);
        ChohyoSeigyoHanyo 帳票制御汎用_帳票タイトル
                = manager.get帳票制御汎用(SubGyomuCode.DBC介護給付, 帳票分類ID, FlexibleYear.MIN, 帳票タイトル);
        ChohyoSeigyoHanyo 帳票制御汎用_帳票タイトル_抹消線あり１
                = manager.get帳票制御汎用(SubGyomuCode.DBC介護給付, 帳票分類ID, FlexibleYear.MIN, 帳票タイトル_抹消線あり１);
        ChohyoSeigyoHanyo 帳票制御汎用_帳票タイトル_抹消線あり２
                = manager.get帳票制御汎用(SubGyomuCode.DBC介護給付, 帳票分類ID, FlexibleYear.MIN, 帳票タイトル_抹消線あり２);
        ChohyoSeigyoHanyo 帳票制御汎用_帳票タイトル_抹消線あり３
                = manager.get帳票制御汎用(SubGyomuCode.DBC介護給付, 帳票分類ID, FlexibleYear.MIN, 帳票タイトル_抹消線あり３);
        ChohyoSeigyoHanyo 帳票制御汎用_帳票タイトル_抹消線あり４
                = manager.get帳票制御汎用(SubGyomuCode.DBC介護給付, 帳票分類ID, FlexibleYear.MIN, 帳票タイトル_抹消線あり４);
        if (取り消し線を編集しない.equals(帳票制御汎用_取り消し線.get設定値())) {
            entity.setTitle(帳票制御汎用_帳票タイトル.get設定値());
        } else if (取り消し線を編集する.equals(帳票制御汎用_取り消し線.get設定値())) {
            entity.setTitle21(帳票制御汎用_帳票タイトル_抹消線あり１.get設定値());
            entity.setTitle24(帳票制御汎用_帳票タイトル_抹消線あり４.get設定値());
            if (Kaigogassan_ShikyuFushikyuKubun.支給.getコード().equals(kogakuGassanEntity.get高額合算支給不支給決定()
                    .getShikyuKubunCode())) {
                entity.setTitle221(帳票制御汎用_帳票タイトル_抹消線あり２.get設定値());
                entity.setTitle222(RString.EMPTY);
                entity.setTitle231(RString.EMPTY);
                entity.setTitle232(帳票制御汎用_帳票タイトル_抹消線あり３.get設定値());
            } else if (Kaigogassan_ShikyuFushikyuKubun.不支給.getコード().equals(kogakuGassanEntity.get高額合算支給不支給決定()
                    .getShikyuKubunCode())) {
                entity.setTitle221(RString.EMPTY);
                entity.setTitle222(帳票制御汎用_帳票タイトル_抹消線あり２.get設定値());
                entity.setTitle231(帳票制御汎用_帳票タイトル_抹消線あり３.get設定値());
                entity.setTitle232(RString.EMPTY);
            }
        }
        entity.set支払予定日(kogakuParam.get支払予定日());
        entity.set文書番号(kogakuParam.get文書番号());
        entity.set発行日(kogakuParam.get発行日());
        entity.set被保険者番号(kogakuParam.get被保険者番号());
        setKoza(entity, kogakuParam.get口座ID(), kogakuParam.get識別コード());
        set通知文(entity);
        set送付物宛先(entity, kogakuParam.get識別コード());
        target.set高額合算支給決定通知書(entity);
        target.setデータ有無(データ有無);
        return target;
    }

    private void set送付物宛先(KogakuGassanShikyuKetteiTsuchishoEntity entity, ShikibetsuCode 識別コード) {
        Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
        IAtesakiGyomuHanteiKey 宛先業務判定キー = AtesakiGyomuHanteiKeyFactory.createInstace(GyomuCode.DB介護保険, SubGyomuCode.DBC介護給付);
        AtesakiPSMSearchKeyBuilder builder = new AtesakiPSMSearchKeyBuilder(宛先業務判定キー);
        builder.set識別コード(識別コード);
        builder.set基準日(FlexibleDate.getNowDate());
        builder.set業務固有キー利用区分(GyomuKoyuKeyRiyoKubun.利用しない);
        IAtesaki 宛先 = ShikibetsuTaishoService.getAtesakiFinder().get宛先(builder.build());
        ChohyoSeigyoKyotsu 帳票共通情報
                = new ChohyoSeigyoKyotsuManager().get帳票制御共通(SubGyomuCode.DBC介護給付, 帳票分類ID);
        EditedAtesaki 編集後宛先 = JushoHenshu.create編集後宛先(宛先, 地方公共団体, 帳票共通情報);
        SofubutsuAtesakiSource 送付物宛先 = null;
        if (編集後宛先 != null && 編集後宛先.getSofubutsuAtesakiSource() != null) {
            送付物宛先 = 編集後宛先.getSofubutsuAtesakiSource().get送付物宛先ソース();
        }
        if (送付物宛先 != null) {
            送付物宛先.customerBarCode = ReportUtil.getCustomerBarCode(送付物宛先.yubinNo, 送付物宛先.jusho1);
        }
        entity.set送付物宛先(送付物宛先);
    }

    private void set通知文(KogakuGassanShikyuKetteiTsuchishoEntity entity) {
        entity.set文書1(get通知文文章(NUM_1, NUM_2));
        entity.set文書2(get通知文文章(NUM_1, NUM_3));
        entity.set文書3(get通知文文章(NUM_2, NUM_3));
        entity.set文書4(get通知文文章(NUM_3, NUM_3));
        entity.set文書5(get通知文文章(NUM_3, NUM_4));
        entity.set文書6(get通知文文章(NUM_4, NUM_3));
        entity.set文書7(get通知文文章(NUM_4, NUM_4));
    }

    private RString get通知文文章(int パターン番号, int 項目番号) {
        TsuchishoTeikeibunFinder finder = new TsuchishoTeikeibunFinder();
        TsuchishoTeikeibun tsuchishoTeikeibun = finder.get通知書定型文_最新適用開始日(SubGyomuCode.DBC介護給付, 帳票分類ID,
                KamokuCode.EMPTY, パターン番号, 項目番号);
        if (tsuchishoTeikeibun != null) {
            return tsuchishoTeikeibun.get文章();
        }
        return RString.EMPTY;
    }

    private void setKoza(KogakuGassanShikyuKetteiTsuchishoEntity entity, long 口座ID, ShikibetsuCode 識別コード) {
        IKoza 口座;
        ChohyoSeigyoKyotsuManager chohyoSeigyoKyotsuManager = new ChohyoSeigyoKyotsuManager();
        IKozaSearchKey searchKey = new KozaSearchKeyBuilder().setサブ業務コード(SubGyomuCode.DBC介護給付)
                .set業務コード(GyomuCode.DB介護保険).set識別コード(識別コード).set口座ID(口座ID).build();
        IKozaManager iKozaManager = KozaService.createKozaManager();
        if (chohyoSeigyoKyotsuManager.get帳票制御共通(SubGyomuCode.DBC介護給付, 帳票分類ID).is口座マスク有無()) {
            口座 = KozaManager.createInstance().getマスク済口座(searchKey).isEmpty() ? null
                    : KozaManager.createInstance().getマスク済口座(searchKey).get(0);
        } else {
            口座 = iKozaManager.get口座(searchKey).isEmpty() ? null : iKozaManager.get口座(searchKey).get(0);
        }
        entity.set口座情報(口座);
    }
}
