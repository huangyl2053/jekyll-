/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dba.business.report.hihokenshashohakkoichiranhyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 *
 * 一覧表証発行者Entityリストです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HihokenshashoHakkoIchiranHyoItem {
    private final RString printTimeStamp;
    private final RString shichosonName;
    private final RString shichosonCode;
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
    private final RString kofujiyutitle;
    private final RString list_1;
    private final RString list_2;
    private final RString list_3;
    private final RString list_4;
    private final RString list_5;
    private final RString list_6;
    private final RString list_7;
    private final RString list_8;
    private final RString list_9;
    private final RString list_10;
    
    /**
     * コンストラクタです。
     * @param printTimeStamp 作成日時
     * @param shichosonName 市町村名
     * @param shichosonCode 市町村コード
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
     * @param kofujiyutitle 交付事由タイトル
     * @param list_1 帳票連番
     * @param list_2 被保険者番号
     * @param list_3 氏名
     * @param list_4 生年月日_年齢
     * @param list_5 送付先住所
     * @param list_6 要介護
     * @param list_7 認定開始日～認定終了日
     * @param list_8 施設名
     * @param list_9 計画事業所名
     * @param list_10 交付・非交付事由
     */
    public HihokenshashoHakkoIchiranHyoItem(RString printTimeStamp,
            RString shichosonName,
            RString shichosonCode,
            RString shutsuryokujun1,
            RString shutsuryokujun2,
            RString shutsuryokujun3,
            RString shutsuryokujun4,
            RString shutsuryokujun5,
            RString kaipage1,
            RString kaipage2,
            RString kaipage3,
            RString kaipage4,
            RString kaipage5,
            RString kofujiyutitle,
            RString list_1,
            RString list_2,
            RString list_3,
            RString list_4,
            RString list_5,
            RString list_6,
            RString list_7,
            RString list_8,
            RString list_9,
            RString list_10) {
        this.printTimeStamp = printTimeStamp;
        this.shichosonName = shichosonName;
        this.shichosonCode = shichosonCode;
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
        this.kofujiyutitle = kofujiyutitle;
        this.list_1 = list_1;
        this.list_2 = list_2;
        this.list_3 = list_3;
        this.list_4 = list_4;
        this.list_5 = list_5;
        this.list_6 = list_6;
        this.list_7 = list_7;
        this.list_8 = list_8;
        this.list_9 = list_9;
        this.list_10 = list_10;
    }
}
