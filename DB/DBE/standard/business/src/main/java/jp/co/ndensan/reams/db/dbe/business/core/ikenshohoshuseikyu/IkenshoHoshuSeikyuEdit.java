/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ikenshohoshuseikyu;

import java.util.Map;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hoshushiharaijunbi.HoshuShiharaiJunbiRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ikenshohoshuseikyu.IkenshoHoshuSeikyuEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoSakuseiKaisuKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.ZaitakuShisetsuKubun;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 主治医意見書作成報酬請求書のEditクラスです。
 *
 * @reamsid_L DBE-1980-020 suguangjun
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IkenshoHoshuSeikyuEdit {

    private int index;
    private RString shujiiIryokikanCode = RString.EMPTY;

    /**
     * 主治医意見書作成報酬請求書の編集処理です。
     *
     * @param entity 主治医意見書作成報酬請求書
     * @param 消費税率 消費税率
     * @param 通知文 通知文
     * @return IkenshoHoshuSeikyuEntity
     */
    public IkenshoHoshuSeikyuEntity getIkenshoHoshuSeikyuEntity(HoshuShiharaiJunbiRelateEntity entity, RString 消費税率,
            Map<Integer, RString> 通知文) {
        IkenshoHoshuSeikyuEntity seikyuEntity = new IkenshoHoshuSeikyuEntity();
        seikyuEntity.set郵便番号(entity.getYubinNo());
        seikyuEntity.set住所(entity.getJusho());
        seikyuEntity.set医療機関(entity.getIryoKikanMeisho());
        seikyuEntity.set代表者名(entity.getDaihyoshaName());
        seikyuEntity.set帳票タイトル(DbBusinessConfig.get(ConfigNameDBE.主治医意見書作成報酬請求書, RDate.getNowDate(),
                SubGyomuCode.DBE認定支援));
        seikyuEntity.set通知文1(通知文.get(1));
        seikyuEntity.set通知文2(通知文.get(2));
        Decimal 単価 = entity.getTanka();
        if (!shujiiIryokikanCode.equals(entity.getShujiiIryoKikanCode())) {
            index = 1;
            if (entity.getIkenshoSakuseiKaisuKubun() != null && entity.getZaitakuShisetsuKubun() != null
                    && IkenshoSakuseiKaisuKubun.初回.getコード().equals(entity.getIkenshoSakuseiKaisuKubun().value())
                    && ZaitakuShisetsuKubun.在宅.getコード().equals(entity.getZaitakuShisetsuKubun().value())) {
                seikyuEntity.set新規在宅件数(intToRString(index));
                seikyuEntity.set新規在宅単価(decimalToRString(単価));
            }
            if (entity.getIkenshoSakuseiKaisuKubun() != null && entity.getZaitakuShisetsuKubun() != null
                    && IkenshoSakuseiKaisuKubun.初回.getコード().equals(entity.getIkenshoSakuseiKaisuKubun().value())
                    && ZaitakuShisetsuKubun.施設.getコード().equals(entity.getZaitakuShisetsuKubun().value())) {
                seikyuEntity.set新規施設件数(intToRString(index));
                seikyuEntity.set新規施設単価(decimalToRString(単価));
            }
            if (entity.getIkenshoSakuseiKaisuKubun() != null && entity.getZaitakuShisetsuKubun() != null
                    && IkenshoSakuseiKaisuKubun._2回目以降.getコード().equals(entity.getIkenshoSakuseiKaisuKubun().value())
                    && ZaitakuShisetsuKubun.在宅.getコード().equals(entity.getZaitakuShisetsuKubun().value())) {
                seikyuEntity.set更新在宅件数(intToRString(index));
                seikyuEntity.set更新在宅単価(decimalToRString(単価));
            }
            if (entity.getIkenshoSakuseiKaisuKubun() != null && entity.getZaitakuShisetsuKubun() != null
                    && IkenshoSakuseiKaisuKubun._2回目以降.getコード().equals(entity.getIkenshoSakuseiKaisuKubun().value())
                    && ZaitakuShisetsuKubun.施設.getコード().equals(entity.getZaitakuShisetsuKubun().value())) {
                seikyuEntity.set更新施設件数(intToRString(index));
                seikyuEntity.set更新施設単価(decimalToRString(単価));
            }
        }
        getIkenshoHoshuSeikyuEntity(entity, seikyuEntity, 単価);
        shujiiIryokikanCode = entity.getShujiiIryoKikanCode();
        Decimal 新規在宅計 = 単価.multiply(rstringToInt(seikyuEntity.get新規在宅件数()));
        Decimal 新規施設計 = 単価.multiply(rstringToInt(seikyuEntity.get新規施設件数()));
        Decimal 更新在宅計 = 単価.multiply(rstringToInt(seikyuEntity.get更新在宅件数()));
        Decimal 更新施設計 = 単価.multiply(rstringToInt(seikyuEntity.get更新施設件数()));
        seikyuEntity.set新規在宅計(decimalToRString(新規在宅計));
        seikyuEntity.set新規施設計(decimalToRString(新規施設計));
        seikyuEntity.set更新在宅計(decimalToRString(更新在宅計));
        seikyuEntity.set更新施設計(decimalToRString(更新施設計));
        Decimal 作成件数合計 = Decimal.ZERO;
        作成件数合計 = 作成件数合計.add(rstringToInt(seikyuEntity.get新規在宅件数())).add(rstringToInt(seikyuEntity.get新規施設件数()))
                .add(rstringToInt(seikyuEntity.get更新在宅件数())).add(rstringToInt(seikyuEntity.get更新施設件数()));
        seikyuEntity.set作成件数合計(decimalToRString(作成件数合計));
        Decimal 小計 = 新規在宅計.add(新規施設計).add(更新在宅計).add(更新施設計);
        seikyuEntity.set小計(decimalToRString(小計));
        Decimal 消費税額 = 小計.multiply(new Decimal(消費税率.toString())).subtract(小計);
        seikyuEntity.set消費税額(decimalToRString(消費税額));
        seikyuEntity.set合計金額(decimalToRString(小計.add(消費税額)));
        seikyuEntity.set請求金額(seikyuEntity.get合計金額());
        return seikyuEntity;
    }

    private IkenshoHoshuSeikyuEntity getIkenshoHoshuSeikyuEntity(HoshuShiharaiJunbiRelateEntity entity, IkenshoHoshuSeikyuEntity seikyuEntity,
            Decimal 単価) {
        if (shujiiIryokikanCode.equals(entity.getShinsakaiIinCode())) {
            if (entity.getIkenshoSakuseiKaisuKubun() != null && entity.getZaitakuShisetsuKubun() != null
                    && IkenshoSakuseiKaisuKubun.初回.getコード().equals(entity.getIkenshoSakuseiKaisuKubun().value())
                    && ZaitakuShisetsuKubun.在宅.getコード().equals(entity.getZaitakuShisetsuKubun().value())) {
                index++;
                seikyuEntity.set新規在宅件数(intToRString(index));
                seikyuEntity.set新規在宅単価(decimalToRString(単価));
            }
            if (entity.getIkenshoSakuseiKaisuKubun() != null && entity.getZaitakuShisetsuKubun() != null
                    && IkenshoSakuseiKaisuKubun.初回.getコード().equals(entity.getIkenshoSakuseiKaisuKubun().value())
                    && ZaitakuShisetsuKubun.施設.getコード().equals(entity.getZaitakuShisetsuKubun().value())) {
                index++;
                seikyuEntity.set新規施設件数(intToRString(index));
                seikyuEntity.set新規施設単価(decimalToRString(単価));
            }
            if (entity.getIkenshoSakuseiKaisuKubun() != null && entity.getZaitakuShisetsuKubun() != null
                    && IkenshoSakuseiKaisuKubun._2回目以降.getコード().equals(entity.getIkenshoSakuseiKaisuKubun().value())
                    && ZaitakuShisetsuKubun.在宅.getコード().equals(entity.getZaitakuShisetsuKubun().value())) {
                index++;
                seikyuEntity.set更新在宅件数(intToRString(index));
                seikyuEntity.set更新在宅単価(decimalToRString(単価));
            }
            if (entity.getIkenshoSakuseiKaisuKubun() != null && entity.getZaitakuShisetsuKubun() != null
                    && IkenshoSakuseiKaisuKubun._2回目以降.getコード().equals(entity.getIkenshoSakuseiKaisuKubun().value())
                    && ZaitakuShisetsuKubun.施設.getコード().equals(entity.getZaitakuShisetsuKubun().value())) {
                index++;
                seikyuEntity.set更新施設件数(intToRString(index));
                seikyuEntity.set更新施設単価(decimalToRString(単価));
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

    private int rstringToInt(RString date) {
        if (RString.isNullOrEmpty(date)) {
            return 0;
        }
        return Integer.valueOf(date.toString());
    }
}
