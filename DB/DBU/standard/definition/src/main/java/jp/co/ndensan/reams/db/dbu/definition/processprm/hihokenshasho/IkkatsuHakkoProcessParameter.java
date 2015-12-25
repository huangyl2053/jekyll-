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
            Time 今回の時分秒_以上,
            FlexibleDate 今回の終了日,
            Time 今回の時分秒_未満,
            FlexibleDate 今回の基準日,
            Time 今回の時分秒,
            FlexibleDate 交付日,
            Boolean テスト出力するフラグ,
            Boolean 再発行するフラグ,
            FlexibleDate 発行日時の発行日,
            Time 発行日時の時分秒,
            RString 出力順ID,
            RString 証表示タイプ) {
        this.shutsuryokuJokenCode = 出力条件コード;
        this.konkaiFromYMD = 今回の開始日;
        this.konkaiFromHMS = 今回の時分秒_以上;
        this.konkaiToYMD = 今回の終了日;
        this.konkaiToHMS = 今回の時分秒_未満;
        this.konkaiKijunHMS = 今回の時分秒;
        this.konkaikijunYMD = 今回の基準日;
        this.kofuYMD = 交付日;
        this.testShutsuryokuFlag = テスト出力するフラグ;
        this.saihakkoFlag = 再発行するフラグ;
        this.hakkouYMD = 発行日時の発行日;
        this.hakkouHMS = 発行日時の時分秒;
        this.shutsuryokujunId = 出力順ID;
        this.shohyojiType = 証表示タイプ;
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
