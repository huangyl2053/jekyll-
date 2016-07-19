/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.honnsanteifuka;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.business.core.basic.KeisangoJoho;
import jp.co.ndensan.reams.db.dbb.business.core.choshuyuyo.honnsanteifuka.CalculateChoteiResult;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.ShikakuKikan;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.ShikakuKikanJoho;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.fukakeisan.FukaKokyoBatchParameter;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.choteikyotsu.ChoteiKyotsu;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.choteikyotsu.ChoteiKyotsuBuilder;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJoho;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJohoBuilder;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.kibetsu.Kibetsu;
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
import jp.co.ndensan.reams.db.dbb.business.report.honsanteikekkaicihiran.HonsanteiKekkaIcihiranProperty.DBB200009ShutsuryokujunEnum;
import jp.co.ndensan.reams.db.dbb.definition.core.choshuhoho.ChoshuHohoKibetsu;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.ErrorCode;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.HasuChoseiHoho;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.HasuChoseiTaisho;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.KozaKubun;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.ShokkenKubun;
import jp.co.ndensan.reams.db.dbb.definition.core.honnsanteifuka.CaluculateFukaParameter;
import jp.co.ndensan.reams.db.dbb.definition.core.honnsanteifuka.HonsenteiKeisangojohoParameter;
import jp.co.ndensan.reams.db.dbb.definition.core.honnsanteifuka.KeisanTaishoshaParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2010FukaErrorListEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fuka.SetaiShotokuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajoho.fukajoho.FukaJohoRelateEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.honnsanteifuka.HonSanJonTyuShutuTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.honnsanteifuka.HonsenteiKeisangojohoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.honnsanteifuka.KakuShugyoumuJouHouEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.honnsanteifuka.KeisangojohoAtenaKozaEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.honnsanteifuka.KuBunnGaTsurakuTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.honnsanteifuka.SetaiHaakuShuturyokuEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2010FukaErrorListDac;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.honnsanteifuka.IHonnSanteiFukaMapper;
import jp.co.ndensan.reams.db.dbb.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbb.service.core.choshuhoho.ChoshuHohoKoshin;
import jp.co.ndensan.reams.db.dbb.service.core.fuka.SetaiShotokuKazeiHantei;
import jp.co.ndensan.reams.db.dbb.service.core.fuka.fukakeisan.FukaKeisan;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.HokenryoDankaiSettings;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.HokenryoRank;
import jp.co.ndensan.reams.db.dbb.service.report.honsanteikekkaicihiran.HonsanteiKekkaIcihiranPrintService;
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
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2003KibetsuEntity;
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
import jp.co.ndensan.reams.db.dbz.business.core.hihokensha.seikatsuhogojukyusha.SeikatsuHogoJukyusha;
import jp.co.ndensan.reams.db.dbz.business.core.kanri.JushoHenshu;
import jp.co.ndensan.reams.db.dbz.business.core.kyokaisogaitosha.kyokaisogaitosha.KyokaisoGaitosha;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.SetaiinHaakuKanriShikibetsuKubun;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7006RoreiFukushiNenkinJukyushaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7065ChohyoSeigyoKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.hihokensha.seikatsuhogojukyusha.SeikatsuHogoJukyushaRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.kyokaisogaitosha.KyokaisoGaitoshaEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7065ChohyoSeigyoKyotsuDac;
import jp.co.ndensan.reams.ua.uax.business.core.koza.IKoza;
import jp.co.ndensan.reams.ua.uax.business.core.koza.Koza;
import jp.co.ndensan.reams.ua.uax.business.core.koza.KozaSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.definition.core.valueobject.code.KozaYotoKubunCodeValue;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.IKozaSearchKey;
import jp.co.ndensan.reams.ua.uax.entity.db.relate.KozaRelateEntity;
import jp.co.ndensan.reams.ur.urc.service.core.shunokamoku.authority.ShunoKamokuAuthority;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
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
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
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
import jp.co.ndensan.reams.uz.uza.lang.RDate;
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
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 本算定賦課バッチのクラス
 *
 * @reamsid_L DBB-0730-020 lijunjun
 */
public class HonnSanteiFuka {

    private final MapperProvider mapperProvider;
    private final DbV2001ChoshuHohoAliveDac 徴収方法Dac;
    private final DbT7065ChohyoSeigyoKyotsuDac 帳票制御共通Dac;
    private final DbT2001ChoshuHohoDac 介護徴収方法Dac;
    private final DbT2010FukaErrorListDac 賦課エラーDac;
    private final DbT2002FukaDac 介護賦課Dac;
    private final DbT2003KibetsuDac 介護期別Dac;
    private final DbT7022ShoriDateKanriDac 処理日付管理Dac;
    private final UrT0705ChoteiKyotsuDac choteiKyotsuDac;
    private static final RString T5 = new RString("T5");
    private static final RString SIGN = new RString(" ＞ ");
    private static final RString FROMAT = new RString("%02d");
    private static final RString ゼロ_0000 = new RString("0000");
    private static final RString 合併情報区分_合併あり = new RString("1");
    private static final RString バッチID = new RString("DBBBT43001");
    private static final RString 内部帳票ID = new RString("DBB400001_FukaErrorIchitan");
    private static final RString 使用する = new RString("1");
    private static final RString 使用しない = new RString("0");
    private static final ReportId 帳票ID = new ReportId("DBB200009_HonsanteiKekkaIcihiran");
    private static final RString FORMAT_LEFT = new RString("【");
    private static final RString FORMAT_RIGHT = new RString("】");
    private static final RString 定数_賦課年度 = new RString("賦課年度");
    private static final RString 定数_調定年度 = new RString("調定年度");
    private static final RString 年度 = new RString("年度");
    private static final RString 定数_出力順 = new RString("出力順");
    private static final RString CSV出力有無_有り = new RString("有り");
    private static final RString CSVファイル名_一覧表 = new RString("本算定結果一覧表");
    private static final RString 本算定_EUCファイル名 = new RString("HonsanteiKekkaIcihiranData.csv");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBB200009");
    private static final RString カンマ = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString 本算定賦課 = new RString("A1");
    private static final RString 年金保険者からの通知 = new RString("T1");
    private static final RString 保険料額の減額変更 = new RString("T2");
    private static final RString 徴収方法修正 = new RString("T3");
    private static final RString 特別徴収対象者外 = new RString("T4");
    private static final RString 資格喪失特徴中止 = new RString("T5");
    private static final RString ゆうちょ銀行 = new RString("9900");
    private static final RString HYPHEN = new RString("-");
    private static final Code CODE = new Code("0");
    private final RString 特別徴収 = new RString("特別徴収");
    private final RString 普通徴収 = new RString("普通徴収");
    private final RString 併用徴収 = new RString("併用徴収");
    private final RString 本算定賦課なし = new RString("本算定賦課なし");
    private final RString 本算定前半普徴 = new RString("本算定前半普徴");
    private static final RString タイトル_作成年月日 = new RString("作成年月日");
    private static final RString タイトル_作成時刻 = new RString("作成時刻");
    private static final RString タイトル_賦課年度 = new RString("賦課年度");
    private static final RString タイトル_通知書番号 = new RString("通知書番号");
    private static final RString タイトル_被保険者番号 = new RString("被保険者番号");
    private static final RString タイトル_氏名 = new RString("氏名");
    private static final RString タイトル_生年月日 = new RString("生年月日");
    private static final RString タイトル_性別 = new RString("性別");
    private static final RString タイトル_識別コード = new RString("識別コード");
    private static final RString タイトル_世帯コード = new RString("世帯コード");
    private static final RString タイトル_町域コード = new RString("町域コード");
    private static final RString タイトル_郵便番号 = new RString("郵便番号");
    private static final RString タイトル_住所 = new RString("住所");
    private static final RString タイトル_町域管内管外住所 = new RString("町域（管内）・管外住所");
    private static final RString タイトル_番地 = new RString("番地");
    private static final RString タイトル_口座情報 = new RString("口座情報");
    private static final RString タイトル_資格取得日 = new RString("資格取得日");
    private static final RString タイトル_資格喪失日 = new RString("資格喪失日");
    private static final RString タイトル_資格期間 = new RString("資格期間");
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
    private static final RString タイトル_徴収方法 = new RString("徴収方法");
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
    private static final RString タイトル_備考 = new RString("備考");
    private static final int NUM_負1 = -1;
    private static final int 四月 = 4;
    private static final int NUM_0 = 0;
    private static final int NUM_1 = 1;
    private static final int NUM_2 = 2;
    private static final int NUM_3 = 3;
    private static final int NUM_4 = 4;
    private static final int NUM_5 = 5;
    private static final int NUM_6 = 6;
    private static final int NUM_7 = 7;
    private static final int NUM_8 = 8;
    private static final int NUM_9 = 9;
    private static final int NUM_10 = 10;
    private static final int NUM_11 = 11;
    private static final int NUM_12 = 12;
    private static final int NUM_13 = 13;
    private static final int NUM_14 = 14;

    /**
     * コンストラクタです。
     */
    public HonnSanteiFuka() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.処理日付管理Dac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
        this.徴収方法Dac = InstanceProvider.create(DbV2001ChoshuHohoAliveDac.class);
        this.介護徴収方法Dac = InstanceProvider.create(DbT2001ChoshuHohoDac.class);
        this.賦課エラーDac = InstanceProvider.create(DbT2010FukaErrorListDac.class);
        this.帳票制御共通Dac = InstanceProvider.create(DbT7065ChohyoSeigyoKyotsuDac.class);
        this.介護賦課Dac = InstanceProvider.create(DbT2002FukaDac.class);
        this.介護期別Dac = InstanceProvider.create(DbT2003KibetsuDac.class);
        this.choteiKyotsuDac = InstanceProvider.create(UrT0705ChoteiKyotsuDac.class);
    }

    /**
     * コンストラクタです。
     *
     * @param mapperProvider MapperProvider
     * @param 徴収方法Dac DbV2001ChoshuHohoAliveDac
     * @param 帳票制御共通Dac DbT7065ChohyoSeigyoKyotsuDac
     * @param 介護徴収方法Dac DbT2001ChoshuHohoDac
     * @param 賦課エラーDac DbT2010FukaErrorListDac
     * @param 介護賦課Dac DbT2002FukaDac
     * @param 介護期別Dac DbT2003KibetsuDac
     * @param choteiKyotsuDac UrT0705ChoteiKyotsuDac
     */
    HonnSanteiFuka(MapperProvider mapperProvider,
            DbV2001ChoshuHohoAliveDac 徴収方法Dac,
            DbT7065ChohyoSeigyoKyotsuDac 帳票制御共通Dac,
            DbT2001ChoshuHohoDac 介護徴収方法Dac,
            DbT2010FukaErrorListDac 賦課エラーDac,
            DbT2002FukaDac 介護賦課Dac,
            DbT2003KibetsuDac 介護期別Dac,
            UrT0705ChoteiKyotsuDac choteiKyotsuDac,
            DbT7022ShoriDateKanriDac 処理日付管理Dac) {
        this.mapperProvider = mapperProvider;
        this.徴収方法Dac = 徴収方法Dac;
        this.帳票制御共通Dac = 帳票制御共通Dac;
        this.介護徴収方法Dac = 介護徴収方法Dac;
        this.賦課エラーDac = 賦課エラーDac;
        this.介護賦課Dac = 介護賦課Dac;
        this.介護期別Dac = 介護期別Dac;
        this.choteiKyotsuDac = choteiKyotsuDac;
        this.処理日付管理Dac = 処理日付管理Dac;
    }

    /**
     * にて生成した{@link HonnSanteiFuka}のインスタンスを返します。
     *
     * @return FukaKeisan
     */
    public static HonnSanteiFuka createInstance() {
        return InstanceProvider.create(HonnSanteiFuka.class);
    }

    /**
     * 本算定特徴中止者追加のメソッド
     *
     * @param 賦課年度 FlexibleYear
     * @param 処理日時 YMDHMS
     */
    public void insertHonsanteiTokuchoChushisha(FlexibleYear 賦課年度, YMDHMS 処理日時) {
        List<DbT2001ChoshuHohoEntity> 徴収方法情報リスト = 徴収方法Dac.select徴収方法情報(賦課年度);
        List<ChoshuHoho> 徴収方法情報List = new ArrayList<>();
        for (DbT2001ChoshuHohoEntity 徴収方法情報entity : 徴収方法情報リスト) {
            徴収方法情報entity.initializeMd5();
            徴収方法情報List.add(new ChoshuHoho(徴収方法情報entity));
        }
        DbT2001ChoshuHohoEntity 介護徴収方法Entity;
        for (ChoshuHoho 徴収方法entity : 徴収方法情報List) {
            介護徴収方法Entity = new DbT2001ChoshuHohoEntity();
            FlexibleYear fukaNendo = 徴収方法entity.get賦課年度();
            if (fukaNendo != null) {
                介護徴収方法Entity.setFukaNendo(fukaNendo);
            }
            HihokenshaNo hihokenshaNo = 徴収方法entity.get被保険者番号();
            if (hihokenshaNo != null) {
                介護徴収方法Entity.setHihokenshaNo(hihokenshaNo);
            }
            介護徴収方法Entity.setRirekiNo(徴収方法entity.get履歴番号() + 1);
            介護徴収方法Entity.setChoshuHoho4gatsu(徴収方法entity.get徴収方法4月());
            介護徴収方法Entity.setChoshuHoho5gatsu(徴収方法entity.get徴収方法5月());
            介護徴収方法Entity.setChoshuHoho6gatsu(徴収方法entity.get徴収方法6月());
            介護徴収方法Entity.setChoshuHoho7gatsu(徴収方法entity.get徴収方法7月());
            介護徴収方法Entity.setChoshuHoho8gatsu(徴収方法entity.get徴収方法8月());
            介護徴収方法Entity.setChoshuHoho9gatsu(徴収方法entity.get徴収方法9月());
            介護徴収方法Entity.setChoshuHoho10gatsu(徴収方法entity.get徴収方法10月());
            介護徴収方法Entity.setChoshuHoho11gatsu(徴収方法entity.get徴収方法11月());
            介護徴収方法Entity.setChoshuHoho12gatsu(徴収方法entity.get徴収方法12月());
            介護徴収方法Entity.setChoshuHoho1gatsu(徴収方法entity.get徴収方法1月());
            介護徴収方法Entity.setChoshuHoho2gatsu(徴収方法entity.get徴収方法2月());
            介護徴収方法Entity.setChoshuHoho3gatsu(徴収方法entity.get徴収方法3月());
            介護徴収方法Entity.setChoshuHohoYoku4gatsu(徴収方法entity.get徴収方法翌4月());
            介護徴収方法Entity.setChoshuHohoYoku5gatsu(徴収方法entity.get徴収方法翌5月());
            介護徴収方法Entity.setChoshuHohoYoku6gatsu(徴収方法entity.get徴収方法翌6月());
            介護徴収方法Entity.setChoshuHohoYoku7gatsu(徴収方法entity.get徴収方法翌7月());
            介護徴収方法Entity.setChoshuHohoYoku8gatsu(徴収方法entity.get徴収方法翌8月());
            介護徴収方法Entity.setChoshuHohoYoku9gatsu(徴収方法entity.get徴収方法翌9月());
            介護徴収方法Entity.setKariNenkinNo(徴収方法entity.get仮徴収_基礎年金番号());
            介護徴収方法Entity.setKariNenkinCode(徴収方法entity.get仮徴収_年金コード());
            介護徴収方法Entity.setKariHosokuM(徴収方法entity.get仮徴収_捕捉月());
            介護徴収方法Entity.setHonNenkinNo(徴収方法entity.get本徴収_基礎年金番号());
            介護徴収方法Entity.setHonNenkinCode(徴収方法entity.get本徴収_年金コード());
            介護徴収方法Entity.setHonHosokuM(徴収方法entity.get本徴収_捕捉月());
            介護徴収方法Entity.setYokunendoKariNenkinNo(徴収方法entity.get翌年度仮徴収_基礎年金番号());
            介護徴収方法Entity.setYokunendoKariNenkinCode(徴収方法entity.get翌年度仮徴収_年金コード());
            介護徴収方法Entity.setYokunendoKariHosokuM(徴収方法entity.get翌年度仮徴収_捕捉月());
            介護徴収方法Entity.setIraiSohuzumiFlag(徴収方法entity.is依頼情報送付済みフラグ());
            介護徴収方法Entity.setTsuikaIraiSohuzumiFlag(徴収方法entity.is追加依頼情報送付済みフラグ());
            介護徴収方法Entity.setTokuchoTeishiNichiji(処理日時);
            介護徴収方法Entity.setTokuchoTeishiJiyuCode(T5);
            介護徴収方法Entity.setState(EntityDataState.Added);
            介護徴収方法Dac.save(介護徴収方法Entity);
        }
    }

    /**
     * 計算対象者抽出・通知書番号発番
     *
     * @param 調定年度 FlexibleYear
     * @param 賦課年度 FlexibleYear
     * @param 資格基準日 RString
     */
    @Transaction
    public void selectKeisanTaishosha(FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            FlexibleDate 資格基準日) {
        FlexibleDate 賦課年度_修正後 = new FlexibleDate(賦課年度.getYearValue(), 四月, NUM_1);
        IHonnSanteiFukaMapper mapper = mapperProvider.create(IHonnSanteiFukaMapper.class);
        KeisanTaishoshaParameter parameter = KeisanTaishoshaParameter.createSelectByKeyParam(調定年度, 賦課年度, 資格基準日, 賦課年度_修正後);
        List<DbT1001HihokenshaDaichoEntity> 資格の情報 = mapper.select資格の情報(parameter);
        List<FukaJohoRelateEntity> 賦課の情報 = mapper.select賦課の情報(parameter);
        List<HihokenshaDaicho> 資格 = new ArrayList<>();
        HihokenshaNo fukaHihokenshaNo;
        HihokenshaNo daichoHihokenshaNo;
        //--------------------Test------------------------------//
        mapper.creat本算定抽出Temp();
        //--------------------Test------------------------------//
        for (DbT1001HihokenshaDaichoEntity daichoEntity : 資格の情報) {
            int count = 0;
            for (FukaJohoRelateEntity relateEntity : 賦課の情報) {
                fukaHihokenshaNo = relateEntity.get介護賦課Entity().getHihokenshaNo();
                daichoHihokenshaNo = daichoEntity.getHihokenshaNo();
                if (fukaHihokenshaNo != null && daichoHihokenshaNo != null) {
                    count = editor本算定抽出Temp(fukaHihokenshaNo, daichoHihokenshaNo, count,
                            daichoEntity, parameter, relateEntity, mapper);
                }
            }
            if (count == 0) {
                HonSanJonTyuShutuTempEntity entity = new HonSanJonTyuShutuTempEntity();
                set資格情報Entity(daichoEntity, entity, parameter);
                entity.setChoteiNendo(parameter.get調定年度());
                entity.setFukaNendo(parameter.get賦課年度());
                entity.setTsuchishoNo(create通知書番号(daichoEntity.getHihokenshaNo().getColumnValue(), count + 1));
                mapper.insert本算定抽出Temp(entity);
            }
            資格.add(new HihokenshaDaicho(daichoEntity));
        }
        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        if (市町村セキュリティ情報 != null && 市町村セキュリティ情報.get導入形態コード() != null
                && DonyuKeitaiCode.事務広域.getCode().equals(市町村セキュリティ情報.get導入形態コード().getKey())) {
            RString 合併情報区分 = DbBusinessConfig.get(ConfigNameDBU.合併情報管理_合併情報区分,
                    RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
            if (合併情報区分_合併あり.equals(合併情報区分)) {
                HokenryoRank rank = InstanceProvider.create(HokenryoRank.class);
                List<MonthShichoson> 月別ランク情報 = rank.get月別ランク情報(資格, parameter.get賦課年度());
                mapper.create月別ランクTemp();
                for (HihokenshaDaicho daicho : 資格) {
                    KuBunnGaTsurakuTempEntity tsurakuEntity = new KuBunnGaTsurakuTempEntity();
                    tsurakuEntity.setHihokenshaNo(daicho.get被保険者番号());
                    set月別ランク(tsurakuEntity, 月別ランク情報);
                    mapper.insert月別ランクTemp(tsurakuEntity);
                }
            }
        }
        set賦課情報Error(賦課の情報, 資格の情報, parameter);
    }

    private int editor本算定抽出Temp(HihokenshaNo fukaHihokenshaNo, HihokenshaNo daichoHihokenshaNo, int count,
            DbT1001HihokenshaDaichoEntity daichoEntity, KeisanTaishoshaParameter parameter,
            FukaJohoRelateEntity relateEntity, IHonnSanteiFukaMapper mapper) {
        if (fukaHihokenshaNo.equals(daichoHihokenshaNo)) {
            count = count + NUM_1;
            HonSanJonTyuShutuTempEntity entity = new HonSanJonTyuShutuTempEntity();
            set資格情報Entity(daichoEntity, entity, parameter);
            if (count == NUM_1) {
                entity.setChoteiNendo(relateEntity.get介護賦課Entity().getChoteiNendo());
                entity.setFukaNendo(relateEntity.get介護賦課Entity().getFukaNendo());
                entity.setTsuchishoNo(relateEntity.get介護賦課Entity().getTsuchishoNo());
            } else if (count > NUM_1) {
                entity.setChoteiNendo(parameter.get調定年度());
                entity.setFukaNendo(parameter.get賦課年度());
                entity.setTsuchishoNo(create通知書番号(daichoEntity.getHihokenshaNo().getColumnValue(), count));
            }
            mapper.insert本算定抽出Temp(entity);
        }
        return count;
    }

    private void set賦課情報Error(List<FukaJohoRelateEntity> 賦課の情報,
            List<DbT1001HihokenshaDaichoEntity> 資格情報List,
            KeisanTaishoshaParameter parameter) throws NullPointerException, IllegalArgumentException {
        List<HihokenshaNo> 被保険者番号List = new ArrayList<>();
        for (FukaJohoRelateEntity relateEntity : 賦課の情報) {
            被保険者番号List.add(relateEntity.get介護賦課Entity().getHihokenshaNo());
        }
        for (FukaJohoRelateEntity relateEntity : 賦課の情報) {
            boolean flg = true;
            for (DbT1001HihokenshaDaichoEntity daichoEntity : 資格情報List) {
                if (被保険者番号List.contains(daichoEntity.getHihokenshaNo())) {
                    flg = false;
                    break;
                }
            }
            if (flg) {
                DbT2010FukaErrorListEntity errorListEntity = new DbT2010FukaErrorListEntity();
                errorListEntity.setSubGyomuCode(SubGyomuCode.DBB介護賦課);
                errorListEntity.setInternalReportId(内部帳票ID);
                errorListEntity.setFukaNendo(parameter.get賦課年度());
                TsuchishoNo tsuchishoNo = relateEntity.get介護賦課Entity().getTsuchishoNo();
                if (tsuchishoNo != null) {
                    errorListEntity.setTsuchishoNo(tsuchishoNo);
                }
                YMDHMS choteiNichiji = relateEntity.get介護賦課Entity().getChoteiNichiji();
                if (choteiNichiji != null) {
                    errorListEntity.setInternalReportCreationDateTime(choteiNichiji.isEmpty()
                            ? null : choteiNichiji.getRDateTime());
                }
                errorListEntity.setBatchId(バッチID);
                errorListEntity.setBatchStartingDateTime(RDate.getNowDateTime());
                errorListEntity.setErrorCode(new Code(ErrorCode.被保険者台帳データなし.getコード()));
                errorListEntity.setHihokenshaNo(relateEntity.get介護賦課Entity().getHihokenshaNo());
                errorListEntity.setShikibetsuCode(relateEntity.get介護賦課Entity().getShikibetsuCode());
                errorListEntity.setShikakuShutokuYMD(relateEntity.get介護賦課Entity().getShikakuShutokuYMD());
                errorListEntity.setShikakuShutokuJiyu(relateEntity.get介護賦課Entity().getShikakuShutokuJiyu());
                errorListEntity.setShikakuSoshitsuYMD(relateEntity.get介護賦課Entity().getShikakuSoshitsuYMD());
                errorListEntity.setShikakuSoshitsuJiyu(relateEntity.get介護賦課Entity().getShikakuSoshitsuJiyu());
                errorListEntity.setState(EntityDataState.Added);
                賦課エラーDac.save(errorListEntity);
            }
        }
    }

    private void set月別ランク(KuBunnGaTsurakuTempEntity rankuEntity, List<MonthShichoson> 月別ランク情報リスト) {
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

    private void set資格情報Entity(DbT1001HihokenshaDaichoEntity daichoEntity, HonSanJonTyuShutuTempEntity entity,
            KeisanTaishoshaParameter param) {
        entity.setHihokenshaNo(daichoEntity.getHihokenshaNo());
        entity.setIdoYMD(daichoEntity.getIdoYMD());
        entity.setEdaNo(daichoEntity.getEdaNo());
        entity.setIdoJiyuCode(daichoEntity.getIdoJiyuCode());
        entity.setShichosonCode(daichoEntity.getShichosonCode());
        entity.setShikibetsuCode(daichoEntity.getShikibetsuCode());
        entity.setShikakuShutokuJiyuCode(daichoEntity.getShikakuShutokuJiyuCode());
        entity.setShikakuShutokuYMD(daichoEntity.getShikakuShutokuYMD());
        entity.setShikakuShutokuTodokedeYMD(daichoEntity.getShikakuShutokuTodokedeYMD());
        entity.setIchigoShikakuShutokuYMD(daichoEntity.getIchigoShikakuShutokuYMD());
        entity.setHihokennshaKubunCode(daichoEntity.getHihokennshaKubunCode());
        entity.setShikakuSoshitsuJiyuCode(daichoEntity.getShikakuSoshitsuJiyuCode());
        entity.setShikakuSoshitsuYMD(daichoEntity.getShikakuSoshitsuYMD());
        entity.setShikakuSoshitsuTodokedeYMD(daichoEntity.getShikakuSoshitsuTodokedeYMD());
        entity.setShikakuHenkoJiyuCode(daichoEntity.getShikakuHenkoJiyuCode());
        entity.setShikakuHenkoYMD(daichoEntity.getShikakuHenkoYMD());
        entity.setShikakuHenkoTodokedeYMD(daichoEntity.getShikakuHenkoTodokedeYMD());
        entity.setJushochitokureiTekiyoJiyuCode(daichoEntity.getJushochitokureiTekiyoJiyuCode());
        entity.setJushochitokureiTekiyoYMD(daichoEntity.getJushochitokureiTekiyoYMD());
        entity.setJushochitokureiTekiyoTodokedeYMD(daichoEntity.getJushochitokureiTekiyoTodokedeYMD());
        entity.setJushochitokureiKaijoJiyuCode(daichoEntity.getJushochitokureiKaijoJiyuCode());
        entity.setJushochitokureiKaijoYMD(daichoEntity.getJushochitokureiKaijoYMD());
        entity.setJushochitokureiKaijoTodokedeYMD(daichoEntity.getJushochitokureiKaijoTodokedeYMD());
        entity.setJushochiTokureiFlag(daichoEntity.getJushochiTokureiFlag());
        entity.setKoikinaiJushochiTokureiFlag(daichoEntity.getKoikinaiJushochiTokureiFlag());
        entity.setKoikinaiTokureiSochimotoShichosonCode(daichoEntity.getKoikinaiTokureiSochimotoShichosonCode());
        entity.setKyuShichosonCode(daichoEntity.getKyuShichosonCode());
        entity.setLogicalDeletedFlag(daichoEntity.getLogicalDeletedFlag());
        FlexibleDate fukaDate = new FlexibleDate(param.get賦課年度().getYearValue(), 四月, NUM_1);
        if (fukaDate.isBeforeOrEquals(daichoEntity.getShikakuShutokuYMD())) {
            entity.setKijunYMD(daichoEntity.getShikakuShutokuYMD());
        } else {
            entity.setKijunYMD(fukaDate);
        }
    }

    /**
     * 世帯員把握のメソッドです。
     */
    public void collectSetaiin() {

        IHonnSanteiFukaMapper mapper = mapperProvider.create(IHonnSanteiFukaMapper.class);
        List<SetaiHaakuShuturyokuEntity> 世帯員把握情報 = mapper.select世帯員把握();
        //--------------------------Test----------------------//
        mapper.create世帯員把握入力テーブル();
        //--------------------------Test----------------------//
        for (SetaiHaakuShuturyokuEntity shutuPartEntity : 世帯員把握情報) {
            mapper.insert世帯員把握入力テーブル(shutuPartEntity);
        }
        //  「バッチ設計_DBBBT00001_世帯把握（バッチ）」を呼び出し
        SetaiShotokuKazeiHantei hantei = SetaiShotokuKazeiHantei.createInstance();
        hantei.getSetaiinHaaku(SetaiinHaakuKanriShikibetsuKubun.賦課.getコード());
        hantei.getJuminShotokuJoho();
    }

    /**
     * テスト用
     */
    public void testCreateTBL() {
        IHonnSanteiFukaMapper mapper = mapperProvider.create(IHonnSanteiFukaMapper.class);
//        mapper.create月別ランクTemp();
        KuBunnGaTsurakuTempEntity rankuEntity = new KuBunnGaTsurakuTempEntity();
        rankuEntity.setHihokenshaNo(new HihokenshaNo("1234567890"));
        mapper.insert月別ランクTemp(rankuEntity);
        KuBunnGaTsurakuTempEntity rankuEntity1 = new KuBunnGaTsurakuTempEntity();
        rankuEntity1.setHihokenshaNo(new HihokenshaNo("1000000000"));
        mapper.insert月別ランクTemp(rankuEntity1);
        // ---------------------------テスト用-----------------------------------
        // ---------------------------テスト用-----------------------------------

        selectKeisanTaishosha(new FlexibleYear("2016"), new FlexibleYear("2016"), new FlexibleDate("20150101"));
        collectSetaiin();

    }

    /**
     * 賦課計算のメソッドます。
     *
     * @param 賦課年度 FlexibleYear
     * @param 調定日時 YMDHMS
     */
    public void caluculateFuka(FlexibleYear 賦課年度,
            YMDHMS 調定日時) {
        IHonnSanteiFukaMapper mapper = mapperProvider.create(IHonnSanteiFukaMapper.class);
        KozaSearchKeyBuilder kozabuilder = new KozaSearchKeyBuilder();
        kozabuilder.set業務コード(GyomuCode.DB介護保険);
        kozabuilder.set用途区分(new KozaYotoKubunCodeValue(CODE));
        kozabuilder.set基準日(FlexibleDate.getNowDate());
        IKozaSearchKey kozaSearchKey = kozabuilder.build();
        ShunoKamokuAuthority sut = InstanceProvider.create(ShunoKamokuAuthority.class);
        List<KamokuCode> list = sut.get更新権限科目コード(ControlDataHolder.getUserId());
        CaluculateFukaParameter parameter = CaluculateFukaParameter.createSelectByKeyParam(kozaSearchKey, list);
        // ------------------------------Test-------------------------------------//
        selectKeisanTaishosha(new FlexibleYear("2012"), new FlexibleYear("2010"), new FlexibleDate("20000101"));
//        mapper.create月別ランクTemp();
        collectSetaiin();
        // ------------------------------Test-------------------------------------//
        List<KakuShugyoumuJouHouEntity> 各種業務情報List = mapper.get賦課計算情報(parameter);
        // ------------------------------Test-------------------------------------//
        for (KakuShugyoumuJouHouEntity entity : 各種業務情報List) {
            List<SetaiShotokuEntity> 世帯員所得情報 = entity.get世帯員所得情報();
            for (SetaiShotokuEntity shotokuEntity : 世帯員所得情報) {
                shotokuEntity.setKazeiKubun(new RString("3"));
            }
        }
        // ------------------------------Test-------------------------------------//
        if (各種業務情報List == null || 各種業務情報List.isEmpty()) {
            return;
        }
        HokenryoDankaiList 保険料段階List = HokenryoDankaiSettings.createInstance().get保険料段階ListIn(賦課年度);
        SeigyoJoho 月別保険料制御情報 = editor月別保険料制御情報(保険料段階List);
        NengakuSeigyoJoho 年額制御情報 = editor年額制御情報();
        for (KakuShugyoumuJouHouEntity jouHouEntity : 各種業務情報List) {
            List<SeikatsuHogoJukyusha> 生保の情報のリスト = new ArrayList<>();
            for (SeikatsuHogoJukyushaRelateEntity entity : jouHouEntity.get生保の情報()) {
                SeikatsuHogoJukyusha jukyusha = new SeikatsuHogoJukyusha(entity);
                生保の情報のリスト.add(jukyusha);
            }
            List<RoreiFukushiNenkinJukyusha> 老福の情報のリスト = new ArrayList<>();
            for (DbT7006RoreiFukushiNenkinJukyushaEntity entity : jouHouEntity.get老齢の情報()) {
                RoreiFukushiNenkinJukyusha kinJukyusha = new RoreiFukushiNenkinJukyusha(entity);
                老福の情報のリスト.add(kinJukyusha);
            }
            List<KyokaisoGaitosha> 境界層の情報のリスト = new ArrayList<>();
            for (KyokaisoGaitoshaEntity entity : jouHouEntity.get境界層の情報()) {
                KyokaisoGaitosha gaitosha = new KyokaisoGaitosha(entity);
                境界層の情報のリスト.add(gaitosha);
            }
            List<SetaiShotokuEntity> 世帯員所得情報List = jouHouEntity.get世帯員所得情報();
            FukaKonkyoBatchParameter 賦課根拠param = new FukaKonkyoBatchParameter();
            賦課根拠param.set賦課基準日(jouHouEntity.getKijunYMD());
            賦課根拠param.set生保の情報リスト(生保の情報のリスト);
            賦課根拠param.set老齢の情報のリスト(老福の情報のリスト);
            賦課根拠param.set世帯員所得情報List(世帯員所得情報List);
            FukaKonkyoFactory factory = new FukaKonkyoFactory();
            FukaKonkyo 賦課根拠 = factory.create(賦課根拠param);

            HokenryoDankaiHantei hantei = InstanceProvider.create(HokenryoDankaiHantei.class);
            HokenryoDankaiHanteiParameter 保険料段階パラメータ = new HokenryoDankaiHanteiParameter();
            保険料段階パラメータ.setFukaNendo(jouHouEntity.getFukaNendo());
            保険料段階パラメータ.setFukaKonkyo(賦課根拠);
            保険料段階パラメータ.setSeigyoJoho(月別保険料制御情報);
            TsukibetsuHokenryoDankai 月別保険料段階 = hantei.determine月別保険料段階(保険料段階パラメータ);

            NengakuHokenryoKeisanParameter 年額保険料パラメータ = new NengakuHokenryoKeisanParameter();
            年額保険料パラメータ.set賦課年度(賦課年度);
            NengakuFukaKonkyoFactory nengakuFukaKonkyo = InstanceProvider.create(NengakuFukaKonkyoFactory.class);
            KuBunnGaTsurakuTempEntity 月別ランク = jouHouEntity.get月別ランク();
            NengakuFukaKonkyo 年額賦課根拠 = nengakuFukaKonkyo.createNengakuFukaKonkyo(
                    jouHouEntity.getKijunYMD(),
                    jouHouEntity.get資格の情報().getIchigoShikakuShutokuYMD(),
                    jouHouEntity.get資格の情報().getShikakuSoshitsuYMD(),
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
            fukaKokyoBatchParameter.set賦課年度(賦課年度);
            fukaKokyoBatchParameter.set資格の情報(new HihokenshaDaicho(jouHouEntity.get資格の情報()));
            fukaKokyoBatchParameter.set世帯員所得情報List(jouHouEntity.get世帯員所得情報());
            fukaKokyoBatchParameter.set生保の情報のリスト(生保の情報のリスト);
            fukaKokyoBatchParameter.set老福の情報のリスト(老福の情報のリスト);
            fukaKokyoBatchParameter.set境界層の情報のリスト(境界層の情報のリスト);
            fukaKokyoBatchParameter.set賦課根拠パラメータ(賦課根拠);
            fukaKokyoBatchParameter.set月別保険料段階(月別保険料段階);
            fukaKokyoBatchParameter.set年額保険料(年額保険料.getHokenryoNengaku());
            fukaKokyoBatchParameter.set調定日時(調定日時);
            if (jouHouEntity.get賦課の情報() == null) {
                create新規の賦課処理(jouHouEntity, fukaKokyoBatchParameter, 調定日時, 年額保険料, 賦課年度);
            } else {
                create既存の賦課処理(jouHouEntity, fukaKokyoBatchParameter, 調定日時, 年額保険料, 賦課年度);
            }
        }
    }

    private void create既存の賦課処理(KakuShugyoumuJouHouEntity jouHouEntity,
            FukaKokyoBatchParameter fukaKokyoBatchParameter,
            YMDHMS 調定日時,
            NengakuHokenryo 年額保険料,
            FlexibleYear 賦課年度) {
        FukaJoho 賦課の情報_更正前 = new FukaJoho(jouHouEntity.get賦課の情報());
        fukaKokyoBatchParameter.set賦課の情報_設定前(賦課の情報_更正前);
        FukaJoho 賦課の情報_更正後 = FukaKeisan.createInstance().reflect賦課根拠(fukaKokyoBatchParameter);
        ChoshuHoho 徴収方法の情報_更正後 = new ChoshuHoho(jouHouEntity.get徴収方法の情報());
        if (賦課の情報_更正後.get減免前介護保険料_年額().equals(年額保険料.getHokenryoNengaku())
                || (new ChoshuHoho(jouHouEntity.get徴収方法の情報()).get特別徴収停止事由コード() != null
                || !new ChoshuHoho(jouHouEntity.get徴収方法の情報()).get特別徴収停止事由コード().isEmpty())) {
            CalculateChoteiResult choteiResult = caluculateChotei(調定日時, 賦課の情報_更正後,
                    new ChoshuHoho(jouHouEntity.get徴収方法の情報()), 年額保険料,
                    new HihokenshaDaicho(jouHouEntity.get資格の情報()));
            賦課の情報_更正後 = choteiResult.get賦課情報();
            徴収方法の情報_更正後 = choteiResult.get徴収方法情報();
        }
        if (Decimal.ZERO.compareTo(賦課の情報_更正前.get減免額()) == NUM_0) {
            賦課の情報_更正後 = creat出力対象(賦課年度, 賦課の情報_更正後,
                    賦課の情報_更正前, 調定日時, 徴収方法の情報_更正後, jouHouEntity);
            FukaJoho 賦課の情報_設定後 = setChoteiJiyu(賦課の情報_更正前, 賦課の情報_更正後,
                    new ChoshuHoho(jouHouEntity.get徴収方法の情報()));
            DbT2002FukaEntity 介護賦課 = 賦課の情報_設定後.toEntity();
            介護賦課.setState(EntityDataState.Added);
            介護賦課Dac.save(介護賦課);
            List<Kibetsu> kibetsuList = 賦課の情報_設定後.getKibetsuList();
            for (Kibetsu kibetsu : kibetsuList) {
                DbT2003KibetsuEntity 介護期別 = kibetsu.toEntity();
                介護期別.setState(EntityDataState.Added);
                介護期別Dac.save(介護期別);
                List<ChoteiKyotsu> choteiKyotsuList = kibetsu.getChoteiKyotsuList();
                for (ChoteiKyotsu choteiKyotsu : choteiKyotsuList) {
                    UrT0705ChoteiKyotsuEntity choteiKyotsuEntity = choteiKyotsu.toEntity();
                    choteiKyotsuEntity.setState(EntityDataState.Added);
                    choteiKyotsuDac.save(choteiKyotsuEntity);
                }
            }
        } else if (Decimal.ZERO.compareTo(賦課の情報_更正前.get減免額()) == NUM_負1) {
            DbT2010FukaErrorListEntity errorListEntity = new DbT2010FukaErrorListEntity();
            errorListEntity.setSubGyomuCode(SubGyomuCode.DBB介護賦課);
            errorListEntity.setInternalReportId(内部帳票ID);
            errorListEntity.setInternalReportCreationDateTime(賦課の情報_更正後.get調定日時() == null
                    ? null : 賦課の情報_更正後.get調定日時().getRDateTime());
            errorListEntity.setFukaNendo(賦課年度);
            errorListEntity.setTsuchishoNo(賦課の情報_更正後.get通知書番号());
            errorListEntity.setBatchId(バッチID);
            errorListEntity.setBatchStartingDateTime(RDate.getNowDateTime());
            errorListEntity.setErrorCode(new Code(ErrorCode.賦課に減免あり.getコード()));
            errorListEntity.setHihokenshaNo(賦課の情報_更正後.get被保険者番号());
            errorListEntity.setShikibetsuCode(賦課の情報_更正後.get識別コード());
            errorListEntity.setShikakuShutokuYMD(賦課の情報_更正後.get資格取得日());
            errorListEntity.setShikakuShutokuJiyu(賦課の情報_更正後.get資格取得事由());
            errorListEntity.setShikakuSoshitsuYMD(賦課の情報_更正後.get資格喪失日());
            errorListEntity.setShikakuSoshitsuJiyu(賦課の情報_更正後.get資格喪失事由());
            errorListEntity.setState(EntityDataState.Added);
            賦課エラーDac.save(errorListEntity);
        }

    }

    private FukaJoho creat出力対象(FlexibleYear 賦課年度,
            FukaJoho 賦課の情報_更正後, FukaJoho 賦課の情報_更正前, YMDHMS 調定日時,
            ChoshuHoho 徴収方法の情報_更正後, KakuShugyoumuJouHouEntity jouHouEntity) {
        FukaJohoBuilder builder = 賦課の情報_更正後.createBuilderForEdit();
        builder.set被保険者番号(new HihokenshaDaicho(jouHouEntity.get資格の情報()).get被保険者番号());
        if (賦課の情報_更正前 == null) {
            builder.set履歴番号(NUM_0);
        } else if (is変化有り(賦課の情報_更正前, 賦課の情報_更正後)) {
            builder.set履歴番号(賦課の情報_更正前.get履歴番号() + NUM_1);
        }
        builder.set調定日時(調定日時);
        builder.set異動基準日時(調定日時);
        builder.set徴収方法履歴番号(徴収方法の情報_更正後.get履歴番号());
        if (is普徴期別がZERO(賦課の情報_更正後)) {
            builder.set口座区分(KozaKubun.現金納付.getコード());
        } else {
            if (!jouHouEntity.get口座().isEmpty()) {
                builder.set口座区分(KozaKubun.口座振替.getコード());
            } else {
                builder.set口座区分(KozaKubun.現金納付.getコード());
            }
        }
        builder.set職権区分(ShokkenKubun.非該当.getコード());
        HokenryoRank rank = InstanceProvider.create(HokenryoRank.class);
        List<HihokenshaDaicho> 資格の情報 = new ArrayList<>();
        資格の情報.add(new HihokenshaDaicho(jouHouEntity.get資格の情報()));
        List<MonthShichoson> 月別ランク情報 = rank.get月別ランク情報(資格の情報, 賦課年度);
        builder.set賦課市町村コード(get最終月の市町村コード(月別ランク情報));
        if (賦課の情報_更正前 != null) {
            builder.set特徴歳出還付額(賦課の情報_更正前.get特徴歳出還付額());
            builder.set普徴歳出還付額(賦課の情報_更正前.get普徴歳出還付額());
            builder.set減免額(賦課の情報_更正前.get減免額());
        }
        賦課の情報_更正後 = builder.build();
        return 賦課の情報_更正後;
    }

    private void create新規の賦課処理(KakuShugyoumuJouHouEntity jouHouEntity,
            FukaKokyoBatchParameter fukaKokyoBatchParameter,
            YMDHMS 調定日時,
            NengakuHokenryo 年額保険料,
            FlexibleYear 賦課年度) {
        FukaJoho 新しい賦課の情報 = new FukaJoho(jouHouEntity.getChoteiNendo(), jouHouEntity.getFukaNendo(),
                jouHouEntity.getTsuchishoNo(), NUM_0);
        fukaKokyoBatchParameter.set賦課の情報_設定前(新しい賦課の情報);
        FukaJoho 賦課の情報_設定後 = FukaKeisan.createInstance().reflect賦課根拠(fukaKokyoBatchParameter);
        CalculateChoteiResult choteiResult = caluculateChotei(調定日時, 賦課の情報_設定後,
                new ChoshuHoho(jouHouEntity.get徴収方法の情報()), 年額保険料,
                new HihokenshaDaicho(jouHouEntity.get資格の情報()));
        FukaJoho 賦課の情報_更正後 = choteiResult.get賦課情報();
        FukaJohoBuilder fukaBuilder = 賦課の情報_更正後.createBuilderForEdit();
        fukaBuilder.set被保険者番号(jouHouEntity.get資格の情報().getHihokenshaNo())
                .set調定日時(調定日時)
                .set異動基準日時(調定日時)
                .set徴収方法履歴番号(jouHouEntity.get徴収方法の情報().getRirekiNo())
                .set職権区分(ShokkenKubun.非該当.getコード())
                .set特徴歳出還付額(Decimal.ZERO)
                .set普徴歳出還付額(Decimal.ZERO)
                .set減免額(Decimal.ONE);
        if (is普徴期別がZERO(賦課の情報_更正後)) {
            fukaBuilder.set口座区分(KozaKubun.現金納付.getコード());
        } else {
            if (!jouHouEntity.get口座().isEmpty()) {
                fukaBuilder.set口座区分(KozaKubun.口座振替.getコード());
            } else {
                fukaBuilder.set口座区分(KozaKubun.現金納付.getコード());
            }
        }
        HokenryoRank rank = InstanceProvider.create(HokenryoRank.class);
        List<HihokenshaDaicho> 資格の情報 = new ArrayList<>();
        資格の情報.add(new HihokenshaDaicho(jouHouEntity.get資格の情報()));
        List<MonthShichoson> 月別ランク情報 = rank.get月別ランク情報(資格の情報, 賦課年度);
        fukaBuilder.set賦課市町村コード(get最終月の市町村コード(月別ランク情報)).build();
        FukaJoho 賦課の情報_更正前 = new FukaJoho(jouHouEntity.get賦課の情報());
        賦課の情報_設定後 = setChoteiJiyu(賦課の情報_更正前, 賦課の情報_更正後,
                new ChoshuHoho(jouHouEntity.get徴収方法の情報()));
        DbT2002FukaEntity 介護賦課 = 賦課の情報_設定後.toEntity();
        介護賦課.setState(EntityDataState.Added);
        介護賦課Dac.save(介護賦課);
        List<Kibetsu> kibetsuList = 賦課の情報_設定後.getKibetsuList();
        for (Kibetsu kibetsu : kibetsuList) {
            DbT2003KibetsuEntity 介護期別 = kibetsu.toEntity();
            介護期別.setState(EntityDataState.Added);
            介護期別Dac.save(介護期別);
            List<ChoteiKyotsu> choteiKyotsuList = kibetsu.getChoteiKyotsuList();
            for (ChoteiKyotsu choteiKyotsu : choteiKyotsuList) {
                UrT0705ChoteiKyotsuEntity choteiKyotsuEntity = choteiKyotsu.toEntity();
                choteiKyotsuEntity.setState(EntityDataState.Added);
                choteiKyotsuDac.save(choteiKyotsuEntity);
            }
        }
    }

    private boolean is普徴期別がZERO(FukaJoho 賦課の情報_更正後) {
        return Decimal.ZERO.equals(賦課の情報_更正後.get普徴期別金額01())
                && Decimal.ZERO.equals(賦課の情報_更正後.get普徴期別金額02())
                && Decimal.ZERO.equals(賦課の情報_更正後.get普徴期別金額02())
                && Decimal.ZERO.equals(賦課の情報_更正後.get普徴期別金額04())
                && Decimal.ZERO.equals(賦課の情報_更正後.get普徴期別金額05())
                && Decimal.ZERO.equals(賦課の情報_更正後.get普徴期別金額06())
                && Decimal.ZERO.equals(賦課の情報_更正後.get普徴期別金額07())
                && Decimal.ZERO.equals(賦課の情報_更正後.get普徴期別金額08())
                && Decimal.ZERO.equals(賦課の情報_更正後.get普徴期別金額09())
                && Decimal.ZERO.equals(賦課の情報_更正後.get普徴期別金額10())
                && Decimal.ZERO.equals(賦課の情報_更正後.get普徴期別金額11())
                && Decimal.ZERO.equals(賦課の情報_更正後.get普徴期別金額12())
                && Decimal.ZERO.equals(賦課の情報_更正後.get普徴期別金額13())
                && Decimal.ZERO.equals(賦課の情報_更正後.get普徴期別金額14());
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

    private boolean isDecimal変更(Decimal 更正前, Decimal 更正後) {
        if (更正後 != null && !更正後.equals(更正前)) {
            return true;
        } else if (更正後 == null && 更正前 != null) {
            return true;
        }
        return false;
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
            if (月.equals(choson.get月().getコード()) && choson.get市町村コード() != null
                    && !choson.get市町村コード().getColumnValue().isEmpty()) {
                return choson.get市町村コード();
            }
        }
        return null;
    }

    /**
     * 調定計算
     *
     * @param 調定日時 YMDHMS
     * @param 賦課情報_更正前 FukaJoho
     * @param 徴収方法情報_更正前 ChoshuHoho
     * @param 年額保険料 NengakuHokenryo
     * @param 資格の情報 HihokenshaDaicho
     * @return CalculateChoteiResult
     */
    public CalculateChoteiResult caluculateChotei(YMDHMS 調定日時,
            FukaJoho 賦課情報_更正前,
            ChoshuHoho 徴収方法情報_更正前,
            NengakuHokenryo 年額保険料,
            HihokenshaDaicho 資格の情報) {
        // TODO QAのNo.933(Redmine#91256)
        List<Decimal> 特徴期別金額 = new ArrayList<>();
        for (int i = 0; i < NUM_4; i++) {
            特徴期別金額.add(Decimal.ONE);
        }
        List<Decimal> 普徴期別金額 = new ArrayList<>();
        for (int i = 0; i < NUM_14; i++) {
            普徴期別金額.add(Decimal.TEN);
        }
        FukaJoho 賦課の情報_クローン = 賦課情報_更正前;
        List<Kibetsu> kibetsuList = 賦課の情報_クローン.getKibetsuList();
        for (Kibetsu kibetsu : kibetsuList) {
            if (ChoshuHohoKibetsu.特別徴収.getコード().equals(kibetsu.get徴収方法())) {
                set特徴期別金額(kibetsu, 特徴期別金額);
            } else if (ChoshuHohoKibetsu.普通徴収.getコード().equals(kibetsu.get徴収方法())) {
                set普徴期別金額(kibetsu, 普徴期別金額);
            }
        }
        ChoshuHoho 徴収方法の情報_クローン = 徴収方法情報_更正前;
        徴収方法の情報_クローン.createBuilderForEdit().set特別徴収停止事由コード(
                new RString("01")).set特別徴収停止日時(調定日時).build();
        ChoshuHohoKoshin choshuHohoKoshin = ChoshuHohoKoshin.createInstance();
        choshuHohoKoshin.getChoshuHohoKoshinData(徴収方法の情報_クローン, 調定日時,
                賦課の情報_クローン.get資格取得日(), 賦課の情報_クローン.get資格喪失日());
        CalculateChoteiResult result = new CalculateChoteiResult();
        result.set徴収方法情報(徴収方法の情報_クローン);
        result.set賦課情報(賦課の情報_クローン);
        return result;
    }

    private void set特徴期別金額(Kibetsu kibetsu, List<Decimal> 特徴期別金額) {
        switch (kibetsu.get期()) {
            case NUM_1:
                set期別金額(kibetsu, 特徴期別金額.get(0));
                break;
            case NUM_2:
                set期別金額(kibetsu, 特徴期別金額.get(NUM_1));
                break;
            case NUM_3:
                set期別金額(kibetsu, 特徴期別金額.get(NUM_2));
                break;
            case NUM_4:
                set期別金額(kibetsu, 特徴期別金額.get(NUM_3));
                break;
            case NUM_5:
                set期別金額(kibetsu, 特徴期別金額.get(NUM_4));
                break;
            case NUM_6:
                set期別金額(kibetsu, 特徴期別金額.get(NUM_6));
                break;
            default:
        }
    }

    private void set普徴期別金額(Kibetsu kibetsu, List<Decimal> 普徴期別金額) {
        switch (kibetsu.get期()) {
            case NUM_1:
                set期別金額(kibetsu, 普徴期別金額.get(0));
                break;
            case NUM_2:
                set期別金額(kibetsu, 普徴期別金額.get(NUM_1));
                break;
            case NUM_3:
                set期別金額(kibetsu, 普徴期別金額.get(NUM_2));
                break;
            case NUM_4:
                set期別金額(kibetsu, 普徴期別金額.get(NUM_3));
                break;
            case NUM_5:
                set期別金額(kibetsu, 普徴期別金額.get(NUM_4));
                break;
            case NUM_6:
                set期別金額(kibetsu, 普徴期別金額.get(NUM_5));
                break;
            case NUM_7:
                set期別金額(kibetsu, 普徴期別金額.get(NUM_6));
                break;
            case NUM_8:
                set期別金額(kibetsu, 普徴期別金額.get(NUM_7));
                break;
            case NUM_9:
                set期別金額(kibetsu, 普徴期別金額.get(NUM_8));
                break;
            case NUM_10:
                set期別金額(kibetsu, 普徴期別金額.get(NUM_9));
                break;
            case NUM_11:
                set期別金額(kibetsu, 普徴期別金額.get(NUM_10));
                break;
            case NUM_12:
                set期別金額(kibetsu, 普徴期別金額.get(NUM_11));
                break;
            case NUM_13:
                set期別金額(kibetsu, 普徴期別金額.get(NUM_12));
                break;
            case NUM_14:
                set期別金額(kibetsu, 普徴期別金額.get(NUM_13));
                break;
            default:
        }
    }

    private void set期別金額(Kibetsu kibetsu, Decimal 期別金額) {
        List<ChoteiKyotsu> choteiKyotsuList = kibetsu.getChoteiKyotsuList();
        for (ChoteiKyotsu choteiKyotsu : choteiKyotsuList) {
            ChoteiKyotsuBuilder builder = choteiKyotsu.createBuilderForEdit();
            if (choteiKyotsu.get調定ID().equals(kibetsu.get調定ID().longValue())) {
                builder.set調定額(期別金額).build();
                break;
            }
        }
    }

    /**
     * 調定事由設定
     *
     * @param 当初賦課情報 FukaJoho
     * @param 設定前賦課情報 FukaJoho
     * @param 徴収方法情報 ChoshuHoho
     * @return DbT2002FukaEntity
     */
    public FukaJoho setChoteiJiyu(FukaJoho 当初賦課情報,
            FukaJoho 設定前賦課情報,
            ChoshuHoho 徴収方法情報) {
        RString 調定事由１ = 本算定賦課;
        RString 調定事由２ = RString.EMPTY;
        RString 調定事由３ = RString.EMPTY;
        RString 調定事由４ = RString.EMPTY;
        if (設定前賦課情報.get履歴番号() == NUM_0 && 設定前賦課情報.get資格喪失事由() != null) {
            調定事由２ = 設定前賦課情報.get資格喪失事由();
        } else {
            if (is特別徴収停止事由コード(徴収方法情報) && is調定事由(当初賦課情報)) {
                調定事由２ = 徴収方法情報.get特別徴収停止事由コード();
                調定事由３ = 徴収方法情報.get特別徴収停止事由コード();
                調定事由４ = 徴収方法情報.get特別徴収停止事由コード();
            } else if (設定前賦課情報.get資格喪失事由() != null) {
                調定事由２ = 設定前賦課情報.get資格喪失事由();
                調定事由３ = 設定前賦課情報.get資格喪失事由();
                調定事由４ = 設定前賦課情報.get資格喪失事由();
            }
        }
        FukaJoho 設定後賦課情報 = 設定前賦課情報;
        設定後賦課情報.createBuilderForEdit().set調定事由1(調定事由１)
                .set調定事由2(調定事由２).set調定事由3(調定事由３).set調定事由4(調定事由４).build();
        return 設定後賦課情報;
    }

    /**
     * 本算定結果一覧表出力
     *
     * @param 調定年度 FlexibleYear
     * @param 賦課年度 FlexibleYear
     * @param 調定日時 YMDHMS
     * @param 出力順ID Long
     */
    public void spoolHonsanteiKekkaIchiran(FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            YMDHMS 調定日時,
            Long 出力順ID) {
        IHonnSanteiFukaMapper mapper = mapperProvider.create(IHonnSanteiFukaMapper.class);
        IOutputOrder outputOrder = ChohyoShutsuryokujunFinderFactory.createInstance().get出力順(
                SubGyomuCode.DBB介護賦課, 帳票ID, 出力順ID);
        RString 出力順 = MyBatisOrderByClauseCreator.create(DBB200009ShutsuryokujunEnum.class, outputOrder);
        KozaSearchKeyBuilder kozabuilder = new KozaSearchKeyBuilder();
        kozabuilder.set業務コード(GyomuCode.DB介護保険);
        kozabuilder.set用途区分(new KozaYotoKubunCodeValue(CODE));
        kozabuilder.set基準日(new FlexibleDate(調定日時.getDate().toString()));
        IKozaSearchKey kozaSearchKey = kozabuilder.build();
        ShunoKamokuAuthority sut = InstanceProvider.create(ShunoKamokuAuthority.class);
        List<KamokuCode> list = sut.get更新権限科目コード(ControlDataHolder.getUserId());
        HonsenteiKeisangojohoParameter param = HonsenteiKeisangojohoParameter
                .createSelectByKeyParam(調定年度, 賦課年度, 調定日時, 出力順, kozaSearchKey, list);
        List<HonsenteiKeisangojohoEntity> 本算定計算後賦課情報リスト = mapper.select本算定計算後賦課情報(param);
        List<KeisangojohoAtenaKozaEntity> 計算後情報_宛名_口座List = new ArrayList<>();
        for (HonsenteiKeisangojohoEntity entity : 本算定計算後賦課情報リスト) {
            KeisangoJoho keisangoJoho = new KeisangoJoho(entity.get計算後情報());
            KeisangojohoAtenaKozaEntity 計算後情報_宛名_口座Entity = setKeisangojohoAtenaKozaEntity(keisangoJoho, entity);
            計算後情報_宛名_口座List.add(計算後情報_宛名_口座Entity);
        }
        SourceDataCollection sourceDataCollection = new HonsanteiKekkaIcihiranPrintService().printHonsanteiKekkaIcihira(
                計算後情報_宛名_口座List, 賦課年度, 調定日時, 出力順ID);
        for (KeisangojohoAtenaKozaEntity keisangojohoAtenaKozaEntity : 計算後情報_宛名_口座List) {
            List<RString> 月別所得段階リスト = new ArrayList<>();
            set月別取得段階(keisangojohoAtenaKozaEntity, 月別所得段階リスト);
            RString 口座情報 = kozaJoho(keisangojohoAtenaKozaEntity);
            RString 徴収方法 = set徴収方法(keisangojohoAtenaKozaEntity);
            RString 備考 = set備考(keisangojohoAtenaKozaEntity);
            IKojin 宛名情報 = ShikibetsuTaishoFactory.createKojin(keisangojohoAtenaKozaEntity.get宛名Entity());
            ChohyoSeigyoKyotsu 帳票制御共通 = load帳票制御共通(帳票ID);
            RString 住所編集 = JushoHenshu.editJusho(帳票制御共通, 宛名情報,
                    AssociationFinderFactory.createInstance().getAssociation());
            keisangojohoAtenaKozaEntity.get宛名Entity().setJusho(new AtenaJusho(住所編集));
            publish本算定結果一覧表(調定日時, 賦課年度, 口座情報, 徴収方法, 備考, 宛名情報, 住所編集, 月別所得段階リスト, keisangojohoAtenaKozaEntity);
        }
        List<RString> 出力条件リスト = new ArrayList<>();
        RStringBuilder builder = new RStringBuilder();
        builder.append((FORMAT_LEFT).concat(定数_調定年度).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE)
                .concat(調定年度.wareki().eraType(EraType.KANJI).toDateString()).concat(年度));
        出力条件リスト.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append((FORMAT_LEFT).concat(定数_賦課年度).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE)
                .concat(賦課年度.wareki().eraType(EraType.KANJI).toDateString()).concat(年度));
        出力条件リスト.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append((FORMAT_LEFT).concat(定数_出力順).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE));
        if (outputOrder != null) {
            List<ISetSortItem> iSetSortItemList = outputOrder.get設定項目リスト();
            for (ISetSortItem iSetSortItem : iSetSortItemList) {
                if (iSetSortItem == iSetSortItemList.get(iSetSortItemList.size() - 1)) {
                    builder.append(iSetSortItem.get項目名());
                } else {
                    builder.append(iSetSortItem.get項目名()).append(SIGN);
                }
            }
        }
        RString 出力ページ数 = new RString(sourceDataCollection.iterator().next().getPageCount());
        loadバッチ出力条件リスト(出力条件リスト, 出力ページ数, CSV出力有無_有り, CSVファイル名_一覧表);
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
                本算定_EUCファイル名,
                出力条件リスト);
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(reportOutputJokenhyoItem);
        printer.print();
    }

    /**
     * nullの判断するメソッドです。
     *
     * @param 項目 Object
     * @return boolean 項目がnullの場合、falseを返し
     */
    public boolean isNull(Object 項目) {
        return 項目 == null;
    }

    private void publish本算定結果一覧表(YMDHMS 調定日時, FlexibleYear 賦課年度, RString 口座情報, RString 徴収方法,
            RString 備考, IKojin 宛名情報, RString 住所編集, List<RString> 月別所得段階リスト,
            KeisangojohoAtenaKozaEntity 計算後情報_宛名_口座Entity) {
        List<RString> headList = publish本算定結果一覧表_headList();

        FileSpoolManager manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther,
                EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        RString eucFilePath = Path.combinePath(spoolWorkPath, 本算定_EUCファイル名);
        try (CsvListWriter csvListWriter = new CsvListWriter.InstanceBuilder(eucFilePath).setNewLine(NewLine.CRLF)
                .setDelimiter(カンマ)
                .setEnclosure(EUC_WRITER_ENCLOSURE)
                .setEncode(Encode.UTF_8withBOM)
                .hasHeader(true).setHeader(headList)
                .build()) {

            List<RString> bodyList = new ArrayList<>();
            RString 作成年月日 = 調定日時.getRDateTime().getDate().seireki()
                    .separator(Separator.SLASH).fillType(FillType.BLANK).toDateString();
            RString 作成日時 = 調定日時.getRDateTime().getTime().toFormattedTimeString(DisplayTimeFormat.HH_mm_ss);
            bodyList.add(作成年月日);
            bodyList.add(作成日時);
            bodyList.add(賦課年度.toDateString());
            bodyList.add(計算後情報_宛名_口座Entity.get通知書番号().getColumnValue());
            bodyList.add(計算後情報_宛名_口座Entity.get被保険者番号().getColumnValue());
            AtenaMeisho meisho = 計算後情報_宛名_口座Entity.get宛名Entity().getMeisho();
            if (meisho != null) {
                bodyList.add(meisho.getColumnValue());
            } else {
                bodyList.add(RString.EMPTY);
            }
            FlexibleDate seinengappiYMD = 計算後情報_宛名_口座Entity.get宛名Entity().getSeinengappiYMD();
            if (seinengappiYMD != null) {
                RString 生年月日 = seinengappiYMD.seireki()
                        .separator(Separator.SLASH).fillType(FillType.BLANK).toDateString();
                bodyList.add(生年月日);
            } else {
                bodyList.add(RString.EMPTY);
            }
            bodyList.add(宛名情報.get性別().code());
            bodyList.add(計算後情報_宛名_口座Entity.get識別コード().getColumnValue());
            bodyList.add(計算後情報_宛名_口座Entity.get世帯コード().getColumnValue());
            ChoikiCode choikiCode = 計算後情報_宛名_口座Entity.get宛名Entity().getChoikiCode();
            if (choikiCode != null) {
                bodyList.add(choikiCode.getColumnValue());
            } else {
                bodyList.add(RString.EMPTY);
            }
            YubinNo yubinNo = 計算後情報_宛名_口座Entity.get宛名Entity().getYubinNo();
            if (yubinNo != null) {
                bodyList.add(yubinNo.getColumnValue());
            } else {
                bodyList.add(RString.EMPTY);
            }
            bodyList.add(住所編集);
            AtenaJusho jusho = 計算後情報_宛名_口座Entity.get宛名Entity().getJusho();
            if (jusho != null) {
                bodyList.add(jusho.getColumnValue());
            } else {
                bodyList.add(RString.EMPTY);
            }
            AtenaBanchi banchi = 計算後情報_宛名_口座Entity.get宛名Entity().getBanchi();
            if (banchi != null) {
                bodyList.add(banchi.getColumnValue());
            } else {
                bodyList.add(RString.EMPTY);
            }
            bodyList.add(口座情報);
            bodyList.add(計算後情報_宛名_口座Entity.get資格取得日().seireki()
                    .separator(Separator.SLASH).fillType(FillType.BLANK).toDateString());
            bodyList.add(計算後情報_宛名_口座Entity.get資格喪失日().seireki()
                    .separator(Separator.SLASH).fillType(FillType.BLANK).toDateString());
            ShikakuKikan shikakuKikan = new ShikakuKikan();
            ShikakuKikanJoho 資格期間 = shikakuKikan.get資格期間(賦課年度, 計算後情報_宛名_口座Entity.get資格取得日(),
                    計算後情報_宛名_口座Entity.get資格喪失日());
            bodyList.add(new RString(String.valueOf(資格期間.get月数())));
            bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(計算後情報_宛名_口座Entity.get確定介護保険料_年額()), 0));
            bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(計算後情報_宛名_口座Entity.get減免前介護保険料_年額()), 0));
            bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(計算後情報_宛名_口座Entity.get減免額()), 0));
            bodyList.add(月別所得段階リスト.get(NUM_3));
            bodyList.add(月別所得段階リスト.get(NUM_4));
            bodyList.add(月別所得段階リスト.get(NUM_5));
            bodyList.add(月別所得段階リスト.get(NUM_6));
            bodyList.add(月別所得段階リスト.get(NUM_7));
            bodyList.add(月別所得段階リスト.get(NUM_8));
            bodyList.add(月別所得段階リスト.get(NUM_9));
            bodyList.add(月別所得段階リスト.get(NUM_10));
            bodyList.add(月別所得段階リスト.get(NUM_11));
            bodyList.add(月別所得段階リスト.get(NUM_0));
            bodyList.add(月別所得段階リスト.get(NUM_1));
            bodyList.add(月別所得段階リスト.get(NUM_2));
            bodyList.add(徴収方法);
            bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(計算後情報_宛名_口座Entity.get特徴期別金額01()), 0));
            bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(計算後情報_宛名_口座Entity.get特徴期別金額02()), 0));
            bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(計算後情報_宛名_口座Entity.get特徴期別金額03()), 0));
            bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(計算後情報_宛名_口座Entity.get特徴期別金額04()), 0));
            bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(計算後情報_宛名_口座Entity.get特徴期別金額05()), 0));
            bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(計算後情報_宛名_口座Entity.get特徴期別金額06()), 0));
            set普徴額_x期(計算後情報_宛名_口座Entity, bodyList);
            bodyList.add(備考);
            csvListWriter.writeLine(bodyList);
            csvListWriter.close();
        }
    }

    private Decimal nullTOZero(Decimal 期別金額) {
        if (期別金額 == null) {
            return Decimal.ZERO;
        }
        return 期別金額;
    }

    private List<RString> publish本算定結果一覧表_headList() {
        List<RString> headList = new ArrayList<>();
        headList.add(タイトル_作成年月日);
        headList.add(タイトル_作成時刻);
        headList.add(タイトル_賦課年度);
        headList.add(タイトル_通知書番号);
        headList.add(タイトル_被保険者番号);
        headList.add(タイトル_氏名);
        headList.add(タイトル_生年月日);
        headList.add(タイトル_性別);
        headList.add(タイトル_識別コード);
        headList.add(タイトル_世帯コード);
        headList.add(タイトル_町域コード);
        headList.add(タイトル_郵便番号);
        headList.add(タイトル_住所);
        headList.add(タイトル_町域管内管外住所);
        headList.add(タイトル_番地);
        headList.add(タイトル_口座情報);
        headList.add(タイトル_資格取得日);
        headList.add(タイトル_資格喪失日);
        headList.add(タイトル_資格期間);
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
        headList.add(タイトル_徴収方法);
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
        headList.add(タイトル_備考);
        return headList;
    }

    private void set普徴額_x期(KeisangojohoAtenaKozaEntity entity,
            List<RString> bodyList) {
        FuchoKiUtil 月期対応取得_普徴 = new FuchoKiUtil();
        KitsukiList 期月リスト_普徴 = 月期対応取得_普徴.get期月リスト();
        KitsukiList kitsukiList = 期月リスト_普徴.filtered本算定期間();
        Kitsuki 最終法定納期 = kitsukiList.get最終法定納期();
        if (最終法定納期.get期AsInt() == NUM_1) {
            editor1期(bodyList, entity);
        } else if (最終法定納期.get期AsInt() == NUM_2) {
            editor2期(bodyList, entity);
        } else if (最終法定納期.get期AsInt() == NUM_3) {
            editor3期(bodyList, entity);
        } else if (最終法定納期.get期AsInt() == NUM_4) {
            editor4期(bodyList, entity);
        } else if (最終法定納期.get期AsInt() == NUM_5) {
            editor5期(bodyList, entity);
        } else if (最終法定納期.get期AsInt() == NUM_6) {
            editor6期(bodyList, entity);
        } else if (最終法定納期.get期AsInt() == NUM_7) {
            editor7期(bodyList, entity);
        } else if (最終法定納期.get期AsInt() == NUM_8) {
            editor8期(bodyList, entity);
        } else if (最終法定納期.get期AsInt() == NUM_9) {
            editor9期(bodyList, entity);
        } else if (最終法定納期.get期AsInt() == NUM_10) {
            editor10期(bodyList, entity);
        } else if (最終法定納期.get期AsInt() == NUM_11) {
            editor11期(bodyList, entity);
        } else if (最終法定納期.get期AsInt() == NUM_12) {
            editor12期(bodyList, entity);
        }
    }

    private void editor1期(List<RString> bodyList, KeisangojohoAtenaKozaEntity entity) {
        bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額01()), 0));
        bodyList.add(RString.EMPTY);
        bodyList.add(RString.EMPTY);
        bodyList.add(RString.EMPTY);
        bodyList.add(RString.EMPTY);
        bodyList.add(RString.EMPTY);
        bodyList.add(RString.EMPTY);
        bodyList.add(RString.EMPTY);
        bodyList.add(RString.EMPTY);
        bodyList.add(RString.EMPTY);
        bodyList.add(RString.EMPTY);
        bodyList.add(RString.EMPTY);
    }

    private void editor2期(List<RString> bodyList, KeisangojohoAtenaKozaEntity entity) {
        bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額01()), 0));
        bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額02()), 0));
        bodyList.add(RString.EMPTY);
        bodyList.add(RString.EMPTY);
        bodyList.add(RString.EMPTY);
        bodyList.add(RString.EMPTY);
        bodyList.add(RString.EMPTY);
        bodyList.add(RString.EMPTY);
        bodyList.add(RString.EMPTY);
        bodyList.add(RString.EMPTY);
        bodyList.add(RString.EMPTY);
        bodyList.add(RString.EMPTY);
    }

    private void editor3期(List<RString> bodyList, KeisangojohoAtenaKozaEntity entity) {
        bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額01()), 0));
        bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額02()), 0));
        bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額03()), 0));
        bodyList.add(RString.EMPTY);
        bodyList.add(RString.EMPTY);
        bodyList.add(RString.EMPTY);
        bodyList.add(RString.EMPTY);
        bodyList.add(RString.EMPTY);
        bodyList.add(RString.EMPTY);
        bodyList.add(RString.EMPTY);
        bodyList.add(RString.EMPTY);
        bodyList.add(RString.EMPTY);
    }

    private void editor4期(List<RString> bodyList, KeisangojohoAtenaKozaEntity entity) {
        bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額01()), 0));
        bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額02()), 0));
        bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額03()), 0));
        bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額04()), 0));
        bodyList.add(RString.EMPTY);
        bodyList.add(RString.EMPTY);
        bodyList.add(RString.EMPTY);
        bodyList.add(RString.EMPTY);
        bodyList.add(RString.EMPTY);
        bodyList.add(RString.EMPTY);
        bodyList.add(RString.EMPTY);
        bodyList.add(RString.EMPTY);
    }

    private void editor5期(List<RString> bodyList, KeisangojohoAtenaKozaEntity entity) {
        bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額01()), 0));
        bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額02()), 0));
        bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額03()), 0));
        bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額04()), 0));
        bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額05()), 0));
        bodyList.add(RString.EMPTY);
        bodyList.add(RString.EMPTY);
        bodyList.add(RString.EMPTY);
        bodyList.add(RString.EMPTY);
        bodyList.add(RString.EMPTY);
        bodyList.add(RString.EMPTY);
        bodyList.add(RString.EMPTY);
    }

    private void editor6期(List<RString> bodyList, KeisangojohoAtenaKozaEntity entity) {
        bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額01()), 0));
        bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額02()), 0));
        bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額03()), 0));
        bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額04()), 0));
        bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額05()), 0));
        bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額06()), 0));
        bodyList.add(RString.EMPTY);
        bodyList.add(RString.EMPTY);
        bodyList.add(RString.EMPTY);
        bodyList.add(RString.EMPTY);
        bodyList.add(RString.EMPTY);
        bodyList.add(RString.EMPTY);
    }

    private void editor7期(List<RString> bodyList, KeisangojohoAtenaKozaEntity entity) {
        bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額01()), 0));
        bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額02()), 0));
        bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額03()), 0));
        bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額04()), 0));
        bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額05()), 0));
        bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額06()), 0));
        bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額07()), 0));
        bodyList.add(RString.EMPTY);
        bodyList.add(RString.EMPTY);
        bodyList.add(RString.EMPTY);
        bodyList.add(RString.EMPTY);
        bodyList.add(RString.EMPTY);
    }

    private void editor8期(List<RString> bodyList, KeisangojohoAtenaKozaEntity entity) {
        bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額01()), 0));
        bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額02()), 0));
        bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額03()), 0));
        bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額04()), 0));
        bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額05()), 0));
        bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額06()), 0));
        bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額07()), 0));
        bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額08()), 0));
        bodyList.add(RString.EMPTY);
        bodyList.add(RString.EMPTY);
        bodyList.add(RString.EMPTY);
        bodyList.add(RString.EMPTY);
    }

    private void editor9期(List<RString> bodyList, KeisangojohoAtenaKozaEntity entity) {
        bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額01()), 0));
        bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額02()), 0));
        bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額03()), 0));
        bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額04()), 0));
        bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額05()), 0));
        bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額06()), 0));
        bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額07()), 0));
        bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額08()), 0));
        bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額09()), 0));
        bodyList.add(RString.EMPTY);
        bodyList.add(RString.EMPTY);
        bodyList.add(RString.EMPTY);
    }

    private void editor10期(List<RString> bodyList, KeisangojohoAtenaKozaEntity entity) {
        bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額01()), 0));
        bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額02()), 0));
        bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額03()), 0));
        bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額04()), 0));
        bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額05()), 0));
        bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額06()), 0));
        bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額07()), 0));
        bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額08()), 0));
        bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額09()), 0));
        bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額10()), 0));
        bodyList.add(RString.EMPTY);
        bodyList.add(RString.EMPTY);
    }

    private void editor11期(List<RString> bodyList, KeisangojohoAtenaKozaEntity entity) {
        bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額01()), 0));
        bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額02()), 0));
        bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額03()), 0));
        bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額04()), 0));
        bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額05()), 0));
        bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額06()), 0));
        bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額07()), 0));
        bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額08()), 0));
        bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額09()), 0));
        bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額10()), 0));
        bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額11()), 0));
        bodyList.add(RString.EMPTY);
    }

    private void editor12期(List<RString> bodyList, KeisangojohoAtenaKozaEntity entity) {
        bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額01()), 0));
        bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額02()), 0));
        bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額03()), 0));
        bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額04()), 0));
        bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額05()), 0));
        bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額06()), 0));
        bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額07()), 0));
        bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額08()), 0));
        bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額09()), 0));
        bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額10()), 0));
        bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額11()), 0));
        bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額12()), 0));
    }

    private ChohyoSeigyoKyotsu load帳票制御共通(ReportId 帳票分類Id) throws NullPointerException {
        requireNonNull(帳票分類Id, UrSystemErrorMessages.値がnull.getReplacedMessage(帳票分類Id.toString()));

        DbT7065ChohyoSeigyoKyotsuEntity entity = 帳票制御共通Dac.selectByKey(SubGyomuCode.DBB介護賦課, 帳票分類Id);
        if (entity == null) {
            return null;
        }
        return new ChohyoSeigyoKyotsu(entity);
    }

    private void set月別取得段階(KeisangojohoAtenaKozaEntity entity,
            List<RString> 月別所得段階リスト) {
        FlexibleYearMonth 月割開始年月1 = entity.get月割開始年月1();
        int 開始月1 = 月割開始年月1.getMonthValue();
        FlexibleYearMonth 月割終了年月1 = entity.get月割終了年月1();
        int 終了月1 = 月割終了年月1.getMonthValue();
        RString 保険料算定段階1 = entity.get保険料算定段階1();
        set月別取得段階(開始月1, 終了月1, 保険料算定段階1, 月別所得段階リスト);
        FlexibleYearMonth 月割開始年月2 = entity.get月割開始年月2();
        int 開始月2 = 月割開始年月2.getMonthValue();
        FlexibleYearMonth 月割終了年月2 = entity.get月割終了年月2();
        int 終了月2 = 月割終了年月2.getMonthValue();
        RString 保険料算定段階2 = entity.get保険料算定段階2();
        set月別取得段階(開始月2, 終了月2, 保険料算定段階2, 月別所得段階リスト);
    }

    private void set月別取得段階(int 開始月, int 終了月,
            RString 保険料算定段階, List<RString> 月別所得段階リスト) {
        for (int i = 開始月; i <= (開始月 > 終了月 ? (終了月 + NUM_12) : 終了月); i++) {
            int currentMonth = (i - 1) % NUM_12 + 1;
            set保険料算定段階(currentMonth, 保険料算定段階, 月別所得段階リスト);
        }
    }

    private void set保険料算定段階(int currentMonth, RString 保険料算定段階,
            List<RString> 月別所得段階リスト) {

        if (currentMonth == NUM_1) {
            月別所得段階リスト.add(保険料算定段階);
        } else {
            月別所得段階リスト.add(RString.EMPTY);
        }
        if (currentMonth == NUM_2) {
            月別所得段階リスト.add(保険料算定段階);
        } else {
            月別所得段階リスト.add(RString.EMPTY);
        }
        if (currentMonth == NUM_3) {
            月別所得段階リスト.add(保険料算定段階);
        } else {
            月別所得段階リスト.add(RString.EMPTY);
        }
        if (currentMonth == NUM_4) {
            月別所得段階リスト.add(保険料算定段階);
        } else {
            月別所得段階リスト.add(RString.EMPTY);
        }
        if (currentMonth == NUM_5) {
            月別所得段階リスト.add(保険料算定段階);
        } else {
            月別所得段階リスト.add(RString.EMPTY);
        }
        if (currentMonth == NUM_6) {
            月別所得段階リスト.add(保険料算定段階);
        } else {
            月別所得段階リスト.add(RString.EMPTY);
        }
        if (currentMonth == NUM_7) {
            月別所得段階リスト.add(保険料算定段階);
        } else {
            月別所得段階リスト.add(RString.EMPTY);
        }
        if (currentMonth == NUM_8) {
            月別所得段階リスト.add(保険料算定段階);
        } else {
            月別所得段階リスト.add(RString.EMPTY);
        }
        if (currentMonth == NUM_9) {
            月別所得段階リスト.add(保険料算定段階);
        } else {
            月別所得段階リスト.add(RString.EMPTY);
        }
        if (currentMonth == NUM_10) {
            月別所得段階リスト.add(保険料算定段階);
        } else {
            月別所得段階リスト.add(RString.EMPTY);
        }
        if (currentMonth == NUM_11) {
            月別所得段階リスト.add(保険料算定段階);
        } else {
            月別所得段階リスト.add(RString.EMPTY);
        }
        if (currentMonth == NUM_12) {
            月別所得段階リスト.add(保険料算定段階);
        } else {
            月別所得段階リスト.add(RString.EMPTY);
        }

    }

    private KeisangojohoAtenaKozaEntity setKeisangojohoAtenaKozaEntity(
            KeisangoJoho keisangoJoho, HonsenteiKeisangojohoEntity entity) {
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
        atenaKozaEntity.set仮徴収基礎年金番号(keisangoJoho.get仮徴収_基礎年金番号());
        atenaKozaEntity.set仮徴収年金コード(keisangoJoho.get仮徴収_年金コード());
        atenaKozaEntity.set仮徴収捕捉月(keisangoJoho.get仮徴収_捕捉月());
        atenaKozaEntity.set本徴収基礎年金番号(keisangoJoho.get本徴収_基礎年金番号());
        atenaKozaEntity.set本徴収年金コード(keisangoJoho.get本徴収_年金コード());
        atenaKozaEntity.set本徴収捕捉月(keisangoJoho.get本徴収_捕捉月());
        atenaKozaEntity.set翌年度仮徴収基礎年金番号(keisangoJoho.get翌年度仮徴収_基礎年金番号());
        atenaKozaEntity.set翌年度仮徴収年金コード(keisangoJoho.get翌年度仮徴収_年金コード());
        atenaKozaEntity.set翌年度仮徴収捕捉月(keisangoJoho.get翌年度仮徴収_捕捉月());
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

    private RString kozaJoho(KeisangojohoAtenaKozaEntity entity) {
        KozaRelateEntity releteEntity = entity.get口座Entity();
        IKoza koza = new Koza(releteEntity);
        RString 口座情報 = RString.EMPTY;
        if (koza.get金融機関コード() != null) {
            if (koza.get金融機関コード().value().length() >= NUM_4 && ゆうちょ銀行
                    .equals(koza.get金融機関コード().value().substring(NUM_0, NUM_4))) {
                口座情報 = 金融機関コードHander1(koza);
            } else {
                口座情報 = 金融機関コードHander2(koza);
            }
        }
        return 口座情報;
    }

    private RString 金融機関コードHander1(IKoza koza) {
        RString 金融機関コード;
        RString 通帳記号;
        RString 通帳番号;
        RString 口座情報 = RString.EMPTY;
        if (koza.get通帳記号() != null && koza.get通帳番号() != null && koza.get口座名義人漢字() != null) {
            if (koza.get金融機関コード().value().length() >= NUM_4) {
                金融機関コード = koza.get金融機関コード().value().substring(NUM_0, NUM_4);
            } else {
                金融機関コード = koza.get金融機関コード().value();
            }
            if (koza.get通帳記号().length() >= NUM_5) {
                通帳記号 = koza.get通帳記号().substring(NUM_0, NUM_5);
            } else {
                通帳記号 = koza.get通帳記号();
            }
            if (koza.get通帳番号().length() >= NUM_8) {
                通帳番号 = koza.get通帳番号().substring(NUM_0, NUM_8);
            } else {
                通帳番号 = koza.get通帳番号();
            }
            口座情報 = 金融機関コード.concat(RString.FULL_SPACE).concat(通帳記号).concat(HYPHEN).concat(通帳番号)
                    .concat(RString.FULL_SPACE).concat(koza.get口座名義人漢字().toString());
        }
        return 口座情報;
    }

    private RString 金融機関コードHander2(IKoza koza) {
        RString 金融機関コード;
        RString 預金種別略称;
        RString 支店コード;
        RString 口座番号;
        RString 口座情報 = RString.EMPTY;
        if (koza.get支店コード() != null && koza.get口座番号() != null && koza.get口座名義人漢字() != null) {
            if (koza.get金融機関コード().value().length() >= NUM_4) {
                金融機関コード = koza.get金融機関コード().value().substring(NUM_0, NUM_4);
            } else {
                金融機関コード = koza.get金融機関コード().value();
            }
            if (koza.get支店コード().value().length() >= NUM_5) {
                支店コード = koza.get支店コード().value().substring(NUM_0, NUM_5);
            } else {
                支店コード = koza.get支店コード().value();
            }
            if (koza.get預金種別() != null && koza.get預金種別().get預金種別略称().length() >= NUM_2) {
                預金種別略称 = koza.get預金種別().get預金種別略称().substring(NUM_0, NUM_2);
            } else {
                預金種別略称 = koza.get預金種別().get預金種別略称();
            }
            if (koza.get口座番号().length() >= NUM_7) {
                口座番号 = koza.get口座番号().substring(NUM_0, NUM_7);
            } else {
                口座番号 = koza.get口座番号();
            }
            口座情報 = 金融機関コード.concat(HYPHEN).concat(支店コード).concat(RString.FULL_SPACE)
                    .concat(預金種別略称).concat(HYPHEN).concat(口座番号).concat(RString.FULL_SPACE)
                    .concat(koza.get口座名義人漢字().toString());
        }
        return 口座情報;
    }

    private RString set徴収方法(KeisangojohoAtenaKozaEntity entity) {
        RString 徴収方法 = RString.EMPTY;
        Decimal 特徴期の期別金額の合計 = nullTOZero(entity.get特徴期別金額04())
                .add(nullTOZero(entity.get特徴期別金額05()))
                .add(nullTOZero(entity.get特徴期別金額06()));
        Decimal 普徴期の期別金額の合計 = nullTOZero(entity.get普徴期別金額01())
                .add(nullTOZero(entity.get普徴期別金額02()).add(nullTOZero(entity.get普徴期別金額03())))
                .add(nullTOZero(entity.get普徴期別金額04())).add(nullTOZero(entity.get普徴期別金額05()))
                .add(nullTOZero(entity.get普徴期別金額06())).add(nullTOZero(entity.get普徴期別金額07()))
                .add(nullTOZero(entity.get普徴期別金額08())).add(nullTOZero(entity.get普徴期別金額09()))
                .add(nullTOZero(entity.get普徴期別金額10())).add(nullTOZero(entity.get普徴期別金額11()))
                .add(nullTOZero(entity.get普徴期別金額12())).add(nullTOZero(entity.get普徴期別金額13()))
                .add(nullTOZero(entity.get普徴期別金額14()));
        if (特徴期の期別金額の合計.compareTo(Decimal.ZERO) == NUM_0 && 普徴期の期別金額の合計.compareTo(Decimal.ZERO) == NUM_0) {
            return 徴収方法;
        } else if (特徴期の期別金額の合計.compareTo(Decimal.ONE) != NUM_負1 && 普徴期の期別金額の合計.compareTo(Decimal.ZERO) == NUM_0) {
            return 特別徴収;
        } else if (特徴期の期別金額の合計.compareTo(Decimal.ZERO) == NUM_0 && 普徴期の期別金額の合計.compareTo(Decimal.ONE) != NUM_負1) {
            return 普通徴収;
        } else if (特徴期の期別金額の合計.compareTo(Decimal.ONE) != NUM_負1 && 普徴期の期別金額の合計.compareTo(Decimal.ONE) != NUM_負1) {
            return 併用徴収;
        } else {
            return 徴収方法;
        }
    }

    private RString set備考(KeisangojohoAtenaKozaEntity entity) {
        RString 備考 = RString.EMPTY;
        Decimal 特徴期の期別金額の合計 = nullTOZero(entity.get特徴期別金額04())
                .add(nullTOZero(entity.get特徴期別金額05()))
                .add(nullTOZero(entity.get特徴期別金額06()));
        Decimal 普徴期の期別金額の合計 = nullTOZero(entity.get普徴期別金額01())
                .add(nullTOZero(entity.get普徴期別金額02()).add(nullTOZero(entity.get普徴期別金額03())))
                .add(nullTOZero(entity.get普徴期別金額04())).add(nullTOZero(entity.get普徴期別金額05()))
                .add(nullTOZero(entity.get普徴期別金額06())).add(nullTOZero(entity.get普徴期別金額07()))
                .add(nullTOZero(entity.get普徴期別金額08())).add(nullTOZero(entity.get普徴期別金額09()))
                .add(nullTOZero(entity.get普徴期別金額10())).add(nullTOZero(entity.get普徴期別金額11()))
                .add(nullTOZero(entity.get普徴期別金額12())).add(nullTOZero(entity.get普徴期別金額13()))
                .add(nullTOZero(entity.get普徴期別金額14()));
        if (特徴期の期別金額の合計.compareTo(Decimal.ZERO) == NUM_0 && 普徴期の期別金額の合計.compareTo(Decimal.ZERO) == NUM_0) {
            return 本算定賦課なし;
        } else if (特徴期の期別金額の合計.compareTo(Decimal.ONE) != NUM_負1 && 普徴期の期別金額の合計.compareTo(Decimal.ZERO) == NUM_0) {
            return 本算定前半普徴;
        } else if (特徴期の期別金額の合計.compareTo(Decimal.ZERO) == NUM_0 && 普徴期の期別金額の合計.compareTo(Decimal.ONE) == NUM_負1) {
            return 備考;
        } else if (特徴期の期別金額の合計.compareTo(Decimal.ONE) != NUM_負1 && 普徴期の期別金額の合計.compareTo(Decimal.ONE) == NUM_負1) {
            return 備考;
        } else {
            return 備考;
        }
    }

    private boolean is調定事由(FukaJoho 当初賦課情報) {
        return 当初賦課情報.get調定事由1() == null && 当初賦課情報.get調定事由2() == null
                && 当初賦課情報.get調定事由3() == null && 当初賦課情報.get調定事由4() == null;
    }

    private boolean is特別徴収停止事由コード(ChoshuHoho 徴収方法情報) {
        RString tokuchoTeishiJiyuCode = 徴収方法情報.get特別徴収停止事由コード();
        if (tokuchoTeishiJiyuCode != null) {
            return tokuchoTeishiJiyuCode.equals(年金保険者からの通知)
                    || tokuchoTeishiJiyuCode.equals(保険料額の減額変更)
                    || tokuchoTeishiJiyuCode.equals(徴収方法修正)
                    || tokuchoTeishiJiyuCode.equals(特別徴収対象者外)
                    || tokuchoTeishiJiyuCode.equals(資格喪失特徴中止);
        } else {
            return false;
        }
    }

    private SeigyoJoho editor月別保険料制御情報(HokenryoDankaiList 保険料段階List) {
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
                保険料段階List,
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

    private NengakuSeigyoJoho editor年額制御情報() {
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
        // TODO QAのNo.957　「ランク別制御情報」の設定方法がない。
        Map<RString, RankBetsuKijunKingaku> ランク別制御情報 = new HashMap<RString, RankBetsuKijunKingaku>();
        RankBetsuKijunKingaku gaku = new RankBetsuKijunKingaku();
//        gaku.setランク基準金額1(Decimal.ONE);
//        gaku.setランク基準金額2(Decimal.ONE);
        ランク別制御情報.put(new RString("01"), gaku);
        ランク別制御情報.put(new RString("1"), gaku);
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

    /**
     * 処理日付管理テーブル更新
     *
     * @param 処理名 RString
     * @param 処理枝番 RString
     * @param 年度 FlexibleYear
     * @param 年度内連番 RString
     * @param システム日時 YMDHMS
     */
    public void update処理日付管理(RString 処理名, RString 処理枝番, FlexibleYear 年度, RString 年度内連番, YMDHMS システム日時) {
        List<DbT7022ShoriDateKanriEntity> entityList = 処理日付管理Dac.selectBySomeKeys(SubGyomuCode.DBB介護賦課,
                処理名, 処理枝番, 年度, 年度内連番);
        if (entityList != null) {
            update処理日付管理(entityList, システム日時);
        }
    }

    private void update処理日付管理(List<DbT7022ShoriDateKanriEntity> entityList, YMDHMS システム日時) {
        for (DbT7022ShoriDateKanriEntity entity : entityList) {
            entity.setKijunTimestamp(システム日時);
            entity.setState(EntityDataState.Modified);
            処理日付管理Dac.save(entity);
        }
    }

}
