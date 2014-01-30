/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.relate;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IryoKikanJokyo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.KaigoIryoKikanCode;
import jp.co.ndensan.reams.db.dbe.entity.relate.KaigoIryoKikanEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.uz.uza.util.db.ITrueFalseCriteria;

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
    List<KaigoIryoKikanEntity> select(ITrueFalseCriteria criteria);

    /**
     * 市町村コードと介護医療機関コードを元に、介護医療機関の情報を取得します。
     *
     * @param 市町村コード 市町村コード
     * @param 介護医療機関コード 介護医療機関コード
     * @return 介護医療機関情報のリスト
     */
    KaigoIryoKikanEntity select(ShichosonCode 市町村コード, KaigoIryoKikanCode 介護医療機関コード);

    /**
     * 市町村コード、介護医療機関コード、医療機関状況を元に、介護医療機関の情報を取得します。
     *
     * @param 市町村コード 市町村コード
     * @param 介護医療機関コード 介護医療機関コード
     * @param 医療機関の状況 医療機関の状況
     * @return 介護医療機関情報
     */
    KaigoIryoKikanEntity select(ShichosonCode 市町村コード, KaigoIryoKikanCode 介護医療機関コード, IryoKikanJokyo 医療機関の状況);

    /**
     * 指定した市町村コードに該当する、介護医療機関情報をリストで返します。
     *
     * @param 市町村コード 市町村コード
     * @return 介護医療機関情報のリスト
     */
    List<KaigoIryoKikanEntity> select(ShichosonCode 市町村コード);

    /**
     * 指定した市町村コードと医療機関状況に該当する、介護医療機関情報をリストで返します。
     *
     * @param 市町村コード 市町村コード
     * @param 医療機関の状況 医療機関の状況
     * @return 介護医療機関情報のリスト
     */
    List<KaigoIryoKikanEntity> select(ShichosonCode 市町村コード, IryoKikanJokyo 医療機関の状況);
}
