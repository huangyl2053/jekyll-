/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.taishoshakensakubusiness;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.taishoshakensaku.TaishoshaKensakuRelateEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 過誤申立決定情報照会のビジネスです。
 *
 * @reamsid_L DBC-2940-010 jinjue
 */
public class TaishoshaKensakuRelateBusiness {

    private final TaishoshaKensakuRelateEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity TaishoshaKensakuRelateEntity
     */
    public TaishoshaKensakuRelateBusiness(TaishoshaKensakuRelateEntity entity) {
        this.entity = entity;
    }

    /**
     * 取扱年月を取得します。
     *
     * @return 取扱年月
     */
    public FlexibleYearMonth get取扱年月() {
        return entity.get取扱年月();
    }

    /**
     * 保険者区分を取得します。
     *
     * @return 保険者区分
     */
    public RString get保険者区分() {
        return entity.get保険者区分();
    }

    /**
     * 被保険者氏名を取得します。
     *
     * @return 被保険者氏名
     */
    public RString get被保険者氏名() {
        return entity.get被保険者氏名();
    }

    /**
     * 履歴番号を取得します。
     *
     * @return 履歴番号
     */
    public Decimal get履歴番号() {
        return entity.get履歴番号();
    }

    /**
     * 介護給付費件数を取得します。
     *
     * @return 介護給付費件数
     */
    public int get介護給付費件数() {
        return entity.get介護給付費件数();
    }

    /**
     * 介護給付費単位数を取得します。
     *
     * @return 介護給付費単位数
     */
    public Decimal get介護給付費単位数() {
        return entity.get介護給付費単位数();
    }

    /**
     * 介護給付費保険者負担額を取得します。
     *
     * @return 介護給付費保険者負担額
     */
    public Decimal get介護給付費保険者負担額() {
        return entity.get介護給付費保険者負担額();
    }

    /**
     * 高額介護サービス費件数を取得します。
     *
     * @return 高額介護サービス費件数
     */
    public int get高額介護サービス費件数() {
        return entity.get高額介護サービス費件数();
    }

    /**
     * 高額介護サービス費単位数を取得します。
     *
     * @return 高額介護サービス費単位数
     */
    public Decimal get高額介護サービス費単位数() {
        return entity.get高額介護サービス費単位数();
    }

    /**
     * 高額介護サービス費保険者負担額を取得します。
     *
     * @return 高額介護サービス費保険者負担額
     */
    public Decimal get高額介護サービス費保険者負担額() {
        return entity.get高額介護サービス費保険者負担額();
    }

    /**
     * 特定入所者介護サービス費等件数を取得します。
     *
     * @return 特定入所者介護サービス費等件数
     */
    public int get特定入所者介護サービス費等件数() {
        return entity.get特定入所者介護サービス費等件数();
    }

    /**
     * 特定入所者介護サービス費等費用額を取得します。
     *
     * @return 特定入所者介護サービス費等費用額
     */
    public Decimal get特定入所者介護サービス費等費用額() {
        return entity.get特定入所者介護サービス費等費用額();
    }

    /**
     * 特定入所者介護サービス費等保険者負担額を取得します。
     *
     * @return 特定入所者介護サービス費等保険者負担額
     */
    public Decimal get特定入所者介護サービス費等保険者負担額() {
        return entity.get特定入所者介護サービス費等保険者負担額();
    }

    /**
     * 公費負担者番号を取得します。
     *
     * @return 公費負担者番号
     */
    public RString get公費負担者番号() {
        return entity.get公費負担者番号();
    }

    /**
     * 作成年月日を取得します。
     *
     * @return 作成年月日
     */
    public FlexibleDate get作成年月日() {
        return entity.get作成年月日();
    }

    /**
     * 取込年月を取得します。
     *
     * @return 取込年月
     */
    public FlexibleYearMonth get取込年月() {
        return entity.get取込年月();
    }

    /**
     * 取扱年月_明細を取得します。
     *
     * @return 取扱年月_明細
     */
    public FlexibleYearMonth get取扱年月_明細() {
        return entity.get取扱年月_明細();
    }

    /**
     * 保険者区分_明細を取得します。
     *
     * @return 保険者区分_明細
     */
    public RString get保険者区分_明細() {
        return entity.get保険者区分_明細();
    }

    /**
     * 履歴番号_明細を取得します。
     *
     * @return 履歴番号_明細
     */
    public int get履歴番号_明細() {
        return entity.get履歴番号_明細();
    }

    /**
     * 事業所番号を取得します。
     *
     * @return 事業所番号
     */
    public JigyoshaNo get事業所番号() {
        return entity.get事業所番号();
    }

    /**
     * 事業所名を取得します。
     *
     * @return 事業所名
     */
    public RString get事業所名() {
        return entity.get事業所名();
    }

    /**
     * 被保険者番号を取得します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return entity.get被保険者番号();
    }

    /**
     * 公費受給者番号を取得します。
     *
     * @return 公費受給者番号
     */
    public RString get公費受給者番号() {
        return entity.get公費受給者番号();
    }

    /**
     * 証記載保険者番号を取得します。
     *
     * @return 証記載保険者番号
     */
    public HokenshaNo get証記載保険者番号() {
        return entity.get証記載保険者番号();
    }

    /**
     * サービス提供年月を取得します。
     *
     * @return サービス提供年月
     */
    public FlexibleYearMonth getサービス提供年月() {
        return entity.getサービス提供年月();
    }

    /**
     * サービス種類コードを取得します。
     *
     * @return サービス種類コード
     */
    public ServiceShuruiCode getサービス種類コード() {
        return entity.getサービス種類コード();
    }

    /**
     * サービス種類名を取得します。
     *
     * @return サービス種類名
     */
    public RString getサービス種類名() {
        return entity.getサービス種類名();
    }

    /**
     * 過誤申立事由コードを取得します。
     *
     * @return 過誤申立事由コード
     */
    public Code get過誤申立事由コード() {
        return entity.get過誤申立事由コード();
    }

    /**
     * 過誤申立事由を取得します。
     *
     * @return 過誤申立事由
     */
    public RString get過誤申立事由() {
        return entity.get過誤申立事由();
    }

    /**
     * 単位数を取得します。
     *
     * @return 単位数
     */
    public Decimal get単位数() {
        return entity.get単位数();
    }

    /**
     * 保険者負担額を取得します。
     *
     * @return 保険者負担額
     */
    public Decimal get保険者負担額() {
        return entity.get保険者負担額();
    }

    /**
     * コード略称を取得します。
     *
     * @return コード略称
     */
    public RString getコード略称() {
        return entity.getコード略称();
    }

    /**
     * 取込年月_明細を取得します。
     *
     * @return 取込年月_明細
     */
    public FlexibleYearMonth get取込年月_明細() {
        return entity.get取込年月_明細();
    }

    /**
     * 保険者区分_再を取得します。
     *
     * @return 保険者区分_再
     */
    public RString get保険者区分_再() {
        return entity.get保険者区分_再();
    }

    /**
     * 履歴番号_再を取得します。
     *
     * @return 履歴番号_再
     */
    public Decimal get履歴番号_再() {
        return entity.get履歴番号_再();
    }
}
