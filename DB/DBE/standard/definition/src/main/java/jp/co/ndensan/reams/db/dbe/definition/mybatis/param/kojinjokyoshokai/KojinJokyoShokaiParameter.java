/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatis.param.kojinjokyoshokai;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;

/**
 * 要介護認定個人状況照会のMyBatis用パラメータクラスです。
 *
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class KojinJokyoShokaiParameter {

    private ShinseishoKanriNo shinseishoKanriNo;

    /**
     * コンストラクタです。
     *
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private KojinJokyoShokaiParameter(ShinseishoKanriNo shinseishoKanriNo) {
        this.shinseishoKanriNo = shinseishoKanriNo;
    }

    /**
     * 一覧検索用のパラメータを生成します。
     *
     * @param shinseishoKanriNo 申請書管理番号
     * @return 要介護認定個人状況照会パラメータ
     */
    public static KojinJokyoShokaiParameter createSelectByKeyParam(ShinseishoKanriNo shinseishoKanriNo) {

        return new KojinJokyoShokaiParameter(shinseishoKanriNo);
    }

}
