/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.report.jutakukaishujizenshinseitsuchisho;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.jutakukaishujizenshinseishoninkekkatsuchisho.JutakukaishuJizenShinseiShoninKekkaTsuchishoItem;
import jp.co.ndensan.reams.db.dbc.definition.core.jutakukaishujizenshinseitsuchisho.JutakuKaishuJizenShinseiParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jutakukaishujizenshinseitsuchisho.KuJigyoshaEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.jutakukaishujizenshinseitsuchisho.IJutakuKaishuJizenShinseiTsuchishoMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbc.service.report.jutakukaishujizenshinseishoninkekkatsuchisho.JutakukaishuJizenShinseiShoninKekkaTsuchishoService;
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
import jp.co.ndensan.reams.ur.urz.business.core.bunshono.BunshoNo;
import jp.co.ndensan.reams.ur.urz.business.core.bunshono.BunshoNoHatsubanHoho;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.ur.urz.service.core.bunshono.BunshoNoFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.bunshono.IBunshoNoFinder;
import jp.co.ndensan.reams.ux.uxx.business.core.tsuchishoteikeibun.TsuchishoTeikeibunInfo;
import jp.co.ndensan.reams.ux.uxx.service.core.tsuchishoteikeibun.TsuchishoTeikeibunManager;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.util.CountedItem;
import jp.co.ndensan.reams.uz.uza.util.Saiban;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 住宅改修事前申請承認結果通知書
 */
public class JutakuKaishuJizenShinseiTsuchishoManager {

    private final MapperProvider mapperProvider;
    private RString 汎用キー_文書番号;

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
     * 住宅改修事前申請承認結果通知書帳票作成
     *
     * @param parameter parameter
     */
    public void createJutakuKaishuJizenShinseiTsuchisho(JutakuKaishuJizenShinseiParameter parameter) {

        JutakukaishuJizenShinseiShoninKekkaTsuchishoItem item
                = createJizenShinseiTsuchishoSource(parameter);
        new JutakukaishuJizenShinseiShoninKekkaTsuchishoService().print(item);
    }

    /**
     * 事前申請承認結果通知書ソース編集
     *
     * @param parameter parameter
     * @return JutakukaishuJizenShinseiShoninKekkaTsuchishoItem
     */
    public JutakukaishuJizenShinseiShoninKekkaTsuchishoItem createJizenShinseiTsuchishoSource(
            JutakuKaishuJizenShinseiParameter parameter) {

        IBunshoNoFinder finder = BunshoNoFinderFactory.createInstance();
        BunshoNo bunshoNo = finder.get文書番号管理(ReportIdDBC.DBC100001.getReportId(), parameter.get発行日());
        RString 文書番号 = RString.EMPTY;
        if (bunshoNo != null) {
            文書番号 = get文書番号(bunshoNo);
        }
        RString 通知文 = null;
        RString 注意文 = null;
        int koumokuNo = 0;
        TsuchishoTeikeibunManager manager = new TsuchishoTeikeibunManager();
        TsuchishoTeikeibunInfo teikeibun
                = manager.get通知書定型文パターン(ReportIdDBC.DBC100001.getReportId(), SubGyomuCode.DBC介護給付);
        if (teikeibun != null) {
            koumokuNo = teikeibun.get更新用_パターン番号();
        }
        if (koumokuNo == 1) {
            TsuchishoTeikeibunInfo tsuchishoTeikeibunInfo1 = manager.get通知書定形文検索(SubGyomuCode.DBC介護給付,
                    ReportIdDBC.DBC100001.getReportId(), KamokuCode.EMPTY, koumokuNo, 1,
                    new FlexibleDate(RDate.getNowDate().toDateString()));
            if (tsuchishoTeikeibunInfo1 != null) {
                通知文 = tsuchishoTeikeibunInfo1.getUrT0126TsuchishoTeikeibunEntity().getSentence();
            }
            TsuchishoTeikeibunInfo tsuchishoTeikeibunInfo2 = manager.get通知書定形文検索(SubGyomuCode.DBC介護給付,
                    ReportIdDBC.DBC100001.getReportId(), KamokuCode.EMPTY, koumokuNo, 2,
                    new FlexibleDate(RDate.getNowDate().toDateString()));
            if (tsuchishoTeikeibunInfo2 != null) {
                注意文 = tsuchishoTeikeibunInfo2.getUrT0126TsuchishoTeikeibunEntity().getSentence();
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
        List<IAtesaki> 宛先s = ShikibetsuTaishoService.getAtesakiFinder().get宛先s(searchKey);
        ReportAtesakiEditor reportAtesakiEditor = new SofubutsuAtesakiEditorBuilder(宛先s.get(0)).build();
        SofubutsuAtesakiSource 送付物宛先 = new SofubutsuAtesakiSourceBuilder(reportAtesakiEditor).buildSource();
        IJutakuKaishuJizenShinseiTsuchishoMapper mapper
                = mapperProvider.create(IJutakuKaishuJizenShinseiTsuchishoMapper.class);
        KuJigyoshaEntity entity = mapper.get事業者情報(parameter);
        JutakukaishuJizenShinseiShoninKekkaTsuchishoItem item
                = new JutakukaishuJizenShinseiShoninKekkaTsuchishoItem(文書番号,
                        ReportIdDBC.DBC100001.getReportName(),
                        通知文,
                        parameter.get被保険者氏名(),
                        new RString(parameter.get被保険者番号().value().toString()),
                        new RString(parameter.get受付日().wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).
                                separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString().toString()),
                        parameter.get判定区分(),
                        new RString(parameter.get承認年月日().wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).
                                separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString().toString()),
                        new RString("不承認").equals(parameter.get不承認理由()) ? parameter.get不承認理由() : RString.EMPTY,
                        parameter.get給付の種類(),
                        parameter.get事業者名(),
                        new RString(entity.getKeiyakuJigyoshaYubinNo().value().toString()),
                        new RString(entity.getKeiyakuJigyoshaJusho().value().toString()),
                        new RString(entity.getKeiyakuJigyoshaTelNo().value().toString()),
                        parameter.get作成者氏名(),
                        new RString(parameter.get費用額合計().toString()),
                        new RString(parameter.get保険対象費用額().toString()),
                        new RString(parameter.get利用者負担額().toString()),
                        new RString(parameter.get保険給付額().toString()),
                        注意文,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
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

    private RString get文書番号(BunshoNo bushoNo) {
        RString 文書番号 = RString.EMPTY;
        RString 文書番号発番方法 = bushoNo.get文書番号発番方法();
        if (BunshoNoHatsubanHoho.固定.getCode().equalsIgnoreCase(文書番号発番方法)) {
            文書番号 = bushoNo.edit文書番号();
        } else if (BunshoNoHatsubanHoho.手入力.getCode().equalsIgnoreCase(文書番号発番方法)) {
            throw new ApplicationException(UrErrorMessages.実行不可.getMessage().replace("文書番号情報の取得"));
        } else if (BunshoNoHatsubanHoho.自動採番.getCode().equalsIgnoreCase(文書番号発番方法)) {
            CountedItem 採番 = Saiban.get(SubGyomuCode.DBC介護給付, 汎用キー_文書番号,
                    new FlexibleYear(RDate.getNowDate().getYear().toDateString()));
            文書番号 = bushoNo.edit文書番号(採番.nextString());
        }
        return 文書番号;
    }
}
