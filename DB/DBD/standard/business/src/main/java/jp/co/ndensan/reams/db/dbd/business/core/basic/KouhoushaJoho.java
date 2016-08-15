/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.basic;

import java.util.UUID;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kouhoushajoho.KouhoushaJohoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.ua.uax.business.core.findshikibetsutaisho.FindShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 候補者情報クラスです。
 *
 * @reamsid_L DBD-3530-060 liuyl
 */
public class KouhoushaJoho {

    private final KouhoushaJohoEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity KouhoushaJohoEntity
     */
    public KouhoushaJoho(KouhoushaJohoEntity entity) {
        this.entity = entity;
    }

    /**
     * 把握処理IDを取得です。
     *
     * @return 把握処理ID
     */
    public UUID get把握処理ID() {
        return entity.get把握処理ID();
    }

    /**
     * 更新認定フラグを取得です。
     *
     * @return 更新認定フラグ
     */
    public boolean get更新認定フラグ() {
        return entity.is更新認定フラグ();
    }

    /**
     * 被保険者番号を取得です。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return entity.get被保険者番号();
    }

    /**
     * 識別コードを取得です。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return entity.get識別コード();
    }

    /**
     * 世帯課税を取得です。
     *
     * @return 世帯課税
     */
    public RString get世帯課税() {
        return entity.get世帯課税();
    }

    /**
     * 市町村コードを取得です。
     *
     * @return 市町村コード
     */
    public LasdecCode get市町村コード() {
        return entity.get市町村コード();
    }

    /**
     * 老福を取得です。
     *
     * @return 老福
     */
    public boolean get老福() {
        return entity.is生保();
    }

    /**
     * 生保を取得です。
     *
     * @return 生保
     */
    public boolean get生保() {
        return entity.is生保();
    }

    /**
     * 旧措置を取得です。
     *
     * @return 旧措置
     */
    public boolean get旧措置() {
        return entity.is旧措置();
    }

    /**
     * 要介護認定状態区分コードを取得です。
     *
     * @return 要介護認定状態区分コード
     */
    public Code get要介護認定状態区分コード() {
        return entity.get要介護認定状態区分コード();
    }

    /**
     * 厚労省IF識別コードを取得です。
     *
     * @return 厚労省IF識別コード
     */
    public Code get厚労省IF識別コード() {
        return entity.get厚労省IF識別コード();
    }

    /**
     * 認定開始日を取得です。
     *
     * @return 認定開始日
     */
    public FlexibleDate get認定開始日() {
        return entity.get認定開始日();
    }

    /**
     * 認定終了日を取得です。
     *
     * @return 認定終了日
     */
    public FlexibleDate get認定終了日() {
        return entity.get認定終了日();
    }

    /**
     * 利用者負担段階を取得です。
     *
     * @return 利用者負担段階
     */
    public RString get利用者負担段階() {
        return entity.get利用者負担段階();
    }

    /**
     * 事業者番号を取得です。
     *
     * @return 事業者番号
     */
    public JigyoshaNo get事業者番号() {
        return entity.get事業者番号();
    }

    /**
     * 合計所得金額を取得です。
     *
     * @return 合計所得金額
     */
    public Decimal get合計所得金額() {
        return entity.get合計所得金額();
    }

    /**
     * 年金収入額を取得です。
     *
     * @return 年金収入額
     */
    public Decimal get年金収入額() {
        return entity.get年金収入額();
    }

    /**
     * 非課税年金勘案額を取得です。
     *
     * @return 非課税年金勘案額
     */
    public Decimal get非課税年金勘案額() {
        return entity.get非課税年金勘案額();
    }

    /**
     * 宛名識別対象を取得です。
     *
     * @return 宛名識別対象
     */
    public FindShikibetsuTaisho get宛名識別対象() {
        FindShikibetsuTaisho result = new FindShikibetsuTaisho(entity.getEntity(), ShikibetsuTaishoFactory.createKojin(entity.getEntity()));
        return result;
    }
}
