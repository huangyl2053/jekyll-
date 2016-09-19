/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokugeppohokenkyufukogakugassan;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 処理結果確認リスト情報のRelateEntityクラスです。
 *
 * @reamsid_L DBU-5590-030 zhangzhiming
 */
@SuppressWarnings("PMd.UnusedPrivateField")
@lombok.Setter
@lombok.Getter
public class ShoriKekkaKakuninListRelateEntity {

    private RString komokuNo1;
    private RString komokuNo2;
    private RString komokuNo3;
    private RString komokuNo4;
    private RString programId;
    private RString syoriMeisyou;
    private RString komoku1;
    private RString komoku2;
    private RString komoku3;
    private RString komoku4;
    private RString naiYou1;
    private RString naiYou2;
}
