/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.report.jutakukaishujizenshinseitsuchisho;

import jp.co.ndensan.reams.db.dbc.business.report.jutakukaishujizenshinseishoninkekkatsuchisho.JutakukaishuJizenShinseiShoninKekkaTsuchishoItem;
import jp.co.ndensan.reams.db.dbc.business.report.jutakukaishujizenshinseishoninkekkatsuchisho.JutakukaishuJizenShinseiShoninKekkaTsuchishoProperty;
import jp.co.ndensan.reams.db.dbc.business.report.jutakukaishujizenshinseishoninkekkatsuchisho.JutakukaishuJizenShinseiShoninKekkaTsuchishoReport;
import jp.co.ndensan.reams.db.dbc.definition.core.jutakukaishujizenshinseitsuchisho.JutakuKaishuJizenShinseiParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jutakukaishujizenshinseitsuchisho.KuJigyoshaEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.jutakukaishujizenshinseishoninkekka.JutakukaishuJizenShinseiShoninKekkaTsuchishoReportSource;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.jutakukaishujizenshinseitsuchisho.IJutakuKaishuJizenShinseiTsuchishoMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.report.parts.sofubutsuatesaki.SofubutsuAtesakiEditorBuilder;
import jp.co.ndensan.reams.ua.uax.business.report.parts.sofubutsuatesaki.SofubutsuAtesakiSourceBuilder;
import jp.co.ndensan.reams.ua.uax.business.report.parts.util.atesaki.ReportAtesakiEditor;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.GyomuKoyuKeyRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.SofusakiRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.atesaki.IAtesakiGyomuHanteiKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.atesaki.IAtesakiPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.service.core.shikibetsutaisho.ShikibetsuTaishoService;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.bunshono.BunshoNo;
import jp.co.ndensan.reams.ur.urz.business.core.ninshosha.Ninshosha;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha._NinshoshaSourceBuilderFactory;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.ur.urz.service.core.bunshono.BunshoNoFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.bunshono.IBunshoNoFinder;
import jp.co.ndensan.reams.ur.urz.service.core.ninshosha.INinshoshaManager;
import jp.co.ndensan.reams.ur.urz.service.core.ninshosha.NinshoshaFinderFactory;
import jp.co.ndensan.reams.ux.uxx.business.core.tsuchishoteikeibun.TsuchishoTeikeibunInfo;
import jp.co.ndensan.reams.ux.uxx.service.core.tsuchishoteikeibun.TsuchishoTeikeibunManager;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 住宅改修事前申請承認結果通知書
 */
public class JutakuKaishuJizenShinseiTsuchishoManager {

    private final MapperProvider mapperProvider;
    private static final ReportId ID = new ReportId("DBC100001_JutakukaishuJizenShinseiShoninKekkaTsuchisho");

    /**
     * コンストラクタです。
     */
    JutakuKaishuJizenShinseiTsuchishoManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);

    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link JutakuKaishuJizenShinseiTsuchishoManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link JutakuKaishuJizenShinseiTsuchishoManager}のインスタンス
     */
    public static JutakuKaishuJizenShinseiTsuchishoManager createInstance() {

        return InstanceProvider.create(JutakuKaishuJizenShinseiTsuchishoManager.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param 受給者台帳Dac
     */
    JutakuKaishuJizenShinseiTsuchishoManager(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * 住宅改修事前申請承認結果通知書帳票作成
     *
     * @param parameter
     * @return {@link SourceDataCollection}
     */
    public SourceDataCollection createJutakuKaishuJizenShinseiTsuchisho(JutakuKaishuJizenShinseiParameter parameter) {

        JutakukaishuJizenShinseiShoninKekkaTsuchishoItem item = createJizenShinseiTsuchishoSource(parameter);
        JutakukaishuJizenShinseiShoninKekkaTsuchishoProperty property
                = new JutakukaishuJizenShinseiShoninKekkaTsuchishoProperty();
        return new Printer<JutakukaishuJizenShinseiShoninKekkaTsuchishoReportSource>().spool(property, toReports(item));
    }

    /**
     * 事前申請承認結果通知書ソース編集
     *
     * @param parameter
     * @return
     */
    public JutakukaishuJizenShinseiShoninKekkaTsuchishoItem createJizenShinseiTsuchishoSource(
            JutakuKaishuJizenShinseiParameter parameter) {

        IBunshoNoFinder finder = BunshoNoFinderFactory.createInstance();
        BunshoNo bunshoNo = finder.get文書番号管理(ID, parameter.get発行日());
        RString hoge = bunshoNo.edit文書番号();

        RString tsuchibun1 = null;
        RString tsuchibun2 = null;
        int koumokuNo = 0;
        TsuchishoTeikeibunManager manager = new TsuchishoTeikeibunManager();
        TsuchishoTeikeibunInfo teikeibun = manager.get通知書定型文パターン(ID, SubGyomuCode.DBC介護給付);
        if (teikeibun != null) {
            koumokuNo = teikeibun.get更新用_パターン番号();
        }
        if (koumokuNo == 1) {
            TsuchishoTeikeibunInfo tsuchishoTeikeibunInfo1 = manager.get通知書定形文検索(SubGyomuCode.DBC介護給付,
                    ID, KamokuCode.EMPTY, koumokuNo, 1, new FlexibleDate(RDate.getNowDate().toDateString()));
            if (tsuchishoTeikeibunInfo1 != null) {
                tsuchibun1 = tsuchishoTeikeibunInfo1.get更新用_文章();
            }
            TsuchishoTeikeibunInfo tsuchishoTeikeibunInfo2 = manager.get通知書定形文検索(SubGyomuCode.DBC介護給付,
                    ID, KamokuCode.EMPTY, koumokuNo, 2, new FlexibleDate(RDate.getNowDate().toDateString()));
            if (tsuchishoTeikeibunInfo2 != null) {
                tsuchibun2 = tsuchishoTeikeibunInfo2.get更新用_文章();
            }
        }

        GyomuKoyuKeyRiyoKubun 業務固有キー利用区分 = GyomuKoyuKeyRiyoKubun.利用しない;
        SofusakiRiyoKubun 送付先利用区分 = SofusakiRiyoKubun.利用する;
        IAtesakiGyomuHanteiKey 宛先業務判定キー
                = AtesakiGyomuHanteiKeyFactory.createInstace(GyomuCode.DB介護保険, SubGyomuCode.DBC介護給付);
        IAtesakiPSMSearchKey searchKey = new AtesakiPSMSearchKeyBuilder(宛先業務判定キー)
                .set識別コード(parameter.get識別コード())
                .set業務固有キー利用区分(業務固有キー利用区分)
                .set送付先利用区分(送付先利用区分)
                .build();
        IAtesaki 宛先 = ShikibetsuTaishoService.getAtesakiFinder().get宛先(searchKey);
        ReportAtesakiEditor reportAtesakiEditor = new SofubutsuAtesakiEditorBuilder(宛先).build();
        SofubutsuAtesakiSource 送付物宛先 = new SofubutsuAtesakiSourceBuilder(reportAtesakiEditor).buildSource();

        IAssociationFinder assfinder = AssociationFinderFactory.createInstance();
        Association association = assfinder.getAssociation();
        INinshoshaManager iNinshoshaManager = NinshoshaFinderFactory.createInstance();
        Ninshosha ninshosha = iNinshoshaManager.get帳票認証者(GyomuCode.DB介護保険,
                NinshoshaDenshikoinshubetsuCode.保険者印.getコード());
        //イメージファイルパス(IReportWriterよりフォルダパス)
        NinshoshaSource 認証者 = _NinshoshaSourceBuilderFactory.createInstance(ninshosha, association,
                RString.EMPTY, new RDate(parameter.get発行日().toString()), 100).buildSource();

        IJutakuKaishuJizenShinseiTsuchishoMapper mapper
                = mapperProvider.create(IJutakuKaishuJizenShinseiTsuchishoMapper.class);
        KuJigyoshaEntity entity = mapper.get事業者情報(parameter);
        if (entity == null) {
            entity = new KuJigyoshaEntity();
        }

        JutakukaishuJizenShinseiShoninKekkaTsuchishoItem item
                = new JutakukaishuJizenShinseiShoninKekkaTsuchishoItem(hoge,
                        new RString("住宅改修事前申請承認結果通知書"),
                        tsuchibun1,
                        parameter.get被保険者氏名(),
                        new RString(parameter.get被保険者番号().toString()),
                        null,
                        parameter.get判定区分(),
                        null,
                        parameter.get不承認理由(),
                        null,
                        null,
                        new RString(entity.getKeiyakuJigyoshaYubinNo().toString()),
                        new RString(entity.getKeiyakuJigyoshaJusho().toString()),
                        new RString(entity.getKeiyakuJigyoshaTelNo().toString()),
                        null,
                        null,
                        null,
                        null,
                        null,
                        tsuchibun2,
                        認証者.hakkoYMD,
                        認証者.denshiKoin,
                        認証者.ninshoshaYakushokuMei,
                        認証者.ninshoshaYakushokuMei1,
                        認証者.koinMojiretsu,
                        認証者.ninshoshaYakushokuMei2,
                        認証者.ninshoshaShimeiKakenai,
                        認証者.ninshoshaShimeiKakeru,
                        認証者.koinShoryaku,
                        送付物宛先.yubinNo,
                        送付物宛先.gyoseiku,
                        送付物宛先.jusho1,
                        送付物宛先.jushoText,
                        送付物宛先.jusho2,
                        送付物宛先.jusho3,
                        送付物宛先.katagakiText,
                        送付物宛先.katagaki1,
                        送付物宛先.katagakiSmall2,
                        送付物宛先.katagaki2,
                        送付物宛先.katagakiSmall1,
                        送付物宛先.shimei1,
                        送付物宛先.shimeiSmall2,
                        送付物宛先.shimeiText,
                        送付物宛先.meishoFuyo2,
                        送付物宛先.shimeiSmall1,
                        送付物宛先.dainoKubunMei,
                        送付物宛先.shimei2,
                        送付物宛先.meishoFuyo1,
                        送付物宛先.samabunShimeiText,
                        送付物宛先.samaBun2,
                        送付物宛先.kakkoLeft2,
                        送付物宛先.samabunShimei2,
                        送付物宛先.samabunShimeiSmall2,
                        送付物宛先.kakkoRight2,
                        送付物宛先.kakkoLeft1,
                        送付物宛先.samabunShimei1,
                        送付物宛先.samaBun1,
                        送付物宛先.kakkoRight1,
                        送付物宛先.samabunShimeiSmall1,
                        送付物宛先.customerBarCode
                );
        return item;
    }

    private JutakukaishuJizenShinseiShoninKekkaTsuchishoReport toReports(
            JutakukaishuJizenShinseiShoninKekkaTsuchishoItem item) {
        return JutakukaishuJizenShinseiShoninKekkaTsuchishoReport.createFrom(item);
    }
}
