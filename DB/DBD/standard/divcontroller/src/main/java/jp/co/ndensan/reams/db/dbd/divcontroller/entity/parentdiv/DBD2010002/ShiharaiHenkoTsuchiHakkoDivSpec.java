/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD2010002;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 *
 * 支払方法変更管理各種通知書発行バリデーションクラスです。
 *
 * @reamsid_L DBD-3640-010 panxiaobo
 */
public enum ShiharaiHenkoTsuchiHakkoDivSpec implements IPredicate<ShiharaiHenkoTsuchiHakkoDiv> {

    予告発行日の必須入力 {
                /**
                 * 発行日の必須入力です。
                 *
                 * @param div ShiharaiHenkoTsuchiHakkoDiv
                 * @return 出力チェックボックスをチェックオンの場合、発行日は空の場合、エラーとする
                 */
                @Override
                public boolean apply(ShiharaiHenkoTsuchiHakkoDiv div) {
                    return div.getYokokuTsuchisho().getTxtYokokuTsuchishoHakkoDate().getValue() != null;
                }
            },
    変更発行日の必須入力 {
                /**
                 * 発行日の必須入力です。
                 *
                 * @param div ShiharaiHenkoTsuchiHakkoDiv
                 * @return 出力チェックボックスをチェックオンの場合、発行日は空の場合、エラーとする
                 */
                @Override
                public boolean apply(ShiharaiHenkoTsuchiHakkoDiv div) {
                    return div.getHenkoTsuchisho().getTxtHenkoTsuchishoHakkoDate().getValue() != null;
                }
            },
    控除発行日の必須入力 {
                /**
                 * 発行日の必須入力です。
                 *
                 * @param div ShiharaiHenkoTsuchiHakkoDiv
                 * @return 出力チェックボックスをチェックオンの場合、発行日は空の場合、エラーとする
                 */
                @Override
                public boolean apply(ShiharaiHenkoTsuchiHakkoDiv div) {
                    return div.getKojoTsuchisho().getTxtKojoTsuchishoHakkoDate().getValue() != null;
                }
            },
    差止発行日の必須入力 {
                /**
                 * 発行日の必須入力です。
                 *
                 * @param div ShiharaiHenkoTsuchiHakkoDiv
                 * @return 出力チェックボックスをチェックオンの場合、発行日は空の場合、エラーとする
                 */
                @Override
                public boolean apply(ShiharaiHenkoTsuchiHakkoDiv div) {
                    return div.getSashitomeTsuchisho().getTxtSashitomeTsuchishoHakkoDate() != null;
                }
            },
    減額発行日の必須入力 {
                /**
                 * 発行日の必須入力です。
                 *
                 * @param div ShiharaiHenkoTsuchiHakkoDiv
                 * @return 出力チェックボックスをチェックオンの場合、発行日は空の場合、エラーとする
                 */
                @Override
                public boolean apply(ShiharaiHenkoTsuchiHakkoDiv div) {
                    return div.getGengakuTsuchisho().getTxtGengakuTsuchishoHakkoDate() != null;
                }
            }
}
