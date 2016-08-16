/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.shokanbaraika1go;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.ShiharaiHohoHenko;
import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.taino.ShiharaiHohoHenkoTaino;
import jp.co.ndensan.reams.db.dbd.business.core.taino.TainoHanteiResultKohen;
import jp.co.ndensan.reams.db.dbd.business.core.taino.TainoKiSummary;
import jp.co.ndensan.reams.db.dbd.definition.core.shiharaihohohenko.ShiharaiHenkoBenmeiRiyuCode;
import jp.co.ndensan.reams.db.dbd.definition.core.shiharaihohohenko.ShiharaiHenkoBenmeiShinsaKekkaKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.shiharaihohohenko.ShiharaiHenkoShuryoShinseiRiyuCode;
import jp.co.ndensan.reams.db.dbd.definition.core.shiharaihohohenko.ShiharaiHenkoShuryoShinseiShinsaKekkaKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.shiharaihohohenko.TainoHanteiKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.shiharaihohohenko.TaishoHanteiKubun;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4022ShiharaiHohoHenkoTainoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.shiharaihohohenko.ShiharaiHohoHenkoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurity.ShichosonSecurityJohoFinder;
import jp.co.ndensan.reams.db.dbz.definition.core.shiharaihohohenko.ShiharaiHenkoKanriKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.shiharaihohohenko.ShiharaiHenkoMukoKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.shiharaihohohenko.ShiharaiHenkoShuryoKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.shiharaihohohenko.ShiharaiHenkoTorokuKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.taino.JikoKubun;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4021ShiharaiHohoHenkoEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 1号償還払い化ダイアログを管理するクラスです。
 *
 * @reamsid_L DBD-3620-041 mawy
 */
public class ShokanBaraiKa1GoManager {

    /**
     * 1号予告者登録新規登録用の支払方法変更を生成します。
     *
     * @param 滞納判定結果 滞納判定結果
     * @param 被保険者番号 被保険者番号
     * @param 予告登録日 予告登録日
     * @param 弁明書提出期限 弁明書提出期限
     * @param 最大履歴番号 最大履歴番号
     * @return 支払方法変更 ShiharaiHohoHenko
     */
    public ShiharaiHohoHenko createShiharaiHohoHenkoFor1号予告者登録(
            TainoHanteiResultKohen 滞納判定結果,
            HihokenshaNo 被保険者番号,
            FlexibleDate 予告登録日,
            FlexibleDate 弁明書提出期限,
            RString 最大履歴番号) {
        ShiharaiHohoHenkoEntity 支払方法変更Entity = new ShiharaiHohoHenkoEntity();
        ShoKisaiHokenshaNo 証記載保険者番号 = ShichosonSecurityJohoFinder.createInstance()
                .getShichosonSecurityJoho(GyomuBunrui.介護事務)
                .get市町村情報()
                .get証記載保険者番号();
        支払方法変更Entity.set支払方法変更Entity(get1号予告者登録の登録Entity(
                被保険者番号,
                予告登録日,
                弁明書提出期限,
                最大履歴番号,
                証記載保険者番号));
        支払方法変更Entity.set支払方法変更滞納Entity(get支払方法変更滞納Entity(
                滞納判定結果,
                TainoHanteiKubun.予告登録.getコード(),
                被保険者番号,
                最大履歴番号,
                証記載保険者番号));
        return new ShiharaiHohoHenko(支払方法変更Entity);
    }

    /**
     * 償還払い化登録新規登録用の支払方法変更を生成します。
     *
     * @param 滞納判定結果 滞納判定結果
     * @param 被保険者番号 被保険者番号
     * @param 提出期限_開始 提出期限_開始
     * @param 変更決定日 変更決定日
     * @param 保険者証提出期限 保険者証提出期限
     * @param 最大履歴番号 最大履歴番号
     * @return 支払方法変更 ShiharaiHohoHenko
     */
    public ShiharaiHohoHenko createShiharaiHohoHenkoFor償還払い化登録(
            TainoHanteiResultKohen 滞納判定結果,
            HihokenshaNo 被保険者番号,
            FlexibleDate 提出期限_開始,
            FlexibleDate 変更決定日,
            FlexibleDate 保険者証提出期限,
            RString 最大履歴番号) {
        ShiharaiHohoHenkoEntity 支払方法変更Entity = new ShiharaiHohoHenkoEntity();
        ShoKisaiHokenshaNo 証記載保険者番号 = ShichosonSecurityJohoFinder.createInstance()
                .getShichosonSecurityJoho(GyomuBunrui.介護事務)
                .get市町村情報()
                .get証記載保険者番号();
        支払方法変更Entity.set支払方法変更Entity(get償還払い化登録の登録Entity(
                被保険者番号,
                提出期限_開始,
                変更決定日,
                保険者証提出期限,
                最大履歴番号,
                証記載保険者番号));
        支払方法変更Entity.set支払方法変更滞納Entity(get支払方法変更滞納Entity(
                滞納判定結果,
                TainoHanteiKubun.償還払化登録.getコード(),
                被保険者番号,
                最大履歴番号,
                証記載保険者番号));
        return new ShiharaiHohoHenko(支払方法変更Entity);
    }

    private DbT4021ShiharaiHohoHenkoEntity get1号予告者登録の登録Entity(
            HihokenshaNo 被保険者番号,
            FlexibleDate 予告登録日,
            FlexibleDate 弁明書提出期限,
            RString 最大履歴番号,
            ShoKisaiHokenshaNo 証記載保険者番号) {
        DbT4021ShiharaiHohoHenkoEntity entity = new DbT4021ShiharaiHohoHenkoEntity();
        entity.setShoKisaiHokenshaNo(証記載保険者番号);
        entity.setHihokenshaNo(被保険者番号);
        entity.setKanriKubun(ShiharaiHenkoKanriKubun._１号償還払い化.getコード());
        entity.setRirekiNo(get最大履歴番号(最大履歴番号));
        entity.setTorokuKubun(ShiharaiHenkoTorokuKubun._１号予告登録者.getコード());
        entity.setShuryoKubun(ShiharaiHenkoShuryoKubun._空.getコード());
        entity.setYokoku_TorokuYMD(予告登録日);
        entity.setYokoku_TsuchiSaiHakkoFlag(false);
        entity.setBemmei_TeishutsuYMD(弁明書提出期限);
        entity.setBemmei_RiyuCode(ShiharaiHenkoBenmeiRiyuCode._空.getコード());
        entity.setBemmei_ShinsaKekkaKubun(ShiharaiHenkoBenmeiShinsaKekkaKubun._空.getコード());
        entity.setShokan_TsuchiSaiHakkoFlag(false);
        entity.setSashitome_Flag(false);
        entity.setShuryoShinsei_RiyuCode(ShiharaiHenkoShuryoShinseiRiyuCode._空.getコード());
        entity.setShuryoShinsei_ShinsaKekkaKubun(ShiharaiHenkoShuryoShinseiShinsaKekkaKubun._空.getコード());
        entity.setMukoKubun(ShiharaiHenkoMukoKubun.有効.getコード());
        entity.setLogicalDeletedFlag(false);
        return entity;
    }

    private DbT4021ShiharaiHohoHenkoEntity get償還払い化登録の登録Entity(
            HihokenshaNo 被保険者番号,
            FlexibleDate 提出期限_開始,
            FlexibleDate 変更決定日,
            FlexibleDate 保険者証提出期限,
            RString 最大履歴番号,
            ShoKisaiHokenshaNo 証記載保険者番号) {
        DbT4021ShiharaiHohoHenkoEntity entity = new DbT4021ShiharaiHohoHenkoEntity();
        entity.setShoKisaiHokenshaNo(証記載保険者番号);
        entity.setHihokenshaNo(被保険者番号);
        entity.setKanriKubun(ShiharaiHenkoKanriKubun._１号償還払い化.getコード());
        entity.setRirekiNo(get最大履歴番号(最大履歴番号));
        entity.setTorokuKubun(ShiharaiHenkoTorokuKubun._１号償還払い化登録.getコード());
        entity.setTekiyoKaishiYMD(提出期限_開始);
        entity.setShuryoKubun(ShiharaiHenkoShuryoKubun._空.getコード());
        entity.setYokoku_TsuchiSaiHakkoFlag(false);
        entity.setBemmei_RiyuCode(ShiharaiHenkoBenmeiRiyuCode._空.getコード());
        entity.setBemmei_ShinsaKekkaKubun(ShiharaiHenkoBenmeiShinsaKekkaKubun._空.getコード());
        entity.setShokan_KetteiYMD(変更決定日);
        entity.setShokan_TsuchiSaiHakkoFlag(false);
        entity.setHihokenshaShoTeishutsuYMD(保険者証提出期限);
        entity.setSashitome_Flag(false);
        entity.setShuryoShinsei_RiyuCode(ShiharaiHenkoShuryoShinseiRiyuCode._空.getコード());
        entity.setShuryoShinsei_ShinsaKekkaKubun(ShiharaiHenkoShuryoShinseiShinsaKekkaKubun._空.getコード());
        entity.setMukoKubun(ShiharaiHenkoMukoKubun.有効.getコード());
        entity.setLogicalDeletedFlag(false);
        return entity;
    }

    private List<DbT4022ShiharaiHohoHenkoTainoEntity> get支払方法変更滞納Entity(
            TainoHanteiResultKohen 滞納判定結果,
            RString 滞納判定区分,
            HihokenshaNo 被保険者番号,
            RString 最大履歴番号,
            ShoKisaiHokenshaNo 証記載保険者番号) {
        List<DbT4022ShiharaiHohoHenkoTainoEntity> 支払方法変更滞納Entity = new ArrayList();
        List<ShiharaiHohoHenkoTaino> 支払方法変更滞納情報 = new ArrayList();
        List<TainoKiSummary> tainoKiSummary = 滞納判定結果.get滞納情報();
        int 連番 = 0;
        for (TainoKiSummary summary : tainoKiSummary) {
            TaishoHanteiKubun 対象管理区分 = get対象管理区分(連番++, summary.get時効区分().getコード(), 支払方法変更滞納情報);
            DbT4022ShiharaiHohoHenkoTainoEntity entity = new DbT4022ShiharaiHohoHenkoTainoEntity();
            entity.setShoKisaiHokenshaNo(証記載保険者番号);
            entity.setHihokenshaNo(被保険者番号);
            entity.setKanriKubun(ShiharaiHenkoKanriKubun._１号償還払い化.getコード());
            entity.setRirekiNo(get最大履歴番号(最大履歴番号));
            entity.setTainoHanteiKubun(滞納判定区分);
            entity.setRenNo(連番++);
            entity.setChoteiNendo(summary.get調定年度());
            entity.setFukaNendo(summary.get賦課年度());
            entity.setTsuchishoNo(summary.get通知書番号());
            entity.setTokucho_fuchoKubun(summary.get徴収方法().getコード());
            entity.setShuno_Ki_Tsuki(summary.get期());
            entity.setTainoHanteiYMD(FlexibleDate.getNowDate());
            entity.setHanteiKijunYMD(滞納判定結果.get滞納判定基準日());
            entity.setJikoKisanYMD(summary.get時効起算日());
            entity.setJikoKisanKubun(summary.get時効起算日区分().getコード());
            entity.setKanno_MinoKubun(summary.get未納完納区分().getコード());
            entity.setJikoKubun(summary.get時効区分().getコード());
            entity.setJikoAtoShunyuKubun(summary.get時効後収入区分().getコード());
            entity.setTaishoKanriKubun(対象管理区分.getコード());
            entity.setChoteigaku(summary.get調定額());
            entity.setKojoGaku(summary.get控除額());
            entity.setTainoGaku(summary.get滞納額());
            entity.setNokigen(new FlexibleDate(summary.get納期限().toDateString()));
            entity.setLogicalDeletedFlag(false);
            支払方法変更滞納Entity.add(entity);
            支払方法変更滞納情報.add(new ShiharaiHohoHenkoTaino(entity));
        }
        return 支払方法変更滞納Entity;
    }

    private int get最大履歴番号(RString 最大履歴番号) {
        if (最大履歴番号.isEmpty()) {
            return 0;
        } else {
            return Integer.parseInt(最大履歴番号.toString());
        }
    }

    private TaishoHanteiKubun get対象管理区分(int 連番, RString 時効区分, List<ShiharaiHohoHenkoTaino> 支払方法変更滞納情報) {
        TaishoHanteiKubun 対象管理区分 = TaishoHanteiKubun._空;
        if (連番 > 1) {
            for (ShiharaiHohoHenkoTaino shiharaiHohoHenkoTaino : 支払方法変更滞納情報) {
                if (shiharaiHohoHenkoTaino.get連番() == 連番 - 1
                        && JikoKubun.時効到来.getコード().equals(shiharaiHohoHenkoTaino.get時効区分())) {
                    対象管理区分 = TaishoHanteiKubun.前回対象;
                } else if (shiharaiHohoHenkoTaino.get連番() == 連番 - 1
                        && JikoKubun.時効未到来.getコード().equals(shiharaiHohoHenkoTaino.get時効区分())
                        && JikoKubun.時効到来.getコード().equals(時効区分)) {
                    対象管理区分 = TaishoHanteiKubun.今回対象;
                }
            }
        } else {
            対象管理区分 = TaishoHanteiKubun.今回対象;
        }
        return 対象管理区分;
    }

}
