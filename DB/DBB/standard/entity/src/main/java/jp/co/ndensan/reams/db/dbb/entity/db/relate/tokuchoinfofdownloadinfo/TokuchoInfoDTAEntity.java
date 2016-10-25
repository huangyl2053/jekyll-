/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchoinfofdownloadinfo;

import jp.co.ndensan.reams.uz.uza.io.fld.FldField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 異動情報_送信ファイルを格納する
 *
 * @reamsid_L DBB-4240-010 chenhui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class TokuchoInfoDTAEntity {

    @FldField(order = 1, length = 9)
    private RString beforeData;
    @FldField(order = 2, length = 8)
    private RString createDate;

    /**
     * コンストラクタです。
     *
     * @param beforeData RString
     * @param createDate RString
     */
    public TokuchoInfoDTAEntity(RString beforeData, RString createDate) {
        this.beforeData = beforeData;
        this.createDate = createDate;
    }

    /**
     * コンストラクタです。
     *
     */
    public TokuchoInfoDTAEntity() {
    }
}
