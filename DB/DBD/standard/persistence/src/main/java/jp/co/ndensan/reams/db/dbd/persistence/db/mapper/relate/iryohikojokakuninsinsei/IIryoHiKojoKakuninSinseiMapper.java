/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.iryohikojokakuninsinsei;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 
 * @reamsid_L DBD-5770-030 x_zhaowen
 */
public interface IIryoHiKojoKakuninSinseiMapper {
    /**
     * 受給者判定
     * @param 被保険者番号 RString
     * @return Integer
     */
    Integer 受給者台帳抽出(RString 被保険者番号);
}
