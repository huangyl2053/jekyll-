/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.kyotakuservicekeikakuinfo;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.kyotakuservicekeikakuinfo.KyotakuServiceKeikakuInfoRelateEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 居宅サービス計画情報クラスです。
 */
public class KyotakuServiceKeikaku {

    private final KyotakuServiceKeikakuInfoRelateEntity entity;

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link KyotakuServiceKeikakuInfoRelateEntity}より{@link KyotakuServiceKeikaku}を生成します。
     *
     * @param entity DBより取得した{@link KyotakuServiceKeikakuInfoRelateEntity}
     */
    public KyotakuServiceKeikaku(KyotakuServiceKeikakuInfoRelateEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("居宅サービス計画情報"));
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return entity.getHihokenshano();
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
     * @return 連絡先区分番号
     */
    public Decimal get履歴番号() {
        return entity.getRirekiNo();
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
     * 計画事業者番号を返します。
     *
     * @return 計画事業者番号
     */
    public JigyoshaNo get計画事業者番号() {
        return entity.getKeikakuJigyoshaNo();
    }

    /**
     * 委託先事業者番号を返します。
     *
     * @return 委託先事業者番号
     */
    public JigyoshaNo get委託先事業者番号() {
        return entity.getItakusakiJigyoshaNo();
    }

    /**
     * 事業者名称を返します。
     *
     * @return 事業者名称
     */
    public RString get事業者名称() {
        return entity.getJigyoshaName();
    }
}
