/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kogakugassanjikofutangaku;

import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_JikofutangakuShomeishoRealHakkoFlag;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigokogakugassan.Kaigogassan_DataSakuseiKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenDataSaisoFlag;
import jp.co.ndensan.reams.db.dbc.entity.csv.kogakugassanjikofutangakushomeishoin.KogakuGassanJikofutangakuShomeishoInCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassanjikofutangakushomeishoin.DbWT37H1KogakuGassanaJikofutangakuTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassanjikofutangakushomeishoin.DbWT37H2KogakuGassanaJikofutangakuMeisaiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kokuhorenkyotsu.DbWT0001HihokenshaIchijiEntity;
import jp.co.ndensan.reams.db.dbc.service.core.kyufujissekikoshinin.KyufuJissekiKoshinReadCsvFileService;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 高額合算自己負担額証明書情報取込のバッチ用パラメータクラスです。
 *
 * @reamsid_L DBC-2640-010 zhengshenlei
 */
public class KogakuGassanJikofutangakuReadCsvFileService {

    private final Decimal 補正済_合計_自己負担額 = Decimal.ZERO;
    private final Decimal 補正済_合計_70_74自己負担額_内訳 = Decimal.ZERO;
    private final Decimal 補正済_合計_70未満高額支給額 = Decimal.ZERO;
    private final Decimal 補正済_合計_70_74高額支給額 = Decimal.ZERO;
    private final RString 支払場所 = RString.EMPTY;
    private final FlexibleDate 支払期間開始年月日 = FlexibleDate.EMPTY;
    private final FlexibleDate 支払期間終了年月日 = FlexibleDate.EMPTY;
    private final RString 閉庁内容 = RString.EMPTY;
    private final RString 支払期間開始時間 = RString.EMPTY;
    private final RString 支払期間終了時間 = RString.EMPTY;
    private final FlexibleYearMonth 自己負担額確認情報受取年月 = FlexibleYearMonth.EMPTY;
    private final FlexibleYearMonth 補正済自己負担額情報送付年月 = FlexibleYearMonth.EMPTY;
    private final FlexibleYearMonth 自己負担額証明書情報受取年月 = FlexibleYearMonth.EMPTY;
    private final RString 送付対象外フラグ = RString.EMPTY;
    private final FlexibleDate 自己負担額計算年月日 = FlexibleDate.EMPTY;
    private final FlexibleDate 自己負担額証明書作成年月日 = FlexibleDate.EMPTY;
    private final RString 後期_国保処理区分 = RString.EMPTY;
    private final FlexibleDate バッチ補正実施年月日 = FlexibleDate.EMPTY;
    private final FlexibleDate リアル補正実施年月日 = FlexibleDate.EMPTY;
    private final boolean 更新フラグ = false;
    private final boolean 自己負担額差異フラグ = false;
    private final int 履歴番号 = 1;
    private final RString 対象月 = new RString("2");
    private final RString 補正済摘要 = RString.EMPTY;

    /**
     * {@link InstanceProvider#create}にて生成した{@link KyufuJissekiKoshinReadCsvFileService}のインスタンスを返します。
     *
     * @return KyufuJissekiKoshinReadCsvFileService
     */
    public static KogakuGassanJikofutangakuReadCsvFileService createInstance() {

        return InstanceProvider.create(KogakuGassanJikofutangakuReadCsvFileService.class);
    }

    /**
     * 高額合算自己負担額一時TBL登録する
     *
     * @param 連番 int
     * @param shomeishoInCsvEntity KogakuGassanJikofutangakuShomeishoInCsvEntity
     * @param tableWriter IBatchTableWriter
     */
    public void insert高額合算自己負担額一時TBL(int 連番, KogakuGassanJikofutangakuShomeishoInCsvEntity shomeishoInCsvEntity, IBatchTableWriter tableWriter) {
        DbWT37H1KogakuGassanaJikofutangakuTempEntity temp = new DbWT37H1KogakuGassanaJikofutangakuTempEntity();
        temp.setRenban(連番);
        temp.setHokenshaNoIn(new HihokenshaNo(shomeishoInCsvEntity.get被保険者_証_番号()));
        temp.setTaishoNendo(new FlexibleYear(shomeishoInCsvEntity.get対象年度()));
        temp.setShoKisaiHokenshaNo(new ShoKisaiHokenshaNo(shomeishoInCsvEntity.get保険者番号()));
        temp.setShikyuShinseishoSeiriNo(shomeishoInCsvEntity.get支給申請書整理番号());
        temp.setRirekiNo(履歴番号);
        temp.setHokenSeidoCode(shomeishoInCsvEntity.get保険制度コード());
        temp.setHokenshaMei(shomeishoInCsvEntity.get保険者名称());
        temp.setKokuho_HihokenshaShoKigo(shomeishoInCsvEntity.get突合用国保被保険者個人番号());
        temp.setHihokenshaShimeiKana(new AtenaKanaMeisho(shomeishoInCsvEntity.get被保険者氏名_カナ()));
        temp.setHihokenshaShimei(new AtenaMeisho(shomeishoInCsvEntity.get被保険者氏名_漢字()));
        temp.setUmareYMD(new FlexibleDate(shomeishoInCsvEntity.get生年月日()));
        temp.setSeibetsuCode(new Code(shomeishoInCsvEntity.get性別()));
        temp.setShotokuKubun(shomeishoInCsvEntity.get所得区分());
        temp.setOver70_ShotokuKubun(shomeishoInCsvEntity.get七十歳以上の者に係る所得区分());
        temp.setJikoFutanSeiriNo(shomeishoInCsvEntity.get自己負担額証明書整理番号());
        temp.setKoki_HokenshaNo(shomeishoInCsvEntity.get突合用後期高齢者医療保険者番号());
        temp.setKoki_HihokenshaNo(shomeishoInCsvEntity.get突合用後期高齢者医療被保険者番号());
        temp.setKokuho_HokenshaNo(shomeishoInCsvEntity.get突合用国民健康保険保険者番号());
        temp.setKokuho_HihokenshaShoNo(shomeishoInCsvEntity.get突合用国民健康保険被保険者証番号());
        temp.setKokuho_KojinNo(shomeishoInCsvEntity.get突合用国保被保険者個人番号());
        temp.setIdoKubun(shomeishoInCsvEntity.get異動区分());
        temp.setHoseiZumiSofuKubun(shomeishoInCsvEntity.get補正済自己負担額送付区分());
        temp.setTaishoKeisanKaishiYMD(new FlexibleDate(shomeishoInCsvEntity.get対象計算期間_開始()));
        temp.setTaishoKeisanShuryoYMD(new FlexibleDate(shomeishoInCsvEntity.get対象計算期間_終了()));
        temp.setHihokenshaKaishiYMD(new FlexibleDate(shomeishoInCsvEntity.get被保険者期間_開始()));
        temp.setHihokenshaShuryoYMD(new FlexibleDate(shomeishoInCsvEntity.get被保険者期間_終了()));
        temp.setShinseiYMD(new FlexibleDate(shomeishoInCsvEntity.get申請年月日()));
        temp.setGokei_JikoFutanGaku(new Decimal(shomeishoInCsvEntity.get対象年度合計欄_自己負担額().toString()));
        temp.setGokei_70_74JikoFutanGaku(new Decimal(shomeishoInCsvEntity.get対象年度合計欄_うち70_74歳の者に係る負担額().toString()));
        temp.setGokei_Under70KogakuShikyuGaku(
                new Decimal(shomeishoInCsvEntity.get対象年度合計欄_高額療養費_高額介護_予防_サービス費_支給額_70歳未満().toString()));
        temp.setGokei_70_74KogakuShikyuGaku(
                new Decimal(shomeishoInCsvEntity.get対象年度合計欄_高額療養費_高額介護_予防_サービス費_支給額_70_74歳().toString()));
        temp.setSumi_Gokei_JikoFutanGaku(補正済_合計_自己負担額);
        temp.setSumi_Gokei_70_74JikoFutanGaku(補正済_合計_70_74自己負担額_内訳);
        temp.setSumi_Gokei_Under70KogakuShikyuGaku(補正済_合計_70未満高額支給額);
        temp.setSumi_Gokei_70_74KogakuShikyuGaku(補正済_合計_70_74高額支給額);
        temp.setAtesakiShimei(new AtenaMeisho(shomeishoInCsvEntity.get宛先情報_宛先氏名_漢字()));
        temp.setAtesakiYubinNo(new YubinNo(shomeishoInCsvEntity.get宛先情報_宛先郵便番号()));
        temp.setAtesakiJusho(shomeishoInCsvEntity.get宛先情報_宛先住所_漢字());
        temp.setMadoguchi_TaishoshaHanteiCode(shomeishoInCsvEntity.get窓口払対象者判定コード());
        temp.setShiharaiBasho(支払場所);
        temp.setShikaraiKaishiYMD(支払期間開始年月日);
        temp.setShiharaiShuryoYMD(支払期間終了年月日);
        temp.setHeichoNaiyo(閉庁内容);
        temp.setShiharaiKaishiTime(支払期間開始時間);
        temp.setShiharaiShuryoTime(支払期間終了時間);
        temp.setBiko(shomeishoInCsvEntity.get備考欄());
        temp.setDataSakuseiKubun(Kaigogassan_DataSakuseiKubun.国保連取込情報.getコード());
        temp.setKakunin_UketoriYM(自己負担額確認情報受取年月);
        temp.setHoseiZumi_SofuYM(補正済自己負担額情報送付年月);
        temp.setShomeisho_UketoriYM(自己負担額証明書情報受取年月);
        temp.setSaisoFlag(KokuhorenDataSaisoFlag.再送不要.getコード());
        temp.setSofuTaishoGaiFlag(送付対象外フラグ);
        temp.setJikoFutanKeisanYMD(自己負担額計算年月日);
        temp.setShomeiShoSakuseiYMD(自己負担額証明書作成年月日);
        temp.setKoki_KokuhoShoriKubun(後期_国保処理区分);
        temp.setJikoFutangakuShomeishoRealHakkoFlag(KaigoGassan_JikofutangakuShomeishoRealHakkoFlag.未発行.getコード());
        temp.setBatchHoseiJissiYMD(バッチ補正実施年月日);
        temp.setRealHoseiJissiYMD(リアル補正実施年月日);
        temp.setKoshinFlag(更新フラグ);
        temp.setJikoFutangakuSaiFlag(自己負担額差異フラグ);
        tableWriter.insert(temp);
    }

    /**
     * 高額合算自己負担額明細一時TBL登録する
     *
     * @param 連番 int
     * @param shomeishoInCsvEntity KogakuGassanJikofutangakuShomeishoInCsvEntity
     * @param tableWriter IBatchTableWriter
     */
    public void insert高額合算自己負担額明細一時TBL(int 連番, KogakuGassanJikofutangakuShomeishoInCsvEntity shomeishoInCsvEntity, IBatchTableWriter tableWriter) {
        DbWT37H2KogakuGassanaJikofutangakuMeisaiTempEntity temp = new DbWT37H2KogakuGassanaJikofutangakuMeisaiTempEntity();
        temp.setRenban(連番);
        temp.setHokenshaNoIn(new HihokenshaNo(shomeishoInCsvEntity.get被保険者_証_番号()));
        temp.setTaishoNendo(new FlexibleYear(shomeishoInCsvEntity.get対象年度()));
        temp.setShoKisaiHokenshaNo(new ShoKisaiHokenshaNo(shomeishoInCsvEntity.get保険者番号()));
        temp.setShikyuShinseishoSeiriNo(shomeishoInCsvEntity.get支給申請書整理番号());
        temp.setRirekiNo(履歴番号);
        temp.setTaishoM(対象月);
        temp.setJikoFutanGaku(
                new Decimal(shomeishoInCsvEntity.get対象年度翌年2月分_自己負担額().toString()));
        temp.setUchisu_70_74JikoFutanGaku(
                new Decimal(shomeishoInCsvEntity.get対象年度翌年2月分_うち70_74歳の者に係る負担額().toString()));
        temp.setUnder_70KogakuShikyuGaku(
                new Decimal(shomeishoInCsvEntity.get対象年度翌年2月分_高額療養費_高額介護_予防_サービス費_支給額_70歳未満().toString()));
        temp.setOver_70_74KogakuShikyuGaku(
                new Decimal(shomeishoInCsvEntity.get対象年度翌年2月分_高額療養費_高額介護_予防_サービス費_支給額_70_74歳().toString()));
        temp.setTekiyo(shomeishoInCsvEntity.get対象年度翌年2月分_摘要());
        temp.setSumi_JikoFutanGaku(補正済_合計_自己負担額);
        temp.setSumi_70_74JikoFutanGaku(補正済_合計_70_74自己負担額_内訳);
        temp.setSumi_under_70KogakuShikyuGaku(補正済_合計_70未満高額支給額);
        temp.setSumi_70_74KogakuShikyuGaku(補正済_合計_70_74高額支給額);
        temp.setSumi_Tekiyo(補正済摘要);
        temp.setJikoFutangakuSaiFlag(自己負担額差異フラグ);
        tableWriter.insert(temp);
    }

    /**
     * 被保険者一時TBL登録する
     *
     * @param 連番 int
     * @param shomeishoInCsvEntity KogakuGassanJikofutangakuShomeishoInCsvEntity
     * @param tableWriter IBatchTableWriter
     */
    public void insert被保険者一時TBL(int 連番, KogakuGassanJikofutangakuShomeishoInCsvEntity shomeishoInCsvEntity, IBatchTableWriter tableWriter) {
        DbWT0001HihokenshaIchijiEntity hihoken = new DbWT0001HihokenshaIchijiEntity();
        hihoken.setMeisaiRenban(連番);
        RString 被保険者番号 = shomeishoInCsvEntity.get被保険者_証_番号();
        RString 保険者番号 = shomeishoInCsvEntity.get保険者番号();
        if (保険者番号 != null && !保険者番号.isEmpty()) {
            hihoken.setShoHokenshaNo(new ShoKisaiHokenshaNo(保険者番号));
        }
        if (被保険者番号 != null && !被保険者番号.isEmpty()) {
            hihoken.setOrgHihokenshaNo(new HihokenshaNo(被保険者番号));
        }
        hihoken.setServiceTeikyoYmd(FlexibleDate.getNowDate());
        hihoken.setOrgHihokenshaKanaShimei(shomeishoInCsvEntity.get被保険者氏名_カナ());
        hihoken.setOrgHihokenshaShimei(shomeishoInCsvEntity.get被保険者氏名_カナ());
        hihoken.setOldShichosonCode(LasdecCode.EMPTY);
        hihoken.setHenkanHihokenshaNo(HihokenshaNo.EMPTY);
        hihoken.setHihokenshaNo(new HihokenshaNo(被保険者番号));
        hihoken.setShichosonCode(LasdecCode.EMPTY);
        hihoken.setKannaiKangaiKubun(RString.EMPTY);
        hihoken.setYubinNo(RString.EMPTY);
        hihoken.setChoikiCode(RString.EMPTY);
        hihoken.setGyoseikuCode(RString.EMPTY);
        hihoken.setGyoseikuMei(RString.EMPTY);
        hihoken.setJusho(RString.EMPTY);
        hihoken.setBanchi(RString.EMPTY);
        hihoken.setKatagaki(RString.EMPTY);
        hihoken.setKanaMeisho(RString.EMPTY);
        hihoken.setMeisho(RString.EMPTY);
        hihoken.setShimei50onKana(RString.EMPTY);
        hihoken.setShikakuShutokuYmd(FlexibleDate.EMPTY);
        hihoken.setShikakuShutokuJiyuCode(RString.EMPTY);
        hihoken.setShikakuSoshitsuYmd(FlexibleDate.EMPTY);
        hihoken.setShikakuSoshitsuJiyuCode(RString.EMPTY);
        hihoken.setSetaiShuyakuNo(HihokenshaNo.EMPTY);
        tableWriter.insert(hihoken);
    }
}
