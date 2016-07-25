/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shujiihoshushiharai;

import java.util.Map;
import jp.co.ndensan.reams.db.dbe.business.core.chosahoshushiharai.ChosaHoshuShiharaiEdit;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hoshushiharaijunbi.HoshuShiharaiJunbiRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiihoshushiharai.ShujiiHoshuShiharaiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoSakuseiKaisuKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.ZaitakuShisetsuKubun;
import jp.co.ndensan.reams.ua.uax.business.core.koza.Koza;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
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
     * @param 通知文 通知文
     * @param 口座情報 口座情報
     * @return IkenshoHoshuSeikyuEntity
     */
    public ShujiiHoshuShiharaiEntity getShujiiHoshuShiharaiEntity(HoshuShiharaiJunbiRelateEntity entity, RString 消費税率,
            NinshoshaSource 認証者, Map<Integer, RString> 通知文, Koza 口座情報) {
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
        seikyuEntity.set通知文1(通知文.get(1));
        seikyuEntity.set通知文2(通知文.get(2));
        if (口座情報 != null) {
            seikyuEntity.set種別(口座情報.get預金種別().get預金種別名称());
            seikyuEntity.set番号(口座情報.get口座番号());
            seikyuEntity.set金融機関(口座情報.getCombined金融機関名and支店名());
            seikyuEntity.set名議人(口座情報.get口座名義人().value());
        }
        seikyuEntity.set郵便番号(entity.getYubinNo());
        seikyuEntity.set住所(entity.getJusho());
        seikyuEntity.set医療機関(entity.getIryoKikanMeisho());
        seikyuEntity.set代表者名(entity.getDaihyoshaName());
        seikyuEntity.set名称付与(DbBusinessConfig.get(ConfigNameDBE.主治医意見書作成報酬支払通知書_宛先敬称, RDate.getNowDate(),
                SubGyomuCode.DBE認定支援));
        seikyuEntity.setバーコード(ChosaHoshuShiharaiEdit.getバーコード(entity));
        seikyuEntity.setその他(entity.getShujiiIryoKikanCode());
        Decimal 税率 = rstringToDecimal(消費税率);
        Decimal 単価税込 = entity.getTanka().multiply(税率).roundUpTo(0);
        if (!shujiiIryokikanCode.equals(entity.getShujiiIryoKikanCode())) {
            index = 1;
            if (entity.getIkenshoSakuseiKaisuKubun() != null && entity.getZaitakuShisetsuKubun() != null
                    && IkenshoSakuseiKaisuKubun.初回.getコード().equals(entity.getIkenshoSakuseiKaisuKubun().value())
                    && ZaitakuShisetsuKubun.在宅.getコード().equals(entity.getZaitakuShisetsuKubun().value())) {
                seikyuEntity.set在宅新規件数(intToRString(index));
                seikyuEntity.set在宅新規単価税込(decimalToRString(単価税込));
            }
            if (entity.getIkenshoSakuseiKaisuKubun() != null && entity.getZaitakuShisetsuKubun() != null
                    && IkenshoSakuseiKaisuKubun._2回目以降.getコード().equals(entity.getIkenshoSakuseiKaisuKubun().value())
                    && ZaitakuShisetsuKubun.在宅.getコード().equals(entity.getZaitakuShisetsuKubun().value())) {
                seikyuEntity.set在宅継続件数(intToRString(index));
                seikyuEntity.set在宅継続単価税込(decimalToRString(単価税込));
            }
            if (entity.getIkenshoSakuseiKaisuKubun() != null && entity.getZaitakuShisetsuKubun() != null
                    && IkenshoSakuseiKaisuKubun.初回.getコード().equals(entity.getIkenshoSakuseiKaisuKubun().value())
                    && ZaitakuShisetsuKubun.施設.getコード().equals(entity.getZaitakuShisetsuKubun().value())) {
                seikyuEntity.set施設新規件数(intToRString(index));
                seikyuEntity.set施設新規単価税込(decimalToRString(単価税込));
            }
            if (entity.getIkenshoSakuseiKaisuKubun() != null && entity.getZaitakuShisetsuKubun() != null
                    && IkenshoSakuseiKaisuKubun._2回目以降.getコード().equals(entity.getIkenshoSakuseiKaisuKubun().value())
                    && ZaitakuShisetsuKubun.施設.getコード().equals(entity.getZaitakuShisetsuKubun().value())) {
                seikyuEntity.set施設継続件数(intToRString(index));
                seikyuEntity.set施設継続単価税込(decimalToRString(単価税込));
            }
            seikyuEntity.set検診料等の件数(intToRString(index));
            seikyuEntity.set検診料等の単価税込(RString.EMPTY);
            Decimal 検診料等の金額 = new Decimal(entity.getIkenshoBettoShinryohi()).multiply(税率).roundUpTo(0);
            seikyuEntity.set検診料等の金額(new RString(検診料等の金額.toString()));
        }
        getIkenshoHoshuSeikyuEntity(entity, seikyuEntity, 単価税込);
        shujiiIryokikanCode = entity.getShujiiIryoKikanCode();
        Decimal 新規在宅計 = rstringToDecimal(seikyuEntity.get在宅新規件数()).multiply(単価税込);
        Decimal 新規施設計 = rstringToDecimal(seikyuEntity.get在宅継続件数()).multiply(単価税込);
        Decimal 更新在宅計 = rstringToDecimal(seikyuEntity.get施設新規件数()).multiply(単価税込);
        Decimal 更新施設計 = rstringToDecimal(seikyuEntity.get施設継続件数()).multiply(単価税込);
        seikyuEntity.set在宅新規合計(decimalToRString(新規在宅計.roundUpTo(0)));
        seikyuEntity.set在宅継続合計(decimalToRString(新規施設計.roundUpTo(0)));
        seikyuEntity.set施設新規合計(decimalToRString(更新在宅計.roundUpTo(0)));
        seikyuEntity.set施設継続合計(decimalToRString(更新施設計.roundUpTo(0)));
        Decimal 合計 = 新規在宅計.add(新規施設計).add(更新在宅計).add(更新施設計);
        Decimal 合計金額 = 合計.add(rstringToDecimal(seikyuEntity.get検診料等の金額()));
        seikyuEntity.set合計金額(decimalToRString(合計金額.roundUpTo(0)));
        return seikyuEntity;
    }

    private ShujiiHoshuShiharaiEntity getIkenshoHoshuSeikyuEntity(HoshuShiharaiJunbiRelateEntity entity,
            ShujiiHoshuShiharaiEntity seikyuEntity, Decimal 単価税込) {
        if (shujiiIryokikanCode.equals(entity.getShinsakaiIinCode())) {
            if (entity.getIkenshoSakuseiKaisuKubun() != null && entity.getZaitakuShisetsuKubun() != null
                    && IkenshoSakuseiKaisuKubun.初回.getコード().equals(entity.getIkenshoSakuseiKaisuKubun().value())
                    && ZaitakuShisetsuKubun.在宅.getコード().equals(entity.getZaitakuShisetsuKubun().value())) {
                index++;
                seikyuEntity.set在宅新規件数(intToRString(index));
                seikyuEntity.set在宅新規単価税込(decimalToRString(単価税込));
            }
            if (entity.getIkenshoSakuseiKaisuKubun() != null && entity.getZaitakuShisetsuKubun() != null
                    && IkenshoSakuseiKaisuKubun._2回目以降.getコード().equals(entity.getIkenshoSakuseiKaisuKubun().value())
                    && ZaitakuShisetsuKubun.在宅.getコード().equals(entity.getZaitakuShisetsuKubun().value())) {
                index++;
                seikyuEntity.set在宅継続件数(intToRString(index));
                seikyuEntity.set在宅継続単価税込(decimalToRString(単価税込));
            }
            if (entity.getIkenshoSakuseiKaisuKubun() != null && entity.getZaitakuShisetsuKubun() != null
                    && IkenshoSakuseiKaisuKubun.初回.getコード().equals(entity.getIkenshoSakuseiKaisuKubun().value())
                    && ZaitakuShisetsuKubun.施設.getコード().equals(entity.getZaitakuShisetsuKubun().value())) {
                index++;
                seikyuEntity.set施設新規件数(intToRString(index));
                seikyuEntity.set施設新規単価税込(decimalToRString(単価税込));
            }
            if (entity.getIkenshoSakuseiKaisuKubun() != null && entity.getZaitakuShisetsuKubun() != null
                    && IkenshoSakuseiKaisuKubun._2回目以降.getコード().equals(entity.getIkenshoSakuseiKaisuKubun().value())
                    && ZaitakuShisetsuKubun.施設.getコード().equals(entity.getZaitakuShisetsuKubun().value())) {
                index++;
                seikyuEntity.set施設継続件数(intToRString(index));
                seikyuEntity.set施設継続単価税込(decimalToRString(単価税込));
            }
        }
        return seikyuEntity;
    }

    private RString decimalToRString(Decimal date) {
        if (date == null) {
            return RString.EMPTY;
        }
        return new RString(date.toString());
    }

    private RString intToRString(int date) {
        return new RString(date);
    }

    private Decimal rstringToDecimal(RString date) {
        if (RString.isNullOrEmpty(date)) {
            return Decimal.ZERO;
        }
        return new Decimal(date.toString());
    }
}
