/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.yokaigoninteijohoteikyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.chkichijihanteikekka.ChkIchijiHanteiKekkaBusiness;
import jp.co.ndensan.reams.db.dbe.business.report.ichijihanteikekkahyo.IchijihanteikekkahyoReport;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.processprm.yokaigoninteijohoteikyo.YokaigoBatchProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteikekkahyoa4.IchijihanteikekkahyoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.yokaigoninteijohoteikyo.YokaigoninteiEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ichijihanteikekkahyoa4.IchijihanteikekkahyoReportSource;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.yokaigoninteijohoteikyo.IYokaigoNinteiJohoTeikyoMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.tokuteishippei.TokuteiShippei;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun99;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.Sikaku;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser01;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser03;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser04;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser07;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser08;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser10;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser11;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser12;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser13;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser16;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser17;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser20;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser21;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser22;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser33;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser34;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.GenzainoJokyoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinchishoNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ServiceKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ShogaiNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.JotaiAnteiseiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.SuiteiKyufuKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.kekka.YokaigoJotaizoReiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5207NinteichosahyoServiceJokyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5208NinteichosahyoServiceJokyoFlagEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5211NinteichosahyoChosaItemEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5304ShujiiIkenshoIkenItemEntity;
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
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.api.ReportInfo;

/**
 * 一次判定結果の作成クラスです。
 *
 * @reamsid_L DBE-0230-030 zhangzhiming
 */
public class ChkIchijiHanteiKekkaProcess extends BatchProcessBase<YokaigoninteiEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.yokaigoninteijohoteikyo."
            + "IYokaigoNinteiJohoTeikyoMapper.get要介護認定申請者");
    private YokaigoBatchProcessParamter processPrm;
    IchijihanteikekkahyoEntity bodyItem;
    IYokaigoNinteiJohoTeikyoMapper mapper;
    @BatchWriter
    private BatchReportWriter<IchijihanteikekkahyoReportSource> batchWrite;
    private ReportSourceWriter<IchijihanteikekkahyoReportSource> reportSourceWriter;
    private static final RString 判定結果コード09 = new RString("09");
    private static final RString 判定結果コード06 = new RString("06");
    private static final RString 判定結果コード02 = new RString("02");
    private static final RString 判定結果コード99 = new RString("99");
    private static final RString 識別コード09B = new RString("09B");
    private static final RString 識別コード06A = new RString("06A");
    private static final RString 識別コード02A = new RString("02A");
    private static final RString 識別コード09A = new RString("09A");
    private static final RString 識別コード99A = new RString("99A");
    private static final RString CSV出力有無 = new RString("なし");
    private static final RString CSVファイル名 = new RString("-");
    private static final RString 認定調査票チェックフラグ = new RString("【認定調査票チェックフラグ】");
    private static final RString 特記事項チェックフラグ = new RString("【特記事項チェックフラグ】");
    private static final RString 主治医意見書チェックフラグ = new RString("【主治医意見書チェックフラグ】");
    private static final RString その他資料チェックフラグ = new RString("【その他資料チェックフラグ】");
    private static final RString 一次判定結果チェックフラグ = new RString("【一次判定結果チェックフラグ】");
    private static final RString 総合事業開始区分 = new RString("【総合事業開始区分】");
    private static final RString 印刷する = new RString("1");
    private static final RString 印刷しない = new RString("2");
    private static final RString 差分のみ印刷 = new RString("3");
    private static final RString 認定情報_事務局用 = new RString("認定情報(事務局用)");
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
    private static final int 連番79 = 79;
    private static final int 連番80 = 80;
    private static final int 連番81 = 81;
    private static final int 連番82 = 82;
    private static final int 連番83 = 83;
    private static final int 連番84 = 84;
    List<RString> list;
    List<DbT5207NinteichosahyoServiceJokyoEntity> dbt5207Entity;
    List<DbT5211NinteichosahyoChosaItemEntity> 調査項目;
    List<DbT5211NinteichosahyoChosaItemEntity> 前回調査項目;
    List<DbT5304ShujiiIkenshoIkenItemEntity> 意見書項目;
    List<DbT5304ShujiiIkenshoIkenItemEntity> 前回意見書項目;
    List<DbT5208NinteichosahyoServiceJokyoFlagEntity> dbt5208Entity;

    @Override
    protected void initialize() {
        list = new ArrayList<>();
        dbt5207Entity = new ArrayList<>();
        調査項目 = new ArrayList<>();
        前回調査項目 = new ArrayList<>();
        意見書項目 = new ArrayList<>();
        前回意見書項目 = new ArrayList<>();
        dbt5208Entity = new ArrayList<>();
    }

    @Override
    protected void beforeExecute() {
        mapper = getMapper(IYokaigoNinteiJohoTeikyoMapper.class);
        list = mapper.get認定調査特記事項番号(processPrm.toYokaigoBatchMybitisParamter());
        dbt5207Entity = mapper.get認定調査票サービス状況(processPrm.toYokaigoBatchMybitisParamter());
        調査項目 = mapper.get認定調査票調査項目(processPrm.toYokaigoBatchMybitisParamter());
        前回調査項目 = mapper.get前回認定調査票調査項目(processPrm.toYokaigoBatchMybitisParamter());
        意見書項目 = mapper.get主治医意見書意見項目(processPrm.toYokaigoBatchMybitisParamter());
        前回意見書項目 = mapper.get前回主治医意見書意見項目(processPrm.toYokaigoBatchMybitisParamter());
        dbt5208Entity = mapper.get認定調査票フラグ(processPrm.toYokaigoBatchMybitisParamter());
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processPrm.toYokaigoBatchMybitisParamter());
    }

    @Override
    protected void createWriter() {
        batchWrite = BatchReportFactory.createBatchReportWriter(ReportIdDBE.DBE517181.getReportId().value()).create();
        reportSourceWriter = new ReportSourceWriter(batchWrite);
    }

    @Override
    protected void process(YokaigoninteiEntity entity) {
        bodyItem = setBodyItem(entity);
        bodyItem.set意見書認知症高齢者自立度(ChkIchijiHanteiKekkaBusiness.set意見書認知症(意見書項目, bodyItem));
        bodyItem.set現在のサービス状況(ChkIchijiHanteiKekkaBusiness.setサービス状況(dbt5207Entity, dbt5208Entity, bodyItem));
        bodyItem.set身体機能_起居動作リスト(ChkIchijiHanteiKekkaBusiness.set身体機能_起居動作リスト(list, bodyItem));
        bodyItem.set生活機能リスト(ChkIchijiHanteiKekkaBusiness.set生活機能リスト(list, bodyItem));
        bodyItem.set認知機能リスト(ChkIchijiHanteiKekkaBusiness.set認知機能リスト(list, bodyItem));
        bodyItem.set精神_行動障害リスト(ChkIchijiHanteiKekkaBusiness.set精神_行動障害リスト(list, bodyItem));
        bodyItem.set社会生活への適応リスト(ChkIchijiHanteiKekkaBusiness.set社会生活への適応リスト(list, bodyItem));
        bodyItem.set特別な医療1リスト(ChkIchijiHanteiKekkaBusiness.set特別な医療1リスト(list, bodyItem));
        bodyItem.set特別な医療2リスト(ChkIchijiHanteiKekkaBusiness.set特別な医療2リスト(list, bodyItem));
        bodyItem.set日常生活自立度リスト(ChkIchijiHanteiKekkaBusiness.set日常生活自立度リスト(list, bodyItem));
        bodyItem.set主治医意見書項目1リスト(ChkIchijiHanteiKekkaBusiness.set主治医意見書項目1リスト(意見書項目, bodyItem));
        bodyItem.set主治医意見書項目2リスト(ChkIchijiHanteiKekkaBusiness.set主治医意見書項目2リスト(意見書項目, 前回意見書項目, bodyItem));
        bodyItem.set主治医意見書項目3リスト(ChkIchijiHanteiKekkaBusiness.set主治医意見書項目3リスト(意見書項目, 前回意見書項目, bodyItem));
        bodyItem.set主治医意見書項目4リスト(ChkIchijiHanteiKekkaBusiness.set主治医意見書項目4リスト(意見書項目, 前回意見書項目, bodyItem));
        bodyItem.set認知機能1リスト(ChkIchijiHanteiKekkaBusiness.set認知機能1リスト(調査項目, bodyItem));
        bodyItem.set認知機能2リスト(ChkIchijiHanteiKekkaBusiness.set認知機能2リスト(調査項目, 前回調査項目, bodyItem));
        bodyItem.set認知機能3リスト(ChkIchijiHanteiKekkaBusiness.set認知機能3リスト(調査項目, 前回調査項目, bodyItem));
        bodyItem.set認知機能4リスト(ChkIchijiHanteiKekkaBusiness.set認知機能4リスト(調査項目, 前回調査項目, bodyItem));
        bodyItem.set身体機能_起居動作1リスト(ChkIchijiHanteiKekkaBusiness.set身体機能_起居動作1リスト(調査項目, bodyItem));
        bodyItem.set身体機能_起居動作2リスト(set身体機能_起居動作2リスト(調査項目, 前回調査項目));
        bodyItem.set身体機能_起居動作3リスト(set身体機能_起居動作3リスト(調査項目, 前回調査項目));
        bodyItem.set身体機能_起居動作4リスト(set身体機能_起居動作4リスト(調査項目, 前回調査項目));
        bodyItem.set生活機能1リスト(set生活機能1リスト(調査項目));
        bodyItem.set生活機能2リスト(set生活機能2リスト(調査項目, 前回調査項目));
        bodyItem.set生活機能3リスト(set生活機能3リスト(調査項目, 前回調査項目));
        bodyItem.set生活機能4リスト(set生活機能4リスト(調査項目, 前回調査項目));
        bodyItem.set精神_行動障害1リスト(set精神_行動障害1リスト(調査項目));
        bodyItem.set精神_行動障害2リスト(set精神_行動障害2リスト(調査項目, 前回調査項目));
        bodyItem.set精神_行動障害3リスト(set精神_行動障害3リスト(調査項目, 前回調査項目));
        bodyItem.set精神_行動障害4リスト(set精神_行動障害4リスト(調査項目, 前回調査項目));
        bodyItem.set社会生活への適応1リスト(set社会生活への適応1リスト(調査項目));
        bodyItem.set社会生活への適応2リスト(set社会生活への適応2リスト(調査項目, 前回調査項目));
        bodyItem.set社会生活への適応3リスト(set社会生活への適応3リスト(調査項目, 前回調査項目));
        bodyItem.set社会生活への適応4リスト(set社会生活への適応4リスト(調査項目, 前回調査項目));
        bodyItem.set特別な医療3_1リスト(set特別な医療3_1リスト(調査項目));
        bodyItem.set特別な医療3_2リスト(set特別な医療3_2リスト(調査項目, 前回調査項目));
        bodyItem.set特別な医療4_1リスト(set特別な医療4_1リスト(調査項目));
        bodyItem.set特別な医療4_2リスト(set特別な医療4_2リスト(調査項目, 前回調査項目));
        IchijihanteikekkahyoReport report = new IchijihanteikekkahyoReport(bodyItem);
        report.writeBy(reportSourceWriter);
    }

    @Override
    protected void afterExecute() {
        set出力条件表();
    }

    private RString get調査連番(List<DbT5211NinteichosahyoChosaItemEntity> 調査項目,
            List<DbT5211NinteichosahyoChosaItemEntity> 前回調査項目, int 連番) {
        RString 状況改善 = RString.EMPTY;
        RString 今回調査 = RString.EMPTY;
        RString 前回調査 = RString.EMPTY;
        if (連番 < 調査項目.size() && !RString.isNullOrEmpty(調査項目.get(連番).getResearchItem())) {
            今回調査 = 調査項目.get(連番).getResearchItem();
        }
        if (連番 < 前回調査項目.size() && !RString.isNullOrEmpty(前回調査項目.get(連番).getResearchItem())) {
            前回調査 = 前回調査項目.get(連番).getResearchItem();
        }
        if (RString.isNullOrEmpty(前回調査)) {
            return 状況改善;
        }
        if ((RString.isNullOrEmpty(今回調査) ? 0 : Integer.parseInt(今回調査.toString())) < Integer.parseInt(前回調査.toString())) {
            状況改善 = new RString("▽");
        }
        if ((RString.isNullOrEmpty(今回調査) ? 0 : Integer.parseInt(今回調査.toString())) > Integer.parseInt(前回調査.toString())) {
            状況改善 = new RString("▲");
        }
        return 状況改善;
    }

    private RString get状況結果(List<DbT5211NinteichosahyoChosaItemEntity> 調査項目,
            List<DbT5211NinteichosahyoChosaItemEntity> 前回調査項目, int 連番) {
        RString 今回調査 = RString.EMPTY;
        RString 前回調査 = RString.EMPTY;
        if (連番 < 調査項目.size() && !RString.isNullOrEmpty(調査項目.get(連番).getResearchItem())) {
            今回調査 = 調査項目.get(連番).getResearchItem();
        }
        if (連番 < 前回調査項目.size() && !RString.isNullOrEmpty(前回調査項目.get(連番).getResearchItem())) {
            前回調査 = 前回調査項目.get(連番).getResearchItem();
        }
        if (RString.isNullOrEmpty(前回調査) || 今回調査.equals(前回調査)) {
            return RString.EMPTY;
        }
        int 結果 = (RString.isNullOrEmpty(今回調査) ? 0 : Integer.parseInt(今回調査.toString())) - Integer.parseInt(前回調査.toString());
        if (結果 < 0) {
            return new RString(結果).substring(1);
        }
        return new RString(結果);
    }

    private List<RString> set特別な医療4_2リスト(List<DbT5211NinteichosahyoChosaItemEntity> 調査項目,
            List<DbT5211NinteichosahyoChosaItemEntity> 前回調査項目) {
        List<RString> 特別な医療4_2リスト = new ArrayList<>();
        if (識別コード09B.equals(bodyItem.get厚労省IF識別コード()) || 識別コード09A.equals(bodyItem.get厚労省IF識別コード())) {
            特別な医療4_2リスト.add(get調査連番(調査項目, 前回調査項目, 連番68));
            特別な医療4_2リスト.add(get調査連番(調査項目, 前回調査項目, 連番69));
            特別な医療4_2リスト.add(get調査連番(調査項目, 前回調査項目, 連番70));
            特別な医療4_2リスト.add(get調査連番(調査項目, 前回調査項目, 連番71));
            特別な医療4_2リスト.add(get調査連番(調査項目, 前回調査項目, 連番72));
            特別な医療4_2リスト.add(get調査連番(調査項目, 前回調査項目, 連番73));
        }
        if (識別コード06A.equals(bodyItem.get厚労省IF識別コード()) || 識別コード02A.equals(bodyItem.get厚労省IF識別コード())) {
            特別な医療4_2リスト.add(get調査連番(調査項目, 前回調査項目, 連番73));
            特別な医療4_2リスト.add(get調査連番(調査項目, 前回調査項目, 連番74));
            特別な医療4_2リスト.add(get調査連番(調査項目, 前回調査項目, 連番75));
            特別な医療4_2リスト.add(get調査連番(調査項目, 前回調査項目, 連番76));
            特別な医療4_2リスト.add(get調査連番(調査項目, 前回調査項目, 連番77));
            特別な医療4_2リスト.add(get調査連番(調査項目, 前回調査項目, 連番78));
        }
        if (識別コード99A.equals(bodyItem.get厚労省IF識別コード())) {
            特別な医療4_2リスト.add(get調査連番(調査項目, 前回調査項目, 連番79));
            特別な医療4_2リスト.add(get調査連番(調査項目, 前回調査項目, 連番80));
            特別な医療4_2リスト.add(get調査連番(調査項目, 前回調査項目, 連番81));
            特別な医療4_2リスト.add(get調査連番(調査項目, 前回調査項目, 連番82));
            特別な医療4_2リスト.add(get調査連番(調査項目, 前回調査項目, 連番83));
            特別な医療4_2リスト.add(get調査連番(調査項目, 前回調査項目, 連番84));
        }
        return 特別な医療4_2リスト;
    }

    private List<RString> set特別な医療4_1リスト(List<DbT5211NinteichosahyoChosaItemEntity> dbt5211Entity) {
        List<RString> 特別な医療4_1リスト = new ArrayList<>();
        if (識別コード09B.equals(bodyItem.get厚労省IF識別コード()) || 識別コード09A.equals(bodyItem.get厚労省IF識別コード())) {
            特別な医療4_1リスト.add(get名称01(dbt5211Entity, 連番68));
            特別な医療4_1リスト.add(get名称01(dbt5211Entity, 連番69));
            特別な医療4_1リスト.add(get名称01(dbt5211Entity, 連番70));
            特別な医療4_1リスト.add(get名称01(dbt5211Entity, 連番71));
            特別な医療4_1リスト.add(get名称01(dbt5211Entity, 連番72));
            特別な医療4_1リスト.add(get名称01(dbt5211Entity, 連番73));
        }
        if (識別コード06A.equals(bodyItem.get厚労省IF識別コード()) || 識別コード02A.equals(bodyItem.get厚労省IF識別コード())) {
            特別な医療4_1リスト.add(get名称01(dbt5211Entity, 連番73));
            特別な医療4_1リスト.add(get名称01(dbt5211Entity, 連番74));
            特別な医療4_1リスト.add(get名称01(dbt5211Entity, 連番75));
            特別な医療4_1リスト.add(get名称01(dbt5211Entity, 連番76));
            特別な医療4_1リスト.add(get名称01(dbt5211Entity, 連番77));
            特別な医療4_1リスト.add(get名称01(dbt5211Entity, 連番78));
        }
        if (識別コード99A.equals(bodyItem.get厚労省IF識別コード())) {
            特別な医療4_1リスト.add(get名称01(dbt5211Entity, 連番79));
            特別な医療4_1リスト.add(get名称01(dbt5211Entity, 連番80));
            特別な医療4_1リスト.add(get名称01(dbt5211Entity, 連番81));
            特別な医療4_1リスト.add(get名称01(dbt5211Entity, 連番82));
            特別な医療4_1リスト.add(get名称01(dbt5211Entity, 連番83));
            特別な医療4_1リスト.add(get名称01(dbt5211Entity, 連番84));
        }
        return 特別な医療4_1リスト;
    }

    private List<RString> set特別な医療3_2リスト(List<DbT5211NinteichosahyoChosaItemEntity> 調査項目,
            List<DbT5211NinteichosahyoChosaItemEntity> 前回調査項目) {
        List<RString> 特別な医療3_2リスト = new ArrayList<>();
        if (識別コード09B.equals(bodyItem.get厚労省IF識別コード()) || 識別コード09A.equals(bodyItem.get厚労省IF識別コード())) {
            特別な医療3_2リスト.add(get調査連番(調査項目, 前回調査項目, 連番62));
            特別な医療3_2リスト.add(get調査連番(調査項目, 前回調査項目, 連番63));
            特別な医療3_2リスト.add(get調査連番(調査項目, 前回調査項目, 連番64));
            特別な医療3_2リスト.add(get調査連番(調査項目, 前回調査項目, 連番65));
            特別な医療3_2リスト.add(get調査連番(調査項目, 前回調査項目, 連番66));
            特別な医療3_2リスト.add(get調査連番(調査項目, 前回調査項目, 連番67));
        }
        if (識別コード06A.equals(bodyItem.get厚労省IF識別コード()) || 識別コード02A.equals(bodyItem.get厚労省IF識別コード())) {
            特別な医療3_2リスト.add(get調査連番(調査項目, 前回調査項目, 連番67));
            特別な医療3_2リスト.add(get調査連番(調査項目, 前回調査項目, 連番68));
            特別な医療3_2リスト.add(get調査連番(調査項目, 前回調査項目, 連番69));
            特別な医療3_2リスト.add(get調査連番(調査項目, 前回調査項目, 連番70));
            特別な医療3_2リスト.add(get調査連番(調査項目, 前回調査項目, 連番71));
            特別な医療3_2リスト.add(get調査連番(調査項目, 前回調査項目, 連番72));
        }
        if (識別コード99A.equals(bodyItem.get厚労省IF識別コード())) {
            特別な医療3_2リスト.add(get調査連番(調査項目, 前回調査項目, 連番73));
            特別な医療3_2リスト.add(get調査連番(調査項目, 前回調査項目, 連番74));
            特別な医療3_2リスト.add(get調査連番(調査項目, 前回調査項目, 連番75));
            特別な医療3_2リスト.add(get調査連番(調査項目, 前回調査項目, 連番76));
            特別な医療3_2リスト.add(get調査連番(調査項目, 前回調査項目, 連番77));
            特別な医療3_2リスト.add(get調査連番(調査項目, 前回調査項目, 連番78));
        }
        return 特別な医療3_2リスト;
    }

    private List<RString> set特別な医療3_1リスト(List<DbT5211NinteichosahyoChosaItemEntity> dbt5211Entity) {
        List<RString> 特別な医療3_1リスト = new ArrayList<>();
        if (識別コード09B.equals(bodyItem.get厚労省IF識別コード()) || 識別コード09A.equals(bodyItem.get厚労省IF識別コード())) {
            特別な医療3_1リスト.add(get名称01(dbt5211Entity, 連番62));
            特別な医療3_1リスト.add(get名称01(dbt5211Entity, 連番63));
            特別な医療3_1リスト.add(get名称01(dbt5211Entity, 連番64));
            特別な医療3_1リスト.add(get名称01(dbt5211Entity, 連番65));
            特別な医療3_1リスト.add(get名称01(dbt5211Entity, 連番66));
            特別な医療3_1リスト.add(get名称01(dbt5211Entity, 連番67));
        }
        if (識別コード06A.equals(bodyItem.get厚労省IF識別コード()) || 識別コード02A.equals(bodyItem.get厚労省IF識別コード())) {
            特別な医療3_1リスト.add(get名称01(dbt5211Entity, 連番67));
            特別な医療3_1リスト.add(get名称01(dbt5211Entity, 連番68));
            特別な医療3_1リスト.add(get名称01(dbt5211Entity, 連番69));
            特別な医療3_1リスト.add(get名称01(dbt5211Entity, 連番70));
            特別な医療3_1リスト.add(get名称01(dbt5211Entity, 連番71));
            特別な医療3_1リスト.add(get名称01(dbt5211Entity, 連番72));
        }
        if (識別コード99A.equals(bodyItem.get厚労省IF識別コード())) {
            特別な医療3_1リスト.add(get名称01(dbt5211Entity, 連番73));
            特別な医療3_1リスト.add(get名称01(dbt5211Entity, 連番74));
            特別な医療3_1リスト.add(get名称01(dbt5211Entity, 連番75));
            特別な医療3_1リスト.add(get名称01(dbt5211Entity, 連番76));
            特別な医療3_1リスト.add(get名称01(dbt5211Entity, 連番77));
            特別な医療3_1リスト.add(get名称01(dbt5211Entity, 連番78));
        }
        return 特別な医療3_1リスト;
    }

    private List<RString> 社会生活機能(List<DbT5211NinteichosahyoChosaItemEntity> 調査項目, List<DbT5211NinteichosahyoChosaItemEntity> dbt5211Entity) {
        List<RString> 社会生活への適応4リスト = new ArrayList<>();
        if (差分のみ印刷.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査前回結果印刷有無, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
            if (識別コード09B.equals(bodyItem.get厚労省IF識別コード()) || 識別コード09A.equals(bodyItem.get厚労省IF識別コード())) {
                社会生活への適応4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番56).isEmpty() ? RString.EMPTY : get名称12(dbt5211Entity, 連番56));
                社会生活への適応4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番56).isEmpty() ? RString.EMPTY : get名称12(dbt5211Entity, 連番57));
                社会生活への適応4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番56).isEmpty() ? RString.EMPTY : get名称12(dbt5211Entity, 連番58));
                社会生活への適応4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番56).isEmpty() ? RString.EMPTY : get名称12(dbt5211Entity, 連番59));
                社会生活への適応4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番56).isEmpty() ? RString.EMPTY : get名称12(dbt5211Entity, 連番60));
                社会生活への適応4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番56).isEmpty() ? RString.EMPTY : get名称12(dbt5211Entity, 連番61));
            }
            if (識別コード06A.equals(bodyItem.get厚労省IF識別コード()) || 識別コード02A.equals(bodyItem.get厚労省IF識別コード())) {
                社会生活への適応4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番34).isEmpty() ? RString.EMPTY : get名称22(dbt5211Entity, 連番34));
                社会生活への適応4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番35).isEmpty() ? RString.EMPTY : get名称22(dbt5211Entity, 連番35));
                社会生活への適応4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番37).isEmpty() ? RString.EMPTY : get名称17(dbt5211Entity, 連番37));
                社会生活への適応4リスト.add(RString.EMPTY);
                社会生活への適応4リスト.add(RString.EMPTY);
                社会生活への適応4リスト.add(RString.EMPTY);
            }
            if (識別コード06A.equals(bodyItem.get厚労省IF識別コード()) || 識別コード02A.equals(bodyItem.get厚労省IF識別コード())) {
                社会生活への適応4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番40).isEmpty() ? RString.EMPTY : get名称22(dbt5211Entity, 連番40));
                社会生活への適応4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番41).isEmpty() ? RString.EMPTY : get名称22(dbt5211Entity, 連番41));
                社会生活への適応4リスト.add(RString.EMPTY);
                社会生活への適応4リスト.add(RString.EMPTY);
                社会生活への適応4リスト.add(RString.EMPTY);
                社会生活への適応4リスト.add(RString.EMPTY);
            }
        }
        return 社会生活への適応4リスト;
    }

    private List<RString> set社会生活への適応4リスト(List<DbT5211NinteichosahyoChosaItemEntity> dbt5211Entity,
            List<DbT5211NinteichosahyoChosaItemEntity> 前回調査項目) {
        List<RString> 社会生活への適応4リスト = new ArrayList<>();
        社会生活機能(dbt5211Entity, 前回調査項目);
        if (印刷しない.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査前回結果印刷有無, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
            社会生活への適応4リスト.add(RString.EMPTY);
            社会生活への適応4リスト.add(RString.EMPTY);
            社会生活への適応4リスト.add(RString.EMPTY);
            社会生活への適応4リスト.add(RString.EMPTY);
            社会生活への適応4リスト.add(RString.EMPTY);
            社会生活への適応4リスト.add(RString.EMPTY);
        }
        if (印刷する.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査前回結果印刷有無, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
            if (識別コード09B.equals(bodyItem.get厚労省IF識別コード()) || 識別コード09A.equals(bodyItem.get厚労省IF識別コード())) {
                社会生活への適応4リスト.add(get名称12(dbt5211Entity, 連番56));
                社会生活への適応4リスト.add(get名称12(dbt5211Entity, 連番57));
                社会生活への適応4リスト.add(get名称12(dbt5211Entity, 連番58));
                社会生活への適応4リスト.add(get名称12(dbt5211Entity, 連番59));
                社会生活への適応4リスト.add(get名称12(dbt5211Entity, 連番60));
                社会生活への適応4リスト.add(get名称12(dbt5211Entity, 連番61));
            }
            if (識別コード06A.equals(bodyItem.get厚労省IF識別コード()) || 識別コード02A.equals(bodyItem.get厚労省IF識別コード())) {
                社会生活への適応4リスト.add(get名称22(dbt5211Entity, 連番34));
                社会生活への適応4リスト.add(get名称22(dbt5211Entity, 連番35));
                社会生活への適応4リスト.add(get名称17(dbt5211Entity, 連番37));
                社会生活への適応4リスト.add(RString.EMPTY);
                社会生活への適応4リスト.add(RString.EMPTY);
                社会生活への適応4リスト.add(RString.EMPTY);
            }
            if (識別コード99A.equals(bodyItem.get厚労省IF識別コード())) {
                社会生活への適応4リスト.add(get名称22(dbt5211Entity, 連番40));
                社会生活への適応4リスト.add(get名称22(dbt5211Entity, 連番41));
                社会生活への適応4リスト.add(RString.EMPTY);
                社会生活への適応4リスト.add(RString.EMPTY);
                社会生活への適応4リスト.add(RString.EMPTY);
                社会生活への適応4リスト.add(RString.EMPTY);
            }
        }
        return 社会生活への適応4リスト;
    }

    private List<RString> set社会生活への適応3リスト(List<DbT5211NinteichosahyoChosaItemEntity> 調査項目,
            List<DbT5211NinteichosahyoChosaItemEntity> 前回調査項目) {
        List<RString> 社会生活への適応3リスト = new ArrayList<>();
        if (識別コード09B.equals(bodyItem.get厚労省IF識別コード()) || 識別コード09A.equals(bodyItem.get厚労省IF識別コード())) {
            社会生活への適応3リスト.add(get状況結果(調査項目, 前回調査項目, 連番56));
            社会生活への適応3リスト.add(get状況結果(調査項目, 前回調査項目, 連番57));
            社会生活への適応3リスト.add(get状況結果(調査項目, 前回調査項目, 連番58));
            社会生活への適応3リスト.add(get状況結果(調査項目, 前回調査項目, 連番59));
            社会生活への適応3リスト.add(get状況結果(調査項目, 前回調査項目, 連番60));
            社会生活への適応3リスト.add(get状況結果(調査項目, 前回調査項目, 連番61));
        }
        if (識別コード06A.equals(bodyItem.get厚労省IF識別コード()) || 識別コード02A.equals(bodyItem.get厚労省IF識別コード())) {
            社会生活への適応3リスト.add(get状況結果(調査項目, 前回調査項目, 連番34));
            社会生活への適応3リスト.add(get状況結果(調査項目, 前回調査項目, 連番35));
            社会生活への適応3リスト.add(get状況結果(調査項目, 前回調査項目, 連番37));
            社会生活への適応3リスト.add(RString.EMPTY);
            社会生活への適応3リスト.add(RString.EMPTY);
            社会生活への適応3リスト.add(RString.EMPTY);
        }
        if (識別コード99A.equals(bodyItem.get厚労省IF識別コード())) {
            社会生活への適応3リスト.add(get状況結果(調査項目, 前回調査項目, 連番40));
            社会生活への適応3リスト.add(get状況結果(調査項目, 前回調査項目, 連番41));
            社会生活への適応3リスト.add(RString.EMPTY);
            社会生活への適応3リスト.add(RString.EMPTY);
            社会生活への適応3リスト.add(RString.EMPTY);
            社会生活への適応3リスト.add(RString.EMPTY);
        }
        return 社会生活への適応3リスト;
    }

    private List<RString> set社会生活への適応2リスト(List<DbT5211NinteichosahyoChosaItemEntity> 調査項目,
            List<DbT5211NinteichosahyoChosaItemEntity> 前回調査項目) {
        List<RString> 社会生活への適応2リスト = new ArrayList<>();
        if (識別コード09B.equals(bodyItem.get厚労省IF識別コード()) || 識別コード09A.equals(bodyItem.get厚労省IF識別コード())) {
            社会生活への適応2リスト.add(get調査連番(調査項目, 前回調査項目, 連番56));
            社会生活への適応2リスト.add(get調査連番(調査項目, 前回調査項目, 連番57));
            社会生活への適応2リスト.add(get調査連番(調査項目, 前回調査項目, 連番58));
            社会生活への適応2リスト.add(get調査連番(調査項目, 前回調査項目, 連番59));
            社会生活への適応2リスト.add(get調査連番(調査項目, 前回調査項目, 連番60));
            社会生活への適応2リスト.add(get調査連番(調査項目, 前回調査項目, 連番61));
        }
        if (識別コード06A.equals(bodyItem.get厚労省IF識別コード()) || 識別コード02A.equals(bodyItem.get厚労省IF識別コード())) {
            社会生活への適応2リスト.add(get調査連番(調査項目, 前回調査項目, 連番34));
            社会生活への適応2リスト.add(get調査連番(調査項目, 前回調査項目, 連番35));
            社会生活への適応2リスト.add(get調査連番(調査項目, 前回調査項目, 連番36));
            社会生活への適応2リスト.add(get調査連番(調査項目, 前回調査項目, 連番37));
            社会生活への適応2リスト.add(RString.EMPTY);
            社会生活への適応2リスト.add(RString.EMPTY);
            社会生活への適応2リスト.add(RString.EMPTY);
        }
        if (識別コード99A.equals(bodyItem.get厚労省IF識別コード())) {
            社会生活への適応2リスト.add(get調査連番(調査項目, 前回調査項目, 連番40));
            社会生活への適応2リスト.add(get調査連番(調査項目, 前回調査項目, 連番41));
            社会生活への適応2リスト.add(RString.EMPTY);
            社会生活への適応2リスト.add(RString.EMPTY);
            社会生活への適応2リスト.add(RString.EMPTY);
            社会生活への適応2リスト.add(RString.EMPTY);
        }
        return 社会生活への適応2リスト;
    }

    private List<RString> set社会生活への適応1リスト(List<DbT5211NinteichosahyoChosaItemEntity> dbt5211Entity) {
        List<RString> 社会生活への適応1リスト = new ArrayList<>();
        if (識別コード09B.equals(bodyItem.get厚労省IF識別コード()) || 識別コード09A.equals(bodyItem.get厚労省IF識別コード())) {
            社会生活への適応1リスト.add(get名称12(dbt5211Entity, 連番56));
            社会生活への適応1リスト.add(get名称12(dbt5211Entity, 連番57));
            社会生活への適応1リスト.add(get名称17(dbt5211Entity, 連番58));
            社会生活への適応1リスト.add(get名称16(dbt5211Entity, 連番59));
            社会生活への適応1リスト.add(get名称10(dbt5211Entity, 連番60));
            社会生活への適応1リスト.add(get名称10(dbt5211Entity, 連番61));
        }
        if (識別コード06A.equals(bodyItem.get厚労省IF識別コード()) || 識別コード02A.equals(bodyItem.get厚労省IF識別コード())) {
            社会生活への適応1リスト.add(get名称22(dbt5211Entity, 連番34));
            社会生活への適応1リスト.add(get名称22(dbt5211Entity, 連番35));
            社会生活への適応1リスト.add(get名称17(dbt5211Entity, 連番37));
            社会生活への適応1リスト.add(RString.EMPTY);
            社会生活への適応1リスト.add(RString.EMPTY);
            社会生活への適応1リスト.add(RString.EMPTY);
        }
        if (識別コード99A.equals(bodyItem.get厚労省IF識別コード())) {
            社会生活への適応1リスト.add(get名称22(dbt5211Entity, 連番40));
            社会生活への適応1リスト.add(get名称22(dbt5211Entity, 連番41));
            社会生活への適応1リスト.add(RString.EMPTY);
            社会生活への適応1リスト.add(RString.EMPTY);
            社会生活への適応1リスト.add(RString.EMPTY);
            社会生活への適応1リスト.add(RString.EMPTY);
        }
        return 社会生活への適応1リスト;
    }

    private List<RString> 精神機能(List<DbT5211NinteichosahyoChosaItemEntity> 調査項目, List<DbT5211NinteichosahyoChosaItemEntity> dbt5211Entity) {
        List<RString> 精神_行動障害4リスト = new ArrayList<>();
        if (差分のみ印刷.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査前回結果印刷有無, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
            if (識別コード09B.equals(bodyItem.get厚労省IF識別コード()) || 識別コード09A.equals(bodyItem.get厚労省IF識別コード())) {
                精神_行動障害4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番41).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番41));
                精神_行動障害4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番42).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番42));
                精神_行動障害4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番43).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番43));
                精神_行動障害4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番44).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番44));
                精神_行動障害4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番45).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番45));
                精神_行動障害4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番46).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番46));
                精神_行動障害4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番47).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番47));
                精神_行動障害4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番48).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番48));
                精神_行動障害4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番49).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番49));
                精神_行動障害4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番50).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番50));
                精神_行動障害4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番51).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番51));
                精神_行動障害4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番52).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番52));
                精神_行動障害4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番53).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番53));
                精神_行動障害4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番54).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番54));
                精神_行動障害4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番55).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番55));
            }
            set精神機能差分99A(調査項目, dbt5211Entity);
            set精神機能差分02A(調査項目, dbt5211Entity);
        }
        return 精神_行動障害4リスト;
    }

    private List<RString> set精神機能差分99A(List<DbT5211NinteichosahyoChosaItemEntity> 調査項目,
            List<DbT5211NinteichosahyoChosaItemEntity> dbt5211Entity) {
        List<RString> 精神_行動障害4リスト = new ArrayList<>();
        if (識別コード99A.equals(bodyItem.get厚労省IF識別コード())) {
            精神_行動障害4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番54).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番54));
            精神_行動障害4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番55).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番55));
            精神_行動障害4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番57).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番57));
            精神_行動障害4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番58).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番58));
            精神_行動障害4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番60).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番60));
            精神_行動障害4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番61).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番61));
            精神_行動障害4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番62).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番62));
            精神_行動障害4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番64).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番64));
            精神_行動障害4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番66).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番66));
            精神_行動障害4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番67).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番67));
            精神_行動障害4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番69).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番69));
            精神_行動障害4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番42).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番42));
            精神_行動障害4リスト.add(RString.EMPTY);
            精神_行動障害4リスト.add(RString.EMPTY);
            精神_行動障害4リスト.add(RString.EMPTY);
        }
        return 精神_行動障害4リスト;
    }

    private List<RString> set精神機能差分02A(List<DbT5211NinteichosahyoChosaItemEntity> 調査項目,
            List<DbT5211NinteichosahyoChosaItemEntity> dbt5211Entity) {
        List<RString> 精神_行動障害4リスト = new ArrayList<>();
        if (識別コード06A.equals(bodyItem.get厚労省IF識別コード()) || 識別コード02A.equals(bodyItem.get厚労省IF識別コード())) {
            精神_行動障害4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番48).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番48));
            精神_行動障害4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番49).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番49));
            精神_行動障害4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番51).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番51));
            精神_行動障害4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番52).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番52));
            精神_行動障害4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番54).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番54));
            精神_行動障害4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番55).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番55));
            精神_行動障害4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番56).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番56));
            精神_行動障害4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番58).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番58));
            精神_行動障害4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番60).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番60));
            精神_行動障害4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番61).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番61));
            精神_行動障害4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番63).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番63));
            精神_行動障害4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番66).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番66));
            精神_行動障害4リスト.add(RString.EMPTY);
            精神_行動障害4リスト.add(RString.EMPTY);
            精神_行動障害4リスト.add(RString.EMPTY);
        }
        return 精神_行動障害4リスト;
    }

    private List<RString> set精神_行動障害4リスト(List<DbT5211NinteichosahyoChosaItemEntity> dbt5211Entity,
            List<DbT5211NinteichosahyoChosaItemEntity> 前回調査項目) {
        List<RString> 精神_行動障害4リスト = new ArrayList<>();
        精神機能(dbt5211Entity, 前回調査項目);
        if (印刷しない.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査前回結果印刷有無, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
            精神_行動障害4リスト.add(RString.EMPTY);
            精神_行動障害4リスト.add(RString.EMPTY);
            精神_行動障害4リスト.add(RString.EMPTY);
            精神_行動障害4リスト.add(RString.EMPTY);
            精神_行動障害4リスト.add(RString.EMPTY);
            精神_行動障害4リスト.add(RString.EMPTY);
            精神_行動障害4リスト.add(RString.EMPTY);
            精神_行動障害4リスト.add(RString.EMPTY);
            精神_行動障害4リスト.add(RString.EMPTY);
            精神_行動障害4リスト.add(RString.EMPTY);
            精神_行動障害4リスト.add(RString.EMPTY);
            精神_行動障害4リスト.add(RString.EMPTY);
            精神_行動障害4リスト.add(RString.EMPTY);
            精神_行動障害4リスト.add(RString.EMPTY);
            精神_行動障害4リスト.add(RString.EMPTY);
        }
        if (印刷する.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査前回結果印刷有無, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
            if (識別コード09B.equals(bodyItem.get厚労省IF識別コード()) || 識別コード09A.equals(bodyItem.get厚労省IF識別コード())) {
                精神_行動障害4リスト.add(get名称16(dbt5211Entity, 連番41));
                精神_行動障害4リスト.add(get名称16(dbt5211Entity, 連番42));
                精神_行動障害4リスト.add(get名称16(dbt5211Entity, 連番43));
                精神_行動障害4リスト.add(get名称16(dbt5211Entity, 連番44));
                精神_行動障害4リスト.add(get名称16(dbt5211Entity, 連番45));
                精神_行動障害4リスト.add(get名称16(dbt5211Entity, 連番46));
                精神_行動障害4リスト.add(get名称16(dbt5211Entity, 連番47));
                精神_行動障害4リスト.add(get名称16(dbt5211Entity, 連番48));
                精神_行動障害4リスト.add(get名称16(dbt5211Entity, 連番49));
                精神_行動障害4リスト.add(get名称16(dbt5211Entity, 連番50));
                精神_行動障害4リスト.add(get名称16(dbt5211Entity, 連番51));
                精神_行動障害4リスト.add(get名称16(dbt5211Entity, 連番52));
                精神_行動障害4リスト.add(get名称16(dbt5211Entity, 連番53));
                精神_行動障害4リスト.add(get名称16(dbt5211Entity, 連番54));
                精神_行動障害4リスト.add(get名称16(dbt5211Entity, 連番55));
            }
            if (識別コード06A.equals(bodyItem.get厚労省IF識別コード()) || 識別コード02A.equals(bodyItem.get厚労省IF識別コード())) {
                精神_行動障害4リスト.add(get名称16(dbt5211Entity, 連番48));
                精神_行動障害4リスト.add(get名称16(dbt5211Entity, 連番49));
                精神_行動障害4リスト.add(get名称16(dbt5211Entity, 連番51));
                精神_行動障害4リスト.add(get名称16(dbt5211Entity, 連番52));
                精神_行動障害4リスト.add(get名称16(dbt5211Entity, 連番54));
                精神_行動障害4リスト.add(get名称16(dbt5211Entity, 連番55));
                精神_行動障害4リスト.add(get名称16(dbt5211Entity, 連番56));
                精神_行動障害4リスト.add(get名称16(dbt5211Entity, 連番58));
                精神_行動障害4リスト.add(get名称16(dbt5211Entity, 連番60));
                精神_行動障害4リスト.add(get名称16(dbt5211Entity, 連番61));
                精神_行動障害4リスト.add(get名称16(dbt5211Entity, 連番63));
                精神_行動障害4リスト.add(get名称16(dbt5211Entity, 連番66));
                精神_行動障害4リスト.add(RString.EMPTY);
                精神_行動障害4リスト.add(RString.EMPTY);
                精神_行動障害4リスト.add(RString.EMPTY);
            }
            if (識別コード99A.equals(bodyItem.get厚労省IF識別コード())) {
                精神_行動障害4リスト.add(get名称16(dbt5211Entity, 連番54));
                精神_行動障害4リスト.add(get名称16(dbt5211Entity, 連番55));
                精神_行動障害4リスト.add(get名称16(dbt5211Entity, 連番57));
                精神_行動障害4リスト.add(get名称16(dbt5211Entity, 連番58));
                精神_行動障害4リスト.add(get名称16(dbt5211Entity, 連番60));
                精神_行動障害4リスト.add(get名称16(dbt5211Entity, 連番61));
                精神_行動障害4リスト.add(get名称16(dbt5211Entity, 連番62));
                精神_行動障害4リスト.add(get名称16(dbt5211Entity, 連番64));
                精神_行動障害4リスト.add(get名称16(dbt5211Entity, 連番66));
                精神_行動障害4リスト.add(get名称16(dbt5211Entity, 連番67));
                精神_行動障害4リスト.add(get名称16(dbt5211Entity, 連番69));
                精神_行動障害4リスト.add(get名称16(dbt5211Entity, 連番42));
                精神_行動障害4リスト.add(RString.EMPTY);
                精神_行動障害4リスト.add(RString.EMPTY);
                精神_行動障害4リスト.add(RString.EMPTY);
            }
        }
        return 精神_行動障害4リスト;
    }

    private List<RString> set精神_行動障害3リスト(List<DbT5211NinteichosahyoChosaItemEntity> 調査項目,
            List<DbT5211NinteichosahyoChosaItemEntity> 前回調査項目) {
        List<RString> 精神_行動障害3リスト = new ArrayList<>();
        if (識別コード09B.equals(bodyItem.get厚労省IF識別コード()) || 識別コード09A.equals(bodyItem.get厚労省IF識別コード())) {
            精神_行動障害3リスト.add(get状況結果(調査項目, 前回調査項目, 連番41));
            精神_行動障害3リスト.add(get状況結果(調査項目, 前回調査項目, 連番42));
            精神_行動障害3リスト.add(get状況結果(調査項目, 前回調査項目, 連番43));
            精神_行動障害3リスト.add(get状況結果(調査項目, 前回調査項目, 連番44));
            精神_行動障害3リスト.add(get状況結果(調査項目, 前回調査項目, 連番45));
            精神_行動障害3リスト.add(get状況結果(調査項目, 前回調査項目, 連番46));
            精神_行動障害3リスト.add(get状況結果(調査項目, 前回調査項目, 連番47));
            精神_行動障害3リスト.add(get状況結果(調査項目, 前回調査項目, 連番48));
            精神_行動障害3リスト.add(get状況結果(調査項目, 前回調査項目, 連番49));
            精神_行動障害3リスト.add(get状況結果(調査項目, 前回調査項目, 連番50));
            精神_行動障害3リスト.add(get状況結果(調査項目, 前回調査項目, 連番51));
            精神_行動障害3リスト.add(get状況結果(調査項目, 前回調査項目, 連番52));
            精神_行動障害3リスト.add(get状況結果(調査項目, 前回調査項目, 連番53));
            精神_行動障害3リスト.add(get状況結果(調査項目, 前回調査項目, 連番54));
            精神_行動障害3リスト.add(get状況結果(調査項目, 前回調査項目, 連番55));
        }
        if (識別コード06A.equals(bodyItem.get厚労省IF識別コード()) || 識別コード02A.equals(bodyItem.get厚労省IF識別コード())) {
            精神_行動障害3リスト.add(get状況結果(調査項目, 前回調査項目, 連番48));
            精神_行動障害3リスト.add(get状況結果(調査項目, 前回調査項目, 連番49));
            精神_行動障害3リスト.add(get状況結果(調査項目, 前回調査項目, 連番51));
            精神_行動障害3リスト.add(get状況結果(調査項目, 前回調査項目, 連番52));
            精神_行動障害3リスト.add(get状況結果(調査項目, 前回調査項目, 連番54));
            精神_行動障害3リスト.add(get状況結果(調査項目, 前回調査項目, 連番55));
            精神_行動障害3リスト.add(get状況結果(調査項目, 前回調査項目, 連番56));
            精神_行動障害3リスト.add(get状況結果(調査項目, 前回調査項目, 連番58));
            精神_行動障害3リスト.add(get状況結果(調査項目, 前回調査項目, 連番60));
            精神_行動障害3リスト.add(get状況結果(調査項目, 前回調査項目, 連番61));
            精神_行動障害3リスト.add(get状況結果(調査項目, 前回調査項目, 連番63));
            精神_行動障害3リスト.add(get状況結果(調査項目, 前回調査項目, 連番66));
            精神_行動障害3リスト.add(RString.EMPTY);
            精神_行動障害3リスト.add(RString.EMPTY);
            精神_行動障害3リスト.add(RString.EMPTY);
        }
        if (識別コード99A.equals(bodyItem.get厚労省IF識別コード())) {
            精神_行動障害3リスト.add(get状況結果(調査項目, 前回調査項目, 連番54));
            精神_行動障害3リスト.add(get状況結果(調査項目, 前回調査項目, 連番55));
            精神_行動障害3リスト.add(get状況結果(調査項目, 前回調査項目, 連番57));
            精神_行動障害3リスト.add(get状況結果(調査項目, 前回調査項目, 連番58));
            精神_行動障害3リスト.add(get状況結果(調査項目, 前回調査項目, 連番60));
            精神_行動障害3リスト.add(get状況結果(調査項目, 前回調査項目, 連番61));
            精神_行動障害3リスト.add(get状況結果(調査項目, 前回調査項目, 連番62));
            精神_行動障害3リスト.add(get状況結果(調査項目, 前回調査項目, 連番64));
            精神_行動障害3リスト.add(get状況結果(調査項目, 前回調査項目, 連番66));
            精神_行動障害3リスト.add(get状況結果(調査項目, 前回調査項目, 連番67));
            精神_行動障害3リスト.add(get状況結果(調査項目, 前回調査項目, 連番69));
            精神_行動障害3リスト.add(get状況結果(調査項目, 前回調査項目, 連番42));
            精神_行動障害3リスト.add(RString.EMPTY);
            精神_行動障害3リスト.add(RString.EMPTY);
            精神_行動障害3リスト.add(RString.EMPTY);
        }
        return 精神_行動障害3リスト;
    }

    private List<RString> set精神_行動障害2リスト(List<DbT5211NinteichosahyoChosaItemEntity> 調査項目,
            List<DbT5211NinteichosahyoChosaItemEntity> 前回調査項目) {
        List<RString> 精神_行動障害2リスト = new ArrayList<>();
        if (識別コード09B.equals(bodyItem.get厚労省IF識別コード()) || 識別コード09A.equals(bodyItem.get厚労省IF識別コード())) {
            精神_行動障害2リスト.add(get調査連番(調査項目, 前回調査項目, 連番41));
            精神_行動障害2リスト.add(get調査連番(調査項目, 前回調査項目, 連番42));
            精神_行動障害2リスト.add(get調査連番(調査項目, 前回調査項目, 連番43));
            精神_行動障害2リスト.add(get調査連番(調査項目, 前回調査項目, 連番44));
            精神_行動障害2リスト.add(get調査連番(調査項目, 前回調査項目, 連番45));
            精神_行動障害2リスト.add(get調査連番(調査項目, 前回調査項目, 連番46));
            精神_行動障害2リスト.add(get調査連番(調査項目, 前回調査項目, 連番47));
            精神_行動障害2リスト.add(get調査連番(調査項目, 前回調査項目, 連番48));
            精神_行動障害2リスト.add(get調査連番(調査項目, 前回調査項目, 連番49));
            精神_行動障害2リスト.add(get調査連番(調査項目, 前回調査項目, 連番50));
            精神_行動障害2リスト.add(get調査連番(調査項目, 前回調査項目, 連番51));
            精神_行動障害2リスト.add(get調査連番(調査項目, 前回調査項目, 連番52));
            精神_行動障害2リスト.add(get調査連番(調査項目, 前回調査項目, 連番53));
            精神_行動障害2リスト.add(get調査連番(調査項目, 前回調査項目, 連番54));
            精神_行動障害2リスト.add(get調査連番(調査項目, 前回調査項目, 連番55));
        }
        if (識別コード06A.equals(bodyItem.get厚労省IF識別コード()) || 識別コード02A.equals(bodyItem.get厚労省IF識別コード())) {
            精神_行動障害2リスト.add(get調査連番(調査項目, 前回調査項目, 連番48));
            精神_行動障害2リスト.add(get調査連番(調査項目, 前回調査項目, 連番49));
            精神_行動障害2リスト.add(get調査連番(調査項目, 前回調査項目, 連番51));
            精神_行動障害2リスト.add(get調査連番(調査項目, 前回調査項目, 連番52));
            精神_行動障害2リスト.add(get調査連番(調査項目, 前回調査項目, 連番54));
            精神_行動障害2リスト.add(get調査連番(調査項目, 前回調査項目, 連番55));
            精神_行動障害2リスト.add(get調査連番(調査項目, 前回調査項目, 連番56));
            精神_行動障害2リスト.add(get調査連番(調査項目, 前回調査項目, 連番58));
            精神_行動障害2リスト.add(get調査連番(調査項目, 前回調査項目, 連番60));
            精神_行動障害2リスト.add(get調査連番(調査項目, 前回調査項目, 連番61));
            精神_行動障害2リスト.add(get調査連番(調査項目, 前回調査項目, 連番63));
            精神_行動障害2リスト.add(get調査連番(調査項目, 前回調査項目, 連番66));
            精神_行動障害2リスト.add(RString.EMPTY);
            精神_行動障害2リスト.add(RString.EMPTY);
            精神_行動障害2リスト.add(RString.EMPTY);
        }
        if (識別コード99A.equals(bodyItem.get厚労省IF識別コード())) {
            精神_行動障害2リスト.add(get調査連番(調査項目, 前回調査項目, 連番54));
            精神_行動障害2リスト.add(get調査連番(調査項目, 前回調査項目, 連番55));
            精神_行動障害2リスト.add(get調査連番(調査項目, 前回調査項目, 連番57));
            精神_行動障害2リスト.add(get調査連番(調査項目, 前回調査項目, 連番58));
            精神_行動障害2リスト.add(get調査連番(調査項目, 前回調査項目, 連番60));
            精神_行動障害2リスト.add(get調査連番(調査項目, 前回調査項目, 連番61));
            精神_行動障害2リスト.add(get調査連番(調査項目, 前回調査項目, 連番62));
            精神_行動障害2リスト.add(get調査連番(調査項目, 前回調査項目, 連番64));
            精神_行動障害2リスト.add(get調査連番(調査項目, 前回調査項目, 連番66));
            精神_行動障害2リスト.add(get調査連番(調査項目, 前回調査項目, 連番67));
            精神_行動障害2リスト.add(get調査連番(調査項目, 前回調査項目, 連番69));
            精神_行動障害2リスト.add(get調査連番(調査項目, 前回調査項目, 連番42));
            精神_行動障害2リスト.add(RString.EMPTY);
            精神_行動障害2リスト.add(RString.EMPTY);
            精神_行動障害2リスト.add(RString.EMPTY);
        }
        return 精神_行動障害2リスト;
    }

    private List<RString> set精神_行動障害1リスト(List<DbT5211NinteichosahyoChosaItemEntity> dbt5211Entity) {
        List<RString> 精神_行動障害1リスト = new ArrayList<>();
        if (識別コード09B.equals(bodyItem.get厚労省IF識別コード()) || 識別コード09A.equals(bodyItem.get厚労省IF識別コード())) {
            精神_行動障害1リスト.add(get名称16(dbt5211Entity, 連番41));
            精神_行動障害1リスト.add(get名称16(dbt5211Entity, 連番42));
            精神_行動障害1リスト.add(get名称16(dbt5211Entity, 連番43));
            精神_行動障害1リスト.add(get名称16(dbt5211Entity, 連番44));
            精神_行動障害1リスト.add(get名称16(dbt5211Entity, 連番45));
            精神_行動障害1リスト.add(get名称16(dbt5211Entity, 連番46));
            精神_行動障害1リスト.add(get名称16(dbt5211Entity, 連番47));
            精神_行動障害1リスト.add(get名称16(dbt5211Entity, 連番48));
            精神_行動障害1リスト.add(get名称16(dbt5211Entity, 連番49));
            精神_行動障害1リスト.add(get名称16(dbt5211Entity, 連番50));
            精神_行動障害1リスト.add(get名称16(dbt5211Entity, 連番51));
            精神_行動障害1リスト.add(get名称16(dbt5211Entity, 連番52));
            精神_行動障害1リスト.add(get名称16(dbt5211Entity, 連番53));
            精神_行動障害1リスト.add(get名称16(dbt5211Entity, 連番54));
            精神_行動障害1リスト.add(get名称16(dbt5211Entity, 連番55));
        }
        if (識別コード06A.equals(bodyItem.get厚労省IF識別コード()) || 識別コード02A.equals(bodyItem.get厚労省IF識別コード())) {
            精神_行動障害1リスト.add(get名称16(dbt5211Entity, 連番48));
            精神_行動障害1リスト.add(get名称16(dbt5211Entity, 連番49));
            精神_行動障害1リスト.add(get名称16(dbt5211Entity, 連番51));
            精神_行動障害1リスト.add(get名称16(dbt5211Entity, 連番52));
            精神_行動障害1リスト.add(get名称16(dbt5211Entity, 連番54));
            精神_行動障害1リスト.add(get名称16(dbt5211Entity, 連番55));
            精神_行動障害1リスト.add(get名称16(dbt5211Entity, 連番56));
            精神_行動障害1リスト.add(get名称16(dbt5211Entity, 連番58));
            精神_行動障害1リスト.add(get名称16(dbt5211Entity, 連番60));
            精神_行動障害1リスト.add(get名称16(dbt5211Entity, 連番61));
            精神_行動障害1リスト.add(get名称16(dbt5211Entity, 連番63));
            精神_行動障害1リスト.add(get名称16(dbt5211Entity, 連番66));
            精神_行動障害1リスト.add(RString.EMPTY);
            精神_行動障害1リスト.add(RString.EMPTY);
            精神_行動障害1リスト.add(RString.EMPTY);
        }
        if (識別コード99A.equals(bodyItem.get厚労省IF識別コード())) {
            精神_行動障害1リスト.add(get名称16(dbt5211Entity, 連番54));
            精神_行動障害1リスト.add(get名称16(dbt5211Entity, 連番55));
            精神_行動障害1リスト.add(get名称16(dbt5211Entity, 連番57));
            精神_行動障害1リスト.add(get名称16(dbt5211Entity, 連番58));
            精神_行動障害1リスト.add(get名称16(dbt5211Entity, 連番60));
            精神_行動障害1リスト.add(get名称16(dbt5211Entity, 連番61));
            精神_行動障害1リスト.add(get名称16(dbt5211Entity, 連番62));
            精神_行動障害1リスト.add(get名称16(dbt5211Entity, 連番64));
            精神_行動障害1リスト.add(get名称16(dbt5211Entity, 連番66));
            精神_行動障害1リスト.add(get名称16(dbt5211Entity, 連番67));
            精神_行動障害1リスト.add(get名称16(dbt5211Entity, 連番69));
            精神_行動障害1リスト.add(get名称16(dbt5211Entity, 連番42));
            精神_行動障害1リスト.add(RString.EMPTY);
            精神_行動障害1リスト.add(RString.EMPTY);
            精神_行動障害1リスト.add(RString.EMPTY);
        }
        return 精神_行動障害1リスト;
    }

    private List<RString> 生活機能(List<DbT5211NinteichosahyoChosaItemEntity> 調査項目, List<DbT5211NinteichosahyoChosaItemEntity> dbt5211Entity) {
        List<RString> 生活機能4リスト = new ArrayList<>();
        if (差分のみ印刷.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査前回結果印刷有無, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
            if (識別コード09B.equals(bodyItem.get厚労省IF識別コード()) || 識別コード09A.equals(bodyItem.get厚労省IF識別コード())) {
                生活機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番20).isEmpty() ? RString.EMPTY : get名称10(dbt5211Entity, 連番20));
                生活機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番21).isEmpty() ? RString.EMPTY : get名称10(dbt5211Entity, 連番21));
                生活機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番22).isEmpty() ? RString.EMPTY : get名称11(dbt5211Entity, 連番22));
                生活機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番23).isEmpty() ? RString.EMPTY : get名称10(dbt5211Entity, 連番23));
                生活機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番24).isEmpty() ? RString.EMPTY : get名称10(dbt5211Entity, 連番24));
                生活機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番25).isEmpty() ? RString.EMPTY : get名称10(dbt5211Entity, 連番25));
                生活機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番26).isEmpty() ? RString.EMPTY : get名称12(dbt5211Entity, 連番26));
                生活機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番27).isEmpty() ? RString.EMPTY : get名称12(dbt5211Entity, 連番27));
                生活機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番28).isEmpty() ? RString.EMPTY : get名称12(dbt5211Entity, 連番28));
                生活機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番29).isEmpty() ? RString.EMPTY : get名称10(dbt5211Entity, 連番29));
                生活機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番30).isEmpty() ? RString.EMPTY : get名称10(dbt5211Entity, 連番30));
                生活機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番31).isEmpty() ? RString.EMPTY : get名称13(dbt5211Entity, 連番31));
            }
            set生活機能差分99A(調査項目, dbt5211Entity);
            set生活機能差分02A(調査項目, dbt5211Entity);
        }
        return 生活機能4リスト;
    }

    private List<RString> set生活機能差分99A(List<DbT5211NinteichosahyoChosaItemEntity> 調査項目,
            List<DbT5211NinteichosahyoChosaItemEntity> dbt5211Entity) {
        List<RString> 生活機能4リスト = new ArrayList<>();
        if (識別コード99A.equals(bodyItem.get厚労省IF識別コード())) {
            生活機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番17).isEmpty() ? RString.EMPTY : get名称20(dbt5211Entity, 連番17));
            生活機能4リスト.add(RString.EMPTY);
            生活機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番25).isEmpty() ? RString.EMPTY : get名称33(dbt5211Entity, 連番25));
            生活機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番30).isEmpty() ? RString.EMPTY : get名称33(dbt5211Entity, 連番30));
            生活機能4リスト.add(RString.EMPTY);
            生活機能4リスト.add(RString.EMPTY);
            生活機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番31).isEmpty() ? RString.EMPTY : get名称22(dbt5211Entity, 連番31));
            生活機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番32).isEmpty() ? RString.EMPTY : get名称22(dbt5211Entity, 連番32));
            生活機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番33).isEmpty() ? RString.EMPTY : get名称22(dbt5211Entity, 連番33));
            生活機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番36).isEmpty() ? RString.EMPTY : get名称34(dbt5211Entity, 連番36));
            生活機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番37).isEmpty() ? RString.EMPTY : get名称34(dbt5211Entity, 連番37));
            生活機能4リスト.add(RString.EMPTY);
        }
        return 生活機能4リスト;
    }

    private List<RString> set生活機能差分02A(List<DbT5211NinteichosahyoChosaItemEntity> 調査項目,
            List<DbT5211NinteichosahyoChosaItemEntity> dbt5211Entity) {
        List<RString> 生活機能4リスト = new ArrayList<>();
        if (識別コード02A.equals(bodyItem.get厚労省IF識別コード()) || 識別コード06A.equals(bodyItem.get厚労省IF識別コード())) {
            生活機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番16).isEmpty() ? RString.EMPTY : get名称20(dbt5211Entity, 連番16));
            生活機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番17).isEmpty() ? RString.EMPTY : get名称20(dbt5211Entity, 連番17));
            生活機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番23).isEmpty() ? RString.EMPTY : get名称11(dbt5211Entity, 連番23));
            生活機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番24).isEmpty() ? RString.EMPTY : get名称20(dbt5211Entity, 連番24));
            生活機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番26).isEmpty() ? RString.EMPTY : get名称20(dbt5211Entity, 連番26));
            生活機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番27).isEmpty() ? RString.EMPTY : get名称20(dbt5211Entity, 連番27));
            生活機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番28).isEmpty() ? RString.EMPTY : get名称22(dbt5211Entity, 連番28));
            生活機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番29).isEmpty() ? RString.EMPTY : get名称22(dbt5211Entity, 連番29));
            生活機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番30).isEmpty() ? RString.EMPTY : get名称22(dbt5211Entity, 連番30));
            生活機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番32).isEmpty() ? RString.EMPTY : get名称20(dbt5211Entity, 連番32));
            生活機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番33).isEmpty() ? RString.EMPTY : get名称20(dbt5211Entity, 連番33));
        }
        if (識別コード02A.equals(bodyItem.get厚労省IF識別コード())) {
            生活機能4リスト.add(RString.EMPTY);
        }
        if (識別コード06A.equals(bodyItem.get厚労省IF識別コード())) {
            生活機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番80).isEmpty() ? RString.EMPTY : get名称13(dbt5211Entity, 連番80));
        }
        return 生活機能4リスト;
    }

    private List<RString> set生活機能4リスト(List<DbT5211NinteichosahyoChosaItemEntity> dbt5211Entity,
            List<DbT5211NinteichosahyoChosaItemEntity> 前回調査項目) {
        List<RString> 生活機能4リスト = new ArrayList<>();
        生活機能(調査項目, 前回調査項目);
        if (印刷しない.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査前回結果印刷有無, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
            生活機能4リスト.add(RString.EMPTY);
            生活機能4リスト.add(RString.EMPTY);
            生活機能4リスト.add(RString.EMPTY);
            生活機能4リスト.add(RString.EMPTY);
            生活機能4リスト.add(RString.EMPTY);
            生活機能4リスト.add(RString.EMPTY);
            生活機能4リスト.add(RString.EMPTY);
            生活機能4リスト.add(RString.EMPTY);
            生活機能4リスト.add(RString.EMPTY);
            生活機能4リスト.add(RString.EMPTY);
            生活機能4リスト.add(RString.EMPTY);
            生活機能4リスト.add(RString.EMPTY);
        }
        if (印刷する.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査前回結果印刷有無, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
            if (識別コード09B.equals(bodyItem.get厚労省IF識別コード()) || 識別コード09A.equals(bodyItem.get厚労省IF識別コード())) {
                生活機能4リスト.add(get名称10(dbt5211Entity, 連番20));
                生活機能4リスト.add(get名称10(dbt5211Entity, 連番21));
                生活機能4リスト.add(get名称11(dbt5211Entity, 連番22));
                生活機能4リスト.add(get名称10(dbt5211Entity, 連番23));
                生活機能4リスト.add(get名称10(dbt5211Entity, 連番24));
                生活機能4リスト.add(get名称10(dbt5211Entity, 連番25));
                生活機能4リスト.add(get名称12(dbt5211Entity, 連番26));
                生活機能4リスト.add(get名称12(dbt5211Entity, 連番27));
                生活機能4リスト.add(get名称12(dbt5211Entity, 連番28));
                生活機能4リスト.add(get名称10(dbt5211Entity, 連番29));
                生活機能4リスト.add(get名称10(dbt5211Entity, 連番30));
                生活機能4リスト.add(get名称13(dbt5211Entity, 連番31));
            }
            if (識別コード99A.equals(bodyItem.get厚労省IF識別コード())) {
                生活機能4リスト.add(get名称20(dbt5211Entity, 連番17));
                生活機能4リスト.add(RString.EMPTY);
                生活機能4リスト.add(get名称33(dbt5211Entity, 連番25));
                生活機能4リスト.add(get名称33(dbt5211Entity, 連番30));
                生活機能4リスト.add(RString.EMPTY);
                生活機能4リスト.add(RString.EMPTY);
                生活機能4リスト.add(get名称22(dbt5211Entity, 連番31));
                生活機能4リスト.add(get名称22(dbt5211Entity, 連番32));
                生活機能4リスト.add(get名称22(dbt5211Entity, 連番33));
                生活機能4リスト.add(get名称34(dbt5211Entity, 連番36));
                生活機能4リスト.add(get名称34(dbt5211Entity, 連番37));
                生活機能4リスト.add(RString.EMPTY);
            }
            if (識別コード02A.equals(bodyItem.get厚労省IF識別コード())) {
                生活機能4リスト.add(get名称20(dbt5211Entity, 連番16));
                生活機能4リスト.add(get名称20(dbt5211Entity, 連番17));
                生活機能4リスト.add(get名称11(dbt5211Entity, 連番23));
                生活機能4リスト.add(get名称20(dbt5211Entity, 連番24));
                生活機能4リスト.add(get名称20(dbt5211Entity, 連番26));
                生活機能4リスト.add(get名称20(dbt5211Entity, 連番27));
                生活機能4リスト.add(get名称22(dbt5211Entity, 連番28));
                生活機能4リスト.add(get名称22(dbt5211Entity, 連番29));
                生活機能4リスト.add(get名称22(dbt5211Entity, 連番30));
                生活機能4リスト.add(get名称20(dbt5211Entity, 連番32));
                生活機能4リスト.add(get名称20(dbt5211Entity, 連番33));
                生活機能4リスト.add(RString.EMPTY);
            }
            if (識別コード06A.equals(bodyItem.get厚労省IF識別コード())) {
                生活機能4リスト.add(get名称20(dbt5211Entity, 連番16));
                生活機能4リスト.add(get名称20(dbt5211Entity, 連番17));
                生活機能4リスト.add(get名称11(dbt5211Entity, 連番23));
                生活機能4リスト.add(get名称20(dbt5211Entity, 連番24));
                生活機能4リスト.add(get名称20(dbt5211Entity, 連番26));
                生活機能4リスト.add(get名称20(dbt5211Entity, 連番27));
                生活機能4リスト.add(get名称22(dbt5211Entity, 連番28));
                生活機能4リスト.add(get名称22(dbt5211Entity, 連番29));
                生活機能4リスト.add(get名称22(dbt5211Entity, 連番30));
                生活機能4リスト.add(get名称20(dbt5211Entity, 連番32));
                生活機能4リスト.add(get名称20(dbt5211Entity, 連番33));
                生活機能4リスト.add(get名称13(dbt5211Entity, 連番80));
            }
        }
        return 生活機能4リスト;
    }

    private List<RString> set生活機能3リスト(List<DbT5211NinteichosahyoChosaItemEntity> 調査項目,
            List<DbT5211NinteichosahyoChosaItemEntity> 前回調査項目) {
        List<RString> 生活機能3リスト = new ArrayList<>();
        if (識別コード09B.equals(bodyItem.get厚労省IF識別コード()) || 識別コード09A.equals(bodyItem.get厚労省IF識別コード())) {
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番20));
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番21));
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番22));
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番23));
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番24));
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番25));
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番26));
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番27));
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番28));
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番29));
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番30));
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番31));
        }
        if (識別コード99A.equals(bodyItem.get厚労省IF識別コード())) {
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番17));
            生活機能3リスト.add(RString.EMPTY);
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番25));
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番30));
            生活機能3リスト.add(RString.EMPTY);
            生活機能3リスト.add(RString.EMPTY);
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番31));
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番32));
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番33));
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番36));
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番37));
            生活機能3リスト.add(RString.EMPTY);
        }
        if (識別コード02A.equals(bodyItem.get厚労省IF識別コード())) {
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番16));
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番17));
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番23));
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番24));
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番26));
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番27));
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番28));
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番29));
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番30));
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番32));
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番33));
            生活機能3リスト.add(RString.EMPTY);
        }
        if (識別コード06A.equals(bodyItem.get厚労省IF識別コード())) {
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番16));
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番17));
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番23));
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番24));
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番26));
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番27));
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番28));
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番29));
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番30));
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番32));
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番33));
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番80));
        }
        return 生活機能3リスト;
    }

    private List<RString> set生活機能2リスト(List<DbT5211NinteichosahyoChosaItemEntity> 調査項目,
            List<DbT5211NinteichosahyoChosaItemEntity> 前回調査項目) {
        List<RString> 生活機能2リスト = new ArrayList<>();
        if (識別コード09B.equals(bodyItem.get厚労省IF識別コード()) || 識別コード09A.equals(bodyItem.get厚労省IF識別コード())) {
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番20));
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番21));
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番22));
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番23));
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番24));
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番25));
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番26));
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番27));
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番28));
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番29));
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番30));
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番31));
        }
        if (識別コード99A.equals(bodyItem.get厚労省IF識別コード())) {
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番17));
            生活機能2リスト.add(RString.EMPTY);
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番25));
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番30));
            生活機能2リスト.add(RString.EMPTY);
            生活機能2リスト.add(RString.EMPTY);
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番31));
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番32));
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番33));
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番36));
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番37));
            生活機能2リスト.add(RString.EMPTY);
        }
        if (識別コード02A.equals(bodyItem.get厚労省IF識別コード())) {
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番16));
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番17));
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番23));
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番24));
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番26));
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番27));
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番28));
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番29));
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番30));
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番32));
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番33));
            生活機能2リスト.add(RString.EMPTY);
        }
        if (識別コード06A.equals(bodyItem.get厚労省IF識別コード())) {
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番16));
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番17));
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番23));
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番24));
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番26));
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番27));
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番28));
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番29));
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番30));
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番32));
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番33));
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番80));
        }
        return 生活機能2リスト;
    }

    private List<RString> set生活機能1リスト(List<DbT5211NinteichosahyoChosaItemEntity> dbt5211Entity) {
        List<RString> 生活機能1リスト = new ArrayList<>();
        if (識別コード09B.equals(bodyItem.get厚労省IF識別コード()) || 識別コード09A.equals(bodyItem.get厚労省IF識別コード())) {
            生活機能1リスト.add(get名称10(dbt5211Entity, 連番20));
            生活機能1リスト.add(get名称10(dbt5211Entity, 連番21));
            生活機能1リスト.add(get名称11(dbt5211Entity, 連番22));
            生活機能1リスト.add(get名称10(dbt5211Entity, 連番23));
            生活機能1リスト.add(get名称10(dbt5211Entity, 連番24));
            生活機能1リスト.add(get名称10(dbt5211Entity, 連番25));
            生活機能1リスト.add(get名称12(dbt5211Entity, 連番26));
            生活機能1リスト.add(get名称12(dbt5211Entity, 連番27));
            生活機能1リスト.add(get名称12(dbt5211Entity, 連番28));
            生活機能1リスト.add(get名称10(dbt5211Entity, 連番29));
            生活機能1リスト.add(get名称10(dbt5211Entity, 連番30));
            生活機能1リスト.add(get名称13(dbt5211Entity, 連番31));
        }
        if (識別コード99A.equals(bodyItem.get厚労省IF識別コード())) {
            生活機能1リスト.add(get名称20(dbt5211Entity, 連番17));
            生活機能1リスト.add(RString.EMPTY);
            生活機能1リスト.add(get名称33(dbt5211Entity, 連番25));
            生活機能1リスト.add(get名称33(dbt5211Entity, 連番30));
            生活機能1リスト.add(RString.EMPTY);
            生活機能1リスト.add(RString.EMPTY);
            生活機能1リスト.add(get名称22(dbt5211Entity, 連番31));
            生活機能1リスト.add(get名称22(dbt5211Entity, 連番32));
            生活機能1リスト.add(get名称22(dbt5211Entity, 連番33));
            生活機能1リスト.add(get名称34(dbt5211Entity, 連番36));
            生活機能1リスト.add(get名称34(dbt5211Entity, 連番37));
            生活機能1リスト.add(RString.EMPTY);
        }
        if (識別コード02A.equals(bodyItem.get厚労省IF識別コード())) {
            生活機能1リスト.add(get名称20(dbt5211Entity, 連番16));
            生活機能1リスト.add(get名称20(dbt5211Entity, 連番17));
            生活機能1リスト.add(get名称11(dbt5211Entity, 連番23));
            生活機能1リスト.add(get名称20(dbt5211Entity, 連番24));
            生活機能1リスト.add(get名称20(dbt5211Entity, 連番26));
            生活機能1リスト.add(get名称20(dbt5211Entity, 連番27));
            生活機能1リスト.add(get名称22(dbt5211Entity, 連番28));
            生活機能1リスト.add(get名称22(dbt5211Entity, 連番29));
            生活機能1リスト.add(get名称22(dbt5211Entity, 連番30));
            生活機能1リスト.add(get名称20(dbt5211Entity, 連番32));
            生活機能1リスト.add(get名称20(dbt5211Entity, 連番33));
            生活機能1リスト.add(RString.EMPTY);
        }
        if (識別コード06A.equals(bodyItem.get厚労省IF識別コード())) {
            生活機能1リスト.add(get名称20(dbt5211Entity, 連番16));
            生活機能1リスト.add(get名称20(dbt5211Entity, 連番17));
            生活機能1リスト.add(get名称11(dbt5211Entity, 連番23));
            生活機能1リスト.add(get名称20(dbt5211Entity, 連番24));
            生活機能1リスト.add(get名称20(dbt5211Entity, 連番26));
            生活機能1リスト.add(get名称20(dbt5211Entity, 連番27));
            生活機能1リスト.add(get名称22(dbt5211Entity, 連番28));
            生活機能1リスト.add(get名称22(dbt5211Entity, 連番29));
            生活機能1リスト.add(get名称22(dbt5211Entity, 連番30));
            生活機能1リスト.add(get名称20(dbt5211Entity, 連番32));
            生活機能1リスト.add(get名称20(dbt5211Entity, 連番33));
            生活機能1リスト.add(get名称13(dbt5211Entity, 連番80));
        }
        return 生活機能1リスト;
    }

    private RString 機能差分結果(List<DbT5211NinteichosahyoChosaItemEntity> 意見書項目,
            List<DbT5211NinteichosahyoChosaItemEntity> 前回意見書項目, int 連番) {
        RString 今回調査 = RString.EMPTY;
        if (連番 < 意見書項目.size() && !RString.isNullOrEmpty(意見書項目.get(連番).getResearchItem())) {
            今回調査 = 意見書項目.get(連番).getResearchItem();
        }
        if (連番 < 前回意見書項目.size() && !RString.isNullOrEmpty(前回意見書項目.get(連番).getResearchItem())) {
            RString 前回調査 = 前回意見書項目.get(連番).getResearchItem();
            if (!今回調査.equals(前回調査)) {
                return 前回調査;
            }
        }
        return RString.EMPTY;
    }

    private List<RString> get身体機能09B(List<DbT5211NinteichosahyoChosaItemEntity> 調査項目, List<DbT5211NinteichosahyoChosaItemEntity> dbt5211Entity) {
        List<RString> 身体機能_起居動作4リスト = new ArrayList<>();
        if (識別コード09B.equals(bodyItem.get厚労省IF識別コード()) || 識別コード09A.equals(bodyItem.get厚労省IF識別コード())) {
            身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番6).isEmpty() ? RString.EMPTY : get名称01(dbt5211Entity, 連番6));
            身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番7).isEmpty() ? RString.EMPTY : get名称01(dbt5211Entity, 連番7));
            身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番8).isEmpty() ? RString.EMPTY : get名称01(dbt5211Entity, 連番8));
            身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番9).isEmpty() ? RString.EMPTY : get名称02(dbt5211Entity, 連番9));
            身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番10).isEmpty() ? RString.EMPTY : get名称02(dbt5211Entity, 連番10));
            身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番11).isEmpty() ? RString.EMPTY : get名称03(dbt5211Entity, 連番11));
            身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番12).isEmpty() ? RString.EMPTY : get名称04(dbt5211Entity, 連番12));
            身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番13).isEmpty() ? RString.EMPTY : get名称02(dbt5211Entity, 連番13));
            身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番14).isEmpty() ? RString.EMPTY : get名称02(dbt5211Entity, 連番14));
            身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番15).isEmpty() ? RString.EMPTY : get名称04(dbt5211Entity, 連番15));
            身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番16).isEmpty() ? RString.EMPTY : get名称06(dbt5211Entity, 連番16));
            身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番17).isEmpty() ? RString.EMPTY : get名称07(dbt5211Entity, 連番17));
            身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番18).isEmpty() ? RString.EMPTY : get名称08(dbt5211Entity, 連番18));
            身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番19).isEmpty() ? RString.EMPTY : get名称09(dbt5211Entity, 連番19));
        }
        return 身体機能_起居動作4リスト;
    }

    private List<RString> get身体機能02A(List<DbT5211NinteichosahyoChosaItemEntity> 調査項目, List<DbT5211NinteichosahyoChosaItemEntity> dbt5211Entity) {
        List<RString> 身体機能_起居動作4リスト = new ArrayList<>();
        if (識別コード02A.equals(bodyItem.get厚労省IF識別コード()) || 識別コード06A.equals(bodyItem.get厚労省IF識別コード())) {
            身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番7).isEmpty() ? RString.EMPTY : get名称01(dbt5211Entity, 連番7));
            身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番8).isEmpty() ? RString.EMPTY : get名称01(dbt5211Entity, 連番8));
            身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番10).isEmpty() ? RString.EMPTY : get名称01(dbt5211Entity, 連番10));
            身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番11).isEmpty() ? RString.EMPTY : get名称02(dbt5211Entity, 連番11));
            身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番12).isEmpty() ? RString.EMPTY : get名称02(dbt5211Entity, 連番12));
            身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番13).isEmpty() ? RString.EMPTY : get名称03(dbt5211Entity, 連番13));
            身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番14).isEmpty() ? RString.EMPTY : get名称04(dbt5211Entity, 連番14));
            身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番15).isEmpty() ? RString.EMPTY : get名称02(dbt5211Entity, 連番15));
            身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番18).isEmpty() ? RString.EMPTY : get名称02(dbt5211Entity, 連番18));
            身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番19).isEmpty() ? RString.EMPTY : get名称04(dbt5211Entity, 連番19));
            身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番20).isEmpty() ? RString.EMPTY : get名称21(dbt5211Entity, 連番20));
            身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番31).isEmpty() ? RString.EMPTY : get名称22(dbt5211Entity, 連番31));
            身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番38).isEmpty() ? RString.EMPTY : get名称08(dbt5211Entity, 連番38));
            身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番39).isEmpty() ? RString.EMPTY : get名称09(dbt5211Entity, 連番39));
        }
        return 身体機能_起居動作4リスト;
    }

    private List<RString> get身体機能99A(List<DbT5211NinteichosahyoChosaItemEntity> 調査項目, List<DbT5211NinteichosahyoChosaItemEntity> dbt5211Entity) {
        List<RString> 身体機能_起居動作4リスト = new ArrayList<>();
        if (識別コード99A.equals(bodyItem.get厚労省IF識別コード())) {
            身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番7).isEmpty() ? RString.EMPTY : get名称01(dbt5211Entity, 連番7));
            身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番8).isEmpty() ? RString.EMPTY : get名称01(dbt5211Entity, 連番8));
            身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番10).isEmpty() ? RString.EMPTY : get名称01(dbt5211Entity, 連番10));
            身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番11).isEmpty() ? RString.EMPTY : get名称02(dbt5211Entity, 連番11));
            身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番12).isEmpty() ? RString.EMPTY : get名称02(dbt5211Entity, 連番12));
            身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番13).isEmpty() ? RString.EMPTY : get名称03(dbt5211Entity, 連番13));
            身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番15).isEmpty() ? RString.EMPTY : get名称04(dbt5211Entity, 連番15));
            身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番16).isEmpty() ? RString.EMPTY : get名称02(dbt5211Entity, 連番16));
            身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番18).isEmpty() ? RString.EMPTY : get名称02(dbt5211Entity, 連番18));
            身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番19).isEmpty() ? RString.EMPTY : get名称04(dbt5211Entity, 連番19));
            身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番21).isEmpty() ? RString.EMPTY : get名称21(dbt5211Entity, 連番21));
            身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番34).isEmpty() ? RString.EMPTY : get名称22(dbt5211Entity, 連番34));
            身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番44).isEmpty() ? RString.EMPTY : get名称08(dbt5211Entity, 連番44));
            身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番45).isEmpty() ? RString.EMPTY : get名称09(dbt5211Entity, 連番45));
        }
        return 身体機能_起居動作4リスト;
    }

    private List<RString> 身体機能(List<DbT5211NinteichosahyoChosaItemEntity> 調査項目, List<DbT5211NinteichosahyoChosaItemEntity> dbt5211Entity) {
        List<RString> 身体機能_起居動作4リスト = new ArrayList<>();
        if (差分のみ印刷.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査前回結果印刷有無, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
            身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 0).isEmpty() ? RString.EMPTY : get名称01(dbt5211Entity, 0));
            身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番1).isEmpty() ? RString.EMPTY : get名称01(dbt5211Entity, 連番1));
            身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番2).isEmpty() ? RString.EMPTY : get名称01(dbt5211Entity, 連番2));
            身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番3).isEmpty() ? RString.EMPTY : get名称01(dbt5211Entity, 連番3));
            身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番4).isEmpty() ? RString.EMPTY : get名称01(dbt5211Entity, 連番4));
            身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番5).isEmpty() ? RString.EMPTY : get名称01(dbt5211Entity, 連番5));
            get身体機能09B(調査項目, dbt5211Entity);
            get身体機能02A(調査項目, dbt5211Entity);
            get身体機能99A(調査項目, dbt5211Entity);
        }
        return 身体機能_起居動作4リスト;
    }

    private List<RString> set身体機能_起居動作4リスト(List<DbT5211NinteichosahyoChosaItemEntity> 調査項目,
            List<DbT5211NinteichosahyoChosaItemEntity> dbt5211Entity) {
        List<RString> 身体機能_起居動作4リスト = new ArrayList<>();
        身体機能(調査項目, dbt5211Entity);
        if (印刷しない.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査前回結果印刷有無, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
            身体機能_起居動作4リスト.add(RString.EMPTY);
            身体機能_起居動作4リスト.add(RString.EMPTY);
            身体機能_起居動作4リスト.add(RString.EMPTY);
            身体機能_起居動作4リスト.add(RString.EMPTY);
            身体機能_起居動作4リスト.add(RString.EMPTY);
            身体機能_起居動作4リスト.add(RString.EMPTY);
            身体機能_起居動作4リスト.add(RString.EMPTY);
            身体機能_起居動作4リスト.add(RString.EMPTY);
            身体機能_起居動作4リスト.add(RString.EMPTY);
            身体機能_起居動作4リスト.add(RString.EMPTY);
            身体機能_起居動作4リスト.add(RString.EMPTY);
            身体機能_起居動作4リスト.add(RString.EMPTY);
            身体機能_起居動作4リスト.add(RString.EMPTY);
            身体機能_起居動作4リスト.add(RString.EMPTY);
            身体機能_起居動作4リスト.add(RString.EMPTY);
            身体機能_起居動作4リスト.add(RString.EMPTY);
            身体機能_起居動作4リスト.add(RString.EMPTY);
            身体機能_起居動作4リスト.add(RString.EMPTY);
            身体機能_起居動作4リスト.add(RString.EMPTY);
            身体機能_起居動作4リスト.add(RString.EMPTY);
        }
        if (印刷する.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査前回結果印刷有無, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
            身体機能_起居動作4リスト.add(get名称01(dbt5211Entity, 0));
            身体機能_起居動作4リスト.add(get名称01(dbt5211Entity, 連番1));
            身体機能_起居動作4リスト.add(get名称01(dbt5211Entity, 連番2));
            身体機能_起居動作4リスト.add(get名称01(dbt5211Entity, 連番3));
            身体機能_起居動作4リスト.add(get名称01(dbt5211Entity, 連番4));
            身体機能_起居動作4リスト.add(get名称01(dbt5211Entity, 連番5));
            if (識別コード09B.equals(bodyItem.get厚労省IF識別コード()) || 識別コード09A.equals(bodyItem.get厚労省IF識別コード())) {
                身体機能_起居動作4リスト.add(get名称01(dbt5211Entity, 連番6));
                身体機能_起居動作4リスト.add(get名称01(dbt5211Entity, 連番7));
                身体機能_起居動作4リスト.add(get名称01(dbt5211Entity, 連番8));
                身体機能_起居動作4リスト.add(get名称02(dbt5211Entity, 連番9));
                身体機能_起居動作4リスト.add(get名称02(dbt5211Entity, 連番10));
                身体機能_起居動作4リスト.add(get名称03(dbt5211Entity, 連番11));
                身体機能_起居動作4リスト.add(get名称04(dbt5211Entity, 連番12));
                身体機能_起居動作4リスト.add(get名称02(dbt5211Entity, 連番13));
                身体機能_起居動作4リスト.add(get名称02(dbt5211Entity, 連番14));
                身体機能_起居動作4リスト.add(get名称04(dbt5211Entity, 連番15));
                身体機能_起居動作4リスト.add(get名称06(dbt5211Entity, 連番16));
                身体機能_起居動作4リスト.add(get名称07(dbt5211Entity, 連番17));
                身体機能_起居動作4リスト.add(get名称08(dbt5211Entity, 連番18));
                身体機能_起居動作4リスト.add(get名称09(dbt5211Entity, 連番19));
            }
            if (識別コード02A.equals(bodyItem.get厚労省IF識別コード()) || 識別コード06A.equals(bodyItem.get厚労省IF識別コード())) {
                身体機能_起居動作4リスト.add(get名称01(dbt5211Entity, 連番7));
                身体機能_起居動作4リスト.add(get名称01(dbt5211Entity, 連番8));
                身体機能_起居動作4リスト.add(get名称01(dbt5211Entity, 連番10));
                身体機能_起居動作4リスト.add(get名称02(dbt5211Entity, 連番11));
                身体機能_起居動作4リスト.add(get名称02(dbt5211Entity, 連番12));
                身体機能_起居動作4リスト.add(get名称03(dbt5211Entity, 連番13));
                身体機能_起居動作4リスト.add(get名称04(dbt5211Entity, 連番14));
                身体機能_起居動作4リスト.add(get名称02(dbt5211Entity, 連番15));
                身体機能_起居動作4リスト.add(get名称02(dbt5211Entity, 連番18));
                身体機能_起居動作4リスト.add(get名称04(dbt5211Entity, 連番19));
                身体機能_起居動作4リスト.add(get名称21(dbt5211Entity, 連番20));
                身体機能_起居動作4リスト.add(get名称22(dbt5211Entity, 連番31));
                身体機能_起居動作4リスト.add(get名称08(dbt5211Entity, 連番38));
                身体機能_起居動作4リスト.add(get名称09(dbt5211Entity, 連番39));
            }
            if (識別コード99A.equals(bodyItem.get厚労省IF識別コード())) {
                身体機能_起居動作4リスト.add(get名称01(dbt5211Entity, 連番7));
                身体機能_起居動作4リスト.add(get名称01(dbt5211Entity, 連番8));
                身体機能_起居動作4リスト.add(get名称01(dbt5211Entity, 連番10));
                身体機能_起居動作4リスト.add(get名称02(dbt5211Entity, 連番11));
                身体機能_起居動作4リスト.add(get名称02(dbt5211Entity, 連番12));
                身体機能_起居動作4リスト.add(get名称03(dbt5211Entity, 連番13));
                身体機能_起居動作4リスト.add(get名称04(dbt5211Entity, 連番15));
                身体機能_起居動作4リスト.add(get名称02(dbt5211Entity, 連番16));
                身体機能_起居動作4リスト.add(get名称02(dbt5211Entity, 連番18));
                身体機能_起居動作4リスト.add(get名称04(dbt5211Entity, 連番19));
                身体機能_起居動作4リスト.add(get名称21(dbt5211Entity, 連番21));
                身体機能_起居動作4リスト.add(get名称22(dbt5211Entity, 連番34));
                身体機能_起居動作4リスト.add(get名称08(dbt5211Entity, 連番44));
                身体機能_起居動作4リスト.add(get名称09(dbt5211Entity, 連番45));
            }
        }
        return 身体機能_起居動作4リスト;
    }

    private List<RString> set身体機能_起居動作3リスト(List<DbT5211NinteichosahyoChosaItemEntity> 調査項目,
            List<DbT5211NinteichosahyoChosaItemEntity> 前回調査項目) {
        List<RString> 身体機能_起居動作3リスト = new ArrayList<>();
        身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 0));
        身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番1));
        身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番2));
        身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番3));
        身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番4));
        身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番5));
        if (識別コード09B.equals(bodyItem.get厚労省IF識別コード()) || 識別コード09A.equals(bodyItem.get厚労省IF識別コード())) {
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番6));
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番7));
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番8));
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番9));
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番10));
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番11));
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番12));
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番13));
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番14));
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番15));
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番16));
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番17));
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番18));
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番19));
        }
        if (識別コード06A.equals(bodyItem.get厚労省IF識別コード()) || 識別コード02A.equals(bodyItem.get厚労省IF識別コード())) {
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番7));
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番8));
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番10));
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番11));
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番12));
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番13));
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番14));
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番15));
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番18));
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番19));
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番20));
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番31));
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番38));
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番39));
        }
        if (識別コード99A.equals(bodyItem.get厚労省IF識別コード())) {
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番7));
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番8));
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番10));
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番11));
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番12));
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番13));
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番15));
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番16));
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番18));
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番19));
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番21));
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番34));
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番44));
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番45));
        }
        return 身体機能_起居動作3リスト;
    }

    private List<RString> set身体機能_起居動作2リスト(List<DbT5211NinteichosahyoChosaItemEntity> 調査項目,
            List<DbT5211NinteichosahyoChosaItemEntity> 前回調査項目) {
        List<RString> 身体機能_起居動作2リスト = new ArrayList<>();
        身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 0));
        身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番1));
        身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番2));
        身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番3));
        身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番4));
        身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番5));
        if (識別コード09B.equals(bodyItem.get厚労省IF識別コード()) || 識別コード09A.equals(bodyItem.get厚労省IF識別コード())) {
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番6));
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番7));
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番8));
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番9));
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番10));
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番11));
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番12));
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番13));
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番14));
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番15));
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番16));
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番17));
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番18));
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番19));
        }
        if (識別コード06A.equals(bodyItem.get厚労省IF識別コード()) || 識別コード02A.equals(bodyItem.get厚労省IF識別コード())) {
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番7));
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番8));
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番10));
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番11));
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番12));
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番13));
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番14));
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番15));
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番18));
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番19));
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番20));
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番31));
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番38));
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番39));
        }
        if (識別コード99A.equals(bodyItem.get厚労省IF識別コード())) {
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番7));
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番8));
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番10));
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番11));
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番12));
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番13));
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番15));
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番16));
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番18));
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番19));
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番21));
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番34));
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番44));
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番45));
        }
        return 身体機能_起居動作2リスト;
    }

    private IchijihanteikekkahyoEntity setBodyItem(YokaigoninteiEntity entity) {
        IchijihanteikekkahyoEntity ichijiEntity = new IchijihanteikekkahyoEntity();
        setBodyItem02(ichijiEntity, entity);
        setBodyItem03(ichijiEntity, entity);
        setBodyItem04(ichijiEntity, entity);
        ichijiEntity.setタイトル(認定情報_事務局用);
        ichijiEntity.set合議体番号(entity.get合議体番号());
        ichijiEntity.set審査順(entity.get審査会審査順());
        ichijiEntity.set被保険者区分(RString.isNullOrEmpty(entity.get被保険者区分コード()) ? RString.EMPTY
                : HihokenshaKubunCode.toValue(entity.get被保険者区分コード()).get名称());
        ichijiEntity.set申請区分(RString.isNullOrEmpty(entity.get申請区分_申()) ? RString.EMPTY
                : NinteiShinseiShinseijiKubunCode.toValue(entity.get申請区分_申()).get名称());
        ichijiEntity.set年齢(entity.get年齢());
        ichijiEntity.set性別(RString.isNullOrEmpty(entity.get性別()) ? RString.EMPTY
                : Seibetsu.toValue(entity.get性別()).get名称());
        ichijiEntity.set現在の状況(RString.isNullOrEmpty(entity.get施設利用()) ? RString.EMPTY
                : GenzainoJokyoCode.toValue(entity.get施設利用()).get名称());
        ichijiEntity.set前々回認定有効期間(entity.get前々回認定有効期間());
        ichijiEntity.set前々回認定有効期間開始年月日(entity.get前々回認定有効期間_開始());
        ichijiEntity.set前々回認定有効期間終了年月日(entity.get前々回認定有効期間_終了());
        ichijiEntity.set前回認定有効期間(entity.get前回認定有効期間());
        ichijiEntity.set前回認定有効期間開始年月日(entity.get前回認定有効期間_開始());
        ichijiEntity.set前回認定有効期間終了年月日(entity.get前回認定有効期間_終了());
        ichijiEntity.set前回認定日(entity.get前回二次判定年月日());
        ichijiEntity.set前回状態像(RString.isNullOrEmpty(entity.get前回状態像()) ? RString.EMPTY
                : YokaigoJotaizoReiCode.toValue(entity.get前回状態像()).get名称());
        ichijiEntity.set管理番号(entity.get申請書管理番号());
        ichijiEntity.set氏名(entity.get被保険者氏名());
        ichijiEntity.set被保険者番号(entity.get被保険者番号());
        ichijiEntity.set保険者番号(entity.get保険者番号());
        ichijiEntity.set所属(entity.get所属());
        ichijiEntity.set市町村名(entity.get市町村名());
        ichijiEntity.set事業者番号(entity.get事業者番号());
        ichijiEntity.set事業者名(entity.get事業者名称());
        ichijiEntity.set認定調査員番号(entity.get認定調査員コード());
        ichijiEntity.set認定調査員氏名(entity.get調査員氏名());
        ichijiEntity.set認定調査員資格(RString.isNullOrEmpty(entity.get調査員資格()) ? RString.EMPTY
                : Sikaku.toValue(entity.get調査員資格()).get名称());
        ichijiEntity.set医療機関番号(entity.get主治医医療機関コード());
        ichijiEntity.set医療機関名称(entity.get医療機関名称());
        ichijiEntity.set主治医番号(entity.get主治医コード());
        ichijiEntity.set主治医氏名(entity.get主治医氏名());
        ichijiEntity.set認定有効期間(entity.get認定有効期間());
        ichijiEntity.set認定有効期間開始年月日(entity.get認定有効期間開始年月日() == null ? RString.EMPTY
                : new RString(entity.get認定有効期間開始年月日().toString()));
        ichijiEntity.set認定有効期間終了年月日(entity.get認定有効期間終了年月日() == null ? RString.EMPTY
                : new RString(entity.get認定有効期間終了年月日().toString()));
        ichijiEntity.set特定疾病名(RString.isNullOrEmpty(entity.get特定疾病()) ? RString.EMPTY
                : TokuteiShippei.toValue(entity.get特定疾病()).get名称());
        ichijiEntity.set状態像名称(RString.isNullOrEmpty(entity.get要介護状態像例コード()) ? RString.EMPTY
                : YokaigoJotaizoReiCode.toValue(entity.get要介護状態像例コード()).get名称());
        ichijiEntity.set要介護認定等基準時間(entity.get要介護認定等基準時間());
        ichijiEntity.set要介護認定等基準時間_食事(entity.get要介護認定等基準時間_食事());
        ichijiEntity.set要介護認定等基準時間_排泄(entity.get要介護認定等基準時間_排泄());
        ichijiEntity.set要介護認定等基準時間_移動(entity.get要介護認定等基準時間_移動());
        ichijiEntity.set要介護認定等基準時間_清潔保持(entity.get要介護認定等基準時間_清潔保持());
        ichijiEntity.set要介護認定等基準時間_間接(entity.get要介護認定等基準時間_間接ケア());
        ichijiEntity.set要介護認定等基準時間_BPSD関連(entity.get要介護認定等基準時間_BPSD関連());
        ichijiEntity.set要介護認定等基準時間_機能訓練(entity.get要介護認定等基準時間_機能訓練());
        ichijiEntity.set要介護認定等基準時間_医療関連(entity.get要介護認定等基準時間_医療関連());
        ichijiEntity.set要介護認定等基準時間_認知症加算(entity.get要介護認定等基準時間_認知症加算());
        ichijiEntity.set警告コード(entity.get警告コード());
        ichijiEntity.set中間評価項目得点第1群(entity.get中間評価項目得点第1群());
        ichijiEntity.set中間評価項目得点第2群(entity.get中間評価項目得点第2群());
        ichijiEntity.set中間評価項目得点第3群(entity.get中間評価項目得点第3群());
        ichijiEntity.set中間評価項目得点第4群(entity.get中間評価項目得点第4群());
        ichijiEntity.set中間評価項目得点第5群(entity.get中間評価項目得点第5群());
        ichijiEntity.set認定調査結果認知症高齢者自立度(RString.isNullOrEmpty(entity.get認知症高齢者自立度()) ? RString.EMPTY
                : NinchishoNichijoSeikatsuJiritsudoCode.toValue(entity.get認知症高齢者自立度()).get名称());
        ichijiEntity.set認知症自立度Ⅱ以上の蓋然性(entity.get蓋然性());
        ichijiEntity.set状態の安定性(RString.isNullOrEmpty(entity.get安定性()) ? RString.EMPTY
                : JotaiAnteiseiCode.toValue(entity.get安定性()).get名称());
        ichijiEntity.set給付区分(RString.isNullOrEmpty(entity.get給付区分()) ? RString.EMPTY
                : SuiteiKyufuKubunCode.toValue(entity.get給付区分()).get名称());
        ichijiEntity.set現在のサービス利用状況名(RString.isNullOrEmpty(entity.getサービス区分コード()) ? RString.EMPTY
                : ServiceKubunCode.toValue(entity.getサービス区分コード()).get名称());
        ichijiEntity.set厚労省IF識別コード(entity.get厚労省IF識別コード());
        List<RString> 高齢者自立度リスト = new ArrayList<>();
        高齢者自立度リスト.add(RString.isNullOrEmpty(entity.get障害高齢者自立度()) ? RString.EMPTY
                : ShogaiNichijoSeikatsuJiritsudoCode.toValue(entity.get障害高齢者自立度()).get名称());
        高齢者自立度リスト.add(RString.isNullOrEmpty(entity.get認知症高齢者自立度()) ? RString.EMPTY
                : NinchishoNichijoSeikatsuJiritsudoCode.toValue(entity.get認知症高齢者自立度()).get名称());
        ichijiEntity.set高齢者自立度リスト(高齢者自立度リスト);
        return ichijiEntity;
    }

    private void setBodyItem03(IchijihanteikekkahyoEntity ichijiEntity, YokaigoninteiEntity entity) {
        ichijiEntity.set申請日_元号(entity.get認定申請年月日() == null ? RString.EMPTY : entity.get認定申請年月日()
                .wareki().eraType(EraType.KANJI).getEra());
        ichijiEntity.set申請日_年(entity.get認定申請年月日() == null ? RString.EMPTY : entity.get認定申請年月日()
                .wareki().eraType(EraType.KANJI).getYear());
        ichijiEntity.set申請日_月(entity.get認定申請年月日() == null ? RString.EMPTY : entity.get認定申請年月日()
                .wareki().eraType(EraType.KANJI).getMonth());
        ichijiEntity.set申請日_日(entity.get認定申請年月日() == null ? RString.EMPTY : entity.get認定申請年月日()
                .wareki().eraType(EraType.KANJI).getDay());
        ichijiEntity.set作成日_元号(entity.get作成年月日() == null ? RString.EMPTY : entity.get作成年月日()
                .wareki().eraType(EraType.KANJI).getEra());
        ichijiEntity.set作成日_年(entity.get作成年月日() == null ? RString.EMPTY : entity.get作成年月日()
                .wareki().eraType(EraType.KANJI).getYear());
        ichijiEntity.set作成日_月(entity.get作成年月日() == null ? RString.EMPTY : entity.get作成年月日()
                .wareki().eraType(EraType.KANJI).getMonth());
        ichijiEntity.set作成日_日(entity.get作成年月日() == null ? RString.EMPTY : entity.get作成年月日()
                .wareki().eraType(EraType.KANJI).getDay());
        ichijiEntity.set調査日_元号(entity.get実施年月日() == null ? RString.EMPTY : entity.get実施年月日()
                .wareki().eraType(EraType.KANJI).getEra());
        ichijiEntity.set調査日_年(entity.get実施年月日() == null ? RString.EMPTY : entity.get実施年月日()
                .wareki().eraType(EraType.KANJI).getYear());
        ichijiEntity.set調査日_月(entity.get実施年月日() == null ? RString.EMPTY : entity.get実施年月日()
                .wareki().eraType(EraType.KANJI).getMonth());
        ichijiEntity.set調査日_日(entity.get実施年月日() == null ? RString.EMPTY : entity.get実施年月日()
                .wareki().eraType(EraType.KANJI).getDay());
        ichijiEntity.set審査日_元号(entity.get審査会開催日() == null ? RString.EMPTY : entity.get審査会開催日()
                .wareki().eraType(EraType.KANJI).getEra());
        ichijiEntity.set審査日_年(entity.get審査会開催日() == null ? RString.EMPTY : entity.get審査会開催日()
                .wareki().eraType(EraType.KANJI).getYear());
        ichijiEntity.set審査日_月(entity.get審査会開催日() == null ? RString.EMPTY : entity.get審査会開催日()
                .wareki().eraType(EraType.KANJI).getMonth());
        ichijiEntity.set審査日_日(entity.get審査会開催日() == null ? RString.EMPTY : entity.get審査会開催日()
                .wareki().eraType(EraType.KANJI).getDay());
    }

    private void setBodyItem02(IchijihanteikekkahyoEntity ichijiEntity, YokaigoninteiEntity entity) {
        if (判定結果コード09.equals(entity.get厚労省IF識別コード().substring(0, 2))) {
            ichijiEntity.set前々回要介護度(RString.isNullOrEmpty(entity.get前々回要介護度()) ? RString.EMPTY
                    : YokaigoJotaiKubun09.toValue(entity.get前々回要介護度()).get名称());
            ichijiEntity.set前回要介護度(RString.isNullOrEmpty(entity.get前回認定結果()) ? RString.EMPTY
                    : YokaigoJotaiKubun09.toValue(entity.get前回認定結果()).get名称());
            ichijiEntity.set一次判定結果(RString.isNullOrEmpty(entity.get一次判定結果()) ? RString.EMPTY
                    : IchijiHanteiKekkaCode09.toValue(entity.get一次判定結果()).get名称());
            ichijiEntity.set二次判定結果(RString.isNullOrEmpty(entity.get二次判定結果()) ? RString.EMPTY
                    : YokaigoJotaiKubun09.toValue(entity.get二次判定結果()).get名称());
        }
        if (判定結果コード06.equals(entity.get厚労省IF識別コード().substring(0, 2))) {
            ichijiEntity.set前々回要介護度(RString.isNullOrEmpty(entity.get前々回要介護度()) ? RString.EMPTY
                    : YokaigoJotaiKubun06.toValue(entity.get前々回要介護度()).get名称());
            ichijiEntity.set前回要介護度(RString.isNullOrEmpty(entity.get前回認定結果()) ? RString.EMPTY
                    : YokaigoJotaiKubun06.toValue(entity.get前回認定結果()).get名称());
            ichijiEntity.set一次判定結果(RString.isNullOrEmpty(entity.get一次判定結果()) ? RString.EMPTY
                    : IchijiHanteiKekkaCode06.toValue(entity.get一次判定結果()).get名称());
            ichijiEntity.set二次判定結果(RString.isNullOrEmpty(entity.get二次判定結果()) ? RString.EMPTY
                    : YokaigoJotaiKubun06.toValue(entity.get二次判定結果()).get名称());
        }
    }

    private void setBodyItem04(IchijihanteikekkahyoEntity ichijiEntity, YokaigoninteiEntity entity) {
        if (判定結果コード02.equals(entity.get厚労省IF識別コード().substring(0, 2))) {
            ichijiEntity.set前々回要介護度(RString.isNullOrEmpty(entity.get前々回要介護度()) ? RString.EMPTY
                    : YokaigoJotaiKubun02.toValue(entity.get前々回要介護度()).get名称());
            ichijiEntity.set前回要介護度(RString.isNullOrEmpty(entity.get前回認定結果()) ? RString.EMPTY
                    : YokaigoJotaiKubun02.toValue(entity.get前回認定結果()).get名称());
            ichijiEntity.set一次判定結果(RString.isNullOrEmpty(entity.get一次判定結果()) ? RString.EMPTY
                    : YokaigoJotaiKubun02.toValue(entity.get一次判定結果()).get名称());
            ichijiEntity.set二次判定結果(RString.isNullOrEmpty(entity.get二次判定結果()) ? RString.EMPTY
                    : YokaigoJotaiKubun02.toValue(entity.get二次判定結果()).get名称());
        }
        if (判定結果コード99.equals(entity.get厚労省IF識別コード().substring(0, 2))) {
            ichijiEntity.set前々回要介護度(RString.isNullOrEmpty(entity.get前々回要介護度()) ? RString.EMPTY
                    : YokaigoJotaiKubun99.toValue(entity.get前々回要介護度()).get名称());
            ichijiEntity.set前回要介護度(RString.isNullOrEmpty(entity.get前回認定結果()) ? RString.EMPTY
                    : YokaigoJotaiKubun99.toValue(entity.get前回認定結果()).get名称());
            ichijiEntity.set一次判定結果(RString.isNullOrEmpty(entity.get一次判定結果()) ? RString.EMPTY
                    : YokaigoJotaiKubun99.toValue(entity.get一次判定結果()).get名称());
            ichijiEntity.set二次判定結果(RString.isNullOrEmpty(entity.get二次判定結果()) ? RString.EMPTY
                    : YokaigoJotaiKubun99.toValue(entity.get二次判定結果()).get名称());
        }
    }

    private RString get名称34(List<DbT5211NinteichosahyoChosaItemEntity> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size()) {
            if (RString.isNullOrEmpty(dbt5211Entity.get(連番).getResearchItem())) {
                return RString.EMPTY;
            }
            return ChosaAnser34.toValue(dbt5211Entity.get(連番).getResearchItem()).get名称();
        }
        return RString.EMPTY;
    }

    private RString get名称33(List<DbT5211NinteichosahyoChosaItemEntity> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size()) {
            if (RString.isNullOrEmpty(dbt5211Entity.get(連番).getResearchItem())) {
                return RString.EMPTY;
            }
            return ChosaAnser33.toValue(dbt5211Entity.get(連番).getResearchItem()).get名称();
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

    private RString get名称13(List<DbT5211NinteichosahyoChosaItemEntity> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size()) {
            if (RString.isNullOrEmpty(dbt5211Entity.get(連番).getResearchItem())) {
                return RString.EMPTY;
            }
            return ChosaAnser13.toValue(dbt5211Entity.get(連番).getResearchItem()).get名称();
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

    private RString get名称10(List<DbT5211NinteichosahyoChosaItemEntity> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size()) {
            if (RString.isNullOrEmpty(dbt5211Entity.get(連番).getResearchItem())) {
                return RString.EMPTY;
            }
            return ChosaAnser10.toValue(dbt5211Entity.get(連番).getResearchItem()).get名称();
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

    private RString get名称07(List<DbT5211NinteichosahyoChosaItemEntity> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size()) {
            if (RString.isNullOrEmpty(dbt5211Entity.get(連番).getResearchItem())) {
                return RString.EMPTY;
            }
            return ChosaAnser07.toValue(dbt5211Entity.get(連番).getResearchItem()).get名称();
        }
        return RString.EMPTY;
    }

    private RString get名称06(List<DbT5211NinteichosahyoChosaItemEntity> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size()) {
            if (RString.isNullOrEmpty(dbt5211Entity.get(連番).getResearchItem())) {
                return RString.EMPTY;
            }
            return ChosaAnser06.toValue(dbt5211Entity.get(連番).getResearchItem()).get名称();
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

    private RString get名称12(List<DbT5211NinteichosahyoChosaItemEntity> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size()) {
            if (RString.isNullOrEmpty(dbt5211Entity.get(連番).getResearchItem())) {
                return RString.EMPTY;
            }
            return ChosaAnser12.toValue(dbt5211Entity.get(連番).getResearchItem()).get名称();
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
                        ReportIdDBE.DBE517181.getReportId().value(),
                        association.getLasdecCode_().getColumnValue(),
                        association.get市町村名(),
                        new RString(JobContextHolder.getJobId()),
                        ReportInfo.getReportName(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE517181.getReportId().value()),
                        new RString(String.valueOf(reportSourceWriter.pageCount().value())),
                        CSV出力有無,
                        CSVファイル名,
                        出力条件);
        OutputJokenhyoFactory.createInstance(帳票出力条件表パラメータ).print();
    }
}
