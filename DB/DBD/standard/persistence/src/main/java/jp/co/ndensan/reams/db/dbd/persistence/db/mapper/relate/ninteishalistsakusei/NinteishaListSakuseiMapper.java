/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.ninteishalistsakusei;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.relate.ninteishalistsakusei.NinteishaListSakuseiParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd200004.ShakaiFukushiHojinKeigenGaitoshaIchiranEntity;

/**
 * 対象者一次特定を取得します
 *
 * @reamsid_L DBD-3830-040 tianyh
 */
public interface NinteishaListSakuseiMapper {

    /**
     * select社会福祉法人軽減情報。
     *
     * @param parameter NinteishaListSakuseiParameter
     * @return ShakaiFukushiHojinKeigenGaitoshaIchiranEntity{@code list}
     */
    List<ShakaiFukushiHojinKeigenGaitoshaIchiranEntity> select社会福祉法人軽減情報(NinteishaListSakuseiParameter parameter);

}
