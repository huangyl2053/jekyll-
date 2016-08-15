/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.hikazenenkintaishoshadoutei;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd8100202.ChofukuTorikomiDataDeleteShoriJohoEntity;

/**
 * 重複取込データ除外処理のマッパーインタフェースです。
 *
 * @reamsid_L DBD-4910-040 x_miaocl
 */
public interface IChofukuTorikomiDataDeleteShoriMapper {

    List<ChofukuTorikomiDataDeleteShoriJohoEntity> get重複取込データ除外処理();

    int deleceデータを削除処理();
}
