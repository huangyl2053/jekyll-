/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.yokaigoninteijohoteikyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.ninteichosajohohyo42.NinteiChosaJohohyo42Report;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.processprm.yokaigoninteijohoteikyo.YokaigoBatchProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.yokaigoninteijohoteikyo.NinteiChosaJohohyoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.yokaigoninteijohoteikyo.YokaigoninteiEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosajohohyo.NinteiChosaJohohyo42ReportSource;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.yokaigoninteijohoteikyo.IYokaigoNinteiJohoTeikyoMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.tokuteishippei.TokuteiShippei;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun99;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser01;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser03;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser04;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser08;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser11;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser14;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser15;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser16;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser17;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser20;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser21;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser22;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser23;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.GenzainoJokyoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinchishoNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ShogaiNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode99;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.kekka.YokaigoJotaizoReiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.RensakusakiTsuzukigara;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5207NinteichosahyoServiceJokyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5208NinteichosahyoServiceJokyoFlagEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5209NinteichosahyoKinyuItemEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5211NinteichosahyoChosaItemEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.api.ReportInfo;

/**
 * 認定調査票の作成クラスです。
 *
 * @reamsid_L DBE-0230-030 zhangzhiming
 */
public class ChkNinteiChosahyo42Process extends BatchProcessBase<YokaigoninteiEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.yokaigoninteijohoteikyo."
            + "IYokaigoNinteiJohoTeikyoMapper.get要介護認定申請者");
    private YokaigoBatchProcessParamter processPrm;
    NinteiChosaJohohyoEntity bodyItem;
    IYokaigoNinteiJohoTeikyoMapper mapper;
    @BatchWriter
    private BatchReportWriter<NinteiChosaJohohyo42ReportSource> batchWrite42;
    private ReportSourceWriter<NinteiChosaJohohyo42ReportSource> reportSourceWriter42;
    private static final RString 判定結果コード09 = new RString("09");
    private static final RString 判定結果コード06 = new RString("06");
    private static final RString 判定結果コード02 = new RString("02");
    private static final RString 判定結果コード99 = new RString("99");
    private static final RString CSV出力有無 = new RString("なし");
    private static final RString CSVファイル名 = new RString("-");
    private static final RString 認定調査票チェックフラグ = new RString("【認定調査票チェックフラグ】");
    private static final RString 特記事項チェックフラグ = new RString("【特記事項チェックフラグ】");
    private static final RString 主治医意見書チェックフラグ = new RString("【主治医意見書チェックフラグ】");
    private static final RString その他資料チェックフラグ = new RString("【その他資料チェックフラグ】");
    private static final RString 一次判定結果チェックフラグ = new RString("【一次判定結果チェックフラグ】");
    private static final RString 総合事業開始区分 = new RString("【総合事業開始区分】");
    private static final RString テキスト = new RString("1");
    private static final RString イメージ = new RString("2");
    private static final RString イメージID01 = new RString("C0001.png");
    private static final RString イメージID02 = new RString("C0002.png");
    private static final RString イメージID03 = new RString("C0003.png");
    private static final RString イメージID04 = new RString("C0004.png");
    private static final RString イメージID05 = new RString("C0005.png");
    private static final RString イメージID06 = new RString("C0006.png");
    private static final int 連番1 = 1;
    private static final int 連番2 = 2;
    private static final int 連番3 = 3;
    private static final int 連番4 = 4;
    private static final int 連番5 = 5;
    private static final int 連番6 = 6;
    private static final int 連番7 = 7;
    private static final int 連番8 = 8;
    private static final int 連番9 = 9;
    private static final int 連番10 = 10;
    private static final int 連番11 = 11;
    private static final int 連番12 = 12;
    private static final int 連番13 = 13;
    private static final int 連番14 = 14;
    private static final int 連番15 = 15;
    private static final int 連番16 = 16;
    private static final int 連番17 = 17;
    private static final int 連番18 = 18;
    private static final int 連番19 = 19;
    private static final int 連番20 = 20;
    private static final int 連番21 = 21;
    private static final int 連番22 = 22;
    private static final int 連番23 = 23;
    private static final int 連番24 = 24;
    private static final int 連番25 = 25;
    private static final int 連番26 = 26;
    private static final int 連番27 = 27;
    private static final int 連番28 = 28;
    private static final int 連番29 = 29;
    private static final int 連番30 = 30;
    private static final int 連番31 = 31;
    private static final int 連番32 = 32;
    private static final int 連番33 = 33;
    private static final int 連番34 = 34;
    private static final int 連番35 = 35;
    private static final int 連番36 = 36;
    private static final int 連番37 = 37;
    private static final int 連番38 = 38;
    private static final int 連番39 = 39;
    private static final int 連番40 = 40;
    private static final int 連番41 = 41;
    private static final int 連番42 = 42;
    private static final int 連番43 = 43;
    private static final int 連番44 = 44;
    private static final int 連番45 = 45;
    private static final int 連番46 = 46;
    private static final int 連番47 = 47;
    private static final int 連番48 = 48;
    private static final int 連番49 = 49;
    private static final int 連番50 = 50;
    private static final int 連番51 = 51;
    private static final int 連番52 = 52;
    private static final int 連番53 = 53;
    private static final int 連番54 = 54;
    private static final int 連番55 = 55;
    private static final int 連番56 = 56;
    private static final int 連番57 = 57;
    private static final int 連番58 = 58;
    private static final int 連番59 = 59;
    private static final int 連番60 = 60;
    private static final int 連番61 = 61;
    private static final int 連番62 = 62;
    private static final int 連番63 = 63;
    private static final int 連番64 = 64;
    private static final int 連番65 = 65;
    private static final int 連番66 = 66;
    private static final int 連番67 = 67;
    private static final int 連番68 = 68;
    private static final int 連番69 = 69;
    private static final int 連番70 = 70;
    private static final int 連番71 = 71;
    private static final int 連番72 = 72;
    private static final int 連番73 = 73;
    private static final int 連番74 = 74;
    private static final int 連番75 = 75;
    private static final int 連番76 = 76;
    private static final int 連番77 = 77;
    private static final int 連番78 = 78;
    List<DbT5207NinteichosahyoServiceJokyoEntity> dbt5207Entity;
    List<DbT5211NinteichosahyoChosaItemEntity> dbt5211Entity;
    List<DbT5208NinteichosahyoServiceJokyoFlagEntity> dbt5208Entity;

    @Override
    protected void initialize() {
        dbt5207Entity = new ArrayList<>();
        dbt5211Entity = new ArrayList<>();
        dbt5208Entity = new ArrayList<>();
    }

    @Override
    protected void beforeExecute() {
        mapper = getMapper(IYokaigoNinteiJohoTeikyoMapper.class);
        dbt5207Entity = mapper.get認定調査票サービス状況(processPrm.toYokaigoBatchMybitisParamter());
        dbt5211Entity = mapper.get認定調査票調査項目(processPrm.toYokaigoBatchMybitisParamter());
        dbt5208Entity = mapper.get認定調査票フラグ(processPrm.toYokaigoBatchMybitisParamter());
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processPrm.toYokaigoBatchMybitisParamter());
    }

    @Override
    protected void createWriter() {
        batchWrite42 = BatchReportFactory.createBatchReportWriter(ReportIdDBE.DBE091042.getReportId().value()).create();
        reportSourceWriter42 = new ReportSourceWriter(batchWrite42);
    }

    @Override
    protected void process(YokaigoninteiEntity entity) {
        bodyItem = setBodyItem(entity);
        bodyItem.setサービス区分リスト_42(setサービス状況02(dbt5207Entity, dbt5208Entity));
        bodyItem.set麻痺拘縮1_リスト_42(set麻痺拘縮1_リスト(dbt5211Entity));
        bodyItem.set麻痺拘縮2_リスト_42(set麻痺拘縮2_リスト(dbt5211Entity));
        bodyItem.set移動リスト_42(set移動リスト(dbt5211Entity));
        bodyItem.set複雑動作リスト_42(set複雑動作リスト(dbt5211Entity));
        bodyItem.set特別介護リスト_42(set特別介護リスト(dbt5211Entity));
        bodyItem.set身の回りリスト_42(set身の回りリスト(dbt5211Entity));
        bodyItem.set意思疎通リスト_42(set意思疎通リスト(dbt5211Entity));
        bodyItem.set問題行動リスト_42(set問題行動リスト(dbt5211Entity));
        bodyItem.set特別な医療リスト_42(set特別な医療リスト(dbt5211Entity));
        NinteiChosaJohohyo42Report report = new NinteiChosaJohohyo42Report(bodyItem);
        report.writeBy(reportSourceWriter42);
    }

    @Override
    protected void afterExecute() {
        set出力条件表();
    }

    private List<RString> set特別な医療リスト(List<DbT5211NinteichosahyoChosaItemEntity> dbt5211Entity) {
        List<RString> 特別な医療リスト = new ArrayList<>();
        特別な医療リスト.add(get名称01(dbt5211Entity, 連番67));
        特別な医療リスト.add(get名称01(dbt5211Entity, 連番68));
        特別な医療リスト.add(get名称01(dbt5211Entity, 連番69));
        特別な医療リスト.add(get名称01(dbt5211Entity, 連番70));
        特別な医療リスト.add(get名称01(dbt5211Entity, 連番71));
        特別な医療リスト.add(get名称01(dbt5211Entity, 連番72));
        特別な医療リスト.add(get名称01(dbt5211Entity, 連番73));
        特別な医療リスト.add(get名称01(dbt5211Entity, 連番74));
        特別な医療リスト.add(get名称01(dbt5211Entity, 連番75));
        特別な医療リスト.add(get名称01(dbt5211Entity, 連番76));
        特別な医療リスト.add(get名称01(dbt5211Entity, 連番77));
        特別な医療リスト.add(get名称01(dbt5211Entity, 連番78));
        return 特別な医療リスト;
    }

    private List<RString> set問題行動リスト(List<DbT5211NinteichosahyoChosaItemEntity> dbt5211Entity) {
        List<RString> 問題行動リスト = new ArrayList<>();
        問題行動リスト.add(get名称16(dbt5211Entity, 連番48));
        問題行動リスト.add(get名称16(dbt5211Entity, 連番49));
        問題行動リスト.add(get名称16(dbt5211Entity, 連番50));
        問題行動リスト.add(get名称16(dbt5211Entity, 連番51));
        問題行動リスト.add(get名称16(dbt5211Entity, 連番52));
        問題行動リスト.add(get名称16(dbt5211Entity, 連番53));
        問題行動リスト.add(get名称16(dbt5211Entity, 連番54));
        問題行動リスト.add(get名称16(dbt5211Entity, 連番55));
        問題行動リスト.add(get名称16(dbt5211Entity, 連番56));
        問題行動リスト.add(get名称16(dbt5211Entity, 連番57));
        問題行動リスト.add(get名称16(dbt5211Entity, 連番58));
        問題行動リスト.add(get名称16(dbt5211Entity, 連番59));
        問題行動リスト.add(get名称16(dbt5211Entity, 連番60));
        問題行動リスト.add(get名称16(dbt5211Entity, 連番61));
        問題行動リスト.add(get名称16(dbt5211Entity, 連番62));
        問題行動リスト.add(get名称16(dbt5211Entity, 連番63));
        問題行動リスト.add(get名称16(dbt5211Entity, 連番64));
        問題行動リスト.add(get名称16(dbt5211Entity, 連番65));
        問題行動リスト.add(get名称16(dbt5211Entity, 連番66));
        return 問題行動リスト;
    }

    private List<RString> set意思疎通リスト(List<DbT5211NinteichosahyoChosaItemEntity> dbt5211Entity) {
        List<RString> 意思疎通リスト = new ArrayList<>();
        意思疎通リスト.add(get名称08(dbt5211Entity, 連番38));
        意思疎通リスト.add(get名称09(dbt5211Entity, 連番39));
        意思疎通リスト.add(get名称14(dbt5211Entity, 連番40));
        意思疎通リスト.add(get名称23(dbt5211Entity, 連番41));
        意思疎通リスト.add(get名称15(dbt5211Entity, 連番42));
        意思疎通リスト.add(get名称15(dbt5211Entity, 連番43));
        意思疎通リスト.add(get名称15(dbt5211Entity, 連番44));
        意思疎通リスト.add(get名称15(dbt5211Entity, 連番45));
        意思疎通リスト.add(get名称15(dbt5211Entity, 連番46));
        意思疎通リスト.add(get名称15(dbt5211Entity, 連番47));
        return 意思疎通リスト;
    }

    private List<RString> set身の回りリスト(List<DbT5211NinteichosahyoChosaItemEntity> dbt5211Entity) {
        List<RString> 身の回りリスト = new ArrayList<>();
        身の回りリスト.add(get名称22(dbt5211Entity, 連番28));
        身の回りリスト.add(get名称22(dbt5211Entity, 連番29));
        身の回りリスト.add(get名称22(dbt5211Entity, 連番30));
        身の回りリスト.add(get名称22(dbt5211Entity, 連番31));
        身の回りリスト.add(get名称20(dbt5211Entity, 連番32));
        身の回りリスト.add(get名称20(dbt5211Entity, 連番33));
        身の回りリスト.add(get名称22(dbt5211Entity, 連番34));
        身の回りリスト.add(get名称22(dbt5211Entity, 連番35));
        身の回りリスト.add(get名称22(dbt5211Entity, 連番36));
        身の回りリスト.add(get名称17(dbt5211Entity, 連番37));
        return 身の回りリスト;
    }

    private List<RString> set特別介護リスト(List<DbT5211NinteichosahyoChosaItemEntity> dbt5211Entity) {
        List<RString> 特別介護リスト = new ArrayList<>();
        特別介護リスト.add(get名称01(dbt5211Entity, 連番21));
        特別介護リスト.add(get名称01(dbt5211Entity, 連番22));
        特別介護リスト.add(get名称11(dbt5211Entity, 連番23));
        特別介護リスト.add(get名称20(dbt5211Entity, 連番24));
        特別介護リスト.add(get名称20(dbt5211Entity, 連番25));
        特別介護リスト.add(get名称20(dbt5211Entity, 連番26));
        特別介護リスト.add(get名称20(dbt5211Entity, 連番27));
        return 特別介護リスト;
    }

    private List<RString> set複雑動作リスト(List<DbT5211NinteichosahyoChosaItemEntity> dbt5211Entity) {
        List<RString> 複雑動作リスト = new ArrayList<>();
        複雑動作リスト.add(get名称02(dbt5211Entity, 連番18));
        複雑動作リスト.add(get名称04(dbt5211Entity, 連番19));
        複雑動作リスト.add(get名称21(dbt5211Entity, 連番20));
        return 複雑動作リスト;
    }

    private List<RString> set麻痺拘縮1_リスト(List<DbT5211NinteichosahyoChosaItemEntity> dbt5211Entity) {
        List<RString> 麻痺拘縮1_リスト = new ArrayList<>();
        麻痺拘縮1_リスト.add(get名称01(dbt5211Entity, 0));
        麻痺拘縮1_リスト.add(get名称01(dbt5211Entity, 連番2));
        麻痺拘縮1_リスト.add(get名称01(dbt5211Entity, 連番4));
        麻痺拘縮1_リスト.add(get名称01(dbt5211Entity, 連番5));
        麻痺拘縮1_リスト.add(get名称01(dbt5211Entity, 連番7));
        麻痺拘縮1_リスト.add(get名称01(dbt5211Entity, 連番9));
        return 麻痺拘縮1_リスト;
    }

    private List<RString> set麻痺拘縮2_リスト(List<DbT5211NinteichosahyoChosaItemEntity> dbt5211Entity) {
        List<RString> 麻痺拘縮2_リスト = new ArrayList<>();
        麻痺拘縮2_リスト.add(get名称01(dbt5211Entity, 連番1));
        麻痺拘縮2_リスト.add(get名称01(dbt5211Entity, 連番3));
        麻痺拘縮2_リスト.add(RString.EMPTY);
        麻痺拘縮2_リスト.add(get名称01(dbt5211Entity, 連番6));
        麻痺拘縮2_リスト.add(get名称01(dbt5211Entity, 連番8));
        麻痺拘縮2_リスト.add(get名称01(dbt5211Entity, 連番10));
        return 麻痺拘縮2_リスト;
    }

    private List<RString> set移動リスト(List<DbT5211NinteichosahyoChosaItemEntity> dbt5211Entity) {
        List<RString> 移動リスト = new ArrayList<>();
        移動リスト.add(get名称02(dbt5211Entity, 連番11));
        移動リスト.add(get名称02(dbt5211Entity, 連番12));
        移動リスト.add(get名称03(dbt5211Entity, 連番13));
        移動リスト.add(get名称04(dbt5211Entity, 連番14));
        移動リスト.add(get名称02(dbt5211Entity, 連番15));
        移動リスト.add(get名称20(dbt5211Entity, 連番16));
        移動リスト.add(get名称20(dbt5211Entity, 連番17));
        return 移動リスト;
    }

    private List<RString> setサービス状況02(List<DbT5207NinteichosahyoServiceJokyoEntity> dbt5207Entity,
            List<DbT5208NinteichosahyoServiceJokyoFlagEntity> dbt5208Entity) {
        List<RString> サービス区分リスト = new ArrayList<>();
        サービス区分リスト.add(new RString(getサービス状況02(dbt5207Entity, 0)));
        サービス区分リスト.add(new RString(getサービス状況02(dbt5207Entity, 連番1)));
        サービス区分リスト.add(new RString(getサービス状況02(dbt5207Entity, 連番2)));
        サービス区分リスト.add(new RString(getサービス状況02(dbt5207Entity, 連番3)));
        サービス区分リスト.add(new RString(getサービス状況02(dbt5207Entity, 連番4)));
        サービス区分リスト.add(new RString(getサービス状況02(dbt5207Entity, 連番5)));
        サービス区分リスト.add(new RString(getサービス状況02(dbt5207Entity, 連番6)));
        サービス区分リスト.add(new RString(getサービス状況02(dbt5207Entity, 連番7)));
        サービス区分リスト.add(new RString(getサービス状況02(dbt5207Entity, 連番8)));
        サービス区分リスト.add(new RString(getサービス状況02(dbt5207Entity, 連番9)));
        サービス区分リスト.add(new RString(getサービス状況02(dbt5207Entity, 連番10)));
        サービス区分リスト.add(new RString(getサービス状況02(dbt5207Entity, 連番11)));
        サービス区分リスト.add(new RString(getサービス状況02(dbt5207Entity, 連番12)));
        if (dbt5208Entity != null && !dbt5208Entity.isEmpty() && dbt5208Entity.get(0).getServiceJokyoFlag()) {
            サービス区分リスト.add(new RString("1"));
        } else {
            サービス区分リスト.add(new RString("0"));
        }
        return サービス区分リスト;
    }

    private int getサービス状況02(List<DbT5207NinteichosahyoServiceJokyoEntity> dbt5207Entity, int 連番) {
        if (連番 < dbt5207Entity.size()) {
            return dbt5207Entity.get(連番).getServiceJokyo();
        }
        return 0;
    }

    private NinteiChosaJohohyoEntity setBodyItem(YokaigoninteiEntity entity) {
        NinteiChosaJohohyoEntity ninteiEntity = new NinteiChosaJohohyoEntity();
        ninteiEntity.set保険者番号(entity.get保険者番号());
        ninteiEntity.set被保険者番号(entity.get被保険者番号());
        ninteiEntity.set被保険者氏名(entity.get被保険者氏名());
        ninteiEntity.set申請日_元号(entity.get認定申請年月日() == null ? RString.EMPTY : entity.get認定申請年月日()
                .wareki().eraType(EraType.KANJI).getEra());
        ninteiEntity.set申請日_年(entity.get認定申請年月日() == null ? RString.EMPTY : entity.get認定申請年月日()
                .wareki().eraType(EraType.KANJI).getYear());
        ninteiEntity.set申請日_月(entity.get認定申請年月日() == null ? RString.EMPTY : entity.get認定申請年月日()
                .wareki().eraType(EraType.KANJI).getMonth());
        ninteiEntity.set申請日_日(entity.get認定申請年月日() == null ? RString.EMPTY : entity.get認定申請年月日()
                .wareki().eraType(EraType.KANJI).getDay());
        ninteiEntity.set作成日_元号(entity.get作成年月日() == null ? RString.EMPTY : entity.get作成年月日()
                .wareki().eraType(EraType.KANJI).getEra());
        ninteiEntity.set作成日_年(entity.get作成年月日() == null ? RString.EMPTY : entity.get作成年月日()
                .wareki().eraType(EraType.KANJI).getYear());
        ninteiEntity.set作成日_月(entity.get作成年月日() == null ? RString.EMPTY : entity.get作成年月日()
                .wareki().eraType(EraType.KANJI).getMonth());
        ninteiEntity.set作成日_日(entity.get作成年月日() == null ? RString.EMPTY : entity.get作成年月日()
                .wareki().eraType(EraType.KANJI).getDay());
        ninteiEntity.set調査日_元号(entity.get実施年月日() == null ? RString.EMPTY : entity.get実施年月日()
                .wareki().eraType(EraType.KANJI).getEra());
        ninteiEntity.set調査日_年(entity.get実施年月日() == null ? RString.EMPTY : entity.get実施年月日()
                .wareki().eraType(EraType.KANJI).getYear());
        ninteiEntity.set調査日_月(entity.get実施年月日() == null ? RString.EMPTY : entity.get実施年月日()
                .wareki().eraType(EraType.KANJI).getMonth());
        ninteiEntity.set調査日_日(entity.get実施年月日() == null ? RString.EMPTY : entity.get実施年月日()
                .wareki().eraType(EraType.KANJI).getDay());
        ninteiEntity.set審査日_元号(entity.get審査会開催日() == null ? RString.EMPTY : entity.get審査会開催日()
                .wareki().eraType(EraType.KANJI).getEra());
        ninteiEntity.set審査日_年(entity.get審査会開催日() == null ? RString.EMPTY : entity.get審査会開催日()
                .wareki().eraType(EraType.KANJI).getYear());
        ninteiEntity.set審査日_月(entity.get審査会開催日() == null ? RString.EMPTY : entity.get審査会開催日()
                .wareki().eraType(EraType.KANJI).getMonth());
        ninteiEntity.set審査日_日(entity.get審査会開催日() == null ? RString.EMPTY : entity.get審査会開催日()
                .wareki().eraType(EraType.KANJI).getDay());
        ninteiEntity.setタイトル(DbBusinessConfig.get(ConfigNameDBE.認定調査情報票, RDate.getNowDate(), SubGyomuCode.DBE認定支援));
        ninteiEntity.set年齢(entity.get年齢());
        ninteiEntity.set性別(Seibetsu.toValue(entity.get性別()).get名称());
        ninteiEntity.set郵便番号(entity.get郵便番号());
        ninteiEntity.set電話(entity.get電話());
        ninteiEntity.set現住所(entity.get住所());
        ninteiEntity.set家族連絡先郵便番号(entity.get連絡先郵便番号());
        ninteiEntity.set家族連絡先電話1(entity.get連絡先電話電話());
        ninteiEntity.set家族連絡先電話2(entity.get連絡先携帯電話());
        ninteiEntity.set家族連絡先住所(entity.get連絡先住所());
        ninteiEntity.set家族連絡先名(entity.get連絡先氏名());
        setBodyItem01(ninteiEntity, entity);
        return ninteiEntity;
    }

    private void setBodyItem01(NinteiChosaJohohyoEntity ninteiEntity, YokaigoninteiEntity entity) {
        setBodyItem02(ninteiEntity, entity);
        ninteiEntity.set家族連絡先関係(RString.isNullOrEmpty(entity.get関係()) ? RString.EMPTY
                : RensakusakiTsuzukigara.toValue(entity.get関係()).get名称());
        ninteiEntity.set申請区分_申(RString.isNullOrEmpty(entity.get申請区分_申()) ? RString.EMPTY : NinteiShinseiShinseijiKubunCode
                .toValue(entity.get申請区分_申()).get名称());
        ninteiEntity.set変更事由(entity.get変更事由());
        ninteiEntity.set二次判定日(entity.get二次判定年月日() == null ? RString.EMPTY : entity.get二次判定年月日().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        ninteiEntity.set認定有効時間_月(entity.get認定有効期間());
        ninteiEntity.set認定有効時間From(entity.get認定有効期間開始年月日() == null ? RString.EMPTY : entity.get認定有効期間開始年月日().
                wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        ninteiEntity.set認定有効時間To(entity.get認定有効期間終了年月日() == null ? RString.EMPTY : entity.get認定有効期間終了年月日()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        ninteiEntity.set状態像コード(RString.isNullOrEmpty(entity.get要介護状態像例コード()) ? RString.EMPTY
                : YokaigoJotaizoReiCode.toValue(entity.get要介護状態像例コード()).get名称());
        ninteiEntity.set特定疾病(RString.isNullOrEmpty(entity.get特定疾病()) ? RString.EMPTY
                : TokuteiShippei.toValue(entity.get特定疾病()).get名称());
        ninteiEntity.set審査会意見(entity.get審査会意見());
        ninteiEntity.set前回判定日(entity.get前回認定日() == null ? RString.EMPTY : entity.get前回認定日().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        ninteiEntity.set前回判定有効時間_月(entity.get前回認定有効期間());
        ninteiEntity.set前回判定有効時間From(entity.get前回認定有効期間開始年月日() == null ? RString.EMPTY : entity.get前回認定有効期間開始年月日()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        ninteiEntity.set前回判定有効時間To(entity.get前回認定有効期間終了年月日() == null ? RString.EMPTY : entity.get前回認定有効期間終了年月日()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        ninteiEntity.set調査実施日(entity.get実施年月日() == null ? RString.EMPTY : entity.get実施年月日().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        ninteiEntity.set実施場所コード(entity.get実施場所コード());
        ninteiEntity.set記入者(entity.get調査員氏名());
        ninteiEntity.set厚労省IF識別コード(entity.get厚労省IF識別コード());
        ninteiEntity.setサービス区分コード(entity.getサービス区分コード());
        List<DbT5209NinteichosahyoKinyuItemEntity> dbt5209Entity = mapper.get認定調査票記入項目(processPrm.toYokaigoBatchMybitisParamter());
        if (テキスト.equals(entity.getテキスト_イメージ区分())) {
            ninteiEntity.set実施場所名称(entity.get実施場所名称());
            ninteiEntity.set市町村特別給付(get市町村特別給付(dbt5209Entity, 0));
            ninteiEntity.set介護保険給付外の在宅(get市町村特別給付(dbt5209Entity, 連番1));
            ninteiEntity.set施設名(entity.get施設名());
            ninteiEntity.set施設住所(entity.get施設住所());
            ninteiEntity.set施設電話(entity.get施設電話番号());
        } else {
            ninteiEntity.set実施場所名称(RString.EMPTY);
            ninteiEntity.set市町村特別給付(RString.EMPTY);
            ninteiEntity.set介護保険給付外の在宅(RString.EMPTY);
            ninteiEntity.set施設名(RString.EMPTY);
            ninteiEntity.set施設住所(RString.EMPTY);
            ninteiEntity.set施設電話(RString.EMPTY);
        }
        RDateTime イメージID = mapper.getイメージ(processPrm.toYokaigoBatchMybitisParamter());
        if (イメージ.equals(entity.getテキスト_イメージ区分())) {
            ninteiEntity.set実施場所イメージ(共有ファイルを引き出す(イメージID, イメージID01));
            ninteiEntity.set市町村特別給付イメージ(共有ファイルを引き出す(イメージID, イメージID02));
            ninteiEntity.set介護保険給付外の在宅イメージ(共有ファイルを引き出す(イメージID, イメージID03));
            ninteiEntity.set施設名イメージ(共有ファイルを引き出す(イメージID, イメージID04));
            ninteiEntity.set施設住所イメージ(共有ファイルを引き出す(イメージID, イメージID05));
            ninteiEntity.set施設電話イメージ(共有ファイルを引き出す(イメージID, イメージID06));
        }
        ninteiEntity.set施設利用(RString.isNullOrEmpty(entity.get施設利用()) ? RString.EMPTY
                : GenzainoJokyoCode.toValue(entity.get施設利用()).get名称());
        ninteiEntity.set所属機関(entity.get事業者名称());
        List<RString> 日常生活自立度リスト = new ArrayList<>();
        日常生活自立度リスト.add(RString.isNullOrEmpty(entity.get障害高齢者自立度()) ? RString.EMPTY
                : ShogaiNichijoSeikatsuJiritsudoCode.toValue(entity.get障害高齢者自立度()).get名称());
        日常生活自立度リスト.add(RString.isNullOrEmpty(entity.get認知症高齢者自立度()) ? RString.EMPTY
                : NinchishoNichijoSeikatsuJiritsudoCode.toValue(entity.get認知症高齢者自立度()).get名称());
        ninteiEntity.set日常生活自立度リスト(日常生活自立度リスト);
    }

    private RString get市町村特別給付(List<DbT5209NinteichosahyoKinyuItemEntity> dbt5209Entity, int 連番) {
        if (連番 < dbt5209Entity.size()) {
            return dbt5209Entity.get(連番).getServiceJokyoKinyu();
        }
        return RString.EMPTY;
    }

    private void setBodyItem02(NinteiChosaJohohyoEntity ninteiEntity, YokaigoninteiEntity entity) {
        if (判定結果コード09.equals(entity.get厚労省IF識別コード().substring(0, 2))) {
            ninteiEntity.set一次判定結果(RString.isNullOrEmpty(entity.get一次判定結果()) ? RString.EMPTY
                    : IchijiHanteiKekkaCode09.toValue(entity.get一次判定結果()).get名称());
            ninteiEntity.set二次判定結果(RString.isNullOrEmpty(entity.get二次判定結果()) ? RString.EMPTY
                    : YokaigoJotaiKubun09.toValue(entity.get二次判定結果()).get名称());
            ninteiEntity.set前回判定結果(RString.isNullOrEmpty(entity.get前回認定結果()) ? RString.EMPTY
                    : YokaigoJotaiKubun09.toValue(entity.get前回認定結果()).get名称());
        }
        if (判定結果コード06.equals(entity.get厚労省IF識別コード().substring(0, 2))) {
            ninteiEntity.set一次判定結果(RString.isNullOrEmpty(entity.get一次判定結果()) ? RString.EMPTY
                    : IchijiHanteiKekkaCode06.toValue(entity.get一次判定結果()).get名称());
            ninteiEntity.set二次判定結果(RString.isNullOrEmpty(entity.get二次判定結果()) ? RString.EMPTY
                    : YokaigoJotaiKubun06.toValue(entity.get二次判定結果()).get名称());
            ninteiEntity.set前回判定結果(RString.isNullOrEmpty(entity.get前回認定結果()) ? RString.EMPTY
                    : YokaigoJotaiKubun06.toValue(entity.get前回認定結果()).get名称());
        }
        if (判定結果コード02.equals(entity.get厚労省IF識別コード().substring(0, 2))) {
            ninteiEntity.set一次判定結果(RString.isNullOrEmpty(entity.get一次判定結果()) ? RString.EMPTY
                    : IchijiHanteiKekkaCode02.toValue(entity.get一次判定結果()).get名称());
            ninteiEntity.set二次判定結果(RString.isNullOrEmpty(entity.get二次判定結果()) ? RString.EMPTY
                    : YokaigoJotaiKubun02.toValue(entity.get二次判定結果()).get名称());
            ninteiEntity.set前回判定結果(RString.isNullOrEmpty(entity.get前回認定結果()) ? RString.EMPTY
                    : YokaigoJotaiKubun02.toValue(entity.get前回認定結果()).get名称());
        }
        if (判定結果コード99.equals(entity.get厚労省IF識別コード().substring(0, 2))) {
            ninteiEntity.set一次判定結果(RString.isNullOrEmpty(entity.get一次判定結果()) ? RString.EMPTY
                    : IchijiHanteiKekkaCode99.toValue(entity.get一次判定結果()).get名称());
            ninteiEntity.set二次判定結果(RString.isNullOrEmpty(entity.get二次判定結果()) ? RString.EMPTY
                    : YokaigoJotaiKubun99.toValue(entity.get二次判定結果()).get名称());
            ninteiEntity.set前回判定結果(RString.isNullOrEmpty(entity.get前回認定結果()) ? RString.EMPTY
                    : YokaigoJotaiKubun99.toValue(entity.get前回認定結果()).get名称());
        }
    }

    private RString 共有ファイルを引き出す(RDateTime イメージID, RString イメージID01) {
        RString imagePath = RString.EMPTY;
        if (イメージID != null) {
            imagePath = getFilePath(イメージID, イメージID01);
        }
        return imagePath;
    }

    private RString getFilePath(RDateTime sharedFileId, RString sharedFileName) {
        RString imagePath = Path.combinePath(Path.getUserHomePath(), new RString("app/webapps/db#dbe/WEB-INF/image/"));
        ReadOnlySharedFileEntryDescriptor descriptor
                = new ReadOnlySharedFileEntryDescriptor(new FilesystemName(sharedFileName),
                        sharedFileId);
        try {
            SharedFile.copyToLocal(descriptor, new FilesystemPath(imagePath));
        } catch (Exception e) {
            return RString.EMPTY;
        }
        return Path.combinePath(new RString("/db/dbe/image/"), sharedFileName);
    }

    private RString get名称17(List<DbT5211NinteichosahyoChosaItemEntity> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size()) {
            if (RString.isNullOrEmpty(dbt5211Entity.get(連番).getResearchItem())) {
                return RString.EMPTY;
            }
            return ChosaAnser17.toValue(dbt5211Entity.get(連番).getResearchItem()).get名称();
        }
        return RString.EMPTY;
    }

    private RString get名称16(List<DbT5211NinteichosahyoChosaItemEntity> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size()) {
            if (RString.isNullOrEmpty(dbt5211Entity.get(連番).getResearchItem())) {
                return RString.EMPTY;
            }
            return ChosaAnser16.toValue(dbt5211Entity.get(連番).getResearchItem()).get名称();
        }
        return RString.EMPTY;
    }

    private RString get名称15(List<DbT5211NinteichosahyoChosaItemEntity> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size()) {
            if (RString.isNullOrEmpty(dbt5211Entity.get(連番).getResearchItem())) {
                return RString.EMPTY;
            }
            return ChosaAnser15.toValue(dbt5211Entity.get(連番).getResearchItem()).get名称();
        }
        return RString.EMPTY;
    }

    private RString get名称14(List<DbT5211NinteichosahyoChosaItemEntity> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size()) {
            if (RString.isNullOrEmpty(dbt5211Entity.get(連番).getResearchItem())) {
                return RString.EMPTY;
            }
            return ChosaAnser14.toValue(dbt5211Entity.get(連番).getResearchItem()).get名称();
        }
        return RString.EMPTY;
    }

    private RString get名称23(List<DbT5211NinteichosahyoChosaItemEntity> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size()) {
            if (RString.isNullOrEmpty(dbt5211Entity.get(連番).getResearchItem())) {
                return RString.EMPTY;
            }
            return ChosaAnser23.toValue(dbt5211Entity.get(連番).getResearchItem()).get名称();
        }
        return RString.EMPTY;
    }

    private RString get名称11(List<DbT5211NinteichosahyoChosaItemEntity> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size()) {
            if (RString.isNullOrEmpty(dbt5211Entity.get(連番).getResearchItem())) {
                return RString.EMPTY;
            }
            return ChosaAnser11.toValue(dbt5211Entity.get(連番).getResearchItem()).get名称();
        }
        return RString.EMPTY;
    }

    private RString get名称22(List<DbT5211NinteichosahyoChosaItemEntity> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size()) {
            if (RString.isNullOrEmpty(dbt5211Entity.get(連番).getResearchItem())) {
                return RString.EMPTY;
            }
            return ChosaAnser22.toValue(dbt5211Entity.get(連番).getResearchItem()).get名称();
        }
        return RString.EMPTY;
    }

    private RString get名称09(List<DbT5211NinteichosahyoChosaItemEntity> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size()) {
            if (RString.isNullOrEmpty(dbt5211Entity.get(連番).getResearchItem())) {
                return RString.EMPTY;
            }
            return ChosaAnser09.toValue(dbt5211Entity.get(連番).getResearchItem()).get名称();
        }
        return RString.EMPTY;
    }

    private RString get名称08(List<DbT5211NinteichosahyoChosaItemEntity> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size()) {
            if (RString.isNullOrEmpty(dbt5211Entity.get(連番).getResearchItem())) {
                return RString.EMPTY;
            }
            return ChosaAnser08.toValue(dbt5211Entity.get(連番).getResearchItem()).get名称();
        }
        return RString.EMPTY;
    }

    private RString get名称21(List<DbT5211NinteichosahyoChosaItemEntity> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size()) {
            if (RString.isNullOrEmpty(dbt5211Entity.get(連番).getResearchItem())) {
                return RString.EMPTY;
            }
            return ChosaAnser21.toValue(dbt5211Entity.get(連番).getResearchItem()).get名称();
        }
        return RString.EMPTY;
    }

    private RString get名称20(List<DbT5211NinteichosahyoChosaItemEntity> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size()) {
            if (RString.isNullOrEmpty(dbt5211Entity.get(連番).getResearchItem())) {
                return RString.EMPTY;
            }
            return ChosaAnser20.toValue(dbt5211Entity.get(連番).getResearchItem()).get名称();
        }
        return RString.EMPTY;
    }

    private RString get名称04(List<DbT5211NinteichosahyoChosaItemEntity> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size()) {
            if (RString.isNullOrEmpty(dbt5211Entity.get(連番).getResearchItem())) {
                return RString.EMPTY;
            }
            return ChosaAnser04.toValue(dbt5211Entity.get(連番).getResearchItem()).get名称();
        }
        return RString.EMPTY;
    }

    private RString get名称03(List<DbT5211NinteichosahyoChosaItemEntity> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size()) {
            if (RString.isNullOrEmpty(dbt5211Entity.get(連番).getResearchItem())) {
                return RString.EMPTY;
            }
            return ChosaAnser03.toValue(dbt5211Entity.get(連番).getResearchItem()).get名称();
        }
        return RString.EMPTY;
    }

    private RString get名称02(List<DbT5211NinteichosahyoChosaItemEntity> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size()) {
            if (RString.isNullOrEmpty(dbt5211Entity.get(連番).getResearchItem())) {
                return RString.EMPTY;
            }
            return ChosaAnser02.toValue(dbt5211Entity.get(連番).getResearchItem()).get名称();
        }
        return RString.EMPTY;
    }

    private RString get名称01(List<DbT5211NinteichosahyoChosaItemEntity> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size()) {
            if (RString.isNullOrEmpty(dbt5211Entity.get(連番).getResearchItem())) {
                return RString.EMPTY;
            }
            return ChosaAnser01.toValue(dbt5211Entity.get(連番).getResearchItem()).get名称();
        }
        return RString.EMPTY;
    }

    private void set出力条件表() {
        List<RString> 出力条件 = new ArrayList();
        RStringBuilder builder = new RStringBuilder();
        builder.append(認定調査票チェックフラグ);
        builder.append(processPrm.getChkNinteiChosahyo());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(特記事項チェックフラグ);
        builder.append(processPrm.getChkTokkiJiko());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(主治医意見書チェックフラグ);
        builder.append(processPrm.getChkShujiiIkensho());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(その他資料チェックフラグ);
        builder.append(processPrm.getChkSonotaShiryo());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(一次判定結果チェックフラグ);
        builder.append(processPrm.getChkIchijiHanteiKekka());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(総合事業開始区分);
        builder.append(DbBusinessConfig.get(ConfigNameDBE.総合事業開始区分, RDate.getNowDate(), SubGyomuCode.DBE認定支援));
        出力条件.add(builder.toRString());
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        ReportOutputJokenhyoItem 帳票出力条件表パラメータ
                = new ReportOutputJokenhyoItem(
                        ReportIdDBE.DBE091042.getReportId().value(),
                        association.getLasdecCode_().getColumnValue(),
                        association.get市町村名(),
                        new RString(JobContextHolder.getJobId()),
                        ReportInfo.getReportName(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE091042.getReportId().value()),
                        new RString(String.valueOf(reportSourceWriter42.pageCount().value())),
                        CSV出力有無,
                        CSVファイル名,
                        出力条件);
        OutputJokenhyoFactory.createInstance(帳票出力条件表パラメータ).print();
    }
}
