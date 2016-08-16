/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.seikyugakutsuchishoin;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120230.DbWT1511SeikyugakuTsuchishoTempEntity;

/**
 * 介護給付費等請求額通知書情報取込のバッチのDB操作クラスです。
 *
 * @reamsid_L DBC-2480-010 jiangwenkai
 */
public interface ISeikyugakuTsuchishoInMapper {

    /**
     * 介護給付費サービス請求額通知書一時TBLの全件を取りメソッドです。
     *
     * @return List<Map<String,Object>>
     */
    List<DbWT1511SeikyugakuTsuchishoTempEntity> select介護給付費サービス請求額通知書一時TBLの全件();

}
