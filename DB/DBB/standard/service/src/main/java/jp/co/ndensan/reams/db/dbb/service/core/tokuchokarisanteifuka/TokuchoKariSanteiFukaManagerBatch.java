/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.tokuchokarisanteifuka;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJoho;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJohoBuilder;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.HokenryoDankaiHantei;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.core.TsukibetsuHokenryoDankai;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.FukaKonkyo;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.HokenryoDankaiHanteiParameter;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.SeigyoJoho;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.HokenryoDankaiList;
import jp.co.ndensan.reams.db.dbb.business.core.tokuchokarisanteifukamanager.FukaJohoLokukatu;
import jp.co.ndensan.reams.db.dbb.business.core.tokuchokarisanteifukamanager.FukaJohokeizoku;
import jp.co.ndensan.reams.db.dbb.business.core.tokuchokarisanteifukamanager.SikakuSaisinnsiki;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukarisanteikekkaIchiran.TokubetsuChoshuKarisanteiKekkaIchiranProperty;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.ErrorCode;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.HasuChoseiTani;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.KozaKubun;
import jp.co.ndensan.reams.db.dbb.definition.core.tokucho.TokuchoNengakuKijunNendo6Gatsu;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2010FukaErrorListEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajoho.fukajoho.FukaJohoRelateEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchokarisanteifukamanager.FukaJohoLokukatuRelateEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchokarisanteifukamanager.FukaJohoTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchokarisanteifukamanager.FukaJohokeizokuRelateEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchokarisanteifukamanager.SikakuSaisinnsikiRelateEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchokarisanteifukamanager.TokuchoKariKeisangoFukaEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchokarisanteifukamanager.TokuchoKarisanteiKekkaIchiranEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchokarisanteifukamanager.TokuchoKarisanteiKekkaIchiranTeisiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchokarisanteifukamanager.TokutyoukariSannteiTyuushutuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchokarisanteifukamanager.TokutyoukariSannteiTyuushutuResultEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchokarisanteifukamanager.ZennNenndoFukaTempEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2010FukaErrorListDac;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokuchokarisanteifuka.ITokuchoKariSanteiFukaMapper;
import jp.co.ndensan.reams.db.dbb.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbb.service.core.fuka.fukakeisan.FukaKeisan;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.HokenryoDankaiSettings;
import jp.co.ndensan.reams.db.dbb.service.report.tokubetsuchoshukarisanteikekkaichiran.TokubetsuChoshuKarisanteiKekkaIchiranPrintService;
import jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbx.definition.core.choteijiyu.ChoteiJiyuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.KazeiKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.RoreiFukushiNenkinJukyusha;
import jp.co.ndensan.reams.db.dbz.business.core.hihokensha.seikatsuhogojukyusha.SeikatsuHogoJukyusha;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7006RoreiFukushiNenkinJukyushaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.hihokensha.seikatsuhogojukyusha.SeikatsuHogoJukyushaRelateEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7065ChohyoSeigyoKyotsuDac;
import jp.co.ndensan.reams.ur.urd.business.core.tokuchokarisanteikiwari.GyomuConfigJohoClass;
import jp.co.ndensan.reams.ur.urd.business.core.tokuchokarisanteikiwari.TokuchoKarisanteiKiwari;
import jp.co.ndensan.reams.ur.urd.business.core.tokuchokarisanteikiwari.TokuchoKarisanteiKiwariInput;
import jp.co.ndensan.reams.ur.urd.business.core.tokuchokarisanteikiwari.TokuchoKarisanteiKiwariOutput;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.definition.core.reportoutputorder.SortOrder;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * ビジネス設計_DBBBZ33001_1_特徴仮算定賦課（バッチ）
 *
 * @reamsid_L DBB-0700-020 xuhao
 */
public class TokuchoKariSanteiFukaManagerBatch {

    private final MapperProvider mProvider;
    private final DbT2010FukaErrorListDac 賦課エラー一覧Dac;
    private final DbT7022ShoriDateKanriDac 処理日付管理Dac;

    private static final RString キー_調定年度 = new RString("choteiNendo");
    private static final RString キー_調定年度_1 = new RString("choteiNendo_1");
    private static final RString キー_調定日時 = new RString("choteiNichiji");
    private static final RString キー_賦課年度 = new RString("fukaNendo");
    private static final RString キー_出力順 = new RString("出力順");
    private static final int 整数_0 = 0;
    private static final int 整数_1 = 1;
    private static final int 整数_2 = 2;
    private static final int 整数_3 = 3;
    private static final int 整数_4 = 4;
    private static final int 整数_5 = 5;
    private static final int 整数_14 = 14;
    private static final int 整数_16 = 16;
    private static final RString RSTRING_1 = new RString("1");
    private static final RString RSTRING_3 = new RString("3");
    private static final RString 内部帳票ID = new RString("DBB400001_FukaErrorIchitan");
    private static final RString バッチID = new RString("DBBBT33001");
    private static final RString 特別徴収_厚生労働省 = new RString("1");
    private static final RString 特別徴収_地共済 = new RString("2");
    private static final RString 文字列_04 = new RString("04");
    private static final RString 文字列_01 = new RString("01");
    private static final RString 文字列_03 = new RString("03");
    private static final RString 文字列_31 = new RString("31");
    private static final RString 文字列_0000 = new RString("0000");
    private static final ReportId 特別徴収仮算定結果一覧表_帳票分類ID = new ReportId("DBB200002_TokubetsuChoshuKarisanteiKekkaIchiran");
    private static final ReportId 帳票ID = new ReportId("DBB200002_TokubetsuChoshuKarisanteiKekkaIchiran");
    private static final RString FORMAT_LEFT = new RString("【");
    private static final RString FORMAT_RIGHT = new RString("】");
    private static final RString FORMAT_MIN = new RString("<");
    private static final RString 定数_賦課年度 = new RString("賦課年度");
    private static final RString 定数_調定年度 = new RString("調定年度");
    private static final RString 定数_出力順 = new RString("出力順");
    private static final RString 定数_出力条件 = new RString("出力条件");
    private static final RString CSV出力有無 = new RString("有り");
    private static final RString CSVファイル名 = new RString("TokubetsuChoshuKarisanteiKekkaIchiranData.csv");
    private static final RString 帳票名 = new RString("特別徴収仮算定結果一覧表");
    private static final RString 年度内番号 = new RString("0001");
    private static final RString 保険料段階を使用する = new RString("1");
    private static final RString 年度 = new RString("年度");

    /**
     * コンストラクタです。
     */
    TokuchoKariSanteiFukaManagerBatch() {
        mProvider = InstanceProvider.create(MapperProvider.class);
        賦課エラー一覧Dac = InstanceProvider.create(DbT2010FukaErrorListDac.class);
        処理日付管理Dac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mProvider mProvider
     */
    TokuchoKariSanteiFukaManagerBatch(MapperProvider mProvider, DbT2010FukaErrorListDac 賦課エラー一覧Dac,
            DbT7065ChohyoSeigyoKyotsuDac 帳票制御共通Dac,
            DbT7022ShoriDateKanriDac 処理日付管理Dac) {
        this.mProvider = mProvider;
        this.賦課エラー一覧Dac = 賦課エラー一覧Dac;
        this.処理日付管理Dac = 処理日付管理Dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link TokuchoKariSanteiFukaManagerBatch}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link TokuchoKariSanteiFukaManagerBatch}のインスタンス
     */
    public static TokuchoKariSanteiFukaManagerBatch createInstance() {
        return InstanceProvider.create(TokuchoKariSanteiFukaManagerBatch.class);
    }

    /**
     * 特徴仮算定対象抽出
     *
     * @param 調定年度 FlexibleYear
     */
    public void selectKarisateiTaisho(FlexibleYear 調定年度) {
        Map<String, Object> parameter = new HashMap<>();
        parameter.put(キー_調定年度.toString(), 調定年度);
        parameter.put(キー_調定年度_1.toString(), 調定年度.minusYear(整数_1));
        ITokuchoKariSanteiFukaMapper mapper = mProvider.create(ITokuchoKariSanteiFukaMapper.class);
        mapper.creat特徴仮算定抽出Temp();
        List<TokutyoukariSannteiTyuushutuResultEntity> 特徴継続者EntityList = mapper.select特徴継続者(parameter);
        for (TokutyoukariSannteiTyuushutuResultEntity 徴収方法Entity : 特徴継続者EntityList) {
            TokutyoukariSannteiTyuushutuEntity entity = new TokutyoukariSannteiTyuushutuEntity();
            entity.setFukaNendo(徴収方法Entity.getFukaNendo());
            entity.setHihokenshaNo(徴収方法Entity.getHihokenshaNo());
            entity.setRirekiNo(徴収方法Entity.getRirekiNo());
            entity.setChoshuHoho4gatsu(徴収方法Entity.getChoshuHoho4gatsu());
            entity.setChoshuHoho5gatsu(徴収方法Entity.getChoshuHoho5gatsu());
            entity.setChoshuHoho6gatsu(徴収方法Entity.getChoshuHoho6gatsu());
            entity.setChoshuHoho7gatsu(徴収方法Entity.getChoshuHoho7gatsu());
            entity.setChoshuHoho8gatsu(徴収方法Entity.getChoshuHoho8gatsu());
            entity.setChoshuHoho9gatsu(徴収方法Entity.getChoshuHoho9gatsu());
            entity.setChoshuHoho10gatsu(徴収方法Entity.getChoshuHoho10gatsu());
            entity.setChoshuHoho11gatsu(徴収方法Entity.getChoshuHoho11gatsu());
            entity.setChoshuHoho12gatsu(徴収方法Entity.getChoshuHoho12gatsu());
            entity.setChoshuHoho1gatsu(徴収方法Entity.getChoshuHoho1gatsu());
            entity.setChoshuHoho2gatsu(徴収方法Entity.getChoshuHoho2gatsu());
            entity.setChoshuHoho3gatsu(徴収方法Entity.getChoshuHoho3gatsu());
            entity.setChoshuHohoYoku4gatsu(徴収方法Entity.getChoshuHohoYoku4gatsu());
            entity.setChoshuHohoYoku5gatsu(徴収方法Entity.getChoshuHohoYoku5gatsu());
            entity.setChoshuHohoYoku6gatsu(徴収方法Entity.getChoshuHohoYoku6gatsu());
            entity.setChoshuHohoYoku7gatsu(徴収方法Entity.getChoshuHohoYoku7gatsu());
            entity.setChoshuHohoYoku8gatsu(徴収方法Entity.getChoshuHohoYoku8gatsu());
            entity.setChoshuHohoYoku9gatsu(徴収方法Entity.getChoshuHohoYoku9gatsu());
            entity.setKariNenkinNo(徴収方法Entity.getKariNenkinNo());
            entity.setKariNenkinCode(徴収方法Entity.getKariNenkinCode());
            entity.setKariHosokuM(徴収方法Entity.getKariHosokuM());
            entity.setHonNenkinNo(徴収方法Entity.getHonNenkinNo());
            entity.setHonNenkinCode(徴収方法Entity.getHonNenkinCode());
            entity.setHonHosokuM(徴収方法Entity.getHonHosokuM());
            entity.setYokunendoKariNenkinNo(徴収方法Entity.getYokunendoKariNenkinNo());
            entity.setYokunendoKariNenkinCode(徴収方法Entity.getYokunendoKariNenkinCode());
            entity.setYokunendoKariHosokuM(徴収方法Entity.getYokunendoKariHosokuM());
            entity.setIraiSohuzumiFlag(徴収方法Entity.isIraiSohuzumiFlag());
            entity.setTsuikaIraiSohuzumiFlag(徴収方法Entity.isTsuikaIraiSohuzumiFlag());
            entity.setTokuchoTeishiNichiji(徴収方法Entity.getTokuchoTeishiNichiji());
            entity.setTokuchoTeishiJiyuCode(徴収方法Entity.getTokuchoTeishiJiyuCode());
            entity.setTsuchishoNo(徴収方法Entity.getTsuchishoNo());
            entity.setChoteigaku(徴収方法Entity.getChoteigaku());
            if (徴収方法Entity.getHokenryoDankai2() != null) {
                entity.setHokenryoDankai(徴収方法Entity.getHokenryoDankai2());
            } else {
                entity.setHokenryoDankai(徴収方法Entity.getHokenryoDankai1());
            }
            entity.setSeihoKaishiYMD(徴収方法Entity.getSeihoKaishiYMD());
            entity.setSeihoHaishiYMD(徴収方法Entity.getSeihoHaishiYMD());
            entity.setRonenKaishiYMD(徴収方法Entity.getRonenKaishiYMD());
            entity.setRonenHaishiYMD(徴収方法Entity.getRonenHaishiYMD());
            entity.setSetaikazeiKubun(徴収方法Entity.getSetaikazeiKubun());
            entity.setKazeiKubun(徴収方法Entity.getKazeiKubun());
            entity.setGokeiShotokuGaku(徴収方法Entity.getGokeiShotokuGaku());
            entity.setNenkinShunyuGaku(徴収方法Entity.getNenkinShunyuGaku());
            mapper.inset特徴仮算定抽出Temp(entity);
        }
        List<TokutyoukariSannteiTyuushutuResultEntity> 特徴6月開始者EntityList = mapper.select特徴6月開始者(parameter);
        for (TokutyoukariSannteiTyuushutuResultEntity 徴収方法Entity : 特徴6月開始者EntityList) {
            TokutyoukariSannteiTyuushutuEntity entity = new TokutyoukariSannteiTyuushutuEntity();
            entity.setFukaNendo(徴収方法Entity.getFukaNendo());
            entity.setHihokenshaNo(徴収方法Entity.getHihokenshaNo());
            entity.setRirekiNo(徴収方法Entity.getRirekiNo());
            entity.setChoshuHoho4gatsu(徴収方法Entity.getChoshuHoho4gatsu());
            entity.setChoshuHoho5gatsu(徴収方法Entity.getChoshuHoho5gatsu());
            entity.setChoshuHoho6gatsu(徴収方法Entity.getChoshuHoho6gatsu());
            entity.setChoshuHoho7gatsu(徴収方法Entity.getChoshuHoho7gatsu());
            entity.setChoshuHoho8gatsu(徴収方法Entity.getChoshuHoho8gatsu());
            entity.setChoshuHoho9gatsu(徴収方法Entity.getChoshuHoho9gatsu());
            entity.setChoshuHoho10gatsu(徴収方法Entity.getChoshuHoho10gatsu());
            entity.setChoshuHoho11gatsu(徴収方法Entity.getChoshuHoho11gatsu());
            entity.setChoshuHoho12gatsu(徴収方法Entity.getChoshuHoho12gatsu());
            entity.setChoshuHoho1gatsu(徴収方法Entity.getChoshuHoho1gatsu());
            entity.setChoshuHoho2gatsu(徴収方法Entity.getChoshuHoho2gatsu());
            entity.setChoshuHoho3gatsu(徴収方法Entity.getChoshuHoho3gatsu());
            entity.setChoshuHohoYoku4gatsu(徴収方法Entity.getChoshuHohoYoku4gatsu());
            entity.setChoshuHohoYoku5gatsu(徴収方法Entity.getChoshuHohoYoku5gatsu());
            entity.setChoshuHohoYoku6gatsu(徴収方法Entity.getChoshuHohoYoku6gatsu());
            entity.setChoshuHohoYoku7gatsu(徴収方法Entity.getChoshuHohoYoku7gatsu());
            entity.setChoshuHohoYoku8gatsu(徴収方法Entity.getChoshuHohoYoku8gatsu());
            entity.setChoshuHohoYoku9gatsu(徴収方法Entity.getChoshuHohoYoku9gatsu());
            entity.setKariNenkinNo(徴収方法Entity.getKariNenkinNo());
            entity.setKariNenkinCode(徴収方法Entity.getKariNenkinCode());
            entity.setKariHosokuM(徴収方法Entity.getKariHosokuM());
            entity.setHonNenkinNo(徴収方法Entity.getHonNenkinNo());
            entity.setHonNenkinCode(徴収方法Entity.getHonNenkinCode());
            entity.setHonHosokuM(徴収方法Entity.getHonHosokuM());
            entity.setYokunendoKariNenkinNo(徴収方法Entity.getYokunendoKariNenkinNo());
            entity.setYokunendoKariNenkinCode(徴収方法Entity.getYokunendoKariNenkinCode());
            entity.setYokunendoKariHosokuM(徴収方法Entity.getYokunendoKariHosokuM());
            entity.setIraiSohuzumiFlag(徴収方法Entity.isIraiSohuzumiFlag());
            entity.setTsuikaIraiSohuzumiFlag(徴収方法Entity.isTsuikaIraiSohuzumiFlag());
            entity.setTokuchoTeishiNichiji(徴収方法Entity.getTokuchoTeishiNichiji());
            entity.setTokuchoTeishiJiyuCode(徴収方法Entity.getTokuchoTeishiJiyuCode());
            entity.setTsuchishoNo(徴収方法Entity.getTsuchishoNo());
            entity.setChoteigaku(Decimal.ZERO);
            if (徴収方法Entity.getHokenryoDankai2() != null) {
                entity.setHokenryoDankai(徴収方法Entity.getHokenryoDankai2());
            } else {
                entity.setHokenryoDankai(徴収方法Entity.getHokenryoDankai1());
            }
            entity.setSeihoKaishiYMD(徴収方法Entity.getSeihoKaishiYMD());
            entity.setSeihoHaishiYMD(徴収方法Entity.getSeihoHaishiYMD());
            entity.setRonenKaishiYMD(徴収方法Entity.getRonenKaishiYMD());
            entity.setRonenHaishiYMD(徴収方法Entity.getRonenHaishiYMD());
            entity.setSetaikazeiKubun(徴収方法Entity.getSetaikazeiKubun());
            entity.setKazeiKubun(徴収方法Entity.getKazeiKubun());
            entity.setGokeiShotokuGaku(徴収方法Entity.getGokeiShotokuGaku());
            entity.setNenkinShunyuGaku(徴収方法Entity.getNenkinShunyuGaku());
            mapper.inset特徴仮算定抽出Temp(entity);
        }
        List<ZennNenndoFukaTempEntity> 前年度賦課EntityList = mapper.select前年度賦課(parameter);
        mapper.create前年度賦課Temp();
        for (ZennNenndoFukaTempEntity entity : 前年度賦課EntityList) {
            mapper.inset前年度賦課Temp(entity);
        }
        mapper.delete最新履歴以外のデータ();
        mapper.update特徴仮算定抽出Temp();

    }

    /**
     * 資格不整合データ抽出
     *
     * @param システム日時 YMDHMS
     */
    public void selectShikakuFuseigoData(YMDHMS システム日時) {
        ITokuchoKariSanteiFukaMapper mapper = mProvider.create(ITokuchoKariSanteiFukaMapper.class);
        List<TokutyoukariSannteiTyuushutuEntity> 不整合データList = mapper.select不整合データ();
        if (不整合データList != null && !不整合データList.isEmpty()) {
            for (TokutyoukariSannteiTyuushutuEntity 不整合データ : 不整合データList) {
                DbT2010FukaErrorListEntity entity = 賦課エラー一覧Dac.selectByKey(SubGyomuCode.DBB介護賦課, 内部帳票ID,
                        不整合データ.getFukaNendo(), 不整合データ.getTsuchishoNo());
                if (entity == null) {
                    entity = new DbT2010FukaErrorListEntity();
                    entity.setSubGyomuCode(SubGyomuCode.DBB介護賦課);
                    entity.setInternalReportId(内部帳票ID);
                    entity.setFukaNendo(不整合データ.getFukaNendo());
                    entity.setTsuchishoNo(不整合データ.getTsuchishoNo());
                    entity.setInternalReportCreationDateTime(システム日時.getRDateTime());
                    entity.setBatchId(バッチID);
                    entity.setBatchStartingDateTime(システム日時.getRDateTime());
                    entity.setErrorCode(new Code(ErrorCode.被保険者台帳データなし.getコード()));
                    entity.setHihokenshaNo(不整合データ.getHihokenshaNo());
                    entity.setState(EntityDataState.Added);
                } else {
                    entity.setInternalReportCreationDateTime(システム日時.getRDateTime());
                    entity.setBatchId(バッチID);
                    entity.setBatchStartingDateTime(システム日時.getRDateTime());
                    entity.setErrorCode(new Code(ErrorCode.被保険者台帳データなし.getコード()));
                    entity.setHihokenshaNo(不整合データ.getHihokenshaNo());
                    entity.setState(EntityDataState.Modified);
                }
                賦課エラー一覧Dac.save(entity);
                mapper.delete特徴仮算定抽出Temp(不整合データ);
            }
        }
    }

    /**
     * 資格等最新化（４月開始）
     *
     * @param 調定年度 FlexibleYear
     * @param 調定日時 YMDHMS
     */
    public void reflectShikakuToSaishinApril(FlexibleYear 調定年度, YMDHMS 調定日時) {
        ITokuchoKariSanteiFukaMapper mapper = mProvider.create(ITokuchoKariSanteiFukaMapper.class);
        Map<String, Object> parameter = new HashMap<>();
        parameter.put(キー_調定年度.toString(), 調定年度);
        parameter.put(キー_調定年度_1.toString(), 調定年度.minusYear(整数_1));
        List<SikakuSaisinnsikiRelateEntity> 資格等最新化情報List_４月開始 = mapper.select資格等最新化_４月開始(parameter);
        List<SikakuSaisinnsiki> 賦課の情報List_業務概念 = new ArrayList<>();
        List<FukaJohoTempEntity> 賦課の情報一時EntityList = new ArrayList<>();
        for (SikakuSaisinnsikiRelateEntity 資格等最新化情報 : 資格等最新化情報List_４月開始) {
            FukaJoho 賦課の情報_４月開始;
            ChoshuHoho 徴収方法の情報_４月開始;
            HihokenshaDaicho 資格の情報_４月開始;
            List<SeikatsuHogoJukyusha> 生保の情報List_４月開始 = new ArrayList<>();
            List<RoreiFukushiNenkinJukyusha> 老齢の情報List_４月開始 = new ArrayList<>();
            FukaJohoRelateEntity fukaJohoRelateEntity = 資格等最新化情報.get賦課の情報();
            if (fukaJohoRelateEntity == null) {
                賦課の情報_４月開始 = null;
            } else {
                fukaJohoRelateEntity.initializeMd5ToEntities();
                賦課の情報_４月開始 = new FukaJoho(fukaJohoRelateEntity);
            }
            DbT2001ChoshuHohoEntity dbt2001entity = 資格等最新化情報.get徴収方法の情報();
            if (dbt2001entity == null) {
                徴収方法の情報_４月開始 = null;
            } else {
                dbt2001entity.initializeMd5();
                徴収方法の情報_４月開始 = new ChoshuHoho(dbt2001entity);
            }
            DbT1001HihokenshaDaichoEntity dbt1001entity = 資格等最新化情報.get資格の情報();
            if (dbt1001entity == null) {
                資格の情報_４月開始 = null;
            } else {
                dbt1001entity.initializeMd5();
                資格の情報_４月開始 = new HihokenshaDaicho(dbt1001entity);
            }
            set生保の情報(資格等最新化情報, 生保の情報List_４月開始);
            List<DbT7006RoreiFukushiNenkinJukyushaEntity> dbt7006EnittyList = 資格等最新化情報.get老齢の情報();
            for (DbT7006RoreiFukushiNenkinJukyushaEntity dbt7006Entity : dbt7006EnittyList) {
                RoreiFukushiNenkinJukyusha 老齢の情報_４月開始;
                if (dbt7006Entity == null) {
                    老齢の情報_４月開始 = null;
                } else {
                    dbt7006Entity.initializeMd5();
                    老齢の情報_４月開始 = new RoreiFukushiNenkinJukyusha(dbt7006Entity);
                }
                老齢の情報List_４月開始.add(老齢の情報_４月開始);
            }
            SikakuSaisinnsiki sikakuSaisinnsiki = new SikakuSaisinnsiki(資格等最新化情報.get生保開始日(), 資格等最新化情報.get生保廃止日(),
                    資格等最新化情報.get老年開始日(), 資格等最新化情報.get老年廃止日(), 資格等最新化情報.get世帯課税区分(), 資格等最新化情報.get課税区分(),
                    資格等最新化情報.get合計所得金額(), 資格等最新化情報.get公的年金収入額(), 賦課の情報_４月開始, 徴収方法の情報_４月開始, 資格の情報_４月開始,
                    生保の情報List_４月開始, 老齢の情報List_４月開始);
            賦課の情報List_業務概念.add(sikakuSaisinnsiki);
        }
        for (SikakuSaisinnsiki 賦課の情報_業務概念 : 賦課の情報List_業務概念) {
            FukaJohoTempEntity 賦課の情報一時Entity = set賦課の情報_業務概念(賦課の情報_業務概念, 調定日時, 調定年度);
            賦課の情報一時EntityList.add(賦課の情報一時Entity);
        }
        mapper.create賦課の情報一時テーブル();
        if (!賦課の情報一時EntityList.isEmpty()) {
            for (FukaJohoTempEntity entity : 賦課の情報一時EntityList) {
                if (entity.isFalg()) {
                    mapper.inset賦課の情報一時テーブル(entity);
                }
            }
        }

    }

    private FukaJohoTempEntity set賦課の情報_業務概念(SikakuSaisinnsiki 賦課の情報_業務概念, YMDHMS 調定日時, FlexibleYear 調定年度) {
        ChoshuHoho 徴収方法の情報_４月開始 = 賦課の情報_業務概念.get徴収方法の情報_４月開始();
        HihokenshaDaicho 資格の情報_４月開始 = 賦課の情報_業務概念.get資格の情報_４月開始();
        List<SeikatsuHogoJukyusha> 生保の情報List_４月開始 = 賦課の情報_業務概念.get生保の情報List_４月開始();
        List<RoreiFukushiNenkinJukyusha> 老齢の情報List_４月開始 = 賦課の情報_業務概念.get老齢の情報List_４月開始();
        FukaJoho 賦課の情報_更正前 = 賦課の情報_業務概念.get賦課の情報_４月開始();
        FukaJohoTempEntity 賦課の情報一時Entity = new FukaJohoTempEntity();
        賦課の情報一時Entity.setChoteiNendo(賦課の情報_更正前.get調定年度());
        賦課の情報一時Entity.setFukaNendo(賦課の情報_更正前.get賦課年度());
        賦課の情報一時Entity.setTsuchishoNo(賦課の情報_更正前.get通知書番号());
        賦課の情報一時Entity.setRirekiNo(賦課の情報_更正前.get履歴番号() + 整数_1);
        賦課の情報一時Entity.setHihokenshaNo(賦課の情報_更正前.get被保険者番号());
        賦課の情報一時Entity.setShikibetsuCode(賦課の情報_更正前.get識別コード());
        賦課の情報一時Entity.setSetaiCode(賦課の情報_更正前.get世帯コード());
        賦課の情報一時Entity.setSetaiInsu(賦課の情報_更正前.get世帯員数());
        賦課の情報一時Entity.setKazeiKubun(賦課の情報_更正前.get課税区分());
        賦課の情報一時Entity.setSetaikazeiKubun(賦課の情報_更正前.get世帯課税区分());
        賦課の情報一時Entity.setGokeiShotokuGaku(賦課の情報_更正前.get合計所得金額());
        賦課の情報一時Entity.setNenkinShunyuGaku(賦課の情報_更正前.get公的年金収入額());
        賦課の情報一時Entity.setHokenryoDankai(賦課の情報_更正前.get保険料段階());
        賦課の情報一時Entity.setHokenryoDankai1(賦課の情報_更正前.get保険料算定段階1());
        賦課の情報一時Entity.setNengakuHokenryo1(賦課の情報_更正前.get算定年額保険料1());
        賦課の情報一時Entity.setTsukiwariStartYM1(賦課の情報_更正前.get月割開始年月1());
        賦課の情報一時Entity.setTsukiwariEndYM1(賦課の情報_更正前.get月割終了年月1());
        賦課の情報一時Entity.setHokenryoDankai2(賦課の情報_更正前.get保険料算定段階2());
        賦課の情報一時Entity.setNengakuHokenryo2(賦課の情報_更正前.get算定年額保険料2());
        賦課の情報一時Entity.setTsukiwariStartYM2(賦課の情報_更正前.get月割開始年月2());
        賦課の情報一時Entity.setTsukiwariEndYM2(賦課の情報_更正前.get月割終了年月2());
        賦課の情報一時Entity.setChoteiNichiji(調定日時);
        if (!調定日時.equals(賦課の情報_更正前.get調定日時())) {
            賦課の情報一時Entity.setFalg(true);
        }
        賦課の情報一時Entity.setKoseiM(文字列_04);
        if (!文字列_04.equals(賦課の情報_更正前.get更正月())) {
            賦課の情報一時Entity.setFalg(true);
        }
        賦課の情報一時Entity.setGemmenMaeHokenryo(賦課の情報_更正前.get減免前介護保険料_年額());
        賦課の情報一時Entity.setGemmenGaku(賦課の情報_更正前.get減免額());
        賦課の情報一時Entity.setKakuteiHokenryo(賦課の情報_更正前.get確定介護保険料_年額());
        賦課の情報一時Entity.setChoshuHohoRirekiNo(徴収方法の情報_４月開始.get履歴番号());
        if (徴収方法の情報_４月開始.get履歴番号() != 賦課の情報_更正前.get徴収方法履歴番号()) {
            賦課の情報一時Entity.setFalg(true);
        }
        賦課の情報一時Entity.setIdoKijunNichiji(調定日時);
        if (!調定日時.equals(賦課の情報_更正前.get異動基準日時())) {
            賦課の情報一時Entity.setFalg(true);
        }
        賦課の情報一時Entity.setKozaKubun(賦課の情報_更正前.get口座区分());
        賦課の情報一時Entity.setKyokaisoKubun(賦課の情報_更正前.get境界層区分());
        賦課の情報一時Entity.setShokkenKubun(賦課の情報_更正前.get職権区分());
        賦課の情報一時Entity.setTkSaishutsuKampuGaku(Decimal.ZERO);
        if (!Decimal.ZERO.equals(賦課の情報_更正前.get特徴歳出還付額())) {
            賦課の情報一時Entity.setFalg(true);
        }
        賦課の情報一時Entity.setFuSaishutsuKampuGaku(Decimal.ZERO);
        if (!Decimal.ZERO.equals(賦課の情報_更正前.get普徴歳出還付額())) {
            賦課の情報一時Entity.setFalg(true);
        }
        賦課の情報一時Entity.setTkKibetsuGaku04(Decimal.ZERO);
        if (!Decimal.ZERO.equals(賦課の情報_更正前.get特徴期別金額04())) {
            賦課の情報一時Entity.setFalg(true);
        }
        賦課の情報一時Entity.setTkKibetsuGaku05(Decimal.ZERO);
        if (!Decimal.ZERO.equals(賦課の情報_更正前.get特徴期別金額05())) {
            賦課の情報一時Entity.setFalg(true);
        }
        賦課の情報一時Entity.setTkKibetsuGaku06(Decimal.ZERO);
        if (!Decimal.ZERO.equals(賦課の情報_更正前.get特徴期別金額06())) {
            賦課の情報一時Entity.setFalg(true);
        }
        set普徴期別金額(賦課の情報一時Entity, 賦課の情報_更正前);
        賦課の情報一時Entity = modifyFukaJohoCommon_４月開始(調定年度, 資格の情報_４月開始, 生保の情報List_４月開始,
                老齢の情報List_４月開始, 賦課の情報_業務概念.get生保開始日(), 賦課の情報_業務概念.get生保廃止日(),
                賦課の情報_業務概念.get老年開始日(), 賦課の情報_業務概念.get老年廃止日(), 賦課の情報_業務概念.get世帯課税区分(),
                賦課の情報_業務概念.get課税区分(), 賦課の情報_業務概念.get合計所得金額(), 賦課の情報_業務概念.get公的年金収入額(),
                賦課の情報一時Entity, 賦課の情報_更正前);
        RString 徴収方法の情報_徴収方法4月 = 徴収方法の情報_４月開始.get徴収方法4月();
        set特別徴収停止事由コード(徴収方法の情報_徴収方法4月, 賦課の情報一時Entity, 徴収方法の情報_４月開始, 賦課の情報_更正前);
        return 賦課の情報一時Entity;
    }

    private void set普徴期別金額(FukaJohoTempEntity 賦課の情報一時Entity, FukaJoho 賦課の情報_更正前) {
        賦課の情報一時Entity.setFuKibetsuGaku01(Decimal.ZERO);
        if (!Decimal.ZERO.equals(賦課の情報_更正前.get普徴期別金額01())) {
            賦課の情報一時Entity.setFalg(true);
        }
        賦課の情報一時Entity.setFuKibetsuGaku02(Decimal.ZERO);
        if (!Decimal.ZERO.equals(賦課の情報_更正前.get普徴期別金額02())) {
            賦課の情報一時Entity.setFalg(true);
        }
        賦課の情報一時Entity.setFuKibetsuGaku03(Decimal.ZERO);
        if (!Decimal.ZERO.equals(賦課の情報_更正前.get普徴期別金額03())) {
            賦課の情報一時Entity.setFalg(true);
        }
        賦課の情報一時Entity.setFuKibetsuGaku04(Decimal.ZERO);
        if (!Decimal.ZERO.equals(賦課の情報_更正前.get普徴期別金額04())) {
            賦課の情報一時Entity.setFalg(true);
        }
        賦課の情報一時Entity.setFuKibetsuGaku05(Decimal.ZERO);
        if (!Decimal.ZERO.equals(賦課の情報_更正前.get普徴期別金額05())) {
            賦課の情報一時Entity.setFalg(true);
        }
        賦課の情報一時Entity.setFuKibetsuGaku06(Decimal.ZERO);
        if (!Decimal.ZERO.equals(賦課の情報_更正前.get普徴期別金額06())) {
            賦課の情報一時Entity.setFalg(true);
        }
        賦課の情報一時Entity.setFuKibetsuGaku07(Decimal.ZERO);
        if (!Decimal.ZERO.equals(賦課の情報_更正前.get普徴期別金額07())) {
            賦課の情報一時Entity.setFalg(true);
        }
        賦課の情報一時Entity.setFuKibetsuGaku08(Decimal.ZERO);
        if (!Decimal.ZERO.equals(賦課の情報_更正前.get普徴期別金額08())) {
            賦課の情報一時Entity.setFalg(true);
        }
        賦課の情報一時Entity.setFuKibetsuGaku09(Decimal.ZERO);
        if (!Decimal.ZERO.equals(賦課の情報_更正前.get普徴期別金額09())) {
            賦課の情報一時Entity.setFalg(true);
        }
        賦課の情報一時Entity.setFuKibetsuGaku10(Decimal.ZERO);
        if (!Decimal.ZERO.equals(賦課の情報_更正前.get普徴期別金額10())) {
            賦課の情報一時Entity.setFalg(true);
        }
        賦課の情報一時Entity.setFuKibetsuGaku11(Decimal.ZERO);
        if (!Decimal.ZERO.equals(賦課の情報_更正前.get普徴期別金額11())) {
            賦課の情報一時Entity.setFalg(true);
        }
        賦課の情報一時Entity.setFuKibetsuGaku12(Decimal.ZERO);
        if (!Decimal.ZERO.equals(賦課の情報_更正前.get普徴期別金額12())) {
            賦課の情報一時Entity.setFalg(true);
        }
        賦課の情報一時Entity.setFuKibetsuGaku13(Decimal.ZERO);
        if (!Decimal.ZERO.equals(賦課の情報_更正前.get普徴期別金額13())) {
            賦課の情報一時Entity.setFalg(true);
        }
        賦課の情報一時Entity.setFuKibetsuGaku14(Decimal.ZERO);
        if (!Decimal.ZERO.equals(賦課の情報_更正前.get普徴期別金額14())) {
            賦課の情報一時Entity.setFalg(true);
        }
    }

    private void set生保の情報(SikakuSaisinnsikiRelateEntity 資格等最新化情報, List<SeikatsuHogoJukyusha> 生保の情報List_４月開始) {
        List<SeikatsuHogoJukyushaRelateEntity> seikatsuHogoJukyushaRelateEntityList = 資格等最新化情報.get生保の情報();
        if (seikatsuHogoJukyushaRelateEntityList != null && !seikatsuHogoJukyushaRelateEntityList.isEmpty()) {
            for (SeikatsuHogoJukyushaRelateEntity seikatsuHogoJukyushaRelateEntity : seikatsuHogoJukyushaRelateEntityList) {
                SeikatsuHogoJukyusha 生保の情報_４月開始;
                if (seikatsuHogoJukyushaRelateEntity == null) {
                    生保の情報_４月開始 = null;
                } else {
                    seikatsuHogoJukyushaRelateEntity.initializeMd5ToEntities();
                    生保の情報_４月開始 = new SeikatsuHogoJukyusha(seikatsuHogoJukyushaRelateEntity);
                }
                生保の情報List_４月開始.add(生保の情報_４月開始);
            }
        }
    }

    private void set特別徴収停止事由コード(RString 徴収方法の情報_徴収方法4月, FukaJohoTempEntity 賦課の情報一時Entity,
            ChoshuHoho 徴収方法の情報_４月開始, FukaJoho 賦課の情報_更正前) {
        if (徴収方法の情報_徴収方法4月 != 特別徴収_厚生労働省 && 徴収方法の情報_徴収方法4月 != 特別徴収_地共済) {
            賦課の情報一時Entity.setChoteiJiyu1(徴収方法の情報_４月開始.get特別徴収停止事由コード());
            if (!徴収方法の情報_４月開始.get特別徴収停止事由コード().equals(賦課の情報_更正前.get調定事由1())) {
                賦課の情報一時Entity.setFalg(true);
            }
            賦課の情報一時Entity.setChoteiJiyu2(RString.EMPTY);
            if (!RString.EMPTY.equals(賦課の情報_更正前.get調定事由2())) {
                賦課の情報一時Entity.setFalg(true);
            }
            賦課の情報一時Entity.setChoteiJiyu3(RString.EMPTY);
            if (!RString.EMPTY.equals(賦課の情報_更正前.get調定事由3())) {
                賦課の情報一時Entity.setFalg(true);
            }
            賦課の情報一時Entity.setChoteiJiyu4(RString.EMPTY);
            if (!RString.EMPTY.equals(賦課の情報_更正前.get調定事由4())) {
                賦課の情報一時Entity.setFalg(true);
            }
            賦課の情報一時Entity.setTkKibetsuGaku01(Decimal.ZERO);
            if (!Decimal.ZERO.equals(賦課の情報_更正前.get特徴期別金額01())) {
                賦課の情報一時Entity.setFalg(true);
            }
            賦課の情報一時Entity.setTkKibetsuGaku02(Decimal.ZERO);
            if (!Decimal.ZERO.equals(賦課の情報_更正前.get特徴期別金額02())) {
                賦課の情報一時Entity.setFalg(true);
            }
            賦課の情報一時Entity.setTkKibetsuGaku03(Decimal.ZERO);
            if (!Decimal.ZERO.equals(賦課の情報_更正前.get特徴期別金額03())) {
                賦課の情報一時Entity.setFalg(true);
            }
        }
    }

    private FukaJohoTempEntity modifyFukaJohoCommon_４月開始(FlexibleYear 調定年度,
            HihokenshaDaicho 資格の情報,
            List<SeikatsuHogoJukyusha> 生保の情報List,
            List<RoreiFukushiNenkinJukyusha> 老齢の情報List,
            FlexibleDate 前年度生保開始日,
            FlexibleDate 前年度生保廃止日,
            FlexibleDate 前年度老年開始日,
            FlexibleDate 前年度老年廃止日,
            RString 前年度世帯課税区分,
            RString 前年度課税区分,
            Decimal 前年度合計所得金額,
            Decimal 前年度公的年金収入額,
            FukaJohoTempEntity 賦課の情報一時Entity,
            FukaJoho 賦課の情報_更正前) {
        賦課の情報一時Entity.setShikakuShutokuYMD(資格の情報.get第1号資格取得年月日());
        if (!賦課の情報_更正前.get資格取得日().equals(資格の情報.get第1号資格取得年月日())) {
            賦課の情報一時Entity.setFalg(true);
        }
        賦課の情報一時Entity.setShikakuShutokuJiyu(資格の情報.get資格取得事由コード());
        if (!賦課の情報_更正前.get資格取得事由().equals(資格の情報.get資格取得事由コード())) {
            賦課の情報一時Entity.setFalg(true);
        }
        賦課の情報一時Entity.setShikakuSoshitsuYMD(資格の情報.get資格喪失年月日());
        if (!賦課の情報_更正前.get資格喪失日().equals(資格の情報.get資格取得年月日())) {
            賦課の情報一時Entity.setFalg(true);
        }
        賦課の情報一時Entity.setShikakuSoshitsuJiyu(資格の情報.get資格喪失事由コード());
        if (!賦課の情報_更正前.get資格喪失事由().equals(資格の情報.get資格喪失事由コード())) {
            賦課の情報一時Entity.setFalg(true);
        }
        FlexibleDate 調定年度開始日 = new FlexibleDate(調定年度.toDateString().concat(文字列_04).concat(文字列_01));
        FlexibleDate 調定年度廃止日 = new FlexibleDate(調定年度.plusYear(整数_1).toDateString().concat(文字列_03).concat(文字列_31));
        set生保の情報_modifyFukaJohoCommon_４月開始(生保の情報List, 調定年度開始日, 調定年度廃止日, 賦課の情報一時Entity, 賦課の情報_更正前);
        set老齢の情報_modifyFukaJohoCommon_４月開始(老齢の情報List, 調定年度開始日, 調定年度廃止日, 賦課の情報一時Entity, 賦課の情報_更正前);
        賦課の情報一時Entity.setFukaYMD(FukaKeisan.createInstance().findOut賦課基準日(調定年度, 資格の情報));
        HokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter = new HokenryoDankaiHanteiParameter();
        hokenryoDankaiHanteiParameter.setFukaNendo(調定年度);
        FukaKonkyo fukaKonkyo = new FukaKonkyo();
        fukaKonkyo.setFukakijunYMD(調定年度開始日);
        if (前年度生保開始日.isEmpty()) {
            fukaKonkyo.setSeihoStartYMD(FlexibleDate.EMPTY);
        } else if (前年度生保廃止日.isEmpty() || 調定年度開始日.isBeforeOrEquals(前年度生保廃止日)) {
            fukaKonkyo.setSeihoStartYMD(調定年度開始日);
        } else {
            fukaKonkyo.setSeihoStartYMD(FlexibleDate.EMPTY);
        }
        fukaKonkyo.setSeihoEndYMD(FlexibleDate.EMPTY);
        if (前年度老年開始日.isEmpty()) {
            fukaKonkyo.setRoreiNenkinStartYMD(FlexibleDate.EMPTY);
        } else if (前年度老年廃止日.isEmpty() || 調定年度開始日.isBeforeOrEquals(前年度老年廃止日)) {
            fukaKonkyo.setRoreiNenkinStartYMD(調定年度開始日);
        } else {
            fukaKonkyo.setRoreiNenkinStartYMD(FlexibleDate.EMPTY);
        }
        fukaKonkyo.setRoreiNenkinEndYMD(FlexibleDate.EMPTY);
        List<KazeiKubun> setaiinKazeiKubunList = new ArrayList<>();
        setaiinKazeiKubunList.add(KazeiKubun.toValue(前年度世帯課税区分));
        setaiinKazeiKubunList.add(KazeiKubun.toValue(前年度課税区分));
        fukaKonkyo.setSetaiinKazeiKubunList(setaiinKazeiKubunList);
        fukaKonkyo.setGokeiShotoku(前年度合計所得金額);
        fukaKonkyo.setKotekiNenkinShunyu(前年度公的年金収入額);
        hokenryoDankaiHanteiParameter.setFukaKonkyo(fukaKonkyo);
        SeigyoJoho seigyoJoho = new SeigyoJoho();
        seigyoJoho.setHokenryoDankaiList(HokenryoDankaiSettings.createInstance().getCurrent保険料段階List());
        seigyoJoho.setKijunNenkinShunyu01(new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準年金収入1,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課).toString()));
        seigyoJoho.setKijunNenkinShunyu02(new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準年金収入2,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課).toString()));
        seigyoJoho.setKijunNenkinShunyu03(new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準年金収入3,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課).toString()));
        seigyoJoho.setKijunShotokuKingaku01(new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額1,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課).toString()));
        seigyoJoho.setKijunShotokuKingaku02(new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額2,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課).toString()));
        seigyoJoho.setKijunShotokuKingaku03(new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額3,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課).toString()));
        seigyoJoho.setKijunShotokuKingaku04(new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額4,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課).toString()));
        seigyoJoho.setKijunShotokuKingaku05(new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額5,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課).toString()));
        seigyoJoho.setKijunShotokuKingaku06(new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額6,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課).toString()));
        seigyoJoho.setKijunShotokuKingaku07(new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額7,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課).toString()));
        seigyoJoho.setKijunShotokuKingaku08(new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額8,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課).toString()));
        seigyoJoho.setKijunShotokuKingaku09(new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額9,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課).toString()));
        seigyoJoho.setKijunShotokuKingaku10(new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額10,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課).toString()));
        seigyoJoho.setKijunShotokuKingaku11(new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額11,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課).toString()));
        seigyoJoho.setKijunShotokuKingaku12(new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額12,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課).toString()));
        seigyoJoho.setKijunShotokuKingaku13(new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額13,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課).toString()));
        seigyoJoho.setKijunShotokuKingaku14(new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額14,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課).toString()));
        seigyoJoho.setKijunShotokuKingaku15(new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額15,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課).toString()));
        seigyoJoho.setKazeisouShotokuDankai(DbBusinessConfig.get(ConfigNameDBB.賦課基準_課税層保険料段階インデックス,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課));
        if (保険料段階を使用する.equals(DbBusinessConfig.get(ConfigNameDBB.賦課基準_未申告保険料段階使用,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課))) {
            seigyoJoho.setUsesMishinkokuDankai(true);
        } else {
            seigyoJoho.setUsesMishinkokuDankai(false);
        }
        seigyoJoho.setMishinkokuDankai(DbBusinessConfig.get(ConfigNameDBB.賦課基準_未申告保険料段階インデックス,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課));
        seigyoJoho.setMishinkokuKazeiKubun(KazeiKubun.toValue(DbBusinessConfig.get(ConfigNameDBB.賦課基準_未申告課税区分,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課)));
        if (保険料段階を使用する.equals(DbBusinessConfig.get(ConfigNameDBB.賦課基準_所得調査中保険料段階使用,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課))) {
            seigyoJoho.setUsesShotokuChosachuDankai(true);
        } else {
            seigyoJoho.setUsesShotokuChosachuDankai(false);
        }
        seigyoJoho.setShotokuChosachuDankai(DbBusinessConfig.get(ConfigNameDBB.賦課基準_所得調査中保険料段階インデックス,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課));
        seigyoJoho.setShotokuChosachuKazeiKubun(KazeiKubun.toValue(DbBusinessConfig.get(ConfigNameDBB.賦課基準_所得調査中課税区分,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課)));
        if (保険料段階を使用する.equals(DbBusinessConfig.get(ConfigNameDBB.賦課基準_課税取消保険料段階使用,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課))) {
            seigyoJoho.setUsesKazeiTorikeshiDankai(true);
        } else {
            seigyoJoho.setUsesKazeiTorikeshiDankai(false);
        }
        seigyoJoho.setKazeiTorikeshiDankai(DbBusinessConfig.get(ConfigNameDBB.賦課基準_課税取消保険料段階インデックス,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課));
        seigyoJoho.setKazeiTorikeshiKazeiKubun(KazeiKubun.toValue(DbBusinessConfig.get(ConfigNameDBB.賦課基準_課税取消課税区分,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課)));
        hokenryoDankaiHanteiParameter.setSeigyoJoho(seigyoJoho);
        TsukibetsuHokenryoDankai 月別保険料段階 = new HokenryoDankaiHantei().determine月別保険料段階(hokenryoDankaiHanteiParameter);
        RString 保険料段階 = 月別保険料段階.get保険料段階04月().edit表示用保険料段階();
        賦課の情報一時Entity.setHokenryoDankaiKarisanntei(保険料段階);
        if (!保険料段階.equals(賦課の情報_更正前.get保険料段階_仮算定時())) {
            賦課の情報一時Entity.setFalg(true);
        }
        if (資格の情報.get旧市町村コード() != null && !資格の情報.get旧市町村コード().isEmpty()) {
            賦課の情報一時Entity.setFukaShichosonCode(資格の情報.get旧市町村コード());
        } else if (資格の情報.get広住特措置元市町村コード() != null && !資格の情報.get広住特措置元市町村コード().isEmpty()) {
            賦課の情報一時Entity.setFukaShichosonCode(資格の情報.get広住特措置元市町村コード());
        } else {
            賦課の情報一時Entity.setFukaShichosonCode(資格の情報.get市町村コード());
        }
        equals賦課市町村コード(賦課の情報_更正前, 賦課の情報一時Entity);
        return 賦課の情報一時Entity;
    }

    private void set老齢の情報_modifyFukaJohoCommon_４月開始(List<RoreiFukushiNenkinJukyusha> 老齢の情報List, FlexibleDate 調定年度開始日,
            FlexibleDate 調定年度廃止日, FukaJohoTempEntity 賦課の情報一時Entity, FukaJoho 賦課の情報_更正前) {
        FlexibleDate 最新老齢受給開始年月日 = null;
        RoreiFukushiNenkinJukyusha 最新老齢の情報 = null;
        for (RoreiFukushiNenkinJukyusha 老齢の情報 : 老齢の情報List) {
            if (老齢の情報.get受給開始年月日() == null || 老齢の情報.get受給終了年月日() == null) {
                continue;
            }
            if (!調定年度廃止日.isBeforeOrEquals(老齢の情報.get受給開始年月日()) && 調定年度開始日.isBefore(老齢の情報.get受給終了年月日())) {
                if (最新老齢受給開始年月日 == null) {
                    最新老齢受給開始年月日 = 老齢の情報.get受給開始年月日();
                    最新老齢の情報 = 老齢の情報;
                } else {
                    if (最新老齢受給開始年月日.isBefore(老齢の情報.get受給開始年月日())) {
                        最新老齢受給開始年月日 = 老齢の情報.get受給開始年月日();
                        最新老齢の情報 = 老齢の情報;
                    }
                }
            }
        }
        if (最新老齢の情報 == null) {
            賦課の情報一時Entity.setRonenKaishiYMD(FlexibleDate.EMPTY);
            if (!FlexibleDate.EMPTY.equals(賦課の情報_更正前.get老年開始日())) {
                賦課の情報一時Entity.setFalg(true);
            }
            賦課の情報一時Entity.setRonenHaishiYMD(FlexibleDate.EMPTY);
            if (!FlexibleDate.EMPTY.equals(賦課の情報_更正前.get老年廃止日())) {
                賦課の情報一時Entity.setFalg(true);
            }
        } else {
            賦課の情報一時Entity.setRonenKaishiYMD(最新老齢の情報.get受給開始年月日());
            if (!最新老齢の情報.get受給開始年月日().equals(賦課の情報_更正前.get老年開始日())) {
                賦課の情報一時Entity.setFalg(true);
            }
            賦課の情報一時Entity.setRonenHaishiYMD(最新老齢の情報.get受給終了年月日());
            if (!最新老齢の情報.get受給終了年月日().equals(賦課の情報_更正前.get老年廃止日())) {
                賦課の情報一時Entity.setFalg(true);
            }
        }

    }

    private void set生保の情報_modifyFukaJohoCommon_４月開始(List<SeikatsuHogoJukyusha> 生保の情報List, FlexibleDate 調定年度開始日,
            FlexibleDate 調定年度廃止日, FukaJohoTempEntity 賦課の情報一時Entity, FukaJoho 賦課の情報_更正前) {
        FlexibleDate 最新受給開始日 = null;
        SeikatsuHogoJukyusha 最新生保の情報 = null;
        for (SeikatsuHogoJukyusha 生保の情報 : 生保の情報List) {
            if (生保の情報.get受給開始日() == null || 生保の情報.get受給廃止日() == null) {
                continue;
            }
            if (!調定年度廃止日.isBeforeOrEquals(生保の情報.get受給開始日()) && 調定年度開始日.isBefore(生保の情報.get受給廃止日())) {
                if (最新受給開始日 == null) {
                    最新受給開始日 = 生保の情報.get受給廃止日();
                    最新生保の情報 = 生保の情報;
                } else {
                    if (最新受給開始日.isBefore(生保の情報.get受給廃止日())) {
                        最新受給開始日 = 生保の情報.get受給廃止日();
                        最新生保の情報 = 生保の情報;
                    }
                }
            }
        }
        if (最新生保の情報 == null) {
            賦課の情報一時Entity.setSeihofujoShurui(RString.EMPTY);
            if (!RString.EMPTY.equals(賦課の情報_更正前.get生活保護扶助種類())) {
                賦課の情報一時Entity.setFalg(true);
            }
            賦課の情報一時Entity.setSeihoKaishiYMD(FlexibleDate.EMPTY);
            if (!FlexibleDate.EMPTY.equals(賦課の情報_更正前.get生保開始日())) {
                賦課の情報一時Entity.setFalg(true);
            }
            賦課の情報一時Entity.setSeihoHaishiYMD(FlexibleDate.EMPTY);
            if (!FlexibleDate.EMPTY.equals(賦課の情報_更正前.get生保廃止日())) {
                賦課の情報一時Entity.setFalg(true);
            }
        } else {
            // TODO QA 949
            // 生活保護扶助種類 mapper
//            List<SeikatsuHogoFujoShurui> 最新生活保護扶助種類List = 最新生保の情報.getSeikatsuHogoFujoShuruiList();
//            int 生活保護扶助種類 = Integer.valueOf(最新生活保護扶助種類List.get(整数_0).get扶助種類コード().toString());
//            for (SeikatsuHogoFujoShurui 最新生活保護扶助種類 : 最新生活保護扶助種類List) {
//                if (生活保護扶助種類 > (Integer.valueOf(最新生活保護扶助種類.get扶助種類コード().toString()))) {
//                    生活保護扶助種類 = Integer.valueOf(最新生活保護扶助種類.get扶助種類コード().toString());
//                }
//            }
//            賦課の情報一時Entity.setSeihofujoShurui(new RString(String.valueOf(生活保護扶助種類)));
//            if (!new RString(String.valueOf(生活保護扶助種類)).equals(賦課の情報_更正前.get生活保護扶助種類())) {
//                賦課の情報一時Entity.setFalg(true);
//            }
            賦課の情報一時Entity.setSeihoKaishiYMD(最新生保の情報.get受給開始日());
            if (!最新生保の情報.get受給開始日().equals(賦課の情報_更正前.get生保開始日())) {
                賦課の情報一時Entity.setFalg(true);
            }
            賦課の情報一時Entity.setSeihoHaishiYMD(最新生保の情報.get受給廃止日());
            if (!最新生保の情報.get受給廃止日().equals(賦課の情報_更正前.get生保廃止日())) {
                賦課の情報一時Entity.setFalg(true);
            }
        }
    }

    private void equals賦課市町村コード(FukaJoho 賦課の情報_更正前, FukaJohoTempEntity 賦課の情報一時Entity) {
        if (賦課の情報_更正前.get賦課市町村コード() == null) {
            if (賦課の情報一時Entity.getFukaShichosonCode() != null) {
                賦課の情報一時Entity.setFalg(true);
            }
        } else if (!賦課の情報_更正前.get賦課市町村コード().equals(賦課の情報一時Entity.getFukaShichosonCode())) {
            賦課の情報一時Entity.setFalg(true);
        }
    }

    /**
     * 賦課情報の計算登録（継続）
     *
     * @param 調定年度 FlexibleYear
     * @param 調定日時 YMDHMS
     */
    public void createFukaJohoKeizoku(FlexibleYear 調定年度, YMDHMS 調定日時) {
        ITokuchoKariSanteiFukaMapper mapper = mProvider.create(ITokuchoKariSanteiFukaMapper.class);
        List<FukaJohokeizokuRelateEntity> 賦課情報_継続List = mapper.select賦課情報_継続();
        mapper.clear賦課の情報一時テーブル();
        List<FukaJohokeizoku> 業務概念_賦課情報_継続List = new ArrayList<>();
        for (FukaJohokeizokuRelateEntity 賦課情報_継続 : 賦課情報_継続List) {
            ChoshuHoho 徴収方法の情報_継続;
            HihokenshaDaicho 資格の情報_継続;
            List<SeikatsuHogoJukyusha> 生保の情報List_継続 = new ArrayList<>();
            List<RoreiFukushiNenkinJukyusha> 老齢の情報List_継続 = new ArrayList<>();
            DbT2001ChoshuHohoEntity dbt2001entity = 賦課情報_継続.get徴収方法の情報();
            if (dbt2001entity == null) {
                徴収方法の情報_継続 = null;
            } else {
                dbt2001entity.initializeMd5();
                徴収方法の情報_継続 = new ChoshuHoho(dbt2001entity);
            }
            DbT1001HihokenshaDaichoEntity dbt1001entity = 賦課情報_継続.get資格の情報();
            if (dbt1001entity == null) {
                資格の情報_継続 = null;
            } else {
                dbt1001entity.initializeMd5();
                資格の情報_継続 = new HihokenshaDaicho(dbt1001entity);
            }
            List<SeikatsuHogoJukyushaRelateEntity> seikatsuHogoJukyushaRelateEntityList = 賦課情報_継続.get生保の情報();
            if (seikatsuHogoJukyushaRelateEntityList != null && !seikatsuHogoJukyushaRelateEntityList.isEmpty()) {
                for (SeikatsuHogoJukyushaRelateEntity seikatsuHogoJukyushaRelateEntity : seikatsuHogoJukyushaRelateEntityList) {
                    SeikatsuHogoJukyusha 生保の情報_継続;
                    if (seikatsuHogoJukyushaRelateEntity == null) {
                        生保の情報_継続 = null;
                    } else {
                        seikatsuHogoJukyushaRelateEntity.initializeMd5ToEntities();
                        生保の情報_継続 = new SeikatsuHogoJukyusha(seikatsuHogoJukyushaRelateEntity);
                    }
                    生保の情報List_継続.add(生保の情報_継続);
                }
            }
            List<DbT7006RoreiFukushiNenkinJukyushaEntity> dbt7006EnittyList = 賦課情報_継続.get老齢の情報();
            for (DbT7006RoreiFukushiNenkinJukyushaEntity dbt7006Entity : dbt7006EnittyList) {
                RoreiFukushiNenkinJukyusha 老齢の情報_継続;
                if (dbt7006Entity == null) {
                    老齢の情報_継続 = null;
                } else {
                    dbt7006Entity.initializeMd5();
                    老齢の情報_継続 = new RoreiFukushiNenkinJukyusha(dbt7006Entity);
                }
                老齢の情報List_継続.add(老齢の情報_継続);
            }
            FukaJohokeizoku fukaJohokeizoku = new FukaJohokeizoku(賦課情報_継続.getChoteigaku(), 賦課情報_継続.getSeihoKaishiYMD(),
                    賦課情報_継続.getSeihoHaishiYMD(), 賦課情報_継続.getRonenKaishiYMD(),
                    賦課情報_継続.getRonenHaishiYMD(), 賦課情報_継続.getSetaikazeiKubun(), 賦課情報_継続.getKazeiKubun(),
                    賦課情報_継続.getGokeiShotokuGaku(), 賦課情報_継続.getNenkinShunyuGaku(), 徴収方法の情報_継続, 資格の情報_継続,
                    生保の情報List_継続, 老齢の情報List_継続);
            業務概念_賦課情報_継続List.add(fukaJohokeizoku);
        }
        Map<HihokenshaNo, Integer> 被保険者番号Map = new HashMap<>();
        if (!業務概念_賦課情報_継続List.isEmpty()) {
            for (FukaJohokeizoku 業務概念_賦課情報_継続 : 業務概念_賦課情報_継続List) {
                FukaJoho 賦課情報 = modifyFukaJohoCommon(調定年度, 調定日時, 業務概念_賦課情報_継続.get資格の情報_継続(),
                        業務概念_賦課情報_継続.get徴収方法の情報_継続(), 業務概念_賦課情報_継続.get生保の情報List_継続(),
                        業務概念_賦課情報_継続.get老齢の情報List_継続(), 業務概念_賦課情報_継続.getSeihoKaishiYMD(),
                        業務概念_賦課情報_継続.getSeihoHaishiYMD(), 業務概念_賦課情報_継続.getRonenKaishiYMD(),
                        業務概念_賦課情報_継続.getRonenHaishiYMD(), 業務概念_賦課情報_継続.getSetaikazeiKubun(), 業務概念_賦課情報_継続.getKazeiKubun(),
                        業務概念_賦課情報_継続.getGokeiShotokuGaku(), 業務概念_賦課情報_継続.getNenkinShunyuGaku(), null, 被保険者番号Map);
                set被保険者番号Map(被保険者番号Map, 賦課情報);
                FukaJohoTempEntity 賦課の情報一時Entity = create賦課の情報一時Entity(賦課情報, 業務概念_賦課情報_継続.getChoteigaku(),
                        業務概念_賦課情報_継続.getChoteigaku(), 業務概念_賦課情報_継続.getChoteigaku());
                mapper.inset賦課の情報一時テーブル(賦課の情報一時Entity);
            }
        }
    }

    /**
     * 賦課情報の計算登録（6月開始）
     *
     * @param 調定年度 FlexibleYear
     * @param 調定日時 YMDHMS
     */
    public void createFukaJohoJune(FlexibleYear 調定年度, YMDHMS 調定日時) {
        ITokuchoKariSanteiFukaMapper mapper = mProvider.create(ITokuchoKariSanteiFukaMapper.class);
        List<FukaJohoLokukatuRelateEntity> 賦課情報_6月開始List = mapper.select賦課情報_6月開始();
        List<FukaJohoLokukatu> 業務概念_賦課情報_6月開始List = new ArrayList<>();
        for (FukaJohoLokukatuRelateEntity 賦課情報_6月開始 : 賦課情報_6月開始List) {
            ChoshuHoho 徴収方法の情報_6月開始;
            HihokenshaDaicho 資格の情報_6月開始;
            List<SeikatsuHogoJukyusha> 生保の情報List_6月開始 = new ArrayList<>();
            List<RoreiFukushiNenkinJukyusha> 老齢の情報List_6月開始 = new ArrayList<>();
            DbT2001ChoshuHohoEntity dbt2001entity = 賦課情報_6月開始.get徴収方法の情報();
            if (dbt2001entity == null) {
                徴収方法の情報_6月開始 = null;
            } else {
                dbt2001entity.initializeMd5();
                徴収方法の情報_6月開始 = new ChoshuHoho(dbt2001entity);
            }
            DbT1001HihokenshaDaichoEntity dbt1001entity = 賦課情報_6月開始.get資格の情報();
            if (dbt1001entity == null) {
                資格の情報_6月開始 = null;
            } else {
                dbt1001entity.initializeMd5();
                資格の情報_6月開始 = new HihokenshaDaicho(dbt1001entity);
            }
            List<SeikatsuHogoJukyushaRelateEntity> seikatsuHogoJukyushaRelateEntityList = 賦課情報_6月開始.get生保の情報();
            if (seikatsuHogoJukyushaRelateEntityList != null && !seikatsuHogoJukyushaRelateEntityList.isEmpty()) {
                for (SeikatsuHogoJukyushaRelateEntity seikatsuHogoJukyushaRelateEntity : seikatsuHogoJukyushaRelateEntityList) {
                    SeikatsuHogoJukyusha 生保の情報_6月開始;
                    if (seikatsuHogoJukyushaRelateEntity == null) {
                        生保の情報_6月開始 = null;
                    } else {
                        seikatsuHogoJukyushaRelateEntity.initializeMd5ToEntities();
                        生保の情報_6月開始 = new SeikatsuHogoJukyusha(seikatsuHogoJukyushaRelateEntity);
                    }
                    生保の情報List_6月開始.add(生保の情報_6月開始);
                }
            }
            List<DbT7006RoreiFukushiNenkinJukyushaEntity> dbt7006EnittyList = 賦課情報_6月開始.get老齢の情報();
            for (DbT7006RoreiFukushiNenkinJukyushaEntity dbt7006Entity : dbt7006EnittyList) {
                RoreiFukushiNenkinJukyusha 老齢の情報_6月開始;
                if (dbt7006Entity == null) {
                    老齢の情報_6月開始 = null;
                } else {
                    dbt7006Entity.initializeMd5();
                    老齢の情報_6月開始 = new RoreiFukushiNenkinJukyusha(dbt7006Entity);
                }
                老齢の情報List_6月開始.add(老齢の情報_6月開始);
            }
            FukaJohoLokukatu fukaJohoLokukatu = new FukaJohoLokukatu(賦課情報_6月開始.getChoteigaku(), 賦課情報_6月開始.getHokenryoDankai(),
                    賦課情報_6月開始.getSeihoKaishiYMD(),
                    賦課情報_6月開始.getSeihoHaishiYMD(), 賦課情報_6月開始.getRonenKaishiYMD(),
                    賦課情報_6月開始.getRonenHaishiYMD(), 賦課情報_6月開始.getSetaikazeiKubun(),
                    賦課情報_6月開始.getKazeiKubun(), 賦課情報_6月開始.getGokeiShotokuGaku(),
                    賦課情報_6月開始.getNenkinShunyuGaku(), 徴収方法の情報_6月開始, 資格の情報_6月開始,
                    生保の情報List_6月開始, 老齢の情報List_6月開始);
            業務概念_賦課情報_6月開始List.add(fukaJohoLokukatu);
        }
        Map<HihokenshaNo, Integer> 被保険者番号Map = new HashMap<>();
        for (FukaJohoLokukatu 業務概念_賦課情報_6月開始 : 業務概念_賦課情報_6月開始List) {
            FukaJoho 賦課情報 = modifyFukaJohoCommon(調定年度, 調定日時, 業務概念_賦課情報_6月開始.get資格の情報_6月開始(),
                    業務概念_賦課情報_6月開始.get徴収方法の情報_6月開始(), 業務概念_賦課情報_6月開始.get生保の情報List_6月開始(),
                    業務概念_賦課情報_6月開始.get老齢の情報List_6月開始(), 業務概念_賦課情報_6月開始.getSeihoKaishiYMD(),
                    業務概念_賦課情報_6月開始.getSeihoHaishiYMD(), 業務概念_賦課情報_6月開始.getRonenKaishiYMD(),
                    業務概念_賦課情報_6月開始.getRonenHaishiYMD(), 業務概念_賦課情報_6月開始.getSetaikazeiKubun(),
                    業務概念_賦課情報_6月開始.getKazeiKubun(), 業務概念_賦課情報_6月開始.getGokeiShotokuGaku(),
                    業務概念_賦課情報_6月開始.getNenkinShunyuGaku(), null, 被保険者番号Map);
            set被保険者番号Map(被保険者番号Map, 賦課情報);
            HokenryoDankaiList 前年度の保険料段階リスト;
            Decimal 保険料率 = Decimal.ZERO;
            RString 特別徴収_年額基準年度_6月開始 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_年額基準年度_6月開始,
                    new RDate(調定年度.minusYear(整数_1).toString()), SubGyomuCode.DBB介護賦課);
            if (TokuchoNengakuKijunNendo6Gatsu.当年度.getコード().equals(特別徴収_年額基準年度_6月開始)) {
                前年度の保険料段階リスト = HokenryoDankaiSettings.createInstance()
                        .get保険料段階ListIn(調定年度.minusYear(整数_1));
                保険料率 = 前年度の保険料段階リスト.getBy段階区分(業務概念_賦課情報_6月開始.getHokenryoDankai()).get保険料率();
            } else if (TokuchoNengakuKijunNendo6Gatsu.翌年度.getコード().equals(特別徴収_年額基準年度_6月開始)) {
                前年度の保険料段階リスト = HokenryoDankaiSettings.createInstance()
                        .get保険料段階ListIn(調定年度);
                保険料率 = 前年度の保険料段階リスト.getBy段階区分(賦課情報.get保険料段階_仮算定時()).get保険料率();
            }
            TokuchoKarisanteiKiwariOutput 特徴仮算定期割 = get特徴仮算定期割(調定年度, 保険料率);
            Decimal 特徴期別金額01 = Decimal.ZERO;
            Decimal 特徴期別金額02 = Decimal.ZERO;
            Decimal 特徴期別金額03 = Decimal.ZERO;
            特徴期別金額01 = set特徴期別金額01(特徴仮算定期割, 特徴期別金額01);
            特徴期別金額02 = set特徴期別金額02(特徴仮算定期割, 特徴期別金額02);
            特徴期別金額03 = set特徴期別金額03(特徴仮算定期割, 特徴期別金額03);
            FukaJohoTempEntity 賦課の情報一時Entity = create賦課の情報一時Entity(賦課情報, 特徴期別金額01, 特徴期別金額02, 特徴期別金額03);
            mapper.inset賦課の情報一時テーブル(賦課の情報一時Entity);
        }
    }

    private Decimal set特徴期別金額03(TokuchoKarisanteiKiwariOutput 特徴仮算定期割, Decimal 特徴期別金額03) {
        if (特徴仮算定期割 != null && 特徴仮算定期割.get特徴期別額() != null && 整数_3 <= 特徴仮算定期割.get特徴期別額().size()) {
            特徴期別金額03 = 特徴仮算定期割.get特徴期別額().get(整数_2);
        }
        return 特徴期別金額03;
    }

    private Decimal set特徴期別金額02(TokuchoKarisanteiKiwariOutput 特徴仮算定期割, Decimal 特徴期別金額02) {
        if (特徴仮算定期割 != null && 特徴仮算定期割.get特徴期別額() != null && 整数_2 <= 特徴仮算定期割.get特徴期別額().size()) {
            特徴期別金額02 = 特徴仮算定期割.get特徴期別額().get(整数_1);
        }
        return 特徴期別金額02;
    }

    private Decimal set特徴期別金額01(TokuchoKarisanteiKiwariOutput 特徴仮算定期割, Decimal 特徴期別金額01) {
        if (特徴仮算定期割 != null && 特徴仮算定期割.get特徴期別額() != null && 整数_1 <= 特徴仮算定期割.get特徴期別額().size()) {
            特徴期別金額01 = 特徴仮算定期割.get特徴期別額().get(整数_0);
        }
        return 特徴期別金額01;
    }

    private void set被保険者番号Map(Map<HihokenshaNo, Integer> 被保険者番号Map, FukaJoho 賦課情報) throws NumberFormatException {
        if (被保険者番号Map.containsKey(賦課情報.get被保険者番号())) {
            被保険者番号Map.remove(賦課情報.get被保険者番号());
            int 枝番号 = Integer.valueOf(賦課情報.get通知書番号().value().substring(整数_14, 整数_16).toString());
            被保険者番号Map.put(賦課情報.get被保険者番号(), 枝番号);
        } else {
            int 枝番号 = Integer.valueOf(賦課情報.get通知書番号().value().substring(整数_14, 整数_16).toString());
            被保険者番号Map.put(賦課情報.get被保険者番号(), 枝番号);
        }
    }

    private FukaJohoTempEntity create賦課の情報一時Entity(FukaJoho 賦課情報, Decimal 特徴期別金額01, Decimal 特徴期別金額02, Decimal 特徴期別金額03) {
        FukaJohoTempEntity 賦課の情報一時Entity = new FukaJohoTempEntity();
        賦課の情報一時Entity.setChoteiNendo(賦課情報.get調定年度());
        賦課の情報一時Entity.setFukaNendo(賦課情報.get賦課年度());
        賦課の情報一時Entity.setTsuchishoNo(賦課情報.get通知書番号());
        賦課の情報一時Entity.setRirekiNo(賦課情報.get履歴番号());
        賦課の情報一時Entity.setHihokenshaNo(賦課情報.get被保険者番号());
        賦課の情報一時Entity.setShikibetsuCode(賦課情報.get識別コード());
        賦課の情報一時Entity.setSetaiCode(賦課情報.get世帯コード());
        賦課の情報一時Entity.setSetaiInsu(賦課情報.get世帯員数());
        賦課の情報一時Entity.setShikakuShutokuYMD(賦課情報.get資格取得日());
        賦課の情報一時Entity.setShikakuShutokuJiyu(賦課情報.get資格取得事由());
        賦課の情報一時Entity.setShikakuSoshitsuYMD(賦課情報.get資格喪失日());
        賦課の情報一時Entity.setShikakuSoshitsuJiyu(賦課情報.get資格喪失事由());
        賦課の情報一時Entity.setSeihofujoShurui(賦課情報.get生活保護扶助種類());
        賦課の情報一時Entity.setSeihoKaishiYMD(賦課情報.get生保開始日());
        賦課の情報一時Entity.setSeihoHaishiYMD(賦課情報.get生保廃止日());
        賦課の情報一時Entity.setRonenKaishiYMD(賦課情報.get老年開始日());
        賦課の情報一時Entity.setRonenHaishiYMD(賦課情報.get老年廃止日());
        賦課の情報一時Entity.setFukaYMD(賦課情報.get賦課期日());
        賦課の情報一時Entity.setKazeiKubun(賦課情報.get課税区分());
        賦課の情報一時Entity.setSetaikazeiKubun(賦課情報.get世帯課税区分());
        賦課の情報一時Entity.setGokeiShotokuGaku(賦課情報.get合計所得金額());
        賦課の情報一時Entity.setNenkinShunyuGaku(賦課情報.get公的年金収入額());
        賦課の情報一時Entity.setHokenryoDankai(賦課情報.get保険料段階());
        賦課の情報一時Entity.setHokenryoDankai1(賦課情報.get保険料算定段階1());
        賦課の情報一時Entity.setNengakuHokenryo1(賦課情報.get算定年額保険料1());
        賦課の情報一時Entity.setTsukiwariStartYM1(賦課情報.get月割開始年月1());
        賦課の情報一時Entity.setTsukiwariEndYM1(賦課情報.get月割終了年月1());
        賦課の情報一時Entity.setHokenryoDankai2(賦課情報.get保険料算定段階2());
        賦課の情報一時Entity.setNengakuHokenryo2(賦課情報.get算定年額保険料2());
        賦課の情報一時Entity.setTsukiwariStartYM2(賦課情報.get月割開始年月2());
        賦課の情報一時Entity.setTsukiwariEndYM2(賦課情報.get月割終了年月2());
        賦課の情報一時Entity.setChoteiNichiji(賦課情報.get調定日時());
        賦課の情報一時Entity.setChoteiJiyu1(賦課情報.get調定事由1());
        賦課の情報一時Entity.setChoteiJiyu2(賦課情報.get調定事由2());
        賦課の情報一時Entity.setChoteiJiyu3(賦課情報.get調定事由3());
        賦課の情報一時Entity.setChoteiJiyu4(賦課情報.get調定事由4());
        賦課の情報一時Entity.setKoseiM(賦課情報.get更正月());
        賦課の情報一時Entity.setGemmenMaeHokenryo(賦課情報.get減免前介護保険料_年額());
        賦課の情報一時Entity.setGemmenGaku(賦課情報.get減免額());
        賦課の情報一時Entity.setKakuteiHokenryo(賦課情報.get確定介護保険料_年額());
        賦課の情報一時Entity.setHokenryoDankaiKarisanntei(賦課情報.get保険料段階_仮算定時());
        賦課の情報一時Entity.setChoshuHohoRirekiNo(賦課情報.get徴収方法履歴番号());
        賦課の情報一時Entity.setIdoKijunNichiji(賦課情報.get異動基準日時());
        賦課の情報一時Entity.setKozaKubun(賦課情報.get口座区分());
        賦課の情報一時Entity.setKyokaisoKubun(賦課情報.get境界層区分());
        賦課の情報一時Entity.setShokkenKubun(賦課情報.get職権区分());
        賦課の情報一時Entity.setFukaShichosonCode(賦課情報.get賦課市町村コード());
        賦課の情報一時Entity.setTkSaishutsuKampuGaku(賦課情報.get特徴歳出還付額());
        賦課の情報一時Entity.setFuSaishutsuKampuGaku(賦課情報.get普徴歳出還付額());
        賦課の情報一時Entity.setTkKibetsuGaku01(特徴期別金額01);
        賦課の情報一時Entity.setTkKibetsuGaku02(特徴期別金額02);
        賦課の情報一時Entity.setTkKibetsuGaku03(特徴期別金額03);
        賦課の情報一時Entity.setTkKibetsuGaku04(Decimal.ZERO);
        賦課の情報一時Entity.setTkKibetsuGaku05(Decimal.ZERO);
        賦課の情報一時Entity.setTkKibetsuGaku06(Decimal.ZERO);
        賦課の情報一時Entity.setFuKibetsuGaku01(Decimal.ZERO);
        賦課の情報一時Entity.setFuKibetsuGaku02(Decimal.ZERO);
        賦課の情報一時Entity.setFuKibetsuGaku03(Decimal.ZERO);
        賦課の情報一時Entity.setFuKibetsuGaku04(Decimal.ZERO);
        賦課の情報一時Entity.setFuKibetsuGaku05(Decimal.ZERO);
        賦課の情報一時Entity.setFuKibetsuGaku06(Decimal.ZERO);
        賦課の情報一時Entity.setFuKibetsuGaku07(Decimal.ZERO);
        賦課の情報一時Entity.setFuKibetsuGaku08(Decimal.ZERO);
        賦課の情報一時Entity.setFuKibetsuGaku09(Decimal.ZERO);
        賦課の情報一時Entity.setFuKibetsuGaku10(Decimal.ZERO);
        賦課の情報一時Entity.setFuKibetsuGaku11(Decimal.ZERO);
        賦課の情報一時Entity.setFuKibetsuGaku12(Decimal.ZERO);
        賦課の情報一時Entity.setFuKibetsuGaku13(Decimal.ZERO);
        賦課の情報一時Entity.setFuKibetsuGaku14(Decimal.ZERO);
        return 賦課の情報一時Entity;
    }

    /**
     * 賦課の情報共通編集
     *
     * @param 調定年度 FlexibleYear
     * @param 調定日時 YMDHMS
     * @param 資格の情報 HihokenshaDaicho
     * @param 徴収方法の情報 ChoshuHoho
     * @param 生保の情報List List<SeikatsuHogoJukyusha>
     * @param 老齢の情報List List<RoreiFukushiNenkinJukyusha>
     * @param 前年度生保開始日 FlexibleDate
     * @param 前年度生保廃止日 FlexibleDate
     * @param 前年度老年開始日 FlexibleDate
     * @param 前年度老年廃止日 FlexibleDate
     * @param 前年度世帯課税区分 RString
     * @param 前年度課税区分 RString
     * @param 前年度合計所得金額 Decimal
     * @param 前年度公的年金収入額 Decimal
     * @param 通知書番号 TsuchishoNo
     * @param 被保険者番号Map Map
     * @return FukaJoho
     */
    public FukaJoho modifyFukaJohoCommon(FlexibleYear 調定年度,
            YMDHMS 調定日時,
            HihokenshaDaicho 資格の情報,
            ChoshuHoho 徴収方法の情報,
            List<SeikatsuHogoJukyusha> 生保の情報List,
            List<RoreiFukushiNenkinJukyusha> 老齢の情報List,
            FlexibleDate 前年度生保開始日,
            FlexibleDate 前年度生保廃止日,
            FlexibleDate 前年度老年開始日,
            FlexibleDate 前年度老年廃止日,
            RString 前年度世帯課税区分,
            RString 前年度課税区分,
            Decimal 前年度合計所得金額,
            Decimal 前年度公的年金収入額,
            TsuchishoNo 通知書番号,
            Map<HihokenshaNo, Integer> 被保険者番号Map) {
        HihokenshaNo 被保険者番号 = 資格の情報.get被保険者番号();
        if (被保険者番号Map.containsKey(被保険者番号)) {
            RString 枝番号 = new RString(String.valueOf(被保険者番号Map.get(被保険者番号) + 整数_1));
            通知書番号 = new TsuchishoNo(文字列_0000.concat(被保険者番号.value()).concat(枝番号.padZeroToLeft(整数_2)));
        } else {
            通知書番号 = new TsuchishoNo(文字列_0000.concat(被保険者番号.value()).concat(文字列_01));
        }
        FukaJoho 賦課情報 = new FukaJoho(調定年度, 調定年度, 通知書番号, 整数_0);
        FukaJohoBuilder 賦課情報Builder = 賦課情報.createBuilderForEdit();
        賦課情報Builder.set資格取得日(資格の情報.get第1号資格取得年月日());
        賦課情報Builder.set資格取得事由(資格の情報.get資格取得事由コード());
        賦課情報Builder.set資格喪失日(資格の情報.get資格喪失年月日());
        賦課情報Builder.set資格喪失事由(資格の情報.get資格喪失事由コード());
        FlexibleDate 調定年度開始日 = new FlexibleDate(調定年度.toDateString().concat(文字列_04).concat(文字列_01));
        FlexibleDate 調定年度廃止日 = new FlexibleDate(調定年度.plusYear(整数_1).toDateString().concat(文字列_03).concat(文字列_31));
        set生保の情報_modifyFukaJohoCommon(生保の情報List, 調定年度開始日, 調定年度廃止日, 賦課情報Builder);
        set老齢の情報_modifyFukaJohoCommon(老齢の情報List, 調定年度開始日, 調定年度廃止日, 賦課情報Builder);
        賦課情報Builder.set賦課期日(FukaKeisan.createInstance().findOut賦課基準日(調定年度, 資格の情報));
        賦課情報Builder.set調定事由1(ChoteiJiyuCode.仮算定賦課.getコード());
        賦課情報Builder.set調定事由2(RString.EMPTY);
        賦課情報Builder.set調定事由3(RString.EMPTY);
        賦課情報Builder.set調定事由4(RString.EMPTY);
        HokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter = new HokenryoDankaiHanteiParameter();
        hokenryoDankaiHanteiParameter.setFukaNendo(調定年度);
        FukaKonkyo fukaKonkyo = new FukaKonkyo();
        fukaKonkyo.setFukakijunYMD(調定年度開始日);
        if (前年度生保開始日.isEmpty()) {
            fukaKonkyo.setSeihoStartYMD(FlexibleDate.EMPTY);
        } else if (前年度生保廃止日.isEmpty() || 調定年度開始日.isBeforeOrEquals(前年度生保廃止日)) {
            fukaKonkyo.setSeihoStartYMD(調定年度開始日);
        } else {
            fukaKonkyo.setSeihoStartYMD(FlexibleDate.EMPTY);
        }
        fukaKonkyo.setSeihoEndYMD(FlexibleDate.EMPTY);
        if (前年度老年開始日.isEmpty()) {
            fukaKonkyo.setRoreiNenkinStartYMD(FlexibleDate.EMPTY);
        } else if (前年度老年廃止日.isEmpty() || 調定年度開始日.isBeforeOrEquals(前年度老年廃止日)) {
            fukaKonkyo.setRoreiNenkinStartYMD(調定年度開始日);
        } else {
            fukaKonkyo.setRoreiNenkinStartYMD(FlexibleDate.EMPTY);
        }
        fukaKonkyo.setRoreiNenkinEndYMD(FlexibleDate.EMPTY);
        List<KazeiKubun> setaiinKazeiKubunList = new ArrayList<>();
        setaiinKazeiKubunList.add(KazeiKubun.toValue(前年度世帯課税区分));
        setaiinKazeiKubunList.add(KazeiKubun.toValue(前年度課税区分));
        fukaKonkyo.setSetaiinKazeiKubunList(setaiinKazeiKubunList);
        fukaKonkyo.setGokeiShotoku(前年度合計所得金額);
        fukaKonkyo.setKotekiNenkinShunyu(前年度公的年金収入額);
        hokenryoDankaiHanteiParameter.setFukaKonkyo(fukaKonkyo);
        SeigyoJoho seigyoJoho = new SeigyoJoho();
        seigyoJoho.setHokenryoDankaiList(HokenryoDankaiSettings.createInstance().getCurrent保険料段階List());
        seigyoJoho.setKijunNenkinShunyu01(new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準年金収入1,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課).toString()));
        seigyoJoho.setKijunNenkinShunyu02(new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準年金収入2,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課).toString()));
        seigyoJoho.setKijunNenkinShunyu03(new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準年金収入3,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課).toString()));
        seigyoJoho.setKijunShotokuKingaku01(new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額1,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課).toString()));
        seigyoJoho.setKijunShotokuKingaku02(new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額2,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課).toString()));
        seigyoJoho.setKijunShotokuKingaku03(new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額3,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課).toString()));
        seigyoJoho.setKijunShotokuKingaku04(new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額4,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課).toString()));
        seigyoJoho.setKijunShotokuKingaku05(new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額5,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課).toString()));
        seigyoJoho.setKijunShotokuKingaku06(new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額6,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課).toString()));
        seigyoJoho.setKijunShotokuKingaku07(new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額7,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課).toString()));
        seigyoJoho.setKijunShotokuKingaku08(new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額8,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課).toString()));
        seigyoJoho.setKijunShotokuKingaku09(new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額9,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課).toString()));
        seigyoJoho.setKijunShotokuKingaku10(new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額10,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課).toString()));
        seigyoJoho.setKijunShotokuKingaku11(new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額11,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課).toString()));
        seigyoJoho.setKijunShotokuKingaku12(new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額12,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課).toString()));
        seigyoJoho.setKijunShotokuKingaku13(new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額13,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課).toString()));
        seigyoJoho.setKijunShotokuKingaku14(new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額14,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課).toString()));
        seigyoJoho.setKijunShotokuKingaku15(new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額15,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課).toString()));
        seigyoJoho.setKazeisouShotokuDankai(DbBusinessConfig.get(ConfigNameDBB.賦課基準_課税層保険料段階インデックス,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課));
        if (保険料段階を使用する.equals(DbBusinessConfig.get(ConfigNameDBB.賦課基準_未申告保険料段階使用,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課))) {
            seigyoJoho.setUsesMishinkokuDankai(true);
        } else {
            seigyoJoho.setUsesMishinkokuDankai(false);
        }
        seigyoJoho.setMishinkokuDankai(DbBusinessConfig.get(ConfigNameDBB.賦課基準_未申告保険料段階インデックス,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課));
        seigyoJoho.setMishinkokuKazeiKubun(KazeiKubun.toValue(DbBusinessConfig.get(ConfigNameDBB.賦課基準_未申告課税区分,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課)));
        if (保険料段階を使用する.equals(DbBusinessConfig.get(ConfigNameDBB.賦課基準_所得調査中保険料段階使用,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課))) {
            seigyoJoho.setUsesShotokuChosachuDankai(true);
        } else {
            seigyoJoho.setUsesShotokuChosachuDankai(false);
        }
        seigyoJoho.setShotokuChosachuDankai(DbBusinessConfig.get(ConfigNameDBB.賦課基準_所得調査中保険料段階インデックス,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課));
        seigyoJoho.setShotokuChosachuKazeiKubun(KazeiKubun.toValue(DbBusinessConfig.get(ConfigNameDBB.賦課基準_所得調査中課税区分,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課)));
        if (保険料段階を使用する.equals(DbBusinessConfig.get(ConfigNameDBB.賦課基準_課税取消保険料段階使用,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課))) {
            seigyoJoho.setUsesKazeiTorikeshiDankai(true);
        } else {
            seigyoJoho.setUsesKazeiTorikeshiDankai(false);
        }
        seigyoJoho.setKazeiTorikeshiDankai(DbBusinessConfig.get(ConfigNameDBB.賦課基準_課税取消保険料段階インデックス,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課));
        seigyoJoho.setKazeiTorikeshiKazeiKubun(KazeiKubun.toValue(DbBusinessConfig.get(ConfigNameDBB.賦課基準_課税取消課税区分,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課)));
        hokenryoDankaiHanteiParameter.setSeigyoJoho(seigyoJoho);
        TsukibetsuHokenryoDankai 月別保険料段階 = new HokenryoDankaiHantei().determine月別保険料段階(hokenryoDankaiHanteiParameter);
        賦課情報Builder.set保険料段階_仮算定時(月別保険料段階.get保険料段階04月().edit表示用保険料段階());
        if (資格の情報.get旧市町村コード() != null && !資格の情報.get旧市町村コード().isEmpty()) {
            賦課情報Builder.set賦課市町村コード(資格の情報.get旧市町村コード());
        } else if (資格の情報.get広住特措置元市町村コード() != null && !資格の情報.get広住特措置元市町村コード().isEmpty()) {
            賦課情報Builder.set賦課市町村コード(資格の情報.get広住特措置元市町村コード());
        } else {
            賦課情報Builder.set賦課市町村コード(資格の情報.get市町村コード());
        }
        賦課情報Builder.set被保険者番号(資格の情報.get被保険者番号());
        賦課情報Builder.set識別コード(資格の情報.get識別コード());
        賦課情報Builder.set調定日時(調定日時);
        賦課情報Builder.set更正月(文字列_04);
        賦課情報Builder.set徴収方法履歴番号(徴収方法の情報.get履歴番号());
        賦課情報Builder.set異動基準日時(調定日時);
        賦課情報Builder.set口座区分(KozaKubun.現金納付.getコード());
        賦課情報Builder.set特徴歳出還付額(Decimal.ZERO);
        賦課情報Builder.set普徴歳出還付額(Decimal.ZERO);
        return 賦課情報Builder.build();
    }

    private void set老齢の情報_modifyFukaJohoCommon(List<RoreiFukushiNenkinJukyusha> 老齢の情報List, FlexibleDate 調定年度開始日,
            FlexibleDate 調定年度廃止日, FukaJohoBuilder 賦課情報Builder) {
        FlexibleDate 最新老齢受給開始年月日 = null;
        RoreiFukushiNenkinJukyusha 最新老齢の情報 = null;
        for (RoreiFukushiNenkinJukyusha 老齢の情報 : 老齢の情報List) {
            if (調定年度開始日.isBeforeOrEquals(老齢の情報.get受給終了年月日()) || 老齢の情報.get受給開始年月日().isBeforeOrEquals(調定年度廃止日)) {
                if (最新老齢受給開始年月日 == null) {
                    最新老齢受給開始年月日 = 老齢の情報.get受給開始年月日();
                    最新老齢の情報 = 老齢の情報;
                } else {
                    if (最新老齢受給開始年月日.isBefore(老齢の情報.get受給開始年月日())) {
                        最新老齢受給開始年月日 = 老齢の情報.get受給開始年月日();
                        最新老齢の情報 = 老齢の情報;
                    }
                }
            }
        }
        if (最新老齢の情報 == null) {
            賦課情報Builder.set老年開始日(FlexibleDate.EMPTY);
            賦課情報Builder.set老年廃止日(FlexibleDate.EMPTY);
        } else {
            賦課情報Builder.set老年開始日(最新老齢の情報.get受給開始年月日());
            賦課情報Builder.set老年廃止日(最新老齢の情報.get受給終了年月日());
        }
    }

    private void set生保の情報_modifyFukaJohoCommon(List<SeikatsuHogoJukyusha> 生保の情報List, FlexibleDate 調定年度開始日,
            FlexibleDate 調定年度廃止日, FukaJohoBuilder 賦課情報Builder) {
        FlexibleDate 最新受給開始日 = null;
        SeikatsuHogoJukyusha 最新生保の情報 = null;
        for (SeikatsuHogoJukyusha 生保の情報 : 生保の情報List) {
            if (調定年度開始日.isBeforeOrEquals(生保の情報.get受給廃止日()) || 生保の情報.get受給開始日().isBeforeOrEquals(調定年度廃止日)) {
                if (最新受給開始日 == null) {
                    最新受給開始日 = 生保の情報.get受給廃止日();
                    最新生保の情報 = 生保の情報;
                } else {
                    if (最新受給開始日.isBefore(生保の情報.get受給廃止日())) {
                        最新受給開始日 = 生保の情報.get受給廃止日();
                        最新生保の情報 = 生保の情報;
                    }
                }
            }
        }
        if (最新生保の情報 == null) {
            賦課情報Builder.set生活保護扶助種類(RString.EMPTY);
            賦課情報Builder.set生保開始日(FlexibleDate.EMPTY);
            賦課情報Builder.set生保廃止日(FlexibleDate.EMPTY);
        } else {
//            List<SeikatsuHogoFujoShurui> 生活保護扶助種類情報List = 最新生保の情報.getSeikatsuHogoFujoShuruiList();
//            FujoShuruiCodeValue min扶助種類コード = 生活保護扶助種類情報List.get(整数_0).get扶助種類コード();
//            for (SeikatsuHogoFujoShurui seikatsuHogoFujoShurui : 生活保護扶助種類情報List) {
//                int 扶助種類コード = Integer.valueOf(seikatsuHogoFujoShurui.get扶助種類コード().value().toString());
//                if (扶助種類コード < Integer.valueOf(min扶助種類コード.value().toString())) {
//                    min扶助種類コード = seikatsuHogoFujoShurui.get扶助種類コード();
//                }
//            }
//            賦課情報Builder.set生活保護扶助種類(min扶助種類コード.value().value());
            賦課情報Builder.set生保開始日(最新生保の情報.get受給開始日());
            賦課情報Builder.set生保廃止日(最新生保の情報.get受給廃止日());
        }
    }

    /**
     * 特徴仮算定結果一覧表出力
     *
     * @param 調定年度 FlexibleYear
     * @param 賦課年度 FlexibleYear
     * @param 調定日時 YMDHMS
     * @param 出力順ID RString
     */
    public void spoolTokuchoKarisanteiKekkaIchiran(FlexibleYear 調定年度, FlexibleYear 賦課年度, YMDHMS 調定日時, final RString 出力順ID) {
        ITokuchoKariSanteiFukaMapper mapper = mProvider.create(ITokuchoKariSanteiFukaMapper.class);
        RString 出力順 = get出力順(特別徴収仮算定結果一覧表_帳票分類ID, 出力順ID);
        Map<String, Object> parameter = new HashMap<>();
        parameter.put(キー_調定年度.toString(), 調定年度);
        parameter.put(キー_調定年度_1.toString(), 調定年度.minusYear(整数_1));
        parameter.put(キー_賦課年度.toString(), 賦課年度);
        parameter.put(キー_調定日時.toString(), 調定日時);
        parameter.put(キー_出力順.toString(), 出力順);
        List<TokuchoKarisanteiKekkaIchiranEntity> 特徴仮算定結果情報List = mapper.select特徴仮算定結果情報(parameter);
        List<TokuchoKariKeisangoFukaEntity> 特徴仮算定計算後賦課情報EntityList = new ArrayList<>();
        for (TokuchoKarisanteiKekkaIchiranEntity 特徴仮算定結果情報 : 特徴仮算定結果情報List) {
            TokuchoKariKeisangoFukaEntity entity = new TokuchoKariKeisangoFukaEntity();
            set特徴仮算定結果情報(entity, 特徴仮算定結果情報);
            特徴仮算定計算後賦課情報EntityList.add(entity);
        }
        List<TokuchoKarisanteiKekkaIchiranTeisiEntity> 特徴仮算定計算後賦課情報_特徴停止List = mapper.select特徴仮算定計算後賦課情報_特徴停止(parameter);
        for (TokuchoKarisanteiKekkaIchiranTeisiEntity 特徴仮算定計算後賦課情報_特徴停止 : 特徴仮算定計算後賦課情報_特徴停止List) {
            TokuchoKariKeisangoFukaEntity entity = new TokuchoKariKeisangoFukaEntity();
            set特徴仮算定計算後賦課情報_特徴停止(entity, 特徴仮算定計算後賦課情報_特徴停止);
            特徴仮算定計算後賦課情報EntityList.add(entity);
        }
        Collections.sort(特徴仮算定計算後賦課情報EntityList, new Comparator<TokuchoKariKeisangoFukaEntity>() {
            @Override
            public int compare(TokuchoKariKeisangoFukaEntity o1, TokuchoKariKeisangoFukaEntity o2) {
                IOutputOrder 並び順 = ChohyoShutsuryokujunFinderFactory.createInstance()
                        .get出力順(SubGyomuCode.DBB介護賦課, 特別徴収仮算定結果一覧表_帳票分類ID, Long.parseLong(出力順ID.toString()));
                List<RString> 並び順List = new ArrayList<>();
                List<SortOrder> 昇降順List = new ArrayList<>();
                for (int i = 整数_0; i < 整数_5; i++) {
                    if (i < 並び順.get設定項目リスト().size()) {
                        並び順List.add(並び順.get設定項目リスト().get(i).get項目名());
                        昇降順List.add(並び順.get設定項目リスト().get(i).get昇降順());
                    } else {
                        break;
                    }
                }
                int flag = 整数_0;
                if (並び順List.size() > 整数_0) {
                    flag = getソート(o1, o2, 並び順List.get(整数_0), 昇降順List.get(整数_0));
                }
                if (整数_0 == flag && 並び順List.size() > 整数_1) {
                    flag = getソート(o1, o2, 並び順List.get(整数_1), 昇降順List.get(整数_1));
                }
                if (整数_0 == flag && 並び順List.size() > 整数_2) {
                    flag = getソート(o1, o2, 並び順List.get(整数_2), 昇降順List.get(整数_2));
                }
                if (整数_0 == flag && 並び順List.size() > 整数_3) {
                    flag = getソート(o1, o2, 並び順List.get(整数_3), 昇降順List.get(整数_3));
                }
                if (整数_0 == flag && 並び順List.size() > 整数_4) {
                    flag = getソート(o1, o2, 並び順List.get(整数_4), 昇降順List.get(整数_4));
                }
                return flag;
            }
        });
        SourceDataCollection sourceDataCollection = new TokubetsuChoshuKarisanteiKekkaIchiranPrintService().printSingle(
                特徴仮算定計算後賦課情報EntityList, Long.parseLong(出力順ID.toString()), 調定年度, 調定日時);
        TokuchoKariSanteiFukaManager.createInstance().publish特別徴収開始通知書発行一覧表(特徴仮算定計算後賦課情報EntityList, 調定日時);
        RString 出力ページ数 = new RString(sourceDataCollection.iterator().next().getPageCount());
        loadバッチ出力条件リスト(調定年度, 賦課年度, Long.parseLong(出力順ID.toString()), 出力ページ数);
    }

    private void set特徴仮算定計算後賦課情報_特徴停止(TokuchoKariKeisangoFukaEntity entity,
            TokuchoKarisanteiKekkaIchiranTeisiEntity 特徴仮算定計算後賦課情報_特徴停止) {
        entity.set調定年度(FlexibleYear.EMPTY);
        entity.set賦課年度(FlexibleYear.EMPTY);
        entity.set通知書番号(特徴仮算定計算後賦課情報_特徴停止.get賦課Newest().getTsuchishoNo());
        entity.set更正前後区分(RString.EMPTY);
        entity.set作成処理名(RString.EMPTY);
        entity.set賦課履歴番号(特徴仮算定計算後賦課情報_特徴停止.get賦課Newest().getRirekiNo());
        entity.set被保険者番号(特徴仮算定計算後賦課情報_特徴停止.get賦課Newest().getHihokenshaNo());
        entity.set識別コード(特徴仮算定計算後賦課情報_特徴停止.get賦課Newest().getShikibetsuCode());
        entity.set世帯コード(SetaiCode.EMPTY);
        entity.set世帯員数(整数_0);
        entity.set資格取得日(FlexibleDate.EMPTY);
        entity.set資格取得事由(RString.EMPTY);
        entity.set資格喪失日(FlexibleDate.EMPTY);
        entity.set資格喪失事由(RString.EMPTY);
        entity.set生活保護扶助種類(RString.EMPTY);
        entity.set生保開始日(FlexibleDate.EMPTY);
        entity.set生保廃止日(FlexibleDate.EMPTY);
        entity.set老齢開始日(FlexibleDate.EMPTY);
        entity.set老齢廃止日(FlexibleDate.EMPTY);
        entity.set賦課期日(FlexibleDate.EMPTY);
        entity.set課税区分(RString.EMPTY);
        entity.set世帯課税区分(RString.EMPTY);
        entity.set合計所得金額(Decimal.ZERO);
        entity.set公的年金収入額(Decimal.ZERO);
        entity.set保険料段階(RString.EMPTY);
        entity.set保険料算定段階1(RString.EMPTY);
        entity.set算定年額保険料1(Decimal.ZERO);
        entity.set月割開始年月1(FlexibleYearMonth.EMPTY);
        entity.set月割終了年月1(FlexibleYearMonth.EMPTY);
        entity.set保険料算定段階2(RString.EMPTY);
        entity.set算定年額保険料2(Decimal.ZERO);
        entity.set月割開始年月2(FlexibleYearMonth.EMPTY);
        entity.set月割終了年月2(FlexibleYearMonth.EMPTY);
        entity.set調定日時(特徴仮算定計算後賦課情報_特徴停止.get賦課Newest().getChoteiNichiji());
        entity.set調定事由1(RString.EMPTY);
        entity.set調定事由2(RString.EMPTY);
        entity.set調定事由3(RString.EMPTY);
        entity.set調定事由4(RString.EMPTY);
        entity.set更正月(RString.EMPTY);
        entity.set減免前介護保険料_年額(Decimal.ZERO);
        entity.set減免額(Decimal.ZERO);
        entity.set確定介護保険料_年額(Decimal.ZERO);
        entity.set保険料段階_仮算定時(RString.EMPTY);
        entity.set徴収方法履歴番号(整数_0);
        entity.set異動基準日時(特徴仮算定計算後賦課情報_特徴停止.get賦課Newest().getIdoKijunNichiji());
        entity.set口座区分(RString.EMPTY);
        entity.set境界層区分(RString.EMPTY);
        entity.set職権区分(RString.EMPTY);
        entity.set賦課市町村コード(LasdecCode.EMPTY);
        entity.set特徴歳出還付額(Decimal.ZERO);
        entity.set普徴歳出還付額(Decimal.ZERO);
        entity.set特徴期期別金額01(Decimal.ZERO);
        entity.set特徴期期別金額02(Decimal.ZERO);
        entity.set特徴期期別金額03(Decimal.ZERO);
        entity.set特徴期期別金額04(Decimal.ZERO);
        entity.set特徴期期別金額05(Decimal.ZERO);
        entity.set特徴期期別金額06(Decimal.ZERO);
        entity.set普徴期期別金額01(Decimal.ZERO);
        entity.set普徴期期別金額02(Decimal.ZERO);
        entity.set普徴期期別金額03(Decimal.ZERO);
        entity.set普徴期期別金額04(Decimal.ZERO);
        entity.set普徴期期別金額05(Decimal.ZERO);
        entity.set普徴期期別金額06(Decimal.ZERO);
        entity.set普徴期期別金額07(Decimal.ZERO);
        entity.set普徴期期別金額08(Decimal.ZERO);
        entity.set普徴期期別金額09(Decimal.ZERO);
        entity.set普徴期期別金額10(Decimal.ZERO);
        entity.set普徴期期別金額11(Decimal.ZERO);
        entity.set普徴期期別金額12(Decimal.ZERO);
        entity.set普徴期期別金額13(Decimal.ZERO);
        entity.set普徴期期別金額14(Decimal.ZERO);
        entity.set徴収方法4月(RString.EMPTY);
        entity.set徴収方法5月(RString.EMPTY);
        entity.set徴収方法6月(RString.EMPTY);
        entity.set徴収方法7月(RString.EMPTY);
        entity.set徴収方法8月(RString.EMPTY);
        entity.set徴収方法9月(RString.EMPTY);
        entity.set徴収方法10月(RString.EMPTY);
        entity.set徴収方法11月(RString.EMPTY);
        entity.set徴収方法12月(RString.EMPTY);
        entity.set徴収方法1月(RString.EMPTY);
        entity.set徴収方法2月(RString.EMPTY);
        entity.set徴収方法3月(RString.EMPTY);
        entity.set徴収方法翌4月(RString.EMPTY);
        entity.set徴収方法翌5月(RString.EMPTY);
        entity.set徴収方法翌6月(RString.EMPTY);
        entity.set徴収方法翌7月(RString.EMPTY);
        entity.set徴収方法翌8月(RString.EMPTY);
        entity.set徴収方法翌9月(RString.EMPTY);
        entity.set仮徴収_基礎年金番号(RString.EMPTY);
        entity.set仮徴収_年金コード(RString.EMPTY);
        entity.set仮徴収_捕捉月(RString.EMPTY);
        entity.set本徴収_基礎年金番号(RString.EMPTY);
        entity.set本徴収_年金コード(RString.EMPTY);
        entity.set本徴収_捕捉月(RString.EMPTY);
        entity.set翌年度仮徴収_基礎年金番号(特徴仮算定計算後賦課情報_特徴停止.get徴収方法Newest().getHonNenkinNo());
        entity.set翌年度仮徴収_年金コード(特徴仮算定計算後賦課情報_特徴停止.get徴収方法Newest().getHonNenkinCode());
        entity.set翌年度仮徴収_捕捉月(特徴仮算定計算後賦課情報_特徴停止.get徴収方法Newest().getHonHosokuM());
        entity.set依頼情報送付済みフラグ(false);
        entity.set追加依頼情報送付済みフラグ(false);
        entity.set特別徴収停止日時(特徴仮算定計算後賦課情報_特徴停止.get徴収方法Newest().getTokuchoTeishiNichiji());
        entity.set特別徴収停止事由コード(特徴仮算定計算後賦課情報_特徴停止.get徴収方法Newest().getTokuchoTeishiJiyuCode());
        entity.set特徴収入額01(Decimal.ZERO);
        entity.set特徴収入額02(Decimal.ZERO);
        entity.set特徴収入額03(Decimal.ZERO);
        entity.set特徴収入額04(Decimal.ZERO);
        entity.set特徴収入額05(Decimal.ZERO);
        entity.set特徴収入額06(Decimal.ZERO);
        entity.set普徴収入額01(Decimal.ZERO);
        entity.set普徴収入額02(Decimal.ZERO);
        entity.set普徴収入額03(Decimal.ZERO);
        entity.set普徴収入額04(Decimal.ZERO);
        entity.set普徴収入額05(Decimal.ZERO);
        entity.set普徴収入額06(Decimal.ZERO);
        entity.set普徴収入額07(Decimal.ZERO);
        entity.set普徴収入額08(Decimal.ZERO);
        entity.set普徴収入額09(Decimal.ZERO);
        entity.set普徴収入額10(Decimal.ZERO);
        entity.set普徴収入額11(Decimal.ZERO);
        entity.set普徴収入額12(Decimal.ZERO);
        entity.set普徴収入額13(Decimal.ZERO);
        entity.set普徴収入額14(Decimal.ZERO);
        entity.set宛名(特徴仮算定計算後賦課情報_特徴停止.get宛名());
        if (特徴仮算定計算後賦課情報_特徴停止.get賦課Newest().getHokenryoDankai2() != null) {
            entity.set前年度保険料段階(特徴仮算定計算後賦課情報_特徴停止.get賦課Newest().getHokenryoDankai2());
        } else {
            entity.set前年度保険料段階(特徴仮算定計算後賦課情報_特徴停止.get賦課Newest().getHokenryoDankai1());
        }
        entity.set前年度保険料(特徴仮算定計算後賦課情報_特徴停止.get賦課Newest().getKakuteiHokenryo());
    }

    private void set特徴仮算定結果情報(TokuchoKariKeisangoFukaEntity entity, TokuchoKarisanteiKekkaIchiranEntity 特徴仮算定結果情報) {
        entity.set調定年度(特徴仮算定結果情報.get計算後情報().getChoteiNendo());
        entity.set賦課年度(特徴仮算定結果情報.get計算後情報().getFukaNendo());
        entity.set通知書番号(特徴仮算定結果情報.get計算後情報().getTsuchishoNo());
        entity.set更正前後区分(特徴仮算定結果情報.get計算後情報().getKoseiZengoKubun());
        entity.set作成処理名(特徴仮算定結果情報.get計算後情報().getSakuseiShoriName());
        entity.set賦課履歴番号(特徴仮算定結果情報.get計算後情報().getFukaRirekiNo());
        entity.set被保険者番号(特徴仮算定結果情報.get計算後情報().getHihokenshaNo());
        entity.set識別コード(特徴仮算定結果情報.get計算後情報().getShikibetsuCode());
        entity.set世帯コード(特徴仮算定結果情報.get計算後情報().getSetaiCode());
        entity.set世帯員数(特徴仮算定結果情報.get計算後情報().getSetaiInsu());
        entity.set資格取得日(特徴仮算定結果情報.get計算後情報().getShikakuShutokuYMD());
        entity.set資格取得事由(特徴仮算定結果情報.get計算後情報().getShikakuShutokuJiyu());
        entity.set資格喪失日(特徴仮算定結果情報.get計算後情報().getShikakuSoshitsuYMD());
        entity.set資格喪失事由(特徴仮算定結果情報.get計算後情報().getShikakuSoshitsuJiyu());
        entity.set生活保護扶助種類(特徴仮算定結果情報.get計算後情報().getSeihofujoShurui());
        entity.set生保開始日(特徴仮算定結果情報.get計算後情報().getSeihoKaishiYMD());
        entity.set生保廃止日(特徴仮算定結果情報.get計算後情報().getSeihoHaishiYMD());
        entity.set老齢開始日(特徴仮算定結果情報.get計算後情報().getRonenKaishiYMD());
        entity.set老齢廃止日(特徴仮算定結果情報.get計算後情報().getRonenHaishiYMD());
        entity.set賦課期日(特徴仮算定結果情報.get計算後情報().getFukaYMD());
        entity.set課税区分(特徴仮算定結果情報.get計算後情報().getKazeiKubun());
        entity.set世帯課税区分(特徴仮算定結果情報.get計算後情報().getSetaikazeiKubun());
        entity.set合計所得金額(特徴仮算定結果情報.get計算後情報().getGokeiShotokuGaku());
        entity.set公的年金収入額(特徴仮算定結果情報.get計算後情報().getNenkinShunyuGaku());
        entity.set保険料段階(特徴仮算定結果情報.get計算後情報().getHokenryoDankai());
        entity.set保険料算定段階1(特徴仮算定結果情報.get計算後情報().getHokenryoDankai1());
        entity.set算定年額保険料1(特徴仮算定結果情報.get計算後情報().getNengakuHokenryo1());
        entity.set月割開始年月1(特徴仮算定結果情報.get計算後情報().getTsukiwariStartYM1());
        entity.set月割終了年月1(特徴仮算定結果情報.get計算後情報().getTsukiwariEndYM1());
        entity.set保険料算定段階2(特徴仮算定結果情報.get計算後情報().getHokenryoDankai2());
        entity.set算定年額保険料2(特徴仮算定結果情報.get計算後情報().getNengakuHokenryo2());
        entity.set月割開始年月2(特徴仮算定結果情報.get計算後情報().getTsukiwariStartYM2());
        entity.set月割終了年月2(特徴仮算定結果情報.get計算後情報().getTsukiwariEndYM2());
        entity.set調定日時(特徴仮算定結果情報.get計算後情報().getChoteiNichiji());
        entity.set調定事由1(特徴仮算定結果情報.get計算後情報().getChoteiJiyu1());
        entity.set調定事由2(特徴仮算定結果情報.get計算後情報().getChoteiJiyu2());
        entity.set調定事由3(特徴仮算定結果情報.get計算後情報().getChoteiJiyu3());
        entity.set調定事由4(特徴仮算定結果情報.get計算後情報().getChoteiJiyu4());
        entity.set更正月(特徴仮算定結果情報.get計算後情報().getKoseiM());
        entity.set減免前介護保険料_年額(特徴仮算定結果情報.get計算後情報().getGemmenMaeHokenryo());
        entity.set減免額(特徴仮算定結果情報.get計算後情報().getGemmenGaku());
        entity.set確定介護保険料_年額(特徴仮算定結果情報.get計算後情報().getKakuteiHokenryo());
        entity.set保険料段階_仮算定時(特徴仮算定結果情報.get計算後情報().getHokenryoDankaiKarisanntei());
        entity.set徴収方法履歴番号(特徴仮算定結果情報.get計算後情報().getChoshuHohoRirekiNo());
        entity.set異動基準日時(特徴仮算定結果情報.get計算後情報().getIdoKijunNichiji());
        entity.set口座区分(特徴仮算定結果情報.get計算後情報().getKozaKubun());
        entity.set境界層区分(特徴仮算定結果情報.get計算後情報().getKyokaisoKubun());
        entity.set職権区分(特徴仮算定結果情報.get計算後情報().getShokkenKubun());
        entity.set賦課市町村コード(特徴仮算定結果情報.get計算後情報().getFukaShichosonCode());
        entity.set特徴歳出還付額(特徴仮算定結果情報.get計算後情報().getTkSaishutsuKampuGaku());
        entity.set普徴歳出還付額(特徴仮算定結果情報.get計算後情報().getFuSaishutsuKampuGaku());
        entity.set特徴期期別金額01(特徴仮算定結果情報.get計算後情報().getTkKibetsuGaku01());
        entity.set特徴期期別金額02(特徴仮算定結果情報.get計算後情報().getTkKibetsuGaku02());
        entity.set特徴期期別金額03(特徴仮算定結果情報.get計算後情報().getTkKibetsuGaku03());
        entity.set特徴期期別金額04(特徴仮算定結果情報.get計算後情報().getTkKibetsuGaku04());
        entity.set特徴期期別金額05(特徴仮算定結果情報.get計算後情報().getTkKibetsuGaku05());
        entity.set特徴期期別金額06(特徴仮算定結果情報.get計算後情報().getTkKibetsuGaku06());
        entity.set普徴期期別金額01(特徴仮算定結果情報.get計算後情報().getFuKibetsuGaku01());
        entity.set普徴期期別金額02(特徴仮算定結果情報.get計算後情報().getFuKibetsuGaku02());
        entity.set普徴期期別金額03(特徴仮算定結果情報.get計算後情報().getFuKibetsuGaku03());
        entity.set普徴期期別金額04(特徴仮算定結果情報.get計算後情報().getFuKibetsuGaku04());
        entity.set普徴期期別金額05(特徴仮算定結果情報.get計算後情報().getFuKibetsuGaku05());
        entity.set普徴期期別金額06(特徴仮算定結果情報.get計算後情報().getFuKibetsuGaku06());
        entity.set普徴期期別金額07(特徴仮算定結果情報.get計算後情報().getFuKibetsuGaku07());
        entity.set普徴期期別金額08(特徴仮算定結果情報.get計算後情報().getFuKibetsuGaku08());
        entity.set普徴期期別金額09(特徴仮算定結果情報.get計算後情報().getFuKibetsuGaku09());
        entity.set普徴期期別金額10(特徴仮算定結果情報.get計算後情報().getFuKibetsuGaku10());
        entity.set普徴期期別金額11(特徴仮算定結果情報.get計算後情報().getFuKibetsuGaku11());
        entity.set普徴期期別金額12(特徴仮算定結果情報.get計算後情報().getFuKibetsuGaku12());
        entity.set普徴期期別金額13(特徴仮算定結果情報.get計算後情報().getFuKibetsuGaku13());
        entity.set普徴期期別金額14(特徴仮算定結果情報.get計算後情報().getFuKibetsuGaku14());
        entity.set徴収方法4月(特徴仮算定結果情報.get計算後情報().getChoshuHoho4gatsu());
        entity.set徴収方法5月(特徴仮算定結果情報.get計算後情報().getChoshuHoho5gatsu());
        entity.set徴収方法6月(特徴仮算定結果情報.get計算後情報().getChoshuHoho6gatsu());
        entity.set徴収方法7月(特徴仮算定結果情報.get計算後情報().getChoshuHoho7gatsu());
        entity.set徴収方法8月(特徴仮算定結果情報.get計算後情報().getChoshuHoho8gatsu());
        entity.set徴収方法9月(特徴仮算定結果情報.get計算後情報().getChoshuHoho9gatsu());
        entity.set徴収方法10月(特徴仮算定結果情報.get計算後情報().getChoshuHoho10gatsu());
        entity.set徴収方法11月(特徴仮算定結果情報.get計算後情報().getChoshuHoho11gatsu());
        entity.set徴収方法12月(特徴仮算定結果情報.get計算後情報().getChoshuHoho12gatsu());
        entity.set徴収方法1月(特徴仮算定結果情報.get計算後情報().getChoshuHoho1gatsu());
        entity.set徴収方法2月(特徴仮算定結果情報.get計算後情報().getChoshuHoho2gatsu());
        entity.set徴収方法3月(特徴仮算定結果情報.get計算後情報().getChoshuHoho3gatsu());
        entity.set徴収方法翌4月(特徴仮算定結果情報.get計算後情報().getChoshuHohoYoku4gatsu());
        entity.set徴収方法翌5月(特徴仮算定結果情報.get計算後情報().getChoshuHohoYoku5gatsu());
        entity.set徴収方法翌6月(特徴仮算定結果情報.get計算後情報().getChoshuHohoYoku6gatsu());
        entity.set徴収方法翌7月(特徴仮算定結果情報.get計算後情報().getChoshuHohoYoku7gatsu());
        entity.set徴収方法翌8月(特徴仮算定結果情報.get計算後情報().getChoshuHohoYoku8gatsu());
        entity.set徴収方法翌9月(特徴仮算定結果情報.get計算後情報().getChoshuHohoYoku9gatsu());
        entity.set仮徴収_基礎年金番号(特徴仮算定結果情報.get計算後情報().getKariNenkinNo());
        entity.set仮徴収_年金コード(特徴仮算定結果情報.get計算後情報().getKariNenkinCode());
        entity.set仮徴収_捕捉月(特徴仮算定結果情報.get計算後情報().getKariHosokuM());
        entity.set本徴収_基礎年金番号(特徴仮算定結果情報.get計算後情報().getHonNenkinNo());
        entity.set本徴収_年金コード(特徴仮算定結果情報.get計算後情報().getHonNenkinCode());
        entity.set本徴収_捕捉月(特徴仮算定結果情報.get計算後情報().getHonHosokuM());
        entity.set翌年度仮徴収_基礎年金番号(特徴仮算定結果情報.get計算後情報().getYokunendoKariNenkinNo());
        entity.set翌年度仮徴収_年金コード(特徴仮算定結果情報.get計算後情報().getYokunendoKariNenkinCode());
        entity.set翌年度仮徴収_捕捉月(特徴仮算定結果情報.get計算後情報().getYokunendoKariHosokuM());
        entity.set依頼情報送付済みフラグ(特徴仮算定結果情報.get計算後情報().getIraiSohuzumiFlag());
        entity.set追加依頼情報送付済みフラグ(特徴仮算定結果情報.get計算後情報().getTsuikaIraiSohuzumiFlag());
        entity.set特別徴収停止日時(特徴仮算定結果情報.get計算後情報().getTokuchoTeishiNichiji());
        entity.set特別徴収停止事由コード(特徴仮算定結果情報.get計算後情報().getTokuchoTeishiJiyuCode());
        entity.set特徴収入額01(特徴仮算定結果情報.get計算後情報().getTkShunyuGaku01());
        entity.set特徴収入額02(特徴仮算定結果情報.get計算後情報().getTkShunyuGaku02());
        entity.set特徴収入額03(特徴仮算定結果情報.get計算後情報().getTkShunyuGaku03());
        entity.set特徴収入額04(特徴仮算定結果情報.get計算後情報().getTkShunyuGaku04());
        entity.set特徴収入額05(特徴仮算定結果情報.get計算後情報().getTkShunyuGaku05());
        entity.set特徴収入額06(特徴仮算定結果情報.get計算後情報().getTkShunyuGaku06());
        entity.set普徴収入額01(特徴仮算定結果情報.get計算後情報().getFuShunyuGaku01());
        entity.set普徴収入額02(特徴仮算定結果情報.get計算後情報().getFuShunyuGaku02());
        entity.set普徴収入額03(特徴仮算定結果情報.get計算後情報().getFuShunyuGaku03());
        entity.set普徴収入額04(特徴仮算定結果情報.get計算後情報().getFuShunyuGaku04());
        entity.set普徴収入額05(特徴仮算定結果情報.get計算後情報().getFuShunyuGaku05());
        entity.set普徴収入額06(特徴仮算定結果情報.get計算後情報().getFuShunyuGaku06());
        entity.set普徴収入額07(特徴仮算定結果情報.get計算後情報().getFuShunyuGaku07());
        entity.set普徴収入額08(特徴仮算定結果情報.get計算後情報().getFuShunyuGaku08());
        entity.set普徴収入額09(特徴仮算定結果情報.get計算後情報().getFuShunyuGaku09());
        entity.set普徴収入額10(特徴仮算定結果情報.get計算後情報().getFuShunyuGaku10());
        entity.set普徴収入額11(特徴仮算定結果情報.get計算後情報().getFuShunyuGaku11());
        entity.set普徴収入額12(特徴仮算定結果情報.get計算後情報().getFuShunyuGaku12());
        entity.set普徴収入額13(特徴仮算定結果情報.get計算後情報().getFuShunyuGaku13());
        entity.set普徴収入額14(特徴仮算定結果情報.get計算後情報().getFuShunyuGaku14());
        entity.set宛名(特徴仮算定結果情報.get宛名());
        entity.set前年度保険料段階(特徴仮算定結果情報.get前年度保険料段階());
        entity.set前年度保険料(特徴仮算定結果情報.get確定介護保険料_年額());
        entity.set特別徴収義務者コード(特徴仮算定結果情報.get特別徴収業務者コード());
    }

    private int getソート(TokuchoKariKeisangoFukaEntity o1, TokuchoKariKeisangoFukaEntity o2, RString 項目名, SortOrder 昇降順) {
        if (TokubetsuChoshuKarisanteiKekkaIchiranProperty.TokuchoKarisanteiFukaEnum.郵便番号.getフォームフィールド名().equals(項目名)) {
            YubinNo 郵便番号2 = o2.get宛名().getYubinNo();
            YubinNo 郵便番号1 = o1.get宛名().getYubinNo();
            if (isNull郵便番号(郵便番号2, 郵便番号1)) {
                return 昇降順_郵便番号(昇降順, 郵便番号1, 郵便番号2);
            }
        } else if (TokubetsuChoshuKarisanteiKekkaIchiranProperty.TokuchoKarisanteiFukaEnum.町域コード.getフォームフィールド名().equals(項目名)) {
            ChoikiCode 町域コード2 = o2.get宛名().getChoikiCode();
            ChoikiCode 町域コード1 = o1.get宛名().getChoikiCode();
            if (町域コード2 != null && 町域コード1 != null) {
                return 昇降順_町域コード(昇降順, 町域コード1, 町域コード2);
            }
        } else if (TokubetsuChoshuKarisanteiKekkaIchiranProperty.TokuchoKarisanteiFukaEnum.行政区コード.getフォームフィールド名().equals(項目名)) {
            GyoseikuCode 行政区コード2 = o2.get宛名().getGyoseikuCode();
            GyoseikuCode 行政区コード1 = o1.get宛名().getGyoseikuCode();
            if (行政区コード2 != null && 行政区コード1 != null) {
                return 昇降順_行政区コード(昇降順, 行政区コード1, 行政区コード2);
            }
        } else if (TokubetsuChoshuKarisanteiKekkaIchiranProperty.TokuchoKarisanteiFukaEnum.世帯コード.getフォームフィールド名().equals(項目名)) {
            return 昇降順_世帯コード(昇降順, o1, o2);
        } else if (TokubetsuChoshuKarisanteiKekkaIchiranProperty.TokuchoKarisanteiFukaEnum.識別コード.getフォームフィールド名().equals(項目名)) {
            return 昇降順_識別コード(昇降順, o1, o2);
        } else if (TokubetsuChoshuKarisanteiKekkaIchiranProperty.TokuchoKarisanteiFukaEnum.生年月日.getフォームフィールド名().equals(項目名)) {
            FlexibleDate 生年月日2 = o2.get宛名().getSeinengappiYMD();
            FlexibleDate 生年月日1 = o1.get宛名().getSeinengappiYMD();
            if (生年月日2 != null && 生年月日1 != null) {
                return 昇降順_生年月日(昇降順, 生年月日1, 生年月日2);
            }
        } else if (TokubetsuChoshuKarisanteiKekkaIchiranProperty.TokuchoKarisanteiFukaEnum.性別.getフォームフィールド名().equals(項目名)) {
            RString 性別2 = o2.get宛名().getSeibetsuCode();
            RString 性別1 = o1.get宛名().getSeibetsuCode();
            if (性別2 != null && 性別1 != null) {
                return 昇降順_性別(昇降順, 性別1, 性別2);
            }
        } else if (TokubetsuChoshuKarisanteiKekkaIchiranProperty.TokuchoKarisanteiFukaEnum.通知書番号.getフォームフィールド名().equals(項目名)
                && SortOrder.ASCENDING.equals(昇降順)) {
            return o1.get通知書番号().compareTo(o2.get通知書番号());
        }
        return o2.get通知書番号().compareTo(o1.get通知書番号());
    }

    private boolean isNull郵便番号(YubinNo 郵便番号2, YubinNo 郵便番号1) {
        return 郵便番号2 != null && 郵便番号1 != null;
    }

    private int 昇降順_性別(SortOrder 昇降順, RString 性別1, RString 性別2) {
        if (SortOrder.ASCENDING.equals(昇降順)) {
            return 性別1.compareTo(性別2);
        }
        return 性別2.compareTo(性別1);
    }

    private int 昇降順_生年月日(SortOrder 昇降順, FlexibleDate 生年月日1, FlexibleDate 生年月日2) {
        if (SortOrder.ASCENDING.equals(昇降順)) {
            return 生年月日1.compareTo(生年月日2);
        }
        return 生年月日2.compareTo(生年月日1);
    }

    private int 昇降順_識別コード(SortOrder 昇降順, TokuchoKariKeisangoFukaEntity o1, TokuchoKariKeisangoFukaEntity o2) {
        if (SortOrder.ASCENDING.equals(昇降順)) {
            return o1.get識別コード().compareTo(o2.get識別コード());
        }
        return o2.get識別コード().compareTo(o1.get識別コード());
    }

    private int 昇降順_世帯コード(SortOrder 昇降順, TokuchoKariKeisangoFukaEntity o1, TokuchoKariKeisangoFukaEntity o2) {
        if (SortOrder.ASCENDING.equals(昇降順)) {
            return o1.get世帯コード().compareTo(o2.get世帯コード());
        }
        return o2.get世帯コード().compareTo(o1.get世帯コード());
    }

    private int 昇降順_行政区コード(SortOrder 昇降順, GyoseikuCode 行政区コード1, GyoseikuCode 行政区コード2) {
        if (SortOrder.ASCENDING.equals(昇降順)) {
            return 行政区コード1.compareTo(行政区コード2);
        }
        return 行政区コード2.compareTo(行政区コード1);
    }

    private int 昇降順_町域コード(SortOrder 昇降順, ChoikiCode 町域コード1, ChoikiCode 町域コード2) {
        if (SortOrder.ASCENDING.equals(昇降順)) {
            return 町域コード1.compareTo(町域コード2);
        }
        return 町域コード2.compareTo(町域コード1);
    }

    private int 昇降順_郵便番号(SortOrder 昇降順, YubinNo 郵便番号1, YubinNo 郵便番号2) {
        if (SortOrder.ASCENDING.equals(昇降順)) {
            return 郵便番号1.compareTo(郵便番号2);
        }
        return 郵便番号2.compareTo(郵便番号1);
    }

    private void loadバッチ出力条件リスト(FlexibleYear 調定年度, FlexibleYear 賦課年度, long 出力順ID, RString 出力ページ数) {
        List<RString> 出力条件リスト = new ArrayList<>();
        出力条件リスト.add(定数_出力条件);
        RStringBuilder builder = new RStringBuilder();
        builder.append(FORMAT_LEFT.concat(定数_調定年度).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE)
                .concat(調定年度.wareki().eraType(EraType.KANJI).toDateString().concat(年度)));
        出力条件リスト.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(FORMAT_LEFT.concat(定数_賦課年度).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE)
                .concat(賦課年度.wareki().eraType(EraType.KANJI).toDateString().concat(年度)));
        出力条件リスト.add(builder.toRString());
        IOutputOrder 並び順 = ChohyoShutsuryokujunFinderFactory.createInstance()
                .get出力順(SubGyomuCode.DBB介護賦課, 特別徴収仮算定結果一覧表_帳票分類ID, 出力順ID);
        List<RString> 並び順List = new ArrayList<>();
        for (int i = 整数_0; i < 整数_5; i++) {
            if (i < 並び順.get設定項目リスト().size()) {
                並び順List.add(並び順.get設定項目リスト().get(i).get項目名());
            } else {
                break;
            }
        }
        builder = new RStringBuilder();
        builder.append(FORMAT_LEFT.concat(定数_出力順).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE));
        for (RString 出力項目 : 並び順List) {
            if (出力項目 != null && !出力項目.isEmpty()) {
                builder.append(出力項目).append(FORMAT_MIN);
            }
        }
        if (builder.toRString().substring(builder.toRString().length() - 整数_1, builder.toRString().length()).equals(FORMAT_MIN)) {
            出力条件リスト.add(builder.toRString().substring(整数_0, builder.toRString().length() - 整数_1));
        } else {
            出力条件リスト.add(builder.toRString());
        }
        Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
        RString 導入団体コード = 地方公共団体.getLasdecCode_().value();
        RString 市町村名 = 地方公共団体.get市町村名();
        ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                帳票ID.value(),
                導入団体コード,
                市町村名,
                new RString(String.valueOf(JobContextHolder.getJobId())),
                帳票名,
                出力ページ数,
                CSV出力有無,
                CSVファイル名,
                出力条件リスト);
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(reportOutputJokenhyoItem);
        printer.print();
    }

    /**
     * 入力の改頁出力順IDによって、出力順を取得するメソッドです。
     *
     * @param 帳票ID ReportId
     * @param 出力順ID RString
     * @return RString 出力順
     */
    private RString get出力順(ReportId 帳票分類ID, RString 出力順ID) {

        if (RString.isNullOrEmpty(出力順ID)) {
            return RString.EMPTY;
        }
        IChohyoShutsuryokujunFinder fider = ChohyoShutsuryokujunFinderFactory.createInstance();
        IOutputOrder outputOrder = fider.get出力順(SubGyomuCode.DBB介護賦課, 帳票分類ID, Long.parseLong(出力順ID.toString()));
        if (outputOrder == null) {
            return RString.EMPTY;
        }
        RString 出力順 = MyBatisOrderByClauseCreator.create(TokubetsuChoshuKarisanteiKekkaIchiranProperty.TokuchoKarisanteiFukaEnum.class, outputOrder);
        return 出力順;
    }

    /**
     * update処理日付管理テーブル
     *
     * @param 調定年度 FlexibleYear
     * @param システム日時 システム日時
     */
    public void update処理日付管理テーブル(FlexibleYear 調定年度, YMDHMS システム日時) {
        List<DbT7022ShoriDateKanriEntity> 特徴仮算定賦課List = 処理日付管理Dac.selectShoriDateKanri(SubGyomuCode.DBB介護賦課,
                ShoriName.特徴仮算定賦課.get名称(), 調定年度);
        for (DbT7022ShoriDateKanriEntity entity : 特徴仮算定賦課List) {
            entity.setKijunTimestamp(システム日時);
            entity.setState(EntityDataState.Modified);
            処理日付管理Dac.save(entity);
        }
        List<DbT7022ShoriDateKanriEntity> 依頼金額計算List = 処理日付管理Dac.select基準日時toupdate(ShoriName.依頼金額計算.get名称(),
                年度内番号, 調定年度);
        for (DbT7022ShoriDateKanriEntity entity : 依頼金額計算List) {
            entity.setKijunTimestamp(システム日時);
            entity.setState(EntityDataState.Modified);
            処理日付管理Dac.save(entity);
        }
    }

    private TokuchoKarisanteiKiwariOutput get特徴仮算定期割(FlexibleYear 調定年度, Decimal 保険料率) {
        TokuchoKarisanteiKiwari 保険系業務共通 = new TokuchoKarisanteiKiwari();
        TokuchoKarisanteiKiwariInput inputEntity = new TokuchoKarisanteiKiwariInput();
        inputEntity.set前年度最終期別額(Decimal.ZERO);
        inputEntity.set前年度賦課額(保険料率);
        inputEntity.set現在特徴期(整数_2);
        RString 特徴定期数 = DbBusinessConfig.get(ConfigNameDBB.特徴期情報_設定納期数,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
        RString 特徴仮算定期数 = DbBusinessConfig.get(ConfigNameDBB.特徴期情報_仮算定期数,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
        RString 特徴仮算定計算区分 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_依頼金額計算方法_6月開始,
                new RDate(調定年度.minusYear(整数_1).toString()), SubGyomuCode.DBB介護賦課);
        RString 端数区分 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_期別端数,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
        GyomuConfigJohoClass 業務コンフィグ情報 = new GyomuConfigJohoClass();
        業務コンフィグ情報.set特徴定期数(Integer.valueOf(特徴定期数.toString()));
        業務コンフィグ情報.set特徴仮算定期数(Integer.valueOf(特徴仮算定期数.toString()));
        if (RSTRING_1.equals(特徴仮算定計算区分)) {
            業務コンフィグ情報.set特徴仮算定計算区分(整数_1);
        } else if (RSTRING_3.equals(特徴仮算定計算区分)) {
            業務コンフィグ情報.set特徴仮算定計算区分(整数_2);
        }
        if (HasuChoseiTani._1.getコード().equals(端数区分)) {
            業務コンフィグ情報.set端数区分特徴仮算定期別額(整数_1);
        } else if (HasuChoseiTani._10.getコード().equals(端数区分)) {
            業務コンフィグ情報.set端数区分特徴仮算定期別額(整数_2);
        } else if (HasuChoseiTani._100.getコード().equals(端数区分)) {
            業務コンフィグ情報.set端数区分特徴仮算定期別額(整数_3);
        } else if (HasuChoseiTani._1000.getコード().equals(端数区分)) {
            業務コンフィグ情報.set端数区分特徴仮算定期別額(整数_4);
        }
        inputEntity.set業務コンフィグ情報(業務コンフィグ情報);
        return 保険系業務共通.getTokuchoKarisanteiKibetsuGaku(inputEntity);
    }
}
