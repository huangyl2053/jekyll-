/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.mybatisprm.hihokenshasho;

import java.sql.Time;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 被保険者証一括発行のMyBatisパラメータ
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class IkkatsuHakkoMybatisParameter implements IMyBatisParameter {

    private final RString shutsuryokuJokenCode;
    private final FlexibleDate konkaiFromYMD;
    private final Time konkaiFromHMS;
    private final FlexibleDate konkaiToYMD;
    private final Time konkaiToHMS;
    private final FlexibleDate konkaikijunYMD;
    private final Time konkaiKijunHMS;
    private final ShinseishoKanriNo shinseishoKanriNo;
    private final FlexibleDate seinengappiToYMD;
    private final FlexibleDate seinengappiFromYMD;

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
     * @param shinseishoKanriNo 申請書管理番号
     * @param seinengappiToYMD 生年月日抽出開始日
     * @param seinengappiFromYMD 生年月日抽出終了日
     */
    public IkkatsuHakkoMybatisParameter(RString shutsuryokuJokenCode,
            FlexibleDate konkaiFromYMD,
            Time konkaiFromHMS,
            FlexibleDate konkaiToYMD,
            Time konkaiToHMS,
            FlexibleDate konkaikijunYMD,
            Time konkaiKijunHMS,
            ShinseishoKanriNo shinseishoKanriNo,
            FlexibleDate seinengappiToYMD,
            FlexibleDate seinengappiFromYMD) {
        this.shutsuryokuJokenCode = shutsuryokuJokenCode;
        this.konkaiFromYMD = konkaiFromYMD;
        this.konkaiFromHMS = konkaiFromHMS;
        this.konkaiToYMD = konkaiToYMD;
        this.konkaiToHMS = konkaiToHMS;
        this.konkaikijunYMD = konkaikijunYMD;
        this.konkaiKijunHMS = konkaiKijunHMS;
        this.shinseishoKanriNo = shinseishoKanriNo;
        this.seinengappiToYMD = seinengappiToYMD;
        this.seinengappiFromYMD = seinengappiFromYMD;
    }
}
