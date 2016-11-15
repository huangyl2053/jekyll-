/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD8010002;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.core.syorijyoutaicode.SyoriJyoutaiCode;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 非課税年金対象者情報取込バリデーションクラスです。
 *
 * @reamsid_L DBD-4910-010 huangh
 */
public enum HikazeiNenkinTaishoshaJohoDivSpec implements IPredicate<HikazeiNenkinTaishoshaJohoDiv> {

    編集なしチェック {
                /**
                 * 編集なしチェックです。
                 *
                 * @param div 非課税年金対象者情報取込Div
                 * @return true:変更あるです、false:変更ないです。
                 */
                @Override
                public boolean apply(HikazeiNenkinTaishoshaJohoDiv div) {

                    List<dgShoriSettei_Row> rowList = div.getDgShoriSettei().getDataSource();
                    for (dgShoriSettei_Row row : rowList) {
                        if (!row.getHdnSyokiShoriJotai().equals(row.getTxtShoriJotai().getSelectedKey())) {
                            return true;
                        }
                    }
                    return false;
                }
            },
    /**
     * アップロードファイル未指定チェック。
     */
    アップロードファイル未指定チェック {
                @Override
                public boolean apply(HikazeiNenkinTaishoshaJohoDiv div) {
                    return div.getFuairuAppurodo().getUplTaishoFuairu().getRemainUnUploadedFiles().size() > 0;
                }
            },
    /**
     * 処理状態単一チェック。
     */
    処理状態単一チェック {
                @Override
                public boolean apply(HikazeiNenkinTaishoshaJohoDiv div) {

                    return div.getDgTanitsuTaishoShoriItchiran().getActiveRow().getTxtShoriJotai()
                    .equals(SyoriJyoutaiCode.未処理.get名称())
                    || div.getDgTanitsuTaishoShoriItchiran().getActiveRow().getTxtShoriJotai()
                    .equals(SyoriJyoutaiCode.再処理前.get名称())
                    || div.getDgTanitsuTaishoShoriItchiran().getActiveRow().getTxtShoriJotai()
                    .equals(SyoriJyoutaiCode.追加取込前.get名称());

                }
            },
    /**
     * 処理状態広域チェック。
     */
    処理状態広域チェック {
                @Override
                public boolean apply(HikazeiNenkinTaishoshaJohoDiv div) {

                    return div.getTxtShoriJotai().getValue()
                    .equals(SyoriJyoutaiCode.未処理.get名称())
                    || div.getTxtShoriJotai().getValue()
                    .equals(SyoriJyoutaiCode.再処理前.get名称())
                    || div.getTxtShoriJotai().getValue()
                    .equals(SyoriJyoutaiCode.追加取込前.get名称());

                }
            },
    /**
     * 市町村コードチェック。
     */
    市町村コードチェック {
                @Override
                public boolean apply(HikazeiNenkinTaishoshaJohoDiv div) {
                    return true;
                }
            },
    /**
     * 年次ファイル通知内容チェック。
     */
    年次ファイル通知内容チェック {
                @Override
                public boolean apply(HikazeiNenkinTaishoshaJohoDiv div) {
                    RString 処理 = div.getDgTanitsuTaishoShoriItchiran().getSelectedItems().get(0).getTxtShori();
                    if (処理.equals(処理_月次)) {
                        return true;
                    }

                    RString line = div.getHdnLine();
                    if (null == line || line.isEmpty()) {
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
                public boolean apply(HikazeiNenkinTaishoshaJohoDiv div
                ) {
                    RString 処理コード = div.getDgTanitsuTaishoShoriItchiran().getSelectedItems().get(0).getTxtShori();
                    if (処理コード.equals(処理_年次)) {
                        return true;
                    }

                    RString line = div.getHdnLine();
                    if (null == line || line.isEmpty() || line.length() < 通知内容コード終了位置) {
                        return false;
                    }

                    RString 通知内容コード = line.substring(通知内容コード開始位置, 通知内容コード終了位置);
                    return 通知内容コード.equals(補足給付初回回付_月次);
                }
            },
    /**
     * アップロードファイル無し_広域チェック。
     */
    アップロードファイル無し_広域チェック {
                @Override
                public boolean apply(HikazeiNenkinTaishoshaJohoDiv div
                ) {

                    for (dgKoikiTaishoShoriItiran_Row row : div.getDgKoikiTaishoShoriItiran().getDataSource()) {
                        if (!row.getTxtTorikomi()) {
                            return false;
                        }
                    }

                    return true;
                }
            },
    /**
     * アップロード済みファイル名チェック。
     */
    アップロード済みファイル名チェック {
                @Override
                public boolean apply(HikazeiNenkinTaishoshaJohoDiv div
                ) {
                    return !RString.EMPTY.equals(div.getTanitsuTaishoShoriIchiran().getTxtFuairuMei().getValue())
                    && !SharedFile.searchSharedFile(div.getTanitsuTaishoShoriIchiran().getHdnFileName()).isEmpty();
                }
            },;

    private static final RString 処理_年次 = new RString("年次");
    private static final RString 処理_月次 = new RString("月次");
    private static final RString 補足給付初回回付_年次 = new RString("93");
    private static final RString 補足給付初回回付_月次 = new RString("94");
    private static final int 通知内容コード開始位置 = 105;
    private static final int 通知内容コード終了位置 = 107;
}
