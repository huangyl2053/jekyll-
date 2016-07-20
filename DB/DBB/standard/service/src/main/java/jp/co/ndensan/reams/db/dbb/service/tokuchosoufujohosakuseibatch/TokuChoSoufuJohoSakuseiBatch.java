/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.tokuchosoufujohosakuseibatch;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.basic.tokuchosoufujohosakusei.TokuChoSoufuJohoSakuseiResult;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchosoufujohosakusei.TokuChoSoufuJohoSakuseiEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokuchosoufujohosakusei.ITokuChoSoufuJohoSakuseiMapper;
import jp.co.ndensan.reams.db.dbb.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.TokuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.Tsuki;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.UeT0511NenkinTokuchoKaifuJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.UeT0511NenkinTokuchoKaifuJohoDac;
import jp.co.ndensan.reams.ue.uex.definition.core.TsuchiNaiyoCodeType;
import jp.co.ndensan.reams.ue.uex.entity.db.basic.UeT0515KaigohokenNenkinTokuchoTaishoshaJoho550Entity;
import jp.co.ndensan.reams.ue.uex.entity.db.basic.UeT1704KaigoTokuchoTorikomiRirekiEntity;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.CountedItem;
import jp.co.ndensan.reams.uz.uza.util.Saiban;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 徴収方法更新のクラスです。
 *
 * @reamsid_L DBB-9070-010 huangyanan
 */
public class TokuChoSoufuJohoSakuseiBatch {

    private final RString 年度_2016 = new RString("2016");
    private final RString 年度_2015 = new RString("2015");
    //    2015
    private final RString 前年度2月 = new RString("02");
    private final RString 前年度4月 = new RString("04");
    private final RString 前年度6月 = new RString("06");
    private final RString 前年度8月 = new RString("08");
    private final RString 前年度10月 = new RString("10");
    private final RString 前年度12月 = new RString("12");
//    2015
//    2016
    private final RString 月2 = new RString("02");
    private final RString 月4 = new RString("04");
    private final RString 月6 = new RString("06");
    private final RString 月8 = new RString("08");
    private final RString 月10 = new RString("10");
    private final RString 月12 = new RString("12");
    //    2016
//    2017
    private final RString 翌2月 = new RString("02");
    private final RString 翌4月 = new RString("04");
    private final RString 翌6月 = new RString("06");
    //    2017

    private static final RString RS0 = new RString("0");
    private static final RString RS1 = new RString("1");
    private static final RString RS2 = new RString("2");
    private static final RString RS01 = new RString("01");
    private static final RString RS02 = new RString("02");
    private static final RString RS03 = new RString("03");
    private static final RString RS04 = new RString("04");
    private static final RString RS05 = new RString("05");
    private static final RString RS06 = new RString("06");
    private static final RString RS31 = new RString("31");
    private static final RString RS30 = new RString("30");
    private static final RString RS00 = new RString("00");
    private static final RString RS0001 = new RString("0001");
    private static final RString RS0002 = new RString("0002");
    private static final RString RS0004 = new RString("00004");
    private static final RString RS0005 = new RString("0005");
    private static final RString RS0006 = new RString("0006");
    private static final RString 定値_DT媒体コード = new RString("6");
    private static final int NUM1 = 1;
    private static final int NUM2 = 2;
    private static final int NUM3 = 3;
    private static final int NUM4 = 4;
    private static final int NUM5 = 5;
    private static final int NUM6 = 6;
    private static final int NUM7 = 7;
    private static final int NUM8 = 8;
    private static final int NUM9 = 9;
    private static final int NUM10 = 10;
    private static final int NUM11 = 11;
    private static final int NUM12 = 12;
    private static final int NUM15 = 15;
    private static final RString STR5 = new RString("5");
    private static final RString 特徴制度間IF全件作成 = new RString("特徴制度間IF全件作成");
    private static final RString 特徴制度間IF作成 = new RString("特徴制度間IF作成");
    private static final RString 依頼金額計算 = new RString("依頼金額計算");
    private static final RString 本算定賦課 = new RString("本算定賦課");
    private static final RString 金額あり = new RString("1");
    private static final RString 金額なし = new RString("2");
    private static final RString GENERICKEY = new RString("UeT1704KaigoTokuchoTorikomiRireki_renban");
    private final FlexibleYear 年度 = new FlexibleYear("0000");
    private final MapperProvider mapperProvider;
    private final DbT7022ShoriDateKanriDac 処理日付管理マスタdac;
    private final UeT0511NenkinTokuchoKaifuJohoDac 年金特徴回付情報_介護継承dac;
    private final ITokuChoSoufuJohoSakuseiMapper mapper;

    /**
     * コンストラクタです。
     */
    TokuChoSoufuJohoSakuseiBatch() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        処理日付管理マスタdac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
        年金特徴回付情報_介護継承dac = InstanceProvider.create(UeT0511NenkinTokuchoKaifuJohoDac.class);
        mapper = mapperProvider.create(ITokuChoSoufuJohoSakuseiMapper.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link TokuChoSoufuJohoSakuseiBatch}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link TokuChoSoufuJohoSakuseiBatch}のインスタンス
     */
    public static TokuChoSoufuJohoSakuseiBatch createInstance() {
        return InstanceProvider.create(TokuChoSoufuJohoSakuseiBatch.class);
    }

    /**
     * 年金特徴回付情報（介護継承）から、年金特徴回付情報を抽出し、一時テーブルを作成する.
     *
     * @param 処理年度 FlexibleYear
     * @param 特徴開始月 RDate
     * @param 遷移元メニュー RString
     * @return List<UeT0511NenkinTokuchoKaifuJohoEntity>
     */
    public List<UeT0511NenkinTokuchoKaifuJohoEntity> selectNenkinTokuChoKaifuJoho(FlexibleYear 処理年度, RDate 特徴開始月, RString 遷移元メニュー) {
        if (特徴開始月 == null || 処理年度 == null) {
            return new ArrayList();
        }
        List<UeT0511NenkinTokuchoKaifuJohoEntity> resultList = null;
        if (特徴制度間IF作成.equals(遷移元メニュー)) {
            FlexibleYear 入力処理年度 = null;
            RString 通知内容コード = null;
            RString 捕捉月 = null;
            if (月8.equals(特徴開始月.getYearMonth().toDateString()) && 年度_2016.equals(処理年度.toDateString())) {
                入力処理年度 = new FlexibleYear(年度_2016);
                通知内容コード = RS30;
                捕捉月 = 月2;
            } else if (月10.equals(特徴開始月.getYearMonth().toDateString()) && 年度_2016.equals(処理年度.toDateString())) {
                入力処理年度 = new FlexibleYear(年度_2016);
                通知内容コード = RS00;
                捕捉月 = 月4;
            } else if (月12.equals(特徴開始月.getYearMonth().toDateString()) && 年度_2016.equals(処理年度.toDateString())) {
                入力処理年度 = new FlexibleYear(年度_2016);
                通知内容コード = RS30;
                捕捉月 = 月6;
            } else if (翌2月.equals(特徴開始月.getYearMonth().toDateString()) && 年度_2016.equals(処理年度.toDateString())) {
                入力処理年度 = new FlexibleYear(年度_2016);
                通知内容コード = RS30;
                捕捉月 = 月8;
            } else if (翌4月.equals(特徴開始月.getYearMonth().toDateString()) && 年度_2016.equals(処理年度.toDateString())) {
                入力処理年度 = new FlexibleYear(年度_2016);
                通知内容コード = RS30;
                捕捉月 = 月10;
            } else if (翌6月.equals(特徴開始月.getYearMonth().toDateString()) && 年度_2016.equals(処理年度.toDateString())) {
                入力処理年度 = new FlexibleYear(年度_2016);
                通知内容コード = RS30;
                捕捉月 = 月12;
            }
            resultList = 年金特徴回付情報_介護継承dac.
                    select特徴回付情報のデータ(GyomuCode.DB介護保険, 通知内容コード, 入力処理年度, 捕捉月);
        } else if (特徴制度間IF全件作成.equals(遷移元メニュー)) {
            List<UeT0511NenkinTokuchoKaifuJohoEntity> uet0511entitylist = get抽出するデータ(特徴開始月, 処理年度);
            resultList = 年金特徴回付情報_介護継承dac.select全件特徴回付情報のデータ(GyomuCode.DB介護保険, uet0511entitylist);
        }
        return resultList;
    }

    private List<UeT0511NenkinTokuchoKaifuJohoEntity> get抽出するデータ(RDate 特徴開始月, FlexibleYear 処理年度) {
        List<UeT0511NenkinTokuchoKaifuJohoEntity> uet0511entitylist = new ArrayList();
        if (月4.equals(特徴開始月.getYearMonth().toDateString()) && 年度_2015.equals(処理年度.toDateString())) {
            addToList(uet0511entitylist, new FlexibleYear(年度_2015), RS30, 前年度12月);
            addToList(uet0511entitylist, new FlexibleYear(年度_2015), RS30, 前年度8月);
            addToList(uet0511entitylist, new FlexibleYear(年度_2015), RS30, 前年度6月);
            addToList(uet0511entitylist, new FlexibleYear(年度_2015), RS00, 前年度4月);
        } else if (月6.equals(特徴開始月.getYearMonth().toDateString()) && 年度_2015.equals(処理年度.toDateString())) {
            addToList(uet0511entitylist, new FlexibleYear(年度_2015), RS30, 前年度12月);
            addToList(uet0511entitylist, new FlexibleYear(年度_2015), RS30, 前年度10月);
            addToList(uet0511entitylist, new FlexibleYear(年度_2015), RS30, 前年度8月);
            addToList(uet0511entitylist, new FlexibleYear(年度_2015), RS30, 前年度6月);
            addToList(uet0511entitylist, new FlexibleYear(年度_2015), RS00, 前年度4月);
        } else if (月8.equals(特徴開始月.getYearMonth().toDateString()) && 年度_2016.equals(処理年度.toDateString())) {
            addToList(uet0511entitylist, new FlexibleYear(年度_2016), RS00, 前年度2月);
            addToList(uet0511entitylist, new FlexibleYear(年度_2015), RS30, 前年度12月);
            addToList(uet0511entitylist, new FlexibleYear(年度_2015), RS30, 前年度10月);
            addToList(uet0511entitylist, new FlexibleYear(年度_2015), RS30, 前年度8月);
            addToList(uet0511entitylist, new FlexibleYear(年度_2015), RS30, 前年度6月);
            addToList(uet0511entitylist, new FlexibleYear(年度_2015), RS00, 前年度4月);
        } else if (月10.equals(特徴開始月.getYearMonth().toDateString()) && 年度_2016.equals(処理年度.toDateString())) {
            addToList(uet0511entitylist, new FlexibleYear(年度_2016), RS00, 前年度4月);
        } else if (月12.equals(特徴開始月.getYearMonth().toDateString()) && 年度_2016.equals(処理年度.toDateString())) {
            addToList(uet0511entitylist, new FlexibleYear(年度_2016), RS30, 前年度6月);
            addToList(uet0511entitylist, new FlexibleYear(年度_2016), RS00, 前年度4月);
        } else if (翌2月.equals(特徴開始月.getYearMonth().toDateString()) && 年度_2016.equals(処理年度.toDateString())) {
            addToList(uet0511entitylist, new FlexibleYear(年度_2015), RS30, 前年度8月);
            addToList(uet0511entitylist, new FlexibleYear(年度_2015), RS30, 前年度6月);
            addToList(uet0511entitylist, new FlexibleYear(年度_2015), RS00, 前年度4月);
        }
        return uet0511entitylist;
    }

    private void addToList(List<UeT0511NenkinTokuchoKaifuJohoEntity> uet0511entitylist, FlexibleYear 処理年度,
            RString 通知内容コード, RString 捕捉月) {
        UeT0511NenkinTokuchoKaifuJohoEntity entity = new UeT0511NenkinTokuchoKaifuJohoEntity();
        entity.setShoriNendo(処理年度);
        entity.setTsuchiNaiyoCode(通知内容コード);
        entity.setHosokuTsuki(捕捉月);
        uet0511entitylist.add(entity);
    }

    /**
     * １回の特徴制度間IF作成処理につき、１件のレコードを追加する。
     *
     * @param 特徴開始月 RDate
     * @param 処理年度 FlexibleYear
     * @param 処理日時 YMDHMS
     * @param 遷移元メニュー RString
     * @return UeT1704KaigoTokuchoTorikomiRirekiEntity
     */
    public UeT1704KaigoTokuchoTorikomiRirekiEntity intTokuChoJohoTorikomiRireki(FlexibleYear 処理年度, RDate 特徴開始月, RString 遷移元メニュー, RDateTime 処理日時) {
        UeT1704KaigoTokuchoTorikomiRirekiEntity 介護特別徴収情報取込履歴entity = new UeT1704KaigoTokuchoTorikomiRirekiEntity();
        CountedItem countedItem = Saiban.get(SubGyomuCode.UEA特別徴収分配集約, GENERICKEY, 年度);
        int 連番 = (int) countedItem.next();
        if (特徴制度間IF作成.equals(遷移元メニュー)) {
            YMDHMS 基準日時 = chkTokuchoIraikinKeisan(特徴開始月, 処理年度);
            介護特別徴収情報取込履歴entity.setRenban(連番);
            if (基準日時 == null || 基準日時.isEmpty()) {
                介護特別徴収情報取込履歴entity.setDataShubetsu(金額なし);
            } else {
                介護特別徴収情報取込履歴entity.setDataShubetsu(金額あり);
            }
            介護特別徴収情報取込履歴entity.setShoriTimestamp(処理日時);
        } else if (特徴制度間IF全件作成.equals(遷移元メニュー)) {
            介護特別徴収情報取込履歴entity.setRenban(連番);
            介護特別徴収情報取込履歴entity.setDataShubetsu(STR5);
            介護特別徴収情報取込履歴entity.setShoriTimestamp(処理日時);
        }
        return 介護特別徴収情報取込履歴entity;
    }

    /**
     * 介護保険年金特徴対象者情報に追加するデータを作成する
     *
     * @param 特徴開始月 RDate
     * @param 処理日時 RDateTime
     * @param 処理年度 FlexibleYear
     * @return UeT0515KaigohokenNenkinTokuchoTaishoshaJoho550Entity
     */
    public List<UeT0515KaigohokenNenkinTokuchoTaishoshaJoho550Entity> setTuikaData(FlexibleYear 処理年度, RDate 特徴開始月, RDateTime 処理日時) {
        List<TokuChoSoufuJohoSakuseiEntity> resultentitylist = new ArrayList();
        if (特徴開始月.getMonthValue() == NUM2 || 特徴開始月.getMonthValue() == NUM10 || 特徴開始月.getMonthValue() == NUM12) {
            resultentitylist = mapper.selectUe10122T0511NenkinTokuchoKaifuJohotemp();
        } else if (特徴開始月.getMonthValue() == NUM4 || 特徴開始月.getMonthValue() == NUM6) {
            resultentitylist = mapper.select46UeT0511NenkinTokuchoKaifuJohotemp();
        } else if (特徴開始月.getMonthValue() == NUM8) {
            resultentitylist = mapper.select8UeT0511NenkinTokuchoKaifuJohotemp();
        }
        List<UeT0515KaigohokenNenkinTokuchoTaishoshaJoho550Entity> uet0515Entitys = new ArrayList();
        List<TokuChoSoufuJohoSakuseiResult> resultlist = TokuChoSoufuJohoSakuseiResult.getTokuChoSoufuJohoSakuseiResultList(resultentitylist);
        int 連番 = (int) Saiban.get(SubGyomuCode.UEA特別徴収分配集約, GENERICKEY, 年度).next();
        int シーケンス = NUM1;
        for (TokuChoSoufuJohoSakuseiResult entity : resultlist) {
            UeT0515KaigohokenNenkinTokuchoTaishoshaJoho550Entity tokuchotempentity = new UeT0515KaigohokenNenkinTokuchoTaishoshaJoho550Entity();
            tokuchotempentity.setRenban(連番);
            RString 基礎年金番号 = entity.get対象者の情報().get基礎年金番号();
            tokuchotempentity.setKisoNenkinNo(基礎年金番号);
            RString 年金コード = entity.get対象者の情報().get年金コード();
            tokuchotempentity.setNenkinCode(年金コード);
            if (基礎年金番号 == null || 年金コード == null) {
                tokuchotempentity.setSeq(シーケンス);
                シーケンス = NUM1;
            } else if (Integer.parseInt(年金コード.toString()) < Integer.parseInt(基礎年金番号.toString())
                    && Integer.parseInt(基礎年金番号.toString()) < 連番) {
                tokuchotempentity.setSeq(シーケンス);
                シーケンス = シーケンス + NUM1;
            } else {
                tokuchotempentity.setSeq(シーケンス);
                シーケンス = NUM1;
            }
            tokuchotempentity.setShoriTimestamp(処理日時);
            tokuchotempentity.setDtCityCode(entity.get対象者の情報().getDT市町村コード());
            if (entity.get対象者の情報().getDT特別徴収義務者コード() != null) {
                tokuchotempentity.setDtTokubetsuChoshuGimushaCode(entity.get対象者の情報().getDT特別徴収義務者コード().value());
            }
            if (entity.get対象者の情報().getDT通知内容コード() != null) {
                if (TsuchiNaiyoCodeType.特別徴収対象者情報.get通知内容コード().equals(
                        entity.get対象者の情報().getDT通知内容コード())) {
                    tokuchotempentity.setDtTsuchiNaiyoCode(TsuchiNaiyoCodeType.特別徴収依頼通知.get通知内容コード());
                } else if (TsuchiNaiyoCodeType.特別徴収追加候補者情報.get通知内容コード().equals(
                        entity.get対象者の情報().getDT通知内容コード())) {
                    tokuchotempentity.setDtTsuchiNaiyoCode(TsuchiNaiyoCodeType.特別徴収追加依頼通知.get通知内容コード());
                }
            }
            tokuchotempentity.setDtBaitaiCode(定値_DT媒体コード);
            if (entity.get対象者の情報().getDT特別徴収制度コード() != null) {
                tokuchotempentity.setDtTokubetsuChoshuSeidoCode(entity.get対象者の情報().getDT特別徴収制度コード());
            }
            setEntityValue(tokuchotempentity, entity, 処理年度, 特徴開始月, 処理日時);
            uet0515Entitys.add(tokuchotempentity);
        }
        return uet0515Entitys;
    }

    private void setEntityValue(UeT0515KaigohokenNenkinTokuchoTaishoshaJoho550Entity tokuchotempentity,
            TokuChoSoufuJohoSakuseiResult entity, FlexibleYear 処理年度, RDate 特徴開始月, RDateTime 処理日時) {
        if (RS01.equals(tokuchotempentity.getDtTsuchiNaiyoCode()) && 処理日時 != null) {
            tokuchotempentity.setDtSakuseiYMD(処理日時.getDate().toDateString());
        } else if (RS31.equals(tokuchotempentity.getDtTsuchiNaiyoCode())) {
            tokuchotempentity.setDtSakuseiYMD(entity.get対象者の情報().getDT作成年月日());
        }
        tokuchotempentity.setDtKisoNenkinNo(entity.get対象者の情報().getDT基礎年金番号());
        tokuchotempentity.setDtNenkinCode(entity.get対象者の情報().getDT年金コード());
        tokuchotempentity.setYobi(RString.FULL_SPACE);
        tokuchotempentity.setDtBirthDay(entity.get対象者の情報().getDT生年月日());
        if (entity.get対象者の情報().getDT性別() != null) {
            tokuchotempentity.setDtSeibetsu(entity.get対象者の情報().getDT性別());
        }
        tokuchotempentity.setDtKanaShimei(entity.get対象者の情報().getDTカナ氏名());
        tokuchotempentity.setDtShiftCode1(entity.get対象者の情報().getDTシフトコード１());
        tokuchotempentity.setDtKanjiShimei(entity.get対象者の情報().getDT漢字氏名());
        tokuchotempentity.setDtShiftCode2(entity.get対象者の情報().getDTシフトコード２());
        tokuchotempentity.setDtYubinNo(entity.get対象者の情報().getDT郵便番号());
        tokuchotempentity.setDtKanaJusho(entity.get対象者の情報().getDTカナ住所());
        tokuchotempentity.setDtShiftCode3(entity.get対象者の情報().getDTシフトコード３());
        tokuchotempentity.setDtKanjiJusho(entity.get対象者の情報().getDT漢字住所());
        tokuchotempentity.setDtShiftCode4(entity.get対象者の情報().getDTシフトコード４());
        RString 徴収方法n月;
        switch (特徴開始月.getMonthValue()) {
            case NUM1:
                徴収方法n月 = entity.get徴収方法の情報().get徴収方法1月();
                break;
            case NUM2:
                徴収方法n月 = entity.get徴収方法の情報().get徴収方法2月();
                break;
            case NUM3:
                徴収方法n月 = entity.get徴収方法の情報().get徴収方法3月();
                break;
            case NUM4:
                徴収方法n月 = entity.get徴収方法の情報().get徴収方法4月();
                break;
            case NUM5:
                徴収方法n月 = entity.get徴収方法の情報().get徴収方法5月();
                break;
            case NUM6:
                徴収方法n月 = entity.get徴収方法の情報().get徴収方法6月();
                break;
            case NUM7:
                徴収方法n月 = entity.get徴収方法の情報().get徴収方法7月();
                break;
            case NUM8:
                徴収方法n月 = entity.get徴収方法の情報().get徴収方法8月();
                break;
            case NUM9:
                徴収方法n月 = entity.get徴収方法の情報().get徴収方法9月();
                break;
            case NUM10:
                徴収方法n月 = entity.get徴収方法の情報().get徴収方法10月();
                break;
            case NUM11:
                徴収方法n月 = entity.get徴収方法の情報().get徴収方法11月();
                break;
            case NUM12:
                徴収方法n月 = entity.get徴収方法の情報().get徴収方法12月();
                break;
            default:
                徴収方法n月 = RString.EMPTY;
        }
        if (処理日時 != null) {
            tokuchotempentity.setDtKakushuYMD(処理日時.getDate().toDateString());
        }
        setEntityValueContinue(tokuchotempentity, entity, 処理年度, 特徴開始月, 処理日時, 徴収方法n月);
    }

    private void setEntityValueContinue(UeT0515KaigohokenNenkinTokuchoTaishoshaJoho550Entity tokuchotempentity,
            TokuChoSoufuJohoSakuseiResult entity, FlexibleYear 処理年度, RDate 特徴開始月, RDateTime 処理日時, RString 徴収方法n月) {
        if ((RS1.equals(徴収方法n月) || RS2.equals(徴収方法n月)) && RS1.equals(entity.get資格の情報().get住所地特例フラグ())) {
            tokuchotempentity.setDtKakushuKubun(RS01);
        } else if ((RS1.equals(徴収方法n月) || RS2.equals(徴収方法n月)) && entity.get資格の情報().get資格喪失事由コード() == null
                && !RS1.equals(entity.get資格の情報().get住所地特例フラグ())) {
            tokuchotempentity.setDtKakushuKubun(RS02);
        } else if (!RS1.equals(徴収方法n月) && !RS2.equals(徴収方法n月)) {
            tokuchotempentity.setDtKakushuKubun(RS03);
        }
        tokuchotempentity.setDtShoriKekka(RString.FULL_SPACE);
        tokuchotempentity.setDtKokiIkanCode(RString.FULL_SPACE);
        YMDHMS 基準日時 = chkTokuchoIraikinKeisan(特徴開始月, 処理年度);
        if (基準日時 != null && !基準日時.isEmpty()) {
            setDT各種金額欄12(tokuchotempentity, entity, 特徴開始月);
        }
        tokuchotempentity.setDtKakushuKingaku3(entity.get対象者の情報().getDT各種金額欄３());
        tokuchotempentity.setDtYobi2(RString.FULL_SPACE);
        tokuchotempentity.setDtKyosaiNenkinshoshoKigoNo(entity.get対象者の情報().getDT共済年金証書記号番号());
        if (!RS03.equals(tokuchotempentity.getDtKakushuKubun())) {
            tokuchotempentity.setKaigohokenHihokenshaNo(entity.get対象者の情報().get被保険者番号());
            tokuchotempentity.setKojinCodeKubun(RS0);
            if (entity.get対象者の情報().get識別コード() != null) {
                tokuchotempentity.setKojinCode(entity.get対象者の情報().get識別コード().value().padZeroToLeft(NUM15));
            }
            tokuchotempentity.setKaigohokenJushochitokureiKubun(entity.get資格の情報().get住所地特例フラグ());
            if (entity.get対象者の情報().get処理年度() != null) {
                tokuchotempentity.setHosokuYMD(entity.get対象者の情報().get処理年度().toDateString().concat(
                        entity.get対象者の情報().get捕捉月()).concat(RS01));
            }
            RDate nowDate = RDate.getNowDate();
            RString 特徴開始月_6月捕捉 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_特徴開始月_6月捕捉, nowDate, SubGyomuCode.DBB介護賦課);
            RString 特徴開始月_8月捕捉 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_特徴開始月_8月捕捉, nowDate, SubGyomuCode.DBB介護賦課);
            if ((月6.equals(entity.get対象者の情報().get捕捉月()) && RS04.equals(特徴開始月_6月捕捉))
                    || (月8.equals(entity.get対象者の情報().get捕捉月()) && RS04.equals(特徴開始月_8月捕捉))) {
                tokuchotempentity.setTaikiFlag(RS1);
            } else {
                tokuchotempentity.setTaikiFlag(RS0);
            }
        }
    }

    private void setDT各種金額欄12(UeT0515KaigohokenNenkinTokuchoTaishoshaJoho550Entity tokuchotempentity,
            TokuChoSoufuJohoSakuseiResult entity, RDate 特徴開始月) {
        if (TsuchiNaiyoCodeType.特別徴収対象者情報.get通知内容コード().equals(
                entity.get対象者の情報().getDT通知内容コード())) {
            tokuchotempentity.setDtKakushuKingaku1(new RString(entity.get賦課の情報().get特徴期別金額04().toString()));
            tokuchotempentity.setDtKakushuKingaku2(new RString(entity.get賦課の情報().get特徴期別金額05().toString()));
        } else if (TsuchiNaiyoCodeType.特別徴収追加候補者情報.get通知内容コード().equals(
                entity.get対象者の情報().getDT通知内容コード())) {
            TokuchoKiUtil tokuchokiutil = new TokuchoKiUtil();
            RString 期 = tokuchokiutil.get期月リスト().get月の期(Tsuki.toValue(
                    new RString(特徴開始月.getMonthValue()).padZeroToLeft(NUM2))).get期();
            if (!RString.isNullOrEmpty(期) && RS01.equals(期)) {
                tokuchotempentity.setDtKakushuKingaku1(new RString(entity.get賦課の情報().get特徴期別金額01().toString()));
            } else if (!RString.isNullOrEmpty(期) && RS02.equals(期)) {
                tokuchotempentity.setDtKakushuKingaku1(new RString(entity.get賦課の情報().get特徴期別金額02().toString()));
            } else if (!RString.isNullOrEmpty(期) && RS03.equals(期)) {
                tokuchotempentity.setDtKakushuKingaku1(new RString(entity.get賦課の情報().get特徴期別金額03().toString()));
            } else if (!RString.isNullOrEmpty(期) && RS04.equals(期)) {
                tokuchotempentity.setDtKakushuKingaku1(new RString(entity.get賦課の情報().get特徴期別金額04().toString()));
            } else if (!RString.isNullOrEmpty(期) && RS05.equals(期)) {
                tokuchotempentity.setDtKakushuKingaku1(new RString(entity.get賦課の情報().get特徴期別金額05().toString()));
            } else if (!RString.isNullOrEmpty(期) && RS06.equals(期)) {
                tokuchotempentity.setDtKakushuKingaku1(new RString(entity.get賦課の情報().get特徴期別金額06().toString()));
            }
            tokuchotempentity.setDtKakushuKingaku2(RS0);
        } else {
            tokuchotempentity.setDtKakushuKingaku2(RS0);
        }
    }

    /**
     * 対象者情報追加Tempから、抽出したデータを介護保険年金特徴対象者情報に追加する
     *
     * @return List<UeT0515KaigohokenNenkinTokuchoTaishoshaJoho550Entity>
     */
    public List<UeT0515KaigohokenNenkinTokuchoTaishoshaJoho550Entity> intNenkinTokuChoTaishosyaJoho() {
        return mapper.selectUeT0515KaigohokenNenkinTokuchoTaishoshaJoho550tempAll();
    }

    /**
     * 特徴依頼金額計算の判定
     *
     * @param 特徴開始月 RDate
     * @param 処理年度 FlexibleYear
     * @return 基準日時 YMDHMS
     */
    public YMDHMS chkTokuchoIraikinKeisan(RDate 特徴開始月, FlexibleYear 処理年度) {
        FlexibleYear 入力処理年度 = null;
        RString 年度内年番 = null;
        RString 処理名 = null;
        if (月6.equals(特徴開始月.getYearMonth().toDateString()) && 年度_2015.equals(処理年度.toDateString())) {
            入力処理年度 = new FlexibleYear(年度_2016);
            年度内年番 = RS0001;
            処理名 = 依頼金額計算;
        } else if (月8.equals(特徴開始月.getYearMonth().toDateString()) && 年度_2016.equals(処理年度.toDateString())) {
            入力処理年度 = new FlexibleYear(年度_2016);
            年度内年番 = RS0002;
            処理名 = 依頼金額計算;
        } else if (月10.equals(特徴開始月.getYearMonth().toDateString()) && 年度_2016.equals(処理年度.toDateString())) {
            入力処理年度 = new FlexibleYear(年度_2016);
            年度内年番 = RS0001;
            処理名 = 本算定賦課;
        } else if (月12.equals(特徴開始月.getYearMonth().toDateString()) && 年度_2016.equals(処理年度.toDateString())) {
            入力処理年度 = new FlexibleYear(年度_2016);
            年度内年番 = RS0004;
            処理名 = 依頼金額計算;
        } else if (翌2月.equals(特徴開始月.getYearMonth().toDateString()) && 年度_2016.equals(処理年度.toDateString())) {
            入力処理年度 = new FlexibleYear(年度_2016);
            年度内年番 = RS0005;
            処理名 = 依頼金額計算;
        } else if (翌2月.equals(特徴開始月.getYearMonth().toDateString()) && 年度_2016.equals(処理年度.toDateString())) {
            入力処理年度 = new FlexibleYear(年度_2016);
            年度内年番 = RS0006;
            処理名 = 依頼金額計算;
        }
        DbT7022ShoriDateKanriEntity shoridatekanrientity = 処理日付管理マスタdac.selectBySomeKeysLimits(
                SubGyomuCode.DBB介護賦課, 処理名, RS0001, 入力処理年度, 年度内年番);
        if (shoridatekanrientity == null) {
            return null;
        } else {
            return shoridatekanrientity.getKijunTimestamp();
        }
    }
}
