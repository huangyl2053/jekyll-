/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.hihokenshashohakkoichiranhyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 一覧表証発行者Entity
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IchiranyoShohakkoshaEntity {

    private RString 作成日付;
    private RString ページ数;
    private RString タイトル部分;
    private RString 保険者番号;
    private RString 保険者名;
    private RString ソート順１;
    private RString ソート順２;
    private RString ソート順３;
    private RString ソート順４;
    private RString ソート順５;
    private RString 改頁１;
    private RString 改頁２;
    private RString 改頁３;
    private RString 改頁４;
    private RString 改頁５;
    private RString 帳票連番;
    private RString 被保険者番号;
    private RString 氏名;
    private RString 生年月日_年齢;
    private RString 送付先住所;
    private RString 要介護_認定開始日_認定終了日;
    private RString 施設名;
    private RString 計画事業所名;
    private RString 交付事由_非交付理由タイトル;
    private RString 交付事由;
    private RString 非交付事由;
}
