/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.sogojigyoshikakushogohyoin;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.sogojigyoshikakushogohyoin.SogojigyohiShikakuShogohyoInEntity;

/**
 * 総合事業費資格照合表情報取込のバッチのDB操作クラスです。
 *
 * @reamsid_L DBC-2890-012 wangxue
 */
public interface ISogojigyohiShikakuShogohyoInMapper {

    /**
     * 総合事業費資格照合表情報取込の帳票出力対象データを取りメソッドです。
     *
     * @return SogojigyohiShikakuShogohyoInEntity
     */
    SogojigyohiShikakuShogohyoInEntity get帳票出力対象データ();

}
