/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchosoufujohosakuseibatch;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * DBB-1840-040バッチ設計_DBBBT82001_特徴送付情報作成の特徴異動情報件数表の発行のクラスです。
 *
 * @reamsid_L DBB-1840-040 xuzhao
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class TokuChoYidoKensu {

    private RString 構成市町村コード;
    private RString DT特別徴収義務者コード;
    private int 件数;
    private int 資格件数;
    private int 住所地特例件数;
    private int 仮徴収額変更件数;
    private int 追加依頼件数;
    private RString 市町村名称;
}
