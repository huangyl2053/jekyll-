package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.Hihosyosai.Hihosyosai;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 * このコードはツールによって生成されました。
 *
 * @reamsid_L DBA-0170-010 linghuhang
 */
public interface IHihosyosaiDiv extends ICommonChildDivBaseProperties {

    /**
     * モードを設定します。
     *
     * @param モード モード
     */
    public void 被保詳細モード(RString モード);

    /**
     * 被保詳細に初期化を設定します。
     *
     * @param 市町村コード 市町村コード
     * @param 導入形態コード 導入形態コード
     * @param 広住特措置元市町村コード 広住特措置元市町村コード
     * @param 被保険者番号 被保険者番号
     * @param 異動日 異動日
     * @param 枝番 枝番
     * @param 識別コード 識別コード
     * @param 資格取得日 資格取得日
     * @param 台帳種別 台帳種別
     */
    public void initialize(LasdecCode 市町村コード, RString 導入形態コード, LasdecCode 広住特措置元市町村コード,
            HihokenshaNo 被保険者番号, FlexibleDate 異動日, RString 枝番, ShikibetsuCode 識別コード, FlexibleDate 資格取得日, RString 台帳種別);

    /**
     * 親画面資格変更異動する、被保詳細に初期化を設定します。
     *
     * @param 市町村コード 市町村コード
     * @param 導入形態コード 導入形態コード
     * @param 広住特措置元市町村コード 広住特措置元市町村コード
     * @param 被保険者番号 被保険者番号
     * @param 異動日 異動日
     * @param 枝番 枝番
     * @param 識別コード 識別コード
     * @param 資格取得日 資格取得日
     * @param 台帳種別 台帳種別
     */
    public void initilize(LasdecCode 市町村コード, RString 導入形態コード, LasdecCode 広住特措置元市町村コード,
            HihokenshaNo 被保険者番号, FlexibleDate 異動日, RString 枝番, ShikibetsuCode 識別コード, FlexibleDate 資格取得日, RString 台帳種別);

    /**
     * 変更履歴グリッドのデータを取得します。
     *
     * @return SearchResult<HihokenshaDaicho> 変更履歴グリッド
     */
    SearchResult<HihokenshaDaicho> getGridData();

    /**
     * 施設入退所の保存処理する。
     */
    public void 施設入退所保存処理();

    /**
     * 変更事由DDLを設定します。
     *
     * @param key key
     * @param falg falg
     */
    public void setDdlHenkoJiyu(RString key, boolean falg);

    /**
     * 住所地特例表示モードを設定します。
     *
     * @param 住所地特例表示モード 住所地特例表示モード
     */
    public void 住所地特例表示モード(RString 住所地特例表示モード);

    /**
     * 住所地特例追加ボタンを設定します。
     *
     * @param 住所地特例追加ボタンモード 住所地特例追加ボタンモード
     */
    public void 住所地特例追加ボタン(RString 住所地特例追加ボタンモード);

    /**
     * 住所地特例表示タイプを設定します。
     *
     * @param 住所地特例表示タイプモード 住所地特例表示タイプモード
     */
    public void 住所地特例表示タイプ(RString 住所地特例表示タイプモード);

    /**
     * 資格関連異動表示モードを設定します。
     *
     * @param 資格関連異動表示モード 資格関連異動表示モード
     */
    public void 資格関連異動表示モード(RString 資格関連異動表示モード);

    /**
     * 施設入退所表示モードを設定します。
     *
     * @param 施設入退所表示モード 施設入退所表示モード
     */
    public void 施設入退所表示モード(RString 施設入退所表示モード);

    /**
     * 施設入退所明細表示モードを設定します。
     *
     * @param 施設入退所明細表示モード 施設入退所明細表示モード
     */
    public void 施設入退所明細表示モード(RString 施設入退所明細表示モード);

    /**
     * 施設入退所利用モードを設定します。
     *
     * @param 施設入退所利用モード 施設入退所利用モード
     */
    public void 施設入退所利用モード(RString 施設入退所利用モード);

    /**
     * 施設入退所表示widthサイズを設定します。
     *
     * @param 施設入退所表示widthサイズ 施設入退所表示widthサイズ
     */
    public void 施設入退所表示widthサイズ(RString 施設入退所表示widthサイズ);

    /**
     * 施設入退所表示heightサイズを設定します。
     *
     * @param 施設入退所表示widthサイズ 施設入退所表示widthサイズ
     */
    public void 施設入退所表示heightサイズ(RString 施設入退所表示widthサイズ);

    /**
     * 取得日と喪失日の前後順チックを実施します。
     *
     * @return ValidationMessageControlPairs ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 取得日と喪失日の前後順();
}
