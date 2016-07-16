/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shujiihoshushiharai;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.hoshushiharaijunbi.HoshuShiharaiJunbiRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiihoshushiharai.ShujiiHoshuShiharaiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.util.barcode.CustomerBarCode;
import jp.co.ndensan.reams.uz.uza.report.util.barcode.CustomerBarCodeResult;
import lombok.Getter;
import lombok.Setter;

/**
 * 主治医意見書作成報酬支払通知書のEditクラスです。
 *
 * @reamsid_L DBE-1980-020 suguangjun
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShujiiHoshuShiharaiEdit {

    private int index;
    private RString shujiiIryokikanCode = RString.EMPTY;

    /**
     * 主治医意見書作成報酬支払通知書の編集処理です。
     *
     * @param entity 主治医意見書作成報酬支払通知書
     * @param 消費税率 消費税率
     * @param 認証者 認証者
     * @return IkenshoHoshuSeikyuEntity
     */
    public ShujiiHoshuShiharaiEntity getShujiiHoshuShiharaiEntity(HoshuShiharaiJunbiRelateEntity entity, RString 消費税率,
            NinshoshaSource 認証者) {
        ShujiiHoshuShiharaiEntity seikyuEntity = new ShujiiHoshuShiharaiEntity();
        seikyuEntity.set電子公印(認証者.denshiKoin);
        seikyuEntity.set発行日(認証者.hakkoYMD);
        seikyuEntity.set認証者役職名(認証者.ninshoshaYakushokuMei);
        seikyuEntity.set認証者役職名1(認証者.ninshoshaYakushokuMei1);
        seikyuEntity.set公印文字列(認証者.koinMojiretsu);
        seikyuEntity.set認証者役職名2(認証者.ninshoshaYakushokuMei2);
        seikyuEntity.set認証者氏名カナ(認証者.ninshoshaShimeiKakenai);
        seikyuEntity.set認証者氏名掛ける(認証者.ninshoshaShimeiKakeru);
        seikyuEntity.set公印省略(認証者.koinShoryaku);
        seikyuEntity.set郵便番号(entity.getYubinNo());
        seikyuEntity.set住所(entity.getJusho());
        seikyuEntity.set医療機関(entity.getIryoKikanMeisho());
        seikyuEntity.set代表者名(entity.getDaihyoshaName());
        seikyuEntity.set名称付与(DbBusinessConfig.get(ConfigNameDBE.主治医意見書作成報酬支払通知書_宛先敬称, RDate.getNowDate(),
                SubGyomuCode.DBE認定支援));
        seikyuEntity.setバーコード(getバーコード(entity));
        Decimal 税率 = Decimal.ZERO;
        if (消費税率 != null) {
            税率 = new Decimal(消費税率.toString());
        }
        Decimal 単価税込 = entity.getTanka().multiply(税率);
        if (!shujiiIryokikanCode.equals(entity.getShujiiIryoKikanCode())) {
            index = 1;
            if (new Code("1").equals(entity.getIkenshoSakuseiKaisuKubun()) && new Code("1").equals(entity.getZaitakuShisetsuKubun())) {
                seikyuEntity.set在宅新規件数(new RString(index));
                seikyuEntity.set在宅新規単価税込(new RString(単価税込.toString()));
            }
            if (new Code("2").equals(entity.getIkenshoSakuseiKaisuKubun()) && new Code("1").equals(entity.getZaitakuShisetsuKubun())) {
                seikyuEntity.set在宅継続件数(new RString(index));
                seikyuEntity.set在宅継続単価税込(new RString(単価税込.toString()));
            }
            if (new Code("1").equals(entity.getIkenshoSakuseiKaisuKubun()) && new Code("1").equals(entity.getZaitakuShisetsuKubun())) {
                seikyuEntity.set施設新規件数(new RString(index));
                seikyuEntity.set施設新規単価税込(new RString(単価税込.toString()));
            }
            if (new Code("2").equals(entity.getIkenshoSakuseiKaisuKubun()) && new Code("1").equals(entity.getZaitakuShisetsuKubun())) {
                seikyuEntity.set施設継続件数(new RString(index));
                seikyuEntity.set施設継続単価税込(new RString(単価税込.toString()));
            }
            seikyuEntity.set検診料等の件数(new RString(index));
            seikyuEntity.set検診料等の単価税込(RString.EMPTY);
            Decimal 検診料等の金額 = new Decimal(entity.getIkenshoBettoShinryohi()).multiply(税率);
            seikyuEntity.set検診料等の金額(new RString(検診料等の金額.toString()));
        }
        getIkenshoHoshuSeikyuEntity(entity, seikyuEntity, 単価税込);
        shujiiIryokikanCode = entity.getShujiiIryoKikanCode();
        Decimal 新規在宅計 = Decimal.ZERO;
        Decimal 新規施設計 = Decimal.ZERO;
        Decimal 更新在宅計 = Decimal.ZERO;
        Decimal 更新施設計 = Decimal.ZERO;
        if (entity.getTanka() != null) {
            新規在宅計 = new Decimal(seikyuEntity.get在宅新規件数().toString()).multiply(単価税込);
            新規施設計 = new Decimal(seikyuEntity.get在宅継続件数().toString()).multiply(単価税込);
            更新在宅計 = new Decimal(seikyuEntity.get施設新規件数().toString()).multiply(単価税込);
            更新施設計 = new Decimal(seikyuEntity.get施設継続件数().toString()).multiply(単価税込);
        }
        seikyuEntity.set在宅新規合計(new RString(新規在宅計.toString()));
        seikyuEntity.set在宅継続合計(new RString(新規施設計.toString()));
        seikyuEntity.set施設新規合計(new RString(更新在宅計.toString()));
        seikyuEntity.set施設継続合計(new RString(更新施設計.toString()));
        Decimal 合計 = 新規在宅計.add(新規施設計).add(更新在宅計).add(更新施設計);
        Decimal 合計金額 = 合計.multiply(new Decimal(seikyuEntity.get検診料等の金額().toString()));
        seikyuEntity.set合計金額(new RString(合計金額.toString()));
        return seikyuEntity;
    }

    private ShujiiHoshuShiharaiEntity getIkenshoHoshuSeikyuEntity(HoshuShiharaiJunbiRelateEntity entity,
            ShujiiHoshuShiharaiEntity seikyuEntity, Decimal 単価税込) {
        if (shujiiIryokikanCode.equals(entity.getShinsakaiIinCode())) {
            if (new Code("1").equals(entity.getIkenshoSakuseiKaisuKubun()) && new Code("1").equals(entity.getZaitakuShisetsuKubun())) {
                index++;
                seikyuEntity.set在宅新規件数(new RString(index));
                seikyuEntity.set在宅新規単価税込(new RString(単価税込.toString()));
            }
            if (new Code("2").equals(entity.getIkenshoSakuseiKaisuKubun()) && new Code("1").equals(entity.getZaitakuShisetsuKubun())) {
                index++;
                seikyuEntity.set在宅継続件数(new RString(index));
                seikyuEntity.set在宅継続単価税込(new RString(単価税込.toString()));
            }
            if (new Code("1").equals(entity.getIkenshoSakuseiKaisuKubun()) && new Code("1").equals(entity.getZaitakuShisetsuKubun())) {
                index++;
                seikyuEntity.set施設新規件数(new RString(index));
                seikyuEntity.set施設新規単価税込(new RString(単価税込.toString()));
            }
            if (new Code("2").equals(entity.getIkenshoSakuseiKaisuKubun()) && new Code("1").equals(entity.getZaitakuShisetsuKubun())) {
                index++;
                seikyuEntity.set施設継続件数(new RString(index));
                seikyuEntity.set施設継続単価税込(new RString(単価税込.toString()));
            }
        }
        return seikyuEntity;
    }

    /**
     * バーコードの編集処理です。
     *
     * @param entity バーコード
     * @return RString
     */
    public static RString getバーコード(HoshuShiharaiJunbiRelateEntity entity) {
        CustomerBarCode code = new CustomerBarCode();
        CustomerBarCodeResult result = code.convertCustomerBarCode(entity.getYubinNo().value(), entity.getJusho());
        RString バーコード = RString.EMPTY;
        if (result != null) {
            バーコード = result.getCustomerBarCode();
        }
        return バーコード;
    }
}
