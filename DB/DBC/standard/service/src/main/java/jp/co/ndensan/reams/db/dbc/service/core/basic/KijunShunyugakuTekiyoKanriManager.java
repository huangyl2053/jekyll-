/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 基準収入額適用管理を管理するクラスです。
 */
public class KijunShunyugakuTekiyoKanriManager {

    private final DbT3116KijunShunyugakuTekiyoKanriDac dac;

    /**
     * コンストラクタです。
     */
    public KijunShunyugakuTekiyoKanriManager() {
        dac = InstanceProvider.create(DbT3116KijunShunyugakuTekiyoKanriDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3116KijunShunyugakuTekiyoKanriDac}
     */
    KijunShunyugakuTekiyoKanriManager(DbT3116KijunShunyugakuTekiyoKanriDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する基準収入額適用管理を返します。
     *
     * @param 世帯コード SetaiCode
     * @param 年度 Nendo
     * @param 履歴番号 RirekiNo
     * @param 被保険者番号 HihokenshaNo
     * @return KijunShunyugakuTekiyoKanri
     */
    @Transaction
    public KijunShunyugakuTekiyoKanri get基準収入額適用管理(
             SetaiCode 世帯コード,
            FlexibleYear 年度,
            Decimal 履歴番号,
            HokenshaNo 被保険者番号) {
        requireNonNull(世帯コード, UrSystemErrorMessages.値がnull.getReplacedMessage("世帯コード"));
        requireNonNull(年度, UrSystemErrorMessages.値がnull.getReplacedMessage("年度"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));

        DbT3116KijunShunyugakuTekiyoKanriEntity entity = dac.selectByKey(
                世帯コード,
                年度,
                履歴番号,
                被保険者番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KijunShunyugakuTekiyoKanri(entity);
    }

    /**
     * 基準収入額適用管理を全件返します。
     *
     * @return List<KijunShunyugakuTekiyoKanri>
     */
    @Transaction
    public List<KijunShunyugakuTekiyoKanri> get基準収入額適用管理一覧() {
        List<KijunShunyugakuTekiyoKanri> businessList = new ArrayList<>();

        for (DbT3116KijunShunyugakuTekiyoKanriEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new KijunShunyugakuTekiyoKanri(entity));
        }

        return businessList;
    }

    /**
     * 基準収入額適用管理{@link KijunShunyugakuTekiyoKanri}を保存します。
     *
     * @param 基準収入額適用管理 {@link KijunShunyugakuTekiyoKanri}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save基準収入額適用管理(KijunShunyugakuTekiyoKanri 基準収入額適用管理) {
        requireNonNull(基準収入額適用管理, UrSystemErrorMessages.値がnull.getReplacedMessage("基準収入額適用管理"));
        if (!基準収入額適用管理.hasChanged()) {
            return false;
        }
        return 1 == dac.save(基準収入額適用管理.toEntity());
    }
}
