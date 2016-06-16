/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.processprm.publicationshiryoshinsakai;

import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.publicationshiryoshinsakai.IinTuutishoMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

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
    private RString chohyoIinHusu;

    /**
     * コンストラクタです。
     *
     * @param shinsakaiKaisaiNo 介護認定審査会開催番号
     * @param shuturyokuSutairu 出力スタイル
     * @param printHou 印刷方法
     * @param chohyoIinHusu 審査会委員用部数
     */
    public IinTuutishoProcessParameter(
            RString shinsakaiKaisaiNo,
            RString shuturyokuSutairu,
            RString printHou,
            RString chohyoIinHusu) {
        this.shinsakaiKaisaiNo = shinsakaiKaisaiNo;
        this.shuturyokuSutairu = shuturyokuSutairu;
        this.printHou = printHou;
        this.chohyoIinHusu = chohyoIinHusu;
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
