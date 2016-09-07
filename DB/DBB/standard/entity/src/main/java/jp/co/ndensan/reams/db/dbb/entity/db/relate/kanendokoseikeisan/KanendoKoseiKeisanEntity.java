/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.kanendokoseikeisan;

import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 更正前後確定保険料の取得Entityクラスです。
 *
 * @reamsid_L DBB-9050-010 xicongwang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KanendoKoseiKeisanEntity {

    private Decimal 今回保険料;
    private Decimal 前回保険料;
    private Decimal 普徴期別金額合計;
    private Decimal 特徴期別金額合計;
}
