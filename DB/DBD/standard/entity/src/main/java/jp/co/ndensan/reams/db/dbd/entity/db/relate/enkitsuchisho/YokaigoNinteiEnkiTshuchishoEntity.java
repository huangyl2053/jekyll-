/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.enkitsuchisho;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定延期通知書タイトルEntityクラスです。
 *
 * @reamsid_L DBD-1410-020 chenxin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class YokaigoNinteiEnkiTshuchishoEntity {

    private DbT4101NinteiShinseiJohoEntity entity;

    private RString 文書番号;
    private RString 電子公印;
    private RString 発行日;
    private RString 認証者役職名;
    private RString 認証者役職名1;
    private RString 認証者役職名2;
    private RString 認証者氏名公印に掛けない;
    private RString 認証者氏名公印に掛ける;
    private RString 公印省略;
    private RString 公印文字列;

    private RString 通知文1;
    private RString 通知文2;
    private RString フフォント大;
    private RString フォント混在_1;
    private RString フォント混在_2;
    private RString フォント混在2_1;
    private RString フォント混在2_2;

    private RString 郵便番号;
    private RString 行政区;
    private RString 住所TextField;
    private RString 住所優先順位1;
    private RString 住所優先順位2;
    private RString 住所優先順位3;
    private RString 方書TextField;
    private RString 方書優先順位1標準;
    private RString 方書優先順位2標準;
    private RString 方書優先順位1小;
    private RString 方書優先順位2小;
    private RString 代納人区分;
    private RString 氏名1TextField;
    private RString 氏名1優先順位1標準;
    private RString 氏名1優先順位2標準;
    private RString 氏名1優先順位1小;
    private RString 氏名1優先順位2小;
    private RString 氏名2TextField;
    private RString 氏名2優先順位1標準;
    private RString 氏名2優先順位2標準;
    private RString 氏名2優先順位1小;
    private RString 氏名2優先順位2小;
    private RString 氏名1敬称1;
    private RString 氏名1敬称2;
    private RString 氏名2敬称1;
    private RString 氏名2敬称2;
    private RString 左括弧1;
    private RString 左括弧2;
    private RString 右括弧1;
    private RString 右括弧2;
    private RString カスタマバーコード;
}
