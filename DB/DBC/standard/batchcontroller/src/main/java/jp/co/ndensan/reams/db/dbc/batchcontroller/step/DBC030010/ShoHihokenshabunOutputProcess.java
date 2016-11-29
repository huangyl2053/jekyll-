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
import jp.co.ndensan.reams.db.dbc.business.report.shokanketteitsuchishohihokenshabun.ShokanKetteiTsuchiShoHihokenshabunItem;
import jp.co.ndensan.reams.db.dbc.business.report.shokanketteitsuchishohihokenshabun.ShokanKetteiTsuchiShoHihokenshabunReport;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.shokanketteitsuchishosealer.ShokanKetteiTsuchiShoSealerBatchParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shokanketteitsuchishoikkatsu.ShokanKetteiTsuchiShoKetteiTsuchiIchiranParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanketteitsuchishoshiharai.ShokanKetteiTsuchiShoShiharaiRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.shokanketteitsuchishoshiharaiyotei.ShokanKetteiTsuchiShoHihokenshabunReportSource;
import jp.co.ndensan.reams.db.dbc.service.core.shokanbaraiskkttcsrysmuke.ShokanBaraiShikyuKetteiTsuchishoRiyoshamuke;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakukubun.ShikakuKubun;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoHanyoManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoKyotsuManager;
import jp.co.ndensan.reams.ua.uax.business.core.koza.KozaSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.DainoRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.GyomuKoyuKeyRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.SofusakiRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.atesaki.IAtesakiGyomuHanteiKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.IKozaSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ur.urc.business.core.shunokamoku.shunokamoku.IShunoKamoku;
import jp.co.ndensan.reams.ur.urc.definition.core.shunokamoku.shunokamoku.ShunoKamokuShubetsu;
import jp.co.ndensan.reams.ur.urc.service.core.shunokamoku.authority.ShunoKamokuAuthority;
import jp.co.ndensan.reams.ur.urc.service.core.shunokamoku.kamoku.ShunoKamokuFinder;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * DBC100005_償還払支給（不支給）決定通知書（受領委任払い・被保険者用）を出力します。
 *
 * @reamsid_L DBC-1000-020 zuotao
 */
public class ShoHihokenshabunOutputProcess extends BatchProcessBase<ShokanKetteiTsuchiShoShiharaiRelateEntity> {

    private static final RString 帳票取得SQL = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "shokanketteitsuchishoikkatsusakusei.IShokanKetteiTsuchiShoIkkatsuSakuseiMapper.get決定通知一覧表帳票データ");

    List<ShokanKetteiTsuchiShoShiharai> 帳票データリスト = new ArrayList<>();
    ShokanKetteiTsuchiShoSealerBatchParameter batchPram;
    @BatchWriter
    private BatchReportWriter<ShokanKetteiTsuchiShoHihokenshabunReportSource> batchWrite;
    private ReportSourceWriter<ShokanKetteiTsuchiShoHihokenshabunReportSource> reportSourceWriter;
    Map<RString, RString> 種類Map = new HashMap<RString, RString>();
    private static final int ZERO = 0;
    private static final int TEN = 10;
    private static final RString カンマ = new RString("、");
    private static final RString ORDER_BY = new RString("order by");
    private static final RString 帳票制御汎用キー_償還払い支給不支給決定通知書 = new RString("２号発行有無");
    private static final RString 発行有無_発行しない = new RString("0");
    IOutputOrder outputOrder;
    private ChohyoSeigyoKyotsu 帳票制御共通情報;
    private ReportOutputJokenhyoProcessCore outputCore;

    @Override
    protected IBatchReader createReader() {
        outputCore = new ReportOutputJokenhyoProcessCore();
        RString 出力順 = get出力順(ReportIdDBC.DBC100002_2.getReportId(), batchPram.getSyutujunId());
        if (!RString.isNullOrEmpty(出力順)) {
            出力順 = 出力順.replace(ORDER_BY, RString.EMPTY);
        }
        ChohyoSeigyoHanyoManager 帳票制御汎用Manager = new ChohyoSeigyoHanyoManager();
        RString 資格区分 = null;

        ChohyoSeigyoHanyo 帳票制御汎発行有無 = 帳票制御汎用Manager.get帳票制御汎用(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100002_2.getReportId(),
                FlexibleYear.MIN, 帳票制御汎用キー_償還払い支給不支給決定通知書);
        if (帳票制御汎発行有無 != null && 発行有無_発行しない.equals(帳票制御汎発行有無.get設定値())) {
            資格区分 = ShikakuKubun._２号.getコード();
        }
        帳票制御共通情報 = get帳票制御共通情報();
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先), true);
        key.setデータ取得区分(DataShutokuKubun.直近レコード);

        IAtesakiGyomuHanteiKey 宛先業務判定キー = AtesakiGyomuHanteiKeyFactory.createInstace(GyomuCode.DB介護保険, SubGyomuCode.DBC介護給付);
        AtesakiPSMSearchKeyBuilder 宛先builder = new AtesakiPSMSearchKeyBuilder(宛先業務判定キー);
        宛先builder.set業務固有キー利用区分(GyomuKoyuKeyRiyoKubun.利用しない);
        宛先builder.set基準日(batchPram.getHakkoYMD());
        宛先builder.set送付先利用区分(SofusakiRiyoKubun.利用する);
        宛先builder.set代納人利用区分(DainoRiyoKubun.利用しない);
        
        ShikibetsuTaishoPSMSearchKeyBuilder key2 = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先);
        IShikibetsuTaishoPSMSearchKey psmShikibetsuTaisho = key2.build();
        ShunoKamokuFinder 収納科目Finder = ShunoKamokuFinder.createInstance();
        IShunoKamoku 介護給付_償還 = 収納科目Finder.get科目(ShunoKamokuShubetsu.介護給付_償還);
        KamokuCode 科目コード;
        if (介護給付_償還 != null) {
            科目コード = 介護給付_償還.getコード();
        } else {
            科目コード = KamokuCode.EMPTY;
        }
        IKozaSearchKey searchKey = new KozaSearchKeyBuilder()
                .set業務コード(GyomuCode.DB介護保険)
                .setサブ業務コード(SubGyomuCode.DBC介護給付)
                .set科目コード(科目コード)
                .set基準日(FlexibleDate.getNowDate()).build();
        List<KamokuCode> kamokuList = new ShunoKamokuAuthority().
                get参照権限科目コード(UrControlDataFactory.createInstance().getLoginInfo().getUserId());
        
        ShokanKetteiTsuchiShoKetteiTsuchiIchiranParameter parameter
                = ShokanKetteiTsuchiShoKetteiTsuchiIchiranParameter.toMybatisParameter(出力順, 資格区分, psmShikibetsuTaisho,
                        key.getPSM検索キー(), 宛先builder.build(), searchKey, kamokuList);

        return new BatchDbReader(帳票取得SQL, parameter);
    }
    private ChohyoSeigyoKyotsu get帳票制御共通情報() {
        ChohyoSeigyoKyotsuManager chohyoSeigyoKyotsuManager = new ChohyoSeigyoKyotsuManager();
        return chohyoSeigyoKyotsuManager.get帳票制御共通(SubGyomuCode.DBC介護給付,
                new ReportId(ReportIdDBC.DBC100002_2.getReportId().value()));
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
        batchWrite = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC100005.getReportId().value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchWrite);
    }

    @Override
    protected void process(ShokanKetteiTsuchiShoShiharaiRelateEntity entity) {
        ShokanKetteiTsuchiShoShiharai データ = new ShokanKetteiTsuchiShoShiharai(entity);
        RString key = getJufukuKey(データ);
        RString 種類 = データ.get種類() == null ? RString.EMPTY : データ.get種類();
        if (種類Map.containsKey(key)) {
            RString bef種類 = 種類Map.get(key) == null ? RString.EMPTY : 種類Map.get(key);
            if (bef種類.indexOf(種類) == -1) {
                種類Map.put(key, set種類(bef種類, 種類));
            }
        } else {
            帳票データリスト.add(データ);
            種類Map.put(key, 種類);
                    
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
        ShokanBaraiShikyuKetteiTsuchishoRiyoshamuke sbsktr = ShokanBaraiShikyuKetteiTsuchishoRiyoshamuke.createInstance();
        List<ShokanKetteiTsuchiShoHihokenshabunItem> itemList
                = sbsktr.shokanBaraiShikyuKetteiTsuchishoRiyoshamuke(帳票データリスト, batchPram, reportSourceWriter, 種類Map, 帳票制御共通情報);
        ShokanKetteiTsuchiShoHihokenshabunReport report = ShokanKetteiTsuchiShoHihokenshabunReport.createFrom(itemList);
        report.writeBy(reportSourceWriter);
        eucFileOutputJohoFactory();
    }
    private void eucFileOutputJohoFactory() {
        List<RString> 出力条件List = outputCore.get出力条件(batchPram.getBatParmeter(), outputOrder);
        ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                ReportIdDBC.DBC100005.getReportId().value(),
                Association.getLasdecCode().value(),
                AssociationFinderFactory.createInstance().getAssociation().get市町村名(),
                new RString(batchPram.getJobId()),
                ReportIdDBC.DBC100005.getReportName(),
                new RString(reportSourceWriter.pageCount().value()),
                new RString("なし"),
                RString.EMPTY,
                出力条件List);
        OutputJokenhyoFactory.createInstance(reportOutputJokenhyoItem).print();
    }
}
