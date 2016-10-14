/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1320001;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1320001.HanyoListParamDiv;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.NenreiSoChushutsuHoho;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 汎用リスト出力(介護受給共通)のチェックロジックです。
 *
 * @reamsid_L DBD-3930-011 liwul
 */
public enum HanyoListParamSpec implements IPredicate<HanyoListParamDiv> {

    /**
     * 年度RbGr・年度Rbが選択されている場合、年度条件・年度DDLの選択／未選択をチェックする 未選択（空白行が選択されている）の場合、エラーとする
     */
    実行するボタンクリック1 {
                @Override
                public boolean apply(HanyoListParamDiv div) {
                    if (SpecHelper.is年度Rbが選択されている(div)) {
                        return !SpecHelper.空白行KEY.equals(div.getDdlKijunNendo().getSelectedKey());
                    }
                    return true;
                }
            },
    /**
     * 年度RbGr・年度基準日Rbが選択されている場合、年度基準日条件・年度基準日の入力／未入力をチェックする 未入力の場合、エラーとする
     */
    実行するボタンクリック2 {
                @Override
                public boolean apply(HanyoListParamDiv div) {
                    if (SpecHelper.is年度基準日Rbが選択されている(div)) {
                        return div.getTxtKijunDateA().getValue() != null;
                    }
                    return true;
                }
            },
    /**
     * 基準日RbGr・基準日Rbが選択されている場合、基準日条件・基準日の入力／未入力をチェックする 未入力の場合、エラーとする
     */
    実行するボタンクリック3 {
                @Override
                public boolean apply(HanyoListParamDiv div) {
                    if (SpecHelper.is基準日Rbが選択されている(div)) {
                        return div.getTxtKijunDateB().getValue() != null;
                    }
                    return true;
                }
            },
    /**
     * 基準日RbG・範囲Rbが選択されている場合、範囲条件・範囲From、範囲条件・範囲Toが共に入力されている場合、From-Toの大小関係をチェックする。 範囲From > 範囲Toの場合、エラーとする。
     */
    実行するボタンクリック5 {
                @Override
                public boolean apply(HanyoListParamDiv div) {
                    if (div.getTxtChushutsuHani().getFromValue() != null && div.getTxtChushutsuHani().getToValue() != null) {
                        return div.getTxtChushutsuHani().getFromValue().isBeforeOrEquals(div.getTxtChushutsuHani().getToValue());
                    }
                    return true;
                }
            },
    /**
     * 宛名抽出項目区分RDB・年齢が選択されている場合、年齢From、年齢Toが共に入力されている場合、From-Toの大小関係をチェックする。 年齢From > 年齢Toの場合、エラーとする。
     */
    実行するボタンクリック7 {
                @Override
                public boolean apply(HanyoListParamDiv div) {
                    if (SpecHelper.is年齢が選択されている(div)) {
                        return div.getCcdHanyoListAtenaSelect().get年齢開始().compareTo(div.getCcdHanyoListAtenaSelect().get年齢終了()) <= 0;
                    }
                    return true;
                }
            },
    /**
     * 宛名抽出項目区分RDB・生年月日が選択されている場合、生年月日From、生年月日Toが共に入力されている場合、From-Toの大小関係をチェックする。 生年月日From > 生年月日Toの場合、エラーとする。
     */
    実行するボタンクリック10 {
                @Override
                public boolean apply(HanyoListParamDiv div) {
                    if (SpecHelper.is生年月日が選択されている(div)) {
                        return div.getCcdHanyoListAtenaSelect().get生年月日開始().isBeforeOrEquals(div.getCcdHanyoListAtenaSelect().get生年月日終了());
                    }
                    return true;
                }
            },
    /**
     * 帳票・CSV出力が「True」または帳票のみ出力が「True」の時、 表題が未入力（Empty)であればWarningMessage、警告MSGを表示する ※条件保存の場合はチェック不要
     */
    帳票出力項目チェック１ {
                @Override
                public boolean apply(HanyoListParamDiv div) {
                    return SpecHelper.表題入力チェック(div);
                }
            },
    /**
     * 出力順が未入力（Empty)であれば、エラーとする ※条件保存の場合はチェック不要
     */
    帳票出力項目チェック２ {
                @Override
                public boolean apply(HanyoListParamDiv div) {
                    if (div.getCcdShutsuryokujun().get出力順ID() != null) {
                        return !RString.isNullOrEmpty(new RString(div.getCcdShutsuryokujun().get出力順ID()));
                    }
                    return false;
                }
            },
    /**
     * 出力項目が未入力（Empty)であればエラーとする ※条件保存の場合はチェック不要
     */
    帳票出力項目チェック３ {
                @Override
                public boolean apply(HanyoListParamDiv div) {
                    return !RString.isNullOrEmpty(div.getCcdShutsuryokuKomoku().get出力項目ID());

                }
            };

    private static class SpecHelper {

        static final RString 年度RB_KEY = new RString("key0");
        static final RString 年度基準日RB_KEY = new RString("key1");
        static final RString 基準日RB_KEY = new RString("key0");
        static final RString 帳票_CSV出力_KEY = new RString("key0");
        static final RString 帳票のみ出力_KEY = new RString("key1");
        static final RString 空白行KEY = new RString("key0");

        static boolean 表題入力チェック(HanyoListParamDiv div) {
            if (帳票_CSV出力_KEY.equals(div.getRadShuturyokuHoho().getSelectedKey())
                    || 帳票のみ出力_KEY.equals(div.getRadShuturyokuHoho().getSelectedKey())) {
                return !RString.isNullOrEmpty(div.getTxtHyodaiMeisho().getValue());
            }
            return true;
        }

        static boolean is年度Rbが選択されている(HanyoListParamDiv div) {
            return !div.getChushutsuJokenA().isDisabled() && 年度RB_KEY.equals(div.getRadChushutsuJokenA1().getSelectedKey());
        }

        static boolean is年度基準日Rbが選択されている(HanyoListParamDiv div) {
            return !div.getChushutsuJokenA().isDisabled() && 年度基準日RB_KEY.equals(div.getRadChushutsuJokenA2().getSelectedKey());
        }

        static boolean is基準日Rbが選択されている(HanyoListParamDiv div) {
            return 基準日RB_KEY.equals(div.getRadChushutsuJokenB1().getSelectedKey());
        }

        static boolean is年齢が選択されている(HanyoListParamDiv div) {
            return div.getCcdHanyoListAtenaSelect().get年齢層抽出方法().getコード().equals(NenreiSoChushutsuHoho.年齢範囲.getコード())
                    && div.getCcdHanyoListAtenaSelect().get年齢開始() != null
                    && div.getCcdHanyoListAtenaSelect().get年齢終了() != null;
        }

        static boolean is生年月日が選択されている(HanyoListParamDiv div) {
            return div.getCcdHanyoListAtenaSelect().get年齢層抽出方法().getコード().equals(NenreiSoChushutsuHoho.生年月日範囲.getコード())
                    && div.getCcdHanyoListAtenaSelect().get生年月日開始() != null
                    && div.getCcdHanyoListAtenaSelect().get生年月日終了() != null;
        }
    }
}
