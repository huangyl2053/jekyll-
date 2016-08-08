/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.gennendohonsanteiidou;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.business.core.basic.KeisangoJoho;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJoho;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJohoBuilder;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.kibetsu.Kibetsu;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.HokenryoDankaiList;
import jp.co.ndensan.reams.db.dbb.business.report.honsanteiidou.GenNendoHonsanteiIdouProperty;
import jp.co.ndensan.reams.db.dbb.business.report.honsanteiidou.KeisanjohoAtenaKozaKouseizengoEntity;
import jp.co.ndensan.reams.db.dbb.definition.core.choshuhoho.ChoshuHohoKibetsu;
import jp.co.ndensan.reams.db.dbb.definition.core.choteijiyu.ChoteiJiyuCode;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.KozaKubun;
import jp.co.ndensan.reams.db.dbb.definition.core.tokucho.TokuchoNengakuKijunNendo4Gatsu;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.gennendohonsanteiidou.HonsanteiIdoKekkaParameter;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.gennendohonsanteiidou.TokuchoIraikin4gatsuKaishiParameter;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajoho.fukajoho.FukaJohoRelateEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajoho.kibetsu.KibetsuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajohotoroku.DbT2002FukaJohoTempTableEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.genendoidoukekkaichiran.KeisanjohoAtenaKozaEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.gennendohonsanteiidou.HonsanteiIdoKekkaEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.gennendohonsanteiidou.TokuchoIraikin4gatsuKaishiEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.gennendohonsanteiidou.IGenNendoHonsanteiIdouMapper;
import jp.co.ndensan.reams.db.dbb.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbb.service.core.fuka.fukakeisan.FukaKeisan;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.HokenryoDankaiSettings;
import jp.co.ndensan.reams.db.dbb.service.report.honsanteiidou.GenNendoHonsanteiIdouPrintService;
import jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.FuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KitsukiList;
import jp.co.ndensan.reams.db.dbx.business.util.NendoUtil;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBBCodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.Tsuki;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.UrT0705ChoteiKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.core.basic.RoreiFukushiNenkinJukyusha;
import jp.co.ndensan.reams.db.dbz.business.core.hihokensha.seikatsuhogofujoshurui.SeikatsuHogoFujoShurui;
import jp.co.ndensan.reams.db.dbz.business.core.hihokensha.seikatsuhogojukyusha.SeikatsuHogoJukyusha;
import jp.co.ndensan.reams.db.dbz.business.core.kanri.JushoHenshu;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7006RoreiFukushiNenkinJukyushaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7065ChohyoSeigyoKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.hihokensha.seikatsuhogojukyusha.SeikatsuHogoJukyushaRelateEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7065ChohyoSeigyoKyotsuDac;
import jp.co.ndensan.reams.ua.uax.business.core.koza.IKoza;
import jp.co.ndensan.reams.ua.uax.business.core.koza.Koza;
import jp.co.ndensan.reams.ua.uax.business.core.koza.KozaSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.definition.core.valueobject.code.KozaYotoKubunCodeValue;
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
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
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
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 本算定賦課・本算定異動（現年度）（バッチ）のビジネスクラスです。
 *
 * @reamsid_L DBB-0930-020 cuilin
 */
public class GenNendoHonsanteiIdouFath {

    private final MapperProvider mapperProvider;
    private final DbT7065ChohyoSeigyoKyotsuDac 帳票制御共通Dac;
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
    private static final RString 定数_ページ数 = new RString("0");
    private static final RString ゼロ_0000 = new RString("0000");
    private static final ReportId 帳票ID = new ReportId("DBB200015_HonsanteiIdouKekkaIchiran");
    private final ReportId 帳票分類ID = new ReportId("DBB200009_HonsanteiKekkaIcihiran");
    private static final Code 用途区分コード = new Code("0");
    private static final RString 更正前後区分_更正前 = new RString("1");
    private static final RString 更正前後区分_更正後 = new RString("2");
    private static final RString EUCファイル名 = new RString("HonsanteiIdouKekkaIchiranData.csv");
    private static final EucEntityId EUCエンティティID = new EucEntityId("DBB200015");
    private static final RString カンマ = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString FORMAT_LEFT = new RString("【");
    private static final RString FORMAT_RIGHT = new RString("】");
    private static final RString 定数_出力条件 = new RString("出力条件");
    private static final RString 定数_出力順 = new RString("出力順");
    private static final RString 定値_賦課年度 = new RString("賦課年度");
    private static final RString 定値_調定年度 = new RString("調定年度");
    private static final RString 年度 = new RString("年度");
    private static final RString CSV出力有無_有り = new RString("有り");
    private static final RString CSV出力有無_なし = new RString("なし");
    private static final RString CSVファイル名_一覧表 = new RString("本算定異動（現年度）結果一覧表");
    private static final RString CSVファイル名_なし = new RString("-");
    private static final RString ゆうちょ銀行 = new RString("9900");
    private static final RString SIGN = new RString(" ＞ ");
    private static final RString HYPHEN = new RString("-");
    private static final RString 定値_現金 = new RString("現金");
    private static final RString 定値_口座 = new RString("口座");
    private static final RString 定値_特別徴収 = new RString("特別徴収");
    private static final RString 定値_普通徴収 = new RString("普通徴収");
    private static final RString 定値_併用徴収 = new RString("併用徴収");
    private static final RString 区分_管内 = new RString("1");
    private static final RString 区分_管外 = new RString("2");
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
    private static final RString タイトル_計算上保険料額_更正後 = new RString("計算上保険料額（更正後）");
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
    private static final RString 定数_0 = new RString("0");

    /**
     * コンストラクタです
     */
    public GenNendoHonsanteiIdouFath() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.帳票制御共通Dac = InstanceProvider.create(DbT7065ChohyoSeigyoKyotsuDac.class);
    }

    /**
     * コンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 帳票制御共通Dac DbT7065ChohyoSeigyoKyotsuDac
     */
    GenNendoHonsanteiIdouFath(MapperProvider mapperProvider,
            DbT7065ChohyoSeigyoKyotsuDac 帳票制御共通Dac) {
        this.mapperProvider = mapperProvider;
        this.帳票制御共通Dac = 帳票制御共通Dac;
    }

    /**
     * 特徴依頼金計算 (４月開始)メッソドです。
     *
     * @param 調定年度 FlexibleYear
     * @param 調定日時 YMDHMS
     */
    public void calculateTokuchoIraikin4gatsuKaishi(FlexibleYear 調定年度, YMDHMS 調定日時) {
        IGenNendoHonsanteiIdouMapper mapper = mapperProvider.create(IGenNendoHonsanteiIdouMapper.class);
        mapper.createDbT2002FukaJohoTemp();

        KozaSearchKeyBuilder kozaBuilder = new KozaSearchKeyBuilder();
        kozaBuilder.set業務コード(GyomuCode.DB介護保険);
        kozaBuilder.set用途区分(new KozaYotoKubunCodeValue(用途区分コード));
        kozaBuilder.set基準日(FlexibleDate.getNowDate());
        ShunoKamokuAuthority sut = InstanceProvider.create(ShunoKamokuAuthority.class);
        List<KamokuCode> list = sut.get更新権限科目コード(ControlDataHolder.getUserId());

        TokuchoIraikin4gatsuKaishiParameter param = TokuchoIraikin4gatsuKaishiParameter
                .createParam(調定年度, 調定日時, kozaBuilder.build(), list);

        List<TokuchoIraikin4gatsuKaishiEntity> 特徴依頼金情報リスト = mapper.get特徴依頼金情報(param);

        if (特徴依頼金情報リスト == null || 特徴依頼金情報リスト.isEmpty()) {
            return;
        }
        RString 特徴年額基準年度 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_年額基準年度_4月開始,
                NendoUtil.toNendoStartDate(調定年度), SubGyomuCode.DBB介護賦課);
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
            FukaJoho 賦課の情報 = editFukaJohoKyotsu(調定年度, 資格の情報, 徴収方法の情報,
                    生保の情報, 老齢の情報, 特徴依頼金情報.getZenNendoHokenryoDankai(), 調定日時);

            Decimal 保険料率 = Decimal.ZERO;
            if (TokuchoNengakuKijunNendo4Gatsu.当年度.getコード().equals(特徴年額基準年度)) {
                HokenryoDankaiList 前年度の保険料段階リスト
                        = HokenryoDankaiSettings.createInstance().get保険料段階ListIn(調定年度);
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

            FukaJohoRelateEntity fukaJohoRelateEntity = new FukaJohoRelateEntity();
            fukaJohoRelateEntity.set介護賦課Entity(賦課の情報.toEntity());
            List<KibetsuEntity> 介護期別RelateEntity = new ArrayList<>();

            for (int i = INT_1; i <= INT_6; i++) {
                Kibetsu 特徴期別 = new Kibetsu(賦課の情報.get調定年度(), 賦課の情報.get賦課年度(), 賦課の情報.get通知書番号(),
                        賦課の情報.get履歴番号(), ChoshuHohoKibetsu.特別徴収.getコード(), i);
                set新規賦課の期別金額(特徴期別, 特徴期別金額.get(i - INT_1), 介護期別RelateEntity);
            }
            for (int i = INT_1; i <= INT_14; i++) {
                Kibetsu 普徴期別 = new Kibetsu(賦課の情報.get調定年度(), 賦課の情報.get賦課年度(), 賦課の情報.get通知書番号(),
                        賦課の情報.get履歴番号(), ChoshuHohoKibetsu.普通徴収.getコード(), i);
                set新規賦課の期別金額(普徴期別, Decimal.ZERO, 介護期別RelateEntity);
            }

            fukaJohoRelateEntity.set介護期別RelateEntity(介護期別RelateEntity);
            賦課の情報 = new FukaJoho(fukaJohoRelateEntity);
            DbT2002FukaJohoTempTableEntity fukaJohoTempTableEntity = new DbT2002FukaJohoTempTableEntity();
            set一時賦課情報(fukaJohoTempTableEntity, 賦課の情報);
            mapper.insert賦課の情報一時テーブル(fukaJohoTempTableEntity);
        }
    }

    /**
     * 賦課情報一時テーブルの情報を設定メソッド
     *
     * @param entity DbT2002FukaJohoTempTableEntity
     * @param 賦課の情報 FukaJoho
     */
    protected void set一時賦課情報(DbT2002FukaJohoTempTableEntity entity, FukaJoho 賦課の情報) {
        entity.setChoteiNendo(賦課の情報.get調定年度());
        entity.setFukaNendo(賦課の情報.get賦課年度());
        entity.setTsuchishoNo(賦課の情報.get通知書番号());
        entity.setRirekiNo(賦課の情報.get履歴番号());
        entity.setHihokenshaNo(賦課の情報.get被保険者番号());
        entity.setShikibetsuCode(賦課の情報.get識別コード());
        entity.setSetaiCode(賦課の情報.get世帯コード());
        entity.setSetaiInsu(賦課の情報.get世帯員数());
        entity.setShikakuShutokuYMD(賦課の情報.get資格取得日());
        entity.setShikakuShutokuJiyu(賦課の情報.get資格取得事由());
        entity.setShikakuSoshitsuYMD(賦課の情報.get資格喪失日());
        entity.setShikakuSoshitsuJiyu(賦課の情報.get資格喪失事由());
        entity.setSeihofujoShurui(賦課の情報.get生活保護扶助種類());
        entity.setSeihoKaishiYMD(賦課の情報.get生保開始日());
        entity.setSeihoHaishiYMD(賦課の情報.get生保廃止日());
        entity.setRonenKaishiYMD(賦課の情報.get老年開始日());
        entity.setRonenHaishiYMD(賦課の情報.get老年廃止日());
        entity.setFukaYMD(賦課の情報.get賦課期日());
        entity.setKazeiKubun(賦課の情報.get課税区分());
        entity.setSetaikazeiKubun(賦課の情報.get世帯課税区分());
        entity.setGokeiShotokuGaku(賦課の情報.get合計所得金額());
        entity.setNenkinShunyuGaku(賦課の情報.get公的年金収入額());
        entity.setHokenryoDankai(賦課の情報.get保険料段階());
        entity.setHokenryoDankai1(賦課の情報.get保険料算定段階1());
        entity.setNengakuHokenryo1(賦課の情報.get算定年額保険料1());
        entity.setTsukiwariStartYM1(賦課の情報.get月割開始年月1());
        entity.setTsukiwariEndYM1(賦課の情報.get月割終了年月1());
        entity.setHokenryoDankai2(賦課の情報.get保険料算定段階2());
        entity.setNengakuHokenryo2(賦課の情報.get算定年額保険料2());
        entity.setTsukiwariStartYM2(賦課の情報.get月割開始年月2());
        entity.setTsukiwariEndYM2(賦課の情報.get月割終了年月2());
        entity.setChoteiNichiji(賦課の情報.get調定日時());
        entity.setChoteiJiyu1(賦課の情報.get調定事由1());
        entity.setChoteiJiyu2(賦課の情報.get調定事由2());
        entity.setChoteiJiyu3(賦課の情報.get調定事由3());
        entity.setChoteiJiyu4(賦課の情報.get調定事由4());
        entity.setKoseiM(賦課の情報.get更正月());
        entity.setGemmenMaeHokenryo(賦課の情報.get減免前介護保険料_年額());
        entity.setGemmenGaku(賦課の情報.get減免額());
        entity.setKakuteiHokenryo(賦課の情報.get確定介護保険料_年額());
        entity.setHokenryoDankaiKarisanntei(賦課の情報.get保険料段階_仮算定時());
        entity.setChoshuHohoRirekiNo(賦課の情報.get徴収方法履歴番号());
        entity.setIdoKijunNichiji(賦課の情報.get異動基準日時());
        entity.setKozaKubun(賦課の情報.get口座区分());
        entity.setKyokaisoKubun(賦課の情報.get境界層区分());
        entity.setShokkenKubun(賦課の情報.get職権区分());
        entity.setFukaShichosonCode(賦課の情報.get賦課市町村コード());
        entity.setTkSaishutsuKampuGaku(賦課の情報.get特徴歳出還付額());
        entity.setFuSaishutsuKampuGaku(賦課の情報.get普徴歳出還付額());
        entity.setTkKibetsuGaku01(賦課の情報.get特徴期別金額01());
        entity.setTkKibetsuGaku02(賦課の情報.get特徴期別金額02());
        entity.setTkKibetsuGaku03(賦課の情報.get特徴期別金額03());
        entity.setTkKibetsuGaku04(賦課の情報.get特徴期別金額04());
        entity.setTkKibetsuGaku05(賦課の情報.get特徴期別金額05());
        entity.setTkKibetsuGaku06(賦課の情報.get特徴期別金額06());
        entity.setFuKibetsuGaku01(賦課の情報.get普徴期別金額01());
        entity.setFuKibetsuGaku02(賦課の情報.get普徴期別金額02());
        entity.setFuKibetsuGaku03(賦課の情報.get普徴期別金額03());
        entity.setFuKibetsuGaku04(賦課の情報.get普徴期別金額04());
        entity.setFuKibetsuGaku05(賦課の情報.get普徴期別金額05());
        entity.setFuKibetsuGaku06(賦課の情報.get普徴期別金額06());
        entity.setFuKibetsuGaku07(賦課の情報.get普徴期別金額07());
        entity.setFuKibetsuGaku08(賦課の情報.get普徴期別金額08());
        entity.setFuKibetsuGaku09(賦課の情報.get普徴期別金額09());
        entity.setFuKibetsuGaku10(賦課の情報.get普徴期別金額10());
        entity.setFuKibetsuGaku11(賦課の情報.get普徴期別金額11());
        entity.setFuKibetsuGaku12(賦課の情報.get普徴期別金額12());
        entity.setFuKibetsuGaku13(賦課の情報.get普徴期別金額13());
        entity.setFuKibetsuGaku14(賦課の情報.get普徴期別金額14());
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
        FukaJoho 賦課の情報 = new FukaJoho(調定年度, 調定年度, 通知書番号, 0);
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
                .set調定事由1(ChoteiJiyuCode.捕捉により特徴開始.getコード())
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

    private TsuchishoNo create通知書番号(RString 被保険者番号, int 枝番号) {
        RStringBuilder rst = new RStringBuilder();
        rst.append(ゼロ_0000);
        rst.append(被保険者番号);
        rst.append(new RString(枝番号).padZeroToLeft(INT_2));
        return new TsuchishoNo(rst.toRString());
    }

    private static void set生活保護(FukaJohoBuilder builder, List<SeikatsuHogoJukyusha> 生保情報のリスト,
            FlexibleDate 本年度開始日, FlexibleDate 本年度終了日) {
        List<SeikatsuHogoJukyusha> 生活保護の情報のリスト = new ArrayList<>();
        for (SeikatsuHogoJukyusha entity : 生保情報のリスト) {
            FlexibleDate 受給開始日 = entity.get受給開始日();
            FlexibleDate 受給廃止日 = entity.get受給廃止日();
            if (受給廃止日 == null || 受給廃止日.isEmpty()) {
                受給廃止日 = FlexibleDate.MAX;
            }
            if (受給開始日 != null && !受給開始日.isEmpty()) {
                if (受給開始日.isBeforeOrEquals(本年度終了日) && 本年度開始日.isBeforeOrEquals(受給開始日)) {
                    生活保護の情報のリスト.add(entity);
                } else if (受給廃止日.isBeforeOrEquals(本年度終了日) && 本年度開始日.isBeforeOrEquals(受給廃止日)) {
                    生活保護の情報のリスト.add(entity);
                } else if (受給開始日.isBefore(本年度開始日) && 本年度終了日.isBefore(受給廃止日)) {
                    生活保護の情報のリスト.add(entity);
                }
            }
        }
        if (!生活保護の情報のリスト.isEmpty()) {
            Collections.sort(生活保護の情報のリスト, new Comparator<SeikatsuHogoJukyusha>() {
                @Override
                public int compare(SeikatsuHogoJukyusha o1, SeikatsuHogoJukyusha o2) {
                    if (o2.get受給開始日().isBeforeOrEquals(o1.get受給開始日())) {
                        return -1;
                    }
                    return 1;
                }
            });
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
        if (扶助種類リスト.isEmpty()) {
            return RString.EMPTY;
        }
        List<RString> 扶助種類 = new ArrayList<>();
        for (SeikatsuHogoFujoShurui shurui : 扶助種類リスト) {
            if (shurui.get扶助種類コード() != null) {
                扶助種類.add(shurui.get扶助種類コード().getColumnValue().getColumnValue());
            }
        }
        if (扶助種類.isEmpty()) {
            return RString.EMPTY;
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
            if (受給廃止日 == null || 受給廃止日.isEmpty()) {
                受給廃止日 = FlexibleDate.MAX;
            }
            if (受給開始日 != null && !受給開始日.isEmpty()) {
                if (受給開始日.isBeforeOrEquals(本年度終了日) && 本年度開始日.isBeforeOrEquals(受給開始日)) {
                    老齢福祉の情報リスト.add(entity);
                } else if (受給廃止日.isBeforeOrEquals(本年度終了日) && 本年度開始日.isBeforeOrEquals(受給廃止日)) {
                    老齢福祉の情報リスト.add(entity);
                } else if (受給開始日.isBefore(本年度開始日) && 本年度終了日.isBefore(受給廃止日)) {
                    老齢福祉の情報リスト.add(entity);
                }
            }
        }
        if (!老齢福祉の情報リスト.isEmpty()) {
            Collections.sort(老齢福祉の情報リスト, new Comparator<RoreiFukushiNenkinJukyusha>() {
                @Override
                public int compare(RoreiFukushiNenkinJukyusha o1, RoreiFukushiNenkinJukyusha o2) {
                    if (o2.get受給開始年月日().isBefore(o1.get受給開始年月日())) {
                        return -1;
                    }
                    return 1;
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
        RString 出力順 = MyBatisOrderByClauseCreator.create(GenNendoHonsanteiIdouProperty.DBB200015HonsanteiIdouKekkaIchiranEnum.class, outputOrder);

        List<RString> 出力条件リスト = new ArrayList<>();
        RStringBuilder builder = new RStringBuilder();
        builder.append(定数_出力条件);
        出力条件リスト.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append((FORMAT_LEFT).concat(定値_調定年度).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE)
                .concat(調定年度.wareki().eraType(EraType.KANJI).toDateString()).concat(年度));
        出力条件リスト.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append((FORMAT_LEFT).concat(定値_賦課年度).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE)
                .concat(賦課年度.wareki().eraType(EraType.KANJI).toDateString()).concat(年度));
        出力条件リスト.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(FORMAT_LEFT.concat(定数_出力順).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE));
        if (outputOrder != null) {
            List<ISetSortItem> iSetSortItemList = outputOrder.get設定項目リスト();
            for (ISetSortItem iSetSortItem : iSetSortItemList) {
                if (iSetSortItem == iSetSortItemList.get(iSetSortItemList.size() - INT_1)) {
                    builder.append(iSetSortItem.get項目名());
                } else {
                    builder.append(iSetSortItem.get項目名()).append(SIGN);
                }
            }
        }
        出力条件リスト.add(builder.toRString());

        KozaSearchKeyBuilder kozaBuilder = new KozaSearchKeyBuilder();
        kozaBuilder.set業務コード(GyomuCode.DB介護保険);
        kozaBuilder.set用途区分(new KozaYotoKubunCodeValue(用途区分コード));
        kozaBuilder.set基準日(new FlexibleDate(調定日時.getDate().toString()));

        ShunoKamokuAuthority sut = InstanceProvider.create(ShunoKamokuAuthority.class);
        List<KamokuCode> list = sut.get更新権限科目コード(ControlDataHolder.getUserId());

        HonsanteiIdoKekkaParameter param = HonsanteiIdoKekkaParameter
                .createParam(調定年度, 賦課年度, 調定日時, 出力順, kozaBuilder.build(), list);

        List<HonsanteiIdoKekkaEntity> 本算定計算後賦課情報リスト = mapper.get本算定異動情報(param);
        if (本算定計算後賦課情報リスト == null || 本算定計算後賦課情報リスト.isEmpty()) {
            loadバッチ出力条件リスト(出力条件リスト, 定数_ページ数, CSV出力有無_なし, CSVファイル名_なし, ReportIdDBB.DBB200015.getReportName());
            return;
        }

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
        for (KeisanjohoAtenaKozaEntity 更正後Entity : 計算後情報_宛名_口座_更正後EntityList) {
            KeisanjohoAtenaKozaKouseizengoEntity entity = new KeisanjohoAtenaKozaKouseizengoEntity();
            entity.set計算後情報_宛名_口座_更正後Entity(更正後Entity);
            for (KeisanjohoAtenaKozaEntity 更正前Entity : 計算後情報_宛名_口座_更正前EntityList) {
                if (更正前Entity.get調定年度().equals(更正後Entity.get調定年度())
                        && 更正前Entity.get賦課年度().equals(更正後Entity.get賦課年度())
                        && 更正前Entity.get通知書番号().equals(更正後Entity.get通知書番号())) {
                    entity.set計算後情報_宛名_口座_更正前Entity(更正前Entity);
                    break;
                }
            }
            計算後情報_宛名_口座EntityList.add(entity);
        }
        SourceDataCollection sourceDataCollection
                = new GenNendoHonsanteiIdouPrintService().printTaitsu(計算後情報_宛名_口座EntityList, 出力順ID, 調定日時, 賦課年度);

        publish本算定異動結果一覧表_本算定異動(賦課年度, 調定日時, 計算後情報_宛名_口座EntityList);

        RString 出力ページ数 = new RString(sourceDataCollection.iterator().next().getPageCount());
        loadバッチ出力条件リスト(出力条件リスト, 出力ページ数, CSV出力有無_有り, CSVファイル名_一覧表, ReportIdDBB.DBB200015.getReportName());
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
        KitsukiList 本算定期間 = 期月リスト.filtered本算定期間();
        ChohyoSeigyoKyotsu 帳票制御共通 = load帳票制御共通(帳票分類ID);
        Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
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
                RString 編集後住所 = JushoHenshu.editJusho(帳票制御共通, 宛名情報, 地方公共団体);
                bodyList.add(編集後住所);
                if (区分_管内.equals(更正後Entity.get宛名Entity().getKannaiKangaiKubun()) && 宛名情報.get住所() != null) {
                    bodyList.add(宛名情報.get住所().get住所());
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
                RString 口座情報 = get口座情報(更正後Entity);
                bodyList.add(口座情報);
                bodyList.add(get調定事由略称(更正後Entity.get調定事由1()));

                if (更正前Entity == null || 更正前Entity.get調定日時() == null) {
                    bodyList.add(RString.EMPTY);
                    bodyList.add(RString.EMPTY);
                    bodyList.add(RString.EMPTY);
                    bodyList.add(RString.EMPTY);
                } else {
                    bodyList.add(更正前Entity.get調定日時().getRDateTime().getDate().seireki()
                            .separator(Separator.SLASH).fillType(FillType.BLANK).toDateString());
                    bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(更正前Entity.get確定介護保険料_年額()), 0));
                    bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(更正前Entity.get減免前介護保険料_年額()), 0));
                    bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(更正前Entity.get減免額()), 0));
                }

                List<RString> 更正前_月別所得段階リスト = new ArrayList<>();
                set月別取得段階(更正前Entity, 更正前_月別所得段階リスト);
                bodyList.addAll(更正前_月別所得段階リスト);
                if (更正前Entity != null && KozaKubun.現金納付.getコード().equals(更正前Entity.get口座区分())) {
                    bodyList.add(定値_現金);
                } else if (更正前Entity != null && KozaKubun.口座振替.getコード().equals(更正前Entity.get口座区分())) {
                    bodyList.add(定値_口座);
                } else {
                    bodyList.add(RString.EMPTY);
                }
                bodyList.add(get調定事由略称(更正後Entity.get調定事由2()));

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

                bodyList.add(get調定事由略称(更正後Entity.get調定事由3()));

                set更正前期別金額(本算定期間, 更正前Entity, bodyList);

                bodyList.add(get調定事由略称(更正後Entity.get調定事由4()));
                bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(更正後Entity.get特徴期別金額01()), 0));
                bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(更正後Entity.get特徴期別金額02()), 0));
                bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(更正後Entity.get特徴期別金額03()), 0));
                bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(更正後Entity.get特徴期別金額04()), 0));
                bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(更正後Entity.get特徴期別金額05()), 0));
                bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(更正後Entity.get特徴期別金額06()), 0));
                bodyList.add(随時期月判断(INT_1, 本算定期間, 更正後Entity.get普徴期別金額01()));
                bodyList.add(随時期月判断(INT_2, 本算定期間, 更正後Entity.get普徴期別金額02()));
                bodyList.add(随時期月判断(INT_3, 本算定期間, 更正後Entity.get普徴期別金額03()));
                bodyList.add(随時期月判断(INT_4, 本算定期間, 更正後Entity.get普徴期別金額04()));
                bodyList.add(随時期月判断(INT_5, 本算定期間, 更正後Entity.get普徴期別金額05()));
                bodyList.add(随時期月判断(INT_6, 本算定期間, 更正後Entity.get普徴期別金額06()));
                bodyList.add(随時期月判断(INT_7, 本算定期間, 更正後Entity.get普徴期別金額07()));
                bodyList.add(随時期月判断(INT_8, 本算定期間, 更正後Entity.get普徴期別金額08()));
                bodyList.add(随時期月判断(INT_9, 本算定期間, 更正後Entity.get普徴期別金額09()));
                bodyList.add(随時期月判断(INT_10, 本算定期間, 更正後Entity.get普徴期別金額10()));
                bodyList.add(随時期月判断(INT_11, 本算定期間, 更正後Entity.get普徴期別金額11()));
                bodyList.add(随時期月判断(INT_12, 本算定期間, 更正後Entity.get普徴期別金額12()));
                bodyList.add(随時期月判断(INT_13, 本算定期間, 更正後Entity.get普徴期別金額13()));
                bodyList.add(随時期月判断(INT_14, 本算定期間, 更正後Entity.get普徴期別金額14()));
                bodyList.add(set徴収方法(本算定期間, 更正後Entity));
                bodyList.add(RString.EMPTY);
                toBodyList(bodyList);
                csvListWriter.writeLine(bodyList);
            }
            manager.spool(SubGyomuCode.DBB介護賦課, eucFilePath);
        }
    }

    private void set更正前期別金額(KitsukiList 本算定期間, KeisanjohoAtenaKozaEntity 更正前Entity,
            List<RString> bodyList) {
        if (更正前Entity == null) {
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
        } else {
            bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(更正前Entity.get特徴期別金額01()), 0));
            bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(更正前Entity.get特徴期別金額02()), 0));
            bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(更正前Entity.get特徴期別金額03()), 0));
            bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(更正前Entity.get特徴期別金額04()), 0));
            bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(更正前Entity.get特徴期別金額05()), 0));
            bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(更正前Entity.get特徴期別金額06()), 0));
            bodyList.add(随時期月判断(INT_1, 本算定期間, 更正前Entity.get普徴期別金額01()));
            bodyList.add(随時期月判断(INT_2, 本算定期間, 更正前Entity.get普徴期別金額02()));
            bodyList.add(随時期月判断(INT_3, 本算定期間, 更正前Entity.get普徴期別金額03()));
            bodyList.add(随時期月判断(INT_4, 本算定期間, 更正前Entity.get普徴期別金額04()));
            bodyList.add(随時期月判断(INT_5, 本算定期間, 更正前Entity.get普徴期別金額05()));
            bodyList.add(随時期月判断(INT_6, 本算定期間, 更正前Entity.get普徴期別金額06()));
            bodyList.add(随時期月判断(INT_7, 本算定期間, 更正前Entity.get普徴期別金額07()));
            bodyList.add(随時期月判断(INT_8, 本算定期間, 更正前Entity.get普徴期別金額08()));
            bodyList.add(随時期月判断(INT_9, 本算定期間, 更正前Entity.get普徴期別金額09()));
            bodyList.add(随時期月判断(INT_10, 本算定期間, 更正前Entity.get普徴期別金額10()));
            bodyList.add(随時期月判断(INT_11, 本算定期間, 更正前Entity.get普徴期別金額11()));
            bodyList.add(随時期月判断(INT_12, 本算定期間, 更正前Entity.get普徴期別金額12()));
            bodyList.add(随時期月判断(INT_13, 本算定期間, 更正前Entity.get普徴期別金額13()));
            bodyList.add(随時期月判断(INT_14, 本算定期間, 更正前Entity.get普徴期別金額14()));
            bodyList.add(set徴収方法(本算定期間, 更正前Entity));
        }
    }

    private RString get調定事由略称(RString 調定事由) {

        if (RString.isNullOrEmpty(調定事由)) {
            return RString.EMPTY;
        }
        return CodeMaster.getCodeRyakusho(SubGyomuCode.DBB介護賦課, DBBCodeShubetsu.調定事由.getコード(), new Code(調定事由));
    }

    private RString get口座情報(KeisanjohoAtenaKozaEntity 更正後Entity) {
        if (更正後Entity == null) {
            return RString.EMPTY;
        }
        IKoza 口座_更正後 = new Koza(更正後Entity.get口座Entity());
        RString 金融機関コード = 口座_更正後.get金融機関コード().value();
        RString 通帳記号 = 口座_更正後.getEdited通帳記号();
        RString 通帳番号 = 口座_更正後.getEdited通帳番号();
        RString 口座名義人漢字 = 口座_更正後.get口座名義人漢字().value();
        RString 支店コード = 口座_更正後.get支店コード().value();
        RString 口座番号 = 口座_更正後.get口座番号();
        RString 口座種別 = 口座_更正後.get預金種別().get預金種別略称();
        if (ゆうちょ銀行.equals(金融機関コード.substringReturnAsPossible(0, INT_4))) {
            return 金融機関コード.substringReturnAsPossible(0, INT_4).concat(RString.HALF_SPACE)
                    .concat(通帳記号.substringReturnAsPossible(0, INT_5))
                    .concat(HYPHEN)
                    .concat(通帳番号.substringReturnAsPossible(0, INT_8))
                    .concat(RString.HALF_SPACE)
                    .concat(口座名義人漢字);
        } else {
            return 金融機関コード.substringReturnAsPossible(0, INT_4).concat(HYPHEN)
                    .concat(支店コード.substringReturnAsPossible(0, INT_3)).concat(RString.HALF_SPACE)
                    .concat(口座種別.substringReturnAsPossible(0, INT_2)).concat(HYPHEN)
                    .concat(口座番号.substringReturnAsPossible(0, INT_7)).concat(RString.HALF_SPACE)
                    .concat(口座名義人漢字);
        }
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
        headList.add(タイトル_計算上保険料額_更正後);
        headList.add(タイトル_減免額_更正後);
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

    private RString 随時期月判断(int 期, KitsukiList 本算定期間, Decimal 期別金額) {
        if (!本算定期間.get期の月(期).isEmpty()) {
            return DecimalFormatter.toコンマ区切りRString(nullTOZero(期別金額), 0);
        }
        return RString.EMPTY;
    }

    private void loadバッチ出力条件リスト(List<RString> 出力条件リスト, RString 出力ページ数,
            RString csv出力有無, RString csvファイル名, RString 帳票名) {

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
                csvファイル名,
                出力条件リスト);
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(reportOutputJokenhyoItem);
        printer.print();
    }

    private ChohyoSeigyoKyotsu load帳票制御共通(ReportId 帳票分類ID) throws NullPointerException {
        requireNonNull(帳票分類ID, UrSystemErrorMessages.値がnull.getReplacedMessage(帳票分類ID.toString()));
        DbT7065ChohyoSeigyoKyotsuEntity entity = 帳票制御共通Dac.selectByKey(SubGyomuCode.DBB介護賦課, 帳票分類ID);
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
        月別所得段階リスト.add(RString.EMPTY);
        月別所得段階リスト.add(RString.EMPTY);
        月別所得段階リスト.add(RString.EMPTY);
        月別所得段階リスト.add(RString.EMPTY);
        月別所得段階リスト.add(RString.EMPTY);
        月別所得段階リスト.add(RString.EMPTY);
        月別所得段階リスト.add(RString.EMPTY);
        月別所得段階リスト.add(RString.EMPTY);
        月別所得段階リスト.add(RString.EMPTY);
        月別所得段階リスト.add(RString.EMPTY);
        月別所得段階リスト.add(RString.EMPTY);
        月別所得段階リスト.add(RString.EMPTY);
        if (entity == null) {
            return;
        }
        FlexibleYearMonth 月割開始年月1 = entity.get月割開始年月1();
        FlexibleYearMonth 月割終了年月1 = entity.get月割終了年月1();
        RString 保険料算定段階1 = entity.get保険料算定段階1();
        if (月割開始年月1 != null && 月割開始年月1.isEmpty() && 月割終了年月1 != null && 月割終了年月1.isEmpty()
                && !RString.isNullOrEmpty(保険料算定段階1)) {
            int 開始月1 = 月割開始年月1.getMonthValue();
            int 終了月1 = 月割終了年月1.getMonthValue();
            set月別取得段階(開始月1, 終了月1, 保険料算定段階1, 月別所得段階リスト);
        }

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
        set月別取得段階(開始月2, 終了月2, 保険料算定段階2, 月別所得段階リスト);
    }

    private void set月別取得段階(int 開始月, int 終了月,
            RString 保険料算定段階, List<RString> 月別所得段階リスト) {
        保険料算定段階 = 保険料算定段階.substringReturnAsPossible(0, INT_2);
        if (保険料算定段階.length() == INT_2 && 保険料算定段階.startsWith(定数_0)) {
            保険料算定段階 = 保険料算定段階.substringReturnAsPossible(INT_1, INT_2);
        }
        for (int i = 開始月; i <= (終了月 < 開始月 ? (終了月 + INT_12) : 終了月); i++) {
            int currentMonth = i % INT_12;
            set保険料算定段階(currentMonth, 保険料算定段階, 月別所得段階リスト);
        }
    }

    private void set保険料算定段階(int currentMonth, RString 保険料算定段階,
            List<RString> 月別所得段階リスト) {
        switch (currentMonth) {
            case INT_4:
                月別所得段階リスト.set(0, 保険料算定段階);
                break;
            case INT_5:
                月別所得段階リスト.set(INT_1, 保険料算定段階);
                break;
            case INT_6:
                月別所得段階リスト.set(INT_2, 保険料算定段階);
                break;
            case INT_7:
                月別所得段階リスト.set(INT_3, 保険料算定段階);
                break;
            case INT_8:
                月別所得段階リスト.set(INT_4, 保険料算定段階);
                break;
            case INT_9:
                月別所得段階リスト.set(INT_5, 保険料算定段階);
                break;
            case INT_10:
                月別所得段階リスト.set(INT_6, 保険料算定段階);
                break;
            case INT_11:
                月別所得段階リスト.set(INT_7, 保険料算定段階);
                break;
            case 0:
                月別所得段階リスト.set(INT_8, 保険料算定段階);
                break;
            case INT_1:
                月別所得段階リスト.set(INT_9, 保険料算定段階);
                break;
            case INT_2:
                月別所得段階リスト.set(INT_10, 保険料算定段階);
                break;
            case INT_3:
                月別所得段階リスト.set(INT_11, 保険料算定段階);
                break;
            default:
                break;
        }
    }

    private RString set徴収方法(KitsukiList 本算定期間, KeisanjohoAtenaKozaEntity 計算後情報Entity) {
        Decimal 本算定特徴期合計 = nullTOZero(計算後情報Entity.get特徴期別金額04())
                .add(nullTOZero(計算後情報Entity.get特徴期別金額05()))
                .add(nullTOZero(計算後情報Entity.get特徴期別金額06()));
        Decimal 本算定普徴期合計 = get普徴期別金額(INT_1, 本算定期間, 計算後情報Entity.get普徴期別金額01())
                .add(get普徴期別金額(INT_2, 本算定期間, 計算後情報Entity.get普徴期別金額02()))
                .add(get普徴期別金額(INT_3, 本算定期間, 計算後情報Entity.get普徴期別金額03()))
                .add(get普徴期別金額(INT_4, 本算定期間, 計算後情報Entity.get普徴期別金額04()))
                .add(get普徴期別金額(INT_5, 本算定期間, 計算後情報Entity.get普徴期別金額05()))
                .add(get普徴期別金額(INT_6, 本算定期間, 計算後情報Entity.get普徴期別金額06()))
                .add(get普徴期別金額(INT_7, 本算定期間, 計算後情報Entity.get普徴期別金額07()))
                .add(get普徴期別金額(INT_8, 本算定期間, 計算後情報Entity.get普徴期別金額08()))
                .add(get普徴期別金額(INT_9, 本算定期間, 計算後情報Entity.get普徴期別金額09()))
                .add(get普徴期別金額(INT_10, 本算定期間, 計算後情報Entity.get普徴期別金額10()))
                .add(get普徴期別金額(INT_11, 本算定期間, 計算後情報Entity.get普徴期別金額11()))
                .add(get普徴期別金額(INT_12, 本算定期間, 計算後情報Entity.get普徴期別金額12()))
                .add(get普徴期別金額(INT_13, 本算定期間, 計算後情報Entity.get普徴期別金額13()))
                .add(get普徴期別金額(INT_14, 本算定期間, 計算後情報Entity.get普徴期別金額14()));
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

    private Decimal get普徴期別金額(int 期, KitsukiList 本算定期間, Decimal 期別金額) {
        if (!本算定期間.get期の月(期).isEmpty()) {
            return nullTOZero(期別金額);
        }
        return Decimal.ZERO;
    }

    private void toBodyList(List<RString> bodyList) {
        for (int i = 0; i < bodyList.size(); i++) {
            if (bodyList.get(i) == null) {
                bodyList.remove(bodyList.get(i));
                bodyList.add(i, RString.EMPTY);
            }
        }
    }

    /**
     * 特徴期別金額の設定
     *
     * @param kibetsu Kibetsu
     * @param 特徴期別金額 List<Decimal>
     * @param 介護期別RelateEntity List<KibetsuEntity>
     */
    protected void set特徴期別金額(Kibetsu kibetsu, List<Decimal> 特徴期別金額, List<KibetsuEntity> 介護期別RelateEntity) {
        switch (kibetsu.get期()) {
            case INT_1:
                set既存賦課の期別金額(kibetsu, 特徴期別金額.get(0), 介護期別RelateEntity);
                break;
            case INT_2:
                set既存賦課の期別金額(kibetsu, 特徴期別金額.get(INT_1), 介護期別RelateEntity);
                break;
            case INT_3:
                set既存賦課の期別金額(kibetsu, 特徴期別金額.get(INT_2), 介護期別RelateEntity);
                break;
            case INT_4:
                set既存賦課の期別金額(kibetsu, 特徴期別金額.get(INT_3), 介護期別RelateEntity);
                break;
            case INT_5:
                set既存賦課の期別金額(kibetsu, 特徴期別金額.get(INT_4), 介護期別RelateEntity);
                break;
            case INT_6:
                set既存賦課の期別金額(kibetsu, 特徴期別金額.get(INT_5), 介護期別RelateEntity);
                break;
            default:
        }
    }

    /**
     * 普徴期別金額の設定
     *
     * @param kibetsu Kibetsu
     * @param 普徴期別金額 List<Decimal>
     * @param 介護期別RelateEntity List<KibetsuEntity>
     */
    protected void set普徴期別金額(Kibetsu kibetsu, List<Decimal> 普徴期別金額, List<KibetsuEntity> 介護期別RelateEntity) {
        switch (kibetsu.get期()) {
            case INT_1:
                set既存賦課の期別金額(kibetsu, 普徴期別金額.get(0), 介護期別RelateEntity);
                break;
            case INT_2:
                set既存賦課の期別金額(kibetsu, 普徴期別金額.get(INT_1), 介護期別RelateEntity);
                break;
            case INT_3:
                set既存賦課の期別金額(kibetsu, 普徴期別金額.get(INT_2), 介護期別RelateEntity);
                break;
            case INT_4:
                set既存賦課の期別金額(kibetsu, 普徴期別金額.get(INT_3), 介護期別RelateEntity);
                break;
            case INT_5:
                set既存賦課の期別金額(kibetsu, 普徴期別金額.get(INT_4), 介護期別RelateEntity);
                break;
            case INT_6:
                set既存賦課の期別金額(kibetsu, 普徴期別金額.get(INT_5), 介護期別RelateEntity);
                break;
            case INT_7:
                set既存賦課の期別金額(kibetsu, 普徴期別金額.get(INT_6), 介護期別RelateEntity);
                break;
            case INT_8:
                set既存賦課の期別金額(kibetsu, 普徴期別金額.get(INT_7), 介護期別RelateEntity);
                break;
            case INT_9:
                set既存賦課の期別金額(kibetsu, 普徴期別金額.get(INT_8), 介護期別RelateEntity);
                break;
            case INT_10:
                set既存賦課の期別金額(kibetsu, 普徴期別金額.get(INT_9), 介護期別RelateEntity);
                break;
            case INT_11:
                set既存賦課の期別金額(kibetsu, 普徴期別金額.get(INT_10), 介護期別RelateEntity);
                break;
            case INT_12:
                set既存賦課の期別金額(kibetsu, 普徴期別金額.get(INT_11), 介護期別RelateEntity);
                break;
            case INT_13:
                set既存賦課の期別金額(kibetsu, 普徴期別金額.get(INT_12), 介護期別RelateEntity);
                break;
            case INT_14:
                set既存賦課の期別金額(kibetsu, 普徴期別金額.get(INT_13), 介護期別RelateEntity);
                break;
            default:
        }
    }

    private void set既存賦課の期別金額(Kibetsu kibetsu, Decimal 期別金額, List<KibetsuEntity> 介護期別RelateEntity) {
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

    /**
     * 新規賦課の期別金額設定メソッド
     *
     * @param kibetsu Kibetsu
     * @param 期別金額 Decimal
     * @param 介護期別RelateEntity List<KibetsuEntity>
     */
    protected void set新規賦課の期別金額(Kibetsu kibetsu, Decimal 期別金額, List<KibetsuEntity> 介護期別RelateEntity) {
        KibetsuEntity kibetsuEntity = new KibetsuEntity();

        RStringBuilder rst = new RStringBuilder();
        rst.append(kibetsu.get徴収方法()).append(kibetsu.get期());
        kibetsu = kibetsu.createBuilderForEdit().set調定ID(new Decimal(rst.toString())).build();
        kibetsuEntity.set介護期別Entity(kibetsu.toEntity());

        UrT0705ChoteiKyotsuEntity urT0705ChoteiKyotsuEntity = new UrT0705ChoteiKyotsuEntity();
        urT0705ChoteiKyotsuEntity.setChoteiId(Long.valueOf(rst.toString()));
        urT0705ChoteiKyotsuEntity.setChoteigaku(期別金額);
        List<UrT0705ChoteiKyotsuEntity> entityList = new ArrayList<>();
        entityList.add(urT0705ChoteiKyotsuEntity);

        kibetsuEntity.set調定共通Entity(entityList);
        介護期別RelateEntity.add(kibetsuEntity);
    }
}
