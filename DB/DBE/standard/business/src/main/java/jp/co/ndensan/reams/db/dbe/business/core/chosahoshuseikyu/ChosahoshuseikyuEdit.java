/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.chosahoshuseikyu;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.hoshushiharaijunbi.HoshuShiharaiJunbiRelateEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;
import lombok.Getter;
import lombok.Setter;

/**
 * 認定調査報酬請求書のEditクラスです。
 *
 * @reamsid_L DBE-1980-043 suguangjun
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChosahoshuseikyuEdit {

    private static int 新規在宅件数 = 1;
    private static int 新規施設件数 = 1;
    private static int 更新在宅件数 = 1;
    private static int 更新施設件数 = 1;
    private static RString shinsakaiiincode = RString.EMPTY;

    /**
     * 要介護認定・要支援認定等申請者の編集処理です。
     *
     * @param entity 要介護認定申請
     * @return Chosahoshuseikyu
     */
    public Chosahoshuseikyu getChosahoshuseikyu(HoshuShiharaiJunbiRelateEntity entity) {
        Chosahoshuseikyu shuseikyu = new Chosahoshuseikyu();
        shuseikyu.set郵便番号(entity.getYubinNo().value());
        shuseikyu.set住所(entity.getJusho());
        shuseikyu.set調査機関(entity.getJigyoshaMeisho());
        shuseikyu.set代表者名(entity.getDaihyoshaName());
        if (!shinsakaiiincode.equals(entity.getShinsakaiIinCode())) {
            if (new Code("0").equals(entity.getChosaKubun()) && new Code("1").equals(entity.getHomonShubetsu())) {
                新規在宅件数 = 1;
                shuseikyu.set新規在宅件数(kinngakuFormat(new Decimal(新規在宅件数)));
                shuseikyu.set新規在宅単価(kinngakuFormat(entity.getTanka()));
            }
            if (new Code("0").equals(entity.getChosaKubun()) && new Code("2").equals(entity.getHomonShubetsu())) {
                新規施設件数 = 1;
                shuseikyu.set新規施設件数(kinngakuFormat(new Decimal(新規施設件数)));
                shuseikyu.set新規施設単価(kinngakuFormat(entity.getTanka()));
            }
            if (new Code("1").equals(entity.getChosaKubun()) && new Code("1").equals(entity.getHomonShubetsu())) {
                更新在宅件数 = 1;
                shuseikyu.set更新在宅件数(kinngakuFormat(new Decimal(更新在宅件数)));
                shuseikyu.set更新在宅単価(kinngakuFormat(entity.getTanka()));
            }
            if (new Code("1").equals(entity.getChosaKubun()) && new Code("2").equals(entity.getHomonShubetsu())) {
                更新施設件数 = 更新施設件数 + 1;
                shuseikyu.set更新施設件数(kinngakuFormat(new Decimal(更新施設件数)));
                shuseikyu.set更新施設単価(kinngakuFormat(entity.getTanka()));
            }
        }
        getChosahoshusei(entity, shuseikyu);
        shinsakaiiincode = entity.getShinsakaiIinCode();
        int 新規在宅計 = 0;
        int 新規施設計 = 0;
        int 更新在宅計 = 0;
        int 更新施設計 = 0;
        if (entity.getTanka() != null) {
            新規在宅計 = 新規在宅件数 * Integer.valueOf(entity.getTanka().toString());
            新規施設計 = 新規施設件数 * Integer.valueOf(entity.getTanka().toString());
            更新在宅計 = 更新在宅件数 * Integer.valueOf(entity.getTanka().toString());
            更新施設計 = 更新施設件数 * Integer.valueOf(entity.getTanka().toString());
        }
        shuseikyu.set新規在宅計(kinngakuFormat(new Decimal(新規在宅計)));
        shuseikyu.set新規施設計(kinngakuFormat(new Decimal(新規施設計)));
        shuseikyu.set更新在宅計(kinngakuFormat(new Decimal(更新在宅計)));
        shuseikyu.set更新施設計(kinngakuFormat(new Decimal(更新施設計)));
        int 作成件数合計 = 新規在宅件数 + 新規施設件数 + 更新在宅件数 + 更新施設件数;
        int 小計 = 新規在宅計 + 新規施設計 + 更新在宅計 + 更新施設計;
        shuseikyu.set更新施設計(kinngakuFormat(new Decimal(作成件数合計)));
        shuseikyu.set小計(kinngakuFormat(new Decimal(小計)));
        // TODO
        RString 消費税率 = CodeMaster.getCodeMeisho(CodeShubetsu.EMPTY, Code.EMPTY);
        int 消費税額 = 小計 * Integer.valueOf(消費税率.toString()) - 小計;
        shuseikyu.set消費税額(kinngakuFormat(new Decimal(消費税額)));
        shuseikyu.set合計金額(kinngakuFormat(new Decimal(小計 + 消費税額)));
        return shuseikyu;
    }

    private Chosahoshuseikyu getChosahoshusei(HoshuShiharaiJunbiRelateEntity entity, Chosahoshuseikyu shuseikyu) {
        if (shinsakaiiincode.equals(entity.getShinsakaiIinCode())) {
            if (new Code("0").equals(entity.getChosaKubun()) && new Code("1").equals(entity.getHomonShubetsu())) {
                新規在宅件数 = 新規在宅件数 + 1;
                shuseikyu.set新規在宅件数(kinngakuFormat(new Decimal(新規在宅件数)));
                shuseikyu.set新規在宅単価(kinngakuFormat(entity.getTanka()));
            }
            if (new Code("0").equals(entity.getChosaKubun()) && new Code("2").equals(entity.getHomonShubetsu())) {
                新規施設件数 = 新規施設件数 + 1;
                shuseikyu.set新規施設件数(kinngakuFormat(new Decimal(新規施設件数)));
                shuseikyu.set新規施設単価(kinngakuFormat(entity.getTanka()));
            }
            if (new Code("1").equals(entity.getChosaKubun()) && new Code("1").equals(entity.getHomonShubetsu())) {
                更新在宅件数 = 更新在宅件数 + 1;
                shuseikyu.set更新在宅件数(kinngakuFormat(new Decimal(更新在宅件数)));
                shuseikyu.set更新在宅単価(kinngakuFormat(entity.getTanka()));
            }
            if (new Code("1").equals(entity.getChosaKubun()) && new Code("2").equals(entity.getHomonShubetsu())) {
                更新施設件数 = 更新施設件数 + 1;
                shuseikyu.set更新施設件数(kinngakuFormat(new Decimal(更新施設件数)));
                shuseikyu.set更新施設単価(kinngakuFormat(entity.getTanka()));
            }
        }
        return shuseikyu;
    }

    private RString kinngakuFormat(Decimal date) {
        if (date == null) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toコンマ区切りRString(date, 0);
    }
}
