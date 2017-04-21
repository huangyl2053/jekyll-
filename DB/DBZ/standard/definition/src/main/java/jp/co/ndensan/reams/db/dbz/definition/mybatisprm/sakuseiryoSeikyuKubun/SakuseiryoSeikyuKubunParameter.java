/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.mybatisprm.sakuseiryoSeikyuKubun;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 作成料請求区分取得のMyBatis用パラメータクラスです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public class SakuseiryoSeikyuKubunParameter {

    private final ShinseishoKanriNo 申請書管理番号;
    private final RString 主治医医療機関コード;
    private final RString 主治医コード;

    private SakuseiryoSeikyuKubunParameter(ShinseishoKanriNo 申請書管理番号, RString 主治医医療機関コード, RString 主治医コード) {
        this.申請書管理番号 = 申請書管理番号;
        this.主治医医療機関コード = 主治医医療機関コード;
        this.主治医コード = 主治医コード;
    }

    /**
     * 検索用のパラメータを生成します。
     *
     * @param 申請書管理番号 ShinseishoKanriNo
     * @param 主治医医療機関コード RString
     * @param 主治医コード RString
     * @return 作成料請求区分取得パラメータ
     */
    public static SakuseiryoSeikyuKubunParameter createParameter(ShinseishoKanriNo 申請書管理番号, RString 主治医医療機関コード, RString 主治医コード) {
        return new SakuseiryoSeikyuKubunParameter(申請書管理番号, 主治医医療機関コード, 主治医コード);
    }
}
