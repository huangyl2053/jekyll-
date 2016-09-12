/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.createtsukibetsusuiihyo;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 月別推移表作成のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBB-0760-030 lishengli
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class CreateTsukibetsuSuiihyoMyBatisParameter implements IMyBatisParameter {

    private static final RString 選択対象_町域 = new RString("町域");
    private static final RString 選択対象_行政区 = new RString("行政区");
    private static final RString 選択対象_地区1 = new RString("地区1");
    private static final RString 選択対象_地区2 = new RString("地区2");
    private static final RString 選択対象_地区3 = new RString("地区3");
    private static final int INT_65 = 65;
    private final FlexibleYear choteiNendo;
    private final RString choteiKijunNichiji;
    private final RString kakutukiShikakuKijunNichi;
    private final boolean ageFlg;
    private final RString ageStart;
    private final RString ageEnd;
    private final FlexibleDate ageKijunNi;
    private final boolean seinengappiYMDFlg;
    private final RString seinengappiYMDStart;
    private final RString seinengappiYMDEnd;
    private final RString sentakuTaisho;
    private final List<RString> sentakuKekkaList;
    private final RString shichosonCode;
    private final RString shichosonMeisho;
    private final RString kyuShichosonCode;
    private final RString kyuShichosonMeisho;
    private final boolean is1と3場合;
    private final boolean is2場合;
    private final boolean is町域;
    private final boolean is行政区;
    private final boolean is地区1;
    private final boolean is地区2;
    private final boolean is地区3;
    private final boolean is市町村コード;
    private final boolean is市町村と旧市町村;
    private final RString 調定年度3月31日;
    private final RString 調定年度0401;
    private final RString 調定年度0430;
    private final RString 調定年度減1;
    private final RString 調定年度減2;
    private final FlexibleDate 終了生年月日;
    private final FlexibleDate 開始生年月日;
    private final boolean hasCodeList;
    private final RString psmShikibetsuTaisho;

    /**
     * コンストラクタ。
     *
     * @param choteiNendo 調定年度
     * @param choteiKijunNichiji 調定基準日時
     * @param kakutukiShikakuKijunNichi 各月資格基準日
     * @param ageFlg 年齢フラグ
     * @param ageStart 年齢開始
     * @param ageEnd 年齢終了
     * @param ageKijunNi 年齢基準日
     * @param seinengappiYMDFlg 生年月日フラグ
     * @param seinengappiYMDStart 生年月日開始
     * @param seinengappiYMDEnd 生年月日終了
     * @param sentakuTaisho 選択対象
     * @param sentakuKekkaList List<SentakuKekka>
     * @param shichosonCode 市町村コード
     * @param shichosonMeisho 市町村名称
     * @param kyuShichosonCode 旧市町村コード
     * @param kyuShichosonMeisho 旧市町村名称
     * @param is1と3場合 is1と3場合
     * @param is2場合 is2場合
     * @param is町域 is町域
     * @param is行政区 is行政区
     * @param is地区1 is地区1
     * @param is地区2 is地区2
     * @param is地区3 is地区3
     * @param is市町村コード is市町村コード
     * @param is市町村と旧市町村 is市町村と旧市町村
     * @param 調定年度3月31日 調定年度3月31日
     * @param 調定年度0430 調定年度0430
     * @param 調定年度0401 調定年度0401
     * @param 調定年度減1 調定年度減1
     * @param 調定年度減2 調定年度減2
     * @param 終了生年月日 終了生年月日
     * @param 開始生年月日 開始生年月日
     * @param hasCodeList hasCodeList
     * @param psmShikibetsuTaisho PSM
     */
    private CreateTsukibetsuSuiihyoMyBatisParameter(
            FlexibleYear choteiNendo,
            RString choteiKijunNichiji,
            RString kakutukiShikakuKijunNichi,
            boolean ageFlg,
            RString ageStart,
            RString ageEnd,
            FlexibleDate ageKijunNi,
            boolean seinengappiYMDFlg,
            RString seinengappiYMDStart,
            RString seinengappiYMDEnd,
            RString sentakuTaisho,
            List<RString> sentakuKekkaList,
            RString shichosonCode,
            RString shichosonMeisho,
            RString kyuShichosonCode,
            RString kyuShichosonMeisho,
            boolean is1と3場合,
            boolean is2場合,
            boolean is町域,
            boolean is行政区,
            boolean is地区1,
            boolean is地区2,
            boolean is地区3,
            boolean is市町村コード,
            boolean is市町村と旧市町村,
            RString 調定年度3月31日,
            RString 調定年度0401,
            RString 調定年度0430,
            RString 調定年度減1,
            RString 調定年度減2,
            FlexibleDate 終了生年月日,
            FlexibleDate 開始生年月日,
            boolean hasCodeList,
            RString psmShikibetsuTaisho) {
        this.choteiNendo = choteiNendo;
        this.choteiKijunNichiji = choteiKijunNichiji;
        this.kakutukiShikakuKijunNichi = kakutukiShikakuKijunNichi;
        this.ageFlg = ageFlg;
        this.ageStart = ageStart;
        this.ageEnd = ageEnd;
        this.ageKijunNi = ageKijunNi;
        this.seinengappiYMDFlg = seinengappiYMDFlg;
        this.seinengappiYMDStart = seinengappiYMDStart;
        this.seinengappiYMDEnd = seinengappiYMDEnd;
        this.sentakuTaisho = sentakuTaisho;
        this.sentakuKekkaList = sentakuKekkaList;
        this.shichosonCode = shichosonCode;
        this.shichosonMeisho = shichosonMeisho;
        this.kyuShichosonCode = kyuShichosonCode;
        this.kyuShichosonMeisho = kyuShichosonMeisho;
        this.is1と3場合 = is1と3場合;
        this.is2場合 = is2場合;
        this.is町域 = is町域;
        this.is行政区 = is行政区;
        this.is地区1 = is地区1;
        this.is地区2 = is地区2;
        this.is地区3 = is地区3;
        this.is市町村コード = is市町村コード;
        this.is市町村と旧市町村 = is市町村と旧市町村;
        this.調定年度3月31日 = 調定年度3月31日;
        this.調定年度0401 = 調定年度0401;
        this.調定年度0430 = 調定年度0430;
        this.調定年度減1 = 調定年度減1;
        this.調定年度減2 = 調定年度減2;
        this.終了生年月日 = 終了生年月日;
        this.開始生年月日 = 開始生年月日;
        this.hasCodeList = hasCodeList;
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
    }

    /**
     * コンストラクタ。
     *
     * @param choteiNendo 調定年度
     * @param choteiKijunNichiji 調定基準日時
     * @param kakutukiShikakuKijunNichi 各月資格基準日
     * @param ageFlg 年齢フラグ
     * @param ageStart 年齢開始
     * @param ageEnd 年齢終了
     * @param ageKijunNi 年齢基準日
     * @param seinengappiYMDFlg 生年月日フラグ
     * @param seinengappiYMDStart 生年月日開始
     * @param seinengappiYMDEnd 生年月日終了
     * @param sentakuTaisho 選択対象
     * @param sentakuKekkaList List<SentakuKekka>
     * @param shichosonCode 市町村コード
     * @param shichosonMeisho 市町村名称
     * @param kyuShichosonCode 旧市町村コード
     * @param kyuShichosonMeisho 旧市町村名称
     * @param is1と3場合 is1と3場合
     * @param is2場合 is2場合
     * @param is町域 is町域
     * @param is行政区 is行政区
     * @param is地区1 is地区1
     * @param is地区2 is地区2
     * @param is地区3 is地区3
     * @param is市町村コード is市町村コード
     * @param is市町村と旧市町村 is市町村と旧市町村
     * @param 調定年度3月31日 調定年度3月31日
     * @param 調定年度0430 調定年度0430
     * @param 調定年度0401 調定年度0401
     * @param 調定年度減1 調定年度減1
     * @param 調定年度減2 調定年度減2
     * @param 終了生年月日 終了生年月日
     * @param 開始生年月日 開始生年月日
     * @param hasCodeList hasCodeList
     * @param psmShikibetsuTaisho PSM
     * @return CreateTsukibetsuSuiihyoMyBatisParameter
     */
    public static CreateTsukibetsuSuiihyoMyBatisParameter create_MyBatisParameter(
            FlexibleYear choteiNendo,
            RString choteiKijunNichiji,
            RString kakutukiShikakuKijunNichi,
            boolean ageFlg,
            RString ageStart,
            RString ageEnd,
            FlexibleDate ageKijunNi,
            boolean seinengappiYMDFlg,
            RString seinengappiYMDStart,
            RString seinengappiYMDEnd,
            RString sentakuTaisho,
            List<RString> sentakuKekkaList,
            RString shichosonCode,
            RString shichosonMeisho,
            RString kyuShichosonCode,
            RString kyuShichosonMeisho,
            boolean is1と3場合,
            boolean is2場合,
            boolean is町域,
            boolean is行政区,
            boolean is地区1,
            boolean is地区2,
            boolean is地区3,
            boolean is市町村コード,
            boolean is市町村と旧市町村,
            RString 調定年度3月31日,
            RString 調定年度0401,
            RString 調定年度0430,
            RString 調定年度減1,
            RString 調定年度減2,
            FlexibleDate 終了生年月日,
            FlexibleDate 開始生年月日,
            boolean hasCodeList,
            RString psmShikibetsuTaisho) {
        return new CreateTsukibetsuSuiihyoMyBatisParameter(choteiNendo, choteiKijunNichiji, kakutukiShikakuKijunNichi, ageFlg, ageStart,
                ageEnd, ageKijunNi, seinengappiYMDFlg, seinengappiYMDStart, seinengappiYMDEnd, sentakuTaisho, sentakuKekkaList, shichosonCode,
                shichosonMeisho, kyuShichosonCode, kyuShichosonMeisho, is1と3場合, is2場合, is町域, is行政区, is地区1, is地区2, is地区3,
                is市町村コード, is市町村と旧市町村, 調定年度3月31日, 調定年度0401, 調定年度0430, 調定年度減1, 調定年度減2, 終了生年月日,
                開始生年月日, hasCodeList, psmShikibetsuTaisho);
    }

    /**
     * 月別推移表作成のパラメータクラス作成。
     *
     * @param 調定年度 調定年度
     * @param 年齢フラグ 年齢フラグ
     * @param 年齢開始 年齢開始
     * @param 年齢終了 年齢終了
     * @param 年齢基準日 年齢基準日
     * @param 生年月日フラグ 生年月日フラグ
     * @param 生年月日開始 生年月日開始
     * @param 生年月日終了 生年月日終了
     * @param 選択対象 選択対象
     * @param sentakuKekkaList List<SentakuKekka>
     * @param 市町村コード 市町村コード
     * @param 旧市町村コード 旧市町村コード
     * @param psmShikibetsuTaisho PSM
     * @return 月別推移表作成のMyBatis用パラメータクラスです。
     */
    public static CreateTsukibetsuSuiihyoMyBatisParameter create_被保険者台帳管理と宛名のデータ(
            FlexibleYear 調定年度, boolean 年齢フラグ, RString 年齢開始, RString 年齢終了, FlexibleDate 年齢基準日,
            boolean 生年月日フラグ, RString 生年月日開始, RString 生年月日終了, RString 選択対象, List<RString> sentakuKekkaList,
            RString 市町村コード, RString 旧市町村コード, RString psmShikibetsuTaisho) {
        boolean is1と3場合 = false;
        boolean is2場合 = false;
        RString 調定年度3月31日;
        RString 調定年度0401;
        FlexibleDate 終了生年月日 = FlexibleDate.EMPTY;
        FlexibleDate 開始生年月日 = FlexibleDate.EMPTY;
        if (!RString.isNullOrEmpty(年齢開始) && !RString.isNullOrEmpty(年齢終了) && (年齢基準日 != null && !年齢基準日.isEmpty())) {
            終了生年月日 = 年齢基準日.minusYear(Integer.valueOf(年齢開始.toString()));
            開始生年月日 = 年齢基準日.minusYear(Integer.valueOf(年齢終了.toString()));
            is1と3場合 = true;
        }
        if (RString.isNullOrEmpty(年齢開始) && !RString.isNullOrEmpty(年齢終了) && (年齢基準日 != null && !年齢基準日.isEmpty())) {
            開始生年月日 = 年齢基準日.minusYear(Integer.valueOf(年齢終了.toString()));
            終了生年月日 = 年齢基準日.minusYear(INT_65);
            is1と3場合 = true;
        }
        if (!RString.isNullOrEmpty(年齢開始) && RString.isNullOrEmpty(年齢終了) && (年齢基準日 != null && !年齢基準日.isEmpty())) {
            終了生年月日 = 年齢基準日.minusYear(Integer.valueOf(年齢開始.toString()));
            is2場合 = true;
        }
        boolean is町域 = 選択対象_町域.equals(選択対象);
        boolean is行政区 = 選択対象_行政区.equals(選択対象);
        boolean is地区1 = 選択対象_地区1.equals(選択対象);
        boolean is地区2 = 選択対象_地区2.equals(選択対象);
        boolean is地区3 = 選択対象_地区3.equals(選択対象);
        boolean is市町村コード = has市町村コード(市町村コード, 旧市町村コード);
        boolean is市町村と旧市町村 = has市町村と旧市町村(市町村コード, 旧市町村コード);
        StringBuilder builder1 = new StringBuilder();
        builder1.append(調定年度.plusYear(1).toString());
        builder1.append("0331");
        調定年度3月31日 = new RString(builder1.toString());
        StringBuilder builder2 = new StringBuilder();
        builder2.append(調定年度.toString());
        builder2.append("0401");
        調定年度0401 = new RString(builder2.toString());
        boolean hasCodeList = hasList(sentakuKekkaList);
        return new CreateTsukibetsuSuiihyoMyBatisParameter(
                null, null, null, 年齢フラグ, null, null, null, 生年月日フラグ, 生年月日開始, 生年月日終了, null, sentakuKekkaList,
                市町村コード, null, 旧市町村コード, null, is1と3場合, is2場合, is町域, is行政区, is地区1, is地区2, is地区3,
                is市町村コード, is市町村と旧市町村, 調定年度3月31日, 調定年度0401,
                null, null, null, 終了生年月日, 開始生年月日, hasCodeList, psmShikibetsuTaisho);
    }

    private static boolean hasList(List<RString> sentakuKekkaList) {
        return sentakuKekkaList != null && !sentakuKekkaList.isEmpty();
    }

    private static boolean has市町村コード(RString 市町村コード, RString 旧市町村コード) {
        return !RString.isNullOrEmpty(市町村コード) && RString.isNullOrEmpty(旧市町村コード);
    }

    private static boolean has市町村と旧市町村(RString 市町村コード, RString 旧市町村コード) {
        return !RString.isNullOrEmpty(市町村コード) && !RString.isNullOrEmpty(旧市町村コード);
    }

    /**
     * 月別推移表作成のパラメータクラス作成。
     *
     * @param 調定年度 調定年度
     * @param 調定基準日時 調定基準日時
     * @return 月別推移表作成のMyBatis用パラメータクラスです。
     */
    public static CreateTsukibetsuSuiihyoMyBatisParameter create_現年度データの取得(
            FlexibleYear 調定年度,
            RString 調定基準日時) {
        return new CreateTsukibetsuSuiihyoMyBatisParameter(
                調定年度,
                調定基準日時,
                null, false, null, null, null, false, null, null, null, null, null, null, null, null,
                false, false, false, false, false, false, false, false, false, null,
                null, null, null, null, null, null, false, null);
    }

    /**
     * 月別推移表作成のパラメータクラス作成。
     *
     * @param 調定年度 調定年度
     * @param 調定基準日時 調定基準日時
     * @return 月別推移表作成のMyBatis用パラメータクラスです。
     */
    public static CreateTsukibetsuSuiihyoMyBatisParameter create_過年度のデータの取得(
            FlexibleYear 調定年度,
            RString 調定基準日時) {
        RString 調定年度減1;
        RString 調定年度減2;
        調定年度減1 = 調定年度.minusYear(1).toDateString();
        調定年度減2 = 調定年度.minusYear(2).toDateString();
        return new CreateTsukibetsuSuiihyoMyBatisParameter(
                調定年度, 調定基準日時,
                null, false, null, null, null, false, null, null, null, null, null, null, null, null,
                false, false, false, false, false, false, false, false, false, null, null, null,
                調定年度減1, 調定年度減2, null, null, false, null);
    }

    /**
     * 月別推移表作成のパラメータクラス作成。
     *
     * @param 調定年度 調定年度
     * @param 調定基準日時 調定基準日時
     * @return 月別推移表作成のMyBatis用パラメータクラスです。
     */
    public static CreateTsukibetsuSuiihyoMyBatisParameter create_不明のデータの取得(
            FlexibleYear 調定年度,
            RString 調定基準日時) {
        RString 調定年度0401;
        RString 調定年度0430;
        StringBuilder builder2 = new StringBuilder();
        builder2.append(調定年度.toString());
        builder2.append("0401");
        調定年度0401 = new RString(builder2.toString());
        StringBuilder builder3 = new StringBuilder();
        builder3.append(調定年度.toString());
        builder3.append("0430");
        調定年度0430 = new RString(builder3.toString());
        return new CreateTsukibetsuSuiihyoMyBatisParameter(
                調定年度, 調定基準日時,
                null, false, null, null, null, false, null, null, null, null, null, null, null, null,
                false, false, false, false, false, false, false, false, false, null,
                調定年度0401, 調定年度0430, null, null, null, null, false, null);
    }

    /**
     * 月別推移表作成のパラメータクラス作成。
     *
     * @param 調定年度 調定年度
     * @return 月別推移表作成のMyBatis用パラメータクラスです。
     */
    public static CreateTsukibetsuSuiihyoMyBatisParameter create_4月人数と金額の取得(
            FlexibleYear 調定年度) {
        return new CreateTsukibetsuSuiihyoMyBatisParameter(
                調定年度, null,
                null, false, null, null, null, false, null, null, null, null, null, null, null, null,
                false, false, false, false, false, false, false, false, false, null,
                null, null, null, null, null, null, false, null);
    }

    /**
     * 月別推移表作成のパラメータクラス作成。
     *
     * @param 調定年度 調定年度
     * @return 月別推移表作成のMyBatis用パラメータクラスです。
     */
    public static CreateTsukibetsuSuiihyoMyBatisParameter create_過年度人数と金額の取得(
            FlexibleYear 調定年度) {
        RString 調定年度減1;
        RString 調定年度減2;
        調定年度減1 = 調定年度.minusYear(1).toDateString();
        調定年度減2 = 調定年度.minusYear(2).toDateString();
        return new CreateTsukibetsuSuiihyoMyBatisParameter(
                調定年度, null,
                null, false, null, null, null, false, null, null, null, null, null, null, null, null,
                false, false, false, false, false, false, false, false, false, null,
                null, null, 調定年度減1, 調定年度減2, null, null, false, null);
    }
}
