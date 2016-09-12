/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.report.honsanteiidou;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.business.report.honsanteiidou.GenNendoHonsanteiIdouProperty;
import jp.co.ndensan.reams.db.dbb.business.report.honsanteiidou.GenNendoHonsanteiIdouReport;
import jp.co.ndensan.reams.db.dbb.business.report.honsanteiidou.KeisanjohoAtenaKozaKouseizengoEntity;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.source.gennendohonsanteiidou.GenNendoHonsanteiIdouSource;
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
 * 本算定異動（現年度）結果一覧表帳票Serviceクラスです
 *
 * @reamsid_L DBB-0930-030 sunhui
 */
public class GenNendoHonsanteiIdouPrintService {

    private final DbT7065ChohyoSeigyoKyotsuDac 帳票制御共通Dac;

    private static final int INDEX_0 = 0;
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;

    private final ReportId 帳票分類Id = new ReportId("DBB200015_HonsanteiIdouKekkaIchiran");

    /**
     * コンストラクタです
     *
     */
    public GenNendoHonsanteiIdouPrintService() {
        this.帳票制御共通Dac = InstanceProvider.create(DbT7065ChohyoSeigyoKyotsuDac.class);
    }

    /**
     * printTaitsuメソッド(単一帳票出力用)
     *
     * @param 更正前後EntityList List<KeisanjohoAtenaKozaKouseizengoEntity>
     * @param 出力順ID Long
     * @param 調定日時 YMDHMS
     * @param 賦課年度 FlexibleYear
     * @return SourceDataCollection
     */
    public SourceDataCollection printTaitsu(List<KeisanjohoAtenaKozaKouseizengoEntity> 更正前後EntityList,
            Long 出力順ID, YMDHMS 調定日時, FlexibleYear 賦課年度) {
        SourceDataCollection collection;
        try (ReportManager reportManager = new ReportManager()) {
            printFukusu(更正前後EntityList, 出力順ID, 調定日時, 賦課年度, reportManager);
            collection = reportManager.publish();
        }
        return collection;
    }

    /**
     * printFukusuメソッド(複数帳票出力用)
     *
     * @param 更正前後EntityList List<KeisanjohoAtenaKozaKouseizengoEntity>
     * @param 出力順ID Long
     * @param 調定日時 YMDHMS
     * @param 賦課年度 FlexibleYear
     * @param reportManager ReportManager
     */
    public void printFukusu(List<KeisanjohoAtenaKozaKouseizengoEntity> 更正前後EntityList,
            Long 出力順ID, YMDHMS 調定日時, FlexibleYear 賦課年度, ReportManager reportManager) {

        GenNendoHonsanteiIdouProperty property = new GenNendoHonsanteiIdouProperty();

        List<RString> 住所編集リスト = new ArrayList<>();
        for (KeisanjohoAtenaKozaKouseizengoEntity entity : 更正前後EntityList) {

            IKojin 宛名情報 = ShikibetsuTaishoFactory.createKojin(entity.get計算後情報_宛名_口座_更正後Entity().get宛名Entity());
            ChohyoSeigyoKyotsu 帳票制御共通 = load帳票制御共通(帳票分類Id);
            RString 住所編集 = JushoHenshu.editJusho(帳票制御共通, 宛名情報, AssociationFinderFactory.createInstance().getAssociation());
            住所編集リスト.add(住所編集);
        }
        IAssociationFinder finder = AssociationFinderFactory.createInstance();
        Association association = finder.getAssociation();
        try (ReportAssembler<GenNendoHonsanteiIdouSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<GenNendoHonsanteiIdouSource> reportSourceWriter = new ReportSourceWriter(assembler);
            IOutputOrder 並び順 = ChohyoShutsuryokujunFinderFactory.createInstance()
                    .get出力順(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB200015.getReportId(), 出力順ID);
            int i = 0;
            RString 並び順の１件目 = RString.EMPTY;
            RString 並び順の２件目 = RString.EMPTY;
            RString 並び順の３件目 = RString.EMPTY;
            RString 並び順の４件目 = RString.EMPTY;
            RString 並び順の５件目 = RString.EMPTY;
            if (並び順 != null) {
                for (ISetSortItem item : 並び順.get設定項目リスト()) {
                    if (i == INDEX_0) {
                        並び順の１件目 = item.get項目名();
                    } else if (i == INDEX_1) {
                        並び順の２件目 = item.get項目名();
                    } else if (i == INDEX_2) {
                        並び順の３件目 = item.get項目名();
                    } else if (i == INDEX_3) {
                        並び順の４件目 = item.get項目名();
                    } else if (i == INDEX_4) {
                        並び順の５件目 = item.get項目名();
                    }
                    i = i + 1;
                }
            }
            new GenNendoHonsanteiIdouReport(
                    更正前後EntityList, 調定日時, 賦課年度, association, 住所編集リスト, 並び順の１件目, 並び順の２件目,
                    並び順の３件目, 並び順の４件目, 並び順の５件目)
                    .writeBy(reportSourceWriter);
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

    private ChohyoSeigyoKyotsu load帳票制御共通(ReportId 帳票分類Id) throws NullPointerException {
        requireNonNull(帳票分類Id, UrSystemErrorMessages.値がnull.getReplacedMessage(帳票分類Id.toString()));
        DbT7065ChohyoSeigyoKyotsuEntity entity = 帳票制御共通Dac.selectByKey(SubGyomuCode.DBB介護賦課, 帳票分類Id);
        if (entity == null) {
            return null;
        }
        return new ChohyoSeigyoKyotsu(entity);
    }

}
