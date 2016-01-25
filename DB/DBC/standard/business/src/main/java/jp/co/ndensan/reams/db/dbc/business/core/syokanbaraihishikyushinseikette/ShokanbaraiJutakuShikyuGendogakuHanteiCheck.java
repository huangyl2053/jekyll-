/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.syokanbaraihishikyushinseikette;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 償還払（居宅）支給限度額判定
 *
 * @author Qi
 */
public class ShokanbaraiJutakuShikyuGendogakuHanteiCheck {

    public boolean chkShokanbaraiJutakuShikyuGendogakuTaishoTani(RString 様式番号, Decimal 限度額対象単位, RString サービス種類コード) {
        requireNonNull(様式番号, UrSystemErrorMessages.値がnull.getReplacedMessage("様式番号"));
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        requireNonNull(限度額対象単位, UrSystemErrorMessages.値がnull.getReplacedMessage("限度額対象外単位"));
        boolean flag = false;
        String sub = 様式番号.toString().substring(0, 3);
        switch (sub) {
            case "213":
                if (new Decimal("0").equals(限度額対象単位)) {
                    flag = true;
                }
                break;
            case "214":
                if (!"1".equals(様式番号.toString().substring(3, 4)) && new Decimal("0").equals(限度額対象単位)) {
                    flag = true;
                }
                break;
            case "215":
                if (!"1".equals(様式番号.toString().substring(3, 4)) && new Decimal("0").equals(限度額対象単位)) {
                    flag = true;
                }
                break;
            case "216":
                if (!"1".equals(様式番号.toString().substring(3, 4)) && new Decimal("0").equals(限度額対象単位)) {
                    flag = true;
                }
                break;
            case "217":
                if ("3".equals(様式番号.toString().substring(3, 4)) || "4".equals(様式番号.toString().substring(3, 4))) {
                    if (new RString("33").equals(サービス種類コード) || new RString("35").equals(サービス種類コード)) {
                        if (new Decimal("0").equals(限度額対象単位)) {
                            flag = true;
                        }
                    }
                }
                break;
        }
        return flag;
    }

    public boolean chkShokanbaraiJutakuShikyuGendogakuTaniGokei(RString 様式番号, Decimal 限度額対象外単位, Decimal 限度額対象単位, Decimal 保険分単位合計, RString サービス種類コード) {
        requireNonNull(様式番号, UrSystemErrorMessages.値がnull.getReplacedMessage("様式番号"));
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        requireNonNull(限度額対象外単位, UrSystemErrorMessages.値がnull.getReplacedMessage("限度額対象外単位"));
        requireNonNull(限度額対象単位, UrSystemErrorMessages.値がnull.getReplacedMessage("限度額対象単位"));
        requireNonNull(保険分単位合計, UrSystemErrorMessages.値がnull.getReplacedMessage("保険分単位合計"));
        boolean flag = false;
        String sub = 様式番号.toString().substring(0, 3);
        switch (sub) {
            case "213":
                if (!保険分単位合計.equals(限度額対象単位.add(限度額対象外単位))) {
                    flag = true;
                }
                break;
            case "214":
                if (!保険分単位合計.equals(限度額対象単位.add(限度額対象外単位))) {
                    flag = true;
                }
                break;
            case "215":
                if (!保険分単位合計.equals(限度額対象単位.add(限度額対象外単位))) {
                    flag = true;
                }
                break;
            case "216":
                if (!保険分単位合計.equals(限度額対象単位.add(限度額対象外単位))) {
                    flag = true;
                }
                break;
        }
        return flag;
    }
}
