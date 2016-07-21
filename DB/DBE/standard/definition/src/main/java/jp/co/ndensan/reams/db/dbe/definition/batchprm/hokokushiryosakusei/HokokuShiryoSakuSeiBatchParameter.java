package jp.co.ndensan.reams.db.dbe.definition.batchprm.hokokushiryosakusei;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hokokushiryosakusei.CsvKenHokokuShiryoSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hokokushiryosakusei.JigyoJyokyoHokokuProcessParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hokokushiryosakusei.JisshiJokyoTokeiProcessParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hokokushiryosakusei.ShinsahanteinoHenkojokyoProcessParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hokokushiryosakusei.ShinsakaiShukeiGenzainojokyoProcessParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hokokushiryosakusei.ShinsakaiShukeihyoShinseiBetsuProcessParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hokokushiryosakusei.ShinsakaishukeihyoHanteiBetsuProcessParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hokokushiryosakusei.SinsakaiHanteiJyokyoProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
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

    private static final String JIGYOJYOKYOHOKOKU = "jigyoJyokyoHokoku";
    private static final String JISSIJYOKYOTOKEI = "jissiJyokyoTokei";
    private static final String SINSAHANTEIJYOKYO = "sinsaHanteiJyokyo";
    private static final String SINSAKAIKANRENTOKEI = "sinsakaiKanrenTokei";
    private static final String CSVSHUTSURYOKU = "csvShutsuryoku";
    private static final String SHUTSURYOKUFAIRU = "shutsuryokuFairu";
    private static final String HOKENSYANO = "hokensyaNo";
    private static final String SHICHOSONCODE = "shichosonCode";
    private static final String SHICHOSONNAME = "shichosonName";
    private static final String HIHOKENSYAKUBUN = "hiHokensyaKubun";
    private static final String GOGITAINO = "gogitaiNo";
    private static final String GOGITAINAME = "gogitaiName";
    private static final String GOGITAINOLIST = "gogitaiNoList";
    private static final String TAISHOTSUKIKUBUN = "taishoTsukiKubun";
    private static final String TAISHOTSUKI = "taishoTsuki";
    private static final String KIJYUNYMD = "kijyunYMD";
    private static final String TAISHOGEPPIKUBUN = "taishoGeppiKubun";
    private static final String TAISHOGEPPIFROM = "taishoGeppiFrom";
    private static final String TAISHOGEPPITO = "taishoGeppiTo";
    private static final String SINSEIKUBUNSINSEITOKI = "sinseiKubunSinseitoki";
    private static final String SINSEIKUBUNHOREI = "sinseiKubunHorei";

    @BatchParameter(key = JIGYOJYOKYOHOKOKU, name = "事業状況報告出力区分")
    private boolean jigyoJyokyoHokoku;
    @BatchParameter(key = JISSIJYOKYOTOKEI, name = "実施状況統計出力区分")
    private boolean jissiJyokyoTokei;
    @BatchParameter(key = SINSAHANTEIJYOKYO, name = "審査判定状況出力区分")
    private boolean sinsaHanteiJyokyo;
    @BatchParameter(key = SINSAKAIKANRENTOKEI, name = "審査会関連統計資料作成出力区分")
    private boolean sinsakaiKanrenTokei;
    @BatchParameter(key = CSVSHUTSURYOKU, name = "CSV出力区分")
    private boolean csvShutsuryoku;
    @BatchParameter(key = SHUTSURYOKUFAIRU, name = "出力ファイル名")
    private RString shutsuryokuFairu;
    @BatchParameter(key = HOKENSYANO, name = "保険者番号")
    private RString hokensyaNo;
    @BatchParameter(key = SHICHOSONCODE, name = "市町村コード")
    private LasdecCode shichosonCode;
    @BatchParameter(key = SHICHOSONNAME, name = "市町村名称")
    private RString shichosonName;
    @BatchParameter(key = HIHOKENSYAKUBUN, name = "被保険者区分")
    private RString hiHokensyaKubun;
    @BatchParameter(key = GOGITAINO, name = "合議体番号")
    private int gogitaiNo;
    @BatchParameter(key = GOGITAINAME, name = "合議体名称")
    private RString gogitaiName;
    @BatchParameter(key = GOGITAINOLIST, name = "合議体番号List")
    private List<Integer> gogitaiNoList;
    @BatchParameter(key = TAISHOTSUKIKUBUN, name = "対象月編集区分")
    private boolean isTaishoTsukiKubun;
    @BatchParameter(key = TAISHOTSUKI, name = "対象年月")
    private RString taishoNendoYM;
    @BatchParameter(key = KIJYUNYMD, name = "基準年月日")
    private RDate kijyunYMD;
    @BatchParameter(key = TAISHOGEPPIKUBUN, name = "対象月日編集区分")
    private boolean isTaishoGeppiKubun;
    @BatchParameter(key = TAISHOGEPPIFROM, name = "対象月日開始")
    private RString taishoGeppiFrom;
    @BatchParameter(key = TAISHOGEPPITO, name = "対象月日終了")
    private RString taishoGeppiTo;
    @BatchParameter(key = SINSEIKUBUNSINSEITOKI, name = "申請区分(申請時)")
    private boolean isSinseiKubunSinseitoki;
    @BatchParameter(key = SINSEIKUBUNHOREI, name = "申請区分(法令)")
    private boolean isSinseiKubunHorei;

    /**
     * コンストラクタです。
     */
    public HokokuShiryoSakuSeiBatchParameter() {
    }

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
     * @param shichosonCode 市町村コード
     * @param shichosonName 市町村名称
     * @param hiHokensyaKubun 被保険者区分
     * @param gogitaiNo 合議体番号
     * @param gogitaiName 合議体名称
     * @param gogitaiNoList 合議体番号List
     * @param isTaishoTsukiKubun 対象月編集区分
     * @param taishoNendoYM 対象年月
     * @param kijyunYMD 基準年月日
     * @param isTaishoGeppiKubun 対象月日編集区分
     * @param taishoGeppiFrom 対象月日開始
     * @param taishoGeppiTo 対象月日終了
     * @param isSinseiKubunSinseitoki 申請区分(申請時)
     * @param isSinseiKubunHorei 申請区分(法令)
     */
    public HokokuShiryoSakuSeiBatchParameter(
            boolean jigyoJyokyoHokoku,
            boolean jissiJyokyoTokei,
            boolean sinsaHanteiJyokyo,
            boolean sinsakaiKanrenTokei,
            boolean csvShutsuryoku,
            RString shutsuryokuFairu,
            RString hokensyaNo,
            LasdecCode shichosonCode,
            RString shichosonName,
            RString hiHokensyaKubun,
            int gogitaiNo,
            RString gogitaiName,
            List<Integer> gogitaiNoList,
            boolean isTaishoTsukiKubun,
            RString taishoNendoYM,
            RDate kijyunYMD,
            boolean isTaishoGeppiKubun,
            RString taishoGeppiFrom,
            RString taishoGeppiTo,
            boolean isSinseiKubunSinseitoki,
            boolean isSinseiKubunHorei) {
        this.jigyoJyokyoHokoku = jigyoJyokyoHokoku;
        this.jissiJyokyoTokei = jissiJyokyoTokei;
        this.sinsaHanteiJyokyo = sinsaHanteiJyokyo;
        this.sinsakaiKanrenTokei = sinsakaiKanrenTokei;
        this.csvShutsuryoku = csvShutsuryoku;
        this.shutsuryokuFairu = shutsuryokuFairu;
        this.hokensyaNo = hokensyaNo;
        this.shichosonCode = shichosonCode;
        this.shichosonName = shichosonName;
        this.hiHokensyaKubun = hiHokensyaKubun;
        this.gogitaiNo = gogitaiNo;
        this.gogitaiName = gogitaiName;
        this.gogitaiNoList = gogitaiNoList;
        this.isTaishoTsukiKubun = isTaishoTsukiKubun;
        this.taishoNendoYM = taishoNendoYM;
        this.kijyunYMD = kijyunYMD;
        this.isTaishoGeppiKubun = isTaishoGeppiKubun;
        this.taishoGeppiFrom = taishoGeppiFrom;
        this.taishoGeppiTo = taishoGeppiTo;
        this.isSinseiKubunSinseitoki = isSinseiKubunSinseitoki;
        this.isSinseiKubunHorei = isSinseiKubunHorei;
    }

    /**
     * SinsakaiHanteiJyokyoProcessParameterに転換します。
     *
     * @return SinsakaiHanteiJyokyoProcessParameter
     */
    public SinsakaiHanteiJyokyoProcessParameter toSinsakaiHanteiJyokyoProcessParameter() {

        return new SinsakaiHanteiJyokyoProcessParameter(
                jigyoJyokyoHokoku,
                jissiJyokyoTokei,
                sinsaHanteiJyokyo,
                sinsakaiKanrenTokei,
                csvShutsuryoku,
                shutsuryokuFairu,
                kijyunYMD,
                RString.isNullOrEmpty(hokensyaNo),
                hokensyaNo,
                shichosonCode,
                shichosonName,
                hiHokensyaKubun,
                -1 == gogitaiNo,
                gogitaiNo,
                gogitaiName,
                gogitaiNoList,
                isTaishoTsukiKubun,
                isTaishoGeppiKubun,
                taishoNendoYM,
                RString.isNullOrEmpty(taishoGeppiFrom),
                RString.isNullOrEmpty(taishoGeppiTo),
                taishoGeppiFrom,
                taishoGeppiTo,
                isSinseiKubunSinseitoki,
                isSinseiKubunHorei);
    }

    /**
     * ShinsakaishukeihyoHanteiBetsuProcessParameterに転換します。
     *
     * @return ShinsakaishukeihyoHanteiBetsuProcessParameter
     */
    public ShinsakaishukeihyoHanteiBetsuProcessParameter toShinsakaishukeihyoHanteiBetsuProcessParameter() {

        return new ShinsakaishukeihyoHanteiBetsuProcessParameter(
                jigyoJyokyoHokoku,
                jissiJyokyoTokei,
                sinsaHanteiJyokyo,
                sinsakaiKanrenTokei,
                csvShutsuryoku,
                shutsuryokuFairu,
                kijyunYMD,
                RString.isNullOrEmpty(hokensyaNo),
                hokensyaNo,
                shichosonCode,
                shichosonName,
                hiHokensyaKubun,
                -1 == gogitaiNo,
                gogitaiNo,
                gogitaiNoList,
                isTaishoTsukiKubun,
                isTaishoGeppiKubun,
                taishoNendoYM,
                RString.isNullOrEmpty(taishoGeppiFrom),
                RString.isNullOrEmpty(taishoGeppiTo),
                taishoGeppiFrom,
                taishoGeppiTo,
                isSinseiKubunSinseitoki,
                isSinseiKubunHorei);
    }

    /**
     * JigyoJyokyoHokokuProcessParameterに転換します。
     *
     * @return JigyoJyokyoHokokuProcessParameter
     */
    public JigyoJyokyoHokokuProcessParameter toJigyoJyokyoHokokuProcessParameter() {

        return new JigyoJyokyoHokokuProcessParameter(
                jigyoJyokyoHokoku,
                jissiJyokyoTokei,
                sinsaHanteiJyokyo,
                sinsakaiKanrenTokei,
                csvShutsuryoku,
                shutsuryokuFairu,
                kijyunYMD,
                RString.isNullOrEmpty(hokensyaNo),
                hokensyaNo,
                isTaishoTsukiKubun,
                isTaishoGeppiKubun,
                taishoNendoYM,
                RString.isNullOrEmpty(taishoGeppiFrom),
                RString.isNullOrEmpty(taishoGeppiTo),
                taishoGeppiFrom,
                taishoGeppiTo,
                isSinseiKubunSinseitoki,
                isSinseiKubunHorei);
    }

    /**
     * JisshiJokyoTokeiProcessParameterに転換します。
     *
     * @return JisshiJokyoTokeiProcessParameter
     */
    public JisshiJokyoTokeiProcessParameter toJisshiJokyoTokeiProcessParameter() {

        return new JisshiJokyoTokeiProcessParameter(
                jigyoJyokyoHokoku,
                jissiJyokyoTokei,
                sinsaHanteiJyokyo,
                sinsakaiKanrenTokei,
                csvShutsuryoku,
                shutsuryokuFairu,
                kijyunYMD,
                RString.isNullOrEmpty(hokensyaNo),
                hokensyaNo,
                hiHokensyaKubun,
                -1 == gogitaiNo,
                gogitaiNo,
                gogitaiNoList,
                isTaishoTsukiKubun,
                isTaishoGeppiKubun,
                taishoNendoYM,
                RString.isNullOrEmpty(taishoGeppiFrom),
                RString.isNullOrEmpty(taishoGeppiTo),
                taishoGeppiFrom,
                taishoGeppiTo,
                isSinseiKubunSinseitoki,
                isSinseiKubunHorei);
    }

    /**
     * ShinsahanteinoHenkojokyoProcessParameterに転換します。
     *
     * @return ShinsahanteinoHenkojokyoProcessParameter
     */
    public ShinsahanteinoHenkojokyoProcessParameter toShinsahanteinoHenkojokyoProcessParameter() {

        return new ShinsahanteinoHenkojokyoProcessParameter(
                jigyoJyokyoHokoku,
                jissiJyokyoTokei,
                sinsaHanteiJyokyo,
                sinsakaiKanrenTokei,
                csvShutsuryoku,
                shutsuryokuFairu,
                kijyunYMD,
                RString.isNullOrEmpty(hokensyaNo),
                hokensyaNo,
                shichosonCode,
                shichosonName,
                hiHokensyaKubun,
                -1 == gogitaiNo,
                gogitaiNo,
                gogitaiName,
                gogitaiNoList,
                isTaishoTsukiKubun,
                isTaishoGeppiKubun,
                taishoNendoYM,
                RString.isNullOrEmpty(taishoGeppiFrom),
                RString.isNullOrEmpty(taishoGeppiTo),
                taishoGeppiFrom,
                taishoGeppiTo,
                isSinseiKubunSinseitoki,
                isSinseiKubunHorei);
    }

    /**
     * ShinsakaiShukeihyoShinseiBetsuProcessParameterに転換します。
     *
     * @return ShinsakaiShukeihyoShinseiBetsuProcessParameter
     */
    public ShinsakaiShukeihyoShinseiBetsuProcessParameter toShinsakaiShukeihyoShinseiBetsuProcessParameter() {

        return new ShinsakaiShukeihyoShinseiBetsuProcessParameter(
                jigyoJyokyoHokoku,
                jissiJyokyoTokei,
                sinsaHanteiJyokyo,
                sinsakaiKanrenTokei,
                csvShutsuryoku,
                shutsuryokuFairu,
                kijyunYMD,
                RString.isNullOrEmpty(hokensyaNo),
                hokensyaNo,
                hiHokensyaKubun,
                -1 == gogitaiNo,
                gogitaiNo,
                gogitaiNoList,
                isTaishoTsukiKubun,
                isTaishoGeppiKubun,
                taishoNendoYM,
                RString.isNullOrEmpty(taishoGeppiFrom),
                RString.isNullOrEmpty(taishoGeppiTo),
                taishoGeppiFrom,
                taishoGeppiTo,
                isSinseiKubunSinseitoki,
                isSinseiKubunHorei);
    }

    /**
     * ShinsakaiShukeiGenzainojokyoProcessParameterに転換します。
     *
     * @return ShinsakaiShukeiGenzainojokyoProcessParameter
     */
    public ShinsakaiShukeiGenzainojokyoProcessParameter toShinsakaiShukeiGenzainojokyoProcessParameter() {

        return new ShinsakaiShukeiGenzainojokyoProcessParameter(
                jigyoJyokyoHokoku,
                jissiJyokyoTokei,
                sinsaHanteiJyokyo,
                sinsakaiKanrenTokei,
                csvShutsuryoku,
                shutsuryokuFairu,
                RString.isNullOrEmpty(hokensyaNo),
                hokensyaNo,
                hiHokensyaKubun,
                -1 == gogitaiNo,
                gogitaiNo,
                gogitaiNoList,
                kijyunYMD == null || RString.isNullOrEmpty(kijyunYMD.toDateString()),
                kijyunYMD,
                isTaishoTsukiKubun,
                isTaishoGeppiKubun,
                taishoNendoYM,
                RString.isNullOrEmpty(taishoGeppiFrom),
                RString.isNullOrEmpty(taishoGeppiTo),
                taishoGeppiFrom,
                taishoGeppiTo,
                isSinseiKubunSinseitoki,
                isSinseiKubunHorei);
    }

    /**
     * CsvKenHokokuShiryoSakuseiProcessParameterに転換します。
     *
     * @return CsvKenHokokuShiryoSakuseiProcessParameter
     */
    public CsvKenHokokuShiryoSakuseiProcessParameter toCsvKenHokokuShiryoSakuseiProcessParameter() {

        return new CsvKenHokokuShiryoSakuseiProcessParameter(
                shutsuryokuFairu,
                RString.isNullOrEmpty(hokensyaNo),
                hokensyaNo,
                hiHokensyaKubun,
                -1 == gogitaiNo,
                gogitaiNo,
                gogitaiNoList,
                isTaishoTsukiKubun,
                isTaishoGeppiKubun,
                taishoNendoYM,
                RString.isNullOrEmpty(taishoGeppiFrom),
                RString.isNullOrEmpty(taishoGeppiTo),
                taishoGeppiFrom,
                taishoGeppiTo,
                isSinseiKubunSinseitoki,
                isSinseiKubunHorei);
    }
}
