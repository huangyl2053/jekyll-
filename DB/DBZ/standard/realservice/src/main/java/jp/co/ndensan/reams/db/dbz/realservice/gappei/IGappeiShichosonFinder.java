/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice.gappei;

import jp.co.ndensan.reams.db.dbz.model.gappei.IGappeiShichoson;
import jp.co.ndensan.reams.db.dbz.model.gappei.IGappeiShichosonJoho;
import jp.co.ndensan.reams.db.dbz.model.gappei.IKoikiGappeiShichosonJoho;
import jp.co.ndensan.reams.db.dbz.model.util.items.IItemList;
import jp.co.ndensan.reams.db.dbz.model.util.optional.IOptional;
import jp.co.ndensan.reams.ur.urz.realservice.search.ISearchCondition;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

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
    IOptional<FlexibleDate> get旧市町村情報付与終了日();

    /**
     * 全合併市町村情報を取得します。<br/>
     * 取得される合併市町村情報は「合併情報」+「旧合併市町村情報」です。
     *
     * @param 表示対象のみ true:表示対象のデータのみを対象とします。false:全データを対象とします。
     * @return 全合併市町村情報
     */
    IItemList<IGappeiShichosonJoho> get全合併市町村(boolean 表示対象のみ);

    /**
     * 全旧市町村情報を取得します。
     *
     * @return 全旧市町村情報
     */
    IItemList<IGappeiShichoson> get全旧市町村();

    /**
     * 合併市町村情報を検索します。
     *
     * @param 検索条件 検索条件
     * @param 表示対象のみ true:表示対象のデータのみを対象とします。false:全データを対象とします。
     * @return 合併市町村情報
     */
    IItemList<IGappeiShichosonJoho> find合併市町村(ISearchCondition 検索条件, boolean 表示対象のみ);

    /**
     * 全広域合併市町村情報を取得します。<br/>
     * 取得される広域合併市町村情報は「合併情報」+「広域合併市町村情報」で構成されます。
     *
     * @param 表示対象のみ true:表示対象のデータのみを対象とします。false:全データを対象とします。
     * @return 全広域合併市町村情報
     */
    IItemList<IKoikiGappeiShichosonJoho> get全広域合併市町村(boolean 表示対象のみ);

    /**
     * 地域ごとの最新広域合併市町村情報を取得します。<br/>
     * 取得される広域合併市町村情報は「最新の合併情報」+「最新の構成市町村情報」で構成されます。
     *
     * @return 地域ごとの最新広域合併市町村情報
     */
    IItemList<IKoikiGappeiShichosonJoho> get地域ごとの最新広域合併市町村();

    /**
     * 地域ごとの広域合併市町村情報を取得します。<br/>
     * 取得される広域合併市町村情報は「最新の合併情報」+「最古の旧市町村情報」で構成されます。
     *
     * @param 合併後の市町村コード 合併後の市町村コード
     * @return 地域ごとの広域合併市町村情報
     */
    IOptional<IKoikiGappeiShichosonJoho> get地域ごとの広域合併市町村(RString 合併後の市町村コード);

    /**
     * 全地域の広域合併市町村情報を取得します。<br/>
     * 取得される広域合併市町村情報は「最新の合併情報」+「最古の旧市町村情報」で構成されます。
     *
     * @return 全地域の広域合併市町村情報
     */
    IItemList<IKoikiGappeiShichosonJoho> get全地域の広域合併市町村();

    /**
     * 広域合併市町村情報を検索します。<br/>
     * 取得される広域合併市町村情報は「合併情報」+「その合併時点での市町村情報」で構成されます。
     *
     * @param 検索条件 検索条件
     * @return 広域合併市町村情報
     */
    IItemList<IKoikiGappeiShichosonJoho> find広域合併市町村(ISearchCondition 検索条件);

    /**
     * 合併後の市町村コードで広域合併市町村情報を検索します。<br/>
     * 取得される広域合併市町村情報は「最新の合併情報」+「最新の構成市町村情報」で構成されます。
     *
     * @param 合併後の市町村コード 合併後の市町村コード
     * @return 広域合併市町村情報
     */
    IOptional<IKoikiGappeiShichosonJoho> find広域合併市町村By合併後市町村コード(RString 合併後の市町村コード);

    /**
     * 合併元の市町村コードで広域合併市町村情報を検索します。<br/>
     * 取得される広域合併市町村情報は「最新の合併情報」+「最古の構成市町村情報」で構成されます。
     *
     * @param 合併元の市町村コード 合併元の市町村コード
     * @return 広域合併市町村情報
     */
    IOptional<IKoikiGappeiShichosonJoho> find広域合併市町村By合併元市町村コード(RString 合併元の市町村コード);
}
