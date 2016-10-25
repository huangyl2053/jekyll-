/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.euc.nenkintokucho;

import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.dbb241001.TokuchoHaishinDataTorikomiMybatisParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.UeT0511NenkinTokuchoKaifuJohoEntity;
import jp.co.ndensan.reams.ue.uex.definition.core.TsuchiNaiyoCodeType;
import jp.co.ndensan.reams.ue.uex.entity.db.relate.uext00010.TorikomiFileKaifuJohoTempEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBB241001_特徴配信データ取り込みのDB出力データの編集クラスです。
 *
 * @reamsid_L DBB-4270-020 chenyadong
 */
public class NenkinTokuchoInsertEditor {

    private static final RString TRIPLE_DOLLAR = new RString("$$$");
    private static final int INT_0 = 0;
    private static final int INT_1 = 1;
    private static final int INT_2 = 2;
    private static final int INT_4 = 4;
    private static final int INT_6 = 6;
    private static final RString RSTRING_12 = new RString("12");

    /**
     * DB出力データを編集します。
     *
     * @param tmpEntity TorikomiFileKaifuJohoTempEntity
     * @param parameter TokuchoHaishinDataTorikomiMybatisParameter
     * @param 処理日時 RDateTime
     * @param 連携種別 RString
     * @param 処理対象年月 FlexibleYearMonth
     * @return UeT0511NenkinTokuchoKaifuJohoEntity
     */
    public UeT0511NenkinTokuchoKaifuJohoEntity get対象者or追加候補者情報CsvEntity(TorikomiFileKaifuJohoTempEntity tmpEntity,
            TokuchoHaishinDataTorikomiMybatisParameter parameter, RDateTime 処理日時, RString 連携種別, FlexibleYearMonth 処理対象年月) {
        UeT0511NenkinTokuchoKaifuJohoEntity johoEntity = new UeT0511NenkinTokuchoKaifuJohoEntity();
        johoEntity.setGyomuCode(parameter.getGyomuCode());
        johoEntity.setShoriNendo(parameter.getShoriNendo());
        johoEntity.setTsuchiNaiyoCode(tmpEntity.getTsuchiNaiyoCode());
        johoEntity.setShoriTaishoYM(parameter.getShoriTaishoYM());
        johoEntity.setKisoNenkinNo(tmpEntity.getKisoNenkinNo());
        johoEntity.setNenkinCode(tmpEntity.getNenkinCode());
        johoEntity.setKoseiCityCode(tmpEntity.getShichosoCode());
        johoEntity.setRenban(parameter.getRenban());
        johoEntity.setShoriTimestamp(処理日時);
        johoEntity.setRenkeiShubetsu(連携種別);
        if (TsuchiNaiyoCodeType.特別徴収対象者情報.get通知内容コード().equals(tmpEntity.getTsuchiNaiyoCode())
                || TsuchiNaiyoCodeType.特別徴収追加候補者情報.get通知内容コード().equals(tmpEntity.getTsuchiNaiyoCode())) {
            johoEntity.setHosokuTsuki(get捕捉月(処理対象年月));
        } else {
            johoEntity.setHosokuTsuki(RString.EMPTY);
        }
        if (TsuchiNaiyoCodeType.特別徴収結果通知.get通知内容コード().equals(tmpEntity.getTsuchiNaiyoCode())) {
            johoEntity.setTenbikiTsuki(get天引月(処理対象年月));
        } else {
            johoEntity.setTenbikiTsuki(RString.EMPTY);
        }
        johoEntity.setDtCityCode(tmpEntity.getShichosoCode());
        johoEntity.setDtTokubetsuChoshuGimushaCode(new Code(tmpEntity.getTokuchoGimuCode()));
        johoEntity.setDtTsuchiNaiyoCode(tmpEntity.getTsuchiNaiyoCode());
        johoEntity.setDtBaitaiCode(tmpEntity.getYobi1());
        johoEntity.setDtTokubetsuChoshuSeidoCode(tmpEntity.getTokuchoSeidoCode());
        johoEntity.setDtSakuseiYMD(new RString(tmpEntity.getSakuseiYMD().toString()));
        johoEntity.setDtKisoNenkinNo(tmpEntity.getKisoNenkinNo());
        johoEntity.setDtNenkinCode(tmpEntity.getNenkinCode());
        johoEntity.setDtYobi1(tmpEntity.getYobi2());
        johoEntity.setDtBirthDay(new RString(tmpEntity.getSeiNengappi().toString()));
        johoEntity.setDtSeibetsu(tmpEntity.getSeibetsu());
        johoEntity.setDtKanaShimei(tmpEntity.getShimeiKana());
        johoEntity.setDtShiftCode1(TRIPLE_DOLLAR);
        johoEntity.setDtKanjiShimei(tmpEntity.getShimeiKanji());
        johoEntity.setDtShiftCode2(TRIPLE_DOLLAR);
        johoEntity.setDtYubinNo(tmpEntity.getJushoYubinNo());
        johoEntity.setDtKanaJusho(tmpEntity.getJushoKana());
        johoEntity.setDtShiftCode3(TRIPLE_DOLLAR);
        johoEntity.setDtKanjiJusho(tmpEntity.getJushoKanji());
        johoEntity.setDtShiftCode4(TRIPLE_DOLLAR);
        johoEntity.setDtKakushuKubun(tmpEntity.getKakushuKubun());
        johoEntity.setDtShoriKekka(tmpEntity.getShoriKeikka());
        johoEntity.setDtKokiIkanCode(tmpEntity.getGokoIkanCode());
        johoEntity.setDtKakushuYMD(new RString(tmpEntity.getKakushuYMD().toString()));
        johoEntity.setDtKakushuKingaku1(new RString(tmpEntity.getKakushuKingaku1().toString()));
        johoEntity.setDtKakushuKingaku2(new RString(tmpEntity.getKakushuKingaku2().toString()));
        johoEntity.setDtKakushuKingaku3(new RString(tmpEntity.getKakushuKingaku3().toString()));
        johoEntity.setDtYobi2(tmpEntity.getYobi3());
        johoEntity.setDtKyosaiNenkinshoshoKigoNo(tmpEntity.getKyosaiNenkinShoshoKigoBango());
        johoEntity.setShikibetsuCode(ShikibetsuCode.EMPTY);
        johoEntity.setHihokenshaNo(RString.EMPTY);
        johoEntity.setKokuhoSetaiCode(SetaiCode.EMPTY);
        return johoEntity;

    }

    private RString get捕捉月(FlexibleYearMonth 処理対象年月) {
        RString 捕捉月 = RString.EMPTY;
        if (処理対象年月.getMonthValue() % INT_2 == INT_0) {
            if (処理対象年月.getMonthValue() == INT_2) {
                捕捉月 = RSTRING_12;
            } else {
                捕捉月 = 処理対象年月.minusMonth(INT_2).toDateString().substring(INT_4, INT_6);
            }
        }
        return 捕捉月;
    }

    private RString get天引月(FlexibleYearMonth 処理対象年月) {
        RString 天引月 = RString.EMPTY;
        if (処理対象年月.getMonthValue() % INT_2 != INT_0) {
            if (処理対象年月.getMonthValue() == INT_1) {
                天引月 = RSTRING_12;
            } else {
                天引月 = 処理対象年月.minusMonth(INT_1).toDateString().substring(INT_4, INT_6);
            }
        }
        return 天引月;
    }
}
