/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import javax.annotation.CheckForNull;
import jp.co.ndensan.reams.db.dbb.business.core.FukaRireki;
import jp.co.ndensan.reams.db.dbb.business.core.basic.Fuka;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic._DbT2002FukaDac;
import jp.co.ndensan.reams.db.dbb.persistence.db.relate.FukaDac;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT2002FukaDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.definition.core.util.optional.Optional;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護賦課を管理するクラスです。
 */
public class FukaManager {

    private final RString 調定年度_メセージ = new RString("調定年度");
    private final RString 賦課年度_メセージ = new RString("賦課年度");
    private final RString 通知書番号_メセージ = new RString("通知書番号");
    private final RString 履歴番号_メセージ = new RString("履歴番号");
    private final RString 被保険者番号_メセージ = new RString("被保険者番号");
    private final DbT2002FukaDac dac;
    private final _DbT2002FukaDac _fukaDac;
    private final FukaDac relateDac;

    /**
     * コンストラクタです。
     */
    public FukaManager() {
        dac = InstanceProvider.create(DbT2002FukaDac.class);
        relateDac = InstanceProvider.create(FukaDac.class);
        _fukaDac = InstanceProvider.create(_DbT2002FukaDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT2002FukaDac}
     */
    FukaManager(DbT2002FukaDac dac, FukaDac relateDac) {
        this.dac = dac;
        this.relateDac = relateDac;
        this._fukaDac = null; //暫定対応
    }

    /**
     * 主キーに合致する介護賦課を返します。
     *
     * @param 調定年度 ChoteiNendo
     * @param 賦課年度 FukaNendo
     * @param 通知書番号 TsuchishoNo
     * @param 履歴番号 RirekiNo
     * @return Fuka
     */
    @Transaction
    public Fuka get介護賦課(
            FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            TsuchishoNo 通知書番号,
            int 履歴番号) {
        requireNonNull(調定年度, UrSystemErrorMessages.値がnull.getReplacedMessage(調定年度_メセージ.toString()));
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage(賦課年度_メセージ.toString()));
        requireNonNull(通知書番号, UrSystemErrorMessages.値がnull.getReplacedMessage(通知書番号_メセージ.toString()));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage(履歴番号_メセージ.toString()));

        DbT2002FukaEntity entity = dac.selectByKey(
                調定年度,
                賦課年度,
                通知書番号,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new Fuka(entity);
    }

    /**
     * 引数に一致する介護賦課を返します。
     *
     * @param 調定年度 ChoteiNendo
     * @param 賦課年度 FukaNendo
     * @param 通知書番号 TsuchishoNo
     * @return List<Fuka>
     */
    @Transaction
    public List<Fuka> get介護賦課(FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            TsuchishoNo 通知書番号) {
        List<Fuka> businessList = new ArrayList<>();

        for (DbT2002FukaEntity entity : dac.selectByKey(調定年度, 賦課年度, 通知書番号)) {
            entity.initializeMd5();
            businessList.add(new Fuka(entity));
        }

        return businessList;
    }

    /**
     * 介護賦課を全件返します。
     *
     * @return List<Fuka>
     */
    @Transaction
    public List<Fuka> get介護賦課一覧() {
        List<Fuka> businessList = new ArrayList<>();

        for (DbT2002FukaEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new Fuka(entity));
        }

        return businessList;
    }

    /**
     * 介護賦課{@link Fuka}を保存します。
     *
     * @param 介護賦課 {@link Fuka}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save介護賦課(Fuka 介護賦課) {
        requireNonNull(介護賦課, UrSystemErrorMessages.値がnull.getReplacedMessage("介護賦課"));
        if (!介護賦課.hasChanged()) {
            return false;
        }
        return 1 == dac.save(介護賦課.toEntity());
    }

    /**
     * 引数のキーに一致する介護賦課を取得します。<br />
     * 賦課の任意対象比較に使用します。<br />
     * 調定日時＜＝更生日時、を抽出条件とします。
     *
     * @param 調定年度 ChoteiNendo
     * @param 賦課年度 FukaNendo
     * @param 被保険者番号 HihokenshaNo
     * @param 調定日時 RDateTime
     * @return Fuka
     */
    @Transaction
    public Optional<Fuka> get介護賦課For任意対象比較(
            FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            HihokenshaNo 被保険者番号,
            RDateTime 調定日時) {
        requireNonNull(調定年度, UrSystemErrorMessages.値がnull.getReplacedMessage(調定年度_メセージ.toString()));
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage(賦課年度_メセージ.toString()));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(調定日時, UrSystemErrorMessages.値がnull.getReplacedMessage("調定日時"));

        DbT2002FukaEntity entity = dac.selectFor任意対象比較(
                調定年度,
                賦課年度,
                被保険者番号,
                調定日時);
        if (entity == null) {
            return Optional.ofNullable(null);
        }
        entity.initializeMd5();
        return Optional.of(new Fuka(entity));
    }

    /**
     * 引数のキーに一致する介護賦課を取得します。<br />
     * 賦課の任意対象比較に使用します。<br />
     * 調定日時＜＝更生日時、を抽出条件とします。
     *
     * @param 調定年度 ChoteiNendo
     * @param 賦課年度 FukaNendo
     * @param 通知書番号 TsuchishoNo
     * @param 履歴番号 int
     * @return Fuka
     */
    @Transaction
    public Optional<Fuka> get介護賦課For任意対象比較(
            FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            TsuchishoNo 通知書番号,
            int 履歴番号) {
        requireNonNull(調定年度, UrSystemErrorMessages.値がnull.getReplacedMessage(調定年度_メセージ.toString()));
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage(賦課年度_メセージ.toString()));
        requireNonNull(通知書番号, UrSystemErrorMessages.値がnull.getReplacedMessage(通知書番号_メセージ.toString()));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage(履歴番号_メセージ.toString()));

        DbT2002FukaEntity entity = relateDac.selectFor任意対象比較(
                調定年度,
                賦課年度,
                通知書番号,
                履歴番号);
        if (entity == null) {
            return Optional.ofNullable(null);
        }
        entity.initializeMd5();
        return Optional.of(new Fuka(entity));
    }

    /**
     * 賦課年度に対する最新の介護賦課を返します。
     *
     * @param 賦課年度 FukaNendo
     * @param 通知書番号 TsuchishoNo
     * @return Fuka
     */
    @Transaction
    @CheckForNull
    public Fuka get介護賦課_賦課年度最新(
            FlexibleYear 賦課年度,
            TsuchishoNo 通知書番号) {
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage(賦課年度_メセージ.toString()));
        requireNonNull(通知書番号, UrSystemErrorMessages.値がnull.getReplacedMessage(通知書番号_メセージ.toString()));

        DbT2002FukaEntity entity = dac.selectByFukanendoSaishin(
                賦課年度,
                通知書番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new Fuka(entity);
    }

    /**
     * 指定の被保険者について、賦課年度に対する最新の介護賦課を返します。
     *
     * @param 賦課年度 賦課年度
     * @param 被保険者番号 被保険者番号
     * @return 指定の条件に該当する{@link Fuka}.取得できなかった場合、{@code null}.
     */
    @CheckForNull
    public Fuka get賦課年度最新賦課From被保険者番号(FlexibleYear 賦課年度, HihokenshaNo 被保険者番号) {
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage(賦課年度_メセージ.toString()));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(被保険者番号_メセージ.toString()));

        DbT2002FukaEntity entity = _fukaDac.selectByFukanendoSaishinPerHihokenshaNo(賦課年度, 被保険者番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new Fuka(entity);
    }

    /**
     * 指定の年度の賦課履歴を検索します。
     *
     * @param 賦課年度 賦課年度
     * @param 被保番号 被保番号
     * @return 賦課履歴
     */
    public FukaRireki find賦課履歴On(FlexibleYear 賦課年度, HihokenshaNo 被保番号) {
        List<Fuka> list = new ArrayList<>();
        for (DbT2002FukaEntity entity : dac.select賦課履歴On(賦課年度, 被保番号)) {
            list.add(new Fuka(entity));
        }
        return new FukaRireki(list);
    }

    /**
     * 指定の年度の前年度の賦課履歴を検索します。
     *
     * @param 賦課年度 賦課年度。この前年度を検索対象とする。
     * @param 被保番号 被保番号
     * @return 賦課履歴
     */
    public FukaRireki find前年度賦課履歴(FlexibleYear 賦課年度, HihokenshaNo 被保番号) {
        return find賦課履歴On(賦課年度.minusYear(1), 被保番号);
    }
}
