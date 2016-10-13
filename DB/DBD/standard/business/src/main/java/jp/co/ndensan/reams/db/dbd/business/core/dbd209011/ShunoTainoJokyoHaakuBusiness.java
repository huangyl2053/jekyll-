/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.dbd209011;

import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4022ShiharaiHohoHenkoTainoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakulist.ShunoTainoJokyoHaakuEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakulist.temptable.ShunoJokyoTempTableEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakulist.temptable.ShunoTainoJokyoTempTableEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.taino.JikoKubun;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 収納滞納状況把握情報の取得_ビジネス処理クラスです．
 *
 * @reamsid_L DBD-3610-050 x_miaocl
 */
public class ShunoTainoJokyoHaakuBusiness {

    /**
     * 収納滞納状況把握情報を編集します。
     *
     * @param entity 収納滞納状況把握情報
     * @param 基準日 基準日
     * @param 最古の滞納納期限 最古の滞納納期限
     * @return 収納滞納状況一時テーブルEntity
     */
    public ShunoTainoJokyoTempTableEntity edit収納滞納状況把握情報(ShunoTainoJokyoHaakuEntity entity,
            FlexibleDate 基準日, RDate 最古の滞納納期限) {

        ShunoTainoJokyoTempTableEntity insertEntity = new ShunoTainoJokyoTempTableEntity();
        ShunoJokyoTempTableEntity 収納状況TmpTblEntity = entity.get収納状況TmpTblEntity();

        insertEntity.setTmp_hihokenshaNo(収納状況TmpTblEntity.getTmp_hihokenshaNo());
        insertEntity.setTmp_choteiNendo(収納状況TmpTblEntity.getTmp_choteiNendo());
        insertEntity.setTmp_fukaNendo(収納状況TmpTblEntity.getTmp_fukaNendo());
        insertEntity.setTmp_tokucho_fuchoKubun(収納状況TmpTblEntity.getTmp_tokucho_fuchoKubun());
        insertEntity.setTmp_tsuchishoNo(収納状況TmpTblEntity.getTmp_tsuchishoNo());
        insertEntity.setTmp_kibetsu(収納状況TmpTblEntity.getTmp_kibetsu());
        insertEntity.setTmp_choteigaku(収納状況TmpTblEntity.getTmp_choteigaku());
        insertEntity.setTmp_shunyugaku(収納状況TmpTblEntity.getTmp_shunyugaku());
        insertEntity.setTmp_minogaku(収納状況TmpTblEntity.getTmp_minogaku());
        insertEntity.setTmp_shunyuYMD(収納状況TmpTblEntity.getTmp_shunyuYMD());
        insertEntity.setTmp_tokusokujoHakkoYMD(収納状況TmpTblEntity.getTmp_tokusokujoHakkoYMD());
        insertEntity.setTmp_jikoKisanYMD(収納状況TmpTblEntity.getTmp_jikoKisanYMD());
        insertEntity.setTmp_jikoKisanJiyu(収納状況TmpTblEntity.getTmp_jikoKisanJiyu());
        insertEntity.setTmp_minoKannoKubun(収納状況TmpTblEntity.getTmp_minoKannoKubun());
        insertEntity.setTmp_jikoKubun(収納状況TmpTblEntity.getTmp_jikoKubun());

        RString 滞納区分 = RString.EMPTY;
        DbT4022ShiharaiHohoHenkoTainoEntity 支払方法変更滞納Entity = entity.get支払方法変更滞納Entity();
        if (支払方法変更滞納Entity != null) {
            if (JikoKubun.時効未到来.getコード().equals(支払方法変更滞納Entity.getJikoKubun())
                    && JikoKubun.時効到来.getコード().equals(収納状況TmpTblEntity.getTmp_jikoKubun())) {
                滞納区分 = new RString("2");

            } else if (JikoKubun.時効到来.getコード().equals(支払方法変更滞納Entity.getJikoKubun())) {
                if (最古の滞納納期限 != null && 最古の滞納納期限.equals(収納状況TmpTblEntity.getTmp_nokigen())) {
                    滞納区分 = new RString("3");
                } else {
                    滞納区分 = new RString("1");
                }
            } else if (基準日.isBeforeOrEquals(支払方法変更滞納Entity.getNokigen())) {
                滞納区分 = new RString("4");
            }
            insertEntity.setTmp_tainoKubun(滞納区分);
        }
        return insertEntity;
    }

}
