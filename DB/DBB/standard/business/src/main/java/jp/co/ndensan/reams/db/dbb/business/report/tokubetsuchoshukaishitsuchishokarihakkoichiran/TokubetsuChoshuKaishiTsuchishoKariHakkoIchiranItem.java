/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokarihakkoichiran;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 特別徴収開始通知書（仮算定）発行一覧表Item
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranItem {

    private RString 作成日時;
    private RString タイトル;
    private RString 年度;
    private RString 市町村コード;
    private RString 市町村名称;
    private RString 並び順１;
    private RString 並び順２;
    private RString 並び順３;
    private RString 並び順４;
    private RString 並び順５;
    private RString 改頁１;
    private RString 改頁２;
    private RString 改頁３;
    private RString 改頁４;
    private RString 改頁５;
    private RString 徴収額タイトル;
    private RString 連番;
    private RString 郵便番号;
    private RString 住所;
    private RString 行政区;
    private RString 生年月日;
    private RString 性別;
    private RString 世帯主名;
    private RString 通知書番号;
    private RString 世帯コード;
    private RString 被保険者氏名;
    private RString 特別徴収義務者;
    private RString 特別徴対象年金;
    private RString 仮徴収月4月;
    private RString 仮徴収額4月;
    private RString 仮徴収月6月;
    private RString 仮徴収額6月;
    private RString 仮徴収月8月;
    private RString 仮徴収額8月;
}
