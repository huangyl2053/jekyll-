/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatis.param.shujiiikenshotoroku;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;

/**
 * 主治医意見書登録のパラメータクラス
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class ShujiiIkenshoTorokuMapperParameter {

    private final ShinseishoKanriNo 管理番号;
    private final int 履歴番号;
    private final LasdecCode 市町村コード;

    /**
     * コンストラクタです。
     *
     * @param 管理番号 管理番号
     * @param 履歴番号 履歴番号
     * @param 市町村コード 市町村コード
     */
    private ShujiiIkenshoTorokuMapperParameter(
            ShinseishoKanriNo 管理番号,
            int 履歴番号,
            LasdecCode 市町村コード) {
        this.管理番号 = 管理番号;
        this.履歴番号 = 履歴番号;
        this.市町村コード = 市町村コード;
    }

    /**
     * 主治医意見書登録パラメータークラス作成
     *
     * @param 管理番号 管理番号
     * @param 履歴番号 履歴番号
     * @param 市町村コード 市町村コード
     * @return 主治医意見書登録パラメータークラス
     */
    public static ShujiiIkenshoTorokuMapperParameter createShujiiIkenshoTorokuMapperParameter(
            ShinseishoKanriNo 管理番号,
            int 履歴番号,
            LasdecCode 市町村コード) {

        return new ShujiiIkenshoTorokuMapperParameter(管理番号, 履歴番号, 市町村コード);
    }

}
