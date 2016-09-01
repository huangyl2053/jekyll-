/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.hanyolistfukadaicho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2003KibetsuEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.UrT0705ChoteiKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbV4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt250FindAtesakiEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBBBT22002_汎用リスト 賦課台帳Entityのクラスです。
 *
 * @reamsid_L DBB-1900-030 zhaowei
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanyoListFukaDaichoEntity {

    private DbT2002FukaEntity 介護賦課;
    private List<UrT0705ChoteiKyotsuEntity> 調定共通リスト;
    private List<DbT2003KibetsuEntity> 介護期別リスト;
    private DbT2001ChoshuHohoEntity 介護徴収方法;
    private DbV4001JukyushaDaichoEntity 受給者台帳Newest;
    private DbV1001HihokenshaDaichoEntity 被保険者台帳管理Newest;
    private UaFt200FindShikibetsuTaishoEntity 宛名;
    private UaFt250FindAtesakiEntity 宛先;

    private boolean 本算定後;
    private RString 特別徴収義務者コード;

    /**
     * コンストラクタです。
     */
    public HanyoListFukaDaichoEntity() {
        介護賦課 = new DbT2002FukaEntity();
        調定共通リスト = new ArrayList<>();
        介護期別リスト = new ArrayList<>();
        介護徴収方法 = new DbT2001ChoshuHohoEntity();
        受給者台帳Newest = new DbV4001JukyushaDaichoEntity();
        被保険者台帳管理Newest = new DbV1001HihokenshaDaichoEntity();
        宛名 = new UaFt200FindShikibetsuTaishoEntity();
        宛先 = new UaFt250FindAtesakiEntity();
    }
}
