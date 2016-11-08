/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC030010;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.shokanketteitsuchishoshiharai.ShokanKetteiTsuchiShoShiharai;
import jp.co.ndensan.reams.db.dbc.business.report.shokanbaraishikyufushikyuketteitsuchiichiran.KetteiTsuchiIchiranOutPutOrder;
import jp.co.ndensan.reams.db.dbc.business.report.shokanketteitsuchishosealer.ShokanKetteiTsuchiShoSealerItem;
import jp.co.ndensan.reams.db.dbc.business.report.shokanketteitsuchishosealer.ShokanKetteiTsuchiShoSealerReport;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.shokanketteitsuchishosealer.ShokanKetteiTsuchiShoSealer;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.shokanketteitsuchishosealer.ShokanKetteiTsuchiShoSealerBatchParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shokanketteitsuchishoikkatsu.ShokanKetteiTsuchiShoKetteiTsuchiIchiranParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanketteitsuchishoshiharai.ShokanKetteiTsuchiShoShiharaiRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.shokanketteitsuchishoshiharaiyotei.ShokanKetteiTsuchiShoSealerReportSource;
import jp.co.ndensan.reams.db.dbc.service.core.shokanbaraishikyuketteitsuchishosealertype.ShokanBaraiShikyuKetteiTsuchishoSealerType1;
import jp.co.ndensan.reams.db.dbc.service.core.shokanbaraishikyuketteitsuchishosealertype.TensoData;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.GyomuKoyuKeyRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.SofusakiRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.atesaki.IAtesakiGyomuHanteiKey;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.ur.urz.service.report.daikoprint.IDaikoPrint;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * DBC100004_償還払支給（不支給）決定通知書（ｼｰﾗﾀｲﾌﾟ）を出力します。
 *
 * @reamsid_L DBC-1000-020 zuotao
 */
public class ShokanKetteiTsuchiShoSealerOutputProcess extends BatchProcessBase<ShokanKetteiTsuchiShoShiharaiRelateEntity> {

    private static final RString 帳票取得SQL = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "shokanketteitsuchishoikkatsusakusei.IShokanKetteiTsuchiShoIkkatsuSakuseiMapper.get決定通知一覧表帳票データ");

    List<ShokanKetteiTsuchiShoShiharai> 帳票データリスト = new ArrayList<>();
    ShokanKetteiTsuchiShoSealerBatchParameter batchPram;
    @BatchWriter
    private BatchReportWriter<ShokanKetteiTsuchiShoSealerReportSource> batchWrite;
    private ReportSourceWriter<ShokanKetteiTsuchiShoSealerReportSource> reportSourceWriter;
    Map<RString, RString> 種類Map = new HashMap<RString, RString>();
    private static final int ZERO = 0;
    private static final int TEN = 10;
    private static final RString カンマ = new RString(",");
    private static final RString ORDER_BY = new RString("order by");
    IOutputOrder outputOrder;

    @Override
    protected IBatchReader createReader() {
        RString 出力順 = get出力順(ReportIdDBC.DBC100002_2.getReportId(), batchPram.getSyutujunId());
        if (!RString.isNullOrEmpty(出力順)) {
            出力順 = 出力順.replace(ORDER_BY, RString.EMPTY);
        }
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先), true);
        key.setデータ取得区分(DataShutokuKubun.直近レコード);

        IAtesakiGyomuHanteiKey 宛先業務判定キー = AtesakiGyomuHanteiKeyFactory.createInstace(GyomuCode.DB介護保険, SubGyomuCode.DBC介護給付);
        AtesakiPSMSearchKeyBuilder 宛先builder = new AtesakiPSMSearchKeyBuilder(宛先業務判定キー);
        宛先builder.set業務固有キー利用区分(GyomuKoyuKeyRiyoKubun.利用しない);
        宛先builder.set基準日(batchPram.getHakkoYMD());
        宛先builder.set送付先利用区分(SofusakiRiyoKubun.利用する);
        ShokanKetteiTsuchiShoKetteiTsuchiIchiranParameter parameter
                = ShokanKetteiTsuchiShoKetteiTsuchiIchiranParameter.toMybatisParameter(出力順,
                        key.getPSM検索キー(), 宛先builder.build());

        return new BatchDbReader(帳票取得SQL, parameter);
    }

     private RString get出力順(ReportId 帳票分類ID, RString 出力順ID) {

        if (RString.isNullOrEmpty(出力順ID)) {
            return RString.EMPTY;
        }
        IChohyoShutsuryokujunFinder fider = ChohyoShutsuryokujunFinderFactory.createInstance();
        outputOrder = fider.get出力順(SubGyomuCode.DBC介護給付, 帳票分類ID, Long.parseLong(出力順ID.toString()));
        if (outputOrder == null) {
            return RString.EMPTY;
        }
        return MyBatisOrderByClauseCreator.create(KetteiTsuchiIchiranOutPutOrder.class, outputOrder);
    }
     
    @Override
    protected void createWriter() {
        batchWrite = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC100004.getReportId().value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchWrite);
    }

    @Override
    protected void process(ShokanKetteiTsuchiShoShiharaiRelateEntity entity) {
        ShokanKetteiTsuchiShoShiharai データ = new ShokanKetteiTsuchiShoShiharai(entity);
        RString key = getJufukuKey(データ);
        if (種類Map.containsKey(key)) {
            RString bef種類 = 種類Map.get(key) == null ? RString.EMPTY : 種類Map.get(key);
            if (bef種類.indexOf(データ.get種類()) == 0) {
                種類Map.put(key, set種類(bef種類, データ.get種類()));
            }
        } else {
            帳票データリスト.add(データ);
            種類Map.put(key, データ.get種類());
                    
        }
    }

    private RString getJufukuKey(ShokanKetteiTsuchiShoShiharai shiharai) {
        RStringBuilder key = new RStringBuilder();
        key.append(shiharai.get被保険者番号().value());
        key.append(shiharai.get提供年月().wareki().toDateString());
        key.append(shiharai.get整理番号().padLeft(new RString(ZERO), TEN));
        return key.toRString();
    }
    private RString set種類(RString kyufuShu, RString 種類) {
        if (RString.isNullOrEmpty(kyufuShu)) {
            return 種類;
        }
        RStringBuilder builder = new RStringBuilder(kyufuShu);
        if (!RString.isNullOrEmpty(種類)) {
            builder.append(カンマ);
            builder.append(種類);
        }
        return builder.toRString();
    }
    @Override
    protected void afterExecute() {
        if (帳票データリスト.isEmpty()) {
            return;
        }
        ShokanBaraiShikyuKetteiTsuchishoSealerType1 ichiranhyo = new ShokanBaraiShikyuKetteiTsuchishoSealerType1();
        TensoData data
                = ichiranhyo.createChoHyoData(帳票データリスト, batchPram, reportSourceWriter, 種類Map);
        IDaikoPrint daikoPrint = data.get代行プリント送付票();
        daikoPrint.print();
        List<ShokanKetteiTsuchiShoSealerItem> itemList = new ArrayList<>();
        for (ShokanKetteiTsuchiShoSealer sealer : data.get帳票ソースデータ()) {
            sealer.setPages(new RString(data.get帳票ソースデータ().size()));
            itemList.add(setShokanKetteiTsuchiShoSealerReport(sealer));
        }
        ShokanKetteiTsuchiShoSealerReport report = ShokanKetteiTsuchiShoSealerReport.createFrom(itemList);
        report.writeBy(reportSourceWriter);
    }

    private ShokanKetteiTsuchiShoSealerItem
            setShokanKetteiTsuchiShoSealerReport(ShokanKetteiTsuchiShoSealer item) {

        return new ShokanKetteiTsuchiShoSealerItem(
                item.getTsuban(),
                item.getTitle1(),
                item.getBunshoNo(),
                item.getPage(),
                item.getPages(),
                item.getTitle(),
                item.getTitle2(),
                item.getHihokenshaName2(),
                item.getHihokenshaNo(),
                item.getHihokenshaName(),
                item.getTsuchibun1(),
                item.getKetteiYMD(),
                item.getShikyuGaku(),
                item.getShiharaiYoteiYMD(),
                item.getKyufuShurui1(),
                item.getTaishoYM1(),
                item.getShikyuGaku1(),
                item.getYen1(),
                item.getInfo(),
                item.getKyufuShurui2(),
                item.getTaishoYM2(),
                item.getShikyuGaku2(),
                item.getYen2(),
                item.getKyufuShurui3(),
                item.getTaishoYM3(),
                item.getShikyuGaku3(),
                item.getYen3(),
                item.getKyufuShurui4(),
                item.getTaishoYM4(),
                item.getShikyuGaku4(),
                item.getYen4(),
                item.getBankName(),
                item.getBranchBankName(),
                item.getShumokuTitle(),
                item.getKouzaShu(),
                item.getBangoTitle(),
                item.getKouzaNo(),
                item.getKouzaMeigi(),
                item.getHakkoYMD(),
                item.getDenshiKoin(),
                item.getNinshoshaYakushokuMei(),
                item.getNinshoshaYakushokuMei1(),
                item.getKoinMojiretsu(),
                item.getNinshoshaYakushokuMei2(),
                item.getNinshoshaShimeiKakenai(),
                item.getNinshoshaShimeiKakeru(),
                item.getKoinShoryaku(),
                item.getYubinNo(),
                item.getGyoseiku1(),
                item.getJusho4(),
                item.getJushoText(),
                item.getJusho5(),
                item.getJusho6(),
                item.getKatagakiText(),
                item.getKatagaki3(),
                item.getKatagakiSmall2(),
                item.getKatagaki4(),
                item.getKatagakiSmall1(),
                item.getShimei5(),
                item.getShimeiSmall2(),
                item.getShimeiText(),
                item.getMeishoFuyo2(),
                item.getShimeiSmall1(),
                item.getDainoKubunMei(),
                item.getShimei6(),
                item.getMeishoFuyo1(),
                item.getSamabunShimeiText(),
                item.getSamaBun2(),
                item.getKakkoLeft2(),
                item.getSamabunShimei2(),
                item.getSamabunShimeiSmall2(),
                item.getKakkoRight2(),
                item.getKakkoLeft1(),
                item.getSamabunShimei1(),
                item.getSamaBun1(),
                item.getKakkoRight1(),
                item.getSamabunShimeiSmall1(),
                item.getCustomerBarCode());
    }
}
