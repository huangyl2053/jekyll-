/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.enkitsuchisho;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;

/**
 * 帳票設計_DBD522001_要介護認定延期通知書タイトルバッチパラメタークラスです．
 *
 * @reamsid_L DBD-1410-020 chenxin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class EnkiTsuchishoJyohoMybatisParameter implements IMyBatisParameter {

    private List<ShinseishoKanriNo> shinseishokanribangorisuto;

    /**
     * コンストラクタです。
     *
     * @param 申請書管理番号リスト shinseishokanribangorisuto
     */
    public EnkiTsuchishoJyohoMybatisParameter(List<ShinseishoKanriNo> 申請書管理番号リスト) {
        this.shinseishokanribangorisuto = 申請書管理番号リスト;
    }
}
