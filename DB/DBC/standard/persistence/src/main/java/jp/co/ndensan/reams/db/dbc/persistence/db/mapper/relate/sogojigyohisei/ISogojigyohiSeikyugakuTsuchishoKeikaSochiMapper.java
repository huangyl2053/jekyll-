/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.sogojigyohisei;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120230.DbWT1511SeikyugakuTsuchishoTempEntity;

/**
 * 総合事業費（経過措置）請求額通知書のDB操作です。。
 *
 * @reamsid_L DBC-2480-011 jiangxiaolong
 */
public interface ISogojigyohiSeikyugakuTsuchishoKeikaSochiMapper {

    /**
     * 帳票出力対象データを取得する。
     *
     * @return List<DbWT1511SeikyugakuTsuchishoTempEntity>
     */
    List<DbWT1511SeikyugakuTsuchishoTempEntity> select帳票出力対象データ();

}
