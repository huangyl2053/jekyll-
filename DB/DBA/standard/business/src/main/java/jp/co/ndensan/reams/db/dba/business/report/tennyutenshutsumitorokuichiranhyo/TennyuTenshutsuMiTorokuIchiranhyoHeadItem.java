/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.tennyutenshutsumitorokuichiranhyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 転入転出未登録一覧表ヘッダのITEMです。
 *
 * @reamsid_L DBU-4110-040 yaodongsheng
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TennyuTenshutsuMiTorokuIchiranhyoHeadItem {

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
     * @param shichosonCode 保険者コード
     * @param shichosonName 保険者名
     * @param shutsuryokujun1 出力順1
     * @param shutsuryokujun2 出力順2
     * @param shutsuryokujun3 出力順3
     * @param shutsuryokujun4 出力順4
     * @param shutsuryokujun5 出力順5
     * @param kaipage1 改ページ条件1
     * @param kaipage2 改ページ条件2
     * @param kaipage3 改ページ条件3
     * @param kaipage4 改ページ条件4
     * @param kaipage5 改ページ条件5
     */
    public TennyuTenshutsuMiTorokuIchiranhyoHeadItem(
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
