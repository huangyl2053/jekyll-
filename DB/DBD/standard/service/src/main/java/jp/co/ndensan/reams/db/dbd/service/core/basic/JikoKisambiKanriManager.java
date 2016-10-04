/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.business.core.basic.JikoKisambiKanri;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4023JikoKisambiKanriEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT4023JikoKisambiKanriDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 時効起算日管理を管理するクラスです。
 *
 * @reamsid_L DBD-9999-013 huangh
 */
public class JikoKisambiKanriManager {

    private final DbT4023JikoKisambiKanriDac dac;

    /**
     * コンストラクタです。
     */
    public JikoKisambiKanriManager() {
        dac = InstanceProvider.create(DbT4023JikoKisambiKanriDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT4023JikoKisambiKanriDac}
     */
    JikoKisambiKanriManager(DbT4023JikoKisambiKanriDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する時効起算日管理を返します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保険者番号 被保険者番号
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 特徴_普徴区分 特徴_普徴区分
     * @param 通知書番号 通知書番号
     * @param 収納期_月 収納期_月
     * @param 履歴番号 履歴番号
     * @return JikoKisambiKanri
     */
    @Transaction
    public JikoKisambiKanri get時効起算日管理(
            ShoKisaiHokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            RString 特徴_普徴区分,
            TsuchishoNo 通知書番号,
            RString 収納期_月,
            int 履歴番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(調定年度, UrSystemErrorMessages.値がnull.getReplacedMessage("調定年度"));
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(特徴_普徴区分, UrSystemErrorMessages.値がnull.getReplacedMessage("特徴_普徴区分"));
        requireNonNull(通知書番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通知書番号"));
        requireNonNull(収納期_月, UrSystemErrorMessages.値がnull.getReplacedMessage("収納期_月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT4023JikoKisambiKanriEntity entity = dac.selectByKey(
                証記載保険者番号,
                被保険者番号,
                調定年度,
                賦課年度,
                特徴_普徴区分,
                通知書番号,
                収納期_月,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new JikoKisambiKanri(entity);
    }

    /**
     * 時効起算日管理を全件返します。
     *
     * @return JikoKisambiKanriの{@code list}
     */
    @Transaction
    public List<JikoKisambiKanri> get時効起算日管理一覧() {
        List<JikoKisambiKanri> businessList = new ArrayList<>();

        for (DbT4023JikoKisambiKanriEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new JikoKisambiKanri(entity));
        }

        return businessList;
    }

    /**
     * 時効起算日管理{@link JikoKisambiKanri}を保存します。
     *
     * @param 時効起算日管理 {@link JikoKisambiKanri}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save時効起算日管理(JikoKisambiKanri 時効起算日管理) {
        requireNonNull(時効起算日管理, UrSystemErrorMessages.値がnull.getReplacedMessage("時効起算日管理"));
        if (!時効起算日管理.hasChanged()) {
            return false;
        }
        return 1 == dac.save(時効起算日管理.toEntity());
    }

    /**
     * 時効起算日管理{@link JikoKisambiKanri}を保存します。
     *
     * @param 時効起算日管理 {@link JikoKisambiKanri}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save時効起算日管理ForDeletePhysical(JikoKisambiKanri 時効起算日管理) {
        requireNonNull(時効起算日管理, UrSystemErrorMessages.値がnull.getReplacedMessage("時効起算日管理"));
        DbT4023JikoKisambiKanriEntity entity = 時効起算日管理.toEntity();
        entity.setState(EntityDataState.Deleted);
        return 1 == dac.saveOrDeletePhysicalBy(entity);
    }
}
