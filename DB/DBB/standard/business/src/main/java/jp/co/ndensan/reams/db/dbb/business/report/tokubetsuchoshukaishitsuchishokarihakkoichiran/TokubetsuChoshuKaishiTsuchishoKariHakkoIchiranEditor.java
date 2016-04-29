/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokarihakkoichiran;

import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokarihakkoichiran.TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource;

/**
 * 特別徴収開始通知書（仮算定）発行一覧表Editor
 *
 * @reamsid_L DBB-0790-060 surun
 */
public class TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranEditor implements ITokubetsuChoshuKaishiTsuchishoKariHakkoIchiranEditor {

    private final TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranItem item;

    /**
     * コンストラクタです
     *
     * @param item TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranItem
     */
    public TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranEditor(TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranItem item) {
        this.item = item;
    }

    @Override
    public TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource edit(TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource source) {
        source.printTimeStamp = item.get作成日時();
        source.title = item.getタイトル();
        source.nendo = item.get年度();
        source.hokenshaNo = item.get市町村コード();
        source.hokenshaName = item.get市町村名称();
        source.shutsuryokujun1 = item.get並び順１();
        source.shutsuryokujun1 = item.get並び順２();
        source.shutsuryokujun1 = item.get並び順３();
        source.shutsuryokujun1 = item.get並び順４();
        source.shutsuryokujun1 = item.get並び順５();
        source.kaipage1 = item.get改頁１();
        source.kaipage1 = item.get改頁２();
        source.kaipage1 = item.get改頁３();
        source.kaipage1 = item.get改頁４();
        source.kaipage1 = item.get改頁５();
        source.titleChoshugaku = item.get徴収額タイトル();
        source.listUpper_1 = item.get連番();
        source.listUpper_2 = item.get郵便番号();
        source.listUpper_3 = item.get住所();
        source.listUpper_4 = item.get行政区();
        source.listUpper_5 = item.get生年月日();
        source.listUpper_6 = item.get性別();
        source.listUpper_7 = item.get世帯主名();
        source.listLower_1 = item.get通知書番号();
        source.listLower_2 = item.get世帯コード();
        source.listLower_3 = item.get被保険者氏名();
        source.listLower_4 = item.get特別徴収義務者();
        source.listLower_5 = item.get特別徴対象年金();
        source.listLower_6 = item.get仮徴収月4月();
        source.listLower_7 = item.get仮徴収額4月();
        source.listLower_8 = item.get仮徴収月6月();
        source.listLower_9 = item.get仮徴収額6月();
        source.listLower_10 = item.get仮徴収月8月();
        source.listLower_11 = item.get仮徴収額8月();
        return source;
    }
}
