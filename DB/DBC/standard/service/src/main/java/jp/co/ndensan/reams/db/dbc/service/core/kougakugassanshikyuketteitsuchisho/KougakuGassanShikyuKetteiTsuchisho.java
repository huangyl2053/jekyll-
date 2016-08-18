/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kougakugassanshikyuketteitsuchisho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.gassanjigyobunketteitsuchisho.KogakuGassanShikyuKetteiTsuchisho;
import jp.co.ndensan.reams.db.dbc.business.report.gassanjigyobunketteitsuchisho.KougakugassanShikyuketteiTsuuchishoOutputEntity;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kougakugassanshikyuketteitsuchisho.KougakuGassanShikyuKetteiTsuchishoParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kougakugassanshikyuketteitsuchisho.JigyoKogakuGassanEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kougakugassanshikyuketteitsuchisho.KozaJyohoEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kougakugassanshikyuketteitsuchisho.IKougakuGassanShikyuKetteiTsuchishoMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoHanyoManager;
import jp.co.ndensan.reams.ua.uax.business.core.koza.Koza;
import jp.co.ndensan.reams.ua.uax.business.core.koza.KozaSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.service.core.koza.IKozaManager;
import jp.co.ndensan.reams.ua.uax.service.core.koza.KozaService;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.ux.uxx.business.core.tsuchishoteikeibun.TsuchishoTeikeibun;
import jp.co.ndensan.reams.ux.uxx.service.core.tsuchishoteikeibun.TsuchishoTeikeibunFinder;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
    private static final RString 定数_0 = new RString("0");
    private static final RString 定数_1 = new RString("1");
    private static final RString 項目名_取り消し線 = new RString("取り消し線");
    private static final RString 項目名_帳票タイトル = new RString("帳票タイトル");
// TO DO
//    private static final RString 項目名_帳票タイトル_抹消線あり１ = new RString("帳票タイトル_抹消線あり１");
//    private static final RString 項目名_帳票タイトル_抹消線あり２ = new RString("帳票タイトル_抹消線あり２");
//    private static final RString 項目名_帳票タイトル_抹消線あり３ = new RString("帳票タイトル_抹消線あり３");
//    private static final RString 項目名_帳票タイトル_抹消線あり４ = new RString("帳票タイトル_抹消線あり４");

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
     * 口座情報取得です。
     *
     * @param 口座ID 口座ID
     * @return {@link Koza}
     */
    public Koza getKozaJyoho(long 口座ID) {
        KougakuGassanShikyuKetteiTsuchishoParameter param = new KougakuGassanShikyuKetteiTsuchishoParameter();
        param.set口座ID(口座ID);
        IKougakuGassanShikyuKetteiTsuchishoMapper mapper = mapperProvider.create(IKougakuGassanShikyuKetteiTsuchishoMapper.class);
        List<KozaJyohoEntity> list = mapper.getKozaJyoho(param);
        if (list.isEmpty()) {
            return null;
        }
        KozaSearchKeyBuilder builder = new KozaSearchKeyBuilder();
        List<RString> 業務固有キーリスト = new ArrayList<>();
        業務固有キーリスト.add(list.get(0).get業務固有キー());
        builder.setサブ業務コード(list.get(0).getサブ業務コード());
        builder.set業務コード(list.get(0).get業務コード());
        builder.set科目コード(list.get(0).get科目コード());
        builder.set業務固有キーリスト(業務固有キーリスト);
        builder.set用途区分(list.get(0).get用途区分());
        IKozaManager iKozaManager = KozaService.createKozaManager();
        return iKozaManager.get口座(builder.build()).isEmpty() ? null : iKozaManager.get口座(builder.build()).get(0);
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
     * @param 口座情報 口座情報
     * @return {@link KogakuGassanShikyuKetteiTsuchisho}
     */
    public KougakugassanShikyuketteiTsuuchishoOutputEntity editKougakugassanShikyuketteiTsuuchisho(ShikibetsuCode 識別コード,
            HihokenshaNo 被保険者番号, ReportId 帳票ID, FlexibleYear 対象年度, RString 連絡票整理番号, int 履歴番号, RString 文書番号,
            FlexibleDate 発行日, FlexibleDate 支払予定日, Koza 口座情報) {
        RString データ有無 = 定数_0;
        KougakuGassanShikyuKetteiTsuchishoParameter param = new KougakuGassanShikyuKetteiTsuchishoParameter();
        param.set対象年度(対象年度);
        param.set履歴番号(履歴番号);
        param.set被保険者番号(被保険者番号);
        param.set連絡票整理番号(連絡票整理番号);
        IKougakuGassanShikyuKetteiTsuchishoMapper mapper = mapperProvider.create(IKougakuGassanShikyuKetteiTsuchishoMapper.class);
        JigyoKogakuGassanEntity jigyoKogakuGassanEntity = mapper.select事業高額合算(param);
        KogakuGassanShikyuKetteiTsuchisho entity = new KogakuGassanShikyuKetteiTsuchisho();
        if (jigyoKogakuGassanEntity == null) {
            データ有無 = 定数_1;
        } else {
            entity.set事業高額合算支給不支給決定(jigyoKogakuGassanEntity.get事業高額合算支給不支給決定());
        }
        ChohyoSeigyoHanyoManager manager = new ChohyoSeigyoHanyoManager();
        ChohyoSeigyoHanyo 帳票制御汎用_取り消し線
                = manager.get帳票制御汎用(SubGyomuCode.DBC介護給付, 通知文情報帳票ID, FlexibleYear.MIN, 項目名_取り消し線);
        ChohyoSeigyoHanyo 帳票制御汎用_帳票タイトル
                = manager.get帳票制御汎用(SubGyomuCode.DBC介護給付, 通知文情報帳票ID, FlexibleYear.MIN, 項目名_帳票タイトル);
// TO DO    QA:95951
//        ChohyoSeigyoHanyo 帳票制御汎用_帳票タイトル_抹消線あり１
//                = manager.get帳票制御汎用(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200201.getReportId(), FlexibleYear.MIN, 項目名_帳票タイトル_抹消線あり１);
//        ChohyoSeigyoHanyo 帳票制御汎用_帳票タイトル_抹消線あり２
//                = manager.get帳票制御汎用(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200201.getReportId(), FlexibleYear.MIN, 項目名_帳票タイトル_抹消線あり２);
//        ChohyoSeigyoHanyo 帳票制御汎用_帳票タイトル_抹消線あり３
//                = manager.get帳票制御汎用(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200201.getReportId(), FlexibleYear.MIN, 項目名_帳票タイトル_抹消線あり３);
//        ChohyoSeigyoHanyo 帳票制御汎用_帳票タイトル_抹消線あり４
//                = manager.get帳票制御汎用(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200201.getReportId(), FlexibleYear.MIN, 項目名_帳票タイトル_抹消線あり４);
        if (定数_0.equals(帳票制御汎用_取り消し線.get設定値())) {
            entity.setTitle(帳票制御汎用_帳票タイトル.get設定値());
        }
        entity.set文書番号(文書番号);
        entity.set発行日(発行日);
        entity.set被保険者番号(被保険者番号);
        entity.set口座情報(口座情報);
        //TO DO   QA:95951
        set通知文(entity);
        set送付物宛先(entity);
        KougakugassanShikyuketteiTsuuchishoOutputEntity target = new KougakugassanShikyuketteiTsuuchishoOutputEntity();
        target.set事業分高額合算支給決定通知書(entity);
        target.setデータ有無(データ有無);
        return target;
    }

    //TO DO   QA:95951
    private void set送付物宛先(KogakuGassanShikyuKetteiTsuchisho entity) {
        SofubutsuAtesakiSource 送付物宛先 = new SofubutsuAtesakiSource();
        送付物宛先.yubinNo = new RString("1000001");
        送付物宛先.gyoseiku = new RString("gyoseiku");
        送付物宛先.jushoText = new RString("jushoText");
        送付物宛先.jusho1 = new RString("jusho1");
        送付物宛先.jusho2 = new RString("jusho2");
//        送付物宛先.jusho3 = new RString("jusho3");
        送付物宛先.katagaki1 = new RString("katagaki1");
        送付物宛先.katagaki2 = new RString("katagaki2");
        送付物宛先.katagakiSmall1 = new RString("katagakiSmall1");
        送付物宛先.katagakiSmall2 = new RString("katagakiSmall2");
        送付物宛先.customerBarCode = new RString("1");
        送付物宛先.dainoKubunMei = new RString("dainoKubunMei");
        送付物宛先.shimeiText = new RString("shimeiText");
        送付物宛先.shimei1 = new RString("shimei1");
        送付物宛先.shimei2 = new RString("shimei2");
        送付物宛先.shimeiSmall1 = new RString("shimeiSmall1");
        送付物宛先.shimeiSmall2 = new RString("shimeiSmall2");
        送付物宛先.samabunShimeiText = new RString("samabunShimeiText");
        送付物宛先.samabunShimei1 = new RString("samabunShimei1");
        送付物宛先.samabunShimei2 = new RString("samabunShimei2");
        送付物宛先.samabunShimeiSmall1 = new RString("samabunShimeiSmall1");
        送付物宛先.samabunShimeiSmall2 = new RString("samabunShimeiSmall2");
        送付物宛先.meishoFuyo1 = new RString("meishoFuyo1");
        送付物宛先.meishoFuyo2 = new RString("meishoFuyo2");
        送付物宛先.samaBun1 = new RString("samaBun1");
        送付物宛先.samaBun2 = new RString("samaBun2");
        送付物宛先.kakkoLeft1 = new RString("kakkoLeft1");
        送付物宛先.kakkoLeft2 = new RString("kakkoLeft2");
        送付物宛先.kakkoRight1 = new RString("kakkoRight1");
        送付物宛先.kakkoRight2 = new RString("kakkoRight2");
        entity.set送付物宛先(送付物宛先);
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

    private RString get通知文文章(int パターン番号, int 項目番号) {
        TsuchishoTeikeibunFinder finder = new TsuchishoTeikeibunFinder();
        TsuchishoTeikeibun tsuchishoTeikeibun = finder.get通知書定型文(SubGyomuCode.DBC介護給付, 通知文情報帳票ID,
                KamokuCode.EMPTY, パターン番号, 項目番号, FlexibleDate.getNowDate());
        if (tsuchishoTeikeibun != null) {
            return tsuchishoTeikeibun.get文章();
        }
        return RString.EMPTY;
    }
}
