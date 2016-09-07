/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.kakushutsuchishosakusei;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2003KibetsuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2006ChoshuYuyoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2007KibetsuChoshuYuyoEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.UrT0705ChoteiKyotsuEntity;

/**
 * 徴収猶予の情報（更正後）の取得Entityクラスです。
 *
 * @reamsid_L DBB-0740-020 xicongwang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChoshuYuyoInfoEntity implements Serializable {

    private DbT2002FukaEntity 介護賦課;
    private DbT2006ChoshuYuyoEntity 介護賦課徴収猶予;
    private DbT2007KibetsuChoshuYuyoEntity 介護期別徴収猶予;
    private DbT2003KibetsuEntity 介護期別;
    private UrT0705ChoteiKyotsuEntity 調定共通介護継承;
}
