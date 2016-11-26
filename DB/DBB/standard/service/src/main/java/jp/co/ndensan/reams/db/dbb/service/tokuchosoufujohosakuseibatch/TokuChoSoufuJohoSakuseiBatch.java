/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.tokuchosoufujohosakuseibatch;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.business.core.basic.tokuchosoufujohosakusei.TokuChoSoufuJohoSakuseiResult;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJoho;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchosoufujohosakusei.TokuChoSoufuJohoSakuseiEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokuchosoufujohosakusei.ITokuChoSoufuJohoSakuseiMapper;
import jp.co.ndensan.reams.db.dbb.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.TokuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.Tsuki;
import jp.co.ndensan.reams.db.dbz.business.util.DateConverter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.UeT0515KaigohokenNenkinTokuchoTaishoshaJoho550Entity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.UeT1704KaigoTokuchoTorikomiRirekiEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.ue.uex.definition.core.TsuchiNaiyoCodeType;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * ビジネス設計_DBBBZ84001_3_特徴制度間Ｉ／Ｆ（バッチ）のクラスです。
 *
 * @reamsid_L DBB-1830-050 liuyang
 */
public class TokuChoSoufuJohoSakuseiBatch {

    private final RString 月2 = new RString("02");
    private final RString 月4 = new RString("04");
    private final RString 月6 = new RString("06");
    private final RString 月8 = new RString("08");
    private final RString 月10 = new RString("10");
    private final RString 月12 = new RString("12");
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
    private static final RString RS0001 = new RString("0001");
    private static final RString RS0002 = new RString("0002");
    private static final RString RS0004 = new RString("0004");
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
    private static final RString LINE = new RString("|");
    private static final RString STR5 = new RString("5");
    private static final RString 特徴制度間IF全件作成 = new RString("DBBMN84002");
    private static final RString 特徴制度間IF作成 = new RString("DBBMN84001");
    private static final RString 依頼金額計算 = new RString("依頼金額計算");
    private static final RString 本算定賦課 = new RString("本算定賦課");
    private static final RString 金額あり = new RString("1");
    private static final RString 金額なし = new RString("2");
    private final DbT7022ShoriDateKanriDac 処理日付管理マスタdac;
    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    TokuChoSoufuJohoSakuseiBatch() {
        処理日付管理マスタdac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
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
     * 介護特別徴収情報取込履歴の最大の連番を取得する。
     *
     * @return int
     */
    public int get最大の連番() {
        ITokuChoSoufuJohoSakuseiMapper mapper = mapperProvider.create(ITokuChoSoufuJohoSakuseiMapper.class);
        Integer maxRenban = mapper.selectMaxRenbanUeT1704();
        return (maxRenban == null) ? 1 : (maxRenban + 1);
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
        int 連番 = get最大の連番();
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
     * getKeyOfTokuChoSoufuJohoSakuseiEntityのメソッドです。
     *
     * @param entity TokuChoSoufuJohoSakuseiEntity
     * @return RString
     */
    public RString getKeyOfTokuChoSoufuJohoSakuseiEntity(TokuChoSoufuJohoSakuseiEntity entity) {
        if (entity.getDbt2002entity() == null) {
            return null;
        }
        RString strChoteiNendo = entity.getDbt2002entity().getChoteiNendo().toDateString();
        RString strFukaNendo = entity.getDbt2002entity().getFukaNendo().toDateString();
        RString strTsuchishoNo = entity.getDbt2002entity().getTsuchishoNo().value();
        return strChoteiNendo.concat(LINE).concat(strFukaNendo).concat(LINE).concat(strTsuchishoNo);
    }

    /**
     * 追加用データ作成。
     *
     * @param 特徴開始月 RDate
     * @param 処理日時 RDateTime
     * @param 連番 int
     * @param 基準日時 YMDHMS
     * @param 特徴開始月_6月捕捉 RString
     * @param 特徴開始月_8月捕捉 RString
     * @param resultEntities List<TokuChoSoufuJohoSakuseiEntity>
     * @param シーケンスMap Map<RString, Integer>
     * @return UeT0515KaigohokenNenkinTokuchoTaishoshaJoho550Entity
     */
    public UeT0515KaigohokenNenkinTokuchoTaishoshaJoho550Entity setTuikaData(
            RDate 特徴開始月,
            RDateTime 処理日時,
            int 連番,
            YMDHMS 基準日時,
            RString 特徴開始月_6月捕捉,
            RString 特徴開始月_8月捕捉,
            List<TokuChoSoufuJohoSakuseiEntity> resultEntities,
            Map<RString, Integer> シーケンスMap) {
        TokuChoSoufuJohoSakuseiResult sakuseiResult = TokuChoSoufuJohoSakuseiResult.getTokuChoSoufuJohoSakuseiResult(resultEntities);
        UeT0515KaigohokenNenkinTokuchoTaishoshaJoho550Entity tempEntity = new UeT0515KaigohokenNenkinTokuchoTaishoshaJoho550Entity();
        tempEntity.setRenban(連番);
        RString 基礎年金番号 = sakuseiResult.get対象者の情報().get基礎年金番号();
        tempEntity.setKisoNenkinNo(基礎年金番号);
        RString 年金コード = sakuseiResult.get対象者の情報().get年金コード();
        tempEntity.setNenkinCode(年金コード);
        基礎年金番号 = RString.isNullOrEmpty(基礎年金番号) ? RString.EMPTY : 基礎年金番号;
        年金コード = RString.isNullOrEmpty(年金コード) ? RString.EMPTY : 年金コード;
        RString key = new RString(連番).concat(LINE).concat(基礎年金番号).concat(LINE).concat(年金コード);
        int シーケンス;
        if (シーケンスMap.containsKey(key)) {
            シーケンス = シーケンスMap.get(key) + 1;
            シーケンスMap.put(key, シーケンス);
        } else {
            シーケンスMap.put(key, NUM1);
            シーケンス = NUM1;
        }
        tempEntity.setSeq(シーケンス);
        tempEntity.setShoriTimestamp(処理日時);
        tempEntity.setDtCityCode(sakuseiResult.get対象者の情報().getDT市町村コード());
        if (sakuseiResult.get対象者の情報().getDT特別徴収義務者コード() != null) {
            tempEntity.setDtTokubetsuChoshuGimushaCode(sakuseiResult.get対象者の情報().getDT特別徴収義務者コード().value().value());
        }
        if (TsuchiNaiyoCodeType.特別徴収対象者情報.equals(
                sakuseiResult.get対象者の情報().getDT通知内容コード().value())) {
            tempEntity.setDtTsuchiNaiyoCode(TsuchiNaiyoCodeType.特別徴収依頼通知.get通知内容コード());
        } else if (TsuchiNaiyoCodeType.特別徴収追加候補者情報.equals(
                sakuseiResult.get対象者の情報().getDT通知内容コード().value())) {
            tempEntity.setDtTsuchiNaiyoCode(TsuchiNaiyoCodeType.特別徴収追加依頼通知.get通知内容コード());
        }
        tempEntity.setDtBaitaiCode(定値_DT媒体コード);
        if (sakuseiResult.get対象者の情報().getDT特別徴収制度コード() != null) {
            tempEntity.setDtTokubetsuChoshuSeidoCode(sakuseiResult.get対象者の情報().getDT特別徴収制度コード().getColumnValue());
        }
        setEntityValue(tempEntity, sakuseiResult, 特徴開始月, 処理日時, 基準日時, 特徴開始月_6月捕捉, 特徴開始月_8月捕捉);
        return tempEntity;
    }

    private void setEntityValue(UeT0515KaigohokenNenkinTokuchoTaishoshaJoho550Entity tokuchotempentity,
            TokuChoSoufuJohoSakuseiResult entity, RDate 特徴開始月, RDateTime 処理日時, YMDHMS 基準日時,
            RString 特徴開始月_6月捕捉, RString 特徴開始月_8月捕捉) {
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
            tokuchotempentity.setDtSeibetsu(entity.get対象者の情報().getDT性別().getColumnValue());
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
        RString 徴収方法n月 = RString.EMPTY;
        if (null != entity.get徴収方法の情報()) {
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
            }
        }
        if (処理日時 != null) {
            tokuchotempentity.setDtKakushuYMD(処理日時.getDate().toDateString());
        }
        setEntityValueContinue(tokuchotempentity, entity, 特徴開始月, 徴収方法n月, 基準日時,
                特徴開始月_6月捕捉, 特徴開始月_8月捕捉);
    }

    private void setEntityValueContinue(UeT0515KaigohokenNenkinTokuchoTaishoshaJoho550Entity tokuchotempentity,
            TokuChoSoufuJohoSakuseiResult entity, RDate 特徴開始月, RString 徴収方法n月, YMDHMS 基準日時,
            RString 特徴開始月_6月捕捉, RString 特徴開始月_8月捕捉) {
        setDT各種区分(tokuchotempentity, entity, 徴収方法n月);
        tokuchotempentity.setDtShoriKekka(RString.FULL_SPACE);
        tokuchotempentity.setDtKokiIkanCode(RString.FULL_SPACE);
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
            tokuchotempentity.setKaigohokenJushochitokureiKubun(null == entity.get資格の情報() ? null : entity.get資格の情報().get住所地特例フラグ());
            if (entity.get対象者の情報().get処理年度() != null) {
                tokuchotempentity.setHosokuYMD(entity.get対象者の情報().get処理年度().toDateString().concat(
                        entity.get対象者の情報().get捕捉月()).concat(RS01));
            }
            if ((月6.equals(entity.get対象者の情報().get捕捉月()) && RS04.equals(特徴開始月_6月捕捉))
                    || (月8.equals(entity.get対象者の情報().get捕捉月()) && RS04.equals(特徴開始月_8月捕捉))) {
                tokuchotempentity.setTaikiFlag(RS1);
            } else {
                tokuchotempentity.setTaikiFlag(RS0);
            }
        }
    }

    private void setDT各種区分(UeT0515KaigohokenNenkinTokuchoTaishoshaJoho550Entity tokuchotempentity, TokuChoSoufuJohoSakuseiResult entity, RString 徴収方法n月) {
        if (null != entity.get資格の情報() && (RS1.equals(徴収方法n月) || RS2.equals(徴収方法n月)) && !RS1.equals(entity.get資格の情報().get住所地特例フラグ())) {
            tokuchotempentity.setDtKakushuKubun(RS01);
        } else if (null != entity.get資格の情報() && (RS1.equals(徴収方法n月) || RS2.equals(徴収方法n月)) && entity.get資格の情報().get資格喪失事由コード() == null
                && RS1.equals(entity.get資格の情報().get住所地特例フラグ())) {
            tokuchotempentity.setDtKakushuKubun(RS02);
        }
        if (null != entity.get徴収方法の情報() && !RS1.equals(entity.get徴収方法の情報().get徴収方法10月()) && !RS2.equals(entity.get徴収方法の情報().get徴収方法10月())) {
            tokuchotempentity.setDtKakushuKubun(RS03);
        }
    }

    private void setDT各種金額欄12(UeT0515KaigohokenNenkinTokuchoTaishoshaJoho550Entity tokuchotempentity,
            TokuChoSoufuJohoSakuseiResult entity, RDate 特徴開始月) {
        FukaJoho 賦課の情報 = entity.get賦課の情報();
        if (null != 賦課の情報 && TsuchiNaiyoCodeType.特別徴収対象者情報.equals(
                entity.get対象者の情報().getDT通知内容コード().value())) {
            if (賦課の情報.get特徴期別金額04() != null) {
                tokuchotempentity.setDtKakushuKingaku1(new RString(賦課の情報.get特徴期別金額04().toString()));
            }
            if (賦課の情報.get特徴期別金額05() != null) {
                tokuchotempentity.setDtKakushuKingaku2(new RString(賦課の情報.get特徴期別金額05().toString()));
            }
        } else if (TsuchiNaiyoCodeType.特別徴収追加候補者情報.equals(
                entity.get対象者の情報().getDT通知内容コード().value())) {
            TokuchoKiUtil tokuchokiutil = new TokuchoKiUtil();
            RString 期 = tokuchokiutil.get期月リスト().get月の期(Tsuki.toValue(
                    new RString(特徴開始月.getMonthValue()).padZeroToLeft(NUM2))).get期();
            if (null != 賦課の情報) {
                setDT各種金額欄1(期, tokuchotempentity, 賦課の情報);
            }
            tokuchotempentity.setDtKakushuKingaku2(RS0);
        } else {
            tokuchotempentity.setDtKakushuKingaku2(RS0);
        }
    }

    private void setDT各種金額欄1(RString 期, UeT0515KaigohokenNenkinTokuchoTaishoshaJoho550Entity tokuchotempentity,
            FukaJoho 賦課の情報) {
        if (RS01.equals(期) && 賦課の情報.get特徴期別金額01() != null) {
            tokuchotempentity.setDtKakushuKingaku1(new RString(賦課の情報.get特徴期別金額01().toString()));
        }
        if (RS02.equals(期) && 賦課の情報.get特徴期別金額02() != null) {
            tokuchotempentity.setDtKakushuKingaku1(new RString(賦課の情報.get特徴期別金額02().toString()));
        }
        if (RS03.equals(期) && 賦課の情報.get特徴期別金額03() != null) {
            tokuchotempentity.setDtKakushuKingaku1(new RString(賦課の情報.get特徴期別金額03().toString()));
        }
        if (RS04.equals(期) && 賦課の情報.get特徴期別金額04() != null) {
            tokuchotempentity.setDtKakushuKingaku1(new RString(賦課の情報.get特徴期別金額04().toString()));
        }
        if (RS05.equals(期) && 賦課の情報.get特徴期別金額05() != null) {
            tokuchotempentity.setDtKakushuKingaku1(new RString(賦課の情報.get特徴期別金額05().toString()));
        }
        if (RS06.equals(期) && 賦課の情報.get特徴期別金額06() != null) {
            tokuchotempentity.setDtKakushuKingaku1(new RString(賦課の情報.get特徴期別金額06().toString()));
        }
    }

    /**
     * 特徴依頼金額計算の判定
     *
     * @param 特徴開始月 RDate
     * @param 処理年度 FlexibleYear
     * @return 基準日時 YMDHMS
     */
    public YMDHMS chkTokuchoIraikinKeisan(RDate 特徴開始月, FlexibleYear 処理年度) {
        if (処理年度 == null || 特徴開始月 == null) {
            return null;
        }
        FlexibleYear 年度 = null;
        RString 年度内年番 = null;
        RString 処理名 = null;
        RString 特徴開始月数 = DateConverter.formatMonthFull(特徴開始月.getMonthValue());
        if (月6.equals(特徴開始月数)) {
            年度 = 処理年度.plusYear(NUM1);
            年度内年番 = RS0001;
            処理名 = 依頼金額計算;
        } else if (月8.equals(特徴開始月数)) {
            年度 = 処理年度;
            年度内年番 = RS0002;
            処理名 = 依頼金額計算;
        } else if (月10.equals(特徴開始月数)) {
            年度 = 処理年度;
            年度内年番 = RS0001;
            処理名 = 本算定賦課;
        } else if (月12.equals(特徴開始月数)) {
            年度 = 処理年度;
            年度内年番 = RS0004;
            処理名 = 依頼金額計算;
        } else if (月2.equals(特徴開始月数)) {
            年度 = 処理年度;
            年度内年番 = RS0005;
            処理名 = 依頼金額計算;
        } else if (月4.equals(特徴開始月数)) {
            年度 = 処理年度;
            年度内年番 = RS0006;
            処理名 = 依頼金額計算;
        }
        List<DbT7022ShoriDateKanriEntity> shoridatekanrientityList = 処理日付管理マスタdac.selectBySomeKeys(
                SubGyomuCode.DBB介護賦課, 処理名, RS0001, 年度, 年度内年番);
        if (shoridatekanrientityList.isEmpty()) {
            return null;
        } else {
            return shoridatekanrientityList.get(0).getKijunTimestamp();
        }
    }

}
