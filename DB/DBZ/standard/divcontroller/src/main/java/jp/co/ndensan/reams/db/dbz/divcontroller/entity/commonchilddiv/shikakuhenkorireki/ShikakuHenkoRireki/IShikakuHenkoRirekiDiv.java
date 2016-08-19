package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shikakuhenkorireki.ShikakuHenkoRireki;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/*
 * このコードはツールによって生成されました。
 *
 * @reamsid_L DBA-1300-050 chengsanyuan
 */
public interface IShikakuHenkoRirekiDiv extends ICommonChildDivBaseProperties {

    /**
     * 資格変更履歴の初期化処理
     *
     * @param 被保険者番号
     * @param 識別コード
     * @param 取得日
     */
    void initialize(HihokenshaNo 被保険者番号, ShikibetsuCode 識別コード, FlexibleDate 取得日);

    /**
     * 変更履歴グリッドのデータを取得します。
     *
     * @return List<HihokenshaDaicho>
     */
    SearchResult<HihokenshaDaicho> getGridData();

    /**
     * 被保険者資格詳細異動用、変更履歴グリッドのデータを取得します。
     *
     * @return List<HihokenshaDaicho>
     */
    SearchResult<HihokenshaDaicho> getGridDataFor資格詳細異動();

    /**
     * 変更事由DDLを設定します。
     *
     * @param key 変更事由key
     * @param falg 活性フラグ
     */
    void setDdlHenkoJiyu(RString key, boolean falg);

    /**
     * モードを設定します。
     *
     * @param mode モードキー
     */
    void setDisplayTypeBykey(RString mode);

    /**
     * グリッド上に、状態が「追加」となっているデータが存在するかをチェックします。
     *
     * @return 状態が「追加」になっているデータが存在する場合、{@code true}
     */
    boolean is追加済み();
}
