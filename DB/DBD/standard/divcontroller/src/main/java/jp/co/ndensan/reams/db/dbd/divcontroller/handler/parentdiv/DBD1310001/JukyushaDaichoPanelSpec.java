/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1310001;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.hanyolist.jukyusha2.ChushutsuHohoKubun;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1310001.JukyushaDaichoDiv;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.NenreiSoChushutsuHoho;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * 画面設計_DBDGM13003_汎用リスト出力(受給者台帳)のチェックロジックです。
 *
 * @reamsid_L DBD-1800-010 liwul
 */
public enum JukyushaDaichoPanelSpec implements IPredicate<JukyushaDaichoDiv> {

    /**
     * 基準日RbGr・基準日Rbが選択されている場合、基準日条件・基準日の入力／未入力をチェックする 未入力の場合、エラーとする
     */
    実行するボタンクリック1 {
                @Override
                public boolean apply(JukyushaDaichoDiv div) {
                    if (SpecHelper.is基準日Rbが選択されている(div)) {
                        return div.getTxtKijyunYmd().getValue() != null;
                    }
                    return true;
                }
            },
    /**
     * 基準日RbGr・範囲Rbが選択されている場合、範囲From、範囲Toが共に入力されていなければエラーとする。
     */
    実行するボタンクリック2 {
                @Override
                public boolean apply(JukyushaDaichoDiv div) {
                    if (SpecHelper.is範囲Rbが選択されている(div)) {
                        return div.getTxtNinteiYmdHani().getFromValue() != null || div.getTxtNinteiYmdHani().getToValue() != null;
                    }
                    return true;
                }
            },
    /**
     * 基準日RbGr・範囲Rbが選択されている場合、範囲From、範囲Toが共に入力されている場合、From-Toの大小関係をチェックする。 範囲From > 範囲Toの場合、エラーとする。
     */
    実行するボタンクリック3 {
                @Override
                public boolean apply(JukyushaDaichoDiv div) {
                    if (SpecHelper.is範囲Rbが選択されている(div) && SpecHelper.is範囲From_範囲Toが共に入力(div)) {
                        return div.getTxtNinteiYmdHani().getFromValue().isBeforeOrEquals(div.getTxtNinteiYmdHani().getToValue());
                    }
                    return true;
                }
            },
    /**
     * 宛名抽出項目区分RDB・年齢が選択されている場合、年齢From、年齢Toが共に入力されていなければエラーとする。
     */
    実行するボタンクリック4 {
                @Override
                public boolean apply(JukyushaDaichoDiv div) {
                    if (SpecHelper.is年齢が選択されている(div)) {
                        return SpecHelper.is年齢From入力(div) || SpecHelper.is年齢To入力(div);
                    }
                    return true;
                }
            },
    /**
     * 宛名抽出項目区分RDB・年齢が選択されている場合、年齢From、年齢Toが共に入力されている場合、From-Toの大小関係をチェックする。 年齢From > 年齢Toの場合、エラーとする。
     */
    実行するボタンクリック5 {
                @Override
                public boolean apply(JukyushaDaichoDiv div) {
                    if (SpecHelper.is年齢が選択されている(div) && SpecHelper.is年齢From入力(div) && SpecHelper.is年齢To入力(div)) {
                        return div.getCcdAtenaJoken().get年齢開始().compareTo(div.getCcdAtenaJoken().get年齢終了()) <= 0;
                    }
                    return true;
                }
            },
    /**
     * 宛名抽出項目区分RDB・年齢が選択されている場合、年齢Fromまたは年齢Toのどちらかに入力されている場合、年齢基準日の入力／未入力をチェックする。 未入力の場合、エラーとする
     */
    実行するボタンクリック6 {
                @Override
                public boolean apply(JukyushaDaichoDiv div) {
                    if (SpecHelper.is年齢が選択されている(div) && (SpecHelper.is年齢From入力(div) || SpecHelper.is年齢To入力(div))) {
                        return div.getCcdAtenaJoken().get年齢基準日() != null;
                    }
                    return true;
                }
            },
    /**
     * 宛名抽出項目区分RDB・生年月日が選択されている場合、生年月日From、生年月日Toが共に入力されていなければエラーとする。
     */
    実行するボタンクリック7 {
                @Override
                public boolean apply(JukyushaDaichoDiv div) {
                    if (SpecHelper.is生年月日が選択されている(div)) {
                        return div.getCcdAtenaJoken().get生年月日開始() != null || div.getCcdAtenaJoken().get生年月日終了() != null;
                    }
                    return true;
                }
            },
    /**
     * 宛名抽出項目区分RDB・生年月日が選択されている場合、生年月日From、生年月日Toが共に入力されている場合、From-Toの大小関係をチェックする。 生年月日From > 生年月日Toの場合、エラーとする。
     */
    実行するボタンクリック8 {
                @Override
                public boolean apply(JukyushaDaichoDiv div) {
                    if (SpecHelper.is生年月日が選択されている(div) && SpecHelper.is生年月日From_生年月日Toが共に入力(div)) {
                        return div.getCcdAtenaJoken().get生年月日開始().isBeforeOrEquals(div.getCcdAtenaJoken().get生年月日終了());
                    }
                    return true;
                }
            };

    private static class SpecHelper {

        static boolean is基準日Rbが選択されている(JukyushaDaichoDiv div) {
            return div.getRadChushutsuTaisho().getSelectedKey().equals(ChushutsuHohoKubun.基準日.getコード());
        }

        static boolean is範囲Rbが選択されている(JukyushaDaichoDiv div) {
            return div.getRadChushutsuTaisho().getSelectedKey().equals(ChushutsuHohoKubun.範囲.getコード());
        }

        static boolean is範囲From_範囲Toが共に入力(JukyushaDaichoDiv div) {
            return div.getTxtNinteiYmdHani().getFromValue() != null && div.getTxtNinteiYmdHani().getToValue() != null;
        }

        static boolean is年齢が選択されている(JukyushaDaichoDiv div) {
            return div.getCcdAtenaJoken().get年齢層抽出方法().equals(NenreiSoChushutsuHoho.年齢範囲);
        }

        static boolean is年齢From入力(JukyushaDaichoDiv div) {
            return div.getCcdAtenaJoken().get年齢開始() != null;
        }

        static boolean is年齢To入力(JukyushaDaichoDiv div) {
            return div.getCcdAtenaJoken().get年齢終了() != null;
        }

        static boolean is生年月日が選択されている(JukyushaDaichoDiv div) {
            return div.getCcdAtenaJoken().get年齢層抽出方法().equals(NenreiSoChushutsuHoho.生年月日範囲);
        }

        static boolean is生年月日From_生年月日Toが共に入力(JukyushaDaichoDiv div) {
            return div.getCcdAtenaJoken().get生年月日開始() != null && div.getCcdAtenaJoken().get生年月日終了() != null;
        }
    }
}
