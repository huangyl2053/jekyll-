/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.shikakufuseigo;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.shikakufuseigo.ShikakuFuseigoEntity;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 資格不整合一覧情報のBusinessクラスです。
 *
 * @reamsid_L DBB-0630-020 chengsanyuan
 */
public class ShikakuFuseigoBusiness {

    private final ShikakuFuseigoEntity entity;

    /**
     * コンストラクタです.
     *
     * @param entity ShikakuFuseigoEntity
     */
    public ShikakuFuseigoBusiness(ShikakuFuseigoEntity entity) {
        this.entity = entity;
    }

    /**
     * 対象外フラグを返します。
     *
     * @return 対象外フラグ
     */
    public boolean get対象外フラグ() {
        return entity.getDbt1014Entity().getTaishogaiFlag();
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return entity.getDbt1014Entity().getHihokenshaNo();
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return entity.getDbt1014Entity().getShikibetsuCode();
    }

    /**
     * 生年月日を返します。
     *
     * @return 生年月日
     */
    public FlexibleDate get生年月日() {
        return entity.getDbt1014Entity().getSeinengappiYMD();
    }

    /**
     * 不整合理由コードを返します。
     *
     * @return 不整合理由コード
     */
    public RString get不整合理由コード() {
        return entity.getDbt1014Entity().getFuseigoRiyuCode();
    }

    /**
     * 住民状態コードを返します。
     *
     * @return 住民状態コード
     */
    public RString get住民状態コード() {
        return entity.getDbt1014Entity().getJuminJotaiCode();
    }
}
