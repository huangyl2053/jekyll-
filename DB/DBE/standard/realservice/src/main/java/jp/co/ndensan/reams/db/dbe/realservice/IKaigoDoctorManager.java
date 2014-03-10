/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import jp.co.ndensan.reams.db.dbe.business.KaigoDoctor;
import jp.co.ndensan.reams.db.dbe.business.KaigoDoctorCollection;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IshiJokyo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoDoctorCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoIryoKikanCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.ur.urz.realservice.search.ISearchCondition;

/**
 * 介護医師情報を管理するインターフェースです。
 *
 * @author N8156 宮本 康
 */
public interface IKaigoDoctorManager {

    /**
     * 引数の条件に該当する介護医師情報を取得します。
     *
     * @param 市町村コード 市町村コード
     * @param 介護医療機関コード 介護医療機関コード
     * @param 介護医師コード 介護医師コード
     * @return 介護医師情報
     */
    KaigoDoctor get介護医師(ShichosonCode 市町村コード, KaigoIryoKikanCode 介護医療機関コード, KaigoDoctorCode 介護医師コード);

    /**
     * 引数の条件に該当する介護医師情報を取得します。
     *
     * @param 市町村コード 市町村コード
     * @param 介護医療機関コード 介護医療機関コード
     * @param 介護医師コード 介護医師コード
     * @param 医師の状況 医師の状況
     * @return 介護医師情報
     */
    KaigoDoctor get介護医師(ShichosonCode 市町村コード, KaigoIryoKikanCode 介護医療機関コード, KaigoDoctorCode 介護医師コード, IshiJokyo 医師の状況);

    /**
     * 引数の条件に該当する介護医師情報のリストを取得します。
     *
     * @param 市町村コード 市町村コード
     * @param 介護医療機関コード 介護医療機関コード
     * @return 介護医師情報リスト
     */
    KaigoDoctorCollection get介護医師リストOf(ShichosonCode 市町村コード, KaigoIryoKikanCode 介護医療機関コード);

    /**
     * 引数の条件に該当する介護医師情報のリストを取得します。
     *
     * @param 市町村コード 市町村コード
     * @param 介護医療機関コード 介護医療機関コード
     * @param 医師の状況 医師の状況
     * @return 介護医師情報リスト
     */
    KaigoDoctorCollection get介護医師リストOf(ShichosonCode 市町村コード, KaigoIryoKikanCode 介護医療機関コード, IshiJokyo 医師の状況);

    /**
     * 引数の条件に該当する介護医師情報のリストを取得します。
     *
     * @param 市町村コード 市町村コード
     * @return 介護医師情報リスト
     */
    KaigoDoctorCollection get介護医師リストOf(ShichosonCode 市町村コード);

    /**
     * 引数の条件に該当する介護医師情報のリストを取得します。
     *
     * @param 市町村コード 市町村コード
     * @param 医師の状況 医師の状況
     * @return 介護医師情報リスト
     */
    KaigoDoctorCollection get介護医師リストOf(ShichosonCode 市町村コード, IshiJokyo 医師の状況);

    /**
     * 引数の条件に該当する介護医師情報のリストを取得します。
     *
     * @param searchCondtion 検索条件
     * @return 介護医師情報リスト
     */
    KaigoDoctorCollection get介護医師リストOf(ISearchCondition searchCondtion);

    /**
     * 引数の介護医師情報を新規登録、または更新します。
     *
     * @param 介護医師情報 介護医師情報
     * @return 新規登録、または更新が成功した場合はtrueを返します。
     */
    boolean save(KaigoDoctor 介護医師情報);

    /**
     * 引数の介護医師情報を削除します。
     *
     * @param 介護医師情報 介護医師情報
     * @return 削除が成功した場合はtrueを返します。
     */
    boolean remove(KaigoDoctor 介護医師情報);
}
