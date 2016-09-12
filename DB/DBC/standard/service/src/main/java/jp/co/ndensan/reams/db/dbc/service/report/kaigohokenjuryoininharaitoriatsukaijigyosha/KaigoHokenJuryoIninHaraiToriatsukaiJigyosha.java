/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.report.kaigohokenjuryoininharaitoriatsukaijigyosha;

import jp.co.ndensan.reams.db.dbc.business.core.basic.JuryoininKeiyakuJigyosha;
import jp.co.ndensan.reams.db.dbc.business.core.hokenjuryoininharaitoriatsukai.HokenJuryoIninHaraiToriatsukaiResult;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3077JuryoininKeiyakuJigyoshaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.hokenjuryoininharaitoriatsukai.HokenJuryoIninHaraiToriatsukaiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3077JuryoininKeiyakuJigyoshaDac;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.util.barcode.CustomerBarCode;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * ビジネス設計_DBCMN31001_介護保険受領委任払い取扱事業者登録通知書
 *
 * @reamsid_L DBC-2120-060 sunhui
 */
public class KaigoHokenJuryoIninHaraiToriatsukaiJigyosha {

    private final DbT3077JuryoininKeiyakuJigyoshaDac dac;

    /**
     * テスト用コンストラクタです。
     *
     */
    public KaigoHokenJuryoIninHaraiToriatsukaiJigyosha() {
        this.dac = InstanceProvider.create(DbT3077JuryoininKeiyakuJigyoshaDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac DbT3077JuryoininKeiyakuJigyoshaDac
     *
     */
    KaigoHokenJuryoIninHaraiToriatsukaiJigyosha(
            DbT3077JuryoininKeiyakuJigyoshaDac dac) {
        this.dac = dac;
    }

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
     * @param param JuryoininKeiyakuJigyosha
     * @return HokenJuryoIninHaraiToriatsukaiResult
     */
    public HokenJuryoIninHaraiToriatsukaiResult setHokenJuryoIninHaraiToriatsukai(
            JuryoininKeiyakuJigyosha param) {
        CustomerBarCode code = new CustomerBarCode();
        HokenJuryoIninHaraiToriatsukaiResult result = new HokenJuryoIninHaraiToriatsukaiResult();
        HokenJuryoIninHaraiToriatsukaiEntity sukaiEntity = new HokenJuryoIninHaraiToriatsukaiEntity();
        if (param != null) {
            YubinNo 送付先郵便番号 = param.get送付先郵便番号();
            AtenaJusho 送付先住所 = param.get送付先住所();
            sukaiEntity.set送付先郵便番号(送付先郵便番号);
            sukaiEntity.set送付先住所(送付先住所);
            sukaiEntity.set送付先事業者名称(param.get送付先事業者名称());
            sukaiEntity.set送付先部署(param.get送付先部署());
            if (送付先郵便番号 != null && 送付先住所 != null) {
                sukaiEntity.setバーコード情報(code.convertCustomerBarCode(送付先郵便番号.value(), 送付先住所.value()));
            }
            sukaiEntity.set契約事業者名称(param.get契約事業者名称());
            sukaiEntity.set契約事業者郵便番号(param.get契約事業者郵便番号());
            sukaiEntity.set契約事業者住所(param.get契約事業者住所());
            sukaiEntity.set契約事業者電話番号(param.get契約事業者電話番号());
            sukaiEntity.set受領委任払い取扱事業所登録番号(param.get契約事業者番号());
            sukaiEntity.set契約開始年月日(param.get開始年月日());
            sukaiEntity.set契約終了年月日(param.get終了年月日());
            sukaiEntity.set契約種類(param.get契約種類());
        }
        result.setEntity(sukaiEntity);
        return result;
    }

    /**
     * 受領委任契約事業者を管理するクラスです。
     *
     * @param 契約事業者番号 RString
     * @return JuryoininKeiyakuJigyosha
     */
    public JuryoininKeiyakuJigyosha selectByKey(RString 契約事業者番号) {
        DbT3077JuryoininKeiyakuJigyoshaEntity entity = dac.selectByKey(契約事業者番号);
        if (entity == null) {
            return null;
        }
        return new JuryoininKeiyakuJigyosha(entity);
    }
}
