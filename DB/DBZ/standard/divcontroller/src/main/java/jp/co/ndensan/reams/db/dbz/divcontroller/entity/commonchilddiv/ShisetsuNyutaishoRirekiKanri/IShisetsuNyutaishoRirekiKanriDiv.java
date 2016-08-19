package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuNyutaishoRirekiKanri;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/**
 * このコードはツールによって生成されました。
 *
 * @reamsid_L DBA-0360-030 linghuhang
 */
public interface IShisetsuNyutaishoRirekiKanriDiv extends ICommonChildDivBaseProperties {

    /**
     * 表示モードを設定します。
     *
     * @param 表示モード 表示モード
     */
    public void set表示モード(RString 表示モード);

    /**
     * 明細表示モードを設定します。
     *
     * @param 明細表示モード 明細表示モード
     */
    public void set明細表示モード(RString 明細表示モード);

    /**
     * 利用モードを設定します。
     *
     * @param 利用モード 利用モード
     */
    public void set利用モード(RString 利用モード);

    /**
     * 表示widthサイズを設定します。
     *
     * @param 表示widthサイズ 表示widthサイズ
     */
    public void set表示widthサイズ(RString 表示widthサイズ);

    /**
     * 表示heightサイズを設定します。
     *
     * @param 表示heightサイズ 表示heightサイズ
     */
    public void set表示heightサイズ(RString 表示heightサイズ);

    /**
     * 施設入退所履歴に初期化を設定します。
     *
     * @param 識別コード 識別コード
     */
    public void initialize(ShikibetsuCode 識別コード);

    /**
     * 施設入退所履歴に初期化を設定します。
     *
     * @param 識別コード 識別コード
     * @param 台帳種別 台帳種別
     */
    public void initialize(ShikibetsuCode 識別コード, RString 台帳種別);

    /**
     * 施設入退所履歴の共有子DIVの画面内容から、施設入退所履歴情報をDBに反映します。
     */
    public void saveShisetsuNyutaisho();

    /**
     * 施設入退所履歴の一覧を取得する。
     *
     * @return List<dgShisetsuNyutaishoRireki_Row> 施設入退所履歴の一覧
     */
    public List<dgShisetsuNyutaishoRireki_Row> get施設入退所履歴一覧();

    /**
     * 保存可能な状態か確認します。
     *
     * @return return 保存可能ならtrue
     */
    public boolean isSavable();
}
