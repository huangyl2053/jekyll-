/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kagoketteikohifutanshain;

import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ShikibetsuCodeTempParameter
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShikibetsuCodeTempParameter {

    private final ShikibetsuCode 識別コード;
    private final RString 全国住所コード;
    private final YubinNo 郵便番号;
    private final AtenaJusho 住所;
    private final GyoseikuCode 行政区コード;
    private final RString 行政区;
    private final AtenaKanaMeisho カナ名称;
    private final AtenaMeisho 名称;

    private ShikibetsuCodeTempParameter(ShikibetsuCode 識別コード,
            RString 全国住所コード,
            YubinNo 郵便番号,
            AtenaJusho 住所,
            GyoseikuCode 行政区コード,
            RString 行政区,
            AtenaKanaMeisho カナ名称,
            AtenaMeisho 名称) {
        this.識別コード = 識別コード;
        this.全国住所コード = 全国住所コード;
        this.郵便番号 = 郵便番号;
        this.住所 = 住所;
        this.行政区コード = 行政区コード;
        this.行政区 = 行政区;
        this.カナ名称 = カナ名称;
        this.名称 = 名称;
    }

    /**
     * 宛名識別対象PSMを取得するパラメータ作成
     *
     * @param 識別コード ShikibetsuCode
     * @param 全国住所コード RString
     * @param 郵便番号 YubinNo
     * @param 住所 AtenaJusho
     * @param 行政区コード GyoseikuCode
     * @param 行政区 RString
     * @param カナ名称 AtenaKanaMeisho
     * @param 名称 AtenaMeisho
     * @return ShikibetsuCodeTempParameter
     */
    public static ShikibetsuCodeTempParameter createParameter(ShikibetsuCode 識別コード,
            RString 全国住所コード,
            YubinNo 郵便番号,
            AtenaJusho 住所,
            GyoseikuCode 行政区コード,
            RString 行政区,
            AtenaKanaMeisho カナ名称,
            AtenaMeisho 名称) {
        return new ShikibetsuCodeTempParameter(識別コード,
                全国住所コード, 郵便番号, 住所, 行政区コード, 行政区, カナ名称, 名称);
    }
}
