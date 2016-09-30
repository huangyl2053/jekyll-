/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.dankaibetsushunoritsu;

import java.io.Serializable;

/**
 * 収納宛名データを取得Entityクラスです。
 *
 * @reamsid_L DBB-1630-020 tianshuai
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JukyushaKyufujissekiCountEntity implements Serializable {

    private int 受給者台帳COUNT;
    private int 給付実績基本COUNT;
}
