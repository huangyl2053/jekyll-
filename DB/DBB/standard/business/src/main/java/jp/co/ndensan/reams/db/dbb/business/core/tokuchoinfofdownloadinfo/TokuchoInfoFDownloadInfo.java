/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.tokuchoinfofdownloadinfo;

import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特徴送付ダウンロード情報を格納する
 *
 * @reamsid_L DBB-4240-010 chenhui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokuchoInfoFDownloadInfo {

    private RString 情報名;
    private RString ファイル名;
    private RDateTime 作成日時;
    private boolean ファイル存在;

    /**
     * コンストラクタです。
     */
    public TokuchoInfoFDownloadInfo() {
    }

    /**
     * コンストラクタです。
     *
     * @param 情報名 RString
     * @param ファイル名 RString
     * @param 作成日時 RDateTime
     * @param ファイル存在 boolean
     */
    public TokuchoInfoFDownloadInfo(RString 情報名, RString ファイル名, RDateTime 作成日時,
            boolean ファイル存在) {
        this.情報名 = 情報名;
        this.ファイル名 = ファイル名;
        this.作成日時 = 作成日時;
        this.ファイル存在 = ファイル存在;
    }
}
