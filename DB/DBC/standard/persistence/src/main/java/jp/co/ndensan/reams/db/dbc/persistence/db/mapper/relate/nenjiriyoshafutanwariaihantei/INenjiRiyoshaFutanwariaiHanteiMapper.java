/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.nenjiriyoshafutanwariaihantei;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.nenjiriyoshafutanwariaihantei.NenjiRiyoshaFutanwariaiHanteiMybaticParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.nenjiriyoshafutanwariaihantei.HanteiTaishoshaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.nenjiriyoshafutanwariaihantei.JukyushaDaichoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.nenjiriyoshafutanwariaihantei.SogoJigyoTaishoshaTempEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3113RiyoshaFutanWariaiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3114RiyoshaFutanWariaiMeisaiEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;

/**
 * 年次利用者負担割合判定のマッパーインタフェースです。
 *
 * @reamsid_L DBC-4980-030 yuanzhenxia
 */
public interface INenjiRiyoshaFutanwariaiHanteiMapper {

    /**
     * 受給者台帳TEMPを検索する
     *
     * @param parameter NenjiRiyoshaFutanwariaiHanteiMybaticParameter
     * @return 受給者台帳情報
     */
    List<JukyushaDaichoTempEntity> getJukyushaDaichoTemp(NenjiRiyoshaFutanwariaiHanteiMybaticParameter parameter);

    /**
     * 総合事業対象者台帳TEMPを検索する
     *
     * @param parameter NenjiRiyoshaFutanwariaiHanteiMybaticParameter
     * @return 総合事業対象者台帳情報
     */
    List<SogoJigyoTaishoshaTempEntity> getSogoJigyoTaishoshaTemp(NenjiRiyoshaFutanwariaiHanteiMybaticParameter parameter);

    /**
     * 申請中データを削除する
     *
     * @return JukyushaDaichoTempEntity
     */
    List<JukyushaDaichoTempEntity> delete申請中データ();

    /**
     * 判定対象者TEMPを検索する
     *
     * @return 判定対象者情報
     */
    List<HanteiTaishoshaEntity> getHanteiTaishoshaTemp();

    /**
     * 利用者負担割合明細を削除する
     *
     * @param parameter NenjiRiyoshaFutanwariaiHanteiMybaticParameter
     * @return DbT3114RiyoshaFutanWariaiMeisaiEntity
     */
    List<DbT3114RiyoshaFutanWariaiMeisaiEntity> delete利用者負担割合明細(NenjiRiyoshaFutanwariaiHanteiMybaticParameter parameter);

    /**
     * 利用者負担割合を削除する
     *
     * @param parameter NenjiRiyoshaFutanwariaiHanteiMybaticParameter
     * @return DbT3113RiyoshaFutanWariaiEntity
     */
    List<DbT3113RiyoshaFutanWariaiEntity> delete利用者負担割合(NenjiRiyoshaFutanwariaiHanteiMybaticParameter parameter);

    /**
     * 利用者負担割合世帯員を削除する
     *
     * @param parameter NenjiRiyoshaFutanwariaiHanteiMybaticParameter
     * @return DbT3113RiyoshaFutanWariaiEntity
     */
    List<DbT3113RiyoshaFutanWariaiEntity> delete利用者負担割合世帯員(NenjiRiyoshaFutanwariaiHanteiMybaticParameter parameter);

    /**
     * 処理日付管理マスタを検索する
     *
     * @param parameter NenjiRiyoshaFutanwariaiHanteiMybaticParameter
     * @return 処理日付管理マスタ情報
     */
    List<DbT7022ShoriDateKanriEntity> get処理日付管理マスタ(NenjiRiyoshaFutanwariaiHanteiMybaticParameter parameter);

}
