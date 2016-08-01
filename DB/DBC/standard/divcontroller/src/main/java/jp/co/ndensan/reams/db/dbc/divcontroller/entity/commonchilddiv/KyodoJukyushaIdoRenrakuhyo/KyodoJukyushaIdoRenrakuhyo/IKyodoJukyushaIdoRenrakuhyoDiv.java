package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KyodoJukyushaIdoRenrakuhyo.KyodoJukyushaIdoRenrakuhyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kyodoshorijukyushateiseirenrakuhyo.param.KyodoshoriyoJukyushaIdoRenrakuhyoParam;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/*
 * このコードはツールによって生成されました。
 * @reamsid_L DBC-4390-010 xupeng
 */
public interface IKyodoJukyushaIdoRenrakuhyoDiv extends ICommonChildDivBaseProperties {

    /**
     * 画面を画面初期化します。
     *
     * @param 処理モード
     * @param 被保険者番号
     * @param 異動日
     * @param 論理削除
     * @param 対象年月
     * @return KyodoshoriyoJukyushaIdoRenrakuhyoParam
     */
    public KyodoshoriyoJukyushaIdoRenrakuhyoParam initialize(RString 処理モード, HihokenshaNo 被保険者番号,
            FlexibleDate 異動日, boolean 論理削除, FlexibleYearMonth 対象年月);

    /**
     * 最新画面データ
     *
     * @return KyodoshoriyoJukyushaIdoRenrakuhyoParam
     */
    public KyodoshoriyoJukyushaIdoRenrakuhyoParam getNewデータ();

    /**
     * 一時差止日の入力チェック
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs get一時差止日の入力チェック();

    /**
     * 一時差止日の関連チェック
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs get一時差止日の関連チェック();

    /**
     * 「基本送付情報を追加する」チェックボックス。
     *
     * @return list
     */
    public List<RString> get基本送付情報を追加する();

    /**
     * 「償還送付情報を追加する」チェックボックス。
     *
     * @return list
     */
    public List<RString> get償還送付情報を追加する();

    /**
     * 「高額送付情報を追加する」チェックボックス。
     *
     * @return list
     */
    public List<RString> get高額送付情報を追加する();
}
