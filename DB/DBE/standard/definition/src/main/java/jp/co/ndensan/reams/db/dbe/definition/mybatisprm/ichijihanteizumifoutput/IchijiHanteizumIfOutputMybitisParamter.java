/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ichijihanteizumifoutput;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * バッチ設計_DBE309001_一次判定IF作成のバッチフロークラスです。
 *
 * @reamsid_L DBE-1470-021 wanghui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public final class IchijiHanteizumIfOutputMybitisParamter implements IMyBatisParameter {

    private final List<ShinseishoKanriNo> shinseishoKanriNoList;
    private final RString イメージ区分;

    /**
     * コンストラクタです。
     *
     * @param shinseishoKanriNoList List<RString>
     * @param fayirukuben RString
     */
    private IchijiHanteizumIfOutputMybitisParamter(
            List<ShinseishoKanriNo> shinseishoKanriNoList,
            RString イメージ区分) {
        this.shinseishoKanriNoList = shinseishoKanriNoList;
        this.イメージ区分 = イメージ区分;
    }

    /**
     * コンストラクタです。
     *
     * @param shinseishoKanriNoList List<RString>
     * @param イメージ区分 RString
     * @return IchijiHanteizumIfOutputMybitisParamter
     */
    public static IchijiHanteizumIfOutputMybitisParamter createParam(
            List<ShinseishoKanriNo> shinseishoKanriNoList,
            RString イメージ区分) {
        return new IchijiHanteizumIfOutputMybitisParamter(shinseishoKanriNoList, イメージ区分);
    }
}
