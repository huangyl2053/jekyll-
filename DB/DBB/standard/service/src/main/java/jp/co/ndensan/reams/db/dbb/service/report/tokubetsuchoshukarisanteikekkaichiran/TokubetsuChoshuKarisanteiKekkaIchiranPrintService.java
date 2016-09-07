/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.report.tokubetsuchoshukarisanteikekkaichiran;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.HokenryoDankai;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukarisanteikekkaIchiran.TokubetsuChoshuKarisanteiKekkaIchiranProperty;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukarisanteikekkaIchiran.TokubetsuChoshuKarisanteiKekkaIchiranReport;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchokarisanteifukamanager.TokuchoKariKeisangoFukaEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukarisanteikekkaIchiran.TokubetsuChoshuKarisanteiKekkaIchiranSource;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.HokenryoDankaiSettings;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.core.kanri.JushoHenshu;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7065ChohyoSeigyoKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7065ChohyoSeigyoKyotsuDac;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
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
 * 帳票設計_DBBRP33001_2_特別徴収仮算定結果一覧表
 *
 * @reamsid_L DBB-0700-030 xuhao
 */
public class TokubetsuChoshuKarisanteiKekkaIchiranPrintService {

    private static final int NUM0 = 0;
    private static final int NUM5 = 5;
    private final ReportId 帳票分類Id = new ReportId("DBB200002_TokubetsuChoshuKarisanteiKekkaIchiran");
    private final DbT7065ChohyoSeigyoKyotsuDac 帳票制御共通Dac;
    private static final ReportId 特別徴収仮算定結果一覧表_帳票分類ID = new ReportId("DBB200002_TokubetsuChoshuKarisanteiKekkaIchiran");

    /**
     * コンストラクタです。
     */
    public TokubetsuChoshuKarisanteiKekkaIchiranPrintService() {
        this.帳票制御共通Dac = InstanceProvider.create(DbT7065ChohyoSeigyoKyotsuDac.class);
    }

    /**
     * printSingle
     *
     * @param 特徴仮算定計算後賦課情報EntityList List<TokuchoKariKeisangoFukaEntity>
     * @param 出力順ID long
     * @param 調定年度 FlexibleYear
     * @param 調定日時 YMDHMS
     * @return SourceDataCollection
     */
    public SourceDataCollection printSingle(List<TokuchoKariKeisangoFukaEntity> 特徴仮算定計算後賦課情報EntityList,
            long 出力順ID, FlexibleYear 調定年度, YMDHMS 調定日時) {
        SourceDataCollection collection;
        try (ReportManager reportManager = new ReportManager()) {
            print(特徴仮算定計算後賦課情報EntityList, 出力順ID, 調定年度, 調定日時, reportManager);
            collection = reportManager.publish();
        }
        return collection;
    }

    /**
     * print
     *
     * @param 特徴仮算定計算後賦課情報EntityList List<TokuchoKariKeisangoFukaEntity>
     * @param 出力順ID Long
     * @param 調定年度 FlexibleYear
     * @param 調定日時 YMDHMS
     * @param reportManager ReportManager
     */
    public void print(
            List<TokuchoKariKeisangoFukaEntity> 特徴仮算定計算後賦課情報EntityList,
            Long 出力順ID, FlexibleYear 調定年度, YMDHMS 調定日時, ReportManager reportManager) {
        IOutputOrder 並び順 = ChohyoShutsuryokujunFinderFactory.createInstance()
                .get出力順(SubGyomuCode.DBB介護賦課, 特別徴収仮算定結果一覧表_帳票分類ID, 出力順ID);
        TokubetsuChoshuKarisanteiKekkaIchiranProperty property
                = new TokubetsuChoshuKarisanteiKekkaIchiranProperty(並び順);
        try (ReportAssembler<TokubetsuChoshuKarisanteiKekkaIchiranSource> assembler = createAssembler(property, reportManager)) {

            List<RString> 並び順List = new ArrayList<>();
            List<RString> 改頁List = new ArrayList<>();
            for (int i = NUM0; i < NUM5; i++) {
                if (i < 並び順.get設定項目リスト().size()) {
                    並び順List.add(並び順.get設定項目リスト().get(i).get項目名());
                    if (並び順.get設定項目リスト().get(i).is改頁項目()) {
                        改頁List.add(並び順.get設定項目リスト().get(i).get項目名());
                    }
                } else {
                    break;
                }
            }
            List<RString> 住所編集リスト = new ArrayList<>();
            List<Decimal> 前年度保険料リスト = new ArrayList<>();
            for (TokuchoKariKeisangoFukaEntity entity : 特徴仮算定計算後賦課情報EntityList) {
                IKojin 宛名情報 = ShikibetsuTaishoFactory.createKojin(entity.get宛名());
                ChohyoSeigyoKyotsu 帳票制御共通 = load帳票制御共通(帳票分類Id);
                RString 住所編集 = JushoHenshu.editJusho(帳票制御共通, 宛名情報,
                        AssociationFinderFactory.createInstance().getAssociation());
                住所編集リスト.add(住所編集);
                HokenryoDankai 保険料段階 = new HokenryoDankaiSettings().getCurrent保険料段階List().getBy段階区分(entity.get前年度保険料段階());
                Decimal 前年度保険料 = 保険料段階.get保険料率();
                前年度保険料リスト.add(前年度保険料);
            }
            IAssociationFinder finder = AssociationFinderFactory.createInstance();
            Association association = finder.getAssociation();
            RString 市町村コード = RString.EMPTY;
            RString 市町村名称 = association.get市町村名();
            if (association.get地方公共団体コード() != null) {
                市町村コード = association.get地方公共団体コード().value();
            }
            ReportSourceWriter<TokubetsuChoshuKarisanteiKekkaIchiranSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);
            new TokubetsuChoshuKarisanteiKekkaIchiranReport(市町村コード, 市町村名称, 特徴仮算定計算後賦課情報EntityList, 調定年度, 調定日時,
                    並び順List, 改頁List, 住所編集リスト, 前年度保険料リスト).writeBy(reportSourceWriter);
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
