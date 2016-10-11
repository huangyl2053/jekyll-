/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.dbc020080;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_ErrorKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_ErrorListType;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc020080.DBC020080ProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc020080.DBC020080ShoriKekkaCSVEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3070KogakuGassanJikoFutanGakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc020080.DBC020080ShoriKekkaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc020080.DBC020080TaishoDataEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc020080.JissekiFutangakuDataTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc020080.RiyoshaFutangakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.gassanjikofutangakukeisankekkaichiran.GassanJikofutangakuKeisanKekkaIchiranEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.util.DateConverter;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.AgeCalculator;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.DateOfBirthFactory;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.IDateOfBirth;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.AgeArrivalDay;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DoitsuninDaihyoshaYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * バッチ設計_DBCMN62006_自己負担額計算（一括）のDBC020080DataUtilクラスです。
 *
 * @reamsid_L DBC-2060-030 liuyang
 */
public class DBC020080DataUtil {

    private static final int ERRORINDEX = -1;
    private static final int NUM_3 = 3;

    private static final int NUM_4 = 4;
    private static final int NUM_5 = 5;
    private static final int NUM_6 = 6;
    private static final int NUM_8 = 8;
    private static final int NUM_15 = 15;

    private static final int NUM_70 = 70;

    private static final int NUM_75 = 75;
    private static final RString INITSERVICETEIKYOYMS = new RString("0000000000000000");
    private static final RString ZERO = new RString("0");
    private static final RString ONE = new RString("1");
    private static final RString TWO = new RString("2");

    private static final RString THREE = new RString("3");
    private static final RString LINE = new RString("|");
    private static final RString 当年 = new RString("0");
    private static final RString 翌年 = new RString("1");
    private static final RString SET = new RString("set");
    private static final RString JIKOFUTANGAKU = new RString("JikoFutanGaku");
    private static final RString UCHISU_70_74JIKOFUTANGAKU = new RString("Uchisu_70_74JikoFutanGaku");
    private static final RString UNDER_70KOGAKUSHIKYUGAKU = new RString("Under_70KogakuShikyuGaku");
    private static final RString OVER_70_74KOGAKUSHIKYUGAKU = new RString("Over_70_74KogakuShikyuGaku");
    private static final RString TEKIYO = new RString("Tekiyo");
    private static final RString SUMI_JIKOFUTANGAKU = new RString("Sumi_JikoFutanGaku");
    private static final RString SUMI_70_74JIKOFUTANGAKU = new RString("Sumi_70_74JikoFutanGaku");
    private static final RString SUMI_UNDER_70KOGAKUSHIKYUGAKU = new RString("Sumi_under_70KogakuShikyuGaku");
    private static final RString SUMI_70_74KOGAKUSHIKYUGAKU = new RString("Sumi_70_74KogakuShikyuGaku");
    private static final RString SUMI_TEKIYO = new RString("Sumi_Tekiyo");
    private static final RString JIKOFUTANGAKUWORK = new RString("JikoFutangakuWork");
    private static final RString UCHISUJIKOFUTANGAKU = new RString("UchisuJikoFutanGaku");
    private static final RString BIKO = new RString("Biko");
    private static final RString 当年4月 = new RString("004");
    private static final RString 当年5月 = new RString("005");
    private static final RString 当年6月 = new RString("006");
    private static final RString 当年7月 = new RString("007");
    private static final RString 当年8月 = new RString("008");
    private static final RString 当年9月 = new RString("009");
    private static final RString 当年10月 = new RString("010");
    private static final RString 当年11月 = new RString("011");
    private static final RString 当年12月 = new RString("012");
    private static final RString 翌年1月 = new RString("101");
    private static final RString 翌年2月 = new RString("102");
    private static final RString 翌年3月 = new RString("103");
    private static final RString 翌年4月 = new RString("104");
    private static final RString 翌年5月 = new RString("105");
    private static final RString 翌年6月 = new RString("106");
    private static final RString 翌年7月 = new RString("107");
    private static final RString MESSAGE = new RString("対象となるデータが存在しません。");
    private static final RString 左括弧 = new RString("【");
    private static final RString 中間括弧 = new RString("】、【");
    private static final RString 右括弧 = new RString("】");
    private static final RString SETBIKO = new RString("setBiko");
    private static final RString GETJIKOFUTANGAKUWORK = new RString("getJikoFutangakuWork");
    private static final RString GETSUMI_JIKOFUTANGAKU = new RString("getSumi_JikoFutanGaku");
    private static final RString SETJIKOFUTANGAKUWORK = new RString("setJikoFutangakuWork");
    private static final RString 給付額減額 = new RString("給付額減額");
    private static final RString 資格期間エラー = new RString("資格期間エラー");
    private static final FlexibleYear 新規年度 = new FlexibleYear("0000");
    private static final RString 新規処理枝番 = new RString("0000");
    private static final RString 新規年度内連番 = new RString("0001");
//    private static final RString 連番フォーマット = new RString("0000");
    private static final RString 作成日時 = new RString("作成日時");
    private static final RString 処理名 = new RString("処理名");
    private static final RString 証記載保険者番号 = new RString("証記載保険者番号");
    private static final RString 被保険者番号 = new RString("被保険者番号");
    private static final RString 被保険者カナ氏名 = new RString("被保険者カナ氏名");
    private static final RString 被保険者氏名 = new RString("被保険者氏名");
    private static final RString エラー内容 = new RString("エラー内容");
    private static final RString 備考 = new RString("備考");
    private final List<RString> suffixList;
    private static final Class CLS = JissekiFutangakuDataTempEntity.class;
    private static final Class DECIMALCLS = Decimal.class;
    private static final Class RSTRINGCLS = RString.class;
    private static final Class DATAUTILCLS = DBC020080DataUtil.class;

    /**
     * DBC020080DataUtilのコンストラクタです。
     */
    public DBC020080DataUtil() {
        suffixList = new ArrayList<>();
        suffixList.add(当年4月);
        suffixList.add(当年5月);
        suffixList.add(当年6月);
        suffixList.add(当年7月);
        suffixList.add(当年8月);
        suffixList.add(当年9月);
        suffixList.add(当年10月);
        suffixList.add(当年11月);
        suffixList.add(当年12月);
        suffixList.add(翌年1月);
        suffixList.add(翌年2月);
        suffixList.add(翌年3月);
        suffixList.add(翌年4月);
        suffixList.add(翌年5月);
        suffixList.add(翌年6月);
        suffixList.add(翌年7月);
    }

    /**
     * get出力順リストのメソッドです。
     *
     * @param 出力順項目 Map<Integer, ISetSortItem>
     * @return List<RString>
     */
    public List<RString> get出力順リスト(Map<Integer, ISetSortItem> 出力順項目) {
        List<RString> 出力順リスト = new ArrayList<>();
        for (Map.Entry<Integer, ISetSortItem> sub : 出力順項目.entrySet()) {
            出力順リスト.add(sub.getValue().get項目名());
        }
        setFullList(出力順リスト);
        return 出力順リスト;
    }

    /**
     * get出力順リストのメソッドです。
     *
     * @param 改頁項目 Map<Integer, RString>
     * @return List<RString>
     */
    public List<RString> get改頁リスト(Map<Integer, RString> 改頁項目) {
        List<RString> 改頁リスト = new ArrayList<>();
        for (Map.Entry<Integer, RString> sub : 改頁項目.entrySet()) {
            改頁リスト.add(sub.getValue());
        }
        setFullList(改頁リスト);
        return 改頁リスト;
    }

    /**
     * setFullListのメソッドです。
     *
     * @param 対象リスト List<RString>
     */
    public void setFullList(List<RString> 対象リスト) {
        if (対象リスト == null) {
            対象リスト = new ArrayList<>();
            for (int i = 0; i < NUM_5; i++) {
                対象リスト.add(RString.EMPTY);
            }
            return;
        }
        int size = 対象リスト.size();
        if (size < NUM_5) {
            for (int i = 0; i < NUM_5 - size; i++) {
                対象リスト.add(RString.EMPTY);
            }
        }
    }

    /**
     * 実績負担額データ一時表のデータを取得のメソッドです。<br/>
     * 対象者抽出　処理時
     *
     * @param entity DBC020080TaishoDataEntity
     * @param 処理日時 RDateTime
     * @param 市町村名 RString
     * @return JissekiFutangakuDataTempEntity
     */
    public JissekiFutangakuDataTempEntity toJissekiTempEntityTaishoChuShu(DBC020080TaishoDataEntity entity,
            RDateTime 処理日時, RString 市町村名) {
        JissekiFutangakuDataTempEntity result = new JissekiFutangakuDataTempEntity();
        result.setShinseibiMikeisanKubun(ONE);
        result.setSeiriNo(entity.getSeiriNo());
        result.setRirekiNo(nonullRStr(entity.getRirekiNo()));
        result.setJikoFutanKeisanYMD(nonullRStr(getRDate(処理日時)));
        result.setHihokenshaNo(nonullRStr(entity.getTaishoHihokenshaNo()));
        result.setTaishoNendo(nonullRStr(entity.getTaishoNendo()));
        result.setHokenshaNo(nonullRStr(entity.getHokenshaNo()));
        result.setShikyuShinseishoSeiriNo(entity.getShikyuShinseishoSeiriNo());
        result.setHokenSeidoCode(THREE);
        result.setHokenshaMei(市町村名);
        result.setKokuho_HihokenshaShoKigo(entity.getKokuho_HihokenshaShoKigo());
        result.setHihokenshaShimeiKana(nonullRStr(entity.getKanaMeisho()));
        result.setHihokenshaShimei(nonullRStr(entity.getMeisho()));
        result.setUmareYMD(nonullRStr(entity.getSeinengappiYMD()));
        result.setSeibetsuCode(entity.getSeibetsuCode());
        result.setTaishoKeisanKaishiYMD(nonullRStr(entity.getTaishoKeisanKaishiYMD()));
        result.setTaishoKeisanShuryoYMD(nonullRStr(entity.getTaishoKeisanShuryoYMD()));
        RString 被保険者期間開始 = nonullRStr(entity.getKanyuKaishiYMD());
        RString 被保険者期間終了 = nonullRStr(entity.getKanyuKaishiYMD());
        result.setHihokenshaKaishiYMD(被保険者期間開始);
        result.setHihokenshaShuryoYMD(被保険者期間終了);
        result.setShinseiYMD(nonullRStr(entity.getShinseiYMD()));
        result.setDataKubun(ONE);
        result.setIchiranShikibetsuCode(nonullRStr(entity.getShikibetsuCode()));
        result.setIchiranShichosonCode(nonullRStr(entity.getShichosonCode()));
        result.setIchiranYubinNo(nonullRStr(entity.getYubinNo()));
        result.setIchiranChoikiCode(nonullRStr(entity.getChoikiCode()));
        result.setIchiranGyoseikuCode(nonullRStr(entity.getGyoseikuCode()));
        result.setIchiranBiko(被保険者期間開始.isEmpty() && 被保険者期間終了.isEmpty() ? 資格期間エラー : RString.EMPTY);
        initJissekiFutangakuDataTempEntity(result);
        return result;
    }

    private void initJissekiFutangakuDataTempEntity(JissekiFutangakuDataTempEntity result) {
        result.setShotokuKubun(RString.EMPTY);
        result.setOver70_ShotokuKubun(RString.EMPTY);
        result.setJikoFutanSeiriNo(RString.EMPTY);
        result.setKoki_HokenshaNo(RString.EMPTY);
        result.setKoki_HihokenshaNo(RString.EMPTY);
        result.setKokuho_HokenshaNo(RString.EMPTY);
        result.setKokuho_HihokenshaShoNo(RString.EMPTY);
        result.setKokuho_KojinNo(RString.EMPTY);
        result.setIdoKubun(RString.EMPTY);
        result.setHoseiZumiSofuKubun(RString.EMPTY);
        result.setGokei_JikoFutanGaku(Decimal.ZERO);
        result.setGokei_70_74JikoFutanGaku(Decimal.ZERO);
        result.setGokei_Under70KogakuShikyuGaku(Decimal.ZERO);
        result.setGokei_70_74KogakuShikyuGaku(Decimal.ZERO);
        result.setSumi_Gokei_JikoFutanGaku(Decimal.ZERO);
        result.setSumi_Gokei_70_74JikoFutanGaku(Decimal.ZERO);
        result.setSumi_Gokei_Under70KogakuShikyuGaku(Decimal.ZERO);
        result.setSumi_Gokei_70_74KogakuShikyuGaku(Decimal.ZERO);
        result.setAtesakiShimei(RString.EMPTY);
        result.setAtesakiYubinNo(RString.EMPTY);
        result.setAtesakiJusho(RString.EMPTY);
        result.setMadoguchi_TaishoshaHanteiCode(RString.EMPTY);
        result.setShiharaiBasho(RString.EMPTY);
        result.setShikaraiKaishiYMD(RString.EMPTY);
        result.setShiharaiShuryoYMD(RString.EMPTY);
        result.setShikaraiKaishiYMDYobi(RString.EMPTY);
        result.setShiharaiShuryoYMDYobi(RString.EMPTY);
        result.setShikaraiKaishiYMDJikan(RString.EMPTY);
        result.setShiharaiShuryoYMDJikan(RString.EMPTY);
        result.setBiko(RString.EMPTY);
        result.setDataSakuseiKubun(RString.EMPTY);
        result.setKakunin_UketoriYM(RString.EMPTY);
        result.setHoseiZumi_SofuYM(RString.EMPTY);
        result.setShomeisho_UketoriYM(RString.EMPTY);
        result.setSaisoFlag(RString.EMPTY);
        result.setSofuTaishoGaiFlag(RString.EMPTY);
        result.setJikoFutanKeisanYMD2(RString.EMPTY);
        result.setShomeiShoSakuseiYMD(RString.EMPTY);
        result.setShomeiShoHakoflag(RString.EMPTY);
        result.setBatchHoseiJissiYMD(RString.EMPTY);
        result.setRealHoseiJissiYMD(RString.EMPTY);
        result.setKoki_KokuhoShoriKubun(RString.EMPTY);
        result.setShikyuGakuKeisanYMD(RString.EMPTY);
        result.setJikoFutangakuHosei(RString.EMPTY);
        result.setKogakuShikyuGakuHosei(RString.EMPTY);
        result.setIchiranKakuninKubun(RString.EMPTY);
        result.setIchiranKakuninKubun2(RString.EMPTY);
        loopInitDecimal(result, JIKOFUTANGAKU);
        loopInitDecimal(result, JIKOFUTANGAKU);
        loopInitDecimal(result, UCHISU_70_74JIKOFUTANGAKU);
        loopInitDecimal(result, UNDER_70KOGAKUSHIKYUGAKU);
        loopInitDecimal(result, OVER_70_74KOGAKUSHIKYUGAKU);
        loopInitRString(result, TEKIYO);
        loopInitDecimal(result, SUMI_JIKOFUTANGAKU);
        loopInitDecimal(result, SUMI_70_74JIKOFUTANGAKU);
        loopInitDecimal(result, SUMI_UNDER_70KOGAKUSHIKYUGAKU);
        loopInitDecimal(result, SUMI_70_74KOGAKUSHIKYUGAKU);
        loopInitRString(result, SUMI_TEKIYO);
    }

    private void loopInitDecimal(JissekiFutangakuDataTempEntity 実績負担額, RString tokenName) {
        Method method;
        try {
            for (RString suffix : suffixList) {
                method = CLS.getMethod(SET.concat(tokenName).concat(suffix).toString(), DECIMALCLS);
                method.invoke(実績負担額, Decimal.ZERO);
            }
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(DATAUTILCLS.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loopInitRString(JissekiFutangakuDataTempEntity 実績負担額, RString tokenName) {
        Method method;
        try {
            for (RString suffix : suffixList) {
                method = CLS.getMethod(SET.concat(tokenName).concat(suffix).toString(), RSTRINGCLS);
                method.invoke(実績負担額, RString.EMPTY);
            }
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(DATAUTILCLS.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void singleSetDecimal(JissekiFutangakuDataTempEntity 実績負担額, RString tokenSet, RString tokenGet, int index) {
        RString suffix = suffixList.get(index);
        Method method;
        try {
            method = CLS.getMethod(SET.concat(tokenGet).concat(suffix).toString());
            Decimal dec = (Decimal) method.invoke(実績負担額);
            method = CLS.getMethod(SET.concat(tokenSet).concat(suffix).toString(), DECIMALCLS);
            method.invoke(実績負担額, dec);
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(DATAUTILCLS.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loopSetDecimal(JissekiFutangakuDataTempEntity 実績負担額, RString tokenSet, RString tokenGet) {
        Method method;
        try {
            for (RString suffix : suffixList) {
                method = CLS.getMethod(SET.concat(tokenGet).concat(suffix).toString());
                Decimal dec = (Decimal) method.invoke(実績負担額);
                method = CLS.getMethod(SET.concat(tokenSet).concat(suffix).toString(), DECIMALCLS);
                method.invoke(実績負担額, dec);
            }
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(DATAUTILCLS.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loopSetRString(JissekiFutangakuDataTempEntity 実績負担額, RString tokenSet, RString tokenGet) {
        Method method;
        try {
            for (RString suffix : suffixList) {
                method = CLS.getMethod(SET.concat(tokenGet).concat(suffix).toString());
                RString str = (RString) method.invoke(実績負担額);
                method = CLS.getMethod(SET.concat(tokenSet).concat(suffix).toString(), RSTRINGCLS);
                method.invoke(実績負担額, str);
            }
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(DATAUTILCLS.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loopSetDecimal(JissekiFutangakuDataTempEntity 実績負担額Set, RString tokenSet,
            JissekiFutangakuDataTempEntity 実績負担額Get, RString tokenGet) {
        Method method;
        try {
            for (RString suffix : suffixList) {
                method = CLS.getMethod(SET.concat(tokenGet).concat(suffix).toString());
                Decimal dec = (Decimal) method.invoke(実績負担額Get);
                method = CLS.getMethod(SET.concat(tokenSet).concat(suffix).toString(), DECIMALCLS);
                method.invoke(実績負担額Set, dec);
            }
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(DATAUTILCLS.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Decimal loopAddDecimal(JissekiFutangakuDataTempEntity 実績負担額Get, RString tokenGet) {
        Decimal sum = Decimal.ZERO;
        Method method;
        try {
            for (RString suffix : suffixList) {
                method = CLS.getMethod(SET.concat(tokenGet).concat(suffix).toString());
                Decimal dec = (Decimal) method.invoke(実績負担額Get);
                sum = sum.add(dec);
            }
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(DATAUTILCLS.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return sum;
        }
    }

    private void loopSetRString(JissekiFutangakuDataTempEntity 実績負担額Set, RString tokenSet,
            JissekiFutangakuDataTempEntity 実績負担額Get, RString tokenGet) {
        Method method;
        try {
            for (RString suffix : suffixList) {
                method = CLS.getMethod(SET.concat(tokenGet).concat(suffix).toString());
                RString str = (RString) method.invoke(実績負担額Get);
                method = CLS.getMethod(SET.concat(tokenSet).concat(suffix).toString(), RSTRINGCLS);
                method.invoke(実績負担額Set, str);
            }
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(DATAUTILCLS.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * 処理結果リスト一時表のデータを取得のメソッドです。
     *
     * @param entity DBC020080TaishoDataEntity
     * @param errorType KaigoGassan_ErrorListType
     * @return JissekiFutangakuDataTempEntity
     */
    public DBC020080ShoriKekkaTempEntity toShoriKekkaTempEntity(
            JissekiFutangakuDataTempEntity entity, KaigoGassan_ErrorListType errorType) {
        DBC020080ShoriKekkaTempEntity result = new DBC020080ShoriKekkaTempEntity();
        result.setErrorKubun(errorType.getコード());
        result.setShoHokanehshaNo(nonullRStr(entity.getHokenshaNo()));
        result.setHihokenshaNo(nonullRStr(entity.getHihokenshaNo()));
        result.setHihokenshaKanaShimei(nonullRStr(entity.getHihokenshaShimeiKana()));
        result.setHihokenshaShimei(nonullRStr(entity.getHihokenshaShimei()));
        result.setKey1(nonullRStr(entity.getHihokenshaNo()));
        if (KaigoGassan_ErrorListType.リストタイプ2.equals(errorType)) {
            result.setKey2(entity.getTaishoNendo());
        }
        result.setKey3(RString.EMPTY);
        result.setKey4(RString.EMPTY);
        result.setKey5(RString.EMPTY);
        KaigoGassan_ErrorKubun errorKubun;
        if (KaigoGassan_ErrorListType.リストタイプ0.equals(errorType)) {
            errorKubun = KaigoGassan_ErrorKubun.被保険者情報取得エラー;
        } else if (KaigoGassan_ErrorListType.リストタイプ3.equals(errorType)) {
            errorKubun = KaigoGassan_ErrorKubun.資格期間エラー;
        } else if (KaigoGassan_ErrorListType.リストタイプ2.equals(errorType)) {
            errorKubun = KaigoGassan_ErrorKubun.高額支給額集計エラー;
        } else {
            errorKubun = KaigoGassan_ErrorKubun.宛名取得エラー;
        }
        result.setErrorNaiyo(errorKubun.getキー1());
        result.setBiko(errorKubun.getキー2());
        return result;
    }

    /**
     * DBC020080ShoriKekkaTempEntityのキーを取得します。
     *
     * @param entity DBC020080ShoriKekkaTempEntity
     * @return RString
     */
    public RString getKeyOfShoriKekkaTemp(DBC020080ShoriKekkaTempEntity entity) {
        RStringBuilder key = new RStringBuilder(entity.getErrorKubun());
        key.append(LINE);
        key.append(entity.getShoHokanehshaNo());
        key.append(LINE);
        key.append(entity.getHihokenshaNo());
        key.append(LINE);
        key.append(entity.getKey1());
        key.append(LINE);
        key.append(entity.getKey2());
        key.append(LINE);
        key.append(entity.getKey3());
        key.append(LINE);
        key.append(entity.getKey4());
        key.append(LINE);
        key.append(entity.getKey5());
        return key.toRString();
    }

    /**
     * judge抽出対象自己負担基準額のメソッドです。
     *
     * @param 高額合算自己負担額 DbT3070KogakuGassanJikoFutanGakuEntity
     * @param 抽出対象自己負担基準額 Decimal
     * @return boolean
     */
    public boolean judge抽出対象自己負担基準額(DbT3070KogakuGassanJikoFutanGakuEntity 高額合算自己負担額,
            Decimal 抽出対象自己負担基準額) {
        if (高額合算自己負担額 == null) {
            return false;
        }
        Decimal 補正済_合計_自己負担額 = 高額合算自己負担額.getSumi_Gokei_JikoFutanGaku();
        Decimal 補正済_合計_70未満高額支給額 = 高額合算自己負担額.getSumi_Gokei_Under70KogakuShikyuGaku();
        Decimal sub = nonullDecimal(補正済_合計_自己負担額).subtract(nonullDecimal(補正済_合計_70未満高額支給額));
        return sub.compareTo(nonullDecimal(抽出対象自己負担基準額)) >= 0;
    }

    /**
     * getErrorMessageのメソッドです。
     *
     * @param 実績負担額 JissekiFutangakuDataTempEntity
     * @return RString
     */
    public RString getErrorMessage(JissekiFutangakuDataTempEntity 実績負担額) {
        RString 被保険者番号 = 実績負担額.getHihokenshaNo();
        RString 対象年度 = 実績負担額.getTaishoNendo();
        RStringBuilder メッセージ = new RStringBuilder(左括弧).append(被保険者番号).
                append(中間括弧).append(対象年度).append(右括弧).append(MESSAGE);
        return メッセージ.toRString();
    }

    /**
     * update受託なし処理時のメソッドです。
     *
     * @param 実績負担額 JissekiFutangakuDataTempEntity
     * @param 処理日時 RDateTime
     */
    public void update受託なし処理時(JissekiFutangakuDataTempEntity 実績負担額, RDateTime 処理日時) {
        loopSetDecimal(実績負担額, SUMI_JIKOFUTANGAKU, JIKOFUTANGAKU);
        loopSetDecimal(実績負担額, SUMI_70_74KOGAKUSHIKYUGAKU, UCHISU_70_74JIKOFUTANGAKU);
        loopSetRString(実績負担額, SUMI_TEKIYO, TEKIYO);
        実績負担額.setSumi_Gokei_JikoFutanGaku(実績負担額.getGokei_JikoFutanGaku());
        実績負担額.setSumi_Gokei_70_74JikoFutanGaku(実績負担額.getGokei_70_74JikoFutanGaku());
        RString 処理日 = getDate(処理日時);
        実績負担額.setJikoFutanKeisanYMD2(処理日);
        実績負担額.setBatchHoseiJissiYMD(処理日);
    }

    /**
     * updJIssekiFutangakuTempのメソッドです。
     *
     * @param 実績負担額 JissekiFutangakuDataTempEntity
     * @return boolean
     */
    public boolean updJIssekiFutangakuTemp(JissekiFutangakuDataTempEntity 実績負担額) {
        if (!judgeAgeLessThan75(実績負担額)) {
            return false;
        }
        List<Integer> indexs = getSuffixIndexs(実績負担額);
        if (indexs.isEmpty()) {
            return false;
        }
        FlexibleYear 対象年度 = new FlexibleYear(実績負担額.getTaishoNendo());
        FlexibleYearMonth 算出した年月の翌月 = get70歳年齢到達日前日の翌月(実績負担額);
        FlexibleYearMonth 被保険者期間終了 = new FlexibleYearMonth(実績負担額.getHihokenshaShuryoYMD());
        FlexibleYearMonth サービス提供年月;
        for (int index : indexs) {
            サービス提供年月 = getYMFromIndex(index, 対象年度);
            if (サービス提供年月 == null) {
                continue;
            }
            if (算出した年月の翌月.isBeforeOrEquals(サービス提供年月) && サービス提供年月.isBeforeOrEquals(被保険者期間終了)) {
                singleSetDecimal(実績負担額, UCHISUJIKOFUTANGAKU, JIKOFUTANGAKUWORK, index);
            }
        }
        return true;
    }

    /**
     * updJIssekiFutangakuTempAfterProcessのメソッドです。
     *
     * @param 実績負担額Set JissekiFutangakuDataTempEntity
     * @param 実績負担額Get JissekiFutangakuDataTempEntity
     * @param 処理日時 RDateTime
     */
    public void updJIssekiFutangakuTemp償還受託あり(JissekiFutangakuDataTempEntity 実績負担額Set,
            JissekiFutangakuDataTempEntity 実績負担額Get, RDateTime 処理日時) {
        loopSetDecimal(実績負担額Set, JIKOFUTANGAKU, 実績負担額Get, JIKOFUTANGAKUWORK);
        loopSetDecimal(実績負担額Set, UCHISU_70_74JIKOFUTANGAKU, 実績負担額Get, UCHISUJIKOFUTANGAKU);
        loopSetRString(実績負担額Set, TEKIYO, 実績負担額Get, BIKO);
        実績負担額Set.setGokei_JikoFutanGaku(loopAddDecimal(実績負担額Get, JIKOFUTANGAKUWORK));
        実績負担額Set.setGokei_70_74KogakuShikyuGaku(loopAddDecimal(実績負担額Get, UCHISUJIKOFUTANGAKU));
        実績負担額Set.setDataSakuseiKubun(TWO);
        実績負担額Set.setJikoFutanKeisanYMD2(TEKIYO);
        実績負担額Set.setJikoFutanKeisanYMD(nonullRStr(getRDate(処理日時)));
    }

    /**
     * updJIssekiFutangakuTempAfterProcessのメソッドです。
     *
     * @param 実績負担額Set JissekiFutangakuDataTempEntity
     * @param 実績負担額Get JissekiFutangakuDataTempEntity
     * @param 処理日時 RDateTime
     */
    public void updJIssekiFutangakuTemp呼び出し元自己負担額計算(JissekiFutangakuDataTempEntity 実績負担額Set,
            JissekiFutangakuDataTempEntity 実績負担額Get, RDateTime 処理日時) {
        loopSetDecimal(実績負担額Set, JIKOFUTANGAKU, 実績負担額Get, JIKOFUTANGAKUWORK);
        loopSetDecimal(実績負担額Set, UCHISU_70_74JIKOFUTANGAKU, 実績負担額Get, UCHISUJIKOFUTANGAKU);
        loopSetRString(実績負担額Set, TEKIYO, 実績負担額Get, BIKO);
        Decimal sum1 = loopAddDecimal(実績負担額Get, JIKOFUTANGAKUWORK);
        Decimal sum2 = loopAddDecimal(実績負担額Get, UCHISUJIKOFUTANGAKU);
        実績負担額Set.setGokei_JikoFutanGaku(sum1);
        実績負担額Set.setGokei_70_74KogakuShikyuGaku(sum2);
        loopSetDecimal(実績負担額Set, SUMI_JIKOFUTANGAKU, 実績負担額Get, JIKOFUTANGAKUWORK);
        loopSetDecimal(実績負担額Set, SUMI_70_74JIKOFUTANGAKU, 実績負担額Get, UCHISUJIKOFUTANGAKU);
        loopSetRString(実績負担額Set, SUMI_TEKIYO, 実績負担額Get, BIKO);
        実績負担額Set.setSumi_Gokei_JikoFutanGaku(sum1);
        実績負担額Set.setSumi_Gokei_70_74JikoFutanGaku(sum2);
        loopAddDecimal(実績負担額Get, JIKOFUTANGAKUWORK);
        loopAddDecimal(実績負担額Get, UCHISUJIKOFUTANGAKU);
        実績負担額Set.setDataSakuseiKubun(TWO);
        実績負担額Set.setJikoFutanKeisanYMD2(TEKIYO);
        RString 処理日 = nonullRStr(getRDate(処理日時));
        実績負担額Set.setJikoFutanKeisanYMD(処理日);
        実績負担額Set.setBatchHoseiJissiYMD(処理日);
    }

    private FlexibleYearMonth getYMFromIndex(int index, FlexibleYear taishoNendo) {
        if (index == ERRORINDEX) {
            return null;
        }
        RString suffix = suffixList.get(index);
        FlexibleYear 年 = ONE.equals(suffix.substring(0, 1)) ? taishoNendo.plusYear(1) : taishoNendo;
        RString 月 = suffix.substring(1, NUM_3);
        return new FlexibleYearMonth(年.toDateString().concat(月));
    }

    private List<Integer> getSuffixIndexs(JissekiFutangakuDataTempEntity 実績負担額) {
        List<Integer> indexs = new ArrayList<>();
        RString yms = 実績負担額.getServiceTeikyoYMs();
        int index = ERRORINDEX;
        for (int i = 0; i < yms.length(); i++) {
            index = yms.indexOf(ONE, index + 1);
            if (index == ERRORINDEX) {
                break;
            }
            indexs.add(index);
        }
        return indexs;
    }

//    private int getSuffixIndex(JissekiFutangakuDataTempEntity 実績負担額) {
//        FlexibleYearMonth 翌月前日 = get70歳年齢到達日前日の翌月(実績負担額);
//        int 翌月前日年 = 翌月前日.getYearValue();
//        int 翌月前日月 = 翌月前日.getMonthValue();
//        RString 対象年度 = 実績負担額.getTaishoNendo();
//        boolean is翌年 = is翌年(対象年度, 翌月前日年);
//        boolean is当年 = is当年(対象年度, 翌月前日年);
//        if (!is当年 && !is翌年) {
//            return ERRORINDEX;
//        }
//        int index = is当年 ? 翌月前日月 - NUM_4 : 翌月前日月 + NUM_8;
//        if (index > NUM_15 || index < 0) {
//            return ERRORINDEX;
//        }
//        return index;
//    }
    private boolean judgeAgeLessThan75(JissekiFutangakuDataTempEntity 実績負担額) {
        RString umareYMD = 実績負担額.getUmareYMD();
        RString hihokenshaShuryoYMD = 実績負担額.getHihokenshaShuryoYMD();
        IDateOfBirth dob = DateOfBirthFactory.createInstance(getFlexibleDate(umareYMD));
        AgeCalculator ageCalculator = new AgeCalculator(dob, JuminJotai.住民, FlexibleDate.MAX, AgeArrivalDay.当日, getFlexibleDate(hihokenshaShuryoYMD));
        int age = Integer.parseInt(ageCalculator.get年齢().toString());
        return age < NUM_75;
    }

    private FlexibleYearMonth get70歳年齢到達日前日の翌月(JissekiFutangakuDataTempEntity 実績負担額) {
        RString umareYMD = 実績負担額.getUmareYMD();
        IDateOfBirth dob = DateOfBirthFactory.createInstance(getFlexibleDate(umareYMD));
        AgeCalculator ageCalculator = new AgeCalculator(dob, JuminJotai.住民, FlexibleDate.MAX, AgeArrivalDay.前日);
        FlexibleDate age = ageCalculator.get年齢到達日(NUM_70);
        Calendar 前到達70翌月;
        前到達70翌月 = getRealDateCalendar(age);
        前到達70翌月.set(前到達70翌月.get(Calendar.YEAR), 前到達70翌月.get(Calendar.MONTH) + 1, 1);
        FlexibleYearMonth ym = new FlexibleDate(前到達70翌月.get(Calendar.YEAR), 前到達70翌月.get(Calendar.MONTH), 1).getYearMonth();
        return ym;
    }

    private Calendar getRealDateCalendar(FlexibleDate date) {
        if (date == null || date.isEmpty()) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.set(date.getYearValue(), date.getMonthValue(), date.getDayValue());
        return calendar;
    }

    private FlexibleDate getFlexibleDate(RString date) {
        if (date == null) {
            return null;
        }
        if (date.isEmpty()) {
            return FlexibleDate.EMPTY;
        }
        return new FlexibleDate(date.toString());
    }

    private RString getDate(RDateTime dt) {
        if (dt == null) {
            return RString.EMPTY;
        }
        return dt.getDate().toDateString();
    }

    /**
     * clearAreaForInsShiharaihohoHenkoTempProcessのメソッドです。
     *
     * @param entity JissekiFutangakuDataTempEntity
     */
    public void clearAreaForInsShiharaihohoHenkoTempProcess(JissekiFutangakuDataTempEntity entity) {
        entity.setJikoFutangakuWork004(null);
        entity.setJikoFutangakuWork005(null);
        entity.setJikoFutangakuWork006(null);
        entity.setJikoFutangakuWork007(null);
        entity.setJikoFutangakuWork008(null);
        entity.setJikoFutangakuWork009(null);
        entity.setJikoFutangakuWork010(null);
        entity.setJikoFutangakuWork011(null);
        entity.setJikoFutangakuWork012(null);
        entity.setJikoFutangakuWork101(null);
        entity.setJikoFutangakuWork102(null);
        entity.setJikoFutangakuWork103(null);
        entity.setJikoFutangakuWork104(null);
        entity.setJikoFutangakuWork105(null);
        entity.setJikoFutangakuWork106(null);
        entity.setJikoFutangakuWork107(null);
        entity.setUchisuJikoFutanGaku004(null);
        entity.setUchisuJikoFutanGaku005(null);
        entity.setUchisuJikoFutanGaku006(null);
        entity.setUchisuJikoFutanGaku007(null);
        entity.setUchisuJikoFutanGaku008(null);
        entity.setUchisuJikoFutanGaku009(null);
        entity.setUchisuJikoFutanGaku010(null);
        entity.setUchisuJikoFutanGaku011(null);
        entity.setUchisuJikoFutanGaku012(null);
        entity.setUchisuJikoFutanGaku101(null);
        entity.setUchisuJikoFutanGaku102(null);
        entity.setUchisuJikoFutanGaku103(null);
        entity.setUchisuJikoFutanGaku104(null);
        entity.setUchisuJikoFutanGaku105(null);
        entity.setUchisuJikoFutanGaku106(null);
        entity.setUchisuJikoFutanGaku107(null);
        entity.setBiko004(null);
        entity.setBiko005(null);
        entity.setBiko006(null);
        entity.setBiko007(null);
        entity.setBiko008(null);
        entity.setBiko009(null);
        entity.setBiko010(null);
        entity.setBiko011(null);
        entity.setBiko012(null);
        entity.setBiko101(null);
        entity.setBiko102(null);
        entity.setBiko103(null);
        entity.setBiko104(null);
        entity.setBiko105(null);
        entity.setBiko106(null);
        entity.setBiko107(null);
    }

    /**
     * init自己負担額内数ワークエリアのメソッドです。
     *
     * @param entity JissekiFutangakuDataTempEntity
     */
    public void init自己負担額内数ワークエリア(JissekiFutangakuDataTempEntity entity) {
        if (entity == null) {
            return;
        }
        entity.setUchisuJikoFutanGaku004(Decimal.ZERO);
        entity.setUchisuJikoFutanGaku005(Decimal.ZERO);
        entity.setUchisuJikoFutanGaku006(Decimal.ZERO);
        entity.setUchisuJikoFutanGaku007(Decimal.ZERO);
        entity.setUchisuJikoFutanGaku008(Decimal.ZERO);
        entity.setUchisuJikoFutanGaku009(Decimal.ZERO);
        entity.setUchisuJikoFutanGaku010(Decimal.ZERO);
        entity.setUchisuJikoFutanGaku011(Decimal.ZERO);
        entity.setUchisuJikoFutanGaku012(Decimal.ZERO);
        entity.setUchisuJikoFutanGaku101(Decimal.ZERO);
        entity.setUchisuJikoFutanGaku102(Decimal.ZERO);
        entity.setUchisuJikoFutanGaku103(Decimal.ZERO);
        entity.setUchisuJikoFutanGaku104(Decimal.ZERO);
        entity.setUchisuJikoFutanGaku105(Decimal.ZERO);
        entity.setUchisuJikoFutanGaku106(Decimal.ZERO);
        entity.setUchisuJikoFutanGaku107(Decimal.ZERO);
    }

    /**
     * ワークエリア初期化のメソッドです。
     *
     * @param insEntity JissekiFutangakuDataTempEntity
     * @param 該当する年月 RString
     */
    public void insShiharaihohoHenkoTemp(JissekiFutangakuDataTempEntity insEntity, RString 該当する年月) {
        if (insEntity == null) {
            return;
        }
        loopInitDecimal(insEntity, JIKOFUTANGAKUWORK);
        loopInitDecimal(insEntity, UCHISUJIKOFUTANGAKU);
        insEntity.setServiceTeikyoYMs(INITSERVICETEIKYOYMS);
        if (該当する年月 == null) {
            return;
        }
        int index = getSuffixIndex(insEntity.getTaishoNendo(), 該当する年月);
        if (index == ERRORINDEX) {
            return;
        }
        RString suffix = suffixList.get(index);
        try {
            Method method = CLS.getMethod(SETBIKO.concat(suffix).toString(), RSTRINGCLS);
            method.invoke(insEntity, 給付額減額);
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(DATAUTILCLS.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * 自己負担額ワークエリア加算のメソッドです。
     *
     * @param updEntity JissekiFutangakuDataTempEntity
     * @param 利用者負担 RiyoshaFutangakuEntity
     */
    public void add自己負担額ワークエリア(JissekiFutangakuDataTempEntity updEntity,
            RiyoshaFutangakuEntity 利用者負担) {
        if (updEntity == null || 利用者負担 == null) {
            return;
        }
        RString 対象年度 = updEntity.getTaishoNendo();
        RString 該当する年月 = 利用者負担.getServiceTeikyoYM();
        if (RString.isNullOrEmpty(対象年度) || RString.isNullOrEmpty(該当する年月)) {
            return;
        }
        int index = getSuffixIndex(対象年度, 該当する年月);
        if (index == ERRORINDEX) {
            return;
        }
        RStringBuilder ymsBuilder = new RStringBuilder(updEntity.getServiceTeikyoYMs());
        ymsBuilder.replace(index, index + 1, ONE);
        updEntity.setServiceTeikyoYMs(ymsBuilder.toRString());
        RString suffix = suffixList.get(index);
        Decimal sum = Decimal.ZERO;
        Method method;
        try {
            method = CLS.getMethod(GETJIKOFUTANGAKUWORK.concat(suffix).toString());
            sum = addDecimalNonull((Decimal) method.invoke(updEntity), 利用者負担.getRiyoshaFutangaku());
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(DATAUTILCLS.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            method = CLS.getMethod(SETJIKOFUTANGAKUWORK.concat(suffix).toString(), DECIMALCLS);
            method.invoke(updEntity, sum);
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(DATAUTILCLS.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * init高額支給額ワークエリアのメソッドです。
     *
     * @param 実績負担額 JissekiFutangakuDataTempEntity
     */
    public void init高額支給額ワークエリア(JissekiFutangakuDataTempEntity 実績負担額) {
//        TODO QA
    }

    /**
     * get補正済自己負担額項目に0でない月のメソッドです。
     *
     * @param 実績負担額 JissekiFutangakuDataTempEntity
     * @return List<RString>
     */
    public List<RString> get補正済自己負担額項目に0でない月(JissekiFutangakuDataTempEntity 実績負担額) {
        List<RString> 該当SuffixList = new ArrayList();
        Method method;
        Decimal dec;
        try {
            for (RString suffix : suffixList) {
                method = CLS.getMethod(GETSUMI_JIKOFUTANGAKU.concat(suffix).toString());
                dec = (Decimal) method.invoke(実績負担額);
                if (!Decimal.ZERO.equals(dec)) {
                    該当SuffixList.add(suffix);
                }
            }
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException ex) {
            Logger.getLogger(DATAUTILCLS.getName()).log(Level.SEVERE, null, ex);
        }
        return 該当SuffixList;
    }

    private int getSuffixIndex(RString 対象年度, RString 該当する年月) {
        if (RString.isNullOrEmpty(対象年度) || RString.isNullOrEmpty(該当する年月)) {
            return ERRORINDEX;
        }
        int 該当する月 = Integer.parseInt(該当する年月.substring(NUM_4, NUM_6).toString());
        RString 該当する年 = 該当する年月.substring(0, NUM_4);
        boolean is当年 = is当年(該当する年, 対象年度);
        boolean is翌年 = is翌年(該当する年, 対象年度);
        if (!is当年 && !is翌年) {
            return ERRORINDEX;

        }
        int index = is当年 ? 該当する月 - NUM_4 : 該当する月 + NUM_8;
        if (index < 0 || index > NUM_15) {
            return ERRORINDEX;
        }
        return index;
    }

    private boolean is翌年(RString 対象年度, RString year) {
        Decimal dec1 = nonullDecimal(対象年度);
        Decimal dec2 = nonullDecimal(year);
        Decimal sub = dec2.subtract(dec1);
        return Decimal.ONE.equals(sub);
    }

    private boolean is当年(RString year1, RString year2) {
        Decimal dec1 = nonullDecimal(year1);
        Decimal dec2 = nonullDecimal(year2);
        Decimal sub = dec1.subtract(dec2);
        return Decimal.ZERO.equals(sub);
    }

    private boolean is翌年(RString 対象年度, int year) {
        Decimal dec1 = nonullDecimal(対象年度);
        Decimal dec2 = nonullDecimal(year);
        Decimal sub = dec2.subtract(dec1);
        return Decimal.ONE.equals(sub);
    }

    private boolean is当年(RString year1, int year2) {
        Decimal dec1 = nonullDecimal(year1);
        Decimal dec2 = nonullDecimal(year2);
        Decimal sub = dec1.subtract(dec2);
        return Decimal.ZERO.equals(sub);
    }

    /**
     * 帳票明細データを取得のメソッドです。
     *
     * @param entity JissekiFutangakuDataTempEntity
     * @return GassanJikofutangakuKeisanKekkaIchiranEntity
     */
    public GassanJikofutangakuKeisanKekkaIchiranEntity
            toGassanJikofutangakuKeisanKekkaIchiranEntity(JissekiFutangakuDataTempEntity entity) {
        GassanJikofutangakuKeisanKekkaIchiranEntity result = new GassanJikofutangakuKeisanKekkaIchiranEntity();
        result.set被保険者番号(new HihokenshaNo(nonullRStr(entity.getHihokenshaNo())));
        result.set被保険者氏名(entity.getHihokenshaShimei());
        result.set生年月日(new FlexibleDate(nonullRStr(entity.getUmareYMD())));
        result.set性別(entity.getSeibetsuCode());
        result.set申請書整理番号(entity.getShikyuShinseishoSeiriNo());
        result.set申請年月日(new FlexibleDate(nonullRStr(entity.getShinseiYMD())));
        result.set申請対象年度(new FlexibleYear(nonullRStr(entity.getTaishoNendo())));
        result.set介護加入期間開始(new FlexibleDate(nonullRStr(entity.getHihokenshaKaishiYMD())));
        result.set介護加入期間終了(new FlexibleDate(nonullRStr(entity.getHihokenshaShuryoYMD())));
        Decimal 自己負担額 = new Decimal(nonullRStr(entity.getGokei_JikoFutanGaku()).toString());
        Decimal 高額支給額 = new Decimal(nonullRStr(entity.getGokei_Under70KogakuShikyuGaku()).toString());
        result.set自己負担額(自己負担額);
        result.set高額支給額(高額支給額);
        result.setOneTwo(addDecimalNonull(自己負担額, 高額支給額));
        result.set自己負担額内数(nonullDecimal(entity.getGokei_70_74JikoFutanGaku()));
        result.set備考資格期間不正(entity.getIchiranBiko());
        result.set備考高額支給額確認データ(entity.getIchiranKakuninKubun());
        result.set識別コード(entity.getIchiranShikibetsuCode());
        result.set一覧用確認区分(entity.getIchiranKakuninKubun());
        result.set一覧用確認区分２(entity.getIchiranKakuninKubun2());
        result.setYubinNo(entity.getIchiranYubinNo());
        result.setChoikiCode(entity.getIchiranChoikiCode());
        result.setGyoseikuCode(entity.getIchiranGyoseikuCode());
        result.setHokenshaNo(entity.getHokenshaNo());
        return result;
    }

    /**
     * getInsertDbT7022Entityのメソッドです。
     *
     * @param entity DbT7022ShoriDateKanriEntity
     * @param parameter parameter
     * @return DbT7022ShoriDateKanriEntity
     */
    public DbT7022ShoriDateKanriEntity getInsertOrUpdateDbT7022Entity(DbT7022ShoriDateKanriEntity entity,
            DBC020080ProcessParameter parameter) {
        RDateTime システム日付 = parameter.get処理日時();
        FlexibleDate kijunYMD = new FlexibleDate(システム日付.getDate().toDateString());
        YMDHMS kijunTimestamp = new YMDHMS(システム日付);
        FlexibleDate taishoKaishiYMD = new FlexibleDate(parameter.get申請対象開始日().toDateString());
        FlexibleDate taishoShuryoYMD = new FlexibleDate(parameter.get申請対象終了日().toDateString());
        if (entity == null) {
            DbT7022ShoriDateKanriEntity result = new DbT7022ShoriDateKanriEntity();
            result.setSubGyomuCode(SubGyomuCode.DBC介護給付);
            result.setShichosonCode(parameter.get市町村コード());
            result.setShoriName(ShoriName.高額合算自己負担額計算登録.get名称());
            result.setShoriEdaban(新規処理枝番);
            result.setNendo(新規年度);
            result.setNendoNaiRenban(新規年度内連番);
            result.setKijunYMD(kijunYMD);
            result.setKijunTimestamp(kijunTimestamp);
            result.setTaishoKaishiYMD(taishoKaishiYMD);
            result.setTaishoShuryoYMD(taishoShuryoYMD);
            result.setState(EntityDataState.Added);
            return result;
        } else {
            entity.setKijunYMD(kijunYMD);
            entity.setKijunTimestamp(kijunTimestamp);
            entity.setTaishoKaishiYMD(taishoKaishiYMD);
            entity.setTaishoShuryoYMD(taishoShuryoYMD);
            entity.setTaishoKaishiTimestamp(null);
            entity.setTaishoShuryoTimestamp(null);
            entity.setState(EntityDataState.Modified);
            return entity;
        }
    }

    /**
     * toDBC020080ShoriKekkaCSVEntityのメソッドです。
     *
     * @param entity DBC020080ShoriKekkaTempEntity
     * @param isTitle boolean
     * @param isFirst boolean
     * @param parameter DBC020080ProcessParameter
     * @return DBC020080ShoriKekkaCSVEntity
     */
    public DBC020080ShoriKekkaCSVEntity toDBC020080ShoriKekkaCSVEntity(DBC020080ShoriKekkaTempEntity entity,
            boolean isTitle, boolean isFirst, DBC020080ProcessParameter parameter) {
        KaigoGassan_ErrorListType errorType = KaigoGassan_ErrorListType.toValue(entity.getErrorKubun());
        if (isTitle) {
            return getTitle(errorType);
        }
        DBC020080ShoriKekkaCSVEntity result = new DBC020080ShoriKekkaCSVEntity();
        if (!isTitle && isFirst) {
            result.set作成日時(DateConverter.getDate12Time142(parameter.get処理日時()));
        }
        result.set処理名(entity.getErrorKubun());
        result.set証記載保険者番号(entity.getShoHokanehshaNo());
        result.set被保険者番号(entity.getHihokenshaNo());
        result.set被保険者カナ氏名(entity.getHihokenshaKanaShimei());
        result.set被保険者氏名(entity.getHihokenshaShimei());
        result.setキー1(entity.getKey1());
        result.setキー2(entity.getKey2());
        result.setキー3(entity.getKey3());
        result.setキー4(entity.getKey4());
        result.setキー5(entity.getKey5());
        result.setエラー内容(entity.getErrorNaiyo());
        result.set備考(entity.getBiko());
        return result;
    }

    private DBC020080ShoriKekkaCSVEntity getTitle(KaigoGassan_ErrorListType errorType) {
        DBC020080ShoriKekkaCSVEntity title = new DBC020080ShoriKekkaCSVEntity();
        title.set作成日時(作成日時);
        title.set処理名(処理名);
        title.set証記載保険者番号(証記載保険者番号);
        title.set被保険者番号(被保険者番号);
        title.set被保険者カナ氏名(被保険者カナ氏名);
        title.set被保険者氏名(被保険者氏名);
        title.setキー1(errorType.getキー1());
        title.setキー2(errorType.getキー2());
        title.setキー3(errorType.getキー3());
        title.setキー4(errorType.getキー4());
        title.setキー5(errorType.getキー5());
        title.setエラー内容(エラー内容);
        title.set備考(備考);
        return title;
    }

    /**
     * 宛名検索条件を取得します。
     *
     * @return IShikibetsuTaishoPSMSearchKey
     */
    public IShikibetsuTaishoPSMSearchKey get宛名検索条件() {
        List<JuminShubetsu> 住民種別リスト = new ArrayList<>();
        List<JuminJotai> 住民状態リスト = new ArrayList<>();
        住民種別リスト.add(JuminShubetsu.住登外個人_外国人);
        住民種別リスト.add(JuminShubetsu.外国人);
        住民種別リスト.add(JuminShubetsu.住登外個人_日本人);
        住民種別リスト.add(JuminShubetsu.日本人);
        住民状態リスト.add(JuminJotai.住民);
        住民状態リスト.add(JuminJotai.住登外);
        住民状態リスト.add(JuminJotai.消除者);
        住民状態リスト.add(JuminJotai.転出者);
        住民状態リスト.add(JuminJotai.死亡者);
        return new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先)
                .set住民種別(住民種別リスト)
                .set住民状態(住民状態リスト)
                .set同一人代表者優先区分(DoitsuninDaihyoshaYusenKubun.同一人代表者を優先しない)
                .build();
    }

    private RString nonullRStr(RString rstring) {
        if (rstring == null) {
            return RString.EMPTY;
        }
        return rstring;
    }

    private RString nonullRStr(Decimal dec) {
        if (dec == null) {
            return RString.EMPTY;
        }
        return new RString(dec.toString());
    }

    private RString nonullRStr(RDate date) {
        if (date == null) {
            return RString.EMPTY;
        }
        return date.toDateString();
    }

    private RString nonullRStr(HihokenshaNo hihokenshaNo) {
        if (hihokenshaNo == null) {
            return RString.EMPTY;
        }
        return hihokenshaNo.value();
    }

    private RString nonullRStr(FlexibleYear flexibleYear) {
        if (flexibleYear == null) {
            return RString.EMPTY;
        }
        return flexibleYear.toDateString();
    }

    private RString nonullRStr(FlexibleDate flexibleDate) {
        if (flexibleDate == null) {
            return RString.EMPTY;
        }
        return new RString(flexibleDate.toString());
    }

    private RString nonullRStr(HokenshaNo hokenshaNo) {
        if (hokenshaNo == null) {
            return RString.EMPTY;
        }
        return hokenshaNo.value();
    }

    private RString nonullRStr(AtenaKanaMeisho atenaKanaMeisho) {
        if (atenaKanaMeisho == null) {
            return RString.EMPTY;
        }
        return atenaKanaMeisho.value();
    }

    private RString nonullRStr(AtenaMeisho atenaMeisho) {
        if (atenaMeisho == null) {
            return RString.EMPTY;
        }
        return atenaMeisho.value();
    }

    private RString nonullRStr(ShikibetsuCode shikibetsuCode) {
        if (shikibetsuCode == null) {
            return RString.EMPTY;
        }
        return shikibetsuCode.value();
    }

    private RString nonullRStr(LasdecCode lasdecCode) {
        if (lasdecCode == null) {
            return RString.EMPTY;
        }
        return lasdecCode.value();
    }

    private RString nonullRStr(YubinNo yubinNo) {
        if (yubinNo == null) {
            return RString.EMPTY;
        }
        return yubinNo.value();
    }

    private RString nonullRStr(ChoikiCode choikiCode) {
        if (choikiCode == null) {
            return RString.EMPTY;
        }
        return choikiCode.value();
    }

    private RString nonullRStr(GyoseikuCode gyoseikuCode) {
        if (gyoseikuCode == null) {
            return RString.EMPTY;
        }
        return gyoseikuCode.value();
    }

    private RDate getRDate(RDateTime dt) {
        if (dt == null) {
            return null;
        }
        return dt.getDate();
    }

    private Decimal nonullDecimal(Decimal dec) {
        if (dec == null) {
            return Decimal.ZERO;
        }
        return dec;
    }

    private Decimal nonullDecimal(RString rstring) {
        if (RString.isNullOrEmpty(rstring)) {
            return Decimal.ZERO;
        }
        return new Decimal(rstring.trim().toString());
    }

    private Decimal nonullDecimal(Integer integer) {
        if (integer == null) {
            return Decimal.ZERO;
        }
        return new Decimal(integer);
    }

    private RString addDecimalNonull(RString dec1, Decimal dec2) {
        return nonullRStr(nonullDecimal(dec2).add(nonullDecimal(dec1)));
    }

    private Decimal addDecimalNonull(Decimal dec1, Decimal dec2) {
        return nonullDecimal(dec1).subtract(nonullDecimal(dec2));
    }
}
