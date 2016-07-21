/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.homonchosairaisho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.ninteichosahyogaikyochosa.ChosahyoGaikyochosaItem;
import jp.co.ndensan.reams.db.dbe.business.report.ninteichosahyogaikyochosa.ChosahyoGaikyochosaReport;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.iraisho.GridParameter;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hakkoichiranhyo.HomonChosaIraishoProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hakkoichiranhyo.HomonChosaIraishoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosahyogaikyochosa.ChosahyoGaikyochosaReportSource;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.hakkoichiranhyo.IHomonChosaIraishoMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.RensakusakiTsuzukigara;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5201NinteichosaIraiJohoEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 *
 * 要介護認定調査票（概況調査）の帳票DBE221011出力処理クラスです。
 *
 * @reamsid_L DBE-0080-140 duanzhanli
 */
public class ChosahyoGaikyochosa_221011Process extends BatchProcessBase<HomonChosaIraishoRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbe.persistence.db.mapper."
            + "relate.hakkoichiranhyo.IHomonChosaIraishoMapper.get訪問調査依頼書");
    private static final ReportId 帳票ID = ReportIdDBE.DBE221011.getReportId();
    private static final RString CONFIGVALUE = new RString("1");
    private static final RString IRAIFROMYMD = new RString("【依頼開始日】");
    private static final RString IRAITOYMD = new RString("【依頼終了日】");
    private static final RString NINTEIOCHOSAIRAISHO = new RString("【認定調査依頼書印刷区分】");
    private static final RString NINTEICHOSAHYO = new RString("【認定調査票印刷区分】");
    private static final RString NINTEICHOSAIRAILIST = new RString("【認定調査依頼リスト】");
    private static final RString NINTEICHOSAITAKUSAKICODE = new RString("　　【認定調査委託先コード】");
    private static final RString NINTEICHOSAINCODE = new RString("　　【認定調査員コード】");
    private static final RString SHOKISAIHOKENSHANO = new RString("　　【証記載保険者番号】");
    private static final RString HAKKOBI = new RString("【発行日】");
    private static final RString TEISHUTSUKIGEN = new RString("【提出期限】");
    private static final RString KYOTSUHIZUKE = new RString("【共通日付】");
    private static final RString NINTEICHOSAIRAISYO = new RString("【認定調査依頼書出力区分】");
    private static final RString NINTEICHOSAHYOKIHON = new RString("【認定調査票(基本調査)出力区分】");
    private static final RString NINTEICHOSAHYOTOKKI = new RString("【認定調査票(特記事項)出力区分】");
    private static final RString NINTEICHOSAHYOGAIKYOU = new RString("【認定調査票(概況調査)出力区分】");
    private static final RString NINTEICHOSAHYOOCRKIHON = new RString("【認定調査票OCR(基本調査)出力区分】");
    private static final RString NINTEICHOSAHYOOCRTOKKI = new RString("【認定調査票OCR(特記事項)出力区分】");
    private static final RString NINTEICHOSAHYOOCRGAIKYOU = new RString("【認定調査票OCR(概況調査)出力区分】");
    private static final RString NINTEICHOSACHECKHYO = new RString("【認定調査差異チェック表出力区分】");
    private static final RString NINTEICHOSAIRAICHOHYO = new RString("【認定調査依頼一覧表出力区分】");
    private static final RString ZENKONINTEICHOSAHYO = new RString("【前回認定調査結果との比較表出力区分】");
    private static final int INT3 = 3;
    private static final int INT4 = 4;
    private static final int INT5 = 5;
    private static final int INT6 = 6;
    private static final int INT7 = 7;
    private static final int INT8 = 8;
    private static final int INT9 = 9;
    private static final int INT10 = 10;
    private static final int INT11 = 11;
    private static final int INT12 = 12;
    private static final RString 文字列1 = new RString("1");
    private static final RString 文字列2 = new RString("2");
    private static final RString 文字列3 = new RString("3");
    private static final RString 文字列4 = new RString("4");
    private static final RString 文字列5 = new RString("5");
    private static final RString 年号_明治 = new RString("明");
    private static final RString 年号_大正 = new RString("大");
    private static final RString 年号_昭和 = new RString("昭");
    private static final RString 記号 = new RString("✔");
    private static final RString YOKAIGOJOTAIKUBUN01 = new RString("01");
    private static final RString YOKAIGOJOTAIKUBUN12 = new RString("12");
    private static final RString YOKAIGOJOTAIKUBUN13 = new RString("13");
    private static final RString YOKAIGOJOTAIKUBUN21 = new RString("21");
    private static final RString YOKAIGOJOTAIKUBUN22 = new RString("22");
    private static final RString YOKAIGOJOTAIKUBUN23 = new RString("23");
    private static final RString YOKAIGOJOTAIKUBUN24 = new RString("24");
    private static final RString YOKAIGOJOTAIKUBUN25 = new RString("25");
    private RString 誕生日明治;
    private RString 誕生日大正;
    private RString 誕生日昭和;
    private RString 性別_男;
    private RString 性別_女;
    private RString 被保険者番号1;
    private RString 被保険者番号2;
    private RString 被保険者番号3;
    private RString 被保険者番号4;
    private RString 被保険者番号5;
    private RString 被保険者番号6;
    private RString 被保険者番号7;
    private RString 被保険者番号8;
    private RString 被保険者番号9;
    private RString 被保険者番号10;
    private RString 保険者番号1;
    private RString 保険者番号2;
    private RString 保険者番号3;
    private RString 保険者番号4;
    private RString 保険者番号5;
    private RString 保険者番号6;
    private RString 申請年1;
    private RString 申請年2;
    private RString 申請月1;
    private RString 申請月2;
    private RString 申請日1;
    private RString 申請日2;
    private RString 記入者コード1;
    private RString 記入者コード2;
    private RString 記入者コード3;
    private RString 記入者コード4;
    private RString 記入者コード5;
    private RString 記入者コード6;
    private RString 記入者コード7;
    private RString 記入者コード8;
    private RString 所属機関コード1;
    private RString 所属機関コード2;
    private RString 所属機関コード3;
    private RString 所属機関コード4;
    private RString 所属機関コード5;
    private RString 所属機関コード6;
    private RString 所属機関コード7;
    private RString 所属機関コード8;
    private RString 所属機関コード9;
    private RString 所属機関コード10;
    private RString 所属機関コード11;
    private RString 所属機関コード12;
    private RString 年;
    private List<ChosahyoGaikyochosaItem> itemList;
    private IHomonChosaIraishoMapper iHomonChosaIraishoMapper;
    private HomonChosaIraishoProcessParamter processParamter;
    @BatchWriter
    private BatchReportWriter<ChosahyoGaikyochosaReportSource> batchReportWriter;
    private ReportSourceWriter<ChosahyoGaikyochosaReportSource> reportSourceWriter;
    @BatchWriter
    private BatchPermanentTableWriter<DbT5201NinteichosaIraiJohoEntity> dbT5201EntityWriter;

    @Override
    protected void initialize() {
        iHomonChosaIraishoMapper = getMapper(IHomonChosaIraishoMapper.class);
        itemList = new ArrayList<>();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParamter.toHomonChosaIraishoMybitisParamter());
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(帳票ID.value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
        dbT5201EntityWriter = new BatchPermanentTableWriter(DbT5201NinteichosaIraiJohoEntity.class);
    }

    @Override
    protected void process(HomonChosaIraishoRelateEntity entity) {
        update認定調査依頼情報(entity);
        itemList.add(setItem(entity));
    }

    @Override
    protected void afterExecute() {
        if (itemList != null && !itemList.isEmpty()) {
            ChosahyoGaikyochosaReport report = ChosahyoGaikyochosaReport.createFrom(itemList);
            report.writeBy(reportSourceWriter);
        }
        バッチ出力条件リストの出力();
    }

    private ChosahyoGaikyochosaItem setItem(HomonChosaIraishoRelateEntity entity) {
        get保険者番号(entity);
        get被保険者番号(entity);
        get申請日(entity);
        get記入者コード(entity);
        get所属機関コード(entity);
        get性別(entity.get性別());
        get年号(entity.get生年月日());
        RString 要支援 = RString.EMPTY;
        if (YOKAIGOJOTAIKUBUN12.equals(entity.get前回要介護状態区分コード())
                || YOKAIGOJOTAIKUBUN13.equals(entity.get前回要介護状態区分コード())) {
            要支援 = 記号;
        }
        RString 要支援詳細 = RString.EMPTY;
        if (YOKAIGOJOTAIKUBUN12.equals(entity.get前回要介護状態区分コード())) {
            要支援詳細 = 文字列1;
        } else if (YOKAIGOJOTAIKUBUN13.equals(entity.get前回要介護状態区分コード())) {
            要支援詳細 = 文字列2;
        }
        get年月日(entity.get生年月日());
        return new ChosahyoGaikyochosaItem(保険者番号1,
                保険者番号2,
                保険者番号3,
                保険者番号4,
                保険者番号5,
                保険者番号6,
                申請年1,
                申請年2,
                申請月1,
                申請月2,
                申請日1,
                申請日2,
                被保険者番号1,
                被保険者番号2,
                被保険者番号3,
                被保険者番号4,
                被保険者番号5,
                被保険者番号6,
                被保険者番号7,
                被保険者番号8,
                被保険者番号9,
                被保険者番号10,
                記入者コード1,
                記入者コード2,
                記入者コード3,
                記入者コード4,
                記入者コード5,
                記入者コード6,
                記入者コード7,
                記入者コード8,
                entity.get調査員氏名(),
                所属機関コード1,
                所属機関コード2,
                所属機関コード3,
                所属機関コード4,
                所属機関コード5,
                所属機関コード6,
                所属機関コード7,
                所属機関コード8,
                所属機関コード9,
                所属機関コード10,
                所属機関コード11,
                所属機関コード12,
                entity.get事業者名称(),
                entity.get被保険者氏名カナ(),
                entity.get被保険者氏名(),
                性別_男,
                性別_女,
                entity.get住所(),
                entity.get郵便番号(),
                entity.get電話番号(),
                誕生日明治,
                誕生日大正,
                誕生日昭和,
                年,
                !RString.isNullOrEmpty(entity.get生年月日()) ? entity.get生年月日().substring(INT4, INT6) : RString.EMPTY,
                !RString.isNullOrEmpty(entity.get生年月日()) ? entity.get生年月日().substring(INT6, INT8) : RString.EMPTY,
                entity.get年齢(),
                entity.get連絡先住所(),
                entity.get連絡先郵便番号(),
                entity.get連絡先電話番号(),
                entity.get連絡先携帯番号(),
                entity.get連絡先氏名(),
                !RString.isNullOrEmpty(entity.get連絡先続柄())
                ? RensakusakiTsuzukigara.toValue(entity.get連絡先続柄()).get名称() : RString.EMPTY,
                RString.isNullOrEmpty(entity.get前回認定年月日()) ? 記号 : RString.EMPTY,
                !RString.isNullOrEmpty(entity.get前回認定年月日()) ? 記号 : RString.EMPTY,
                !RString.isNullOrEmpty(entity.get前回認定年月日()) ? entity.get前回認定年月日().substring(0, INT4) : RString.EMPTY,
                !RString.isNullOrEmpty(entity.get前回認定年月日()) ? entity.get前回認定年月日().substring(INT4, INT6) : RString.EMPTY,
                !RString.isNullOrEmpty(entity.get前回認定年月日()) ? entity.get前回認定年月日().substring(INT6, INT8) : RString.EMPTY,
                YOKAIGOJOTAIKUBUN01.equals(entity.get前回要介護状態区分コード()) ? 記号 : RString.EMPTY,
                要支援,
                要支援詳細,
                get要介護詳細(entity),
                get要介護詳細(entity.get前回要介護状態区分コード()));
    }

    private void get年月日(RString 生年月日) {
        年 = RString.EMPTY;
        if (!RString.isNullOrEmpty(生年月日)) {
            年 = new FlexibleYear(生年月日.substring(0, INT4)).wareki().eraType(EraType.KANJI).toDateString().substring(2, INT4);
        }
    }

    private RString get要介護詳細(HomonChosaIraishoRelateEntity entity) {
        RString 要介護 = RString.EMPTY;
        if (YOKAIGOJOTAIKUBUN21.equals(entity.get前回要介護状態区分コード())
                || YOKAIGOJOTAIKUBUN22.equals(entity.get前回要介護状態区分コード())
                || YOKAIGOJOTAIKUBUN23.equals(entity.get前回要介護状態区分コード())
                || YOKAIGOJOTAIKUBUN24.equals(entity.get前回要介護状態区分コード())
                || YOKAIGOJOTAIKUBUN25.equals(entity.get前回要介護状態区分コード())) {
            要介護 = 記号;
        }
        return 要介護;
    }

    private RString get要介護詳細(RString yokaigoJotaiKubun) {
        RString 要介護詳細 = RString.EMPTY;
        if (YOKAIGOJOTAIKUBUN21.equals(yokaigoJotaiKubun)) {
            要介護詳細 = 文字列1;
        } else if (YOKAIGOJOTAIKUBUN22.equals(yokaigoJotaiKubun)) {
            要介護詳細 = 文字列2;
        } else if (YOKAIGOJOTAIKUBUN23.equals(yokaigoJotaiKubun)) {
            要介護詳細 = 文字列3;
        } else if (YOKAIGOJOTAIKUBUN24.equals(yokaigoJotaiKubun)) {
            要介護詳細 = 文字列4;
        } else if (YOKAIGOJOTAIKUBUN25.equals(yokaigoJotaiKubun)) {
            要介護詳細 = 文字列5;
        }
        return 要介護詳細;
    }

    private void get性別(RString 性別コード) {
        if (性別コード.equals(Seibetsu.男.getコード())) {
            性別_男 = 記号;
        } else if (性別コード.equals(Seibetsu.女.getコード())) {
            性別_女 = 記号;
        }
    }

    private void get年号(RString 生年月日) {
        誕生日明治 = RString.EMPTY;
        誕生日大正 = RString.EMPTY;
        誕生日昭和 = RString.EMPTY;
        if (!RString.isNullOrEmpty(生年月日)) {
            RString 年号 = new FlexibleDate(生年月日).wareki().toDateString();
            if (年号.startsWith(年号_明治)) {
                誕生日明治 = 記号;
            } else if (年号.startsWith(年号_大正)) {
                誕生日大正 = 記号;
            } else if (年号.startsWith(年号_昭和)) {
                誕生日昭和 = 記号;
            }
        }
    }

    private void get申請日(HomonChosaIraishoRelateEntity entity) {
        申請年1 = RString.EMPTY;
        申請年2 = RString.EMPTY;
        申請月1 = RString.EMPTY;
        申請月2 = RString.EMPTY;
        申請日1 = RString.EMPTY;
        申請日2 = RString.EMPTY;
        RString 申請日 = entity.get認定申請年月日();
        if (!RString.isNullOrEmpty(申請日)) {
            RString shiseiYMD = new FlexibleDate(申請日).wareki().eraType(EraType.KANJI).toDateString();
            申請年1 = shiseiYMD.substring(2, INT3);
            申請年2 = shiseiYMD.substring(INT3, INT4);
            申請月1 = shiseiYMD.substring(INT5, INT6);
            申請月2 = shiseiYMD.substring(INT6, INT7);
            申請日1 = shiseiYMD.substring(INT8, INT9);
            申請日2 = shiseiYMD.substring(INT9, INT10);
        }
    }

    private void get所属機関コード(HomonChosaIraishoRelateEntity entity) {
        所属機関コード1 = RString.EMPTY;
        所属機関コード2 = RString.EMPTY;
        所属機関コード3 = RString.EMPTY;
        所属機関コード4 = RString.EMPTY;
        所属機関コード5 = RString.EMPTY;
        所属機関コード6 = RString.EMPTY;
        所属機関コード7 = RString.EMPTY;
        所属機関コード8 = RString.EMPTY;
        所属機関コード9 = RString.EMPTY;
        所属機関コード10 = RString.EMPTY;
        所属機関コード11 = RString.EMPTY;
        所属機関コード12 = RString.EMPTY;
        RString 所属機関コード = entity.get認定調査委託先コード();
        if (!RString.isNullOrEmpty(所属機関コード) && INT12 <= 所属機関コード.length()) {
            所属機関コード1 = 所属機関コード.substring(0, 1);
            所属機関コード2 = 所属機関コード.substring(1, 2);
            所属機関コード3 = 所属機関コード.substring(2, INT3);
            所属機関コード4 = 所属機関コード.substring(INT3, INT4);
            所属機関コード5 = 所属機関コード.substring(INT4, INT5);
            所属機関コード6 = 所属機関コード.substring(INT5, INT6);
            所属機関コード7 = 所属機関コード.substring(INT6, INT7);
            所属機関コード8 = 所属機関コード.substring(INT7, INT8);
            所属機関コード9 = 所属機関コード.substring(INT8, INT9);
            所属機関コード10 = 所属機関コード.substring(INT9, INT10);
            所属機関コード11 = 所属機関コード.substring(INT10, INT11);
            所属機関コード12 = 所属機関コード.substring(INT11, INT12);

        }
    }

    private void get記入者コード(HomonChosaIraishoRelateEntity entity) {
        記入者コード1 = RString.EMPTY;
        記入者コード2 = RString.EMPTY;
        記入者コード3 = RString.EMPTY;
        記入者コード4 = RString.EMPTY;
        記入者コード5 = RString.EMPTY;
        記入者コード6 = RString.EMPTY;
        記入者コード7 = RString.EMPTY;
        記入者コード8 = RString.EMPTY;
        RString 記入者コード = entity.get認定調査員コード();
        if (!RString.isNullOrEmpty(記入者コード) && INT8 <= 記入者コード.length()) {
            記入者コード1 = 記入者コード.substring(0, 1);
            記入者コード2 = 記入者コード.substring(1, 2);
            記入者コード3 = 記入者コード.substring(2, INT3);
            記入者コード4 = 記入者コード.substring(INT3, INT4);
            記入者コード5 = 記入者コード.substring(INT4, INT5);
            記入者コード6 = 記入者コード.substring(INT5, INT6);
            記入者コード7 = 記入者コード.substring(INT6, INT7);
            記入者コード8 = 記入者コード.substring(INT7, INT8);
        }
    }

    private void get被保険者番号(HomonChosaIraishoRelateEntity entity) {
        被保険者番号1 = RString.EMPTY;
        被保険者番号2 = RString.EMPTY;
        被保険者番号3 = RString.EMPTY;
        被保険者番号4 = RString.EMPTY;
        被保険者番号5 = RString.EMPTY;
        被保険者番号6 = RString.EMPTY;
        被保険者番号7 = RString.EMPTY;
        被保険者番号8 = RString.EMPTY;
        被保険者番号9 = RString.EMPTY;
        被保険者番号10 = RString.EMPTY;
        RString 被保険者番号 = entity.get被保険者番号();
        if (!RString.isNullOrEmpty(被保険者番号) && INT10 <= 被保険者番号.length()) {
            被保険者番号1 = 被保険者番号.substring(0, 1);
            被保険者番号2 = 被保険者番号.substring(1, 2);
            被保険者番号3 = 被保険者番号.substring(2, INT3);
            被保険者番号4 = 被保険者番号.substring(INT3, INT4);
            被保険者番号5 = 被保険者番号.substring(INT4, INT5);
            被保険者番号6 = 被保険者番号.substring(INT5, INT6);
            被保険者番号7 = 被保険者番号.substring(INT6, INT7);
            被保険者番号8 = 被保険者番号.substring(INT7, INT8);
            被保険者番号9 = 被保険者番号.substring(INT8, INT9);
            被保険者番号10 = 被保険者番号.substring(INT9, INT10);
        }
    }

    private void get保険者番号(HomonChosaIraishoRelateEntity entity) {
        保険者番号1 = RString.EMPTY;
        保険者番号2 = RString.EMPTY;
        保険者番号3 = RString.EMPTY;
        保険者番号4 = RString.EMPTY;
        保険者番号5 = RString.EMPTY;
        保険者番号6 = RString.EMPTY;
        RString 証記載保険者番号 = entity.get証記載保険者番号();
        if (!RString.isNullOrEmpty(証記載保険者番号) && INT6 <= 証記載保険者番号.length()) {
            保険者番号1 = 証記載保険者番号.substring(0, 1);
            保険者番号2 = 証記載保険者番号.substring(1, 2);
            保険者番号3 = 証記載保険者番号.substring(2, INT3);
            保険者番号4 = 証記載保険者番号.substring(INT3, INT4);
            保険者番号5 = 証記載保険者番号.substring(INT4, INT5);
            保険者番号6 = 証記載保険者番号.substring(INT5, INT6);
        }
    }

    private void update認定調査依頼情報(HomonChosaIraishoRelateEntity entity) {
        DbT5201NinteichosaIraiJohoEntity dbT5201Entity = iHomonChosaIraishoMapper.get認定調査依頼情報(entity);
        RString 認定調査期限設定方法 = DbBusinessConfig.get(ConfigNameDBE.認定調査期限設定方法, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        if (CONFIGVALUE.equals(認定調査期限設定方法)) {
            switch (processParamter.getTeishutsuKigen().toString()) {
                case "0":
                    int 期限日数 = Integer.parseInt(DbBusinessConfig.get(ConfigNameDBE.認定調査期限日数,
                            RDate.getNowDate(), SubGyomuCode.DBE認定支援).toString());
                    FlexibleDate 認定調査依頼日 = entity.get認定調査依頼年月日();
                    if (認定調査依頼日 != null && !認定調査依頼日.isEmpty()) {
                        dbT5201Entity.setNinteichosaKigenYMD(認定調査依頼日.plusDay(期限日数));
                    }
                    break;
                case "1":
                    dbT5201Entity.setNinteichosaKigenYMD(FlexibleDate.EMPTY);
                    break;
                case "2":
                    if (!RString.isNullOrEmpty(processParamter.getKyotsuHizuke())) {
                        dbT5201Entity.setNinteichosaKigenYMD(new FlexibleDate(processParamter.getKyotsuHizuke()));
                    }
                    break;
                default:
                    break;
            }
        }
        RString hakkobi = processParamter.getHakkobi();
        if (!RString.isNullOrEmpty(hakkobi)) {
            dbT5201Entity.setChosahyoTouShutsuryokuYMD(new FlexibleDate(hakkobi));
        } else {
            dbT5201Entity.setChosahyoTouShutsuryokuYMD(FlexibleDate.EMPTY);
        }
        dbT5201EntityWriter.update(dbT5201Entity);
    }

    private void バッチ出力条件リストの出力() {
        Association 導入団体クラス = AssociationFinderFactory.createInstance().getAssociation();
        RString 導入団体コード = 導入団体クラス.getLasdecCode_().value();
        RString 市町村名 = 導入団体クラス.get市町村名();
        RString 出力ページ数 = new RString(String.valueOf(reportSourceWriter.pageCount().value()));
        RString csv出力有無 = new RString("無し");
        RString csvファイル名 = new RString("－");
        RString ジョブ番号 = new RString("56");
        List<RString> 出力条件 = new ArrayList<>();
        RStringBuilder builder = new RStringBuilder();
        builder.append(IRAIFROMYMD);
        builder.append(processParamter.getIraiFromYMD());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(IRAITOYMD);
        builder.append(processParamter.getIraiToYMD());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(NINTEIOCHOSAIRAISHO);
        builder.append(processParamter.getNinteioChosaIraisho());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(NINTEICHOSAHYO);
        builder.append(processParamter.getNinteiChosahyo());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(NINTEICHOSAIRAILIST);
        出力条件.add(builder.toRString());
        List<GridParameter> ninteiChosaIraiList = processParamter.getNinteiChosaIraiList();
        for (GridParameter gridParameter : ninteiChosaIraiList) {
            builder = new RStringBuilder();
            builder.append(NINTEICHOSAITAKUSAKICODE);
            builder.append(gridParameter.getNinteichosaItakusakiCode());
            出力条件.add(builder.toRString());
            builder = new RStringBuilder();
            builder.append(NINTEICHOSAINCODE);
            builder.append(gridParameter.getNinteiChosainCode());
            出力条件.add(builder.toRString());
            builder = new RStringBuilder();
            builder.append(SHOKISAIHOKENSHANO);
            builder.append(gridParameter.getShoKisaiHokenshaNo());
            出力条件.add(builder.toRString());
        }
        builder = new RStringBuilder();
        builder.append(HAKKOBI);
        builder.append(processParamter.getHakkobi());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(TEISHUTSUKIGEN);
        builder.append(processParamter.getTeishutsuKigen());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(KYOTSUHIZUKE);
        builder.append(processParamter.getKyotsuHizuke());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(NINTEICHOSAIRAICHOHYO);
        builder.append(processParamter.isNinteiChosaIraiChohyo());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(NINTEICHOSAIRAISYO);
        builder.append(processParamter.isNinteiChosaIraisyo());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(NINTEICHOSAHYOKIHON);
        builder.append(processParamter.isNinteiChosahyoKihon());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(NINTEICHOSAHYOTOKKI);
        builder.append(processParamter.isNinteiChosahyoTokki());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(NINTEICHOSAHYOGAIKYOU);
        builder.append(processParamter.isNinteiChosahyoGaikyou());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(NINTEICHOSAHYOOCRKIHON);
        builder.append(processParamter.isNinteiChosahyoOCRKihon());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(NINTEICHOSAHYOOCRTOKKI);
        builder.append(processParamter.isNinteiChosahyoOCRTokki());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(NINTEICHOSAHYOOCRGAIKYOU);
        builder.append(processParamter.isNinteiChosahyoOCRGaikyou());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(NINTEICHOSACHECKHYO);
        builder.append(processParamter.isNinteiChosaCheckHyo());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(ZENKONINTEICHOSAHYO);
        builder.append(processParamter.isZenkoNinteiChosahyo());
        出力条件.add(builder.toRString());
        ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                帳票ID.value(),
                導入団体コード,
                市町村名,
                ジョブ番号,
                ReportIdDBE.DBE221011.getReportName(),
                出力ページ数,
                csv出力有無,
                csvファイル名,
                出力条件);
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(reportOutputJokenhyoItem);
        printer.print();
    }
}
