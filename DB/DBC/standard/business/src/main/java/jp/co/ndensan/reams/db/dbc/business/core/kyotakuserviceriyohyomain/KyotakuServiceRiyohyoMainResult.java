/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kyotakuserviceriyohyomain;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyotakuserviceriyohyomain.KyotakuServiceRirekiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 居宅サービ業務概念スラスです。
 *
 * @reamsid_L DBC-1930-030 huzongcheng
 */
public class KyotakuServiceRiyohyoMainResult implements Serializable {

    private final KyotakuServiceRirekiEntity entity;

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link KyotakuServiceRirekiEntity}より{@link KyotakuServiceRiyohyoMainResult}を生成します。
     *
     * @param entity DBより取得した{@link KyotakuServiceRirekiEntity}
     */
    public KyotakuServiceRiyohyoMainResult(KyotakuServiceRirekiEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("居宅サービEntity"));
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return entity.getHihokenshaNo();
    }

    /**
     * 対象年月を返します。
     *
     * @return 対象年月
     */
    public FlexibleYearMonth get対象年月() {
        return entity.getTaishoYM();
    }

    /**
     * 履歴番号を返します。
     *
     * @return 履歴番号
     */
    public int get履歴番号() {
        return entity.getRirekiNo();
    }

    /**
     * 届出年月日を返します。
     *
     * @return 届出年月日
     */
    public FlexibleDate get届出年月日() {
        return entity.getTodokedeYMD();
    }

    /**
     * 居宅・総合事業区分を返します。
     *
     * @return 居宅・総合事業区分
     */
    public RString get居宅_総合事業区分() {
        return entity.getSogoJigyoKubun();
    }

    /**
     * 適用開始年月日を返します。
     *
     * @return 適用開始年月日
     */
    public FlexibleDate get適用開始年月日() {
        return entity.getTekiyoKaishiYMD();
    }

    /**
     * 適用終了年月日を返します。
     *
     * @return 適用終了年月日
     */
    public FlexibleDate get適用終了年月日() {
        return entity.getTekiyoShuryoYMD();
    }

    /**
     * 作成区分コードを返します。
     *
     * @return 作成区分コード
     */
    public RString get作成区分コード() {
        return entity.getSakuseiKubunCode();
    }

    /**
     * 計画変更年月日を返します。
     *
     * @return 計画変更年月日
     */
    public FlexibleDate get計画変更年月日() {
        return entity.getKeikakuHenkoYMD();
    }

    /**
     * 履歴順を返します。
     *
     * @return 履歴順
     */
    public int get履歴順() {
        return entity.getRirekiSort();
    }

}
