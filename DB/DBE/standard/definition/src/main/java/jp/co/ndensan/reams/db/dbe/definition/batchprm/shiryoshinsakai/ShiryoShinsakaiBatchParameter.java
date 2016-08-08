/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.batchprm.shiryoshinsakai;

import jp.co.ndensan.reams.db.dbe.definition.processprm.shiryoshinsakai.IinItiziHanteiProcessParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.shiryoshinsakai.IinShinsakaiIinJohoProcessParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.shiryoshinsakai.IinTokkiJikouItiziHanteiProcessParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.shiryoshinsakai.IinTuikaSiryoProcessParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.shiryoshinsakai.IinTuutishoProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 介護認定審査会資料作成_バッチ用のパラメータです。
 *
 * @reamsid_L DBE-0150-010 linghuhang
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShiryoShinsakaiBatchParameter extends BatchParameterBase {

    private static final String SHINSAKAIKAISAINO = "shinsakaiKaisaiNo";
    private static final String SHINSAKAIKAISAIYOTEIYMD = "shinsakaiKaisaiYoteiYMD";
    private static final String SHINSAKAIKAISHIYOTEITIME = "shinsakaiKaishiYoteiTime";
    private static final String GOGITAINO = "gogitaiNo";
    private static final String GOGITAINAME = "gogitaiName";
    private static final String SHUTURYOKUJUN = "shuturyokuJun";
    private static final String SHUTURYOKUSUTAIRU = "shuturyokuSutairu";
    private static final String PRINTHOU = "printHou";
    private static final String SAKUSEIJOKEN = "sakuseiJoken";
    private static final String BANGOSTART = "bangoStart";
    private static final String BANGOEND = "bangoEnd";
    private static final String CHOYOJIMU_TAISHOUSHAFALG = "choyoJimu_taishoushaFalg";
    private static final String CHOYOJIMU_TOKKIJIKOUFALG = "choyoJimu_tokkiJikouFalg";
    private static final String CHOYOJIMU_ITIZIHANTEIFALG = "choyoJimu_itiziHanteiFalg";
    private static final String CHOYOJIMU_TOKKIJIKOUHANTEIFALG = "choyoJimu_tokkiJikouHanteiFalg";
    private static final String CHOYOJIMU_IKENSHOFALG = "choyoJimu_ikenshoFalg";
    private static final String CHOYOJIMU_GAIKYOUTOKKIFALG = "choyoJimu_gaikyouTokkiFalg";
    private static final String CHOYOJIMU_HANTEIFALG = "choyoJimu_hanteiFalg";
    private static final String CHOYOJIMU_GAIKYOUTOKKIIRANFALG = "choyoJimu_gaikyouTokkiIranFalg";
    private static final String CHOYOJIMU_SONOTASIRYOFALG = "choyoJimu_sonotaSiryoFalg";
    private static final String CHOHYOIIN_TUUTISHOFALG = "chohyoIin_tuutishoFalg";
    private static final String CHOHYOIIN_TOKKIJIKOUFALG = "chohyoIin_tokkiJikouFalg";
    private static final String CHOHYOIIN_ITIZIHANTEIFALG = "chohyoIin_itiziHanteiFalg";
    private static final String CHOHYOIIN_TOKKIJIKOUHANTEIFALG = "chohyoIin_tokkiJikouHanteiFalg";
    private static final String CHOHYOIIN_IKENSHOFALG = "chohyoIin_ikenshoFalg";
    private static final String CHOHYOIIN_HANTEIFALG = "chohyoIin_hanteiFalg";
    private static final String CHOHYOIIN_TAISHOUSHAFALG = "chohyoIin_taishoushaFalg";
    private static final String CHOYOIIN_SONOTASIRYOFALG = "choyoIin_sonotaSiryoFalg";

    @BatchParameter(key = SHINSAKAIKAISAINO, name = "介護認定審査会開催番号")
    private RString shinsakaiKaisaiNo;
    @BatchParameter(key = SHINSAKAIKAISAIYOTEIYMD, name = "介護認定審査会開催予定年月日")
    private FlexibleDate shinsakaiKaisaiYoteiYMD;
    @BatchParameter(key = SHINSAKAIKAISHIYOTEITIME, name = "介護認定審査会開始予定時刻")
    private RString shinsakaiKaishiYoteiTime;
    @BatchParameter(key = GOGITAINO, name = "合議体番号")
    private RString gogitaiNo;
    @BatchParameter(key = GOGITAINAME, name = "合議体名称")
    private RString gogitaiName;
    @BatchParameter(key = SHUTURYOKUJUN, name = "出力順")
    private RString shuturyokuJun;
    @BatchParameter(key = SHUTURYOKUSUTAIRU, name = "出力スタイル")
    private RString shuturyokuSutairu;
    @BatchParameter(key = PRINTHOU, name = "印刷方法")
    private RString printHou;
    @BatchParameter(key = SAKUSEIJOKEN, name = "作成条件")
    private RString sakuseiJoken;
    @BatchParameter(key = BANGOSTART, name = "開始資料番号")
    private int bangoStart;
    @BatchParameter(key = BANGOEND, name = "終了資料番号")
    private int bangoEnd;
    @BatchParameter(key = CHOYOJIMU_TAISHOUSHAFALG, name = "事務局審査会対象者一覧フラグ")
    private RString choyoJimu_taishoushaFalg;
    @BatchParameter(key = CHOYOJIMU_TOKKIJIKOUFALG, name = "事務局特記事項フラグ")
    private RString choyoJimu_tokkiJikouFalg;
    @BatchParameter(key = CHOYOJIMU_ITIZIHANTEIFALG, name = "事務局一次判定結果票フラグ")
    private RString choyoJimu_itiziHanteiFalg;
    @BatchParameter(key = CHOYOJIMU_TOKKIJIKOUHANTEIFALG, name = "事務局特記事項_一次判定フラグ")
    private RString choyoJimu_tokkiJikouHanteiFalg;
    @BatchParameter(key = CHOYOJIMU_IKENSHOFALG, name = "事務局主治医意見書フラグ")
    private RString choyoJimu_ikenshoFalg;
    @BatchParameter(key = CHOYOJIMU_SONOTASIRYOFALG, name = "事務局その他資料フラグ")
    private RString choyoJimu_sonotaSiryoFalg;
    @BatchParameter(key = CHOYOJIMU_GAIKYOUTOKKIFALG, name = "事務局概況特記フラグ")
    private RString choyoJimu_gaikyouTokkiFalg;
    @BatchParameter(key = CHOYOJIMU_HANTEIFALG, name = "事務局予備判定記入表フラグ")
    private RString choyoJimu_hanteiFalg;
    @BatchParameter(key = CHOYOJIMU_GAIKYOUTOKKIIRANFALG, name = "事務局概況特記一覧フラグ")
    private RString choyoJimu_gaikyouTokkiIranFalg;
    @BatchParameter(key = CHOHYOIIN_TAISHOUSHAFALG, name = "委員用審査会対象者一覧フラグ")
    private RString chohyoIin_taishoushaFalg;
    @BatchParameter(key = CHOHYOIIN_TOKKIJIKOUFALG, name = "委員用特記事項フラグ")
    private RString chohyoIin_tokkiJikouFalg;
    @BatchParameter(key = CHOHYOIIN_ITIZIHANTEIFALG, name = "委員用一次判定結果票フラグ")
    private RString chohyoIin_itiziHanteiFalg;
    @BatchParameter(key = CHOHYOIIN_TOKKIJIKOUHANTEIFALG, name = "委員用特記事項_一次判定フラグ")
    private RString chohyoIin_tokkiJikouHanteiFalg;
    @BatchParameter(key = CHOHYOIIN_IKENSHOFALG, name = "委員用主治医意見書フラグ")
    private RString chohyoIin_ikenshoFalg;
    @BatchParameter(key = CHOYOIIN_SONOTASIRYOFALG, name = "委員用その他資料フラグ")
    private RString chohyoIin_sonotaSiryoFalg;
    @BatchParameter(key = CHOHYOIIN_TUUTISHOFALG, name = "委員用審査会開催通知書フラグ")
    private RString chohyoIin_tuutishoFalg;
    @BatchParameter(key = CHOHYOIIN_HANTEIFALG, name = "委員用予備判定記入表フラグ")
    private RString chohyoIin_hanteiFalg;

    /**
     * コンストラクタです。
     */
    public ShiryoShinsakaiBatchParameter() {
    }

    /**
     * コンストラクタです。
     *
     * @param shinsakaiKaisaiNo 介護認定審査会開催番号
     * @param shinsakaiKaisaiYoteiYMD 介護認定審査会開催予定年月日
     * @param shinsakaiKaishiYoteiTime 介護認定審査会開始予定時刻
     * @param gogitaiNo 合議体番号
     * @param gogitaiName 合議体名称
     * @param shuturyokuJun 出力順
     * @param shuturyokuSutairu 出力スタイル
     * @param printHou 印刷方法
     * @param sakuseiJoken 作成条件
     * @param bangoStart 開始資料番号
     * @param bangoEnd 終了資料番号
     * @param choyoJimu_taishoushaFalg 事務局審査会対象者一覧フラグ
     * @param choyoJimu_tokkiJikouFalg 事務_特記事項フラグ
     * @param choyoJimu_itiziHanteiFalg 事務_一次判定結果票フラグ
     * @param choyoJimu_tokkiJikouHanteiFalg 事務_特記事項_一次判定フラグ
     * @param choyoJimu_ikenshoFalg 事務_主治医意見書フラグ
     * @param choyoJimu_sonotaSiryoFalg 事務局その他資料フラグ
     * @param choyoJimu_gaikyouTokkiFalg 事務_概況特記フラグ
     * @param choyoJimu_hanteiFalg 事務_予備判定記入表フラグ
     * @param choyoJimu_gaikyouTokkiIranFalg 事務_概況特記一覧フラグ
     * @param chohyoIin_taishoushaFalg 委員用審査会対象者一覧フラグ
     * @param chohyoIin_tuutishoFalg 委員_審査会開催通知書フラグ
     * @param chohyoIin_tokkiJikouFalg 委員_特記事項フラグ
     * @param chohyoIin_itiziHanteiFalg 委員_一次判定結果票フラグ
     * @param chohyoIin_tokkiJikouHanteiFalg 委員_特記事項_一次判定フラグ
     * @param chohyoIin_sonotaSiryoFalg 委員用その他資料フラグ
     * @param chohyoIin_ikenshoFalg 委員_主治医意見書フラグ
     * @param chohyoIin_hanteiFalg 委員_予備判定記入表フラグ
     */
    public ShiryoShinsakaiBatchParameter(
            RString shinsakaiKaisaiNo,
            FlexibleDate shinsakaiKaisaiYoteiYMD,
            RString shinsakaiKaishiYoteiTime,
            RString gogitaiNo,
            RString gogitaiName,
            RString shuturyokuJun,
            RString shuturyokuSutairu,
            RString printHou,
            RString sakuseiJoken,
            int bangoStart,
            int bangoEnd,
            RString choyoJimu_taishoushaFalg,
            RString choyoJimu_tokkiJikouFalg,
            RString choyoJimu_itiziHanteiFalg,
            RString choyoJimu_tokkiJikouHanteiFalg,
            RString choyoJimu_ikenshoFalg,
            RString choyoJimu_sonotaSiryoFalg,
            RString choyoJimu_gaikyouTokkiFalg,
            RString choyoJimu_hanteiFalg,
            RString choyoJimu_gaikyouTokkiIranFalg,
            RString chohyoIin_taishoushaFalg,
            RString chohyoIin_tokkiJikouFalg,
            RString chohyoIin_itiziHanteiFalg,
            RString chohyoIin_tokkiJikouHanteiFalg,
            RString chohyoIin_ikenshoFalg,
            RString chohyoIin_sonotaSiryoFalg,
            RString chohyoIin_tuutishoFalg,
            RString chohyoIin_hanteiFalg) {
        this.shinsakaiKaisaiNo = shinsakaiKaisaiNo;
        this.shinsakaiKaisaiYoteiYMD = shinsakaiKaisaiYoteiYMD;
        this.shinsakaiKaishiYoteiTime = shinsakaiKaishiYoteiTime;
        this.gogitaiNo = gogitaiNo;
        this.gogitaiName = gogitaiName;
        this.shuturyokuJun = shuturyokuJun;
        this.shuturyokuSutairu = shuturyokuSutairu;
        this.printHou = printHou;
        this.sakuseiJoken = sakuseiJoken;
        this.bangoStart = bangoStart;
        this.bangoEnd = bangoEnd;
        this.choyoJimu_taishoushaFalg = choyoJimu_taishoushaFalg;
        this.choyoJimu_tokkiJikouFalg = choyoJimu_tokkiJikouFalg;
        this.choyoJimu_itiziHanteiFalg = choyoJimu_itiziHanteiFalg;
        this.choyoJimu_tokkiJikouHanteiFalg = choyoJimu_tokkiJikouHanteiFalg;
        this.choyoJimu_ikenshoFalg = choyoJimu_ikenshoFalg;
        this.choyoJimu_sonotaSiryoFalg = choyoJimu_sonotaSiryoFalg;
        this.choyoJimu_gaikyouTokkiFalg = choyoJimu_gaikyouTokkiFalg;
        this.choyoJimu_hanteiFalg = choyoJimu_hanteiFalg;
        this.choyoJimu_gaikyouTokkiIranFalg = choyoJimu_gaikyouTokkiIranFalg;
        this.chohyoIin_taishoushaFalg = chohyoIin_taishoushaFalg;
        this.chohyoIin_tokkiJikouFalg = chohyoIin_tokkiJikouFalg;
        this.chohyoIin_itiziHanteiFalg = chohyoIin_itiziHanteiFalg;
        this.chohyoIin_tokkiJikouHanteiFalg = chohyoIin_tokkiJikouHanteiFalg;
        this.chohyoIin_ikenshoFalg = chohyoIin_ikenshoFalg;
        this.chohyoIin_sonotaSiryoFalg = chohyoIin_sonotaSiryoFalg;
        this.chohyoIin_tuutishoFalg = chohyoIin_tuutishoFalg;
        this.chohyoIin_hanteiFalg = chohyoIin_hanteiFalg;
    }

    /**
     * 審査会開催のお知らせ一覧情報ProcessParameterに転換します。
     *
     * @return IinTuutishoProcessParameter
     */
    public IinTuutishoProcessParameter toIinTuutishoProcessParameter() {
        return new IinTuutishoProcessParameter(
                shinsakaiKaisaiNo,
                shuturyokuSutairu,
                printHou,
                Decimal.ZERO,
                shinsakaiKaisaiYoteiYMD,
                shinsakaiKaishiYoteiTime,
                RString.EMPTY,
                gogitaiNo);
    }

    /**
     * 委員用特記事項と一次判定結果票情報ProcessParameterに転換します。
     *
     * @return IinTokkiJikouItiziHanteiProcessParameter
     */
    public IinTokkiJikouItiziHanteiProcessParameter toIinTokkiJikouItiziHanteiProcessParameter() {
        return new IinTokkiJikouItiziHanteiProcessParameter(shinsakaiKaisaiNo,
                shuturyokuJun,
                sakuseiJoken,
                bangoStart,
                bangoEnd,
                shuturyokuSutairu,
                printHou,
                Decimal.ZERO,
                shinsakaiKaisaiYoteiYMD,
                shinsakaiKaishiYoteiTime,
                gogitaiName, gogitaiNo);
    }

    /**
     * 委員用介護認定審査対象者一覧表情報ProcessParameterに転換します。
     *
     * @return IinTokkiJikouItiziHanteiProcessParameter
     */
    public IinShinsakaiIinJohoProcessParameter toIinShinsakaiIinJohoProcessParameter() {
        return new IinShinsakaiIinJohoProcessParameter(Integer.parseInt(gogitaiNo.toString()),
                shinsakaiKaisaiYoteiYMD,
                shinsakaiKaisaiNo,
                shuturyokuJun,
                shuturyokuSutairu,
                printHou,
                shinsakaiKaishiYoteiTime);
    }

    /**
     * 介護認定追加資料鑑情報ProcessParameterに転換します。
     *
     * @return IinTuikaSiryoProcessParameter
     */
    public IinTuikaSiryoProcessParameter toIinTuikaSiryoProcessParameter() {
        return new IinTuikaSiryoProcessParameter(shinsakaiKaisaiNo,
                shuturyokuSutairu,
                printHou,
                Decimal.ZERO);
    }

    /**
     * 介護認定更新ProcessParameterに転換します。
     *
     * @return IinItiziHanteiProcessParameter
     */
    public IinItiziHanteiProcessParameter toIinItiziHanteiProcessParameter() {
        return new IinItiziHanteiProcessParameter(shinsakaiKaisaiNo, shuturyokuJun, sakuseiJoken, gogitaiNo, printHou);
    }
}
