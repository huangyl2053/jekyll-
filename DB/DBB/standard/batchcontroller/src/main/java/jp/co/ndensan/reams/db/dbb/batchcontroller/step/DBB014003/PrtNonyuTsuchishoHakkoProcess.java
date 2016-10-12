/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB014003;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import jp.co.ndensan.reams.db.dbb.business.core.fukaatena.FukaAtena;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJoho;
import jp.co.ndensan.reams.db.dbb.business.core.karisanteiidotsuchisho.TsuchishoKyotsuEntity;
import jp.co.ndensan.reams.db.dbb.business.report.NonyuTsuchisho;
import jp.co.ndensan.reams.db.dbb.business.report.karinonyutsuchishohakkoichiran.KariNonyuTsuchishoHakkoIchiranProperty.DBB100014NonyuTsuchishoEnum;
import jp.co.ndensan.reams.db.dbb.business.report.karinonyutsuchishohakkoichiran.KariNonyuTsuchishoHakkoIchiranReport;
import jp.co.ndensan.reams.db.dbb.business.report.karisanteihokenryononyutsuchishobook.KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverReport;
import jp.co.ndensan.reams.db.dbb.business.report.karisanteihokenryononyutsuchishobook.KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverReport;
import jp.co.ndensan.reams.db.dbb.business.report.karisanteihokenryononyutsuchishobook.KarisanteiNonyuTsuchishoBookFuriKaeAriRenchoCoverReport;
import jp.co.ndensan.reams.db.dbb.business.report.karisanteihokenryononyutsuchishobook.KarisanteiNonyuTsuchishoBookFuriKaeNashiRenchoCoverReport;
import jp.co.ndensan.reams.db.dbb.business.report.karisanteihokenryononyutsuchishoginfuri.KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoReport;
import jp.co.ndensan.reams.db.dbb.business.report.karisanteihokenryononyutsuchishoginfuri.KarisanteiHokenryoNonyuTsuchishoGinfuriReport;
import jp.co.ndensan.reams.db.dbb.business.report.karisanteihokenryononyutsuchishokigoto.KarisanteiHokenryoNonyuTsuchishoKigotoRenchoReport;
import jp.co.ndensan.reams.db.dbb.business.report.karisanteihokenryononyutsuchishokigoto.KarisanteiHokenryoNonyuTsuchishoKigotoReport;
import jp.co.ndensan.reams.db.dbb.business.report.karisanteinonyutsuchishocvskakuko.KarisanteiNonyuTsuchishoCVSKakukoRenchoReport;
import jp.co.ndensan.reams.db.dbb.business.report.karisanteinonyutsuchishocvskakuko.KarisanteiNonyuTsuchishoCVSKakukoReport;
import jp.co.ndensan.reams.db.dbb.business.report.karisanteinonyutsuchishocvskigoto.KarisanteiNonyuTsuchishoCVSKigotoReport;
import jp.co.ndensan.reams.db.dbb.business.report.karisanteinonyutsuchishocvskigoto.KarisanteiNonyuTsuchishoCVSMultiRenchoCoverReport;
import jp.co.ndensan.reams.db.dbb.business.report.karisanteinonyutsuchishocvsmulti.KarisanteiNonyuTsuchishoCVSMultiRenchoReport;
import jp.co.ndensan.reams.db.dbb.business.report.karisanteinonyutsuchishocvsmulti.KarisanteiNonyuTsuchishoCVSMultiReport;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.KariSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedKariSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiNonyuTsuchiShoSeigyoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NokiJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.ShunyuJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.UniversalPhase;
import jp.co.ndensan.reams.db.dbb.definition.core.ShoriKubun;
import jp.co.ndensan.reams.db.dbb.definition.core.choshuhoho.ChoshuHohoKibetsu;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.fuchokaritsuchishoikkatsuhakko.FuchokaritsuchishoikkatsuhakkoParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbb014003.FuchoKarisanteiTsuchishoHakkoProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2015KeisangoJohoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2017TsuchishoHakkogoIdoshaEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fuchokaritsuchishoikkatsuhakko.FuchoKariTsuchishoIkkatsuHakkoTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fuchokaritsuchishoikkatsuhakko.FukaJohoZenendoTmpEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajoho.fukajoho.FukaJohoRelateEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajoho.kibetsu.KibetsuEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.karinonyutsuchishohakkoichiran.KariNonyuTsuchishoHakkoIchiranSource;
import jp.co.ndensan.reams.db.dbb.entity.report.karisanteihokenryononyutsuchishobook.KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverSource;
import jp.co.ndensan.reams.db.dbb.entity.report.karisanteihokenryononyutsuchishobook.KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource;
import jp.co.ndensan.reams.db.dbb.entity.report.karisanteihokenryononyutsuchishobook.KarisanteiNonyuTsuchishoBookFuriKaeAriRenchoCoverSource;
import jp.co.ndensan.reams.db.dbb.entity.report.karisanteihokenryononyutsuchishobook.KarisanteiNonyuTsuchishoBookFuriKaeNashiRenchoCoverSource;
import jp.co.ndensan.reams.db.dbb.entity.report.karisanteihokenryononyutsuchishoginfuri.KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource;
import jp.co.ndensan.reams.db.dbb.entity.report.karisanteihokenryononyutsuchishoginfuri.KarisanteiHokenryoNonyuTsuchishoGinfuriSource;
import jp.co.ndensan.reams.db.dbb.entity.report.karisanteihokenryononyutsuchishokigoto.KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource;
import jp.co.ndensan.reams.db.dbb.entity.report.karisanteihokenryononyutsuchishokigoto.KarisanteiHokenryoNonyuTsuchishoKigotoSource;
import jp.co.ndensan.reams.db.dbb.entity.report.karisanteinonyutsuchishocvskakuko.KarisanteiNonyuTsuchishoCVSKakukoRenchoSource;
import jp.co.ndensan.reams.db.dbb.entity.report.karisanteinonyutsuchishocvskakuko.KarisanteiNonyuTsuchishoCVSKakukoSource;
import jp.co.ndensan.reams.db.dbb.entity.report.karisanteinonyutsuchishocvskigoto.KarisanteiNonyuTsuchishoCVSKigotoSource;
import jp.co.ndensan.reams.db.dbb.entity.report.karisanteinonyutsuchishocvskigoto.KarisanteiNonyuTsuchishoCVSMultiRenchoCoverSource;
import jp.co.ndensan.reams.db.dbb.entity.report.karisanteinonyutsuchishocvsmulti.KarisanteiNonyuTsuchishoCVSMultiRenchoSource;
import jp.co.ndensan.reams.db.dbb.entity.report.karisanteinonyutsuchishocvsmulti.KarisanteiNonyuTsuchishoCVSMultiSource;
import jp.co.ndensan.reams.db.dbb.service.core.honsanteitsuchishoikkatsuhakko.HonsanteiTsuchishoIkkatsuHakkoFath;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.FukaNokiResearcher;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.NonyuTsuchiShoSeigyoJohoLoaderFinder;
import jp.co.ndensan.reams.db.dbb.service.report.tsuchisho.notsu.NonyuTsuchiShoJohoFactory;
import jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.FuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KitsukiList;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.TokuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2003KibetsuEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.UrT0705ChoteiKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedKoza;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoKyotsuManager;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.AtesakiFactory;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.koza.Koza;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.AtesakiShubetsu;
import jp.co.ndensan.reams.ur.urc.business.core.noki.nokikanri.Noki;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.business.report.daikoprint.DaikoPrintItem;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.definition.core.codemaster.URZCodeShubetsu;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.daikoprint.DaikoPrintFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvListWriter;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 普徴仮算定通知書一括発行の納入通知書の発行Processクラスです。
 *
 * @reamsid_L DBB-0710-030 yebangqiang
 */
public class PrtNonyuTsuchishoHakkoProcess extends BatchProcessBase<FuchoKariTsuchishoIkkatsuHakkoTempEntity> {

    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate."
            + "fuchokaritsuchishoikkatsuhakko.IFuchoKarisanteiTsuchishoHakkoMapper.select出力対象データ");
    private static final int NUM_0 = 0;
    private static final int NUM_1 = 1;
    private static final int NUM_2 = 2;
    private static final int NUM_4 = 4;
    private static final int NUM_7 = 7;
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBB200007"));
    private static final RString 出力期表示方法_1 = new RString("1");
    private static final RString 帳票タイプ_期毎タイプ = new RString("期毎タイプ");
    private static final RString 帳票タイプ_銀振タイプ = new RString("銀振タイプ");
    private static final RString 帳票タイプ_ブックタイプ = new RString("ブックタイプ");
    private static final RString 帳票タイプ_コンビニタイプ = new RString("コンビニタイプ");
    private static final int 特徴納期_1期 = 1;
    private static final int 特徴納期_3期 = 3;
    private static final RString 生活保護者先頭出力フラグ_する = new RString("1");
    private static final RString 生活保護者先頭出力フラグ_しない = new RString("0");
    private static final int INDEX_0 = 0;
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private static final int INDEX_5 = 5;
    private static final int INDEX_6 = 6;
    private static final int INDEX_14 = 14;
    private static final RString 降順 = new RString("DESC,");
    private static final RString 昇順 = new RString("ASC,");
    private static final RString 英数字ファイル名 = new RString("TokubetsuChoshuHeijunkaKakuteiData.csv");
    private static final RString 生活保護区分 = new RString("seikatsuHogoKubun");
    private static final RString 口座区分 = new RString("dbT2015KeisangoJoho_kozaKubun");
    private static final int 月_4 = 4;
    private static final int 月_5 = 5;
    private static final int 月_6 = 6;
    private static final int 月_7 = 7;
    private static final int 月_8 = 8;
    private static final int 月_9 = 9;
    private static final int 月_10 = 10;
    private static final int 月_11 = 11;
    private static final int 月_12 = 12;
    private static final int 月_1 = 1;
    private static final int 月_2 = 2;
    private static final int 月_3 = 3;
    private static final int 月_14 = 14;
    private static final int 月_15 = 15;
    private static final RString 重複な期情報 = new RString("0");
    private static final RString 山分け区分_する = new RString(0);
    private static final RString 山分け区分_しない = new RString("1");
    private static final int 出力期リストのサイズ_1 = 1;
    private static final int 出力期リストのサイズ_2 = 2;
    private static final int 出力期リストのサイズ_3 = 3;
    private static final int 出力期リストのサイズ_4 = 4;
    private static final int 出力期リストのサイズ_5 = 5;
    private static final int 出力期リストのサイズ_6 = 6;
    private static final int 出力期リストのサイズ_7 = 7;
    private static final int 出力期リストのサイズ_8 = 8;
    private static final int 出力期リストのサイズ_9 = 9;
    private static final int 出力期リストのサイズ_10 = 10;
    private static final int 山分け用スプール数_1 = 1;
    private static final int 山分け用スプール数_2 = 2;
    private static final int 山分け用スプール数_3 = 3;
    private static final int 山分け用スプール数_4 = 4;
    private static final int 山分け用スプール数_5 = 5;
    private static final RString ブック開始位置_1 = new RString("1");
    private static final RString ブック開始位置_2 = new RString("2");
    private static final RString ブック開始位置_3 = new RString("3");
    private static final RString ブック開始位置_4 = new RString("4");
    private static final RString ブック開始位置_5 = new RString("5");
    private static final RString 定数_特徴方法 = new RString("getTkKibetsuGaku");
    private static final RString 定数_普徴方法 = new RString("getFuKibetsuGaku");
    private static final RString ゆうちょ銀行 = new RString("9900");
    private static final RString HYPHEN = new RString("-");
    private static final RString タイトル_作成日時 = new RString("作成年月日");
    private static final RString タイトル_作成時刻 = new RString("作成時刻");
    private static final RString タイトル_通知書番号 = new RString("通知書番号");
    private static final RString タイトル_被保険者番号 = new RString("被保険者番号");
    private static final RString タイトル_世帯コード = new RString("世帯コード");
    private static final RString タイトル_表示コード名１ = new RString("表示コード名１");
    private static final RString タイトル_表示コード名２ = new RString("表示コード名２");
    private static final RString タイトル_表示コード名３ = new RString("表示コード名３");
    private static final RString タイトル_表示コード１ = new RString("表示コード1");
    private static final RString タイトル_表示コード２ = new RString("表示コード2");
    private static final RString タイトル_表示コード３ = new RString("表示コード3");
    private static final RString タイトル_行政区 = new RString("行政区");
    private static final RString タイトル_保険料額 = new RString("保険料額");
    private static final RString タイトル_当期 = new RString("当期");
    private static final RString タイトル_納付人_送付先 = new RString("代納人／送付先");
    private static final RString タイトル_生保開始日 = new RString("生保開始日");
    private static final RString タイトル_生保種別 = new RString("生保種別");
    private static final RString タイトル_氏名 = new RString("氏名");
    private static final RString タイトル_郵便番号 = new RString("郵便番号");
    private static final RString タイトル_住所 = new RString("住所");
    private static final RString タイトル_町域_管内_管外住所 = new RString("町域（管内）・管外住所");
    private static final RString タイトル_番地 = new RString("番地");
    private static final RString タイトル_所得段階 = new RString("前所得段階");
    private static final RString タイトル_仮特別徴収額 = new RString("仮特別徴収額");
    private static final RString タイトル_次期以降 = new RString("次期以降");
    private static final RString タイトル_口座情報 = new RString("口座情報");
    private static final RString パラメータ名_調定年度 = new RString("調定年度");
    private static final RString パラメータ名_賦課年度 = new RString("賦課年度");
    private static final RString パラメータ名_対象者 = new RString("対象者");
    private static final RString パラメータ名_発行日 = new RString("発行日");
    private static final RString パラメータ名_出力期 = new RString("出力期");
    private static final RString パラメータ名_生活保護対象者をまとめて先頭に出力 = new RString("生活保護対象者をまとめて先頭に出力");
    private static final RString パラメータ名_ページごとに山分け = new RString("ページごとに山分け");
    private static final RString CSV出力有無_なし = new RString("なし");
    private static final RString CSVファイル名_なし = new RString("なし");
    private static final RString 処理名 = new RString("普徴仮算定通知書一括発行");
    private static final RString 出力条件_左括弧 = new RString("【");
    private static final RString 出力条件_右括弧 = new RString("】");
    private static final ReportId 納入通知書_帳票分類ID = new ReportId("DBB100014_KarisanteiHokenryoNonyuTsuchishoDaihyo");
    private static final RString ジョブ番号 = new RString("【ジョブ番号】");
    private NinshoshaSource dbb100014NinshoshaSource;
    private NinshoshaSource dbb100015NinshoshaSource;
    private NinshoshaSource dbb100018NinshoshaSource;
    private NinshoshaSource dbb100019NinshoshaSource;
    private NinshoshaSource dbb100021NinshoshaSource;
    private NinshoshaSource dbb100023NinshoshaSource;
    private NinshoshaSource dbb100020NinshoshaSource;
    private NinshoshaSource dbb100022NinshoshaSource;
    private NinshoshaSource dbb100026NinshoshaSource;
    private NinshoshaSource dbb100027NinshoshaSource;
    private NinshoshaSource dbb100024NinshoshaSource;
    private NinshoshaSource dbb100025NinshoshaSource;
    private NinshoshaSource dbb100028NinshoshaSource;
    private NinshoshaSource dbb100029NinshoshaSource;
    private BatchReportWriter<KarisanteiHokenryoNonyuTsuchishoKigotoSource> dbb100014reportWriter;
    private ReportSourceWriter<KarisanteiHokenryoNonyuTsuchishoKigotoSource> dbb100014ReportSourceWriter;
    private BatchReportWriter<KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource> dbb100015reportWriter;
    private ReportSourceWriter<KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource> dbb100015ReportSourceWriter;
    private BatchReportWriter<KarisanteiHokenryoNonyuTsuchishoGinfuriSource> dbb100018reportWriter;
    private ReportSourceWriter<KarisanteiHokenryoNonyuTsuchishoGinfuriSource> dbb100018ReportSourceWriter;
    private BatchReportWriter<KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource> dbb100019reportWriter;
    private ReportSourceWriter<KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource> dbb100019ReportSourceWriter;
    private BatchReportWriter<KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource> dbb100021reportWriter;
    private ReportSourceWriter<KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource> dbb100021ReportSourceWriter;
    private BatchReportWriter<KarisanteiNonyuTsuchishoBookFuriKaeNashiRenchoCoverSource> dbb100023reportWriter;
    private ReportSourceWriter<KarisanteiNonyuTsuchishoBookFuriKaeNashiRenchoCoverSource> dbb100023ReportSourceWriter;
    private BatchReportWriter<KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverSource> dbb100020reportWriter;
    private ReportSourceWriter<KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverSource> dbb100020ReportSourceWriter;
    private BatchReportWriter<KarisanteiNonyuTsuchishoBookFuriKaeAriRenchoCoverSource> dbb100022reportWriter;
    private ReportSourceWriter<KarisanteiNonyuTsuchishoBookFuriKaeAriRenchoCoverSource> dbb100022ReportSourceWriter;
    private BatchReportWriter<KarisanteiNonyuTsuchishoCVSMultiSource> dbb100026reportWriter;
    private ReportSourceWriter<KarisanteiNonyuTsuchishoCVSMultiSource> dbb100026ReportSourceWriter;
    private BatchReportWriter<KarisanteiNonyuTsuchishoCVSMultiRenchoSource> dbb100027reportWriter;
    private ReportSourceWriter<KarisanteiNonyuTsuchishoCVSMultiRenchoSource> dbb100027ReportSourceWriter;
    private BatchReportWriter<KarisanteiNonyuTsuchishoCVSKakukoSource> dbb100024reportWriter;
    private ReportSourceWriter<KarisanteiNonyuTsuchishoCVSKakukoSource> dbb100024ReportSourceWriter;
    private BatchReportWriter<KarisanteiNonyuTsuchishoCVSKakukoRenchoSource> dbb100025reportWriter;
    private ReportSourceWriter<KarisanteiNonyuTsuchishoCVSKakukoRenchoSource> dbb100025ReportSourceWriter;
    private BatchReportWriter<KarisanteiNonyuTsuchishoCVSKigotoSource> dbb100028reportWriter;
    private ReportSourceWriter<KarisanteiNonyuTsuchishoCVSKigotoSource> dbb100028ReportSourceWriter;
    private BatchReportWriter<KarisanteiNonyuTsuchishoCVSMultiRenchoCoverSource> dbb100029reportWriter;
    private ReportSourceWriter<KarisanteiNonyuTsuchishoCVSMultiRenchoCoverSource> dbb100029ReportSourceWriter;
    private RDate nowDate;
    private KitsukiList 期月リスト_普徴;
    private List<NokiJoho> 出力期の期月情報リスト;
    private int 出力期;
    private TsuchishoKyotsuEntity 通知書共通情報;
    private KariSanteiNonyuTsuchiShoSeigyoJoho 仮算定納入通知書制御情報;
    private FuchoKarisanteiTsuchishoHakkoProcessParameter processParameter;
    private IOutputOrder outputOrder;
    private Association 導入団体クラス;
    private RString eucFilePath;
    private RString 出力順;
    private RString 帳票名;
    private FileSpoolManager manager;
    private ChohyoSeigyoKyotsu 帳票制御共通;
    private List<RString> 出力順リスト;
    private List<RString> 改頁条件リスト;
    private TsuchishoNo tsuchishoNo;
    private FlexibleYear choteiNendo;
    private FlexibleYear fukaNendo;
    private Decimal 連番;
    private int rirekiNo;
    private int 山分け用スプール数;
    private int 総ページ数;
    private LasdecCode 市町村コード;
    private RString 市町村名;
    private ReportId 帳票ID;
    private DbT2002FukaEntity fukaEntity;
    private DbT2003KibetsuEntity kibetsuEntity;
    private FuchoKariTsuchishoIkkatsuHakkoTempEntity lastEntity;
    private List<KibetsuEntity> kibetsuEntityList;
    private List<UrT0705ChoteiKyotsuEntity> choteiKyotsuEntityList;
    private Map<String, ReportSourceWriter> スプール;
    private Map<String, BatchReportWriter> reportWriter;
    @BatchWriter
    private CsvListWriter csvListWriter;
    @BatchWriter
    private BatchReportWriter<KariNonyuTsuchishoHakkoIchiranSource> batchReportWriter;
    private ReportSourceWriter<KariNonyuTsuchishoHakkoIchiranSource> reportSourceWriter;
    @BatchWriter
    private BatchPermanentTableWriter permanentTableWriter;

    @Override
    protected void initialize() {
        連番 = Decimal.ONE;
        スプール = new HashMap<>();
        reportWriter = new HashMap<>();
        outputOrder = ChohyoShutsuryokujunFinderFactory.createInstance().get出力順(
                SubGyomuCode.DBB介護賦課, 納入通知書_帳票分類ID,
                processParameter.get出力帳票一覧List().get(NUM_0).get出力順ID());
        導入団体クラス = AssociationFinderFactory.createInstance().getAssociation();
        出力順 = RString.EMPTY;
        出力順リスト設定();
        帳票ID = processParameter.get出力帳票一覧List().get(NUM_0).get帳票ID();
        帳票名 = get帳票名();
        nowDate = RDate.getNowDate();
        kibetsuEntityList = new ArrayList<>();
        choteiKyotsuEntityList = new ArrayList<>();

        RString 帳票タイプ = get帳票タイプ();
        FuchoKiUtil 月期対応取得_普徴 = new FuchoKiUtil();
        期月リスト_普徴 = 月期対応取得_普徴.get期月リスト();
        get出力期の期月情報リスト();
        山分け用スプール数 = 山分け用スプール数の算出(帳票タイプ);

        通知書共通情報 = get通知書共通情報(processParameter.get調定年度());
        仮算定納入通知書制御情報 = NonyuTsuchiShoSeigyoJohoLoaderFinder.createInstance().get仮算定納入通知書制御情報();
        ChohyoSeigyoKyotsuManager chohyoSeigyoKyotsuManager = new ChohyoSeigyoKyotsuManager();
        帳票制御共通 = chohyoSeigyoKyotsuManager.get帳票制御共通(SubGyomuCode.DBB介護賦課, 納入通知書_帳票分類ID);
    }

    @Override
    protected IBatchReader createReader() {
        KitsukiList 普徴仮算定期間 = 期月リスト_普徴.filtered仮算定期間();
        出力期 = Integer.parseInt(processParameter.get出力期().toString());

        int 普徴仮算定期間の最後の期 = 普徴仮算定期間.getLast().get期AsInt();
        final RString 生活保護対象者をまとめて先頭に出力 = processParameter.get生活保護対象者をまとめて先頭に出力();
        RString 出力順_文字列 = 出力順文字列を取得(出力順, 生活保護対象者をまとめて先頭に出力);
        FuchokaritsuchishoikkatsuhakkoParameter param = FuchokaritsuchishoikkatsuhakkoParameter.createSelectByKeyParam(
                普徴仮算定期間の最後の期, 出力期, processParameter.get対象者(), 生活保護対象者をまとめて先頭に出力, 出力順_文字列);
        return new BatchDbReader(MAPPERPATH, param);
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB200007.getReportId().value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);

        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther,
                EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        eucFilePath = Path.combinePath(spoolWorkPath, 英数字ファイル名);
        List<RString> headerList = new ArrayList<>();
        csvファイルヘーダ設定(headerList);
        csvListWriter = new CsvListWriter.InstanceBuilder(eucFilePath).setNewLine(NewLine.CRLF)
                .setDelimiter(EUC_WRITER_DELIMITER)
                .setEnclosure(EUC_WRITER_ENCLOSURE)
                .setEncode(Encode.UTF_8withBOM)
                .hasHeader(true).setHeader(headerList)
                .build();

        permanentTableWriter = new BatchPermanentTableWriter(DbT2017TsuchishoHakkogoIdoshaEntity.class);

        initializ納入通知書();
    }

    @Override
    protected void process(FuchoKariTsuchishoIkkatsuHakkoTempEntity entity) {
        final FukaJohoZenendoTmpEntity 賦課情報 = entity.get賦課情報();
        if (choteiNendo == null) {
            lastEntity = entity;
            set賦課情報集計前データ(賦課情報);
        } else if ((!choteiNendo.equals(賦課情報.getChoteiNendo())) || (!fukaNendo.equals(賦課情報.getFukaNendo()))
                || (!tsuchishoNo.equals(賦課情報.getTsuchishoNo())) || (rirekiNo != 賦課情報.getRirekiNo())) {
            FukaJohoRelateEntity fukaJohoRelateEntity = new FukaJohoRelateEntity();
            fukaJohoRelateEntity.set介護賦課Entity(fukaEntity);
            fukaJohoRelateEntity.set介護期別RelateEntity(kibetsuEntityList);
            fukaEntity = null;
            kibetsuEntity = null;
            choteiKyotsuEntityList = new ArrayList<>();
            kibetsuEntityList = new ArrayList<>();
            set賦課情報集計前データ(賦課情報);
            保険料納入通知書発行(lastEntity, fukaJohoRelateEntity);
            permanentTableWriter.insert(get通知書発行後異動者(processParameter.getシステム日時(),
                    lastEntity.get計算後情報_更正後(), 連番.intValue()));
            連番 = 連番.add(Decimal.ONE);
            lastEntity = entity;
        } else {
            lastEntity = entity;
            set賦課情報集計前データ(賦課情報);
        }
    }

    private void 保険料納入通知書発行(
            FuchoKariTsuchishoIkkatsuHakkoTempEntity entity, FukaJohoRelateEntity fukaJohoRelateEntity) {
        Long shunoId = Long.valueOf(entity.get賦課情報().getShunoId());
        市町村コード = 導入団体クラス.get地方公共団体コード();
        市町村名 = 導入団体クラス.get市町村名();
        List<Kitsuki> 出力期リスト = get出力期リスト(出力期);
        KariSanteiTsuchiShoKyotsu 保険料納入通知書仮算定情報 = new KariSanteiTsuchiShoKyotsu();
        保険料納入通知書仮算定情報.set発行日(processParameter.get発行日());
        保険料納入通知書仮算定情報.set帳票分類ID(processParameter.get出力帳票一覧List().get(NUM_0).get帳票分類ID());
        保険料納入通知書仮算定情報.set帳票ID(帳票ID);
        保険料納入通知書仮算定情報.set処理区分(ShoriKubun.バッチ);
        保険料納入通知書仮算定情報.set地方公共団体(導入団体クラス);
        FukaAtena 賦課情報_宛名_更正前 = new FukaAtena();
        IKojin 宛名 = ShikibetsuTaishoFactory.createKojin(entity.get宛名識別対象());
        賦課情報_宛名_更正前.set賦課情報(get賦課情報(entity.get計算後情報_更正前(), shunoId));
        賦課情報_宛名_更正前.set宛名(宛名);
        FukaAtena 賦課情報_宛名_更正後 = new FukaAtena();
        賦課情報_宛名_更正後.set賦課情報(get賦課情報(entity.get計算後情報_更正後(), shunoId));
        賦課情報_宛名_更正後.set宛名(宛名);
        保険料納入通知書仮算定情報.set賦課の情報_更正前(賦課情報_宛名_更正前);
        保険料納入通知書仮算定情報.set賦課の情報_更正後(賦課情報_宛名_更正後);
        保険料納入通知書仮算定情報.set納組情報(entity.get納組());
        保険料納入通知書仮算定情報.set普徴納期情報リスト(通知書共通情報.get普徴納期情報リスト());
        保険料納入通知書仮算定情報.set特徴納期情報リスト(通知書共通情報.get特徴納期情報リスト());
        IAtesaki 宛先情報 = AtesakiFactory.createInstance(entity.get宛先());
        保険料納入通知書仮算定情報.set宛先情報(宛先情報);
        保険料納入通知書仮算定情報.set前年度賦課情報(new FukaJoho(fukaJohoRelateEntity));
        保険料納入通知書仮算定情報.set口座情報(new Koza(entity.get特定口座()));
        保険料納入通知書仮算定情報.set徴収方法情報_更正前(get徴収方法情報(entity.get計算後情報_更正前()));
        保険料納入通知書仮算定情報.set徴収方法情報_更正後(get徴収方法情報(entity.get計算後情報_更正後()));
//        保険料納入通知書仮算定情報.set対象者_追加含む_情報_更正前(new NenkinTokuchoKaifuJoho(
//                entity.get年金特徴回付情報_更正前()));
//        保険料納入通知書仮算定情報.set対象者_追加含む_情報_更正後(new NenkinTokuchoKaifuJoho(
//                entity.get年金特徴回付情報_更正後()));
        保険料納入通知書仮算定情報.set収入情報(get収入情報(entity.get計算後情報_更正後()));
        保険料納入通知書仮算定情報.set帳票制御共通(帳票制御共通);
        NonyuTsuchiShoJohoFactory 納入通知書情報作成サービス = new NonyuTsuchiShoJohoFactory();
        KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報 = 納入通知書情報作成サービス.create仮算定納入通知書情報(
                保険料納入通知書仮算定情報, 仮算定納入通知書制御情報, 出力期リスト, 宛先情報.get宛先名称());
        publish納入通知書仮算定(仮算定納入通知書情報);
        List<RString> bodyList = publish納入通知書発行一覧表(仮算定納入通知書情報.get編集後仮算定通知書共通情報());
        csvListWriter.writeLine(bodyList);
        KariNonyuTsuchishoHakkoIchiranReport report = new KariNonyuTsuchishoHakkoIchiranReport(
                仮算定納入通知書情報, 出力順リスト, processParameter.getシステム日時(), 出力期, 導入団体クラス, 連番);
        report.writeBy(reportSourceWriter);
    }

    @Override
    protected void afterExecute() {
        FukaJohoRelateEntity fukaJohoRelateEntity = new FukaJohoRelateEntity();
        fukaJohoRelateEntity.set介護賦課Entity(fukaEntity);
        fukaJohoRelateEntity.set介護期別RelateEntity(kibetsuEntityList);
        保険料納入通知書発行(lastEntity, fukaJohoRelateEntity);
        permanentTableWriter.insert(get通知書発行後異動者(processParameter.getシステム日時(),
                lastEntity.get計算後情報_更正後(), 連番.intValue()));

        if (山分け区分_しない.equals(processParameter.getページごとに山分け())) {
            総ページ数 = スプール.get(String.valueOf(0)).pageCount().value();
        }
        if (帳票制御共通.is代行プリント有無()) {
            代行プリント送付票の出力(processParameter.get調定年度(), processParameter.get賦課年度(), processParameter.get対象者(),
                    processParameter.get発行日(), 出力期, processParameter.get生活保護対象者をまとめて先頭に出力(),
                    processParameter.getページごとに山分け(), 市町村コード, 市町村名, 総ページ数);
        }
        バッチ出力条件リストの出力(processParameter.get発行日(), 出力期, processParameter.get生活保護対象者をまとめて先頭に出力(),
                processParameter.getページごとに山分け(), 市町村コード, 市町村名, new RString(総ページ数));

        manager.spool(SubGyomuCode.DBB介護賦課, eucFilePath);
        close納入通知書();
    }

    private void 代行プリント送付票の出力(FlexibleYear 調定年度, FlexibleYear 賦課年度,
            RString 納入通知書対象者, FlexibleDate 発行日, int 出力期, RString 生活保護者先頭出力フラグ, RString 山分け区分,
            LasdecCode 市町村コード, RString 市町村名, int ページ数) {
        List<RString> 帳票名リスト = new ArrayList<>();
        帳票名リスト.add(帳票名);
        List<Decimal> ページ数リスト = new ArrayList<>();
        ページ数リスト.add(new Decimal(ページ数));
        List<RString> 抽出条件 = new ArrayList<>();
        抽出条件.add(パラメータ名_調定年度.concat(RString.FULL_SPACE).concat(調定年度.wareki().toDateString()));
        抽出条件.add(パラメータ名_賦課年度.concat(RString.FULL_SPACE).concat(賦課年度.wareki().toDateString()));
        抽出条件.add(パラメータ名_対象者.concat(RString.FULL_SPACE).concat(納入通知書対象者));
        List<RString> 詳細設定 = new ArrayList<>();
        詳細設定.add(パラメータ名_発行日.concat(RString.FULL_SPACE).concat(発行日.wareki().toDateString()));
        詳細設定.add(パラメータ名_出力期.concat(RString.FULL_SPACE).concat(new RString(出力期)));
        詳細設定.add(パラメータ名_生活保護対象者をまとめて先頭に出力.concat(RString.FULL_SPACE).concat(
                生活保護者先頭出力フラグ));
        詳細設定.add(パラメータ名_ページごとに山分け.concat(RString.FULL_SPACE).concat(山分け区分));
        DaikoPrintItem item = new DaikoPrintItem(SubGyomuCode.DBB介護賦課, 市町村コード, 市町村名,
                ジョブ番号.concat(RString.FULL_SPACE).concat(new RString(String.valueOf(JobContextHolder.getJobId()))),
                処理名, 帳票ID.value(), 帳票名リスト, ページ数リスト, 抽出条件, 出力順リスト, 改頁条件リスト, 詳細設定);
        DaikoPrintFactory.createInstance(item);
    }

    private void バッチ出力条件リストの出力(FlexibleDate 発行日, int 出力期, RString 生活保護者先頭出力フラグ,
            RString 山分け区分, LasdecCode 市町村コード, RString 市町村名, RString ページ数) {
        List<RString> 出力条件リスト = new ArrayList<>();
        出力条件リスト.add(出力条件_左括弧.concat(パラメータ名_発行日).concat(出力条件_右括弧).concat(
                発行日.wareki().toDateString()));
        出力条件リスト.add(出力条件_左括弧.concat(パラメータ名_出力期).concat(出力条件_右括弧).concat(new RString(出力期)));
        出力条件リスト.add(出力条件_左括弧.concat(パラメータ名_対象者).concat(出力条件_右括弧).concat(processParameter.get対象者()));
        出力条件リスト.add(出力条件_左括弧.concat(パラメータ名_生活保護対象者をまとめて先頭に出力).concat(出力条件_右括弧)
                .concat(生活保護者先頭出力フラグ));
        出力条件リスト.add(出力条件_左括弧.concat(パラメータ名_ページごとに山分け).concat(出力条件_右括弧).
                concat(山分け区分));
        ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                帳票ID.value(),
                市町村コード.value(),
                市町村名,
                new RString(String.valueOf(JobContextHolder.getJobId())),
                帳票名,
                ページ数,
                CSV出力有無_なし,
                CSVファイル名_なし,
                出力条件リスト);
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(reportOutputJokenhyoItem);
        printer.print();
    }

    private void initializ納入通知書() {
        if (ReportIdDBB.DBB100014.getReportId().equals(帳票ID)) {
            for (int idex = 0; idex < 山分け用スプール数; idex++) {
                dbb100014reportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB100014.getReportId().value()).create();
                dbb100014ReportSourceWriter = new ReportSourceWriter<>(dbb100014reportWriter);
                スプール.put(String.valueOf(idex), dbb100014ReportSourceWriter);
                reportWriter.put(String.valueOf(idex), dbb100014reportWriter);
                dbb100014NinshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 納入通知書_帳票分類ID,
                        processParameter.get発行日(), NinshoshaDenshikoinshubetsuCode.保険者印.getコード(),
                        KenmeiFuyoKubunType.付与なし, dbb100014ReportSourceWriter);
            }
        } else if (ReportIdDBB.DBB100015.getReportId().equals(帳票ID)) {
            for (int idex = 0; idex < 山分け用スプール数; idex++) {
                dbb100015reportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB100015.getReportId().value()).create();
                dbb100015ReportSourceWriter = new ReportSourceWriter<>(dbb100015reportWriter);
                スプール.put(String.valueOf(idex), dbb100015ReportSourceWriter);
                reportWriter.put(String.valueOf(idex), dbb100015reportWriter);
                dbb100014NinshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 納入通知書_帳票分類ID,
                        processParameter.get発行日(), NinshoshaDenshikoinshubetsuCode.保険者印.getコード(),
                        KenmeiFuyoKubunType.付与なし, dbb100015ReportSourceWriter);
            }
        } else if (ReportIdDBB.DBB100018.getReportId().equals(帳票ID)) {
            for (int idex = 0; idex < 山分け用スプール数; idex++) {
                dbb100018reportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB100018.getReportId().value()).create();
                dbb100018ReportSourceWriter = new ReportSourceWriter<>(dbb100018reportWriter);
                スプール.put(String.valueOf(idex), dbb100018ReportSourceWriter);
                reportWriter.put(String.valueOf(idex), dbb100018reportWriter);
                dbb100014NinshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 納入通知書_帳票分類ID,
                        processParameter.get発行日(), NinshoshaDenshikoinshubetsuCode.保険者印.getコード(),
                        KenmeiFuyoKubunType.付与なし, dbb100018ReportSourceWriter);
            }
        } else if (ReportIdDBB.DBB100019.getReportId().equals(帳票ID)) {
            for (int idex = 0; idex < 山分け用スプール数; idex++) {
                dbb100019reportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB100019.getReportId().value()).create();
                dbb100019ReportSourceWriter = new ReportSourceWriter<>(dbb100019reportWriter);
                スプール.put(String.valueOf(idex), dbb100019ReportSourceWriter);
                reportWriter.put(String.valueOf(idex), dbb100019reportWriter);
                dbb100014NinshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 納入通知書_帳票分類ID,
                        processParameter.get発行日(), NinshoshaDenshikoinshubetsuCode.保険者印.getコード(),
                        KenmeiFuyoKubunType.付与なし, dbb100019ReportSourceWriter);
            }
        } else if (ReportIdDBB.DBB100021.getReportId().equals(帳票ID)) {
            for (int idex = 0; idex < 山分け用スプール数; idex++) {
                dbb100021reportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB100021.getReportId().value()).create();
                dbb100021ReportSourceWriter = new ReportSourceWriter<>(dbb100021reportWriter);
                スプール.put(String.valueOf(idex), dbb100021ReportSourceWriter);
                reportWriter.put(String.valueOf(idex), dbb100021reportWriter);
                dbb100014NinshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 納入通知書_帳票分類ID,
                        processParameter.get発行日(), NinshoshaDenshikoinshubetsuCode.保険者印.getコード(),
                        KenmeiFuyoKubunType.付与なし, dbb100021ReportSourceWriter);
            }
        } else if (ReportIdDBB.DBB100023.getReportId().equals(帳票ID)) {
            for (int idex = 0; idex < 山分け用スプール数; idex++) {
                dbb100023reportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB100023.getReportId().value()).create();
                dbb100023ReportSourceWriter = new ReportSourceWriter<>(dbb100023reportWriter);
                スプール.put(String.valueOf(idex), dbb100023ReportSourceWriter);
                reportWriter.put(String.valueOf(idex), dbb100023reportWriter);
                dbb100014NinshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 納入通知書_帳票分類ID,
                        processParameter.get発行日(), NinshoshaDenshikoinshubetsuCode.保険者印.getコード(),
                        KenmeiFuyoKubunType.付与なし, dbb100023ReportSourceWriter);
            }
        } else if (ReportIdDBB.DBB100020.getReportId().equals(帳票ID)) {
            for (int idex = 0; idex < 山分け用スプール数; idex++) {
                dbb100020reportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB100020.getReportId().value()).create();
                dbb100020ReportSourceWriter = new ReportSourceWriter<>(dbb100020reportWriter);
                スプール.put(String.valueOf(idex), dbb100020ReportSourceWriter);
                reportWriter.put(String.valueOf(idex), dbb100020reportWriter);
                dbb100014NinshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 納入通知書_帳票分類ID,
                        processParameter.get発行日(), NinshoshaDenshikoinshubetsuCode.保険者印.getコード(),
                        KenmeiFuyoKubunType.付与なし, dbb100020ReportSourceWriter);
            }
        } else {
            initializ納入通知書_ブックタイプ();
        }
    }

    private void initializ納入通知書_ブックタイプ() {
        if (ReportIdDBB.DBB100022.getReportId().equals(帳票ID)) {
            for (int idex = 0; idex < 山分け用スプール数; idex++) {
                dbb100022reportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB100022.getReportId().value()).create();
                dbb100022ReportSourceWriter = new ReportSourceWriter<>(dbb100022reportWriter);
                スプール.put(String.valueOf(idex), dbb100022ReportSourceWriter);
                reportWriter.put(String.valueOf(idex), dbb100022reportWriter);
                dbb100014NinshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 納入通知書_帳票分類ID,
                        processParameter.get発行日(), NinshoshaDenshikoinshubetsuCode.保険者印.getコード(),
                        KenmeiFuyoKubunType.付与なし, dbb100022ReportSourceWriter);
            }
        } else if (ReportIdDBB.DBB100026.getReportId().equals(帳票ID)) {
            for (int idex = 0; idex < 山分け用スプール数; idex++) {
                dbb100026reportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB100026.getReportId().value()).create();
                dbb100026ReportSourceWriter = new ReportSourceWriter<>(dbb100026reportWriter);
                スプール.put(String.valueOf(idex), dbb100026ReportSourceWriter);
                reportWriter.put(String.valueOf(idex), dbb100026reportWriter);
                dbb100014NinshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 納入通知書_帳票分類ID,
                        processParameter.get発行日(), NinshoshaDenshikoinshubetsuCode.保険者印.getコード(),
                        KenmeiFuyoKubunType.付与なし, dbb100026ReportSourceWriter);
            }
        } else if (ReportIdDBB.DBB100027.getReportId().equals(帳票ID)) {
            for (int idex = 0; idex < 山分け用スプール数; idex++) {
                dbb100027reportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB100027.getReportId().value()).create();
                dbb100027ReportSourceWriter = new ReportSourceWriter<>(dbb100027reportWriter);
                スプール.put(String.valueOf(idex), dbb100027ReportSourceWriter);
                reportWriter.put(String.valueOf(idex), dbb100027reportWriter);
                dbb100014NinshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 納入通知書_帳票分類ID,
                        processParameter.get発行日(), NinshoshaDenshikoinshubetsuCode.保険者印.getコード(),
                        KenmeiFuyoKubunType.付与なし, dbb100027ReportSourceWriter);
            }
        } else if (ReportIdDBB.DBB100024.getReportId().equals(帳票ID)) {
            for (int idex = 0; idex < 山分け用スプール数; idex++) {
                dbb100024reportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB100024.getReportId().value()).create();
                dbb100024ReportSourceWriter = new ReportSourceWriter<>(dbb100024reportWriter);
                スプール.put(String.valueOf(idex), dbb100024ReportSourceWriter);
                reportWriter.put(String.valueOf(idex), dbb100024reportWriter);
                dbb100014NinshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 納入通知書_帳票分類ID,
                        processParameter.get発行日(), NinshoshaDenshikoinshubetsuCode.保険者印.getコード(),
                        KenmeiFuyoKubunType.付与なし, dbb100024ReportSourceWriter);
            }
        } else if (ReportIdDBB.DBB100025.getReportId().equals(帳票ID)) {
            for (int idex = 0; idex < 山分け用スプール数; idex++) {
                dbb100025reportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB100025.getReportId().value()).create();
                dbb100025ReportSourceWriter = new ReportSourceWriter<>(dbb100025reportWriter);
                スプール.put(String.valueOf(idex), dbb100025ReportSourceWriter);
                reportWriter.put(String.valueOf(idex), dbb100025reportWriter);
                dbb100014NinshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 納入通知書_帳票分類ID,
                        processParameter.get発行日(), NinshoshaDenshikoinshubetsuCode.保険者印.getコード(),
                        KenmeiFuyoKubunType.付与なし, dbb100025ReportSourceWriter);
            }
        } else if (ReportIdDBB.DBB100028.getReportId().equals(帳票ID)) {
            for (int idex = 0; idex < 山分け用スプール数; idex++) {
                dbb100028reportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB100028.getReportId().value()).create();
                dbb100028ReportSourceWriter = new ReportSourceWriter<>(dbb100028reportWriter);
                スプール.put(String.valueOf(idex), dbb100028ReportSourceWriter);
                reportWriter.put(String.valueOf(idex), dbb100028reportWriter);
                dbb100014NinshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 納入通知書_帳票分類ID,
                        processParameter.get発行日(), NinshoshaDenshikoinshubetsuCode.保険者印.getコード(),
                        KenmeiFuyoKubunType.付与なし, dbb100028ReportSourceWriter);
            }
        } else if (ReportIdDBB.DBB100029.getReportId().equals(帳票ID)) {
            for (int idex = 0; idex < 山分け用スプール数; idex++) {
                dbb100029reportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB100029.getReportId().value()).create();
                dbb100029ReportSourceWriter = new ReportSourceWriter<>(dbb100029reportWriter);
                スプール.put(String.valueOf(idex), dbb100029ReportSourceWriter);
                reportWriter.put(String.valueOf(idex), dbb100029reportWriter);
                dbb100014NinshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 納入通知書_帳票分類ID,
                        processParameter.get発行日(), NinshoshaDenshikoinshubetsuCode.保険者印.getコード(),
                        KenmeiFuyoKubunType.付与なし, dbb100029ReportSourceWriter);
            }
        }
    }

    private RString get帳票名() {
        if (ReportIdDBB.DBB100014.getReportId().equals(帳票ID)) {
            return ReportIdDBB.DBB100014.getReportName();
        } else if (ReportIdDBB.DBB100015.getReportId().equals(帳票ID)) {
            return ReportIdDBB.DBB100015.getReportName();
        } else if (ReportIdDBB.DBB100018.getReportId().equals(帳票ID)) {
            return ReportIdDBB.DBB100018.getReportName();
        } else if (ReportIdDBB.DBB100019.getReportId().equals(帳票ID)) {
            return ReportIdDBB.DBB100019.getReportName();
        } else if (ReportIdDBB.DBB100021.getReportId().equals(帳票ID)) {
            return ReportIdDBB.DBB100021.getReportName();
        } else if (ReportIdDBB.DBB100023.getReportId().equals(帳票ID)) {
            return ReportIdDBB.DBB100023.getReportName();
        } else if (ReportIdDBB.DBB100020.getReportId().equals(帳票ID)) {
            return ReportIdDBB.DBB100020.getReportName();
        } else if (ReportIdDBB.DBB100022.getReportId().equals(帳票ID)) {
            return ReportIdDBB.DBB100022.getReportName();
        } else if (ReportIdDBB.DBB100026.getReportId().equals(帳票ID)) {
            return ReportIdDBB.DBB100026.getReportName();
        } else if (ReportIdDBB.DBB100027.getReportId().equals(帳票ID)) {
            return ReportIdDBB.DBB100027.getReportName();
        } else if (ReportIdDBB.DBB100024.getReportId().equals(帳票ID)) {
            return ReportIdDBB.DBB100024.getReportName();
        } else if (ReportIdDBB.DBB100025.getReportId().equals(帳票ID)) {
            return ReportIdDBB.DBB100025.getReportName();
        } else if (ReportIdDBB.DBB100028.getReportId().equals(帳票ID)) {
            return ReportIdDBB.DBB100028.getReportName();
        } else if (ReportIdDBB.DBB100029.getReportId().equals(帳票ID)) {
            return ReportIdDBB.DBB100029.getReportName();
        }
        return RString.EMPTY;
    }

    private DbT2017TsuchishoHakkogoIdoshaEntity get通知書発行後異動者(YMDHMS 帳票作成日時,
            DbT2015KeisangoJohoEntity 計算後情報_更正後, int 連番) {

        DbT2017TsuchishoHakkogoIdoshaEntity dbt2017entity = new DbT2017TsuchishoHakkogoIdoshaEntity();
        dbt2017entity.setReportID(帳票ID);
        dbt2017entity.setChohyosakuseiTimestamp(帳票作成日時);
        dbt2017entity.setTsuchishoNo(計算後情報_更正後.getTsuchishoNo());
        dbt2017entity.setFukaNendo(計算後情報_更正後.getFukaNendo());
        dbt2017entity.setShikibetsuCode(計算後情報_更正後.getShikibetsuCode());
        dbt2017entity.setHihokenshaNo(計算後情報_更正後.getHihokenshaNo());
        dbt2017entity.setKeisanTimestamp(get調定日時(計算後情報_更正後.getChoteiNichiji()));
        dbt2017entity.setGaitoRemban(連番);
        dbt2017entity.setIdoAriFlag(false);
        dbt2017entity.setState(EntityDataState.Added);
        return dbt2017entity;
    }

    private YMDHMS get調定日時(YMDHMS 調定日時) {
        if (調定日時 == null) {
            return null;
        }
        return 調定日時;
    }

    private void 出力順リスト設定() {
        int i = 0;
        if (outputOrder != null) {
            出力順 = MyBatisOrderByClauseCreator.create(
                    DBB100014NonyuTsuchishoEnum.class, outputOrder);
            出力順リスト = new ArrayList<>();
            改頁条件リスト = new ArrayList<>();
            for (ISetSortItem item : outputOrder.get設定項目リスト()) {
                if (item.is改頁項目()) {
                    改頁条件リスト.add(item.get項目名());
                }
                if (i == INDEX_0) {
                    出力順リスト.add(item.get項目名());
                } else if (i == INDEX_1) {
                    出力順リスト.add(item.get項目名());
                } else if (i == INDEX_2) {
                    出力順リスト.add(item.get項目名());
                } else if (i == INDEX_3) {
                    出力順リスト.add(item.get項目名());
                } else if (i == INDEX_4) {
                    出力順リスト.add(item.get項目名());
                }
                i = i + 1;
            }
        }
    }

    private void get出力期の期月情報リスト() {
        KitsukiList 普徴仮算定期間 = 期月リスト_普徴.filtered仮算定期間();
        int to出力期 = 普徴仮算定期間.getLast().get期AsInt();
        if (出力期表示方法_1.equals(processParameter.get出力期の表示方法())) {
            to出力期 = 出力期;
        }
        KitsukiList 出力期の期月リスト = 期月リスト_普徴.subListBy期(出力期, to出力期);
        List<Noki> 普徴納期リスト = FukaNokiResearcher.createInstance().get普徴納期ALL();
        出力期の期月情報リスト = new ArrayList<>();
        for (Kitsuki 出力期の期月 : 出力期の期月リスト.toList()) {
            for (Noki 普徴納期 : 普徴納期リスト) {
                NokiJoho 期月情報 = new NokiJoho();
                if (出力期の期月.get期AsInt() == 普徴納期.get期別()) {
                    期月情報.set期月(出力期の期月);
                    期月情報.set納期(普徴納期);
                    出力期の期月情報リスト.add(期月情報);
                }
            }
        }
    }

    private int 山分け用スプール数の算出(RString 帳票タイプ) {
        int 山分け用スプール = 0;
        final RString ページごとに山分け = processParameter.getページごとに山分け();
        if (山分け区分_する.equals(ページごとに山分け)) {
            Kitsuki 今回の期月 = null;
            for (NokiJoho 出力期の期月情報 : 出力期の期月情報リスト) {
                final Kitsuki 期月 = 出力期の期月情報.get期月();
                if (期月.get期AsInt() == 出力期) {
                    今回の期月 = 期月;
                    break;
                }
            }
            if (帳票タイプ_期毎タイプ.equals(帳票タイプ)) {
                山分け用スプール = 出力期の期月情報リスト.size();
            } else if (帳票タイプ_銀振タイプ.equals(帳票タイプ)) {
                山分け用スプール = 1;
            } else if (帳票タイプ_ブックタイプ.equals(帳票タイプ)) {
                山分け用スプール = 今回出力期の印字位置を取得と山分け用スプール数の算出(
                        今回の期月, 出力期の期月情報リスト.size());
            } else if (帳票タイプ_コンビニタイプ.equals(帳票タイプ)) {
                山分け用スプール = コンビニカット印字位置を取得と山分け用スプール数の算出(今回の期月);
            }
        } else if (山分け区分_しない.equals(ページごとに山分け)) {
            山分け用スプール = 1;
        }
        return 山分け用スプール;
    }

    private void set賦課情報集計前データ(final FukaJohoZenendoTmpEntity 賦課情報) {
        choteiNendo = 賦課情報.getChoteiNendo();
        fukaNendo = 賦課情報.getFukaNendo();
        tsuchishoNo = 賦課情報.getTsuchishoNo();
        rirekiNo = 賦課情報.getRirekiNo();
        if (fukaEntity == null) {
            fukaEntity = new DbT2002FukaEntity();
            fukaEntity.setChoteiNendo(賦課情報.getChoteiNendo());
            fukaEntity.setFukaNendo(賦課情報.getFukaNendo());
            fukaEntity.setTsuchishoNo(賦課情報.getTsuchishoNo());
            fukaEntity.setRirekiNo(賦課情報.getRirekiNo());
            fukaEntity.setHihokenshaNo(賦課情報.getHihokenshaNo());
            fukaEntity.setShikibetsuCode(賦課情報.getShikibetsuCode());
            fukaEntity.setSetaiCode(賦課情報.getSetaiCode());
            fukaEntity.setSetaiInsu(賦課情報.getSetaiInsu());
            fukaEntity.setShikakuShutokuYMD(賦課情報.getShikakuShutokuYMD());
            fukaEntity.setShikakuShutokuJiyu(賦課情報.getShikakuShutokuJiyu());
            fukaEntity.setShikakuSoshitsuYMD(賦課情報.getShikakuSoshitsuYMD());
            fukaEntity.setShikakuSoshitsuJiyu(賦課情報.getShikakuSoshitsuJiyu());
            fukaEntity.setSeihofujoShurui(賦課情報.getSeihofujoShurui());
            fukaEntity.setSeihoKaishiYMD(賦課情報.getSeihoKaishiYMD());
            fukaEntity.setSeihoHaishiYMD(賦課情報.getSeihoHaishiYMD());
            fukaEntity.setRonenKaishiYMD(賦課情報.getRonenKaishiYMD());
            fukaEntity.setRonenHaishiYMD(賦課情報.getRonenHaishiYMD());
            fukaEntity.setFukaYMD(賦課情報.getFukaYMD());
            fukaEntity.setKazeiKubun(賦課情報.getKazeiKubun());
            fukaEntity.setSetaikazeiKubun(賦課情報.getSetaikazeiKubun());
            fukaEntity.setGokeiShotokuGaku(賦課情報.getGokeiShotokuGaku());
            fukaEntity.setNenkinShunyuGaku(賦課情報.getNenkinShunyuGaku());
            fukaEntity.setHokenryoDankai(賦課情報.getHokenryoDankai());
            fukaEntity.setHokenryoDankai1(賦課情報.getHokenryoDankai1());
            fukaEntity.setNengakuHokenryo1(賦課情報.getNengakuHokenryo1());
            fukaEntity.setTsukiwariStartYM1(賦課情報.getTsukiwariStartYM1());
            fukaEntity.setTsukiwariEndYM1(賦課情報.getTsukiwariEndYM1());
            fukaEntity.setHokenryoDankai2(賦課情報.getHokenryoDankai2());
            fukaEntity.setNengakuHokenryo2(賦課情報.getNengakuHokenryo2());
            fukaEntity.setTsukiwariStartYM2(賦課情報.getTsukiwariStartYM2());
            fukaEntity.setTsukiwariEndYM2(賦課情報.getTsukiwariEndYM2());
            fukaEntity.setChoteiNichiji(賦課情報.getChoteiNichiji());
            fukaEntity.setChoteiJiyu1(賦課情報.getChoteiJiyu1());
            fukaEntity.setChoteiJiyu2(賦課情報.getChoteiJiyu2());
            fukaEntity.setChoteiJiyu3(賦課情報.getChoteiJiyu3());
            fukaEntity.setChoteiJiyu4(賦課情報.getChoteiJiyu4());
            fukaEntity.setKoseiM(賦課情報.getKoseiM());
            fukaEntity.setGemmenMaeHokenryo(賦課情報.getGemmenMaeHokenryo());
            fukaEntity.setGemmenGaku(賦課情報.getGemmenGaku());
            fukaEntity.setKakuteiHokenryo(賦課情報.getKakuteiHokenryo());
            fukaEntity.setHokenryoDankaiKarisanntei(賦課情報.getHokenryoDankaiKarisanntei());
            fukaEntity.setChoshuHohoRirekiNo(賦課情報.getChoshuHohoRirekiNo());
            fukaEntity.setIdoKijunNichiji(賦課情報.getIdoKijunNichiji());
            fukaEntity.setKozaKubun(賦課情報.getKozaKubun());
            fukaEntity.setKyokaisoKubun(賦課情報.getKyokaisoKubun());
            fukaEntity.setShokkenKubun(賦課情報.getShokkenKubun());
            fukaEntity.setFukaShichosonCode(賦課情報.getFukaShichosonCode());
            fukaEntity.setTkSaishutsuKampuGaku(賦課情報.getTkSaishutsuKampuGaku());
            fukaEntity.setFuSaishutsuKampuGaku(賦課情報.getFuSaishutsuKampuGaku());
        }

        KibetsuEntity 介護期別Relate = new KibetsuEntity();

        if (kibetsuEntity == null || (!kibetsuEntity.getChoshuHouhou().equals(賦課情報.getChoshuHouhou()))
                || (kibetsuEntity.getKi() != 賦課情報.getKi())) {
            kibetsuEntity = new DbT2003KibetsuEntity();
            kibetsuEntity.setChoteiNendo(賦課情報.getChoteiNendo());
            kibetsuEntity.setFukaNendo(賦課情報.getFukaNendo());
            kibetsuEntity.setTsuchishoNo(賦課情報.getTsuchishoNo());
            kibetsuEntity.setRirekiNo(賦課情報.getRirekiNo());
            kibetsuEntity.setChoteiId(賦課情報.getChoteiId());
            kibetsuEntity.setChoshuHouhou(賦課情報.getChoshuHouhou());
            kibetsuEntity.setKi(賦課情報.getKi());
            介護期別Relate.set介護期別Entity(kibetsuEntity);
            UrT0705ChoteiKyotsuEntity choteiKyotsuEntity = new UrT0705ChoteiKyotsuEntity();
            choteiKyotsuEntity.setChoteiId(賦課情報.getChoteiId().longValue());
            choteiKyotsuEntity.setChoteigaku(賦課情報.getChoteigaku());
            choteiKyotsuEntity.setShunoId(Long.valueOf(賦課情報.getShunoId()));
            choteiKyotsuEntityList.add(choteiKyotsuEntity);
            介護期別Relate.set調定共通Entity(choteiKyotsuEntityList);
            kibetsuEntityList.add(介護期別Relate);
        }
    }

    private ReportSourceWriter getReportSourceWriter(int idex) {
        if (山分け区分_しない.equals(processParameter.getページごとに山分け())) {
            return スプール.get(String.valueOf(0));
        } else {
            return スプール.get(String.valueOf(idex));
        }
    }

    private void publish納入通知書仮算定(KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報) {
        int ページ数 = 0;
        if (ReportIdDBB.DBB100014.getReportId().equals(帳票ID) && dbb100014NinshoshaSource != null) {
            KarisanteiHokenryoNonyuTsuchishoKigotoReport report = new KarisanteiHokenryoNonyuTsuchishoKigotoReport(
                    仮算定納入通知書情報, dbb100014NinshoshaSource);
            List<NonyuTsuchisho<KarisanteiHokenryoNonyuTsuchishoKigotoSource>> nonyuTsuchishoList = report.devidedByPage();
            for (int idex = 0; idex < nonyuTsuchishoList.size(); idex++) {
                nonyuTsuchishoList.get(idex).writeBy(getReportSourceWriter(idex));
                ページ数 = ページ数 + getReportSourceWriter(idex).pageCount().value();
            }
            総ページ数 = ページ数;
        } else if (ReportIdDBB.DBB100015.getReportId().equals(帳票ID) && dbb100015NinshoshaSource != null) {
            KarisanteiHokenryoNonyuTsuchishoKigotoRenchoReport report = new KarisanteiHokenryoNonyuTsuchishoKigotoRenchoReport(
                    仮算定納入通知書情報, dbb100015NinshoshaSource);
            List<NonyuTsuchisho<KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource>> nonyuTsuchishoList = report.devidedByPage();
            for (int idex = 0; idex < nonyuTsuchishoList.size(); idex++) {
                nonyuTsuchishoList.get(idex).writeBy(getReportSourceWriter(idex));
                ページ数 = ページ数 + getReportSourceWriter(idex).pageCount().value();
            }
            総ページ数 = ページ数;
        } else {
            publish納入通知書_銀振タイプ(仮算定納入通知書情報, ページ数);
        }
    }

    private void publish納入通知書_銀振タイプ(KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報, int ページ数) {
        if (ReportIdDBB.DBB100018.getReportId().equals(帳票ID) && dbb100018NinshoshaSource != null) {
            KarisanteiHokenryoNonyuTsuchishoGinfuriReport report = new KarisanteiHokenryoNonyuTsuchishoGinfuriReport(
                    仮算定納入通知書情報, dbb100018NinshoshaSource);
            List<NonyuTsuchisho<KarisanteiHokenryoNonyuTsuchishoGinfuriSource>> nonyuTsuchishoList = report.devidedByPage();
            for (int idex = 0; idex < nonyuTsuchishoList.size(); idex++) {
                nonyuTsuchishoList.get(idex).writeBy(getReportSourceWriter(idex));
                ページ数 = ページ数 + getReportSourceWriter(idex).pageCount().value();
            }
            総ページ数 = ページ数;
        } else if (ReportIdDBB.DBB100019.getReportId().equals(帳票ID) && dbb100019NinshoshaSource != null) {
            KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoReport report = new KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoReport(
                    仮算定納入通知書情報, dbb100019NinshoshaSource);
            List<NonyuTsuchisho<KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource>> nonyuTsuchishoList = report.devidedByPage();
            for (int idex = 0; idex < nonyuTsuchishoList.size(); idex++) {
                nonyuTsuchishoList.get(idex).writeBy(getReportSourceWriter(idex));
                ページ数 = ページ数 + getReportSourceWriter(idex).pageCount().value();
            }
            総ページ数 = ページ数;
        } else {
            publish納入通知書_ブックタイプ(仮算定納入通知書情報, ページ数);
        }
    }

    private void publish納入通知書_ブックタイプ(KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報, int ページ数) {
        if (ReportIdDBB.DBB100021.getReportId().equals(帳票ID) && dbb100021NinshoshaSource != null) {
            KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverReport report = new KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverReport(
                    仮算定納入通知書情報, dbb100021NinshoshaSource);
            List<NonyuTsuchisho<KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource>> nonyuTsuchishoList = report.devidedByPage();
            for (int idex = 0; idex < nonyuTsuchishoList.size(); idex++) {
                nonyuTsuchishoList.get(idex).writeBy(getReportSourceWriter(idex));
                ページ数 = ページ数 + getReportSourceWriter(idex).pageCount().value();
            }
            総ページ数 = ページ数;
        } else if (ReportIdDBB.DBB100023.getReportId().equals(帳票ID) && dbb100023NinshoshaSource != null) {
            KarisanteiNonyuTsuchishoBookFuriKaeNashiRenchoCoverReport report = new KarisanteiNonyuTsuchishoBookFuriKaeNashiRenchoCoverReport(
                    仮算定納入通知書情報, dbb100023NinshoshaSource);
            List<NonyuTsuchisho<KarisanteiNonyuTsuchishoBookFuriKaeNashiRenchoCoverSource>> nonyuTsuchishoList = report.devidedByPage();
            for (int idex = 0; idex < nonyuTsuchishoList.size(); idex++) {
                nonyuTsuchishoList.get(idex).writeBy(getReportSourceWriter(idex));
                ページ数 = ページ数 + getReportSourceWriter(idex).pageCount().value();
            }
            総ページ数 = ページ数;
        } else if (ReportIdDBB.DBB100022.getReportId().equals(帳票ID) && dbb100022NinshoshaSource != null) {
            KarisanteiNonyuTsuchishoBookFuriKaeAriRenchoCoverReport report = new KarisanteiNonyuTsuchishoBookFuriKaeAriRenchoCoverReport(
                    仮算定納入通知書情報, dbb100022NinshoshaSource);
            List<NonyuTsuchisho<KarisanteiNonyuTsuchishoBookFuriKaeAriRenchoCoverSource>> nonyuTsuchishoList = report.devidedByPage();
            for (int idex = 0; idex < nonyuTsuchishoList.size(); idex++) {
                nonyuTsuchishoList.get(idex).writeBy(getReportSourceWriter(idex));
                ページ数 = ページ数 + getReportSourceWriter(idex).pageCount().value();
            }
            総ページ数 = ページ数;
        } else if (ReportIdDBB.DBB100020.getReportId().equals(帳票ID) && dbb100020NinshoshaSource != null) {
            KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverReport report = new KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverReport(
                    仮算定納入通知書情報, dbb100020NinshoshaSource);
            List<NonyuTsuchisho<KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverSource>> nonyuTsuchishoList = report.devidedByPage();
            for (int idex = 0; idex < nonyuTsuchishoList.size(); idex++) {
                nonyuTsuchishoList.get(idex).writeBy(getReportSourceWriter(idex));
                ページ数 = ページ数 + getReportSourceWriter(idex).pageCount().value();
            }
            総ページ数 = ページ数;
        } else {
            print納入通知書_コンビニタイプ(仮算定納入通知書情報, ページ数);
        }
    }

    private void print納入通知書_コンビニタイプ(KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報, int ページ数) {
        if (ReportIdDBB.DBB100026.getReportId().equals(帳票ID) && dbb100026NinshoshaSource != null) {
            KarisanteiNonyuTsuchishoCVSMultiReport report = new KarisanteiNonyuTsuchishoCVSMultiReport(
                    仮算定納入通知書情報, dbb100026NinshoshaSource);
            List<NonyuTsuchisho<KarisanteiNonyuTsuchishoCVSMultiSource>> nonyuTsuchishoList = report.devidedByPage();
            for (int idex = 0; idex < nonyuTsuchishoList.size(); idex++) {
                nonyuTsuchishoList.get(idex).writeBy(getReportSourceWriter(idex));
                ページ数 = ページ数 + getReportSourceWriter(idex).pageCount().value();
            }
            総ページ数 = ページ数;
        } else if (ReportIdDBB.DBB100027.getReportId().equals(帳票ID) && dbb100027NinshoshaSource != null) {
            KarisanteiNonyuTsuchishoCVSMultiRenchoReport report = new KarisanteiNonyuTsuchishoCVSMultiRenchoReport(
                    仮算定納入通知書情報, dbb100027NinshoshaSource);
            List<NonyuTsuchisho<KarisanteiNonyuTsuchishoCVSMultiRenchoSource>> nonyuTsuchishoList = report.devidedByPage();
            for (int idex = 0; idex < nonyuTsuchishoList.size(); idex++) {
                nonyuTsuchishoList.get(idex).writeBy(getReportSourceWriter(idex));
                ページ数 = ページ数 + getReportSourceWriter(idex).pageCount().value();
            }
            総ページ数 = ページ数;
        } else if (ReportIdDBB.DBB100024.getReportId().equals(帳票ID) && dbb100024NinshoshaSource != null) {
            KarisanteiNonyuTsuchishoCVSKakukoReport report = new KarisanteiNonyuTsuchishoCVSKakukoReport(
                    仮算定納入通知書情報, dbb100024NinshoshaSource);
            List<NonyuTsuchisho<KarisanteiNonyuTsuchishoCVSKakukoSource>> nonyuTsuchishoList = report.devidedByPage();
            for (int idex = 0; idex < nonyuTsuchishoList.size(); idex++) {
                nonyuTsuchishoList.get(idex).writeBy(getReportSourceWriter(idex));
                ページ数 = ページ数 + getReportSourceWriter(idex).pageCount().value();
            }
            総ページ数 = ページ数;
        } else if (ReportIdDBB.DBB100025.getReportId().equals(帳票ID) && dbb100025NinshoshaSource != null) {
            KarisanteiNonyuTsuchishoCVSKakukoRenchoReport report = new KarisanteiNonyuTsuchishoCVSKakukoRenchoReport(
                    仮算定納入通知書情報, dbb100025NinshoshaSource);
            List<NonyuTsuchisho<KarisanteiNonyuTsuchishoCVSKakukoRenchoSource>> nonyuTsuchishoList = report.devidedByPage();
            for (int idex = 0; idex < nonyuTsuchishoList.size(); idex++) {
                nonyuTsuchishoList.get(idex).writeBy(getReportSourceWriter(idex));
                ページ数 = ページ数 + getReportSourceWriter(idex).pageCount().value();
            }
            総ページ数 = ページ数;
        } else {
            print納入通知書_コンビニ期毎タイプ(仮算定納入通知書情報, ページ数);
        }
    }

    private void print納入通知書_コンビニ期毎タイプ(KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報, int ページ数) {
        if (ReportIdDBB.DBB100028.getReportId().equals(帳票ID) && dbb100028NinshoshaSource != null) {
            KarisanteiNonyuTsuchishoCVSKigotoReport report = new KarisanteiNonyuTsuchishoCVSKigotoReport(
                    仮算定納入通知書情報, dbb100028NinshoshaSource);
            List<NonyuTsuchisho<KarisanteiNonyuTsuchishoCVSKigotoSource>> nonyuTsuchishoList = report.devidedByPage();
            for (int idex = 0; idex < nonyuTsuchishoList.size(); idex++) {
                nonyuTsuchishoList.get(idex).writeBy(getReportSourceWriter(idex));
                ページ数 = ページ数 + getReportSourceWriter(idex).pageCount().value();
            }
            総ページ数 = ページ数;
        } else if (ReportIdDBB.DBB100029.getReportId().equals(帳票ID) && dbb100029NinshoshaSource != null) {
            KarisanteiNonyuTsuchishoCVSMultiRenchoCoverReport report = new KarisanteiNonyuTsuchishoCVSMultiRenchoCoverReport(
                    仮算定納入通知書情報, dbb100029NinshoshaSource);
            List<NonyuTsuchisho<KarisanteiNonyuTsuchishoCVSMultiRenchoCoverSource>> nonyuTsuchishoList = report.devidedByPage();
            for (int idex = 0; idex < nonyuTsuchishoList.size(); idex++) {
                nonyuTsuchishoList.get(idex).writeBy(getReportSourceWriter(idex));
                ページ数 = ページ数 + getReportSourceWriter(idex).pageCount().value();
            }
            総ページ数 = ページ数;
        }
    }

    private List<RString> publish納入通知書発行一覧表(EditedKariSanteiTsuchiShoKyotsu 編集後仮算定通知書共通情報) {
        List<RString> bodyList = new ArrayList<>();
        bodyList.add(processParameter.getシステム日時().getDate().seireki().separator(Separator.SLASH).fillType(FillType.BLANK).toDateString());
        bodyList.add(processParameter.getシステム日時().getRDateTime().getTime().toFormattedTimeString(DisplayTimeFormat.HH_mm_ss));
        表示コード編集(編集後仮算定通知書共通情報.get表示コード１名(), bodyList);
        表示コード編集(編集後仮算定通知書共通情報.get表示コード２名(), bodyList);
        表示コード編集(編集後仮算定通知書共通情報.get表示コード３名(), bodyList);
        bodyList.add(isNull(編集後仮算定通知書共通情報.get通知書番号())
                ? RString.EMPTY : 編集後仮算定通知書共通情報.get通知書番号().getColumnValue());
        bodyList.add(isNull(編集後仮算定通知書共通情報.get被保険者番号())
                ? RString.EMPTY : 編集後仮算定通知書共通情報.get被保険者番号().getColumnValue());
        if (isNull(編集後仮算定通知書共通情報.get編集後個人())) {
            bodyList.add(RString.EMPTY);
        } else {
            bodyList.add(isNull(編集後仮算定通知書共通情報.get編集後個人().get世帯コード())
                    ? RString.EMPTY : 編集後仮算定通知書共通情報.get編集後個人().get世帯コード().getColumnValue());
        }
        表示コード編集(編集後仮算定通知書共通情報.get表示コード1(), bodyList);
        表示コード編集(編集後仮算定通知書共通情報.get表示コード２(), bodyList);
        表示コード編集(編集後仮算定通知書共通情報.get表示コード３(), bodyList);
        if (isNull(編集後仮算定通知書共通情報.get編集後宛先())) {
            bodyList.add(RString.EMPTY);
        } else {
            bodyList.add(編集後仮算定通知書共通情報.get編集後宛先().get行政区名());
        }
        if (isNull(編集後仮算定通知書共通情報.get更正後())) {
            bodyList.add(RString.EMPTY);
        } else {
            bodyList.add(isNull(編集後仮算定通知書共通情報.get更正後().get保険料率())
                    ? RString.EMPTY : new RString(編集後仮算定通知書共通情報.get更正後().get保険料率().toString()));
        }
        set当期(編集後仮算定通知書共通情報, 出力期, bodyList);
        if (isNull(編集後仮算定通知書共通情報.get編集後宛先())
                || isNull(編集後仮算定通知書共通情報.get編集後宛先().get宛先種別())
                || (!AtesakiShubetsu.本人.equals(編集後仮算定通知書共通情報.get編集後宛先().get宛先種別()))) {
            bodyList.add(RString.EMPTY);
        } else {
            bodyList.add(編集後仮算定通知書共通情報.get編集後宛先().get宛先名称().getName().value());

        }
        if (isNull(編集後仮算定通知書共通情報.get更正後())) {
            bodyList.add(RString.EMPTY);
        } else {
            bodyList.add(編集後仮算定通知書共通情報.get更正後().get生保開始日_西暦());
        }
        if (isNull(編集後仮算定通知書共通情報.get更正後())
                || RString.isNullOrEmpty(編集後仮算定通知書共通情報.get更正後().get生活保護扶助種類())) {
            bodyList.add(RString.EMPTY);
        } else {
            RString 生活保護扶助名称 = CodeMaster.getCodeMeisho(SubGyomuCode.URZ業務共通_共通系,
                    URZCodeShubetsu.扶助種類コード.getCodeShubetsu(),
                    new Code(編集後仮算定通知書共通情報.get更正後().get生活保護扶助種類()));
            bodyList.add(生活保護扶助名称);
        }

        if (isNull(編集後仮算定通知書共通情報.get編集後宛先())) {
            bodyList.add(RString.EMPTY);
            bodyList.add(RString.EMPTY);
            bodyList.add(RString.EMPTY);
            bodyList.add(RString.EMPTY);
            bodyList.add(RString.EMPTY);
        } else {
            bodyList.add(isNull(編集後仮算定通知書共通情報.get編集後宛先().get本人名称())
                    ? RString.EMPTY : 編集後仮算定通知書共通情報.get編集後宛先().get本人名称().getName().value());
            bodyList.add(編集後仮算定通知書共通情報.get編集後宛先().get郵便番号());
            bodyList.add(編集後仮算定通知書共通情報.get編集後宛先().get編集後住所());
            bodyList.add(編集後仮算定通知書共通情報.get編集後宛先().get町域());
            bodyList.add(編集後仮算定通知書共通情報.get編集後宛先().get番地());
        }
        if (isNull(編集後仮算定通知書共通情報.get更正後())) {
            bodyList.add(RString.EMPTY);
        } else {
            bodyList.add(編集後仮算定通知書共通情報.get更正後().get保険料段階());
        }
        bodyList.add(isNull(編集後仮算定通知書共通情報.get今後納付すべき額())
                ? RString.EMPTY : new RString(編集後仮算定通知書共通情報.get今後納付すべき額().toString()));
        set次期以降(編集後仮算定通知書共通情報, 出力期, bodyList);
        bodyList.add(get口座情報(編集後仮算定通知書共通情報));
        return bodyList;
    }

    private RString get帳票タイプ() {
        RString 帳票タイプ = RString.EMPTY;
        if (ReportIdDBB.DBB100014.getReportId().equals(帳票ID) || ReportIdDBB.DBB100015.getReportId().equals(帳票ID)
                || ReportIdDBB.DBB100028.getReportId().equals(帳票ID) || ReportIdDBB.DBB100029.getReportId().equals(帳票ID)) {
            帳票タイプ = 帳票タイプ_期毎タイプ;
        } else if (ReportIdDBB.DBB100018.getReportId().equals(帳票ID) || ReportIdDBB.DBB100019.getReportId().equals(帳票ID)) {
            帳票タイプ = 帳票タイプ_銀振タイプ;
        } else if (ReportIdDBB.DBB100021.getReportId().equals(帳票ID) || ReportIdDBB.DBB100023.getReportId().equals(帳票ID)
                || ReportIdDBB.DBB100020.getReportId().equals(帳票ID) || ReportIdDBB.DBB100022.getReportId().equals(帳票ID)) {
            帳票タイプ = 帳票タイプ_ブックタイプ;
        } else if (ReportIdDBB.DBB100026.getReportId().equals(帳票ID) || ReportIdDBB.DBB100027.getReportId().equals(帳票ID)
                || ReportIdDBB.DBB100024.getReportId().equals(帳票ID) || ReportIdDBB.DBB100025.getReportId().equals(帳票ID)) {
            帳票タイプ = 帳票タイプ_コンビニタイプ;
        }
        return 帳票タイプ;
    }

    private List<Kitsuki> get出力期リスト(int 出力期) {
        List<Kitsuki> 出力期リスト = new ArrayList<>();
        KitsukiList 期月リスト = new FuchoKiUtil().get期月リスト().filtered仮算定期間();
        for (Kitsuki 期月 : 期月リスト.toList()) {
            if (出力期 == 期月.get期AsInt()) {
                出力期リスト.add(期月);
                break;
            }
        }
        return 出力期リスト;
    }

    private TsuchishoKyotsuEntity get通知書共通情報(FlexibleYear 調定年度) {
        TsuchishoKyotsuEntity 通知書共通情報entity = new TsuchishoKyotsuEntity();
        KitsukiList 普徴仮算定期間 = 期月リスト_普徴.filtered仮算定期間();
        FukaNokiResearcher fukaNokiResearcher = new FukaNokiResearcher(new RYear(調定年度.toDateString()));
        List<Noki> 普徴納期リスト = fukaNokiResearcher.get普徴納期ALL();
        List<NokiJoho> 期月情報リスト = new ArrayList<>();
        for (Kitsuki 期月 : 普徴仮算定期間.toList()) {
            for (Noki 普徴納期 : 普徴納期リスト) {
                NokiJoho 期月情報 = new NokiJoho();
                if (期月.get期AsInt() == 普徴納期.get期別()) {
                    期月情報.set期月(期月);
                    期月情報.set納期(普徴納期);
                    期月情報リスト.add(期月情報);
                }
            }
        }
        TokuchoKiUtil 月期対応取得_特徴 = new TokuchoKiUtil();
        List<NokiJoho> 特徴期月情報リスト = new ArrayList<>();
        for (int i = 特徴納期_1期; i <= 特徴納期_3期; i++) {
            NokiJoho 特徴期月情報 = new NokiJoho();
            Kitsuki 期月情報 = 月期対応取得_特徴.get期月リスト().get期の最初月(i);
            特徴期月情報.set期月(期月情報);
            Noki 賦課納期 = fukaNokiResearcher.get特徴納期(i);
            特徴期月情報.set納期(賦課納期);
            特徴期月情報リスト.add(特徴期月情報);
        }
        重複な期情報を削除(期月情報リスト);
        通知書共通情報entity.set普徴納期情報リスト(期月情報リスト);
        通知書共通情報entity.set特徴納期情報リスト(特徴期月情報リスト);
        return 通知書共通情報entity;
    }

    private RString 出力順文字列を取得(RString 出力順, RString 生活保護者先頭出力フラグ) {
        if (!RString.isNullOrEmpty(出力順)) {
            List<RString> 出力順Arr = 出力順.split(RString.HALF_SPACE.toString());
            if (生活保護者先頭出力フラグ_する.equals(生活保護者先頭出力フラグ)) {
                出力順Arr.add(INDEX_2, EUC_WRITER_ENCLOSURE.concat(生活保護区分).concat(EUC_WRITER_ENCLOSURE));
                出力順Arr.add(INDEX_3, 降順);
                出力順Arr.add(INDEX_4, EUC_WRITER_ENCLOSURE.concat(口座区分).concat(EUC_WRITER_ENCLOSURE));
                出力順Arr.add(INDEX_5, 昇順);
            } else if (生活保護者先頭出力フラグ_しない.equals(生活保護者先頭出力フラグ)) {
                出力順Arr.add(INDEX_2, EUC_WRITER_ENCLOSURE.concat(口座区分).concat(EUC_WRITER_ENCLOSURE));
                出力順Arr.add(INDEX_3, 昇順);
            }
            RStringBuilder 出力順_文字列 = new RStringBuilder(RString.EMPTY);
            for (Object 出力順Obj1 : 出力順Arr.toArray()) {
                出力順_文字列.append(出力順Obj1).append(RString.HALF_SPACE);
            }
            return 出力順_文字列.toRString();
        }
        return RString.EMPTY;
    }

    private void 重複な期情報を削除(List<NokiJoho> 期月情報リスト) {
        for (NokiJoho 期月情報 : 期月情報リスト) {
            switch (期月情報.get期月().get月AsInt()) {
                case 月_4:
                    重複な期情報を削除共通(nowDate, 期月情報リスト, 期月情報, ConfigNameDBB.普徴期情報_納付書の印字位置1);
                    break;
                case 月_5:
                    重複な期情報を削除共通(nowDate, 期月情報リスト, 期月情報, ConfigNameDBB.普徴期情報_納付書の印字位置2);
                    break;
                case 月_6:
                    重複な期情報を削除共通(nowDate, 期月情報リスト, 期月情報, ConfigNameDBB.普徴期情報_納付書の印字位置3);
                    break;
                case 月_7:
                    重複な期情報を削除共通(nowDate, 期月情報リスト, 期月情報, ConfigNameDBB.普徴期情報_納付書の印字位置4);
                    break;
                case 月_8:
                    重複な期情報を削除共通(nowDate, 期月情報リスト, 期月情報, ConfigNameDBB.普徴期情報_納付書の印字位置5);
                    break;
                case 月_9:
                    重複な期情報を削除共通(nowDate, 期月情報リスト, 期月情報, ConfigNameDBB.普徴期情報_納付書の印字位置6);
                    break;
                case 月_10:
                    重複な期情報を削除共通(nowDate, 期月情報リスト, 期月情報, ConfigNameDBB.普徴期情報_納付書の印字位置7);
                    break;
                case 月_11:
                    重複な期情報を削除共通(nowDate, 期月情報リスト, 期月情報, ConfigNameDBB.普徴期情報_納付書の印字位置8);
                    break;
                case 月_12:
                    重複な期情報を削除共通(nowDate, 期月情報リスト, 期月情報, ConfigNameDBB.普徴期情報_納付書の印字位置9);
                    break;
                case 月_1:
                    重複な期情報を削除共通(nowDate, 期月情報リスト, 期月情報, ConfigNameDBB.普徴期情報_納付書の印字位置10);
                    break;
                case 月_2:
                    重複な期情報を削除共通(nowDate, 期月情報リスト, 期月情報, ConfigNameDBB.普徴期情報_納付書の印字位置11);
                    break;
                case 月_3:
                    重複な期情報を削除共通(nowDate, 期月情報リスト, 期月情報, ConfigNameDBB.普徴期情報_納付書の印字位置12);
                    break;
                case 月_14:
                    重複な期情報を削除共通(nowDate, 期月情報リスト, 期月情報, ConfigNameDBB.普徴期情報_納付書の印字位置13);
                    break;
                case 月_15:
                    重複な期情報を削除共通(nowDate, 期月情報リスト, 期月情報, ConfigNameDBB.普徴期情報_納付書の印字位置14);
                    break;
                default:
                    break;
            }
        }
    }

    private void 重複な期情報を削除共通(RDate nowDate, List<NokiJoho> 期月情報リスト, NokiJoho 期月情報,
            ConfigNameDBB 印字位置) {
        if (重複な期情報.equals(DbBusinessConfig.get(印字位置, nowDate, SubGyomuCode.DBB介護賦課))) {
            期月情報リスト.remove(期月情報);
        }
    }

    private int 今回出力期の印字位置を取得と山分け用スプール数の算出(final Kitsuki 期月, int 出力期リストのサイズ) {
        RString 今回出力期の印字位置 = null;
        switch (期月.get月AsInt()) {
            case 月_4:
                今回出力期の印字位置 = DbBusinessConfig.get(
                        ConfigNameDBB.普徴期情報_ブック開始位置1, nowDate, SubGyomuCode.DBB介護賦課);
                break;
            case 月_5:
                今回出力期の印字位置 = DbBusinessConfig.get(
                        ConfigNameDBB.普徴期情報_ブック開始位置2, nowDate, SubGyomuCode.DBB介護賦課);
                break;
            case 月_6:
                今回出力期の印字位置 = DbBusinessConfig.get(
                        ConfigNameDBB.普徴期情報_ブック開始位置3, nowDate, SubGyomuCode.DBB介護賦課);
                break;
            case 月_7:
                今回出力期の印字位置 = DbBusinessConfig.get(
                        ConfigNameDBB.普徴期情報_ブック開始位置4, nowDate, SubGyomuCode.DBB介護賦課);
                break;
            case 月_8:
                今回出力期の印字位置 = DbBusinessConfig.get(
                        ConfigNameDBB.普徴期情報_ブック開始位置5, nowDate, SubGyomuCode.DBB介護賦課);
                break;
            case 月_9:
                今回出力期の印字位置 = DbBusinessConfig.get(
                        ConfigNameDBB.普徴期情報_ブック開始位置6, nowDate, SubGyomuCode.DBB介護賦課);
                break;
            case 月_10:
                今回出力期の印字位置 = DbBusinessConfig.get(
                        ConfigNameDBB.普徴期情報_ブック開始位置7, nowDate, SubGyomuCode.DBB介護賦課);
                break;
            case 月_11:
                今回出力期の印字位置 = DbBusinessConfig.get(
                        ConfigNameDBB.普徴期情報_ブック開始位置8, nowDate, SubGyomuCode.DBB介護賦課);
                break;
            case 月_12:
                今回出力期の印字位置 = DbBusinessConfig.get(
                        ConfigNameDBB.普徴期情報_ブック開始位置9, nowDate, SubGyomuCode.DBB介護賦課);
                break;
            case 月_1:
                今回出力期の印字位置 = DbBusinessConfig.get(
                        ConfigNameDBB.普徴期情報_ブック開始位置10, nowDate, SubGyomuCode.DBB介護賦課);
                break;
            case 月_2:
                今回出力期の印字位置 = DbBusinessConfig.get(
                        ConfigNameDBB.普徴期情報_ブック開始位置11, nowDate, SubGyomuCode.DBB介護賦課);
                break;
            case 月_3:
                今回出力期の印字位置 = DbBusinessConfig.get(
                        ConfigNameDBB.普徴期情報_ブック開始位置12, nowDate, SubGyomuCode.DBB介護賦課);
                break;
            case 月_14:
                今回出力期の印字位置 = DbBusinessConfig.get(
                        ConfigNameDBB.普徴期情報_ブック開始位置13, nowDate, SubGyomuCode.DBB介護賦課);
                break;
            case 月_15:
                今回出力期の印字位置 = DbBusinessConfig.get(
                        ConfigNameDBB.普徴期情報_ブック開始位置14, nowDate, SubGyomuCode.DBB介護賦課);
                break;
            default:
                break;
        }
        return 山分け用スプール数を算出(今回出力期の印字位置, 出力期リストのサイズ);
    }

    private int 山分け用スプール数を算出(RString 今回出力期の印字位置, int 出力期リストのサイズ) {
        int スプール数 = 0;
        if (ブック開始位置_1.equals(今回出力期の印字位置)) {
            スプール数 = ブック開始位置1山分け用スプール数算出(出力期リストのサイズ, スプール数);
        } else if (ブック開始位置_2.equals(今回出力期の印字位置)) {
            スプール数 = ブック開始位置2山分け用スプール数算出(出力期リストのサイズ, スプール数);
        } else if (ブック開始位置_3.equals(今回出力期の印字位置)) {
            スプール数 = ブック開始位置3山分け用スプール数算出(出力期リストのサイズ, スプール数);
        } else if (ブック開始位置_4.equals(今回出力期の印字位置)) {
            スプール数 = ブック開始位置4山分け用スプール数算出(出力期リストのサイズ, スプール数);
        } else if (ブック開始位置_5.equals(今回出力期の印字位置)) {
            スプール数 = ブック開始位置5山分け用スプール数算出(出力期リストのサイズ, スプール数);
        }
        return スプール数;
    }

    private int ブック開始位置5山分け用スプール数算出(int 出力期リストのサイズ, int 山分け用スプール数) {
        if (出力期リストのサイズ_1 == 出力期リストのサイズ) {
            山分け用スプール数 = 山分け用スプール数_2;
        } else if (出力期リストのサイズ_2 <= 出力期リストのサイズ && 出力期リストのサイズ <= 出力期リストのサイズ_5) {
            山分け用スプール数 = 山分け用スプール数_3;
        } else if (出力期リストのサイズ_6 <= 出力期リストのサイズ && 出力期リストのサイズ <= 出力期リストのサイズ_9) {
            山分け用スプール数 = 山分け用スプール数_4;
        } else if (出力期リストのサイズ_10 <= 出力期リストのサイズ) {
            山分け用スプール数 = 山分け用スプール数_5;
        }
        return 山分け用スプール数;
    }

    private int ブック開始位置4山分け用スプール数算出(int 出力期リストのサイズ, int 山分け用スプール数) {
        if (出力期リストのサイズ_1 <= 出力期リストのサイズ && 出力期リストのサイズ <= 出力期リストのサイズ_2) {
            山分け用スプール数 = 山分け用スプール数_2;
        } else if (出力期リストのサイズ_3 <= 出力期リストのサイズ && 出力期リストのサイズ <= 出力期リストのサイズ_6) {
            山分け用スプール数 = 山分け用スプール数_3;
        } else if (出力期リストのサイズ_7 <= 出力期リストのサイズ) {
            山分け用スプール数 = 山分け用スプール数_4;
        }
        return 山分け用スプール数;
    }

    private int ブック開始位置3山分け用スプール数算出(int 出力期リストのサイズ, int 山分け用スプール数) {
        if (出力期リストのサイズ_1 <= 出力期リストのサイズ && 出力期リストのサイズ <= 出力期リストのサイズ_3) {
            山分け用スプール数 = 山分け用スプール数_2;
        } else if (出力期リストのサイズ_4 <= 出力期リストのサイズ && 出力期リストのサイズ <= 出力期リストのサイズ_7) {
            山分け用スプール数 = 山分け用スプール数_3;
        } else if (出力期リストのサイズ_8 <= 出力期リストのサイズ) {
            山分け用スプール数 = 山分け用スプール数_4;
        }
        return 山分け用スプール数;
    }

    private int ブック開始位置2山分け用スプール数算出(int 出力期リストのサイズ, int 山分け用スプール数) {
        if (出力期リストのサイズ_1 <= 出力期リストのサイズ && 出力期リストのサイズ <= 出力期リストのサイズ_4) {
            山分け用スプール数 = 山分け用スプール数_2;
        } else if (出力期リストのサイズ_5 <= 出力期リストのサイズ && 出力期リストのサイズ <= 出力期リストのサイズ_8) {
            山分け用スプール数 = 山分け用スプール数_3;
        } else if (出力期リストのサイズ_9 <= 出力期リストのサイズ) {
            山分け用スプール数 = 山分け用スプール数_4;
        }
        return 山分け用スプール数;
    }

    private int ブック開始位置1山分け用スプール数算出(int 出力期リストのサイズ, int 山分け用スプール数) {
        if (出力期リストのサイズ_1 <= 出力期リストのサイズ && 出力期リストのサイズ <= 出力期リストのサイズ_5) {
            山分け用スプール数 = 山分け用スプール数_2;
        } else if (出力期リストのサイズ_6 <= 出力期リストのサイズ && 出力期リストのサイズ <= 出力期リストのサイズ_9) {
            山分け用スプール数 = 山分け用スプール数_3;
        } else if (出力期リストのサイズ_10 <= 出力期リストのサイズ) {
            山分け用スプール数 = 山分け用スプール数_4;
        }
        return 山分け用スプール数;
    }

    private int コンビニカット印字位置を取得と山分け用スプール数の算出(final Kitsuki 期月) {
        RString コンビニカット印字位置 = RString.EMPTY;
        switch (期月.get月AsInt()) {
            case 月_4:
                コンビニカット印字位置 = DbBusinessConfig.get(
                        ConfigNameDBB.普徴期情報_コンビニカット印字位置1, nowDate, SubGyomuCode.DBB介護賦課);
                break;
            case 月_5:
                コンビニカット印字位置 = DbBusinessConfig.get(
                        ConfigNameDBB.普徴期情報_コンビニカット印字位置2, nowDate, SubGyomuCode.DBB介護賦課);
                break;
            case 月_6:
                コンビニカット印字位置 = DbBusinessConfig.get(
                        ConfigNameDBB.普徴期情報_コンビニカット印字位置3, nowDate, SubGyomuCode.DBB介護賦課);
                break;
            case 月_7:
                コンビニカット印字位置 = DbBusinessConfig.get(
                        ConfigNameDBB.普徴期情報_コンビニカット印字位置4, nowDate, SubGyomuCode.DBB介護賦課);
                break;
            case 月_8:
                コンビニカット印字位置 = DbBusinessConfig.get(
                        ConfigNameDBB.普徴期情報_コンビニカット印字位置5, nowDate, SubGyomuCode.DBB介護賦課);
                break;
            case 月_9:
                コンビニカット印字位置 = DbBusinessConfig.get(
                        ConfigNameDBB.普徴期情報_コンビニカット印字位置6, nowDate, SubGyomuCode.DBB介護賦課);
                break;
            case 月_10:
                コンビニカット印字位置 = DbBusinessConfig.get(
                        ConfigNameDBB.普徴期情報_コンビニカット印字位置7, nowDate, SubGyomuCode.DBB介護賦課);
                break;
            case 月_11:
                コンビニカット印字位置 = DbBusinessConfig.get(
                        ConfigNameDBB.普徴期情報_コンビニカット印字位置8, nowDate, SubGyomuCode.DBB介護賦課);
                break;
            case 月_12:
                コンビニカット印字位置 = DbBusinessConfig.get(
                        ConfigNameDBB.普徴期情報_コンビニカット印字位置9, nowDate, SubGyomuCode.DBB介護賦課);
                break;
            case 月_1:
                コンビニカット印字位置 = DbBusinessConfig.get(
                        ConfigNameDBB.普徴期情報_コンビニカット印字位置10, nowDate, SubGyomuCode.DBB介護賦課);
                break;
            case 月_2:
                コンビニカット印字位置 = DbBusinessConfig.get(
                        ConfigNameDBB.普徴期情報_コンビニカット印字位置11, nowDate, SubGyomuCode.DBB介護賦課);
                break;
            case 月_3:
                コンビニカット印字位置 = DbBusinessConfig.get(
                        ConfigNameDBB.普徴期情報_コンビニカット印字位置12, nowDate, SubGyomuCode.DBB介護賦課);
                break;
            case 月_14:
                コンビニカット印字位置 = DbBusinessConfig.get(
                        ConfigNameDBB.普徴期情報_コンビニカット印字位置13, nowDate, SubGyomuCode.DBB介護賦課);
                break;
            case 月_15:
                コンビニカット印字位置 = DbBusinessConfig.get(
                        ConfigNameDBB.普徴期情報_コンビニカット印字位置14, nowDate, SubGyomuCode.DBB介護賦課);
                break;
            default:
                break;
        }
        int 印字位置 = Integer.parseInt(コンビニカット印字位置.toString());
        return コンビニタイプ_山分け用スプール数算出(印字位置);
    }

    private int コンビニタイプ_山分け用スプール数算出(int 印字位置) {
        int スプール数 = 0;
        if (出力期リストのサイズ_8 <= 印字位置) {
            スプール数 = 山分け用スプール数_4;
        } else if (出力期リストのサイズ_5 <= 印字位置 && 印字位置 <= 出力期リストのサイズ_7) {
            スプール数 = 山分け用スプール数_3;
        } else if (出力期リストのサイズ_2 <= 印字位置 && 印字位置 <= 出力期リストのサイズ_4) {
            スプール数 = 山分け用スプール数_2;
        } else if (印字位置 == 出力期リストのサイズ_1) {
            スプール数 = 山分け用スプール数_1;
        }
        return スプール数;
    }

    private FukaJoho get賦課情報(DbT2015KeisangoJohoEntity 計算後情報, Long shunoId) {
        FukaJohoRelateEntity fukaJohoRelateEntity = new FukaJohoRelateEntity();
        DbT2002FukaEntity 賦課Entity = new DbT2002FukaEntity();
        賦課Entity.setChoteiNendo(計算後情報.getChoteiNendo());
        賦課Entity.setFukaNendo(計算後情報.getFukaNendo());
        賦課Entity.setTsuchishoNo(計算後情報.getTsuchishoNo());
        賦課Entity.setRirekiNo(計算後情報.getFukaRirekiNo());
        賦課Entity.setHihokenshaNo(計算後情報.getHihokenshaNo());
        賦課Entity.setShikibetsuCode(計算後情報.getShikibetsuCode());
        賦課Entity.setSetaiCode(計算後情報.getSetaiCode());
        賦課Entity.setSetaiInsu(計算後情報.getSetaiInsu());
        賦課Entity.setShikakuShutokuYMD(計算後情報.getShikakuShutokuYMD());
        賦課Entity.setShikakuShutokuJiyu(計算後情報.getShikakuShutokuJiyu());
        賦課Entity.setShikakuSoshitsuYMD(計算後情報.getShikakuSoshitsuYMD());
        賦課Entity.setShikakuSoshitsuJiyu(計算後情報.getShikakuSoshitsuJiyu());
        賦課Entity.setSeihofujoShurui(計算後情報.getSeihofujoShurui());
        賦課Entity.setSeihoKaishiYMD(計算後情報.getSeihoKaishiYMD());
        賦課Entity.setSeihoHaishiYMD(計算後情報.getSeihoHaishiYMD());
        賦課Entity.setRonenKaishiYMD(計算後情報.getRonenKaishiYMD());
        賦課Entity.setRonenHaishiYMD(計算後情報.getRonenHaishiYMD());
        賦課Entity.setFukaYMD(計算後情報.getFukaYMD());
        賦課Entity.setKazeiKubun(計算後情報.getKazeiKubun());
        賦課Entity.setSetaikazeiKubun(計算後情報.getSetaikazeiKubun());
        賦課Entity.setGokeiShotokuGaku(計算後情報.getGokeiShotokuGaku());
        賦課Entity.setNenkinShunyuGaku(計算後情報.getNenkinShunyuGaku());
        賦課Entity.setHokenryoDankai(計算後情報.getHokenryoDankai());
        賦課Entity.setHokenryoDankai1(計算後情報.getHokenryoDankai1());
        賦課Entity.setNengakuHokenryo1(計算後情報.getNengakuHokenryo1());
        賦課Entity.setTsukiwariStartYM1(計算後情報.getTsukiwariStartYM1());
        賦課Entity.setTsukiwariEndYM1(計算後情報.getTsukiwariEndYM1());
        賦課Entity.setHokenryoDankai2(計算後情報.getHokenryoDankai2());
        賦課Entity.setNengakuHokenryo2(計算後情報.getNengakuHokenryo2());
        賦課Entity.setTsukiwariStartYM2(計算後情報.getTsukiwariStartYM2());
        賦課Entity.setTsukiwariEndYM2(計算後情報.getTsukiwariEndYM2());
        賦課Entity.setChoteiNichiji(計算後情報.getChoteiNichiji());
        賦課Entity.setChoteiJiyu1(計算後情報.getChoteiJiyu1());
        賦課Entity.setChoteiJiyu2(計算後情報.getChoteiJiyu2());
        賦課Entity.setChoteiJiyu3(計算後情報.getChoteiJiyu3());
        賦課Entity.setChoteiJiyu4(計算後情報.getChoteiJiyu4());
        賦課Entity.setKoseiM(計算後情報.getKoseiM());
        賦課Entity.setGemmenMaeHokenryo(計算後情報.getGemmenMaeHokenryo());
        賦課Entity.setGemmenGaku(計算後情報.getGemmenGaku());
        賦課Entity.setKakuteiHokenryo(計算後情報.getKakuteiHokenryo());
        賦課Entity.setHokenryoDankaiKarisanntei(計算後情報.getHokenryoDankaiKarisanntei());
        賦課Entity.setChoshuHohoRirekiNo(計算後情報.getChoshuHohoRirekiNo());
        賦課Entity.setIdoKijunNichiji(計算後情報.getIdoKijunNichiji());
        賦課Entity.setKozaKubun(計算後情報.getKozaKubun());
        賦課Entity.setKyokaisoKubun(計算後情報.getKyokaisoKubun());
        賦課Entity.setShokkenKubun(計算後情報.getShokkenKubun());
        賦課Entity.setFukaShichosonCode(計算後情報.getFukaShichosonCode());
        賦課Entity.setTkSaishutsuKampuGaku(計算後情報.getTkSaishutsuKampuGaku());
        賦課Entity.setFuSaishutsuKampuGaku(計算後情報.getFuSaishutsuKampuGaku());

        fukaJohoRelateEntity.set介護賦課Entity(賦課Entity);
        List<KibetsuEntity> 期別リスト = new ArrayList<>();
        for (int index = INDEX_1; index <= INDEX_6; index++) {
            KibetsuEntity 介護期別Relate = new KibetsuEntity();
            DbT2003KibetsuEntity 介護期別Entity = new DbT2003KibetsuEntity();
            介護期別Entity.setChoteiNendo(計算後情報.getChoteiNendo());
            介護期別Entity.setFukaNendo(計算後情報.getFukaNendo());
            介護期別Entity.setTsuchishoNo(計算後情報.getTsuchishoNo());
            介護期別Entity.setRirekiNo(計算後情報.getFukaRirekiNo());
            介護期別Entity.setChoteiId(new Decimal(index));
            介護期別Entity.setChoshuHouhou(ChoshuHohoKibetsu.特別徴収.getコード());
            介護期別Entity.setKi(index);
            List<UrT0705ChoteiKyotsuEntity> 調定共通EntityList = new ArrayList<>();
            UrT0705ChoteiKyotsuEntity 調定共通Entity = new UrT0705ChoteiKyotsuEntity();
            調定共通Entity.setChoteiId(new Decimal(index).longValue());
            調定共通Entity.setChoteigaku(get特徴調定額(計算後情報, index));
            調定共通Entity.setShunoId(shunoId);
            調定共通EntityList.add(調定共通Entity);
            介護期別Relate.set介護期別Entity(介護期別Entity);
            介護期別Relate.set調定共通Entity(調定共通EntityList);
            期別リスト.add(介護期別Relate);
        }
        for (int index = INDEX_1; index <= INDEX_14; index++) {
            KibetsuEntity 介護期別Relate = new KibetsuEntity();
            DbT2003KibetsuEntity 介護期別Entity = new DbT2003KibetsuEntity();
            介護期別Entity.setChoteiNendo(計算後情報.getChoteiNendo());
            介護期別Entity.setFukaNendo(計算後情報.getFukaNendo());
            介護期別Entity.setTsuchishoNo(計算後情報.getTsuchishoNo());
            介護期別Entity.setRirekiNo(計算後情報.getFukaRirekiNo());
            介護期別Entity.setChoteiId(new Decimal(index).add(Decimal.TEN));
            介護期別Entity.setChoshuHouhou(ChoshuHohoKibetsu.普通徴収.getコード());
            介護期別Entity.setKi(index);
            List<UrT0705ChoteiKyotsuEntity> 調定共通EntityList = new ArrayList<>();
            UrT0705ChoteiKyotsuEntity 調定共通Entity = new UrT0705ChoteiKyotsuEntity();
            調定共通Entity.setChoteiId(new Decimal(index).add(Decimal.TEN).longValue());
            調定共通Entity.setShunoId(shunoId);
            調定共通Entity.setChoteigaku(get普通調定額(計算後情報, index));
            調定共通EntityList.add(調定共通Entity);
            介護期別Relate.set介護期別Entity(介護期別Entity);
            介護期別Relate.set調定共通Entity(調定共通EntityList);
            期別リスト.add(介護期別Relate);
        }
        fukaJohoRelateEntity.set介護期別RelateEntity(期別リスト);
        return new FukaJoho(fukaJohoRelateEntity);
    }

    private Decimal get特徴調定額(DbT2015KeisangoJohoEntity entity, int index) {
        Decimal 特徴調定額 = Decimal.ZERO;
        if (entity == null) {
            return null;
        }
        RStringBuilder sb = new RStringBuilder(定数_特徴方法.toString());
        sb.append(new RString(index).padZeroToLeft(2));
        Class clazz = entity.getClass();
        try {
            Method getMethod = clazz.getDeclaredMethod(sb.toString());
            特徴調定額 = (Decimal) getMethod.invoke(entity);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException ex) {
            Logger.getLogger(PrtNonyuTsuchishoHakkoProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 特徴調定額;
    }

    private Decimal get普通調定額(DbT2015KeisangoJohoEntity entity, int index) {
        Decimal 普通調定額 = Decimal.ZERO;
        if (entity == null) {
            return null;
        }
        RStringBuilder sb = new RStringBuilder(定数_普徴方法.toString());
        sb.append(new RString(index).padZeroToLeft(2));
        Class clazz = entity.getClass();
        try {
            Method getMethod = clazz.getDeclaredMethod(sb.toString());
            普通調定額 = (Decimal) getMethod.invoke(entity);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException ex) {
            Logger.getLogger(HonsanteiTsuchishoIkkatsuHakkoFath.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 普通調定額;
    }

    private ChoshuHoho get徴収方法情報(DbT2015KeisangoJohoEntity 計算後情報) {
        DbT2001ChoshuHohoEntity choshuHohoEntity = new DbT2001ChoshuHohoEntity();
        choshuHohoEntity.setFukaNendo(計算後情報.getFukaNendo());
        choshuHohoEntity.setHihokenshaNo(計算後情報.getHihokenshaNo());
        choshuHohoEntity.setRirekiNo(計算後情報.getFukaRirekiNo());
        choshuHohoEntity.setChoshuHoho4gatsu(計算後情報.getChoshuHoho4gatsu());
        choshuHohoEntity.setChoshuHoho5gatsu(計算後情報.getChoshuHoho5gatsu());
        choshuHohoEntity.setChoshuHoho6gatsu(計算後情報.getChoshuHoho6gatsu());
        choshuHohoEntity.setChoshuHoho7gatsu(計算後情報.getChoshuHoho7gatsu());
        choshuHohoEntity.setChoshuHoho8gatsu(計算後情報.getChoshuHoho8gatsu());
        choshuHohoEntity.setChoshuHoho9gatsu(計算後情報.getChoshuHoho9gatsu());
        choshuHohoEntity.setChoshuHoho10gatsu(計算後情報.getChoshuHoho10gatsu());
        choshuHohoEntity.setChoshuHoho11gatsu(計算後情報.getChoshuHoho11gatsu());
        choshuHohoEntity.setChoshuHoho12gatsu(計算後情報.getChoshuHoho12gatsu());
        choshuHohoEntity.setChoshuHoho1gatsu(計算後情報.getChoshuHoho1gatsu());
        choshuHohoEntity.setChoshuHoho2gatsu(計算後情報.getChoshuHoho2gatsu());
        choshuHohoEntity.setChoshuHoho3gatsu(計算後情報.getChoshuHoho3gatsu());
        choshuHohoEntity.setChoshuHohoYoku4gatsu(計算後情報.getChoshuHohoYoku4gatsu());
        choshuHohoEntity.setChoshuHohoYoku5gatsu(計算後情報.getChoshuHohoYoku5gatsu());
        choshuHohoEntity.setChoshuHohoYoku6gatsu(計算後情報.getChoshuHohoYoku6gatsu());
        choshuHohoEntity.setChoshuHohoYoku7gatsu(計算後情報.getChoshuHohoYoku7gatsu());
        choshuHohoEntity.setChoshuHohoYoku8gatsu(計算後情報.getChoshuHohoYoku8gatsu());
        choshuHohoEntity.setChoshuHohoYoku9gatsu(計算後情報.getChoshuHohoYoku9gatsu());
        choshuHohoEntity.setKariNenkinNo(計算後情報.getKariNenkinNo());
        choshuHohoEntity.setKariNenkinCode(計算後情報.getKariNenkinCode());
        choshuHohoEntity.setKariHosokuM(計算後情報.getKariHosokuM());
        choshuHohoEntity.setHonNenkinNo(計算後情報.getHonNenkinNo());
        choshuHohoEntity.setHonNenkinCode(計算後情報.getHonNenkinCode());
        choshuHohoEntity.setHonHosokuM(計算後情報.getHonHosokuM());
        choshuHohoEntity.setYokunendoKariNenkinNo(計算後情報.getYokunendoKariNenkinNo());
        choshuHohoEntity.setYokunendoKariNenkinCode(計算後情報.getYokunendoKariNenkinCode());
        choshuHohoEntity.setYokunendoKariHosokuM(計算後情報.getYokunendoKariHosokuM());
        choshuHohoEntity.setIraiSohuzumiFlag(計算後情報.getIraiSohuzumiFlag());
        choshuHohoEntity.setTsuikaIraiSohuzumiFlag(計算後情報.getTsuikaIraiSohuzumiFlag());
        choshuHohoEntity.setTokuchoTeishiNichiji(計算後情報.getTokuchoTeishiNichiji());
        choshuHohoEntity.setTokuchoTeishiJiyuCode(計算後情報.getTokuchoTeishiJiyuCode());

        return new ChoshuHoho(choshuHohoEntity);
    }

    private ShunyuJoho get収入情報(DbT2015KeisangoJohoEntity 計算後情報) {
        ShunyuJoho 収入情報 = new ShunyuJoho();
        収入情報.set調定年度(計算後情報.getChoteiNendo());
        収入情報.set賦課年度(計算後情報.getFukaNendo());
        収入情報.set通知書番号(計算後情報.getTsuchishoNo());
        収入情報.set特徴収入額01(計算後情報.getTkShunyuGaku01());
        収入情報.set特徴収入額02(計算後情報.getTkShunyuGaku02());
        収入情報.set特徴収入額03(計算後情報.getTkShunyuGaku03());
        収入情報.set特徴収入額04(計算後情報.getTkShunyuGaku04());
        収入情報.set特徴収入額05(計算後情報.getTkShunyuGaku05());
        収入情報.set特徴収入額06(計算後情報.getTkShunyuGaku06());
        収入情報.set普徴収入額01(計算後情報.getFuShunyuGaku01());
        収入情報.set普徴収入額02(計算後情報.getFuShunyuGaku02());
        収入情報.set普徴収入額03(計算後情報.getFuShunyuGaku03());
        収入情報.set普徴収入額04(計算後情報.getFuShunyuGaku04());
        収入情報.set普徴収入額05(計算後情報.getFuShunyuGaku05());
        収入情報.set普徴収入額06(計算後情報.getFuShunyuGaku06());
        収入情報.set普徴収入額07(計算後情報.getFuShunyuGaku07());
        収入情報.set普徴収入額08(計算後情報.getFuShunyuGaku08());
        収入情報.set普徴収入額09(計算後情報.getFuShunyuGaku09());
        収入情報.set普徴収入額10(計算後情報.getFuShunyuGaku10());
        収入情報.set普徴収入額11(計算後情報.getFuShunyuGaku11());
        収入情報.set普徴収入額12(計算後情報.getFuShunyuGaku12());
        収入情報.set普徴収入額13(計算後情報.getFuShunyuGaku13());
        収入情報.set普徴収入額14(計算後情報.getFuShunyuGaku14());

        return 収入情報;
    }

    private void set当期(EditedKariSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報, int 出力期, List<RString> bodyList) {
        if (isNull(編集後本算定通知書共通情報.get更正後()) || isNull(編集後本算定通知書共通情報.get更正後().get更正後普徴期別金額リスト())
                || 編集後本算定通知書共通情報.get更正後().get更正後普徴期別金額リスト().isEmpty()) {
            bodyList.add(RString.EMPTY);
        } else {
            boolean 区分 = false;
            List<UniversalPhase> 普徴期別金額リスト = 編集後本算定通知書共通情報.get更正後().get更正後普徴期別金額リスト();
            for (UniversalPhase 普徴期別金額 : 普徴期別金額リスト) {
                if (出力期 == 普徴期別金額.get期()) {
                    区分 = true;
                    bodyList.add(isNull(普徴期別金額.get金額()) ? RString.EMPTY
                            : DecimalFormatter.toコンマ区切りRString(普徴期別金額.get金額(), 0));
                    break;
                }
            }
            if (!区分) {
                bodyList.add(RString.EMPTY);
            }
        }
    }

    private void set次期以降(EditedKariSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報, int 出力期, List<RString> bodyList) {
        if (isNull(編集後本算定通知書共通情報.get更正後()) || isNull(編集後本算定通知書共通情報.get更正後().get更正後普徴期別金額リスト())
                || 編集後本算定通知書共通情報.get更正後().get更正後普徴期別金額リスト().isEmpty()) {
            bodyList.add(RString.EMPTY);
        } else {
            boolean 区分 = false;
            List<UniversalPhase> 普徴期別金額リスト = 編集後本算定通知書共通情報.get更正後().get更正後普徴期別金額リスト();
            for (UniversalPhase 普徴期別金額 : 普徴期別金額リスト) {
                if (出力期 == (普徴期別金額.get期() + NUM_1)) {
                    区分 = true;
                    bodyList.add(isNull(普徴期別金額.get金額()) ? RString.EMPTY
                            : DecimalFormatter.toコンマ区切りRString(普徴期別金額.get金額(), 0));
                    break;
                }
            }
            if (!区分) {
                bodyList.add(RString.EMPTY);
            }
        }
    }

    private void 表示コード編集(RString 表示コード, List<RString> bodyList) {
        if (isNull(表示コード)) {
            bodyList.add(RString.EMPTY);
        } else {
            bodyList.add(表示コード);
        }
    }

    private boolean isNull(Object object) {
        return object == null;
    }

    private RString get口座情報(EditedKariSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報) {
        RString 口座情報;
        EditedKoza 編集後口座 = 編集後本算定通知書共通情報.get編集後口座();
        RString 口座種別略称 = 編集後口座.get口座種別略称();
        if (口座種別略称.length() >= NUM_2) {
            口座種別略称 = 口座種別略称.substring(NUM_0, NUM_2);
        }
        RString 口座番号 = 編集後口座.get口座番号Or通帳記号番号();
        if (口座番号.length() >= NUM_7) {
            口座番号 = 口座番号.substring(NUM_0, NUM_7);
        }
        口座情報 = 編集後口座.get金融機関コードCombinedWith支店コード().concat(RString.HALF_SPACE).concat(
                口座種別略称).concat(HYPHEN).concat(口座番号).concat(RString.HALF_SPACE).concat(
                        編集後口座.get口座名義人漢字優先());
        if (ゆうちょ銀行.equals(編集後口座.get金融機関コードCombinedWith支店コード().subSequence(NUM_0, NUM_4))) {
            口座情報 = 編集後口座.get金融機関コードCombinedWith支店コード().concat(RString.HALF_SPACE)
                    .concat(編集後口座.get口座番号Or通帳記号番号()).concat(RString.HALF_SPACE)
                    .concat(編集後口座.get口座名義人漢字優先());
        }
        return 口座情報;
    }

    private void csvファイルヘーダ設定(List<RString> headerList) {
        headerList.add(タイトル_作成日時);
        headerList.add(タイトル_作成時刻);
        headerList.add(タイトル_表示コード名１);
        headerList.add(タイトル_表示コード名２);
        headerList.add(タイトル_表示コード名３);
        headerList.add(タイトル_通知書番号);
        headerList.add(タイトル_被保険者番号);
        headerList.add(タイトル_世帯コード);
        headerList.add(タイトル_表示コード１);
        headerList.add(タイトル_表示コード２);
        headerList.add(タイトル_表示コード３);
        headerList.add(タイトル_行政区);
        headerList.add(タイトル_保険料額);
        headerList.add(タイトル_当期);
        headerList.add(タイトル_納付人_送付先);
        headerList.add(タイトル_生保開始日);
        headerList.add(タイトル_生保種別);
        headerList.add(タイトル_氏名);
        headerList.add(タイトル_郵便番号);
        headerList.add(タイトル_住所);
        headerList.add(タイトル_町域_管内_管外住所);
        headerList.add(タイトル_番地);
        headerList.add(タイトル_所得段階);
        headerList.add(タイトル_仮特別徴収額);
        headerList.add(タイトル_次期以降);
        headerList.add(タイトル_口座情報);
    }

    private void close納入通知書() {
        for (int idex = 0; idex < 山分け用スプール数; idex++) {
            reportWriter.get(String.valueOf(idex)).close();
        }
    }
}
