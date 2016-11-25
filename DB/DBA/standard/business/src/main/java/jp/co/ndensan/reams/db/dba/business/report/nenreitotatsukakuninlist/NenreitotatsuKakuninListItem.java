/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.nenreitotatsukakuninlist;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 年齢到達者登録リスト帳票のItemクラスです。
 *
 * @reamsid_L DBA-0570-060 xuyue
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NenreitotatsuKakuninListItem {

    private final RString printTimeStamp;
    private final RString taishoJohotitle;
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
    private final RString tyusyutsukikanF;
    private final RString tyusyutsukikanT;
    private final RString kaishiTitle;
    private final RString shuryoTitle;
    private final RString kubunTitle;
    private final RString idoJohoTitle1;
    private final RString idoJohoTitle2;
    private final RString idoJohoTitle3;
    private final RString kaishiYmdTitle;
    private final RString shuryoYmdTitle;
    private final RString idoJohoTitle4;
    private final RString idoJohoTitle5;
    private final RString idoJohoTitle6;
    private final RString listUpper_1;
    private final RString listUpper_2;
    private final RString listUpper_3;
    private final RString listUpper_4;
    private final RString listUpper_5;
    private final RString listUpper_6;
    private final RString listUpper_7;
    private final RString listUpper_8;
    private final RString listUpper_9;
    private final RString listUpper_10;
    private final RString listUpper_11;
    private final RString listUpper_12;
    private final RString listUpper_13;
    private final RString listUpper_14;
    private final RString listHihokenshaNo_1;
    private final RString listLower_1;
    private final RString listLower_2;
    private final RString listLower_3;
    private final RString listLower_4;
    private final RString listLower_5;
    private final RString listLower_6;
    private final RString listLower_7;
    private final RString listLower_8;
    private final RString listLower_9;
    private final RString listLower_10;
    private final RString listLower_11;
    private final RString listLower_12;
    private final RString listLower_13;
    private final RString listLower_14;
    private final RString yubinNo;
    private final RString choikiCode;
    private final RString banchiCode;
    private final RString gyoseikuCode;
    private final RString chiku1;
    private final RString chiku2;
    private final RString chiku3;
    private final RString shimei50onKana;
    private final RString seinengappiYMD;
    private final RString gender;

    /**
     *
     * @param printTimeStamp 印刷日時
     * @param taishoJohotitle 対象情報タイトル
     * @param shichosonCode 市町村コード
     * @param shichosonName 市町村名
     * @param shutsuryokujun1 並び順１
     * @param shutsuryokujun2 並び順２
     * @param shutsuryokujun3 並び順３
     * @param shutsuryokujun4 並び順４
     * @param shutsuryokujun5 並び順５
     * @param kaipage1 改頁１
     * @param kaipage2 改頁２
     * @param kaipage3 改頁３
     * @param kaipage4 改頁４
     * @param kaipage5 改頁５
     * @param tyusyutsukikanF 抽出期間From
     * @param tyusyutsukikanT 抽出期間To
     * @param kaishiTitle 開始タイトル
     * @param shuryoTitle 終了タイトル
     * @param kubunTitle 区分タイトル
     * @param idoJohoTitle1 異動情報タイトル1
     * @param idoJohoTitle2 異動情報タイトル2
     * @param idoJohoTitle3 異動情報タイトル3
     * @param kaishiYmdTitle 開始年月日タイトル
     * @param shuryoYmdTitle 終了年月日タイトル
     * @param idoJohoTitle4 異動情報タイトル4
     * @param idoJohoTitle5 異動情報タイトル5
     * @param idoJohoTitle6 異動情報タイトル6
     * @param listUpper_1 世帯コード
     * @param listUpper_2 被保険者カナ氏名
     * @param listUpper_3 取得情報．前．事由
     * @param listUpper_4 取得情報．前．異動年月日
     * @param listUpper_5 取得情報．前．届出年月日
     * @param listUpper_6 開始年月日データ．前
     * @param listUpper_7 喪失情報．前．事由
     * @param listUpper_8 喪失情報．前．異動年月日
     * @param listUpper_9 喪失情報．前．届出年月日
     * @param listUpper_10 終了年月日データ．前
     * @param listUpper_11 区分．前．資格
     * @param listUpper_12 異動情報データ1
     * @param listUpper_13 異動情報データ2
     * @param listUpper_14 異動情報データ3
     * @param listHihokenshaNo_1 被保険者番号
     * @param listLower_1 識別コード
     * @param listLower_2 被保険者氏名
     * @param listLower_3 取得情報．後．事由
     * @param listLower_4 取得情報．後．異動年月日
     * @param listLower_5 取得情報．後．届出年月日
     * @param listLower_6 開始年月日データ．後
     * @param listLower_7 喪失情報．後．事由
     * @param listLower_8 喪失情報．後．異動年月日
     * @param listLower_9 喪失情報．後．届出年月日
     * @param listLower_10 終了年月日データ．後
     * @param listLower_11 区分．後．資格
     * @param listLower_12 異動情報データ4
     * @param listLower_13 異動情報データ5
     * @param listLower_14 異動情報データ6
     * @param yubinNo 郵便番号
     * @param choikiCode 町域コード
     * @param banchiCode 番地コード
     * @param gyoseikuCode 行政区コード
     * @param chiku1 地区１
     * @param chiku2 地区２
     * @param chiku3 地区３
     * @param shimei50onKana 氏名５０音カナ
     * @param seinengappiYMD 生年月日
     * @param gender 性別
     */
    public NenreitotatsuKakuninListItem(
            RString printTimeStamp,
            RString taishoJohotitle,
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
            RString kaipage5,
            RString tyusyutsukikanF,
            RString tyusyutsukikanT,
            RString kaishiTitle,
            RString shuryoTitle,
            RString kubunTitle,
            RString idoJohoTitle1,
            RString idoJohoTitle2,
            RString idoJohoTitle3,
            RString kaishiYmdTitle,
            RString shuryoYmdTitle,
            RString idoJohoTitle4,
            RString idoJohoTitle5,
            RString idoJohoTitle6,
            RString listUpper_1,
            RString listUpper_2,
            RString listUpper_3,
            RString listUpper_4,
            RString listUpper_5,
            RString listUpper_6,
            RString listUpper_7,
            RString listUpper_8,
            RString listUpper_9,
            RString listUpper_10,
            RString listUpper_11,
            RString listUpper_12,
            RString listUpper_13,
            RString listUpper_14,
            RString listHihokenshaNo_1,
            RString listLower_1,
            RString listLower_2,
            RString listLower_3,
            RString listLower_4,
            RString listLower_5,
            RString listLower_6,
            RString listLower_7,
            RString listLower_8,
            RString listLower_9,
            RString listLower_10,
            RString listLower_11,
            RString listLower_12,
            RString listLower_13,
            RString listLower_14,
            RString yubinNo,
            RString choikiCode,
            RString banchiCode,
            RString gyoseikuCode,
            RString chiku1,
            RString chiku2,
            RString chiku3,
            RString shimei50onKana,
            RString seinengappiYMD,
            RString gender
    ) {
        this.printTimeStamp = printTimeStamp;
        this.taishoJohotitle = taishoJohotitle;
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
        this.tyusyutsukikanF = tyusyutsukikanF;
        this.tyusyutsukikanT = tyusyutsukikanT;
        this.kaishiTitle = kaishiTitle;
        this.shuryoTitle = shuryoTitle;
        this.kubunTitle = kubunTitle;
        this.idoJohoTitle1 = idoJohoTitle1;
        this.idoJohoTitle2 = idoJohoTitle2;
        this.idoJohoTitle3 = idoJohoTitle3;
        this.kaishiYmdTitle = kaishiYmdTitle;
        this.shuryoYmdTitle = shuryoYmdTitle;
        this.idoJohoTitle4 = idoJohoTitle4;
        this.idoJohoTitle5 = idoJohoTitle5;
        this.idoJohoTitle6 = idoJohoTitle6;
        this.listUpper_1 = listUpper_1;
        this.listUpper_2 = listUpper_2;
        this.listUpper_3 = listUpper_3;
        this.listUpper_4 = listUpper_4;
        this.listUpper_5 = listUpper_5;
        this.listUpper_6 = listUpper_6;
        this.listUpper_7 = listUpper_7;
        this.listUpper_8 = listUpper_8;
        this.listUpper_9 = listUpper_9;
        this.listUpper_10 = listUpper_10;
        this.listUpper_11 = listUpper_11;
        this.listUpper_12 = listUpper_12;
        this.listUpper_13 = listUpper_13;
        this.listUpper_14 = listUpper_14;
        this.listHihokenshaNo_1 = listHihokenshaNo_1;
        this.listLower_1 = listLower_1;
        this.listLower_2 = listLower_2;
        this.listLower_3 = listLower_3;
        this.listLower_4 = listLower_4;
        this.listLower_5 = listLower_5;
        this.listLower_6 = listLower_6;
        this.listLower_7 = listLower_7;
        this.listLower_8 = listLower_8;
        this.listLower_9 = listLower_9;
        this.listLower_10 = listLower_10;
        this.listLower_11 = listLower_11;
        this.listLower_12 = listLower_12;
        this.listLower_13 = listLower_13;
        this.listLower_14 = listLower_14;
        this.yubinNo = yubinNo;
        this.choikiCode = choikiCode;
        this.banchiCode = banchiCode;
        this.gyoseikuCode = gyoseikuCode;
        this.chiku1 = chiku1;
        this.chiku2 = chiku2;
        this.chiku3 = chiku3;
        this.shimei50onKana = shimei50onKana;
        this.seinengappiYMD = seinengappiYMD;
        this.gender = gender;
    }
}
