/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.business.core.basic.FukinitsuNokiKanri;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2016FukinitsuNokiKanriEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2016FukinitsuNokiKanriDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 不均一納期管理を管理するクラスです。
 *
 * @reamsid_L DBB-1770-040 cuilin
 */
public class FukinitsuNokiKanriManager {

    private final DbT2016FukinitsuNokiKanriDac dac;
    private static final RString 調定年度メッセージ = new RString("調定年度");
    private static final RString 市町村コードメッセージ = new RString("市町村コード");
    private static final RString 不均一納期管理メッセージ = new RString("不均一納期管理");

    /**
     * コンストラクタです。
     */
    public FukinitsuNokiKanriManager() {
        dac = InstanceProvider.create(DbT2016FukinitsuNokiKanriDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT2016FukinitsuNokiKanriDac}
     */
    FukinitsuNokiKanriManager(DbT2016FukinitsuNokiKanriDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する不均一納期管理を返します。
     *
     * @param 調定年度 調定年度
     * @param 市町村コード 市町村コード
     * @return FukinitsuNokiKanri
     */
    @Transaction
    public FukinitsuNokiKanri get不均一納期管理(
            FlexibleYear 調定年度,
            LasdecCode 市町村コード) {
        requireNonNull(調定年度, UrSystemErrorMessages.値がnull.getReplacedMessage(調定年度メッセージ.toString()));
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage(市町村コードメッセージ.toString()));

        DbT2016FukinitsuNokiKanriEntity entity = dac.selectByKey(
                調定年度,
                市町村コード);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new FukinitsuNokiKanri(entity);
    }

    /**
     * 不均一納期管理を全件返します。
     *
     * @return FukinitsuNokiKanriの{@code list}
     */
    @Transaction
    public List<FukinitsuNokiKanri> get不均一納期管理一覧() {
        List<FukinitsuNokiKanri> businessList = new ArrayList<>();

        for (DbT2016FukinitsuNokiKanriEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new FukinitsuNokiKanri(entity));
        }

        return businessList;
    }

    /**
     * 不均一納期管理{@link FukinitsuNokiKanri}を保存します。
     *
     * @param 不均一納期管理 {@link FukinitsuNokiKanri}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save不均一納期管理(FukinitsuNokiKanri 不均一納期管理) {
        requireNonNull(不均一納期管理, UrSystemErrorMessages.値がnull.getReplacedMessage(不均一納期管理メッセージ.toString()));
        if (!不均一納期管理.hasChanged()) {
            return false;
        }
        return 1 == dac.save(不均一納期管理.toEntity());
    }

    /**
     * 市町村コードを取得します。
     *
     * @param 調定年度 FlexibleYear
     * @return List<FukinitsuNokiKanri>
     */
    public List<FukinitsuNokiKanri> get市町村コード(FlexibleYear 調定年度) {
        List<FukinitsuNokiKanri> businessList = new ArrayList<>();
        for (DbT2016FukinitsuNokiKanriEntity entity : dac.selectShichosonCode(調定年度)) {
            entity.initializeMd5();
            businessList.add(new FukinitsuNokiKanri(entity));
        }
        return businessList;
    }
}
