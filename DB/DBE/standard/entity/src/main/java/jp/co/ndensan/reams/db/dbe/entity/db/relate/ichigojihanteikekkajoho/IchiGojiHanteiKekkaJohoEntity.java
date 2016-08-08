/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ichigojihanteikekkajoho;

import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 一五次判定結果情報Entityクラスです。
 *
 * @reamsid_L DBE-3000-290 chenxiangyu
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IchiGojiHanteiKekkaJohoEntity {

    private Code 厚労省IF識別コード;
    private FlexibleDate 判定年月日;
    private Code 判定結果コード;
    private Code 認知症加算後の一五次判定結果コード;
    private int 基準時間;
    private int 基準時間_食事;
    private int 基準時間_排泄;
    private int 基準時間_移動;
    private int 基準時間_清潔保持;
    private int 基準時間_間接ケア;
    private int 基準時間_BPSD関連;
    private int 基準時間_機能訓練;
    private int 基準時間_医療関連;
    private int 基準時間_認知症加算;
    private int 中間評価項目得点第一群;
    private int 中間評価項目得点第二群;
    private int 中間評価項目得点第三群;
    private int 中間評価項目得点第四群;
    private int 中間評価項目得点第五群;
    private Decimal 認知症自立度Ⅱ_蓋然性;
    private Code 安定性コード;
    private Code 給付区分コード;
    private Code 判定警告コード;
    private int 認定調査結果_件数;
    private int 主治医意見書_件数;
    private RString 基本調査項目;
    private RString 主治医意見書項目;
    private RString 認定調査_障害自立度コード;
    private RString 認定調査_認知症自立度コード;
    private RString 主治医意見書_認知症自立度;
}
