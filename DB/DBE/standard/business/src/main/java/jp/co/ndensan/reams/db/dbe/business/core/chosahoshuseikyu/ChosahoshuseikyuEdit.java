/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.chosahoshuseikyu;

import java.util.Map;
import jp.co.ndensan.reams.db.dbe.definition.core.hoshu.HomonShubetsu;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hoshushiharaijunbi.HoshuShiharaiJunbiRelateEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ChosaKubun;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 認定調査報酬請求書のEditクラスです。
 *
 * @reamsid_L DBE-1980-020 suguangjun
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChosahoshuseikyuEdit {

    private int index;
    private RString shinsakaiiincode = RString.EMPTY;

    /**
     * 認定調査報酬請求書の編集処理です。
     *
     * @param entity 要介護認定申請
     * @param 消費税率 消費税率
     * @param 通知文 通知文
     * @return Chosahoshuseikyu
     */
    public Chosahoshuseikyu getChosahoshuseikyu(HoshuShiharaiJunbiRelateEntity entity, RString 消費税率, Map<Integer, RString> 通知文) {
        Chosahoshuseikyu shuseikyu = new Chosahoshuseikyu();
        shuseikyu.set郵便番号(entity.getYubinNo().value());
        shuseikyu.set住所(entity.getJusho());
        shuseikyu.set調査機関(entity.getJigyoshaMeisho());
        shuseikyu.set代表者名(entity.getDaihyoshaName());
        shuseikyu.set通知文1(通知文.get(1));
        shuseikyu.set通知文2(通知文.get(2));
        Decimal 単価 = entity.getTanka();
        if (!shinsakaiiincode.equals(entity.getShinsakaiIinCode())) {
            index = 1;
            if (entity.getChosaKubun() != null && entity.getHomonShubetsu() != null
                    && ChosaKubun.新規調査.getコード().equals(entity.getChosaKubun().value())
                    && HomonShubetsu.在宅.getコード().equals(entity.getHomonShubetsu().value())) {
                shuseikyu.set新規在宅件数(intToRString(index));
                shuseikyu.set新規在宅単価(decimalToRString(単価));
            }
            if (entity.getChosaKubun() != null && entity.getHomonShubetsu() != null
                    && ChosaKubun.新規調査.getコード().equals(entity.getChosaKubun().value())
                    && HomonShubetsu.施設.getコード().equals(entity.getHomonShubetsu().value())) {
                shuseikyu.set新規施設件数(intToRString(index));
                shuseikyu.set新規施設単価(decimalToRString(単価));
            }
            if (entity.getChosaKubun() != null && entity.getHomonShubetsu() != null
                    && ChosaKubun.再調査.getコード().equals(entity.getChosaKubun().value())
                    && HomonShubetsu.在宅.getコード().equals(entity.getHomonShubetsu().value())) {
                shuseikyu.set更新在宅件数(intToRString(index));
                shuseikyu.set更新在宅単価(decimalToRString(単価));
            }
            if (entity.getChosaKubun() != null && entity.getHomonShubetsu() != null
                    && ChosaKubun.再調査.getコード().equals(entity.getChosaKubun().value())
                    && HomonShubetsu.施設.getコード().equals(entity.getHomonShubetsu().value())) {
                shuseikyu.set更新施設件数(intToRString(index));
                shuseikyu.set更新施設単価(decimalToRString(単価));
            }
        }
        getChosahoshusei(entity, shuseikyu, 単価);
        shinsakaiiincode = entity.getShinsakaiIinCode();
        Decimal 新規在宅計 = 単価.multiply(rstringToInt(shuseikyu.get新規在宅件数()));
        Decimal 新規施設計 = 単価.multiply(rstringToInt(shuseikyu.get新規施設件数()));
        Decimal 更新在宅計 = 単価.multiply(rstringToInt(shuseikyu.get更新在宅件数()));
        Decimal 更新施設計 = 単価.multiply(rstringToInt(shuseikyu.get更新施設件数()));
        shuseikyu.set新規在宅計(decimalToRString(新規在宅計));
        shuseikyu.set新規施設計(decimalToRString(新規施設計));
        shuseikyu.set更新在宅計(decimalToRString(更新在宅計));
        shuseikyu.set更新施設計(decimalToRString(更新施設計));
        Decimal 作成件数合計 = Decimal.ZERO;
        作成件数合計 = 作成件数合計.add(rstringToInt(shuseikyu.get新規在宅件数())).add(rstringToInt(shuseikyu.get新規施設件数()))
                .add(rstringToInt(shuseikyu.get更新在宅件数())).add(rstringToInt(shuseikyu.get更新施設件数()));
        shuseikyu.set作成件数合計(decimalToRString(作成件数合計));
        Decimal 小計 = 新規在宅計.add(新規施設計).add(更新在宅計).add(更新施設計);
        shuseikyu.set小計(decimalToRString(小計));
        Decimal 消費税額 = 小計.multiply(new Decimal(消費税率.toString())).subtract(小計);
        shuseikyu.set消費税額(decimalToRString(消費税額));
        shuseikyu.set合計金額(decimalToRString(小計.add(消費税額)));
        shuseikyu.set請求金額(shuseikyu.get合計金額());
        return shuseikyu;
    }

    private Chosahoshuseikyu getChosahoshusei(HoshuShiharaiJunbiRelateEntity entity, Chosahoshuseikyu shuseikyu, Decimal 単価) {
        if (shinsakaiiincode.equals(entity.getShinsakaiIinCode())) {
            if (entity.getChosaKubun() != null && entity.getHomonShubetsu() != null
                    && ChosaKubun.新規調査.getコード().equals(entity.getChosaKubun().value())
                    && HomonShubetsu.在宅.getコード().equals(entity.getHomonShubetsu().value())) {
                index++;
                shuseikyu.set新規在宅件数(intToRString(index));
                shuseikyu.set新規在宅単価(decimalToRString(単価));
            }
            if (entity.getChosaKubun() != null && entity.getHomonShubetsu() != null
                    && ChosaKubun.新規調査.getコード().equals(entity.getChosaKubun().value())
                    && HomonShubetsu.施設.getコード().equals(entity.getHomonShubetsu().value())) {
                index++;
                shuseikyu.set新規施設件数(intToRString(index));
                shuseikyu.set新規施設単価(decimalToRString(単価));
            }
            if (entity.getChosaKubun() != null && entity.getHomonShubetsu() != null
                    && ChosaKubun.再調査.getコード().equals(entity.getChosaKubun().value())
                    && HomonShubetsu.在宅.getコード().equals(entity.getHomonShubetsu().value())) {
                index++;
                shuseikyu.set更新在宅件数(intToRString(index));
                shuseikyu.set更新在宅単価(decimalToRString(単価));
            }
            if (entity.getChosaKubun() != null && entity.getHomonShubetsu() != null
                    && ChosaKubun.再調査.getコード().equals(entity.getChosaKubun().value())
                    && HomonShubetsu.施設.getコード().equals(entity.getHomonShubetsu().value())) {
                index++;
                shuseikyu.set更新施設件数(intToRString(index));
                shuseikyu.set更新施設単価(decimalToRString(単価));
            }
        }
        return shuseikyu;
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
