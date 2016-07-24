/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.honsanteiidokanendofuka;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.business.core.basic.KeisangoJoho;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.choteijiyu.ChoteiJiyuParameter;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.choteijiyu.FukaJohoList;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.fukakeisan.FukaKokyoBatchParameter;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJoho;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJohoBuilder;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.HokenryoDankaiHantei;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.core.TsukibetsuHokenryoDankai;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.fukakonkyo.FukaKonkyoBatchParameter;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.fukakonkyo.FukaKonkyoFactory;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.FukaKonkyo;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.HokenryoDankaiHanteiParameter;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.SeigyoJoho;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.SeigyojohoFactory;
import jp.co.ndensan.reams.db.dbb.business.core.honsanteiidokanendofuka.FukaJohoToChoshuHoho;
import jp.co.ndensan.reams.db.dbb.business.core.kanendokoseikeisan.KoseigoFukaResult;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.HokenryoDankaiList;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.MonthShichoson;
import jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.NengakuHokenryo;
import jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.NengakuHokenryoKeisan;
import jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.param.NengakuFukaKonkyo;
import jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.param.NengakuFukaKonkyoFactory;
import jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.param.NengakuHokenryoKeisanParameter;
import jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.param.NengakuSeigyoJoho;
import jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.param.RankBetsuKijunKingaku;
import jp.co.ndensan.reams.db.dbb.business.report.honsanteikekkaicihiran.HonsanteiKekkaIcihiranProperty.DBB200009ShutsuryokujunEnum;
import jp.co.ndensan.reams.db.dbb.business.report.kanendoidoukekkaichiran.KeisangojohoAtenaKozaKouseizengoEntity;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.ErrorCode;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.HasuChoseiHoho;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.HasuChoseiTaisho;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.KozaKubun;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.honsanteiidokanendofuka.CalculateFukaParameter;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.honsanteiidokanendofuka.KanendoFukaParameter;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.honsanteiidokanendofuka.KeisangojohoToKozaParameter;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2010FukaErrorListEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fuka.SetaiHaakuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajoho.fukajoho.FukaJohoRelateEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.honsanteiidokanendofuka.CalculateFukaEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.honsanteiidokanendofuka.CalculateFukaTmpEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.honsanteiidokanendofuka.HonsanteiShotokuTmpEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.honsanteiidokanendofuka.IdoTmpEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.honsanteiidokanendofuka.KeisangojohoToKozaEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.honsanteiidokanendofuka.ShotokuIdoTmpEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.honsanteiidokanendofuka.TsukibetsuRankuTmpEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kanendoidoukekkaichiran.KeisangojohoAtenaKozaEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2010FukaErrorListDac;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.honsanteiidokanendofuka.IHonSanteiIdoKanendoFukaMapper;
import jp.co.ndensan.reams.db.dbb.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbb.service.core.fuka.SetaiShotokuKazeiHantei;
import jp.co.ndensan.reams.db.dbb.service.core.fuka.choteijiyu.ChoteiJiyuHantei;
import jp.co.ndensan.reams.db.dbb.service.core.fuka.fukakeisan.FukaKeisan;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.HokenryoDankaiSettings;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.HokenryoRank;
import jp.co.ndensan.reams.db.dbb.service.report.kanendoidoukekkaichiran.KanendoIdouKekkaIchiranPrintService;
import jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.FuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KitsukiList;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.KazeiKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.Tsuki;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT2001ChoshuHohoDac;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT2002FukaDac;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT2003KibetsuDac;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbV1001HihokenshaDaichoAliveDac;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbV2001ChoshuHohoAliveDac;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.UrT0705ChoteiKyotsuDac;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.core.basic.RoreiFukushiNenkinJukyusha;
import jp.co.ndensan.reams.db.dbz.business.core.hihokensha.seikatsuhogojukyusha.SeikatsuHogoJukyusha;
import jp.co.ndensan.reams.db.dbz.business.core.kanri.JushoHenshu;
import jp.co.ndensan.reams.db.dbz.business.core.kyokaisogaitosha.kyokaisogaitosha.KyokaisoGaitosha;
import static jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu.CustomerBarcodeShiyoUmu.使用しない;
import static jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu.CustomerBarcodeShiyoUmu.使用する;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.SetaiinHaakuKanriShikibetsuKubun;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7006RoreiFukushiNenkinJukyushaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7065ChohyoSeigyoKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.hihokensha.seikatsuhogojukyusha.SeikatsuHogoJukyushaRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.kyokaisogaitosha.KyokaisoGaitoshaEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1001HihokenshaDaichoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7065ChohyoSeigyoKyotsuDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbV2502KaigoShotokuAliveDac;
import jp.co.ndensan.reams.ua.uax.business.core.idoruiseki.ShikibetsuTaishoIdoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.core.koza.IKoza;
import jp.co.ndensan.reams.ua.uax.business.core.koza.Koza;
import jp.co.ndensan.reams.ua.uax.business.core.koza.KozaSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.definition.core.valueobject.code.KozaYotoKubunCodeValue;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.idoruiseki.ShikibetsuTaishoIdoChushutsuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.idoruiseki.ShikibetsuTaishoIdoSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.IKozaSearchKey;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt001FindIdoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaT0310KozaEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.relate.KozaRelateEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.relate.kinyukikan.KinyuKikanEntity;
import jp.co.ndensan.reams.ua.uax.persistence.db.basic.UaFt001FindIdoFunctionDac;
import jp.co.ndensan.reams.ur.urc.service.core.shunokamoku.authority.ShunoKamokuAuthority;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvListWriter;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 本算定異動（過年度）（バッチ）のビジネスクラスです。
 *
 * @reamsid_L DBB-0910-020 zhujun
 */
public class HonSanteiIdoKanendoFuka {

    private static final int INT_1 = 1;
    private static final int INT_2 = 2;
    private static final int INT_4 = 4;
    private static final Code 用途区分コード = new Code("0");
    private static final RString FROMAT = new RString("%02d");
    private static final RString ゼロ_0000 = new RString("0000");
    private static final RString 合併情報区分_合併あり = new RString("1");
    private static final RString バッチID = new RString("DBBBT45001");
    private static final RString 内部帳票ID = new RString("DBB400001_FukaErrorIchitan");
    private static final RString 空 = RString.EMPTY;
    private static final Code CODE_0 = new Code("0");
    private static final RString 定値_ゼロ = new RString("0");
    private static final RString 定値_イチ = new RString("1");
    private static final RString 定値_二 = new RString("2");
    private static final RString 定値_調定年度 = new RString("調定年度");
    private static final RString 定値_抽出開始日時 = new RString("抽出開始日時（以上）");
    private static final RString 定値_抽出終了日時 = new RString("抽出終了日時（未満）");
    private static final RString 定値_帳票名称 = new RString("帳票名称");
    private static final RString 定値_改頁項目名 = new RString("改頁項目名");
    private static final RString 定値_出力順項目名 = new RString("出力順項目名");
    private static final RString SIGN = new RString(" ＞ ");
    private static final RString CSV出力有無 = new RString("あり");
    private static final RString CSVファイル名 = new RString("KanendoIdouKekkaIchiranData.csv");
    private static final int ゼロ_定値 = 0;
    private static final int イチ_定値 = 1;
    private static final int 二_定値 = 2;
    private static final int ミ_定値 = 3;
    private static final int ヨ_定値 = 4;
    private static final int ゴ_定値 = 5;
    private static final int ロク_定値 = 6;
    private static final int ナナ_定値 = 7;
    private static final int ハチ_定値 = 8;
    private static final int キュウ_定値 = 9;
    private static final int ジュウ_定値 = 10;
    private static final int ジュウイチ_定値 = 11;
    private static final int ジュウ二_定値 = 12;
    private static final int ジュウミ_定値 = 13;
    private static final int ジュウヨ_定値 = 14;
    private static final RString カンマ = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString FORMAT_LEFT = new RString("【");
    private static final RString FORMAT_RIGHT = new RString("】");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBB200027");
    private static final RString EUCファイル名 = new RString("KanendoIdouKekkaIchiran.csv");
    private static final ReportId 帳票ID = ReportIdDBB.DBB200027.getReportId();
    private static final RString 帳票名 = ReportIdDBB.DBB200027.getReportName();
    private static final ReportId 帳票分類ID = new ReportId("DBB200027_KanendoIdouKekkaIchiran");
    private static final RString タイトル_作成年月日 = new RString("作成年月日");
    private static final RString タイトル_作成時刻 = new RString("作成時刻");
    private static final RString タイトル_通知書番号 = new RString("通知書番号");
    private static final RString タイトル_氏名 = new RString("氏名");
    private static final RString タイトル_住所 = new RString("住所");
    private static final RString タイトル_金融機関コード = new RString("金融機関コード");
    private static final RString タイトル_種類 = new RString("種類");
    private static final RString タイトル_口座番号 = new RString("口座番号");
    private static final RString タイトル_調定年度 = new RString("調定年度");
    private static final RString タイトル_賦課年度 = new RString("賦課年度");
    private static final RString タイトル_確定保険料額 = new RString("確定保険料額");
    private static final RString タイトル_計算上保険料額 = new RString("計算上保険料額");
    private static final RString タイトル_減免額 = new RString("減免額");
    private static final RString タイトル_月別取得段階4月 = new RString("月別取得段階4月");
    private static final RString タイトル_月別取得段階5月 = new RString("月別取得段階5月");
    private static final RString タイトル_月別取得段階6月 = new RString("月別取得段階6月");
    private static final RString タイトル_月別取得段階7月 = new RString("月別取得段階7月");
    private static final RString タイトル_月別取得段階8月 = new RString("月別取得段階8月");
    private static final RString タイトル_月別取得段階9月 = new RString("月別取得段階9月");
    private static final RString タイトル_月別取得段階10月 = new RString("月別取得段階10月");
    private static final RString タイトル_月別取得段階11月 = new RString("月別取得段階11月");
    private static final RString タイトル_月別取得段階12月 = new RString("月別取得段階12月");
    private static final RString タイトル_月別取得段階1月 = new RString("月別取得段階1月");
    private static final RString タイトル_月別取得段階2月 = new RString("月別取得段階2月");
    private static final RString タイトル_月別取得段階3月 = new RString("月別取得段階3月");
    private static final RString タイトル_歳出還付額_特 = new RString("歳出還付額（特）");
    private static final RString タイトル_歳出還付額_普 = new RString("歳出還付額（普）");
    private static final RString タイトル_金融機関名称 = new RString("金融機関名称");
    private static final RString タイトル_口座名義人 = new RString("口座名義人");
    private static final RString タイトル_調定年月日 = new RString("調定年月日");
    private static final RString タイトル_特徴額１期 = new RString("特徴額１期");
    private static final RString タイトル_特徴額２期 = new RString("特徴額２期");
    private static final RString タイトル_特徴額３期 = new RString("特徴額３期");
    private static final RString タイトル_特徴額４期 = new RString("特徴額４期");
    private static final RString タイトル_特徴額５期 = new RString("特徴額５期");
    private static final RString タイトル_特徴額６期 = new RString("特徴額６期");
    private static final RString タイトル_普徴額1期 = new RString("普徴額1期");
    private static final RString タイトル_普徴額2期 = new RString("普徴額2期");
    private static final RString タイトル_普徴額3期 = new RString("普徴額3期");
    private static final RString タイトル_普徴額4期 = new RString("普徴額4期");
    private static final RString タイトル_普徴額5期 = new RString("普徴額5期");
    private static final RString タイトル_普徴額6期 = new RString("普徴額6期");
    private static final RString タイトル_普徴額7期 = new RString("普徴額7期");
    private static final RString タイトル_普徴額8期 = new RString("普徴額8期");
    private static final RString タイトル_普徴額9期 = new RString("普徴額9期");
    private static final RString タイトル_普徴額10期 = new RString("普徴額10期");
    private static final RString タイトル_普徴額11期 = new RString("普徴額11期");
    private static final RString タイトル_普徴額12期 = new RString("普徴額12期");
    private static final RString タイトル_普徴額13期 = new RString("普徴額13期");
    private static final RString タイトル_普徴額14期 = new RString("普徴額14期");
    private static final RString タイトル_調定事由 = new RString("調定事由");

    private final MapperProvider mapperProvider;
    private final DbT2010FukaErrorListDac 賦課エラーDac;
    private final DbT2002FukaDac 賦課Dac;
    private final UaFt001FindIdoFunctionDac 宛名識別異動分Dac;
    private final DbT7065ChohyoSeigyoKyotsuDac 帳票制御共通Dac;

    /**
     * コンストラクタです
     */
    public HonSanteiIdoKanendoFuka() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.賦課エラーDac = InstanceProvider.create(DbT2010FukaErrorListDac.class);
        this.賦課Dac = InstanceProvider.create(DbT2002FukaDac.class);
        this.宛名識別異動分Dac = InstanceProvider.create(UaFt001FindIdoFunctionDac.class);
        this.帳票制御共通Dac = InstanceProvider.create(DbT7065ChohyoSeigyoKyotsuDac.class);
    }

    /**
     * コンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 徴収方法NewestDac 徴収方法NewestDac
     * @param 賦課エラーDac DbT2010FukaErrorListDac
     * @param 賦課NewestDac DbV2002FukaAliveDac
     * @param 処理状況Dac DbT7022ShoriDateKanriDac
     */
    HonSanteiIdoKanendoFuka(MapperProvider mapperProvider,
            DbV2001ChoshuHohoAliveDac 徴収方法NewestDac,
            DbT2010FukaErrorListDac 賦課エラーDac,
            DbT7022ShoriDateKanriDac 処理状況Dac,
            DbT2002FukaDac 賦課Dac,
            DbT2003KibetsuDac 期別Dac,
            UrT0705ChoteiKyotsuDac 調定共通Dac,
            UaFt001FindIdoFunctionDac 宛名識別異動分Dac,
            DbT1001HihokenshaDaichoDac 被保険者台帳管理Dac,
            DbV2502KaigoShotokuAliveDac 介護所得Dac,
            DbV1001HihokenshaDaichoAliveDac 被保険者台帳管理NewestDac,
            DbT2001ChoshuHohoDac 徴収方法Dac,
            DbT7065ChohyoSeigyoKyotsuDac 帳票制御共通Dac) {
        this.mapperProvider = mapperProvider;
        this.賦課エラーDac = 賦課エラーDac;
        this.賦課Dac = 賦課Dac;
        this.宛名識別異動分Dac = 宛名識別異動分Dac;
        this.帳票制御共通Dac = 帳票制御共通Dac;
    }

    /**
     * 生成した{@link HonSanteiIdoKanendoFuka}のインスタンスを返します。
     *
     * @return GenNendoHonsanteiIdou
     */
    public static HonSanteiIdoKanendoFuka createInstance() {
        return InstanceProvider.create(HonSanteiIdoKanendoFuka.class);
    }

    /**
     * 賦課根拠異動抽出メソッドです。
     *
     * @param param 入力パラメータ
     */
    public void selectKanendoIdoData(KanendoFukaParameter param) {
        IHonSanteiIdoKanendoFukaMapper mapper = mapperProvider.create(IHonSanteiIdoKanendoFukaMapper.class);
        ShikibetsuTaishoIdoSearchKey searchKey = new ShikibetsuTaishoIdoSearchKeyBuilder(
                ShikibetsuTaishoIdoChushutsuKubun.異動年月日で抽出, param.get抽出開始日時(), param.get抽出終了日時()).build();
        List<UaFt001FindIdoEntity> 宛名識別異動分取得PSM = 宛名識別異動分Dac.select(searchKey);
        mapper.createJukiChushutsuTmp();
        for (UaFt001FindIdoEntity uaFt001FindIdoEntity : 宛名識別異動分取得PSM) {
            ShotokuIdoTmpEntity entity = new ShotokuIdoTmpEntity();
            entity.setShikibetsuCode(uaFt001FindIdoEntity.getShikibetsuCode());
            mapper.insertJukiChushutsuTmp(entity);
        }
        mapper.createJukiIdoTmp();
        List<ShotokuIdoTmpEntity> 被保険者本人異動s = mapper.select住基異動_被保険者本人異動(param);
        for (ShotokuIdoTmpEntity shukiIdoEntity : 被保険者本人異動s) {
            mapper.insertJukiIdoTmp(shukiIdoEntity);
        }
        mapper.delete本人情報の削除();

        mapper.createIdoTmp();
        List<IdoTmpEntity> 本人以外の異動情報s = mapper.select住基異動_本人以外の異動情報(
                new FlexibleDate(param.get調定年度().minusYear(INT_2).getYearValue(), INT_4, INT_1));
        for (IdoTmpEntity entity : 本人以外の異動情報s) {
            mapper.insertIdoTmp(entity);
        }

        List<IdoTmpEntity> 本人異動情報s = mapper.select住基異動_本人の異動情報();
        for (IdoTmpEntity entity : 本人異動情報s) {
            mapper.insertIdoTmp(entity);
        }

        mapper.createShotokuChushutsuTmp();
        param.set調定年度minus1(param.get調定年度().minusYear(INT_1));
        param.set調定年度minus2(param.get調定年度().minusYear(INT_2));
        param.set年度サイクル(DbBusinessConfig.get(ConfigNameDBB.日付関連_年度サイクル, RDate.getNowDate(), SubGyomuCode.DBB介護賦課));
        List<ShotokuIdoTmpEntity> 介護取得から異動データs = mapper.select所得異動_介護所得から異動データ(param);
        for (ShotokuIdoTmpEntity entity : 介護取得から異動データs) {
            mapper.insertShotokuChushutsuTmp(entity);
        }

        mapper.createShotokuIdoTmp();
        List<ShotokuIdoTmpEntity> 所得異動_被保険者本人異動s = mapper.select所得異動_被保険者本人異動();
        for (ShotokuIdoTmpEntity entity : 所得異動_被保険者本人異動s) {
            mapper.insertShotokuIdoTmp(entity);
        }
        mapper.delete所得異動_本人の情報の削除();

        本人以外の異動情報s = mapper.select所得異動_本人以外の異動情報(
                new FlexibleDate(param.get調定年度().minusYear(INT_2).getYearValue(), INT_4, INT_1));
        for (IdoTmpEntity entity : 本人以外の異動情報s) {
            mapper.insertIdoTmp(entity);
        }
        本人異動情報s = mapper.select所得異動_本人の異動情報();
        for (IdoTmpEntity entity : 本人異動情報s) {
            mapper.insertIdoTmp(entity);
        }

        List<IdoTmpEntity> 資格の異動情報s = mapper.select資格の異動(param);
        for (IdoTmpEntity entity : 資格の異動情報s) {
            mapper.insertIdoTmp(entity);
        }

        List<IdoTmpEntity> 生保の異動情報s = mapper.select生保の異動(param);
        for (IdoTmpEntity entity : 生保の異動情報s) {
            mapper.insertIdoTmp(entity);
        }

        List<IdoTmpEntity> 老齢の異動情報s = mapper.select老齢の異動(param);
        for (IdoTmpEntity entity : 老齢の異動情報s) {
            mapper.insertIdoTmp(entity);
        }

        List<IdoTmpEntity> 境界層の異動情報s = mapper.select境界層の異動(param);
        for (IdoTmpEntity entity : 境界層の異動情報s) {
            mapper.insertIdoTmp(entity);
        }

        List<IdoTmpEntity> 徴収方法の異動情報s = mapper.select徴収方法の異動(param);
        for (IdoTmpEntity entity : 徴収方法の異動情報s) {
            mapper.insertIdoTmp(entity);
        }
    }

    /**
     * 通知書番号発番の処理です。
     *
     * @param param パラメータ
     */
    public void createTsuchishoBango(KanendoFukaParameter param) {
        IHonSanteiIdoKanendoFukaMapper mapper = mapperProvider.create(IHonSanteiIdoKanendoFukaMapper.class);
        param.set賦課年度(param.get調定年度().minusYear(INT_1));
        List<DbT1001HihokenshaDaichoEntity> daichoEntityList = mapper.select資格情報(param);
        List<HihokenshaDaicho> 資格の情報年度minus1 = new ArrayList<>();
        for (DbT1001HihokenshaDaichoEntity entity : daichoEntityList) {
            資格の情報年度minus1.add(new HihokenshaDaicho(entity));
        }
        List<FukaJohoRelateEntity> fukaJohoList = mapper.select賦課情報(param);
        List<FukaJoho> 賦課の情報年度minus1 = new ArrayList<>();
        for (FukaJohoRelateEntity entity : fukaJohoList) {
            賦課の情報年度minus1.add(new FukaJoho(entity));
        }

        mapper.createKanendoHonSanteiChushutsuTmp();
        mapper.createTsukibetsuRankuTmp();
        dbの処理(資格の情報年度minus1, 賦課の情報年度minus1, param);

        param.set賦課年度(param.get調定年度().minusYear(INT_2));
        daichoEntityList = mapper.select資格情報(param);
        List<HihokenshaDaicho> 資格の情報年度minus2 = new ArrayList<>();
        for (DbT1001HihokenshaDaichoEntity entity : daichoEntityList) {
            資格の情報年度minus2.add(new HihokenshaDaicho(entity));
        }
        fukaJohoList = mapper.select賦課情報(param);
        List<FukaJoho> 賦課の情報年度minus2 = new ArrayList<>();
        for (FukaJohoRelateEntity entity : fukaJohoList) {
            賦課の情報年度minus2.add(new FukaJoho(entity));
        }
        dbの処理(資格の情報年度minus2, 賦課の情報年度minus2, param);
    }

    private void dbの処理(List<HihokenshaDaicho> 資格の情報年度, List<FukaJoho> 賦課の情報年度, KanendoFukaParameter param) {
        Collections.sort(資格の情報年度, new Comparator<HihokenshaDaicho>() {
            @Override
            public int compare(HihokenshaDaicho o1, HihokenshaDaicho o2) {
                return o1.get被保険者番号().compareTo(o2.get被保険者番号());
            }
        });
        List<HihokenshaDaicho> daichoList = new ArrayList<>();
        boolean isFirst = true;
        HihokenshaNo 被保険者番号 = HihokenshaNo.EMPTY;
        Map<HihokenshaNo, FukaJoho> 賦課情報Map = new HashMap<>();
        for (FukaJoho joho : 賦課の情報年度) {
            賦課情報Map.put(joho.get被保険者番号(), joho);
        }
        for (HihokenshaDaicho daicho : 資格の情報年度) {
            if (isFirst) {
                被保険者番号 = daicho.get被保険者番号();
                daichoList.add(daicho);
                isFirst = false;
                continue;
            }
            if (被保険者番号.equals(daicho.get被保険者番号())) {
                daichoList.add(daicho);
            } else {
                process一時表(daichoList, 賦課情報Map.get(被保険者番号), param);
                daichoList.clear();
                被保険者番号 = daicho.get被保険者番号();
                daichoList.add(daicho);
            }
        }
        FukaJoho 賦課の情報 = null;
        if (!daichoList.isEmpty()) {
            賦課の情報 = 賦課情報Map.get(daichoList.get(0).get被保険者番号());
        }
        process一時表(daichoList, 賦課の情報, param);
        process賦課エラー情報(資格の情報年度, 賦課の情報年度, param);
    }

    private void sort(List<HihokenshaDaicho> 資格の情報年度) {
        Collections.sort(資格の情報年度, new Comparator<HihokenshaDaicho>() {
            @Override
            public int compare(HihokenshaDaicho o1, HihokenshaDaicho o2) {
                return o1.get第1号資格取得年月日().isBefore(o2.get第1号資格取得年月日()) ? 1 : -1;
            }
        });
    }

    private void process一時表(List<HihokenshaDaicho> 資格の情報, FukaJoho 賦課の情報, KanendoFukaParameter param) {
        sort(資格の情報);
        IHonSanteiIdoKanendoFukaMapper mapper = mapperProvider.create(IHonSanteiIdoKanendoFukaMapper.class);
        if (賦課の情報 == null) {
            for (HihokenshaDaicho daicho : 資格の情報) {
                HonsanteiShotokuTmpEntity entity = new HonsanteiShotokuTmpEntity();
                set資格の情報Entity(daicho, entity, param);
                entity.setFukaNendo(param.get賦課年度());
                entity.setTsuchishoNo(create通知書番号(daicho.get被保険者番号().getColumnValue(), 1));
                mapper.insertKanendoHonSanteiChushutsuTmp(entity);
            }
        } else if (資格の情報.size() == 1) {
            HonsanteiShotokuTmpEntity entity = new HonsanteiShotokuTmpEntity();
            set資格の情報Entity(資格の情報.get(0), entity, param);
            entity.setFukaNendo(賦課の情報.get賦課年度());
            entity.setTsuchishoNo(賦課の情報.get通知書番号());
            mapper.insertKanendoHonSanteiChushutsuTmp(entity);
        } else {
            int count = 0;
            for (HihokenshaDaicho daicho : 資格の情報) {
                count = count + 1;
                HonsanteiShotokuTmpEntity entity = new HonsanteiShotokuTmpEntity();
                set資格の情報Entity(daicho, entity, param);
                entity.setFukaNendo(param.get賦課年度());
                entity.setTsuchishoNo(create通知書番号(daicho.get被保険者番号().getColumnValue(), count));
                mapper.insertKanendoHonSanteiChushutsuTmp(entity);
            }
        }
        load月別ランク(資格の情報, param.get賦課年度());
    }

    private void process賦課エラー情報(List<HihokenshaDaicho> 資格の情報, List<FukaJoho> 賦課の情報, KanendoFukaParameter param) {
        for (FukaJoho fukaEntity : 賦課の情報) {
            boolean flg = true;
            for (HihokenshaDaicho daichoEntity : 資格の情報) {
                if (fukaEntity.get被保険者番号().equals(daichoEntity.get被保険者番号())) {
                    flg = false;
                    break;
                }
            }
            if (flg) {
                DbT2010FukaErrorListEntity errorListEntity = new DbT2010FukaErrorListEntity();
                errorListEntity.setSubGyomuCode(SubGyomuCode.DBB介護賦課);
                errorListEntity.setInternalReportId(内部帳票ID);
                errorListEntity.setFukaNendo(param.get賦課年度());
                errorListEntity.setTsuchishoNo(fukaEntity.get通知書番号());
                errorListEntity.setInternalReportCreationDateTime(fukaEntity.get調定日時() == null
                        || fukaEntity.get調定日時().isEmpty() ? null : fukaEntity.get調定日時().getRDateTime());
                errorListEntity.setBatchId(バッチID);
                errorListEntity.setBatchStartingDateTime(RDate.getNowDateTime());
                errorListEntity.setErrorCode(new Code(ErrorCode.被保険者台帳データなし.getコード()));
                errorListEntity.setHihokenshaNo(fukaEntity.get被保険者番号());
                errorListEntity.setShikibetsuCode(fukaEntity.get識別コード());
                errorListEntity.setShikakuShutokuYMD(fukaEntity.get資格取得日());
                errorListEntity.setShikakuShutokuJiyu(fukaEntity.get資格取得事由());
                errorListEntity.setShikakuSoshitsuYMD(fukaEntity.get資格喪失日());
                errorListEntity.setShikakuSoshitsuJiyu(fukaEntity.get資格喪失事由());
                errorListEntity.setState(EntityDataState.Added);
                賦課エラーDac.save(errorListEntity);
            }
        }
    }

    private void set資格の情報Entity(HihokenshaDaicho 資格の情報, HonsanteiShotokuTmpEntity entity,
            KanendoFukaParameter param) {
        entity.setHihokenshaNo(資格の情報.get被保険者番号());
        entity.setIdoYMD(資格の情報.get異動日());
        entity.setEdaNo(資格の情報.get枝番());
        entity.setIdoJiyuCode(資格の情報.get異動事由コード());
        entity.setShichosonCode(資格の情報.get市町村コード());
        entity.setShikibetsuCode(資格の情報.get識別コード());
        entity.setShikakuShutokuJiyuCode(資格の情報.get資格取得事由コード());
        entity.setShikakuShutokuYMD(資格の情報.get資格取得年月日());
        entity.setShikakuShutokuTodokedeYMD(資格の情報.get資格取得届出年月日());
        entity.setIchigoShikakuShutokuYMD(資格の情報.get第1号資格取得年月日());
        entity.setHihokennshaKubunCode(資格の情報.get被保険者区分コード());
        entity.setShikakuSoshitsuJiyuCode(資格の情報.get資格喪失事由コード());
        entity.setShikakuSoshitsuYMD(資格の情報.get資格喪失年月日());
        entity.setShikakuSoshitsuTodokedeYMD(資格の情報.get資格喪失届出年月日());
        entity.setShikakuHenkoJiyuCode(資格の情報.get資格変更事由コード());
        entity.setShikakuHenkoYMD(資格の情報.get資格変更年月日());
        entity.setShikakuHenkoTodokedeYMD(資格の情報.get資格変更届出年月日());
        entity.setJushochitokureiTekiyoJiyuCode(資格の情報.get住所地特例適用事由コード());
        entity.setJushochitokureiTekiyoYMD(資格の情報.get適用年月日());
        entity.setJushochitokureiTekiyoTodokedeYMD(資格の情報.get適用届出年月日());
        entity.setJushochitokureiKaijoJiyuCode(資格の情報.get住所地特例解除事由コード());
        entity.setJushochitokureiKaijoYMD(資格の情報.get解除年月日());
        entity.setJushochitokureiKaijoTodokedeYMD(資格の情報.get解除届出年月日());
        entity.setJushochiTokureiFlag(資格の情報.get住所地特例フラグ());
        entity.setKoikinaiJushochiTokureiFlag(資格の情報.get広域内住所地特例フラグ());
        entity.setKoikinaiTokureiSochimotoShichosonCode(資格の情報.get広住特措置元市町村コード());
        entity.setKyuShichosonCode(資格の情報.get旧市町村コード());
        entity.setLogicalDeletedFlag(資格の情報.is論理削除フラグ());
        FlexibleDate fukaDate = new FlexibleDate(param.get賦課年度().getYearValue(), INT_4, INT_1);
        if (資格の情報.get第1号資格取得年月日() == null || 資格の情報.get第1号資格取得年月日().isEmpty()
                || 資格の情報.get第1号資格取得年月日().isBefore(fukaDate)) {
            entity.setFukaKijitsu(fukaDate);
        } else {
            entity.setFukaKijitsu(資格の情報.get第1号資格取得年月日());
        }
    }

    private void load月別ランク(List<HihokenshaDaicho> 資格の情報, FlexibleYear 賦課年度) {
        if (資格の情報.isEmpty()) {
            return;
        }
        IHonSanteiIdoKanendoFukaMapper mapper = mapperProvider.create(IHonSanteiIdoKanendoFukaMapper.class);
        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        if (市町村セキュリティ情報 != null && 市町村セキュリティ情報.get導入形態コード() != null
                && DonyuKeitaiCode.事務広域.getCode().equals(市町村セキュリティ情報.get導入形態コード().getKey())) {
            RString 合併情報区分 = DbBusinessConfig.get(ConfigNameDBU.合併情報管理_合併情報区分,
                    RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
            if (合併情報区分_合併あり.equals(合併情報区分)) {
                HokenryoRank rank = InstanceProvider.create(HokenryoRank.class);
                List<MonthShichoson> 月別ランク情報 = rank.get月別ランク情報(資格の情報, 賦課年度);
                TsukibetsuRankuTmpEntity rankuEntity = new TsukibetsuRankuTmpEntity();
                rankuEntity.setHihokenshaNo(資格の情報.get(0).get被保険者番号());
                rankuEntity.setFukaNendo(new RYear(賦課年度.getYearValue()));
                set月別ランク(rankuEntity, 月別ランク情報);
                mapper.insertTsukibetsuRankuTmp(rankuEntity);
            }
        }
    }

    private void set月別ランク(TsukibetsuRankuTmpEntity rankuEntity, List<MonthShichoson> 月別ランク情報リスト) {
        for (MonthShichoson 月別ランク情報 : 月別ランク情報リスト) {
            if (Tsuki._4月.getコード().equals(月別ランク情報.get月().getコード())) {
                rankuEntity.setRankKubun4Gatsu(月別ランク情報.getランク区分());
                rankuEntity.setShichosonCode4Gatsu(月別ランク情報.get市町村コード());
            } else if (Tsuki._5月.getコード().equals(月別ランク情報.get月().getコード())) {
                rankuEntity.setRankKubun5Gatsu(月別ランク情報.getランク区分());
                rankuEntity.setShichosonCode5Gatsu(月別ランク情報.get市町村コード());
            } else if (Tsuki._6月.getコード().equals(月別ランク情報.get月().getコード())) {
                rankuEntity.setRankKubun6Gatsu(月別ランク情報.getランク区分());
                rankuEntity.setShichosonCode6Gatsu(月別ランク情報.get市町村コード());
            } else if (Tsuki._7月.getコード().equals(月別ランク情報.get月().getコード())) {
                rankuEntity.setRankKubun7Gatsu(月別ランク情報.getランク区分());
                rankuEntity.setShichosonCode7Gatsu(月別ランク情報.get市町村コード());
            } else if (Tsuki._8月.getコード().equals(月別ランク情報.get月().getコード())) {
                rankuEntity.setRankKubun8Gatsu(月別ランク情報.getランク区分());
                rankuEntity.setShichosonCode8Gatsu(月別ランク情報.get市町村コード());
            } else if (Tsuki._9月.getコード().equals(月別ランク情報.get月().getコード())) {
                rankuEntity.setRankKubun9Gatsu(月別ランク情報.getランク区分());
                rankuEntity.setShichosonCode9Gatsu(月別ランク情報.get市町村コード());
            } else if (Tsuki._10月.getコード().equals(月別ランク情報.get月().getコード())) {
                rankuEntity.setRankKubun10Gatsu(月別ランク情報.getランク区分());
                rankuEntity.setShichosonCode10Gatsu(月別ランク情報.get市町村コード());
            } else if (Tsuki._11月.getコード().equals(月別ランク情報.get月().getコード())) {
                rankuEntity.setRankKubun11Gatsu(月別ランク情報.getランク区分());
                rankuEntity.setShichosonCode11Gatsu(月別ランク情報.get市町村コード());
            } else if (Tsuki._12月.getコード().equals(月別ランク情報.get月().getコード())) {
                rankuEntity.setRankKubun12Gatsu(月別ランク情報.getランク区分());
                rankuEntity.setShichosonCode12Gatsu(月別ランク情報.get市町村コード());
            } else if (Tsuki._1月.getコード().equals(月別ランク情報.get月().getコード())) {
                rankuEntity.setRankKubun1Gatsu(月別ランク情報.getランク区分());
                rankuEntity.setShichosonCode1Gatsu(月別ランク情報.get市町村コード());
            } else if (Tsuki._2月.getコード().equals(月別ランク情報.get月().getコード())) {
                rankuEntity.setRankKubun2Gatsu(月別ランク情報.getランク区分());
                rankuEntity.setShichosonCode2Gatsu(月別ランク情報.get市町村コード());
            } else if (Tsuki._3月.getコード().equals(月別ランク情報.get月().getコード())) {
                rankuEntity.setRankKubun3Gatsu(月別ランク情報.getランク区分());
                rankuEntity.setShichosonCode3Gatsu(月別ランク情報.get市町村コード());
            }
        }
    }

    private TsuchishoNo create通知書番号(RString 被保険者番号, int 枝番号) {
        RStringBuilder rst = new RStringBuilder();
        rst.append(ゼロ_0000);
        rst.append(被保険者番号);
        rst.append(new RString(String.format(FROMAT.toString(), 枝番号)));
        return new TsuchishoNo(rst.toRString());
    }

    /**
     * 世帯員把握の処理です。
     */
    public void collectSetaiin() {
        IHonSanteiIdoKanendoFukaMapper mapper = mapperProvider.create(IHonSanteiIdoKanendoFukaMapper.class);
        List<SetaiHaakuEntity> 世帯員把握情報 = mapper.select世帯員把握情報();
        mapper.createTmpSetaiHaaku();
        for (SetaiHaakuEntity setaiHaakuEntity : 世帯員把握情報) {
            mapper.insertTmpSetaiHaaku(setaiHaakuEntity);
        }

        SetaiShotokuKazeiHantei hantei = SetaiShotokuKazeiHantei.createInstance();
        hantei.getSetaiinHaaku(SetaiinHaakuKanriShikibetsuKubun.賦課.getコード());
        hantei.getJuminShotokuJoho();
    }

    /**
     * 賦課計算の処理です。
     *
     * @param 調定年度 調定年度
     * @param 調定日時 調定日時
     */
    public void calculateFuka(FlexibleYear 調定年度, YMDHMS 調定日時) {
        ShunoKamokuAuthority auth = InstanceProvider.create(ShunoKamokuAuthority.class);
        KozaSearchKeyBuilder kozaBuilder = new KozaSearchKeyBuilder();
        kozaBuilder.setサブ業務コード(SubGyomuCode.DBB介護賦課);
        kozaBuilder.set業務コード(GyomuCode.DB介護保険);
        kozaBuilder.set基準日(FlexibleDate.getNowDate());
        kozaBuilder.set用途区分(new KozaYotoKubunCodeValue(用途区分コード));
        List<KamokuCode> list = auth.get更新権限科目コード(ControlDataHolder.getUserId());
        CalculateFukaParameter param = new CalculateFukaParameter(kozaBuilder.build(), list, 調定年度, 調定日時);
        IHonSanteiIdoKanendoFukaMapper mapper = mapperProvider.create(IHonSanteiIdoKanendoFukaMapper.class);
        List<CalculateFukaTmpEntity> 賦課計算用データ = mapper.select賦課計算用データ(param);
        mapper.createCalculateFukaTmp();
        for (CalculateFukaTmpEntity entity : 賦課計算用データ) {
            mapper.insertCalculateFukaTmp(entity);
        }
        List<CalculateFukaEntity> 賦課計算 = mapper.select賦課計算(param);
        HokenryoDankaiList 保険料段階List = HokenryoDankaiSettings.createInstance().get保険料段階ListIn(param.get賦課年度());
        SeigyoJoho 月別保険料制御情報 = get月別保険料制御情報(保険料段階List);

        NengakuSeigyoJoho 年額制御情報 = get年額制御情報();
        for (CalculateFukaEntity 賦課計算の情報 : 賦課計算) {
            HokenryoDankaiHantei hantei = InstanceProvider.create(HokenryoDankaiHantei.class);
            HokenryoDankaiHanteiParameter 保険料段階パラメータ = new HokenryoDankaiHanteiParameter();
            保険料段階パラメータ.setFukaNendo(賦課計算の情報.getFukaNendo());

            List<SeikatsuHogoJukyusha> 生保の情報 = new ArrayList<>();
            for (SeikatsuHogoJukyushaRelateEntity entity : 賦課計算の情報.get生保の情報()) {
                生保の情報.add(new SeikatsuHogoJukyusha(entity));
            }
            List<RoreiFukushiNenkinJukyusha> 老齢の情報 = new ArrayList<>();
            for (DbT7006RoreiFukushiNenkinJukyushaEntity entity : 賦課計算の情報.get老齢の情報()) {
                老齢の情報.add(new RoreiFukushiNenkinJukyusha(entity));
            }
            List<KyokaisoGaitosha> 境界層の情報 = new ArrayList<>();
            for (KyokaisoGaitoshaEntity entity : 賦課計算の情報.get境界層の情報()) {
                境界層の情報.add(new KyokaisoGaitosha(entity));
            }
            FukaKonkyoFactory factory = InstanceProvider.create(FukaKonkyoFactory.class);
            FukaKonkyoBatchParameter fukaKonkyoBatchParameter = new FukaKonkyoBatchParameter();
            fukaKonkyoBatchParameter.set賦課基準日(賦課計算の情報.getFukaKijitsu());
            fukaKonkyoBatchParameter.set生保の情報リスト(生保の情報);
            fukaKonkyoBatchParameter.set老齢の情報のリスト(老齢の情報);
            fukaKonkyoBatchParameter.set世帯員所得情報List(賦課計算の情報.get世帯員所得情報());
            FukaKonkyo 賦課根拠 = factory.create(fukaKonkyoBatchParameter);
            保険料段階パラメータ.setFukaKonkyo(賦課根拠);

            保険料段階パラメータ.setSeigyoJoho(月別保険料制御情報);
            TsukibetsuHokenryoDankai 月別保険料段階 = hantei.determine月別保険料段階(保険料段階パラメータ);

            NengakuHokenryoKeisanParameter 年額保険料パラメータ = new NengakuHokenryoKeisanParameter();
            年額保険料パラメータ.set賦課年度(賦課計算の情報.getFukaNendo());

            NengakuFukaKonkyoFactory nengakuFukaKonkyo = InstanceProvider.create(NengakuFukaKonkyoFactory.class);
            TsukibetsuRankuTmpEntity 月別ランク = 賦課計算の情報.get月別ランク();
            NengakuFukaKonkyo 年額賦課根拠 = nengakuFukaKonkyo.createNengakuFukaKonkyo(
                    賦課計算の情報.getFukaKijitsu(),
                    賦課計算の情報.get資格の情報().getIchigoShikakuShutokuYMD(),
                    賦課計算の情報.get資格の情報().getShikakuSoshitsuYMD(),
                    月別保険料段階,
                    月別ランク.getRankKubun4Gatsu(),
                    月別ランク.getRankKubun5Gatsu(),
                    月別ランク.getRankKubun6Gatsu(),
                    月別ランク.getRankKubun7Gatsu(),
                    月別ランク.getRankKubun8Gatsu(),
                    月別ランク.getRankKubun9Gatsu(),
                    月別ランク.getRankKubun10Gatsu(),
                    月別ランク.getRankKubun11Gatsu(),
                    月別ランク.getRankKubun12Gatsu(),
                    月別ランク.getRankKubun1Gatsu(),
                    月別ランク.getRankKubun2Gatsu(),
                    月別ランク.getRankKubun3Gatsu());

            年額保険料パラメータ.set年額賦課根拠(年額賦課根拠);
            年額保険料パラメータ.set年額制御情報(年額制御情報);
            NengakuHokenryoKeisan keisan = InstanceProvider.create(NengakuHokenryoKeisan.class);
            NengakuHokenryo 年額保険料 = keisan.calculate年額保険料(年額保険料パラメータ);

            FukaKokyoBatchParameter fukaKokyoBatchParameter = new FukaKokyoBatchParameter();
            fukaKokyoBatchParameter.set賦課年度(param.get賦課年度());
            fukaKokyoBatchParameter.set調定日時(調定日時);
            fukaKokyoBatchParameter.set資格の情報(new HihokenshaDaicho(賦課計算の情報.get資格の情報()));
            fukaKokyoBatchParameter.set世帯員所得情報List(賦課計算の情報.get世帯員所得情報());
            fukaKokyoBatchParameter.set生保の情報のリスト(生保の情報);
            fukaKokyoBatchParameter.set老福の情報のリスト(老齢の情報);
            fukaKokyoBatchParameter.set境界層の情報のリスト(境界層の情報);
            if (賦課計算の情報.get賦課の情報() == null) {
                create新規の賦課処理(賦課計算の情報, fukaKokyoBatchParameter, param);
            } else {
                create既存の賦課処理(賦課計算の情報, fukaKokyoBatchParameter, param, 年額保険料.getHokenryoNengaku());
            }
        }
    }

    private NengakuSeigyoJoho get年額制御情報() {
        RDate nowDate = RDate.getNowDate();
        Decimal 端数単位 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.年額計算_端数調整単位_通常,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        RString 端数調整方法 = DbBusinessConfig.get(ConfigNameDBB.年額計算_端数調整方法_通常,
                nowDate, SubGyomuCode.DBB介護賦課);
        Decimal 端数単位_ランク用 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.年額計算_端数調整単位_ランク変更のみ,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        RString 端数調整方法_ランク用 = DbBusinessConfig.get(ConfigNameDBB.年額計算_端数調整方法_通常,
                nowDate, SubGyomuCode.DBB介護賦課);
        RString 端数調整対象 = DbBusinessConfig.get(ConfigNameDBB.年額計算_端数調整対象,
                nowDate, SubGyomuCode.DBB介護賦課);
        Map<RString, RankBetsuKijunKingaku> ランク別制御情報 = new HashMap<>();
        // TODO QAのNo.957　「ランク別制御情報」の設定方法がない。
        NengakuFukaKonkyoFactory nengakuFukaKonkyoFactory = InstanceProvider.create(NengakuFukaKonkyoFactory.class);
        NengakuSeigyoJoho 年額制御情報 = nengakuFukaKonkyoFactory.createNengakuSeigyoJoho(
                端数単位,
                HasuChoseiHoho.toValue(端数調整方法),
                端数単位_ランク用,
                HasuChoseiHoho.toValue(端数調整方法_ランク用),
                HasuChoseiTaisho.toValue(端数調整対象),
                ランク別制御情報);
        return 年額制御情報;
    }

    private void create新規の賦課処理(CalculateFukaEntity 賦課計算の情報, FukaKokyoBatchParameter fukaKokyoBatchParameter,
            CalculateFukaParameter param) {
        FukaJoho 新しい賦課の情報 = new FukaJoho(param.get調定年度(), 賦課計算の情報.getFukaNendo(), 賦課計算の情報.getTsuchishoNo(), 0);
        fukaKokyoBatchParameter.set賦課の情報_設定前(新しい賦課の情報);
        FukaJoho 賦課の情報_設定後 = FukaKeisan.createInstance().reflect賦課根拠(fukaKokyoBatchParameter);
        List<FukaJoho> 賦課の情報_設定後List = new ArrayList<>();
        賦課の情報_設定後List.add(賦課の情報_設定後);
        FukaJohoToChoshuHoho 調定計算 = caluculateChotei(賦課の情報_設定後List, new ChoshuHoho(賦課計算の情報.get徴収方法の情報()),
                param.get調定年度(), param.get調定日時());

        List<FukaJoho> 賦課の情報 = 調定計算.get賦課情報();
        for (FukaJoho joho : 賦課の情報) {
            update賦課の情報(joho, 賦課計算の情報, param, joho);
        }
    }

    private void create既存の賦課処理(CalculateFukaEntity 賦課計算の情報, FukaKokyoBatchParameter fukaKokyoBatchParameter,
            CalculateFukaParameter param, Decimal 年額保険料) {
        List<FukaJoho> 賦課の情報_更正前List = new ArrayList<>();
        List<FukaJoho> 賦課の情報_更正後List = new ArrayList<>();
        List<FukaJoho> 賦課の情報_計算前List = new ArrayList<>();
        for (FukaJohoRelateEntity entity : 賦課計算の情報.get賦課の情報()) {
            FukaJoho 賦課の情報_設定前 = new FukaJoho(entity);
            if (Decimal.ZERO.compareTo(賦課の情報_設定前.get減免額()) < 0) {
                賦課エラー登録処理(賦課の情報_設定前, param.get賦課年度(), new Code(ErrorCode.職権変更該当.getコード()));
                continue;
            }

            賦課の情報_更正前List.add(賦課の情報_設定前);
            fukaKokyoBatchParameter.set賦課の情報_設定前(賦課の情報_設定前);
            FukaJoho 賦課の情報_更正後 = FukaKeisan.createInstance().reflect賦課根拠(fukaKokyoBatchParameter);
            if ((賦課の情報_設定前.get調定年度().equals(賦課の情報_設定前.get賦課年度())
                    && isDecimal変更(賦課の情報_設定前.get減免前介護保険料_年額(), 年額保険料)
                    || (!RString.isNullOrEmpty(賦課計算の情報.get徴収方法の情報().getTokuchoTeishiJiyuCode())))) {
                賦課の情報_計算前List.add(賦課の情報_更正後);
            } else {
                賦課の情報_更正後List.add(賦課の情報_更正後);
            }
        }
        if (!賦課の情報_計算前List.isEmpty()) {
            FukaJohoToChoshuHoho 調定計算 = caluculateChotei(賦課の情報_計算前List,
                    new ChoshuHoho(賦課計算の情報.get徴収方法の情報()), param.get調定年度(), param.get調定日時());
            賦課の情報_更正後List.addAll(調定計算.get賦課情報());
        }
        FukaJoho 計算前 = get最新賦課情報(賦課の情報_更正前List);
        FukaJoho 計算後 = get最新賦課情報(賦課の情報_更正後List);
        if (is変化有り(計算前, 計算後)) {
            update賦課の情報(計算前, 賦課計算の情報, param, 計算後);
        }
    }

    private FukaJoho get最新賦課情報(List<FukaJoho> 賦課の情報List) {
        FukaJoho result = null;
        if (賦課の情報List == null || 賦課の情報List.isEmpty()) {
            return null;
        }
        if (賦課の情報List.size() == 1) {
            return 賦課の情報List.get(0);
        }
        boolean isFirst = true;
        for (FukaJoho joho : 賦課の情報List) {
            if (isFirst) {
                isFirst = false;
                result = joho;
            }
            if (result != null && result.get調定年度().isBefore(joho.get調定年度())) {
                result = joho;
            }
        }
        return result;
    }

    private void update賦課の情報(FukaJoho 計算前, CalculateFukaEntity 賦課計算の情報,
            CalculateFukaParameter param, FukaJoho 計算後) {
        int 履歴番号 = 0;
        if (!計算前.equals(計算後)) {
            履歴番号 = 計算前.get履歴番号() + INT_1;
        }
        int 徴収方法履歴番号 = 0;
        if (計算後 != null) {
            徴収方法履歴番号 = 計算後.get徴収方法履歴番号();
        }
        FukaJohoBuilder builder = 計算前.createBuilderForEdit();
        builder.set履歴番号(履歴番号);
        builder.set被保険者番号(賦課計算の情報.get資格の情報().getHihokenshaNo())
                .set調定日時(param.get調定日時())
                .set異動基準日時(param.get調定日時())
                .set保険料段階_仮算定時(計算前.get保険料段階_仮算定時())
                .set徴収方法履歴番号(徴収方法履歴番号);
        if (!is普徴期別金額あり(計算後)) {
            builder.set口座区分(KozaKubun.現金納付.getコード());
        } else {
            if (!賦課計算の情報.get口座().isEmpty()) {
                builder.set口座区分(KozaKubun.口座振替.getコード());
            } else {
                builder.set口座区分(KozaKubun.現金納付.getコード());
            }
        }
        HokenryoRank rank = InstanceProvider.create(HokenryoRank.class);
        List<HihokenshaDaicho> 資格 = new ArrayList<>();
        資格.add(new HihokenshaDaicho(賦課計算の情報.get資格の情報()));
        List<MonthShichoson> 月別ランク情報 = rank.get月別ランク情報(資格, param.get賦課年度());
        builder.set賦課市町村コード(get最終月の市町村コード(月別ランク情報))
                .set特徴歳出還付額(計算前.get特徴歳出還付額())
                .set普徴歳出還付額(計算前.get普徴歳出還付額())
                .set異動基準日時(param.get調定日時())
                .set減免額(計算前.get減免額());
        計算後 = builder.build();
        DbT2002FukaEntity fuka = 計算後.toEntity();
        fuka.setState(EntityDataState.Added);
        賦課Dac.save(fuka);
        // TODO QAのNo.984
    }

    private SeigyoJoho get月別保険料制御情報(HokenryoDankaiList 保険料段階リスト) {
        RDate nowDate = RDate.getNowDate();
        Decimal 基準年金収入額01 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準年金収入1,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        Decimal 基準年金収入額02 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準年金収入2,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        Decimal 基準年金収入額03 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準年金収入3,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        Decimal 基準所得金額01 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額1,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        Decimal 基準所得金額02 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額2,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        Decimal 基準所得金額03 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額3,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        Decimal 基準所得金額04 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額4,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        Decimal 基準所得金額05 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額5,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        Decimal 基準所得金額06 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額6,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        Decimal 基準所得金額07 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額7,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        Decimal 基準所得金額08 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額8,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        Decimal 基準所得金額09 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額9,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        Decimal 基準所得金額10 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額10,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        Decimal 基準所得金額11 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額11,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        Decimal 基準所得金額12 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額12,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        Decimal 基準所得金額13 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額13,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        Decimal 基準所得金額14 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額14,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        Decimal 基準所得金額15 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額15,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        RString 課税層所得段階 = DbBusinessConfig.get(ConfigNameDBB.賦課基準_課税層保険料段階インデックス,
                nowDate, SubGyomuCode.DBB介護賦課);
        RString 未申告段階使用 = DbBusinessConfig.get(ConfigNameDBB.賦課基準_未申告保険料段階使用,
                nowDate, SubGyomuCode.DBB介護賦課);
        boolean 未申告段階使用有無 = false;
        if (使用する.getコード().equals(未申告段階使用)) {
            未申告段階使用有無 = true;
        } else if (使用しない.getコード().equals(未申告段階使用)) {
            未申告段階使用有無 = false;
        }
        RString 未申告段階インデックス = DbBusinessConfig.get(ConfigNameDBB.賦課基準_未申告保険料段階インデックス,
                nowDate, SubGyomuCode.DBB介護賦課);
        RString 未申告課税区分 = DbBusinessConfig.get(ConfigNameDBB.賦課基準_未申告課税区分,
                nowDate, SubGyomuCode.DBB介護賦課);
        RString 所得調査中段階使用 = DbBusinessConfig.get(ConfigNameDBB.賦課基準_所得調査中保険料段階使用,
                nowDate, SubGyomuCode.DBB介護賦課);
        boolean 所得調査中段階使用有無 = false;
        if (使用する.getコード().equals(所得調査中段階使用)) {
            所得調査中段階使用有無 = true;
        } else if (使用しない.getコード().equals(所得調査中段階使用)) {
            所得調査中段階使用有無 = false;
        }
        RString 所得調査中段階インデックス = DbBusinessConfig.get(ConfigNameDBB.賦課基準_所得調査中保険料段階インデックス,
                nowDate, SubGyomuCode.DBB介護賦課);
        RString 所得調査中課税区分 = DbBusinessConfig.get(ConfigNameDBB.賦課基準_所得調査中課税区分,
                nowDate, SubGyomuCode.DBB介護賦課);
        RString 課税取消段階使用 = DbBusinessConfig.get(ConfigNameDBB.賦課基準_課税取消保険料段階使用,
                nowDate, SubGyomuCode.DBB介護賦課);
        boolean 課税取消段階使用有無 = false;
        if (使用する.getコード().equals(課税取消段階使用)) {
            課税取消段階使用有無 = true;
        } else if (使用しない.getコード().equals(課税取消段階使用)) {
            課税取消段階使用有無 = false;
        }
        RString 課税取消段階インデックス = DbBusinessConfig.get(ConfigNameDBB.賦課基準_課税取消保険料段階インデックス,
                nowDate, SubGyomuCode.DBB介護賦課);
        RString 課税取消課税区分 = DbBusinessConfig.get(ConfigNameDBB.賦課基準_課税取消課税区分,
                nowDate, SubGyomuCode.DBB介護賦課);

        SeigyojohoFactory seigyojohoFactory = InstanceProvider.create(SeigyojohoFactory.class);
        SeigyoJoho 月別保険料制御情報 = seigyojohoFactory.createSeigyojoho(
                保険料段階リスト,
                基準年金収入額01,
                基準年金収入額02,
                基準年金収入額03,
                基準所得金額01,
                基準所得金額02,
                基準所得金額03,
                基準所得金額04,
                基準所得金額05,
                基準所得金額06,
                基準所得金額07,
                基準所得金額08,
                基準所得金額09,
                基準所得金額10,
                基準所得金額11,
                基準所得金額12,
                基準所得金額13,
                基準所得金額14,
                基準所得金額15,
                課税層所得段階,
                未申告段階使用有無,
                未申告段階インデックス,
                KazeiKubun.toValue(未申告課税区分),
                所得調査中段階使用有無,
                所得調査中段階インデックス,
                KazeiKubun.toValue(所得調査中課税区分),
                課税取消段階使用有無,
                課税取消段階インデックス,
                KazeiKubun.toValue(課税取消課税区分));
        return 月別保険料制御情報;
    }

    private boolean is普徴期別金額あり(FukaJoho 賦課の情報) {
        if (賦課の情報 == null) {
            return false;
        }
        return is金額あり(賦課の情報.get普徴期別金額01())
                || is金額あり(賦課の情報.get普徴期別金額02())
                || is金額あり(賦課の情報.get普徴期別金額03())
                || is金額あり(賦課の情報.get普徴期別金額04())
                || is金額あり(賦課の情報.get普徴期別金額05())
                || is金額あり(賦課の情報.get普徴期別金額06())
                || is金額あり(賦課の情報.get普徴期別金額07())
                || is金額あり(賦課の情報.get普徴期別金額08())
                || is金額あり(賦課の情報.get普徴期別金額09())
                || is金額あり(賦課の情報.get普徴期別金額10())
                || is金額あり(賦課の情報.get普徴期別金額11())
                || is金額あり(賦課の情報.get普徴期別金額12())
                || is金額あり(賦課の情報.get普徴期別金額13())
                || is金額あり(賦課の情報.get普徴期別金額14());
    }

    private boolean is金額あり(Decimal 金額) {
        return 金額 != null && !Decimal.ZERO.equals(金額);
    }

    private LasdecCode get最終月の市町村コード(List<MonthShichoson> 月別ランク情報) {
        return get市町村コード(月別ランク情報, Tsuki._3月.getコード()) == null
                ? get市町村コード(月別ランク情報, Tsuki._2月.getコード()) == null
                ? get市町村コード(月別ランク情報, Tsuki._1月.getコード()) == null
                ? get市町村コード(月別ランク情報, Tsuki._12月.getコード()) == null
                ? get市町村コード(月別ランク情報, Tsuki._11月.getコード()) == null
                ? get市町村コード(月別ランク情報, Tsuki._10月.getコード()) == null
                ? get市町村コード(月別ランク情報, Tsuki._9月.getコード()) == null
                ? get市町村コード(月別ランク情報, Tsuki._8月.getコード()) == null
                ? get市町村コード(月別ランク情報, Tsuki._7月.getコード()) == null
                ? get市町村コード(月別ランク情報, Tsuki._6月.getコード()) == null
                ? get市町村コード(月別ランク情報, Tsuki._5月.getコード()) == null
                ? get市町村コード(月別ランク情報, Tsuki._4月.getコード())
                : get市町村コード(月別ランク情報, Tsuki._5月.getコード())
                : get市町村コード(月別ランク情報, Tsuki._6月.getコード())
                : get市町村コード(月別ランク情報, Tsuki._7月.getコード())
                : get市町村コード(月別ランク情報, Tsuki._8月.getコード())
                : get市町村コード(月別ランク情報, Tsuki._9月.getコード())
                : get市町村コード(月別ランク情報, Tsuki._10月.getコード())
                : get市町村コード(月別ランク情報, Tsuki._11月.getコード())
                : get市町村コード(月別ランク情報, Tsuki._12月.getコード())
                : get市町村コード(月別ランク情報, Tsuki._1月.getコード())
                : get市町村コード(月別ランク情報, Tsuki._2月.getコード())
                : get市町村コード(月別ランク情報, Tsuki._3月.getコード());
    }

    private LasdecCode get市町村コード(List<MonthShichoson> 月別ランク情報, RString 月) {
        for (MonthShichoson choson : 月別ランク情報) {
            if (月.equals(choson.get月().getコード()) && choson.get市町村コード() != null
                    && !choson.get市町村コード().getColumnValue().isEmpty()) {
                return choson.get市町村コード();
            }
        }
        return null;
    }

    private boolean is変化有り(FukaJoho 更正前, FukaJoho 更正後) {
        if (更正前 == null && 更正後 == null) {
            return false;
        } else if (更正前 != null && 更正後 == null) {
            return true;
        } else if (更正前 == null && 更正後 != null) {
            return true;
        }
        return is変化有り1(更正前, 更正後)
                || is変化有り2(更正前, 更正後)
                || is変化有り3(更正前, 更正後)
                || is変化有り4(更正前, 更正後);
    }

    private boolean is変化有り1(FukaJoho 更正前, FukaJoho 更正後) {
        return isTsuchishoNo変更(更正前.get通知書番号(), 更正後.get通知書番号())
                || isHihokenshaNo変更(更正前.get被保険者番号(), 更正後.get被保険者番号())
                || isShikibetsuCode変更(更正前.get識別コード(), 更正後.get識別コード())
                || isSetaiCode変更(更正前.get世帯コード(), 更正後.get世帯コード())
                || isInt変更(更正前.get世帯員数(), 更正後.get世帯員数())
                || isFlexibleDate変更(更正前.get資格取得日(), 更正後.get資格取得日())
                || isRString変更(更正前.get資格取得事由(), 更正後.get資格取得事由())
                || isFlexibleDate変更(更正前.get資格喪失日(), 更正後.get資格喪失日())
                || isRString変更(更正前.get資格喪失事由(), 更正後.get資格喪失事由())
                || isRString変更(更正前.get生活保護扶助種類(), 更正後.get生活保護扶助種類())
                || isFlexibleDate変更(更正前.get生保開始日(), 更正後.get生保開始日())
                || isFlexibleDate変更(更正前.get生保廃止日(), 更正後.get生保廃止日())
                || isFlexibleDate変更(更正前.get老年開始日(), 更正後.get老年開始日())
                || isFlexibleDate変更(更正前.get老年廃止日(), 更正後.get老年廃止日())
                || isFlexibleDate変更(更正前.get賦課期日(), 更正後.get賦課期日())
                || isRString変更(更正前.get課税区分(), 更正後.get課税区分())
                || isRString変更(更正前.get世帯課税区分(), 更正後.get世帯課税区分())
                || isDecimal変更(更正前.get合計所得金額(), 更正後.get合計所得金額());
    }

    private boolean is変化有り2(FukaJoho 更正前, FukaJoho 更正後) {
        return isDecimal変更(更正前.get公的年金収入額(), 更正後.get公的年金収入額())
                || isRString変更(更正前.get保険料段階(), 更正後.get保険料段階())
                || isRString変更(更正前.get保険料算定段階1(), 更正後.get保険料算定段階1())
                || isDecimal変更(更正前.get算定年額保険料1(), 更正後.get算定年額保険料1())
                || isFlexibleYearMonth変更(更正前.get月割開始年月1(), 更正後.get月割開始年月1())
                || isFlexibleYearMonth変更(更正前.get月割終了年月1(), 更正後.get月割終了年月1())
                || isRString変更(更正前.get保険料算定段階2(), 更正後.get保険料算定段階2())
                || isDecimal変更(更正前.get算定年額保険料2(), 更正後.get算定年額保険料2())
                || isFlexibleYearMonth変更(更正前.get月割開始年月2(), 更正後.get月割開始年月2())
                || isFlexibleYearMonth変更(更正前.get月割終了年月2(), 更正後.get月割終了年月2())
                || isRString変更(更正前.get調定事由1(), 更正後.get調定事由1())
                || isRString変更(更正前.get調定事由2(), 更正後.get調定事由2())
                || isRString変更(更正前.get調定事由3(), 更正後.get調定事由3())
                || isRString変更(更正前.get調定事由4(), 更正後.get調定事由4())
                || isDecimal変更(更正前.get減免前介護保険料_年額(), 更正後.get減免前介護保険料_年額())
                || isDecimal変更(更正前.get減免額(), 更正後.get減免額())
                || isDecimal変更(更正前.get確定介護保険料_年額(), 更正後.get確定介護保険料_年額())
                || isRString変更(更正前.get保険料段階_仮算定時(), 更正後.get保険料段階_仮算定時())
                || isRString変更(更正前.get口座区分(), 更正後.get口座区分());
    }

    private boolean is変化有り3(FukaJoho 更正前, FukaJoho 更正後) {
        return isRString変更(更正前.get境界層区分(), 更正後.get境界層区分())
                || isRString変更(更正前.get職権区分(), 更正後.get職権区分())
                || isLasdecCode変更(更正前.get賦課市町村コード(), 更正後.get賦課市町村コード())
                || isDecimal変更(更正前.get特徴歳出還付額(), 更正後.get特徴歳出還付額())
                || isDecimal変更(更正前.get普徴歳出還付額(), 更正後.get普徴歳出還付額())
                || isYMDHMS変更(更正前.get調定日時(), 更正後.get調定日時())
                || isRString変更(更正前.get更正月(), 更正後.get更正月())
                || isInt変更(更正前.get徴収方法履歴番号(), 更正後.get徴収方法履歴番号())
                || isYMDHMS変更(更正前.get異動基準日時(), 更正後.get異動基準日時())
                || isDecimal変更(更正前.get特徴期別金額01(), 更正後.get特徴期別金額01())
                || isDecimal変更(更正前.get特徴期別金額02(), 更正後.get特徴期別金額02())
                || isDecimal変更(更正前.get特徴期別金額03(), 更正後.get特徴期別金額03())
                || isDecimal変更(更正前.get特徴期別金額04(), 更正後.get特徴期別金額04())
                || isDecimal変更(更正前.get特徴期別金額05(), 更正後.get特徴期別金額05())
                || isDecimal変更(更正前.get特徴期別金額06(), 更正後.get特徴期別金額06());
    }

    private boolean is変化有り4(FukaJoho 更正前, FukaJoho 更正後) {
        return isDecimal変更(更正前.get普徴期別金額01(), 更正後.get普徴期別金額01())
                || isDecimal変更(更正前.get普徴期別金額02(), 更正後.get普徴期別金額02())
                || isDecimal変更(更正前.get普徴期別金額03(), 更正後.get普徴期別金額03())
                || isDecimal変更(更正前.get普徴期別金額04(), 更正後.get普徴期別金額04())
                || isDecimal変更(更正前.get普徴期別金額05(), 更正後.get普徴期別金額05())
                || isDecimal変更(更正前.get普徴期別金額06(), 更正後.get普徴期別金額06())
                || isDecimal変更(更正前.get普徴期別金額07(), 更正後.get普徴期別金額07())
                || isDecimal変更(更正前.get普徴期別金額08(), 更正後.get普徴期別金額08())
                || isDecimal変更(更正前.get普徴期別金額09(), 更正後.get普徴期別金額09())
                || isDecimal変更(更正前.get普徴期別金額10(), 更正後.get普徴期別金額10())
                || isDecimal変更(更正前.get普徴期別金額11(), 更正後.get普徴期別金額11())
                || isDecimal変更(更正前.get普徴期別金額12(), 更正後.get普徴期別金額12())
                || isDecimal変更(更正前.get普徴期別金額13(), 更正後.get普徴期別金額13())
                || isDecimal変更(更正前.get普徴期別金額14(), 更正後.get普徴期別金額14());
    }

    private boolean isTsuchishoNo変更(TsuchishoNo 更正前, TsuchishoNo 更正後) {
        if (更正前 == null) {
            更正前 = TsuchishoNo.EMPTY;
        }
        if (更正後 == null) {
            更正後 = TsuchishoNo.EMPTY;
        }
        return !更正後.equals(更正前);
    }

    private boolean isHihokenshaNo変更(HihokenshaNo 更正前, HihokenshaNo 更正後) {
        if (更正前 == null) {
            更正前 = HihokenshaNo.EMPTY;
        }
        if (更正後 == null) {
            更正後 = HihokenshaNo.EMPTY;
        }
        return !更正後.equals(更正前);
    }

    private boolean isShikibetsuCode変更(ShikibetsuCode 更正前, ShikibetsuCode 更正後) {
        if (更正前 == null) {
            更正前 = ShikibetsuCode.EMPTY;
        }
        if (更正後 == null) {
            更正後 = ShikibetsuCode.EMPTY;
        }
        return !更正後.equals(更正前);
    }

    private boolean isSetaiCode変更(SetaiCode 更正前, SetaiCode 更正後) {
        if (更正前 == null) {
            更正前 = SetaiCode.EMPTY;
        }
        if (更正後 == null) {
            更正後 = SetaiCode.EMPTY;
        }
        return !更正後.equals(更正前);
    }

    private boolean isInt変更(int 更正前, int 更正後) {
        return 更正前 != 更正後;
    }

    private boolean isFlexibleDate変更(FlexibleDate 更正前, FlexibleDate 更正後) {
        if (更正前 == null) {
            更正前 = FlexibleDate.EMPTY;
        }
        if (更正後 == null) {
            更正後 = FlexibleDate.EMPTY;
        }
        return !更正後.equals(更正前);
    }

    private boolean isRString変更(RString 更正前, RString 更正後) {
        if (更正前 == null) {
            更正前 = RString.EMPTY;
        }
        if (更正後 == null) {
            更正後 = RString.EMPTY;
        }
        return !更正後.equals(更正前);
    }

    private boolean isFlexibleYearMonth変更(FlexibleYearMonth 更正前, FlexibleYearMonth 更正後) {
        if (更正前 == null) {
            更正前 = FlexibleYearMonth.EMPTY;
        }
        if (更正後 == null) {
            更正後 = FlexibleYearMonth.EMPTY;
        }
        return !更正後.equals(更正前);
    }

    private boolean isLasdecCode変更(LasdecCode 更正前, LasdecCode 更正後) {
        if (更正前 == null) {
            更正前 = LasdecCode.EMPTY;
        }
        if (更正後 == null) {
            更正後 = LasdecCode.EMPTY;
        }
        return !更正後.equals(更正前);
    }

    private boolean isYMDHMS変更(YMDHMS 更正前, YMDHMS 更正後) {
        if (更正後 != null && !更正後.isEmpty()
                && !更正後.equals(更正前)) {
            return true;
        } else if ((更正後 == null || 更正後.isEmpty())
                && 更正前 != null && !更正前.isEmpty()) {
            return true;
        }
        return false;
    }

    private boolean isDecimal変更(Decimal 更正前, Decimal 更正後) {
        if (更正前 == null) {
            更正前 = Decimal.ZERO;
        }
        if (更正後 == null) {
            更正後 = Decimal.ZERO;
        }
        return !更正後.equals(更正前);
    }

    private void 賦課エラー登録処理(FukaJoho 賦課の情報_設定後, FlexibleYear 賦課年度, Code エラーコード) {
        DbT2010FukaErrorListEntity errorListEntity = new DbT2010FukaErrorListEntity();
        errorListEntity.setSubGyomuCode(SubGyomuCode.DBB介護賦課);
        errorListEntity.setInternalReportId(内部帳票ID);
        errorListEntity.setFukaNendo(賦課年度);
        errorListEntity.setTsuchishoNo(賦課の情報_設定後.get通知書番号());
        errorListEntity.setInternalReportCreationDateTime(賦課の情報_設定後.get調定日時() == null
                || 賦課の情報_設定後.get調定日時().isEmpty() ? null : 賦課の情報_設定後.get調定日時().getRDateTime());
        errorListEntity.setBatchId(バッチID);
        errorListEntity.setBatchStartingDateTime(RDate.getNowDateTime());
        errorListEntity.setHihokenshaNo(賦課の情報_設定後.get被保険者番号());
        errorListEntity.setShikibetsuCode(賦課の情報_設定後.get識別コード());
        errorListEntity.setErrorCode(エラーコード);
        errorListEntity.setShikakuShutokuYMD(賦課の情報_設定後.get資格取得日());
        errorListEntity.setShikakuShutokuJiyu(賦課の情報_設定後.get資格取得事由());
        errorListEntity.setShikakuSoshitsuYMD(賦課の情報_設定後.get資格喪失日());
        errorListEntity.setShikakuSoshitsuJiyu(賦課の情報_設定後.get資格喪失事由());
        errorListEntity.setState(EntityDataState.Added);
        賦課エラーDac.save(errorListEntity);
    }

    /**
     * 調定計算と調定事由メソッドです
     *
     * @param 賦課情報リスト List<FukaJoho>
     * @param 徴収方法情報 ChoshuHoho
     * @param 調定年度 FlexibleYear
     * @param 調定日時 YMDHMS
     * @return FukaJohoToChoshuHoho 更正後の賦課の情報と徴収方法の情報
     */
    public FukaJohoToChoshuHoho caluculateChotei(List<FukaJoho> 賦課情報リスト,
            ChoshuHoho 徴収方法情報, FlexibleYear 調定年度, YMDHMS 調定日時) {
        // TODO ビジネス設計_DBBBZ00002_過年度更正計算 を実装完了しない。使用しないのパラメータ。
        調定年度 = new FlexibleYear(調定日時.getYear().toString());
        if (調定年度 == null) {
            throw new ApplicationException(UrErrorMessages.入力値が不正.getMessage());
        }
        KoseigoFukaResult 調定計算Result = new KoseigoFukaResult(賦課情報リスト, 徴収方法情報);
        FukaJoho 入力_現年度 = get賦課情報_現年度(賦課情報リスト);
        List<FukaJoho> 調定計算_賦課リスト = 調定計算Result.get賦課の情報リスト();
        FukaJoho 更正後_現年度 = get賦課情報_現年度(調定計算_賦課リスト);
        Decimal 更正後_年額 = get減免前介護保険料_年額(更正後_現年度);
        Decimal 更正前_年額 = get減免前介護保険料_年額(入力_現年度);
        ChoteiJiyuParameter parameter = new ChoteiJiyuParameter();
        FukaJohoList 更正後賦課 = new FukaJohoList();
        List<FukaJohoList> 更正後賦課List = new ArrayList<>();
        更正後賦課.set現年度(更正後_現年度);
        parameter.set更正前徴収方法(徴収方法情報);
        parameter.set更正後徴収方法(調定計算Result.getChoshuHoho());
        parameter.set現年度(入力_現年度);
        FukaJoho 更正後_過年度 = get賦課情報_過年度(調定計算_賦課リスト);
        FukaJoho 更正前_過年度 = null;
        if (更正後_過年度 != null && 賦課情報リスト != null && !賦課情報リスト.isEmpty()) {
            for (FukaJoho 賦課情報 : 賦課情報リスト) {
                if (更正後_過年度.get調定年度().equals(賦課情報.get調定年度())) {
                    更正前_過年度 = 賦課情報;
                }
            }
        }
        if ((更正後_年額 == null && 更正前_年額 != null && Decimal.ZERO.compareTo(更正前_年額) < ゼロ_定値)
                || (更正前_年額 != null && 更正後_年額 != null && 更正後_年額.compareTo(更正前_年額) < ゼロ_定値)) {
            更正後賦課.set過年度(更正後_過年度);
            更正後賦課List.add(更正後賦課);
            parameter.set更正後賦課リスト(更正後賦課List);
            parameter.set過年度(更正前_過年度);
        } else {
            更正後賦課List.add(更正後賦課);
            parameter.set更正後賦課リスト(更正後賦課List);
        }

        List<FukaJohoList> 調定事由 = ChoteiJiyuHantei.createInstance().set調定事由(parameter);
        FukaJohoToChoshuHoho 更正result = new FukaJohoToChoshuHoho();
        更正result.set徴収方法の情報(調定計算Result.getChoshuHoho());
        List<FukaJoho> 賦課情報 = new ArrayList<>();
        for (FukaJohoList entity : 調定事由) {
            賦課情報.add(entity.get現年度());
            賦課情報.add(entity.get過年度());
        }
        更正result.set賦課情報(賦課情報);
        return 更正result;
    }

    private Decimal get減免前介護保険料_年額(FukaJoho 賦課情報) {
        if (賦課情報 == null) {
            return null;
        }
        return 賦課情報.get減免前介護保険料_年額();
    }

    private FukaJoho get賦課情報_過年度(List<FukaJoho> 賦課情報リスト) {
        if (賦課情報リスト == null) {
            return null;
        }
        FukaJoho 過年度 = null;
        for (FukaJoho 賦課情報 : 賦課情報リスト) {
            if (賦課情報.get賦課年度().isBefore(賦課情報.get調定年度())) {
                過年度 = 過年度 == null ? 賦課情報 : (過年度.get調定年度().isBefore(賦課情報.get調定年度()) ? 賦課情報 : 過年度);
            }
        }
        return 過年度;
    }

    private FukaJoho get賦課情報_現年度(List<FukaJoho> 賦課情報リスト) {
        if (賦課情報リスト == null) {
            return null;
        }
        for (FukaJoho 賦課情報 : 賦課情報リスト) {
            if (賦課情報.get賦課年度().equals(賦課情報.get調定年度())) {
                return 賦課情報;
            }
        }
        return null;
    }

    /**
     * 計算後情報から本算定異動（過年度）結果一覧表を、帳票とＣＳＶファイルで作成する。
     *
     * @param parameter KanendoFukaParameter
     */
    public void spoolKanendoIdoKekkaIchiran(KanendoFukaParameter parameter) {
        FlexibleYear 調定年度 = parameter.get調定年度();
        YMDHMS 調定日時 = parameter.getシステム日時();
        Long 出力順ID = parameter.get出力順ID();
        YMDHMS 抽出開始日時 = new YMDHMS(parameter.get抽出開始日時().toString());
        YMDHMS 抽出終了日時 = new YMDHMS(parameter.get抽出終了日時().toString());
        IOutputOrder outputOrder = ChohyoShutsuryokujunFinderFactory.createInstance().get出力順(SubGyomuCode.DBB介護賦課, 帳票ID, 出力順ID);
        IHonSanteiIdoKanendoFukaMapper mapper = mapperProvider.create(IHonSanteiIdoKanendoFukaMapper.class);

        RString 出力順 = MyBatisOrderByClauseCreator.create(DBB200009ShutsuryokujunEnum.class, outputOrder);
        KozaSearchKeyBuilder kozabuilder = new KozaSearchKeyBuilder();
        kozabuilder.set業務コード(GyomuCode.DB介護保険);
        kozabuilder.set用途区分(new KozaYotoKubunCodeValue(CODE_0));
        kozabuilder.set基準日(new FlexibleDate(調定日時.getDate().toString()));
        IKozaSearchKey kozaSearchKey = kozabuilder.build();
        ShunoKamokuAuthority sut = InstanceProvider.create(ShunoKamokuAuthority.class);
        List<KamokuCode> list = sut.get更新権限科目コード(ControlDataHolder.getUserId());
        int 日付関連_年度サイクル = Integer.valueOf(DbBusinessConfig.get(
                ConfigNameDBB.日付関連_年度サイクル, RDate.getNowDate(), SubGyomuCode.DBB介護賦課).toString());
        KeisangojohoToKozaParameter param = KeisangojohoToKozaParameter
                .createSelectByKeyParam(調定年度, 調定日時, 出力順, kozaSearchKey, list, 日付関連_年度サイクル);
        List<KeisangojohoToKozaEntity> 本算定計算後賦課情報リスト = mapper.select計算後情報と宛名と口座(param);

        List<KeisangojohoAtenaKozaEntity> 計算後情報_宛名_口座List = new ArrayList<>();
        List<KeisangojohoAtenaKozaEntity> 計算後情報_宛名_口座_更正前List = new ArrayList<>();
        List<KeisangojohoAtenaKozaEntity> 計算後情報_宛名_口座_更正後List = new ArrayList<>();
        for (KeisangojohoToKozaEntity entity : 本算定計算後賦課情報リスト) {
            KeisangojohoAtenaKozaEntity 計算後情報_宛名_口座Entity = setKeisangojohoAtenaKozaEntity(entity);
            計算後情報_宛名_口座List.add(計算後情報_宛名_口座Entity);
            RString 更正前後区分 = entity.get計算後情報().getKoseiZengoKubun();
            if (定値_イチ.equals(更正前後区分)) {
                計算後情報_宛名_口座_更正前List.add(計算後情報_宛名_口座Entity);
            } else if (定値_二.equals(更正前後区分)) {
                計算後情報_宛名_口座_更正後List.add(計算後情報_宛名_口座Entity);
            }
        }
        KitsukiList 法定納期までの期月リスト = get法定納期までの期月リスト();
        publish本算定結果一覧表(調定日時, 計算後情報_宛名_口座List, 法定納期までの期月リスト);
        List<KeisangojohoAtenaKozaKouseizengoEntity> 更正前後EntityList = new ArrayList<>();
        for (KeisangojohoAtenaKozaEntity entity_更正後 : 計算後情報_宛名_口座_更正後List) {
            boolean has更正前 = false;
            for (KeisangojohoAtenaKozaEntity entity_更正前 : 計算後情報_宛名_口座_更正前List) {
                if (entity_更正後.get通知書番号().equals(entity_更正前.get通知書番号())) {
                    KeisangojohoAtenaKozaKouseizengoEntity 更正前後Entity
                            = new KeisangojohoAtenaKozaKouseizengoEntity(entity_更正前, entity_更正後);
                    更正前後EntityList.add(更正前後Entity);
                    has更正前 = true;
                    break;
                }
            }
            if (!has更正前) {
                KeisangojohoAtenaKozaKouseizengoEntity 更正前後Entity
                        = new KeisangojohoAtenaKozaKouseizengoEntity(null, entity_更正後);
                更正前後EntityList.add(更正前後Entity);
            }
        }
        SourceDataCollection sourceDataCollection
                = new KanendoIdouKekkaIchiranPrintService().printTaitsu(更正前後EntityList, new RString(出力順ID), 調定日時);
        RString 出力ページ数 = sourceDataCollection == null ? 定値_ゼロ : new RString(sourceDataCollection.iterator().next().getPageCount());
        load出力条件リスト(調定年度, 抽出開始日時, 抽出終了日時, outputOrder, 帳票名, 出力ページ数);
    }

    private void load出力条件リスト(FlexibleYear 調定年度,
            YMDHMS 抽出開始日時, YMDHMS 抽出終了日時, IOutputOrder outputOrder, RString 帳票名称, RString 出力ページ数) {
        List<RString> 出力条件リスト = new ArrayList<>();
        RStringBuilder builder = new RStringBuilder();
        builder.append((FORMAT_LEFT).concat(定値_調定年度).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE)
                .concat(調定年度.wareki().toDateString()));
        出力条件リスト.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append((FORMAT_LEFT).concat(定値_抽出開始日時).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE)
                .concat(抽出開始日時.getDate().wareki().toDateString()).concat(RString.FULL_SPACE)
                .concat(抽出開始日時.getRDateTime().getTime().toFormattedTimeString(DisplayTimeFormat.HH_mm_ss)));
        出力条件リスト.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append((FORMAT_LEFT).concat(定値_抽出終了日時).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE)
                .concat(抽出終了日時.getDate().wareki().toDateString()).concat(RString.FULL_SPACE)
                .concat(抽出終了日時.getRDateTime().getTime().toFormattedTimeString(DisplayTimeFormat.HH_mm_ss)));
        出力条件リスト.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append((FORMAT_LEFT).concat(定値_帳票名称).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE).concat(帳票名称));
        出力条件リスト.add(builder.toRString());
        RStringBuilder builder_改頁項目名 = new RStringBuilder();
        RStringBuilder builder_出力順項目名 = new RStringBuilder();
        builder_改頁項目名.append((FORMAT_LEFT).concat(定値_改頁項目名).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE));
        builder_出力順項目名.append((FORMAT_LEFT).concat(定値_出力順項目名).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE));
        if (outputOrder != null) {
            List<ISetSortItem> iSetSortItemList = outputOrder.get設定項目リスト();
            for (ISetSortItem iSetSortItem : iSetSortItemList) {
                builder_出力順項目名.append(iSetSortItem.get項目名()).append(SIGN);
                if (iSetSortItem.is改頁項目()) {
                    builder_改頁項目名.append(iSetSortItem.get項目名()).append(SIGN);
                }
            }
        }
        RString 改頁項目名 = builder_改頁項目名.toRString();
        RString 出力順項目名 = builder_出力順項目名.toRString();
        if (改頁項目名.contains(SIGN)) {
            改頁項目名 = 改頁項目名.substring(ゼロ_定値, 改頁項目名.length() - SIGN.length());
        }
        if (出力順項目名.contains(SIGN)) {
            出力順項目名 = 出力順項目名.substring(ゼロ_定値, 出力順項目名.length() - SIGN.length());
        }
        出力条件リスト.add(改頁項目名);
        出力条件リスト.add(出力順項目名);

        Association association = AssociationFinderFactory.createInstance().getAssociation();
        RString 導入団体コード = association.getLasdecCode_().value();
        RString 市町村名 = association.get市町村名();

        ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                帳票ID.getColumnValue(),
                導入団体コード,
                市町村名,
                RString.FULL_SPACE.concat(String.valueOf(JobContextHolder.getJobId())),
                帳票名,
                出力ページ数,
                CSV出力有無,
                CSVファイル名,
                出力条件リスト);
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(reportOutputJokenhyoItem);
        printer.print();
    }

    private void publish本算定結果一覧表(YMDHMS 調定日時,
            List<KeisangojohoAtenaKozaEntity> 計算後情報_宛名_口座List,
            KitsukiList 法定納期までの期月リスト) {
        List<RString> headList = publish本算定結果一覧表_headList();

        FileSpoolManager manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther,
                EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        RString eucFilePath = Path.combinePath(spoolWorkPath, EUCファイル名);
        try (CsvListWriter csvListWriter = new CsvListWriter.InstanceBuilder(eucFilePath).setNewLine(NewLine.CRLF)
                .setDelimiter(カンマ)
                .setEnclosure(EUC_WRITER_ENCLOSURE)
                .setEncode(Encode.UTF_8withBOM)
                .hasHeader(true)
                .setHeader(headList)
                .build()) {
            for (KeisangojohoAtenaKozaEntity 計算後情報_宛名_口座Entity : 計算後情報_宛名_口座List) {

                List<RString> 月別所得段階リスト = get月別所得段階リスト(計算後情報_宛名_口座Entity);
                RString 口座種類 = get口座種類(計算後情報_宛名_口座Entity);
                List<Decimal> 普徴額リスト = 普徴額の編集(法定納期までの期月リスト, 計算後情報_宛名_口座Entity);
                RString 住所 = get住所(計算後情報_宛名_口座Entity);

                List<RString> bodyList = new ArrayList<>();
                UaT0310KozaEntity 口座Entity = 計算後情報_宛名_口座Entity.get口座Entity() == null
                        ? null : 計算後情報_宛名_口座Entity.get口座Entity().getUaT0310KozaEntity();
                RString 作成年月日 = 調定日時.getRDateTime().getDate().seireki()
                        .separator(Separator.SLASH).fillType(FillType.BLANK).toDateString();
                RString 作成日時 = 調定日時.getRDateTime().getTime().toFormattedTimeString(DisplayTimeFormat.HH_mm_ss);
                bodyList.add(作成年月日);
                bodyList.add(作成日時);
                bodyList.add(計算後情報_宛名_口座Entity.get通知書番号().getColumnValue());
                AtenaMeisho 氏名 = 計算後情報_宛名_口座Entity.get宛名Entity().getKanjiShimei();
                if (氏名 == null || 氏名.isEmpty()) {
                    bodyList.add(空);
                } else {
                    bodyList.add(氏名.getColumnValue());
                }
                bodyList.add(住所);
                KinyuKikanCode 金融機関コード = 口座Entity == null ? null : 口座Entity.getKinyuKikanCode();
                if (金融機関コード != null && !金融機関コード.isEmpty()) {
                    bodyList.add(金融機関コード.getColumnValue());
                } else {
                    bodyList.add(空);
                }
                bodyList.add(口座種類);
                bodyList.add(口座Entity == null ? null : 口座Entity.getKozaNo());
                bodyList.add(計算後情報_宛名_口座Entity.get調定年度().toDateString());
                bodyList.add(計算後情報_宛名_口座Entity.get賦課年度().toDateString());
                bodyList.add(formatDecimal(計算後情報_宛名_口座Entity.get確定介護保険料_年額()));
                bodyList.add(formatDecimal(計算後情報_宛名_口座Entity.get減免前介護保険料_年額()));
                bodyList.add(formatDecimal(計算後情報_宛名_口座Entity.get減免額()));
                bodyList.add(get表記(月別所得段階リスト.get(ゼロ_定値)));
                bodyList.add(get表記(月別所得段階リスト.get(イチ_定値)));
                bodyList.add(get表記(月別所得段階リスト.get(二_定値)));
                bodyList.add(get表記(月別所得段階リスト.get(ミ_定値)));
                bodyList.add(get表記(月別所得段階リスト.get(ヨ_定値)));
                bodyList.add(get表記(月別所得段階リスト.get(ゴ_定値)));
                bodyList.add(get表記(月別所得段階リスト.get(ロク_定値)));
                bodyList.add(get表記(月別所得段階リスト.get(ナナ_定値)));
                bodyList.add(get表記(月別所得段階リスト.get(ハチ_定値)));
                bodyList.add(get表記(月別所得段階リスト.get(キュウ_定値)));
                bodyList.add(get表記(月別所得段階リスト.get(ジュウ_定値)));
                bodyList.add(get表記(月別所得段階リスト.get(ジュウイチ_定値)));
                bodyList.add(formatDecimal(計算後情報_宛名_口座Entity.get特徴歳出還付額()));
                bodyList.add(formatDecimal(計算後情報_宛名_口座Entity.get普徴歳出還付額()));
                List<KinyuKikanEntity> 金融機関EntityList = 計算後情報_宛名_口座Entity.get口座Entity() == null
                        ? null : 計算後情報_宛名_口座Entity.get口座Entity().getKinyuKikanEntity();
                if (金融機関EntityList != null && !金融機関EntityList.isEmpty() && 金融機関EntityList.get(ゼロ_定値).get金融機関Entity() != null) {
                    bodyList.add(金融機関EntityList.get(ゼロ_定値).get金融機関Entity().getName());
                } else {
                    bodyList.add(空);
                }
                AtenaKanaMeisho 口座名義人 = 口座Entity == null ? null : 口座Entity.getKozaMeiginin();
                if (口座名義人 != null && !口座名義人.isEmpty()) {
                    bodyList.add(口座名義人.getColumnValue());
                } else {
                    bodyList.add(空);
                }
                bodyList.add(作成年月日);
                bodyList.add(formatDecimal(計算後情報_宛名_口座Entity.get特徴期別金額01()));
                bodyList.add(formatDecimal(計算後情報_宛名_口座Entity.get特徴期別金額02()));
                bodyList.add(formatDecimal(計算後情報_宛名_口座Entity.get特徴期別金額03()));
                bodyList.add(formatDecimal(計算後情報_宛名_口座Entity.get特徴期別金額04()));
                bodyList.add(formatDecimal(計算後情報_宛名_口座Entity.get特徴期別金額05()));
                bodyList.add(formatDecimal(計算後情報_宛名_口座Entity.get特徴期別金額06()));
                for (Decimal 普徴期別金額 : 普徴額リスト) {
                    bodyList.add(formatDecimal(普徴期別金額));
                }
                bodyList.add(get調定事由(計算後情報_宛名_口座Entity));
                toBodyList(bodyList);
                csvListWriter.writeLine(bodyList);
            }
            csvListWriter.close();
        }
    }

    private RString get調定事由(KeisangojohoAtenaKozaEntity entity) {
        RStringBuilder 調定事由builder = new RStringBuilder();
        RString 調定事由1 = entity.get調定事由1();
        RString 調定事由2 = entity.get調定事由2();
        RString 調定事由3 = entity.get調定事由3();
        RString 調定事由4 = entity.get調定事由4();
        調定事由builder.append(調定事由1 == null ? 空 : 調定事由1);
        調定事由builder.append(調定事由2 == null || 調定事由2.isEmpty() ? 空 : RString.HALF_SPACE.concat(調定事由2));
        調定事由builder.append(調定事由3 == null || 調定事由3.isEmpty() ? 空 : RString.HALF_SPACE.concat(調定事由3));
        調定事由builder.append(調定事由4 == null || 調定事由4.isEmpty() ? 空 : RString.HALF_SPACE.concat(調定事由4));
        return 調定事由builder.toRString().trimStart();
    }

    private void toBodyList(List<RString> bodyList) {
        for (int i = ゼロ_定値; i < bodyList.size(); i++) {
            if (bodyList.get(i) == null) {
                bodyList.remove(bodyList.get(i));
                bodyList.add(i, RString.EMPTY);
            }
        }
    }

    private RString get表記(RString 月別所得段階) {
        if (月別所得段階 == null || 月別所得段階.isEmpty()) {
            return 空;
        } else {
            return HokenryoDankaiSettings.createInstance().getCurrent保険料段階List().getBy段階区分(月別所得段階).get表記();
        }
    }

    private RString formatDecimal(Decimal 金額) {
        if (金額 == null) {
            return 空;
        }
        return DecimalFormatter.toコンマ区切りRString(金額, 0);
    }

    private List<RString> publish本算定結果一覧表_headList() {
        List<RString> headList = new ArrayList<>();
        headList.add(タイトル_作成年月日);
        headList.add(タイトル_作成時刻);
        headList.add(タイトル_通知書番号);
        headList.add(タイトル_氏名);
        headList.add(タイトル_住所);
        headList.add(タイトル_金融機関コード);
        headList.add(タイトル_種類);
        headList.add(タイトル_口座番号);
        headList.add(タイトル_調定年度);
        headList.add(タイトル_賦課年度);
        headList.add(タイトル_確定保険料額);
        headList.add(タイトル_計算上保険料額);
        headList.add(タイトル_減免額);
        headList.add(タイトル_月別取得段階4月);
        headList.add(タイトル_月別取得段階5月);
        headList.add(タイトル_月別取得段階6月);
        headList.add(タイトル_月別取得段階7月);
        headList.add(タイトル_月別取得段階8月);
        headList.add(タイトル_月別取得段階9月);
        headList.add(タイトル_月別取得段階10月);
        headList.add(タイトル_月別取得段階11月);
        headList.add(タイトル_月別取得段階12月);
        headList.add(タイトル_月別取得段階1月);
        headList.add(タイトル_月別取得段階2月);
        headList.add(タイトル_月別取得段階3月);
        headList.add(タイトル_歳出還付額_特);
        headList.add(タイトル_歳出還付額_普);
        headList.add(タイトル_金融機関名称);
        headList.add(タイトル_口座名義人);
        headList.add(タイトル_調定年月日);
        headList.add(タイトル_特徴額１期);
        headList.add(タイトル_特徴額２期);
        headList.add(タイトル_特徴額３期);
        headList.add(タイトル_特徴額４期);
        headList.add(タイトル_特徴額５期);
        headList.add(タイトル_特徴額６期);
        headList.add(タイトル_普徴額1期);
        headList.add(タイトル_普徴額2期);
        headList.add(タイトル_普徴額3期);
        headList.add(タイトル_普徴額4期);
        headList.add(タイトル_普徴額5期);
        headList.add(タイトル_普徴額6期);
        headList.add(タイトル_普徴額7期);
        headList.add(タイトル_普徴額8期);
        headList.add(タイトル_普徴額9期);
        headList.add(タイトル_普徴額10期);
        headList.add(タイトル_普徴額11期);
        headList.add(タイトル_普徴額12期);
        headList.add(タイトル_普徴額13期);
        headList.add(タイトル_普徴額14期);
        headList.add(タイトル_調定事由);
        return headList;
    }

    private RString get住所(KeisangojohoAtenaKozaEntity 計算後情報_宛名_口座Entity) {
        IKojin 宛名情報 = ShikibetsuTaishoFactory.createKojin(計算後情報_宛名_口座Entity.get宛名Entity());
        DbT7065ChohyoSeigyoKyotsuEntity entity = 帳票制御共通Dac.selectByKey(SubGyomuCode.DBB介護賦課, 帳票分類ID);
        ChohyoSeigyoKyotsu 帳票制御共通 = new ChohyoSeigyoKyotsu(entity);
        return JushoHenshu.editJusho(帳票制御共通, 宛名情報, AssociationFinderFactory.createInstance().getAssociation());
    }

    private List<Decimal> 普徴額の編集(KitsukiList 法定納期までの期月リスト, KeisangojohoAtenaKozaEntity 計算後情報_宛名_口座_更正前Entity) {
        List<Decimal> 普徴額List = new普徴額リスト();
        List<Kitsuki> 期月リスト = 法定納期までの期月リスト.toList();
        for (Kitsuki 期月 : 期月リスト) {
            int 期 = 期月.get期AsInt();
            switch (期) {
                case イチ_定値:
                    普徴額List.set(ゼロ_定値, 計算後情報_宛名_口座_更正前Entity.get普徴期別金額01());
                    break;
                case 二_定値:
                    普徴額List.set(イチ_定値, 計算後情報_宛名_口座_更正前Entity.get普徴期別金額02());
                    break;
                case ミ_定値:
                    普徴額List.set(二_定値, 計算後情報_宛名_口座_更正前Entity.get普徴期別金額03());
                    break;
                case ヨ_定値:
                    普徴額List.set(ミ_定値, 計算後情報_宛名_口座_更正前Entity.get普徴期別金額04());
                    break;
                case ゴ_定値:
                    普徴額List.set(ヨ_定値, 計算後情報_宛名_口座_更正前Entity.get普徴期別金額05());
                    break;
                case ロク_定値:
                    普徴額List.set(ゴ_定値, 計算後情報_宛名_口座_更正前Entity.get普徴期別金額06());
                    break;
                case ナナ_定値:
                    普徴額List.set(ロク_定値, 計算後情報_宛名_口座_更正前Entity.get普徴期別金額07());
                    break;
                case ハチ_定値:
                    普徴額List.set(ナナ_定値, 計算後情報_宛名_口座_更正前Entity.get普徴期別金額08());
                    break;
                case キュウ_定値:
                    普徴額List.set(ハチ_定値, 計算後情報_宛名_口座_更正前Entity.get普徴期別金額09());
                    break;
                case ジュウ_定値:
                    普徴額List.set(キュウ_定値, 計算後情報_宛名_口座_更正前Entity.get普徴期別金額10());
                    break;
                case ジュウイチ_定値:
                    普徴額List.set(ジュウ_定値, 計算後情報_宛名_口座_更正前Entity.get普徴期別金額11());
                    break;
                case ジュウ二_定値:
                    普徴額List.set(ジュウイチ_定値, 計算後情報_宛名_口座_更正前Entity.get普徴期別金額12());
                    break;
                case ジュウミ_定値:
                    普徴額List.set(ジュウ二_定値, 計算後情報_宛名_口座_更正前Entity.get普徴期別金額13());
                    break;
                case ジュウヨ_定値:
                    普徴額List.set(ジュウミ_定値, 計算後情報_宛名_口座_更正前Entity.get普徴期別金額14());
                    break;
                default:
                    break;
            }
        }
        return 普徴額List;
    }

    private KitsukiList get法定納期までの期月リスト() {
        FuchoKiUtil 月期対応取得_普徴 = new FuchoKiUtil();
        int 最終法定納期 = 月期対応取得_普徴.get期月リスト().get最終法定納期().get期AsInt();
        return 月期対応取得_普徴.get期月リスト().subListBy期(イチ_定値, 最終法定納期);
    }

    private RString get口座種類(KeisangojohoAtenaKozaEntity 計算後情報_宛名_口座_更正前Entity) {
        KozaRelateEntity releteEntity = 計算後情報_宛名_口座_更正前Entity.get口座Entity();
        if (releteEntity == null) {
            return 空;
        }
        IKoza koza = new Koza(releteEntity);
        RString 口座種類 = koza.get預金種別().get預金種別略称();
        if (口座種類 != null && イチ_定値 < 口座種類.length()) {
            return 口座種類.substring(ゼロ_定値, 二_定値);
        }
        return 口座種類;
    }

    private List<RString> get月別所得段階リスト(KeisangojohoAtenaKozaEntity 計算後情報_宛名_口座_Entity) {
        List<RString> 月別所得段階リスト = new月別所得段階リスト();
        FlexibleYearMonth 月割開始年月1 = 計算後情報_宛名_口座_Entity.get月割開始年月1();
        FlexibleYearMonth 月割終了年月1 = 計算後情報_宛名_口座_Entity.get月割終了年月1();
        RString 保険料算定段階1 = 計算後情報_宛名_口座_Entity.get保険料算定段階1();
        if (月割開始年月1 != null && !月割開始年月1.isEmpty() && 月割終了年月1 != null
                && !月割終了年月1.isEmpty() && 保険料算定段階1 != null && !保険料算定段階1.isEmpty()) {
            int 開始年月1 = 月割開始年月1.getMonthValue();
            int 終了年月1 = 月割終了年月1.getMonthValue();
            for (int i = 開始年月1; i <= (開始年月1 > 終了年月1 ? (終了年月1 + ジュウ二_定値) : 終了年月1); i++) {
                int index = i < ヨ_定値 ? i - イチ_定値 : i - ヨ_定値;
                月別所得段階リスト.set(index, 保険料算定段階1);
            }
        }
        FlexibleYearMonth 月割開始年月2 = 計算後情報_宛名_口座_Entity.get月割開始年月2();
        FlexibleYearMonth 月割終了年月2 = 計算後情報_宛名_口座_Entity.get月割終了年月2();
        RString 保険料算定段階2 = 計算後情報_宛名_口座_Entity.get保険料算定段階2();
        if (月割開始年月2 != null && !月割開始年月2.isEmpty() && 月割終了年月2 != null
                && !月割終了年月2.isEmpty() && 保険料算定段階2 != null && !保険料算定段階2.isEmpty()) {
            int 開始年月2 = 月割開始年月2.getMonthValue();
            int 終了年月2 = 月割終了年月2.getMonthValue();
            for (int i = 開始年月2; i <= (開始年月2 > 終了年月2 ? (終了年月2 + ジュウ二_定値) : 終了年月2); i++) {
                int index = i < ヨ_定値 ? i - イチ_定値 : i - ヨ_定値;
                月別所得段階リスト.set(index, 保険料算定段階2);
            }
        }
        return 月別所得段階リスト;
    }

    private List<Decimal> new普徴額リスト() {
        List<Decimal> 普徴額リスト = new ArrayList<>();
        for (int i = 0; i < ジュウヨ_定値; i++) {
            普徴額リスト.add(null);
        }
        return 普徴額リスト;
    }

    private List<RString> new月別所得段階リスト() {
        List<RString> 月別所得段階リスト = new ArrayList<>();
        for (int i = 0; i < ジュウ二_定値; i++) {
            月別所得段階リスト.add(空);
        }
        return 月別所得段階リスト;
    }

    private KeisangojohoAtenaKozaEntity setKeisangojohoAtenaKozaEntity(KeisangojohoToKozaEntity entity) {
        KeisangoJoho keisangoJoho = new KeisangoJoho(entity.get計算後情報());
        KeisangojohoAtenaKozaEntity atenaKozaEntity = new KeisangojohoAtenaKozaEntity();
        atenaKozaEntity.set調定年度(keisangoJoho.get調定年度());
        atenaKozaEntity.set賦課年度(keisangoJoho.get賦課年度());
        atenaKozaEntity.set通知書番号(keisangoJoho.get通知書番号());
        atenaKozaEntity.set更正前後区分(keisangoJoho.get更正前後区分());
        atenaKozaEntity.set作成処理名(keisangoJoho.get作成処理名());
        atenaKozaEntity.set賦課履歴番号(keisangoJoho.get賦課履歴番号());
        atenaKozaEntity.set被保険者番号(keisangoJoho.get被保険者番号());
        atenaKozaEntity.set識別コード(keisangoJoho.get識別コード());
        atenaKozaEntity.set世帯コード(keisangoJoho.get世帯コード());
        atenaKozaEntity.set世帯員数(keisangoJoho.get世帯員数());
        atenaKozaEntity.set資格取得日(keisangoJoho.get資格取得日());
        atenaKozaEntity.set資格取得事由(keisangoJoho.get資格取得事由());
        atenaKozaEntity.set資格喪失日(keisangoJoho.get資格喪失日());
        atenaKozaEntity.set資格喪失事由(keisangoJoho.get資格喪失事由());
        atenaKozaEntity.set生活保護扶助種類(keisangoJoho.get生活保護扶助種類());
        atenaKozaEntity.set生保開始日(keisangoJoho.get生保開始日());
        atenaKozaEntity.set生保廃止日(keisangoJoho.get生保廃止日());
        atenaKozaEntity.set老齢開始日(keisangoJoho.get老齢開始日());
        atenaKozaEntity.set老齢廃止日(keisangoJoho.get老齢廃止日());
        atenaKozaEntity.set賦課期日(keisangoJoho.get賦課期日());
        atenaKozaEntity.set課税区分(keisangoJoho.get課税区分());
        atenaKozaEntity.set世帯課税区分(keisangoJoho.get世帯課税区分());
        atenaKozaEntity.set合計所得金額(keisangoJoho.get合計所得金額());
        atenaKozaEntity.set公的年金収入額(keisangoJoho.get公的年金収入額());
        atenaKozaEntity.set保険料段階(keisangoJoho.get保険料段階());
        atenaKozaEntity.set保険料算定段階1(keisangoJoho.get保険料算定段階1());
        atenaKozaEntity.set算定年額保険料1(keisangoJoho.get算定年額保険料1());
        atenaKozaEntity.set月割開始年月1(keisangoJoho.get月割開始年月1());
        atenaKozaEntity.set月割終了年月1(keisangoJoho.get月割終了年月1());
        atenaKozaEntity.set保険料算定段階2(keisangoJoho.get保険料算定段階2());
        atenaKozaEntity.set算定年額保険料2(keisangoJoho.get算定年額保険料2());
        atenaKozaEntity.set月割開始年月2(keisangoJoho.get月割開始年月2());
        atenaKozaEntity.set月割終了年月2(keisangoJoho.get月割終了年月2());
        atenaKozaEntity.set調定日時(keisangoJoho.get調定日時());
        atenaKozaEntity.set調定事由1(keisangoJoho.get調定事由1());
        atenaKozaEntity.set調定事由2(keisangoJoho.get調定事由2());
        atenaKozaEntity.set調定事由3(keisangoJoho.get調定事由3());
        atenaKozaEntity.set調定事由4(keisangoJoho.get調定事由4());
        atenaKozaEntity.set更正月(keisangoJoho.get更正月());
        atenaKozaEntity.set減免前介護保険料_年額(keisangoJoho.get減免前介護保険料_年額());
        atenaKozaEntity.set減免額(keisangoJoho.get減免額());
        atenaKozaEntity.set確定介護保険料_年額(keisangoJoho.get確定介護保険料_年額());
        atenaKozaEntity.set保険料段階_仮算定時(keisangoJoho.get保険料段階_仮算定時());
        atenaKozaEntity.set徴収方法履歴番号(keisangoJoho.get徴収方法履歴番号());
        atenaKozaEntity.set異動基準日時(keisangoJoho.get異動基準日時());
        atenaKozaEntity.set口座区分(keisangoJoho.get口座区分());
        atenaKozaEntity.set境界層区分(keisangoJoho.get境界層区分());
        atenaKozaEntity.set職権区分(keisangoJoho.get職権区分());
        atenaKozaEntity.set賦課市町村コード(keisangoJoho.get賦課市町村コード());
        atenaKozaEntity.set特徴歳出還付額(keisangoJoho.get特徴歳出還付額());
        atenaKozaEntity.set普徴歳出還付額(keisangoJoho.get普徴歳出還付額());
        atenaKozaEntity.set特徴期別金額01(keisangoJoho.get特徴期別金額01());
        atenaKozaEntity.set特徴期別金額02(keisangoJoho.get特徴期別金額02());
        atenaKozaEntity.set特徴期別金額03(keisangoJoho.get特徴期別金額03());
        atenaKozaEntity.set特徴期別金額04(keisangoJoho.get特徴期別金額04());
        atenaKozaEntity.set特徴期別金額05(keisangoJoho.get特徴期別金額05());
        atenaKozaEntity.set特徴期別金額06(keisangoJoho.get特徴期別金額06());
        atenaKozaEntity.set普徴期別金額01(keisangoJoho.get普徴期別金額01());
        atenaKozaEntity.set普徴期別金額02(keisangoJoho.get普徴期別金額02());
        atenaKozaEntity.set普徴期別金額03(keisangoJoho.get普徴期別金額03());
        atenaKozaEntity.set普徴期別金額04(keisangoJoho.get普徴期別金額04());
        atenaKozaEntity.set普徴期別金額05(keisangoJoho.get普徴期別金額05());
        atenaKozaEntity.set普徴期別金額06(keisangoJoho.get普徴期別金額06());
        atenaKozaEntity.set普徴期別金額07(keisangoJoho.get普徴期別金額07());
        atenaKozaEntity.set普徴期別金額08(keisangoJoho.get普徴期別金額08());
        atenaKozaEntity.set普徴期別金額09(keisangoJoho.get普徴期別金額09());
        atenaKozaEntity.set普徴期別金額10(keisangoJoho.get普徴期別金額10());
        atenaKozaEntity.set普徴期別金額11(keisangoJoho.get普徴期別金額11());
        atenaKozaEntity.set普徴期別金額12(keisangoJoho.get普徴期別金額12());
        atenaKozaEntity.set普徴期別金額13(keisangoJoho.get普徴期別金額13());
        atenaKozaEntity.set普徴期別金額14(keisangoJoho.get普徴期別金額14());
        atenaKozaEntity.set徴収方法4月(keisangoJoho.get徴収方法4月());
        atenaKozaEntity.set徴収方法5月(keisangoJoho.get徴収方法5月());
        atenaKozaEntity.set徴収方法6月(keisangoJoho.get徴収方法6月());
        atenaKozaEntity.set徴収方法7月(keisangoJoho.get徴収方法7月());
        atenaKozaEntity.set徴収方法8月(keisangoJoho.get徴収方法8月());
        atenaKozaEntity.set徴収方法9月(keisangoJoho.get徴収方法9月());
        atenaKozaEntity.set徴収方法10月(keisangoJoho.get徴収方法10月());
        atenaKozaEntity.set徴収方法11月(keisangoJoho.get徴収方法11月());
        atenaKozaEntity.set徴収方法12月(keisangoJoho.get徴収方法12月());
        atenaKozaEntity.set徴収方法1月(keisangoJoho.get徴収方法1月());
        atenaKozaEntity.set徴収方法2月(keisangoJoho.get徴収方法2月());
        atenaKozaEntity.set徴収方法3月(keisangoJoho.get徴収方法3月());
        atenaKozaEntity.set徴収方法翌4月(keisangoJoho.get徴収方法翌4月());
        atenaKozaEntity.set徴収方法翌5月(keisangoJoho.get徴収方法翌5月());
        atenaKozaEntity.set徴収方法翌6月(keisangoJoho.get徴収方法翌6月());
        atenaKozaEntity.set徴収方法翌7月(keisangoJoho.get徴収方法翌7月());
        atenaKozaEntity.set徴収方法翌8月(keisangoJoho.get徴収方法翌8月());
        atenaKozaEntity.set徴収方法翌9月(keisangoJoho.get徴収方法翌9月());
        atenaKozaEntity.set仮徴収_基礎年金番号(keisangoJoho.get仮徴収_基礎年金番号());
        atenaKozaEntity.set仮徴収_年金コード(keisangoJoho.get仮徴収_年金コード());
        atenaKozaEntity.set仮徴収_捕捉月(keisangoJoho.get仮徴収_捕捉月());
        atenaKozaEntity.set本徴収_基礎年金番号(keisangoJoho.get本徴収_基礎年金番号());
        atenaKozaEntity.set本徴収_年金コード(keisangoJoho.get本徴収_年金コード());
        atenaKozaEntity.set本徴収_捕捉月(keisangoJoho.get本徴収_捕捉月());
        atenaKozaEntity.set翌年度仮徴収_基礎年金番号(keisangoJoho.get翌年度仮徴収_基礎年金番号());
        atenaKozaEntity.set翌年度仮徴収_年金コード(keisangoJoho.get翌年度仮徴収_年金コード());
        atenaKozaEntity.set翌年度仮徴収_捕捉月(keisangoJoho.get翌年度仮徴収_捕捉月());
        atenaKozaEntity.set依頼情報送付済みフラグ(keisangoJoho.is依頼情報送付済みフラグ());
        atenaKozaEntity.set追加依頼情報送付済みフラグ(keisangoJoho.is追加依頼情報送付済みフラグ());
        atenaKozaEntity.set特別徴収停止日時(keisangoJoho.get特別徴収停止日時());
        atenaKozaEntity.set特別徴収停止事由コード(keisangoJoho.get特別徴収停止事由コード());
        atenaKozaEntity.set特徴収入額01(keisangoJoho.get特徴収入額01());
        atenaKozaEntity.set特徴収入額02(keisangoJoho.get特徴収入額02());
        atenaKozaEntity.set特徴収入額03(keisangoJoho.get特徴収入額03());
        atenaKozaEntity.set特徴収入額04(keisangoJoho.get特徴収入額04());
        atenaKozaEntity.set特徴収入額05(keisangoJoho.get特徴収入額05());
        atenaKozaEntity.set特徴収入額06(keisangoJoho.get特徴収入額06());
        atenaKozaEntity.set普徴収入額01(keisangoJoho.get普徴収入額01());
        atenaKozaEntity.set普徴収入額02(keisangoJoho.get普徴収入額02());
        atenaKozaEntity.set普徴収入額03(keisangoJoho.get普徴収入額03());
        atenaKozaEntity.set普徴収入額04(keisangoJoho.get普徴収入額04());
        atenaKozaEntity.set普徴収入額05(keisangoJoho.get普徴収入額05());
        atenaKozaEntity.set普徴収入額06(keisangoJoho.get普徴収入額06());
        atenaKozaEntity.set普徴収入額07(keisangoJoho.get普徴収入額07());
        atenaKozaEntity.set普徴収入額08(keisangoJoho.get普徴収入額08());
        atenaKozaEntity.set普徴収入額09(keisangoJoho.get普徴収入額09());
        atenaKozaEntity.set普徴収入額10(keisangoJoho.get普徴収入額10());
        atenaKozaEntity.set普徴収入額11(keisangoJoho.get普徴収入額11());
        atenaKozaEntity.set普徴収入額12(keisangoJoho.get普徴収入額12());
        atenaKozaEntity.set普徴収入額13(keisangoJoho.get普徴収入額13());
        atenaKozaEntity.set普徴収入額14(keisangoJoho.get普徴収入額14());
        atenaKozaEntity.set宛名Entity(entity.get宛名());
        atenaKozaEntity.set口座Entity(entity.get口座());
        return atenaKozaEntity;
    }
}
