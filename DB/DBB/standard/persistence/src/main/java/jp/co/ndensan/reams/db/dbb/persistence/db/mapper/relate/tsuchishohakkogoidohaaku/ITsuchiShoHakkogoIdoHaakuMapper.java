/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tsuchishohakkogoidohaaku;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.tsuchishohakkogoidosha.IdoshaParamter;
import jp.co.ndensan.reams.db.dbb.definition.tsuchishohakkogoidosha.QualificationsParamter;
import jp.co.ndensan.reams.db.dbb.entity.euc.tsuchishohakkogoidosha.Dbv2001EntityResult;
import jp.co.ndensan.reams.db.dbb.entity.euc.tsuchishohakkogoidosha.DbT2017Uaft200EntityResult;

/**
 * 通知書発行後異動把握のMapperクラスです。
 */
public interface ITsuchiShoHakkogoIdoHaakuMapper {

    /**
     * get対象データTwo
     *
     * @param paramter QualificationsParamter
     * @return List
     */
    List<Dbv2001EntityResult> get対象データTwo(QualificationsParamter paramter);

    /**
     * get異動者情報
     *
     * @param threeParamter threeParamter
     * @return List
     */
    List<DbT2017Uaft200EntityResult> get異動者情報(IdoshaParamter threeParamter);

}
