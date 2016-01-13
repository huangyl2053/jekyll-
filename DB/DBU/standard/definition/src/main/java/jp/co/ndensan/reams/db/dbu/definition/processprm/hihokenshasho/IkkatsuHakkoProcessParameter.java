/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.processprm.hihokenshasho;

import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.hihokenshasho.IkkatsuHakkoMybatisParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
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
    private RTime konkaiFromHMS;
    private FlexibleDate konkaiToYMD;
    private RTime konkaiToHMS;
    private FlexibleDate konkaiKijunYMD;
    private RTime konkaiKijunHMS;
    private FlexibleDate kofuYMD;
    private RString testShutsuryokuFlag;
    private RString saihakkoFlag;
    private FlexibleDate hakkouYMD;
    private RTime hakkouHMS;
    private RString shutsuryokujunId;
    private RString shohyojiType;
    private ShinseishoKanriNo shinseishoKanriNo;
    private FlexibleDate seinengappiToYMD;
    private FlexibleDate seinengappiFromYMD;
    private HihokenshaNo hihokenshaNo;
    private ShikibetsuCode shikibetsuCode;
    private RString psmShikibetsuTaisho;
    private RString psmAtesaki;
    private FlexibleDate nenreiTotatsuYMD;

    /**
     * コンストラクタ
     *
     * @param 出力条件コード 出力条件コード
     * @param 今回の開始日 今回の開始日
     * @param 今回の時分秒_以上 今回の時分秒_以上
     * @param 今回の終了日 今回の終了日
     * @param 今回の時分秒_未満 今回の時分秒_未満
     * @param 今回の基準日 今回の基準日
     * @param 今回の時分秒 今回の時分秒
     * @param 交付日 交付日
     * @param テスト出力するフラグ テスト出力するフラグ
     * @param 再発行するフラグ 再発行するフラグ
     * @param 発行日時の発行日 発行日時の発行日
     * @param 発行日時の時分秒 発行日時の時分秒
     * @param 出力順ID 出力順ID
     * @param 証表示タイプ 証表示タイプ
     */
    public IkkatsuHakkoProcessParameter(RString 出力条件コード,
            FlexibleDate 今回の開始日,
            RTime 今回の時分秒_以上,
            FlexibleDate 今回の終了日,
            RTime 今回の時分秒_未満,
            FlexibleDate 今回の基準日,
            RTime 今回の時分秒,
            FlexibleDate 交付日,
            RString テスト出力するフラグ,
            RString 再発行するフラグ,
            FlexibleDate 発行日時の発行日,
            RTime 発行日時の時分秒,
            RString 出力順ID,
            RString 証表示タイプ) {
        this.shutsuryokuJokenCode = 出力条件コード;
        this.konkaiFromYMD = 今回の開始日;
        this.konkaiFromHMS = 今回の時分秒_以上;
        this.konkaiToYMD = 今回の終了日;
        this.konkaiToHMS = 今回の時分秒_未満;
        this.konkaiKijunYMD = 今回の基準日;
        this.konkaiKijunHMS = 今回の時分秒;
        this.kofuYMD = 交付日;
        this.testShutsuryokuFlag = テスト出力するフラグ;
        this.saihakkoFlag = 再発行するフラグ;
        this.hakkouYMD = 発行日時の発行日;
        this.hakkouHMS = 発行日時の時分秒;
        this.shutsuryokujunId = 出力順ID;
        this.shohyojiType = 証表示タイプ;
    }

    private RDateTime getKonkaiYMDHMS(FlexibleDate konkaiYMD, RTime konkaiHMS) {
        RDateTime konkaiYMDHMS = RDateTime.of(konkaiYMD.getYearValue(),
                konkaiYMD.getMonthValue(),
                konkaiYMD.getDayValue(),
                konkaiHMS.getHour(),
                konkaiHMS.getMinute(),
                konkaiHMS.getSecond(),
                konkaiHMS.getMillisOfSecond());
        return konkaiYMDHMS;
    }

    /**
     * mybatisのパラメータを生成します。
     *
     * @return mybatisパラメータ
     */
    public IkkatsuHakkoMybatisParameter toIkkatsuHakkoMybatisParameter() {
        return IkkatsuHakkoMybatisParameter.createSelectByKeyParam(shutsuryokuJokenCode,
                getKonkaiYMDHMS(konkaiFromYMD, konkaiFromHMS),
                konkaiToYMD,
                getKonkaiYMDHMS(konkaiToYMD, konkaiToHMS),
                konkaiKijunYMD,
                getKonkaiYMDHMS(konkaiKijunYMD, konkaiKijunHMS),
                shinseishoKanriNo,
                seinengappiToYMD,
                seinengappiFromYMD,
                hihokenshaNo,
                shikibetsuCode,
                psmShikibetsuTaisho,
                psmAtesaki,
                nenreiTotatsuYMD);
    }
}
