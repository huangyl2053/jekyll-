/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shinsakaijizenshinsakekkaichiran;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 事前審査結果状況のビジネスクラスです。
 *
 * @reamsid_L DBE-1640-010 zhaoyao
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JizenShinsaKekkaJokyo {

    private RString shinsakaiOrder;
    private RString shisain1;
    private RString shisain2;
    private RString shisain3;
    private RString shisain4;
    private RString shisain5;
}
