/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.tokuchosoufujohosakuseibatch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.business.core.basic.tokuchosoufujohosakusei.TokuChoSoufuJohoSakuseiResult;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchotaishoshaichiransakusei.TokuchoSeidokanIFSakuseiMyBatisParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchosoufujohosakusei.TokuChoSoufuJohoSakuseiEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokuchosoufujohosakusei.ITokuChoSoufuJohoSakuseiMapper;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokuchotaishoshaichiransakusei.IUeT0511Mapper;
import jp.co.ndensan.reams.db.dbb.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.TokuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.Tsuki;
import jp.co.ndensan.reams.db.dbz.business.util.DateConverter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.UeT0515KaigohokenNenkinTokuchoTaishoshaJoho550Entity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.UeT1704KaigoTokuchoTorikomiRirekiEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.ue.uex.definition.core.RenkeiShubetsu;
import jp.co.ndensan.reams.ue.uex.definition.core.SeibetsuCodeNenkinTokucho;
import jp.co.ndensan.reams.ue.uex.definition.core.TokubetsuChoshuGimushaCode;
import jp.co.ndensan.reams.ue.uex.definition.core.TokubetsuChoshuSeidoCode;
import jp.co.ndensan.reams.ue.uex.definition.core.TsuchiNaiyoCode;
import jp.co.ndensan.reams.ue.uex.definition.core.TsuchiNaiyoCodeType;
import jp.co.ndensan.reams.ue.uex.entity.db.basic.UeT0511NenkinTokuchoKaifuJohoEntity;
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
    private static final RString RS30 = new RString("30");
    private static final RString RS00 = new RString("00");
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
    private static final RString GENERICKEY = new RString("UeT1704KaigoTokuchoTorikomiRireki_renban");
    private final FlexibleYear 年度 = new FlexibleYear("0000");
    private final MapperProvider mapperProvider;
    private final DbT7022ShoriDateKanriDac 処理日付管理マスタdac;
    private final ITokuChoSoufuJohoSakuseiMapper mapper;
    private final IUeT0511Mapper uet0511Mapper;

    /**
     * コンストラクタです。
     */
    TokuChoSoufuJohoSakuseiBatch() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        処理日付管理マスタdac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
        mapper = mapperProvider.create(ITokuChoSoufuJohoSakuseiMapper.class);
        uet0511Mapper = mapperProvider.create(IUeT0511Mapper.class);
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
    public List<UeT0511NenkinTokuchoKaifuJohoEntity> selectNenkinTokuChoKaifuJoho(
            FlexibleYear 処理年度, RDate 特徴開始月, RString 遷移元メニュー) {
        if (特徴開始月 == null || 処理年度 == null) {
            return new ArrayList();
        }
        TokuchoSeidokanIFSakuseiMyBatisParameter param = new TokuchoSeidokanIFSakuseiMyBatisParameter(処理年度);
        int 特徴開始年数 = 特徴開始月.getYearValue();
        RString 特徴開始月数 = DateConverter.formatMonthFull(特徴開始月.getMonthValue());
        List<jp.co.ndensan.reams.ue.uex.entity.db.basic.UeT0511NenkinTokuchoKaifuJohoEntity> results = null;

        FlexibleYear 入力処理年度 = null;
        RString 通知内容コード = null;
        RString 捕捉月 = RString.EMPTY;
        if (月8.equals(特徴開始月数)) {
            if (特徴制度間IF全件作成.equals(遷移元メニュー)) {
                results = uet0511Mapper.selectAug(param);
            }
            入力処理年度 = new FlexibleYear(DateConverter.formatYearFull(特徴開始年数));
            通知内容コード = RS30;
            捕捉月 = 月2;
        } else if (月10.equals(特徴開始月数)) {
            if (特徴制度間IF全件作成.equals(遷移元メニュー)) {
                results = uet0511Mapper.selectOct(param);
            }
            入力処理年度 = new FlexibleYear(DateConverter.formatYearFull(特徴開始年数));
            通知内容コード = RS00;
            捕捉月 = 月4;
        } else if (月12.equals(特徴開始月数)) {
            if (特徴制度間IF全件作成.equals(遷移元メニュー)) {
                results = uet0511Mapper.selectDec(param);
            }
            入力処理年度 = new FlexibleYear(DateConverter.formatYearFull(特徴開始年数));
            通知内容コード = RS30;
            捕捉月 = 月6;
        } else if (月2.equals(特徴開始月数)) {
            if (特徴制度間IF全件作成.equals(遷移元メニュー)) {
                results = uet0511Mapper.selectFeb(param);
            }
            入力処理年度 = new FlexibleYear(DateConverter.formatYearFull(特徴開始年数 - 1));
            通知内容コード = RS30;
            捕捉月 = 月8;
        } else if (月4.equals(特徴開始月数)) {
            if (特徴制度間IF全件作成.equals(遷移元メニュー)) {
                results = uet0511Mapper.selectApr(param);
            }
            入力処理年度 = new FlexibleYear(DateConverter.formatYearFull(特徴開始年数 - 1));
            通知内容コード = RS30;
            捕捉月 = 月10;
        } else if (月6.equals(特徴開始月数)) {
            if (特徴制度間IF全件作成.equals(遷移元メニュー)) {
                results = uet0511Mapper.selectJun(param);
            }
            入力処理年度 = new FlexibleYear(DateConverter.formatYearFull(特徴開始年数 - 1));
            通知内容コード = RS30;
            捕捉月 = 月12;
        }
        if (特徴制度間IF作成.equals(遷移元メニュー)) {
            results = uet0511Mapper.select(new TokuchoSeidokanIFSakuseiMyBatisParameter(
                    入力処理年度, 通知内容コード, 捕捉月));
        }
        return results;
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
        int 連番 = 0;
        if (resultlist != null && !resultlist.isEmpty()) {
            連番 = (int) Saiban.get(SubGyomuCode.UEA特別徴収分配集約, GENERICKEY, 年度).next();
        }
        int シーケンス;
        Map<RString, Integer> シーケンスMap = new HashMap<>();
        for (TokuChoSoufuJohoSakuseiResult entity : resultlist) {
            UeT0515KaigohokenNenkinTokuchoTaishoshaJoho550Entity tokuchotempentity = new UeT0515KaigohokenNenkinTokuchoTaishoshaJoho550Entity();
            tokuchotempentity.setRenban(連番);
            RString 基礎年金番号 = entity.get対象者の情報().get基礎年金番号();
            tokuchotempentity.setKisoNenkinNo(基礎年金番号);
            RString 年金コード = entity.get対象者の情報().get年金コード();
            tokuchotempentity.setNenkinCode(年金コード);
            基礎年金番号 = RString.isNullOrEmpty(基礎年金番号) ? RString.EMPTY : 基礎年金番号;
            年金コード = RString.isNullOrEmpty(年金コード) ? RString.EMPTY : 年金コード;
            RString key = new RString(連番).concat(LINE).concat(基礎年金番号).concat(LINE).concat(年金コード);
            if (シーケンスMap.containsKey(key)) {
                シーケンス = シーケンスMap.get(key) + 1;
                シーケンスMap.put(key, シーケンス);
            } else {
                シーケンスMap.put(key, NUM1);
                シーケンス = NUM1;
            }
            tokuchotempentity.setSeq(シーケンス);
            tokuchotempentity.setShoriTimestamp(処理日時);
            tokuchotempentity.setDtCityCode(entity.get対象者の情報().getDT市町村コード());
            if (entity.get対象者の情報().getDT特別徴収義務者コード() != null) {
                tokuchotempentity.setDtTokubetsuChoshuGimushaCode(entity.get対象者の情報().getDT特別徴収義務者コード().value());
            }
            if (TsuchiNaiyoCodeType.特別徴収対象者情報.get通知内容コード().equals(
                    entity.get対象者の情報().getDT通知内容コード())) {
                tokuchotempentity.setDtTsuchiNaiyoCode(TsuchiNaiyoCodeType.特別徴収依頼通知.get通知内容コード());
            } else if (TsuchiNaiyoCodeType.特別徴収追加候補者情報.get通知内容コード().equals(
                    entity.get対象者の情報().getDT通知内容コード())) {
                tokuchotempentity.setDtTsuchiNaiyoCode(TsuchiNaiyoCodeType.特別徴収追加依頼通知.get通知内容コード());
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
        setEntityValueContinue(tokuchotempentity, entity, 処理年度, 特徴開始月, 徴収方法n月);
    }

    private void setEntityValueContinue(UeT0515KaigohokenNenkinTokuchoTaishoshaJoho550Entity tokuchotempentity,
            TokuChoSoufuJohoSakuseiResult entity, FlexibleYear 処理年度, RDate 特徴開始月, RString 徴収方法n月) {
        if ((RS1.equals(徴収方法n月) || RS2.equals(徴収方法n月)) && !RS1.equals(entity.get資格の情報().get住所地特例フラグ())) {
            tokuchotempentity.setDtKakushuKubun(RS01);
        } else if ((RS1.equals(徴収方法n月) || RS2.equals(徴収方法n月)) && entity.get資格の情報().get資格喪失事由コード() == null
                && RS1.equals(entity.get資格の情報().get住所地特例フラグ())) {
            tokuchotempentity.setDtKakushuKubun(RS02);
        }
        if (!RS1.equals(entity.get徴収方法の情報().get徴収方法10月()) && !RS2.equals(entity.get徴収方法の情報().get徴収方法10月())) {
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
        List<UeT0515KaigohokenNenkinTokuchoTaishoshaJoho550Entity> dbzEntitis = new ArrayList<>();
        for (jp.co.ndensan.reams.ue.uex.entity.db.basic.UeT0515KaigohokenNenkinTokuchoTaishoshaJoho550Entity entity
                : mapper.selectUeT0515KaigohokenNenkinTokuchoTaishoshaJoho550tempAll()) {
            if (entity != null) {
                dbzEntitis.add(entityCopy(entity));
            }
        }
        return dbzEntitis;
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
        DbT7022ShoriDateKanriEntity shoridatekanrientity = 処理日付管理マスタdac.selectBySomeKeysLimits(
                SubGyomuCode.DBB介護賦課, 処理名, RS0001, 年度, 年度内年番);
        if (shoridatekanrientity == null) {
            return null;
        } else {
            return shoridatekanrientity.getKijunTimestamp();
        }
    }

    /**
     * Entity転換のメソドです。
     *
     * @param entity
     * jp.co.ndensan.reams.ue.uex.entity.db.basic.UeT0511NenkinTokuchoKaifuJohoEntity
     * @return
     * jp.co.ndensan.reams.db.dbz.entity.db.basic.UeT0511NenkinTokuchoKaifuJohoEntity
     */
    public jp.co.ndensan.reams.db.dbz.entity.db.basic.UeT0511NenkinTokuchoKaifuJohoEntity entityCopy(
            UeT0511NenkinTokuchoKaifuJohoEntity entity) {
        jp.co.ndensan.reams.db.dbz.entity.db.basic.UeT0511NenkinTokuchoKaifuJohoEntity dbzEntity
                = new jp.co.ndensan.reams.db.dbz.entity.db.basic.UeT0511NenkinTokuchoKaifuJohoEntity();
        if (entity == null) {
            return dbzEntity;
        }
        dbzEntity.setGyomuCode(entity.getGyomuCode());
        dbzEntity.setShoriNendo(entity.getShoriNendo());
        TsuchiNaiyoCode tsuchiNaiyoCode = entity.getTsuchiNaiyoCode();
        dbzEntity.setTsuchiNaiyoCode(tsuchiNaiyoCode == null ? RString.EMPTY
                : tsuchiNaiyoCode.value().get通知内容コード());
        dbzEntity.setShoriTaishoYM(entity.getShoriTaishoYM());
        dbzEntity.setKisoNenkinNo(entity.getKisoNenkinNo());
        dbzEntity.setNenkinCode(entity.getNenkinCode());
        dbzEntity.setKoseiCityCode(entity.getKoseiCityCode());
        dbzEntity.setRenban(entity.getRenban());
        dbzEntity.setShoriTimestamp(entity.getShoriTimestamp());
        RenkeiShubetsu renkeiShubetsu = entity.getRenkeiShubetsu();
        dbzEntity.setRenkeiShubetsu(renkeiShubetsu == null ? RString.EMPTY : renkeiShubetsu.value().code());
        dbzEntity.setHosokuTsuki(entity.getHosokuTsuki());
        dbzEntity.setTenbikiTsuki(entity.getTenbikiTsuki());
        dbzEntity.setDtCityCode(entity.getDtCityCode());
        TokubetsuChoshuGimushaCode tokubetsuChoshuGimushaCode = entity.getDtTokubetsuChoshuGimushaCode();
        dbzEntity.setDtTokubetsuChoshuGimushaCode(tokubetsuChoshuGimushaCode == null ? null
                : tokubetsuChoshuGimushaCode.value());
        tsuchiNaiyoCode = entity.getDtTsuchiNaiyoCode();
        dbzEntity.setDtTsuchiNaiyoCode(tsuchiNaiyoCode == null ? RString.EMPTY
                : tsuchiNaiyoCode.value().get通知内容コード());
        dbzEntity.setDtBaitaiCode(entity.getDtBaitaiCode());
        TokubetsuChoshuSeidoCode tokubetsuChoshuSeidoCode = entity.getDtTokubetsuChoshuSeidoCode();
        dbzEntity.setDtTokubetsuChoshuSeidoCode(tokubetsuChoshuSeidoCode == null ? RString.EMPTY
                : tokubetsuChoshuSeidoCode.value().getコード());
        dbzEntity.setDtSakuseiYMD(entity.getDtSakuseiYMD());
        dbzEntity.setDtKisoNenkinNo(entity.getDtKisoNenkinNo());
        dbzEntity.setDtNenkinCode(entity.getDtNenkinCode());
        dbzEntity.setDtYobi1(entity.getDtYobi1());
        dbzEntity.setDtBirthDay(entity.getDtBirthDay());
        SeibetsuCodeNenkinTokucho seibetsuCodeNenkinTokucho = entity.getDtSeibetsu();
        dbzEntity.setDtSeibetsu(seibetsuCodeNenkinTokucho == null ? RString.EMPTY
                : seibetsuCodeNenkinTokucho.value().get性別コード());
        dbzEntity.setDtKanaShimei(entity.getDtKanaShimei());
        dbzEntity.setDtShiftCode1(entity.getDtShiftCode1());
        dbzEntity.setDtKanjiShimei(entity.getDtKanjiShimei());
        dbzEntity.setDtShiftCode2(entity.getDtShiftCode2());
        dbzEntity.setDtYubinNo(entity.getDtYubinNo());
        dbzEntity.setDtKanaJusho(entity.getDtKanaJusho());
        dbzEntity.setDtShiftCode3(entity.getDtShiftCode3());
        dbzEntity.setDtKanjiJusho(entity.getDtKanjiJusho());
        dbzEntity.setDtShiftCode4(entity.getDtShiftCode4());
        dbzEntity.setDtKakushuKubun(entity.getDtKakushuKubun());
        dbzEntity.setDtShoriKekka(entity.getDtShoriKekka());
        dbzEntity.setDtKokiIkanCode(entity.getDtKokiIkanCode());
        dbzEntity.setDtKakushuYMD(entity.getDtKakushuYMD());
        dbzEntity.setDtKakushuKingaku1(entity.getDtKakushuKingaku1());
        dbzEntity.setDtKakushuKingaku2(entity.getDtKakushuKingaku2());
        dbzEntity.setDtKakushuKingaku3(entity.getDtKakushuKingaku3());
        dbzEntity.setDtYobi2(entity.getDtYobi2());
        dbzEntity.setDtKyosaiNenkinshoshoKigoNo(entity.getDtKyosaiNenkinshoshoKigoNo());
        dbzEntity.setShikibetsuCode(entity.getShikibetsuCode());
        dbzEntity.setHihokenshaNo(entity.getHihokenshaNo());
        dbzEntity.setKokuhoSetaiCode(entity.getKokuhoSetaiCode());
        dbzEntity.setDtKakushuKingaku4(entity.getDtKakushuKingaku4());
        dbzEntity.setDtKakushuKingaku5(entity.getDtKakushuKingaku5());
        dbzEntity.setDtKakushuKingaku6(entity.getDtKakushuKingaku6());
        dbzEntity.setDtKakushuKingaku7(entity.getDtKakushuKingaku7());
        dbzEntity.setDtKakushuKingaku8(entity.getDtKakushuKingaku8());
        dbzEntity.setDtTeishiYM(entity.getDtTeishiYM());
        dbzEntity.setDtYobi4Juminzei(entity.getDtYobi4Juminzei());
        dbzEntity.setDtKojinNo(entity.getDtKojinNo());
        dbzEntity.setKokuhoYoteiSoshitsuKubun(entity.getKokuhoYoteiSoshitsuKubun());
        return dbzEntity;
    }

    /**
     * Entity転換のメソドです。
     *
     * @param entity
     * jp.co.ndensan.reams.ue.uex.entity.db.basic.UeT0511NenkinTokuchoKaifuJohoEntity
     * @return
     * jp.co.ndensan.reams.db.dbz.entity.db.basic.UeT0511NenkinTokuchoKaifuJohoEntity
     */
    public UeT0515KaigohokenNenkinTokuchoTaishoshaJoho550Entity entityCopy(
            jp.co.ndensan.reams.ue.uex.entity.db.basic.UeT0515KaigohokenNenkinTokuchoTaishoshaJoho550Entity entity) {
        UeT0515KaigohokenNenkinTokuchoTaishoshaJoho550Entity dbzEntity
                = new UeT0515KaigohokenNenkinTokuchoTaishoshaJoho550Entity();
        if (entity == null) {
            return dbzEntity;
        }
        dbzEntity.setRenban(entity.getRenban());
        dbzEntity.setKisoNenkinNo(entity.getKisoNenkinNo());
        dbzEntity.setNenkinCode(entity.getNenkinCode());
        dbzEntity.setSeq(entity.getSeq());
        dbzEntity.setShoriTimestamp(entity.getShoriTimestamp());
        dbzEntity.setDtCityCode(entity.getDtCityCode());
        dbzEntity.setDtTokubetsuChoshuGimushaCode(entity.getDtTokubetsuChoshuGimushaCode());
        dbzEntity.setDtTsuchiNaiyoCode(entity.getDtTsuchiNaiyoCode());
        dbzEntity.setDtBaitaiCode(entity.getDtBaitaiCode());
        dbzEntity.setDtTokubetsuChoshuSeidoCode(entity.getDtTokubetsuChoshuSeidoCode());
        dbzEntity.setDtSakuseiYMD(entity.getDtSakuseiYMD());
        dbzEntity.setDtKisoNenkinNo(entity.getDtKisoNenkinNo());
        dbzEntity.setDtNenkinCode(entity.getDtNenkinCode());
        dbzEntity.setDtYobi1(entity.getDtYobi1());
        dbzEntity.setDtBirthDay(entity.getDtBirthDay());
        dbzEntity.setDtSeibetsu(entity.getDtSeibetsu());
        dbzEntity.setDtKanaShimei(entity.getDtKanaShimei());
        dbzEntity.setDtShiftCode1(entity.getDtShiftCode1());
        dbzEntity.setDtKanjiShimei(entity.getDtKanjiShimei());
        dbzEntity.setDtShiftCode2(entity.getDtShiftCode2());
        dbzEntity.setDtYubinNo(entity.getDtYubinNo());
        dbzEntity.setDtKanaJusho(entity.getDtKanaJusho());
        dbzEntity.setDtShiftCode3(entity.getDtShiftCode3());
        dbzEntity.setDtKanjiJusho(entity.getDtKanjiJusho());
        dbzEntity.setDtShiftCode4(entity.getDtShiftCode4());
        dbzEntity.setDtKakushuKubun(entity.getDtKakushuKubun());
        dbzEntity.setDtShoriKekka(entity.getDtShoriKekka());
        dbzEntity.setDtKokiIkanCode(entity.getDtKokiIkanCode());
        dbzEntity.setDtKakushuYMD(entity.getDtKakushuYMD());
        dbzEntity.setDtKakushuKingaku1(entity.getDtKakushuKingaku1());
        dbzEntity.setDtKakushuKingaku2(entity.getDtKakushuKingaku2());
        dbzEntity.setDtKakushuKingaku3(entity.getDtKakushuKingaku3());
        dbzEntity.setDtYobi2(entity.getDtYobi2());
        dbzEntity.setDtKyosaiNenkinshoshoKigoNo(entity.getDtKyosaiNenkinshoshoKigoNo());
        dbzEntity.setKaigohokenHihokenshaNo(entity.getKaigohokenHihokenshaNo());
        dbzEntity.setKojinCodeKubun(entity.getKojinCodeKubun());
        dbzEntity.setKojinCode(entity.getKojinCode());
        dbzEntity.setKaigohokenJushochitokureiKubun(entity.getKaigohokenJushochitokureiKubun());
        dbzEntity.setHosokuYMD(entity.getHosokuYMD());
        dbzEntity.setTaikiFlag(entity.getTaikiFlag());
        dbzEntity.setYobi(entity.getYobi());
        dbzEntity.setHosokuYMD(entity.getHosokuYMD());
        dbzEntity.setTaikiFlag(entity.getTaikiFlag());
        dbzEntity.setYobi(entity.getYobi());
        return dbzEntity;
    }

}
