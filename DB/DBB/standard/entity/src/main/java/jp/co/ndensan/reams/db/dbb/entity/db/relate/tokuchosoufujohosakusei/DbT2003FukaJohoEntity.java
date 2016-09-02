/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchosoufujohosakusei;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * DBB-1830-040バッチ設計_DBBBT84001_特徴制度間Ｉ／ＦのDbT2003FukaJohoEntityのクラスです。
 *
 * @reamsid_L DBB-1830-040 liuyang
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class DbT2003FukaJohoEntity {

    private int ki;
    private Decimal choteigaku;
    private long choteiId;
    private RString choshuHouhou;
}
