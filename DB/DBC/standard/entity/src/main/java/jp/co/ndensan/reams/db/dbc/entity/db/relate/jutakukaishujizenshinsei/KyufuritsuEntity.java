/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.jutakukaishujizenshinsei;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付率取得用Entityクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufuritsuEntity implements Cloneable, Serializable {

    private int rirekiNo;
    private int edaNo;
    private RString futanWariaiKubun;
}
