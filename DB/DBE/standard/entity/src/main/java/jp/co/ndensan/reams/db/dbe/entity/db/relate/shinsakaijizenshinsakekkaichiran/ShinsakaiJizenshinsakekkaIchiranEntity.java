/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaijizenshinsakekkaichiran;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 事前審査結果一覧表の帳票のパラメータクラスです。
 *
 * @reamsid_L DBE-1640-040 zhaoyao
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShinsakaiJizenshinsakekkaIchiranEntity {

    private final RString 合議体番号;
    private final RString 介護認定審査会開催番号;
    private final RString 介護認定審査会開催予定年月日;
    private final RString 審査員1;
    private final RString 審査員2;
    private final RString 審査員3;
    private final RString 審査員4;
    private final RString 審査員5;
    private final RString no;
    private final RString 特定疾病;
    private final RString 被保険者番号;
    private final RString 前回介護度;
    private final RString メモ1;
    private final RString 判定1;
    private final RString 期間1;
    private final RString メモ2;
    private final RString 判定2;
    private final RString 期間2;
    private final RString メモ3;
    private final RString 判定3;
    private final RString 期間3;
    private final RString メモ4;
    private final RString 判定4;
    private final RString 期間4;
    private final RString メモ5;
    private final RString 判定5;
    private final RString 期間5;
    private final RString 一次判定;
    private final RString 二次判定;
    private final RString 区分;
    private final RString 有効期間;
    private final RString 有効期間開始年月日;
    private final RString 有効期間終了年月日;
    private final RString 一次判定の変更理由;
    private final RString 一致件数;
    private final RString 審査件数;

    /**
     * コンストラクタです。
     *
     * @param 合議体番号 合議体番号
     * @param 介護認定審査会開催番号 介護認定審査会開催番号
     * @param 介護認定審査会開催予定年月日 介護認定審査会開催予定年月日
     * @param 審査員1 審査員1
     * @param 審査員2 審査員2
     * @param 審査員3 審査員3
     * @param 審査員4 審査員4
     * @param 審査員5 審査員5
     * @param no no
     * @param 特定疾病 特定疾病
     * @param 被保険者番号 被保険者番号
     * @param 前回介護度 前回介護度
     * @param メモ1 メモ1
     * @param 判定1 判定1
     * @param 期間1 期間1
     * @param メモ2 メモ2
     * @param 判定2 判定2
     * @param 期間2 期間2
     * @param メモ3 メモ3
     * @param 判定3 判定3
     * @param 期間3 期間3
     * @param メモ4 メモ4
     * @param 判定4 判定4
     * @param 期間4 期間4
     * @param メモ5 メモ5
     * @param 判定5 判定5
     * @param 期間5 期間5
     * @param 一次判定 一次判定
     * @param 二次判定 二次判定
     * @param 区分 区分
     * @param 有効期間 有効期間
     * @param 有効期間開始年月日 有効期間開始年月日
     * @param 有効期間終了年月日 有効期間終了年月日
     * @param 一次判定の変更理由 一次判定の変更理由
     * @param 一致件数 一致件数
     * @param 審査件数 審査件数
     */
    public ShinsakaiJizenshinsakekkaIchiranEntity(
            RString 合議体番号,
            RString 介護認定審査会開催番号,
            RString 介護認定審査会開催予定年月日,
            RString 審査員1,
            RString 審査員2,
            RString 審査員3,
            RString 審査員4,
            RString 審査員5,
            RString no,
            RString 特定疾病,
            RString 被保険者番号,
            RString 前回介護度,
            RString メモ1,
            RString 判定1,
            RString 期間1,
            RString メモ2,
            RString 判定2,
            RString 期間2,
            RString メモ3,
            RString 判定3,
            RString 期間3,
            RString メモ4,
            RString 判定4,
            RString 期間4,
            RString メモ5,
            RString 判定5,
            RString 期間5,
            RString 一次判定,
            RString 二次判定,
            RString 区分,
            RString 有効期間,
            RString 有効期間開始年月日,
            RString 有効期間終了年月日,
            RString 一次判定の変更理由,
            RString 一致件数,
            RString 審査件数) {
        this.合議体番号 = 合議体番号;
        this.介護認定審査会開催番号 = 介護認定審査会開催番号;
        this.介護認定審査会開催予定年月日 = 介護認定審査会開催予定年月日;
        this.審査員1 = 審査員1;
        this.審査員2 = 審査員2;
        this.審査員3 = 審査員3;
        this.審査員4 = 審査員4;
        this.審査員5 = 審査員5;
        this.no = no;
        this.特定疾病 = 特定疾病;
        this.被保険者番号 = 被保険者番号;
        this.前回介護度 = 前回介護度;
        this.メモ1 = メモ1;
        this.判定1 = 判定1;
        this.期間1 = 期間1;
        this.メモ2 = メモ2;
        this.判定2 = 判定2;
        this.期間2 = 期間2;
        this.メモ3 = メモ3;
        this.判定3 = 判定3;
        this.期間3 = 期間3;
        this.メモ4 = メモ4;
        this.判定4 = 判定4;
        this.期間4 = 期間4;
        this.メモ5 = メモ5;
        this.判定5 = 判定5;
        this.期間5 = 期間5;
        this.一次判定 = 一次判定;
        this.二次判定 = 二次判定;
        this.区分 = 区分;
        this.有効期間 = 有効期間;
        this.有効期間開始年月日 = 有効期間開始年月日;
        this.有効期間終了年月日 = 有効期間終了年月日;
        this.一次判定の変更理由 = 一次判定の変更理由;
        this.一致件数 = 一致件数;
        this.審査件数 = 審査件数;
    }
}
