/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.relate;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IryoKikanJokyo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoIryoKikanCode;
import jp.co.ndensan.reams.db.dbe.entity.relate.KaigoIryoKikanEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.util.db.ITrueFalseCriteria;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 業務共通の医療機関、講座、介護業務独自の主治医医療機関の情報を取得するデータアクセスクラスのインターフェースです。
 *
 * @author n8178 城間篤人
 */
public interface IKaigoIryoKikanDac {

    /**
     * 複雑な検索条件がUI画面から与えられた際に、その検索条件を元に介護医療機関情報を取得します。
     *
     * @param criteria 検索条件
     * @return 介護医療機関情報のリスト
     */
    @Transaction
    List<KaigoIryoKikanEntity> select(ITrueFalseCriteria criteria);

    /**
     * 証記載保険者番号と介護医療機関コードを元に、介護医療機関の情報を取得します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 介護医療機関コード 介護医療機関コード
     * @return 介護医療機関情報のリスト
     */
    @Transaction
    KaigoIryoKikanEntity select(ShoKisaiHokenshaNo 証記載保険者番号, KaigoIryoKikanCode 介護医療機関コード);

    /**
     * 証記載保険者番号、介護医療機関コード、医療機関状況を元に、介護医療機関の情報を取得します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 介護医療機関コード 介護医療機関コード
     * @param 医療機関の状況 医療機関の状況
     * @return 介護医療機関情報
     */
    @Transaction
    KaigoIryoKikanEntity select(ShoKisaiHokenshaNo 証記載保険者番号, KaigoIryoKikanCode 介護医療機関コード, IryoKikanJokyo 医療機関の状況);

    /**
     * 指定した証記載保険者番号に該当する、介護医療機関情報をリストで返します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @return 介護医療機関情報のリスト
     */
    @Transaction
    List<KaigoIryoKikanEntity> select(ShoKisaiHokenshaNo 証記載保険者番号);

    /**
     * 指定した証記載保険者番号と医療機関状況に該当する、介護医療機関情報をリストで返します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 医療機関の状況 医療機関の状況
     * @return 介護医療機関情報のリスト
     */
    @Transaction
    List<KaigoIryoKikanEntity> select(ShoKisaiHokenshaNo 証記載保険者番号, IryoKikanJokyo 医療機関の状況);
}
