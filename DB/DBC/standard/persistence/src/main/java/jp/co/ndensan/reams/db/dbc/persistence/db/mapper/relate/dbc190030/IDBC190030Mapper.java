/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc190030;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc190030.DBC190030MyBatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.kijunsyunyunenji.HihokenshaDaichoTempSixColumnEntity;

/**
 * サービスコード単位明細リストのMapperです。
 *
 * @reamsid_L DBC-3330-010 jianglaisheng
 */
public interface IDBC190030Mapper {

    /**
     * get被保険者台帳1のメソッドです。
     *
     * @param parameter DBC190030MyBatisParameter
     * @return List<HihokenshaDaichoTempSixColumnEntity>
     */
    List<HihokenshaDaichoTempSixColumnEntity> get被保険者台帳1(DBC190030MyBatisParameter parameter);

    /**
     * get被保険者台帳2のメソッドです。
     *
     * @param parameter DBC190030MyBatisParameter
     * @return List<HihokenshaDaichoTempSixColumnEntity>
     */
    List<HihokenshaDaichoTempSixColumnEntity> get被保険者台帳2(DBC190030MyBatisParameter parameter);

    /**
     * get被保険者台帳3のメソッドです。
     *
     * @param parameter DBC190030MyBatisParameter
     * @return List<HihokenshaDaichoTempSixColumnEntity>
     */
    List<HihokenshaDaichoTempSixColumnEntity> get被保険者台帳3(DBC190030MyBatisParameter parameter);

    /**
     * get被保険者台帳4のメソッドです。
     *
     * @param parameter DBC190030MyBatisParameter
     * @return List<HihokenshaDaichoTempSixColumnEntity>
     */
    List<HihokenshaDaichoTempSixColumnEntity> get被保険者台帳4(DBC190030MyBatisParameter parameter);

}
