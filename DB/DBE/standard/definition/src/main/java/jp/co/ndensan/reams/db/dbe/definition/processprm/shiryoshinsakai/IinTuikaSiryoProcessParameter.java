/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.processprm.shiryoshinsakai;

import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shiryoshinsakai.IinTuutishoMyBatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shiryoshinsakai.JimuTuutishoMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 委員用追加資料鑑情報のProcessParameterです。
 *
 * @reamsid_L DBE-0150-200 linghuhang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IinTuikaSiryoProcessParameter implements IBatchProcessParameter {

    private RString shinsakaiKaisaiNo;
    private FlexibleDate shinsakaiKaisaiYoteiYMD;
    private RString shuturyokuSutairu;
    private RString printHou;
    private RString bunshoKanriNo;

    /**
     * コンストラクタです。
     *
     * @param shinsakaiKaisaiNo 介護認定審査会開催番号
     * @param shinsakaiKaisaiYoteiYMD 介護認定審査会開催予定日
     * @param shuturyokuSutairu 出力スタイル
     * @param printHou 印刷方法
     * @param bunshoKanriNo 文書管理番号
     */
    public IinTuikaSiryoProcessParameter(
            RString shinsakaiKaisaiNo,
            FlexibleDate shinsakaiKaisaiYoteiYMD,
            RString shuturyokuSutairu,
            RString printHou,
            RString bunshoKanriNo) {
        this.shinsakaiKaisaiNo = shinsakaiKaisaiNo;
        this.shinsakaiKaisaiYoteiYMD = shinsakaiKaisaiYoteiYMD;
        this.shuturyokuSutairu = shuturyokuSutairu;
        this.printHou = printHou;
        this.bunshoKanriNo = bunshoKanriNo;
    }

    /**
     * 委員用追加資料鑑情報のMyBatisParameterに転換します。
     *
     * @return IinTuutishoMyBatisParameter
     */
    public IinTuutishoMyBatisParameter toIinTuutishoMyBatisParameter() {
        return new IinTuutishoMyBatisParameter(shinsakaiKaisaiNo, shinsakaiKaisaiYoteiYMD, bunshoKanriNo);
    }

    /**
     * 事務局追加資料鑑情報のMyBatisParameterに転換します。
     *
     * @return IinTuutishoMyBatisParameter
     */
    public JimuTuutishoMyBatisParameter toJimuTuutishoMyBatisParameter() {
        return new JimuTuutishoMyBatisParameter(shinsakaiKaisaiNo);
    }
}
