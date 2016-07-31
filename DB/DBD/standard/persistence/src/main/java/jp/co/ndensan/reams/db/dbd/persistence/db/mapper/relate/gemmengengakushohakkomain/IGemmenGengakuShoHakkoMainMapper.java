/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.gemmengengakushohakkomain;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmengengaku.futangendogakunintei.FutanGendogakuNinteiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmengengaku.homonkaigogengaku.HomonKaigoRiyoshaFutangakuGengakuEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmengengaku.riyoshafutangengaku.RiyoshaFutangakuGengakuEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmengengaku.shafukukeigen.ShafukuRiyoshaFutanKeigenEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmengengaku.tokubetsuchikikasangemmen.TokubetsuchiikiKasanGemmenEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;

/**
 * 減免減額認定証・決定通知書個別発行のマッパーインタフェースです。
 *
 * @reamsid_L DBD-3540-010 xuyue
 */
public interface IGemmenGengakuShoHakkoMainMapper {

    /**
     * 利用者負担額減免の情報を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return 利用者負担額減免の情報
     */
    List<RiyoshaFutangakuGengakuEntity> get利用者負担額減免の情報(HihokenshaNo 被保険者番号);

    /**
     * 負担限度額認定の情報を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return 負担限度額認定の情報
     */
    List<FutanGendogakuNinteiEntity> get負担限度額認定の情報(HihokenshaNo 被保険者番号);

    /**
     * 社会福祉法人等利用者負担軽減の情報を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return 社会福祉法人等利用者負担軽減の情報
     */
    List<ShafukuRiyoshaFutanKeigenEntity> get社会福祉法人等利用者負担軽減の情報(HihokenshaNo 被保険者番号);

    /**
     * 訪問介護利用者負担額減額の情報を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return 訪問介護利用者負担額減額の情報
     */
    List<HomonKaigoRiyoshaFutangakuGengakuEntity> get訪問介護利用者負担額減額の情報(HihokenshaNo 被保険者番号);

    /**
     * 特別地域加算減免の情報を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return 特別地域加算減免の情報
     */
    List<TokubetsuchiikiKasanGemmenEntity> get特別地域加算減免の情報(HihokenshaNo 被保険者番号);

}
