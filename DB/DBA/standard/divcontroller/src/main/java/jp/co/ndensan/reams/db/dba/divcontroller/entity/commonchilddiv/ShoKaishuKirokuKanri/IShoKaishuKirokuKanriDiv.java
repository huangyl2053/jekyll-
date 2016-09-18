package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.ShoKaishuKirokuKanri;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoKofuKaishu;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoKofuKaishuIdentifier;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * このコードはツールによって生成されました。
 *
 * @reamsid_L DBA-1070-010 lizhuoxuan
 */
public interface IShoKaishuKirokuKanriDiv extends ICommonChildDivBaseProperties {

    /**
     * 被保険者番号と状態を指定して、共有子Divを初期化します。
     *
     * @param 状態 証回収共有子Divの状態
     * @param 被保険者番号 対象者の被保険者番号
     */
    void initialize(RString 状態, HihokenshaNo 被保険者番号);

    /**
     * 被保険者番号と状態を指定して、共有子Divを初期化します。
     *
     * @param 状態 証回収共有子Divの状態
     * @param 被保険者番号 対象者の被保険者番号
     * @param dataSource グリッドに設定するデータ
     * @param 証交付回収情報Model 共有子Div内で保持される証回収のデータ
     */
    void initialize(RString 状態, HihokenshaNo 被保険者番号,
            ArrayList<dgKoufuKaishu_Row> dataSource, Models<ShoKofuKaishuIdentifier, ShoKofuKaishu> 証交付回収情報Model);

    /**
     * 証交付回収情報一覧を取得します。
     *
     * @return 証交付回収情報一覧 証交付回収情報一覧
     */
    List<dgKoufuKaishu_Row> get証交付回収情報一覧();

    /**
     * 証交付回収の保存処理結果を返します。
     */
    void saveShoKaishuKirokuKanri();

    /**
     * 保存対象を含むデータを取得します。
     *
     * @return 保存対象を含む証交付回収データ
     */
    Models<ShoKofuKaishuIdentifier, ShoKofuKaishu> getSaveData();
}
