/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchosoufujohosakuseibatch;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * DBB-1840-040バッチ設計_DBBBT82001_特徴送付情報作成の特徴依頼情報件数表の発行のクラスです。
 *
 * @reamsid_L DBB-1840-040 xuzhao
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class TokuChoIraiKensu {

    private RString 構成市町村コード;
    private RString dT特別徴収義務者コード;
    private int 件数;
    private RString 金額1;
    private RString 金額2;
    private RString 市町村名称;

}
