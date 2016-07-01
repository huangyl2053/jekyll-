/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.iinyobihanteikinyuhyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 委員用予備判定記入表のITEMです。
 *
 * @reamsid_L DBE-0150-150 wangrenze
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IinYobihanteiKinyuhyoItem {

    private final RString 作成年月日;
    private final RString 審査会開催番号;
    private final RString no;
    private final RString 申請区分;
    private final RString 被保険者区分;
    private final RString 性別;
    private final RString 年齢;
    private final RString 前回二次判定;
    private final RString 前回認定有効期間;
    private final RString 一次判定;
    private final RString 二次判定;
    private final RString 状態像;
    private final RString 認定有効期間;
    private final RString 特定疾病コード;
    private final RString 特定疾病名称;
    private final RString 調査員特記事項;
    private final RString 主治医意見書;

    /**
     * インスタンスを生成します。
     *
     * @param 作成年月日 作成年月日
     * @param 審査会開催番号 審査会開催番号
     * @param no no
     * @param 申請区分 申請区分
     * @param 被保険者区分 被保険者区分
     * @param 性別 性別
     * @param 年齢 年齢
     * @param 前回二次判定 前回二次判定
     * @param 前回認定有効期間 前回認定有効期間
     * @param 一次判定 一次判定
     * @param 二次判定 二次判定
     * @param 状態像 状態像
     * @param 認定有効期間 認定有効期間
     * @param 特定疾病コード 特定疾病コード
     * @param 特定疾病名称 特定疾病名称
     * @param 調査員特記事項 調査員特記事項
     * @param 主治医意見書 主治医意見書
     */
    public IinYobihanteiKinyuhyoItem(RString 作成年月日,
            RString 審査会開催番号, RString no, RString 申請区分, RString 被保険者区分,
            RString 性別, RString 年齢, RString 前回二次判定,
            RString 前回認定有効期間, RString 一次判定, RString 二次判定, RString 状態像,
            RString 認定有効期間, RString 特定疾病コード, RString 特定疾病名称, RString 調査員特記事項,
            RString 主治医意見書) {
        this.作成年月日 = 作成年月日;
        this.審査会開催番号 = 審査会開催番号;
        this.no = no;
        this.申請区分 = 申請区分;
        this.被保険者区分 = 被保険者区分;
        this.性別 = 性別;
        this.年齢 = 年齢;
        this.前回二次判定 = 前回二次判定;
        this.前回認定有効期間 = 前回認定有効期間;
        this.一次判定 = 一次判定;
        this.二次判定 = 二次判定;
        this.状態像 = 状態像;
        this.認定有効期間 = 認定有効期間;
        this.特定疾病コード = 特定疾病コード;
        this.特定疾病名称 = 特定疾病名称;
        this.調査員特記事項 = 調査員特記事項;
        this.主治医意見書 = 主治医意見書;

    }
}
