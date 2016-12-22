/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosadataoutput;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 申請履歴情報を取得するためのMyBatis用パラメータクラスです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public final class DbT5121MybitisParameter implements IMyBatisParameter {

    private final List<RString> shinseishoKanriNoList;

    private DbT5121MybitisParameter(List<RString> 申請書管理番号リスト) {
        this.shinseishoKanriNoList = 申請書管理番号リスト;
    }

    /**
     * パラメータクラスを取得します。
     *
     * @param 申請書管理番号リスト 申請書管理番号リスト
     * @return パラメータクラス
     */
    public static DbT5121MybitisParameter createParam(List<RString> 申請書管理番号リスト) {
        return new DbT5121MybitisParameter(申請書管理番号リスト);
    }
}
