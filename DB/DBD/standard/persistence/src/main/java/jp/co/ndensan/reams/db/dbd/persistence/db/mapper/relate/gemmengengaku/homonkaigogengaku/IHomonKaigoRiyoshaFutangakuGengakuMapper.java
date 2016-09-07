/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.gemmengengaku.homonkaigogengaku;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.gemmengengaku.homonkaigogengaku.HomonKaigoRiyoshaFutangakuGengakuMapperParameter;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.gemmengengaku.ninteishoketteitsuchishokobetsuhakko.NinteiJohoParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmengengaku.homonkaigogengaku.HomonKaigoRiyoshaFutangakuGengakuEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;

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

    /**
     * 訪問介護利用者負担額減額情報を検索By被保険者番号で取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return List<HomonKaigoRiyoshaFutangakuGengakuEntity>
     */
    List<HomonKaigoRiyoshaFutangakuGengakuEntity> select訪問介護利用者負担額減額By被保険者番号(HihokenshaNo 被保険者番号);

    /**
     * 被保険者番号、減免減額種類、履歴番号により、訪問介護利用者負担額減額情報を取得します。
     *
     * @param parameter 訪問介護利用者負担額減額検索条件
     * @return HomonKaigoRiyoshaFutangakuGengakuEntity
     */
    HomonKaigoRiyoshaFutangakuGengakuEntity select訪問介護利用者負担額減額(NinteiJohoParameter parameter);
}
