/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.DaisanshaKoiJidan;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3080DaisanshaKoiJidanEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3080DaisanshaKoiJidanDac;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護第三者行為示談を管理するクラスです。
 */
public class DaisanshaKoiJidanManager {

    private final DbT3080DaisanshaKoiJidanDac dac;

    /**
     * コンストラクタです。
     */
    public DaisanshaKoiJidanManager() {
        dac = InstanceProvider.create(DbT3080DaisanshaKoiJidanDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3080DaisanshaKoiJidanDac}
     */
    DaisanshaKoiJidanManager(DbT3080DaisanshaKoiJidanDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する介護第三者行為示談を返します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 第三者行為届出管理番号 TodokedeKanriNo
     * @param 示談報告書受付年月日 JidanHokokushoUketukeYMD
     * @param 履歴番号 RirekiNo
     * @return DaisanshaKoiJidan
     */
    @Transaction
    public DaisanshaKoiJidan get介護第三者行為示談(
            HihokenshaNo 被保険者番号,
            RString 第三者行為届出管理番号,
            FlexibleDate 示談報告書受付年月日,
            Decimal 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(第三者行為届出管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("第三者行為届出管理番号"));
        requireNonNull(示談報告書受付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("示談報告書受付年月日"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT3080DaisanshaKoiJidanEntity entity = dac.selectByKey(
                被保険者番号,
                第三者行為届出管理番号,
                示談報告書受付年月日,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new DaisanshaKoiJidan(entity);
    }

    /**
     * 介護第三者行為示談を全件返します。
     *
     * @return List<DaisanshaKoiJidan>
     */
    @Transaction
    public List<DaisanshaKoiJidan> get介護第三者行為示談一覧() {
        List<DaisanshaKoiJidan> businessList = new ArrayList<>();

        for (DbT3080DaisanshaKoiJidanEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new DaisanshaKoiJidan(entity));
        }

        return businessList;
    }

    /**
     * 介護第三者行為示談{@link DaisanshaKoiJidan}を保存します。
     *
     * @param 介護第三者行為示談 {@link DaisanshaKoiJidan}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save介護第三者行為示談(DaisanshaKoiJidan 介護第三者行為示談) {
        requireNonNull(介護第三者行為示談, UrSystemErrorMessages.値がnull.getReplacedMessage("介護第三者行為示談"));
        if (!介護第三者行為示談.hasChanged()) {
            return false;
        }
        return 1 == dac.save(介護第三者行為示談.toEntity());
    }
}
