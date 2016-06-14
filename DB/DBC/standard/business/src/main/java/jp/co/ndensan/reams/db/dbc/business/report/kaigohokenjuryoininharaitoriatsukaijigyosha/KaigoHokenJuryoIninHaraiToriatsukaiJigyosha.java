/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kaigohokenjuryoininharaitoriatsukaijigyosha;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3077JuryoininKeiyakuJigyoshaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.hokenjuryoininharaitoriatsukai.HokenJuryoIninHaraiToriatsukaiEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.report.util.barcode.CustomerBarCode;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * ビジネス設計_DBCMN31001_介護保険受領委任払い取扱事業者登録通知書
 *
 * @reamsid_L DBC-2120-060 sunhui
 */
public class KaigoHokenJuryoIninHaraiToriatsukaiJigyosha {

    /**
     * {@link InstanceProvider#create}にて生成した{@link KaigoHokenJuryoIninHaraiToriatsukaiJigyosha}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link KaigoHokenJuryoIninHaraiToriatsukaiJigyosha}のインスタンス
     */
    public static KaigoHokenJuryoIninHaraiToriatsukaiJigyosha createInstance() {

        return InstanceProvider.create(KaigoHokenJuryoIninHaraiToriatsukaiJigyosha.class);
    }

    /**
     * 介護保険受領委任払い取扱事業者登録通知書データ
     *
     * @param entity DbT3077JuryoininKeiyakuJigyoshaEntity
     * @return HokenJuryoIninHaraiToriatsukaiEntity
     */
    public HokenJuryoIninHaraiToriatsukaiEntity setHokenJuryoIninHaraiToriatsukai(DbT3077JuryoininKeiyakuJigyoshaEntity entity) {
        CustomerBarCode code = new CustomerBarCode();
        HokenJuryoIninHaraiToriatsukaiEntity sukaiEntity = new HokenJuryoIninHaraiToriatsukaiEntity();
        if (entity != null) {
            YubinNo 送付先郵便番号 = entity.getSofusakiYubinNo();
            AtenaJusho 送付先住所 = entity.getSofusakiJusho();
            sukaiEntity.set送付先郵便番号(送付先郵便番号);
            sukaiEntity.set送付先住所(送付先住所);
            sukaiEntity.set送付先事業者名称(entity.getSofusakiJigyoshaName());
            sukaiEntity.set送付先部署(entity.getSofusakiBusho());
            if (送付先郵便番号 != null && 送付先住所 != null) {
                sukaiEntity.setバーコード情報(code.convertCustomerBarCode(送付先郵便番号.value(), 送付先住所.value()));
            }
            sukaiEntity.set契約事業者名称(entity.getKeiyakuJigyoshaName());
            sukaiEntity.set契約事業者郵便番号(entity.getKeiyakuJigyoshaYubinNo());
            sukaiEntity.set契約事業者住所(entity.getKeiyakuJigyoshaJusho());
            sukaiEntity.set契約事業者電話番号(entity.getKeiyakuJigyoshaTelNo());
            sukaiEntity.set受領委任払い取扱事業所登録番号(entity.getKeiyakuJigyoshaNo());
            sukaiEntity.set契約開始年月日(entity.getKaishiYMD());
            sukaiEntity.set契約終了年月日(entity.getShuryoYMD());
            sukaiEntity.set契約種類(entity.getKeiyakuShurui());
        }
        return sukaiEntity;
    }
}
