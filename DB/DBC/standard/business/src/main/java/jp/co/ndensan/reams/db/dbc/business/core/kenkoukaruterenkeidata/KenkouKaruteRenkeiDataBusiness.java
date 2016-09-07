/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kenkoukaruterenkeidata;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kenkoukaruterenkeidata.KenkouKaruteRenkeiDataEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 健康かるて連携データ作成のbusinessです。
 *
 * @reamsid_L DBC-5020-040 zhaoyao
 */
public class KenkouKaruteRenkeiDataBusiness {

    private final KenkouKaruteRenkeiDataEntity entity;

    /**
     * コンストラクタです
     *
     * @param entity 健康かるて連携データ作成のEntit
     */
    public KenkouKaruteRenkeiDataBusiness(KenkouKaruteRenkeiDataEntity entity) {
        this.entity = entity;
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
     * 異動日を取得します。
     *
     * @return 異動日
     */
    public FlexibleDate get異動日() {
        return entity.get異動日();
    }

    /**
     * 市町村コードを取得します。
     *
     * @return 市町村コード
     */
    public RString get市町村コード() {
        return entity.get市町村コード();
    }

    /**
     * 識別コードを取得します。
     *
     * @return 識別コード
     */
    public RString get識別コード() {
        return entity.get識別コード();
    }

    /**
     * 資格取得年月日を取得します。
     *
     * @return 異動日
     */
    public FlexibleDate get資格取得年月日() {
        return entity.get資格取得年月日();
    }

    /**
     * 資格喪失年月日を取得します。
     *
     * @return 資格喪失年月日
     */
    public FlexibleDate get資格喪失年月日() {
        return entity.get資格喪失年月日();
    }

    /**
     * 論理削除フラグを取得します。
     *
     * @return 論理削除フラグ
     */
    public boolean is論理削除フラグ() {
        return entity.is論理削除フラグ();
    }

    /**
     * 業務コードを取得します。
     *
     * @return 業務コード
     */
    public RString get業務コード() {
        return entity.get業務コード();
    }

    /**
     * 住民種別コードを取得します。
     *
     * @return 住民種別コード
     */
    public RString get住民種別コード() {
        return entity.get住民種別コード();
    }

    /**
     * 住民状態コードを取得します。
     *
     * @return 住民状態コード
     */
    public RString get住民状態コード() {
        return entity.get住民状態コード();
    }

    /**
     * 名称を取得します。
     *
     * @return 名称
     */
    public RString get名称() {
        return entity.get名称();
    }

    /**
     * カナ名称を取得します。
     *
     * @return カナ名称
     */
    public RString getカナ名称() {
        return entity.getカナ名称();
    }

    /**
     * 個人番号を取得します。
     *
     * @return 個人番号
     */
    public RString get個人番号() {
        return entity.get個人番号();
    }

    /**
     * 生年月日を取得します。
     *
     * @return 生年月日
     */
    public FlexibleDate get生年月日() {
        return entity.get生年月日();
    }

    /**
     * 性別を取得します。
     *
     * @return 性別
     */
    public RString get性別() {
        return entity.get性別();
    }

    /**
     * 履歴番号を取得します。
     *
     * @return 履歴番号
     */
    public RString get履歴番号() {
        return entity.get履歴番号();
    }

    /**
     * 枝番を取得します。
     *
     * @return 枝番
     */
    public RString get枝番() {
        return entity.get枝番();
    }

    /**
     * 要介護認定状態区分コードを取得します。
     *
     * @return 要介護認定状態区分コード
     */
    public RString get要介護認定状態区分コード() {
        return entity.get要介護認定状態区分コード();
    }

    /**
     * 認定年月日を取得します。
     *
     * @return 認定年月日
     */
    public FlexibleDate get認定年月日() {
        return entity.get認定年月日();
    }

    /**
     * 喪失年月日を取得します。
     *
     * @return 喪失年月日
     */
    public FlexibleDate get喪失年月日() {
        return entity.get喪失年月日();
    }

    /**
     * 認定有効期間開始年月日を取得します。
     *
     * @return 認定有効期間開始年月日
     */
    public FlexibleDate get認定有効期間開始年月日() {
        return entity.get認定有効期間開始年月日();
    }

    /**
     * 認定有効期間終了年月日を取得します。
     *
     * @return 認定有効期間終了年月日
     */
    public FlexibleDate get認定有効期間終了年月日() {
        return entity.get認定有効期間終了年月日();
    }
}
