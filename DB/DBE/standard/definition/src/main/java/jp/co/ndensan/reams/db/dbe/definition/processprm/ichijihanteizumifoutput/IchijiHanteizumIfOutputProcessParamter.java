/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.processprm.ichijihanteizumifoutput;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ichijihanteizumifoutput.IchijiHanteizumIfOutputMybitisParamter;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * バッチ設計_DBE309001_一次判定IF作成のバッチフロークラスです。
 *
 * @reamsid_L DBE-1470-021 wanghui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class IchijiHanteizumIfOutputProcessParamter implements IBatchProcessParameter {

    private final List<ShinseishoKanriNo> shinseishoKanriNoList;
    private RString イメージ区分;

    /**
     * コンストラクタです。
     *
     * @param 申請書管理番号リスト List<RString>
     */
    public IchijiHanteizumIfOutputProcessParamter(
            List<ShinseishoKanriNo> 申請書管理番号リスト) {
        this.shinseishoKanriNoList = 申請書管理番号リスト;
    }

    /**
     * mybatisのパラメータを生成します。
     *
     * @return IchijiHanteizumIfOutputMybitisParamter
     */
    public IchijiHanteizumIfOutputMybitisParamter toIchijiHanteizumIfOutputMybitisParamter() {
        return IchijiHanteizumIfOutputMybitisParamter.createParam(shinseishoKanriNoList, イメージ区分);
    }
}
