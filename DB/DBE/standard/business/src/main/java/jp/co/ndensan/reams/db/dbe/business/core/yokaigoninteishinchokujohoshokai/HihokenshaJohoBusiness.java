/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteishinchokujohoshokai;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.yokaigoninteishinchokujohoshokai.HihokenshaJohoRelateEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者情報検索ビジネスクラスです。
 *
 * @reamsid_L DBE-0230-010 zhangzhiming
 */
public class HihokenshaJohoBusiness {

    private final HihokenshaJohoRelateEntity entity;

    /**
     * コンストラクタです.
     *
     * @param entity HihokenshaJyuhouRelateEntity
     */
    public HihokenshaJohoBusiness(HihokenshaJohoRelateEntity entity) {
        this.entity = entity;
    }

    /**
     * 証記載保険者番号のgetメソッドです。
     *
     * @return 証記載保険者番号
     */
    public RString get証記載保険者番号() {
        return entity.getShoKisaiHokenshaNo();
    }

    /**
     * 被保険者番号のgetメソッドです。
     *
     * @return 被保険者番号
     */
    public RString get被保険者番号() {
        return entity.getHihokenshaNo();
    }

    /**
     * 被保険者氏名のgetメソッドです。
     *
     * @return 被保険者氏名
     */
    public AtenaMeisho get被保険者氏名() {
        return entity.getHihokenshaName();
    }
}
