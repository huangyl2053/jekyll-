/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.honsanteiidokanendofuka;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * 抽出異動一時Entityクラスです。
 *
 * @reamsid_L DBB-0910-020 zhujun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShotokuIdoTmpEntity implements IDbAccessable {

    private ShikibetsuCode shikibetsuCode;
}
