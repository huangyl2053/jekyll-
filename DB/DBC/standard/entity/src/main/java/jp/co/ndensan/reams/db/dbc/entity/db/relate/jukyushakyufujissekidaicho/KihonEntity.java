/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給者給付実績台帳の基本Entityクラスです。
 *
 * @reamsid_L DBC-3080-030 dongyabin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KihonEntity {

    private RString 入力識別番号;
    private RString 被保険者番号;
    private RString サービス提供年月;
    private RString 給付実績区分コード;
    private RString 事業所番号;
    private RString 通し番号;
    private RString 生年月日;
    private RString 性別コード;
    private RString 要介護度;
    private RString 認定有効期間;
    private RString 証記載保険者番号;
    private RString 老人保険市町村番号;
    private RString 老人保険受給者番号;
    private RString 旧措置入所者特例コード;
    private RString 警告区分コード;
    private RString 審査年月;
    private RString 保険者番号後期;
    private RString 被保険者番号後期;
    private RString 保険者番号国保;
    private RString 被保険者証番号国保;
    private RString 個人番号国保;
    private RString 整理番号;
    private RString 居住サービス計画作成区分コード;
    private RString 居住サービス計画作成区分名１;
    private RString 居住サービス計画作成区分名２;
    private RString 居住サービス計画事業者番号;
    private RString 居住サービス計画事業者名１;
    private RString 居住サービス計画事業者名２;
    private RString 入所院期間;
    private RString 入所院実日数;
    private RString 外泊日数;
    private RString 出力様式;
    private RString 出力様式１;
    private RString 出力様式２;
    private RString サービス事業者番号;
    private RString サービス事業者名;
    private RString 退所院の状態;
    private RString サービス期間;
    private RString 中止理由タイトル;
    private RString 中止理由コード;
    private RString 保険給付率;
    private RString 前サービス単位数;
    private RString 後サービス単位数;
    private RString 前保険請求額;
    private RString 後保険請求額;
    private RString 前利用者負担額;
    private RString 後利用者負担額;
    private RString 前緊急時施設療養費請求額;
    private RString 後緊急時施設療養費請求額;
    private RString 基本ヘッダー１;
    private RString 基本ヘッダー２;
    private RString 前特定診療費請求額;
    private RString 後特定診療費請求額;
    private RString 基本ヘッダー3;
    private RString 基本ヘッダー４;
    private RString 前特定入所者介護サービス等等請求額;
    private RString 後特定入所者介護サービス等等請求額;
    private RString 公費１負担者番号;
    private RString 公費１受給者番号;
    private RString 公費１給付率;
    private RString 前公費１サービス単位数;
    private RString 後公費１サービス単位数;
    private RString 前公費１保険請求額;
    private RString 後公費１保険請求額;
    private RString 前公費１利用者負担額;
    private RString 後公費１利用者負担額;
    private RString 前公費１緊急時施設療養費請求額;
    private RString 後公費１緊急時施設療養費請求額;
    private RString 前公費１特定診療費請求額;
    private RString 後公費１特定診療費請求額;
    private RString 前公費１特定入所者介護サービス費等請求額;
    private RString 後公費１特定入所者介護サービス費等請求額;
    private RString 公費２負担者番号;
    private RString 公費２受給者番号;
    private RString 公費２給付率;
    private RString 前公費２サービス単位数;
    private RString 後公費２サービス単位数;
    private RString 前公費２保険請求額;
    private RString 後公費２保険請求額;
    private RString 前公費２利用者負担額;
    private RString 後公費２利用者負担額;
    private RString 前公費２緊急時施設療養費請求額;
    private RString 後公費２緊急時施設療養費請求額;
    private RString 前公費２特定診療費請求額;
    private RString 後公費２特定診療費請求額;
    private RString 前公費２特定入所者介護サービス費等請求額;
    private RString 後公費２特定入所者介護サービス費等請求額;
    private RString 公費３負担者番号;
    private RString 公費３受給者番号;
    private RString 公費３給付率;
    private RString 前公費３サービス単位数;
    private RString 後公費３サービス単位数;
    private RString 前公費３保険請求額;
    private RString 後公費３保険請求額;
    private RString 前公費３利用者負担額;
    private RString 後公費３利用者負担額;
    private RString 前公費３緊急時施設療養費請求額;
    private RString 後公費３緊急時施設療養費請求額;
    private RString 前公費３特定診療費請求額;
    private RString 後公費３特定診療費請求額;
    private RString 前公費３特定入所者介護サービス費等請求額;
    private RString 後公費３特定入所者介護サービス費等請求額;
    private RString 被保険者氏名カナ;
    private RString 被保険者氏名;
    private RString 世帯コード;
    private RString 住所コード;
    private RString 住所;
    private RString 行政区コード;
    private RString 行政区;
    private RString 住民コード;
    private RString 高額受付年月日;
    private RString 高額決定年月日;
    private RString 高額公費１負担番号;
    private RString 高額公費２負担番号;
    private RString 高額公費３負担番号;
    private RString 高額利用者負担額;
    private RString 高額公費１負担額;
    private RString 高額公費２負担額;
    private RString 高額公費３負担額;
    private RString 高額支給額;
    private RString 高額公費１支給額;
    private RString 高額公費２支給額;
    private RString 高額公費３支給額;
}
