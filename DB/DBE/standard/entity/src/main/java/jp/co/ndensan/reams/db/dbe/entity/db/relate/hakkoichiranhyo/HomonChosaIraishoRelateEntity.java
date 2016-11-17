/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.hakkoichiranhyo;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5201NinteichosaIraiJohoEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 訪問調査依頼書発行のRelateEntityクラスです。
 *
 * @reamsid_L DBE-0080-140 duanzhanli
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class HomonChosaIraishoRelateEntity {

    private RString 申請書管理番号;
    private RString 被保険者番号;
    private RString 被保険者氏名カナ;
    private RString 被保険者氏名;
    private RString 住所;
    private RString 生年月日;
    private RString 性別;
    private RString 郵便番号;
    private RString 電話番号;
    private RString 認定申請年月日;
    private RString 認定申請区分_申請時_コード;
    private RString 証記載保険者番号;
    private RString 年齢;
    private RString 訪問調査先住所;
    private RString 訪問調査先電話番号;
    private RString 訪問調査先名称;
    private RString 訪問調査先郵便番号;
    private RString 前回認定年月日;
    private RString 前回要介護状態区分コード;
    private RString 代表者名;
    private RString 調査委託先住所;
    private RString 事業者名称;
    private RString 調査委託先住所_郵便番号;
    private RString 事業者番号;
    private RString 調査員氏名;
    private FlexibleDate 認定調査依頼年月日;
    private int 最大依頼履歴番号;
    private RString 認定調査期限年月日;
    private RString 認定調査員コード;
    private RString 認定調査委託先コード;
    private RString 前回認知症高齢者自立度;
    private RString 前回障害高齢者自立度;
    private RString 要介護認定一次判定結果コード;
    private RString 二次判定要介護状態区分コード;
    private RString 二次判定年月日;
    private RString 前回連番;
    private RString 前回連番に対する調査項目;
    private RString 連絡先郵便番号;
    private RString 連絡先電話番号;
    private RString 連絡先携帯番号;
    private RString 連絡先氏名;
    private RString 連絡先続柄;
    private RString 連絡先住所;
    private RString 厚労省IF識別コード;
    private RString 今回一次判定結果コード;
    private RString 介護認定審査会開催年月日;
    private RString 合議体番号;
    private RString 今回障害高齢者自立度;
    private RString 今回認知症高齢者自立度;
    private RString 今回連番;
    private RString 今回連番に対する調査項目;
    private RString 直近区分;
    private DbT5201NinteichosaIraiJohoEntity dbt5201Entity;
}
