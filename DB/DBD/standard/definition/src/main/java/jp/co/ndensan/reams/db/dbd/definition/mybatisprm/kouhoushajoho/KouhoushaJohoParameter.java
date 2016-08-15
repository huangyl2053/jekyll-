/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.kouhoushajoho;

import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 候補者情報のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBD-3530-060 liuyl
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KouhoushaJohoParameter {

    private FlexibleDate 基準日;
    private YMDHMS バッチ処理日時;
    private RString 減免減額種類;

    /**
     * コンストラクタです。
     *
     * @param 基準日 FlexibleDate
     * @param バッチ処理日時 YMDHMS
     * @param 減免減額種類 RString
     */
    public KouhoushaJohoParameter(FlexibleDate 基準日, YMDHMS バッチ処理日時, RString 減免減額種類) {
        this.基準日 = 基準日;
        this.バッチ処理日時 = バッチ処理日時;
        this.減免減額種類 = 減免減額種類;
    }

}
