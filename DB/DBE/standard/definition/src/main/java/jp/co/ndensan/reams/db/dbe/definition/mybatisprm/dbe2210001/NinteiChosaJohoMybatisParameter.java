/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.dbe2210001;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 *
 * 要介護認定調査督促状のMybatisパラメータクラスです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class NinteiChosaJohoMybatisParameter implements IMyBatisParameter {

    private final int temp_認定調査依頼履歴番号;
    private final RString temp_認定調査委託先コード;
    private final ShinseishoKanriNo temp_申請書管理番号;

    /**
     * コンストラクタです。
     * 
     * @param temp_認定調査依頼履歴番号 基準日
     * @param temp_認定調査委託先コード 認定調査督促期限日数
     * @param temp_申請書管理番号 印刷済対象者
     */
    public NinteiChosaJohoMybatisParameter(int temp_認定調査依頼履歴番号,
            RString temp_認定調査委託先コード,
            ShinseishoKanriNo temp_申請書管理番号
          ) {
        this.temp_認定調査依頼履歴番号 = temp_認定調査依頼履歴番号;
        this.temp_認定調査委託先コード = temp_認定調査委託先コード;
        this.temp_申請書管理番号 = temp_申請書管理番号;
    }

}
