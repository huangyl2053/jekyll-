/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;

/**
 * イメージ情報の識別子です。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class ImageIdentifier implements Serializable {

    private final ShinseishoKanriNo 申請書管理番号;
    private final int 取込ページ番号;
    private final Code 原本マスク分;

    /**
     * コンストラクタです。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 取込ページ番号 取込ページ番号
     * @param 原本マスク分 原本マスク分
     */
    public ImageIdentifier(ShinseishoKanriNo 申請書管理番号,
            int 取込ページ番号,
            Code 原本マスク分) {
        this.申請書管理番号 = 申請書管理番号;
        this.取込ページ番号 = 取込ページ番号;
        this.原本マスク分 = 原本マスク分;
    }
}
