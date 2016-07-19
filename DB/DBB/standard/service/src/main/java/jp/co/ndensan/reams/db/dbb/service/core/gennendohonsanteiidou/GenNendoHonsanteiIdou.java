/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.gennendohonsanteiidou;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.business.core.basic.KeisangoJoho;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.choteijiyu.ChoteiJiyuParameter;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.choteijiyu.FukaJohoList;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.fukakeisan.FukaKokyoBatchParameter;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJoho;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJohoBuilder;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.kibetsu.Kibetsu;
import jp.co.ndensan.reams.db.dbb.business.core.gennendohonsanteiidou.CaluculateChoteiResult;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.HokenryoDankaiHantei;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.core.TsukibetsuHokenryoDankai;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.fukakonkyo.FukaKonkyoBatchParameter;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.fukakonkyo.FukaKonkyoFactory;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.FukaKonkyo;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.HokenryoDankaiHanteiParameter;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.SeigyoJoho;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.SeigyojohoFactory;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.HokenryoDankaiList;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.MonthShichoson;
import jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.NengakuHokenryo;
import jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.NengakuHokenryoKeisan;
import jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.param.NengakuFukaKonkyo;
import jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.param.NengakuFukaKonkyoFactory;
import jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.param.NengakuHokenryoKeisanParameter;
import jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.param.NengakuSeigyoJoho;
import jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.param.RankBetsuKijunKingaku;
import jp.co.ndensan.reams.db.dbb.business.report.honsanteiidou.GenNendoHonsanteiIdouProperty.DBB200015HonsanteiIdouKekkaIchiranEnum;
import jp.co.ndensan.reams.db.dbb.business.report.honsanteiidou.KeisanjohoAtenaKozaKouseizengoEntity;
import jp.co.ndensan.reams.db.dbb.definition.core.choshuhoho.ChoshuHohoKibetsu;
import jp.co.ndensan.reams.db.dbb.definition.core.choteijiyu.ChoteiJiyuCode;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.ErrorCode;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.HasuChoseiHoho;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.HasuChoseiTaisho;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.KozaKubun;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.ShokkenKubun;
import jp.co.ndensan.reams.db.dbb.definition.core.tokucho.HosokushaIraiKingaku;
import jp.co.ndensan.reams.db.dbb.definition.core.tokucho.TokuchoNengakuKijunNendo4Gatsu;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.gennendohonsanteiidou.CalculateFukaParameter;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.gennendohonsanteiidou.HonsanteiIdoKekkaParameter;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.gennendohonsanteiidou.IdoParameter;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.gennendohonsanteiidou.TokuchoIraikin4gatsuKaishiParameter;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.gennendohonsanteiidou.TsuchishoNoCreateParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2010FukaErrorListEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fuka.SetaiHaakuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajoho.fukajoho.FukaJohoRelateEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajoho.kibetsu.KibetsuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.genendoidoukekkaichiran.KeisanjohoAtenaKozaEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.gennendohonsanteiidou.CalculateFukaEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.gennendohonsanteiidou.CozaIdoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.gennendohonsanteiidou.FukaJouhouEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.gennendohonsanteiidou.HonsanteiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.gennendohonsanteiidou.HonsanteiIdoKekkaEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.gennendohonsanteiidou.IdoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.gennendohonsanteiidou.ShotokuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.gennendohonsanteiidou.ShotokuIdoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.gennendohonsanteiidou.ShukiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.gennendohonsanteiidou.ShukiIdoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.gennendohonsanteiidou.TokuChoKaishiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.gennendohonsanteiidou.TokuKarisanteiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.gennendohonsanteiidou.TokuchoIraikin4gatsuKaishiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.gennendohonsanteiidou.TsukibetsuRankuEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2010FukaErrorListDac;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.gennendohonsanteiidou.IGenNendoHonsanteiIdouMapper;
import jp.co.ndensan.reams.db.dbb.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbb.service.core.choshuhoho.ChoshuHohoKoshin;
import jp.co.ndensan.reams.db.dbb.service.core.fuka.SetaiShotokuKazeiHantei;
import jp.co.ndensan.reams.db.dbb.service.core.fuka.choteijiyu.ChoteiJiyuHantei;
import jp.co.ndensan.reams.db.dbb.service.core.fuka.fukakeisan.FukaKeisan;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.HokenryoDankaiSettings;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.HokenryoRank;
import jp.co.ndensan.reams.db.dbb.service.report.honsanteiidou.GenNendoHonsanteiIdouPrintService;
import jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHohoBuilder;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.FuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KitsukiList;
import jp.co.ndensan.reams.db.dbx.business.util.NendoUtil;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.KazeiKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.Tsuki;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.UrT0705ChoteiKyotsuEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT2001ChoshuHohoDac;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT2002FukaDac;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT2003KibetsuDac;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbV2001ChoshuHohoAliveDac;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.UrT0705ChoteiKyotsuDac;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.core.basic.RoreiFukushiNenkinJukyusha;
import jp.co.ndensan.reams.db.dbz.business.core.hihokensha.seikatsuhogofujoshurui.SeikatsuHogoFujoShurui;
import jp.co.ndensan.reams.db.dbz.business.core.hihokensha.seikatsuhogojukyusha.SeikatsuHogoJukyusha;
import jp.co.ndensan.reams.db.dbz.business.core.kanri.JushoHenshu;
import jp.co.ndensan.reams.db.dbz.business.core.kyokaisogaitosha.kyokaisogaitosha.KyokaisoGaitosha;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.SetaiinHaakuKanriShikibetsuKubun;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7006RoreiFukushiNenkinJukyushaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7065ChohyoSeigyoKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.hihokensha.seikatsuhogojukyusha.SeikatsuHogoJukyushaRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.kyokaisogaitosha.KyokaisoGaitoshaEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7065ChohyoSeigyoKyotsuDac;
import jp.co.ndensan.reams.ua.uax.business.core.idoruiseki.ShikibetsuTaishoIdoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.core.koza.IKoza;
import jp.co.ndensan.reams.ua.uax.business.core.koza.Koza;
import jp.co.ndensan.reams.ua.uax.business.core.koza.KozaSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.definition.core.valueobject.code.KozaYotoKubunCodeValue;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.idoruiseki.ShikibetsuTaishoIdoChushutsuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.idoruiseki.ShikibetsuTaishoIdoSearchKey;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt001FindIdoEntity;
import jp.co.ndensan.reams.ua.uax.persistence.db.basic.UaFt001FindIdoFunctionDac;
import jp.co.ndensan.reams.ur.urc.service.core.shunokamoku.authority.ShunoKamokuAuthority;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
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
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.Month;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
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
 * 本算定賦課・本算定異動（現年度）（バッチ）のビジネスクラスです。
 *
 * @reamsid_L DBB-0930-020 cuilin
 */
public class GenNendoHonsanteiIdou {

    private final MapperProvider mapperProvider;
    private final DbV2001ChoshuHohoAliveDac 徴収方法NewestDac;
    private final DbT2010FukaErrorListDac 賦課エラーDac;
    private final DbT2002FukaDac 賦課Dac;
    private final DbT2003KibetsuDac 期別Dac;
    private final UrT0705ChoteiKyotsuDac 調定共通Dac;
    private final UaFt001FindIdoFunctionDac 宛名識別異動分Dac;
    private final DbT2001ChoshuHohoDac 徴収方法Dac;
    private final DbT7065ChohyoSeigyoKyotsuDac 帳票制御共通Dac;
    private static final RString KEY_CHOTEINENDOYMD = new RString("choteiNendoYMD");
    private static final RString KEY_FUKANENDO = new RString("fukaNendo");
    private static final int INT_1 = 1;
    private static final int INT_2 = 2;
    private static final int INT_3 = 3;
    private static final int INT_4 = 4;
    private static final int INT_5 = 5;
    private static final int INT_6 = 6;
    private static final int INT_7 = 7;
    private static final int INT_8 = 8;
    private static final int INT_9 = 9;
    private static final int INT_10 = 10;
    private static final int INT_11 = 11;
    private static final int INT_12 = 12;
    private static final int INT_13 = 13;
    private static final int INT_14 = 14;
    private static final int DAY = 31;
    private static final RString ゼロ_0000 = new RString("0000");
    private static final RString 内部帳票ID = new RString("DBB400001_FukaErrorIchitan");
    private static final ReportId 帳票ID = new ReportId("DBB200015_HonsanteiIdouKekkaIchiran");
    private final ReportId 帳票分類Id = new ReportId("DBB200009_HonsanteiKekkaIcihiran");
    private static final RString バッチID = new RString("DBBBT44001");
    private static final RString 合併情報区分_合併あり = new RString("1");
    private static final RString 使用する = new RString("1");
    private static final RString 使用しない = new RString("0");
    private static final Code 用途区分コード = new Code("0");
    private static final RString 更正前後区分_更正前 = new RString("1");
    private static final RString 更正前後区分_更正後 = new RString("2");
    private static final RString EUCファイル名 = new RString("HonsanteiIdouKekkaIchiranData.csv");
    private static final EucEntityId EUCエンティティID = new EucEntityId("DBB200015");
    private static final RString カンマ = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString FORMAT_LEFT = new RString("【");
    private static final RString FORMAT_RIGHT = new RString("】");
    private static final RString 定値_賦課年度 = new RString("賦課年度");
    private static final RString 定値_調定年度 = new RString("調定年度");
    private static final RString 年度 = new RString("年度");
    private static final RString CSV出力有無_有り = new RString("有り");
    private static final RString CSVファイル名_一覧表 = new RString("本算定異動（現年度）結果一覧表");
    private static final RString ゆうちょ銀行 = new RString("9900");
    private static final RString HYPHEN = new RString("-");
    private static final RString 定値_現金 = new RString("現金");
    private static final RString 定値_口座 = new RString("口座");
    private static final RString 定値_特別徴収 = new RString("特別徴収");
    private static final RString 定値_普通徴収 = new RString("普通徴収");
    private static final RString 定値_併用徴収 = new RString("併用徴収");
    private static final RString 区分_管内 = new RString("1");
    private static final RString 区分_管外 = new RString("2");
    private static final RString 文字列_随 = new RString("随");
    private static final RString タイトル_作成年月日 = new RString("作成年月日");
    private static final RString タイトル_作成時刻 = new RString("作成時刻");
    private static final RString タイトル_賦課年度 = new RString("賦課年度");
    private static final RString タイトル_被保険者番号 = new RString("被保険者番号");
    private static final RString タイトル_通知書番号 = new RString("通知書番号");
    private static final RString タイトル_氏名 = new RString("氏名");
    private static final RString タイトル_住所 = new RString("住所");
    private static final RString タイトル_町域住所 = new RString("町域（管内）・管外住所");
    private static final RString タイトル_番地 = new RString("番地");
    private static final RString タイトル_口座情報 = new RString("口座情報");
    private static final RString タイトル_調定事由１_更正後 = new RString("調定事由１（更正後）");
    private static final RString タイトル_調定年月日_更正前 = new RString("調定年月日（更正前）");
    private static final RString タイトル_確定保険料額_更正前 = new RString("確定保険料額（更正前）");
    private static final RString タイトル_計算上保険料額_更正前 = new RString("計算上保険料額（更正前）");
    private static final RString タイトル_減免額_更正前 = new RString("減免額（更正前）");
    private static final RString タイトル_月別所得段階4月_更正前 = new RString("月別所得段階4月（更正前）");
    private static final RString タイトル_月別所得段階5月_更正前 = new RString("月別所得段階5月（更正前）");
    private static final RString タイトル_月別所得段階6月_更正前 = new RString("月別所得段階6月（更正前）");
    private static final RString タイトル_月別所得段階7月_更正前 = new RString("月別所得段階7月（更正前）");
    private static final RString タイトル_月別所得段階8月_更正前 = new RString("月別所得段階8月（更正前）");
    private static final RString タイトル_月別所得段階9月_更正前 = new RString("月別所得段階9月（更正前）");
    private static final RString タイトル_月別所得段階10月_更正前 = new RString("月別所得段階10月（更正前）");
    private static final RString タイトル_月別所得段階11月_更正前 = new RString("月別所得段階11月（更正前）");
    private static final RString タイトル_月別所得段階12月_更正前 = new RString("月別所得段階12月（更正前）");
    private static final RString タイトル_月別所得段階1月_更正前 = new RString("月別所得段階1月（更正前）");
    private static final RString タイトル_月別所得段階2月_更正前 = new RString("月別所得段階2月（更正前）");
    private static final RString タイトル_月別所得段階3月_更正前 = new RString("月別所得段階3月（更正前）");
    private static final RString タイトル_口座異動_更正前 = new RString("口座異動（更正前）");
    private static final RString タイトル_調定事由2_更正後 = new RString("調定事由2（更正後）");
    private static final RString タイトル_調定年月日_更正後 = new RString("調定年月日（更正後）");
    private static final RString タイトル_確定保険料額_更正後 = new RString("確定保険料額（更正後）");
    private static final RString タイトル_減免額_更正後 = new RString("減免額（更正後）");
    private static final RString タイトル_月別所得段階4月_更正後 = new RString("月別所得段階4月（更正後）");
    private static final RString タイトル_月別所得段階5月_更正後 = new RString("月別所得段階5月（更正後）");
    private static final RString タイトル_月別所得段階6月_更正後 = new RString("月別所得段階6月（更正後）");
    private static final RString タイトル_月別所得段階7月_更正後 = new RString("月別所得段階7月（更正後）");
    private static final RString タイトル_月別所得段階8月_更正後 = new RString("月別所得段階8月（更正後）");
    private static final RString タイトル_月別所得段階9月_更正後 = new RString("月別所得段階9月（更正後）");
    private static final RString タイトル_月別所得段階10月_更正後 = new RString("月別所得段階10月（更正後）");
    private static final RString タイトル_月別所得段階11月_更正後 = new RString("月別所得段階11月（更正後）");
    private static final RString タイトル_月別所得段階12月_更正後 = new RString("月別所得段階12月（更正後）");
    private static final RString タイトル_月別所得段階1月_更正後 = new RString("月別所得段階1月（更正後）");
    private static final RString タイトル_月別所得段階2月_更正後 = new RString("月別所得段階2月（更正後）");
    private static final RString タイトル_月別所得段階3月_更正後 = new RString("月別所得段階3月（更正後）");
    private static final RString タイトル_口座異動_更正後 = new RString("口座異動（更正後）");
    private static final RString タイトル_調定事由3_更正後 = new RString("調定事由3（更正後）");
    private static final RString タイトル_特徴額１期_更正前 = new RString("特徴額１期（更正前）");
    private static final RString タイトル_特徴額２期_更正前 = new RString("特徴額２期（更正前）");
    private static final RString タイトル_特徴額３期_更正前 = new RString("特徴額３期（更正前）");
    private static final RString タイトル_特徴額４期_更正前 = new RString("特徴額４期（更正前）");
    private static final RString タイトル_特徴額５期_更正前 = new RString("特徴額５期（更正前）");
    private static final RString タイトル_特徴額６期_更正前 = new RString("特徴額６期（更正前）");
    private static final RString タイトル_普徴額1期_更正前 = new RString("普徴額1期（更正前）");
    private static final RString タイトル_普徴額2期_更正前 = new RString("普徴額2期（更正前）");
    private static final RString タイトル_普徴額3期_更正前 = new RString("普徴額3期（更正前）");
    private static final RString タイトル_普徴額4期_更正前 = new RString("普徴額4期（更正前）");
    private static final RString タイトル_普徴額5期_更正前 = new RString("普徴額5期（更正前）");
    private static final RString タイトル_普徴額6期_更正前 = new RString("普徴額6期（更正前）");
    private static final RString タイトル_普徴額7期_更正前 = new RString("普徴額7期（更正前）");
    private static final RString タイトル_普徴額8期_更正前 = new RString("普徴額8期（更正前）");
    private static final RString タイトル_普徴額9期_更正前 = new RString("普徴額9期（更正前）");
    private static final RString タイトル_普徴額10期_更正前 = new RString("普徴額10期（更正前）");
    private static final RString タイトル_普徴額11期_更正前 = new RString("普徴額11期（更正前）");
    private static final RString タイトル_普徴額12期_更正前 = new RString("普徴額12期（更正前）");
    private static final RString タイトル_普徴額13期_更正前 = new RString("普徴額13期（更正前）");
    private static final RString タイトル_普徴額14期_更正前 = new RString("普徴額14期（更正前）");
    private static final RString タイトル_徴収方法_更正前 = new RString("徴収方法（更正前）");
    private static final RString タイトル_調定事由4_更正後 = new RString("調定事由4（更正後）");
    private static final RString タイトル_特徴額１期_更正後 = new RString("特徴額１期（更正後）");
    private static final RString タイトル_特徴額２期_更正後 = new RString("特徴額２期（更正後）");
    private static final RString タイトル_特徴額３期_更正後 = new RString("特徴額３期（更正後）");
    private static final RString タイトル_特徴額４期_更正後 = new RString("特徴額４期（更正後）");
    private static final RString タイトル_特徴額５期_更正後 = new RString("特徴額５期（更正後）");
    private static final RString タイトル_特徴額６期_更正後 = new RString("特徴額６期（更正後）");
    private static final RString タイトル_普徴額1期_更正後 = new RString("普徴額1期（更正後）");
    private static final RString タイトル_普徴額2期_更正後 = new RString("普徴額2期（更正後）");
    private static final RString タイトル_普徴額3期_更正後 = new RString("普徴額3期（更正後）");
    private static final RString タイトル_普徴額4期_更正後 = new RString("普徴額4期（更正後）");
    private static final RString タイトル_普徴額5期_更正後 = new RString("普徴額5期（更正後）");
    private static final RString タイトル_普徴額6期_更正後 = new RString("普徴額6期（更正後）");
    private static final RString タイトル_普徴額7期_更正後 = new RString("普徴額7期（更正後）");
    private static final RString タイトル_普徴額8期_更正後 = new RString("普徴額8期（更正後）");
    private static final RString タイトル_普徴額9期_更正後 = new RString("普徴額9期（更正後）");
    private static final RString タイトル_普徴額10期_更正後 = new RString("普徴額10期（更正後）");
    private static final RString タイトル_普徴額11期_更正後 = new RString("普徴額11期（更正後）");
    private static final RString タイトル_普徴額12期_更正後 = new RString("普徴額12期（更正後）");
    private static final RString タイトル_普徴額13期_更正後 = new RString("普徴額13期（更正後）");
    private static final RString タイトル_普徴額14期_更正後 = new RString("普徴額14期（更正後）");
    private static final RString タイトル_徴収方法_更正後 = new RString("徴収方法（更正後）");
    private static final RString タイトル_調定事由5_更正後 = new RString("調定事由５（更正後）");

    /**
     * コンストラクタです
     */
    public GenNendoHonsanteiIdou() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.徴収方法NewestDac = InstanceProvider.create(DbV2001ChoshuHohoAliveDac.class);
        this.賦課エラーDac = InstanceProvider.create(DbT2010FukaErrorListDac.class);
        this.期別Dac = InstanceProvider.create(DbT2003KibetsuDac.class);
        this.調定共通Dac = InstanceProvider.create(UrT0705ChoteiKyotsuDac.class);
        this.賦課Dac = InstanceProvider.create(DbT2002FukaDac.class);
        this.宛名識別異動分Dac = InstanceProvider.create(UaFt001FindIdoFunctionDac.class);
        this.徴収方法Dac = InstanceProvider.create(DbT2001ChoshuHohoDac.class);
        this.帳票制御共通Dac = InstanceProvider.create(DbT7065ChohyoSeigyoKyotsuDac.class);
    }

    /**
     * コンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 徴収方法NewestDac 徴収方法NewestDac
     * @param 賦課エラーDac DbT2010FukaErrorListDac
     * @param 賦課Dac DbT2002FukaDac
     * @param 期別Dac DbT2003KibetsuDac
     * @param 調定共通Dac UrT0705ChoteiKyotsuDac
     * @param 宛名識別異動分Dac UaFt001FindIdoFunctionDac
     * @param 徴収方法Dac DbT2001ChoshuHohoDac
     * @param 帳票制御共通Dac DbT7065ChohyoSeigyoKyotsuDac
     */
    GenNendoHonsanteiIdou(MapperProvider mapperProvider,
            DbV2001ChoshuHohoAliveDac 徴収方法NewestDac,
            DbT2010FukaErrorListDac 賦課エラーDac,
            DbT2002FukaDac 賦課Dac,
            DbT2003KibetsuDac 期別Dac,
            UrT0705ChoteiKyotsuDac 調定共通Dac,
            UaFt001FindIdoFunctionDac 宛名識別異動分Dac,
            DbT2001ChoshuHohoDac 徴収方法Dac,
            DbT7065ChohyoSeigyoKyotsuDac 帳票制御共通Dac) {
        this.mapperProvider = mapperProvider;
        this.徴収方法NewestDac = 徴収方法NewestDac;
        this.賦課エラーDac = 賦課エラーDac;
        this.賦課Dac = 賦課Dac;
        this.期別Dac = 期別Dac;
        this.調定共通Dac = 調定共通Dac;
        this.宛名識別異動分Dac = 宛名識別異動分Dac;
        this.徴収方法Dac = 徴収方法Dac;
        this.帳票制御共通Dac = 帳票制御共通Dac;
    }

    /**
     * にて生成した{@link GenNendoHonsanteiIdou}のインスタンスを返します。
     *
     * @return GenNendoHonsanteiIdou
     */
    public static GenNendoHonsanteiIdou createInstance() {
        return InstanceProvider.create(GenNendoHonsanteiIdou.class);
    }

    /**
     * 特別徴収開始者抽出メソッドです。
     *
     * @param 賦課年度 FlexibleYear
     * @param 算定月 RString
     */
    public void selectTokuchoKaishisha(FlexibleYear 賦課年度, RString 算定月) {
        List<DbV2001ChoshuHohoEntity> entityList = new ArrayList<>();
        if (Tsuki._10月.getコード().equals(算定月)) {
            entityList = 徴収方法NewestDac.get特別徴収開始者_12月(賦課年度);
        } else if (Tsuki._12月.getコード().equals(算定月)) {
            entityList = 徴収方法NewestDac.get特別徴収開始者_2月(賦課年度);
        } else if (Tsuki._2月.getコード().equals(算定月)) {
            entityList = 徴収方法NewestDac.get特別徴収開始者_4月(賦課年度);
        }
        IGenNendoHonsanteiIdouMapper mapper = mapperProvider.create(IGenNendoHonsanteiIdouMapper.class);
        if (entityList != null && !entityList.isEmpty()) {
            mapper.createTmpTokuChoKaishi();
            for (DbV2001ChoshuHohoEntity entity : entityList) {
                TokuChoKaishiEntity tokuChoKaishiEntity = new TokuChoKaishiEntity();
                tokuChoKaishiEntity.setHihokenshaNo(entity.getHihokenshaNo());
                mapper.insertTmpTokuChoKaishi(tokuChoKaishiEntity);
            }
        }
        if (entityList != null && !entityList.isEmpty() && Tsuki._2月.getコード().equals(算定月)) {
            mapper.createTmpTokuKarisantei();
            Map<String, Object> map = new HashMap<>();
            map.put(KEY_FUKANENDO.toString(), 賦課年度.minusYear(INT_1));
            List<TokuKarisanteiEntity> 特徴仮算定情報リスト = mapper.get特徴4月開始者の特徴仮算定対象データ(map);
            for (TokuKarisanteiEntity entity : 特徴仮算定情報リスト) {
                mapper.insertTmpTokuKarisantei(entity);
            }
        }
    }

    /**
     * 異動情報抽出メソッドです。
     *
     *
     * @param 調定年度 FlexibleYear
     * @param 賦課年度 FlexibleYear
     * @param 抽出開始日時 RDateTime
     * @param 抽出終了日時 RDateTime
     * @param 調定日時 RDateTime
     */
    public void selectIdoJoho(FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            RDateTime 抽出開始日時,
            RDateTime 抽出終了日時,
            RDateTime 調定日時) {
        IGenNendoHonsanteiIdouMapper mapper = mapperProvider.create(IGenNendoHonsanteiIdouMapper.class);
        ShunoKamokuAuthority auth = InstanceProvider.create(ShunoKamokuAuthority.class);
        KozaSearchKeyBuilder kozaBuilder = new KozaSearchKeyBuilder();
        kozaBuilder.setサブ業務コード(SubGyomuCode.DBB介護賦課);
        kozaBuilder.set業務コード(GyomuCode.DB介護保険);
        kozaBuilder.set基準日(FlexibleDate.getNowDate());
        kozaBuilder.set用途区分(new KozaYotoKubunCodeValue(用途区分コード));
        List<KamokuCode> list = auth.get更新権限科目コード(ControlDataHolder.getUserId());

        IdoParameter param = IdoParameter.createParam(調定年度, 賦課年度,
                抽出開始日時, 抽出終了日時, 調定日時, kozaBuilder.build(), list);

        ShikibetsuTaishoIdoSearchKey searchKey = new ShikibetsuTaishoIdoSearchKeyBuilder(
                ShikibetsuTaishoIdoChushutsuKubun.異動年月日で抽出, 抽出開始日時, 抽出終了日時).build();
        List<UaFt001FindIdoEntity> 宛名識別異動分取得PSM = 宛名識別異動分Dac.select(searchKey);
        mapper.createTmpShuki();
        for (UaFt001FindIdoEntity uaFt001FindIdoEntity : 宛名識別異動分取得PSM) {
            ShukiEntity entity = new ShukiEntity();
            entity.setShikibetsuCode(uaFt001FindIdoEntity.getShikibetsuCode());
            mapper.insertTmpShuki(entity);
        }
        List<ShukiIdoEntity> shukiIdoEntityList = mapper.get住基異動_被保険者本人異動(param);
        mapper.createTmpShukiIdo();
        for (ShukiIdoEntity shukiIdoEntity : shukiIdoEntityList) {
            mapper.insertTmpShukiIdo(shukiIdoEntity);
        }
        mapper.delete住基異動_本人の情報の削除();
        Map<String, Object> map = new HashMap<>();
        map.put(KEY_CHOTEINENDOYMD.toString(), new FlexibleDate(NendoUtil.toNendoStartDate(調定年度).toDateString()));
        List<IdoEntity> 住基異動_本人以外の異動情報 = mapper.get住基異動_本人以外の異動情報(map);
        mapper.createTmpIdo();
        for (IdoEntity idoEntity : 住基異動_本人以外の異動情報) {
            mapper.insertTmpIdo(idoEntity);
        }

        List<IdoEntity> 住基異動_本人の異動情報 = mapper.get住基異動_本人の異動情報();
        for (IdoEntity idoEntity : 住基異動_本人の異動情報) {
            mapper.insertTmpIdo(idoEntity);
        }

        List<ShotokuEntity> shotokuEntityList = mapper.get所得異動データ();
        mapper.createTmpShotoku();
        for (ShotokuEntity shotokuEntity : shotokuEntityList) {
            mapper.insertTmpShotoku(shotokuEntity);
        }
        List<ShotokuIdoEntity> shotokuIdoEntityList = mapper.get所得異動_被保険者本人異動();
        mapper.createTmpShotokuIdo();
        for (ShotokuIdoEntity shotokuIdoEntity : shotokuIdoEntityList) {
            mapper.insertTmpShotokuIdo(shotokuIdoEntity);
        }
        mapper.delete所得異動_本人の情報の削除();
        List<IdoEntity> 所得異動_本人以外の異動情報 = mapper.get所得異動_本人以外の異動情報(map);
        for (IdoEntity idoEntity : 所得異動_本人以外の異動情報) {
            mapper.insertTmpIdo(idoEntity);
        }
        List<IdoEntity> 所得異動_本人の異動情報 = mapper.get所得異動_本人の異動情報();
        for (IdoEntity idoEntity : 所得異動_本人の異動情報) {
            mapper.insertTmpIdo(idoEntity);
        }

        List<IdoEntity> 資格の異動情報 = mapper.get資格の異動(param);
        for (IdoEntity entity : 資格の異動情報) {
            mapper.insertTmpIdo(entity);
        }
        List<IdoEntity> 生保の異動情報 = mapper.get生保の異動(param);
        for (IdoEntity idoEntity : 生保の異動情報) {
            mapper.insertTmpIdo(idoEntity);
        }
        List<IdoEntity> 老齢の異動情報 = mapper.get老齢の異動(param);
        for (IdoEntity idoEntity : 老齢の異動情報) {
            mapper.insertTmpIdo(idoEntity);
        }
        List<IdoEntity> 境界層の異動情報 = mapper.get境界層の異動(param);
        for (IdoEntity idoEntity : 境界層の異動情報) {
            mapper.insertTmpIdo(idoEntity);
        }
        List<DbT2001ChoshuHohoEntity> 徴収方法の異動情報 = 徴収方法Dac.get徴収方法の異動(調定年度, 抽出開始日時, 抽出終了日時);
        for (DbT2001ChoshuHohoEntity entity : 徴収方法の異動情報) {
            IdoEntity idoEntity = new IdoEntity();
            idoEntity.setHihokenshaNo(entity.getHihokenshaNo());
            mapper.insertTmpIdo(idoEntity);
        }

        List<FukaJouhouEntity> 賦課情報一時 = mapper.get賦課情報一時(param);
        mapper.createTmpFukaJouhou();
        for (FukaJouhouEntity fukaJouhouEntity : 賦課情報一時) {
            mapper.insertTmpFukaJouhou(fukaJouhouEntity);
        }

        mapper.createTmpCozaIdo();
        List<CozaIdoEntity> 口座の異動 = mapper.get口座の異動(param);
        for (CozaIdoEntity cozaIdoEntity : 口座の異動) {
            mapper.insertTmpCozaIdo(cozaIdoEntity);
        }
        List<CozaIdoEntity> 現金の異動 = mapper.get現金の異動(param);
        for (CozaIdoEntity cozaIdoEntity : 現金の異動) {
            mapper.insertTmpCozaIdo(cozaIdoEntity);
        }
    }

    /**
     * 異動トリガーTemp作成メソッドです。
     *
     * @param 異動賦課で同時に計算する特徴捕捉分 RString
     * @param 特徴捕捉対象者の依頼金額計算 RString
     */
    public void createIdoTriggerTemp(RString 異動賦課で同時に計算する特徴捕捉分, RString 特徴捕捉対象者の依頼金額計算) {
        IGenNendoHonsanteiIdouMapper mapper = mapperProvider.create(IGenNendoHonsanteiIdouMapper.class);
        mapper.createTmpIdoTrigger();
        if (異動賦課で同時に計算する特徴捕捉分 == null || 異動賦課で同時に計算する特徴捕捉分.isEmpty()) {
            mapper.insert異動Tempと口座異動Tempをマージ();
        } else if (HosokushaIraiKingaku.通常の異動賦課に含めて計算する.getコード().equals(特徴捕捉対象者の依頼金額計算)) {
            mapper.insert通常の異動賦課に含めて計算する();
        } else if (HosokushaIraiKingaku.特徴捕捉対象者のみを計算する.getコード().equals(特徴捕捉対象者の依頼金額計算)) {
            mapper.insert特徴捕捉対象者のみを計算する();
        }
    }

    /**
     * 通知書番号発番
     *
     * @param 賦課年度 FlexibleYear
     * @param 調定年度 FlexibleYear
     * @param 抽出開始日時 RDateTime
     * @param 抽出終了日時 RDateTime
     */
    public void getTsuchishoNo(FlexibleYear 賦課年度,
            FlexibleYear 調定年度,
            RDateTime 抽出開始日時,
            RDateTime 抽出終了日時) {
        IGenNendoHonsanteiIdouMapper mapper = mapperProvider.create(IGenNendoHonsanteiIdouMapper.class);
        TsuchishoNoCreateParameter param = TsuchishoNoCreateParameter.createParam(賦課年度, 調定年度, 抽出開始日時, 抽出終了日時);
        List<DbT1001HihokenshaDaichoEntity> daichoEntityList = mapper.get資格の情報(param);
        List<HihokenshaDaicho> 資格の情報 = new ArrayList<>();
        for (DbT1001HihokenshaDaichoEntity entity : daichoEntityList) {
            資格の情報.add(new HihokenshaDaicho(entity));
        }
        List<FukaJohoRelateEntity> fukaJohoList = mapper.get賦課の情報(param);
        List<FukaJoho> 賦課の情報 = new ArrayList<>();
        for (FukaJohoRelateEntity entity : fukaJohoList) {
            賦課の情報.add(new FukaJoho(entity));
        }
        Collections.sort(資格の情報, new Comparator<HihokenshaDaicho>() {
            @Override
            public int compare(HihokenshaDaicho o1, HihokenshaDaicho o2) {
                int flag = o1.get第1号資格取得年月日().compareTo(o2.get第1号資格取得年月日());
                return flag;
            }
        });

        mapper.createTmpHonsantei();
        for (HihokenshaDaicho daicho : 資格の情報) {
            int count = 0;
            for (FukaJoho fukaJoho : 賦課の情報) {
                if (fukaJoho.get被保険者番号().equals(daicho.get被保険者番号())) {
                    count = count + INT_1;
                    HonsanteiEntity entity = new HonsanteiEntity();
                    set資格の情報Entity(daicho, entity, param);
                    if (count == INT_1) {
                        entity.setChoteiNendo(fukaJoho.get調定年度());
                        entity.setFukaNendo(fukaJoho.get賦課年度());
                        entity.setTsuchishoNo(fukaJoho.get通知書番号());
                    } else if (INT_1 < count) {
                        entity.setChoteiNendo(調定年度);
                        entity.setFukaNendo(賦課年度);
                        entity.setTsuchishoNo(create通知書番号(daicho.get被保険者番号().getColumnValue(), count));
                    }
                    mapper.insertTmpHonsantei(entity);
                }
            }
            if (count == 0) {
                HonsanteiEntity entity = new HonsanteiEntity();
                set資格の情報Entity(daicho, entity, param);
                entity.setChoteiNendo(調定年度);
                entity.setFukaNendo(賦課年度);
                entity.setTsuchishoNo(create通知書番号(daicho.get被保険者番号().getColumnValue(), count + 1));
                mapper.insertTmpHonsantei(entity);
            }
        }
        load月別ランク(get資格(資格の情報), 賦課年度);

        for (FukaJoho fukaEntity : 賦課の情報) {
            boolean flg = true;
            for (HihokenshaDaicho daichoEntity : 資格の情報) {
                if (fukaEntity.get被保険者番号().equals(daichoEntity.get被保険者番号())) {
                    flg = false;
                    break;
                }
            }
            if (flg) {
                賦課エラー登録処理(fukaEntity, 賦課年度, new Code(ErrorCode.被保険者台帳データなし.getコード()));
            }
        }
    }

    private void set資格の情報Entity(HihokenshaDaicho 資格の情報, HonsanteiEntity entity,
            TsuchishoNoCreateParameter param) {
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
        FlexibleDate fukaDate = new FlexibleDate(NendoUtil.toNendoStartDate(param.get賦課年度()).toDateString());
        if (資格の情報.get第1号資格取得年月日() == null || 資格の情報.get第1号資格取得年月日().isEmpty()
                || 資格の情報.get第1号資格取得年月日().isBefore(fukaDate)) {
            entity.setKijunYMD(fukaDate);
        } else {
            entity.setKijunYMD(資格の情報.get第1号資格取得年月日());
        }
    }

    private void load月別ランク(List<HihokenshaDaicho> 資格の情報, FlexibleYear 賦課年度) {
        IGenNendoHonsanteiIdouMapper mapper = mapperProvider.create(IGenNendoHonsanteiIdouMapper.class);
        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        if (市町村セキュリティ情報 != null && 市町村セキュリティ情報.get導入形態コード() != null
                && DonyuKeitaiCode.事務広域.getCode().equals(市町村セキュリティ情報.get導入形態コード().getKey())) {
            RString 合併情報区分 = DbBusinessConfig.get(ConfigNameDBU.合併情報管理_合併情報区分,
                    RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
            if (合併情報区分_合併あり.equals(合併情報区分)) {
                HokenryoRank rank = InstanceProvider.create(HokenryoRank.class);
                List<MonthShichoson> 月別ランク情報 = rank.get月別ランク情報(資格の情報, 賦課年度);
                mapper.createTmpTsukibetsuRanku();
                for (HihokenshaDaicho daicho : 資格の情報) {
                    TsukibetsuRankuEntity rankuEntity = new TsukibetsuRankuEntity();
                    rankuEntity.setHihokenshaNo(daicho.get被保険者番号());
                    set月別ランク(rankuEntity, 月別ランク情報);
                    mapper.insertTmpTsukibetsuRanku(rankuEntity);
                }
            }
        }
    }

    private void set月別ランク(TsukibetsuRankuEntity rankuEntity, List<MonthShichoson> 月別ランク情報) {
        for (MonthShichoson 月別ランク : 月別ランク情報) {
            if (Tsuki._4月.getコード().equals(月別ランク.get月().getコード())) {
                rankuEntity.setRankKubun4Gatsu(月別ランク.getランク区分());
                rankuEntity.setShichosonCode4Gatsu(月別ランク.get市町村コード());
            } else if (Tsuki._5月.getコード().equals(月別ランク.get月().getコード())) {
                rankuEntity.setRankKubun5Gatsu(月別ランク.getランク区分());
                rankuEntity.setShichosonCode5Gatsu(月別ランク.get市町村コード());
            } else if (Tsuki._6月.getコード().equals(月別ランク.get月().getコード())) {
                rankuEntity.setRankKubun6Gatsu(月別ランク.getランク区分());
                rankuEntity.setShichosonCode6Gatsu(月別ランク.get市町村コード());
            } else if (Tsuki._7月.getコード().equals(月別ランク.get月().getコード())) {
                rankuEntity.setRankKubun7Gatsu(月別ランク.getランク区分());
                rankuEntity.setShichosonCode7Gatsu(月別ランク.get市町村コード());
            } else if (Tsuki._8月.getコード().equals(月別ランク.get月().getコード())) {
                rankuEntity.setRankKubun8Gatsu(月別ランク.getランク区分());
                rankuEntity.setShichosonCode8Gatsu(月別ランク.get市町村コード());
            } else if (Tsuki._9月.getコード().equals(月別ランク.get月().getコード())) {
                rankuEntity.setRankKubun9Gatsu(月別ランク.getランク区分());
                rankuEntity.setShichosonCode9Gatsu(月別ランク.get市町村コード());
            } else if (Tsuki._10月.getコード().equals(月別ランク.get月().getコード())) {
                rankuEntity.setRankKubun10Gatsu(月別ランク.getランク区分());
                rankuEntity.setShichosonCode10Gatsu(月別ランク.get市町村コード());
            } else if (Tsuki._11月.getコード().equals(月別ランク.get月().getコード())) {
                rankuEntity.setRankKubun11Gatsu(月別ランク.getランク区分());
                rankuEntity.setShichosonCode11Gatsu(月別ランク.get市町村コード());
            } else if (Tsuki._12月.getコード().equals(月別ランク.get月().getコード())) {
                rankuEntity.setRankKubun12Gatsu(月別ランク.getランク区分());
                rankuEntity.setShichosonCode12Gatsu(月別ランク.get市町村コード());
            } else if (Tsuki._1月.getコード().equals(月別ランク.get月().getコード())) {
                rankuEntity.setRankKubun1Gatsu(月別ランク.getランク区分());
                rankuEntity.setShichosonCode1Gatsu(月別ランク.get市町村コード());
            } else if (Tsuki._2月.getコード().equals(月別ランク.get月().getコード())) {
                rankuEntity.setRankKubun2Gatsu(月別ランク.getランク区分());
                rankuEntity.setShichosonCode2Gatsu(月別ランク.get市町村コード());
            } else if (Tsuki._3月.getコード().equals(月別ランク.get月().getコード())) {
                rankuEntity.setRankKubun3Gatsu(月別ランク.getランク区分());
                rankuEntity.setShichosonCode3Gatsu(月別ランク.get市町村コード());
            }
        }
    }

    private List<HihokenshaDaicho> get資格(List<HihokenshaDaicho> 資格の情報) {
        List<HihokenshaDaicho> 資格 = new ArrayList<>();
        Collections.sort(資格の情報, new Comparator<HihokenshaDaicho>() {
            @Override
            public int compare(HihokenshaDaicho o1, HihokenshaDaicho o2) {
                int flag = o2.get被保険者番号().compareTo(o1.get被保険者番号());
                if (flag == 0) {
                    flag = o2.get異動日().compareTo(o1.get異動日());
                    if (flag == 0) {
                        flag = o2.get枝番().compareTo(o1.get枝番());
                    }
                }
                return flag;
            }
        });
        資格.add(資格の情報.get(0));
        for (int i = 1; i < 資格の情報.size(); i++) {
            if (!資格の情報.get(i).get被保険者番号().equals(資格の情報.get(i - 1).get被保険者番号())) {
                資格.add(資格の情報.get(i + 1));
            }
        }
        return 資格;
    }

    private TsuchishoNo create通知書番号(RString 被保険者番号, int 枝番号) {
        RStringBuilder rst = new RStringBuilder();
        rst.append(ゼロ_0000);
        rst.append(被保険者番号);
        rst.append(new RString(枝番号).padZeroToLeft(INT_2));
        return new TsuchishoNo(rst.toRString());
    }

    /**
     * 世帯員把握メソッドです。
     */
    public void collectSetaiin() {
        IGenNendoHonsanteiIdouMapper mapper = mapperProvider.create(IGenNendoHonsanteiIdouMapper.class);
        List<SetaiHaakuEntity> 世帯員把握情報 = mapper.get世帯員把握情報();
        mapper.createTmpSetaiHaaku();
        for (SetaiHaakuEntity setaiHaakuEntity : 世帯員把握情報) {
            mapper.insertTmpSetaiHaaku(setaiHaakuEntity);
        }
        SetaiShotokuKazeiHantei hantei = SetaiShotokuKazeiHantei.createInstance();
        hantei.getSetaiinHaaku(SetaiinHaakuKanriShikibetsuKubun.賦課.getコード());
        hantei.getJuminShotokuJoho();
    }

    /**
     * 賦課計算メソッドです。
     *
     * @param 賦課年度 FlexibleYear
     * @param 調定日時 YMDHMS
     * @param 算定月 RString
     */
    public void calculateFukaTsujoIdo(FlexibleYear 賦課年度,
            YMDHMS 調定日時,
            RString 算定月) {
        IGenNendoHonsanteiIdouMapper mapper = mapperProvider.create(IGenNendoHonsanteiIdouMapper.class);

        ShunoKamokuAuthority auth = InstanceProvider.create(ShunoKamokuAuthority.class);
        KozaSearchKeyBuilder kozaBuilder = new KozaSearchKeyBuilder();
        kozaBuilder.setサブ業務コード(SubGyomuCode.DBB介護賦課);
        kozaBuilder.set業務コード(GyomuCode.DB介護保険);
        kozaBuilder.set基準日(FlexibleDate.getNowDate());
        kozaBuilder.set用途区分(new KozaYotoKubunCodeValue(用途区分コード));
        List<KamokuCode> list = auth.get更新権限科目コード(ControlDataHolder.getUserId());

        CalculateFukaParameter param = CalculateFukaParameter.createParam(
                賦課年度, 調定日時, 算定月, kozaBuilder.build(), list);

        List<CalculateFukaEntity> 賦課計算の情報リスト = mapper.get賦課計算の情報(param);
        if (賦課計算の情報リスト == null || 賦課計算の情報リスト.isEmpty()) {
            return;
        }
        HokenryoDankaiList 保険料段階List = HokenryoDankaiSettings.createInstance().get保険料段階ListIn(param.get賦課年度());
        SeigyoJoho 月別保険料制御情報 = get月別保険料制御情報(保険料段階List);

        NengakuSeigyoJoho 年額制御情報 = get年額制御情報();
        for (CalculateFukaEntity 賦課計算の情報 : 賦課計算の情報リスト) {
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
            fukaKonkyoBatchParameter.set賦課基準日(賦課計算の情報.getKijunYMD());
            fukaKonkyoBatchParameter.set生保の情報リスト(生保の情報);
            fukaKonkyoBatchParameter.set老齢の情報のリスト(老齢の情報);
            fukaKonkyoBatchParameter.set世帯員所得情報List(賦課計算の情報.get世帯員所得情報());
            FukaKonkyo 賦課根拠 = factory.create(fukaKonkyoBatchParameter);
            保険料段階パラメータ.setFukaKonkyo(賦課根拠);

            保険料段階パラメータ.setSeigyoJoho(月別保険料制御情報);
            TsukibetsuHokenryoDankai 月別保険料段階 = hantei.determine月別保険料段階(保険料段階パラメータ);

            NengakuHokenryoKeisanParameter 年額保険料パラメータ = new NengakuHokenryoKeisanParameter();
            年額保険料パラメータ.set賦課年度(param.get賦課年度());

            NengakuFukaKonkyoFactory nengakuFukaKonkyo = InstanceProvider.create(NengakuFukaKonkyoFactory.class);
            TsukibetsuRankuEntity 月別ランク = 賦課計算の情報.get月別ランク();
            NengakuFukaKonkyo 年額賦課根拠 = nengakuFukaKonkyo.createNengakuFukaKonkyo(
                    賦課計算の情報.getKijunYMD(),
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
            fukaKokyoBatchParameter.set資格の情報(new HihokenshaDaicho(賦課計算の情報.get資格の情報()));
            fukaKokyoBatchParameter.set世帯員所得情報List(賦課計算の情報.get世帯員所得情報());
            fukaKokyoBatchParameter.set生保の情報のリスト(生保の情報);
            fukaKokyoBatchParameter.set老福の情報のリスト(老齢の情報);
            fukaKokyoBatchParameter.set境界層の情報のリスト(境界層の情報);
            fukaKokyoBatchParameter.set賦課根拠パラメータ(賦課根拠);
            fukaKokyoBatchParameter.set月別保険料段階(月別保険料段階);
            fukaKokyoBatchParameter.set年額保険料(年額保険料.getHokenryoNengaku());
            fukaKokyoBatchParameter.set調定日時(調定日時);
            if (賦課計算の情報.get賦課の情報() == null) {
                create新規の賦課処理(賦課計算の情報, fukaKokyoBatchParameter, param, 年額保険料.getHokenryoNengaku());
            } else {
                create既存の賦課処理(賦課計算の情報, fukaKokyoBatchParameter, param, 年額保険料.getHokenryoNengaku());
            }
        }
    }

    private void create新規の賦課処理(CalculateFukaEntity 賦課計算の情報, FukaKokyoBatchParameter fukaKokyoBatchParameter,
            CalculateFukaParameter param, Decimal 年額保険料) {
        FukaJoho 新しい賦課の情報 = new FukaJoho(賦課計算の情報.getChoteiNendo(), 賦課計算の情報.getFukaNendo(),
                賦課計算の情報.getTsuchishoNo(), 0);
        fukaKokyoBatchParameter.set賦課の情報_設定前(新しい賦課の情報);

        FukaKeisan fukaKeisan = FukaKeisan.createInstance();
        FukaJoho 賦課の情報_設定後 = fukaKeisan.reflect賦課根拠(fukaKokyoBatchParameter);

        CaluculateChoteiResult 調定計算 = caluculateChotei(param.get算定月(), param.get調定日時(), 賦課の情報_設定後,
                new ChoshuHoho(賦課計算の情報.get徴収方法の情報()), new HihokenshaDaicho(賦課計算の情報.get資格の情報()),
                年額保険料);
        FukaJoho 賦課の情報_更正後 = 調定計算.get賦課の情報();
        FukaJohoBuilder builder = 賦課の情報_更正後.createBuilderForEdit();
        builder.set被保険者番号(賦課計算の情報.get資格の情報().getHihokenshaNo())
                .set調定日時(param.get調定日時())
                .set異動基準日時(param.get調定日時())
                .set徴収方法履歴番号(調定計算.get徴収方法の情報().get履歴番号());
        if (!is普徴期別金額あり(調定計算.get賦課の情報())) {
            builder.set口座区分(KozaKubun.現金納付.getコード());
        } else {
            if (!賦課計算の情報.get口座().isEmpty()) {
                builder.set口座区分(KozaKubun.口座振替.getコード());
            } else {
                builder.set口座区分(KozaKubun.現金納付.getコード());
            }
        }
        builder.set職権区分(ShokkenKubun.非該当.getコード());
        HokenryoRank rank = InstanceProvider.create(HokenryoRank.class);
        List<HihokenshaDaicho> 資格 = new ArrayList<>();
        資格.add(new HihokenshaDaicho(賦課計算の情報.get資格の情報()));
        List<MonthShichoson> 月別ランク情報 = rank.get月別ランク情報(資格, param.get賦課年度());
        builder.set賦課市町村コード(get最終月の市町村コード(月別ランク情報))
                .set特徴歳出還付額(Decimal.ZERO)
                .set普徴歳出還付額(Decimal.ZERO)
                .set減免額(Decimal.ZERO);
        賦課の情報_更正後 = builder.build();

        List<FukaJohoList> 更正後賦課リスト = new ArrayList<>();
        FukaJohoList fukaList = new FukaJohoList();
        fukaList.set現年度(賦課の情報_更正後);
        更正後賦課リスト.add(fukaList);
        ChoteiJiyuParameter choteiJiyuParameter = new ChoteiJiyuParameter();
        choteiJiyuParameter.set更正後賦課リスト(更正後賦課リスト);
        choteiJiyuParameter.set更正前徴収方法(new ChoshuHoho(賦課計算の情報.get徴収方法の情報()));
        choteiJiyuParameter.set更正後徴収方法(調定計算.get徴収方法の情報());
        ChoteiJiyuHantei hantei = ChoteiJiyuHantei.createInstance();
        List<FukaJohoList> 出力用賦課リスト = hantei.set調定事由(choteiJiyuParameter);
        for (FukaJohoList 出力用賦課 : 出力用賦課リスト) {
            DbT2002FukaEntity fuka = 出力用賦課.get現年度().toEntity();
            fuka.setState(EntityDataState.Added);
            賦課Dac.save(fuka);

            // TODO QAのNo.984
//            List<Kibetsu> kibetsuList = 出力用賦課.get現年度().getKibetsuList();
//            for (Kibetsu kibetsu : kibetsuList) {
//                DbT2003KibetsuEntity kibetsuEntity = kibetsu.toEntity();
//                kibetsuEntity.setChoteiNendo(fuka.getChoteiNendo());
//                kibetsuEntity.setFukaNendo(fuka.getFukaNendo());
//                kibetsuEntity.setTsuchishoNo(fuka.getTsuchishoNo());
//                kibetsuEntity.setRirekiNo(fuka.getRirekiNo());
//                kibetsuEntity.setChoshuHouhou(new RString("1"));
//                kibetsuEntity.setKi(INT_1);
//                kibetsuEntity.setChoteiId(Decimal.ONE);
//                kibetsuEntity.setState(EntityDataState.Added);
//                期別Dac.save(kibetsuEntity);
//                List<ChoteiKyotsu> choteiKyotsuList = kibetsu.getChoteiKyotsuList();
//                for (ChoteiKyotsu choteiKyotsu : choteiKyotsuList) {
//                    UrT0705ChoteiKyotsuEntity urT0705ChoteiKyotsuEntity = choteiKyotsu.toEntity();
//                    urT0705ChoteiKyotsuEntity.setChoteiId(new Long(1));.
//                    urT0705ChoteiKyotsuEntity.setShunoId(出力用賦課.get現年度().get収納ID01());
//                    urT0705ChoteiKyotsuEntity.setChoteigaku(出力用賦課.get現年度().get特徴期別金額01());
//                    urT0705ChoteiKyotsuEntity.setState(EntityDataState.Added);
//                    調定共通Dac.save(urT0705ChoteiKyotsuEntity);
//                }
//            }
        }
        DbT2001ChoshuHohoEntity dbT2001ChoshuHohoEntity = 調定計算.get徴収方法の情報().toEntity();
        dbT2001ChoshuHohoEntity.setState(EntityDataState.Modified);
        徴収方法Dac.save(dbT2001ChoshuHohoEntity);
    }

    private void create既存の賦課処理(CalculateFukaEntity 賦課計算の情報, FukaKokyoBatchParameter fukaKokyoBatchParameter,
            CalculateFukaParameter param, Decimal 年額保険料) {
        FukaJoho 賦課の情報_設定前 = new FukaJoho(賦課計算の情報.get賦課の情報());
        fukaKokyoBatchParameter.set賦課の情報_設定前(賦課の情報_設定前);

        FukaKeisan fukaKeisan = FukaKeisan.createInstance();
        FukaJoho 賦課の情報_更正後 = fukaKeisan.reflect賦課根拠(fukaKokyoBatchParameter);
        ChoshuHoho 徴収方法の情報 = new ChoshuHoho(賦課計算の情報.get徴収方法の情報());
        if ((賦課の情報_更正後.get調定年度().equals(賦課の情報_更正後.get賦課年度())
                && isDecimal変更(賦課の情報_更正後.get減免前介護保険料_年額(), 年額保険料)
                || (賦課計算の情報.get徴収方法の情報().getTokuchoTeishiJiyuCode() != null
                && !賦課計算の情報.get徴収方法の情報().getTokuchoTeishiJiyuCode().isEmpty()))) {
            CaluculateChoteiResult 調定計算 = caluculateChotei(param.get算定月(), param.get調定日時(), 賦課の情報_更正後,
                    new ChoshuHoho(賦課計算の情報.get徴収方法の情報()), new HihokenshaDaicho(賦課計算の情報.get資格の情報()),
                    年額保険料);
            賦課の情報_更正後 = 調定計算.get賦課の情報();
            徴収方法の情報 = 調定計算.get徴収方法の情報();
        }
        if (ShokkenKubun.該当.getコード().equals(賦課の情報_更正後.get職権区分())) {
            賦課エラー登録処理(賦課の情報_更正後, param.get賦課年度(), new Code(ErrorCode.職権変更該当.getコード()));
        } else if (賦課の情報_更正後.get減免額() != null && 0 < 賦課の情報_更正後.get減免額().doubleValue()) {
            賦課エラー登録処理(賦課の情報_更正後, param.get賦課年度(), new Code(ErrorCode.賦課に減免あり.getコード()));
        } else if (ShokkenKubun.非該当.getコード().equals(賦課の情報_更正後.get職権区分())
                && (賦課の情報_更正後.get減免額() == null || Decimal.ZERO.equals(賦課の情報_更正後.get減免額()))) {
            FukaJohoBuilder builder = 賦課の情報_更正後.createBuilderForEdit();
            if (is変化有り(賦課の情報_設定前, 賦課の情報_更正後)) {
                builder.set履歴番号(賦課の情報_設定前.get履歴番号() + INT_1);
            }
            builder.set被保険者番号(賦課計算の情報.get資格の情報().getHihokenshaNo())
                    .set調定日時(param.get調定日時())
                    .set異動基準日時(param.get調定日時())
                    .set保険料段階_仮算定時(賦課の情報_設定前.get保険料段階_仮算定時())
                    .set徴収方法履歴番号(徴収方法の情報.get履歴番号());
            if (!is普徴期別金額あり(賦課の情報_更正後)) {
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
                    .set特徴歳出還付額(賦課の情報_設定前.get特徴歳出還付額())
                    .set普徴歳出還付額(賦課の情報_設定前.get普徴歳出還付額())
                    .set減免額(賦課の情報_設定前.get減免額());
            賦課の情報_更正後 = builder.build();

            List<FukaJohoList> 更正後賦課リスト = new ArrayList<>();
            FukaJohoList fukaList = new FukaJohoList();
            fukaList.set現年度(賦課の情報_更正後);
            更正後賦課リスト.add(fukaList);
            ChoteiJiyuParameter choteiJiyuParameter = new ChoteiJiyuParameter();
            choteiJiyuParameter.set現年度(賦課の情報_設定前);
            choteiJiyuParameter.set更正後賦課リスト(更正後賦課リスト);
            choteiJiyuParameter.set更正前徴収方法(new ChoshuHoho(賦課計算の情報.get徴収方法の情報()));
            choteiJiyuParameter.set更正後徴収方法(徴収方法の情報);
            ChoteiJiyuHantei hantei = ChoteiJiyuHantei.createInstance();
            List<FukaJohoList> 出力用賦課リスト = hantei.set調定事由(choteiJiyuParameter);
            for (FukaJohoList 出力用賦課 : 出力用賦課リスト) {
                DbT2002FukaEntity fuka = 出力用賦課.get現年度().toEntity();
                if (fuka.getRirekiNo() == 賦課の情報_設定前.get履歴番号()) {
                    fuka.setState(EntityDataState.Modified);
                } else {
                    fuka.setState(EntityDataState.Added);
                }
                賦課Dac.save(fuka);

                // TODO QAのNo.984
//                List<Kibetsu> kibetsuList = 出力用賦課.get現年度().getKibetsuList();
//                for (Kibetsu kibetsu : kibetsuList) {
//                    DbT2003KibetsuEntity kibetsuEntity = kibetsu.toEntity();
//                    kibetsuEntity.setRirekiNo(fuka.getRirekiNo());
//                    kibetsuEntity.setState(EntityDataState.Added);
//                    期別Dac.save(kibetsuEntity);
//                    List<ChoteiKyotsu> choteiKyotsuList = kibetsu.getChoteiKyotsuList();
//                    for (ChoteiKyotsu choteiKyotsu : choteiKyotsuList) {
//                        UrT0705ChoteiKyotsuEntity urT0705ChoteiKyotsuEntity = choteiKyotsu.toEntity();
//                        urT0705ChoteiKyotsuEntity.setState(EntityDataState.Modified);
//                        調定共通Dac.save(urT0705ChoteiKyotsuEntity);
//                    }
//                }
            }
            DbT2001ChoshuHohoEntity dbT2001ChoshuHohoEntity = 徴収方法の情報.toEntity();
            dbT2001ChoshuHohoEntity.setState(EntityDataState.Modified);
            徴収方法Dac.save(dbT2001ChoshuHohoEntity);
        }

    }

    private boolean is普徴期別金額あり(FukaJoho 賦課の情報) {
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
        LasdecCode 市町村コード_3月 = get市町村コード(月別ランク情報, Tsuki._3月.getコード());
        if (市町村コード_3月 != null) {
            return 市町村コード_3月;
        }
        LasdecCode 市町村コード_2月 = get市町村コード(月別ランク情報, Tsuki._2月.getコード());
        if (市町村コード_2月 != null) {
            return 市町村コード_2月;
        }
        LasdecCode 市町村コード_1月 = get市町村コード(月別ランク情報, Tsuki._1月.getコード());
        if (市町村コード_1月 != null) {
            return 市町村コード_1月;
        }
        LasdecCode 市町村コード_12月 = get市町村コード(月別ランク情報, Tsuki._12月.getコード());
        if (市町村コード_12月 != null) {
            return 市町村コード_12月;
        }
        LasdecCode 市町村コード_11月 = get市町村コード(月別ランク情報, Tsuki._11月.getコード());
        if (市町村コード_11月 != null) {
            return 市町村コード_11月;
        }
        LasdecCode 市町村コード_10月 = get市町村コード(月別ランク情報, Tsuki._10月.getコード());
        if (市町村コード_10月 != null) {
            return 市町村コード_10月;
        }
        LasdecCode 市町村コード_9月 = get市町村コード(月別ランク情報, Tsuki._9月.getコード());
        if (市町村コード_9月 != null) {
            return 市町村コード_9月;
        }
        LasdecCode 市町村コード_8月 = get市町村コード(月別ランク情報, Tsuki._8月.getコード());
        if (市町村コード_8月 != null) {
            return 市町村コード_8月;
        }
        LasdecCode 市町村コード_7月 = get市町村コード(月別ランク情報, Tsuki._7月.getコード());
        if (市町村コード_7月 != null) {
            return 市町村コード_7月;
        }
        LasdecCode 市町村コード_6月 = get市町村コード(月別ランク情報, Tsuki._6月.getコード());
        if (市町村コード_6月 != null) {
            return 市町村コード_6月;
        }
        LasdecCode 市町村コード_5月 = get市町村コード(月別ランク情報, Tsuki._5月.getコード());
        if (市町村コード_5月 != null) {
            return 市町村コード_5月;
        }
        LasdecCode 市町村コード_4月 = get市町村コード(月別ランク情報, Tsuki._4月.getコード());
        if (市町村コード_4月 != null) {
            return 市町村コード_4月;
        }
        return null;
    }

    private LasdecCode get市町村コード(List<MonthShichoson> 月別ランク情報, RString 月) {
        for (MonthShichoson choson : 月別ランク情報) {
            if (月.equals(choson.get月()) && choson.get市町村コード() != null
                    && !choson.get市町村コード().getColumnValue().isEmpty()) {
                return choson.get市町村コード();
            }
        }
        return null;
    }

    private void 賦課エラー登録処理(FukaJoho 賦課の情報, FlexibleYear 賦課年度, Code エラーコード) {
        DbT2010FukaErrorListEntity errorListEntity = new DbT2010FukaErrorListEntity();
        errorListEntity.setSubGyomuCode(SubGyomuCode.DBB介護賦課);
        errorListEntity.setInternalReportId(内部帳票ID);
        errorListEntity.setFukaNendo(賦課年度);
        errorListEntity.setTsuchishoNo(賦課の情報.get通知書番号());
        errorListEntity.setInternalReportCreationDateTime(賦課の情報.get調定日時() == null
                || 賦課の情報.get調定日時().isEmpty() ? null : 賦課の情報.get調定日時().getRDateTime());
        errorListEntity.setBatchId(バッチID);
        errorListEntity.setBatchStartingDateTime(RDate.getNowDateTime());
        errorListEntity.setHihokenshaNo(賦課の情報.get被保険者番号());
        errorListEntity.setShikibetsuCode(賦課の情報.get識別コード());
        errorListEntity.setErrorCode(エラーコード);
        errorListEntity.setShikakuShutokuYMD(賦課の情報.get資格取得日());
        errorListEntity.setShikakuShutokuJiyu(賦課の情報.get資格取得事由());
        errorListEntity.setShikakuSoshitsuYMD(賦課の情報.get資格喪失日());
        errorListEntity.setShikakuSoshitsuJiyu(賦課の情報.get資格喪失事由());
        errorListEntity.setState(EntityDataState.Added);
        賦課エラーDac.save(errorListEntity);
    }

    private boolean is変化有り(FukaJoho 更正前, FukaJoho 更正後) {
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
        if (更正後 != null && !更正後.isEmpty()
                && !更正後.equals(更正前)) {
            return true;
        } else if ((更正後 == null || 更正後.isEmpty())
                && 更正前 != null && !更正前.isEmpty()) {
            return true;
        }
        return false;
    }

    private boolean isHihokenshaNo変更(HihokenshaNo 更正前, HihokenshaNo 更正後) {
        if (更正後 != null && !更正後.isEmpty()
                && !更正後.equals(更正前)) {
            return true;
        } else if ((更正後 == null || 更正後.isEmpty())
                && 更正前 != null && !更正前.isEmpty()) {
            return true;
        }
        return false;
    }

    private boolean isShikibetsuCode変更(ShikibetsuCode 更正前, ShikibetsuCode 更正後) {
        if (更正後 != null && !更正後.isEmpty()
                && !更正後.equals(更正前)) {
            return true;
        } else if ((更正後 == null || 更正後.isEmpty())
                && 更正前 != null && !更正前.isEmpty()) {
            return true;
        }
        return false;
    }

    private boolean isSetaiCode変更(SetaiCode 更正前, SetaiCode 更正後) {
        if (更正後 != null && !更正後.isEmpty()
                && !更正後.equals(更正前)) {
            return true;
        } else if ((更正後 == null || 更正後.isEmpty())
                && 更正前 != null && !更正前.isEmpty()) {
            return true;
        }
        return false;
    }

    private boolean isInt変更(int 更正前, int 更正後) {
        return 更正前 != 更正後;
    }

    private boolean isFlexibleDate変更(FlexibleDate 更正前, FlexibleDate 更正後) {
        if (更正後 != null && !更正後.isEmpty()
                && !更正後.equals(更正前)) {
            return true;
        } else if ((更正後 == null || 更正後.isEmpty())
                && 更正前 != null && !更正前.isEmpty()) {
            return true;
        }
        return false;
    }

    private boolean isRString変更(RString 更正前, RString 更正後) {
        if (更正後 != null && !更正後.isEmpty()
                && !更正後.equals(更正前)) {
            return true;
        } else if ((更正後 == null || 更正後.isEmpty())
                && 更正前 != null && !更正前.isEmpty()) {
            return true;
        }
        return false;
    }

    private boolean isFlexibleYearMonth変更(FlexibleYearMonth 更正前, FlexibleYearMonth 更正後) {
        if (更正後 != null && !更正後.isEmpty()
                && !更正後.equals(更正前)) {
            return true;
        } else if ((更正後 == null || 更正後.isEmpty())
                && 更正前 != null && !更正前.isEmpty()) {
            return true;
        }
        return false;
    }

    private boolean isLasdecCode変更(LasdecCode 更正前, LasdecCode 更正後) {
        if (更正後 != null && !更正後.isEmpty()
                && !更正後.equals(更正前)) {
            return true;
        } else if ((更正後 == null || 更正後.isEmpty())
                && 更正前 != null && !更正前.isEmpty()) {
            return true;
        }
        return false;
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
        if (更正後 != null && !更正後.equals(更正前)) {
            return true;
        } else if (更正後 == null && 更正前 != null) {
            return true;
        }
        return false;
    }

    /**
     * 調定計算メソッドです。
     *
     * @param 算定月 RString
     * @param 調定日時 YMDHMS
     * @param 賦課の情報_更正前 FukaJoho
     * @param 徴収方法の情報_更正前 ChoshuHoho
     * @param 資格の情報 HihokenshaDaicho
     * @param 年額保険料 Decimal
     * @return CaluculateChoteiResult
     */
    public CaluculateChoteiResult caluculateChotei(RString 算定月,
            YMDHMS 調定日時,
            FukaJoho 賦課の情報_更正前,
            ChoshuHoho 徴収方法の情報_更正前,
            HihokenshaDaicho 資格の情報,
            Decimal 年額保険料) {
        // TODO QAのNo.933(Redmine#91256)
        List<Decimal> 特徴期別金額 = new ArrayList<>();
        for (int i = 0; i < INT_6; i++) {
            特徴期別金額.add(Decimal.ONE);
        }
        List<Decimal> 普徴期別金額 = new ArrayList<>();
        for (int i = 0; i < INT_14; i++) {
            普徴期別金額.add(Decimal.TEN);
        }
        RString 特徴停止事由コード = new RString("01");

        FukaJoho 賦課の情報 = 賦課の情報_更正前;
        FukaJohoRelateEntity fukaJohoRelateEntity = new FukaJohoRelateEntity();
        fukaJohoRelateEntity.set介護賦課Entity(賦課の情報.toEntity());
        List<KibetsuEntity> 介護期別RelateEntity = new ArrayList<>();
        for (Kibetsu kibetsu : 賦課の情報.getKibetsuList()) {
            if (ChoshuHohoKibetsu.特別徴収.getコード().equals(kibetsu.get徴収方法())) {
                set特徴期別金額(kibetsu, 特徴期別金額, 介護期別RelateEntity);
            } else if (ChoshuHohoKibetsu.普通徴収.getコード().equals(kibetsu.get徴収方法())) {
                set普徴期別金額(kibetsu, 普徴期別金額, 介護期別RelateEntity);
            }
        }
        fukaJohoRelateEntity.set介護期別RelateEntity(介護期別RelateEntity);
        賦課の情報 = new FukaJoho(fukaJohoRelateEntity);
        ChoshuHoho 出力用徴収方法の情報 = 徴収方法の情報_更正前;
        if (!Tsuki._3月.getコード().equals(算定月)) {
            Decimal 更正前の特別徴収額 = Decimal.ZERO;
            if (賦課の情報_更正前.get特徴期別金額01() != null) {
                更正前の特別徴収額 = 更正前の特別徴収額.add(賦課の情報_更正前.get特徴期別金額01());
            }
            if (賦課の情報_更正前.get特徴期別金額02() != null) {
                更正前の特別徴収額 = 更正前の特別徴収額.add(賦課の情報_更正前.get特徴期別金額02());
            }
            if (賦課の情報_更正前.get特徴期別金額03() != null) {
                更正前の特別徴収額 = 更正前の特別徴収額.add(賦課の情報_更正前.get特徴期別金額03());
            }
            if (賦課の情報_更正前.get特徴期別金額04() != null) {
                更正前の特別徴収額 = 更正前の特別徴収額.add(賦課の情報_更正前.get特徴期別金額04());
            }
            if (賦課の情報_更正前.get特徴期別金額05() != null) {
                更正前の特別徴収額 = 更正前の特別徴収額.add(賦課の情報_更正前.get特徴期別金額05());
            }
            if (賦課の情報_更正前.get特徴期別金額06() != null) {
                更正前の特別徴収額 = 更正前の特別徴収額.add(賦課の情報_更正前.get特徴期別金額06());
            }
            Decimal 更正後の特別徴収額 = Decimal.ZERO;
            for (Decimal decimal : 特徴期別金額) {
                更正後の特別徴収額.add(decimal);
            }
            if (更正前の特別徴収額.compareTo(更正後の特別徴収額) < 0
                    || (特徴停止事由コード != null && !特徴停止事由コード.isEmpty())) {
                ChoshuHohoBuilder builder = 出力用徴収方法の情報.createBuilderForEdit();
                builder.set特別徴収停止事由コード(特徴停止事由コード)
                        .set特別徴収停止日時(調定日時);
                出力用徴収方法の情報 = builder.build();
                ChoshuHohoKoshin choshuHohoKoshin = ChoshuHohoKoshin.createInstance();
                出力用徴収方法の情報 = choshuHohoKoshin.getChoshuHohoKoshinData(出力用徴収方法の情報,
                        調定日時, 賦課の情報.get資格取得日(), 賦課の情報.get資格喪失日());
            }
        }
        CaluculateChoteiResult result = new CaluculateChoteiResult();
        result.set賦課の情報(賦課の情報);
        result.set徴収方法の情報(出力用徴収方法の情報);
        return result;
    }

    /**
     * 特徴依頼金計算 (４月開始)メッソドです。
     *
     * @param 調定年度 FlexibleYear
     * @param 調定日時 YMDHMS
     */
    public void calculateTokuchoIraikin4gatsuKaishi(FlexibleYear 調定年度, YMDHMS 調定日時) {
        IGenNendoHonsanteiIdouMapper mapper = mapperProvider.create(IGenNendoHonsanteiIdouMapper.class);

        KozaSearchKeyBuilder kozaBuilder = new KozaSearchKeyBuilder();
        kozaBuilder.set業務コード(GyomuCode.DB介護保険);
        kozaBuilder.set用途区分(new KozaYotoKubunCodeValue(用途区分コード));
        kozaBuilder.set基準日(new FlexibleDate(調定日時.getDate().toString()));
        ShunoKamokuAuthority sut = InstanceProvider.create(ShunoKamokuAuthority.class);
        List<KamokuCode> list = sut.get更新権限科目コード(ControlDataHolder.getUserId());

        TokuchoIraikin4gatsuKaishiParameter param = TokuchoIraikin4gatsuKaishiParameter
                .createParam(調定年度, 調定日時, kozaBuilder.build(), list);

        List<TokuchoIraikin4gatsuKaishiEntity> 特徴依頼金情報リスト = mapper.get特徴依頼金情報(param);

        RString 特徴年額基準年度 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_年額基準年度_4月開始,
                NendoUtil.toNendoStartDate(param.get調定年度()), SubGyomuCode.DBB介護賦課);
        for (TokuchoIraikin4gatsuKaishiEntity 特徴依頼金情報 : 特徴依頼金情報リスト) {
            HihokenshaDaicho 資格の情報 = new HihokenshaDaicho(特徴依頼金情報.get資格の情報());
            ChoshuHoho 徴収方法の情報 = new ChoshuHoho(特徴依頼金情報.get徴収方法の情報());
            List<SeikatsuHogoJukyusha> 生保の情報 = new ArrayList<>();
            for (SeikatsuHogoJukyushaRelateEntity entity : 特徴依頼金情報.get生保の情報()) {
                生保の情報.add(new SeikatsuHogoJukyusha(entity));
            }
            List<RoreiFukushiNenkinJukyusha> 老齢の情報 = new ArrayList<>();
            for (DbT7006RoreiFukushiNenkinJukyushaEntity entity : 特徴依頼金情報.get老齢の情報()) {
                老齢の情報.add(new RoreiFukushiNenkinJukyusha(entity));
            }
            FukaJoho 賦課の情報 = editFukaJohoKyotsu(param.get調定年度(), 資格の情報, 徴収方法の情報,
                    生保の情報, 老齢の情報, 特徴依頼金情報.getZenNendoHokenryoDankai(), param.get調定日時());

            Decimal 保険料率 = Decimal.ZERO;
            if (TokuchoNengakuKijunNendo4Gatsu.当年度.getコード().equals(特徴年額基準年度)) {
                HokenryoDankaiList 前年度の保険料段階リスト
                        = HokenryoDankaiSettings.createInstance().get保険料段階ListIn(param.get調定年度());
                保険料率 = 前年度の保険料段階リスト.getBy段階区分(特徴依頼金情報.getZenNendoHokenryoDankai()).get保険料率();
            }
            // TODO QAのNo.933(Redmine#91256) URD（保険系業務共通）特徴仮算定期割クラスの呼び出し
            // jp.co.ndensan.reams.ur.urd.realservice.business.TokuchoKarisanteiKiwari
            List<Decimal> 特徴期別金額 = new ArrayList<>();
            特徴期別金額.add(保険料率);
            特徴期別金額.add(保険料率);
            特徴期別金額.add(保険料率);
            特徴期別金額.add(Decimal.ZERO);
            特徴期別金額.add(Decimal.ZERO);
            特徴期別金額.add(Decimal.ZERO);
            List<Decimal> 普徴期別金額 = new ArrayList<>();
            for (int i = 0; i < INT_14; i++) {
                普徴期別金額.add(Decimal.ZERO);
            }

            FukaJohoRelateEntity fukaJohoRelateEntity = new FukaJohoRelateEntity();
            fukaJohoRelateEntity.set介護賦課Entity(賦課の情報.toEntity());
            List<KibetsuEntity> 介護期別RelateEntity = new ArrayList<>();
            for (Kibetsu kibetsu : 賦課の情報.getKibetsuList()) {
                if (ChoshuHohoKibetsu.特別徴収.getコード().equals(kibetsu.get徴収方法())) {
                    set特徴期別金額(kibetsu, 特徴期別金額, 介護期別RelateEntity);
                } else if (ChoshuHohoKibetsu.普通徴収.getコード().equals(kibetsu.get徴収方法())) {
                    set普徴期別金額(kibetsu, 普徴期別金額, 介護期別RelateEntity);
                }
            }
            fukaJohoRelateEntity.set介護期別RelateEntity(介護期別RelateEntity);
            賦課の情報 = new FukaJoho(fukaJohoRelateEntity);
            DbT2002FukaEntity fuka = 賦課の情報.toEntity();
            fuka.setState(EntityDataState.Added);
            賦課Dac.save(fuka);
            // TODO QAのNo.984
//            for (Kibetsu kibetsu : kibetsuList) {
//                DbT2003KibetsuEntity kibetsuEntity = kibetsu.toEntity();
//                kibetsuEntity.setState(EntityDataState.Added);
//                期別Dac.save(kibetsuEntity);
//                List<ChoteiKyotsu> choteiKyotsuList = kibetsu.getChoteiKyotsuList();
//                for (ChoteiKyotsu choteiKyotsu : choteiKyotsuList) {
//                    UrT0705ChoteiKyotsuEntity urT0705ChoteiKyotsuEntity = choteiKyotsu.toEntity();
//                    urT0705ChoteiKyotsuEntity.setState(EntityDataState.Added);
//                    調定共通Dac.save(urT0705ChoteiKyotsuEntity);
//                }
//            }
        }
    }

    /**
     * 賦課の情報共通編集メッソド
     *
     * @param 調定年度 FlexibleYear
     * @param 資格の情報 HihokenshaDaicho
     * @param 徴収方法の情報 ChoshuHoho
     * @param 生保の情報のリスト List<SeikatsuHogoJukyusha>
     * @param 老福の情報のリスト List<RoreiFukushiNenkinJukyusha>
     * @param 前年度保険料段階 RString
     * @param 調定日時 YMDHMS
     * @return FukaJoho
     */
    public FukaJoho editFukaJohoKyotsu(FlexibleYear 調定年度,
            HihokenshaDaicho 資格の情報,
            ChoshuHoho 徴収方法の情報,
            List<SeikatsuHogoJukyusha> 生保の情報のリスト,
            List<RoreiFukushiNenkinJukyusha> 老福の情報のリスト,
            RString 前年度保険料段階,
            YMDHMS 調定日時) {
        TsuchishoNo 通知書番号 = create通知書番号(資格の情報.get被保険者番号().getColumnValue(), INT_1);
        FukaJoho 賦課の情報 = new FukaJoho(調定年度.plusYear(INT_1), 調定年度.plusYear(INT_1), 通知書番号, 0);
        FukaJohoBuilder builder = 賦課の情報.createBuilderForEdit();
        builder.set被保険者番号(資格の情報.get被保険者番号())
                .set識別コード(資格の情報.get識別コード())
                .set資格取得日(資格の情報.get第1号資格取得年月日())
                .set資格取得事由(資格の情報.get資格取得事由コード())
                .set資格喪失日(資格の情報.get資格喪失年月日())
                .set資格喪失事由(資格の情報.get資格喪失事由コード());
        FlexibleDate 本年度開始日 = new FlexibleDate(NendoUtil.toNendoStartDate(賦課の情報.get賦課年度()).toDateString());
        FlexibleDate 本年度終了日 = new FlexibleDate(賦課の情報.get賦課年度().plusYear(INT_1).getYearValue(),
                Month.MARCH.getValue(), DAY);

        set生活保護(builder, 生保の情報のリスト, 本年度開始日, 本年度終了日);
        set老齢福祉年金(builder, 老福の情報のリスト, 本年度開始日, 本年度終了日);

        FukaKeisan fukaKeisan = FukaKeisan.createInstance();
        FlexibleDate 賦課期日 = fukaKeisan.findOut賦課基準日(調定年度, 資格の情報);
        builder.set賦課期日(賦課期日);

        if (資格の情報.get旧市町村コード() != null && !資格の情報.get旧市町村コード().isEmpty()) {
            builder.set賦課市町村コード(資格の情報.get旧市町村コード());
        } else if (資格の情報.get広住特措置元市町村コード() != null
                && !資格の情報.get広住特措置元市町村コード().isEmpty()) {
            builder.set賦課市町村コード(資格の情報.get広住特措置元市町村コード());
        } else if (資格の情報.get市町村コード() != null && !資格の情報.get市町村コード().isEmpty()) {
            builder.set賦課市町村コード(資格の情報.get市町村コード());
        }

        builder.set調定日時(調定日時)
                .set調定事由1(ChoteiJiyuCode.捕捉により特徴開始.get名称())
                .set調定事由2(RString.EMPTY)
                .set調定事由3(RString.EMPTY)
                .set調定事由4(RString.EMPTY)
                .set更正月(Tsuki._4月.getコード())
                .set保険料段階_仮算定時(前年度保険料段階)
                .set徴収方法履歴番号(徴収方法の情報.get履歴番号())
                .set異動基準日時(調定日時)
                .set口座区分(KozaKubun.現金納付.getコード())
                .set特徴歳出還付額(Decimal.ZERO)
                .set普徴歳出還付額(Decimal.ZERO);
        賦課の情報 = builder.build();
        return 賦課の情報;
    }

    private static void set生活保護(FukaJohoBuilder builder, List<SeikatsuHogoJukyusha> 生保情報のリスト,
            FlexibleDate 本年度開始日, FlexibleDate 本年度終了日) {
        List<SeikatsuHogoJukyusha> 生活保護の情報のリスト = new ArrayList<>();
        for (SeikatsuHogoJukyusha entity : 生保情報のリスト) {
            FlexibleDate 受給開始日 = entity.get受給開始日();
            FlexibleDate 受給廃止日 = entity.get受給廃止日();
            if (受給開始日 == null || 受給開始日.isEmpty()) {
                受給開始日 = FlexibleDate.MIN;
            }
            if (受給廃止日 == null || 受給廃止日.isEmpty()) {
                受給廃止日 = FlexibleDate.MAX;
            }
            if (受給開始日.isBefore(本年度終了日) && 本年度開始日.isBeforeOrEquals(受給開始日)) {
                生活保護の情報のリスト.add(entity);
            } else if (受給廃止日.isBeforeOrEquals(本年度終了日) && 本年度開始日.isBeforeOrEquals(受給廃止日)) {
                生活保護の情報のリスト.add(entity);
            }
        }
        if (!生活保護の情報のリスト.isEmpty()) {
            Collections.sort(生活保護の情報のリスト, new Comparator<SeikatsuHogoJukyusha>() {
                @Override
                public int compare(SeikatsuHogoJukyusha o1, SeikatsuHogoJukyusha o2) {
                    int flag = o2.get受給開始日().compareTo(o1.get受給開始日());
                    return flag;
                }
            });
            // TODO QAのNo.950(Redmine#91760)
            builder.set生活保護扶助種類(get生活保護扶助種類(生活保護の情報のリスト.get(0).getSeikatsuHogoFujoShuruiList()));
            builder.set生保開始日(生活保護の情報のリスト.get(0).get受給開始日());
            builder.set生保廃止日(生活保護の情報のリスト.get(0).get受給廃止日());
        } else {
            builder.set生活保護扶助種類(RString.EMPTY);
            builder.set生保開始日(FlexibleDate.EMPTY);
            builder.set生保廃止日(FlexibleDate.EMPTY);
        }
    }

    private static RString get生活保護扶助種類(List<SeikatsuHogoFujoShurui> 扶助種類リスト) {
        List<RString> 扶助種類 = new ArrayList<>();
        if (扶助種類リスト.isEmpty()) {
            return RString.EMPTY;
        }
        for (SeikatsuHogoFujoShurui shurui : 扶助種類リスト) {
            扶助種類.add(shurui.get扶助種類コード().getColumnValue().getColumnValue());
        }
        Collections.sort(扶助種類);
        return 扶助種類.get(0);
    }

    private static void set老齢福祉年金(FukaJohoBuilder builder, List<RoreiFukushiNenkinJukyusha> 老福の情報リスト,
            FlexibleDate 本年度開始日, FlexibleDate 本年度終了日) {
        List<RoreiFukushiNenkinJukyusha> 老齢福祉の情報リスト = new ArrayList<>();
        for (RoreiFukushiNenkinJukyusha entity : 老福の情報リスト) {
            FlexibleDate 受給開始日 = entity.get受給開始年月日();
            FlexibleDate 受給廃止日 = entity.get受給終了年月日();
            if (受給開始日 == null || 受給開始日.isEmpty()) {
                受給開始日 = FlexibleDate.MIN;
            }
            if (受給廃止日 == null || 受給廃止日.isEmpty()) {
                受給廃止日 = FlexibleDate.MAX;
            }
            if (受給開始日.isBefore(本年度終了日) && 本年度開始日.isBeforeOrEquals(受給開始日)) {
                老齢福祉の情報リスト.add(entity);
            } else if (受給廃止日.isBeforeOrEquals(本年度終了日) && 本年度開始日.isBeforeOrEquals(受給廃止日)) {
                老齢福祉の情報リスト.add(entity);
            }
        }
        if (老齢福祉の情報リスト != null && !老齢福祉の情報リスト.isEmpty()) {
            Collections.sort(老齢福祉の情報リスト, new Comparator<RoreiFukushiNenkinJukyusha>() {
                @Override
                public int compare(RoreiFukushiNenkinJukyusha o1, RoreiFukushiNenkinJukyusha o2) {
                    int flag = o2.get受給開始年月日().compareTo(o1.get受給開始年月日());
                    return flag;
                }
            });
            builder.set老年開始日(老齢福祉の情報リスト.get(0).get受給開始年月日());
            builder.set老年廃止日(老齢福祉の情報リスト.get(0).get受給終了年月日());
        } else {
            builder.set老年開始日(FlexibleDate.EMPTY);
            builder.set老年廃止日(FlexibleDate.EMPTY);
        }
    }

    /**
     * 本算定異動（現年度）結果一覧表出力メッソド
     *
     * @param 調定年度 FlexibleYear
     * @param 賦課年度 FlexibleYear
     * @param 調定日時 YMDHMS
     * @param 出力順ID Long
     */
    public void spoolHonsanteiIdoKekkaIchiranData(FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            YMDHMS 調定日時,
            Long 出力順ID) {
        IGenNendoHonsanteiIdouMapper mapper = mapperProvider.create(IGenNendoHonsanteiIdouMapper.class);
        IOutputOrder outputOrder = ChohyoShutsuryokujunFinderFactory.createInstance().get出力順(
                SubGyomuCode.DBB介護賦課, 帳票ID, 出力順ID);
        RString 出力順 = MyBatisOrderByClauseCreator.create(DBB200015HonsanteiIdouKekkaIchiranEnum.class, outputOrder);

        KozaSearchKeyBuilder kozaBuilder = new KozaSearchKeyBuilder();
        kozaBuilder.set業務コード(GyomuCode.DB介護保険);
        kozaBuilder.set用途区分(new KozaYotoKubunCodeValue(用途区分コード));
        kozaBuilder.set基準日(new FlexibleDate(調定日時.getDate().toString()));

        ShunoKamokuAuthority sut = InstanceProvider.create(ShunoKamokuAuthority.class);
        List<KamokuCode> list = sut.get更新権限科目コード(ControlDataHolder.getUserId());

        HonsanteiIdoKekkaParameter param = HonsanteiIdoKekkaParameter
                .createParam(調定年度, 賦課年度, 調定日時, 出力順, kozaBuilder.build(), list);

        List<HonsanteiIdoKekkaEntity> 本算定計算後賦課情報リスト = mapper.get本算定異動情報(param);

        List<KeisanjohoAtenaKozaEntity> 計算後情報_宛名_口座_更正前EntityList = new ArrayList<>();
        List<KeisanjohoAtenaKozaEntity> 計算後情報_宛名_口座_更正後EntityList = new ArrayList<>();
        for (HonsanteiIdoKekkaEntity entity : 本算定計算後賦課情報リスト) {
            KeisangoJoho 計算後情報 = new KeisangoJoho(entity.get計算後情報());
            if (更正前後区分_更正前.equals(計算後情報.get更正前後区分())) {
                KeisanjohoAtenaKozaEntity 更正前Entity = get更正前Entity(entity, 計算後情報);
                計算後情報_宛名_口座_更正前EntityList.add(更正前Entity);
            } else if (更正前後区分_更正後.equals(計算後情報.get更正前後区分())) {
                KeisanjohoAtenaKozaEntity 更正後Entity = get更正前Entity(entity, 計算後情報);
                計算後情報_宛名_口座_更正後EntityList.add(更正後Entity);
            }
        }
        List<KeisanjohoAtenaKozaKouseizengoEntity> 計算後情報_宛名_口座EntityList = new ArrayList<>();
        for (KeisanjohoAtenaKozaEntity 更正前Entity : 計算後情報_宛名_口座_更正前EntityList) {
            for (KeisanjohoAtenaKozaEntity 更正後Entity : 計算後情報_宛名_口座_更正後EntityList) {
                if (更正前Entity.get調定年度().equals(更正後Entity.get調定年度())
                        && 更正前Entity.get賦課年度().equals(更正後Entity.get賦課年度())
                        && 更正前Entity.get通知書番号().equals(更正後Entity.get通知書番号())) {
                    計算後情報_宛名_口座EntityList.add(new KeisanjohoAtenaKozaKouseizengoEntity(更正前Entity, 更正後Entity));
                    break;
                }
            }
        }
        SourceDataCollection sourceDataCollection
                = new GenNendoHonsanteiIdouPrintService().printTaitsu(計算後情報_宛名_口座EntityList, 出力順ID, 調定日時, 賦課年度);

        publish本算定異動結果一覧表_本算定異動(賦課年度, 調定日時, 計算後情報_宛名_口座EntityList);

        List<RString> 出力条件リスト = new ArrayList<>();
        RStringBuilder builder = new RStringBuilder();
        builder.append((FORMAT_LEFT).concat(定値_調定年度).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE)
                .concat(調定年度.wareki().eraType(EraType.KANJI).toDateString()).concat(年度));
        出力条件リスト.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append((FORMAT_LEFT).concat(定値_賦課年度).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE)
                .concat(賦課年度.wareki().eraType(EraType.KANJI).toDateString()).concat(年度));

        出力条件リスト.add(builder.toRString());
        RString 出力ページ数 = new RString(sourceDataCollection.iterator().next().getPageCount());
        loadバッチ出力条件リスト(出力条件リスト, 出力ページ数, CSV出力有無_有り, CSVファイル名_一覧表);
    }

    private void publish本算定異動結果一覧表_本算定異動(FlexibleYear 賦課年度, YMDHMS 調定日時,
            List<KeisanjohoAtenaKozaKouseizengoEntity> 計算後情報_宛名_口座EntityList) {

        List<RString> headList = publish本算定異動結果一覧表_本算定異動タイトル();
        FileSpoolManager manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther,
                EUCエンティティID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        RString eucFilePath = Path.combinePath(spoolWorkPath, EUCファイル名);

        FuchoKiUtil 月期対応取得_普徴 = new FuchoKiUtil(賦課年度);
        KitsukiList 期月リスト = 月期対応取得_普徴.get期月リスト();
        Kitsuki 最終法定納期 = 期月リスト.get最終法定納期();
        try (CsvListWriter csvListWriter = new CsvListWriter.InstanceBuilder(eucFilePath).setNewLine(NewLine.CRLF)
                .setDelimiter(カンマ)
                .setEnclosure(EUC_WRITER_ENCLOSURE)
                .setEncode(Encode.UTF_8withBOM)
                .hasHeader(true).setHeader(headList)
                .build()) {

            for (KeisanjohoAtenaKozaKouseizengoEntity 更正前後Entity : 計算後情報_宛名_口座EntityList) {
                KeisanjohoAtenaKozaEntity 更正前Entity = 更正前後Entity.get計算後情報_宛名_口座_更正前Entity();
                KeisanjohoAtenaKozaEntity 更正後Entity = 更正前後Entity.get計算後情報_宛名_口座_更正後Entity();

                List<RString> bodyList = new ArrayList<>();

                RString 作成年月日 = 調定日時.getRDateTime().getDate().seireki()
                        .separator(Separator.SLASH).fillType(FillType.BLANK).toDateString();
                RString 作成日時 = 調定日時.getRDateTime().getTime().toFormattedTimeString(DisplayTimeFormat.HH_mm_ss);
                bodyList.add(作成年月日);
                bodyList.add(作成日時);
                bodyList.add(賦課年度.toDateString());
                bodyList.add(更正後Entity.get被保険者番号().getColumnValue());
                bodyList.add(更正後Entity.get通知書番号().getColumnValue());
                AtenaMeisho 氏名 = 更正後Entity.get宛名Entity().getKanjiShimei();
                if (氏名 != null) {
                    bodyList.add(氏名.getColumnValue());
                } else {
                    bodyList.add(RString.EMPTY);
                }

                IKojin 宛名情報 = ShikibetsuTaishoFactory.createKojin(更正後Entity.get宛名Entity());
                ChohyoSeigyoKyotsu 帳票制御共通 = load帳票制御共通(帳票分類Id);
                RString 編集後住所 = JushoHenshu.editJusho(帳票制御共通, 宛名情報, AssociationFinderFactory.createInstance().getAssociation());
                bodyList.add(編集後住所);
                if (区分_管内.equals(更正後Entity.get宛名Entity().getKannaiKangaiKubun())) {
                    bodyList.add(更正後Entity.get宛名Entity().getJusho().getColumnValue());
                } else if (区分_管外.equals(更正後Entity.get宛名Entity().getKannaiKangaiKubun())) {
                    bodyList.add(編集後住所);
                } else {
                    bodyList.add(RString.EMPTY);
                }
                AtenaBanchi banchi = 更正後Entity.get宛名Entity().getBanchi();
                if (banchi != null) {
                    bodyList.add(banchi.getColumnValue());
                } else {
                    bodyList.add(RString.EMPTY);
                }
                RString 口座情報 = get口座情報(更正前Entity, 更正後Entity);
                bodyList.add(口座情報);
                bodyList.add(更正後Entity.get調定事由1());

                RString 調定年月日_更正前 = 更正前Entity.get調定日時().getRDateTime().getDate().seireki()
                        .separator(Separator.SLASH).fillType(FillType.BLANK).toDateString();
                bodyList.add(調定年月日_更正前);
                bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(更正前Entity.get確定介護保険料_年額()), 0));
                bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(更正前Entity.get減免前介護保険料_年額()), 0));
                bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(更正前Entity.get減免額()), 0));

                List<RString> 更正前_月別所得段階リスト = new ArrayList<>();
                set月別取得段階(更正前Entity, 更正前_月別所得段階リスト);
                bodyList.addAll(更正前_月別所得段階リスト);
                if (KozaKubun.現金納付.getコード().equals(更正前Entity.get口座区分())) {
                    bodyList.add(定値_現金);
                } else if (KozaKubun.口座振替.getコード().equals(更正前Entity.get口座区分())) {
                    bodyList.add(定値_口座);
                } else {
                    bodyList.add(RString.EMPTY);
                }
                bodyList.add(更正後Entity.get調定事由2());

                RString 調定年月日_更正後 = 更正後Entity.get調定日時().getRDateTime().getDate().seireki()
                        .separator(Separator.SLASH).fillType(FillType.BLANK).toDateString();
                bodyList.add(調定年月日_更正後);
                bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(更正後Entity.get確定介護保険料_年額()), 0));
                bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(更正後Entity.get減免前介護保険料_年額()), 0));
                bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(更正後Entity.get減免額()), 0));
                List<RString> 更正後_月別所得段階リスト = new ArrayList<>();
                set月別取得段階(更正後Entity, 更正後_月別所得段階リスト);
                bodyList.addAll(更正後_月別所得段階リスト);
                if (KozaKubun.現金納付.getコード().equals(更正後Entity.get口座区分())) {
                    bodyList.add(定値_現金);
                } else if (KozaKubun.口座振替.getコード().equals(更正後Entity.get口座区分())) {
                    bodyList.add(定値_口座);
                } else {
                    bodyList.add(RString.EMPTY);
                }

                bodyList.add(更正後Entity.get調定事由3());
                bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(更正前Entity.get特徴期別金額01()), 0));
                bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(更正前Entity.get特徴期別金額02()), 0));
                bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(更正前Entity.get特徴期別金額03()), 0));
                bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(更正前Entity.get特徴期別金額04()), 0));
                bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(更正前Entity.get特徴期別金額05()), 0));
                bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(更正前Entity.get特徴期別金額06()), 0));
                bodyList.add(随時期月判断(INT_1, 期月リスト, 最終法定納期, 更正前Entity.get普徴期別金額01()));
                bodyList.add(随時期月判断(INT_2, 期月リスト, 最終法定納期, 更正前Entity.get普徴期別金額02()));
                bodyList.add(随時期月判断(INT_3, 期月リスト, 最終法定納期, 更正前Entity.get普徴期別金額03()));
                bodyList.add(随時期月判断(INT_4, 期月リスト, 最終法定納期, 更正前Entity.get普徴期別金額04()));
                bodyList.add(随時期月判断(INT_5, 期月リスト, 最終法定納期, 更正前Entity.get普徴期別金額05()));
                bodyList.add(随時期月判断(INT_6, 期月リスト, 最終法定納期, 更正前Entity.get普徴期別金額06()));
                bodyList.add(随時期月判断(INT_7, 期月リスト, 最終法定納期, 更正前Entity.get普徴期別金額07()));
                bodyList.add(随時期月判断(INT_8, 期月リスト, 最終法定納期, 更正前Entity.get普徴期別金額08()));
                bodyList.add(随時期月判断(INT_9, 期月リスト, 最終法定納期, 更正前Entity.get普徴期別金額09()));
                bodyList.add(随時期月判断(INT_10, 期月リスト, 最終法定納期, 更正前Entity.get普徴期別金額10()));
                bodyList.add(随時期月判断(INT_11, 期月リスト, 最終法定納期, 更正前Entity.get普徴期別金額11()));
                bodyList.add(随時期月判断(INT_12, 期月リスト, 最終法定納期, 更正前Entity.get普徴期別金額12()));
                bodyList.add(随時期月判断(INT_13, 期月リスト, 最終法定納期, 更正前Entity.get普徴期別金額13()));
                bodyList.add(随時期月判断(INT_14, 期月リスト, 最終法定納期, 更正前Entity.get普徴期別金額14()));

                bodyList.add(set徴収方法(更正前Entity));
                bodyList.add(更正後Entity.get調定事由4());
                bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(更正後Entity.get特徴期別金額01()), 0));
                bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(更正後Entity.get特徴期別金額02()), 0));
                bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(更正後Entity.get特徴期別金額03()), 0));
                bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(更正後Entity.get特徴期別金額04()), 0));
                bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(更正後Entity.get特徴期別金額05()), 0));
                bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(更正後Entity.get特徴期別金額06()), 0));
                bodyList.add(随時期月判断(INT_1, 期月リスト, 最終法定納期, 更正後Entity.get普徴期別金額01()));
                bodyList.add(随時期月判断(INT_2, 期月リスト, 最終法定納期, 更正後Entity.get普徴期別金額02()));
                bodyList.add(随時期月判断(INT_3, 期月リスト, 最終法定納期, 更正後Entity.get普徴期別金額03()));
                bodyList.add(随時期月判断(INT_4, 期月リスト, 最終法定納期, 更正後Entity.get普徴期別金額04()));
                bodyList.add(随時期月判断(INT_5, 期月リスト, 最終法定納期, 更正後Entity.get普徴期別金額05()));
                bodyList.add(随時期月判断(INT_6, 期月リスト, 最終法定納期, 更正後Entity.get普徴期別金額06()));
                bodyList.add(随時期月判断(INT_7, 期月リスト, 最終法定納期, 更正後Entity.get普徴期別金額07()));
                bodyList.add(随時期月判断(INT_8, 期月リスト, 最終法定納期, 更正後Entity.get普徴期別金額08()));
                bodyList.add(随時期月判断(INT_9, 期月リスト, 最終法定納期, 更正後Entity.get普徴期別金額09()));
                bodyList.add(随時期月判断(INT_10, 期月リスト, 最終法定納期, 更正後Entity.get普徴期別金額10()));
                bodyList.add(随時期月判断(INT_11, 期月リスト, 最終法定納期, 更正後Entity.get普徴期別金額11()));
                bodyList.add(随時期月判断(INT_12, 期月リスト, 最終法定納期, 更正後Entity.get普徴期別金額12()));
                bodyList.add(随時期月判断(INT_13, 期月リスト, 最終法定納期, 更正後Entity.get普徴期別金額13()));
                bodyList.add(随時期月判断(INT_14, 期月リスト, 最終法定納期, 更正後Entity.get普徴期別金額14()));
                bodyList.add(set徴収方法(更正後Entity));
                bodyList.add(RString.EMPTY);
                toBodyList(bodyList);
                csvListWriter.writeLine(bodyList);
            }
            manager.spool(SubGyomuCode.DBB介護賦課, eucFilePath);
        }
    }

    private RString get口座情報(KeisanjohoAtenaKozaEntity 更正前Entity, KeisanjohoAtenaKozaEntity 更正後Entity) {
        IKoza 口座_更正前 = new Koza(更正前Entity.get口座Entity());
        IKoza 口座_更正後 = new Koza(更正後Entity.get口座Entity());
        if (口座_更正前.get金融機関コード() != null) {
            if (ゆうちょ銀行.equals(口座_更正前.get金融機関コード().value().substring(0, INT_4))
                    && 口座_更正前.get金融機関コード().value().length() >= INT_4) {
                return ゆうちょ銀行の口座(口座_更正後);
            } else {
                return ゆうちょ銀行以外の口座(口座_更正後);
            }
        }
        return RString.EMPTY;
    }

    private RString ゆうちょ銀行の口座(IKoza 口座) {
        RString 金融機関コード;
        RString 通帳記号;
        RString 通帳番号;
        if (口座.get通帳記号() != null && 口座.get通帳番号() != null && 口座.get口座名義人漢字() != null) {
            if (口座.get金融機関コード().getColumnValue().length() >= INT_4) {
                金融機関コード = 口座.get金融機関コード().getColumnValue().substring(0, INT_4);
            } else {
                金融機関コード = 口座.get金融機関コード().getColumnValue();
            }
            if (口座.getEdited通帳記号().length() >= INT_5) {
                通帳記号 = 口座.getEdited通帳記号().substring(0, INT_5);
            } else {
                通帳記号 = 口座.getEdited通帳記号();
            }
            if (口座.getEdited通帳番号().length() >= INT_8) {
                通帳番号 = 口座.getEdited通帳番号().substring(0, INT_8);
            } else {
                通帳番号 = 口座.getEdited通帳番号();
            }
            return 金融機関コード.concat(RString.FULL_SPACE)
                    .concat(通帳記号)
                    .concat(HYPHEN).concat(通帳番号)
                    .concat(RString.FULL_SPACE).concat(口座.get口座名義人漢字().toString());
        }
        return RString.EMPTY;
    }

    private RString ゆうちょ銀行以外の口座(IKoza 口座) {
        RString 金融機関コード;
        RString 預金種別略称;
        RString 支店コード;
        RString 口座番号;
        if (口座.get支店コード() != null && 口座.get口座番号() != null && 口座.get口座名義人漢字() != null) {
            if (口座.get金融機関コード().value().length() >= INT_4) {
                金融機関コード = 口座.get金融機関コード().getColumnValue().substring(0, INT_4);
            } else {
                金融機関コード = 口座.get金融機関コード().getColumnValue();
            }
            if (口座.get支店コード().value().length() >= INT_5) {
                支店コード = 口座.get支店コード().getColumnValue().substring(0, INT_5);
            } else {
                支店コード = 口座.get支店コード().getColumnValue();
            }
            if (口座.get預金種別().get預金種別略称().length() >= INT_2) {
                預金種別略称 = 口座.get預金種別().get預金種別略称().substring(0, INT_2);
            } else {
                預金種別略称 = 口座.get預金種別().get預金種別略称();
            }
            if (口座.get口座番号().length() >= INT_7) {
                口座番号 = 口座.get口座番号().substring(0, INT_7);
            } else {
                口座番号 = 口座.get口座番号();
            }
            return 金融機関コード.concat(HYPHEN)
                    .concat(支店コード).concat(RString.FULL_SPACE)
                    .concat(預金種別略称)
                    .concat(HYPHEN).concat(口座番号).concat(RString.FULL_SPACE)
                    .concat(口座.get口座名義人漢字().toString());
        }
        return RString.EMPTY;
    }

    private Decimal nullTOZero(Decimal 金額) {
        if (金額 == null) {
            return Decimal.ZERO;
        }
        return 金額;
    }

    private List<RString> publish本算定異動結果一覧表_本算定異動タイトル() {
        List<RString> headList = new ArrayList<>();
        headList.add(タイトル_作成年月日);
        headList.add(タイトル_作成時刻);
        headList.add(タイトル_賦課年度);
        headList.add(タイトル_被保険者番号);
        headList.add(タイトル_通知書番号);
        headList.add(タイトル_氏名);
        headList.add(タイトル_住所);
        headList.add(タイトル_町域住所);
        headList.add(タイトル_番地);
        headList.add(タイトル_口座情報);
        headList.add(タイトル_調定事由１_更正後);
        headList.add(タイトル_調定年月日_更正前);
        headList.add(タイトル_確定保険料額_更正前);
        headList.add(タイトル_計算上保険料額_更正前);
        headList.add(タイトル_減免額_更正前);
        headList.add(タイトル_月別所得段階4月_更正前);
        headList.add(タイトル_月別所得段階4月_更正前);
        headList.add(タイトル_月別所得段階5月_更正前);
        headList.add(タイトル_月別所得段階6月_更正前);
        headList.add(タイトル_月別所得段階7月_更正前);
        headList.add(タイトル_月別所得段階8月_更正前);
        headList.add(タイトル_月別所得段階9月_更正前);
        headList.add(タイトル_月別所得段階10月_更正前);
        headList.add(タイトル_月別所得段階11月_更正前);
        headList.add(タイトル_月別所得段階12月_更正前);
        headList.add(タイトル_月別所得段階1月_更正前);
        headList.add(タイトル_月別所得段階2月_更正前);
        headList.add(タイトル_月別所得段階3月_更正前);
        headList.add(タイトル_口座異動_更正前);
        headList.add(タイトル_調定事由2_更正後);
        headList.add(タイトル_調定年月日_更正後);
        headList.add(タイトル_確定保険料額_更正後);
        headList.add(タイトル_減免額_更正後);
        headList.add(タイトル_月別所得段階4月_更正後);
        headList.add(タイトル_月別所得段階4月_更正後);
        headList.add(タイトル_月別所得段階5月_更正後);
        headList.add(タイトル_月別所得段階6月_更正後);
        headList.add(タイトル_月別所得段階7月_更正後);
        headList.add(タイトル_月別所得段階8月_更正後);
        headList.add(タイトル_月別所得段階9月_更正後);
        headList.add(タイトル_月別所得段階10月_更正後);
        headList.add(タイトル_月別所得段階11月_更正後);
        headList.add(タイトル_月別所得段階12月_更正後);
        headList.add(タイトル_月別所得段階1月_更正後);
        headList.add(タイトル_月別所得段階2月_更正後);
        headList.add(タイトル_月別所得段階3月_更正後);
        headList.add(タイトル_口座異動_更正後);
        headList.add(タイトル_調定事由3_更正後);
        headList.add(タイトル_特徴額１期_更正前);
        headList.add(タイトル_特徴額２期_更正前);
        headList.add(タイトル_特徴額３期_更正前);
        headList.add(タイトル_特徴額４期_更正前);
        headList.add(タイトル_特徴額５期_更正前);
        headList.add(タイトル_特徴額６期_更正前);
        headList.add(タイトル_普徴額1期_更正前);
        headList.add(タイトル_普徴額2期_更正前);
        headList.add(タイトル_普徴額3期_更正前);
        headList.add(タイトル_普徴額4期_更正前);
        headList.add(タイトル_普徴額5期_更正前);
        headList.add(タイトル_普徴額6期_更正前);
        headList.add(タイトル_普徴額7期_更正前);
        headList.add(タイトル_普徴額8期_更正前);
        headList.add(タイトル_普徴額9期_更正前);
        headList.add(タイトル_普徴額10期_更正前);
        headList.add(タイトル_普徴額11期_更正前);
        headList.add(タイトル_普徴額12期_更正前);
        headList.add(タイトル_普徴額13期_更正前);
        headList.add(タイトル_普徴額14期_更正前);
        headList.add(タイトル_徴収方法_更正前);
        headList.add(タイトル_調定事由4_更正後);
        headList.add(タイトル_特徴額１期_更正後);
        headList.add(タイトル_特徴額２期_更正後);
        headList.add(タイトル_特徴額３期_更正後);
        headList.add(タイトル_特徴額４期_更正後);
        headList.add(タイトル_特徴額５期_更正後);
        headList.add(タイトル_特徴額６期_更正後);
        headList.add(タイトル_普徴額1期_更正後);
        headList.add(タイトル_普徴額2期_更正後);
        headList.add(タイトル_普徴額3期_更正後);
        headList.add(タイトル_普徴額4期_更正後);
        headList.add(タイトル_普徴額5期_更正後);
        headList.add(タイトル_普徴額6期_更正後);
        headList.add(タイトル_普徴額7期_更正後);
        headList.add(タイトル_普徴額8期_更正後);
        headList.add(タイトル_普徴額9期_更正後);
        headList.add(タイトル_普徴額10期_更正後);
        headList.add(タイトル_普徴額11期_更正後);
        headList.add(タイトル_普徴額12期_更正後);
        headList.add(タイトル_普徴額13期_更正後);
        headList.add(タイトル_普徴額14期_更正後);
        headList.add(タイトル_徴収方法_更正後);
        headList.add(タイトル_調定事由5_更正後);
        return headList;
    }

    private RString 随時期月判断(int 期, KitsukiList 期月リスト, Kitsuki 最終法定納期, Decimal 期別金額) {
        for (Kitsuki kitsuki : 期月リスト.get期の月(期)) {
            if (kitsuki.get月().getコード().compareTo(最終法定納期.get月().getコード()) > 0) {
                return DecimalFormatter.toコンマ区切りRString(nullTOZero(期別金額), 0);
            }
        }
        return RString.EMPTY;
    }

    private void loadバッチ出力条件リスト(List<RString> 出力条件リスト, RString 出力ページ数,
            RString csv出力有無, RString 帳票名) {

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
                csv出力有無,
                EUCファイル名,
                出力条件リスト);
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(reportOutputJokenhyoItem);
        printer.print();
    }

    private ChohyoSeigyoKyotsu load帳票制御共通(ReportId 帳票分類Id) throws NullPointerException {
        requireNonNull(帳票分類Id, UrSystemErrorMessages.値がnull.getReplacedMessage(帳票分類Id.toString()));
        DbT7065ChohyoSeigyoKyotsuEntity entity = 帳票制御共通Dac.selectByKey(SubGyomuCode.DBB介護賦課, 帳票分類Id);
        if (entity == null) {
            return null;
        }
        return new ChohyoSeigyoKyotsu(entity);
    }

    private KeisanjohoAtenaKozaEntity get更正前Entity(HonsanteiIdoKekkaEntity entity, KeisangoJoho 計算後情報) {
        KeisanjohoAtenaKozaEntity 更正前Entity = new KeisanjohoAtenaKozaEntity();
        更正前Entity.set調定年度(計算後情報.get調定年度());
        更正前Entity.set賦課年度(計算後情報.get賦課年度());
        更正前Entity.set通知書番号(計算後情報.get通知書番号());
        更正前Entity.set更正前後区分(計算後情報.get更正前後区分());
        更正前Entity.set作成処理名(計算後情報.get作成処理名());
        更正前Entity.set賦課履歴番号(計算後情報.get賦課履歴番号());
        更正前Entity.set被保険者番号(計算後情報.get被保険者番号());
        更正前Entity.set識別コード(計算後情報.get識別コード());
        更正前Entity.set世帯コード(計算後情報.get世帯コード());
        更正前Entity.set世帯員数(計算後情報.get世帯員数());
        更正前Entity.set資格取得日(計算後情報.get資格取得日());
        更正前Entity.set資格取得事由(計算後情報.get資格取得事由());
        更正前Entity.set資格喪失日(計算後情報.get資格喪失日());
        更正前Entity.set資格喪失事由(計算後情報.get資格喪失事由());
        更正前Entity.set生活保護扶助種類(計算後情報.get生活保護扶助種類());
        更正前Entity.set生保開始日(計算後情報.get生保開始日());
        更正前Entity.set生保廃止日(計算後情報.get生保廃止日());
        更正前Entity.set老齢開始日(計算後情報.get老齢開始日());
        更正前Entity.set老齢廃止日(計算後情報.get老齢廃止日());
        更正前Entity.set賦課期日(計算後情報.get賦課期日());
        更正前Entity.set課税区分(計算後情報.get課税区分());
        更正前Entity.set世帯課税区分(計算後情報.get世帯課税区分());
        更正前Entity.set合計所得金額(計算後情報.get合計所得金額());
        更正前Entity.set公的年金収入額(計算後情報.get公的年金収入額());
        更正前Entity.set保険料段階(計算後情報.get保険料段階());
        更正前Entity.set保険料算定段階1(計算後情報.get保険料算定段階1());
        更正前Entity.set算定年額保険料1(計算後情報.get算定年額保険料1());
        更正前Entity.set月割開始年月1(計算後情報.get月割開始年月1());
        更正前Entity.set月割終了年月1(計算後情報.get月割終了年月1());
        更正前Entity.set保険料算定段階2(計算後情報.get保険料算定段階2());
        更正前Entity.set算定年額保険料2(計算後情報.get算定年額保険料2());
        更正前Entity.set月割開始年月2(計算後情報.get月割開始年月2());
        更正前Entity.set月割終了年月2(計算後情報.get月割終了年月2());
        更正前Entity.set調定日時(計算後情報.get調定日時());
        更正前Entity.set調定事由1(計算後情報.get調定事由1());
        更正前Entity.set調定事由2(計算後情報.get調定事由2());
        更正前Entity.set調定事由3(計算後情報.get調定事由3());
        更正前Entity.set調定事由4(計算後情報.get調定事由4());
        更正前Entity.set更正月(計算後情報.get更正月());
        更正前Entity.set減免前介護保険料_年額(計算後情報.get減免前介護保険料_年額());
        更正前Entity.set減免額(計算後情報.get減免額());
        更正前Entity.set確定介護保険料_年額(計算後情報.get確定介護保険料_年額());
        更正前Entity.set保険料段階_仮算定時(計算後情報.get保険料段階_仮算定時());
        更正前Entity.set徴収方法履歴番号(計算後情報.get徴収方法履歴番号());
        更正前Entity.set異動基準日時(計算後情報.get異動基準日時());
        更正前Entity.set口座区分(計算後情報.get口座区分());
        更正前Entity.set境界層区分(計算後情報.get境界層区分());
        更正前Entity.set職権区分(計算後情報.get職権区分());
        更正前Entity.set賦課市町村コード(計算後情報.get賦課市町村コード());
        更正前Entity.set特徴歳出還付額(計算後情報.get特徴歳出還付額());
        更正前Entity.set普徴歳出還付額(計算後情報.get普徴歳出還付額());
        更正前Entity.set特徴期別金額01(計算後情報.get特徴期別金額01());
        更正前Entity.set特徴期別金額02(計算後情報.get特徴期別金額02());
        更正前Entity.set特徴期別金額03(計算後情報.get特徴期別金額03());
        更正前Entity.set特徴期別金額04(計算後情報.get特徴期別金額04());
        更正前Entity.set特徴期別金額05(計算後情報.get特徴期別金額05());
        更正前Entity.set特徴期別金額06(計算後情報.get特徴期別金額06());
        更正前Entity.set普徴期別金額01(計算後情報.get普徴期別金額01());
        更正前Entity.set普徴期別金額02(計算後情報.get普徴期別金額02());
        更正前Entity.set普徴期別金額03(計算後情報.get普徴期別金額03());
        更正前Entity.set普徴期別金額04(計算後情報.get普徴期別金額04());
        更正前Entity.set普徴期別金額05(計算後情報.get普徴期別金額05());
        更正前Entity.set普徴期別金額06(計算後情報.get普徴期別金額06());
        更正前Entity.set普徴期別金額07(計算後情報.get普徴期別金額07());
        更正前Entity.set普徴期別金額08(計算後情報.get普徴期別金額08());
        更正前Entity.set普徴期別金額09(計算後情報.get普徴期別金額09());
        更正前Entity.set普徴期別金額10(計算後情報.get普徴期別金額10());
        更正前Entity.set普徴期別金額11(計算後情報.get普徴期別金額11());
        更正前Entity.set普徴期別金額12(計算後情報.get普徴期別金額12());
        更正前Entity.set普徴期別金額13(計算後情報.get普徴期別金額13());
        更正前Entity.set普徴期別金額14(計算後情報.get普徴期別金額14());
        更正前Entity.set徴収方法4月(計算後情報.get徴収方法4月());
        更正前Entity.set徴収方法5月(計算後情報.get徴収方法5月());
        更正前Entity.set徴収方法6月(計算後情報.get徴収方法6月());
        更正前Entity.set徴収方法7月(計算後情報.get徴収方法7月());
        更正前Entity.set徴収方法8月(計算後情報.get徴収方法8月());
        更正前Entity.set徴収方法9月(計算後情報.get徴収方法9月());
        更正前Entity.set徴収方法10月(計算後情報.get徴収方法10月());
        更正前Entity.set徴収方法11月(計算後情報.get徴収方法11月());
        更正前Entity.set徴収方法12月(計算後情報.get徴収方法12月());
        更正前Entity.set徴収方法1月(計算後情報.get徴収方法1月());
        更正前Entity.set徴収方法2月(計算後情報.get徴収方法2月());
        更正前Entity.set徴収方法3月(計算後情報.get徴収方法3月());
        更正前Entity.set徴収方法翌4月(計算後情報.get徴収方法翌4月());
        更正前Entity.set徴収方法翌5月(計算後情報.get徴収方法翌5月());
        更正前Entity.set徴収方法翌6月(計算後情報.get徴収方法翌6月());
        更正前Entity.set徴収方法翌7月(計算後情報.get徴収方法翌7月());
        更正前Entity.set徴収方法翌8月(計算後情報.get徴収方法翌8月());
        更正前Entity.set徴収方法翌9月(計算後情報.get徴収方法翌9月());
        更正前Entity.set仮徴収_基礎年金番号(計算後情報.get仮徴収_基礎年金番号());
        更正前Entity.set仮徴収_年金コード(計算後情報.get仮徴収_年金コード());
        更正前Entity.set仮徴収_捕捉月(計算後情報.get仮徴収_捕捉月());
        更正前Entity.set本徴収_基礎年金番号(計算後情報.get本徴収_基礎年金番号());
        更正前Entity.set本徴収_年金コード(計算後情報.get本徴収_年金コード());
        更正前Entity.set本徴収_捕捉月(計算後情報.get本徴収_捕捉月());
        更正前Entity.set翌年度仮徴収_基礎年金番号(計算後情報.get翌年度仮徴収_基礎年金番号());
        更正前Entity.set翌年度仮徴収_年金コード(計算後情報.get翌年度仮徴収_年金コード());
        更正前Entity.set翌年度仮徴収_捕捉月(計算後情報.get翌年度仮徴収_捕捉月());
        更正前Entity.set依頼情報送付済みフラグ(計算後情報.is依頼情報送付済みフラグ());
        更正前Entity.set追加依頼情報送付済みフラグ(計算後情報.is追加依頼情報送付済みフラグ());
        更正前Entity.set特別徴収停止日時(計算後情報.get特別徴収停止日時());
        更正前Entity.set特別徴収停止事由コード(計算後情報.get特別徴収停止事由コード());
        更正前Entity.set特徴収入額01(計算後情報.get特徴収入額01());
        更正前Entity.set特徴収入額02(計算後情報.get特徴収入額02());
        更正前Entity.set特徴収入額03(計算後情報.get特徴収入額03());
        更正前Entity.set特徴収入額04(計算後情報.get特徴収入額04());
        更正前Entity.set特徴収入額05(計算後情報.get特徴収入額05());
        更正前Entity.set特徴収入額06(計算後情報.get特徴収入額06());
        更正前Entity.set普徴収入額01(計算後情報.get普徴収入額01());
        更正前Entity.set普徴収入額02(計算後情報.get普徴収入額02());
        更正前Entity.set普徴収入額03(計算後情報.get普徴収入額03());
        更正前Entity.set普徴収入額04(計算後情報.get普徴収入額04());
        更正前Entity.set普徴収入額05(計算後情報.get普徴収入額05());
        更正前Entity.set普徴収入額06(計算後情報.get普徴収入額06());
        更正前Entity.set普徴収入額07(計算後情報.get普徴収入額07());
        更正前Entity.set普徴収入額08(計算後情報.get普徴収入額08());
        更正前Entity.set普徴収入額09(計算後情報.get普徴収入額09());
        更正前Entity.set普徴収入額10(計算後情報.get普徴収入額10());
        更正前Entity.set普徴収入額11(計算後情報.get普徴収入額11());
        更正前Entity.set普徴収入額12(計算後情報.get普徴収入額12());
        更正前Entity.set普徴収入額13(計算後情報.get普徴収入額13());
        更正前Entity.set普徴収入額14(計算後情報.get普徴収入額14());
        更正前Entity.set宛名Entity(entity.get宛名());
        更正前Entity.set口座Entity(entity.get口座());
        return 更正前Entity;
    }

    private void set月別取得段階(KeisanjohoAtenaKozaEntity entity,
            List<RString> 月別所得段階リスト) {
        FlexibleYearMonth 月割開始年月1 = entity.get月割開始年月1();
        FlexibleYearMonth 月割終了年月1 = entity.get月割終了年月1();
        RString 保険料算定段階1 = entity.get保険料算定段階1();
        int 開始月1 = 月割開始年月1.getMonthValue();
        int 終了月1 = 月割終了年月1.getMonthValue();
        List<RString> 月別所得段階リスト1 = new ArrayList<>();
        set月別取得段階(開始月1, 終了月1, 保険料算定段階1, 月別所得段階リスト1);

        FlexibleYearMonth 月割開始年月2 = entity.get月割開始年月2();
        FlexibleYearMonth 月割終了年月2 = entity.get月割終了年月2();

        RString 保険料算定段階2 = entity.get保険料算定段階2();
        if (月割開始年月2 == null || 月割開始年月2.isEmpty()
                || 月割終了年月2 == null || 月割終了年月2.isEmpty()
                || 保険料算定段階2 == null || 保険料算定段階2.isEmpty()) {
            return;
        }
        int 開始月2 = 月割開始年月2.getMonthValue();
        int 終了月2 = 月割終了年月2.getMonthValue();
        List<RString> 月別所得段階リスト2 = new ArrayList<>();
        set月別取得段階(開始月2, 終了月2, 保険料算定段階2, 月別所得段階リスト2);
        int count = 0;
        for (int i = 0; i < 月別所得段階リスト1.size(); i++) {
            count = count + INT_1;
            if (!月別所得段階リスト1.get(i).isEmpty()) {
                break;
            }
            月別所得段階リスト.add(月別所得段階リスト1.get(i));
        }
        for (int i = count; i < 月別所得段階リスト1.size(); i++) {
            count = count + INT_1;
            if (月別所得段階リスト1.get(i).isEmpty()) {
                break;
            }
            月別所得段階リスト.add(月別所得段階リスト1.get(i));
        }
        for (int i = count; i < 月別所得段階リスト1.size(); i++) {
            月別所得段階リスト.add(月別所得段階リスト1.get(i));
            if (月別所得段階リスト1.get(i).isEmpty()) {
                for (int j = i; j < 月別所得段階リスト2.size(); j++) {
                    月別所得段階リスト.add(月別所得段階リスト2.get(j));
                }
                break;
            }
        }
    }

    private void set月別取得段階(int 開始月, int 終了月,
            RString 保険料算定段階, List<RString> 月別所得段階リスト) {
        for (int i = 開始月; i <= (開始月 > 終了月 ? (終了月 + INT_12) : 終了月); i++) {
            int currentMonth = (i - 1) % INT_12 + 1;
            set保険料算定段階(currentMonth, 保険料算定段階, 月別所得段階リスト);
        }
    }

    private void set保険料算定段階(int currentMonth, RString 保険料算定段階,
            List<RString> 月別所得段階リスト) {

        if (currentMonth == INT_1) {
            月別所得段階リスト.add(保険料算定段階);
        } else {
            月別所得段階リスト.add(RString.EMPTY);
        }
        if (currentMonth == INT_2) {
            月別所得段階リスト.add(保険料算定段階);
        } else {
            月別所得段階リスト.add(RString.EMPTY);
        }
        if (currentMonth == INT_3) {
            月別所得段階リスト.add(保険料算定段階);
        } else {
            月別所得段階リスト.add(RString.EMPTY);
        }
        if (currentMonth == INT_4) {
            月別所得段階リスト.add(保険料算定段階);
        } else {
            月別所得段階リスト.add(RString.EMPTY);
        }
        if (currentMonth == INT_5) {
            月別所得段階リスト.add(保険料算定段階);
        } else {
            月別所得段階リスト.add(RString.EMPTY);
        }
        if (currentMonth == INT_6) {
            月別所得段階リスト.add(保険料算定段階);
        } else {
            月別所得段階リスト.add(RString.EMPTY);
        }
        if (currentMonth == INT_7) {
            月別所得段階リスト.add(保険料算定段階);
        } else {
            月別所得段階リスト.add(RString.EMPTY);
        }
        if (currentMonth == INT_8) {
            月別所得段階リスト.add(保険料算定段階);
        } else {
            月別所得段階リスト.add(RString.EMPTY);
        }
        if (currentMonth == INT_9) {
            月別所得段階リスト.add(保険料算定段階);
        } else {
            月別所得段階リスト.add(RString.EMPTY);
        }
        if (currentMonth == INT_10) {
            月別所得段階リスト.add(保険料算定段階);
        } else {
            月別所得段階リスト.add(RString.EMPTY);
        }
        if (currentMonth == INT_11) {
            月別所得段階リスト.add(保険料算定段階);
        } else {
            月別所得段階リスト.add(RString.EMPTY);
        }
        if (currentMonth == INT_12) {
            月別所得段階リスト.add(保険料算定段階);
        } else {
            月別所得段階リスト.add(RString.EMPTY);
        }

    }

    private RString set徴収方法(KeisanjohoAtenaKozaEntity 計算後情報Entity) {
        Decimal 本算定特徴期合計 = nullTOZero(計算後情報Entity.get特徴期別金額01())
                .add(nullTOZero(計算後情報Entity.get特徴期別金額02()))
                .add(nullTOZero(計算後情報Entity.get特徴期別金額03()))
                .add(nullTOZero(計算後情報Entity.get特徴期別金額04()))
                .add(nullTOZero(計算後情報Entity.get特徴期別金額05()))
                .add(nullTOZero(計算後情報Entity.get特徴期別金額06()));
        Decimal 本算定普徴期合計 = nullTOZero(計算後情報Entity.get普徴期別金額01())
                .add(nullTOZero(計算後情報Entity.get普徴期別金額02()))
                .add(nullTOZero(計算後情報Entity.get普徴期別金額03()))
                .add(nullTOZero(計算後情報Entity.get普徴期別金額04()))
                .add(nullTOZero(計算後情報Entity.get普徴期別金額05()))
                .add(nullTOZero(計算後情報Entity.get普徴期別金額06()))
                .add(nullTOZero(計算後情報Entity.get普徴期別金額07()))
                .add(nullTOZero(計算後情報Entity.get普徴期別金額08()))
                .add(nullTOZero(計算後情報Entity.get普徴期別金額09()))
                .add(nullTOZero(計算後情報Entity.get普徴期別金額10()))
                .add(nullTOZero(計算後情報Entity.get普徴期別金額11()))
                .add(nullTOZero(計算後情報Entity.get普徴期別金額12()))
                .add(nullTOZero(計算後情報Entity.get普徴期別金額13()))
                .add(nullTOZero(計算後情報Entity.get普徴期別金額14()));
        if (本算定特徴期合計.compareTo(Decimal.ZERO) == 0
                && 本算定普徴期合計.compareTo(Decimal.ZERO) == 0) {
            return RString.EMPTY;
        } else if (本算定特徴期合計.compareTo(Decimal.ZERO) == INT_1
                && 本算定普徴期合計.compareTo(Decimal.ZERO) == 0) {
            return 定値_特別徴収;
        } else if (本算定特徴期合計.compareTo(Decimal.ZERO) == 0
                && 本算定普徴期合計.compareTo(Decimal.ZERO) == INT_1) {
            return 定値_普通徴収;
        } else {
            return 定値_併用徴収;
        }
    }

    private void toBodyList(List<RString> bodyList) {
        for (int i = 0; i < bodyList.size(); i++) {
            if (bodyList.get(i) == null) {
                bodyList.remove(bodyList.get(i));
                bodyList.add(i, RString.EMPTY);
            }
        }
    }

    private void set特徴期別金額(Kibetsu kibetsu, List<Decimal> 特徴期別金額, List<KibetsuEntity> 介護期別RelateEntity) {
        switch (kibetsu.get期()) {
            case INT_1:
                set期別金額(kibetsu, 特徴期別金額.get(0), 介護期別RelateEntity);
                break;
            case INT_2:
                set期別金額(kibetsu, 特徴期別金額.get(INT_1), 介護期別RelateEntity);
                break;
            case INT_3:
                set期別金額(kibetsu, 特徴期別金額.get(INT_2), 介護期別RelateEntity);
                break;
            case INT_4:
                set期別金額(kibetsu, 特徴期別金額.get(INT_3), 介護期別RelateEntity);
                break;
            case INT_5:
                set期別金額(kibetsu, 特徴期別金額.get(INT_4), 介護期別RelateEntity);
                break;
            case INT_6:
                set期別金額(kibetsu, 特徴期別金額.get(INT_5), 介護期別RelateEntity);
                break;
            default:
        }
    }

    private void set普徴期別金額(Kibetsu kibetsu, List<Decimal> 普徴期別金額, List<KibetsuEntity> 介護期別RelateEntity) {
        switch (kibetsu.get期()) {
            case INT_1:
                set期別金額(kibetsu, 普徴期別金額.get(0), 介護期別RelateEntity);
                break;
            case INT_2:
                set期別金額(kibetsu, 普徴期別金額.get(INT_1), 介護期別RelateEntity);
                break;
            case INT_3:
                set期別金額(kibetsu, 普徴期別金額.get(INT_2), 介護期別RelateEntity);
                break;
            case INT_4:
                set期別金額(kibetsu, 普徴期別金額.get(INT_3), 介護期別RelateEntity);
                break;
            case INT_5:
                set期別金額(kibetsu, 普徴期別金額.get(INT_4), 介護期別RelateEntity);
                break;
            case INT_6:
                set期別金額(kibetsu, 普徴期別金額.get(INT_5), 介護期別RelateEntity);
                break;
            case INT_7:
                set期別金額(kibetsu, 普徴期別金額.get(INT_6), 介護期別RelateEntity);
                break;
            case INT_8:
                set期別金額(kibetsu, 普徴期別金額.get(INT_7), 介護期別RelateEntity);
                break;
            case INT_9:
                set期別金額(kibetsu, 普徴期別金額.get(INT_8), 介護期別RelateEntity);
                break;
            case INT_10:
                set期別金額(kibetsu, 普徴期別金額.get(INT_9), 介護期別RelateEntity);
                break;
            case INT_11:
                set期別金額(kibetsu, 普徴期別金額.get(INT_10), 介護期別RelateEntity);
                break;
            case INT_12:
                set期別金額(kibetsu, 普徴期別金額.get(INT_11), 介護期別RelateEntity);
                break;
            case INT_13:
                set期別金額(kibetsu, 普徴期別金額.get(INT_12), 介護期別RelateEntity);
                break;
            case INT_14:
                set期別金額(kibetsu, 普徴期別金額.get(INT_13), 介護期別RelateEntity);
                break;
            default:
        }
    }

    private void set期別金額(Kibetsu kibetsu, Decimal 期別金額, List<KibetsuEntity> 介護期別RelateEntity) {
        if (kibetsu.getChoteiKyotsuList() != null && !kibetsu.getChoteiKyotsuList().isEmpty()) {
            KibetsuEntity relateEntity = new KibetsuEntity();
            relateEntity.set介護期別Entity(kibetsu.toEntity());
            UrT0705ChoteiKyotsuEntity entity = kibetsu.getChoteiKyotsuList().get(0).toEntity();
            entity.setChoteigaku(期別金額);
            List<UrT0705ChoteiKyotsuEntity> entityList = new ArrayList<>();
            entityList.add(entity);
            relateEntity.set調定共通Entity(entityList);
            介護期別RelateEntity.add(relateEntity);
        }
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
        if (使用する.equals(未申告段階使用)) {
            未申告段階使用有無 = true;
        } else if (使用しない.equals(未申告段階使用)) {
            未申告段階使用有無 = false;
        }
        RString 未申告段階インデックス = DbBusinessConfig.get(ConfigNameDBB.賦課基準_未申告保険料段階インデックス,
                nowDate, SubGyomuCode.DBB介護賦課);
        RString 未申告課税区分 = DbBusinessConfig.get(ConfigNameDBB.賦課基準_未申告課税区分,
                nowDate, SubGyomuCode.DBB介護賦課);
        RString 所得調査中段階使用 = DbBusinessConfig.get(ConfigNameDBB.賦課基準_所得調査中保険料段階使用,
                nowDate, SubGyomuCode.DBB介護賦課);
        boolean 所得調査中段階使用有無 = false;
        if (使用する.equals(所得調査中段階使用)) {
            所得調査中段階使用有無 = true;
        } else if (使用しない.equals(所得調査中段階使用)) {
            所得調査中段階使用有無 = false;
        }
        RString 所得調査中段階インデックス = DbBusinessConfig.get(ConfigNameDBB.賦課基準_所得調査中保険料段階インデックス,
                nowDate, SubGyomuCode.DBB介護賦課);
        RString 所得調査中課税区分 = DbBusinessConfig.get(ConfigNameDBB.賦課基準_所得調査中課税区分,
                nowDate, SubGyomuCode.DBB介護賦課);
        RString 課税取消段階使用 = DbBusinessConfig.get(ConfigNameDBB.賦課基準_課税取消保険料段階使用,
                nowDate, SubGyomuCode.DBB介護賦課);
        boolean 課税取消段階使用有無 = false;
        if (使用する.equals(課税取消段階使用)) {
            課税取消段階使用有無 = true;
        } else if (使用しない.equals(課税取消段階使用)) {
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
        Map<RString, RankBetsuKijunKingaku> ランク別制御情報 = new HashMap<RString, RankBetsuKijunKingaku>();

        // TODO QAのNo.957　「ランク別制御情報」の設定方法がない。
//        RankBetsuKijunKingaku gaku = new RankBetsuKijunKingaku();
//        gaku.setランク基準金額1(Decimal.ONE);
//        gaku.setランク基準金額2(Decimal.ONE);
//        ランク別制御情報.put(new RString("01"), gaku);
//        ランク別制御情報.put(new RString("1"), gaku);
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

}
