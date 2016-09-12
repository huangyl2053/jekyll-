/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.saisinsaketeijyohou;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.saisinsaketeijyohou.TaishoshaKensakuRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 高額介護サービス費照会を取得するクラスです。
 *
 * @reamsid_L DBC-3040-010 zhangzhiming
 */
public class TaishoshaKensakuBusiness {

    private final TaishoshaKensakuRelateEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity 再審査決定情報RelateEntity
     */
    public TaishoshaKensakuBusiness(TaishoshaKensakuRelateEntity entity) {
        this.entity = entity;
    }

    /**
     * 作成年月日を取得します。
     *
     * @return 作成年月日
     */
    public RString get作成年月日() {
        return entity.get作成年月日();
    }

    /**
     * 審査委員会名を取得します。
     *
     * @return 審査委員会名
     */
    public RString get審査委員会名() {
        return entity.get審査委員会名();
    }

    /**
     * 履歴番号を取得します。
     *
     * @return 履歴番号
     */
    public int get履歴番号() {
        return entity.get履歴番号();
    }

    /**
     * 介護請求件数を取得します。
     *
     * @return 介護請求件数
     */
    public int get介護請求件数() {
        return entity.get介護請求件数();
    }

    /**
     * 介護決定件数を取得します。
     *
     * @return 介護決定件数
     */
    public int get介護決定件数() {
        return entity.get介護決定件数();
    }

    /**
     * 介護調整件数を取得します。
     *
     * @return 介護調整件数
     */
    public int get介護調整件数() {
        return entity.get介護調整件数();
    }

    /**
     * 介護請求単位を取得します。
     *
     * @return 介護請求単位
     */
    public Decimal get介護請求単位() {
        return entity.get介護請求単位();
    }

    /**
     * 介護決定単位を取得します。
     *
     * @return 介護決定単位
     */
    public Decimal get介護決定単位() {
        return entity.get介護決定単位();
    }

    /**
     * 介護調整単位を取得します。
     *
     * @return 介護調整単位
     */
    public Decimal get介護調整単位() {
        return entity.get介護調整単位();
    }

    /**
     * 介護請求保険者負担額を取得します。
     *
     * @return 介護請求保険者負担額
     */
    public Decimal get介護請求保険者負担額() {
        return entity.get介護請求保険者負担額();
    }

    /**
     * 介護決定保険者負担額を取得します。
     *
     * @return 介護決定保険者負担額
     */
    public Decimal get介護決定保険者負担額() {
        return entity.get介護決定保険者負担額();
    }

    /**
     * 介護調整保険者負担額を取得します。
     *
     * @return 介護調整保険者負担額
     */
    public Decimal get介護調整保険者負担額() {
        return entity.get介護調整保険者負担額();
    }

    /**
     * 高額請求件数を取得します。
     *
     * @return 高額請求件数
     */
    public int get高額請求件数() {
        return entity.get高額請求件数();
    }

    /**
     * 高額決定件数を取得します。
     *
     * @return 高額決定件数
     */
    public int get高額決定件数() {
        return entity.get高額決定件数();
    }

    /**
     * 高額調整件数を取得します。
     *
     * @return 高額調整件数
     */
    public int get高額調整件数() {
        return entity.get高額調整件数();
    }

    /**
     * 高額請求単位を取得します。
     *
     * @return 高額請求単位
     */
    public Decimal get高額請求単位() {
        return entity.get高額請求単位();
    }

    /**
     * 高額決定単位を取得します。
     *
     * @return 高額決定単位
     */
    public Decimal get高額決定単位() {
        return entity.get高額決定単位();
    }

    /**
     * 高額調整単位を取得します。
     *
     * @return 高額調整単位
     */
    public Decimal get高額調整単位() {
        return entity.get高額調整単位();
    }

    /**
     * 高額請求保険者負担額を取得します。
     *
     * @return 高額請求保険者負担額
     */
    public Decimal get高額請求保険者負担額() {
        return entity.get高額請求保険者負担額();
    }

    /**
     * 高額決定保険者負担額を取得します。
     *
     * @return 高額決定保険者負担額
     */
    public Decimal get高額決定保険者負担額() {
        return entity.get高額決定保険者負担額();
    }

    /**
     * 高額調整保険者負担額を取得します。
     *
     * @return 高額調整保険者負担額
     */
    public Decimal get高額調整保険者負担額() {
        return entity.get高額調整保険者負担額();
    }

    /**
     * 事業所番号を取得します。
     *
     * @return 事業所番号
     */
    public RString get事業所番号() {
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
    public RString get被保険者番号() {
        return entity.get被保険者番号();
    }

    /**
     * 宛名名称を取得します。
     *
     * @return 宛名名称
     */
    public RString get宛名名称() {
        return entity.get宛名名称();
    }

    /**
     * 申立事由コードを取得します。
     *
     * @return 申立事由コード
     */
    public RString get申立事由コード() {
        return entity.get申立事由コード();
    }

    /**
     * コード名称を取得します。
     *
     * @return コード名称
     */
    public RString getコード名称() {
        return entity.getコード名称();
    }

    /**
     * 再審査申立事由を取得します。
     *
     * @return 再審査申立事由
     */
    public RString get再審査申立事由() {
        return entity.get再審査申立事由();
    }

    /**
     * サービス提供年月を取得します。
     *
     * @return サービス提供年月
     */
    public RString getサービス提供年月() {
        return entity.getサービス提供年月();
    }

    /**
     * サービス種類コードを取得します。
     *
     * @return サービス種類コード
     */
    public RString getサービス種類コード() {
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
     * 再審査結果コードを取得します。
     *
     * @return 再審査結果コード
     */
    public RString get再審査結果コード() {
        return entity.get再審査結果コード();
    }

    /**
     * 当初請求単位数を取得します。
     *
     * @return 当初請求単位数
     */
    public RString get当初請求単位数() {
        return entity.get当初請求単位数();
    }

    /**
     * 原審単位数を取得します。
     *
     * @return 原審単位数
     */
    public RString get原審単位数() {
        return entity.get原審単位数();
    }

    /**
     * 申立単位数を取得します。
     *
     * @return 申立単位数
     */
    public RString get申立単位数() {
        return entity.get申立単位数();
    }

    /**
     * 決定単位数を取得します。
     *
     * @return 決定単位数
     */
    public RString get決定単位数() {
        return entity.get決定単位数();
    }

    /**
     * 調整単位数を取得します。
     *
     * @return 調整単位数
     */
    public RString get調整単位数() {
        return entity.get調整単位数();
    }

    /**
     * 保険者負担額を取得します。
     *
     * @return 保険者負担額
     */
    public RString get保険者負担額() {
        return entity.get保険者負担額();
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
    public RString get証記載保険者番号() {
        return entity.get証記載保険者番号();
    }

    /**
     * 保険者区分を取得します。
     *
     * @return 保険者区分
     */
    public RString get保険者区分() {
        return entity.get保険者区分();
    }
}
