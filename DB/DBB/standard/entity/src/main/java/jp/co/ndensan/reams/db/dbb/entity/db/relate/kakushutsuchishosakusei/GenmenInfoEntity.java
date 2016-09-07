/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.kakushutsuchishosakusei;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2003KibetsuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2004GemmenEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.UrT0705ChoteiKyotsuEntity;

/**
 * 減免の情報（更正後）を取得Entityクラスです。
 *
 * @reamsid_L DBB-0740-020 xicongwang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class GenmenInfoEntity implements Serializable {

    private DbT2002FukaEntity 介護賦課;
    private DbT2004GemmenEntity 介護賦課減免;
    private DbT2003KibetsuEntity 介護期別;
    private UrT0705ChoteiKyotsuEntity 調定共通介護継承;
}
