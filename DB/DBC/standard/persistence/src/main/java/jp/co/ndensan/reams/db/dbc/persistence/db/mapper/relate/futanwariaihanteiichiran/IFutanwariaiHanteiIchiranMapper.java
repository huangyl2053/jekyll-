/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.futanwariaihanteiichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.futanwariaihanteiichiran.FutanwariaiHanteiIchiranMybaticParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.futanwariaihanteiichiran.FutanwariaiHanteiIchiranEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.futanwariaihanteiichiran.MaeRiyoshaFutanWariaiHanteiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables.KonkaiRiyoshaFutanWariaiJohoTempEntity;

/**
 * 負担割合判定一覧出力（共通）のマッパーインタフェースです。
 *
 * @reamsid_L DBC-4980-031 yuanzhenxia
 */
public interface IFutanwariaiHanteiIchiranMapper {

    /**
     * 今回利用者負担割合判定データの抽出です。
     *
     * @param parameter FutanwariaiHanteiIchiranMybaticParameter
     * @return KonkaiRiyoshaFutanWariaiJohoTempEntity
     */
    List<KonkaiRiyoshaFutanWariaiJohoTempEntity> get今回利用者負担割合判定(FutanwariaiHanteiIchiranMybaticParameter parameter);

    /**
     * 前回利用者負担割合判定データの抽出です。
     *
     * @param parameter FutanwariaiHanteiIchiranMybaticParameter
     * @return MaeRiyoshaFutanWariaiHanteiEntity
     */
    List<MaeRiyoshaFutanWariaiHanteiEntity> get前回利用者負担割合判定(FutanwariaiHanteiIchiranMybaticParameter parameter);

    /**
     * 負担割合判定一覧データの抽出です。
     *
     * @param parameter FutanwariaiHanteiIchiranMybaticParameter
     * @return FutanwariaiHanteiIchiranEntity
     */
    List<FutanwariaiHanteiIchiranEntity> get負担割合判定一覧データ(FutanwariaiHanteiIchiranMybaticParameter parameter);

}
