/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.hihokenshashohakkokanriichiranhyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 被保険者証発行管理一覧表ヘッダのITEMです。
 *
 * @reamsid_L DBA-0600-070 lishengli
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HihokenshashoHakkoKanriIchiranhyoHeadItem {

    private final RString printTimeStamp;
    private final int pageCount;
    private final RString title;
    private final RString shichosonCode;
    private final RString shichosonName;
    private final RString shutsuryokujun1;
    private final RString shutsuryokujun2;
    private final RString shutsuryokujun3;
    private final RString shutsuryokujun4;
    private final RString shutsuryokujun5;
    private final RString kaipage1;
    private final RString kaipage2;
    private final RString kaipage3;
    private final RString kaipage4;
    private final RString kaipage5;

    /**
     * インスタンスを生成します。
     *
     * @param printTimeStamp 印刷日時
     * @param pageCount ページ数
     * @param title 帳票タイトル
     * @param shichosonCode 市町村コード
     * @param shichosonName 市町村名
     * @param shutsuryokujun1 ソート順１
     * @param shutsuryokujun2 ソート順２
     * @param shutsuryokujun3 ソート順３
     * @param shutsuryokujun4 ソート順４
     * @param shutsuryokujun5 ソート順５
     * @param kaipage1 改頁１
     * @param kaipage2 改頁２
     * @param kaipage3 改頁３
     * @param kaipage4 改頁４
     * @param kaipage5 改頁５
     */
    public HihokenshashoHakkoKanriIchiranhyoHeadItem(
            RString printTimeStamp,
            int pageCount,
            RString title,
            RString shichosonCode,
            RString shichosonName,
            RString shutsuryokujun1,
            RString shutsuryokujun2,
            RString shutsuryokujun3,
            RString shutsuryokujun4,
            RString shutsuryokujun5,
            RString kaipage1,
            RString kaipage2,
            RString kaipage3,
            RString kaipage4,
            RString kaipage5) {
        this.printTimeStamp = printTimeStamp;
        this.pageCount = pageCount;
        this.title = title;
        this.shichosonCode = shichosonCode;
        this.shichosonName = shichosonName;
        this.shutsuryokujun1 = shutsuryokujun1;
        this.shutsuryokujun2 = shutsuryokujun2;
        this.shutsuryokujun3 = shutsuryokujun3;
        this.shutsuryokujun4 = shutsuryokujun4;
        this.shutsuryokujun5 = shutsuryokujun5;
        this.kaipage1 = kaipage1;
        this.kaipage2 = kaipage2;
        this.kaipage3 = kaipage3;
        this.kaipage4 = kaipage4;
        this.kaipage5 = kaipage5;
    }
}
