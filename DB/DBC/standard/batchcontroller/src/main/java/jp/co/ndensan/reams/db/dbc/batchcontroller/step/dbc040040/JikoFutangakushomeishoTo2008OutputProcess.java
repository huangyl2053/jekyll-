/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc040040;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kogakugassan.KogakuGassanData;
import jp.co.ndensan.reams.db.dbc.business.core.kogakugassan.KogakuGassanMeisai;
import jp.co.ndensan.reams.db.dbc.business.report.jikofutangakushomeisho.JikoFutangakushomeishoData;
import jp.co.ndensan.reams.db.dbc.business.report.jikofutangakushomeisho.JikoFutangakushomeishoReport;
import jp.co.ndensan.reams.db.dbc.business.report.jikofutangakushomeisho.JikoFutangakushomeishoShutsuryokujunEnum;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc040040.JikofutanShomeishoProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc040040.JikoFutangakushomeishoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.jikofutangakushomeisho.JikoFutangakushomeishoReportSource;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc040040.IJikofutanShomeishoMapper;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7069KaigoToiawasesakiEntity;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.AtesakiFactory;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.report.parts.sofubutsuatesaki.SofubutsuAtesakiEditorBuilder;
import jp.co.ndensan.reams.ua.uax.business.report.parts.sofubutsuatesaki.SofubutsuAtesakiSourceBuilder;
import jp.co.ndensan.reams.ua.uax.business.report.parts.util.atesaki.ReportAtesakiEditor;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.ninshosha.Ninshosha;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.NinshoshaSourceBuilderFactory;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.toiawasesaki.ToiawasesakiSource;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.ninshosha.INinshoshaManager;
import jp.co.ndensan.reams.ur.urz.service.core.ninshosha.NinshoshaFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 *
 * 自己負担証明書のprocessクラスです。
 *
 * @reamsid_L DBC-2380-030 pengxingyi
 */
public class JikoFutangakushomeishoTo2008OutputProcess extends BatchKeyBreakBase<JikoFutangakushomeishoEntity> {

    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc040040."
                    + "IJikofutanShomeishoMapper.select自己負担額証明書");
    private static final RString 保険者印_0001 = new RString("0001");
    private static final RString 対象年度区分_1 = new RString("1");
    private static final RString 定数_10 = new RString("10");
    private static final RString 定数_自己負担額証明書 = new RString("自己負担額証明書");
    private static final RString 定数_ORDERBY = new RString("order by");
    private static final int NUM_1 = 1;
    private static final int NUM_3 = 3;
    private static final int NUM_4 = 4;
    private static final int NUM_7 = 7;
    private static final int NUM_12 = 12;
    private IOutputOrder 出力順;
    private JikofutanShomeishoProcessParameter parameter;
    private IJikofutanShomeishoMapper mapper;
    private Ninshosha 認証者;
    private NinshoshaSource 認証者情報;
    private Association 地方公共団体情報;
    private List<KogakuGassanMeisai> 明細List;
    private ToiawasesakiSource 問合せ先情報;

    @BatchWriter
    private BatchReportWriter<JikoFutangakushomeishoReportSource> batchReportWriter;
    private ReportSourceWriter<JikoFutangakushomeishoReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        mapper = getMapper(IJikofutanShomeishoMapper.class);
        DbT7069KaigoToiawasesakiEntity toiawasesakiEntity = mapper.select問合せ先();
        if (toiawasesakiEntity != null) {
            問合せ先情報 = get問合せ先情報(toiawasesakiEntity);
        }
        明細List = get明細List();
        INinshoshaManager ninshoshaManager = NinshoshaFinderFactory.createInstance();
        認証者 = ninshoshaManager.get帳票認証者(GyomuCode.DB介護保険, 保険者印_0001);
        地方公共団体情報 = AssociationFinderFactory.createInstance().getAssociation();
        parameter.set対象年度区分(対象年度区分_1);
        if (parameter.get出力順ID() != 0L) {
            IChohyoShutsuryokujunFinder iChohyoShutsuryokujunFinder = ChohyoShutsuryokujunFinderFactory.createInstance();
            出力順 = iChohyoShutsuryokujunFinder.get出力順(SubGyomuCode.DBC介護給付,
                    ReportIdDBC.DBC200035.getReportId(), parameter.get出力順ID());
            if (出力順 != null) {
                parameter.set出力順(MyBatisOrderByClauseCreator.create(
                        JikoFutangakushomeishoShutsuryokujunEnum.class, 出力順).replace(定数_ORDERBY, RString.EMPTY));
            }
        } else {
            parameter.set出力順(null);
        }
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toMybatisParameter());
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC100050.getReportId().value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
        認証者情報 = NinshoshaSourceBuilderFactory.createInstance(認証者, 地方公共団体情報,
                reportSourceWriter.getImageFolderPath(), RDate.getNowDate()).buildSource();
    }

    @Override
    protected void keyBreakProcess(JikoFutangakushomeishoEntity entity) {
        if (isBreak(entity)) {
            IAtesaki atesaki = AtesakiFactory.createInstance(getBefore().get宛先());
            ReportAtesakiEditor editor = new SofubutsuAtesakiEditorBuilder(atesaki).build();
            SofubutsuAtesakiSource compSofubutsuAtesakiソース = new SofubutsuAtesakiSourceBuilder(editor).buildSource();
            KogakuGassanData 高額合算データ = getKogakuGassanData(getBefore());
            高額合算データ.set明細List(明細List);
            JikoFutangakushomeishoData data = new JikoFutangakushomeishoData();
            data.set問合せ先情報(問合せ先情報);
            data.set宛先情報(compSofubutsuAtesakiソース);
            data.set認証者情報(認証者情報);
            data.set文書番号(parameter.get文書情報());
            data.set高額合算データ(高額合算データ);
            data.setタイトル(定数_自己負担額証明書);
            JikoFutangakushomeishoReport report = new JikoFutangakushomeishoReport(data);
            report.writeBy(reportSourceWriter);
            明細List = get明細List();
        }
    }

    @Override
    protected void usualProcess(JikoFutangakushomeishoEntity entity) {
        for (KogakuGassanMeisai item : 明細List) {
            if (item.get対象月().equals(entity.get高額合算自己負担額明細().getTaishoM())) {
                item.set自己負担額(entity.get高額合算自己負担額明細().getJikoFutanGaku());
                item.set単70_74自己負担額_内数(entity.get高額合算自己負担額明細().getUchisu_70_74JikoFutanGaku());
                item.set摘要(entity.get高額合算自己負担額明細().getTekiyo());
            }
        }
    }

    @Override
    protected void afterExecute() {
        if (getBefore() != null) {
            IAtesaki atesaki = AtesakiFactory.createInstance(getBefore().get宛先());
            ReportAtesakiEditor editor = new SofubutsuAtesakiEditorBuilder(atesaki).build();
            SofubutsuAtesakiSource compSofubutsuAtesakiソース = new SofubutsuAtesakiSourceBuilder(editor).buildSource();
            KogakuGassanData 高額合算データ = getKogakuGassanData(getBefore());
            高額合算データ.set明細List(明細List);
            JikoFutangakushomeishoData data = new JikoFutangakushomeishoData();
            data.set問合せ先情報(問合せ先情報);
            data.set宛先情報(compSofubutsuAtesakiソース);
            data.set認証者情報(認証者情報);
            data.set文書番号(parameter.get文書情報());
            data.set高額合算データ(高額合算データ);
            data.setタイトル(定数_自己負担額証明書);
            JikoFutangakushomeishoReport report = new JikoFutangakushomeishoReport(data);
            report.writeBy(reportSourceWriter);
        }
    }

    private boolean isBreak(JikoFutangakushomeishoEntity currentEntity) {
        JikoFutangakushomeishoEntity beforeEntity = getBefore();
        return !beforeEntity.get高額合算自己負担額明細().getHihokenshaNo().equals(currentEntity.get高額合算自己負担額明細().getHihokenshaNo())
                || !beforeEntity.get高額合算自己負担額明細().getTaishoNendo().equals(currentEntity.get高額合算自己負担額明細().getTaishoNendo())
                || !beforeEntity.get高額合算自己負担額明細().getHokenshaNo().equals(currentEntity.get高額合算自己負担額明細().getHokenshaNo())
                || !beforeEntity.get高額合算自己負担額明細().getShikyuShinseishoSeiriNo().
                equals(currentEntity.get高額合算自己負担額明細().getShikyuShinseishoSeiriNo());
    }

    private KogakuGassanData getKogakuGassanData(JikoFutangakushomeishoEntity entity) {
        KogakuGassanData 高額合算データ = new KogakuGassanData();
        高額合算データ.set被保険者番号(entity.get高額合算一時().getHihokenshaNo());
        高額合算データ.set対象年度(entity.get高額合算一時().getTaishoNendo());
        高額合算データ.set保険者番号(new LasdecCode(entity.get高額合算一時().getHokenshaNo().getColumnValue()));
        高額合算データ.set保険者名(entity.get高額合算一時().getJikoFutanGaku_HokenshaMei());
        高額合算データ.set支給申請書整理番号(entity.get高額合算一時().getShikyuShinseishoSeiriNo());
        高額合算データ.set対象計算期間開始年月日(entity.get高額合算一時().getTaishoKeisanKaishiYMD());
        高額合算データ.set対象計算期間終了年月日(entity.get高額合算一時().getTaishoKeisanShuryoYMD());
        高額合算データ.set被保険者氏名カナ(entity.get高額合算一時().getAtena_HihokenshaKanaShimei());
        高額合算データ.set被保険者氏名(entity.get高額合算一時().getAtena_HihokenshaShimei());
        高額合算データ.set生年月日(entity.get高額合算一時().getAtena_SeinengappiYMD());
        高額合算データ.set性別(Gender.toValue(entity.get高額合算一時().getAtena_Seibetsu()));
        高額合算データ.set自己負担額証明書整理番号(entity.get高額合算一時().getJikoFutanGaku_JikoFutanSeiriNo());
        高額合算データ.set被保険者期間開始年月日(entity.get高額合算一時().getJikoFutanGaku_HihokenshaKaishiYMD());
        高額合算データ.set被保険者期間終了年月日(entity.get高額合算一時().getJikoFutanGaku_HihokenshaShuryoYMD());
        高額合算データ.set合計_自己負担額(entity.get高額合算一時().getJikoFutanGaku_Gokei_JikoFutanGaku());
        高額合算データ.set合計_70_74自己負担額_内訳(entity.get高額合算一時().getJikoFutanGaku_Gokei_70_74JikoFutanGaku());
        高額合算データ.set補正済_合計_自己負担額(entity.get高額合算一時().getJikoFutanGaku_Sumi_Gokei_JikoFutanGaku());
        高額合算データ.set補正済_合計_70_74自己負担額_内訳(entity.get高額合算一時().getJikoFutanGaku_Sumi_Gokei_70_74JikoFutanGaku());
        高額合算データ.set識別コード(entity.get高額合算一時().getShikibetsuCode());
        return 高額合算データ;
    }

    private List<KogakuGassanMeisai> get明細List() {
        List<KogakuGassanMeisai> list = new ArrayList<>();
        for (int i = NUM_4; i <= NUM_12; i++) {
            KogakuGassanMeisai kogakuGassanMeisai = new KogakuGassanMeisai();
            kogakuGassanMeisai.set対象月(new RString(i).padZeroToLeft(NUM_3));
            list.add(kogakuGassanMeisai);
        }
        for (int i = NUM_1; i <= NUM_7; i++) {
            KogakuGassanMeisai kogakuGassanMeisai = new KogakuGassanMeisai();
            kogakuGassanMeisai.set対象月(定数_10.concat(new RString(i)));
            list.add(kogakuGassanMeisai);
        }
        return list;
    }

    private ToiawasesakiSource get問合せ先情報(DbT7069KaigoToiawasesakiEntity toiawasesakiEntity) {
        ToiawasesakiSource source = new ToiawasesakiSource();
        YubinNo yubinNo = toiawasesakiEntity.getYubinNo();
        if (yubinNo != null) {
            source.yubinBango = yubinNo.getEditedYubinNo();
        }
        RString choshaName = toiawasesakiEntity.getChoshaName();
        if (choshaName != null && !RString.isNullOrEmpty(choshaName)) {
            source.choshaBushoName = choshaName.concat(RString.FULL_SPACE).concat(toiawasesakiEntity.getBushoName());
        }
        source.shozaichi = toiawasesakiEntity.getShozaichi();
        source.tantoName = toiawasesakiEntity.getTantoshaName();
        TelNo telNo = toiawasesakiEntity.getTelNo();
        if (telNo != null) {
            source.telNo = telNo.getColumnValue();
        }
        source.naisenNo = toiawasesakiEntity.getNaisenNo();
        return source;
    }

}
