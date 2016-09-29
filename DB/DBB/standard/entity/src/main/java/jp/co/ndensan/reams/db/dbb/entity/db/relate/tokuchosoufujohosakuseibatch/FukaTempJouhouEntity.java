/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchosoufujohosakuseibatch;

import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * DBB-1840-040バッチ設計_DBBBT82001_特徴送付情報作成の賦課Tempのクラスです。
 *
 * @reamsid_L DBB-1840-040 xuzhao
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class FukaTempJouhouEntity {

    private RString 期;
    private RString 調定額;
    private DbT2002FukaEntity 賦課情報;
}
