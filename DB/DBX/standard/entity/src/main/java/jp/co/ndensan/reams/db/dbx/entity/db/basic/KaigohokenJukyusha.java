/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;
import jp.co.ndensan.reams.uz.uza.util.db.OnRshareSchema;

/**
 * 介護保険受給者の定義です
 *
 * @author N2806 太田 智之
 * @jpName 介護保険受給者
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護保険受給者
 * @mainClass
 * @reference
 */
@OnRshareSchema
public enum KaigohokenJukyusha implements IColumnDefinition {
    // TODO N2806太田智之 公開用view構造が決まった段階で見直しが必要

    /**
     * 識別コード
     */
    識別コード(13, 0),
    /**
     * 有効開始年月日
     */
    有効開始年月日(8, 0),
    /**
     * 有効終了年月日
     */
    有効終了年月日(8, 0),
    /**
     * 介護被保険者番号
     */
    介護被保険者番号(8, 0),
    /**
     * 申請番号
     */
    申請番号(8, 0),
    /**
     * 申請有効区分
     */
    申請有効区分(8, 0),
    /**
     * 申請年月日
     */
    申請年月日(8, 0),
    /**
     * 申請時申請区分
     */
    申請時申請区分(8, 0),
    /**
     * 法令申請区分
     */
    法令申請区分(8, 0),
    /**
     * 認定申請理由
     */
    認定申請理由(8, 0),
    /**
     * 地方自治体コード
     */
    地方自治体コード(6, 0),
    /**
     * 取下げ区分
     */
    取下げ区分(8, 0),
    /**
     * 依頼年月日
     */
    依頼年月日(8, 0),
    /**
     * 実施年月日
     */
    実施年月日(8, 0),
    /**
     * 完了年月日
     */
    完了年月日(8, 0),
    /**
     * 事業者名称
     */
    事業者名称(8, 0),
    /**
     * 調査委託先コード
     */
    調査委託先コード(8, 0),
    /**
     * 認定調査員コード
     */
    認定調査員コード(8, 0),
    /**
     * 認定調査員氏名
     */
    認定調査員氏名(8, 0),
    /**
     * 作成依頼年月日
     */
    作成依頼年月日(8, 0),
    /**
     * 受領年月日
     */
    受領年月日(8, 0),
    /**
     * 障害高齢者生活自立度
     */
    障害高齢者生活自立度(8, 0),
    /**
     * 認知症高齢者生活自立度
     */
    認知症高齢者生活自立度(8, 0),
    /**
     * 主治医氏名
     */
    主治医氏名(8, 0),
    /**
     * 主治医医師識別コード
     */
    主治医医師識別コード(8, 0),
    /**
     * 医療機関名称
     */
    医療機関名称(8, 0),
    /**
     * 医療機関コード
     */
    医療機関コード(8, 0),
    /**
     * 一時判定_要介護状態区分
     */
    一時判定_要介護状態区分(8, 0),
    /**
     * 判定年月日
     */
    判定年月日(8, 0),
    /**
     * 認知症加算_要介護状態区分
     */
    認知症加算_要介護状態区分(8, 0),
    /**
     * 資料作成年月日
     */
    資料作成年月日(8, 0),
    /**
     * 回答年月日
     */
    回答年月日(8, 0),
    /**
     * 開催予定年月日
     */
    開催予定年月日(8, 0),
    /**
     * 合議体番号
     */
    合議体番号(8, 0),
    /**
     * 認定年月日
     */
    認定年月日(8, 0),
    /**
     * 要介護状態区分
     */
    要介護状態区分(8, 0),
    /**
     * 審査会意見
     */
    審査会意見(8, 0),
    /**
     * 異動年月日
     */
    異動年月日(8, 0),
    /**
     * 特定疾病
     */
    特定疾病(8, 0),
    /**
     * 喪失年月日
     */
    喪失年月日(8, 0);
    private final int maxLength;
    private final int scale;

    private KaigohokenJukyusha(int maxLength, int scale) {
        this.maxLength = maxLength;
        this.scale = scale;
    }

    /**
     * 列の最大長を返します
     *
     * @return 最大値
     */
    public int getMaxLength() {
        return maxLength;
    }

    /**
     * 小数点以下桁数を返します
     *
     * @return 桁数
     */
    public int getScale() {
        return scale;
    }
}
