/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.tokuchokarisanteifuka;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.HokenryoDankaiHantei;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.core.TsukibetsuHokenryoDankai;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.FukaKonkyo;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.HokenryoDankaiHanteiParameter;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.SeigyoJoho;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.HokenryoDankaiList;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.ErrorCode;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.KozaKubun;
import jp.co.ndensan.reams.db.dbb.definition.core.tokucho.TokuchoNengakuKijunNendo6Gatsu;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2010FukaErrorListEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchokarisanteifukamanager.FukaJohoTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchokarisanteifukamanager.TokuchoKariKeisangoFukaTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchokarisanteifukamanager.TokuchoKarisanteiKekkaIchiranEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchokarisanteifukamanager.TokuchoKarisanteiKekkaIchiranTeisiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchokarisanteifukamanager.TokutyoukariSannteiTyuushutuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchokarisanteifukamanager.TokutyoukariSannteiTyuushutuResultEntity;
import jp.co.ndensan.reams.db.dbb.service.core.fuka.fukakeisan.FukaKeisan;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.HokenryoDankaiSettings;
import jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbx.definition.core.choteijiyu.ChoteiJiyuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.KazeiKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.RoreiFukushiNenkinJukyusha;
import jp.co.ndensan.reams.db.dbz.business.core.hihokensha.seikatsuhogofujoshurui.SeikatsuHogoFujoShurui;
import jp.co.ndensan.reams.db.dbz.business.core.hihokensha.seikatsuhogojukyusha.SeikatsuHogoJukyusha;
import jp.co.ndensan.reams.db.dbz.definition.core.shotoku.SetaiKazeiKubun;
import jp.co.ndensan.reams.dz.dzx.business.core.tokuchokarisanteikiwari.TokuchoKarisanteiKiwariOutput;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.definition.core.code.FujoShuruiCodeValue;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * ビジネス設計_DBBBZ33001_1_特徴仮算定賦課（バッチ）
 *
 * @reamsid_L DBB-0700-020 xuhao
 */
public class TokuchoKariSanteiFukaManagerBatch {

    private static final int 整数_0 = 0;
    private static final int 整数_1 = 1;
    private static final int 整数_2 = 2;
    private static final int 整数_3 = 3;
    private static final int 整数_5 = 5;
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
    private static final RString FORMAT_MIN = new RString(">");
    private static final RString 定数_賦課年度 = new RString("賦課年度");
    private static final RString 定数_調定年度 = new RString("調定年度");
    private static final RString 定数_出力順 = new RString("出力順");
    private static final RString 定数_出力条件 = new RString("出力条件");
    private static final RString CSV出力有無 = new RString("有り");
    private static final RString CSVファイル名 = new RString("TokubetsuChoshuKarisanteiKekkaIchiranData.csv");
    private static final RString 帳票名 = new RString("特別徴収仮算定結果一覧表");
    private static final RString 保険料段階を使用する = new RString("1");
    private static final RString 年度 = new RString("年度");

    /**
     * コンストラクタです。
     */
    TokuchoKariSanteiFukaManagerBatch() {
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
     * create特徴仮算定抽出TempEntityのメソッドです。
     *
     * @param 徴収方法Entity TokutyoukariSannteiTyuushutuResultEntity
     * @param flag boolean
     * @return 特徴仮算定抽出TempEntity
     */
    public TokutyoukariSannteiTyuushutuEntity create特徴仮算定抽出TempEntity(
            TokutyoukariSannteiTyuushutuResultEntity 徴収方法Entity, boolean flag) {
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
        if (flag) {
            entity.setChoteigaku(徴収方法Entity.getChoteigaku());
        } else {
            entity.setChoteigaku(Decimal.ZERO);
        }
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
        return entity;
    }

    /**
     * 賦課エラー一覧Entityを作成のメソッドです。
     *
     * @param 前年度賦課TempEntity TokutyoukariSannteiTyuushutuEntity
     * @param 調定日時 YMDHMS
     * @return 賦課エラー一覧Entity
     */
    public DbT2010FukaErrorListEntity set賦課エラー一覧Entity(TokutyoukariSannteiTyuushutuEntity 前年度賦課TempEntity, YMDHMS 調定日時) {
        DbT2010FukaErrorListEntity entity = new DbT2010FukaErrorListEntity();
        entity.setSubGyomuCode(SubGyomuCode.DBB介護賦課);
        entity.setInternalReportId(内部帳票ID);
        entity.setFukaNendo(前年度賦課TempEntity.getFukaNendo());
        entity.setTsuchishoNo(前年度賦課TempEntity.getTsuchishoNo());
        entity.setInternalReportCreationDateTime(調定日時.getRDateTime());
        entity.setBatchId(バッチID);
        entity.setBatchStartingDateTime(調定日時.getRDateTime());
        entity.setErrorCode(new Code(ErrorCode.被保険者台帳データなし.getコード()));
        entity.setHihokenshaNo(前年度賦課TempEntity.getHihokenshaNo());
        return entity;
    }

    private void set特別徴収停止事由コード(FukaJohoTempEntity 賦課の情報一時Entity,
            ChoshuHoho 徴収方法の情報) {
        if (!特別徴収_厚生労働省.equals(徴収方法の情報.get徴収方法4月()) && !特別徴収_地共済.equals(徴収方法の情報.get徴収方法4月())) {
            賦課の情報一時Entity.setChoteiJiyu1(徴収方法の情報.get特別徴収停止事由コード());
            if (徴収方法の情報.get特別徴収停止事由コード() != null
                    && !徴収方法の情報.get特別徴収停止事由コード().equals(賦課の情報一時Entity.getChoteiJiyu1())) {
                賦課の情報一時Entity.setFalg(true);
            }
            賦課の情報一時Entity.setChoteiJiyu2(RString.EMPTY);
            if (!RString.EMPTY.equals(賦課の情報一時Entity.getChoteiJiyu2())) {
                賦課の情報一時Entity.setFalg(true);
            }
            賦課の情報一時Entity.setChoteiJiyu3(RString.EMPTY);
            if (!RString.EMPTY.equals(賦課の情報一時Entity.getChoteiJiyu3())) {
                賦課の情報一時Entity.setFalg(true);
            }
            賦課の情報一時Entity.setChoteiJiyu4(RString.EMPTY);
            if (!RString.EMPTY.equals(賦課の情報一時Entity.getChoteiJiyu4())) {
                賦課の情報一時Entity.setFalg(true);
            }
            賦課の情報一時Entity.setTkKibetsuGaku01(Decimal.ZERO);
            if (!Decimal.ZERO.equals(賦課の情報一時Entity.getTkKibetsuGaku01())) {
                賦課の情報一時Entity.setFalg(true);
            }
            賦課の情報一時Entity.setTkKibetsuGaku02(Decimal.ZERO);
            if (!Decimal.ZERO.equals(賦課の情報一時Entity.getTkKibetsuGaku02())) {
                賦課の情報一時Entity.setFalg(true);
            }
            賦課の情報一時Entity.setTkKibetsuGaku03(Decimal.ZERO);
            if (!Decimal.ZERO.equals(賦課の情報一時Entity.getTkKibetsuGaku03())) {
                賦課の情報一時Entity.setFalg(true);
            }
        }
    }

    /**
     * 資格等最新化（４月開始）
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
     * @param 前年度合計所得金額 YMDHMS
     * @param 前年度公的年金収入額 Decimal
     * @param 賦課の情報一時Entity FukaJohoTempEntity
     * @return FukaJohoTempEntity
     */
    public FukaJohoTempEntity reflectShikakuToSaishinApril(FlexibleYear 調定年度,
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
            FukaJohoTempEntity 賦課の情報一時Entity) {
        modifyFukaJohoCommon_４月開始(調定年度, 資格の情報, 生保の情報List, 老齢の情報List, 前年度生保開始日, 前年度生保廃止日,
                前年度老年開始日, 前年度老年廃止日, 前年度世帯課税区分, 前年度課税区分, 前年度合計所得金額, 前年度公的年金収入額, 賦課の情報一時Entity);
        set特別徴収停止事由コード(賦課の情報一時Entity, 徴収方法の情報);
        賦課の情報一時Entity.setRirekiNo(賦課の情報一時Entity.getRirekiNo() + 整数_1);
        賦課の情報一時Entity.setChoteiNichiji(調定日時);
        賦課の情報一時Entity.setKoseiM(文字列_04);
        賦課の情報一時Entity.setChoshuHohoRirekiNo(徴収方法の情報.get履歴番号());
        賦課の情報一時Entity.setIdoKijunNichiji(調定日時);
        賦課の情報一時Entity.setTkSaishutsuKampuGaku(Decimal.ZERO);
        賦課の情報一時Entity.setFuSaishutsuKampuGaku(Decimal.ZERO);
        賦課の情報一時Entity.setTkKibetsuGaku02(Decimal.ZERO);
        賦課の情報一時Entity.setTkKibetsuGaku03(Decimal.ZERO);
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

    private void modifyFukaJohoCommon_４月開始(FlexibleYear 調定年度,
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
            FukaJohoTempEntity 賦課の情報一時Entity) {
        get資格取得日Flag(資格の情報, 賦課の情報一時Entity);
        賦課の情報一時Entity.setShikakuShutokuYMD(資格の情報.get第1号資格取得年月日());
        get資格取得事由Flag(資格の情報, 賦課の情報一時Entity);
        賦課の情報一時Entity.setShikakuShutokuJiyu(資格の情報.get資格取得事由コード());
        get資格喪失日Flag(資格の情報, 賦課の情報一時Entity);
        賦課の情報一時Entity.setShikakuSoshitsuYMD(資格の情報.get資格喪失年月日());
        get資格喪失事由Flag(資格の情報, 賦課の情報一時Entity);
        賦課の情報一時Entity.setShikakuSoshitsuJiyu(資格の情報.get資格喪失事由コード());
        FlexibleDate 調定年度開始日 = new FlexibleDate(調定年度.toDateString().concat(文字列_04).concat(文字列_01));
        FlexibleDate 調定年度廃止日 = new FlexibleDate(調定年度.plusYear(整数_1).toDateString().concat(文字列_03).concat(文字列_31));
        set生保の情報_modifyFukaJohoCommon_４月開始(生保の情報List, 調定年度開始日, 調定年度廃止日, 賦課の情報一時Entity);
        set老齢の情報_modifyFukaJohoCommon_４月開始(老齢の情報List, 調定年度開始日, 調定年度廃止日, 賦課の情報一時Entity);
        FlexibleDate 賦課期日 = FukaKeisan.createInstance().findOut賦課基準日(調定年度, 資格の情報);
        if (!賦課期日.equals(賦課の情報一時Entity.getFukaYMD())) {
            賦課の情報一時Entity.setFalg(true);
        }
        賦課の情報一時Entity.setFukaYMD(賦課期日);
        HokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter = new HokenryoDankaiHanteiParameter();
        hokenryoDankaiHanteiParameter.setFukaNendo(調定年度);
        FukaKonkyo fukaKonkyo = new FukaKonkyo();
        fukaKonkyo.setFukakijunYMD(調定年度開始日);
        if (前年度生保開始日 == null || 前年度生保開始日.isEmpty()) {
            fukaKonkyo.setSeihoStartYMD(FlexibleDate.EMPTY);
        } else if (前年度生保廃止日 == null || 前年度生保廃止日.isEmpty() || 調定年度開始日.isBeforeOrEquals(前年度生保廃止日)) {
            fukaKonkyo.setSeihoStartYMD(調定年度開始日);
        } else {
            fukaKonkyo.setSeihoStartYMD(FlexibleDate.EMPTY);
        }
        fukaKonkyo.setSeihoEndYMD(FlexibleDate.EMPTY);
        if (前年度老年開始日 == null || 前年度老年開始日.isEmpty()) {
            fukaKonkyo.setRoreiNenkinStartYMD(FlexibleDate.EMPTY);
        } else if (前年度老年廃止日 == null || 前年度老年廃止日.isEmpty() || 調定年度開始日.isBeforeOrEquals(前年度老年廃止日)) {
            fukaKonkyo.setRoreiNenkinStartYMD(調定年度開始日);
        } else {
            fukaKonkyo.setRoreiNenkinStartYMD(FlexibleDate.EMPTY);
        }
        fukaKonkyo.setRoreiNenkinEndYMD(FlexibleDate.EMPTY);
        if (前年度世帯課税区分 != null && !前年度世帯課税区分.isEmpty()) {
            fukaKonkyo.setZennendoSetaiKazeiKubun(SetaiKazeiKubun.toValue(前年度世帯課税区分));
        }
        if (前年度課税区分 != null && !前年度課税区分.isEmpty()) {
            fukaKonkyo.setZennendoKazeiKubun(KazeiKubun.toValue(前年度課税区分));
        }
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
        RString 保険料段階 = RString.EMPTY;
        保険料段階 = set保険料段階(hokenryoDankaiHanteiParameter, 保険料段階);
        set保険料段階(保険料段階, 賦課の情報一時Entity);
        set市町村コード(資格の情報, 賦課の情報一時Entity);
    }

    private RString set保険料段階(HokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter, RString 保険料段階) {
        HokenryoDankaiHantei hantei = InstanceProvider.create(HokenryoDankaiHantei.class);
        TsukibetsuHokenryoDankai 月別保険料段階 = hantei.determine仮算定保険料段階(hokenryoDankaiHanteiParameter);
        if (月別保険料段階 != null && 月別保険料段階.get保険料段階04月() != null) {
            保険料段階 = hokenryoDankaiHanteiParameter.getSeigyoJoho().getHokenryoDankaiList()
                    .getBy段階Index(月別保険料段階.get保険料段階04月()).get段階区分();
        }
        return 保険料段階;
    }

    private void set保険料段階(RString 保険料段階, FukaJohoTempEntity 賦課の情報一時Entity) {
        if (!保険料段階.equals(賦課の情報一時Entity.getHokenryoDankai())) {
            賦課の情報一時Entity.setFalg(true);
        }
        賦課の情報一時Entity.setHokenryoDankaiKarisanntei(保険料段階);
    }

    private void set市町村コード(HihokenshaDaicho 資格の情報, FukaJohoTempEntity 賦課の情報一時Entity) {
        if (資格の情報.get旧市町村コード() != null && !資格の情報.get旧市町村コード().isEmpty()) {
            if (資格の情報.get旧市町村コード().equals(賦課の情報一時Entity.getFukaShichosonCode())) {
                賦課の情報一時Entity.setFalg(true);
            }
            賦課の情報一時Entity.setFukaShichosonCode(資格の情報.get旧市町村コード());
        } else if (資格の情報.get広住特措置元市町村コード() != null && !資格の情報.get広住特措置元市町村コード().isEmpty()) {
            if (資格の情報.get広住特措置元市町村コード().equals(賦課の情報一時Entity.getFukaShichosonCode())) {
                賦課の情報一時Entity.setFalg(true);
            }
            賦課の情報一時Entity.setFukaShichosonCode(資格の情報.get広住特措置元市町村コード());
        } else {
            if (資格の情報.get市町村コード().equals(賦課の情報一時Entity.getFukaShichosonCode())) {
                賦課の情報一時Entity.setFalg(true);
            }
            賦課の情報一時Entity.setFukaShichosonCode(資格の情報.get市町村コード());
        }
    }

    private void get資格喪失事由Flag(HihokenshaDaicho 資格の情報, FukaJohoTempEntity 賦課の情報一時Entity) {
        if ((賦課の情報一時Entity.getShikakuSoshitsuJiyu() != null
                && !賦課の情報一時Entity.getShikakuSoshitsuJiyu().equals(資格の情報.get資格喪失事由コード()))
                || (資格の情報.get資格喪失事由コード() != null
                && !資格の情報.get資格喪失事由コード().equals(賦課の情報一時Entity.getShikakuSoshitsuJiyu()))) {
            賦課の情報一時Entity.setFalg(true);
        }
    }

    private void get資格喪失日Flag(HihokenshaDaicho 資格の情報, FukaJohoTempEntity 賦課の情報一時Entity) {
        if ((賦課の情報一時Entity.getShikakuSoshitsuYMD() != null
                && !賦課の情報一時Entity.getShikakuSoshitsuYMD().equals(資格の情報.get資格喪失年月日()))
                || (資格の情報.get資格喪失年月日() != null
                && !資格の情報.get資格喪失年月日().equals(賦課の情報一時Entity.getShikakuSoshitsuYMD()))) {
            賦課の情報一時Entity.setFalg(true);
        }
    }

    private void get資格取得事由Flag(HihokenshaDaicho 資格の情報, FukaJohoTempEntity 賦課の情報一時Entity) {
        if ((賦課の情報一時Entity.getShikakuShutokuJiyu() != null
                && !賦課の情報一時Entity.getShikakuShutokuJiyu().equals(資格の情報.get資格取得事由コード()))
                || (資格の情報.get資格取得事由コード() != null
                && !資格の情報.get資格取得事由コード().equals(賦課の情報一時Entity.getShikakuShutokuJiyu()))) {
            賦課の情報一時Entity.setFalg(true);
        }
    }

    private void get資格取得日Flag(HihokenshaDaicho 資格の情報, FukaJohoTempEntity 賦課の情報一時Entity) {
        if ((賦課の情報一時Entity.getShikakuShutokuYMD() != null
                && !賦課の情報一時Entity.getShikakuShutokuYMD().equals(資格の情報.get第1号資格取得年月日()))
                || (資格の情報.get第1号資格取得年月日() != null
                && !資格の情報.get第1号資格取得年月日().equals(賦課の情報一時Entity.getShikakuShutokuYMD()))) {
            賦課の情報一時Entity.setFalg(true);
        }
    }

    private void set老齢の情報_modifyFukaJohoCommon_４月開始(List<RoreiFukushiNenkinJukyusha> 老齢の情報List, FlexibleDate 調定年度開始日,
            FlexibleDate 調定年度廃止日, FukaJohoTempEntity 賦課の情報一時Entity) {
        FlexibleDate 最新老齢受給開始年月日 = null;
        RoreiFukushiNenkinJukyusha 最新老齢の情報 = null;
        for (RoreiFukushiNenkinJukyusha 老齢の情報 : 老齢の情報List) {
            if (老齢の情報.get受給開始年月日() == null || 老齢の情報.get受給開始年月日().isEmpty()
                    || 老齢の情報.get受給終了年月日() == null || 老齢の情報.get受給終了年月日().isEmpty()) {
                continue;
            }
            if (!調定年度廃止日.isBeforeOrEquals(老齢の情報.get受給開始年月日()) && 調定年度開始日.isBefore(老齢の情報.get受給終了年月日())) {
                if (最新老齢受給開始年月日 == null) {
                    最新老齢受給開始年月日 = 老齢の情報.get受給開始年月日();
                    最新老齢の情報 = 老齢の情報;
                } else if (最新老齢受給開始年月日.isBefore(老齢の情報.get受給開始年月日())) {
                    最新老齢受給開始年月日 = 老齢の情報.get受給開始年月日();
                    最新老齢の情報 = 老齢の情報;
                }
            }
        }
        if (最新老齢の情報 == null) {
            if (!FlexibleDate.EMPTY.equals(賦課の情報一時Entity.getRonenKaishiYMD())) {
                賦課の情報一時Entity.setFalg(true);
            }
            賦課の情報一時Entity.setRonenKaishiYMD(FlexibleDate.EMPTY);
            if (!FlexibleDate.EMPTY.equals(賦課の情報一時Entity.getRonenHaishiYMD())) {
                賦課の情報一時Entity.setFalg(true);
            }
            賦課の情報一時Entity.setRonenHaishiYMD(FlexibleDate.EMPTY);
        } else {
            if (!最新老齢の情報.get受給開始年月日().equals(賦課の情報一時Entity.getRonenKaishiYMD())) {
                賦課の情報一時Entity.setFalg(true);
            }
            賦課の情報一時Entity.setRonenKaishiYMD(最新老齢の情報.get受給開始年月日());
            if (!最新老齢の情報.get受給終了年月日().equals(賦課の情報一時Entity.getRonenHaishiYMD())) {
                賦課の情報一時Entity.setFalg(true);
            }
            賦課の情報一時Entity.setRonenHaishiYMD(最新老齢の情報.get受給終了年月日());
        }

    }

    private void set生保の情報_modifyFukaJohoCommon_４月開始(List<SeikatsuHogoJukyusha> 生保の情報List, FlexibleDate 調定年度開始日,
            FlexibleDate 調定年度廃止日, FukaJohoTempEntity 賦課の情報一時Entity) {
        FlexibleDate 最新受給開始日 = null;
        SeikatsuHogoJukyusha 最新生保の情報 = null;
        for (SeikatsuHogoJukyusha 生保の情報 : 生保の情報List) {
            if (生保の情報.get受給開始日() == null || 生保の情報.get受給開始日().isEmpty()
                    || 生保の情報.get受給廃止日() == null || 生保の情報.get受給廃止日().isEmpty()) {
                continue;
            }
            if (!調定年度廃止日.isBeforeOrEquals(生保の情報.get受給開始日()) && 調定年度開始日.isBefore(生保の情報.get受給廃止日())) {
                if (最新受給開始日 == null) {
                    最新受給開始日 = 生保の情報.get受給廃止日();
                    最新生保の情報 = 生保の情報;
                } else if (最新受給開始日.isBefore(生保の情報.get受給廃止日())) {
                    最新受給開始日 = 生保の情報.get受給廃止日();
                    最新生保の情報 = 生保の情報;
                }
            }
        }
        if (最新生保の情報 == null) {
            if (!RString.EMPTY.equals(賦課の情報一時Entity.getSeihofujoShurui())) {
                賦課の情報一時Entity.setFalg(true);
            }
            賦課の情報一時Entity.setSeihofujoShurui(RString.EMPTY);
            if (!FlexibleDate.EMPTY.equals(賦課の情報一時Entity.getSeihoKaishiYMD())) {
                賦課の情報一時Entity.setFalg(true);
            }
            賦課の情報一時Entity.setSeihoKaishiYMD(FlexibleDate.EMPTY);
            if (!FlexibleDate.EMPTY.equals(賦課の情報一時Entity.getSeihoHaishiYMD())) {
                賦課の情報一時Entity.setFalg(true);
            }
            賦課の情報一時Entity.setSeihoHaishiYMD(FlexibleDate.EMPTY);
        } else {
            List<SeikatsuHogoFujoShurui> 最新生活保護扶助種類List = 最新生保の情報.getSeikatsuHogoFujoShuruiList();
            if (最新生活保護扶助種類List != null && !最新生活保護扶助種類List.isEmpty()) {
                set生活保護扶助種類_４月開始(最新生活保護扶助種類List, 賦課の情報一時Entity);
            }
            if (!最新生保の情報.get受給開始日().equals(賦課の情報一時Entity.getSeihoKaishiYMD())) {
                賦課の情報一時Entity.setFalg(true);
            }
            賦課の情報一時Entity.setSeihoKaishiYMD(最新生保の情報.get受給開始日());
            if (!最新生保の情報.get受給廃止日().equals(賦課の情報一時Entity.getSeihoHaishiYMD())) {
                賦課の情報一時Entity.setFalg(true);
            }
            賦課の情報一時Entity.setSeihoHaishiYMD(最新生保の情報.get受給廃止日());
        }
    }

    private void set生活保護扶助種類_４月開始(List<SeikatsuHogoFujoShurui> 最新生活保護扶助種類List, FukaJohoTempEntity 賦課の情報一時Entity) {
        FujoShuruiCodeValue 生活保護扶助種類 = 最新生活保護扶助種類List.get(整数_0).get扶助種類コード();
        for (SeikatsuHogoFujoShurui 最新生活保護扶助種類 : 最新生活保護扶助種類List) {
            if (生活保護扶助種類.value().compareTo(最新生活保護扶助種類.get扶助種類コード().value()) == 整数_1) {
                生活保護扶助種類 = 最新生活保護扶助種類.get扶助種類コード();
            }
        }
        if (!生活保護扶助種類.value().value().equals(賦課の情報一時Entity.getSeihofujoShurui())) {
            賦課の情報一時Entity.setFalg(true);
        }
        賦課の情報一時Entity.setSeihofujoShurui(生活保護扶助種類.value().value());
    }

    /**
     * 賦課情報の計算登録（継続）
     *
     * @param 調定年度 FlexibleYear
     * @param 調定日時 YMDHMS
     * @param 資格の情報 HihokenshaDaicho
     * @param 徴収方法の情報 YMDHMS
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
     * @param 賦課情報一時Entity FukaJohoTempEntity
     * @param 特徴期別金額06 Decimal
     */
    public void createFukaJohoKeizoku(FlexibleYear 調定年度,
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
            Map<HihokenshaNo, Integer> 被保険者番号Map,
            FukaJohoTempEntity 賦課情報一時Entity,
            Decimal 特徴期別金額06) {

        modifyFukaJohoCommon(調定年度, 調定日時,
                資格の情報, 徴収方法の情報, 生保の情報List, 老齢の情報List, 前年度生保開始日, 前年度生保廃止日, 前年度老年開始日, 前年度老年廃止日,
                前年度世帯課税区分, 前年度課税区分, 前年度合計所得金額, 前年度公的年金収入額, 通知書番号, 被保険者番号Map, 賦課情報一時Entity);
        賦課情報一時Entity.setTkKibetsuGaku01(特徴期別金額06);
        賦課情報一時Entity.setTkKibetsuGaku02(特徴期別金額06);
        賦課情報一時Entity.setTkKibetsuGaku03(特徴期別金額06);
    }

    /**
     * 賦課情報の計算登録（6月開始）
     *
     * @param 調定年度 FlexibleYear
     * @param 調定日時 YMDHMS
     * @param 資格の情報 HihokenshaDaicho
     * @param 徴収方法の情報 YMDHMS
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
     * @param 賦課情報一時Entity FukaJohoTempEntity
     * @param 前年度保険料段階 RString
     */
    public void createFukaJohoJune(FlexibleYear 調定年度,
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
            Map<HihokenshaNo, Integer> 被保険者番号Map,
            FukaJohoTempEntity 賦課情報一時Entity,
            RString 前年度保険料段階) {
        modifyFukaJohoCommon(調定年度, 調定日時,
                資格の情報, 徴収方法の情報, 生保の情報List, 老齢の情報List, 前年度生保開始日, 前年度生保廃止日, 前年度老年開始日, 前年度老年廃止日,
                前年度世帯課税区分, 前年度課税区分, 前年度合計所得金額, 前年度公的年金収入額, 通知書番号, 被保険者番号Map, 賦課情報一時Entity);
        HokenryoDankaiList 前年度の保険料段階リスト;
        Decimal 保険料率 = Decimal.ZERO;
        RString 特別徴収_年額基準年度_6月開始 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_年額基準年度_6月開始,
                new RDate(調定年度.minusYear(整数_1).toString()), SubGyomuCode.DBB介護賦課);
        if (TokuchoNengakuKijunNendo6Gatsu.当年度.getコード().equals(特別徴収_年額基準年度_6月開始)) {
            前年度の保険料段階リスト = HokenryoDankaiSettings.createInstance()
                    .get保険料段階ListIn(調定年度.minusYear(整数_1));
            保険料率 = set保険料率1(前年度保険料段階, 保険料率, 前年度の保険料段階リスト);
        } else if (TokuchoNengakuKijunNendo6Gatsu.翌年度.getコード().equals(特別徴収_年額基準年度_6月開始)) {
            前年度の保険料段階リスト = HokenryoDankaiSettings.createInstance()
                    .get保険料段階ListIn(調定年度);
            保険料率 = set保険料率2(賦課情報一時Entity.getHokenryoDankaiKarisanntei(), 保険料率, 前年度の保険料段階リスト);
        }
        TokuchoKarisanteiKiwariOutput 特徴仮算定期割 = get特徴仮算定期割(調定年度, 保険料率);
        Decimal 特徴期別金額01 = Decimal.ZERO;
        Decimal 特徴期別金額02 = Decimal.ZERO;
        Decimal 特徴期別金額03 = Decimal.ZERO;
        特徴期別金額01 = set特徴期別金額01(特徴仮算定期割, 特徴期別金額01);
        特徴期別金額02 = set特徴期別金額02(特徴仮算定期割, 特徴期別金額02);
        特徴期別金額03 = set特徴期別金額03(特徴仮算定期割, 特徴期別金額03);
        賦課情報一時Entity.setFuKibetsuGaku01(特徴期別金額01);
        賦課情報一時Entity.setFuKibetsuGaku02(特徴期別金額02);
        賦課情報一時Entity.setFuKibetsuGaku03(特徴期別金額03);
    }

    private Decimal set保険料率1(RString 前年度保険料段階, Decimal 保険料率, HokenryoDankaiList 前年度の保険料段階リスト) {
        if (前年度保険料段階 != null) {
            保険料率 = 前年度の保険料段階リスト.getBy段階区分(前年度保険料段階).get保険料率();
        }
        return 保険料率;
    }

    private Decimal set保険料率2(RString 保険料段階_仮算定時, Decimal 保険料率, HokenryoDankaiList 前年度の保険料段階リスト) {
        if (保険料段階_仮算定時 != null) {
            保険料率 = 前年度の保険料段階リスト.getBy段階区分(保険料段階_仮算定時).get保険料率();
        }
        return 保険料率;
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

    /**
     * 賦課の情報共通編集のメソッドです。
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
     * @param 賦課情報一時Entity FukaJohoTempEntity
     */
    public void modifyFukaJohoCommon(FlexibleYear 調定年度,
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
            Map<HihokenshaNo, Integer> 被保険者番号Map,
            FukaJohoTempEntity 賦課情報一時Entity) {
        賦課情報一時Entity.setChoteiNendo(調定年度);
        賦課情報一時Entity.setFukaNendo(調定年度);
        HihokenshaNo 被保険者番号 = 資格の情報.get被保険者番号();
        if (被保険者番号Map.containsKey(被保険者番号)) {
            RString 枝番号 = new RString(String.valueOf(被保険者番号Map.get(被保険者番号) + 整数_1));
            通知書番号 = new TsuchishoNo(文字列_0000.concat(被保険者番号.value()).concat(枝番号.padZeroToLeft(整数_2)));
        } else {
            通知書番号 = new TsuchishoNo(文字列_0000.concat(被保険者番号.value()).concat(文字列_01));
        }
        賦課情報一時Entity.setTsuchishoNo(通知書番号);
        賦課情報一時Entity.setRirekiNo(整数_0);
        賦課情報一時Entity.setShikakuShutokuYMD(資格の情報.get第1号資格取得年月日());
        賦課情報一時Entity.setShikakuShutokuJiyu(資格の情報.get資格取得事由コード());
        賦課情報一時Entity.setShikakuSoshitsuYMD(資格の情報.get資格喪失年月日());
        賦課情報一時Entity.setShikakuSoshitsuJiyu(資格の情報.get資格喪失事由コード());
        FlexibleDate 調定年度開始日 = new FlexibleDate(調定年度.toDateString().concat(文字列_04).concat(文字列_01));
        FlexibleDate 調定年度廃止日 = new FlexibleDate(調定年度.plusYear(整数_1).toDateString().concat(文字列_03).concat(文字列_31));
        set生保の情報_modifyFukaJohoCommon(生保の情報List, 調定年度開始日, 調定年度廃止日, 賦課情報一時Entity);
        set老齢の情報_modifyFukaJohoCommon(老齢の情報List, 調定年度開始日, 調定年度廃止日, 賦課情報一時Entity);
        賦課情報一時Entity.setFukaYMD(FukaKeisan.createInstance().findOut賦課基準日(調定年度, 資格の情報));
        賦課情報一時Entity.setChoteiJiyu1(ChoteiJiyuCode.仮算定賦課.getコード());
        賦課情報一時Entity.setChoteiJiyu2(RString.EMPTY);
        賦課情報一時Entity.setChoteiJiyu3(RString.EMPTY);
        賦課情報一時Entity.setChoteiJiyu4(RString.EMPTY);
        HokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter = new HokenryoDankaiHanteiParameter();
        hokenryoDankaiHanteiParameter.setFukaNendo(調定年度);
        FukaKonkyo fukaKonkyo = new FukaKonkyo();
        fukaKonkyo.setFukakijunYMD(調定年度開始日);
        if (前年度生保開始日 == null || 前年度生保開始日.isEmpty()) {
            fukaKonkyo.setSeihoStartYMD(FlexibleDate.EMPTY);
        } else if (前年度生保廃止日 == null || 前年度生保廃止日.isEmpty() || 調定年度開始日.isBeforeOrEquals(前年度生保廃止日)) {
            fukaKonkyo.setSeihoStartYMD(調定年度開始日);
        } else {
            fukaKonkyo.setSeihoStartYMD(FlexibleDate.EMPTY);
        }
        fukaKonkyo.setSeihoEndYMD(FlexibleDate.EMPTY);
        if (前年度老年開始日 == null || 前年度老年開始日.isEmpty()) {
            fukaKonkyo.setRoreiNenkinStartYMD(FlexibleDate.EMPTY);
        } else if (前年度老年廃止日 == null || 前年度老年廃止日.isEmpty() || 調定年度開始日.isBeforeOrEquals(前年度老年廃止日)) {
            fukaKonkyo.setRoreiNenkinStartYMD(調定年度開始日);
        } else {
            fukaKonkyo.setRoreiNenkinStartYMD(FlexibleDate.EMPTY);
        }
        fukaKonkyo.setRoreiNenkinEndYMD(FlexibleDate.EMPTY);
        if (前年度世帯課税区分 != null && !前年度世帯課税区分.isEmpty()) {
            fukaKonkyo.setZennendoSetaiKazeiKubun(SetaiKazeiKubun.toValue(前年度世帯課税区分));
        }
        if (前年度課税区分 != null && !前年度課税区分.isEmpty()) {
            fukaKonkyo.setZennendoKazeiKubun(KazeiKubun.toValue(前年度課税区分));
        }
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
        RString 保険料段階 = RString.EMPTY;
        保険料段階 = set保険料段階(hokenryoDankaiHanteiParameter, 保険料段階);
        賦課情報一時Entity.setHokenryoDankaiKarisanntei(保険料段階);
        set市町村コード_共通編集(資格の情報, 賦課情報一時Entity);
        賦課情報一時Entity.setHihokenshaNo(資格の情報.get被保険者番号());
        賦課情報一時Entity.setShikibetsuCode(資格の情報.get識別コード());
        賦課情報一時Entity.setChoteiNichiji(調定日時);
        賦課情報一時Entity.setKoseiM(文字列_04);
        賦課情報一時Entity.setChoshuHohoRirekiNo(徴収方法の情報.get履歴番号());
        賦課情報一時Entity.setIdoKijunNichiji(調定日時);
        賦課情報一時Entity.setKozaKubun(KozaKubun.現金納付.getコード());
        賦課情報一時Entity.setTkSaishutsuKampuGaku(Decimal.ZERO);
        賦課情報一時Entity.setFuSaishutsuKampuGaku(Decimal.ZERO);
        set期別金額(賦課情報一時Entity);
    }

    private void set期別金額(FukaJohoTempEntity 賦課情報一時Entity) {
        賦課情報一時Entity.setTkKibetsuGaku01(Decimal.ZERO);
        賦課情報一時Entity.setTkKibetsuGaku02(Decimal.ZERO);
        賦課情報一時Entity.setTkKibetsuGaku03(Decimal.ZERO);
        賦課情報一時Entity.setTkKibetsuGaku04(Decimal.ZERO);
        賦課情報一時Entity.setTkKibetsuGaku05(Decimal.ZERO);
        賦課情報一時Entity.setTkKibetsuGaku06(Decimal.ZERO);
        賦課情報一時Entity.setFuKibetsuGaku01(Decimal.ZERO);
        賦課情報一時Entity.setFuKibetsuGaku02(Decimal.ZERO);
        賦課情報一時Entity.setFuKibetsuGaku03(Decimal.ZERO);
        賦課情報一時Entity.setFuKibetsuGaku04(Decimal.ZERO);
        賦課情報一時Entity.setFuKibetsuGaku05(Decimal.ZERO);
        賦課情報一時Entity.setFuKibetsuGaku06(Decimal.ZERO);
        賦課情報一時Entity.setFuKibetsuGaku07(Decimal.ZERO);
        賦課情報一時Entity.setFuKibetsuGaku08(Decimal.ZERO);
        賦課情報一時Entity.setFuKibetsuGaku09(Decimal.ZERO);
        賦課情報一時Entity.setFuKibetsuGaku10(Decimal.ZERO);
        賦課情報一時Entity.setFuKibetsuGaku11(Decimal.ZERO);
        賦課情報一時Entity.setFuKibetsuGaku12(Decimal.ZERO);
        賦課情報一時Entity.setFuKibetsuGaku13(Decimal.ZERO);
        賦課情報一時Entity.setFuKibetsuGaku14(Decimal.ZERO);
    }

    private void set市町村コード_共通編集(HihokenshaDaicho 資格の情報, FukaJohoTempEntity 賦課情報一時Entity) {
        if (資格の情報.get旧市町村コード() != null && !資格の情報.get旧市町村コード().isEmpty()) {
            賦課情報一時Entity.setFukaShichosonCode(資格の情報.get旧市町村コード());
        } else if (資格の情報.get広住特措置元市町村コード() != null && !資格の情報.get広住特措置元市町村コード().isEmpty()) {
            賦課情報一時Entity.setFukaShichosonCode(資格の情報.get広住特措置元市町村コード());
        } else {
            賦課情報一時Entity.setFukaShichosonCode(資格の情報.get市町村コード());
        }
    }

    private void set老齢の情報_modifyFukaJohoCommon(List<RoreiFukushiNenkinJukyusha> 老齢の情報List, FlexibleDate 調定年度開始日,
            FlexibleDate 調定年度廃止日, FukaJohoTempEntity 賦課情報一時Entity) {
        FlexibleDate 最新老齢受給開始年月日 = null;
        RoreiFukushiNenkinJukyusha 最新老齢の情報 = null;
        for (RoreiFukushiNenkinJukyusha 老齢の情報 : 老齢の情報List) {
            if (老齢の情報.get受給開始年月日() == null || 老齢の情報.get受給開始年月日().isEmpty()
                    || 老齢の情報.get受給終了年月日() == null || 老齢の情報.get受給終了年月日().isEmpty()) {
                continue;
            }
            if (調定年度開始日.isBeforeOrEquals(老齢の情報.get受給終了年月日()) || 老齢の情報.get受給開始年月日().isBeforeOrEquals(調定年度廃止日)) {
                if (最新老齢受給開始年月日 == null) {
                    最新老齢受給開始年月日 = 老齢の情報.get受給開始年月日();
                    最新老齢の情報 = 老齢の情報;
                } else if (最新老齢受給開始年月日.isBefore(老齢の情報.get受給開始年月日())) {
                    最新老齢受給開始年月日 = 老齢の情報.get受給開始年月日();
                    最新老齢の情報 = 老齢の情報;
                }
            }
        }
        if (最新老齢の情報 == null) {
            賦課情報一時Entity.setRonenKaishiYMD(FlexibleDate.EMPTY);
            賦課情報一時Entity.setRonenHaishiYMD(FlexibleDate.EMPTY);
        } else {
            賦課情報一時Entity.setRonenKaishiYMD(最新老齢の情報.get受給開始年月日());
            賦課情報一時Entity.setRonenHaishiYMD(最新老齢の情報.get受給終了年月日());
        }
    }

    private void set生保の情報_modifyFukaJohoCommon(List<SeikatsuHogoJukyusha> 生保の情報List, FlexibleDate 調定年度開始日,
            FlexibleDate 調定年度廃止日, FukaJohoTempEntity 賦課情報一時Entity) {
        FlexibleDate 最新受給開始日 = null;
        SeikatsuHogoJukyusha 最新生保の情報 = null;
        for (SeikatsuHogoJukyusha 生保の情報 : 生保の情報List) {
            if (生保の情報.get受給廃止日() == null || 生保の情報.get受給廃止日().isEmpty()
                    || 生保の情報.get受給開始日() == null || 生保の情報.get受給開始日().isEmpty()) {
                continue;
            }
            if (調定年度開始日.isBeforeOrEquals(生保の情報.get受給廃止日()) || 生保の情報.get受給開始日().isBeforeOrEquals(調定年度廃止日)) {
                if (最新受給開始日 == null) {
                    最新受給開始日 = 生保の情報.get受給廃止日();
                    最新生保の情報 = 生保の情報;
                } else if (最新受給開始日.isBefore(生保の情報.get受給廃止日())) {
                    最新受給開始日 = 生保の情報.get受給廃止日();
                    最新生保の情報 = 生保の情報;
                }
            }
        }
        if (最新生保の情報 == null) {
            賦課情報一時Entity.setSeihofujoShurui(RString.EMPTY);
            賦課情報一時Entity.setSeihoKaishiYMD(FlexibleDate.EMPTY);
            賦課情報一時Entity.setSeihoHaishiYMD(FlexibleDate.EMPTY);
        } else {
            List<SeikatsuHogoFujoShurui> 最新生活保護扶助種類List = 最新生保の情報.getSeikatsuHogoFujoShuruiList();
            if (最新生活保護扶助種類List == null || 最新生活保護扶助種類List.isEmpty()) {
                賦課情報一時Entity.setSeihofujoShurui(RString.EMPTY);
            } else {
                set生活保護扶助種類(最新生活保護扶助種類List, 賦課情報一時Entity);
            }
            賦課情報一時Entity.setSeihoKaishiYMD(最新生保の情報.get受給開始日());
            賦課情報一時Entity.setSeihoHaishiYMD(最新生保の情報.get受給廃止日());
        }
    }

    private void set生活保護扶助種類(List<SeikatsuHogoFujoShurui> 最新生活保護扶助種類List, FukaJohoTempEntity 賦課情報一時Entity) {
        FujoShuruiCodeValue 生活保護扶助種類 = 最新生活保護扶助種類List.get(整数_0).get扶助種類コード();
        for (SeikatsuHogoFujoShurui 最新生活保護扶助種類 : 最新生活保護扶助種類List) {
            if (生活保護扶助種類.value().compareTo(最新生活保護扶助種類.get扶助種類コード().value()) == 整数_1) {
                生活保護扶助種類 = 最新生活保護扶助種類.get扶助種類コード();
            }
        }
        賦課情報一時Entity.setSeihofujoShurui(生活保護扶助種類.value().value());
    }

    /**
     * 特徴仮算定計算後賦課情報_特徴停止entityを作成のメソッドです。
     *
     * @param entity TokuchoKariKeisangoFukaTempEntity
     * @param 特徴仮算定計算後賦課情報_特徴停止 TokuchoKarisanteiKekkaIchiranTeisiEntity
     */
    public void set特徴仮算定計算後賦課情報_特徴停止(TokuchoKariKeisangoFukaTempEntity entity,
            TokuchoKarisanteiKekkaIchiranTeisiEntity 特徴仮算定計算後賦課情報_特徴停止) {
        entity.setChoteiNendo(特徴仮算定計算後賦課情報_特徴停止.get賦課Newest().getChoteiNendo());
        entity.setFukaNendo(特徴仮算定計算後賦課情報_特徴停止.get賦課Newest().getFukaNendo());
        entity.setTsuchishoNo(特徴仮算定計算後賦課情報_特徴停止.get賦課Newest().getTsuchishoNo());
        entity.setKoseiZengoKubun(RString.EMPTY);
        entity.setSakuseiShoriName(RString.EMPTY);
        entity.setFukaRirekiNo(特徴仮算定計算後賦課情報_特徴停止.get賦課Newest().getRirekiNo());
        entity.setHihokenshaNo(特徴仮算定計算後賦課情報_特徴停止.get賦課Newest().getHihokenshaNo());
        entity.setShikibetsuCode(特徴仮算定計算後賦課情報_特徴停止.get賦課Newest().getShikibetsuCode());
        entity.setSetaiCode(SetaiCode.EMPTY);
        entity.setSetaiInsu(整数_0);
        entity.setShikakuShutokuYMD(FlexibleDate.EMPTY);
        entity.setShikakuShutokuJiyu(RString.EMPTY);
        entity.setShikakuSoshitsuYMD(FlexibleDate.EMPTY);
        entity.setShikakuSoshitsuJiyu(RString.EMPTY);
        entity.setSeihofujoShurui(RString.EMPTY);
        entity.setSeihoKaishiYMD(FlexibleDate.EMPTY);
        entity.setSeihoHaishiYMD(FlexibleDate.EMPTY);
        entity.setRonenKaishiYMD(FlexibleDate.EMPTY);
        entity.setRonenHaishiYMD(FlexibleDate.EMPTY);
        entity.setFukaYMD(FlexibleDate.EMPTY);
        entity.setKazeiKubun(RString.EMPTY);
        entity.setSetaikazeiKubun(RString.EMPTY);
        entity.setGokeiShotokuGaku(Decimal.ZERO);
        entity.setNenkinShunyuGaku(Decimal.ZERO);
        entity.setHokenryoDankai(RString.EMPTY);
        entity.setHokenryoDankai1(RString.EMPTY);
        entity.setNengakuHokenryo1(Decimal.ZERO);
        entity.setTsukiwariStartYM1(FlexibleYearMonth.EMPTY);
        entity.setTsukiwariEndYM1(FlexibleYearMonth.EMPTY);
        entity.setHokenryoDankai2(RString.EMPTY);
        entity.setNengakuHokenryo2(Decimal.ZERO);
        entity.setTsukiwariStartYM2(FlexibleYearMonth.EMPTY);
        entity.setTsukiwariEndYM2(FlexibleYearMonth.EMPTY);
        entity.setChoteiNichiji(特徴仮算定計算後賦課情報_特徴停止.get賦課Newest().getChoteiNichiji());
        entity.setChoteiJiyu1(RString.EMPTY);
        entity.setChoteiJiyu2(RString.EMPTY);
        entity.setChoteiJiyu3(RString.EMPTY);
        entity.setChoteiJiyu4(RString.EMPTY);
        entity.setKoseiM(RString.EMPTY);
        entity.setGemmenMaeHokenryo(Decimal.ZERO);
        entity.setGemmenGaku(Decimal.ZERO);
        entity.setKakuteiHokenryo(Decimal.ZERO);
        entity.setHokenryoDankaiKarisanntei(RString.EMPTY);
        entity.setChoshuHohoRirekiNo(整数_0);
        entity.setIdoKijunNichiji(特徴仮算定計算後賦課情報_特徴停止.get賦課Newest().getIdoKijunNichiji());
        entity.setKozaKubun(RString.EMPTY);
        entity.setKyokaisoKubun(RString.EMPTY);
        entity.setShokkenKubun(RString.EMPTY);
        entity.setFukaShichosonCode(LasdecCode.EMPTY);
        entity.setTkSaishutsuKampuGaku(Decimal.ZERO);
        entity.setFuSaishutsuKampuGaku(Decimal.ZERO);
        entity.setTkKibetsuGaku01(Decimal.ZERO);
        entity.setTkKibetsuGaku02(Decimal.ZERO);
        entity.setTkKibetsuGaku03(Decimal.ZERO);
        entity.setTkKibetsuGaku04(Decimal.ZERO);
        entity.setTkKibetsuGaku05(Decimal.ZERO);
        entity.setTkKibetsuGaku06(Decimal.ZERO);
        entity.setFuKibetsuGaku01(Decimal.ZERO);
        entity.setFuKibetsuGaku02(Decimal.ZERO);
        entity.setFuKibetsuGaku03(Decimal.ZERO);
        entity.setFuKibetsuGaku04(Decimal.ZERO);
        entity.setFuKibetsuGaku05(Decimal.ZERO);
        entity.setFuKibetsuGaku06(Decimal.ZERO);
        entity.setFuKibetsuGaku07(Decimal.ZERO);
        entity.setFuKibetsuGaku08(Decimal.ZERO);
        entity.setFuKibetsuGaku09(Decimal.ZERO);
        entity.setFuKibetsuGaku10(Decimal.ZERO);
        entity.setFuKibetsuGaku11(Decimal.ZERO);
        entity.setFuKibetsuGaku12(Decimal.ZERO);
        entity.setFuKibetsuGaku13(Decimal.ZERO);
        entity.setFuKibetsuGaku14(Decimal.ZERO);
        entity.setChoshuHoho4gatsu(RString.EMPTY);
        entity.setChoshuHoho5gatsu(RString.EMPTY);
        entity.setChoshuHoho6gatsu(RString.EMPTY);
        entity.setChoshuHoho7gatsu(RString.EMPTY);
        entity.setChoshuHoho8gatsu(RString.EMPTY);
        entity.setChoshuHoho9gatsu(RString.EMPTY);
        entity.setChoshuHoho10gatsu(RString.EMPTY);
        entity.setChoshuHoho11gatsu(RString.EMPTY);
        entity.setChoshuHoho12gatsu(RString.EMPTY);
        entity.setChoshuHoho1gatsu(RString.EMPTY);
        entity.setChoshuHoho2gatsu(RString.EMPTY);
        entity.setChoshuHoho3gatsu(RString.EMPTY);
        entity.setChoshuHohoYoku4gatsu(RString.EMPTY);
        entity.setChoshuHohoYoku5gatsu(RString.EMPTY);
        entity.setChoshuHohoYoku6gatsu(RString.EMPTY);
        entity.setChoshuHohoYoku7gatsu(RString.EMPTY);
        entity.setChoshuHohoYoku8gatsu(RString.EMPTY);
        entity.setChoshuHohoYoku9gatsu(RString.EMPTY);
        entity.setKariNenkinNo(特徴仮算定計算後賦課情報_特徴停止.get徴収方法Newest().getHonNenkinNo());
        entity.setKariNenkinCode(特徴仮算定計算後賦課情報_特徴停止.get徴収方法Newest().getHonNenkinCode());
        entity.setKariHosokuM(特徴仮算定計算後賦課情報_特徴停止.get徴収方法Newest().getHonHosokuM());
        entity.setHonNenkinNo(RString.EMPTY);
        entity.setHonNenkinCode(RString.EMPTY);
        entity.setHonHosokuM(RString.EMPTY);
        entity.setYokunendoKariNenkinNo(特徴仮算定計算後賦課情報_特徴停止.get徴収方法Newest().getHonNenkinNo());
        entity.setYokunendoKariNenkinCode(特徴仮算定計算後賦課情報_特徴停止.get徴収方法Newest().getHonNenkinCode());
        entity.setYokunendoKariHosokuM(特徴仮算定計算後賦課情報_特徴停止.get徴収方法Newest().getHonHosokuM());
        entity.setIraiSohuzumiFlag(false);
        entity.setTsuikaIraiSohuzumiFlag(false);
        entity.setTokuchoTeishiNichiji(特徴仮算定計算後賦課情報_特徴停止.get徴収方法Newest().getTokuchoTeishiNichiji());
        entity.setTokuchoTeishiJiyuCode(特徴仮算定計算後賦課情報_特徴停止.get徴収方法Newest().getTokuchoTeishiJiyuCode());
        entity.setTkShunyuGaku01(Decimal.ZERO);
        entity.setTkShunyuGaku02(Decimal.ZERO);
        entity.setTkShunyuGaku03(Decimal.ZERO);
        entity.setTkShunyuGaku04(Decimal.ZERO);
        entity.setTkShunyuGaku05(Decimal.ZERO);
        entity.setTkShunyuGaku06(Decimal.ZERO);
        entity.setFuShunyuGaku01(Decimal.ZERO);
        entity.setFuShunyuGaku02(Decimal.ZERO);
        entity.setFuShunyuGaku03(Decimal.ZERO);
        entity.setFuShunyuGaku04(Decimal.ZERO);
        entity.setFuShunyuGaku05(Decimal.ZERO);
        entity.setFuShunyuGaku06(Decimal.ZERO);
        entity.setFuShunyuGaku07(Decimal.ZERO);
        entity.setFuShunyuGaku08(Decimal.ZERO);
        entity.setFuShunyuGaku09(Decimal.ZERO);
        entity.setFuShunyuGaku10(Decimal.ZERO);
        entity.setFuShunyuGaku11(Decimal.ZERO);
        entity.setFuShunyuGaku12(Decimal.ZERO);
        entity.setFuShunyuGaku13(Decimal.ZERO);
        entity.setFuShunyuGaku14(Decimal.ZERO);
        UaFt200FindShikibetsuTaishoEntity 宛名 = 特徴仮算定計算後賦課情報_特徴停止.get宛名();
        set宛名(宛名, entity);
        if (!RString.isNullOrEmpty(特徴仮算定計算後賦課情報_特徴停止.get賦課Newest().getHokenryoDankai2())) {
            entity.setDbV2002Fuka_hokenryoDankai(特徴仮算定計算後賦課情報_特徴停止.get賦課Newest().getHokenryoDankai2());
        } else {
            entity.setDbV2002Fuka_hokenryoDankai(特徴仮算定計算後賦課情報_特徴停止.get賦課Newest().getHokenryoDankai1());
        }
        entity.setDbV2002Fuka_kakuteiHokenryo(特徴仮算定計算後賦課情報_特徴停止.get賦課Newest().getKakuteiHokenryo());
        entity.setShutsuryokujunTemp_choshuHoho(RString.EMPTY);
        entity.setShutsuryokujunTemp_tokuchoKaisiTuki(RString.EMPTY);
    }

    /**
     * 特徴仮算定結果情報entityを作成のメソッドです。
     *
     * @param entity TokuchoKariKeisangoFukaTempEntity
     * @param 特徴仮算定結果情報 TokuchoKarisanteiKekkaIchiranEntity
     */
    public void set特徴仮算定結果情報(TokuchoKariKeisangoFukaTempEntity entity, TokuchoKarisanteiKekkaIchiranEntity 特徴仮算定結果情報) {
        entity.setChoteiNendo(特徴仮算定結果情報.get計算後情報().getChoteiNendo());
        entity.setFukaNendo(特徴仮算定結果情報.get計算後情報().getFukaNendo());
        entity.setTsuchishoNo(特徴仮算定結果情報.get計算後情報().getTsuchishoNo());
        entity.setKoseiZengoKubun(特徴仮算定結果情報.get計算後情報().getKoseiZengoKubun());
        entity.setSakuseiShoriName(特徴仮算定結果情報.get計算後情報().getSakuseiShoriName());
        entity.setFukaRirekiNo(特徴仮算定結果情報.get計算後情報().getFukaRirekiNo());
        entity.setHihokenshaNo(特徴仮算定結果情報.get計算後情報().getHihokenshaNo());
        entity.setShikibetsuCode(特徴仮算定結果情報.get計算後情報().getShikibetsuCode());
        entity.setSetaiCode(特徴仮算定結果情報.get計算後情報().getSetaiCode());
        entity.setSetaiInsu(特徴仮算定結果情報.get計算後情報().getSetaiInsu());
        entity.setShikakuShutokuYMD(特徴仮算定結果情報.get計算後情報().getShikakuShutokuYMD());
        entity.setShikakuShutokuJiyu(特徴仮算定結果情報.get計算後情報().getShikakuShutokuJiyu());
        entity.setShikakuSoshitsuYMD(特徴仮算定結果情報.get計算後情報().getShikakuSoshitsuYMD());
        entity.setShikakuSoshitsuJiyu(特徴仮算定結果情報.get計算後情報().getShikakuSoshitsuJiyu());
        entity.setSeihofujoShurui(特徴仮算定結果情報.get計算後情報().getSeihofujoShurui());
        entity.setSeihoKaishiYMD(特徴仮算定結果情報.get計算後情報().getSeihoKaishiYMD());
        entity.setSeihoHaishiYMD(特徴仮算定結果情報.get計算後情報().getSeihoHaishiYMD());
        entity.setRonenKaishiYMD(特徴仮算定結果情報.get計算後情報().getRonenKaishiYMD());
        entity.setRonenHaishiYMD(特徴仮算定結果情報.get計算後情報().getRonenHaishiYMD());
        entity.setFukaYMD(特徴仮算定結果情報.get計算後情報().getFukaYMD());
        entity.setKazeiKubun(特徴仮算定結果情報.get計算後情報().getKazeiKubun());
        entity.setSetaikazeiKubun(特徴仮算定結果情報.get計算後情報().getSetaikazeiKubun());
        entity.setGokeiShotokuGaku(特徴仮算定結果情報.get計算後情報().getGokeiShotokuGaku());
        entity.setNenkinShunyuGaku(特徴仮算定結果情報.get計算後情報().getNenkinShunyuGaku());
        entity.setHokenryoDankai(特徴仮算定結果情報.get計算後情報().getHokenryoDankai());
        entity.setHokenryoDankai1(特徴仮算定結果情報.get計算後情報().getHokenryoDankai1());
        entity.setNengakuHokenryo1(特徴仮算定結果情報.get計算後情報().getNengakuHokenryo1());
        entity.setTsukiwariStartYM1(特徴仮算定結果情報.get計算後情報().getTsukiwariStartYM1());
        entity.setTsukiwariEndYM1(特徴仮算定結果情報.get計算後情報().getTsukiwariEndYM1());
        entity.setHokenryoDankai2(特徴仮算定結果情報.get計算後情報().getHokenryoDankai2());
        entity.setNengakuHokenryo2(特徴仮算定結果情報.get計算後情報().getNengakuHokenryo2());
        entity.setTsukiwariStartYM2(特徴仮算定結果情報.get計算後情報().getTsukiwariStartYM2());
        entity.setTsukiwariEndYM2(特徴仮算定結果情報.get計算後情報().getTsukiwariEndYM2());
        entity.setChoteiNichiji(特徴仮算定結果情報.get計算後情報().getChoteiNichiji());
        entity.setChoteiJiyu1(特徴仮算定結果情報.get計算後情報().getChoteiJiyu1());
        entity.setChoteiJiyu2(特徴仮算定結果情報.get計算後情報().getChoteiJiyu2());
        entity.setChoteiJiyu3(特徴仮算定結果情報.get計算後情報().getChoteiJiyu3());
        entity.setChoteiJiyu4(特徴仮算定結果情報.get計算後情報().getChoteiJiyu4());
        entity.setKoseiM(特徴仮算定結果情報.get計算後情報().getKoseiM());
        entity.setGemmenMaeHokenryo(特徴仮算定結果情報.get計算後情報().getGemmenMaeHokenryo());
        entity.setGemmenGaku(特徴仮算定結果情報.get計算後情報().getGemmenGaku());
        entity.setKakuteiHokenryo(特徴仮算定結果情報.get計算後情報().getKakuteiHokenryo());
        entity.setHokenryoDankaiKarisanntei(特徴仮算定結果情報.get計算後情報().getHokenryoDankaiKarisanntei());
        entity.setChoshuHohoRirekiNo(特徴仮算定結果情報.get計算後情報().getChoshuHohoRirekiNo());
        entity.setIdoKijunNichiji(特徴仮算定結果情報.get計算後情報().getIdoKijunNichiji());
        entity.setKozaKubun(特徴仮算定結果情報.get計算後情報().getKozaKubun());
        entity.setKyokaisoKubun(特徴仮算定結果情報.get計算後情報().getKyokaisoKubun());
        entity.setShokkenKubun(特徴仮算定結果情報.get計算後情報().getShokkenKubun());
        entity.setFukaShichosonCode(特徴仮算定結果情報.get計算後情報().getFukaShichosonCode());
        entity.setTkSaishutsuKampuGaku(特徴仮算定結果情報.get計算後情報().getTkSaishutsuKampuGaku());
        entity.setFuSaishutsuKampuGaku(特徴仮算定結果情報.get計算後情報().getFuSaishutsuKampuGaku());
        entity.setTkKibetsuGaku01(特徴仮算定結果情報.get計算後情報().getTkKibetsuGaku01());
        entity.setTkKibetsuGaku02(特徴仮算定結果情報.get計算後情報().getTkKibetsuGaku02());
        entity.setTkKibetsuGaku03(特徴仮算定結果情報.get計算後情報().getTkKibetsuGaku03());
        entity.setTkKibetsuGaku04(特徴仮算定結果情報.get計算後情報().getTkKibetsuGaku04());
        entity.setTkKibetsuGaku05(特徴仮算定結果情報.get計算後情報().getTkKibetsuGaku05());
        entity.setTkKibetsuGaku06(特徴仮算定結果情報.get計算後情報().getTkKibetsuGaku06());
        entity.setFuKibetsuGaku01(特徴仮算定結果情報.get計算後情報().getFuKibetsuGaku01());
        entity.setFuKibetsuGaku02(特徴仮算定結果情報.get計算後情報().getFuKibetsuGaku02());
        entity.setFuKibetsuGaku03(特徴仮算定結果情報.get計算後情報().getFuKibetsuGaku03());
        entity.setFuKibetsuGaku04(特徴仮算定結果情報.get計算後情報().getFuKibetsuGaku04());
        entity.setFuKibetsuGaku05(特徴仮算定結果情報.get計算後情報().getFuKibetsuGaku05());
        entity.setFuKibetsuGaku06(特徴仮算定結果情報.get計算後情報().getFuKibetsuGaku06());
        entity.setFuKibetsuGaku07(特徴仮算定結果情報.get計算後情報().getFuKibetsuGaku07());
        entity.setFuKibetsuGaku08(特徴仮算定結果情報.get計算後情報().getFuKibetsuGaku08());
        entity.setFuKibetsuGaku09(特徴仮算定結果情報.get計算後情報().getFuKibetsuGaku09());
        entity.setFuKibetsuGaku10(特徴仮算定結果情報.get計算後情報().getFuKibetsuGaku10());
        entity.setFuKibetsuGaku11(特徴仮算定結果情報.get計算後情報().getFuKibetsuGaku11());
        entity.setFuKibetsuGaku12(特徴仮算定結果情報.get計算後情報().getFuKibetsuGaku12());
        entity.setFuKibetsuGaku13(特徴仮算定結果情報.get計算後情報().getFuKibetsuGaku13());
        entity.setFuKibetsuGaku14(特徴仮算定結果情報.get計算後情報().getFuKibetsuGaku14());
        entity.setChoshuHoho4gatsu(特徴仮算定結果情報.get計算後情報().getChoshuHoho4gatsu());
        entity.setChoshuHoho5gatsu(特徴仮算定結果情報.get計算後情報().getChoshuHoho5gatsu());
        entity.setChoshuHoho6gatsu(特徴仮算定結果情報.get計算後情報().getChoshuHoho6gatsu());
        entity.setChoshuHoho7gatsu(特徴仮算定結果情報.get計算後情報().getChoshuHoho7gatsu());
        entity.setChoshuHoho8gatsu(特徴仮算定結果情報.get計算後情報().getChoshuHoho8gatsu());
        entity.setChoshuHoho9gatsu(特徴仮算定結果情報.get計算後情報().getChoshuHoho9gatsu());
        entity.setChoshuHoho10gatsu(特徴仮算定結果情報.get計算後情報().getChoshuHoho10gatsu());
        entity.setChoshuHoho11gatsu(特徴仮算定結果情報.get計算後情報().getChoshuHoho11gatsu());
        entity.setChoshuHoho12gatsu(特徴仮算定結果情報.get計算後情報().getChoshuHoho12gatsu());
        entity.setChoshuHoho1gatsu(特徴仮算定結果情報.get計算後情報().getChoshuHoho1gatsu());
        entity.setChoshuHoho2gatsu(特徴仮算定結果情報.get計算後情報().getChoshuHoho2gatsu());
        entity.setChoshuHoho3gatsu(特徴仮算定結果情報.get計算後情報().getChoshuHoho3gatsu());
        entity.setChoshuHohoYoku4gatsu(特徴仮算定結果情報.get計算後情報().getChoshuHohoYoku4gatsu());
        entity.setChoshuHohoYoku5gatsu(特徴仮算定結果情報.get計算後情報().getChoshuHohoYoku5gatsu());
        entity.setChoshuHohoYoku6gatsu(特徴仮算定結果情報.get計算後情報().getChoshuHohoYoku6gatsu());
        entity.setChoshuHohoYoku7gatsu(特徴仮算定結果情報.get計算後情報().getChoshuHohoYoku7gatsu());
        entity.setChoshuHohoYoku8gatsu(特徴仮算定結果情報.get計算後情報().getChoshuHohoYoku8gatsu());
        entity.setChoshuHohoYoku9gatsu(特徴仮算定結果情報.get計算後情報().getChoshuHohoYoku9gatsu());
        entity.setKariNenkinNo(特徴仮算定結果情報.get計算後情報().getKariNenkinNo());
        entity.setKariNenkinCode(特徴仮算定結果情報.get計算後情報().getKariNenkinCode());
        entity.setKariHosokuM(特徴仮算定結果情報.get計算後情報().getKariHosokuM());
        entity.setHonNenkinNo(特徴仮算定結果情報.get計算後情報().getHonNenkinNo());
        entity.setHonNenkinCode(特徴仮算定結果情報.get計算後情報().getHonNenkinCode());
        entity.setHonHosokuM(特徴仮算定結果情報.get計算後情報().getHonHosokuM());
        entity.setYokunendoKariNenkinNo(特徴仮算定結果情報.get計算後情報().getYokunendoKariNenkinNo());
        entity.setYokunendoKariNenkinCode(特徴仮算定結果情報.get計算後情報().getYokunendoKariNenkinCode());
        entity.setYokunendoKariHosokuM(特徴仮算定結果情報.get計算後情報().getYokunendoKariHosokuM());
        entity.setIraiSohuzumiFlag(特徴仮算定結果情報.get計算後情報().getIraiSohuzumiFlag());
        entity.setTsuikaIraiSohuzumiFlag(特徴仮算定結果情報.get計算後情報().getTsuikaIraiSohuzumiFlag());
        entity.setTokuchoTeishiNichiji(特徴仮算定結果情報.get計算後情報().getTokuchoTeishiNichiji());
        entity.setTokuchoTeishiJiyuCode(特徴仮算定結果情報.get計算後情報().getTokuchoTeishiJiyuCode());
        entity.setTkShunyuGaku01(特徴仮算定結果情報.get計算後情報().getTkShunyuGaku01());
        entity.setTkShunyuGaku02(特徴仮算定結果情報.get計算後情報().getTkShunyuGaku02());
        entity.setTkShunyuGaku03(特徴仮算定結果情報.get計算後情報().getTkShunyuGaku03());
        entity.setTkShunyuGaku04(特徴仮算定結果情報.get計算後情報().getTkShunyuGaku04());
        entity.setTkShunyuGaku05(特徴仮算定結果情報.get計算後情報().getTkShunyuGaku05());
        entity.setTkShunyuGaku06(特徴仮算定結果情報.get計算後情報().getTkShunyuGaku06());
        entity.setFuShunyuGaku01(特徴仮算定結果情報.get計算後情報().getFuShunyuGaku01());
        entity.setFuShunyuGaku02(特徴仮算定結果情報.get計算後情報().getFuShunyuGaku02());
        entity.setFuShunyuGaku03(特徴仮算定結果情報.get計算後情報().getFuShunyuGaku03());
        entity.setFuShunyuGaku04(特徴仮算定結果情報.get計算後情報().getFuShunyuGaku04());
        entity.setFuShunyuGaku05(特徴仮算定結果情報.get計算後情報().getFuShunyuGaku05());
        entity.setFuShunyuGaku06(特徴仮算定結果情報.get計算後情報().getFuShunyuGaku06());
        entity.setFuShunyuGaku07(特徴仮算定結果情報.get計算後情報().getFuShunyuGaku07());
        entity.setFuShunyuGaku08(特徴仮算定結果情報.get計算後情報().getFuShunyuGaku08());
        entity.setFuShunyuGaku09(特徴仮算定結果情報.get計算後情報().getFuShunyuGaku09());
        entity.setFuShunyuGaku10(特徴仮算定結果情報.get計算後情報().getFuShunyuGaku10());
        entity.setFuShunyuGaku11(特徴仮算定結果情報.get計算後情報().getFuShunyuGaku11());
        entity.setFuShunyuGaku12(特徴仮算定結果情報.get計算後情報().getFuShunyuGaku12());
        entity.setFuShunyuGaku13(特徴仮算定結果情報.get計算後情報().getFuShunyuGaku13());
        entity.setFuShunyuGaku14(特徴仮算定結果情報.get計算後情報().getFuShunyuGaku14());
        UaFt200FindShikibetsuTaishoEntity 宛名 = 特徴仮算定結果情報.get宛名();
        set宛名(宛名, entity);
        entity.setDbV2002Fuka_hokenryoDankai(特徴仮算定結果情報.get前年度保険料段階());
        entity.setDbV2002Fuka_kakuteiHokenryo(特徴仮算定結果情報.get確定介護保険料_年額());
        entity.setUeT0511_dtTokubetsuChoshuGimushaCode(特徴仮算定結果情報.get特別徴収業務者コード());
        entity.setShutsuryokujunTemp_choshuHoho(特徴仮算定結果情報.get徴収方法());
        entity.setShutsuryokujunTemp_tokuchoKaisiTuki(特徴仮算定結果情報.get特徴開始月());
    }

    private void set宛名(UaFt200FindShikibetsuTaishoEntity 宛名, TokuchoKariKeisangoFukaTempEntity entity) {
        if (宛名 != null) {
            entity.setAtena_shikibetsuCode(宛名.getShikibetsuCode());
            entity.setAtena_genLasdecCode(宛名.getGenLasdecCode());
            entity.setAtena_kyuLasdecCode(宛名.getKyuLasdecCode());
            entity.setAtena_kyuLasdecCodeRenban(宛名.getKyuLasdecCodeRenban());
            entity.setAtena_gyomuCode(宛名.getGyomuCode());
            entity.setAtena_rirekiNo(宛名.getRirekiNo());
            entity.setAtena_currentFlag(宛名.getCurrentFlag());
            entity.setAtena_juminShubetsuCode(宛名.getJuminShubetsuCode());
            entity.setAtena_kojinNo(宛名.getKojinNo());
            entity.setAtena_hojinNo(宛名.getHojinNo());
            entity.setAtena_shoriYMD(宛名.getShoriYMD());
            entity.setAtena_idoJiyuCode(宛名.getIdoJiyuCode());
            entity.setAtena_idoYMD(宛名.getIdoYMD());
            entity.setAtena_todokedeJiyuCode(宛名.getTodokedeJiyuCode());
            entity.setAtena_todokedeYMD(宛名.getTodokedeYMD());
            entity.setAtena_idoRiyuCode(宛名.getIdoRiyuCode());
            entity.setAtena_meisho(宛名.getMeisho());
            entity.setAtena_kanaMeisho(宛名.getKanaMeisho());
            entity.setAtena_kannaiKangaiKubun(宛名.getKannaiKangaiKubun());
            entity.setAtena_yubinNo(宛名.getYubinNo());
            entity.setAtena_choikiCode(宛名.getChoikiCode());
            entity.setAtena_zenkokuJushoCode(宛名.getZenkokuJushoCode());
            entity.setAtena_jusho(宛名.getJusho());
            entity.setAtena_banchiCode1(宛名.getBanchiCode1());
            entity.setAtena_banchiCode2(宛名.getBanchiCode2());
            entity.setAtena_banchiCode3(宛名.getBanchiCode3());
            entity.setAtena_banchiCode4(宛名.getBanchiCode4());
            entity.setAtena_banchi(宛名.getBanchi());
            entity.setAtena_katagaki(宛名.getKatagaki());
            entity.setAtena_katagakiInjiFlag(宛名.getKatagakiInjiFlag());
            entity.setAtena_gyoseikuCode(宛名.getGyoseikuCode());
            entity.setAtena_gyoseikuName(宛名.getGyoseikuName());
            entity.setAtena_chikuCode1(宛名.getChikuCode1());
            entity.setAtena_chikuName1(宛名.getChikuName1());
            entity.setAtena_chikuCode2(宛名.getChikuCode2());
            entity.setAtena_chikuName2(宛名.getChikuName2());
            entity.setAtena_chikuCode3(宛名.getChikuCode3());
            entity.setAtena_chikuName3(宛名.getChikuName3());
            entity.setAtena_shogakkokuCode(宛名.getShogakkokuCode());
            entity.setAtena_shogakkokuName(宛名.getShogakkokuName());
            entity.setAtena_chugakkokuCode(宛名.getChugakkokuCode());
            entity.setAtena_chugakkokuName(宛名.getChugakkokuName());
            entity.setAtena_tohyokuCode(宛名.getTohyokuCode());
            entity.setAtena_tohyokuName(宛名.getTohyokuName());
            entity.setAtena_juminJotaiCode(宛名.getJuminJotaiCode());
            entity.setAtena_setaiCode(宛名.getSetaiCode());
            entity.setAtena_seinengappiYMD(宛名.getSeinengappiYMD());
            entity.setAtena_seinengappiFushoKubun(宛名.getSeinengappiFushoKubun());
            entity.setAtena_seibetsuCode(宛名.getSeibetsuCode());
            entity.setAtena_tsuzukigaraCode(宛名.getTsuzukigaraCode());
            entity.setAtena_tsuzukigara(宛名.getTsuzukigara());
            entity.setAtena_kazokuNo(宛名.getKazokuNo());
            entity.setAtena_juminhyoHyojijun(宛名.getJuminhyoHyojijun());
            entity.setAtena_kikaYMD(宛名.getKikaYMD());
            entity.setAtena_kanjiShimei(宛名.getKanjiShimei());
            entity.setAtena_kanaShimei(宛名.getKanaShimei());
            entity.setAtena_honsekiZenkokuJushoCode(宛名.getHonsekiZenkokuJushoCode());
            entity.setAtena_honsekiChoikiCode(宛名.getHonsekiChoikiCode());
            entity.setAtena_honsekiJusho(宛名.getHonsekiJusho());
            entity.setAtena_honsekiBanchi(宛名.getHonsekiBanchi());
            entity.setAtena_hittosha(宛名.getHittosha());
            entity.setAtena_gaikokujinShimei(宛名.getGaikokujinShimei());
            entity.setAtena_gaikokujinHeikimei(宛名.getGaikokujinHeikimei());
            entity.setAtena_gaikokujinKanaShimei(宛名.getGaikokujinKanaShimei());
            entity.setAtena_tsushomei(宛名.getTsushomei());
            entity.setAtena_shimeiRiyoKubun(宛名.getShimeiRiyoKubun());
            entity.setAtena_kanaTsushomei(宛名.getKanaTsushomei());
            entity.setAtena_katakanaHyoki(宛名.getKatakanaHyoki());
            entity.setAtena_kokusekiChiikiCode(宛名.getKokusekiChiikiCode());
            entity.setAtena_zairyuShikakuCode(宛名.getZairyuShikakuCode());
            entity.setAtena_zairyuKikanCode(宛名.getZairyuKikanCode());
            entity.setAtena_zairyuKikantoManryoYMD(宛名.getZairyuKikantoManryoYMD());
            entity.setAtena_zairyuCardtoNo(宛名.getZairyuCardtoNo());
            entity.setAtena_zairyuCardtoYukoYMD(宛名.getZairyuCardtoYukoYMD());
            entity.setAtena_dai30Jono45niKiteisuruKubun(宛名.getDai30Jono45niKiteisuruKubun());
            entity.setAtena_setainushiShikibetsuCode(宛名.getSetainushiShikibetsuCode());
            entity.setAtena_setainushiMei(宛名.getSetainushiMei());
            entity.setAtena_hojinKeitaiCode(宛名.getHojinKeitaiCode());
            entity.setAtena_hojinKeitaiMeisho(宛名.getHojinKeitaiMeisho());
            entity.setAtena_hojinKeitaiRyakusho(宛名.getHojinKeitaiRyakusho());
            entity.setAtena_hojinMeishoHenshuKubun(宛名.getHojinMeishoHenshuKubun());
            entity.setAtena_hojinKeitaiRyakushoKubun(宛名.getHojinKeitaiRyakushoKubun());
            entity.setAtena_hojinMeisho(宛名.getHojinMeisho());
            entity.setAtena_hojinKanaMeisho(宛名.getHojinKanaMeisho());
            entity.setAtena_hojinShitenMeisho(宛名.getHojinShitenMeisho());
            entity.setAtena_hojinShitenKanaMeisho(宛名.getHojinShitenKanaMeisho());
            entity.setAtena_daihyoshaShikibetsuCode(宛名.getDaihyoshaShikibetsuCode());
            entity.setAtena_daihyoshaJuminShubetsu(宛名.getDaihyoshaJuminShubetsu());
            entity.setAtena_daihyoshaShimei(宛名.getDaihyoshaShimei());
            entity.setAtena_daihyoshaKanaShimei(宛名.getDaihyoshaKanaShimei());
            entity.setAtena_daihyoshaNihonjinShimei(宛名.getDaihyoshaNihonjinShimei());
            set宛名_After(entity, 宛名);
        }
    }

    private void set宛名_After(TokuchoKariKeisangoFukaTempEntity entity, UaFt200FindShikibetsuTaishoEntity 宛名) {
        entity.setAtena_daihyoshaNihonjinKanaShimei(宛名.getDaihyoshaNihonjinKanaShimei());
        entity.setAtena_daihyoshaGaikokujinShimei(宛名.getDaihyoshaGaikokujinShimei());
        entity.setAtena_daihyoshaGaikokujinHeikimei(宛名.getDaihyoshaGaikokujinHeikimei());
        entity.setAtena_daihyoshaGaikokujinKanaShimei(宛名.getDaihyoshaGaikokujinKanaShimei());
        entity.setAtena_daihyoshaTsushomei(宛名.getDaihyoshaTsushomei());
        entity.setAtena_daihyoshaShimeiRiyoKubun(宛名.getDaihyoshaShimeiRiyoKubun());
        entity.setAtena_daihyoshaKanaTsushomei(宛名.getDaihyoshaKanaTsushomei());
        entity.setAtena_daihyoshaKannaiKangaiKubun(宛名.getDaihyoshaKannaiKangaiKubun());
        entity.setAtena_daihyoshaYubinNo(宛名.getDaihyoshaYubinNo());
        entity.setAtena_daihyoshaChoikiCode(宛名.getDaihyoshaChoikiCode());
        entity.setAtena_daihyoshaZenkokuJushoCode(宛名.getDaihyoshaZenkokuJushoCode());
        entity.setAtena_daihyoshaJusho(宛名.getDaihyoshaJusho());
        entity.setAtena_daihyoshaBanchiCode1(宛名.getDaihyoshaBanchiCode1());
        entity.setAtena_daihyoshaBanchiCode2(宛名.getDaihyoshaBanchiCode2());
        entity.setAtena_daihyoshaBanchiCode3(宛名.getDaihyoshaBanchiCode3());
        entity.setAtena_daihyoshaBanchiCode4(宛名.getDaihyoshaBanchiCode4());
        entity.setAtena_daihyoshaBanchi(宛名.getDaihyoshaBanchi());
        entity.setAtena_daihyoshaKatagaki(宛名.getDaihyoshaKatagaki());
        entity.setAtena_ninkachiendantaiTorokuShikakuKubun(宛名.getNinkachiendantaiTorokuShikakuKubun());
        entity.setAtena_ninkachiendantaiNinkaYMD(宛名.getNinkachiendantaiNinkaYMD());
        entity.setAtena_kojinHojinKBN(宛名.getKojinHojinKBN());
        entity.setAtena_kyoyushaMeisho(宛名.getKyoyushaMeisho());
        entity.setAtena_kyoyushaKanaMeisho(宛名.getKyoyushaKanaMeisho());
        entity.setAtena_torokuJiyuCode(宛名.getTorokuJiyuCode());
        entity.setAtena_torokuIdoYMD(宛名.getTorokuIdoYMD());
        entity.setAtena_torokuTodokedeYMD(宛名.getTorokuTodokedeYMD());
        entity.setAtena_juteiJiyuCode(宛名.getJuteiJiyuCode());
        entity.setAtena_juteiIdoYMD(宛名.getJuteiIdoYMD());
        entity.setAtena_juteiTodokedeYMD(宛名.getJuteiTodokedeYMD());
        entity.setAtena_shojoJiyuCode(宛名.getShojoJiyuCode());
        entity.setAtena_shojoIdoYMD(宛名.getShojoIdoYMD());
        entity.setAtena_shojoTodokedeYMD(宛名.getShojoTodokedeYMD());
        entity.setAtena_jutonaiYubinNo(宛名.getJutonaiYubinNo());
        entity.setAtena_jutonaiChoikiCode(宛名.getJutonaiChoikiCode());
        entity.setAtena_jutonaiJusho(宛名.getJutonaiJusho());
        entity.setAtena_jutonaiBanchiCode1(宛名.getJutonaiBanchiCode1());
        entity.setAtena_jutonaiBanchiCode2(宛名.getJutonaiBanchiCode2());
        entity.setAtena_jutonaiBanchiCode3(宛名.getJutonaiBanchiCode3());
        entity.setAtena_jutonaiBanchiCode4(宛名.getJutonaiBanchiCode4());
        entity.setAtena_jutonaiBanchi(宛名.getJutonaiBanchi());
        entity.setAtena_jutonaiKatagaki(宛名.getJutonaiKatagaki());
        entity.setAtena_jutonaiKatagakiInjiFlag(宛名.getJutonaiKatagakiInjiFlag());
        entity.setAtena_tennyumaeYubinNo(宛名.getTennyumaeYubinNo());
        entity.setAtena_tennyumaeZenkokuJushoCode(宛名.getTennyumaeZenkokuJushoCode());
        entity.setAtena_tennyumaeJusho(宛名.getTennyumaeJusho());
        entity.setAtena_tennyumaeBanchi(宛名.getTennyumaeBanchi());
        entity.setAtena_tennyumaeKatagaki(宛名.getTennyumaeKatagaki());
        entity.setAtena_tennyumaeSetainushimei(宛名.getTennyumaeSetainushimei());
        entity.setAtena_tennyumaeKyusei(宛名.getTennyumaeKyusei());
        entity.setAtena_saishuJutochiYubinNo(宛名.getSaishuJutochiYubinNo());
        entity.setAtena_saishuJutochiZenkokuJushoCode(宛名.getSaishuJutochiZenkokuJushoCode());
        entity.setAtena_saishuJutochiJusho(宛名.getSaishuJutochiJusho());
        entity.setAtena_saishuJutochiBanchi(宛名.getSaishuJutochiBanchi());
        entity.setAtena_saishuJutochiKatagaki(宛名.getSaishuJutochiKatagaki());
        entity.setAtena_saishuJutochiSetainushimei(宛名.getSaishuJutochiSetainushimei());
        entity.setAtena_tenshutsuYoteiIdoYMD(宛名.getTenshutsuYoteiIdoYMD());
        entity.setAtena_tenshutsuYoteiYubinNo(宛名.getTenshutsuYoteiYubinNo());
        entity.setAtena_tenshutsuYoteiZenkokuJushoCode(宛名.getTenshutsuYoteiZenkokuJushoCode());
        entity.setAtena_tenshutsuYoteiJusho(宛名.getTenshutsuYoteiJusho());
        entity.setAtena_tenshutsuYoteiBanchi(宛名.getTenshutsuYoteiBanchi());
        entity.setAtena_tenshutsuYoteiKatagaki(宛名.getTenshutsuYoteiKatagaki());
        entity.setAtena_tenshutsuYoteiSetainushimei(宛名.getTenshutsuYoteiSetainushimei());
        entity.setAtena_tenshutsuKakuteiIdoYMD(宛名.getTenshutsuKakuteiIdoYMD());
        entity.setAtena_tenshutsuKakuteiTsuchiYMD(宛名.getTenshutsuKakuteiTsuchiYMD());
        entity.setAtena_tenshutsuKakuteiYubinNo(宛名.getTenshutsuKakuteiYubinNo());
        entity.setAtena_tenshutsuKakuteiZenkokuJushoCode(宛名.getTenshutsuKakuteiZenkokuJushoCode());
        entity.setAtena_tenshutsuKakuteiJusho(宛名.getTenshutsuKakuteiJusho());
        entity.setAtena_tenshutsuKakuteiBanchi(宛名.getTenshutsuKakuteiBanchi());
        entity.setAtena_tenshutsuKakuteiKatagaki(宛名.getTenshutsuKakuteiKatagaki());
        entity.setAtena_tenshutsuKakuteiSetainushimei(宛名.getTenshutsuKakuteiSetainushimei());
        entity.setAtena_juminhyoUtsushiHakkoSeigyoKubun(宛名.getJuminhyoUtsushiHakkoSeigyoKubun());
        entity.setAtena_renrakusaki1(宛名.getRenrakusaki1());
        entity.setAtena_kensakuRenrakusaki1(宛名.getKensakuRenrakusaki1());
        entity.setAtena_renrakusakiKubun1(宛名.getRenrakusakiKubun1());
        entity.setAtena_renrakusaki2(宛名.getRenrakusaki2());
        entity.setAtena_kensakuRenrakusaki2(宛名.getKensakuRenrakusaki2());
        entity.setAtena_renrakusakiKubun2(宛名.getRenrakusakiKubun2());
        entity.setAtena_renrakusaki3(宛名.getRenrakusaki3());
        entity.setAtena_kensakuRenrakusaki3(宛名.getKensakuRenrakusaki3());
        entity.setAtena_renrakusakiKubun3(宛名.getRenrakusakiKubun3());
        entity.setAtena_mailAddress(宛名.getMailAddress());
        entity.setAtena_biko(宛名.getBiko());
        entity.setAtena_kanaName(宛名.getKanaName());
        entity.setAtena_gaikokujinKanaName(宛名.getGaikokujinKanaName());
        entity.setAtena_kanaTsushoName(宛名.getKanaTsushoName());
        entity.setAtena_jutogaiKanriUpdateCount(宛名.getJutogaiKanriUpdateCount());
        entity.setAtena_jutogaiKanriTorokuNo(宛名.getJutogaiKanriTorokuNo());
        entity.setAtena_jutogaiKojinKihonUpdateCount(宛名.getJutogaiKojinKihonUpdateCount());
        entity.setAtena_jutogaiKojinKihonTorokuNo(宛名.getJutogaiKojinKihonTorokuNo());
        entity.setAtena_jutogaiNihonjinUpdateCount(宛名.getJutogaiNihonjinUpdateCount());
        entity.setAtena_jutogaiNihonjinTorokuNo(宛名.getJutogaiNihonjinTorokuNo());
        entity.setAtena_jutogaiGaikokujinUpdateCount(宛名.getJutogaiGaikokujinUpdateCount());
        entity.setAtena_jutogaiGaikokujinTorokuNo(宛名.getJutogaiGaikokujinTorokuNo());
        entity.setAtena_hojinUpdateCount(宛名.getHojinUpdateCount());
        entity.setAtena_hojinTorokuNo(宛名.getHojinTorokuNo());
        entity.setAtena_kyoyushaUpdateCount(宛名.getKyoyushaUpdateCount());
        entity.setAtena_kyoyushaTorokuNo(宛名.getKyoyushaTorokuNo());
        entity.setAtena_shimeiSearchTorokuNo(宛名.getShimeiSearchTorokuNo());
        entity.setAtena_yusenShimeiUpdateCount(宛名.getYusenShimeiUpdateCount());
        entity.setAtena_yusenShimeiTimestamp(宛名.getYusenShimeiTimestamp());
    }

    /**
     * バッチ出力条件リストを作成のメソッドです。
     *
     * @param 調定年度 FlexibleYear
     * @param 賦課年度 FlexibleYear
     * @param 出力順ID long
     * @param 出力ページ数 RString
     */
    public void loadバッチ出力条件リスト(FlexibleYear 調定年度, FlexibleYear 賦課年度, long 出力順ID, RString 出力ページ数) {
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

    private TokuchoKarisanteiKiwariOutput get特徴仮算定期割(FlexibleYear 調定年度, Decimal 保険料率) {
        TokuchoKariSanteiFukaManager manager = new TokuchoKariSanteiFukaManager();
        return manager.get特徴仮算定期割(調定年度, 保険料率);
    }
}
