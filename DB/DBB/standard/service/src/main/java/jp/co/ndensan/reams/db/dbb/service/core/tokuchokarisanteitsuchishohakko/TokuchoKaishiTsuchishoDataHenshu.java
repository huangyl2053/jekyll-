/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.tokuchokarisanteitsuchishohakko;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jp.co.ndensan.reams.db.dbb.business.core.fukaatena.FukaAtena;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJoho;
import jp.co.ndensan.reams.db.dbb.definition.core.choshuhoho.ChoshuHohoKibetsu;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.TokuchoKaishiTsuhishoKariOutputJoken;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajoho.fukajoho.FukaJohoRelateEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajoho.kibetsu.KibetsuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.keisangojoho.DbTKeisangoJohoTempTableEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchokarisanteitsuchishohakko.TsuchishoDataTempEntity;
import jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbx.business.core.fuka.Fuka;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2003KibetsuEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.UrT0705ChoteiKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7065ChohyoSeigyoKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7067ChohyoSeigyoHanyoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7065ChohyoSeigyoKyotsuDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7067ChohyoSeigyoHanyoDac;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.report.daikoprint.DaikoPrintItem;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.ur.urz.service.report.daikoprint.DaikoPrintFactory;
import jp.co.ndensan.reams.ur.urz.service.report.daikoprint.IDaikoPrint;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * ビジネス設計_DBBBZ33002_1_特徴仮算定通知書一括発行（バッチ）
 *
 * @reamsid_L DBB-0790-040 chenaoqi
 */
public class TokuchoKaishiTsuchishoDataHenshu {

    private final DbT7065ChohyoSeigyoKyotsuDac 帳票制御共通Dac;
    private final DbT7067ChohyoSeigyoHanyoDac 帳票制御汎用Dac;
    private static final RString 定数_特徴方法 = new RString("getTkKibetsuGaku");
    private static final RString 定数_普徴方法 = new RString("getFuKibetsuGaku");
    private static final RString 定数_出力条件 = new RString("出力条件");
    private static final RString 定数_発行日 = new RString("【発行日】");
    private static final RString 定数_出力対象 = new RString("【出力対象】");
    private static final RString 定数_出力順 = new RString("【出力順】");
    private static final RString 定数_抽出条件 = new RString("抽出条件");
    private static final RString 定数_帳票名 = new RString("特別徴収開始通知書（仮算定）");
    private static final RString 定数_処理名 = new RString("「特徴仮算定通知書一括発行」");
    private static final RString ジョブ番号 = new RString("【ジョブ番号】");
    private static final RString SIGN = new RString(" ＞ ");
    private static final RString 定値_0 = new RString("0");
    private static final RString 定値_1 = new RString("1");
    private static final RString 定値_2 = new RString("2");
    private static final RString 定値_3 = new RString("3");
    private static final RString 定値_4 = new RString("4");
    private static final ReportId 帳票分類ID = new ReportId("DBB100003_TokubetsuChoshuKaishiTsuchishoKariDaihyo");
    private static final ReportId 代行プリント送付票_帳票ID = new ReportId("URU000A10_DaikoPrintCheck");
    private static final int INT_1 = 1;
    private static final int INT_5 = 5;
    private static final int INT_7 = 7;
    private static final int INT_14 = 14;

    /**
     * テスト用コンストラクタです。
     */
    public TokuchoKaishiTsuchishoDataHenshu() {
        this.帳票制御共通Dac = InstanceProvider.create(DbT7065ChohyoSeigyoKyotsuDac.class);
        this.帳票制御汎用Dac = InstanceProvider.create(DbT7067ChohyoSeigyoHanyoDac.class);
    }

    /**
     * 該当クラスの対象を返す。
     *
     * @return TokuchoKaishiTsuchishoDataHenshu 該当クラスの対象
     */
    public static TokuchoKaishiTsuchishoDataHenshu createInstance() {
        return InstanceProvider.create(TokuchoKaishiTsuchishoDataHenshu.class);
    }

    /**
     * バッチ出力条件リストの出力
     *
     * @param 出力条件リスト List<RString>
     * @param 帳票ID ReportId
     * @param 出力ページ数 RString
     * @param csv出力有無 RString
     * @param csvファイル名 RString
     * @param 帳票名 RString
     */
    public void loadバッチ出力条件リスト(List<RString> 出力条件リスト, ReportId 帳票ID, RString 出力ページ数,
            RString csv出力有無, RString csvファイル名, RString 帳票名) {
        Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
        RString 導入団体コード = 地方公共団体.getLasdecCode_().value();
        RString 市町村名 = 地方公共団体.get市町村名();
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

    /**
     * 代行プリント送付票の出力
     *
     * @param 発行日 FlexibleDate
     * @param 出力対象区分 RString
     * @param 帳票制御共通情報 ChohyoSeigyoKyotsu
     * @param 地方公共団体 Association
     * @param 出力順ID RString
     * @param ページ数 Decimal
     */
    public void load代行プリント送付票(FlexibleDate 発行日, RString 出力対象区分,
            ChohyoSeigyoKyotsu 帳票制御共通情報,
            Association 地方公共団体, RString 出力順ID, Decimal ページ数) {
        if (!帳票制御共通情報.is代行プリント有無()) {
            return;
        }
        List<RString> 出力順項目List = new ArrayList<>();
        List<RString> 改ページ項目List = new ArrayList<>();
        set出力順_改頁(出力順ID, 出力順項目List, 改ページ項目List);
        List<RString> 抽出条件List = new ArrayList<>();
        RStringBuilder builder = new RStringBuilder();
        builder.append(定数_抽出条件);
        抽出条件List.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(定数_発行日.concat(RString.FULL_SPACE).concat(発行日.wareki().toDateString()));
        抽出条件List.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(定数_出力対象
                .concat(TokuchoKaishiTsuhishoKariOutputJoken.valueOf(出力対象区分.toString()).get名称()));
        抽出条件List.add(builder.toRString());
        List<RString> 帳票名List = new ArrayList<>();
        帳票名List.add(定数_帳票名);
        List<Decimal> ページ数List = new ArrayList<>();
        ページ数List.add(ページ数);
        DaikoPrintItem daikoPrintItem = new DaikoPrintItem(SubGyomuCode.DBB介護賦課,
                地方公共団体.getLasdecCode_(), 地方公共団体.get市町村名(),
                ジョブ番号.concat(RString.FULL_SPACE).concat(new RString(String.valueOf(JobContextHolder.getJobId()))),
                定数_処理名, 代行プリント送付票_帳票ID.getColumnValue(), 帳票名List, ページ数List, 抽出条件List,
                出力順項目List, 改ページ項目List, null);
        IDaikoPrint daikoPrint = DaikoPrintFactory.createInstance(daikoPrintItem);
        daikoPrint.print();
    }

    /**
     * 出力対象のメソッドです。
     *
     * @param 出力対象 RString
     * @return 出力対象
     */
    public RString get出力対象(RString 出力対象) {
        RString 出力対象code = RString.EMPTY;
        if (TokuchoKaishiTsuhishoKariOutputJoken.全件_追加候補者含む.get名称().equals(出力対象)) {
            出力対象code = 定値_0;
        } else if (TokuchoKaishiTsuhishoKariOutputJoken.全件_追加候補者含まない.get名称().equals(出力対象)) {
            出力対象code = 定値_1;
        } else if (TokuchoKaishiTsuhishoKariOutputJoken.追加候補者のみ全て.get名称().equals(出力対象)) {
            出力対象code = 定値_2;
        } else if (TokuchoKaishiTsuhishoKariOutputJoken._4月特別徴収開始の追加候補者のみ.get名称().equals(出力対象)) {
            出力対象code = 定値_3;
        } else if (TokuchoKaishiTsuhishoKariOutputJoken._6月特別徴収開始の追加候補者のみ.get名称().equals(出力対象)) {
            出力対象code = 定値_4;
        }
        return 出力対象code;
    }

    /**
     * 帳票制御共通情報取得メソッドです。
     *
     * @param 帳票分類ID ReportId
     * @return ChohyoSeigyoKyotsu 帳票制御共通情報
     */
    public ChohyoSeigyoKyotsu load帳票制御共通(ReportId 帳票分類ID) {

        DbT7065ChohyoSeigyoKyotsuEntity entity = 帳票制御共通Dac.selectByKey(SubGyomuCode.DBB介護賦課, 帳票分類ID);
        if (entity == null) {
            return null;
        }
        return new ChohyoSeigyoKyotsu(entity);
    }

    /**
     * 帳票制御汎用取得メソッドです。
     *
     * @param 帳票分類ID 帳票分類ID
     * @param 管理年度 管理年度
     * @param 項目名 項目名
     * @return ChohyoSeigyoHanyo
     */
    public ChohyoSeigyoHanyo load帳票制御汎用ByKey(ReportId 帳票分類ID,
            FlexibleYear 管理年度, RString 項目名) {
        DbT7067ChohyoSeigyoHanyoEntity entity
                = 帳票制御汎用Dac.select帳票制御汎用キー(SubGyomuCode.DBB介護賦課, 帳票分類ID, 管理年度, 項目名);
        if (entity == null) {
            return null;
        }
        return new ChohyoSeigyoHanyo(entity);
    }

    /**
     * 賦課の情報の取得
     *
     * @param tempEntity TsuchishoDataTempEntity
     * @return 賦課の情報
     */
    public FukaAtena get賦課の情報(TsuchishoDataTempEntity tempEntity) {

        FukaAtena fukaAtena = new FukaAtena();
        DbTKeisangoJohoTempTableEntity 計算後情報 = tempEntity.get計算後情報();

        if (計算後情報 == null || 計算後情報.getChoteiNendo() == null || 計算後情報.getChoteiNendo().isEmpty()
                || 計算後情報.getFukaNendo() == null || 計算後情報.getFukaNendo().isEmpty()
                || 計算後情報.getTsuchishoNo() == null || 計算後情報.getTsuchishoNo().isEmpty()) {
            return null;
        }
        Fuka fuka = new Fuka(計算後情報.getChoteiNendo(), 計算後情報.getFukaNendo(),
                計算後情報.getTsuchishoNo(), 計算後情報.getFukaRirekiNo());
        fuka = fuka.createBuilderForEdit().set被保険者番号(計算後情報.getHihokenshaNo())
                .set識別コード(計算後情報.getShikibetsuCode())
                .set世帯コード(計算後情報.getSetaiCode()).set世帯員数(計算後情報.getSetaiInsu())
                .set資格取得日(計算後情報.getShikakuShutokuYMD()).set資格取得事由(計算後情報.getShikakuShutokuJiyu())
                .set資格喪失日(計算後情報.getShikakuSoshitsuYMD()).set資格喪失事由(計算後情報.getShikakuSoshitsuJiyu())
                .set生活保護扶助種類(計算後情報.getSeihofujoShurui()).set生保開始日(計算後情報.getSeihoKaishiYMD())
                .set生保廃止日(計算後情報.getSeihoHaishiYMD()).set老年開始日(計算後情報.getRonenKaishiYMD())
                .set老年廃止日(計算後情報.getRonenHaishiYMD()).set賦課期日(計算後情報.getFukaYMD())
                .set課税区分(計算後情報.getKazeiKubun()).set世帯課税区分(計算後情報.getSetaikazeiKubun())
                .set合計所得金額(計算後情報.getGokeiShotokuGaku()).set公的年金収入額(計算後情報.getNenkinShunyuGaku())
                .set保険料段階(計算後情報.getHokenryoDankai()).set保険料算定段階1(計算後情報.getHokenryoDankai1())
                .set算定年額保険料1(計算後情報.getNengakuHokenryo1()).set保険料算定段階2(計算後情報.getHokenryoDankai2())
                .set算定年額保険料2(計算後情報.getNengakuHokenryo2()).set調定日時(計算後情報.getChoteiNichiji())
                .set調定事由1(計算後情報.getChoteiJiyu1()).set調定事由2(計算後情報.getChoteiJiyu2())
                .set調定事由3(計算後情報.getChoteiJiyu3()).set調定事由4(計算後情報.getChoteiJiyu4())
                .set更正月(計算後情報.getKoseiM()).set減免前介護保険料_年額(計算後情報.getGemmenMaeHokenryo())
                .set減免額(計算後情報.getGemmenGaku()).set確定介護保険料_年額(計算後情報.getKakuteiHokenryo())
                .set保険料段階_仮算定時(計算後情報.getHokenryoDankaiKarisanntei())
                .set徴収方法履歴番号(計算後情報.getChoshuHohoRirekiNo())
                .set異動基準日時(計算後情報.getIdoKijunNichiji()).set口座区分(計算後情報.getKozaKubun())
                .set境界層区分(計算後情報.getKyokaisoKubun()).set職権区分(計算後情報.getShokkenKubun())
                .set賦課市町村コード(計算後情報.getFukaShichosonCode()).set特徴歳出還付額(計算後情報.getTkSaishutsuKampuGaku())
                .set普徴歳出還付額(計算後情報.getFuSaishutsuKampuGaku()).set月割開始年月1(計算後情報.getTsukiwariStartYM1())
                .set月割終了年月1(計算後情報.getTsukiwariEndYM1()).set月割開始年月2(計算後情報.getTsukiwariStartYM2())
                .set月割終了年月2(計算後情報.getTsukiwariEndYM2()).build();
        FukaJohoRelateEntity fukaJohoRelateEntity = new FukaJohoRelateEntity();
        fukaJohoRelateEntity.set介護賦課Entity(fuka.toEntity());
        List<KibetsuEntity> 介護期別RelateEntity = new ArrayList<>();
        for (int index = INT_1; index < INT_7; index++) {
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
            調定共通EntityList.add(調定共通Entity);
            介護期別Relate.set介護期別Entity(介護期別Entity);
            介護期別Relate.set調定共通Entity(調定共通EntityList);
            介護期別RelateEntity.add(介護期別Relate);
        }
        for (int index = INT_1; index <= INT_14; index++) {
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
            調定共通Entity.setChoteigaku(get普通調定額(計算後情報, index));
            調定共通EntityList.add(調定共通Entity);
            介護期別Relate.set介護期別Entity(介護期別Entity);
            介護期別Relate.set調定共通Entity(調定共通EntityList);
            介護期別RelateEntity.add(介護期別Relate);
        }
        fukaJohoRelateEntity.set介護期別RelateEntity(介護期別RelateEntity);
        FukaJoho 賦課情報 = new FukaJoho(fukaJohoRelateEntity);
        fukaAtena.set賦課情報(賦課情報);
        IKojin 宛名 = ShikibetsuTaishoFactory.createKojin(tempEntity.get宛名());
        fukaAtena.set宛名(宛名);
        return fukaAtena;
    }

    /**
     * 賦課情報の取得
     *
     * @param fukaJohoRelateEntity FukaJohoRelateEntity
     * @param 期別金額リスト List<Decimal>
     * @return 賦課情報
     */
    public FukaJoho get賦課情報(FukaJohoRelateEntity fukaJohoRelateEntity, List<Decimal> 期別金額リスト) {
        if (fukaJohoRelateEntity == null) {
            return null;
        }
        DbT2002FukaEntity 介護賦課Entity = fukaJohoRelateEntity.get介護賦課Entity();
        List<KibetsuEntity> 介護期別RelateEntity = new ArrayList<>();
        int i = 0;
        for (int index = INT_1; index < INT_7; index++) {
            KibetsuEntity 介護期別Relate = new KibetsuEntity();
            DbT2003KibetsuEntity 介護期別Entity = new DbT2003KibetsuEntity();
            介護期別Entity.setChoteiNendo(介護賦課Entity.getChoteiNendo());
            介護期別Entity.setFukaNendo(介護賦課Entity.getFukaNendo());
            介護期別Entity.setTsuchishoNo(介護賦課Entity.getTsuchishoNo());
            介護期別Entity.setRirekiNo(介護賦課Entity.getRirekiNo());
            介護期別Entity.setChoteiId(new Decimal(index));
            介護期別Entity.setChoshuHouhou(ChoshuHohoKibetsu.特別徴収.getコード());
            介護期別Entity.setKi(index);
            List<UrT0705ChoteiKyotsuEntity> 調定共通EntityList = new ArrayList<>();
            UrT0705ChoteiKyotsuEntity 調定共通Entity = new UrT0705ChoteiKyotsuEntity();
            調定共通Entity.setChoteiId(new Decimal(index).longValue());
            調定共通Entity.setChoteigaku(期別金額リスト.get(i));
            調定共通EntityList.add(調定共通Entity);
            介護期別Relate.set介護期別Entity(介護期別Entity);
            介護期別Relate.set調定共通Entity(調定共通EntityList);
            介護期別RelateEntity.add(介護期別Relate);
            i = i + INT_1;
        }
        fukaJohoRelateEntity.set介護期別RelateEntity(介護期別RelateEntity);
        return new FukaJoho(fukaJohoRelateEntity);

    }

    /**
     * 徴収方法情報の取得
     *
     * @param tempEntity TsuchishoDataTempEntity
     * @return 徴収方法情報
     */
    public ChoshuHoho get徴収方法情報(TsuchishoDataTempEntity tempEntity) {

        DbTKeisangoJohoTempTableEntity 計算後情報 = tempEntity.get計算後情報();

        if (計算後情報 == null || 計算後情報.getFukaNendo() == null || 計算後情報.getFukaNendo().isEmpty()
                || 計算後情報.getHihokenshaNo() == null || 計算後情報.getHihokenshaNo().isEmpty()) {
            return null;
        }
        ChoshuHoho 徴収方法情報 = new ChoshuHoho(計算後情報.getFukaNendo(),
                計算後情報.getHihokenshaNo(), 計算後情報.getChoshuHohoRirekiNo());
        徴収方法情報 = 徴収方法情報.createBuilderForEdit().set徴収方法4月(計算後情報.getChoshuHoho4gatsu())
                .set徴収方法5月(計算後情報.getChoshuHoho5gatsu()).set徴収方法6月(計算後情報.getChoshuHoho6gatsu())
                .set徴収方法7月(計算後情報.getChoshuHoho7gatsu()).set徴収方法8月(計算後情報.getChoshuHoho8gatsu())
                .set徴収方法9月(計算後情報.getChoshuHoho9gatsu()).set徴収方法10月(計算後情報.getChoshuHoho10gatsu())
                .set徴収方法11月(計算後情報.getChoshuHoho11gatsu()).set徴収方法12月(計算後情報.getChoshuHoho12gatsu())
                .set徴収方法1月(計算後情報.getChoshuHoho1gatsu()).set徴収方法2月(計算後情報.getChoshuHoho2gatsu())
                .set徴収方法3月(計算後情報.getChoshuHoho3gatsu()).set徴収方法翌4月(計算後情報.getChoshuHohoYoku4gatsu())
                .set徴収方法翌5月(計算後情報.getChoshuHohoYoku5gatsu()).set徴収方法翌6月(計算後情報.getChoshuHohoYoku6gatsu())
                .set徴収方法翌7月(計算後情報.getChoshuHohoYoku7gatsu()).set徴収方法翌8月(計算後情報.getChoshuHohoYoku8gatsu())
                .set徴収方法翌9月(計算後情報.getChoshuHohoYoku9gatsu()).set仮徴収_基礎年金番号(計算後情報.getKariNenkinNo())
                .set仮徴収_年金コード(計算後情報.getKariNenkinCode()).set仮徴収_捕捉月(計算後情報.getKariHosokuM())
                .set本徴収_基礎年金番号(計算後情報.getHonNenkinNo()).set本徴収_年金コード(計算後情報.getHonNenkinCode())
                .set本徴収_捕捉月(計算後情報.getHonHosokuM()).set翌年度仮徴収_基礎年金番号(計算後情報.getYokunendoKariNenkinNo())
                .set翌年度仮徴収_年金コード(計算後情報.getYokunendoKariNenkinCode())
                .set翌年度仮徴収_捕捉月(計算後情報.getYokunendoKariHosokuM())
                .set依頼情報送付済みフラグ(計算後情報.isIraiSohuzumiFlag())
                .set追加依頼情報送付済みフラグ(計算後情報.isTsuikaIraiSohuzumiFlag())
                .set特別徴収停止日時(計算後情報.getTokuchoTeishiNichiji())
                .set特別徴収停止事由コード(計算後情報.getTokuchoTeishiJiyuCode()).build();
        return 徴収方法情報;
    }

    private Decimal get特徴調定額(DbTKeisangoJohoTempTableEntity entity, int index) {
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
            Logger.getLogger(TokuchoKaishiTsuchishoDataHenshu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 特徴調定額;
    }

    private Decimal get普通調定額(DbTKeisangoJohoTempTableEntity entity, int index) {
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
            Logger.getLogger(TokuchoKaishiTsuchishoDataHenshu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 普通調定額;
    }

    /**
     * 帳票名の取得
     *
     * @param 帳票ID RString
     * @return 帳票名
     */
    public RString get帳票名_特徴(RString 帳票ID) {

        if (ReportIdDBB.DBB100003.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100003.getReportName();
        } else if (ReportIdDBB.DBB100004.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100004.getReportName();
        } else if (ReportIdDBB.DBB100005.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100005.getReportName();
        } else if (ReportIdDBB.DBB100006.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100006.getReportName();
        } else if (ReportIdDBB.DBB100008.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100008.getReportName();
        } else if (ReportIdDBB.DBB100009.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100009.getReportName();
        }
        return RString.EMPTY;
    }

    /**
     * 出力条件リストの取得
     *
     * @param 発行日 FlexibleDate
     * @param 出力対象区分 RString
     * @param 出力順ID RString
     * @return 出力条件リスト
     */
    public List<RString> get出力条件リスト(FlexibleDate 発行日, RString 出力対象区分,
            RString 出力順ID) {
        List<RString> 出力条件リスト = new ArrayList<>();
        RStringBuilder builder = new RStringBuilder();
        builder.append(定数_出力条件);
        出力条件リスト.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(定数_発行日.concat(RString.FULL_SPACE).concat(発行日.wareki().toDateString()));
        出力条件リスト.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(定数_出力対象.concat(RString.FULL_SPACE)
                .concat(RString.isNullOrEmpty(出力対象区分) ? RString.EMPTY : TokuchoKaishiTsuhishoKariOutputJoken.valueOf(出力対象区分.toString()).get名称()));
        出力条件リスト.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(定数_出力順.concat(RString.FULL_SPACE));
        IChohyoShutsuryokujunFinder fider = ChohyoShutsuryokujunFinderFactory.createInstance();
        IOutputOrder outputOrder = null;
        if (出力順ID != null && !出力順ID.isEmpty()) {
            outputOrder = fider.get出力順(SubGyomuCode.DBB介護賦課, 帳票分類ID, Long.valueOf(出力順ID.toString()));
        }
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
        出力条件リスト.add(builder.toRString());
        return 出力条件リスト;
    }

    private void set出力順_改頁(RString 出力順ID, List<RString> 出力順項目List, List<RString> 改ページ項目List) {
        IChohyoShutsuryokujunFinder fider = ChohyoShutsuryokujunFinderFactory.createInstance();
        IOutputOrder outputOrder = fider.get出力順(SubGyomuCode.DBB介護賦課, 帳票分類ID, Long.valueOf(出力順ID.toString()));
        if (outputOrder == null || outputOrder.get設定項目リスト() == null) {
            return;
        }
        int i = INT_1;
        for (ISetSortItem setSortItem : outputOrder.get設定項目リスト()) {
            if (i <= INT_5) {
                出力順項目List.add(setSortItem.get項目名());
                if (setSortItem.is改頁項目()) {
                    改ページ項目List.add(setSortItem.get項目名());
                }
            }
            i = i + INT_1;
        }
    }
}
