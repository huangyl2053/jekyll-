/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tsuchishohakkogoidohaaku;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.tsuchishohakkogoidosha.ThreeParamter;
import jp.co.ndensan.reams.db.dbb.definition.tsuchishohakkogoidosha.TsuchishohakkogoidoshaParamter;
import jp.co.ndensan.reams.db.dbb.definition.tsuchishohakkogoidosha.TwoParamter;
import jp.co.ndensan.reams.db.dbb.entity.tsuchishohakkogoidosha.DBV2001EntityResult;
import jp.co.ndensan.reams.db.dbb.entity.tsuchishohakkogoidosha.DbT2017EntityResult;
import jp.co.ndensan.reams.db.dbb.entity.tsuchishohakkogoidosha.DbT2017Uaft200EntityResult;

/**
 * 通知書発行後異動把握のMapperクラスです。
 */
public interface ITsuchiShoHakkogoIdoHaakuMapper {

    List<DbT2017EntityResult> get対象データ(TsuchishohakkogoidoshaParamter paramter);

    List<DBV2001EntityResult> get対象データTwo(TwoParamter paramter);

    List<DbT2017Uaft200EntityResult> get異動者情報(ThreeParamter threeParamter);

}
