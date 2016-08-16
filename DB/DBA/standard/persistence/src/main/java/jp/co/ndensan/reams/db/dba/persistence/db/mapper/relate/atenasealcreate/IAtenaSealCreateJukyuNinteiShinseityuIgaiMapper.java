/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.atenasealcreate;

import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.atenasealcreate.AtenaSealCreateMybatisParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.atenasealcreate.AtenaSealCreateRelate4001Entity;

/**
 * 宛名シール作成のマッパーインタフェースです。
 *
 * @reamsid_L DBA-1210-030 zhengsongling
 */
public interface IAtenaSealCreateJukyuNinteiShinseityuIgaiMapper {

    /**
     * 抽出対象者が受給認定申請中を除くの場合、データを取得します。
     *
     * @param parameter AtenaSealCreateShitaMybatisParameter
     * @return List<AtenaSealCreateRelateEntity>
     */
    List<AtenaSealCreateRelate4001Entity> getJukyuNinteiShinseityuIgai(AtenaSealCreateMybatisParameter parameter);
}
