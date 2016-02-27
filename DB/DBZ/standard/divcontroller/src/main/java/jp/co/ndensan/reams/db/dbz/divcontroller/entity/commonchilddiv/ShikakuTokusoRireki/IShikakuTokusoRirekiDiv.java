package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShikakuTokusoRireki;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 */
public interface IShikakuTokusoRirekiDiv extends ICommonChildDivBaseProperties {

    /**
     * 引数から渡されたキーを元に被保険者台帳テーブルから情報を取得し、その情報をグリッドに表示します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 識別コード 識別コード
     */
    void initialize(HihokenshaNo 被保険者番号, ShikibetsuCode 識別コード);
}
