/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.hihokenshashochohyo;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 本人情報Entityリストです。
 *
 * @reamsid_L DBU-0490-021 zhangzhiming
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HonninJohoEntity {

    /**
     * 識別コード。
     */
    private ShikibetsuCode shikibetsuCode;

    /**
     * 氏名。
     */
    private RString meisho;

    /**
     * 生年月日。
     */
    private FlexibleDate seinengappiYMD;

    /**
     * 住民種別。
     */
    private RString juminShubetsuCode;

    /**
     * 行政区。
     */
    private RString gyoseikuName;

    /**
     * カナ氏名。
     */
    private RString kanaMeisho;

    /**
     * 郵便番号。
     */
    private YubinNo yubinNo;

    /**
     * 性別。
     */
    private RString seibetsuCode;

    /**
     * 生年月日不詳区分。
     */
    private RString seinengappiFushoKubun;
}
