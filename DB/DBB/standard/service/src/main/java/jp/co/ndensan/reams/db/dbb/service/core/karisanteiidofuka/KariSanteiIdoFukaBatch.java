/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.karisanteiidofuka;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.fukakeisan.FukaKokyoBatchParameter;
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
import jp.co.ndensan.reams.db.dbb.business.core.kanri.HokenryoDankai;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.HokenryoDankaiList;
import jp.co.ndensan.reams.db.dbb.business.report.honsanteiidou.KeisanjohoAtenaKozaKouseizengoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.choteijiyu.ChoteiJiyuCode;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.HasuChoseiTani;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.ShokkenKubun;
import jp.co.ndensan.reams.db.dbb.definition.core.tokucho.TokuchoNengakuKijunNendo8Gatsu;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.karisanteiidofuka.KariSanteiIdoFukaMybatisParameter;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.csv.KarisanteiIdoKekkaIchiranCSVEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2010FukaErrorListEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fuka.SetaiShotokuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajoho.fukajoho.FukaJohoRelateEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajoho.kibetsu.KibetsuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajohotoroku.DbT2002FukaJohoTempTableEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.genendoidoukekkaichiran.KeisanjohoAtenaKozaEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.karisanteiidofuka.HihokenChoshuRelateEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.karisanteiidofuka.KarisanteiIdoKekkaEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.karisanteiidofuka.KozaIdoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.karisanteiidofuka.ShikakuFukaResultEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.karisanteiidofuka.ShikakuShutokuTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.karisanteiidofuka.TokubetuTyoushuuKaisiTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.karisanteiidofuka.TokutyouKariSannteiRelateEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2010FukaErrorListDac;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.karisanteiidofuka.IKariSanteiIdoFukaBatchMapper;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.karisanteiidofuka.IKarisanteiIdoKekkaMapper;
import jp.co.ndensan.reams.db.dbb.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbb.service.core.fuka.fukakeisan.FukaKeisan;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.HokenryoDankaiSettings;
import jp.co.ndensan.reams.db.dbb.service.report.karisanteiidokekkaichiran.KarisanteiIdoKekkaIchiranPrintService;
import jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.FuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KitsukiList;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.TokuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.util.NendoUtil;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.KazeiKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.Tsuki;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbV2001ChoshuHohoAliveDac;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaichoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.RoreiFukushiNenkinJukyusha;
import jp.co.ndensan.reams.db.dbz.business.core.hihokensha.seikatsuhogofujoshurui.SeikatsuHogoFujoShurui;
import jp.co.ndensan.reams.db.dbz.business.core.hihokensha.seikatsuhogojukyusha.SeikatsuHogoJukyusha;
import jp.co.ndensan.reams.db.dbz.business.core.kyokaisogaitosha.kyokaisogaitosha.KyokaisoGaitosha;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7006RoreiFukushiNenkinJukyushaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.hihokensha.seikatsuhogojukyusha.SeikatsuHogoJukyushaRelateEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1001HihokenshaDaichoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.ua.uax.business.core.koza.KozaSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.KozaYotoKubunType;
import jp.co.ndensan.reams.ua.uax.definition.core.valueobject.code.KozaYotoKubunCodeValue;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.IKozaSearchKey;
import jp.co.ndensan.reams.ur.urc.service.core.shunokamoku.authority.ShunoKamokuAuthority;
import jp.co.ndensan.reams.ur.urd.business.core.tokuchokarisanteikiwari.GyomuConfigJohoClass;
import jp.co.ndensan.reams.ur.urd.business.core.tokuchokarisanteikiwari.TokuchoKarisanteiKiwari;
import jp.co.ndensan.reams.ur.urd.business.core.tokuchokarisanteikiwari.TokuchoKarisanteiKiwariInput;
import jp.co.ndensan.reams.ur.urd.business.core.tokuchokarisanteikiwari.TokuchoKarisanteiKiwariOutput;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucCsvWriter;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.Month;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 仮算定異動賦課（バッチ）のビジネス
 *
 * @reamsid_L DBB-0850-020 chenaoqi
 */
public class KariSanteiIdoFukaBatch extends KariSanteiIdoFukaBatchFath {

    private final MapperProvider mapperProvider;
    private final DbT1001HihokenshaDaichoDac 被保険者台帳管理dac;
    private final DbV2001ChoshuHohoAliveDac 徴収方法dac;
    private final DbT2010FukaErrorListDac 賦課エラーdac;
    private final IKariSanteiIdoFukaBatchMapper mapper;
    private static final RString RSTRING_0 = new RString("0");
    private static final RString RSTRING_1 = new RString("1");
    private static final RString RSTRING_2 = new RString("2");
    private static final RString RSTRING_3 = new RString("3");
    private static final RString RSTRING_4 = new RString("04");
    private static final RString RSTRING_6 = new RString("06");
    private static final RString RSTRING_11 = new RString("11");
    private static final RString RSTRING_12 = new RString("12");
    private static final RString RSTRING_100 = new RString("100");
    private static final RString ZERO = new RString("0000");
    private static final RString 内部帳票ID = new RString("DBB400001_FukaErrorIchitan");
    private static final RString バッチID = new RString("DBBBT44001");
    private static final RString ファイル名称 = new RString("KarisanteiIdoKekkaIchiranData.csv");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString CSV出力有無 = new RString("有り");
    private static final RString 定数_出力条件 = new RString("出力条件");
    private static final RString 定数_賦課年度 = new RString("賦課年度");
    private static final RString 定数_調定年度 = new RString("調定年度");
    private static final RString 定数_出力順 = new RString("出力順");
    private static final RString FORMAT_LEFT = new RString("【");
    private static final RString FORMAT_RIGHT = new RString("】");
    private static final RString 年度 = new RString("年度");
    private static final RString SIGN = new RString(" ＞ ");
    private static final RString 処理枝番 = new RString("0001");
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
    private static final int NUM_100 = 100;
    private static final int DAY = 31;
    private static final Code エラーコード = new Code("04");
    private static final EucEntityId EUC_ENTITY_ID_仮算定異動一括結果一覧表CSV = new EucEntityId(new RString("DBB200013"));

    private FileSpoolManager manager;
    private RString eucFilePath;
    private EucCsvWriter<KarisanteiIdoKekkaIchiranCSVEntity> eucCsvWriter;

    /**
     * コンストラクタ
     */
    public KariSanteiIdoFukaBatch() {
        mapperProvider = InstanceProvider.create(MapperProvider.class);
        被保険者台帳管理dac = InstanceProvider.create(DbT1001HihokenshaDaichoDac.class);
        徴収方法dac = InstanceProvider.create(DbV2001ChoshuHohoAliveDac.class);
        賦課エラーdac = InstanceProvider.create(DbT2010FukaErrorListDac.class);
        mapper = mapperProvider.create(IKariSanteiIdoFukaBatchMapper.class);
    }

    /**
     * {@link InstanceProvider#create}により生成されたインタフェースを返します。
     *
     * @return {@link InstanceProvider#create}により生成された{@link KariSanteiIdoFukaBatch}
     */
    public static KariSanteiIdoFukaBatch createInstance() {
        return InstanceProvider.create(KariSanteiIdoFukaBatch.class);
    }

    /**
     * 資格異動者抽出
     *
     * @param 抽出開始日時 抽出開始日時
     * @param 抽出終了日時 抽出終了日時
     * @param 普徴仮算定賦課処理日時 普徴仮算定賦課処理日時
     */
    @Transaction
    public void selectShikakuIdosha(RDateTime 抽出開始日時,
            RDateTime 抽出終了日時, RDateTime 普徴仮算定賦課処理日時) {
        List<DbT1001HihokenshaDaichoEntity> 資格喪失list = 被保険者台帳管理dac.get資格喪失者(
                抽出開始日時, 抽出終了日時, 普徴仮算定賦課処理日時);
        if (資格喪失list != null && !資格喪失list.isEmpty()) {
            for (DbT1001HihokenshaDaichoEntity entity : 資格喪失list) {
                mapper.insert資格喪失Temp(entity);
            }
        }

        List<DbT1001HihokenshaDaichoEntity> 資格取得list = 被保険者台帳管理dac.get資格取得者(
                抽出開始日時, 抽出終了日時, 普徴仮算定賦課処理日時);
        if (資格取得list != null && !資格取得list.isEmpty()) {
            for (DbT1001HihokenshaDaichoEntity entity : 資格取得list) {
                mapper.insert資格取得Temp(entity);
            }
        }
    }

    /**
     * 特別徴収開始者抽出
     *
     * @param 賦課年度 賦課年度
     * @param 調定年度 調定年度
     * @param 処理対象月 処理対象月
     */
    @Transaction
    public void selectTokuchoKaishisha(FlexibleYear 賦課年度, FlexibleYear 調定年度, RString 処理対象月) {
        RString 日付関連_調定年度 = DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
        RDate システム日時 = RDate.getNowDate();
        RDate date = new RDate(Integer.valueOf(日付関連_調定年度.toString()) - 1, システム日時.getMonthValue(), システム日時.getDayValue());
        RString 特徴開始月_2月捕捉 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_特徴開始月_2月捕捉,
                date, SubGyomuCode.DBB介護賦課);
        if (RSTRING_6.equals(処理対象月) && RSTRING_6.equals(特徴開始月_2月捕捉)) {
            List<DbV2001ChoshuHohoEntity> 特別徴収開始者データ = 徴収方法dac.get特別徴収開始者データ(賦課年度);
            if (特別徴収開始者データ != null && !特別徴収開始者データ.isEmpty()) {
                for (DbV2001ChoshuHohoEntity entity : 特別徴収開始者データ) {
                    mapper.insert特別徴収開始Temp(entity);
                }
            }
        }
        List<TokubetuTyoushuuKaisiTempEntity> 特徴仮算定対象List = mapper.select特別徴収開始Temp();
        if (特徴仮算定対象List == null || 特徴仮算定対象List.isEmpty()) {
            return;
        }
        for (TokubetuTyoushuuKaisiTempEntity 特徴仮算定対象 : 特徴仮算定対象List) {

            if (特徴仮算定対象.get保険料算定段階2() == null || 特徴仮算定対象.get保険料算定段階2().isEmpty()) {
                mapper.insert特徴仮算定抽出Temp_1(特徴仮算定対象);
            } else {
                mapper.insert特徴仮算定抽出Temp_2(特徴仮算定対象);
            }
        }

    }

    /**
     * 特別徴収停止者抽出
     *
     * @param 賦課年度 賦課年度
     * @param 抽出開始日時 抽出開始日時
     * @param 抽出終了日時 抽出終了日時
     */
    @Transaction
    public void selectTokuchoTeishisha(FlexibleYear 賦課年度, RDateTime 抽出開始日時,
            RDateTime 抽出終了日時) {

        KozaSearchKeyBuilder builder = new KozaSearchKeyBuilder();
        builder.setサブ業務コード(SubGyomuCode.DBB介護賦課);
        builder.set業務コード(GyomuCode.DB介護保険);
        IKozaSearchKey searchKey = builder.build();
        ShunoKamokuAuthority sut = InstanceProvider.create(ShunoKamokuAuthority.class);
        List<KamokuCode> list = sut.get更新権限科目コード(ControlDataHolder.getUserId());
        KariSanteiIdoFukaMybatisParameter parameter = new KariSanteiIdoFukaMybatisParameter(
                賦課年度, null, 抽出開始日時, 抽出終了日時, searchKey, list, null);
        mapper.insert特別徴収停止者(parameter);
    }

    /**
     * 口座異動者抽出
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 調定日時 調定日時
     */
    @Transaction
    public void selectKozaIdosha(FlexibleYear 調定年度, FlexibleYear 賦課年度,
            RDateTime 調定日時) {
        KozaSearchKeyBuilder builder = new KozaSearchKeyBuilder();
        builder.set業務コード(GyomuCode.DB介護保険);
        builder.set基準日(new FlexibleDate(調定日時.getDate().toString()));
        builder.set用途区分(new KozaYotoKubunCodeValue(KozaYotoKubunType.振替口座.getCode()));
        IKozaSearchKey kozaSearchKey = builder.build();
        ShunoKamokuAuthority sut = InstanceProvider.create(ShunoKamokuAuthority.class);
        List<KamokuCode> list = sut.get更新権限科目コード(ControlDataHolder.getUserId());
        KariSanteiIdoFukaMybatisParameter parameter = new KariSanteiIdoFukaMybatisParameter(
                賦課年度, 調定年度, null, null, kozaSearchKey, list, null);

        mapper.insert賦課情報Temp(parameter);

        mapper.insert口座の異動(parameter);

        mapper.insert現金の異動(parameter);
    }

    /**
     * 通知書番号発番
     *
     * @param 調定年度 FlexibleYear
     * @param 賦課年度 FlexibleYear
     */
    @Transaction
    public void setTsuchishoBango(FlexibleYear 調定年度, FlexibleYear 賦課年度) {
        KozaSearchKeyBuilder builder = new KozaSearchKeyBuilder();
        builder.set業務コード(GyomuCode.DB介護保険);
        IKozaSearchKey searchKey = builder.build();
        ShunoKamokuAuthority sut = InstanceProvider.create(ShunoKamokuAuthority.class);
        List<KamokuCode> list = sut.get更新権限科目コード(ControlDataHolder.getUserId());
        KariSanteiIdoFukaMybatisParameter parameter = new KariSanteiIdoFukaMybatisParameter(
                賦課年度, 調定年度, null, null, searchKey, list, null);
        List<ShikakuShutokuTempEntity> 資格情報List = mapper.select資格情報();
        List<FukaJohoRelateEntity> 賦課情報List = mapper.select賦課情報(parameter);
        List<FukaJoho> 賦課の情報 = new ArrayList<>();
        for (FukaJohoRelateEntity entity : 賦課情報List) {
            賦課の情報.add(new FukaJoho(entity));
        }
        Collections.sort(資格情報List, new Comparator<ShikakuShutokuTempEntity>() {
            @Override
            public int compare(ShikakuShutokuTempEntity o1, ShikakuShutokuTempEntity o2) {
                if (o1.get第1号資格取得年月日().isBefore(o2.get第1号資格取得年月日())) {
                    return 1;
                }
                return -1;
            }
        });
        dbの処理(資格情報List, 賦課の情報, 賦課年度);
    }

    private void dbの処理(List<ShikakuShutokuTempEntity> 資格情報List, List<FukaJoho> 賦課の情報, FlexibleYear 賦課年度) {
        Collections.sort(資格情報List, new Comparator<ShikakuShutokuTempEntity>() {
            @Override
            public int compare(ShikakuShutokuTempEntity o1, ShikakuShutokuTempEntity o2) {
                return o1.get被保険者番号().compareTo(o2.get被保険者番号());
            }
        });
        List<ShikakuShutokuTempEntity> daichoList = new ArrayList<>();
        boolean isFirst = true;
        HihokenshaNo 被保険者番号 = HihokenshaNo.EMPTY;
        Map<HihokenshaNo, FukaJoho> 賦課情報Map = new HashMap<>();
        for (FukaJoho joho : 賦課の情報) {
            賦課情報Map.put(joho.get被保険者番号(), joho);
        }
        for (ShikakuShutokuTempEntity daicho : 資格情報List) {
            if (isFirst) {
                被保険者番号 = daicho.get被保険者番号();
                daichoList.add(daicho);
                isFirst = false;
                continue;
            }
            if (被保険者番号.equals(daicho.get被保険者番号())) {
                daichoList.add(daicho);
            } else {
                sort資格の情報(daichoList);
                update資格取得Temp(賦課年度, daichoList, 賦課情報Map.get(被保険者番号));
                daichoList.clear();
                被保険者番号 = daicho.get被保険者番号();
                daichoList.add(daicho);
            }
        }
        update資格取得Temp(賦課年度, daichoList, 賦課情報Map.get(被保険者番号));
    }

    private void sort資格の情報(List<ShikakuShutokuTempEntity> 資格の情報) {
        Collections.sort(資格の情報, new Comparator<ShikakuShutokuTempEntity>() {
            @Override
            public int compare(ShikakuShutokuTempEntity o1, ShikakuShutokuTempEntity o2) {
                if (o1.get第1号資格取得年月日().isBefore(o2.get第1号資格取得年月日())) {
                    return 1;
                }
                return -1;
            }
        });
    }

    private void update資格取得Temp(FlexibleYear 賦課年度, List<ShikakuShutokuTempEntity> 資格情報List,
            FukaJoho 賦課情報) {
        if (賦課情報 == null) {
            Decimal 枝番号 = Decimal.ONE;
            for (ShikakuShutokuTempEntity 資格情報Entity : 資格情報List) {
                ShikakuShutokuTempEntity insEntity = new ShikakuShutokuTempEntity();
                insEntity.set通知書番号(get通知書番号(資格情報Entity, 枝番号));
                insEntity.set賦課期日(get賦課期日(資格情報Entity, 賦課年度));
                insEntity.set被保険者番号(資格情報Entity.get被保険者番号());
                insEntity.set異動日(資格情報Entity.get異動日());
                insEntity.set枝番(資格情報Entity.get枝番());
                mapper.update資格取得Temp(insEntity);
                枝番号 = 枝番号.add(Decimal.ONE);
            }
        }
    }

    /**
     * 世帯員把握
     */
    @Transaction
    public void collectSetaiin() {
        RString 賦課方法 = DbBusinessConfig.get(ConfigNameDBB.普通徴収_仮算定異動新規賦課方法,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
        FlexibleYear 日付関連_調定年度 = new FlexibleYear(DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課));
        if (RSTRING_11.equals(賦課方法)) {
            List<ShikakuShutokuTempEntity> 資格情報List = mapper.select資格取得情報();
            for (ShikakuShutokuTempEntity 資格情報Entity : 資格情報List) {
                資格情報Entity.set所得年度(日付関連_調定年度.minusYear(1));
                mapper.insert世帯員把握入力(資格情報Entity);
            }
        }
    }

    /**
     * 賦課計算(資格喪失)
     *
     * @param 調定年度 FlexibleYear
     * @param 賦課年度 FlexibleYear
     * @param 調定日時 YMDHMS
     * @param 処理対象月 RString
     */
    @Transaction
    public void caluculateFukaShikakuSoshitsu(FlexibleYear 調定年度, FlexibleYear 賦課年度,
            YMDHMS 調定日時, RString 処理対象月) {
        KozaSearchKeyBuilder builder = new KozaSearchKeyBuilder();
        builder.set業務コード(GyomuCode.DB介護保険);
        builder.set用途区分(new KozaYotoKubunCodeValue(KozaYotoKubunType.振替口座.getCode()));
        builder.set基準日(FlexibleDate.getNowDate());
        IKozaSearchKey searchKey = builder.build();
        ShunoKamokuAuthority sut = InstanceProvider.create(ShunoKamokuAuthority.class);
        List<KamokuCode> list = sut.get更新権限科目コード(ControlDataHolder.getUserId());
        KariSanteiIdoFukaMybatisParameter parameter = new KariSanteiIdoFukaMybatisParameter(
                賦課年度, 調定年度, null, null, searchKey, list, null);
        List<ShikakuFukaResultEntity> 資格喪失情報List = mapper.select資格喪失情報(parameter);
        if (資格喪失情報List == null || 資格喪失情報List.isEmpty()) {
            return;
        }
        for (ShikakuFukaResultEntity 資格喪失情報Entity : 資格喪失情報List) {
            FukaJoho 更正前賦課情報 = new FukaJoho(資格喪失情報Entity.get賦課情報Entity());
            if (更正前賦課情報.get減免額() != null && Decimal.ZERO.compareTo(更正前賦課情報.get減免額()) == -1) {
                insert賦課エラー(更正前賦課情報, 賦課年度, 調定日時);
                continue;
            }
            FuchoKiUtil 月期対応取得_普徴 = new FuchoKiUtil();
            int 普徴仮算定の最終期 = 月期対応取得_普徴.get期月リスト().filtered仮算定期間().getLast().get期AsInt();
            HihokenshaDaicho 資格情報 = new HihokenshaDaicho(資格喪失情報Entity.get資格喪失Entity());
            int 資格喪失月 = 0;
            if (資格情報 != null && 資格情報.get資格喪失年月日() != null) {
                資格喪失月 = 資格情報.get資格喪失年月日().getMonthValue();
            }
            FukaJoho 更正後賦課情報 = new FukaJoho(資格喪失情報Entity.get賦課情報Entity());
            ChoshuHoho 徴収方法情報 = new ChoshuHoho(資格喪失情報Entity.get徴収方法Entity());
            FukaJoho 賦課の情報_設定後 = 賦課根拠の反映(資格喪失情報Entity, 資格情報, 更正後賦課情報, 調定日時, 賦課年度);
            FukaJohoRelateEntity fukaJohoRelateEntity = new FukaJohoRelateEntity();
            fukaJohoRelateEntity.set介護賦課Entity(賦課の情報_設定後.toEntity());
            List<KibetsuEntity> 介護期別RelateEntity = new ArrayList<>();
            for (Kibetsu kibetsu : 賦課の情報_設定後.getKibetsuList()) {
                set特徴期別金額(資格喪失月, 賦課の情報_設定後, kibetsu, 介護期別RelateEntity);
            }
            set普徴期別金額(賦課の情報_設定後, 普徴仮算定の最終期, 資格喪失月, 介護期別RelateEntity);
            fukaJohoRelateEntity.set介護期別RelateEntity(介護期別RelateEntity);
            賦課の情報_設定後 = new FukaJoho(fukaJohoRelateEntity);
            FukaJohoBuilder fukaBuilder = 賦課の情報_設定後.createBuilderForEdit();
            fukaBuilder.set履歴番号(更正前賦課情報.get履歴番号() + 1);
            fukaBuilder.set調定日時(調定日時);
            fukaBuilder.set徴収方法履歴番号(徴収方法情報.get履歴番号());
            fukaBuilder.set異動基準日時(調定日時);
            fukaBuilder.set口座区分(get口座区分(賦課の情報_設定後, 資格喪失情報Entity));
            fukaBuilder.set職権区分(ShokkenKubun.非該当.getコード());
            fukaBuilder.set賦課市町村コード(get賦課市町村コード(資格情報));
            賦課の情報_設定後 = fukaBuilder.build();
            賦課の情報_設定後 = 調定事由設定(更正後賦課情報, 賦課の情報_設定後, 徴収方法情報);
            DbT2002FukaJohoTempTableEntity 賦課情報Entity = set賦課情報一時テーブルEntity(賦課の情報_設定後);
            mapper.insert賦課の情報一時テーブル(賦課情報Entity);
        }
    }

    /**
     * 賦課計算 (特別徴収停止)
     *
     * @param 調定年度 FlexibleYear
     * @param 賦課年度 FlexibleYear
     * @param 調定日時 YMDHMS
     * @param 処理対象月 RString
     */
    @Transaction
    public void caluculateFukaTokuchoTeishi(FlexibleYear 調定年度, FlexibleYear 賦課年度,
            YMDHMS 調定日時, RString 処理対象月) {
        KozaSearchKeyBuilder builder = new KozaSearchKeyBuilder();
        builder.set業務コード(GyomuCode.DB介護保険);
        builder.set用途区分(new KozaYotoKubunCodeValue(KozaYotoKubunType.振替口座.getCode()));
        builder.set基準日(FlexibleDate.getNowDate());
        IKozaSearchKey searchKey = builder.build();
        ShunoKamokuAuthority sut = InstanceProvider.create(ShunoKamokuAuthority.class);
        List<KamokuCode> list = sut.get更新権限科目コード(ControlDataHolder.getUserId());
        KariSanteiIdoFukaMybatisParameter parameter = new KariSanteiIdoFukaMybatisParameter(
                賦課年度, 調定年度, null, null, searchKey, list, null);
        List<ShikakuFukaResultEntity> 特別徴収停止List = mapper.select特別徴収停止(parameter);
        if (特別徴収停止List == null || 特別徴収停止List.isEmpty()) {
            return;
        }
        for (ShikakuFukaResultEntity 特別徴収停止Entity : 特別徴収停止List) {
            FukaJoho 更正前賦課情報 = new FukaJoho(特別徴収停止Entity.get賦課情報Entity());
            if (更正前賦課情報.get減免額() != null && Decimal.ZERO.compareTo(更正前賦課情報.get減免額()) == -1) {
                insert賦課エラー(更正前賦課情報, 賦課年度, 調定日時);
                continue;
            }
            List<HihokenChoshuRelateEntity> 特別徴収停止情報List = 特別徴収停止Entity.get特別徴収停止List();
            for (HihokenChoshuRelateEntity 特別徴収停止情報Entity : 特別徴収停止情報List) {
                HihokenshaDaicho 資格情報 = new HihokenshaDaicho(特別徴収停止情報Entity.get被保険者台帳管理Entity());
                ChoshuHoho 徴収方法情報 = new ChoshuHoho(特別徴収停止情報Entity.get徴収方法Entity());
                TokuchoKiUtil 月期対応取得_特徴 = new TokuchoKiUtil();
                Kitsuki 特徴を停止する期 = null;
                if ((!RSTRING_1.equals(徴収方法情報.get徴収方法6月())
                        && !RSTRING_2.equals(徴収方法情報.get徴収方法6月()))
                        || (!RSTRING_1.equals(徴収方法情報.get徴収方法7月())
                        && !RSTRING_2.equals(徴収方法情報.get徴収方法7月()))) {
                    特徴を停止する期 = 月期対応取得_特徴.get期月リスト().get月の期(Tsuki._6月);
                } else if ((!RSTRING_1.equals(徴収方法情報.get徴収方法8月())
                        && !RSTRING_2.equals(徴収方法情報.get徴収方法8月()))
                        || (!RSTRING_1.equals(徴収方法情報.get徴収方法9月())
                        && !RSTRING_2.equals(徴収方法情報.get徴収方法9月()))) {
                    特徴を停止する期 = 月期対応取得_特徴.get期月リスト().get月の期(Tsuki._8月);
                }
                FukaJoho 賦課の情報_設定後 = 賦課根拠の反映(特別徴収停止Entity, 資格情報, 更正前賦課情報, 調定日時, 賦課年度);
                FukaJohoBuilder fukaBuilder = 賦課の情報_設定後.createBuilderForEdit();
                fukaBuilder.set履歴番号(更正前賦課情報.get履歴番号() + 1);
                fukaBuilder.set調定日時(調定日時);
                fukaBuilder.set徴収方法履歴番号(徴収方法情報.get履歴番号());
                fukaBuilder.set異動基準日時(調定日時);
                fukaBuilder.set口座区分(get口座区分(賦課の情報_設定後, 特別徴収停止Entity));
                fukaBuilder.set職権区分(ShokkenKubun.非該当.getコード());
                fukaBuilder.set賦課市町村コード(get賦課市町村コード(資格情報));
                賦課の情報_設定後 = fukaBuilder.build();
                if (特徴を停止する期 != null) {
                    FukaJohoRelateEntity fukaJohoRelateEntity = new FukaJohoRelateEntity();
                    fukaJohoRelateEntity.set介護賦課Entity(賦課の情報_設定後.toEntity());
                    List<KibetsuEntity> 介護期別RelateEntity = new ArrayList<>();
                    for (Kibetsu kibetsu : 賦課の情報_設定後.getKibetsuList()) {
                        set特徴金額(特徴を停止する期.get期AsInt(), kibetsu, 介護期別RelateEntity);
                    }
                    fukaJohoRelateEntity.set介護期別RelateEntity(介護期別RelateEntity);
                    賦課の情報_設定後 = new FukaJoho(fukaJohoRelateEntity);
                }
                賦課の情報_設定後 = 調定事由設定(更正前賦課情報, 賦課の情報_設定後, 徴収方法情報);
                DbT2002FukaJohoTempTableEntity 賦課情報Entity = set賦課情報一時テーブルEntity(賦課の情報_設定後);
                mapper.insert賦課の情報一時テーブル(賦課情報Entity);
            }

        }
    }

    /**
     * 賦課計算 (資格取得）
     *
     * @param 調定年度 FlexibleYear
     * @param 賦課年度 FlexibleYear
     * @param 調定日時 YMDHMS
     * @param 処理対象月 RString
     */
    @Transaction
    public void caluculateFukaShikakuShutoku(FlexibleYear 調定年度, FlexibleYear 賦課年度,
            YMDHMS 調定日時, RString 処理対象月) {
        KozaSearchKeyBuilder builder = new KozaSearchKeyBuilder();
        builder.set業務コード(GyomuCode.DB介護保険);
        builder.set用途区分(new KozaYotoKubunCodeValue(KozaYotoKubunType.振替口座.getCode()));
        builder.set基準日(FlexibleDate.getNowDate());
        IKozaSearchKey searchKey = builder.build();
        ShunoKamokuAuthority sut = InstanceProvider.create(ShunoKamokuAuthority.class);
        List<KamokuCode> list = sut.get更新権限科目コード(ControlDataHolder.getUserId());
        KariSanteiIdoFukaMybatisParameter parameter = new KariSanteiIdoFukaMybatisParameter(
                賦課年度, 調定年度, null, null, searchKey, list, null);
        List<ShikakuFukaResultEntity> 資格取得List = mapper.select資格取得(parameter);
        if (資格取得List == null || 資格取得List.isEmpty()) {
            return;
        }
        SeigyoJoho 月別保険料制御情報 = new SeigyoJoho();
        HokenryoDankaiList 保険料段階List = HokenryoDankaiSettings.createInstance().get保険料段階ListIn(賦課年度);
        月別保険料制御情報セット(月別保険料制御情報, 保険料段階List);
        FuchoKiUtil 月期対応取得_普徴 = new FuchoKiUtil();
        KitsukiList 普徴期月リスト = 月期対応取得_普徴.get期月リスト();
        int 算定期 = 普徴期月リスト.get月の期(Tsuki.toValue(処理対象月)).get期AsInt();
        KitsukiList 普徴仮算定期間 = 普徴期月リスト.filtered仮算定期間();
        int 最終期 = 普徴仮算定期間.getLast().get期AsInt();
        for (ShikakuFukaResultEntity 資格取得Entity : 資格取得List) {
            List<ShikakuShutokuTempEntity> 資格情報List = 資格取得Entity.get資格取得List();
            for (ShikakuShutokuTempEntity 資格情報 : 資格情報List) {
                RString 保険料段階 = get保険料段階(資格取得Entity, 資格情報, 賦課年度, 月別保険料制御情報);
                Decimal 保険料率 = get保険料率(保険料段階);
                if (資格取得Entity.get賦課情報Entity() == null) {
                    FukaJoho 新しい賦課の情報 = new FukaJoho(調定年度, 賦課年度, 資格情報.get通知書番号(), NUM_0);
                    HihokenshaDaicho 資格の情報 = get資格情報(資格情報);
                    FukaJoho 設定後_賦課の情報 = 賦課根拠の反映_資格取得(資格取得Entity, 資格の情報, 新しい賦課の情報,
                            調定日時, 保険料率, 賦課年度);
                    List<Decimal> 普徴期別金額リスト = caluculateChotei(設定後_賦課の情報, 保険料率, 調定日時, 処理対象月);
                    FukaJohoBuilder builder_設定後 = 設定後_賦課の情報.createBuilderForEdit();
                    builder_設定後.set履歴番号(NUM_0);
                    builder_設定後.set被保険者番号(資格情報.get被保険者番号());
                    builder_設定後.set調定日時(調定日時);
                    builder_設定後.set保険料段階_仮算定時(保険料段階);
                    builder_設定後.set異動基準日時(調定日時);
                    builder_設定後.set口座区分(get口座区分(設定後_賦課の情報, 資格取得Entity));
                    builder_設定後.set賦課市町村コード(get賦課市町村コード_資格取得(資格情報));
                    builder_設定後.set特徴歳出還付額(Decimal.ZERO);
                    builder_設定後.set普徴歳出還付額(Decimal.ZERO);
                    builder_設定後.set減免額(Decimal.ZERO);
                    builder_設定後.set調定事由1(ChoteiJiyuCode.仮算定賦課.getコード());
                    設定後_賦課の情報 = builder_設定後.build();
                    DbT2002FukaJohoTempTableEntity 賦課情報Entity = set賦課情報一時テーブルEntity(設定後_賦課の情報);
                    int index = NUM_0;
                    for (int 期 = 算定期; 期 <= 最終期; 期++) {
                        set普徴期別金額(index, 普徴期別金額リスト, 賦課情報Entity, 期);
                        index = index + 1;
                    }
                    mapper.insert賦課の情報一時テーブル(賦課情報Entity);
                }
            }
        }
    }

    private LasdecCode get賦課市町村コード_資格取得(ShikakuShutokuTempEntity 資格情報) {
        if (資格情報.get旧市町村コード() != null && !資格情報.get旧市町村コード().isEmpty()) {
            return 資格情報.get旧市町村コード();
        } else if (資格情報.get広住特措置元市町村コード() != null && !資格情報.get広住特措置元市町村コード().isEmpty()) {
            return 資格情報.get広住特措置元市町村コード();
        } else if (資格情報.get市町村コード() != null && !資格情報.get市町村コード().isEmpty()) {
            return 資格情報.get市町村コード();
        }
        return null;
    }

    /**
     * 調定計算
     *
     * @param 賦課の情報 FukaJoho
     * @param 年額保険料 Decimal
     * @param 調定日時 YMDHMS
     * @param 処理対象月 RString
     * @return 更正後賦課の情報
     */
    public List<Decimal> caluculateChotei(FukaJoho 賦課の情報, Decimal 年額保険料, YMDHMS 調定日時, RString 処理対象月) {
        FuchoKiUtil 月期対応取得_普徴 = new FuchoKiUtil();
        KitsukiList 普徴期月リスト = 月期対応取得_普徴.get期月リスト();
        Kitsuki 最終法定納期 = 普徴期月リスト.get最終法定納期();
        int 納期数 = 最終法定納期.get期AsInt();
        int 算定期 = 普徴期月リスト.get月の期(Tsuki.toValue(処理対象月)).get期AsInt();
        KitsukiList 普徴仮算定期間 = 普徴期月リスト.filtered仮算定期間();
        int 最終期 = 普徴仮算定期間.getLast().get期AsInt();
        int 仮算定期数 = 最終期 - 算定期;
        int 納付額 = 年額保険料.multiply(仮算定期数 / (納期数 - (算定期 - 1))).intValue();
        int 期別金額 = 納付額 / 仮算定期数;
        RString 端数調整 = DbBusinessConfig.get(ConfigNameDBB.普通徴収_期別端数,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
        RString 仮算定端数調整有無 = DbBusinessConfig.get(ConfigNameDBB.普通徴収_仮算定端数調整有無,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
        int 期別金額_端数調整 = 0;
        if (RSTRING_100.equals(端数調整)) {
            期別金額_端数調整 = (期別金額 / NUM_100) * NUM_100;
        }
        List<Decimal> 普徴期別金額リスト = new ArrayList<>();
        if (仮算定期数 == NUM_1) {
            普徴期別金額リスト.add(new Decimal(納付額));
        } else if (NUM_1 < 仮算定期数) {
            if (RSTRING_1.equals(仮算定端数調整有無)) {
                Decimal 金額_0 = new Decimal(期別金額_端数調整 + (期別金額 - 期別金額_端数調整) * 仮算定期数);
                普徴期別金額リスト.add(金額_0);
                for (int i = 1; i < 仮算定期数; i++) {
                    普徴期別金額リスト.add(new Decimal(期別金額_端数調整));
                }
            } else if (RSTRING_0.equals(仮算定端数調整有無)) {
                for (int i = 0; i < 仮算定期数; i++) {
                    普徴期別金額リスト.add(new Decimal(期別金額_端数調整));
                }
            }
        }
        return 普徴期別金額リスト;
    }

    /**
     * 賦課計算 (口座異動のみ反映）
     *
     * @param 賦課年度 FlexibleYear
     * @param 調定日時 YMDHMS
     */
    @Transaction
    public void caluculateFukaKozaIdo(FlexibleYear 賦課年度, YMDHMS 調定日時) {
        KozaSearchKeyBuilder builder = new KozaSearchKeyBuilder();
        builder.set業務コード(GyomuCode.DB介護保険);
        builder.set用途区分(new KozaYotoKubunCodeValue(KozaYotoKubunType.振替口座.getCode()));
        builder.set基準日(FlexibleDate.getNowDate());
        IKozaSearchKey searchKey = builder.build();
        ShunoKamokuAuthority sut = InstanceProvider.create(ShunoKamokuAuthority.class);
        List<KamokuCode> list = sut.get更新権限科目コード(ControlDataHolder.getUserId());
        KariSanteiIdoFukaMybatisParameter parameter = new KariSanteiIdoFukaMybatisParameter(
                賦課年度, null, null, null, searchKey, list, 調定日時);
        List<ShikakuFukaResultEntity> 口座異動List = mapper.select口座異動(parameter);
        if (口座異動List == null || 口座異動List.isEmpty()) {
            return;
        }
        for (ShikakuFukaResultEntity 口座異動Entity : 口座異動List) {
            FukaJoho 更正前賦課情報 = new FukaJoho(口座異動Entity.get賦課情報Entity());
            FukaJoho 更正後賦課情報 = 更正前賦課情報;
            FukaJohoBuilder fukaBuilder = 更正後賦課情報.createBuilderForEdit();
            KozaIdoEntity 口座異動情報 = 口座異動Entity.get口座異動Entity();
            if (口座異動情報 != null) {
                fukaBuilder.set被保険者番号(口座異動情報.get被保険者番号());
                fukaBuilder.set調定日時(調定日時);
                fukaBuilder.set異動基準日時(調定日時);
                fukaBuilder.set履歴番号(更正前賦課情報.get履歴番号() + 1);
                fukaBuilder.set口座区分(口座異動情報.get更新用口座区分());
                fukaBuilder.set調定事由1(ChoteiJiyuCode.口座情報変更.getコード());
            }
            更正後賦課情報 = fukaBuilder.build();
            DbT2002FukaJohoTempTableEntity 賦課情報Entity = set賦課情報一時テーブルEntity(更正後賦課情報);
            mapper.insert賦課の情報一時テーブル(賦課情報Entity);
        }
    }

    /**
     * 依頼金額計算（8月特徴開始）
     *
     * @param 調定年度 FlexibleYear
     * @param 調定日時 YMDHMS
     */
    @Transaction
    public void caluculateIraiKinTokucho8gatuKaishi(FlexibleYear 調定年度, YMDHMS 調定日時) {
        KozaSearchKeyBuilder builder = new KozaSearchKeyBuilder();
        builder.set業務コード(GyomuCode.DB介護保険);
        builder.set用途区分(new KozaYotoKubunCodeValue(KozaYotoKubunType.振替口座.getCode()));
        builder.set基準日(FlexibleDate.getNowDate());
        IKozaSearchKey searchKey = builder.build();
        ShunoKamokuAuthority sut = InstanceProvider.create(ShunoKamokuAuthority.class);
        List<KamokuCode> list = sut.get更新権限科目コード(ControlDataHolder.getUserId());
        KariSanteiIdoFukaMybatisParameter parameter = new KariSanteiIdoFukaMybatisParameter(
                null, 調定年度, null, null, searchKey, list, 調定日時);
        List<TokutyouKariSannteiRelateEntity> 特徴仮算定List = mapper.select8月特徴開始(parameter);
        if (特徴仮算定List == null || 特徴仮算定List.isEmpty()) {
            return;
        }
        Decimal 枝番号 = Decimal.ONE;
        for (TokutyouKariSannteiRelateEntity 特徴仮算定Entity : 特徴仮算定List) {
            List<SeikatsuHogoJukyusha> 生保の情報のリスト = get生保の情報のリスト_8月特徴開始(特徴仮算定Entity);
            List<RoreiFukushiNenkinJukyusha> 老齢の情報のリスト = get老齢の情報のリスト_8月特徴開始(特徴仮算定Entity);
            HihokenshaDaicho 資格情報 = new HihokenshaDaicho(特徴仮算定Entity.get被保険者台帳管理Entity());
            ChoshuHoho 徴収方法情報 = new ChoshuHoho(特徴仮算定Entity.get徴収方法Entity());
            FukaJoho 編集後賦課の情報;
            boolean 賦課Flag = false;
            if (特徴仮算定Entity.get賦課情報Entity() == null) {
                FukaJoho 新しい賦課の情報 = new FukaJoho(調定年度, 調定年度, TsuchishoNo.EMPTY, NUM_0);
                編集後賦課の情報 = editFukaJokyoKyotsu(RSTRING_0, 調定日時, 特徴仮算定Entity, 新しい賦課の情報, 調定年度,
                        資格情報, 徴収方法情報, 生保の情報のリスト,
                        老齢の情報のリスト, 特徴仮算定Entity.get前年度保険料段階(),
                        特徴仮算定Entity.get前年度合計所得金額(), 特徴仮算定Entity.get前年度公的年金収入額(), 枝番号);
                枝番号 = 枝番号.add(Decimal.ONE);
                賦課Flag = true;
            } else {
                FukaJoho 更正後賦課の情報 = new FukaJoho(特徴仮算定Entity.get賦課情報Entity());
                編集後賦課の情報 = editFukaJokyoKyotsu(RSTRING_1, 調定日時, 特徴仮算定Entity, 更正後賦課の情報, 調定年度,
                        資格情報, 徴収方法情報, 生保の情報のリスト,
                        老齢の情報のリスト, 特徴仮算定Entity.get前年度保険料段階(),
                        特徴仮算定Entity.get前年度合計所得金額(), 特徴仮算定Entity.get前年度公的年金収入額(), Decimal.ZERO);
            }
            RString 特別徴収_年額基準年度_8月開始 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_年額基準年度_8月開始,
                    new RDate(調定年度.minusYear(NUM_1).toString()), SubGyomuCode.DBB介護賦課);
            HokenryoDankaiList 前年度の保険料段階リスト;
            Decimal 保険料率 = Decimal.ZERO;
            if (TokuchoNengakuKijunNendo8Gatsu.当年度.getコード().equals(特別徴収_年額基準年度_8月開始)) {
                前年度の保険料段階リスト = HokenryoDankaiSettings.createInstance()
                        .get保険料段階ListIn(調定年度.minusYear(NUM_1));
                保険料率 = 前年度の保険料段階リスト.getBy段階区分(特徴仮算定Entity.get前年度保険料段階()).get保険料率();
            } else if (TokuchoNengakuKijunNendo8Gatsu.翌年度.getコード().equals(特別徴収_年額基準年度_8月開始)) {
                前年度の保険料段階リスト = HokenryoDankaiSettings.createInstance()
                        .get保険料段階ListIn(調定年度);
                保険料率 = 前年度の保険料段階リスト.getBy段階区分(編集後賦課の情報.get保険料段階_仮算定時()).get保険料率();
            }
            TokuchoKarisanteiKiwariOutput 特徴仮算定期割 = get特徴仮算定期割(調定年度, 保険料率);
            Decimal 特徴期別額 = Decimal.ZERO;
            if (特徴仮算定期割 != null && 特徴仮算定期割.get特徴期別額() != null && NUM_2 <= 特徴仮算定期割.get特徴期別額().size()) {
                特徴期別額 = 特徴仮算定期割.get特徴期別額().get(NUM_2);
            }

            DbT2002FukaJohoTempTableEntity 賦課情報Entity = set賦課情報一時テーブルEntity(編集後賦課の情報);
            賦課情報Entity.setTkKibetsuGaku03(特徴期別額);
            if (賦課Flag) {
                set金額ToZero(賦課情報Entity);
            }
            mapper.insert賦課の情報一時テーブル(賦課情報Entity);
        }

    }

    private void set普徴期別金額(int index, List<Decimal> 普徴期別金額リスト,
            DbT2002FukaJohoTempTableEntity 賦課情報Entity, int 期) {
        switch (期) {
            case NUM_1:
                賦課情報Entity.setFuKibetsuGaku01(普徴期別金額リスト.get(index));
                break;
            case NUM_2:
                賦課情報Entity.setFuKibetsuGaku02(普徴期別金額リスト.get(index));
                break;
            case NUM_3:
                賦課情報Entity.setFuKibetsuGaku03(普徴期別金額リスト.get(index));
                break;
            case NUM_4:
                賦課情報Entity.setFuKibetsuGaku04(普徴期別金額リスト.get(index));
                break;
            case NUM_5:
                賦課情報Entity.setFuKibetsuGaku05(普徴期別金額リスト.get(index));
                break;
            case NUM_6:
                賦課情報Entity.setFuKibetsuGaku06(普徴期別金額リスト.get(index));
                break;
            case NUM_7:
                賦課情報Entity.setFuKibetsuGaku07(普徴期別金額リスト.get(index));
                break;
            case NUM_8:
                賦課情報Entity.setFuKibetsuGaku08(普徴期別金額リスト.get(index));
                break;
            case NUM_9:
                賦課情報Entity.setFuKibetsuGaku09(普徴期別金額リスト.get(index));
                break;
            case NUM_10:
                賦課情報Entity.setFuKibetsuGaku10(普徴期別金額リスト.get(index));
                break;
            case NUM_11:
                賦課情報Entity.setFuKibetsuGaku11(普徴期別金額リスト.get(index));
                break;
            case NUM_12:
                賦課情報Entity.setFuKibetsuGaku12(普徴期別金額リスト.get(index));
                break;
            case NUM_13:
                賦課情報Entity.setFuKibetsuGaku13(普徴期別金額リスト.get(index));
                break;
            case NUM_14:
                賦課情報Entity.setFuKibetsuGaku14(普徴期別金額リスト.get(index));
                break;
            default:
                break;

        }
    }

    /**
     * 賦課の情報共通編集
     *
     * @param 処理区分 RString
     * @param 調定日時 YMDHMS
     * @param 特徴仮算定Entity TokutyouKariSannteiRelateEntity
     * @param 設定前賦課の情報 FukaJoho
     * @param 調定年度 FlexibleYear
     * @param 資格情報 HihokenshaDaicho
     * @param 徴収方法情報 ChoshuHoho
     * @param 生保の情報のリスト List<SeikatsuHogoJukyusha>
     * @param 老齢の情報のリスト List<RoreiFukushiNenkinJukyusha>
     * @param 前年度保険料段階 RString
     * @param 前年度合計所得金額 Decimal
     * @param 前年度公的年金収入額 Decimal
     * @param 枝番号 Decimal
     * @return 編集後賦課の情報
     */
    public FukaJoho editFukaJokyoKyotsu(RString 処理区分, YMDHMS 調定日時,
            TokutyouKariSannteiRelateEntity 特徴仮算定Entity,
            FukaJoho 設定前賦課の情報, FlexibleYear 調定年度,
            HihokenshaDaicho 資格情報, ChoshuHoho 徴収方法情報,
            List<SeikatsuHogoJukyusha> 生保の情報のリスト,
            List<RoreiFukushiNenkinJukyusha> 老齢の情報のリスト, RString 前年度保険料段階,
            Decimal 前年度合計所得金額, Decimal 前年度公的年金収入額, Decimal 枝番号) {
        TsuchishoNo 通知書番号 = TsuchishoNo.EMPTY;
        if (RSTRING_0.equals(処理区分)) {
            RString 枝番 = new RString(枝番号.toString()).padZeroToLeft(2);
            通知書番号 = new TsuchishoNo(ZERO.concat(資格情報.get被保険者番号().value()).concat(枝番));
        } else if (RSTRING_1.equals(処理区分)) {
            通知書番号 = 設定前賦課の情報.get通知書番号();
        }
        FukaJohoBuilder builder = 設定前賦課の情報.createBuilderForEdit();
        builder.set通知書番号(通知書番号);
        builder.set資格取得日(資格情報.get第1号資格取得年月日());
        builder.set資格取得事由(資格情報.get資格取得事由コード());
        builder.set資格喪失日(資格情報.get資格喪失年月日());
        builder.set資格喪失事由(資格情報.get資格喪失事由コード());
        FlexibleDate 賦課期日 = FukaKeisan.createInstance().findOut賦課基準日(調定年度, 資格情報);
        builder.set賦課期日(賦課期日);
        builder.set賦課市町村コード(get賦課市町村コード(資格情報));
        //TODO 仕様変更1.08仕様変更
        builder.set調定事由1(ChoteiJiyuCode.仮算定賦課.getコード());
        builder.set口座区分(get口座区分_特徴仮算定(設定前賦課の情報, 特徴仮算定Entity));
        builder.set被保険者番号(資格情報.get被保険者番号());
        builder.set識別コード(資格情報.get識別コード());
        builder.set調定日時(調定日時);
        builder.set更正月(RSTRING_4);
        builder.set徴収方法履歴番号(徴収方法情報.get履歴番号());
        builder.set異動基準日時(調定日時);
        if (RSTRING_0.equals(処理区分)) {
            builder.set履歴番号(0);
            builder.set特徴歳出還付額(Decimal.ZERO);
            builder.set普徴歳出還付額(Decimal.ZERO);
        } else if (RSTRING_1.equals(処理区分)) {
            builder.set履歴番号(設定前賦課の情報.get履歴番号() + 1);
        }
        FlexibleDate 本年度開始日 = new FlexibleDate(NendoUtil.toNendoStartDate(設定前賦課の情報.get賦課年度()).toDateString());
        FlexibleDate 本年度終了日 = new FlexibleDate(設定前賦課の情報.get賦課年度().plusYear(NUM_1).getYearValue(),
                Month.MARCH.getValue(), DAY);
        set生活保護(builder, 生保の情報のリスト, 本年度開始日, 本年度終了日);

        set老齢福祉年金(builder, 老齢の情報のリスト, 本年度開始日, 本年度終了日);
        return builder.build();
    }

    /**
     * 依頼金計算処理区分
     *
     * @param 調定年度 FlexibleYear
     * @param 算定月 int
     * @return 依頼金計算処理区分
     */
    public RString getIraikinKeisanShoriKubun(FlexibleYear 調定年度, int 算定月) {
        DbT7022ShoriDateKanriDac 処理日付管理Dac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
        List<DbT7022ShoriDateKanriEntity> 処理日付管理List = 処理日付管理Dac.get依頼金額計算(調定年度);
        if (処理日付管理List == null || 処理日付管理List.isEmpty()) {
            return RSTRING_1;
        }
        RString 依頼金計算処理区分 = null;
        for (DbT7022ShoriDateKanriEntity 処理日付管理 : 処理日付管理List) {
            if (処理日付管理.getKijunTimestamp() == null || 処理日付管理.getKijunTimestamp().isEmpty()) {
                依頼金計算処理区分 = RSTRING_1;
                break;
            }
        }
        if (依頼金計算処理区分 == null) {
            依頼金計算処理区分 = RSTRING_2;
        }
        return 依頼金計算処理区分;
    }

    /**
     * 仮算定異動（一括）結果一覧表を作成するメソッドです。
     *
     * @param 調定年度 FlexibleYear
     * @param 賦課年度 FlexibleYear
     * @param 調定日時 YMDHMS
     * @param 出力順ID Long
     */
    public void spoolKariSanteiIdoKekkaIchiran(FlexibleYear 調定年度,
            FlexibleYear 賦課年度, YMDHMS 調定日時, Long 出力順ID) {
        IKarisanteiIdoKekkaMapper kekkaMapper = mapperProvider.create(IKarisanteiIdoKekkaMapper.class);
        KozaSearchKeyBuilder builder = new KozaSearchKeyBuilder();
        builder.set業務コード(GyomuCode.DB介護保険);
        builder.set用途区分(new KozaYotoKubunCodeValue(KozaYotoKubunType.振替口座.getCode()));
        builder.set基準日(new FlexibleDate(調定日時.getRDateTime().getDate().toDateString()));
        IKozaSearchKey kozaSearchKey = builder.build();
        ShunoKamokuAuthority sut = InstanceProvider.create(ShunoKamokuAuthority.class);
        List<KamokuCode> list = sut.get更新権限科目コード(ControlDataHolder.getUserId());
        KariSanteiIdoFukaMybatisParameter parameter = new KariSanteiIdoFukaMybatisParameter(
                賦課年度, 調定年度, null, null,
                kozaSearchKey, list, 調定日時);
        List<KarisanteiIdoKekkaEntity> entityList = kekkaMapper.select仮算定異動賦課(parameter);
        List<KeisanjohoAtenaKozaEntity> 更正前EntityList = new ArrayList<>();
        List<KeisanjohoAtenaKozaEntity> 更正後EntityList = new ArrayList<>();
        for (KarisanteiIdoKekkaEntity entity : entityList) {
            if (RSTRING_1.equals(entity.get計算後情報().getKoseiZengoKubun())) {
                更正前EntityList.add(new KeisanjohoAtenaKozaEntity(entity.get計算後情報(), entity.get宛名(), entity.get口座()));
            }
            if (RSTRING_2.equals(entity.get計算後情報().getKoseiZengoKubun())) {
                更正後EntityList.add(new KeisanjohoAtenaKozaEntity(entity.get計算後情報(), entity.get宛名(), entity.get口座()));
            }
        }
        List<KeisanjohoAtenaKozaKouseizengoEntity> 更正前後EntityList = new ArrayList<>();
        for (KeisanjohoAtenaKozaEntity 計算後情報_宛名_口座_更正後Entity : 更正後EntityList) {
            KeisanjohoAtenaKozaKouseizengoEntity entity = new KeisanjohoAtenaKozaKouseizengoEntity();
            entity.set計算後情報_宛名_口座_更正後Entity(計算後情報_宛名_口座_更正後Entity);
            for (KeisanjohoAtenaKozaEntity 計算後情報_宛名_口座_更正前Entity : 更正前EntityList) {
                if (計算後情報_宛名_口座_更正前Entity.get調定年度()
                        .compareTo(計算後情報_宛名_口座_更正後Entity.get調定年度()) == 0
                        && 計算後情報_宛名_口座_更正前Entity.get賦課年度()
                        .compareTo(計算後情報_宛名_口座_更正後Entity.get賦課年度()) == 0
                        && 計算後情報_宛名_口座_更正前Entity.get通知書番号().equals(計算後情報_宛名_口座_更正後Entity.get通知書番号())
                        && 計算後情報_宛名_口座_更正前Entity.get作成処理名().equals(計算後情報_宛名_口座_更正後Entity.get作成処理名())) {
                    entity.set計算後情報_宛名_口座_更正前Entity(計算後情報_宛名_口座_更正前Entity);
                    break;
                }
            }
            更正前後EntityList.add(entity);
        }

        new KarisanteiIdoKekkaIchiranPrintService().print仮算定異動一括結果一覧表(更正前後EntityList, new RString(出力順ID),
                調定日時, 賦課年度);
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther,
                EUC_ENTITY_ID_仮算定異動一括結果一覧表CSV, UzUDE0831EucAccesslogFileType.Csv);
        eucFilePath = Path.combinePath(manager.getEucOutputDirectry(), ファイル名称);
        eucCsvWriter = new EucCsvWriter.InstanceBuilder(eucFilePath, EUC_ENTITY_ID_仮算定異動一括結果一覧表CSV)
                .setDelimiter(EUC_WRITER_DELIMITER)
                .setEnclosure(EUC_WRITER_ENCLOSURE)
                .setEncode(Encode.UTF_8withBOM)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true)
                .build();
        List<Integer> 月List = set普徴期();
        for (KeisanjohoAtenaKozaKouseizengoEntity 更正前後Entity : 更正前後EntityList) {
            eucCsvWriter.writeLine(setCSVEntity(更正前後Entity, 調定日時, 賦課年度, 月List));
        }
        eucCsvWriter.close();

        List<RString> 出力条件リスト = new ArrayList<>();
        RStringBuilder rstbuilder = new RStringBuilder();
        rstbuilder.append(定数_出力条件);
        出力条件リスト.add(rstbuilder.toRString());
        rstbuilder = new RStringBuilder();
        rstbuilder.append(FORMAT_LEFT.concat(定数_調定年度).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE)
                .concat(調定年度.wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN)
                        .fillType(FillType.BLANK).toDateString().concat(年度)));
        出力条件リスト.add(rstbuilder.toRString());
        rstbuilder = new RStringBuilder();
        rstbuilder.append(FORMAT_LEFT.concat(定数_賦課年度).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE)
                .concat(賦課年度.wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN)
                        .fillType(FillType.BLANK).toDateString().concat(年度)));
        出力条件リスト.add(rstbuilder.toRString());
        rstbuilder = new RStringBuilder();
        rstbuilder.append(FORMAT_LEFT.concat(定数_出力順).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE));
        IChohyoShutsuryokujunFinder fider = ChohyoShutsuryokujunFinderFactory.createInstance();
        IOutputOrder outputOrder = fider.get出力順(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB200013.getReportId(), 出力順ID);
        if (outputOrder != null) {
            List<ISetSortItem> iSetSortItemList = outputOrder.get設定項目リスト();
            for (ISetSortItem iSetSortItem : iSetSortItemList) {
                if (iSetSortItem == iSetSortItemList.get(iSetSortItemList.size() - 1)) {
                    rstbuilder.append(iSetSortItem.get項目名());
                } else {
                    rstbuilder.append(iSetSortItem.get項目名()).append(SIGN);
                }
            }
        }
        出力条件リスト.add(rstbuilder.toRString());
        loadバッチ出力条件リスト(出力条件リスト);
    }

    /**
     * バッチ出力条件リストの出力メソッドです。
     *
     * @param 出力条件リスト List<RString>
     */
    public void loadバッチ出力条件リスト(List<RString> 出力条件リスト) {

        Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
        RString 導入団体コード = 地方公共団体.getLasdecCode_().value();
        RString 市町村名 = 地方公共団体.get市町村名();

        ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                ReportIdDBB.DBB200013.getReportId().value(),
                導入団体コード,
                市町村名,
                RString.FULL_SPACE.concat(String.valueOf(JobContextHolder.getJobId())),
                ReportIdDBB.DBB200013.getReportName(),
                new RString(String.valueOf(eucCsvWriter.getCount())),
                CSV出力有無,
                ファイル名称,
                出力条件リスト);
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(reportOutputJokenhyoItem);
        printer.print();
    }

    private List<Integer> set普徴期() {
        List<Integer> 月List = new ArrayList<>();
        KitsukiList 期月リスト_普徴 = new FuchoKiUtil().get期月リスト();
        List<Kitsuki> 期月リスト = 期月リスト_普徴.filtered仮算定期間().toList();
        Kitsuki 最終法定納期 = 期月リスト_普徴.get最終法定納期();
        for (Kitsuki 期 : 期月リスト) {
            if (期.get期AsInt() <= 最終法定納期.get期AsInt()) {
                月List.add(期.get月AsInt());
            }
        }
        return 月List;
    }

    private TsukibetsuHokenryoDankai get月別保険料段階(ShikakuFukaResultEntity 資格取得Entity,
            ShikakuShutokuTempEntity 資格情報, List<SetaiShotokuEntity> 世帯員所得情報List,
            FlexibleYear 賦課年度, SeigyoJoho 月別保険料制御情報) {
        List<SeikatsuHogoJukyusha> 生保の情報のリスト = get生保の情報のリスト(資格取得Entity);
        List<RoreiFukushiNenkinJukyusha> 老齢の情報のリスト = get老齢の情報のリスト(資格取得Entity);
        FukaKonkyoBatchParameter param = new FukaKonkyoBatchParameter();
        param.set世帯員所得情報List(世帯員所得情報List);
        param.set生保の情報リスト(生保の情報のリスト);
        param.set老齢の情報のリスト(老齢の情報のリスト);
        param.set賦課基準日(資格情報.get賦課期日());
        FukaKonkyoFactory factory = InstanceProvider.create(FukaKonkyoFactory.class);
        FukaKonkyo 賦課根拠 = factory.create(param);
        HokenryoDankaiHanteiParameter parameter = new HokenryoDankaiHanteiParameter();
        parameter.setFukaNendo(賦課年度);
        parameter.setFukaKonkyo(賦課根拠);
        parameter.setSeigyoJoho(月別保険料制御情報);
        HokenryoDankaiHantei hantei = InstanceProvider.create(HokenryoDankaiHantei.class);
        return hantei.determine月別保険料段階(parameter);
    }

    private Decimal get保険料率(RString 保険料段階) {
        HokenryoDankaiList 保険料段階List = HokenryoDankaiSettings.createInstance().getCurrent保険料段階List();
        HokenryoDankai dankai = 保険料段階List.getBy段階区分(保険料段階);
        return dankai.get保険料率();
    }

    private FukaJoho 賦課根拠の反映(ShikakuFukaResultEntity resultEntity, HihokenshaDaicho 資格情報, FukaJoho 更正後賦課情報,
            YMDHMS 調定日時, FlexibleYear 賦課年度) {
        List<SeikatsuHogoJukyusha> 生保の情報のリスト = get生保の情報のリスト(resultEntity);
        List<RoreiFukushiNenkinJukyusha> 老齢の情報のリスト = get老齢の情報のリスト(resultEntity);
        List<KyokaisoGaitosha> 境界層の情報のリスト = get境界層の情報のリスト(resultEntity);
        FukaKokyoBatchParameter batchParameter = new FukaKokyoBatchParameter();
        batchParameter.set賦課年度(賦課年度);
        batchParameter.set賦課の情報_設定前(更正後賦課情報);
        batchParameter.set資格の情報(資格情報);
        batchParameter.set生保の情報のリスト(生保の情報のリスト);
        batchParameter.set老福の情報のリスト(老齢の情報のリスト);
        batchParameter.set境界層の情報のリスト(境界層の情報のリスト);
        batchParameter.set調定日時(調定日時);
        return FukaKeisan.createInstance().reflect賦課根拠(batchParameter);
    }

    private FukaJoho 賦課根拠の反映_資格取得(ShikakuFukaResultEntity resultEntity, HihokenshaDaicho 資格情報,
            FukaJoho 新しい賦課の情報,
            YMDHMS 調定日時, Decimal 年額保険料, FlexibleYear 賦課年度) {
        List<SeikatsuHogoJukyusha> 生保の情報のリスト = get生保の情報のリスト(resultEntity);
        List<RoreiFukushiNenkinJukyusha> 老齢の情報のリスト = get老齢の情報のリスト(resultEntity);
        List<KyokaisoGaitosha> 境界層の情報のリスト = get境界層の情報のリスト(resultEntity);
        FukaKokyoBatchParameter batchParameter = new FukaKokyoBatchParameter();
        batchParameter.set賦課年度(賦課年度);
        batchParameter.set賦課の情報_設定前(新しい賦課の情報);
        batchParameter.set資格の情報(資格情報);
        batchParameter.set世帯員所得情報List(resultEntity.get世帯員所得情報List());
        batchParameter.set生保の情報のリスト(生保の情報のリスト);
        batchParameter.set老福の情報のリスト(老齢の情報のリスト);
        batchParameter.set境界層の情報のリスト(境界層の情報のリスト);
        batchParameter.set年額保険料(年額保険料);
        batchParameter.set調定日時(調定日時);
        return FukaKeisan.createInstance().reflect賦課根拠(batchParameter);
    }

    private void insert賦課エラー(FukaJoho 更正前賦課情報, FlexibleYear 賦課年度, YMDHMS 調定日時) {

        DbT2010FukaErrorListEntity 賦課エラーEntity = 賦課エラーdac.selectByKey(SubGyomuCode.DBB介護賦課, 内部帳票ID,
                賦課年度, 更正前賦課情報.get通知書番号());
        if (賦課エラーEntity == null) {
            賦課エラーEntity = new DbT2010FukaErrorListEntity();
            賦課エラーEntity.setSubGyomuCode(SubGyomuCode.DBB介護賦課);
            賦課エラーEntity.setInternalReportId(内部帳票ID);
            賦課エラーEntity.setInternalReportCreationDateTime(調定日時.getRDateTime());
            賦課エラーEntity.setFukaNendo(賦課年度);
            賦課エラーEntity.setTsuchishoNo(更正前賦課情報.get通知書番号());
            賦課エラーEntity.setBatchId(バッチID);
            賦課エラーEntity.setBatchStartingDateTime(調定日時.getRDateTime());
            賦課エラーEntity.setErrorCode(エラーコード);
            賦課エラーEntity.setHihokenshaNo(更正前賦課情報.get被保険者番号());
            賦課エラーEntity.setShikibetsuCode(更正前賦課情報.get識別コード());
            賦課エラーEntity.setShikakuShutokuYMD(更正前賦課情報.get資格取得日());
            賦課エラーEntity.setShikakuShutokuJiyu(更正前賦課情報.get資格取得事由());
            賦課エラーEntity.setShikakuSoshitsuYMD(更正前賦課情報.get資格喪失日());
            賦課エラーEntity.setShikakuSoshitsuJiyu(更正前賦課情報.get資格喪失事由());
            賦課エラーEntity.setState(EntityDataState.Added);
            賦課エラーdac.save(賦課エラーEntity);
        }

    }

    private void 月別保険料制御情報セット(SeigyoJoho 月別保険料制御情報, HokenryoDankaiList 保険料段階List) {
        月別保険料制御情報.setHokenryoDankaiList(保険料段階List);
        RDate nowDate = RDate.getNowDate();
        Decimal 基準年金収入額01 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準年金収入1,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        月別保険料制御情報.setKijunNenkinShunyu01(基準年金収入額01);
        Decimal 基準年金収入額02 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準年金収入2,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        月別保険料制御情報.setKijunNenkinShunyu02(基準年金収入額02);
        Decimal 基準年金収入額03 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準年金収入3,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        月別保険料制御情報.setKijunNenkinShunyu03(基準年金収入額03);
        Decimal 基準所得金額01 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額1,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        月別保険料制御情報.setKijunShotokuKingaku01(基準所得金額01);
        Decimal 基準所得金額02 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額2,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        月別保険料制御情報.setKijunShotokuKingaku02(基準所得金額02);
        Decimal 基準所得金額03 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額3,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        月別保険料制御情報.setKijunShotokuKingaku03(基準所得金額03);
        Decimal 基準所得金額04 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額4,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        月別保険料制御情報.setKijunShotokuKingaku04(基準所得金額04);
        Decimal 基準所得金額05 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額5,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        月別保険料制御情報.setKijunShotokuKingaku05(基準所得金額05);
        Decimal 基準所得金額06 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額6,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        月別保険料制御情報.setKijunShotokuKingaku06(基準所得金額06);
        Decimal 基準所得金額07 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額7,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        月別保険料制御情報.setKijunShotokuKingaku07(基準所得金額07);
        Decimal 基準所得金額08 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額8,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        月別保険料制御情報.setKijunShotokuKingaku08(基準所得金額08);
        Decimal 基準所得金額09 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額9,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        月別保険料制御情報.setKijunShotokuKingaku09(基準所得金額09);
        Decimal 基準所得金額10 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額10,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        月別保険料制御情報.setKijunShotokuKingaku10(基準所得金額10);
        Decimal 基準所得金額11 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額11,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        月別保険料制御情報.setKijunShotokuKingaku11(基準所得金額11);
        Decimal 基準所得金額12 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額12,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        月別保険料制御情報.setKijunShotokuKingaku12(基準所得金額12);
        Decimal 基準所得金額13 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額13,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        月別保険料制御情報.setKijunShotokuKingaku13(基準所得金額13);
        Decimal 基準所得金額14 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額14,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        月別保険料制御情報.setKijunShotokuKingaku14(基準所得金額14);
        Decimal 基準所得金額15 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額15,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        月別保険料制御情報.setKijunShotokuKingaku15(基準所得金額15);
        RString 課税層所得段階 = DbBusinessConfig.get(ConfigNameDBB.賦課基準_課税層保険料段階インデックス,
                nowDate, SubGyomuCode.DBB介護賦課);
        月別保険料制御情報.setKazeisouShotokuDankai(課税層所得段階);
        RString 未申告段階使用 = DbBusinessConfig.get(ConfigNameDBB.賦課基準_未申告保険料段階使用,
                nowDate, SubGyomuCode.DBB介護賦課);
        if (RSTRING_1.equals(未申告段階使用)) {
            月別保険料制御情報.setUsesMishinkokuDankai(Boolean.TRUE);
        } else if (RSTRING_0.equals(未申告段階使用)) {
            月別保険料制御情報.setUsesMishinkokuDankai(Boolean.FALSE);
        }
        RString 未申告段階インデックス = DbBusinessConfig.get(ConfigNameDBB.賦課基準_未申告保険料段階インデックス,
                nowDate, SubGyomuCode.DBB介護賦課);
        月別保険料制御情報.setMishinkokuDankai(未申告段階インデックス);
        RString 未申告課税区分 = DbBusinessConfig.get(ConfigNameDBB.賦課基準_未申告課税区分,
                nowDate, SubGyomuCode.DBB介護賦課);
        月別保険料制御情報.setMishinkokuKazeiKubun(KazeiKubun.toValue(未申告課税区分));
        RString 所得調査中段階使用 = DbBusinessConfig.get(ConfigNameDBB.賦課基準_所得調査中保険料段階使用,
                nowDate, SubGyomuCode.DBB介護賦課);
        if (RSTRING_1.equals(所得調査中段階使用)) {
            月別保険料制御情報.setUsesShotokuChosachuDankai(Boolean.TRUE);
        } else if (RSTRING_0.equals(所得調査中段階使用)) {
            月別保険料制御情報.setUsesShotokuChosachuDankai(Boolean.FALSE);
        }
        RString 所得調査中段階インデックス = DbBusinessConfig.get(ConfigNameDBB.賦課基準_所得調査中保険料段階インデックス,
                nowDate, SubGyomuCode.DBB介護賦課);
        月別保険料制御情報.setShotokuChosachuDankai(所得調査中段階インデックス);
        RString 所得調査中課税区分 = DbBusinessConfig.get(ConfigNameDBB.賦課基準_所得調査中課税区分,
                nowDate, SubGyomuCode.DBB介護賦課);
        月別保険料制御情報.setShotokuChosachuKazeiKubun(KazeiKubun.toValue(所得調査中課税区分));
        RString 課税取消段階使用 = DbBusinessConfig.get(ConfigNameDBB.賦課基準_課税取消保険料段階使用,
                nowDate, SubGyomuCode.DBB介護賦課);
        if (RSTRING_1.equals(課税取消段階使用)) {
            月別保険料制御情報.setUsesKazeiTorikeshiDankai(Boolean.TRUE);
        } else if (RSTRING_0.equals(課税取消段階使用)) {
            月別保険料制御情報.setUsesKazeiTorikeshiDankai(Boolean.FALSE);
        }
        RString 課税取消段階インデックス = DbBusinessConfig.get(ConfigNameDBB.賦課基準_課税取消保険料段階インデックス,
                nowDate, SubGyomuCode.DBB介護賦課);
        月別保険料制御情報.setKazeiTorikeshiDankai(課税取消段階インデックス);
        RString 課税取消課税区分 = DbBusinessConfig.get(ConfigNameDBB.賦課基準_課税取消課税区分,
                nowDate, SubGyomuCode.DBB介護賦課);
        月別保険料制御情報.setKazeiTorikeshiKazeiKubun(KazeiKubun.toValue(課税取消課税区分));
    }

    private RString get保険料段階(ShikakuFukaResultEntity 資格取得Entity, ShikakuShutokuTempEntity 資格情報,
            FlexibleYear 賦課年度, SeigyoJoho 月別保険料制御情報) {
        RString 賦課方法 = DbBusinessConfig.get(ConfigNameDBB.普通徴収_仮算定異動新規賦課方法,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
        RString 保険料段階 = null;
        if (RSTRING_11.equals(賦課方法)) {
            List<SetaiShotokuEntity> 世帯員所得情報List = 資格取得Entity.get世帯員所得情報List();
            for (SetaiShotokuEntity 世帯員所得情報 : 世帯員所得情報List) {
                if (RSTRING_1.equals(世帯員所得情報.getHonninKubun()) && 世帯員所得情報.getTorokuGyomu() == null) {
                    保険料段階 = DbBusinessConfig.get(ConfigNameDBB.普通徴収_仮算定新規資格適用段階,
                            RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                    break;
                }
            }
            if (保険料段階 == null) {
                TsukibetsuHokenryoDankai 月別保険料段階 = get月別保険料段階(資格取得Entity, 資格情報, 世帯員所得情報List,
                        賦課年度, 月別保険料制御情報);
                保険料段階 = 月別保険料段階.get保険料段階12月().getHokenryoDankai();
            }
        } else if (RSTRING_12.equals(賦課方法)) {
            保険料段階 = DbBusinessConfig.get(ConfigNameDBB.普通徴収_仮算定新規資格適用段階,
                    RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
        }

        return 保険料段階;
    }

    private HihokenshaDaicho get資格情報(ShikakuShutokuTempEntity 資格情報) {
        DbT1001HihokenshaDaichoEntity dbt1001Entity = new DbT1001HihokenshaDaichoEntity();
        HihokenshaDaicho 資格の情報 = new HihokenshaDaicho(dbt1001Entity);
        HihokenshaDaichoBuilder builder = 資格の情報.createBuilderForEdit();
        builder.set被保険者番号(資格情報.get被保険者番号());
        builder.set異動日(資格情報.get異動日());
        builder.set枝番(資格情報.get枝番());
        builder.set異動事由コード(資格情報.get異動事由コード());
        builder.set市町村コード(資格情報.get市町村コード());
        builder.set識別コード(資格情報.get識別コード());
        builder.set資格取得事由コード(資格情報.get資格取得事由コード());
        builder.set資格取得年月日(資格情報.get資格取得年月日());
        builder.set資格取得届出年月日(資格情報.get資格取得届出年月日());
        builder.set第1号資格取得年月日(資格情報.get第1号資格取得年月日());
        builder.set被保険者区分コード(資格情報.get被保険者区分コード());
        builder.set資格喪失事由コード(資格情報.get資格喪失事由コード());
        builder.set資格喪失年月日(資格情報.get資格喪失年月日());
        builder.set資格喪失届出年月日(資格情報.get資格喪失届出年月日());
        builder.set資格変更事由コード(資格情報.get資格変更事由コード());
        builder.set資格変更年月日(資格情報.get資格変更年月日());
        builder.set資格変更届出年月日(資格情報.get資格変更届出年月日());
        builder.set住所地特例適用事由コード(資格情報.get住所地特例適用事由コード());
        builder.set適用年月日(資格情報.get適用年月日());
        builder.set適用届出年月日(資格情報.get適用届出年月日());
        builder.set住所地特例解除事由コード(資格情報.get住所地特例解除事由コード());
        builder.set解除年月日(資格情報.get解除年月日());
        builder.set解除届出年月日(資格情報.get解除届出年月日());
        builder.set住所地特例フラグ(資格情報.get住所地特例フラグ());
        builder.set広域内住所地特例フラグ(資格情報.get広域内住所地特例フラグ());
        builder.set広住特措置元市町村コード(資格情報.get広住特措置元市町村コード());
        builder.set旧市町村コード(資格情報.get旧市町村コード());
        builder.set論理削除フラグ(資格情報.is論理削除フラグ());
        return builder.build();

    }

    /**
     * get生保の情報のリスト
     *
     * @param 特徴仮算定Entity TokutyouKariSannteiRelateEntity
     * @return 生保の情報のリスト
     */
    private List<SeikatsuHogoJukyusha> get生保の情報のリスト_8月特徴開始(TokutyouKariSannteiRelateEntity 特徴仮算定Entity) {

        List<SeikatsuHogoJukyushaRelateEntity> 生保の情報List = 特徴仮算定Entity.get生保の情報List();
        if (生保の情報List == null || 生保の情報List.isEmpty()) {
            return new ArrayList<>();
        }
        List<SeikatsuHogoJukyusha> 生保の情報のリスト = new ArrayList<>();
        for (SeikatsuHogoJukyushaRelateEntity seikatsuEntity : 生保の情報List) {
            SeikatsuHogoJukyusha 生保の情報 = new SeikatsuHogoJukyusha(seikatsuEntity);
            生保の情報のリスト.add(生保の情報);
        }
        return 生保の情報のリスト;

    }

    /**
     * get老齢の情報のリスト
     *
     * @param 特徴仮算定Entity TokutyouKariSannteiRelateEntity
     * @return 老齢の情報のリスト
     */
    private List<RoreiFukushiNenkinJukyusha> get老齢の情報のリスト_8月特徴開始(TokutyouKariSannteiRelateEntity 特徴仮算定Entity) {

        List<DbT7006RoreiFukushiNenkinJukyushaEntity> 老齢の情報List = 特徴仮算定Entity.get老齢の情報List();
        if (老齢の情報List == null || 老齢の情報List.isEmpty()) {
            return new ArrayList<>();
        }
        List<RoreiFukushiNenkinJukyusha> 老齢の情報のリスト = new ArrayList<>();
        for (DbT7006RoreiFukushiNenkinJukyushaEntity dbT7006Entity : 老齢の情報List) {
            RoreiFukushiNenkinJukyusha 老齢の情報 = new RoreiFukushiNenkinJukyusha(dbT7006Entity);
            老齢の情報のリスト.add(老齢の情報);
        }
        return 老齢の情報のリスト;

    }

    private void set生活保護(FukaJohoBuilder builder, List<SeikatsuHogoJukyusha> 生保情報のリスト,
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
            if (受給開始日.isBeforeOrEquals(本年度終了日) && 本年度開始日.isBeforeOrEquals(受給開始日)) {
                生活保護の情報のリスト.add(entity);
            } else if (受給廃止日.isBeforeOrEquals(本年度終了日) && 本年度開始日.isBeforeOrEquals(受給廃止日)) {
                生活保護の情報のリスト.add(entity);
            } else if (受給開始日.isBeforeOrEquals(本年度開始日) && 本年度終了日.isBeforeOrEquals(受給廃止日)) {
                生活保護の情報のリスト.add(entity);
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

    private RString get生活保護扶助種類(List<SeikatsuHogoFujoShurui> 扶助種類リスト) {
        List<RString> 扶助種類 = new ArrayList<>();
        if (扶助種類リスト.isEmpty()) {
            return RString.EMPTY;
        }
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

    private void set老齢福祉年金(FukaJohoBuilder builder, List<RoreiFukushiNenkinJukyusha> 老福の情報リスト,
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

    private TokuchoKarisanteiKiwariOutput get特徴仮算定期割(FlexibleYear 調定年度, Decimal 保険料率) {
        TokuchoKarisanteiKiwari 保険系業務共通 = new TokuchoKarisanteiKiwari();
        TokuchoKarisanteiKiwariInput inputEntity = new TokuchoKarisanteiKiwariInput();
        inputEntity.set前年度賦課額(保険料率);
        inputEntity.set現在特徴期(NUM_3);
        inputEntity.set前年度最終期別額(Decimal.ZERO);
        RString 特徴定期数 = DbBusinessConfig.get(ConfigNameDBB.特徴期情報_設定納期数,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
        RString 特徴仮算定期数 = DbBusinessConfig.get(ConfigNameDBB.特徴期情報_仮算定期数,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
        RString 特徴仮算定計算区分 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_依頼金額計算方法_8月開始,
                new RDate(調定年度.minusYear(NUM_1).toString()), SubGyomuCode.DBB介護賦課);
        RString 端数区分 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_期別端数,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
        GyomuConfigJohoClass 業務コンフィグ情報 = new GyomuConfigJohoClass();
        業務コンフィグ情報.set特徴定期数(Integer.valueOf(特徴定期数.toString()));
        業務コンフィグ情報.set特徴仮算定期数(Integer.valueOf(特徴仮算定期数.toString()));
        if (RSTRING_1.equals(特徴仮算定計算区分)) {
            業務コンフィグ情報.set特徴仮算定計算区分(NUM_1);
        } else if (RSTRING_3.equals(特徴仮算定計算区分)) {
            業務コンフィグ情報.set特徴仮算定計算区分(NUM_2);
        }
        if (HasuChoseiTani._1.getコード().equals(端数区分)) {
            業務コンフィグ情報.set端数区分特徴仮算定期別額(NUM_1);
        } else if (HasuChoseiTani._10.getコード().equals(端数区分)) {
            業務コンフィグ情報.set端数区分特徴仮算定期別額(NUM_2);
        } else if (HasuChoseiTani._100.getコード().equals(端数区分)) {
            業務コンフィグ情報.set端数区分特徴仮算定期別額(NUM_3);
        } else if (HasuChoseiTani._1000.getコード().equals(端数区分)) {
            業務コンフィグ情報.set端数区分特徴仮算定期別額(NUM_4);
        }
        inputEntity.set業務コンフィグ情報(業務コンフィグ情報);
        return 保険系業務共通.getTokuchoKarisanteiKibetsuGaku(inputEntity);
    }

    /**
     * 異動賦課計算
     *
     * @param 調定年度 FlexibleYear
     * @param 基準年月日 FlexibleDate
     * @param 抽出開始日時 RDateTime
     * @param 抽出終了日時 RDateTime
     */
    public void 異動賦課計算(FlexibleYear 調定年度, RDateTime 基準年月日, RDateTime 抽出開始日時, RDateTime 抽出終了日時) {
        RString 最大年度内連番;
        DbT7022ShoriDateKanriEntity dbT7022Entity = new DbT7022ShoriDateKanriEntity();
        DbT7022ShoriDateKanriDac 処理日付管理Dac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
        DbT7022ShoriDateKanriEntity entity = 処理日付管理Dac.select最大年度内連番BY調定年度(調定年度, 処理枝番);
        if (entity != null) {
            最大年度内連番 = new RString(String.valueOf(Integer.parseInt(entity.getNendoNaiRenban().toString()) + 1))
                    .padZeroToLeft(NUM_4);
        } else {
            最大年度内連番 = 処理枝番;
        }
        dbT7022Entity.setSubGyomuCode(SubGyomuCode.DBB介護賦課);
        Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
        dbT7022Entity.setShichosonCode(地方公共団体.getLasdecCode_());
        dbT7022Entity.setShoriName(ShoriName.仮算定異動賦課.get名称());
        dbT7022Entity.setShoriEdaban(処理枝番);
        dbT7022Entity.setNendo(調定年度);
        dbT7022Entity.setNendoNaiRenban(最大年度内連番);
        dbT7022Entity.setKijunYMD(new FlexibleDate(基準年月日.getDate().toString()));
        dbT7022Entity.setKijunTimestamp(new YMDHMS(基準年月日));
        dbT7022Entity.setTaishoKaishiTimestamp(new YMDHMS(抽出開始日時));
        dbT7022Entity.setTaishoShuryoTimestamp(new YMDHMS(抽出終了日時));
        dbT7022Entity.setState(EntityDataState.Added);
        処理日付管理Dac.save(dbT7022Entity);
    }

    /**
     * 八月特徴開始
     *
     * @param 調定年度 FlexibleYear
     * @param 基準日時 YMDHMS
     */
    public void 八月特徴開始(FlexibleYear 調定年度, YMDHMS 基準日時) {
        DbT7022ShoriDateKanriDac 処理日付管理Dac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
        DbT7022ShoriDateKanriEntity entity = 処理日付管理Dac.select処理日付管理マスタ_八月特徴開始情報抽出(調定年度);
        if (entity != null) {
            entity.setKijunTimestamp(基準日時);
            entity.setState(EntityDataState.Modified);
            処理日付管理Dac.save(entity);
        }
    }

    private DbT2002FukaJohoTempTableEntity set賦課情報一時テーブルEntity(FukaJoho 賦課情報) {
        DbT2002FukaJohoTempTableEntity 賦課情報Entity = new DbT2002FukaJohoTempTableEntity();
        賦課情報Entity.setChoteiNendo(賦課情報.get調定年度());
        賦課情報Entity.setFukaNendo(賦課情報.get賦課年度());
        賦課情報Entity.setTsuchishoNo(賦課情報.get通知書番号());
        賦課情報Entity.setRirekiNo(賦課情報.get履歴番号());
        賦課情報Entity.setHihokenshaNo(賦課情報.get被保険者番号());
        賦課情報Entity.setShikibetsuCode(賦課情報.get識別コード());
        賦課情報Entity.setSetaiCode(賦課情報.get世帯コード());
        賦課情報Entity.setSetaiInsu(賦課情報.get世帯員数());
        賦課情報Entity.setShikakuShutokuYMD(賦課情報.get資格取得日());
        賦課情報Entity.setShikakuShutokuJiyu(賦課情報.get資格取得事由());
        賦課情報Entity.setShikakuSoshitsuYMD(賦課情報.get資格喪失日());
        賦課情報Entity.setShikakuSoshitsuJiyu(賦課情報.get資格喪失事由());
        賦課情報Entity.setSeihofujoShurui(賦課情報.get生活保護扶助種類());
        賦課情報Entity.setSeihoKaishiYMD(賦課情報.get生保開始日());
        賦課情報Entity.setSeihoHaishiYMD(賦課情報.get生保廃止日());
        賦課情報Entity.setRonenKaishiYMD(賦課情報.get老年開始日());
        賦課情報Entity.setRonenHaishiYMD(賦課情報.get老年廃止日());
        賦課情報Entity.setFukaYMD(賦課情報.get賦課期日());
        賦課情報Entity.setKazeiKubun(賦課情報.get課税区分());
        賦課情報Entity.setSetaikazeiKubun(賦課情報.get世帯課税区分());
        賦課情報Entity.setGokeiShotokuGaku(賦課情報.get合計所得金額());
        賦課情報Entity.setNenkinShunyuGaku(賦課情報.get公的年金収入額());
        賦課情報Entity.setHokenryoDankai(賦課情報.get保険料段階());
        賦課情報Entity.setHokenryoDankai1(賦課情報.get保険料算定段階1());
        賦課情報Entity.setNengakuHokenryo1(賦課情報.get算定年額保険料1());
        賦課情報Entity.setTsukiwariStartYM1(賦課情報.get月割開始年月1());
        賦課情報Entity.setTsukiwariEndYM1(賦課情報.get月割終了年月1());
        賦課情報Entity.setHokenryoDankai2(賦課情報.get保険料算定段階2());
        賦課情報Entity.setNengakuHokenryo2(賦課情報.get算定年額保険料2());
        賦課情報Entity.setTsukiwariStartYM2(賦課情報.get月割開始年月2());
        賦課情報Entity.setTsukiwariEndYM2(賦課情報.get月割終了年月2());
        賦課情報Entity.setChoteiNichiji(賦課情報.get調定日時());
        賦課情報Entity.setChoteiJiyu1(賦課情報.get調定事由1());
        賦課情報Entity.setChoteiJiyu2(賦課情報.get調定事由1());
        賦課情報Entity.setChoteiJiyu3(賦課情報.get調定事由3());
        賦課情報Entity.setChoteiJiyu4(賦課情報.get調定事由4());
        賦課情報Entity.setKoseiM(賦課情報.get更正月());
        賦課情報Entity.setGemmenMaeHokenryo(賦課情報.get減免前介護保険料_年額());
        賦課情報Entity.setGemmenGaku(賦課情報.get減免額());
        賦課情報Entity.setKakuteiHokenryo(賦課情報.get確定介護保険料_年額());
        賦課情報Entity.setHokenryoDankaiKarisanntei(賦課情報.get保険料段階_仮算定時());
        賦課情報Entity.setChoshuHohoRirekiNo(賦課情報.get徴収方法履歴番号());
        賦課情報Entity.setIdoKijunNichiji(賦課情報.get異動基準日時());
        賦課情報Entity.setKozaKubun(賦課情報.get口座区分());
        賦課情報Entity.setKyokaisoKubun(賦課情報.get境界層区分());
        賦課情報Entity.setShokkenKubun(賦課情報.get職権区分());
        賦課情報Entity.setFukaShichosonCode(賦課情報.get賦課市町村コード());
        賦課情報Entity.setTkSaishutsuKampuGaku(賦課情報.get特徴歳出還付額());
        賦課情報Entity.setFuSaishutsuKampuGaku(賦課情報.get普徴歳出還付額());
        賦課情報Entity.setTkKibetsuGaku01(賦課情報.get特徴期別金額01());
        賦課情報Entity.setTkKibetsuGaku02(賦課情報.get特徴期別金額02());
        賦課情報Entity.setTkKibetsuGaku03(賦課情報.get特徴期別金額03());
        賦課情報Entity.setTkKibetsuGaku04(賦課情報.get特徴期別金額04());
        賦課情報Entity.setTkKibetsuGaku05(賦課情報.get特徴期別金額05());
        賦課情報Entity.setTkKibetsuGaku06(賦課情報.get特徴期別金額06());
        賦課情報Entity.setFuKibetsuGaku01(賦課情報.get普徴期別金額01());
        賦課情報Entity.setFuKibetsuGaku02(賦課情報.get普徴期別金額02());
        賦課情報Entity.setFuKibetsuGaku03(賦課情報.get普徴期別金額03());
        賦課情報Entity.setFuKibetsuGaku04(賦課情報.get普徴期別金額04());
        賦課情報Entity.setFuKibetsuGaku05(賦課情報.get普徴期別金額05());
        賦課情報Entity.setFuKibetsuGaku06(賦課情報.get普徴期別金額06());
        賦課情報Entity.setFuKibetsuGaku07(賦課情報.get普徴期別金額07());
        賦課情報Entity.setFuKibetsuGaku08(賦課情報.get普徴期別金額08());
        賦課情報Entity.setFuKibetsuGaku09(賦課情報.get普徴期別金額09());
        賦課情報Entity.setFuKibetsuGaku10(賦課情報.get普徴期別金額10());
        賦課情報Entity.setFuKibetsuGaku11(賦課情報.get普徴期別金額11());
        賦課情報Entity.setFuKibetsuGaku12(賦課情報.get普徴期別金額12());
        賦課情報Entity.setFuKibetsuGaku13(賦課情報.get普徴期別金額13());
        賦課情報Entity.setFuKibetsuGaku14(賦課情報.get普徴期別金額14());
        return 賦課情報Entity;

    }

    private DbT2002FukaJohoTempTableEntity set金額ToZero(DbT2002FukaJohoTempTableEntity 賦課情報Entity) {
        賦課情報Entity.setTkKibetsuGaku01(Decimal.ZERO);
        賦課情報Entity.setTkKibetsuGaku02(Decimal.ZERO);
        賦課情報Entity.setTkKibetsuGaku04(Decimal.ZERO);
        賦課情報Entity.setTkKibetsuGaku05(Decimal.ZERO);
        賦課情報Entity.setTkKibetsuGaku06(Decimal.ZERO);
        賦課情報Entity.setFuKibetsuGaku01(Decimal.ZERO);
        賦課情報Entity.setFuKibetsuGaku02(Decimal.ZERO);
        賦課情報Entity.setFuKibetsuGaku03(Decimal.ZERO);
        賦課情報Entity.setFuKibetsuGaku04(Decimal.ZERO);
        賦課情報Entity.setFuKibetsuGaku05(Decimal.ZERO);
        賦課情報Entity.setFuKibetsuGaku06(Decimal.ZERO);
        賦課情報Entity.setFuKibetsuGaku07(Decimal.ZERO);
        賦課情報Entity.setFuKibetsuGaku08(Decimal.ZERO);
        賦課情報Entity.setFuKibetsuGaku09(Decimal.ZERO);
        賦課情報Entity.setFuKibetsuGaku10(Decimal.ZERO);
        賦課情報Entity.setFuKibetsuGaku11(Decimal.ZERO);
        賦課情報Entity.setFuKibetsuGaku12(Decimal.ZERO);
        賦課情報Entity.setFuKibetsuGaku13(Decimal.ZERO);
        賦課情報Entity.setFuKibetsuGaku14(Decimal.ZERO);
        return 賦課情報Entity;
    }
}
