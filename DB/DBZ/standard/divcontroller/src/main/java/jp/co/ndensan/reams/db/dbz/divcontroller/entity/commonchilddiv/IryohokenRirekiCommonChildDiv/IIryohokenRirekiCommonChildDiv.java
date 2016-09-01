package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.IryohokenRirekiCommonChildDiv;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.hihokensha.iryohokenkanyujokyo.IryohokenKanyuJokyo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 * @reamsid_L DBA-0230-010 hezhenzhen
 */
public interface IIryohokenRirekiCommonChildDiv extends ICommonChildDivBaseProperties {

    /**
     * 医療保険履歴の初期化処理します。
     *
     * @param モード
     * @param 識別コード
     * @param 被保険者番号
     * @param 市町村コード
     */
    public abstract void initialize(RString モード, RString 識別コード, HihokenshaNo 被保険者番号, LasdecCode 市町村コード);

    /**
     * 医療保険履歴の初期化処理します。市町村コードは導入団体のものを設定します。
     *
     * @param モード
     * @param 識別コード
     * @param 被保険者番号
     */
    public abstract void initialize(RString モード, RString 識別コード, HihokenshaNo 被保険者番号);

    /**
     * 医療保険履歴の初期化処理します。市町村コードは導入団体のものを設定します。 グリッドに設定されるデータは外部から取得したものを設定します。
     *
     * @param モード 医療保険履歴の処理モード
     * @param 識別コード 識別コード
     * @param 被保険者番号 被保険者番号
     * @param 市町村コード 市町村コード
     * @param 医療保険履歴List 医療保険履歴グリッドに設定するデータ
     */
    void initialize(RString モード, RString 識別コード, HihokenshaNo 被保険者番号, LasdecCode 市町村コード, List<dgIryohokenIchiran_Row> 医療保険履歴List);

    /**
     * 医療保険履歴の共有子DIVの画面内容から、施設入退所履歴情報をDBに反映します。
     */
    void save();

    /**
     * グリッド上から、DBに保存される対象となるデータを取得します。
     *
     * @return 保存対象の医療保険加入状況データ
     */
    ArrayList<IryohokenKanyuJokyo> getSaveData();

    /**
     * 医療保険情報を取得します。
     *
     * @return List<dgIryohokenIchiran_Row>
     */
    public abstract List<dgIryohokenIchiran_Row> getDataGridList();

    /**
     * 保存可能な状態かどうかをチェックします。
     *
     * @return 保存可能ならtrue
     */
    public boolean isSavable();

}
