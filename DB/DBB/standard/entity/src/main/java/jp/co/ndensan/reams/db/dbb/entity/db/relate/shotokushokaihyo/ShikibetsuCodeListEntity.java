/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokushokaihyo;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;

/**
 * 対象外の住民情報を更新のクラスです。
 *
 * @reamsid_L DBB-1720-040 lijunjun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShikibetsuCodeListEntity {

    private List<ShikibetsuCode> 識別コードList;
}
