/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.hasuchosei;

import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * I端数調整
 *
 * @author n3336
 */
public interface IHasuChosei {

    Decimal calc端数(Decimal 年額保険料);
}
