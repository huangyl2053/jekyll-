/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.ninteiChosaIkkatsu;

import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 認定調査スケジュール登録11のマッパーインタフェースです。
 */
public interface INinteiChosaIkkatsuInputMapper {

    /**
     * 認定調査スケジュール情報件数取得する
     *
     * @param 認定調査予定年月日
     * @param 調査地区コード
     * @param 認定調査委託先コード
     * @param 認定調査員コード
     * @param 市町村コード
     * @return DbT5221NinteichosaScheduleEntity
     */
    int getCount(FlexibleDate 認定調査予定年月日, Code 調査地区コード, RString 認定調査委託先コード,
            RString 認定調査員コード, LasdecCode 市町村コード);

    /**
     * 認定調査予定情報削除する
     *
     * @param 認定調査予定年月日
     * @param 調査地区コード
     * @param 認定調査委託先コード
     * @param 認定調査員コード
     * @param 市町村コード
     * @return DbT5221NinteichosaScheduleEntity
     */
    boolean getDelete(FlexibleDate 認定調査予定年月日, Code 調査地区コード, RString 認定調査委託先コード,
            RString 認定調査員コード, LasdecCode 市町村コード);

    /**
     * 認定調査スケジュール情報インサート処理
     *
     * @param 認定調査予定年月日
     * @param 認定調査予定開始時間
     * @param 認定調査予定終了時間
     * @param 認定調査時間枠
     * @param 調査地区コード
     * @param 認定調査委託先コード
     * @param 認定調査員コード
     * @param 市町村コード
     * @return DbT5221NinteichosaScheduleEntity
     */
    boolean getInsert(FlexibleDate 認定調査予定年月日, RString 認定調査予定開始時間, RString 認定調査予定終了時間,
            Code 認定調査時間枠, Code 調査地区コード, RString 認定調査委託先コード, RString 認定調査員コード, LasdecCode 市町村コード);

}
