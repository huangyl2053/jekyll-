package jp.co.ndensan.reams.db.dbe.definition.batchprm.hokokushiryosakusei;

import jp.co.ndensan.reams.db.dbe.definition.processprm.hokokushiryosakusei.SinsakaiHanteiJyokyoProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 報告資料作成_バッチフロークラスパラメータクラスです。
 *
 * @reamsid_L DBE-1450-020 wangxiaodong
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HokokuShiryoSakuSeiBatchParameter extends BatchParameterBase {

    private static final int 年度開始月 = 4;
    private static final int 年度終了月 = 3;
    private static final int 年度終了日 = 31;
    private static final String JIGYOJYOKYOHOKOKU = "jigyoJyokyoHokoku";
    private static final String JISSIJYOKYOTOKEI = "jissiJyokyoTokei";
    private static final String SINSAHANTEIJYOKYO = "sinsaHanteiJyokyo";
    private static final String SINSAKAIKANRENTOKEI = "sinsakaiKanrenTokei";
    private static final String CSVSHUTSURYOKU = "csvShutsuryoku";
    private static final String SHUTSURYOKUFAIRU = "shutsuryokuFairu";
    private static final String HOKENSYANO = "hokensyaNo";
    private static final String HIHOKENSYAKUBUN = "hiHokensyaKubun";
    private static final String TAISHONENDO = "taishoNendo";
    private static final String GOGITAINO = "gogitaiNo";
    private static final String TAISHOTSUKIKUBUN = "taishoTsukiKubun";
    private static final String TAISHOTSUKI = "taishoTsuki";
    private static final String KIJYUNYMD = "kijyunYMD";
    private static final String TAISHOGEPPIKUBUN = "taishoGeppiKubun";
    private static final String TAISHOGEPPIFROM = "taishoGeppiFrom";
    private static final String TAISHOGEPPITO = "taishoGeppiTo";
    private static final String SINSEIKUBUNSINSEITOKI = "sinseiKubunSinseitoki";
    private static final String SINSEIKUBUNHOREI = "sinseiKubunHorei";

    @BatchParameter(key = JIGYOJYOKYOHOKOKU, name = "事業状況報告出力区分")
    private final boolean jigyoJyokyoHokoku;
    @BatchParameter(key = JISSIJYOKYOTOKEI, name = "実施状況統計出力区分")
    private final boolean jissiJyokyoTokei;
    @BatchParameter(key = SINSAHANTEIJYOKYO, name = "審査判定状況出力区分")
    private final boolean sinsaHanteiJyokyo;
    @BatchParameter(key = SINSAKAIKANRENTOKEI, name = "審査会関連統計資料作成出力区分")
    private final boolean sinsakaiKanrenTokei;
    @BatchParameter(key = CSVSHUTSURYOKU, name = "CSV出力区分")
    private final boolean csvShutsuryoku;
    @BatchParameter(key = SHUTSURYOKUFAIRU, name = "出力ファイル名")
    private final RString shutsuryokuFairu;
    @BatchParameter(key = HOKENSYANO, name = "保険者番号")
    private final RString hokensyaNo;
    @BatchParameter(key = HIHOKENSYAKUBUN, name = "被保険者区分")
    private final RString hiHokensyaKubun;
    @BatchParameter(key = TAISHONENDO, name = "対象年度")
    private final RDate taishoNendo;
    @BatchParameter(key = GOGITAINO, name = "合議体番号")
    private final int gogitaiNo;
    @BatchParameter(key = TAISHOTSUKIKUBUN, name = "対象月編集区分")
    private final boolean taishoTsukiKubun;
    @BatchParameter(key = TAISHOTSUKI, name = "対象月")
    private final RString taishoTsuki;
    @BatchParameter(key = KIJYUNYMD, name = "基準年月日")
    private final RDate kijyunYMD;
    @BatchParameter(key = TAISHOGEPPIKUBUN, name = "対象月日編集区分")
    private final boolean taishoGeppiKubun;
    @BatchParameter(key = TAISHOGEPPIFROM, name = "対象月日開始")
    private final RString taishoGeppiFrom;
    @BatchParameter(key = TAISHOGEPPITO, name = "対象月日終了")
    private final RString taishoGeppiTo;
    @BatchParameter(key = SINSEIKUBUNSINSEITOKI, name = "申請区分(申請時)")
    private final boolean sinseiKubunSinseitoki;
    @BatchParameter(key = SINSEIKUBUNHOREI, name = "申請区分(法令)")
    private final boolean sinseiKubunHorei;

    /**
     * コンストラクタです。
     *
     * @param jigyoJyokyoHokoku 事業状況報告出力区分
     * @param jissiJyokyoTokei 実施状況統計出力区分
     * @param sinsaHanteiJyokyo 審査判定状況出力区分
     * @param sinsakaiKanrenTokei 審査会関連統計資料作成出力区分
     * @param csvShutsuryoku CSV出力区分
     * @param shutsuryokuFairu 出力ファイル名
     * @param hokensyaNo 保険者番号
     * @param hiHokensyaKubun 被保険者区分
     * @param taishoNendo 対象年度
     * @param gogitaiNo 合議体番号
     * @param taishoTsukiKubun 対象月編集区分
     * @param taishoTsuki 対象月
     * @param kijyunYMD 基準年月日
     * @param taishoGeppiKubun 対象月日編集区分
     * @param taishoGeppiFrom 対象月日開始
     * @param taishoGeppiTo 対象月日終了
     * @param sinseiKubunSinseitoki 申請区分(申請時)
     * @param sinseiKubunHorei 申請区分(法令)
     */
    public HokokuShiryoSakuSeiBatchParameter(
            boolean jigyoJyokyoHokoku,
            boolean jissiJyokyoTokei,
            boolean sinsaHanteiJyokyo,
            boolean sinsakaiKanrenTokei,
            boolean csvShutsuryoku,
            RString shutsuryokuFairu,
            RString hokensyaNo,
            RString hiHokensyaKubun,
            RDate taishoNendo,
            int gogitaiNo,
            boolean taishoTsukiKubun,
            RString taishoTsuki,
            RDate kijyunYMD,
            boolean taishoGeppiKubun,
            RString taishoGeppiFrom,
            RString taishoGeppiTo,
            boolean sinseiKubunSinseitoki,
            boolean sinseiKubunHorei) {
        this.jigyoJyokyoHokoku = jigyoJyokyoHokoku;
        this.jissiJyokyoTokei = jissiJyokyoTokei;
        this.sinsaHanteiJyokyo = sinsaHanteiJyokyo;
        this.sinsakaiKanrenTokei = sinsakaiKanrenTokei;
        this.csvShutsuryoku = csvShutsuryoku;
        this.shutsuryokuFairu = shutsuryokuFairu;
        this.hokensyaNo = hokensyaNo;
        this.hiHokensyaKubun = hiHokensyaKubun;
        this.taishoNendo = taishoNendo;
        this.gogitaiNo = gogitaiNo;
        this.taishoTsukiKubun = taishoTsukiKubun;
        this.taishoTsuki = taishoTsuki;
        this.kijyunYMD = kijyunYMD;
        this.taishoGeppiKubun = taishoGeppiKubun;
        this.taishoGeppiFrom = taishoGeppiFrom;
        this.taishoGeppiTo = taishoGeppiTo;
        this.sinseiKubunSinseitoki = sinseiKubunSinseitoki;
        this.sinseiKubunHorei = sinseiKubunHorei;
    }

    /**
     * SinsakaiHanteiJyokyoProcessParameterに転換します。
     *
     * @return SinsakaiHanteiJyokyoProcessParameter
     */
    public SinsakaiHanteiJyokyoProcessParameter toSinsakaiHanteiJyokyoProcessParameter() {

        return new SinsakaiHanteiJyokyoProcessParameter(
                RString.isNullOrEmpty(hokensyaNo),
                hokensyaNo,
                hiHokensyaKubun,
                taishoNendo == null || RString.isNullOrEmpty(taishoNendo.toDateString()),
                -1 == gogitaiNo,
                gogitaiNo,
                taishoTsukiKubun,
                taishoGeppiKubun,
                taishoNendo == null ? RString.EMPTY : new RDate(taishoNendo.getYearValue(), 年度開始月, 1).toDateString(),
                taishoNendo == null ? RString.EMPTY : new RDate(taishoNendo.getYearValue() + 1, 年度終了月, 年度終了日).toDateString(),
                taishoNendo == null ? RString.EMPTY : taishoNendo.toDateString(),
                taishoGeppiFrom == null || RString.isNullOrEmpty(taishoGeppiFrom),
                taishoGeppiTo == null || RString.isNullOrEmpty(taishoGeppiTo),
                taishoGeppiFrom,
                taishoGeppiTo,
                null);
    }

}
