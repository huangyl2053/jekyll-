/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.soufujouhou;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.soufujouhou.SoufuJouhouRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 再審査申立送付情報照会を取得するクラスです。
 *
 * @reamsid_L DBC-3050-010 zhangzhiming
 */
public class SoufuJouhouBusiness {

    private final SoufuJouhouRelateEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity 再審査申立情報RelateEntity
     */
    public SoufuJouhouBusiness(SoufuJouhouRelateEntity entity) {
        this.entity = entity;
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
     * サービス項目コードを取得します。
     *
     * @return サービス項目コード
     */
    public RString getサービス項目コード() {
        return entity.getサービス項目コード();
    }

    /**
     * サービス略称を取得します。
     *
     * @return サービス略称
     */
    public RString getサービス略称() {
        return entity.getサービス略称();
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
     * 申立年月日を取得します。
     *
     * @return 申立年月日
     */
    public RString get申立年月日() {
        return entity.get申立年月日();
    }

    /**
     * 申立者区分コードを取得します。
     *
     * @return 申立者区分コード
     */
    public RString get申立者区分コード() {
        return entity.get申立者区分コード();
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
     * 申立事由コードを取得します。
     *
     * @return 申立事由コード
     */
    public RString get申立事由コード() {
        return entity.get申立事由コード();
    }
}
