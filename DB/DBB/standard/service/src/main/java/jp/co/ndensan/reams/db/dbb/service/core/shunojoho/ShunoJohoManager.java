/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.shunojoho;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.business.core.fuka.Fuka;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbV2002FukaAliveDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 画面設計_DBB_ShunoJoho_収納情報のManagerクラスです。
 *
 * @reamsid_L DBB-5710-010 xuxin
 */
public class ShunoJohoManager {

    private final RString 調定年度_メセージ = new RString("調定年度");
    private final RString 賦課年度_メセージ = new RString("賦課年度");
    private final RString 通知書番号_メセージ = new RString("通知書番号");

    private final DbV2002FukaAliveDac dac;

    /**
     * コンストラクタです。
     */
    public ShunoJohoManager() {
        dac = InstanceProvider.create(DbV2002FukaAliveDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbV2002FukaAliveDac}
     */
    ShunoJohoManager(DbV2002FukaAliveDac dac) {
        this.dac = dac;
    }

    /**
     * 介護賦課最新履歴の情報を取得します。
     *
     * @param 調定年度 FlexibleYear
     * @param 賦課年度 FlexibleYear
     * @param 通知書番号 TsuchishoNo
     * @return Fuka
     */
    @Transaction
    public Fuka get介護賦課_履歴番号最新(
            FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            TsuchishoNo 通知書番号) {
        requireNonNull(調定年度, UrSystemErrorMessages.値がnull.getReplacedMessage(調定年度_メセージ.toString()));
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage(賦課年度_メセージ.toString()));
        requireNonNull(通知書番号, UrSystemErrorMessages.値がnull.getReplacedMessage(通知書番号_メセージ.toString()));

        DbT2002FukaEntity entity = dac.select賦課情報(
                調定年度,
                賦課年度,
                通知書番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new Fuka(entity);
    }

}
