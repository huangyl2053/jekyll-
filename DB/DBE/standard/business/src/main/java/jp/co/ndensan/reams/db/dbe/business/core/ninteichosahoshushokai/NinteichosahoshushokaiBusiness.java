/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteichosahoshushokai;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosahoshushokai.NinteiChosaHoshuShokaiRelateEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査報酬照会のBusinessクラスです。
 *
 * @reamsid_L DBE-1940-010 jinjue
 */
public class NinteichosahoshushokaiBusiness {

    private final NinteiChosaHoshuShokaiRelateEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity NinteiChosaHoshuShokaiRelateEntity
     */
    public NinteichosahoshushokaiBusiness(NinteiChosaHoshuShokaiRelateEntity entity) {
        this.entity = entity;
    }

    /**
     * 認定調査委託先コードを取得します。
     *
     * @return 認定調査委託先コード
     */
    public RString get認定調査委託先コード() {
        return entity.get認定調査委託先コード();
    }

    /**
     * 事業者名称を取得します。
     *
     * @return 事業者名称
     */
    public RString get事業者名称() {
        return entity.get事業者名称();
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
     * 認定調査員コードを取得します。
     *
     * @return 認定調査員コード
     */
    public RString get認定調査員コード() {
        return entity.get認定調査員コード();
    }

    /**
     * 調査員氏名を取得します。
     *
     * @return 調査員氏名
     */
    public RString get調査員氏名() {
        return entity.get調査員氏名();
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
     * 被保険者氏名を取得します。
     *
     * @return 被保険者氏名
     */
    public AtenaMeisho get被保険者氏名() {
        return entity.get被保険者氏名();
    }

    /**
     * 認定調査依頼区分コードを取得します。
     *
     * @return 認定調査依頼区分コード
     */
    public Code get認定調査依頼区分コード() {
        return entity.get認定調査依頼区分コード();
    }

    /**
     * 認定調査区分コードを取得します。
     *
     * @return 認定調査区分コード
     */
    public Code get認定調査区分コード() {
        return entity.get認定調査区分コード();
    }

    /**
     * 認定調査実施場所コードを取得します。
     *
     * @return 認定調査実施場所コード
     */
    public Code get認定調査実施場所コード() {
        return entity.get認定調査実施場所コード();
    }

    /**
     * 認定調査依頼年月日を取得します。
     *
     * @return 認定調査依頼年月日
     */
    public FlexibleDate get認定調査依頼年月日() {
        return entity.get認定調査依頼年月日();
    }

    /**
     * 認定調査受領年月日を取得します。
     *
     * @return 認定調査受領年月日
     */
    public FlexibleDate get認定調査受領年月日() {
        return entity.get認定調査受領年月日();
    }

    /**
     * 認定調査実施年月日を取得します。
     *
     * @return 認定調査実施年月日
     */
    public FlexibleDate get認定調査実施年月日() {
        return entity.get認定調査実施年月日();
    }

    /**
     * 認定調査委託料を取得します。
     *
     * @return 認定調査委託料
     */
    public int get認定調査委託料() {
        return entity.get認定調査委託料();
    }

    /**
     * 認定調査依頼履歴番号を取得します。
     *
     * @return 認定調査依頼履歴番号
     */
    public int get認定調査依頼履歴番号() {
        return entity.get認定調査依頼履歴番号();
    }

    /**
     * 申請書管理番号を取得します。
     *
     * @return 申請書管理番号
     */
    public ShinseishoKanriNo get申請書管理番号() {
        return entity.get申請書管理番号();
    }

    /**
     * 市町村名称を取得します。
     *
     * @return 市町村名称
     */
    public RString get市町村名称() {
        return entity.get市町村名称();
    }
}
