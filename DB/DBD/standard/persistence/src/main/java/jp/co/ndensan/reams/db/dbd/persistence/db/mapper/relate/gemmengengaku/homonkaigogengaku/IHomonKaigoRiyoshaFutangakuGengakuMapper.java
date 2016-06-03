/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.gemmengengaku.homonkaigogengaku;

import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.gemmengengaku.homonkaigogengaku.HomonKaigoRiyoshaFutangakuGengakuMapperParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmengengaku.homonkaigogengaku.HomonKaigoRiyoshaFutangakuGengakuEntity;

/**
 * 訪問介護利用者負担額減額のマッパーインタフェースです。
 *
 * @reamsid_L DBD-9999-013 huangh
 */
public interface IHomonKaigoRiyoshaFutangakuGengakuMapper {

    /**
     * 訪問介護利用者負担額減額情報をキー検索で１件取得します。
     *
     * @param 訪問介護利用者負担額減額検索条件 訪問介護利用者負担額減額検索条件
     * @return HomonKaigoRiyoshaFutangakuGengakuEntity
     */
    HomonKaigoRiyoshaFutangakuGengakuEntity select訪問介護利用者負担額減額ByKey(HomonKaigoRiyoshaFutangakuGengakuMapperParameter 訪問介護利用者負担額減額検索条件);

}
