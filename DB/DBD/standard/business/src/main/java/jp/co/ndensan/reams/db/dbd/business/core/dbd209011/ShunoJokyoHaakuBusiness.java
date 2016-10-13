/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.dbd209011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.ca.cax.entity.db.basic.CaT0701ShunyuEntity;
import jp.co.ndensan.reams.db.dbd.definition.core.jikokisanbikanri.JikoKisanbiKubun;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakulist.KibetsuJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakulist.ShunoJokyoHaakuEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakulist.temptable.ShunoJokyoTempTableEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.UrT0705ChoteiKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.taino.JikoKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.taino.MinoKannoKubun;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 収納状況把握情報の取得_ビジネス処理クラスです．
 *
 * @reamsid_L DBD-3610-050 x_miaocl
 */
public class ShunoJokyoHaakuBusiness {

    /**
     * 収納状況一時テーブルのデータを編集します。
     *
     * @param shunoJokyoEntity 収納状況一時テーブルのデータ
     * @param 基準日 基準日
     * @return 収納状況一時テーブルのデータ
     */
    public List<ShunoJokyoTempTableEntity> edit収納状況把握情報(ShunoJokyoHaakuEntity shunoJokyoEntity, FlexibleDate 基準日) {
        List<ShunoJokyoTempTableEntity> insertEnList = new ArrayList<>();

        HihokenshaNo 被保険者番号 = shunoJokyoEntity.get資格情報Entity().getHihokenshaNo();
        FlexibleYear 賦課年度 = shunoJokyoEntity.get収納情報().get賦課Entity().getFukaNendo();
        FlexibleYear 調定年度 = shunoJokyoEntity.get収納情報().get賦課Entity().getChoteiNendo();

        List<KibetsuJohoEntity> 期別情報List = shunoJokyoEntity.get収納情報().get期別();
        if (null == 期別情報List || 期別情報List.isEmpty()) {
            return null;
        }
        ShunoJokyoTempTableEntity tmpTblEntity = new ShunoJokyoTempTableEntity();
        tmpTblEntity.setTmp_hihokenshaNo(被保険者番号);
        tmpTblEntity.setTmp_choteiNendo(調定年度);
        tmpTblEntity.setTmp_fukaNendo(賦課年度);

        for (KibetsuJohoEntity 期別 : 期別情報List) {
            set期別情報(tmpTblEntity, 期別, insertEnList, 基準日);
        }

        return insertEnList;
    }

    private void set期別情報(ShunoJokyoTempTableEntity tmpTblEntity, KibetsuJohoEntity 期別,
            List<ShunoJokyoTempTableEntity> insertEnList, FlexibleDate 基準日) {
        ShunoJokyoTempTableEntity insertEntity = new ShunoJokyoTempTableEntity();
        UrT0705ChoteiKyotsuEntity 調定共通Entity = 期別.get調定関連().get調定共通Entity();
        if (調定共通Entity == null) {
            調定共通Entity = new UrT0705ChoteiKyotsuEntity();
        }

        int 期 = 期別.get期別Entity().getKi();
        Decimal 調定額 = 調定共通Entity.getChoteigaku();

        Decimal 収入額 = Decimal.ZERO;
        List<CaT0701ShunyuEntity> 収入List = 期別.get調定関連().get収入List();
        for (CaT0701ShunyuEntity caT0701 : 収入List) {
            caT0701.getShunyuYMD();
            if (caT0701.getShunyugaku() != null) {
                収入額 = 収入額.add(caT0701.getShunyugaku());
            }
        }
        Decimal 未納額 = 調定額.subtract(収入額);
        RDate 納期限 = 調定共通Entity.getNokigenYMD();

        RString 時効起算事由 = RString.EMPTY;
        FlexibleDate 仮の時効起算日 = FlexibleDate.EMPTY;
        FlexibleDate 時効起算年月日 = FlexibleDate.EMPTY;
        if (期別.get時効起算日管理Entity() != null) {
            時効起算年月日 = 期別.get時効起算日管理Entity().getJikoKisanYMD();
        }

        if (時効起算年月日 != null && !時効起算年月日.isEmpty()) {
            仮の時効起算日 = 時効起算年月日;
            時効起算事由 = 期別.get時効起算日管理Entity().getJikoKisanYMDKubun();
        } else if (期別.get調定関連().getCaT1018_督促状発行履歴Entity() != null
                && 期別.get調定関連().getCaT1018_督促状発行履歴Entity().getTokusokujoHakkoYMD() != null) {
            RDate 督促状発行年月日 = 期別.get調定関連().getCaT1018_督促状発行履歴Entity().getTokusokujoHakkoYMD();
            仮の時効起算日 = new FlexibleDate(督促状発行年月日.toDateString());
            時効起算事由 = JikoKisanbiKubun.督促状発行日.getコード();

        } else if (調定共通Entity.getNokigenYMD() != null && 調定共通Entity.getNokigenYMD() != null) {
            RDate 納期限の翌日 = 調定共通Entity.getNokigenYMD().plusDay(1);
            仮の時効起算日 = new FlexibleDate(納期限の翌日.toDateString());
            時効起算事由 = JikoKisanbiKubun.納期限翌日.getコード();
        }

        for (CaT0701ShunyuEntity caT0701 : 収入List) {
            if (仮の時効起算日.plusYear(2).isBeforeOrEquals(new FlexibleDate(caT0701.getShunyuYMD().toDateString()))) {
                break;
            } else if (時効起算年月日 != null && !時効起算年月日.isEmpty() && !仮の時効起算日.isEmpty()
                    && new FlexibleDate(caT0701.getShunyuYMD().toDateString()).isBefore(時効起算年月日)
                    && 仮の時効起算日.isBeforeOrEquals(new FlexibleDate(caT0701.getShunyuYMD().toDateString()))) {
                仮の時効起算日 = new FlexibleDate(caT0701.getShunyuYMD().toDateString());
            }
        }

        FlexibleDate 時効起算日 = 仮の時効起算日;
        if (時効起算日.equals(FlexibleDate.EMPTY)) {
            時効起算事由 = JikoKisanbiKubun.不明_調定無し.getコード();
        }

        RString 未納完納区分 = RString.EMPTY;
        if (基準日.isBefore(new FlexibleDate(納期限.toDateString()))) {
            未納完納区分 = MinoKannoKubun.未来納期.getコード();
        } else if (未納額.equals(Decimal.ZERO)) {
            未納完納区分 = MinoKannoKubun.完納.getコード();
        } else if (未納額.compareTo(Decimal.ZERO) > 0) {
            未納完納区分 = MinoKannoKubun.未納あり.getコード();
        } else if (未納額.compareTo(Decimal.ZERO) < 0) {
            未納完納区分 = MinoKannoKubun.過納.getコード();
        } else if (時効起算日.isEmpty() || 調定額.compareTo(Decimal.ZERO) == 0) {
            未納完納区分 = MinoKannoKubun._0円.getコード();
        }

        RString 時効区分 = RString.EMPTY;
        if (MinoKannoKubun.未納あり.getコード().equals(未納完納区分)) {
            if (基準日.isBefore(時効起算日.plusYear(2))) {
                時効区分 = JikoKubun.時効未到来.getコード();
            } else if (時効起算日.plusYear(2).isBeforeOrEquals(基準日)) {
                時効区分 = JikoKubun.時効到来.getコード();
            }
        } else {
            時効区分 = JikoKubun.空.getコード();
        }

        RString 特徴_普徴区分 = 期別.get期別Entity().getChoshuHouhou();
        TsuchishoNo 通知書番号 = 期別.get期別Entity().getTsuchishoNo();

        insertEntity.setTmp_hihokenshaNo(tmpTblEntity.getTmp_hihokenshaNo());
        insertEntity.setTmp_choteiNendo(tmpTblEntity.getTmp_choteiNendo());
        insertEntity.setTmp_fukaNendo(tmpTblEntity.getTmp_fukaNendo());

        insertEntity.setTmp_tokucho_fuchoKubun(特徴_普徴区分);
        insertEntity.setTmp_tsuchishoNo(通知書番号);
        insertEntity.setTmp_kibetsu(期);
        insertEntity.setTmp_choteigaku(調定額);
        insertEntity.setTmp_shunyugaku(収入額);
        if (!収入List.isEmpty()) {
            insertEntity.setTmp_shunyuYMD(収入List.get(0).getShunyuYMD());
        }
        insertEntity.setTmp_minogaku(未納額);
        insertEntity.setTmp_nokigen(納期限);
        if (期別.get調定関連().getCaT1018_督促状発行履歴Entity() != null) {
            RDate 督促状発行日 = 期別.get調定関連().getCaT1018_督促状発行履歴Entity().getTokusokujoHakkoYMD();
            insertEntity.setTmp_tokusokujoHakkoYMD(督促状発行日);
        }
        insertEntity.setTmp_jikoKisanYMD(時効起算日);
        insertEntity.setTmp_jikoKisanJiyu(時効起算事由);
        insertEntity.setTmp_minoKannoKubun(未納完納区分);
        insertEntity.setTmp_jikoKubun(時効区分);

        insertEnList.add(insertEntity);
    }

}
