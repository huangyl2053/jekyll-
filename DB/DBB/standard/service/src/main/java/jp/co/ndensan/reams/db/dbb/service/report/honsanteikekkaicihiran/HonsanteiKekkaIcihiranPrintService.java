/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.report.honsanteikekkaicihiran;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.business.report.honsanteikekkaicihiran.HonsanteiKekkaIcihiranProperty;
import jp.co.ndensan.reams.db.dbb.business.report.honsanteikekkaicihiran.HonsanteiKekkaIcihiranReport;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.honnsanteifuka.KeisangojohoAtenaKozaEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.honsanteikekkaicihiran.HonsanteiKekkaIcihiranReportSource;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.core.kanri.JushoHenshu;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7065ChohyoSeigyoKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7065ChohyoSeigyoKyotsuDac;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportProperty;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportAssemblerBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.BreakAggregator;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 「本算定賦課計算」PrintService
 *
 * @reamsid_L DBB-0730-030 lijunjun
 */
public class HonsanteiKekkaIcihiranPrintService {

    private final ReportId 帳票分類Id = new ReportId("DBB200009_HonsanteiKekkaIcihiran");
    private final DbT7065ChohyoSeigyoKyotsuDac 帳票制御共通Dac;

    /**
     * コンストラクタです。
     */
    public HonsanteiKekkaIcihiranPrintService() {
        this.帳票制御共通Dac = InstanceProvider.create(DbT7065ChohyoSeigyoKyotsuDac.class);
    }

    /**
     * printHonsanteiKekkaIcihiraのメソッド
     *
     * @param 計算後情報_宛名_口座EntityList List<KeisangojohoAtenaKozaEntity>
     * @param 賦課年度 FlexibleYear
     * @param 調定日時 YMDHMS
     * @param 出力順ID Long
     * @return SourceDataCollection
     */
    public SourceDataCollection printHonsanteiKekkaIcihira(List<KeisangojohoAtenaKozaEntity> 計算後情報_宛名_口座EntityList,
            FlexibleYear 賦課年度,
            YMDHMS 調定日時,
            Long 出力順ID) {
        IOutputOrder 並び順 = ChohyoShutsuryokujunFinderFactory.createInstance()
                .get出力順(SubGyomuCode.DBB介護賦課, 帳票分類Id, 出力順ID);
        HonsanteiKekkaIcihiranProperty property = new HonsanteiKekkaIcihiranProperty(並び順);

        IAssociationFinder finder = AssociationFinderFactory.createInstance();
        Association association = finder.getAssociation();
        RString 市町村コード = association.get地方公共団体コード().value();
        RString 市町村名 = association.get市町村名();

        List<RString> 出力順項目リスト = get出力順(出力順ID);
        List<RString> 改頁項目リスト = get改頁項目(出力順ID);

        List<RString> 住所編集リスト = new ArrayList<>();
        for (KeisangojohoAtenaKozaEntity entity : 計算後情報_宛名_口座EntityList) {

            IKojin 宛名情報 = ShikibetsuTaishoFactory.createKojin(entity.get宛名Entity());
            ChohyoSeigyoKyotsu 帳票制御共通 = load帳票制御共通(帳票分類Id);
            RString 住所編集 = JushoHenshu.editJusho(帳票制御共通, 宛名情報, AssociationFinderFactory.createInstance().getAssociation());
            住所編集リスト.add(住所編集);
        }

        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<HonsanteiKekkaIcihiranReportSource> assembler = createAssembler(property, reportManager)) {

                ReportSourceWriter<HonsanteiKekkaIcihiranReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
                new HonsanteiKekkaIcihiranReport(
                        計算後情報_宛名_口座EntityList, 賦課年度, 調定日時,
                        市町村コード, 市町村名, 住所編集リスト, 出力順項目リスト, 改頁項目リスト).writeBy(reportSourceWriter);
            }
            return reportManager.publish();
        }

    }

    private static <T extends IReportSource, R extends Report<T>> ReportAssembler<T> createAssembler(
            IReportProperty<T> property, ReportManager manager) {
        ReportAssemblerBuilder builder = manager.reportAssembler(property.reportId().value(), property.subGyomuCode());
        for (BreakAggregator<? super T, ?> breaker : property.breakers()) {
            builder.addBreak(breaker);
        }
        builder.isHojinNo(property.containsHojinNo());
        builder.isKojinNo(property.containsKojinNo());
        return builder.<T>create();
    }

    private List<RString> get出力順(Long 出力順ID) {
        IOutputOrder 並び順 = ChohyoShutsuryokujunFinderFactory.createInstance()
                .get出力順(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB200009.getReportId(), 出力順ID);
        List<RString> 並び順List = new ArrayList<>();
        if (並び順 != null) {
            for (ISetSortItem item : 並び順.get設定項目リスト()) {
                並び順List.add(item.get項目名());
            }
        }
        return 並び順List;
    }

    private List<RString> get改頁項目(Long 出力順ID) {
        IOutputOrder 並び順 = ChohyoShutsuryokujunFinderFactory.createInstance()
                .get出力順(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB200009.getReportId(), 出力順ID);
        List<RString> 改頁項目List = new ArrayList<>();
        if (並び順 != null) {
            for (ISetSortItem item : 並び順.get設定項目リスト()) {
                if (item.is改頁項目()) {
                    改頁項目List.add(item.get項目名());
                }
            }
        }
        return 改頁項目List;
    }

    private ChohyoSeigyoKyotsu load帳票制御共通(ReportId 帳票分類Id) throws NullPointerException {
        requireNonNull(帳票分類Id, UrSystemErrorMessages.値がnull.getReplacedMessage(帳票分類Id.toString()));

        DbT7065ChohyoSeigyoKyotsuEntity entity = 帳票制御共通Dac.selectByKey(SubGyomuCode.DBB介護賦課, 帳票分類Id);
        if (entity == null) {
            return null;
        }
        return new ChohyoSeigyoKyotsu(entity);
    }

}
