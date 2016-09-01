/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.tsuchishori;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd5030001.TsuchiShoriEntity;

/**
 * 完了処理・通知書発行画面のMapperクラスです。
 *
 * @reamsid_L DBD-2040-010 chenxin
 */
public interface ITsuchiShoriMapper {

    /**
     * 初期化のデータを取得する。
     *
     * @return List<TsuchiShoriEntity>
     */
    List<TsuchiShoriEntity> 初期化データ取得();
}
