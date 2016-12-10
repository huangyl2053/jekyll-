/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shujiiikenshoirai;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiiikenshoirai.ShujiiIkenshoIraiEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査の情報インターフェースです。
 *
 * @reamsid_L DBE-0200-030 zhangzhiming
 */
public class ShujiiIkenshoIraiBusiness {

    private final ShujiiIkenshoIraiEntity entity;

    /**
     * コンストラクタです.
     *
     * @param entity 認定調査Entity
     */
    public ShujiiIkenshoIraiBusiness(ShujiiIkenshoIraiEntity entity) {
        this.entity = entity;
    }

    /**
     * 認定申請日を取得します。
     *
     * @return 認定申請日
     */
    public FlexibleDate getNinteiShinseiYMD() {
        return entity.getNinteiShinseiYMD();
    }

    /**
     * 申請区分（申請時）を取得します。
     *
     * @return 申請区分（申請時）
     */
    public Code getNinteiShinseiCode() {
        return entity.getNinteiShinseiCode();
    }

    /**
     * 取下年月日を取得します。
     *
     * @return 取下年月日
     */
    public FlexibleDate getTorisageYMD() {
        return entity.getTorisageYMD();
    }

    /**
     * 二次判定年月日を取得します。
     *
     * @return 二次判定年月日
     */
    public FlexibleDate getNijiHanteiYMD() {
        return entity.getNijiHanteiYMD();
    }

    /**
     * 二次判定要介護状態区分コードを取得します。
     *
     * @return 二次判定要介護状態区分コード
     */
    public Code getNijiHanteiYokaigoJotaiCode() {
        return entity.getNijiHanteiYokaigoJotaiCode();
    }

    /**
     * 二次判定認定有効期間を取得します。
     *
     * @return 二次判定認定有効期間
     */
    public int getNijiHanteiNinteiYukoKikan() {
        return entity.getNijiHanteiNinteiYukoKikan();
    }

    /**
     * 主治医医療機関コードを取得します。
     *
     * @return 主治医医療機関コード
     */
    public RString getShujiiIryokikanCode() {
        return entity.getShujiiIryokikanCode();
    }

    /**
     * 医療機関名称を取得します。
     *
     * @return 医療機関名称
     */
    public RString getIryoKikanMeisho() {
        return entity.getIryoKikanMeisho();
    }

    /**
     * 主治医コードを取得します。
     *
     * @return 主治医コード
     */
    public RString getShujiiCode() {
        return entity.getShujiiCode();
    }

    /**
     * 主治医氏名を取得します。
     *
     * @return 主治医氏名
     */
    public AtenaMeisho getShujiiName() {
        return entity.getShujiiName();
    }

    /**
     * 主治医意見書受領年月日を取得します。
     *
     * @return 主治医意見書受領年月日
     */
    public FlexibleDate getIkenshoJuryoYMD() {
        return entity.getIkenshoJuryoYMD();
    }

    /**
     * 主治医意見書記入年月日を取得します。
     *
     * @return 主治医意見書記入年月日
     */
    public FlexibleDate getIkenshoKinyuYMD() {
        return entity.getIkenshoKinyuYMD();
    }

    /**
     * 主治医意見書依頼区分を取得します。
     *
     * @return 主治医意見書依頼区分
     */
    public RString getIkenshoIraiKubun() {
        return entity.getIkenshoIraiKubun();
    }
}
