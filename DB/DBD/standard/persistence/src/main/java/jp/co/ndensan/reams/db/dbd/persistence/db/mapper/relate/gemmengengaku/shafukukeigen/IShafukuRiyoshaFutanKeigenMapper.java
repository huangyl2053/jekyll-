/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.gemmengengaku.shafukukeigen;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.gemmengengaku.ninteishoketteitsuchishokobetsuhakko.NinteiJohoParameter;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.gemmengengaku.shafukukeigen.ShafukuRiyoshaFutanKeigenMapperParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmengengaku.shafukukeigen.ShafukuRiyoshaFutanKeigenEntity;

/**
 * 社会福祉法人等利用者負担軽減のマッパーインタフェースです。
 *
 * @reamsid_L DBD-9999-011 sunhaidi
 */
public interface IShafukuRiyoshaFutanKeigenMapper {

    /**
     * 社会福祉法人等利用者負担軽減情報をキー検索で１件取得します。
     *
     * @param 社会福祉法人等利用者負担軽減検索条件 社会福祉法人等利用者負担軽減検索条件
     * @return ShafukuRiyoshaFutanKeigenEntity
     */
    ShafukuRiyoshaFutanKeigenEntity select社会福祉法人等利用者負担軽減ByKey(ShafukuRiyoshaFutanKeigenMapperParameter 社会福祉法人等利用者負担軽減検索条件);

    /**
     * 主キー1に合致する社会福祉法人等利用者負担軽減のリストを取得します。
     *
     * @param 社会福祉法人等利用者負担軽減検索条件 社会福祉法人等利用者負担軽減検索条件
     * @return ShafukuRiyoshaFutanKeigenEntityの{@code list}
     */
    List<ShafukuRiyoshaFutanKeigenEntity> select社会福祉法人等利用者負担軽減リストBy主キー1(ShafukuRiyoshaFutanKeigenMapperParameter 社会福祉法人等利用者負担軽減検索条件);

    /**
     * 被保険者番号、減免減額種類、履歴番号により、社会福祉法人等利用者負担軽減を取得します。
     *
     * @param parameter 社会福祉法人等利用者負担軽減検索条件
     * @return ShafukuRiyoshaFutanKeigenEntity
     */
    ShafukuRiyoshaFutanKeigenEntity select社会福祉法人等利用者負担軽減(NinteiJohoParameter parameter);
}
