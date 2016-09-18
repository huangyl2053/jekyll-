package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hihokenshafinder.HihokenshaFinder;

import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.IShikibetsuTaishoSearchKey;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.AtenaFinder.IAtenaFinderDiv;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/**
 * 被保険者検索Divのインターフェースです。
 *
 * @author N8156 宮本 康
 */
public interface IHihokenshaFinderDiv extends ICommonChildDivBaseProperties {

    /**
     * 保険者を返します。
     *
     * @return 保険者
     */
    RString get保険者();

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    RString get被保険者番号();

    /**
     * 通知書番号を返します。
     *
     * @return 通知書番号
     */
    RString get通知書番号();

    /**
     * 賦課年度を返します。
     *
     * @return 賦課年度
     */
    FlexibleYear get賦課年度();

    /**
     * 被保険者台帳登録者かどうかを返します。
     *
     * @return true:登録者、false:登録者ではない
     */
    boolean is被保険者台帳登録者();

    /**
     * 受給者台帳登録者かどうかを返します。
     *
     * @return true:登録者、false:登録者ではない
     */
    boolean is受給者台帳登録者();

    /**
     * 住所地特例者かどうかを返します。
     *
     * @return true:特例者、false:特例者ではない
     */
    boolean is住所地特例者();

    /**
     * 最大表示件数を返します。
     *
     * @return 最大表示件数
     */
    int get最大表示件数();

    /**
     * 宛名条件を返します。
     *
     * @return 宛名条件
     */
    IShikibetsuTaishoSearchKey get宛名条件();

    /**
     * 最近処理者を読み込みます。
     */
    void load最近処理者();

    /**
     * 最近処理者を保存します。
     *
     * @param 識別コード 識別コード
     * @param 名称 名称
     */
    void save最近処理者(ShikibetsuCode 識別コード, AtenaMeisho 名称);

    /**
     * 選択中の最近処理者を返します。
     *
     * @return 最近処理者
     */
    RString get最近処理者();

    /**
     * 賦課年度ドロップダウンの値を設定します。
     */
    void set賦課年度ドロップダウン();

    /**
     * 宛名検索の共有子Divを取得する。
     *
     * @return 宛名検索の共有子Div
     */
    IAtenaFinderDiv getCcdAtenaFinder();

    /**
     * ボタンをまとめたDivを返します。
     *
     * @return ボタンをまとめたDiv
     */
    ButtonsForHihokenshaFinderDiv getButtonsForHihokenshaFinder();

    /**
     * 介護の検索条件をまとめたDivを返します。
     *
     * @return 介護検索条件をまとめたDiv
     */
    KaigoFinderDiv getKaigoFinder();

}
