/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.image;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;

/**
 * イメージ情報の識別子です。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class ImageIdentifier implements Serializable {

    private final ShinseishoKanriNo 申請書管理番号;
    private final RDateTime イメージ共有ファイルID;

    /**
     * コンストラクタです。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param イメージ共有ファイルID イメージ共有ファイルID
     */
    public ImageIdentifier(ShinseishoKanriNo 申請書管理番号,
            RDateTime イメージ共有ファイルID) {
        this.申請書管理番号 = 申請書管理番号;
        this.イメージ共有ファイルID = イメージ共有ファイルID;
    }
}
