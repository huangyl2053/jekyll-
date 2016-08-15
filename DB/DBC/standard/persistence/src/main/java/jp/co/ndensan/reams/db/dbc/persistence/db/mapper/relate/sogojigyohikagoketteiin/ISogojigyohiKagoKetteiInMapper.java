/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.sogojigyohikagoketteiin;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.sogojigyohikagoketteiin.SogojigyohiKagoKetteiInEntity;

/**
 * 総合事業費（経過措置）過誤決定通知書情報取込一覧表のDB操作です。
 *
 * @reamsid_L DBC-2550-010 jianglaishen
 */
public interface ISogojigyohiKagoKetteiInMapper {
    /**
     * 帳票出力対象データを取得する。
     *
     * @param parameter Map<String, Object>
     * @return List<SogojigyohiKagoKetteiInEntity>
     */
    List<SogojigyohiKagoKetteiInEntity> get帳票出力対象データ(Map<String, Object> parameter);
}
