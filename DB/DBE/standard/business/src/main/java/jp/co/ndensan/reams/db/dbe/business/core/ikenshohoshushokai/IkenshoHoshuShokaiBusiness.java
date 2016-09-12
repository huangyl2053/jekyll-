/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ikenshohoshushokai;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.ikenshohoshushokai.IkenshoHoshuShokaiRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 意見書作成報酬照会のBusinessクラスです。
 *
 * @reamsid_L DBE-1930-010 chenxiangyu
 */
public class IkenshoHoshuShokaiBusiness {

    private final IkenshoHoshuShokaiRelateEntity entity;

    /**
     * 意見書作成報酬照会項目を返します。
     *
     * @param entity IkenshoHoshuShokaiRelateEntity
     */
    public IkenshoHoshuShokaiBusiness(IkenshoHoshuShokaiRelateEntity entity) {
        this.entity = entity;
    }

    /**
     * 主治医コードを取得します。
     *
     * @return 主治医コード
     */
    public RString get主治医コード() {
        return entity.get主治医コード();
    }

    /**
     * 主治医医療機関コードを取得します。
     *
     * @return 主治医医療機関コード
     */
    public RString get主治医医療機関コード() {
        return entity.get主治医医療機関コード();
    }

    /**
     * 主治医意見書依頼区分を取得します。
     *
     * @return 主治医意見書依頼区分
     */
    public RString get主治医意見書依頼区分() {
        return entity.get主治医意見書依頼区分();
    }

    /**
     * 主治医氏名を取得します。
     *
     * @return 主治医氏名
     */
    public RString get主治医氏名() {
        return entity.get主治医氏名();
    }

    /**
     * 医療機関名称を取得します。
     *
     * @return 医療機関名称
     */
    public RString get医療機関名称() {
        return entity.get医療機関名称();
    }

    /**
     * 在宅_新を取得します。
     *
     * @return 在宅_新
     */
    public RString get在宅_新() {
        return entity.get在宅_新();
    }

    /**
     * 在宅_継を取得します。
     *
     * @return 在宅_継
     */
    public RString get在宅_継() {
        return entity.get在宅_継();
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
     * 施設_新を取得します。
     *
     * @return 施設_新
     */
    public RString get施設_新() {
        return entity.get施設_新();
    }

    /**
     * 施設_継を取得します。
     *
     * @return 施設_継
     */
    public RString get施設_継() {
        return entity.get施設_継();
    }

    /**
     * 申請書管理番号を取得します。
     *
     * @return 申請書管理番号
     */
    public RString get申請書管理番号() {
        return entity.get申請書管理番号();
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
     * 被保険者番号を取得します。
     *
     * @return 被保険者番号
     */
    public RString get被保険者番号() {
        return entity.get被保険者番号();
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
     * 主治医意見書作成依頼履歴番号を取得します。
     *
     * @return 主治医意見書作成依頼履歴番号
     */
    public int get主治医意見書作成依頼履歴番号() {
        return entity.get主治医意見書作成依頼履歴番号();
    }

    /**
     * 主治医意見書作成料を取得します。
     *
     * @return 主治医意見書作成料
     */
    public int get主治医意見書作成料() {
        return entity.get主治医意見書作成料();
    }

    /**
     * 主治医意見書別途診療費を取得します。
     *
     * @return 主治医意見書別途診療費
     */
    public int get主治医意見書別途診療費() {
        return entity.get主治医意見書別途診療費();
    }

    /**
     * 主治医意見書報酬を取得します。
     *
     * @return 主治医意見書報酬
     */
    public int get主治医意見書報酬() {
        return entity.get主治医意見書報酬();
    }

    /**
     * 主治医意見書作成依頼年月日を取得します。
     *
     * @return 主治医意見書作成依頼年月日
     */
    public FlexibleDate get主治医意見書作成依頼年月日() {
        return entity.get主治医意見書作成依頼年月日();
    }

    /**
     * 主治医意見書受領年月日を取得します。
     *
     * @return 主治医意見書受領年月日
     */
    public FlexibleDate get主治医意見書受領年月日() {
        return entity.get主治医意見書受領年月日();
    }

    /**
     * 主治医意見書記入年月日を取得します。
     *
     * @return 主治医意見書記入年月日
     */
    public FlexibleDate get主治医意見書記入年月日() {
        return entity.get主治医意見書記入年月日();
    }
}
