/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd104010;

import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 認定状況のentityです。
 *
 * @reamsid_L　DBD-3770-060 liuwei2
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteiyotaiTwoEntity {

    private Decimal kensu;
    private Decimal sotishakensu;
    private Decimal flag;
    private Decimal flag1;
    private Decimal tableFlag;
}
