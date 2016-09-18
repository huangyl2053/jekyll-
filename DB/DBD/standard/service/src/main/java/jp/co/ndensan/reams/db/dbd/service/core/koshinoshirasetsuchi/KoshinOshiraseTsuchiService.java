/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.koshinoshirasetsuchi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbd.business.report.dbd501002.ShinseiShoEntity;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd511002.KoshinOshiraseTsuchiProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd511002.KoshinOshiraseCommonEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd511002.KoshinOshiraseHeaderEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd511002.KoshinOshiraseTsuchiUpdateEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd511002.KoshinOshiraseTsuchishoHakoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7060KaigoJigyoshaEntity;
import jp.co.ndensan.reams.db.dbz.business.core.util.report.ChohyoUtil;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun99;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiHoreiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4910NinteichosaItakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 認定更新お知らせ通知書発行_サービス処理です。
 *
 * @reamsid_L DBD-2030-020 xuyue
 */
public class KoshinOshiraseTsuchiService {

    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final int FIVE = 5;
    private static final int SIX = 6;
    private static final int SEVEN = 7;
    private static final int EIGHT = 8;
    private static final int NINE = 9;
    private static final int TEN = 10;
    private static final int INDEX_0 = 0;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_5 = 5;
    private static final int INDEX_6 = 6;
    private static final int INDEX_8 = 8;
    private static final int LISTINDEX_0 = 0;
    private static final int LISTINDEX_1 = 1;
    private static final int LISTINDEX_2 = 2;
    private static final int LISTINDEX_3 = 3;
    private static final int LISTINDEX_4 = 4;
    private static final ReportIdDBD 帳票11 = ReportIdDBD.DBD511001;
    private static final ReportIdDBD 帳票01 = ReportIdDBD.DBD501001;
    private static final ReportIdDBD 帳票12 = ReportIdDBD.DBD511002;
    private static RString ジョブ番号 = new RString("【ジョブ番号】");
    private static final RString カラ = new RString("～");
    private static final RString カあ = new RString("-");
    private static final RString まる = new RString("○");
    private static final String 明治 = "明治";
    private static final String 昭和 = "昭和";
    private static final String 大正 = "大正";

    /**
     * 認定更新お知らせ通知書発行_サービスを生成します。
     *
     * @return 認定更新お知らせ通知書発行_サービス
     */
    public static KoshinOshiraseTsuchiService createInstance() {
        return InstanceProvider.create(KoshinOshiraseTsuchiService.class);
    }

    /**
     * 要介護認定申請情報を更新します。
     *
     * @param parameter プロセスパラメータ
     * @param entity 要介護認定申請情報
     * @return 要介護認定申請情報
     */
    public DbT4101NinteiShinseiJohoEntity update要介護認定申請情報(KoshinOshiraseTsuchiProcessParameter parameter,
            DbT4101NinteiShinseiJohoEntity entity) {
        entity.setKoshinTsuchiHakkoYMD(parameter.get通知書発行日());
        return entity;
    }

    /**
     * バッチ出力条件リストの出力を行います。
     *
     * @param association Association
     * @param parameter プロセスパラメータ
     * @param 帳票ID01出力ページ数 帳票DBD501001出力ページ数
     * @param 帳票ID11出力ページ数 帳票DBD511001出力ページ数
     * @param 帳票ID12出力ページ数 帳票DBD511002出力ページ数
     * @param 帳票ID01TF 帳票DBD501001出力判断フラグ
     * @param 帳票ID11TF 帳票DBD511001出力判断フラグ
     * @param 帳票ID12TF 帳票DBD511002出力判断フラグ
     */
    public void バッチ出力条件リストの出力(Association association, KoshinOshiraseTsuchiProcessParameter parameter,
            RString 帳票ID01出力ページ数, RString 帳票ID11出力ページ数, RString 帳票ID12出力ページ数,
            boolean 帳票ID01TF, boolean 帳票ID11TF, boolean 帳票ID12TF) {

        RString 導入団体コード = association.getLasdecCode_().getColumnValue();
        RString 市町村名 = association.get市町村名();
        ジョブ番号 = new RString(String.valueOf(JobContextHolder.getJobId()));
        RString csv出力有無 = new RString("なし");
        RString csvファイル名 = カあ;
        RStringBuilder builder = new RStringBuilder();
        List<RString> 出力条件 = new ArrayList<>();
        builder.append(parameter.get申請書管理番号リスト());
        出力条件.add(builder.toRString());
        builder.append(parameter.get抽出対象期間_開始());
        出力条件.add(builder.toRString());
        builder.append(parameter.get出力対象区分());
        出力条件.add(builder.toRString());
        builder.append(parameter.get出力順());
        出力条件.add(builder.toRString());
        builder.append(parameter.get抽出対象期間_終了());
        出力条件.add(builder.toRString());
        builder.append(parameter.get通知書発行日());
        出力条件.add(builder.toRString());
        if (帳票ID01TF) {
            RString 帳票ID = 帳票01.getReportId().getColumnValue();
            RString 帳票名 = 帳票01.getReportName();
            ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                    帳票ID,
                    導入団体コード,
                    市町村名,
                    ジョブ番号,
                    帳票名,
                    帳票ID01出力ページ数,
                    csv出力有無,
                    csvファイル名,
                    出力条件);
            IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(reportOutputJokenhyoItem);
            printer.print();
        }
        if (帳票ID11TF) {
            RString 帳票ID = 帳票11.getReportId().getColumnValue();
            RString 帳票名 = 帳票11.getReportName();
            ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                    帳票ID,
                    導入団体コード,
                    市町村名,
                    ジョブ番号,
                    帳票名,
                    帳票ID11出力ページ数,
                    csv出力有無,
                    csvファイル名,
                    出力条件);
            IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(reportOutputJokenhyoItem);
            printer.print();
        }
        if (帳票ID12TF) {
            RString 帳票ID = 帳票12.getReportId().getColumnValue();
            RString 帳票名 = 帳票12.getReportName();
            ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                    帳票ID,
                    導入団体コード,
                    市町村名,
                    ジョブ番号,
                    帳票名,
                    帳票ID12出力ページ数,
                    csv出力有無,
                    csvファイル名,
                    出力条件);
            IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(reportOutputJokenhyoItem);
            printer.print();
        }

    }

    /**
     * 認定更新お知らせ通知書データ編集を行います。
     *
     * @param 通知書発行日 通知書発行日
     * @param koshinOshiraseEn 認定更新お知らせ通知書発行のデータ
     * @return 通知文、被保険者番号データ
     */
    public KoshinOshiraseCommonEntity 認定更新お知らせ通知書データ編集(FlexibleDate 通知書発行日,
            KoshinOshiraseTsuchiUpdateEntity koshinOshiraseEn) {
        KoshinOshiraseCommonEntity entity = new KoshinOshiraseCommonEntity();
        Map<Integer, RString> map = ReportUtil.get通知文(SubGyomuCode.DBD介護受給, 帳票11.getReportId(),
                KamokuCode.EMPTY, 1);
        entity.set通知文1(map.get(1));
        entity.set通知文2(map.get(2));
        entity.set文書番号(ReportUtil.get文書番号(SubGyomuCode.DBD介護受給, 帳票11.getReportId(), 通知書発行日));
        entity.set被保険者氏名フリガナ(koshinOshiraseEn.getDbt4101Entity().getHihokenshaKana().getColumnValue());
        entity.set被保険者番号1(koshinOshiraseEn.getDbt4101Entity().getHihokenshaNo().substring(ZERO, ONE));
        entity.set被保険者番号2(koshinOshiraseEn.getDbt4101Entity().getHihokenshaNo().substring(ONE, TWO));
        entity.set被保険者番号3(koshinOshiraseEn.getDbt4101Entity().getHihokenshaNo().substring(TWO, THREE));
        entity.set被保険者番号4(koshinOshiraseEn.getDbt4101Entity().getHihokenshaNo().substring(THREE, FOUR));
        entity.set被保険者番号5(koshinOshiraseEn.getDbt4101Entity().getHihokenshaNo().substring(FOUR, FIVE));
        entity.set被保険者番号6(koshinOshiraseEn.getDbt4101Entity().getHihokenshaNo().substring(FIVE, SIX));
        entity.set被保険者番号7(koshinOshiraseEn.getDbt4101Entity().getHihokenshaNo().substring(SIX, SEVEN));
        entity.set被保険者番号8(koshinOshiraseEn.getDbt4101Entity().getHihokenshaNo().substring(SEVEN, EIGHT));
        entity.set被保険者番号9(koshinOshiraseEn.getDbt4101Entity().getHihokenshaNo().substring(EIGHT, NINE));
        entity.set被保険者番号10(koshinOshiraseEn.getDbt4101Entity().getHihokenshaNo().substring(NINE, TEN));
        entity.set被保険者氏名(koshinOshiraseEn.getDbt4101Entity().getHihokenshaName().getColumnValue());
        entity.set要介護認定開始日(koshinOshiraseEn.getDbV4001JukyushaDaicho().getNinteiYukoKikanKaishiYMD().wareki().separator(Separator.JAPANESE).
                fillType(FillType.BLANK).toDateString());
        entity.set要介護認定終了日(koshinOshiraseEn.getDbV4001JukyushaDaicho().getNinteiYukoKikanShuryoYMD().wareki().separator(Separator.JAPANESE).
                fillType(FillType.BLANK).toDateString());
        if (koshinOshiraseEn.getDbV4001JukyushaDaicho().getYokaigoJotaiKubunCode() != null && !koshinOshiraseEn.getDbV4001JukyushaDaicho().getYokaigoJotaiKubunCode().getColumnValue().isEmpty()) {
            if (koshinOshiraseEn.getDbt4101Entity().getKoroshoIfShikibetsuCode().getColumnValue().equals(new RString("99A"))) {
                entity.set要介護状態区分(YokaigoJotaiKubun99.toValue(koshinOshiraseEn.getDbV4001JukyushaDaicho().getYokaigoJotaiKubunCode().getColumnValue()).get名称());
            } else if (koshinOshiraseEn.getDbt4101Entity().getKoroshoIfShikibetsuCode().getColumnValue().equals(new RString("02A"))) {
                entity.set要介護状態区分(YokaigoJotaiKubun02.toValue(koshinOshiraseEn.getDbV4001JukyushaDaicho().getYokaigoJotaiKubunCode().getColumnValue()).get名称());
            } else if (koshinOshiraseEn.getDbt4101Entity().getKoroshoIfShikibetsuCode().getColumnValue().equals(new RString("06A"))) {
                entity.set要介護状態区分(YokaigoJotaiKubun06.toValue(koshinOshiraseEn.getDbV4001JukyushaDaicho().getYokaigoJotaiKubunCode().getColumnValue()).get名称());
            } else if (koshinOshiraseEn.getDbt4101Entity().getKoroshoIfShikibetsuCode().getColumnValue().equals(new RString("09B"))
                    || koshinOshiraseEn.getDbt4101Entity().getKoroshoIfShikibetsuCode().getColumnValue().equals(new RString("09A"))) {
                entity.set要介護状態区分(YokaigoJotaiKubun09.toValue(koshinOshiraseEn.getDbV4001JukyushaDaicho().getYokaigoJotaiKubunCode().getColumnValue()).get名称());
            }
        }
        return entity;
    }

    /**
     * 発行一覧表データ編集を行います。
     *
     * @param parameter プロセスパラメータ
     * @param outputOrder 出力順
     * @param koshinOshiraseEn 認定更新お知らせ通知書発行エンティティ
     * @param index 項番
     * @return 通知書発行一覧表エンティティ
     */
    public KoshinOshiraseHeaderEntity 発行一覧表データ編集(KoshinOshiraseTsuchiProcessParameter parameter, IOutputOrder outputOrder,
            KoshinOshiraseTsuchiUpdateEntity koshinOshiraseEn, int index) {
        KoshinOshiraseHeaderEntity headerEntity = new KoshinOshiraseHeaderEntity();
        RStringBuilder builder = new RStringBuilder();
        builder.append(parameter.get抽出対象期間_開始().wareki().separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString());
        builder.append(カラ);
        builder.append(parameter.get抽出対象期間_終了().wareki().separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString());
        headerEntity.set抽出対象期間(builder.toRString());
        headerEntity.set市町村コード(koshinOshiraseEn.getDbT7051KoseiShichosonMaster().getShichosonCode().getColumnValue());
        headerEntity.set市町村名称(koshinOshiraseEn.getDbT7051KoseiShichosonMaster().getShichosonMeisho());
        Map<Integer, ISetSortItem> 出力順Map = ChohyoUtil.get出力順項目Map(outputOrder);
        if (出力順Map.get(LISTINDEX_0) != null) {
            headerEntity.set並び順1(出力順Map.get(LISTINDEX_0).get項目名());
        }
        if (出力順Map.get(LISTINDEX_1) != null) {
            headerEntity.set並び順2(出力順Map.get(LISTINDEX_1).get項目名());
        }
        if (出力順Map.get(LISTINDEX_2) != null) {
            headerEntity.set並び順3(出力順Map.get(LISTINDEX_2).get項目名());
        }
        if (出力順Map.get(LISTINDEX_3) != null) {
            headerEntity.set並び順4(出力順Map.get(LISTINDEX_3).get項目名());
        }
        if (出力順Map.get(LISTINDEX_4) != null) {
            headerEntity.set並び順4(出力順Map.get(LISTINDEX_4).get項目名());
        }
        RTime time = RDate.getNowTime();
        RString hour = new RString(time.toString()).substring(INDEX_0, INDEX_2);
        RString min = new RString(time.toString()).substring(INDEX_3, INDEX_5);
        RString sec = new RString(time.toString()).substring(INDEX_6, INDEX_8);
        RString timeFormat = hour.concat("時").concat(min).concat("分").concat(sec).concat("秒");
        headerEntity.set印刷時間(new RString(RDate.getNowDate().wareki().eraType(EraType.KANJI).
                firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).
                fillType(FillType.ZERO).toDateString().toString() + timeFormat + (RString.HALF_SPACE) + (new RString("作成"))));
        index++;
        set通知書発行一覧(headerEntity, koshinOshiraseEn, index);

        return headerEntity;
    }

    /**
     * 要介護認定申請書データ編集を行います。
     *
     * @param koshinOshiraseEn 認定更新お知らせ通知書発行エンティティ
     * @return 要介護認定申請書のEntity
     */
    public ShinseiShoEntity 要介護認定申請書データ編集(KoshinOshiraseTsuchiUpdateEntity koshinOshiraseEn) {
        ShinseiShoEntity entity = new ShinseiShoEntity();
        entity.set市町村名称(koshinOshiraseEn.getDbT7051KoseiShichosonMaster().getShichosonMeisho());
        entity.set被保険者番号第1桁(koshinOshiraseEn.getDbt4101Entity().getHihokenshaNo().substring(ZERO, ONE));
        entity.set被保険者番号第2桁(koshinOshiraseEn.getDbt4101Entity().getHihokenshaNo().substring(ONE, TWO));
        entity.set被保険者番号第3桁(koshinOshiraseEn.getDbt4101Entity().getHihokenshaNo().substring(TWO, THREE));
        entity.set被保険者番号第4桁(koshinOshiraseEn.getDbt4101Entity().getHihokenshaNo().substring(THREE, FOUR));
        entity.set被保険者番号第5桁(koshinOshiraseEn.getDbt4101Entity().getHihokenshaNo().substring(FOUR, FIVE));
        entity.set被保険者番号第6桁(koshinOshiraseEn.getDbt4101Entity().getHihokenshaNo().substring(FIVE, SIX));
        entity.set被保険者番号第7桁(koshinOshiraseEn.getDbt4101Entity().getHihokenshaNo().substring(SIX, SEVEN));
        entity.set被保険者番号第8桁(koshinOshiraseEn.getDbt4101Entity().getHihokenshaNo().substring(SEVEN, EIGHT));
        entity.set被保険者番号第9桁(koshinOshiraseEn.getDbt4101Entity().getHihokenshaNo().substring(EIGHT, NINE));
        entity.set被保険者番号第10桁(koshinOshiraseEn.getDbt4101Entity().getHihokenshaNo().substring(NINE, TEN));
        String nianhao = koshinOshiraseEn.getDbt4101Entity().getSeinengappiYMD().wareki().eraType(EraType.KANJI).getEra().toString();
        if (nianhao.startsWith(明治)) {
            entity.set出生元号明治(まる);
            entity.set出生元号大正(RString.EMPTY);
            entity.set出生元号明治(RString.EMPTY);
        } else if (nianhao.startsWith(大正)) {
            entity.set出生元号明治(RString.EMPTY);
            entity.set出生元号大正(まる);
            entity.set出生元号明治(RString.EMPTY);
        } else if (nianhao.startsWith(昭和)) {
            entity.set出生元号明治(RString.EMPTY);
            entity.set出生元号大正(RString.EMPTY);
            entity.set出生元号明治(まる);
        }
        entity.set被保険者名称カナ(koshinOshiraseEn.getDbt4101Entity().getHihokenshaKana().getColumnValue());
        entity.set出生年YYYY(RString.EMPTY);
        entity.set生まれYY(koshinOshiraseEn.getDbt4101Entity().getSeinengappiYMD().wareki().getYear());
        entity.set出生月MM(koshinOshiraseEn.getDbt4101Entity().getSeinengappiYMD().wareki().getMonth());
        entity.set出生日DD(koshinOshiraseEn.getDbt4101Entity().getSeinengappiYMD().wareki().getDay());
        entity.set被保険者名称(koshinOshiraseEn.getDbt4101Entity().getHihokenshaName().getColumnValue());
        if (Seibetsu.男.getコード().equals(koshinOshiraseEn.getDbt4101Entity().getSeibetsu().getColumnValue())) {
            entity.set性別男(まる);
            entity.set性別女(RString.EMPTY);
        } else if (Seibetsu.女.getコード().equals(koshinOshiraseEn.getDbt4101Entity().getSeibetsu().getColumnValue())) {
            entity.set性別男(RString.EMPTY);
            entity.set性別女(まる);
        }
        entity.set電話番号(koshinOshiraseEn.getDbt4101Entity().getTelNo().getColumnValue());
        entity.set郵便番号(koshinOshiraseEn.getDbt4101Entity().getYubinNo().getColumnValue());
        entity.set住所(koshinOshiraseEn.getDbt4101Entity().getJusho().getColumnValue());
        Code eCode = koshinOshiraseEn.getDbV4001JukyushaDaicho().getYokaigoJotaiKubunCode();
        Map<Integer, RString> map = ReportUtil.get通知文(SubGyomuCode.DBD介護受給, 帳票11.getReportId(),
                KamokuCode.EMPTY, 1);
        entity.set通知文(map.get(1));
        if (koshinOshiraseEn.getDbt4101Entity().getKoroshoIfShikibetsuCode().equals(new Code("99A"))) {
            entity = shichoson(entity, eCode);
        } else if (koshinOshiraseEn.getDbt4101Entity().getKoroshoIfShikibetsuCode().equals(new Code("02A"))) {
            entity = prtKaigo(entity, eCode);
        } else if (koshinOshiraseEn.getDbt4101Entity().getKoroshoIfShikibetsuCode().equals(new Code("06A"))) {
            entity = Kanri(entity, eCode);
        } else if (koshinOshiraseEn.getDbt4101Entity().getKoroshoIfShikibetsuCode().equals(new Code("09B"))
                || koshinOshiraseEn.getDbt4101Entity().getKoroshoIfShikibetsuCode().equals(new Code("09A"))) {
            entity = sakusei(entity, eCode);
        }

        entity.set有効開始年YYYY(koshinOshiraseEn.getDbV4001JukyushaDaicho().getNinteiYukoKikanKaishiYMD().wareki().getYear());
        entity.set有効開始月MM(koshinOshiraseEn.getDbV4001JukyushaDaicho().getNinteiYukoKikanKaishiYMD().wareki().getMonth());
        entity.set有効開始日DD(koshinOshiraseEn.getDbV4001JukyushaDaicho().getNinteiYukoKikanKaishiYMD().wareki().getDay());
        entity.set有効終了年YYYY(koshinOshiraseEn.getDbV4001JukyushaDaicho().getNinteiYukoKikanShuryoYMD().wareki().getYear());
        entity.set有効終了月MM(koshinOshiraseEn.getDbV4001JukyushaDaicho().getNinteiYukoKikanShuryoYMD().wareki().getMonth());
        entity.set有効終了日DD(koshinOshiraseEn.getDbV4001JukyushaDaicho().getNinteiYukoKikanShuryoYMD().wareki().getDay());

        return entity;
    }

    private void set通知書発行一覧(KoshinOshiraseHeaderEntity twonin, KoshinOshiraseTsuchiUpdateEntity koshinOshiraseEn, int index) {
        KoshinOshiraseTsuchishoHakoEntity entity = new KoshinOshiraseTsuchishoHakoEntity();
        entity.set被保険者番号(koshinOshiraseEn.getDbt4101Entity().getHihokenshaNo());
        entity.set被保険者氏名(koshinOshiraseEn.getDbt4101Entity().getHihokenshaName().getColumnValue());
        if (koshinOshiraseEn.getDbt4101Entity().getKoroshoIfShikibetsuCode().getColumnValue().equals(new RString("99A"))) {
            entity.set要介護度(YokaigoJotaiKubun99.toValue(koshinOshiraseEn.getDbV4001JukyushaDaicho().getYokaigoJotaiKubunCode().getColumnValue()).get名称());
        } else if (koshinOshiraseEn.getDbt4101Entity().getKoroshoIfShikibetsuCode().getColumnValue().equals(new RString("02A"))) {
            entity.set要介護度(YokaigoJotaiKubun02.toValue(koshinOshiraseEn.getDbV4001JukyushaDaicho().getYokaigoJotaiKubunCode().getColumnValue()).get名称());
        } else if (koshinOshiraseEn.getDbt4101Entity().getKoroshoIfShikibetsuCode().getColumnValue().equals(new RString("06A"))) {
            entity.set要介護度(YokaigoJotaiKubun06.toValue(koshinOshiraseEn.getDbV4001JukyushaDaicho().getYokaigoJotaiKubunCode().getColumnValue()).get名称());
        } else if (koshinOshiraseEn.getDbt4101Entity().getKoroshoIfShikibetsuCode().getColumnValue().equals(new RString("09B"))
                || koshinOshiraseEn.getDbt4101Entity().getKoroshoIfShikibetsuCode().getColumnValue().equals(new RString("09A"))) {
            entity.set要介護度(YokaigoJotaiKubun09.toValue(koshinOshiraseEn.getDbV4001JukyushaDaicho().getYokaigoJotaiKubunCode().getColumnValue()).get名称());
        }

        FlexibleDate ninteiShinseiYMD = koshinOshiraseEn.getDbt4101Entity().getNinteiShinseiYMD();
        if (ninteiShinseiYMD != null && !ninteiShinseiYMD.isEmpty()) {
            entity.set受給申請日(ninteiShinseiYMD.wareki().separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        }

        FlexibleDate ninteiYMD = koshinOshiraseEn.getDbV4001JukyushaDaicho().getNinteiYMD();
        if (ninteiYMD != null && !ninteiYMD.isEmpty()) {
            entity.set認定日(ninteiYMD.wareki().separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        }
        FlexibleDate ninteiYukoKikanKaishiYMD = koshinOshiraseEn.getDbV4001JukyushaDaicho().getNinteiYukoKikanKaishiYMD();
        if (ninteiYukoKikanKaishiYMD != null && !ninteiYukoKikanKaishiYMD.isEmpty()) {
            entity.set認定開始日(ninteiYukoKikanKaishiYMD.wareki().separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        }
        FlexibleDate ninteiYukoKikanShuryoYMD = koshinOshiraseEn.getDbV4001JukyushaDaicho().getNinteiYukoKikanShuryoYMD();
        if (ninteiYukoKikanShuryoYMD != null && !ninteiYukoKikanShuryoYMD.isEmpty()) {
            entity.set認定終了日(ninteiYukoKikanShuryoYMD.wareki().separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        }
        entity.set受給申請事由(koshinOshiraseEn.getDbt4101Entity().getNinteiShinseiRiyu());
        entity.set申請区分_申請時(NinteiShinseiShinseijiKubunCode.toValue(koshinOshiraseEn.getDbt4101Entity().getNinteiShinseiShinseijiKubunCode().getColumnValue()).get名称());

        Code ninteiShinseiHoreiKubunCode = koshinOshiraseEn.getDbt4101Entity().getNinteiShinseiHoreiKubunCode();
        if (ninteiShinseiHoreiKubunCode != null && !ninteiShinseiHoreiKubunCode.getColumnValue().isEmpty()) {
            entity.set申請区分_法令(NinteiShinseiHoreiCode.toValue(ninteiShinseiHoreiKubunCode.getColumnValue()).get名称());
        }

        DbT4910NinteichosaItakusakiJohoEntity dbT4910Entity = koshinOshiraseEn.getDbT4910NinteichosaItakusakiJoho();
        if (dbT4910Entity == null) {
            dbT4910Entity = new DbT4910NinteichosaItakusakiJohoEntity();
        }
        JigyoshaNo jigyoshaNo = dbT4910Entity.getJigyoshaNo();
        if (jigyoshaNo != null) {
            entity.set居宅支援事業者コード(jigyoshaNo.getColumnValue());
        }
        entity.set居宅支援事業者名称(dbT4910Entity.getJigyoshaMeisho());
        JigyoshaNo nyushoShisetsuCode = koshinOshiraseEn.getDbt4101Entity().getNyushoShisetsuCode();
        if (nyushoShisetsuCode != null) {
            entity.set入所施設事業者コード(nyushoShisetsuCode.getColumnValue());
        }
        DbT7060KaigoJigyoshaEntity dbT7060KaigoJigyosha = koshinOshiraseEn.getDbT7060KaigoJigyosha();
        if (dbT7060KaigoJigyosha == null) {
            dbT7060KaigoJigyosha = new DbT7060KaigoJigyoshaEntity();
        }
        AtenaMeisho jigyoshaName = dbT7060KaigoJigyosha.getJigyoshaName();
        if (jigyoshaName != null) {
            entity.set入所施設事業者名称(jigyoshaName.getColumnValue());
        }
        entity.set連番(index);
        twonin.setTsuchishoHakoEntity(entity);
    }

    private ShinseiShoEntity shichoson(ShinseiShoEntity entity, Code eCode) {
        if (eCode.getColumnValue().equals(YokaigoJotaiKubun99.要介護1.getコード())) {
            set要介護(entity, まる, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY);
        } else if (eCode.getColumnValue().equals(YokaigoJotaiKubun99.要介護2.getコード())) {
            set要介護(entity, RString.EMPTY, まる, RString.EMPTY, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY);
        } else if (eCode.getColumnValue().equals(YokaigoJotaiKubun99.要介護3.getコード())) {
            set要介護(entity, RString.EMPTY, RString.EMPTY, まる, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY);
        } else if (eCode.getColumnValue().equals(YokaigoJotaiKubun99.要介護4.getコード())) {
            set要介護(entity, RString.EMPTY, RString.EMPTY, RString.EMPTY, まる,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY);
        } else if (eCode.getColumnValue().equals(YokaigoJotaiKubun99.要介護5.getコード())) {
            set要介護(entity, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    まる, RString.EMPTY, RString.EMPTY);
        }
        return entity;
    }

    private ShinseiShoEntity prtKaigo(ShinseiShoEntity entity, Code eCode) {
        if (eCode.getColumnValue().equals(YokaigoJotaiKubun02.要介護1.getコード())) {
            set要介護(entity, まる, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY);
        } else if (eCode.getColumnValue().equals(YokaigoJotaiKubun02.要介護2.getコード())) {
            set要介護(entity, RString.EMPTY, まる, RString.EMPTY, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY);
        } else if (eCode.getColumnValue().equals(YokaigoJotaiKubun02.要介護3.getコード())) {
            set要介護(entity, RString.EMPTY, RString.EMPTY, まる, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY);
        } else if (eCode.getColumnValue().equals(YokaigoJotaiKubun02.要介護4.getコード())) {
            set要介護(entity, RString.EMPTY, RString.EMPTY, RString.EMPTY, まる,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY);
        } else if (eCode.getColumnValue().equals(YokaigoJotaiKubun02.要介護5.getコード())) {
            set要介護(entity, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    まる, RString.EMPTY, RString.EMPTY);
        }
        return entity;
    }

    private ShinseiShoEntity Kanri(ShinseiShoEntity entity, Code eCode) {
        if (eCode.getColumnValue().equals(YokaigoJotaiKubun06.要介護1.getコード())) {
            set要介護(entity, まる, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY);
        } else if (eCode.getColumnValue().equals(YokaigoJotaiKubun06.要介護2.getコード())) {
            set要介護(entity, RString.EMPTY, まる, RString.EMPTY, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY);
        } else if (eCode.getColumnValue().equals(YokaigoJotaiKubun06.要介護3.getコード())) {
            set要介護(entity, RString.EMPTY, RString.EMPTY, まる, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY);
        } else if (eCode.getColumnValue().equals(YokaigoJotaiKubun06.要介護4.getコード())) {
            set要介護(entity, RString.EMPTY, RString.EMPTY, RString.EMPTY, まる,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY);
        } else if (eCode.getColumnValue().equals(YokaigoJotaiKubun06.要介護5.getコード())) {
            set要介護(entity, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    まる, RString.EMPTY, RString.EMPTY);
        } else if (eCode.getColumnValue().equals(YokaigoJotaiKubun06.要支援1.getコード())) {
            set要介護(entity, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    RString.EMPTY, まる, RString.EMPTY);
        } else if (eCode.getColumnValue().equals(YokaigoJotaiKubun06.要支援2.getコード())) {
            set要介護(entity, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, まる);
        }
        return entity;
    }

    private ShinseiShoEntity sakusei(ShinseiShoEntity entity, Code eCode) {
        if (eCode.getColumnValue().equals(YokaigoJotaiKubun09.要介護1.getコード())) {
            set要介護(entity, まる, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY);
        } else if (eCode.getColumnValue().equals(YokaigoJotaiKubun09.要介護2.getコード())) {
            set要介護(entity, RString.EMPTY, まる, RString.EMPTY, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY);
        } else if (eCode.getColumnValue().equals(YokaigoJotaiKubun09.要介護3.getコード())) {
            set要介護(entity, RString.EMPTY, RString.EMPTY, まる, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY);
        } else if (eCode.getColumnValue().equals(YokaigoJotaiKubun09.要介護4.getコード())) {
            set要介護(entity, RString.EMPTY, RString.EMPTY, RString.EMPTY, まる,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY);
        } else if (eCode.getColumnValue().equals(YokaigoJotaiKubun09.要介護5.getコード())) {
            set要介護(entity, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    まる, RString.EMPTY, RString.EMPTY);
        } else if (eCode.getColumnValue().equals(YokaigoJotaiKubun09.要支援1.getコード())) {
            set要介護(entity, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    RString.EMPTY, まる, RString.EMPTY);
        } else if (eCode.getColumnValue().equals(YokaigoJotaiKubun09.要支援2.getコード())) {
            set要介護(entity, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, まる);
        }
        return entity;
    }

    private void set要介護(ShinseiShoEntity entity, RString 要介護状態区分1, RString 要介護状態区分2,
            RString 要介護状態区分3, RString 要介護状態区分4, RString 要介護状態区分5, RString 要支援状態区分1,
            RString 要支援状態区分2) {
        entity.set要介護状態区分1(要介護状態区分1);
        entity.set要介護状態区分2(要介護状態区分2);
        entity.set要介護状態区分3(要介護状態区分3);
        entity.set要介護状態区分4(要介護状態区分4);
        entity.set要介護状態区分5(要介護状態区分5);
        entity.set要支援状態区分1(要支援状態区分1);
        entity.set要支援状態区分2(要支援状態区分2);
    }

}
