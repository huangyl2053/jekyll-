/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD8010001;

import jp.co.ndensan.reams.db.dbd.definition.core.shorijotaikubun.ShoriJotaiKubun;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD8010001.TaishoShoriPanelDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD8010001.dgShoriSettei_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 非課税年金対象者情報アップロード画面のチェックロジックです。
 *
 * @reamsid_L DBD-4920-010 lit
 */
public enum TaishoShoriSpec implements IPredicate<TaishoShoriPanelDiv> {

    /**
     * 調定年度チェック。
     */
    調定年度チェック {
                @Override
                public boolean apply(TaishoShoriPanelDiv div) {
                    RString 調定年度 = DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                    return 調定年度.compareTo(調定年度_基準) > 0;
                }
            },
    /**
     * 処理状態チェック_処理済み。
     */
    処理状態チェック_処理済 {
                @Override
                public boolean apply(TaishoShoriPanelDiv div) {
                    return !div.getDgTaishoShoriItchiran().getSelectedItems().get(0).getTxtShoriJotai()
                    .equals(ShoriJotaiKubun.処理済.get名称());
                }
            },
    /**
     * 処理状態チェック_処理なし。
     */
    処理状態チェック_処理なし {
                @Override
                public boolean apply(TaishoShoriPanelDiv div) {
                    return !div.getDgTaishoShoriItchiran().getSelectedItems().get(0).getTxtShoriJotai()
                    .equals(ShoriJotaiKubun.処理なし.get名称());
                }
            },
    /**
     * アップロードファイル未指定チェック。
     */
    アップロードファイル未指定チェック {
                @Override
                public boolean apply(TaishoShoriPanelDiv div) {
                    return div.getUplTaishoFuairu().getRemainUnUploadedFiles().size() > 0;
                }
            },
    /**
     * 編集なしチェック。
     */
    編集なしチェック {
                @Override
                public boolean apply(TaishoShoriPanelDiv div) {
                    for (dgShoriSettei_Row 処理設定 : div.getDgShoriSettei().getDataSource()) {
                        if (処理設定.getTxtShoriJotai().getSelectedIndex() != 0) {
                            return true;
                        }
                    }
                    return false;
                }
            },
    /**
     * 市町村コードチェック。
     */
    市町村コードチェック {
                @Override
                public boolean apply(TaishoShoriPanelDiv div) {
                    RString line = div.getHdnLine();
                    if (null == line || line.isEmpty() || line.length() < 提出元終了位置) {
                        return false;
                    }
                    RString 提出元ID = line.substring(提出元開始位置, 提出元終了位置);
                    return div.getDdlShichosonshitei().getSelectedKey().substring(提出元開始位置, 提出元終了位置).equals(提出元ID);
                }
            },
    /**
     * 年次ファイル通知内容チェック。
     */
    年次ファイル通知内容チェック {
                @Override
                public boolean apply(TaishoShoriPanelDiv div) {
                    RString 処理コード = div.getDgTaishoShoriItchiran().getSelectedItems().get(0).getHdnShoriCode();
                    if (処理コード.equals(処理コード_月次)) {
                        return true;
                    }

                    RString line = div.getHdnLine();
                    if (null == line || line.isEmpty() || line.length() < 通知内容コード終了位置) {
                        return false;
                    }

                    RString 通知内容コード = line.substring(通知内容コード開始位置, 通知内容コード終了位置);
                    return 通知内容コード.equals(補足給付初回回付_年次);

                }
            },
    /**
     * 月次ファイル通知内容チェック。
     */
    月次ファイル通知内容チェック {
                @Override
                public boolean apply(TaishoShoriPanelDiv div) {
                    RString 処理コード = div.getDgTaishoShoriItchiran().getSelectedItems().get(0).getHdnShoriCode();
                    if (処理コード.equals(処理コード_年次)) {
                        return true;
                    }

                    RString line = div.getHdnLine();
                    if (null == line || line.isEmpty() || line.length() < 通知内容コード終了位置) {
                        return false;
                    }

                    RString 通知内容コード = line.substring(通知内容コード開始位置, 通知内容コード終了位置);
                    return 通知内容コード.equals(補足給付初回回付_月次);
                }
            };

    private static final RString 処理コード_年次 = new RString("0");
    private static final RString 処理コード_月次 = new RString("1");
    private static final RString 補足給付初回回付_年次 = new RString("93");
    private static final RString 補足給付初回回付_月次 = new RString("94");
    private static final int 通知内容コード開始位置 = 105;
    private static final int 通知内容コード終了位置 = 107;
    private static final int 提出元開始位置 = 0;
    private static final int 提出元終了位置 = 5;
    private static final RString 調定年度_基準 = new RString("2015");
}
