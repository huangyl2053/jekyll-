/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.mybatisprm.basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * GaibuRenkeiDataoutputJohoMapperのパラメータです。
 */
@lombok.Getter
public class GaibuRenkeiDataoutputJohoMapperParameter implements IMyBatisParameter {

    private boolean searchByShinseishoKanriNos;
    private List<RString> shinseishoKanriNos;

    private GaibuRenkeiDataoutputJohoMapperParameter() {
    }

    /**
     * @param shinseishoKanriNos 申請書管理番号（複数）
     * @return 指定の申請書管理番号に該当する要素をすべて検索するためのパラメータ
     */
    public static GaibuRenkeiDataoutputJohoMapperParameter searchByShinseishoKanriNos(
            Collection<? extends RString> shinseishoKanriNos) {
        GaibuRenkeiDataoutputJohoMapperParameter p = new GaibuRenkeiDataoutputJohoMapperParameter();
        p.searchByShinseishoKanriNos = true;
        p.shinseishoKanriNos = new ArrayList<>(shinseishoKanriNos);
        return p;
    }
}
