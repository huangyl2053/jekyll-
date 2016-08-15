/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.processprm.shiryoshinsakai;

import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shiryoshinsakai.IinTuutishoMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 審査会資料一括作成（委員）のProcessParameterです。
 *
 * @reamsid_L DBE-0150-200 linghuhang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IinTuutishoProcessParameter implements IBatchProcessParameter {

    private RString shinsakaiKaisaiNo;
    private RString shuturyokuSutairu;
    private RString printHou;
    private Decimal chohyoIinHusu;
    private FlexibleDate shinsakaiKaisaiYoteiYMD;
    private RString shinsakaiKaishiYoteiTime;
    private RString shinsakaiKaisaiBashoName;
    private int gogitaiNo;

    /**
     * コンストラクタです。
     *
     * @param shinsakaiKaisaiNo 介護認定審査会開催番号
     * @param shuturyokuSutairu 出力スタイル
     * @param printHou 印刷方法
     * @param shinsakaiKaisaiYoteiYMD 開催予定年月日
     * @param shinsakaiKaishiYoteiTime 予定時刻
     * @param shinsakaiKaisaiBashoName 開催会場
     * @param gogitaiNo 合議体番号
     */
    public IinTuutishoProcessParameter(
            RString shinsakaiKaisaiNo,
            RString shuturyokuSutairu,
            RString printHou,
            FlexibleDate shinsakaiKaisaiYoteiYMD,
            RString shinsakaiKaishiYoteiTime,
            RString shinsakaiKaisaiBashoName,
            int gogitaiNo) {
        this.shinsakaiKaisaiNo = shinsakaiKaisaiNo;
        this.shuturyokuSutairu = shuturyokuSutairu;
        this.printHou = printHou;
        this.chohyoIinHusu = chohyoIinHusu;
        this.shinsakaiKaisaiYoteiYMD = shinsakaiKaisaiYoteiYMD;
        this.shinsakaiKaishiYoteiTime = shinsakaiKaishiYoteiTime;
        this.shinsakaiKaisaiBashoName = shinsakaiKaisaiBashoName;
        this.gogitaiNo = gogitaiNo;
    }

    /**
     * 審査会開催のお知らせ一覧情報のMyBatisParameterに転換します。
     *
     * @return IinTuutishoMyBatisParameter
     */
    public IinTuutishoMyBatisParameter toIinTuutishoMyBatisParameter() {
        return new IinTuutishoMyBatisParameter(shinsakaiKaisaiNo);
    }
}
