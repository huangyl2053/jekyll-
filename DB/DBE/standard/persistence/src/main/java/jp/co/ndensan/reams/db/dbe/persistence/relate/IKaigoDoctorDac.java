/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.relate;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IshiJokyo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoDoctorCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoIryoKikanCode;
import jp.co.ndensan.reams.db.dbe.entity.relate.KaigoDoctorEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.util.db.ITrueFalseCriteria;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護医師情報のデータアクセスインターフェースです。
 *
 * @author N8156 宮本 康
 */
public interface IKaigoDoctorDac {

    /**
     * 引数の条件に該当する介護医師情報エンティティのリストを取得します。
     *
     * @param searchCondition 検索条件
     * @return 介護医師情報エンティティリスト
     */
    @Transaction
    List<KaigoDoctorEntity> select(ITrueFalseCriteria searchCondition);

    /**
     * 引数の条件に該当する介護医師情報エンティティを取得します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 介護医療機関コード 介護医療機関コード
     * @param 介護医師コード 介護医師コード
     * @return 介護医師情報エンティティ
     */
    @Transaction
    KaigoDoctorEntity select(ShoKisaiHokenshaNo 証記載保険者番号, KaigoIryoKikanCode 介護医療機関コード, KaigoDoctorCode 介護医師コード);

    /**
     * 引数の条件に該当する介護医師情報エンティティを取得します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 介護医療機関コード 介護医療機関コード
     * @param 介護医師コード 介護医師コード
     * @param 医師の状況 医師の状況
     * @return 介護医師情報エンティティ
     */
    @Transaction
    KaigoDoctorEntity select(ShoKisaiHokenshaNo 証記載保険者番号, KaigoIryoKikanCode 介護医療機関コード, KaigoDoctorCode 介護医師コード, IshiJokyo 医師の状況);

    /**
     * 引数の条件に該当する介護医師情報エンティティのリストを取得します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 介護医療機関コード 介護医療機関コード
     * @return 介護医師情報エンティティリスト
     */
    @Transaction
    List<KaigoDoctorEntity> select(ShoKisaiHokenshaNo 証記載保険者番号, KaigoIryoKikanCode 介護医療機関コード);

    /**
     * 引数の条件に該当する介護医師情報エンティティのリストを取得します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 介護医療機関コード 介護医療機関コード
     * @param 医師の状況 医師の状況
     * @return 介護医師情報エンティティリスト
     */
    @Transaction
    List<KaigoDoctorEntity> select(ShoKisaiHokenshaNo 証記載保険者番号, KaigoIryoKikanCode 介護医療機関コード, IshiJokyo 医師の状況);

    /**
     * 引数の条件に該当する介護医師情報エンティティのリストを取得します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @return 介護医師情報エンティティリスト
     */
    @Transaction
    List<KaigoDoctorEntity> select(ShoKisaiHokenshaNo 証記載保険者番号);

    /**
     * 引数の条件に該当する介護医師情報エンティティのリストを取得します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 医師の状況 医師の状況
     * @return 介護医師情報エンティティリスト
     */
    @Transaction
    List<KaigoDoctorEntity> select(ShoKisaiHokenshaNo 証記載保険者番号, IshiJokyo 医師の状況);
}
