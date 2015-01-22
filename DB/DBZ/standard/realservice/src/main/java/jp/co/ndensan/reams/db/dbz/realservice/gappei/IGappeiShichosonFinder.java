/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice.gappei;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.GappeiShichosonJoho;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.ur.urz.realservice.search.ISearchCondition;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;

/**
 * 合併市町村情報を取得するインターフェースです。
 *
 * @author N8156 宮本 康
 */
public interface IGappeiShichosonFinder {

    /**
     * 合併ありかどうかを判定します。
     *
     * @return true:合併あり、false:合併なし
     */
    boolean is合併あり();

    /**
     * 旧市町村情報付与終了日を取得します。
     *
     * @return 旧市町村情報付与終了日
     */
    Optional<FlexibleDate> get旧市町村情報付与終了日();

    /**
     * 条件に該当する合併市町村情報を取得します。
     *
     * @param 表示対象のみ true:表示対象のデータのみを対象とします。false:全データを対象とします。
     * @return 合併市町村情報
     */
    IItemList<GappeiShichosonJoho> get合併市町村情報(boolean 表示対象のみ);

    /**
     * 条件に該当する合併市町村情報を取得します。
     *
     * @param 旧市町村コード 旧市町村コード
     * @return 合併市町村情報
     */
    IItemList<GappeiShichosonJoho> get合併市町村情報(LasdecCode 旧市町村コード);

    /**
     * 条件に該当する合併市町村情報を取得します。
     *
     * @param 旧保険者番号 旧保険者番号
     * @return 合併市町村情報
     */
    IItemList<GappeiShichosonJoho> get合併市町村情報(ShoKisaiHokenshaNo 旧保険者番号);

    /**
     * 条件に該当する最新合併市町村情報を取得します。
     *
     * @param 市町村コード 市町村コード
     * @return 合併市町村情報
     */
    Optional<GappeiShichosonJoho> get最新合併市町村情報(LasdecCode 市町村コード);

    /**
     * 条件に該当する最新合併市町村情報を取得します。
     *
     * @param 保険者番号 保険者番号
     * @return 合併市町村情報
     */
    Optional<GappeiShichosonJoho> get最新合併市町村情報(ShoKisaiHokenshaNo 保険者番号);

    /**
     * 条件に該当する最新合併市町村情報を取得します。
     *
     * @param 保険者番号 保険者番号
     * @param 基準年月 基準年月
     * @return 合併市町村情報
     */
    Optional<GappeiShichosonJoho> get最新合併市町村情報(ShoKisaiHokenshaNo 保険者番号, FlexibleYearMonth 基準年月);

    /**
     * 条件に該当する最古合併市町村情報を取得します。
     *
     * @param 旧市町村コード 旧市町村コード
     * @return 合併市町村情報
     */
    Optional<GappeiShichosonJoho> get最古合併市町村情報(LasdecCode 旧市町村コード);

    /**
     * 条件に該当する直近合併市町村情報を取得します。
     *
     * @param 旧保険者番号 旧保険者番号
     * @return 合併市町村情報
     */
    Optional<GappeiShichosonJoho> get直近合併市町村情報(ShoKisaiHokenshaNo 旧保険者番号);

    /**
     * 条件に該当する直近合併市町村情報を取得します。
     *
     * @param 旧保険者番号 旧保険者番号
     * @param 基準年月 基準年月
     * @return 合併市町村情報
     */
    Optional<GappeiShichosonJoho> get直近合併市町村情報(ShoKisaiHokenshaNo 旧保険者番号, FlexibleYearMonth 基準年月);

    /**
     * 条件に該当する市町村情報を取得します。
     *
     * @param 市町村コード 市町村コード
     * @return 合併市町村情報
     */
    Optional<GappeiShichosonJoho> get市町村情報(LasdecCode 市町村コード);

    /**
     * 条件に該当する市町村情報を取得します。
     *
     * @param 保険者番号 保険者番号
     * @return 合併市町村情報
     */
    Optional<GappeiShichosonJoho> get市町村情報(ShoKisaiHokenshaNo 保険者番号);

    /**
     * 条件に該当する最古市町村情報を取得します。
     *
     * @param 市町村コード 市町村コード
     * @return 合併市町村情報
     */
    Optional<GappeiShichosonJoho> get最古市町村情報(LasdecCode 市町村コード);

    /**
     * 条件に該当する合併市町村情報を取得します。
     *
     * @param 検索条件 検索条件
     * @param 表示対象のみ true:表示対象のデータのみを対象とします。false:全データを対象とします。
     * @return 合併市町村情報
     */
    IItemList<GappeiShichosonJoho> find合併市町村情報(ISearchCondition 検索条件, boolean 表示対象のみ);
}
