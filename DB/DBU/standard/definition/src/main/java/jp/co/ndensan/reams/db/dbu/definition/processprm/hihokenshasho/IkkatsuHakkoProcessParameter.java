/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.processprm.hihokenshasho;

import java.sql.Time;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.hihokenshasho.IkkatsuHakkoMybatisParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 被保険者証一括発行のバッチ処理クラスのパラメータ
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class IkkatsuHakkoProcessParameter implements IBatchProcessParameter {

    private RString shutsuryokuJokenCode;
    private FlexibleDate konkaiFromYMD;
    private Time konkaiFromHMS;
    private FlexibleDate konkaiToYMD;
    private Time konkaiToHMS;
    private FlexibleDate konkaikijunYMD;
    private Time konkaiKijunHMS;
    private FlexibleDate kofuYMD;
    private Boolean testShutsuryokuFlag;
    private Boolean saihakkoFlag;
    private FlexibleDate hakkouYMD;
    private Time hakkouHMS;
    private RString shutsuryokujunId;
    private RString shohyojiType;
    private ShinseishoKanriNo shinseishoKanriNo;
    private FlexibleDate seinengappiToYMD;
    private FlexibleDate seinengappiFromYMD;

    /**
     * コンストラクタ
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
     */
    public IkkatsuHakkoProcessParameter(RString shutsuryokuJokenCode,
            FlexibleDate konkaiFromYMD,
            Time konkaiFromHMS,
            FlexibleDate konkaiToYMD,
            Time konkaiToHMS,
            FlexibleDate konkaikijunYMD,
            Time konkaiKijunHMS,
            FlexibleDate kofuYMD,
            Boolean testShutsuryokuFlag,
            Boolean saihakkoFlag,
            FlexibleDate hakkouYMD,
            Time hakkouHMS,
            RString shutsuryokujunId,
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
     * mybatisのパラメータを生成します。
     *
     * @return mybatisパラメータ
     */
    public IkkatsuHakkoMybatisParameter toIkkatsuHakkoMybatisParameter() {
        return new IkkatsuHakkoMybatisParameter(shutsuryokuJokenCode,
                konkaiFromYMD,
                konkaiFromHMS,
                konkaiToYMD,
                konkaiToHMS,
                konkaikijunYMD,
                konkaiKijunHMS,
                shinseishoKanriNo,
                seinengappiToYMD,
                seinengappiFromYMD);
    }
}
