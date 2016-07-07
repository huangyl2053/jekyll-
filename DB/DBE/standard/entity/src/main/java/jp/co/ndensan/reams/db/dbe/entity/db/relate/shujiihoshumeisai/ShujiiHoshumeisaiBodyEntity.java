/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiihoshumeisai;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 帳票設計_DBE622001_主治医意見書作成報酬支払明細書のBodyEntityです。
 *
 * @reamsid_L DBE-1980-044 xuyongchao
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShujiiHoshumeisaiBodyEntity {

    private final RString listIkenshosakuseiryo_1;
    private final RString listIkenshosakuseiryo_2;
    private final RString listIkenshosakuseiryo_3;
    private final RString listIkenshosakuseiryo_4;
    private final RString listIkenshosakuseiryo_5;
    private final RString listIkenshosakuseiryo_6;
    private final RString listIkenshosakuseiryo_7;
    private final RString listIkenshosakuseiryo_8;
    private final RString listIkenshosakuseiryo_9;
    private final RString listIkenshosakuseiryo_10;
    private final RString listGokeikensu_1;
    private final RString listGokeikensu_2;
    private final RString listGokeikensu_3;
    private final RString listGokeikensu_4;
    private final RString listGokeiKingaku_1;
    private final RString listGokeiKingaku_2;
    private final RString listGokeiKingaku_3;

    /**
     * コンストラクタです。
     *
     *
     * @param listIkenshosakuseiryo_1 明細番号
     * @param listIkenshosakuseiryo_2 被保険者番号
     * @param listIkenshosakuseiryo_3 被保険者氏名
     * @param listIkenshosakuseiryo_4 生年月日
     * @param listIkenshosakuseiryo_5 意見書提出日
     * @param listIkenshosakuseiryo_6 新規（在宅）
     * @param listIkenshosakuseiryo_7 新規（施設）
     * @param listIkenshosakuseiryo_8 継続（在宅）
     * @param listIkenshosakuseiryo_9 継続（施設）
     * @param listIkenshosakuseiryo_10 意見書作成料
     * @param listGokeikensu_1 新規（在宅）件数
     * @param listGokeikensu_2 新規（施設）件数
     * @param listGokeikensu_3 継続（在宅）件数
     * @param listGokeikensu_4 継続（施設）件数
     * @param listGokeiKingaku_1 合計金額
     * @param listGokeiKingaku_2 消費税
     * @param listGokeiKingaku_3 合計請求額
     */
    public ShujiiHoshumeisaiBodyEntity(
            RString listIkenshosakuseiryo_1,
            RString listIkenshosakuseiryo_2,
            RString listIkenshosakuseiryo_3,
            RString listIkenshosakuseiryo_4,
            RString listIkenshosakuseiryo_5,
            RString listIkenshosakuseiryo_6,
            RString listIkenshosakuseiryo_7,
            RString listIkenshosakuseiryo_8,
            RString listIkenshosakuseiryo_9,
            RString listIkenshosakuseiryo_10,
            RString listGokeikensu_1,
            RString listGokeikensu_2,
            RString listGokeikensu_3,
            RString listGokeikensu_4,
            RString listGokeiKingaku_1,
            RString listGokeiKingaku_2,
            RString listGokeiKingaku_3) {
        this.listIkenshosakuseiryo_1 = listIkenshosakuseiryo_1;
        this.listIkenshosakuseiryo_2 = listIkenshosakuseiryo_2;
        this.listIkenshosakuseiryo_3 = listIkenshosakuseiryo_3;
        this.listIkenshosakuseiryo_4 = listIkenshosakuseiryo_4;
        this.listIkenshosakuseiryo_5 = listIkenshosakuseiryo_5;
        this.listIkenshosakuseiryo_6 = listIkenshosakuseiryo_6;
        this.listIkenshosakuseiryo_7 = listIkenshosakuseiryo_7;
        this.listIkenshosakuseiryo_8 = listIkenshosakuseiryo_8;
        this.listIkenshosakuseiryo_9 = listIkenshosakuseiryo_9;
        this.listIkenshosakuseiryo_10 = listIkenshosakuseiryo_10;
        this.listGokeikensu_1 = listGokeikensu_1;
        this.listGokeikensu_2 = listGokeikensu_2;
        this.listGokeikensu_3 = listGokeikensu_3;
        this.listGokeikensu_4 = listGokeikensu_4;
        this.listGokeiKingaku_1 = listGokeiKingaku_1;
        this.listGokeiKingaku_2 = listGokeiKingaku_2;
        this.listGokeiKingaku_3 = listGokeiKingaku_3;
    }
}
