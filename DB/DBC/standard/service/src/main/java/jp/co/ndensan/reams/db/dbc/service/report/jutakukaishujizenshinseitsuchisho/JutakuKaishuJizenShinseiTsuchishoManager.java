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
import jp.co.ndensan.reams.uz.uza.math.Decimal;
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
        RString 通知文 = RString.EMPTY;
        RString 注意文 = RString.EMPTY;
        int koumokuNo = 0;
        TsuchishoTeikeibunManager manager = new TsuchishoTeikeibunManager();
        TsuchishoTeikeibunInfo teikeibun
                = manager.get通知書定型文パターン(ReportIdDBC.DBC100001.getReportId(), SubGyomuCode.DBC介護給付);
        if (teikeibun != null) {
            koumokuNo = teikeibun.get更新用_パターン番号();
        }
        if (koumokuNo == 1) {
            TsuchishoTeikeibunInfo tsuchishoTeikeibunInfo = manager.get通知書定形文検索(SubGyomuCode.DBC介護給付,
                    ReportIdDBC.DBC100001.getReportId(), KamokuCode.EMPTY, koumokuNo, 1,
                    new FlexibleDate(RDate.getNowDate().toDateString()));
            if (tsuchishoTeikeibunInfo != null) {
                通知文 = tsuchishoTeikeibunInfo.getUrT0126TsuchishoTeikeibunEntity().getSentence();
            }
            tsuchishoTeikeibunInfo = manager.get通知書定形文検索(SubGyomuCode.DBC介護給付,
                    ReportIdDBC.DBC100001.getReportId(), KamokuCode.EMPTY, koumokuNo, 2,
                    new FlexibleDate(RDate.getNowDate().toDateString()));
            if (tsuchishoTeikeibunInfo != null) {
                注意文 = tsuchishoTeikeibunInfo.getUrT0126TsuchishoTeikeibunEntity().getSentence();
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
        return 通知書ソースデータ(文書番号, 通知文, 注意文, 送付物宛先, entity, parameter);
    }

    private JutakukaishuJizenShinseiShoninKekkaTsuchishoItem 通知書ソースデータ(RString 文書番号,
            RString 通知文, RString 注意文, SofubutsuAtesakiSource 送付物宛先,
            KuJigyoshaEntity entity, JutakuKaishuJizenShinseiParameter parameter) {
        return new JutakukaishuJizenShinseiShoninKekkaTsuchishoItem(nullTOEmpty(文書番号),
                ReportIdDBC.DBC100001.getReportName(),
                nullTOEmpty(通知文),
                nullTOEmpty(parameter.get被保険者氏名()),
                (parameter.get被保険者番号() == null || parameter.get被保険者番号().isEmpty())
                ? RString.EMPTY : new RString(parameter.get被保険者番号().value().toString()),
                (parameter.get受付日() == null || parameter.get受付日().isEmpty())
                ? RString.EMPTY : new RString(parameter.get受付日().wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN)
                        .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString().toString()),
                nullTOEmpty(parameter.get判定区分()),
                (parameter.get承認年月日() == null || parameter.get承認年月日().isEmpty())
                ? RString.EMPTY : new RString(parameter.get承認年月日().wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN)
                        .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString().toString()),
                new RString("不承認").equals(parameter.get不承認理由()) ? parameter.get不承認理由() : RString.EMPTY,
                nullTOEmpty(parameter.get給付の種類()),
                nullTOEmpty(parameter.get事業者名()),
                (entity == null || entity.getKeiyakuJigyoshaYubinNo().isEmpty())
                ? RString.EMPTY : new RString(entity.getKeiyakuJigyoshaYubinNo().value().toString()),
                (entity == null || entity.getKeiyakuJigyoshaJusho().isEmpty())
                ? RString.EMPTY : new RString(entity.getKeiyakuJigyoshaJusho().value().toString()),
                (entity == null || entity.getKeiyakuJigyoshaTelNo().isEmpty())
                ? RString.EMPTY : new RString(entity.getKeiyakuJigyoshaTelNo().value().toString()),
                nullTOEmpty(parameter.get作成者氏名()),
                nullTOEmpty(parameter.get費用額合計()),
                nullTOEmpty(parameter.get保険対象費用額()),
                nullTOEmpty(parameter.get利用者負担額()),
                nullTOEmpty(parameter.get保険給付額()),
                nullTOEmpty(注意文),
                new RString(parameter.get発行日().toString()),
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                nullTOEmpty(送付物宛先.yubinNo),
                nullTOEmpty(送付物宛先.gyoseiku),
                nullTOEmpty(送付物宛先.jusho1),
                nullTOEmpty(送付物宛先.jushoText),
                nullTOEmpty(送付物宛先.jusho2),
                nullTOEmpty(送付物宛先.jusho3),
                nullTOEmpty(送付物宛先.katagakiText),
                nullTOEmpty(送付物宛先.katagaki1),
                nullTOEmpty(送付物宛先.katagakiSmall2),
                nullTOEmpty(送付物宛先.katagaki2),
                nullTOEmpty(送付物宛先.katagakiSmall1),
                nullTOEmpty(送付物宛先.shimei1),
                nullTOEmpty(送付物宛先.shimeiSmall2),
                nullTOEmpty(送付物宛先.shimeiText),
                nullTOEmpty(送付物宛先.meishoFuyo2),
                nullTOEmpty(送付物宛先.shimeiSmall1),
                nullTOEmpty(送付物宛先.dainoKubunMei),
                nullTOEmpty(送付物宛先.shimei2),
                nullTOEmpty(送付物宛先.meishoFuyo1),
                nullTOEmpty(送付物宛先.samabunShimeiText),
                nullTOEmpty(送付物宛先.samaBun2),
                nullTOEmpty(送付物宛先.kakkoLeft2),
                nullTOEmpty(送付物宛先.samabunShimei2),
                nullTOEmpty(送付物宛先.samabunShimeiSmall2),
                nullTOEmpty(送付物宛先.kakkoRight2),
                nullTOEmpty(送付物宛先.kakkoLeft1),
                nullTOEmpty(送付物宛先.samabunShimei1),
                nullTOEmpty(送付物宛先.samaBun1),
                nullTOEmpty(送付物宛先.kakkoRight1),
                nullTOEmpty(送付物宛先.samabunShimeiSmall1),
                nullTOEmpty(送付物宛先.customerBarCode)
        );
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

    /**
     * 空値判断
     *
     * @param 項目 項目
     * @return RString
     */
    private RString nullTOEmpty(RString 項目) {
        if (項目 == null) {
            return RString.EMPTY;
        }
        return 項目;
    }

    /**
     * 空値判断
     *
     * @param 項目 項目
     * @return Decimal
     */
    private RString nullTOEmpty(Decimal 項目) {
        if (項目 == null) {
            return RString.EMPTY;
        }
        return new RString((項目).toString());
    }
}
