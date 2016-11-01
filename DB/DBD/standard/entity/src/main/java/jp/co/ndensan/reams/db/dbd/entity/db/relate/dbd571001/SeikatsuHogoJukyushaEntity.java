/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd571001;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * バッチ設計_DBD571001_受給者台帳を取得するEntityクラスです。
 *
 * @reamsid_L DBD-1760-020 panxiaobo
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SeikatsuHogoJukyushaEntity {

    private ShikibetsuCode 生活保護情報_識別コード;
    private RString 生活保護情報_業務コード;
    private FlexibleDate 生活保護情報_受給開始日;
    private FlexibleDate 生活保護情報_受給廃止日;
    private RString 生活保護情報_扶助種類コード;
}
