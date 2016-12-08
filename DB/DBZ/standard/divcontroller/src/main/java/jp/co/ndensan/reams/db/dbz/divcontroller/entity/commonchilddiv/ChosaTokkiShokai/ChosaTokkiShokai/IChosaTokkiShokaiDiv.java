package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaTokkiShokai.ChosaTokkiShokai;

import java.util.ArrayList;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;
import jp.co.ndensan.reams.uz.uza.ui.binding.IDialogDiv;

/**
 * このコードはツールによって生成されました。
 *
 * @reamsid_L DBE-3000-200 liangbc
 */
public interface IChosaTokkiShokaiDiv extends ICommonChildDivBaseProperties, IDialogDiv {

    /**
     * 画面初期化
     *
     * @param 申請書管理番号 親画面から受け取った申請書管理番号
     * @param 認定調査依頼履歴番号 親画面から受け取った認定調査依頼履歴番号
     * @param 認定調査特記事項番号List 親画面から受け取った認定調査特記事項番号
     * @return 初期化に成功したらtrue、失敗したらfalseを返す。
     */
    public boolean onLoad(ShinseishoKanriNo 申請書管理番号, int 認定調査依頼履歴番号, ArrayList<RString> 認定調査特記事項番号List);
}
