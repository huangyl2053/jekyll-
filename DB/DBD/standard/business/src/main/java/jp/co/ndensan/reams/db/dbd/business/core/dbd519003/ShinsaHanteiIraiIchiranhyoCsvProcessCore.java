/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.dbd519003;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.chohyoshuchiryokuyoshiseijyoho.ChohyoShuchiryokuyoShiseiJyohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd5190003.ShinsaHanteiIraiIchiranhyoCsvEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.NinteiShinseiKubunShinsei;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiYukoKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShinseiTodokedeDaikoKubunCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 資格喪失（死亡）データの業務処理クラスです。
 *
 * @reamsid_L DBD-2110-010 LDNS shaotw
 */
public class ShinsaHanteiIraiIchiranhyoCsvProcessCore {

    /**
     * 資格喪失（死亡）データのCSVEntityを作成する。
     *
     * @param entity 帳票出力用申請情報Entity
     * @return 資格喪失（死亡）データのCSVEntity
     */
    public ShinsaHanteiIraiIchiranhyoCsvEntity toCsvEntity(ChohyoShuchiryokuyoShiseiJyohoEntity entity) {
        ShinsaHanteiIraiIchiranhyoCsvEntity csvEntity = new ShinsaHanteiIraiIchiranhyoCsvEntity();
        csvEntity.set識別コード(entity.get識別コード().value());
        csvEntity.set保険者番号(entity.get証記載保険者番号().value());
        csvEntity.set被保険者番号(entity.get被保険者番号().value());
        FlexibleDate date = entity.get認定申請年月日();
        FlexibleDate newdate = new FlexibleDate(date.getYearValue(), date.getMonthValue(), 1);
        csvEntity.set認定申請日(new RString(newdate.wareki().toString()));
        csvEntity.set枝番(entity.get枝番());
        csvEntity.set申請区分法令コード(new RString(NinteiShinseiKubunShinsei.職権.toString()));
        csvEntity.set申請区分申請時コード(new RString(NinteiShinseiKubunShinsei.資格喪失_死亡.toString()));
        csvEntity.set取下区分コード(new RString(NinteiShinseiYukoKubunCode.有効.toString()));
        csvEntity.set被保険者区分コード(HihokenshaKubunCode.toValue(entity.get被保険者区分コード()).get名称());
        csvEntity.set申請代行区分コード(ShinseiTodokedeDaikoKubunCode.toValue(entity.get申請届出代行区分コード().value()).get名称());
        if (entity.get生年月日() != null) {
            csvEntity.set生年月日(entity.get生年月日().wareki().toDateString());
        }
        if (entity.get性別() != null) {
            csvEntity.set性別コード(Seibetsu.toValue(entity.get性別()).get名称());
        }
        if (entity.get前回要介護状態区分コード() != null) {
            csvEntity.set前回の認定審査会結果(YokaigoJotaiKubun09.toValue(entity.get前回要介護状態区分コード().value()).get名称());
        }
        return csvEntity;
    }
}
