/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.common;

import jp.co.ndensan.reams.db.dbd.definition.enumeratedtype.core.JukyuShinseiJiyu;
import jp.co.ndensan.reams.db.dbd.definition.enumeratedtype.core.ShinseiJokyoKubun;
import jp.co.ndensan.reams.db.dbd.entity.common.NursingCareInformationEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.IYokaigoJotaiKubun;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 *
 * 要介護認定情報を管理するクラスです。
 */
public class NursingCareInformationBusiness {

    private final NursingCareInformationEntity entity;

    /**
     * 要介護認定情報を返します。
     *
     * @param entity NursingCareInformationEntity
     */
    public NursingCareInformationBusiness(NursingCareInformationEntity entity) {
        this.entity = entity;
    }

    /**
     * 申請状況区分を返します。
     *
     * @return 申請状況区分
     */
    public ShinseiJokyoKubun get申請状況区分() {
        return entity.get申請状況区分();
    }

    /**
     * 受給申請年月日を返します。
     *
     * @return 受給申請年月日
     */
    public FlexibleDate get受給申請年月日() {
        return entity.get受給申請年月日();
    }

    /**
     * 認定年月日を返します。
     *
     * @return 認定年月日
     */
    public FlexibleDate get認定年月日() {
        return entity.get認定年月日();
    }

    /**
     * 認定有効期間終了年月日を返します。
     *
     * @return 認定有効期間終了年月日
     */
    public FlexibleDate get認定有効期間終了年月日() {
        return entity.get認定有効期間終了年月日();
    }

    /**
     * 認定有効期間開始年月日を返します。
     *
     * @return 認定有効期間開始年月日
     */
    public FlexibleDate get認定有効期間開始年月日() {
        return entity.get認定有効期間開始年月日();
    }

    /**
     * 受給申請事由を返します。
     *
     * @return 受給申請事由
     */
    public JukyuShinseiJiyu get受給申請事由() {
        return entity.get受給申請事由();
    }

    /**
     * 要介護度を返します。
     *
     * @return 要介護度
     */
    public IYokaigoJotaiKubun get要介護度() {
        return entity.get要介護度();
    }

    /**
     * 旧措置者フラグを返します。
     *
     * @return 旧措置者フラグ
     */
    public boolean is旧措置者フラグ() {
        return entity.is旧措置者フラグ();
    }

}
