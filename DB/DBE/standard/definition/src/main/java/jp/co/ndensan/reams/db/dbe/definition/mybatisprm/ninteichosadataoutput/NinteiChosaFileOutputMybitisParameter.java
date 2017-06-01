/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosadataoutput;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author n3509
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public class NinteiChosaFileOutputMybitisParameter implements IMyBatisParameter {

    private final List<RString> shinseishoKanriNoList;

    /**
     * コンストラクタです。
     *
     * @param shinseishoKanriNoList
     */
    public NinteiChosaFileOutputMybitisParameter(List<RString> shinseishoKanriNoList) {
        this.shinseishoKanriNoList = shinseishoKanriNoList;
    }

    /**
     * パラメータを取得します。
     *
     * @param shinseishoKanriNoList
     * @return バッチパラメータ
     */
    public static NinteiChosaFileOutputMybitisParameter createSelectByKeyParam(List<RString> shinseishoKanriNoList) {
        return new NinteiChosaFileOutputMybitisParameter(shinseishoKanriNoList);
    }
}
