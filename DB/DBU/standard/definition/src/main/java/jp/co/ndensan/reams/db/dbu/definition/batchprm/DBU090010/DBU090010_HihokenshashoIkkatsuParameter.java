/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.batchprm.DBU090010;

import jp.co.ndensan.reams.db.dbu.definition.processprm.hihokenshasho.IkkatsuHakkoProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;

/**
 * 被保険者証一括発行のバッチのパラメータです。
 *
 * @reamsid_L DBU-0420-020 duanzhanli
 *
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DBU090010_HihokenshashoIkkatsuParameter extends BatchParameterBase {

    private static final String KEY_SHUTSURYOKUJOKEN_CODE = "shutsuryokuJokenCode";
    private static final String KEY_KONKAIFROM_YMD = "konkaiFromYMD";
    private static final String KEY_KONKAIFROM_HMS = "konkaiFromHMS";
    private static final String KEY_KONKAITO_YMD = "konkaiToYMD";
    private static final String KEY_KONKAITO_HMS = "konkaiToHMS";
    private static final String KEY_KONKAIKIJUN_YMD = "konkaikijunYMD";
    private static final String KEY_KONKAIKIJUNFROM_HMS = "konkaiKijunHMS";
    private static final String KEY_KOFU_YMD = "kofuYMD";
    private static final String KEY_TESTSHUTSURYOKUFLAG = "testShutsuryokuFlag";
    private static final String KEY_SAIHAKKOFLAG = "saihakkoFlag";
    private static final String KEY_HAKKOU_YMD = "hakkouYMD";
    private static final String KEY_HAKKOU_HMS = "hakkouHMS";
    private static final String KEY_SHUTSURYOKUJUN_ID = "shutsuryokujunId";
    private static final String KEY_SHOHYOJITYPE = "shohyojiType";

    @BatchParameter(key = KEY_SHUTSURYOKUJOKEN_CODE, name = "出力条件コード")
    private RString shutsuryokuJokenCode;
    @BatchParameter(key = KEY_KONKAIFROM_YMD, name = "今回の開始日")
    private FlexibleDate konkaiFromYMD;
    @BatchParameter(key = KEY_KONKAIFROM_HMS, name = "今回の時分秒（以上）")
    private RTime konkaiFromHMS;
    @BatchParameter(key = KEY_KONKAITO_YMD, name = "今回の終了日")
    private FlexibleDate konkaiToYMD;
    @BatchParameter(key = KEY_KONKAITO_HMS, name = "今回の時分秒（未満）")
    private RTime konkaiToHMS;
    @BatchParameter(key = KEY_KONKAIKIJUN_YMD, name = "今回の基準日")
    private FlexibleDate konkaikijunYMD;
    @BatchParameter(key = KEY_KONKAIKIJUNFROM_HMS, name = "今回の時分秒")
    private RTime konkaiKijunHMS;
    @BatchParameter(key = KEY_KOFU_YMD, name = "交付日")
    private FlexibleDate kofuYMD;
    @BatchParameter(key = KEY_TESTSHUTSURYOKUFLAG, name = "テスト出力するフラグ")
    private boolean testShutsuryokuFlag;
    @BatchParameter(key = KEY_SAIHAKKOFLAG, name = "再発行するフラグ")
    private boolean saihakkoFlag;
    @BatchParameter(key = KEY_HAKKOU_YMD, name = "発行日")
    private FlexibleDate hakkouYMD;
    @BatchParameter(key = KEY_HAKKOU_HMS, name = "発行日時の時分秒")
    private RTime hakkouHMS;
    @BatchParameter(key = KEY_SHUTSURYOKUJUN_ID, name = "出力順ID")
    private Long shutsuryokujunId;
    @BatchParameter(key = KEY_SHOHYOJITYPE, name = "証表示タイプ")
    private RString shohyojiType;

    /**
     * コンストラクタです。
     */
    public DBU090010_HihokenshashoIkkatsuParameter() {

    }

    /**
     * コンストラクタです。
     *
     * @param shutsuryokuJokenCode 出力条件コード
     * @param konkaiFromYMD 今回の開始日
     * @param konkaiFromHMS 今回の時分秒_以上
     * @param konkaiToYMD 今回の終了日
     * @param konkaiToHMS 今回の時分秒_未満
     * @param konkaikijunYMD 今回の基準日
     * @param konkaiKijunHMS 今回の時分秒
     * @param kofuYMD 交付日
     * @param testShutsuryokuFlag テスト出力するフラグ
     * @param saihakkoFlag 再発行するフラグ
     * @param hakkouYMD 発行日時の発行日
     * @param hakkouHMS 発行日時の時分秒
     * @param shutsuryokujunId 出力順ID
     * @param shohyojiType 証表示タイプ
     *
     */
    public DBU090010_HihokenshashoIkkatsuParameter(RString shutsuryokuJokenCode,
            FlexibleDate konkaiFromYMD,
            RTime konkaiFromHMS,
            FlexibleDate konkaiToYMD,
            RTime konkaiToHMS,
            FlexibleDate konkaikijunYMD,
            RTime konkaiKijunHMS,
            FlexibleDate kofuYMD,
            boolean testShutsuryokuFlag,
            boolean saihakkoFlag,
            FlexibleDate hakkouYMD,
            RTime hakkouHMS,
            Long shutsuryokujunId,
            RString shohyojiType) {
        this.shutsuryokuJokenCode = shutsuryokuJokenCode;
        this.konkaiFromYMD = konkaiFromYMD;
        this.konkaiFromHMS = konkaiFromHMS;
        this.konkaiToYMD = konkaiToYMD;
        this.konkaiToHMS = konkaiToHMS;
        this.konkaiKijunHMS = konkaiKijunHMS;
        this.konkaikijunYMD = konkaikijunYMD;
        this.kofuYMD = kofuYMD;
        this.testShutsuryokuFlag = testShutsuryokuFlag;
        this.saihakkoFlag = saihakkoFlag;
        this.hakkouYMD = hakkouYMD;
        this.hakkouHMS = hakkouHMS;
        this.shutsuryokujunId = shutsuryokujunId;
        this.shohyojiType = shohyojiType;
    }

    /**
     * processのパラメータを生成します。
     *
     * @return processパラメータ
     */
    public IkkatsuHakkoProcessParameter toIkkatsuHakkoProcessParameter() {
        return new IkkatsuHakkoProcessParameter(shutsuryokuJokenCode,
                konkaiFromYMD,
                konkaiFromHMS,
                konkaiToYMD,
                konkaiToHMS,
                konkaikijunYMD,
                konkaiKijunHMS,
                kofuYMD,
                testShutsuryokuFlag,
                saihakkoFlag,
                hakkouYMD,
                hakkouHMS,
                shutsuryokujunId,
                shohyojiType);
    }
}
