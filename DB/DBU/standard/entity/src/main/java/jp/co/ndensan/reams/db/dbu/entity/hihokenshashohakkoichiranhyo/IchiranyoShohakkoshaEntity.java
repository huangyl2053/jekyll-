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

    RString 作成日付;
    RString ページ数;
    RString タイトル部分;
    RString 保険者番号;
    RString 保険者名;
    RString ソート順１;
    RString ソート順２;
    RString ソート順３;
    RString ソート順４;
    RString ソート順５;
    RString 改頁１;
    RString 改頁２;
    RString 改頁３;
    RString 改頁４;
    RString 改頁５;
    RString 帳票連番;
    RString 被保険者番号;
    RString 氏名;
    RString 生年月日_年齢;
    RString 送付先住所;
    RString 要介護_認定開始日_認定終了日;
    RString 施設名;
    RString 計画事業所名;
    RString 交付事由_非交付理由タイトル;
    RString 交付事由;
    RString 非交付事由;
}
