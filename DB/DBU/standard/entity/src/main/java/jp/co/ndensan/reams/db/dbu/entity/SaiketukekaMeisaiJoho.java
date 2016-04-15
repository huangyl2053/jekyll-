/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 裁決結果明細情報です。
 *
 * @reamsid_L DBU-1080-120 xuyue
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SaiketukekaMeisaiJoho {

    private RString 裁決結果;
    private RString 裁決理由;
    private FlexibleDate 弁明書作成日;

}
